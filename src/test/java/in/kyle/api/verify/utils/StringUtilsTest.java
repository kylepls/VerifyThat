package in.kyle.api.verify.utils;

import org.junit.Test;

import in.kyle.api.verify.Verify;

public class StringUtilsTest {
    @Test(expected = IllegalArgumentException.class)
    public void testWrongNumberArgs() {
        StringUtils.replaceVariables("{} {} {}", 1, 2, 3, 4);
    }
    
    @Test
    public void testUtility() {
        Verify.that(StringUtils.class).isUtilityClass();
    }
    
    @Test
    public void testHiddenChar() {
        String string = "\0\0\0";
        Verify.that(StringUtils.ezReadString(string)).isEqual("\ufffd\ufffd\ufffd");
    }
}
