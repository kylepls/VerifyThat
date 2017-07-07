package in.kyle.api.verify;

import org.junit.Test;

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
