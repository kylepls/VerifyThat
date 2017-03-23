package in.kyle.api.verify.types;

import java.util.Collection;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class CollectionPredicate<T> extends Predicate<Collection<T>> {
    
    public CollectionPredicate(Collection<T> compare) {
        super(compare);
    }
    
    public Result contains(T value) {
        return result(compare.contains(value),
                      "Collection does not contain {}, {}",
                      value,
                      compare);
    }
    
    public Result doesNotContain(T value) {
        return result(!compare.contains(value), "Collection contains {}, {}", value, compare);
    }
    
    public Result isEmpty() {
        return result(compare.isEmpty(), "Collection is not empty, {}", compare);
    }
    
    public Result isNotEmpty() {
        return result(!compare.isEmpty(), "Collection is empty");
    }
    
    public Result sizeIs(int size) {
        return result(compare.size() == size, "Size is not {} == {}", size, compare.size());
    }
    
    public Result sizeIsNot(int size) {
        return result(compare.size() != size, "Size is {} != {}", size, compare.size());
    }
}
