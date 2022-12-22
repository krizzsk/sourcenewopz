package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.Enumeration;

/* renamed from: com.cardinalcommerce.a.CardinalValidateReceiver */
public final class CardinalValidateReceiver extends isEnableLogging {
    public CardinalValidateReceiver() {
    }

    public CardinalValidateReceiver(getProxyAddress getproxyaddress) {
        super(getproxyaddress);
    }

    public CardinalValidateReceiver(setForegroundTintBlendMode setforegroundtintblendmode) {
        super(setforegroundtintblendmode, false);
    }

    public CardinalValidateReceiver(getProxyAddress[] getproxyaddressArr) {
        super(getproxyaddressArr);
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        Enumeration elements = this.cca_continue.elements();
        int i = 0;
        while (elements.hasMoreElements()) {
            i += ((getProxyAddress) elements.nextElement()).values().configure();
        }
        return i + 2 + 2;
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setenabledfsync.configure(49);
        setenabledfsync.configure(128);
        Enumeration elements = this.cca_continue.elements();
        while (elements.hasMoreElements()) {
            setenabledfsync.init((getProxyAddress) elements.nextElement());
        }
        setenabledfsync.configure(0);
        setenabledfsync.configure(0);
    }
}
