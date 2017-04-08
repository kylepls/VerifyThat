package in.kyle.api.verify.types;

import java.util.regex.Pattern;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class StringPredicate extends Predicate<String> {
    
    public StringPredicate(String compare) {
        super(compare);
    }
    
    public void isEmpty() {
        isNotNull();
        process(compare.isEmpty(), "String is not empty, {}, expected empty", compare);
    }
    
    public void startsWith(String string) {
        isNotNull();
        process(compare.startsWith(string), "String does not start with {}, {}", string, compare);
    }
    
    public void endsWith(String string) {
        isNotNull();
        process(compare.endsWith(string), "String does not end with {}, {}", string, compare);
    }
    
    public void containsPattern(String regex) {
        isNotNull();
        Pattern pattern = Pattern.compile(regex);
        process(pattern.matcher(compare).find(),
                "String does not contain pattern {}, {}",
                regex,
                compare);
    }
    
    public void notContainsPattern(String regex) {
        isNotNull();
        Pattern pattern = Pattern.compile(regex);
        process(!pattern.matcher(compare).find(), "String contains pattern {}, {}", regex, compare);
    }
    
    public void contains(String string) {
        isNotNull();
        process(compare.contains(string), "String does not contain {}, {}", string, compare);
    }
    
    public void notContain(String string) {
        isNotNull();
        process(!compare.contains(string),
                "String contains {}, {}, when it should not",
                string,
                compare);
    }
    
    public void matches(String regex) {
        isNotNull();
        process(compare.matches(regex), "String does not match pattern {}, {}", regex, compare);
    }
    
    public void length(int len) {
        isNotNull();
        process(compare.length() == len, "String not of length {}, {}", len, compare);
    }
    
    public void notLength(int len) {
        isNotNull();
        process(compare.length() != len,
                "String of length {}, {}, expected not length",
                len,
                compare);
    }
}
