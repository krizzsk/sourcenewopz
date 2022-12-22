package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cardinalcommerce.a.X509 */
public final class X509 extends setLocationDataConsentGiven implements getExtendedData {

    /* renamed from: a */
    private final byte[] f2490a;

    /* renamed from: com.cardinalcommerce.a.X509$Mappings */
    public final class Mappings extends setEnableDFSync {
        public Mappings(OutputStream outputStream) {
            super(outputStream);
        }

        public final void init(getProxyAddress getproxyaddress) throws IOException {
            if (getproxyaddress != null) {
                getproxyaddress.values().getWarnings().cca_continue(this);
                return;
            }
            throw new IOException("null object detected");
        }
    }

    public X509(byte[] bArr) {
        this.f2490a = setForegroundTintBlendMode.cca_continue(bArr);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof X509)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2490a, ((X509) setlocationdataconsentgiven).f2490a);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2490a.length) + 1 + this.f2490a.length;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2490a);
    }

    public final String init() {
        return setAnimation.cca_continue(this.f2490a);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.f2490a;
        setenabledfsync.configure(21);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
