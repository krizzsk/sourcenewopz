package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setEnableDFSync;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.writeObject */
public final class writeObject extends getType {
    public writeObject(boolean z, int i, getProxyAddress getproxyaddress) {
        super(z, i, getproxyaddress);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        if (this.f2585a) {
            return true;
        }
        return this.getInstance.values().getWarnings().Cardinal();
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        int a;
        int configure = this.getInstance.values().getWarnings().configure();
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
        setLocationDataConsentGiven warnings = this.getInstance.values().getWarnings();
        int i = 160;
        if (this.f2585a) {
            setenabledfsync.cca_continue(160, this.Cardinal);
            setenabledfsync.Cardinal(warnings.configure());
            setenabledfsync.init(warnings);
            return;
        }
        if (!warnings.Cardinal()) {
            i = 128;
        }
        setenabledfsync.cca_continue(i, this.Cardinal);
        if (warnings != null) {
            warnings.cca_continue(new setEnableDFSync.Cardinal(setenabledfsync.getInstance));
            return;
        }
        throw new IOException("null object detected");
    }
}
