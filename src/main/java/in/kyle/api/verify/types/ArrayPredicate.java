package in.kyle.api.verify.types;

import java.util.Arrays;
import java.util.List;

import in.kyle.api.verify.types.iterable.IterablePredicate;

/**
 * Created by Kyle on 6/6/2017.
 */
public class ArrayPredicate<T> extends IterablePredicate<T, List<T>> {
    private final T[] compare;
    
    public ArrayPredicate(T[] compare) {
        super(Arrays.asList(compare));
        this.compare = compare;
    }
    
    public void arrayEquals(T[] other) {
        isNotNull();
        process(arrayEquals(compare, other),
                "Array {} != {}",
                arrayToString(compare),
                arrayToString(other));
    }
    
    public void arrayNotEquals(T[] other) {
        isNotNull();
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
    
    private String arrayToString(T[] array) {
        return Arrays.toString(array);
    }
}
