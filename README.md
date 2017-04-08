## Verify
Make output validation more simple

#### Before:
    
    Assert.assertEquals("A and b must be equal", expected, actual);

#### After:
    
    Verify.that(expected).isEqual(actual);

#### Maven:

https://jitpack.io/#kylepls/VerifyThat/

[![](https://jitpack.io/v/kylepls/VerifyThat.svg)](https://jitpack.io/#kylepls/VerifyThat)
