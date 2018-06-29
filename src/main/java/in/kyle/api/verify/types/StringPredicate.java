package in.kyle.api.verify.types;

import com.github.difflib.text.DiffRow;
import com.github.difflib.text.DiffRowGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import in.kyle.api.utils.Try;
import in.kyle.api.verify.types.iterable.IterablePredicate;

public class StringPredicate
        extends IterablePredicate<Character, List<Character>, StringPredicate> {
    
    private final String compare;
    
    public StringPredicate(String compare) {
        super(getCharacters(compare));
        this.compare = compare;
    }
    
    private static List<Character> getCharacters(String string) {
        List<Character> characters = new ArrayList<>();
        for (char c : string.toCharArray()) {
            characters.add(c);
        }
        return characters;
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
    
    public StringPredicate diffEqual(String string) {
        isNotNull();
        List<String> compareList = Arrays.asList(compare.split("\n"));
        List<String> stringList = Arrays.asList(string.split("\n"));
        List<DiffRow> diffRows = getDiffRows(compareList, stringList);
        String diff = diffRows.stream()
                              .filter(diffRow -> diffRow.getTag() != DiffRow.Tag.EQUAL)
                              .map(diffRow -> diffRows.indexOf(diffRow) + ": " + diffRow.toString())
                              .map(s -> s.replaceAll("\\p{C}", "?"))
                              .collect(Collectors.joining("\n"));
        process(diffRows.size() == 0,
                "Same file",
                String.format("\n%s\n\n\n%s\n\n\n%s\n", compare, string, diff));
        return this;
    }
    
    private List<DiffRow> getDiffRows(List<String> compareList, List<String> stringList) {
        DiffRowGenerator generator = DiffRowGenerator.create().build();
        List<DiffRow> diffRows = Try.to(() -> generator.generateDiffRows(compareList, stringList));
        diffRows.removeIf(diffRow -> diffRow.getTag() == DiffRow.Tag.EQUAL);
        return diffRows;
    }
}
