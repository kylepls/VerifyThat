package in.kyle.api.verify.types;

import in.kyle.api.verify.Lamda;
import in.kyle.api.verify.NonNullPredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class RunnablePredicate extends NonNullPredicate<Lamda.ThrowableRunnable> {
    
    public RunnablePredicate(Lamda.ThrowableRunnable compare) {
        super(compare);
    }
    
    public void throwsException(Class<? extends Throwable> expected) {
        try {
            compare.run();
            process(false, "Did not catch exception {}", expected.getName());
        } catch (Throwable throwable) {
            if (throwable.getClass().equals(expected)) {
                process(true, "");
            } else {
                throwable.printStackTrace();
                process(false, "Caught unknown exception {}", throwable.getClass().getName());
            }
        }
    }
    
    public void doesNotThrowException() {
        try {
            compare.run();
            process(true, "");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            process(false, "Caught exception {}", throwable.getClass().getName());
        }
    }
}
