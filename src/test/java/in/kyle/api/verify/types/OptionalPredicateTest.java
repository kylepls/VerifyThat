package in.kyle.api.verify.types;

import org.junit.Test;

import java.util.Optional;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class OptionalPredicateTest {
    
    @Test
    public void testIsPresent() {
        Optional present = Optional.of(this);
        Verify.that(present).isPresent();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsPresentFail() {
        Optional present = Optional.empty();
        Verify.that(present).isPresent();
    }
    
    
    @Test
    public void testIsNotPresent() {
        Optional present = Optional.empty();
        Verify.that(present).isNotPresent();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotPresentFail() {
        Optional present = Optional.of(this);
        Verify.that(present).isNotPresent();
    }
    
    @Test
    public void testOptionalGet() {
        Verify.that(Optional.of(this)).get().isInstanceOf(this.getClass());
    }
}
