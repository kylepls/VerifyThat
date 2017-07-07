package in.kyle.api.verify.types.reflect.query;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.function.Function;

import in.kyle.api.verify.Verify;

public class ClassQueryTest {
    
    @Test
    public void testIsStatic() {
        Verify.that(TestClass.class).matcher().isStatic();
    }
    
    @Test
    public void testIsFinal() {
        Verify.that(TestClass.class).matcher().isFinal();
    }
    
    @Test
    public void testIsInterface() {
        Verify.that(Function.class).matcher().isInterface();
    }
    
    @Test
    public void testIsAbstract() {
        abstract class Test {
        }
        Verify.that(Test.class).matcher().isAbstract();
    }
    
    @Test
    public void testIsSynthetic() {
        Runnable runnable = () -> {
        };
        Verify.that(runnable.getClass()).matcher().isSynthetic();
    }
    
    @Test
    public void testIsAnnotation() {
        Verify.that(CustomAnnotation.class).matcher().isAnnotation();
    }
    
    @Test
    public void testIsEnum() {
        Verify.that(TestEnum.class).matcher().isEnum();
    }
    
    @Test
    public void testHasAnnotation() {
        Verify.that(TestClass.class).matcher().hasAnnotation(CustomAnnotation.class);
    }
    
    @Test
    public void testTypeIs() {
        Verify.that(TestClass.class).matcher().typeIs(TestClass.class);
    }
    
    @Test
    public void testNameIs() {
        Verify.that(TestClass.class).matcher().nameIs("TestClass");
    }
    
    @Test
    public void testIsPublic() {
        Verify.that(TestEnum.class).matcher().isPublic();
    }
    
    @Test
    public void testIsPrivate() {
        Verify.that(CustomAnnotation.class).matcher().isPrivate();
    }
    
    @Test
    public void testIsProtected() {
        Verify.that(TestClass.class).matcher().isProtected();
    }
    
    @Test
    public void testGetMatched() {
        Verify.that(ClassQueryTest.class).matcher().getMatched().sizeIs(1);
    }
    
    @CustomAnnotation
    protected static final class TestClass {
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    private @interface CustomAnnotation {
    }
    
    public enum TestEnum {
    }
}
