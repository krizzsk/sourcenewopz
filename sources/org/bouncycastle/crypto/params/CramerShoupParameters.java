package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Memoable;

public class CramerShoupParameters implements CipherParameters {

    /* renamed from: H */
    private Digest f6132H;

    /* renamed from: g1 */
    private BigInteger f6133g1;

    /* renamed from: g2 */
    private BigInteger f6134g2;

    /* renamed from: p */
    private BigInteger f6135p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.f6135p = bigInteger;
        this.f6133g1 = bigInteger2;
        this.f6134g2 = bigInteger3;
        Digest digest2 = (Digest) ((Memoable) digest).copy();
        this.f6132H = digest2;
        digest2.reset();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        return cramerShoupParameters.getP().equals(this.f6135p) && cramerShoupParameters.getG1().equals(this.f6133g1) && cramerShoupParameters.getG2().equals(this.f6134g2);
    }

    public BigInteger getG1() {
        return this.f6133g1;
    }

    public BigInteger getG2() {
        return this.f6134g2;
    }

    public Digest getH() {
        return (Digest) ((Memoable) this.f6132H).copy();
    }

    public BigInteger getP() {
        return this.f6135p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }
}
