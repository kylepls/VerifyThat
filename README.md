[![](https://jitpack.io/v/kylepls/VerifyThat.svg)](https://jitpack.io/#kylepls/VerifyThat) 
[![Coverage Status](https://coveralls.io/repos/github/kylepls/VerifyThat/badge.svg?branch=master)
](https://coveralls.io/github/kylepls/VerifyThat?branch=master) [![Build Status](https://api.travis-ci.org/kylepls/VerifyThat.svg?branch=master)](https://travis-ci.org/kylepls/VerifyThat)

## VerifyThat
Make testing validation more fluent and understandable.

##### Example:
    
    String test = "asd";
    Verify.that(test)
          .named("Check string {}", test)           // Name the test
          .sizeIsGreaterThan(2)                     // size > 2
          .contains("sd")                           // contains string "sd"
          .contains('q');                           // ERROR!!!
          
    // ComparisionException: (Check string asd) Expected [contains q] but got [[a, s, d]]

##### String:
    
    Verify.that("asdasd")
          .matches("\\w+")      // regex pattern
          .sizeIsGreaterThan(3) // length > 3
          .startsWith("as")     // starts with "as"
          .contains('d')        // contains letter d
          .notContains('q');    // contains letter q

##### Arrays:
    
    Verify.that(new Object[] {1, 2, 3})
          .isNotEmpty()                 // size > 0
          .sizeIsGreaterThan(1)         // size > 1
          .sizeIsLessThan(4)            // size < 4
          .contains(1, 3)               // contains 1, contains 3
          .arrayEquals(1, 2, 3)         // is same as [1, 2, 3]

##### Map:
    
    Verify.that(map)
          .sizeIsGreaterThan(1)     // size > 1
          .sizeIsLessThan(4)        // size < 4       
          .containsKey("a")         // contains key=a
          .containsValue(1)         // contains value=1
          .containsKeyValue("a", 1);// contains (a:1)

##### Runnable:
    
    Verify.that(() -> { throw new IOException("BAD THINGS", new Exception()); })
          .timeout(10, TimeUnit.SECONDS)         // 10s timeout
          .throwsException(IOException.class)    // Caught IOException
          .messageIs("BAD THINGS")               // Exception message = "BAD THINGS"
          .causeIs(Exception.class);             // Cause of exception is Exception

##### Classes:
    
    // Validation of modifiers
    Verify.that(getClass()).is(ReflectModifier.PUBLIC);
    
    // Verify existance of methods and fields matching conditions
    Verify.that(Runnable.class)
          .matcher()
          .hasMethod()
          .typeIs(Void.TYPE)
          .getMatched()
          .sizeIs(1);

#### VCS:

https://jitpack.io/#kylepls/VerifyThat/
