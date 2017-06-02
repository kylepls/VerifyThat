package in.kyle.api.verify;

import java.util.Arrays;

import in.kyle.api.verify.utils.StringUtils;
import lombok.Data;

/**
 * Created by Kyle on 3/23/2017.
 */
@Data
public abstract class Predicate<T> {
    
    protected final T compare;
    
    public void isNotNull() {
        process(compare != null, "Value is null: {}", compare);
    }
    
    public void isNull() {
        process(compare == null, "Value is not null: {}", compare);
    }
    
    public void isEqual(T t) {
        isNotNull();
        process(compare.equals(t), "Values are not equal {} != {}", compare, t);
    }
    
    public void isNotEqual(T t) {
        isNotNull();
        process(!compare.equals(t), "Value is not equal {} not equal {}", compare, t);
    }
    
    public void isSame(T t) {
        isNotNull();
        process(compare == t, "Value is same {} == {}", compare, t);
    }
    
    public void isNotSame(T t) {
        isNotNull();
        process(compare != t, "Value is different {} != {}", compare, t);
    }
    
    public void isInstanceOf(Class<?> clazz) {
        isNotNull();
        process(clazz.isInstance(compare), "Value is instance of {}", clazz.getName());
    }
    
    public void isNotInstanceOf(Class<?> clazz) {
        isNotNull();
        process(!clazz.isInstance(compare), "Value not instance of {}", clazz.getName());
    }
    
    public void isExactType(Class<?> clazz) {
        isNotNull();
        process(clazz.equals(compare.getClass()),
                "Value class not {}, but instead {}",
                clazz.getName(),
                compare.getClass().getName());
    }
    
    public void isNotExactType(Class<?> clazz) {
        isNotNull();
        process(!clazz.equals(compare.getClass()),
                "Value is not class {}, but instead {}",
                compare.getClass().getName());
    }
    
    protected void process(boolean condition, String errorMessage, Object... vars) {
        if (!condition) {
            error(errorMessage, vars);
        }
    }
    
    private void error(String message, Object... vars) {
        String send = StringUtils.replaceVariables(message, vars);
        ComparisionException comparisionException = new ComparisionException(send);
        StackTraceElement[] stackTrace = comparisionException.getStackTrace();
        String fileName;
        while ((fileName = stackTrace[0].getFileName()) == null || "void.java".equals(fileName) ||
               ("Predicate.java".equals(fileName)) &&
               "result".equals(stackTrace[0].getMethodName())) {
            stackTrace = Arrays.copyOfRange(stackTrace, 1, stackTrace.length);
        }
        comparisionException.setStackTrace(stackTrace);
        throw comparisionException;
    }
}
