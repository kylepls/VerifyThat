package in.kyle.api.verify.types;

import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class BooleanPredicateTest {
    
    @Test
    public void testTrue() {
        Verify.that(true).isTrue();
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotTrue() {
        Verify.that(false).isTrue();
    }
    
    @Test
    public void testFalse() {
        Verify.that(false).isFalse();
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotFalse() {
        Verify.that(false).isTrue();
    }
}
