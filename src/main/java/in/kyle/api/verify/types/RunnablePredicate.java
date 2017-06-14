package in.kyle.api.verify.types;

import java.io.PrintWriter;
import java.io.StringWriter;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 3/23/2017.
 */
public class RunnablePredicate extends Predicate<Verify.ThrowableRunnable> {
    
    public RunnablePredicate(Verify.ThrowableRunnable compare) {
        super(compare);
    }
    
    public ThrowablePredicate throwsException(Class<? extends Throwable> expected) {
        isNotNull();
        try {
            compare.run();
        } catch (Throwable throwable) {
            if (!throwable.getClass().equals(expected)) {
                StringWriter writer = new StringWriter();
                PrintWriter printWriter = new PrintWriter(writer);
                throwable.printStackTrace(printWriter);
                throw error("Caught unknown exception\n{}", writer.getBuffer().toString());
            } else {
                return Verify.that(throwable);
            }
        }
        throw error("Did not catch exception {}", expected.getName());
    }
    
    public void doesNotThrowException() {
        isNotNull();
        try {
            compare.run();
        } catch (Throwable throwable) {
            throw error("Caught exception {}", throwable.getClass().getName());
        }
    }
}
