package com.google.p217ar.core.exceptions;

/* renamed from: com.google.ar.core.exceptions.FatalException */
public class FatalException extends RuntimeException {
    public FatalException() {
    }

    public FatalException(String str) {
        super(str);
    }

    public FatalException(String str, Throwable th) {
        super(str, th);
    }
}
