package in.kyle.api.verify.types;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;

public class InputStreamPredicate extends Predicate<InputStream, InputStreamPredicate> {
    
    public InputStreamPredicate(InputStream compare) {
        super(compare);
    }
    
    /**
     * Reads all the bytes from the stream by calling the {@link InputStream#read()} method
     * Throws a RuntimeException if there was an exception reading from the stream
     *
     * @return - The byte array read from the stream
     */
    public ArrayPredicate<Byte> readAll() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        copyStream(compare, baos);
        return Verify.that(baos.toByteArray());
    }
    
    private void copyStream(InputStream in, OutputStream out) {
        byte[] buffer = new byte[1024];
        int j;
        try {
            while ((j = in.read(buffer)) != -1) {
                out.write(buffer, 0, j);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
