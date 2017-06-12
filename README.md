## Verify
Make output validation more simple

#### Before:
    
    Assert.assertEquals("A and b must be equal", expected, actual);

#### After:
    
    Verify.that(expected).isEqual(actual);

#### Maven:

https://jitpack.io/#kylepls/VerifyThat/

[![](https://jitpack.io/v/kylepls/VerifyThat.svg)](https://jitpack.io/#kylepls/VerifyThat)

[![Coverage Status](https://coveralls.io/repos/github/kylepls/VerifyThat/badge.svg?branch=master)](https://coveralls.io/github/kylepls/VerifyThat?branch=master)

[![Build Status](https://api.travis-ci.org/kylepls/VerifyThat.svg?branch=master)](https://travis-ci.org/kylepls/VerifyThat)