package in.kyle.api.verify.types.reflect.query;

import org.junit.Test;

import in.kyle.api.verify.Verify;
import lombok.AllArgsConstructor;
import lombok.Setter;

public class MethodQueryTest {
    
    @Test
    public void testIsBridge() {
        Verify.that(SubNode.class).matcher().hasMethod().isBridge().getMatched().sizeIs(1);
    }
    
    @Test
    public void testIsDefault() {
        Verify.that(DefaultInterface.class)
              .matcher()
              .hasMethod()
              .isDefault()
              .getMatched()
              .sizeIs(1);
    }
    
    @Test
    public void testSynthetic() {
        Verify.that(SubNode.class)
              .matcher()
              .hasMethod()
              .isSynthetic()
              .getMatched()
              .sizeIsGreaterThan(0);
    }
    
    @Test
    public void testVarargs() {
        Verify.that(DefaultInterface.class)
              .matcher()
              .hasMethod()
              .isVarArgs()
              .getMatched()
              .sizeIs(1);
    }
    
    @Test
    public void testAbstract() {
        abstract class Abstract {
            abstract void method();
        }
        Verify.that(Abstract.class).matcher().hasMethod().isAbstract().getMatched().sizeIs(1);
    }
    
    @Test
    public void testNative() {
        Verify.that(Class.class).matcher().hasMethod().isNative().getMatched().sizeIsNot(0);
    }
    
    @Test
    public void testReturnTypeIs() {
        Verify.that(DefaultInterface.class)
              .matcher()
              .hasMethod()
              .returnTypeIs(Void.TYPE)
              .getMatched()
              .sizeIs(1);
    }
    
    @Test
    public void testGetNamed() {
        Verify.that(DefaultInterface.class)
              .matcher()
              .hasMethod()
              .nameIs("run")
              .getMatched()
              .sizeIs(1);
    }
    
    @Test
    public void testGetType() {
        Verify.that(DefaultInterface.class)
              .matcher()
              .hasMethod()
              .typeIs(Void.TYPE)
              .getMatched()
              .sizeIs(1);
    }
    
    @Test
    public void testModifier() {
        Verify.that(DefaultInterface.class).matcher().hasMethod().isPublic().getMatched().sizeIs(1);
    }
    
    interface DefaultInterface {
        default void run(Object... args) {
        }
    }
    
    @AllArgsConstructor
    private class Node<T> {
        @Setter
        private T data;
    }
    
    public class SubNode extends Node<Integer> {
        SubNode(Integer data) {
            super(data);
        }
        
        public void setData(Integer data) {
            super.setData(data);
        }
    }
}
