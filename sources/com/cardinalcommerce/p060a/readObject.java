package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.readObject */
public final class readObject extends setLocationDataConsentGiven implements getExtendedData {

    /* renamed from: a */
    private final byte[] f2636a;

    readObject(byte[] bArr) {
        this.f2636a = bArr;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof readObject)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2636a, ((readObject) setlocationdataconsentgiven).f2636a);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2636a.length) + 1 + this.f2636a.length;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2636a);
    }

    public final String init() {
        return setAnimation.cca_continue(this.f2636a);
    }

    public final String toString() {
        return init();
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.f2636a;
        setenabledfsync.configure(26);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
