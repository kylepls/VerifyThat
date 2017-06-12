package in.kyle.api.verify.utils;

/**
 * Created by Kyle at Mar 8, 2015
 */
public enum  StringUtils {
    ;
    
    public static String replaceVariables(String string, Object... args) {
        StringBuilder builder = new StringBuilder(string);
        for (Object object : args) {
            int i = builder.indexOf("{}");
            if (i > -1) {
                builder.replace(i, i + 2, object != null ? object.toString() : "null");
            } else {
                throw new IllegalArgumentException(
                        "Wrong number of arguments for string (" + string + "), Length: " +
                        args.length);
            }
        }
        
        return builder.toString();
    }
}
