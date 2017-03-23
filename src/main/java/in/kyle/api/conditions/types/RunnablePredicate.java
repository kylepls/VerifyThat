package in.kyle.api.conditions.types;

import in.kyle.api.conditions.Lamda;
import in.kyle.api.conditions.Predicate;
import in.kyle.api.conditions.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class RunnablePredicate extends Predicate<Lamda.ThrowableRunnable> {
    
    public RunnablePredicate(Lamda.ThrowableRunnable compare) {
        super(compare);
    }
    
    public Result throwsException(Class<? extends Throwable> expected) {
        try {
            compare.run();
            return result(false, "Did not catch exception {}", expected.getName());
        } catch (Throwable throwable) {
            if (throwable.getClass().equals(expected)) {
                return result(true, "");
            } else {
                throwable.printStackTrace();
                return result(false, "Caught unknown exception {}", throwable.getClass().getName());
            }
        }
    }
    
    public Result doesNotThrowException() {
        try {
            compare.run();
            return result(true, "");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return result(false, "Caught exception {}", throwable.getClass().getName());
        }
    }
}
