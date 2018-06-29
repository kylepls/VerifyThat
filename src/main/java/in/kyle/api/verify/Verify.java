package in.kyle.api.verify;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import in.kyle.api.verify.types.*;
import in.kyle.api.verify.types.reflect.ClassPredicate;

public final class Verify extends PrimitivesVerify {
    
    private Verify() {
    }
    
    public static <T> ArrayPredicate<T> that(T[] array) {
        return new ArrayPredicate<>(array);
    }
    
    public static BooleanPredicate that(boolean bool) {
        return new BooleanPredicate(bool);
    }
    
    public static ClassPredicate that(Class<?> clazz) {
        return new ClassPredicate(clazz);
    }
    
    public static <T> CollectionPredicate<T> that(Collection<T> collection) {
        return new CollectionPredicate<>(collection);
    }
    
    public static NumberPredicate that(Number number) {
        return new NumberPredicate(number);
    }
    
    public static RunnablePredicate that(ThrowableRunnable runnable) {
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
    
    public static InputStreamPredicate that(InputStream in) {
        return new InputStreamPredicate(in);
    }
    
    public static <T> OptionalPredicate<T> that(Optional<T> optional) {
        return new OptionalPredicate<>(optional);
    }
    
    //    Java Generics sucks sometimes
    
    
    public interface ThrowableRunnable {
        void run() throws Throwable;
    }
}
