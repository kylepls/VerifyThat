package in.kyle.api.verify.types.iterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import in.kyle.api.verify.Predicate;

public abstract class IterablePredicate<V, T extends Iterable<V>, R extends IterablePredicate<V, 
T, R>>
        extends Predicate<T, R> {
    
    private Collection<V> collection;
    
    public IterablePredicate(T compare) {
        super(compare);
        this.collection = toCollection(compare);
    }
    
    public R isEmpty() {
        isNotNull();
        sizeIs(0);
        return (R) this;
    }
    
    public R isNotEmpty() {
        isNotNull();
        sizeIsNot(0);
        return (R) this;
    }
    
    public R sizeIs(int size) {
        isNotNull();
        process(getSize() == size, "size == " + size, getSize());
        return (R) this;
    }
    
    public R sizeIsNot(int size) {
        isNotNull();
        process(getSize() != size, "size != " + size, getSize());
        return (R) this;
    }
    
    public R sizeIsGreaterThan(int size) {
        isNotNull();
        process(getSize() > size, "size > " + size, getSize());
        return (R) this;
    }
    
    public R sizeIsLessThan(int size) {
        isNotNull();
        process(getSize() < size, "size < " + size, getSize());
        return (R) this;
    }
    
    public R contains(V v) {
        isNotNull();
        process(collection.contains(v), "contains " + v, collection);
        return (R) this;
    }
    
    public R notContains(V v) {
        isNotNull();
        process(!collection.contains(v), "notContains " + v, collection);
        return (R) this;
    }
    
    public R contains(V... values) {
        isNotNull();
        for (V temp : values) {
            contains(temp);
        }
        return (R) this;
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
