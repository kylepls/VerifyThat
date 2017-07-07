package in.kyle.api.verify.types;

import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class ObjectPredicateTest {
    
    private static Object nul = null;
    
    @Test
    public void testIsNotNull() {
        Verify.that(this).isNotNull();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotNullError() {
        Verify.that(nul).isNotNull();
    }
    
    @Test
    public void testIsNull() {
        Verify.that(nul).isNull();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNullError() {
        Verify.that(this).isNull();
    }
    
    @Test
    public void testIsEqual() {
        Verify.that("asd").isEqual("asd");
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsEqualError() {
        Verify.that("asd").isEqual("d");
    }
    
    @Test
    public void testIsNotEqual() {
        Verify.that("asd").isNotEqual("d");
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotEqualError() {
        Verify.that("asd").isNotEqual("asd");
    }
    
    @Test
    public void testIsSame() {
        Verify.that(this).isSame(this);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsSameError() {
        Verify.that(this).isSame(nul);
    }
    
    
    @Test
    public void testIsNotSame() {
        Verify.that(this).isNotSame(nul);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotSameError() {
        Verify.that(this).isNotSame(this);
    }
    
    @Test
    public void testInstanceOf() {
        Verify.that(this).isInstanceOf(Object.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testInstanceOfError() {
        Verify.that(this).isInstanceOf(Number.class);
    }
    
    @Test
    public void testNotInstanceOf() {
        Verify.that(this).isNotInstanceOf(Number.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotInstanceOfError() {
        Verify.that(this).isNotInstanceOf(Object.class);
    }
    
    @Test
    public void testIsExactType() {
        Verify.that(this).isExactType(ObjectPredicateTest.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsExactTypeError() {
        Verify.that(this).isExactType(Object.class);
    }
    
    @Test
    public void testIsNotExactType() {
        Verify.that(this).isNotExactType(Object.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotExactTypeError() {
        Verify.that(this).isNotExactType(ObjectPredicateTest.class);
    }
    
    @Test
    public void testNamed() {
        try {
            Verify.that(this).named("123").isNull();
        } catch (ComparisionException e) {
            if (!e.getMessage().contains("123")) {
                throw new AssertionError("Message does not contain 123");
            }
        }
    }
}
