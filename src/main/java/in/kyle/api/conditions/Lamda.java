package in.kyle.api.conditions;

/**
 * Created by Kyle on 3/23/2017.
 */
public class Lamda {
    public interface ThrowableSupplier<T> {
        T get() throws Throwable;
    }
    
    public interface ThrowableRunnable {
        void run() throws Throwable;
    }
}
