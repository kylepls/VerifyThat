package in.kyle.api.verify.types.reflect.query;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class ReflectHelper {
    
    private ReflectHelper() {
    }
    
    static Collection<Field> getFields(Class<?> clazz) {
        Set<Field> fields = new HashSet<>();
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        
        if (!clazz.equals(Object.class)) {
            fields.addAll(getFields(clazz.getSuperclass()));
        }
        
        return fields;
    }
    
    static Collection<Method> getMethods(Class<?> clazz) {
        if (clazz == null) {
            return Collections.emptySet();
        } else {
            Set<Method> methods = new HashSet<>();
            methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
            
            if (!clazz.equals(Object.class)) {
                methods.addAll(getMethods(clazz.getSuperclass()));
            }
            return methods;
        }
    }
}
