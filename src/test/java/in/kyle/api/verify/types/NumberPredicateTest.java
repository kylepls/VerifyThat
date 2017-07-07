package in.kyle.api.verify.types;

import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class NumberPredicateTest {
    
    @Test
    public void testIsZero() {
        Verify.that(0).isZero();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsZeroError() {
        Verify.that(1).isZero();
    }
    
    @Test
    public void testIsNotZero() {
        Verify.that(1).isNotZero();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotZeroError() {
        Verify.that(0).isNotZero();
    }
    
    @Test
    public void testIsLessThan() {
        Verify.that(1).isLessThan(10);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsLessThanError() {
        Verify.that(10).isLessThan(1);
    }
    
    @Test
    public void testIsGreaterThan() {
        Verify.that(1).isGreaterThan(0);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsGreaterThanError() {
        Verify.that(0).isGreaterThan(1);
    }
    
    @Test
    public void testIsWholeNumber() {
        Verify.that(1).isWholeNumber();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsWholeNumberError() {
        Verify.that(1.5).isWholeNumber();
    }
    
    @Test
    public void testIsNotWholeNumber() {
        Verify.that(1.5).isNotWholeNumber();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotWholeNumberError() {
        Verify.that(1).isNotWholeNumber();
    }
    
    @Test
    public void testIsFinite() {
        Verify.that(1).isFinite();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsFiniteError() {
        Verify.that(Double.POSITIVE_INFINITY).isFinite();
    }
    
    @Test
    public void testIsNotFinite() {
        Verify.that(Double.NEGATIVE_INFINITY).isNotFinite();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotFiniteError() {
        Verify.that(1).isNotFinite();
    }
    
    @Test
    public void testIsDivisibleBy() {
        Verify.that(4).isDivisibleBy(2);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsDivisibleByError() {
        Verify.that(4).isDivisibleBy(3);
    }
    
    @Test
    public void testIsNotDivisibleBy() {
        Verify.that(3).isNotDivisibleBy(2);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotDivisibleByError() {
        Verify.that(4).isNotDivisibleBy(2);
    }
    
    @Test
    public void testDiffType() {
        Verify.that(4.0).isEqual(4);
    }
    
    // wtf
    @Test
    public void testNegativeZero() {
        
        Verify.that(-0.0).isEqual(0.0);
    }
}
