package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c */
    private BigInteger f6142c;

    /* renamed from: d */
    private BigInteger f6143d;

    /* renamed from: h */
    private BigInteger f6144h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f6142c = bigInteger;
        this.f6143d = bigInteger2;
        this.f6144h = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f6142c) && cramerShoupPublicKeyParameters.getD().equals(this.f6143d) && cramerShoupPublicKeyParameters.getH().equals(this.f6144h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f6142c;
    }

    public BigInteger getD() {
        return this.f6143d;
    }

    public BigInteger getH() {
        return this.f6144h;
    }

    public int hashCode() {
        return ((this.f6142c.hashCode() ^ this.f6143d.hashCode()) ^ this.f6144h.hashCode()) ^ super.hashCode();
    }
}
