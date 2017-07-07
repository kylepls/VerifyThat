package in.kyle.api.verify.types;

import java.util.Collection;
import java.util.Map;

import in.kyle.api.verify.types.iterable.IterablePredicate;

public class MapPredicate<K, V> extends IterablePredicate<V, Collection<V>, MapPredicate<K, V>> {
    
    private final Map<K, V> compare;
    
    public MapPredicate(Map<K, V> compare) {
        super(compare.values());
        
        this.compare = compare;
    }
    
    public MapPredicate<K, V> containsKey(K key) {
        process(compare.containsKey(key), compare + " containsKey " + key, false);
        return this;
    }
    
    public MapPredicate<K, V> notContainsKey(K key) {
        process(!compare.containsKey(key), compare + " notContainsKey " + key, false);
        return this;
    }
    
    public MapPredicate<K, V> containsValue(V value) {
        process(compare.containsValue(value), compare + " containsValue " + value, false);
        return this;
    }
    
    public MapPredicate<K, V> notContainsValue(V value) {
        process(!compare.containsValue(value), compare + " notContainsValue " + value, false);
        return this;
    }
    
    public MapPredicate<K, V> containsKeyValue(K key, V value) {
        containsKey(key);
        containsValue(value);
        process(compare.get(key).equals(value),
                compare + " containsPair (" + key + ":" + value + ")",
                false);
        return this;
    }
    
    public MapPredicate<K, V> notContainsKeyValue(K key, V value) {
        V v = compare.get(key);
        process(!v.equals(value), compare + " notContainsPair (" + key + ":" + value + ")", false);
        return this;
    }
}
