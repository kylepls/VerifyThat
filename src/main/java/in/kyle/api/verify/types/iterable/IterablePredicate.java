package in.kyle.api.verify.types.iterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 6/6/2017.
 */
public class IterablePredicate<V, T extends Iterable<V>> extends Predicate<T> {
    
    private Collection<V> collection;
    
    public IterablePredicate(T compare) {
        super(compare);
        this.collection = toCollection(compare);
    }
    
    public void isEmpty() {
        isNotNull();
        sizeIs(0);
    }
    
    public void isNotEmpty() {
        isNotNull();
        sizeIsNot(0);
    }
    
    public void sizeIs(int size) {
        isNotNull();
        process(getSize() == size, "Iterable size should be {}, instead got {}", size, getSize());
    }
    
    public void sizeIsNot(int size) {
        isNotNull();
        process(getSize() != size, "Iterable size should not be {}", size);
    }
    
    public void contains(V v) {
        isNotNull();
        process(collection.contains(v), "Array does not contain {}, {}", v, collection);
    }
    
    public void notContains(V v) {
        isNotNull();
        process(!collection.contains(v), "Array contains {}", v);
    }
    
    public void isEqual(Iterable<V> other) {
        isNotNull();
        Collection<V> otherCollection = toCollection(other);
        process(collection.equals(otherCollection), "Array {} != {}", compare, otherCollection);
    }
    
    public void isNotEqual(Iterable<V> other) {
        isNotNull();
        Collection<V> otherCollection = toCollection(other);
        process(!collection.equals(otherCollection), "Array {} == {}", compare, otherCollection);
    }
    
    private int getSize() {
        return (int) compare.spliterator().getExactSizeIfKnown();
    }
    
    private Collection<V> toCollection(Iterable<V> iterable) {
        Iterator<V> iterator = iterable.iterator();
        List<V> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}
