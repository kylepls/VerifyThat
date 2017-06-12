package in.kyle.api.verify.utils;

import org.junit.Test;

/**
 * Created by Kyle on 6/12/2017.
 */
public class StringUtilsTest {
    @Test(expected = IllegalArgumentException.class)
    public void testWrongNumberArgs() {
        StringUtils.replaceVariables("{} {} {}", 1, 2, 3, 4);
    }
}
