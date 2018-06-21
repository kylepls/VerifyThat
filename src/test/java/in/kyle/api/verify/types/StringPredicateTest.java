package in.kyle.api.verify.types;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import in.kyle.api.verify.ComparisionException;
import in.kyle.api.verify.Verify;

public class StringPredicateTest {
    
    @Test
    public void testStringEmpty() {
        Verify.that("").isEmpty();
    }
    
    @Test(expected = ComparisionException.class)
    public void testStringEmptyError() {
        Verify.that("1").isEmpty();
    }
    
    @Test
    public void testStartsWith() {
        Verify.that("one").startsWith("o");
    }
    
    @Test(expected = ComparisionException.class)
    public void testStartsWithError() {
        Verify.that("one").startsWith("n");
    }
    
    @Test
    public void testEndsWith() {
        Verify.that("one").endsWith("e");
    }
    
    @Test(expected = ComparisionException.class)
    public void testEndsWithError() {
        Verify.that("one").endsWith("n");
    }
    
    @Test
    public void testContainsPattern() {
        Verify.that("one").containsPattern("n");
    }
    
    @Test(expected = ComparisionException.class)
    public void testContainsPatternError() {
        Verify.that("one").containsPattern("r");
    }
    
    @Test
    public void testNotContainsPattern() {
        Verify.that("one").notContainsPattern("r");
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotContainsPatternError() {
        Verify.that("one").notContainsPattern("n");
    }
    
    @Test
    public void testContains() {
        Verify.that("one").contains("e");
    }
    
    @Test(expected = ComparisionException.class)
    public void testContainsError() {
        Verify.that("one").contains("r");
    }
    
    @Test
    public void testNotContains() {
        Verify.that("one").notContain("r");
    }
    
    @Test(expected = ComparisionException.class)
    public void testNotContainsError() {
        Verify.that("one").notContain("e");
    }
    
    @Test
    public void testMatches() {
        Verify.that("one").matches(".+");
    }
    
    @Test(expected = ComparisionException.class)
    public void testMatchesError() {
        Verify.that("one").matches(".");
    }
    
    @Test
    public void testDiffEmpty() throws IOException {
        String file1 = loadFile("file1");
        Verify.that(file1).diffEqual(file1);
    }
    
    @Test(expected = ComparisionException.class)
    public void testDiffEmptyError() throws IOException {
        String file1 = loadFile("file1");
        String file2 = loadFile("file2");
        Verify.that(file2).diffEqual(file1);
    }
    
    private String loadFile(String file) throws IOException {
        InputStream resource = getResource("/" + file);
        if (resource == null) {
            resource = getResource(file);
        }
        StringBuilder sb = new StringBuilder();
        int data;
        while ((data = resource.read()) != -1) {
            sb.append((char) data);
        }
        return sb.toString();
    }
    
    private InputStream getResource(String path) {
        return StringPredicate.class.getResourceAsStream(path);
    }
}
