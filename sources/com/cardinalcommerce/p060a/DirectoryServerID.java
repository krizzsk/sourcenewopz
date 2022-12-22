package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.DirectoryServerID */
public final class DirectoryServerID extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2396a = ButtonType.getWarnings;
    protected int[] configure;

    public DirectoryServerID(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2396a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.configure = getValue.getInstance(bigInteger);
    }

    protected DirectoryServerID(int[] iArr) {
        this.configure = iArr;
    }

    public final BigInteger Cardinal() {
        return setDrawingCacheQuality.Cardinal(17, this.configure);
    }

    public final boolean CardinalError() {
        return setDrawingCacheQuality.configure(17, this.configure);
    }

    public final int cca_continue() {
        return f2396a.bitLength();
    }

    public final boolean cleanup() {
        return setDrawingCacheQuality.init(17, this.configure);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DirectoryServerID)) {
            return false;
        }
        return setDrawingCacheQuality.Cardinal(17, this.configure, ((DirectoryServerID) obj).configure);
    }

    public final int hashCode() {
        return f2396a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.configure, 17);
    }

    public DirectoryServerID() {
        this.configure = new int[17];
    }

    public final boolean CardinalActionCode() {
        return (this.configure[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[17];
        getValue.cca_continue(this.configure, ((DirectoryServerID) getacstransactionid).configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[17];
        getValue.getInstance(this.configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[17];
        getValue.configure(this.configure, ((DirectoryServerID) getacstransactionid).configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[17];
        getValue.init(this.configure, ((DirectoryServerID) getacstransactionid).configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[17];
        setAccessibilityTraversalAfter.getInstance(getValue.f2589a, ((DirectoryServerID) getacstransactionid).configure, iArr);
        getValue.init(iArr, this.configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[17];
        getValue.Cardinal(this.configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[17];
        getValue.init(this.configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[17];
        setAccessibilityTraversalAfter.getInstance(getValue.f2589a, this.configure, iArr);
        return new DirectoryServerID(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.configure;
        if (setDrawingCacheQuality.init(17, iArr) || setDrawingCacheQuality.configure(17, iArr)) {
            return this;
        }
        int[] iArr2 = new int[17];
        int[] iArr3 = new int[17];
        getValue.getInstance(iArr, 519, iArr2);
        getValue.init(iArr2, iArr3);
        if (setDrawingCacheQuality.Cardinal(17, iArr, iArr3)) {
            return new DirectoryServerID(iArr2);
        }
        return null;
    }
}
