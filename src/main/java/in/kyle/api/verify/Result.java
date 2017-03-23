package in.kyle.api.verify;

import java.util.function.Supplier;

import in.kyle.api.verify.utils.StringUtils;
import lombok.SneakyThrows;

/**
 * Created by Kyle on 3/23/2017.
 */
// TODO: 3/23/2017 Rethink 
public class Result {
    
    private final boolean result;
    private final String message;
    
    public Result(boolean result, String message) {
        this.result = result;
        this.message = message;
        error();
    }
    
    public void error() {
        if (result) {
            error(message);
        }
    }
    
    public void error(String message, Object... vars) {
        error(() -> {
            String send = StringUtils.replaceVariables(message, vars);
            return new ComparisionException(send);
        });
    }
    
    @SneakyThrows
    public void error(Supplier<Exception> exception) {
        if (result) {
            throw exception.get();
        }
    }
}
