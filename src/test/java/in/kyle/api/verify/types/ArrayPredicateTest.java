package in.kyle.api.verify.types;

import org.junit.Test;

import java.util.Arrays;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 4/7/2017.
 */
public class ArrayPredicateTest {
    
    private Integer[] empty = {};
    
    private Integer[] odd = {1, 3, 5};
    private Integer[] even = {2, 4, 6};
    
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
        Verify.that(odd).arrayEquals(new Integer[]{1, 3, 5});
    }
    
    @Test(expected = ComparisionException.class)
    public void testArrayEqualsFail() {
        Verify.that(odd).arrayEquals(new Integer[]{1, 2, 5});
    }
    
    @Test
    public void testArrayNotEquals() {
        Verify.that(odd).arrayNotEquals(new Integer[]{1, 2, 5});
    }
    
    @Test(expected = ComparisionException.class)
    public void testArrayNotEqualsFail() {
        Verify.that(odd).arrayNotEquals(odd);
    }
    
    @Test(expected = ComparisionException.class)
    public void testArrayEqualsSizeError() {
        Verify.that(odd).isEqual(Arrays.asList(1, 2));
    }
}
