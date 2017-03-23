package in.kyle.api.conditions.types;

import org.junit.Test;

import in.kyle.api.conditions.ComparisionException;
import in.kyle.api.conditions.Verify;

/**
 * Created by Kyle on 3/23/2017.
 */
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
