package in.kyle.api.verify;

import in.kyle.api.verify.types.ArrayPredicate;

// TODO: 7/19/2017 - I hate this class, if anyone know how to make anything better then this 
// please let me know asap! 
class PrimitivesVerify {
    
    public static ArrayPredicate<Boolean> that(boolean[] array) {
        // Generated Code
        Boolean[] res = new Boolean[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Byte> that(byte[] array) {
        // Generated Code
        Byte[] res = new Byte[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Character> that(char[] array) {
        // Generated Code
        Character[] res = new Character[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Double> that(double[] array) {
        // Generated Code
        Double[] res = new Double[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Float> that(float[] array) {
        // Generated Code
        Float[] res = new Float[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Integer> that(int[] array) {
        // Generated Code
        Integer[] res = new Integer[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Long> that(long[] array) {
        // Generated Code
        Long[] res = new Long[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
    
    public static ArrayPredicate<Short> that(short[] array) {
        // Generated Code
        Short[] res = new Short[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return new ArrayPredicate<>(res);
    }
}
