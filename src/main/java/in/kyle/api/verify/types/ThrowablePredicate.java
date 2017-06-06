package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 6/6/2017.
 */
public class ThrowablePredicate<T extends Throwable> extends Predicate<T> {
    
    public ThrowablePredicate(T compare) {
        super(compare);
    }
    
    public void containsStackElement(Class<?> clazz) {
        for (StackTraceElement stackTraceElement : compare.getStackTrace()) {
            if (stackTraceElement.getClassName().equals(clazz.getName())) {
                return;
            }
        }
        compare.printStackTrace();
        process(false, "Stack does not contain {}", clazz.getName());
    }
    
    public ArrayPredicate<StackTraceElement> toStackPredicate() {
        return Verify.that(compare.getStackTrace());
    }
}
