package in.kyle.api.verify.types;

import java.lang.reflect.Method;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

public class ThrowablePredicate extends Predicate<Throwable, ThrowablePredicate> {
    
    public ThrowablePredicate(Throwable compare) {
        super(compare);
    }
    
    public ThrowablePredicate containsStackElement(Class<?> clazz) {
        process(calculateContainsClass(clazz), "contains " + clazz.getName());
        return this;
    }
    
    private boolean calculateContainsClass(Class<?> clazz) {
        for (StackTraceElement element : compare.getStackTrace()) {
            if (element.getClassName().equals(clazz.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public ThrowablePredicate containsMethod(Method method) {
        process(calculateContainsMethod(method), "contains method " + method);
        return this;
    }
    
    public ThrowablePredicate messageIs(String message) {
        Verify.that(compare.getMessage()).isEqual(message);
        return this;
    }
    
    public ThrowablePredicate causeIs(Class<? extends Throwable> throwableClass) {
        Verify.that(compare.getCause()).isExactType(throwableClass);
        return this;
    }
    
    private boolean calculateContainsMethod(Method method) {
        for (StackTraceElement element : compare.getStackTrace()) {
            if (element.getMethodName().equals(method.getName())) {
                if (element.getClassName().equals(method.getDeclaringClass().getName())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayPredicate<StackTraceElement> toStackPredicate() {
        return Verify.that(compare.getStackTrace());
    }
}
