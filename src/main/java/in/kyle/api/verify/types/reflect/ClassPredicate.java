package in.kyle.api.verify.types.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.types.reflect.query.ClassQueryBuilder;

public class ClassPredicate extends Predicate<Class<?>, ClassPredicate> {
    
    public ClassPredicate(Class compare) {
        super(compare);
    }
    
    public ClassQueryBuilder matcher() {
        return new ClassQueryBuilder(compare, named);
    }
    
    public ClassPredicate isEnum() {
        isNotNull();
        process(compare.isEnum(), compare + " isEnum", false);
        return this;
    }
    
    public ClassPredicate isNotEnum() {
        isNotNull();
        process(!compare.isEnum(), compare + " isNotEnum", false);
        return this;
    }
    
    public ClassPredicate isAssignableTo(Class<?> clazz) {
        isNotNull();
        process(clazz.isAssignableFrom(compare), clazz + " isAssignableTo " + compare, false);
        return this;
    }
    
    public ClassPredicate isNotAssignableTo(Class<?> clazz) {
        isNotNull();
        process(!clazz.isAssignableFrom(compare), clazz + " isNotAssignableTo " + compare, false);
        return this;
    }
    
    public ClassPredicate is(ReflectModifier... modifiers) {
        for (ReflectModifier modifier : modifiers) {
            process((compare.getModifiers() & modifier.getValue()) != 0,
                    compare + " is " + modifier.name(),
                    ReflectModifier.getAll(compare.getModifiers()));
        }
        return this;
    }
    
    // Thank you https://stackoverflow.com/a/10872497/2821370
    public ClassPredicate isUtilityClass() {
        is(ReflectModifier.FINAL);
        
        process(compare.getDeclaredConstructors().length == 1,
                "1 constructor",
                compare.getDeclaredConstructors().length + " constructors");
        
        if (!compare.isEnum()) {
            Constructor<?> constructor = getConstructor();
            process(Modifier.isPrivate(constructor.getModifiers()),
                    "Private constructor",
                    getAccess(constructor));
            
            createInstance();
        }
        
        testMethodNonStatic();
        return this;
    }
    
    private void testMethodNonStatic() {
        for (Method method : compare.getMethods()) {
            if (method.getDeclaringClass().equals(compare)) {
                process(Modifier.isStatic(method.getModifiers()), method + " isStatic", false);
            }
        }
    }
    
    void createInstance() {
        try {
            Constructor<?> constructor = getConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
            constructor.setAccessible(false);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    
    Constructor<?> getConstructor() {
        try {
            return compare.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    
    static String getAccess(Constructor<?> element) {
        int mod = element.getModifiers();
        if (ReflectModifier.PUBLIC.isPresent(mod)) {
            return "public";
        } else if (ReflectModifier.PRIVATE.isPresent(mod)) {
            return "private";
        } else if (ReflectModifier.PROTECTED.isPresent(mod)) {
            return "protected";
        } else {
            return "package";
        }
    }
}
