package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GOST;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.GM */
public final class C1944GM implements isLocationDataConsentGiven {

    /* renamed from: a */
    private DSASigner.dsaSha3_384 f2436a;

    public C1944GM(DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2436a = dsasha3_384;
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        return new GOST.Mappings(this.f2436a.configure(), (byte) 0);
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            throw new setUICustomization(e.getMessage(), e);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GM$Mappings */
    public final class Mappings extends setLocationDataConsentGiven implements getExtendedData {
        private final byte[] Cardinal;

        Mappings(byte[] bArr) {
            this.Cardinal = bArr;
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
            return setForegroundTintBlendMode.Cardinal(this.Cardinal, ((Mappings) setlocationdataconsentgiven).Cardinal);
        }

        /* access modifiers changed from: package-private */
        public final int configure() {
            return KeyAgreementSpi.Cardinal(this.Cardinal.length) + 1 + this.Cardinal.length;
        }

        public final int hashCode() {
            return setForegroundTintBlendMode.init(this.Cardinal);
        }

        public final String init() {
            return setAnimation.cca_continue(this.Cardinal);
        }

        public final String toString() {
            return init();
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = this.Cardinal;
            setenabledfsync.configure(19);
            setenabledfsync.Cardinal(bArr.length);
            setenabledfsync.getInstance.write(bArr);
        }
    }
}
