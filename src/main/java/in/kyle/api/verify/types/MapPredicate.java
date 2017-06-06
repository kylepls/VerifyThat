package in.kyle.api.verify.types;

import java.util.Collection;
import java.util.Map;

import in.kyle.api.verify.types.iterable.IterablePredicate;

/**
 * Created by Kyle on 6/6/2017.
 */
public class MapPredicate<K, V> extends IterablePredicate<V, Collection<V>> {
    
    private final Map<K, V> compare;
    
    public MapPredicate(Map<K, V> compare) {
        super(compare.values());
        
        this.compare = compare;
    }
    
    public void containsKey(K key) {
        process(compare.containsKey(key), "Map does not contain key {}, map: {}", key, compare);
    }
    
    public void notContainsKey(K key) {
        process(!compare.containsKey(key), "Map contains key {}, map: {}", key, compare);
    }
    
    public void containsValue(V value) {
        process(compare.containsValue(value),
                "Map does not contain value {}, map: {}",
                value,
                compare);
    }
    
    public void notContainsValue(V value) {
        process(!compare.containsValue(value), "Map contains value {}, map: {}", value, compare);
    }
    
    public void containsKeyValue(K key, V value) {
        containsKey(key);
        containsValue(value);
        process(compare.get(key).equals(value),
                "Map does not contain ({}:{}), map: {}",
                key,
                value,
                compare);
    }
    
    public void notContainsKeyValue(K key, V value) {
        V v = compare.get(key);
        process(!v.equals(value), "Map does contain ({}:{}), map: {}", key, value, compare);
    }
}
