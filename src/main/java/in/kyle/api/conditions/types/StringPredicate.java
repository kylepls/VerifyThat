package in.kyle.api.conditions.types;

import java.util.regex.Pattern;

import in.kyle.api.conditions.Predicate;
import in.kyle.api.conditions.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class StringPredicate extends Predicate<String> {
    
    public StringPredicate(String compare) {
        super(compare);
    }
    
    public Result isEmpty() {
        return result(compare.isEmpty(), "String is not empty, {}, expected empty", compare);
    }
    
    public Result startsWith(String string) {
        return result(compare.startsWith(string),
                      "String does not start with {}, {}",
                      string,
                      compare);
    }
    
    public Result endsWith(String string) {
        return result(compare.endsWith(string), "String does not end with {}, {}", string, compare);
    }
    
    public Result containsPattern(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return result(pattern.matcher(compare).find(),
                      "String does not contain pattern {}, {}",
                      regex,
                      compare);
    }
    
    public Result notContainsPattern(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return result(!pattern.matcher(compare).find(),
                      "String contains pattern {}, {}",
                      regex,
                      compare);
    }
    
    public Result contains(String string) {
        return result(compare.contains(string), "String does not contain {}, {}", string, compare);
    }
    
    public Result notContain(String string) {
        return result(!compare.contains(string),
                      "String contains {}, {}, when it should not",
                      string,
                      compare);
    }
    
    public Result matches(String regex) {
        return result(compare.matches(regex),
                      "String does not match pattern {}, {}",
                      regex,
                      compare);
    }
    
    public Result length(int len) {
        return result(compare.length() == len, "String not of length {}, {}", len, compare);
    }
    
    public Result notLength(int len) {
        return result(compare.length() != len,
                      "String of length {}, {}, expected not length",
                      len,
                      compare);
    }
}
