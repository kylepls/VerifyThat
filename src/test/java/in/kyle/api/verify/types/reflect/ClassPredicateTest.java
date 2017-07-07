package in.kyle.api.verify.types.reflect;

import org.junit.Assert;
import org.junit.Test;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

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
    
    @Test
    public void testIsInstance() {
        Verify.that(true).isInstanceOf(Boolean.class);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsInstanceFail() {
        Verify.that(1).isInstanceOf(Double.TYPE);
    }
    
    @Test
    public void testIsModifier() {
        Verify.that(getClass()).is(ReflectModifier.PUBLIC);
    }
    
    @Test(expected = ComparisionException.class)
    public void testIsModifierFail() {
        Verify.that(getClass()).is(ReflectModifier.INTERFACE);
    }
    
    @Test
    public void testGetAccessProtected() throws NoSuchMethodException {
        class Test {
            protected Test() {
            }
        }
        String access = ClassPredicate.getAccess(Test.class.getDeclaredConstructors()[0]);
        Assert.assertEquals("protected", access);
    }
    
    @Test
    public void testGetAccessPackage() throws NoSuchMethodException {
        class Test {
            Test() {
            }
        }
        String access = ClassPredicate.getAccess(Test.class.getDeclaredConstructors()[0]);
        Assert.assertEquals("package", access);
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
