package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setEnableDFSync;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.RSA */
public final class RSA extends getType {
    public RSA(getProxyAddress getproxyaddress) {
        super(true, 0, getproxyaddress);
    }

    public RSA(boolean z, int i, getProxyAddress getproxyaddress) {
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
        int configure = this.getInstance.values().getSDKVersion().configure();
        if (this.f2585a) {
            a = KeyAgreementSpi.m1817a(this.Cardinal) + KeyAgreementSpi.Cardinal(configure);
        } else {
            configure--;
            a = KeyAgreementSpi.m1817a(this.Cardinal);
        }
        return a + configure;
    }

    /* renamed from: com.cardinalcommerce.a.RSA$Mappings */
    public final class Mappings extends setLocationDataConsentGiven implements getExtendedData {
        private final byte[] configure;

        Mappings(byte[] bArr) {
            this.configure = bArr;
        }

        /* access modifiers changed from: package-private */
        public final boolean Cardinal() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
            if (!(setlocationdataconsentgiven instanceof Mappings)) {
                return false;
            }
            return setForegroundTintBlendMode.Cardinal(this.configure, ((Mappings) setlocationdataconsentgiven).configure);
        }

        /* access modifiers changed from: package-private */
        public final int configure() throws IOException {
            return KeyAgreementSpi.Cardinal(this.configure.length) + 1 + this.configure.length;
        }

        public final int hashCode() {
            return setForegroundTintBlendMode.init(this.configure);
        }

        public final String init() {
            return setAnimation.init(this.configure);
        }

        public final String toString() {
            return init();
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = this.configure;
            setenabledfsync.configure(12);
            setenabledfsync.Cardinal(bArr.length);
            setenabledfsync.getInstance.write(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setLocationDataConsentGiven sDKVersion = this.getInstance.values().getSDKVersion();
        int i = 160;
        if (this.f2585a) {
            setenabledfsync.cca_continue(160, this.Cardinal);
            setenabledfsync.Cardinal(sDKVersion.configure());
            setenabledfsync.init(sDKVersion);
            return;
        }
        if (!sDKVersion.Cardinal()) {
            i = 128;
        }
        setenabledfsync.cca_continue(i, this.Cardinal);
        if (sDKVersion != null) {
            sDKVersion.cca_continue(new setEnableDFSync.Cardinal(setenabledfsync.getInstance));
            return;
        }
        throw new IOException("null object detected");
    }
}
