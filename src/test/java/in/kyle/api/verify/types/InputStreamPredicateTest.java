package in.kyle.api.verify.types;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import in.kyle.api.verify.Verify;

public class InputStreamPredicateTest {
    
    @Test
    public void testEmptyStream() {
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
        Verify.that(in).readAll().isEmpty();
    }
    
    @Test
    public void testSingleElementStream() {
        InputStream in = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Verify.that(in).readAll().arrayEquals((byte) 1, (byte) 2, (byte) 3);
    }
    
    @Test(expected = RuntimeException.class)
    public void testClosedStreamException() throws IOException {
        InputStream in = new ErrorStream();
        in.close();
        Verify.that(in).readAll();
    }
    
    class ErrorStream extends InputStream {
    
        @Override
        public int read() throws IOException {
            throw new IOException("Oh no :(");
        }
    }
}
