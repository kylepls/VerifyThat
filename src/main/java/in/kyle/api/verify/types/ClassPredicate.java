package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class ClassPredicate extends Predicate<Class> {
    
    public ClassPredicate(Class compare) {
        super(compare);
    }
    
    public void isEnum() {
        isNotNull();
        process(compare.isEnum(), "Class is not enum, expected enum");
    }
    
    public void isNotEnum() {
        isNotNull();
        process(!compare.isEnum(), "Class enum, expected other");
    }
    
    public void isAssignableTo(Class<?> clazz) {
        isNotNull();
        process(clazz.isAssignableFrom(compare),
                "Class is not assignable to {}, {}, expected to be assignable",
                clazz.getName(),
                compare.getName());
    }
    
    public void isNotAssignableTo(Class<?> clazz) {
        isNotNull();
        process(!clazz.isAssignableFrom(compare),
                "Class is assignable to {}, {}, expected to not be assignable",
                clazz.getName(),
                compare.getName());
    }
}
