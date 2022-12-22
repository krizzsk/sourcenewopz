package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.AlgorithmParametersSpi */
public final class AlgorithmParametersSpi extends getString {

    /* renamed from: com.cardinalcommerce.a.AlgorithmParametersSpi$PSS */
    public final class PSS extends ElGamalUtil {
        public BigInteger init;

        public PSS(BigInteger bigInteger, BCGOST3410PublicKey bCGOST3410PublicKey) {
            super(true, bCGOST3410PublicKey);
            this.init = bigInteger;
        }
    }

    public AlgorithmParametersSpi(byte[] bArr, int i) {
        super(bArr, i);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.cca_continue.length + 1) + 1 + this.cca_continue.length + 1;
    }

    /* renamed from: com.cardinalcommerce.a.AlgorithmParametersSpi$OAEP */
    public final class OAEP extends GOST3410Util {
        public BCGOST3410PublicKey Cardinal;

        public OAEP(SecureRandom secureRandom, BCGOST3410PublicKey bCGOST3410PublicKey) {
            super(secureRandom, bCGOST3410PublicKey.init.bitLength() - 1);
            this.Cardinal = bCGOST3410PublicKey;
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.cca_continue;
        int length = bArr.length + 1;
        byte[] bArr2 = new byte[length];
        bArr2[0] = (byte) cleanup();
        System.arraycopy(bArr, 0, bArr2, 1, length - 1);
        setenabledfsync.configure(3);
        setenabledfsync.Cardinal(length);
        setenabledfsync.getInstance.write(bArr2);
    }
}
