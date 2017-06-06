package in.kyle.api.verify.types;

import java.lang.reflect.Method;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 6/6/2017.
 */
public class ThrowablePredicate extends Predicate<Throwable> {
    
    public ThrowablePredicate(Throwable compare) {
        super(compare);
    }
    
    public void containsStackElement(Class<?> clazz) {
        process(calculateContainsClass(clazz), "Stack does not contain {}", clazz.getName());
    }
    
    private boolean calculateContainsClass(Class<?> clazz) {
        for (StackTraceElement element : compare.getStackTrace()) {
            if (element.getClassName().equals(clazz.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public void containsMethod(Method method) {
        process(calculateContainsMethod(method), "Stack does not contain method {}", method);
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
