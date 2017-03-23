package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class ClassPredicate extends Predicate<Class> {
    
    public ClassPredicate(Class compare) {
        super(compare);
    }
    
    public Result isEnum() {
        return result(compare.isEnum(), "Class is not enum, expected enum");
    }
    
    public Result isNotEnum() {
        return result(!compare.isEnum(), "Class enum, expected other");
    }
    
    public Result isAssignableTo(Class<?> clazz) {
        return result(clazz.isAssignableFrom(compare),
                      "Class is not assignable to {}, {}, expected to be assignable",
                      clazz.getName(),
                      compare.getName());
    }
    
    public Result isNotAssignableTo(Class<?> clazz) {
        return result(!clazz.isAssignableFrom(compare),
                      "Class is assignable to {}, {}, expected to not be assignable",
                      clazz.getName(),
                      compare.getName());
    }
}
