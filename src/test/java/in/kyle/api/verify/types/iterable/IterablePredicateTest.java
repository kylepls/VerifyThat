package in.kyle.api.verify.types.iterable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class IterablePredicateTest {
    
    private List<Integer> a;
    private List<Integer> b;
    
    @Before
    public void setup() {
        a = Arrays.asList(1, 2, 3);
        b = Arrays.asList(1, 2, 3);
    }
    
    @Test
    public void testIsEqual() {
        Verify.that(a).isEqual(b);
    }
    
    @Test
    public void testAllMatch() {
        Verify.that(a).allMatch(integer -> integer < 4);
    }
    
    @Test(expected = ComparisionException.class)
    public void testAllMatchFail() {
        Verify.that(a).allMatch(integer -> integer < 2);
    }
    
    @Test
    public void testAnyMatch() {
        Verify.that(a).anyMatch(integer -> integer == 2);
    }
    
    @Test(expected = ComparisionException.class)
    public void testAnyMatchFail() {
        Verify.that(a).anyMatch(integer -> integer == 4);
    }
    
    @Test
    public void testNoneMatch() {
        Verify.that(a).noneMatch(integer -> integer == 4);
    }
    
    @Test(expected = ComparisionException.class)
    public void testNoneMatchFail() {
        Verify.that(a).noneMatch(integer -> integer == 2);
    }
}
