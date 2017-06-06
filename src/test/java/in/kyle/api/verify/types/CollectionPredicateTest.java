package in.kyle.api.verify.types;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 3/23/2017.
 */
public class CollectionPredicateTest {
    
    @Test
    public void testContains() {
        Verify.that(of(1, 2, 3)).contains(2);
    }
    
    @Test(expected = ComparisionException.class)
    public void testContainsError() {
        Verify.that(of(1, 2, 3)).contains(4);
    }
    
    @Test
    public void testNotContains() {
        Verify.that(of(1, 2, 3)).notContains(4);
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotContainsError() {
        Verify.that(of(1, 2, 3)).notContains(2);
    }
    
    @Test
    public void testIsEmpty() {
        Verify.that(of()).isEmpty();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsEmptyError() {
        Verify.that(of(1, 2, 3)).isEmpty();
    }
    
    @Test
    public void testIsNotEmpty() {
        Verify.that(of(1, 2, 3)).isNotEmpty();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotEmptyError() {
        Verify.that(of()).isNotEmpty();
    }
    
    @Test
    public void testSizeIs() {
        Verify.that(of(1, 2, 3)).sizeIs(3);
    }
    
    @Test(expected = ComparisionException.class)
    public void testSizeIsError() {
        Verify.that(of(1, 2, 3)).sizeIs(4);
    }
    
    @Test
    public void testSizeIsNot() {
        Verify.that(of(1, 2, 3)).sizeIsNot(4);
    }
    
    @Test(expected = ComparisionException.class)
    public void testSizeIsNotError() {
        Verify.that(of(1, 2, 3)).sizeIsNot(3);
    }
    
    private static <T> Collection<T> of(T... t) {
        return Arrays.asList(t);
    }
}
