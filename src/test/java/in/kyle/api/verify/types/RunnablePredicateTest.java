package in.kyle.api.verify.types;

import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 3/23/2017.
 */
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
}
