package in.kyle.api.verify.types;

import java.util.Arrays;

import in.kyle.api.verify.NonNullPredicate;

/**
 * Created by Kyle on 4/7/2017.
 */
public class ArrayPredicate<T> extends NonNullPredicate<T[]> {
    public ArrayPredicate(T[] compare) {
        super(compare);
    }
    
    public void isEmpty() {
        sizeIs(0);
    }
    
    public void isNotEmpty() {
        sizeIsNot(0);
    }
    
    public void sizeIs(int size) {
        process(compare.length == size,
                "Array size should be {}, instead got {}",
                size,
                compare.length);
    }
    
    public void sizeIsNot(int size) {
        process(compare.length != size, "Array size should not be {}", size);
    }
    
    public void contains(T t) {
        process(arrayContains(t), "Array does not contain {}, {}", t, arrayToString(compare));
    }
    
    public void notContain(T t) {
        process(!arrayContains(t), "Array contains {}", t);
    }
    
    public void arrayEquals(T[] other) {
        process(arrayEquals(compare, other),
                "Array {} != {}",
                arrayToString(compare),
                arrayToString(other));
    }
    
    public void arrayNotEquals(T[] other) {
        process(!arrayEquals(compare, other),
                "Array {} == {}",
                arrayToString(compare),
                arrayToString(other));
    }
    
    private boolean arrayEquals(T[] a, T[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean arrayContains(T element) {
        for (T t : compare) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }
    
    private String arrayToString(T[] array) {
        return Arrays.toString(array);
    }
}
