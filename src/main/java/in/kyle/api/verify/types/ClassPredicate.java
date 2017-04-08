package in.kyle.api.verify.types;

import in.kyle.api.verify.NonNullPredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class ClassPredicate extends NonNullPredicate<Class> {
    
    public ClassPredicate(Class compare) {
        super(compare);
    }
    
    public void isEnum() {
        process(compare.isEnum(), "Class is not enum, expected enum");
    }
    
    public void isNotEnum() {
        process(!compare.isEnum(), "Class enum, expected other");
    }
    
    public void isAssignableTo(Class<?> clazz) {
        process(clazz.isAssignableFrom(compare),
                "Class is not assignable to {}, {}, expected to be assignable",
                clazz.getName(),
                compare.getName());
    }
    
    public void isNotAssignableTo(Class<?> clazz) {
        process(!clazz.isAssignableFrom(compare),
                "Class is assignable to {}, {}, expected to not be assignable",
                clazz.getName(),
                compare.getName());
    }
}
