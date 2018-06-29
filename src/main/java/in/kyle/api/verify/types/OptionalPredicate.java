package in.kyle.api.verify.types;

import java.util.Optional;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

public class OptionalPredicate<T> extends Predicate<Optional<T>, OptionalPredicate<T>>{
    
    public OptionalPredicate(Optional<T> compare) {
        super(compare);
    }
    
    public OptionalPredicate<T> isPresent() {
        isNotNull();
        process(compare.isPresent(), "isPresent=true");
        return this;
    }
    
    public OptionalPredicate<T> isNotPresent() {
        isNotNull();
        process(!compare.isPresent(), "isPresent=false");
        return this;
    }
    
    public ObjectPredicate get() {
        isPresent();
        return Verify.that(compare.get());
    }
}
