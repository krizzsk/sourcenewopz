package com.didi.sdk.event;

public class StoreException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public StoreException(String str) {
        super(str);
    }

    public StoreException(Throwable th) {
        super(th);
    }

    public StoreException(String str, Throwable th) {
        super(str, th);
    }
}
