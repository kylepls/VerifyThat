package in.kyle.api.verify;

import org.junit.Test;

/**
 * Created by Kyle on 6/12/2017.
 */
public class ThrowableRunnableTest {
    
    @Test
    public void testThrowableRunnable() throws Throwable {
        Verify.ThrowableRunnable runnable = () -> {
            int risky = getRisky();
        };
        runnable.run();
    }
    
    private int getRisky() throws RuntimeException {
        return 1;
    }
}
