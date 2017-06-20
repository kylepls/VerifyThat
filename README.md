[![](https://jitpack.io/v/kylepls/VerifyThat.svg)](https://jitpack.io/#kylepls/VerifyThat) 
[![Coverage Status](https://coveralls.io/repos/github/kylepls/VerifyThat/badge.svg?branch=master)
](https://coveralls.io/github/kylepls/VerifyThat?branch=master) [![Build Status](https://api.travis-ci.org/kylepls/VerifyThat.svg?branch=master)](https://travis-ci.org/kylepls/VerifyThat)

## VerifyThat
Make testing validation more fluent and understandable.

##### String:
    
    // before
    Assert.assertEquals("A and b must be equal", expected, actual);

    // after
    Verify.that(expected).isEqual(actual);

##### Boolean:

    // before
    Assert.assertTrue(bool);
    
    // after
    Verify.that(true).isTrue();

##### Array:
    
    // before
    Assert.assertArrayEquals(array, new int[] {1,2,3});
    
    // after
    Verify.that(array).arrayEquals(1, 2, 3);

##### Map:

    // before    
    Assert.assertEquals(true, map.containsKey("a"));
    
    // after
    Verify.that(map).containsKey("a");

#### VCS:

https://jitpack.io/#kylepls/VerifyThat/
