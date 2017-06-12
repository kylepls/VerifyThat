package in.kyle.api.verify.types.iterable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 6/12/2017.
 */
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
}
