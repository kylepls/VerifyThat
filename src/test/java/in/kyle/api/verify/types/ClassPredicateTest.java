package in.kyle.api.verify.types;

import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 3/23/2017.
 */
public class ClassPredicateTest {
    
    @Test
    public void testIsEnum() {
        Verify.that(Enum.class).isEnum();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotEnumError() {
        Verify.that(ClassPredicateTest.class).isEnum();
    }
    
    @Test
    public void testIsNotEnum() {
        Verify.that(ClassPredicateTest.class).isNotEnum();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotEnumError2() {
        Verify.that(Enum.class).isNotEnum();
    }
    
    
    @Test
    public void testIsAssignableTo() {
        Verify.that(ClassPredicate.class).isAssignableTo(Predicate.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotAssignableToError() {
        Verify.that(Predicate.class).isAssignableTo(ClassPredicate.class);
    }
    
    @Test
    public void testIsNotAssignableTo() {
        Verify.that(Predicate.class).isNotAssignableTo(ClassPredicate.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsNotAssignableToError2() {
        Verify.that(ClassPredicate.class).isNotAssignableTo(Predicate.class);
    }
    
    private enum Enum {
    }
}
