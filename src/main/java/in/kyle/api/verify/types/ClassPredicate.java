package in.kyle.api.verify.types;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class ClassPredicate extends Predicate<Class> {
    
    public ClassPredicate(Class<?> compare) {
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
    
    public void isFinal() {
        process(Modifier.isFinal(compare.getModifiers()), "Class {} must be final", compare);
    }
    
    // Thank you https://stackoverflow.com/a/10872497/2821370
    public void isUtilityClass() {
        isFinal();
        
        process(compare.getDeclaredConstructors().length == 1,
                "Only 1 constructor allowed for utility class");
        
        if (!compare.isEnum()) {
            Constructor<?> constructor = getConstructor();
            process(Modifier.isPrivate(constructor.getModifiers()),
                    "Constructor for {} is not private",
                    compare);
            
            createInstance();
        }
        
        testMethodNonStatic();
    }
    
    private void testMethodNonStatic() {
        for (Method method : compare.getMethods()) {
            if (method.getDeclaringClass().equals(compare)) {
                process(Modifier.isStatic(method.getModifiers()),
                        "Method {} is not static in {}",
                        method.getName(),
                        compare);
            }
        }
    }
    
    protected void createInstance() {
        try {
            Constructor<?> constructor = getConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
            constructor.setAccessible(false);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Constructor<?> getConstructor() {
        try {
            return compare.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
