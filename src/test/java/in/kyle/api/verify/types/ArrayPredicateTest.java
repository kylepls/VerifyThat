package in.kyle.api.verify.types;

import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class ArrayPredicateTest {
    
    private Integer[] empty = {};
    
    private Integer[] odd = {1, 3, 5};
    
    @Test
    public void testEmpty() {
        Verify.that(empty).isEmpty();
    }
    
    @Test(expected = ComparisionException.class)
    public void testEmptyFail() {
        Verify.that(odd).isEmpty();
    }
    
    @Test
    public void testNotEmpty() {
        Verify.that(odd).isNotEmpty();
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotEmptyFail() {
        Verify.that(empty).isNotEmpty();
    }
    
    @Test
    public void testContains() {
        Verify.that(odd).contains(1);
    }
    
    @Test(expected = ComparisionException.class)
    public void testContainsFail() {
        Verify.that(odd).contains(2);
    }
    
    @Test
    public void testNotContains() {
        Verify.that(odd).notContains(2);
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotContainsFail() {
        Verify.that(odd).notContains(1);
    }
    
    @Test
    public void testArrayEquals() {
        Verify.that(odd).arrayEquals(1, 3, 5);
    }
    
    @Test(expected = ComparisionException.class)
    public void testArrayEqualsFail() {
        Verify.that(odd).arrayEquals(1, 2, 5);
    }
    
    @Test
    public void testArrayNotEquals() {
        Verify.that(odd).arrayNotEquals(1, 2, 5);
    }
    
    @Test(expected = ComparisionException.class)
    public void testArrayNotEqualsFail() {
        Verify.that(odd).arrayNotEquals(odd);
    }
    
    @Test(expected = ComparisionException.class)
    public void testArrayEqualsSizeError() {
        Verify.that(odd).arrayEquals(1, 2);
    }
    
    @Test
    public void testContainsMany() {
        Verify.that(odd).contains(1, 3);
    }
    
    @Test(expected = ComparisionException.class)
    public void testContainsManyFail() {
        Verify.that(odd).contains(1, 4);
    }
    
    @Test(expected = ComparisionException.class)
    public void testNullVectorElement() {
        Verify.that(new Object[] {'a', 'b', null, 'd'}).arrayEquals('a', 'b', 'c', 'd');
    }
}
