package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.ECGOST */
public final class ECGOST extends setLocationDataConsentGiven implements getExtendedData {

    /* renamed from: a */
    private final byte[] f2400a;

    ECGOST(byte[] bArr) {
        this.f2400a = bArr;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof ECGOST)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2400a, ((ECGOST) setlocationdataconsentgiven).f2400a);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2400a.length) + 1 + this.f2400a.length;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2400a);
    }

    public final String init() {
        return setAnimation.cca_continue(this.f2400a);
    }

    public final String toString() {
        return init();
    }

    /* renamed from: com.cardinalcommerce.a.ECGOST$Mappings */
    public final class Mappings extends setUiType {
        public static final Mappings Cardinal = new Mappings();
        private static final byte[] cca_continue = new byte[0];

        /* access modifiers changed from: package-private */
        public final boolean Cardinal() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final int configure() {
            return 2;
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = cca_continue;
            setenabledfsync.configure(5);
            setenabledfsync.Cardinal(bArr.length);
            setenabledfsync.getInstance.write(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.f2400a;
        setenabledfsync.configure(18);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
