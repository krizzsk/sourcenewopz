package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk */
    private CramerShoupPublicKeyParameters f6136pk;

    /* renamed from: x1 */
    private BigInteger f6137x1;

    /* renamed from: x2 */
    private BigInteger f6138x2;

    /* renamed from: y1 */
    private BigInteger f6139y1;

    /* renamed from: y2 */
    private BigInteger f6140y2;

    /* renamed from: z */
    private BigInteger f6141z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f6137x1 = bigInteger;
        this.f6138x2 = bigInteger2;
        this.f6139y1 = bigInteger3;
        this.f6140y2 = bigInteger4;
        this.f6141z = bigInteger5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f6137x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f6138x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f6139y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.f6140y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.f6141z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f6136pk;
    }

    public BigInteger getX1() {
        return this.f6137x1;
    }

    public BigInteger getX2() {
        return this.f6138x2;
    }

    public BigInteger getY1() {
        return this.f6139y1;
    }

    public BigInteger getY2() {
        return this.f6140y2;
    }

    public BigInteger getZ() {
        return this.f6141z;
    }

    public int hashCode() {
        return ((((this.f6137x1.hashCode() ^ this.f6138x2.hashCode()) ^ this.f6139y1.hashCode()) ^ this.f6140y2.hashCode()) ^ this.f6141z.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f6136pk = cramerShoupPublicKeyParameters;
    }
}
