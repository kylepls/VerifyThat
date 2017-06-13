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
    
    @Test
    public void testIsUtilityClass() {
        Verify.that(UtilityClassGood.class).isUtilityClass();
    }
    
    @Test
    public void testIsUtilityEnum() {
        Verify.that(UtilityEnumGood.class).isUtilityClass();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsUtilityClassFail() {
        Verify.that(UtilityClassBad.class).isUtilityClass();
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsUtilityEnumFail() {
        Verify.that(UtilityEnumBad.class).isUtilityClass();
    }
    
    @Test
    public void testFinalClass() {
        final class Final {
        }
        Verify.that(Final.class).isFinal();
    }
    
    @Test(expected = ComparisionException.class)
    public void testFinalClassError() {
        class Final {
        }
        Verify.that(Final.class).isFinal();
    }
    
    @Test(expected = RuntimeException.class)
    public void testResolveMethodError() {
        Verify.that(Enum.class).getConstructor();
    }
    
    @Test(expected = RuntimeException.class)
    public void testCreateInstanceFail() throws NoSuchMethodException {
        Verify.that(Enum.class).createInstance();
    }
    
    @Test(expected = RuntimeException.class)
    public void testInstanceCreateError() {
        Verify.that(Bait.class).isUtilityClass();
    }
    
    @Test(expected = ComparisionException.class)
    public void testUtilityMultipleConstructors() {
        final class Test {
            private Test() {
            }
            
            private Test(Object arg) {
            }
        }
        Verify.that(Test.class).isUtilityClass();
    }
    
    @Test(expected = ComparisionException.class)
    public void testUtilityPublicConstructor() {
        Verify.that(PublicConstructor.class).isUtilityClass();
    }
    
    private static final class PublicConstructor {
        public PublicConstructor() {
        }
    }
    
    private static final class Bait {
        
        private Bait() {
            throw new RuntimeException();
        }
    }
    
    private enum Enum {
    }
    
    private enum UtilityEnumGood {
        ;
        
        public static void thing() {
        }
    }
    
    private enum UtilityEnumBad {
        ;
        
        public void badThing() {
        }
    }
    
    private static final class UtilityClassGood {
        
        private UtilityClassGood() {
        }
        
        public static void thing() {
        }
    }
    
    private static final class UtilityClassBad {
        
        public void badThing() {
        }
    }
}
