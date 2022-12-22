package org.bouncycastle.util;

public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f6565_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f6565_e = th;
    }

    public Throwable getCause() {
        return this.f6565_e;
    }
}
