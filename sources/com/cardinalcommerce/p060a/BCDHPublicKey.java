package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.Enumeration;

/* renamed from: com.cardinalcommerce.a.BCDHPublicKey */
public final class BCDHPublicKey extends isEnableLogging {
    private int init = -1;

    public BCDHPublicKey() {
    }

    public BCDHPublicKey(getProxyAddress getproxyaddress) {
        super(getproxyaddress);
    }

    public BCDHPublicKey(setForegroundTintBlendMode setforegroundtintblendmode) {
        super(setforegroundtintblendmode, false);
    }

    public BCDHPublicKey(getProxyAddress[] getproxyaddressArr) {
        super(getproxyaddressArr);
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        int cca_continue = cca_continue();
        return KeyAgreementSpi.Cardinal(cca_continue) + 1 + cca_continue;
    }

    private int cca_continue() throws IOException {
        if (this.init < 0) {
            int i = 0;
            Enumeration elements = this.cca_continue.elements();
            while (elements.hasMoreElements()) {
                i += ((getProxyAddress) elements.nextElement()).values().getWarnings().configure();
            }
            this.init = i;
        }
        return this.init;
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setEnableDFSync init2 = setenabledfsync.init();
        int cca_continue = cca_continue();
        setenabledfsync.configure(49);
        setenabledfsync.Cardinal(cca_continue);
        Enumeration elements = this.cca_continue.elements();
        while (elements.hasMoreElements()) {
            init2.init((getProxyAddress) elements.nextElement());
        }
    }
}
