package in.kyle.api.verify;

import org.junit.Test;

public class PrimitivesVerifyTest {
    
    @Test
    public void testBooleanArray() {
        boolean[] res = new boolean[]{true, false, true};
        Verify.that(res).arrayEquals(true, false, true);
    }
    
    @Test
    public void testByteArray() {
        byte[] res = new byte[]{1, 2, 3};
        Verify.that(res).arrayEquals((byte) 1, (byte) 2, (byte) 3);
    }
    
    @Test
    public void testCharacterArray() {
        char[] res = new char[]{'a', 'b', 'c'};
        Verify.that(res).arrayEquals('a', 'b', 'c');
    }
    
    @Test
    public void testDoubleArray() {
        double[] res = new double[]{1D, 2D, 3D};
        Verify.that(res).arrayEquals(1D, 2D, 3D);
    }
    
    @Test
    public void testFloatArray() {
        float[] res = new float[]{1F, 2F, 3F};
        Verify.that(res).arrayEquals(1F, 2F, 3F);
    }
    
    @Test
    public void testIntegerArray() {
        int[] res = new int[]{1, 2, 3};
        Verify.that(res).arrayEquals(1, 2, 3);
    }
    
    @Test
    public void testLongArray() {
        long[] res = new long[]{1L, 2L, 3L};
        Verify.that(res).arrayEquals(1L, 2L, 3L);
    }
    
    @Test
    public void testShortArray() {
        short[] res = new short[]{1, 2, 3};
        Verify.that(res).arrayEquals((short) 1, (short) 2, (short) 3);
    }
}
