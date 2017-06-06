package in.kyle.api.verify.types;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import in.kyle.api.verify.Verify;

/**
 * Created by Kyle on 6/6/2017.
 */
public class MapPredicateTest {
    
    private Map<String, Integer> map = Maps.<String, Integer>start().kv("a", 1).make();
    
    @Test
    public void testContainsKey() {
        Verify.that(map).containsKey("a");
    }
    
    @Test(expected = Exception.class)
    public void testContainsKeyError() {
        Verify.that(map).containsKey("b");
    }
    
    @Test
    public void testNotContainsKey() {
        Verify.that(map).notContainsKey("b");
    }
    
    @Test(expected = Exception.class)
    public void testNotContainsKeyError() {
        Verify.that(map).notContainsKey("a");
    }
    
    @Test
    public void testContainsValue() {
        Verify.that(map).containsValue(1);
    }
    
    @Test(expected = Exception.class)
    public void testContainsValueError() {
        Verify.that(map).containsValue(2);
    }
    
    @Test
    public void testNotContainsValue() {
        Verify.that(map).notContainsValue(2);
    }
    
    @Test(expected = Exception.class)
    public void testNotContainsValueError() {
        Verify.that(map).notContainsValue(1);
    }
    
    @Test
    public void testContainsKeyValue() {
        Verify.that(map).containsKeyValue("a", 1);
    }
    
    @Test(expected = Exception.class)
    public void testContainsKeyValueError() {
        Verify.that(map).containsKeyValue("b", 1);
    }
    
    @Test
    public void testNotContainsKeyValue() {
        Verify.that(map).notContainsKeyValue("a", 2);
    }
    
    @Test(expected = Exception.class)
    public void testNotContainsKeyValueError() {
        Verify.that(map).notContainsKeyValue("a", 1);
    }
    
    private static class Maps<K, V> {
        private final Map<K, V> map;
        
        private Maps() {
            this.map = new HashMap<>();
        }
        
        public Maps<K, V> kv(K k, V v) {
            map.put(k, v);
            return this;
        }
        
        public Map<K, V> make() {
            return map;
        }
        
        public static <K, V> Maps<K, V> start() {
            return new Maps<>();
        }
    }
}
