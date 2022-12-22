package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.DSTU4145 */
public final class DSTU4145 extends setLocationDataConsentGiven implements getExtendedData {

    /* renamed from: a */
    private final byte[] f2394a;

    DSTU4145(byte[] bArr) {
        this.f2394a = bArr;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof DSTU4145)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2394a, ((DSTU4145) setlocationdataconsentgiven).f2394a);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2394a.length) + 1 + this.f2394a.length;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2394a);
    }

    public final String init() {
        return setAnimation.cca_continue(this.f2394a);
    }

    public final String toString() {
        return init();
    }

    /* renamed from: com.cardinalcommerce.a.DSTU4145$Mappings */
    public final class Mappings extends setRenderType {
        public Mappings(byte[] bArr) {
            super(bArr);
        }

        private byte[] valueOf() {
            if (this.init[this.init.length - 1] != 90) {
                return this.init;
            }
            if (!cleanup()) {
                byte[] bArr = new byte[(this.init.length + 4)];
                System.arraycopy(this.init, 0, bArr, 0, this.init.length - 1);
                System.arraycopy(setAnimation.configure("0000Z"), 0, bArr, this.init.length - 1, 5);
                return bArr;
            } else if (!CardinalError()) {
                byte[] bArr2 = new byte[(this.init.length + 2)];
                System.arraycopy(this.init, 0, bArr2, 0, this.init.length - 1);
                System.arraycopy(setAnimation.configure("00Z"), 0, bArr2, this.init.length - 1, 3);
                return bArr2;
            } else if (!cca_continue()) {
                return this.init;
            } else {
                int length = this.init.length - 2;
                while (length > 0 && this.init[length] == 48) {
                    length--;
                }
                if (this.init[length] == 46) {
                    byte[] bArr3 = new byte[(length + 1)];
                    System.arraycopy(this.init, 0, bArr3, 0, length);
                    bArr3[length] = 90;
                    return bArr3;
                }
                byte[] bArr4 = new byte[(length + 2)];
                int i = length + 1;
                System.arraycopy(this.init, 0, bArr4, 0, i);
                bArr4[i] = 90;
                return bArr4;
            }
        }

        /* access modifiers changed from: package-private */
        public final int configure() {
            int length = valueOf().length;
            return KeyAgreementSpi.Cardinal(length) + 1 + length;
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] valueOf = valueOf();
            setenabledfsync.configure(24);
            setenabledfsync.Cardinal(valueOf.length);
            setenabledfsync.getInstance.write(valueOf);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.f2394a;
        setenabledfsync.configure(27);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
