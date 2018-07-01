package in.kyle.api.verify.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public final class StringUtils {
    
    private static final Map<String, String> replacements = new LinkedHashMap<String, String>() {{
        put(" ", "\u2423");
        put("\r", "\u23ce");
        put("\n", "\u2424\n");
        put("(?=[^\u2424\u23ce\u2423\n])\\p{C}", "\ufffd");
        
    }};
    
    private StringUtils() {
    }
    
    public static String replaceVariables(String string, Object... args) {
        StringBuilder builder = new StringBuilder(string);
        for (Object object : args) {
            int i = builder.indexOf("{}");
            if (i != -1) {
                builder.replace(i, i + 2, object != null ? object.toString() : "null");
            } else {
                throw new IllegalArgumentException(
                        "Wrong number of arguments for string (" + string + "), Length: " +
                        args.length);
            }
        }
        
        return builder.toString();
    }
    
    public static String ezReadString(String input) {
        String result = input;
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
