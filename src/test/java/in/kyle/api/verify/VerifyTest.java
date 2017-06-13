package in.kyle.api.verify;

import org.junit.Test;

/**
 * Created by Kyle on 6/12/2017.
 */
public class VerifyTest {
    
    @Test
    public void testUtilityClass() {
        Verify.that(Verify.class).isUtilityClass();
    }
}
