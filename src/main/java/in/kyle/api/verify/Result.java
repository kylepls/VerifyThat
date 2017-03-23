package in.kyle.api.verify;

import java.util.Arrays;
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
            ComparisionException comparisionException = new ComparisionException(send);
            StackTraceElement[] stackTrace = comparisionException.getStackTrace();
            String fileName;
            while ((fileName = stackTrace[0].getFileName()) == null ||
                   "Result.java".equals(fileName) || ("Predicate.java".equals(fileName)) &&
                                                     "result".equals(stackTrace[0].getMethodName
                                                             ())) {
                stackTrace = Arrays.copyOfRange(stackTrace, 1, stackTrace.length);
            }
            comparisionException.setStackTrace(stackTrace);
            return comparisionException;
        });
    }
    
    
    @SneakyThrows
    public void error(Supplier<Exception> exception) {
        if (result) {
            throw exception.get();
        }
    }
}
