package in.kyle.api.verify;

import java.util.Arrays;

import in.kyle.api.verify.utils.StringUtils;

public abstract class Predicate<T, R extends Predicate<T, R>> {
    
    protected final T compare;
    protected String named;
    
    protected Predicate(T compare) {
        this.compare = compare;
    }
    
    protected Predicate(T compare, String named) {
        this.compare = compare;
        this.named = named;
    }
    
    private static void eraseFromStack(int calls, Throwable throwable) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        StackTraceElement[] elements = Arrays.copyOfRange(stackTrace, calls, stackTrace.length);
        throwable.setStackTrace(elements);
    }
    
    private static void eraseTopPackageFromStack(Throwable throwable) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        String packageName = getPackage(stackTrace[0].getClassName());
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            String p = getPackage(element.getClassName());
            if (!packageName.equals(p)) {
                eraseFromStack(i, throwable);
                break;
            }
        }
    }
    
    private static String getPackage(String fileName) {
        fileName = fileName.replace(".java", "");
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
    
    public R named(String message, Object... args) {
        named = StringUtils.replaceVariables(message, args);
        return (R) this;
    }
    
    public R isNotNull() {
        process(compare != null, "not null");
        return (R) this;
    }
    
    public R isNull() {
        process(compare == null, "null");
        return (R) this;
    }
    
    public R isEqual(T t) {
        isNotNull();
        process(compare.equals(t), "equals(" + t + ")", t);
        return (R) this;
    }
    
    public R isNotEqual(T t) {
        isNotNull();
        process(!compare.equals(t), "notEquals(" + t + ")", t);
        return (R) this;
    }
    
    public R isSame(T t) {
        isNotNull();
        process(compare == t, compare + " == " + t, t);
        return (R) this;
    }
    
    public R isNotSame(T t) {
        isNotNull();
        process(compare != t, compare + " != " + t, t);
        return (R) this;
    }
    
    public R isInstanceOf(Class<?> clazz) {
        isNotNull();
        process(clazz.isInstance(compare), clazz + " isInstance " + compare.getClass(), false);
        return (R) this;
    }
    
    public R isNotInstanceOf(Class<?> clazz) {
        isNotNull();
        process(!clazz.isInstance(compare), clazz + " isNotInstance " + compare.getClass(), false);
        return (R) this;
    }
    
    public R isExactType(Class<?> clazz) {
        isNotNull();
        Verify.that(compare.getClass()).isEqual(clazz);
        return (R) this;
    }
    
    public R isNotExactType(Class<?> clazz) {
        isNotNull();
        Verify.that(compare.getClass()).isNotEqual(clazz);
        return (R) this;
    }
    
    protected void process(boolean condition, String expected) {
        if (!condition) {
            throw error("Expected [" + expected + "] but got [" + compare + "]");
        }
    }
    
    protected void process(boolean condition, String expected, Object actual) {
        if (!condition) {
            throw error("Expected [" + expected + "] but got [" + actual + "]");
        }
    }
    
    protected ComparisionException error(String message, Object... vars) {
        String send = StringUtils.replaceVariables(message, vars);
        if (named != null) {
            send = "(" + named + ") " + send;
        }
        ComparisionException comparisionException = new ComparisionException(send);
        eraseTopPackageFromStack(comparisionException);
        return comparisionException;
    }
}
