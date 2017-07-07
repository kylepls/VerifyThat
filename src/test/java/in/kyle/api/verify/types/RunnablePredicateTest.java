package in.kyle.api.verify.types;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class RunnablePredicateTest {
    
    @Test
    public void testThrowsException() {
        Verify.that(() -> {
            throw new RuntimeException();
        }).throwsException(RuntimeException.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testThrowsExceptionError() {
        Verify.that(() -> {
        }).throwsException(RuntimeException.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testUnexpectedExceptionError() {
        Verify.that(() -> {
            throw new IllegalAccessError();
        }).throwsException(NullPointerException.class);
    }
    
    @Test
    public void testNotThrowsException() {
        Verify.that(() -> {
        }).doesNotThrowException();
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotThrowsExceptionError() {
        Verify.that(() -> {
            throw new RuntimeException();
        }).doesNotThrowException();
    }
    
    @Test(expected = ComparisionException.class)
    public void testNoError() {
        Verify.that(() -> {
        }).throwsException(ComparisionException.class);
    }
    
    @Test
    public void testNestedException() {
        Verify.that(() -> {
            IllegalAccessException swag = new IllegalAccessException("swag");
            throw new RuntimeException(swag);
        }).throwsException(RuntimeException.class).causeIs(IllegalAccessException.class);
    }
    
    @Test(timeout = 10_000, expected = ComparisionException.class)
    public void testTimeout() {
        Verify.that(() -> Thread.sleep(1000))
              .timeout(10, TimeUnit.MILLISECONDS)
              .doesNotThrowException();
    }
    
    @Test(expected = RuntimeException.class)
    public void testInterrupted() {
        Thread thread = Thread.currentThread();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            thread.interrupt();
        }).start();
        Verify.that(() -> {
            Thread.sleep(10000);
        }).doesNotThrowException();
    }
}
