package in.kyle.api.conditions.types;

import in.kyle.api.conditions.Predicate;
import in.kyle.api.conditions.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class BooleanPredicate extends Predicate<Boolean> {
    
    public BooleanPredicate(Boolean compare) {
        super(compare);
    }
    
    public Result isTrue() {
        return result(compare, "Value is false, expected true");
    }
    
    public Result isFalse() {
        return result(!compare, "Value is true, expected false");
    }
}
