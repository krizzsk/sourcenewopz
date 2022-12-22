package com.microblink.blinkbarcode.view.exception;

/* compiled from: line */
public class CalledFromWrongThreadException extends RuntimeException {
    public CalledFromWrongThreadException(String str) {
        super(str);
    }

    public CalledFromWrongThreadException(String str, Throwable th) {
        super(str, th);
    }
}
