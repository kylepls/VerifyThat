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
    
    public void throwsException(Class<? extends Throwable> expected) {
        isNotNull();
        boolean ran = false;
        try {
            compare.run();
            ran = true;
        } catch (Throwable throwable) {
            if (!throwable.getClass().equals(expected)) {
                StringWriter writer = new StringWriter();
                PrintWriter printWriter = new PrintWriter(writer);
                throwable.printStackTrace(printWriter);
                
                process(false, "Caught unknown exception\n{}", writer.getBuffer().toString());
            }
        }
        if (ran) {
            process(false, "Did not catch exception {}", expected.getName());
        }
    }
    
    public void doesNotThrowException() {
        isNotNull();
        try {
            compare.run();
            process(true, "");
        } catch (Throwable throwable) {
            process(false, "Caught exception {}", throwable.getClass().getName());
        }
    }
}
