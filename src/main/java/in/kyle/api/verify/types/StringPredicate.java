package in.kyle.api.verify.types;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import in.kyle.api.verify.types.iterable.IterablePredicate;

public class StringPredicate
        extends IterablePredicate<Character, List<Character>, StringPredicate> {
    
    private final String compare;
    
    public StringPredicate(String compare) {
        super(getCharacters(compare));
        this.compare = compare;
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
    
    public StringPredicate isEqual(String string) {
        isNotNull();
        process(compare.equals(string), compare + " equals " + string, false);
        return this;
    }
    
    public StringPredicate isNotEqual(String string) {
        isNotNull();
        process(!compare.equals(string), compare + " notEquals " + string, false);
        return this;
    }
    
    private static List<Character> getCharacters(String string) {
        List<Character> characters = new ArrayList<>();
        for (char c : string.toCharArray()) {
            characters.add(c);
        }
        return characters;
    }
}
