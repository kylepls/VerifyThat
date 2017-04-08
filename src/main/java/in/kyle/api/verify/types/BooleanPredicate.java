package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class BooleanPredicate extends Predicate<Boolean> {
    
    public BooleanPredicate(Boolean compare) {
        super(compare);
    }
    
    public void isTrue() {
        process(compare, "Value is false, expected true");
    }
    
    public void isFalse() {
        process(!compare, "Value is true, expected false");
    }
}
