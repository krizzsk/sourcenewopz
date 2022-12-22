package com.didi.aoe.library.lang;

public class AoeIOException extends AoeException {
    public AoeIOException() {
    }

    public AoeIOException(String str) {
        super(str);
    }

    public AoeIOException(String str, Throwable th) {
        super(str, th);
    }

    public AoeIOException(Throwable th) {
        super(th);
    }
}
