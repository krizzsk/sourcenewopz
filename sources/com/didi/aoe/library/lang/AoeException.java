package com.didi.aoe.library.lang;

public class AoeException extends Exception {
    public AoeException() {
    }

    public AoeException(String str) {
        super(str);
    }

    public AoeException(String str, Throwable th) {
        super(str, th);
    }

    public AoeException(Throwable th) {
        super(th);
    }
}
