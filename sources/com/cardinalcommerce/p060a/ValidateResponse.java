package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.Enumeration;

/* renamed from: com.cardinalcommerce.a.ValidateResponse */
public final class ValidateResponse extends setThreeDSRequestorAppURL {
    public ValidateResponse() {
    }

    public ValidateResponse(getProxyAddress getproxyaddress) {
        super(getproxyaddress);
    }

    public ValidateResponse(setForegroundTintBlendMode setforegroundtintblendmode) {
        super(setforegroundtintblendmode);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setenabledfsync.configure(48);
        setenabledfsync.configure(128);
        Enumeration cca_continue = cca_continue();
        while (cca_continue.hasMoreElements()) {
            setenabledfsync.init((getProxyAddress) cca_continue.nextElement());
        }
        setenabledfsync.configure(0);
        setenabledfsync.configure(0);
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        Enumeration cca_continue = cca_continue();
        int i = 0;
        while (cca_continue.hasMoreElements()) {
            i += ((getProxyAddress) cca_continue.nextElement()).values().configure();
        }
        return i + 2 + 2;
    }
}
