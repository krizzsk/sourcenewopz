package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.Enumeration;

/* renamed from: com.cardinalcommerce.a.onValidated */
public final class onValidated extends getType {
    public onValidated(boolean z, int i, getProxyAddress getproxyaddress) {
        super(z, i, getproxyaddress);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        if (this.f2585a) {
            return true;
        }
        return this.getInstance.values().getSDKVersion().Cardinal();
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        int a;
        int configure = this.getInstance.values().configure();
        if (this.f2585a) {
            a = KeyAgreementSpi.m1817a(this.Cardinal) + KeyAgreementSpi.Cardinal(configure);
        } else {
            configure--;
            a = KeyAgreementSpi.m1817a(this.Cardinal);
        }
        return a + configure;
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        Enumeration enumeration;
        setenabledfsync.cca_continue(160, this.Cardinal);
        setenabledfsync.configure(128);
        if (!this.f2585a) {
            if (this.getInstance instanceof isEnableDFSync) {
                enumeration = this.getInstance instanceof getErrorNumber ? ((getErrorNumber) this.getInstance).CardinalError() : new getErrorNumber(((isEnableDFSync) this.getInstance).cca_continue()).CardinalError();
            } else if (this.getInstance instanceof setThreeDSRequestorAppURL) {
                enumeration = ((setThreeDSRequestorAppURL) this.getInstance).cca_continue();
            } else if (this.getInstance instanceof isEnableLogging) {
                enumeration = ((isEnableLogging) this.getInstance).cca_continue.elements();
            } else {
                StringBuilder sb = new StringBuilder("not implemented: ");
                sb.append(this.getInstance.getClass().getName());
                throw new getEnvironment(sb.toString());
            }
            while (enumeration.hasMoreElements()) {
                setenabledfsync.init((getProxyAddress) enumeration.nextElement());
            }
        } else {
            setenabledfsync.init(this.getInstance);
        }
        setenabledfsync.configure(0);
        setenabledfsync.configure(0);
    }
}
