package in.kyle.api.verify.types;

import java.util.regex.Pattern;

import in.kyle.api.verify.Predicate;

public class StringPredicate extends Predicate<String, StringPredicate> {
    
    public StringPredicate(String compare) {
        super(compare);
    }
    
    public StringPredicate isEmpty() {
        isNotNull();
        process(compare.isEmpty(), "empty string");
        return this;
    }
    
    public StringPredicate startsWith(String string) {
        isNotNull();
        process(compare.startsWith(string), "startsWith(" + string + ")");
        return this;
    }
    
    public StringPredicate endsWith(String string) {
        isNotNull();
        process(compare.endsWith(string), "endsWith(" + string + ")");
        return this;
    }
    
    public StringPredicate containsPattern(String regex) {
        isNotNull();
        Pattern pattern = Pattern.compile(regex);
        process(pattern.matcher(compare).find(), "containsPattern(" + regex + ")");
        return this;
    }
    
    public StringPredicate notContainsPattern(String regex) {
        isNotNull();
        Pattern pattern = Pattern.compile(regex);
        process(!pattern.matcher(compare).find(), "notContainsPattern(" + regex + ")");
        return this;
    }
    
    public StringPredicate contains(String string) {
        isNotNull();
        process(compare.contains(string), "contains(" + string + ")");
        return this;
    }
    
    public StringPredicate notContain(String string) {
        isNotNull();
        process(!compare.contains(string), "notContains(" + string + ")");
        
        return this;
    }
    
    public StringPredicate matches(String regex) {
        isNotNull();
        process(compare.matches(regex), "matches(" + regex + ")");
        return this;
    }
    
    public StringPredicate length(int len) {
        isNotNull();
        process(compare.length() == len, "length == " + len, compare.length());
        return this;
    }
    
    public StringPredicate notLength(int len) {
        isNotNull();
        process(compare.length() != len, "length != " + len, compare.length());
        return this;
    }
}
