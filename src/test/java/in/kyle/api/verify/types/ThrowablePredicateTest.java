package in.kyle.api.verify.types;

import org.junit.Test;

import java.lang.reflect.Method;

import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 6/6/2017.
 */
public class ThrowablePredicateTest {
    
    @Test
    public void testContainsStack() {
        RuntimeException error = Inside.getError();
        Verify.that(error).containsStackElement(Inside.class);
    }
    
    @Test(expected = Exception.class)
    public void testNotContainsStack() {
        RuntimeException error = Inside.getError();
        Verify.that(error).containsStackElement(Integer.class);
    }
    
    @Test(expected = Exception.class)
    public void testNotContainsMethod() throws NoSuchMethodException {
        Method getError = Inside.class.getDeclaredMethod("otherMethod");
        RuntimeException error = Inside.getError();
        Verify.that(error).containsMethod(getError);
    }
    
    @Test
    public void testContainsMethod() throws NoSuchMethodException {
        Method getError = Inside.class.getDeclaredMethod("getError");
        RuntimeException error = Inside.getError();
        Verify.that(error).containsMethod(getError);
    }
    
    @Test
    public void testMessageIs() {
        RuntimeException exception = new RuntimeException("sample text");
        Verify.that(exception).messageIs("sample text");
    }
    
    @Test(expected = Exception.class)
    public void testMessageIsError() {
        RuntimeException exception = new RuntimeException("sample text");
        Verify.that(exception).messageIs("420");
    }
    
    @Test
    public void testToStackPredicate() {
        RuntimeException exception = new RuntimeException("sample text");
        Verify.that(exception).toStackPredicate().sizeIsNot(0);
    }
    
    private static class Inside {
        private static RuntimeException getError() {
            return new RuntimeException();
        }
        
        private static void otherMethod() {
        }
    }
    
}
