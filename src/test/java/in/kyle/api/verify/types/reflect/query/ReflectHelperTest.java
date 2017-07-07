package in.kyle.api.verify.types.reflect.query;

import org.junit.Test;

import in.kyle.api.verify.Verify;

public class ReflectHelperTest {
    @Test
    public void testUtilityClass() {
        Verify.that(ReflectHelper.class).isUtilityClass();
    }
}
