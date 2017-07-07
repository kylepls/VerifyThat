package in.kyle.api.verify.types;

import java.util.Collection;

import in.kyle.api.verify.Verify;
import in.kyle.api.verify.types.iterable.IterablePredicate;

public class CollectionPredicate<T> extends IterablePredicate<T, Collection<T>, CollectionPredicate<T>> {
    
    public CollectionPredicate(Collection<T> compare) {
        super(compare);
    }
    
    public ArrayPredicate<T> toArrayPredicate() {
        Object[] objects = compare.toArray();
        T[] array = (T[]) objects;
        return Verify.that(array);
    }
}
