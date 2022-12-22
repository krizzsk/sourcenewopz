package com.didi.quicksilver.ext;

public class ErrnoException extends Exception {
    public ErrnoException(Throwable th) {
        super(th);
    }
}
