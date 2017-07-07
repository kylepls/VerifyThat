package in.kyle.api.verify.types.reflect.query;

import in.kyle.api.verify.Verify;
import in.kyle.api.verify.types.reflect.ReflectModifier;

public class ClassQueryBuilder extends ElementQueryBuilder<Class<?>, ClassQueryBuilder> {
    
    public ClassQueryBuilder(Class<?> compare, String named) {
        super(compare, named);
        elements.add(compare);
    }
    
    public ClassQueryBuilder isStatic() {
        Verify.that(compare).is(ReflectModifier.STATIC);
        return this;
    }
    
    public ClassQueryBuilder isFinal() {
        Verify.that(compare).is(ReflectModifier.FINAL);
        return this;
    }
    
    public ClassQueryBuilder isInterface() {
        Verify.that(compare).is(ReflectModifier.INTERFACE);
        return this;
    }
    
    public ClassQueryBuilder isAbstract() {
        Verify.that(compare).is(ReflectModifier.ABSTRACT);
        return this;
    }
    
    public ClassQueryBuilder isSynthetic() {
        Verify.that(compare).is(ReflectModifier.SYNTHETIC);
        return this;
    }
    
    public ClassQueryBuilder isAnnotation() {
        Verify.that(compare).is(ReflectModifier.ANNOTATION);
        return this;
    }
    
    public ClassQueryBuilder isEnum() {
        Verify.that(compare).is(ReflectModifier.ENUM);
        return this;
    }
    
    public MethodQueryBuilder hasMethod() {
        return new MethodQueryBuilder(compare, named, this);
    }
    
    public FieldQueryBuilder hasField() {
        return new FieldQueryBuilder(compare, named, this);
    }
    
    @Override
    int getModifiers(Class<?> aClass) {
        return aClass.getModifiers();
    }
    
    @Override
    String getName(Class<?> aClass) {
        return aClass.getSimpleName();
    }
    
    @Override
    Class<?> getType(Class<?> aClass) {
        return aClass;
    }
    
    @Override
    String getErrorName() {
        return compare.toString();
    }
}
