package in.kyle.api.verify.types;

import java.util.regex.Pattern;

import in.kyle.api.verify.NonNullPredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class StringPredicate extends NonNullPredicate<String> {
    
    public StringPredicate(String compare) {
        super(compare);
    }
    
    public void isEmpty() {
        process(compare.isEmpty(), "String is not empty, {}, expected empty", compare);
    }
    
    public void startsWith(String string) {
        process(compare.startsWith(string), "String does not start with {}, {}", string, compare);
    }
    
    public void endsWith(String string) {
        process(compare.endsWith(string), "String does not end with {}, {}", string, compare);
    }
    
    public void containsPattern(String regex) {
        Pattern pattern = Pattern.compile(regex);
        process(pattern.matcher(compare).find(),
                "String does not contain pattern {}, {}",
                regex,
                compare);
    }
    
    public void notContainsPattern(String regex) {
        Pattern pattern = Pattern.compile(regex);
        process(!pattern.matcher(compare).find(), "String contains pattern {}, {}", regex, compare);
    }
    
    public void contains(String string) {
        process(compare.contains(string), "String does not contain {}, {}", string, compare);
    }
    
    public void notContain(String string) {
        process(!compare.contains(string),
                "String contains {}, {}, when it should not",
                string,
                compare);
    }
    
    public void matches(String regex) {
        process(compare.matches(regex), "String does not match pattern {}, {}", regex, compare);
    }
    
    public void length(int len) {
        process(compare.length() == len, "String not of length {}, {}", len, compare);
    }
    
    public void notLength(int len) {
        process(compare.length() != len,
                "String of length {}, {}, expected not length",
                len,
                compare);
    }
}
