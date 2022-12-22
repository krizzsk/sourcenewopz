package org.bouncycastle.crypto.p076ec;

import org.bouncycastle.math.p082ec.ECPoint;

/* renamed from: org.bouncycastle.crypto.ec.ECPair */
public class ECPair {

    /* renamed from: x */
    private final ECPoint f5906x;

    /* renamed from: y */
    private final ECPoint f5907y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f5906x = eCPoint;
        this.f5907y = eCPoint2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.f5906x;
    }

    public ECPoint getY() {
        return this.f5907y;
    }

    public int hashCode() {
        return this.f5906x.hashCode() + (this.f5907y.hashCode() * 37);
    }
}
