package in.kyle.api.verify.types;

import java.util.Collection;

import in.kyle.api.verify.NonNullPredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class CollectionPredicate<T> extends NonNullPredicate<Collection<T>> {
    
    public CollectionPredicate(Collection<T> compare) {
        super(compare);
    }
    
    public void contains(T value) {
        process(compare.contains(value), "Collection does not contain {}, {}", value, compare);
    }
    
    public void doesNotContain(T value) {
        process(!compare.contains(value), "Collection contains {}, {}", value, compare);
    }
    
    public void isEmpty() {
        process(compare.isEmpty(), "Collection is not empty, {}", compare);
    }
    
    public void isNotEmpty() {
        process(!compare.isEmpty(), "Collection is empty");
    }
    
    public void sizeIs(int size) {
        process(compare.size() == size, "Size is not {} == {}", size, compare.size());
    }
    
    public void sizeIsNot(int size) {
        process(compare.size() != size, "Size is {} != {}", size, compare.size());
    }
}
