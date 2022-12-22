package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.getEnvironment */
public final class getEnvironment extends IOException {
    private Throwable Cardinal;

    public getEnvironment(String str) {
        super(str);
    }

    public getEnvironment(String str, Throwable th) {
        super(str);
        this.Cardinal = th;
    }

    public final Throwable getCause() {
        return this.Cardinal;
    }
}
