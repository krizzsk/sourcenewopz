package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getErrorDetails */
public final class getErrorDetails extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2555a = getMessage.CardinalError;
    protected int[] configure;

    public getErrorDetails(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2555a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.configure = getTransactionID.cca_continue(bigInteger);
    }

    protected getErrorDetails(int[] iArr) {
        this.configure = iArr;
    }

    public final BigInteger Cardinal() {
        return setDrawingCacheQuality.Cardinal(12, this.configure);
    }

    public final boolean CardinalError() {
        return setDrawingCacheQuality.configure(12, this.configure);
    }

    public final int cca_continue() {
        return f2555a.bitLength();
    }

    public final boolean cleanup() {
        return setDrawingCacheQuality.init(12, this.configure);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof getErrorDetails)) {
            return false;
        }
        return setDrawingCacheQuality.Cardinal(12, this.configure, ((getErrorDetails) obj).configure);
    }

    public final int hashCode() {
        return f2555a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.configure, 12);
    }

    public getErrorDetails() {
        this.configure = new int[12];
    }

    public final boolean CardinalActionCode() {
        return (this.configure[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[12];
        getTransactionID.getInstance(this.configure, ((getErrorDetails) getacstransactionid).configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[12];
        getTransactionID.configure(this.configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[12];
        getTransactionID.init(this.configure, ((getErrorDetails) getacstransactionid).configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[12];
        getTransactionID.Cardinal(this.configure, ((getErrorDetails) getacstransactionid).configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[12];
        setAccessibilityTraversalAfter.getInstance(getTransactionID.f2582a, ((getErrorDetails) getacstransactionid).configure, iArr);
        getTransactionID.Cardinal(iArr, this.configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[12];
        getTransactionID.getInstance(this.configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[12];
        getTransactionID.init(this.configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[12];
        setAccessibilityTraversalAfter.getInstance(getTransactionID.f2582a, this.configure, iArr);
        return new getErrorDetails(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.configure;
        if (setDrawingCacheQuality.init(12, iArr) || setDrawingCacheQuality.configure(12, iArr)) {
            return this;
        }
        int[] iArr2 = new int[12];
        int[] iArr3 = new int[12];
        int[] iArr4 = new int[12];
        int[] iArr5 = new int[12];
        getTransactionID.init(iArr, iArr2);
        getTransactionID.Cardinal(iArr2, iArr, iArr2);
        getTransactionID.getInstance(iArr2, 2, iArr3);
        getTransactionID.Cardinal(iArr3, iArr2, iArr3);
        getTransactionID.init(iArr3, iArr3);
        getTransactionID.Cardinal(iArr3, iArr, iArr3);
        getTransactionID.getInstance(iArr3, 5, iArr4);
        getTransactionID.Cardinal(iArr4, iArr3, iArr4);
        getTransactionID.getInstance(iArr4, 5, iArr5);
        getTransactionID.Cardinal(iArr5, iArr3, iArr5);
        getTransactionID.getInstance(iArr5, 15, iArr3);
        getTransactionID.Cardinal(iArr3, iArr5, iArr3);
        getTransactionID.getInstance(iArr3, 2, iArr4);
        getTransactionID.Cardinal(iArr2, iArr4, iArr2);
        getTransactionID.getInstance(iArr4, 28, iArr4);
        getTransactionID.Cardinal(iArr3, iArr4, iArr3);
        getTransactionID.getInstance(iArr3, 60, iArr4);
        getTransactionID.Cardinal(iArr4, iArr3, iArr4);
        getTransactionID.getInstance(iArr4, 120, iArr3);
        getTransactionID.Cardinal(iArr3, iArr4, iArr3);
        getTransactionID.getInstance(iArr3, 15, iArr3);
        getTransactionID.Cardinal(iArr3, iArr5, iArr3);
        getTransactionID.getInstance(iArr3, 33, iArr3);
        getTransactionID.Cardinal(iArr3, iArr2, iArr3);
        getTransactionID.getInstance(iArr3, 64, iArr3);
        getTransactionID.Cardinal(iArr3, iArr, iArr3);
        getTransactionID.getInstance(iArr3, 30, iArr2);
        getTransactionID.init(iArr2, iArr3);
        if (setDrawingCacheQuality.Cardinal(12, iArr, iArr3)) {
            return new getErrorDetails(iArr2);
        }
        return null;
    }
}
