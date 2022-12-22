package org.bouncycastle.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f6566_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f6566_e = th;
    }

    public Throwable getCause() {
        return this.f6566_e;
    }
}
