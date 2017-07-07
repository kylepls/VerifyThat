package in.kyle.api.verify.types;

import java.util.Arrays;
import java.util.List;

import in.kyle.api.verify.types.iterable.IterablePredicate;

public class ArrayPredicate<T> extends IterablePredicate<T, List<T>, ArrayPredicate<T>> {
    private final T[] compare;
    
    public ArrayPredicate(T[] compare) {
        super(Arrays.asList(compare));
        this.compare = compare;
    }
    
    @SafeVarargs
    public final ArrayPredicate<T> arrayEquals(T... other) {
        isNotNull();
        process(arrayEquals(compare, other),
                arrayToString(compare) + " == " + arrayToString(other),
                false);
        return this;
    }
    
    @SafeVarargs
    public final ArrayPredicate<T> arrayNotEquals(T... other) {
        isNotNull();
        process(!arrayEquals(compare, other),
                arrayToString(compare) + " != " + arrayToString(other),
                false);
        return this;
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
