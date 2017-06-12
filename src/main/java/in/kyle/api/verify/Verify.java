package in.kyle.api.verify;

import java.util.Collection;
import java.util.Map;

import in.kyle.api.verify.types.ArrayPredicate;
import in.kyle.api.verify.types.BooleanPredicate;
import in.kyle.api.verify.types.ClassPredicate;
import in.kyle.api.verify.types.CollectionPredicate;
import in.kyle.api.verify.types.MapPredicate;
import in.kyle.api.verify.types.NumberPredicate;
import in.kyle.api.verify.types.ObjectPredicate;
import in.kyle.api.verify.types.RunnablePredicate;
import in.kyle.api.verify.types.StringPredicate;
import in.kyle.api.verify.types.ThrowablePredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public enum Verify {
    ;
    
    public static <T> ArrayPredicate<T> that(T[] array) {
        return new ArrayPredicate<>(array);
    }
    
    public static BooleanPredicate that(boolean bool) {
        return new BooleanPredicate(bool);
    }
    
    public static ClassPredicate that(Class clazz) {
        return new ClassPredicate(clazz);
    }
    
    public static <T> CollectionPredicate<T> that(Collection<T> collection) {
        return new CollectionPredicate<>(collection);
    }
    
    public static NumberPredicate that(Number number) {
        return new NumberPredicate(number);
    }
    
    public static RunnablePredicate that(Lamda.ThrowableRunnable runnable) {
        return new RunnablePredicate(runnable);
    }
    
    public static StringPredicate that(String string) {
        return new StringPredicate(string);
    }
    
    public static ObjectPredicate that(Object object) {
        return new ObjectPredicate(object);
    }
    
    public static ThrowablePredicate that(Throwable t) {
        return new ThrowablePredicate(t);
    }
    
    public static <K, V> MapPredicate<K, V> that(Map<K, V> map) {
        return new MapPredicate<>(map);
    }
}
