package org.apache.commons.p071io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BrokenInputStream */
public class BrokenInputStream extends InputStream {
    private final IOException exception;

    public BrokenInputStream(IOException iOException) {
        this.exception = iOException;
    }

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }

    public int read() throws IOException {
        throw this.exception;
    }

    public int available() throws IOException {
        throw this.exception;
    }

    public long skip(long j) throws IOException {
        throw this.exception;
    }

    public void reset() throws IOException {
        throw this.exception;
    }

    public void close() throws IOException {
        throw this.exception;
    }
}
