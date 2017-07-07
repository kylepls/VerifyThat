package in.kyle.api.verify.types.reflect.query;

import org.junit.Before;
import org.junit.Test;

import in.kyle.api.verify.Verify;

public class FieldQueryTest {
    
    private transient String transientString;
    private volatile String volatileString;
    private ClassQueryBuilder matcher;
    
    @Before
    public void setup() {
        matcher = Verify.that(FieldQueryTest.class).matcher();
    }
    
    @Test
    public void testTransient() {
        matcher.hasField().isTransient().getMatched().sizeIsGreaterThan(0);
    }
    
    @Test
    public void testVolatile() {
        matcher.hasField().isVolatile().getMatched().sizeIs(1);
    }
    
    @Test
    public void testNamed() {
        matcher.hasField().nameIs("volatileString").getMatched().sizeIs(1);
    }
    
    @Test
    public void testGetModifiers() {
        matcher.hasField().isPrivate().getMatched().sizeIsGreaterThan(2);
    }
    
    @Test
    public void testGetType() {
        matcher.hasField().typeIs(String.class).getMatched().sizeIs(2);
    }
}
