package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;

public class BooleanPredicate extends Predicate<Boolean, BooleanPredicate> {
    
    public BooleanPredicate(Boolean compare) {
        super(compare);
    }
    
    public BooleanPredicate isTrue() {
        process(compare, "true");
        return this;
    }
    
    public BooleanPredicate isFalse() {
        process(!compare, "false");
        return this;
    }
}
