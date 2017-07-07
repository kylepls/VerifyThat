package in.kyle.api.verify.types.reflect.query;

import java.lang.reflect.Method;

import in.kyle.api.verify.types.reflect.ReflectModifier;

public class MethodQueryBuilder extends ElementQueryBuilder<Method, MethodQueryBuilder> {
    
    private final ClassQueryBuilder caller;
    
    MethodQueryBuilder(Class<?> compare, String named, ClassQueryBuilder caller) {
        super(compare, named);
        this.caller = caller;
        elements.addAll(ReflectHelper.getMethods(compare));
    }
    
    public MethodQueryBuilder isBridge() {
        removeElements(Method::isBridge, "bridge", false);
        return this;
    }
    
    public MethodQueryBuilder isDefault() {
        removeElements(Method::isDefault, "default", false);
        return this;
    }
    
    public MethodQueryBuilder isSynthetic() {
        removeElements(Method::isSynthetic, "synthetic", false);
        return this;
    }
    
    public MethodQueryBuilder isVarArgs() {
        removeElements(Method::isVarArgs, "varargs", false);
        return this;
    }
    
    public MethodQueryBuilder isAbstract() {
        removeElements(method -> ReflectModifier.ABSTRACT.isPresent(method.getModifiers()),
                       "abstract",
                       false);
        return this;
    }
    
    public MethodQueryBuilder isNative() {
        removeElements(method -> ReflectModifier.NATIVE.isPresent(method.getModifiers()),
                       "native",
                       false);
        return this;
    }
    
    public MethodQueryBuilder returnTypeIs(Class<?> clazz) {
        removeElements(method -> method.getReturnType().equals(clazz),
                       "returnTypeIs=" + clazz.getName(),
                       false);
        return this;
    }
    
    @Override
    int getModifiers(Method method) {
        return method.getModifiers();
    }
    
    @Override
    String getName(Method method) {
        return method.getName();
    }
    
    @Override
    Class<?> getType(Method method) {
        return method.getReturnType();
    }
    
    @Override
    String getErrorName() {
        return "method in " + compare;
    }
}
