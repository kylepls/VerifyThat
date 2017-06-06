package in.kyle.api.verify.types;

import java.util.Collection;

import in.kyle.api.verify.Verify;
import in.kyle.api.verify.types.iterable.IterablePredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class CollectionPredicate<T> extends IterablePredicate<T, Collection<T>> {
    
    public CollectionPredicate(Collection<T> compare) {
        super(compare);
    }
    
    public ArrayPredicate<T> toArrayPredicate() {
        Object[] objects = compare.toArray();
        T[] array = (T[]) objects;
        return Verify.that(array);
    }
}
