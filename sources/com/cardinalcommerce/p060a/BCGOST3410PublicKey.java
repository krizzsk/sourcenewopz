package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.BCGOST3410PublicKey */
public class BCGOST3410PublicKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public BigInteger cca_continue;
    public CipherSpi.OAEPPadding configure;
    public BigInteger getInstance;
    public BigInteger init;

    public BCGOST3410PublicKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.cca_continue = bigInteger3;
        this.init = bigInteger;
        this.getInstance = bigInteger2;
    }

    public BCGOST3410PublicKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, CipherSpi.OAEPPadding oAEPPadding) {
        this.cca_continue = bigInteger3;
        this.init = bigInteger;
        this.getInstance = bigInteger2;
        this.configure = oAEPPadding;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCGOST3410PublicKey)) {
            return false;
        }
        BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) obj;
        if (!bCGOST3410PublicKey.init.equals(this.init) || !bCGOST3410PublicKey.getInstance.equals(this.getInstance) || !bCGOST3410PublicKey.cca_continue.equals(this.cca_continue)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.init.hashCode() ^ this.getInstance.hashCode()) ^ this.cca_continue.hashCode();
    }
}
