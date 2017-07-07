package in.kyle.api.verify.types.reflect.query;

import java.lang.reflect.Field;

import in.kyle.api.verify.types.reflect.ReflectModifier;

public class FieldQueryBuilder extends ElementQueryBuilder<Field, FieldQueryBuilder> {
    
    private final ClassQueryBuilder caller;
    
    FieldQueryBuilder(Class<?> compare, String named, ClassQueryBuilder caller) {
        super(compare, named);
        this.caller = caller;
        elements.addAll(ReflectHelper.getFields(compare));
    }
    
    public FieldQueryBuilder isTransient() {
        removeElements(field -> ReflectModifier.TRANSIENT.isPresent(field.getModifiers()),
                       "transient",
                       false);
        return this;
    }
    
    public FieldQueryBuilder isVolatile() {
        removeElements(field -> ReflectModifier.VOLATILE.isPresent(field.getModifiers()),
                       "volatile",
                       false);
        return this;
    }
    
    @Override
    int getModifiers(Field field) {
        return field.getModifiers();
    }
    
    @Override
    String getName(Field field) {
        return field.getName();
    }
    
    @Override
    Class<?> getType(Field field) {
        return field.getType();
    }
    
    @Override
    String getErrorName() {
        return "field in class " + compare;
    }
}
