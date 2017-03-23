package in.kyle.api.conditions;

import in.kyle.api.conditions.utils.StringUtils;
import lombok.Data;

/**
 * Created by Kyle on 3/23/2017.
 */
@Data
public abstract class Predicate<T> {
    
    protected final T compare;
    
    public Result isNotNull() {
        return result(compare != null, "Value is not null: {}", compare);
    }
    
    public Result isNull() {
        return result(compare == null, "Value is null: {}", compare);
    }
    
    public Result isEqual(T t) {
        return result(compare.equals(t), "Value is equal {} equals {}", compare, t);
    }
    
    public Result isNotEqual(T t) {
        return result(!compare.equals(t), "Value is not equal {} not equal {}", compare, t);
    }
    
    public Result isSame(T t) {
        return result(compare == t, "Value is same {} == {}", compare, t);
    }
    
    public Result isNotSame(T t) {
        return result(compare != t, "Value is different {} != {}", compare, t);
    }
    
    public Result isInstanceOf(Class<?> clazz) {
        return result(clazz.isInstance(compare), "Value is instance of {}", clazz.getName());
    }
    
    public Result isNotInstanceOf(Class<?> clazz) {
        return result(!clazz.isInstance(compare), "Value not instance of {}", clazz.getName());
    }
    
    public Result isExactType(Class<?> clazz) {
        return result(clazz.equals(compare.getClass()),
                      "Value class not {}, but instead {}",
                      clazz.getName(),
                      compare.getClass().getName());
    }
    
    public Result isNotExactType(Class<?> clazz) {
        return result(!clazz.equals(compare.getClass()),
                      "Value is not class {}, but instead {}",
                      compare.getClass().getName());
    }
    
    protected static Result result(boolean bool, String errorMessage, Object... vars) {
        return new Result(!bool, StringUtils.replaceVariables(errorMessage, vars));
    }
}
