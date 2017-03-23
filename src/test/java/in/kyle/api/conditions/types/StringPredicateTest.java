package in.kyle.api.conditions.types;

import org.junit.Test;

import in.kyle.api.conditions.ComparisionException;
import in.kyle.api.conditions.Verify;

/**
 * Created by Kyle on 3/23/2017.
 */
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
    public void testLength() {
        Verify.that("one").length(3);
    }
    
    @Test(expected = ComparisionException.class)
    public void testLengthError() {
        Verify.that("one").length(1);
    }
    
    @Test
    public void testLengthNot() {
        Verify.that("one").notLength(4);
    }
    
    @Test(expected = ComparisionException.class)
    public void testLengthNotError() {
        Verify.that("one").notLength(3);
    }
}
