package in.kyle.api.verify;

import org.junit.Test;

public class VerifyTest {
    
    @Test
    public void testUtilityClass() {
        Verify.that(Verify.class).isUtilityClass();
    }
}
