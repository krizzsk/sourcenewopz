package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.IESCipher;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.EC */
public final class C1943EC {

    /* renamed from: a */
    private static setThreeDSRequestorAppURL f2397a = new GOST();

    /* renamed from: b */
    private static isEnableLogging f2398b = new GOST.Mappings();

    C1943EC() {
    }

    /* renamed from: com.cardinalcommerce.a.EC$Mappings */
    public final class Mappings extends setLocationDataConsentGiven implements getExtendedData {
        private final byte[] init;

        public Mappings(byte[] bArr) {
            this.init = setForegroundTintBlendMode.cca_continue(bArr);
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
            return setForegroundTintBlendMode.Cardinal(this.init, ((Mappings) setlocationdataconsentgiven).init);
        }

        /* access modifiers changed from: package-private */
        public final int configure() {
            return KeyAgreementSpi.Cardinal(this.init.length) + 1 + this.init.length;
        }

        public final int hashCode() {
            return setForegroundTintBlendMode.init(this.init);
        }

        public final String init() {
            return setAnimation.cca_continue(this.init);
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = this.init;
            setenabledfsync.configure(25);
            setenabledfsync.Cardinal(bArr.length);
            setenabledfsync.getInstance.write(bArr);
        }
    }

    public static setThreeDSRequestorAppURL getInstance(setForegroundTintBlendMode setforegroundtintblendmode) {
        return setforegroundtintblendmode.cca_continue.size() <= 0 ? f2397a : new IESCipher.IESwithAESCBC(setforegroundtintblendmode);
    }

    /* renamed from: a */
    static isEnableLogging m1801a(setForegroundTintBlendMode setforegroundtintblendmode) {
        return setforegroundtintblendmode.cca_continue.size() <= 0 ? f2398b : new BCDHPublicKey(setforegroundtintblendmode);
    }
}
