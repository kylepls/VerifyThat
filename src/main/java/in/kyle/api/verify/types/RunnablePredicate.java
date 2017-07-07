package in.kyle.api.verify.types;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

public class RunnablePredicate extends Predicate<Verify.ThrowableRunnable, RunnablePredicate> {
    
    private long timeout;
    private TimeUnit unit;
    
    public RunnablePredicate(Verify.ThrowableRunnable compare) {
        super(compare);
        this.timeout = -1;
        this.unit = TimeUnit.MILLISECONDS;
    }
    
    public RunnablePredicate timeout(long timeout, TimeUnit unit) {
        this.timeout = timeout;
        this.unit = unit;
        return this;
    }
    
    public ThrowablePredicate throwsException(Class<? extends Throwable> expected) {
        isNotNull();
        Optional<Throwable> throwableOptional = runInTime();
        
        process(throwableOptional.isPresent(),
                "catch exception " + expected.getName(),
                "did not throw exception");
        
        Throwable throwable = throwableOptional.get();
        process(throwable.getClass().equals(expected), "exception == " + expected, throwable);
        
        //        if (!throwable.getClass().equals(expected)) {
        //            StringWriter writer = new StringWriter();
        //            PrintWriter printWriter = new PrintWriter(writer);
        //            throwable.printStackTrace(printWriter);
        //            throw error("Caught unknown exception\n{}", writer.getBuffer().toString());
        //        } 
        
        return Verify.that(throwable);
    }
    
    public void doesNotThrowException() {
        isNotNull();
        Optional<Throwable> throwableOptional = runInTime();
        process(!throwableOptional.isPresent(), "no exception", throwableOptional);
    }
    
    private Optional<Throwable> runInTime() {
        long effectiveTimeout = timeout != -1 ? timeout : Long.MAX_VALUE;
        ExecutorService service = Executors.newSingleThreadExecutor();
        AtomicReference<Throwable> error = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);
        service.submit(() -> {
            try {
                compare.run();
            } catch (Throwable throwable) {
                error.set(throwable);
            } finally {
                latch.countDown();
            }
        });
        
        boolean await;
        try {
            await = latch.await(effectiveTimeout, unit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        process(await, "duration < " + timeout + " " + unit, "duration > x");
        return Optional.ofNullable(error.get());
    }
}
