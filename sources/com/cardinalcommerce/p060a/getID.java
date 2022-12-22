package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getID */
public final class getID extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2563a = setCCAPadding.getWarnings;
    protected int[] configure;

    public getID(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2563a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.configure = ErrorMessage.getInstance(bigInteger);
    }

    protected getID(int[] iArr) {
        this.configure = iArr;
    }

    public final BigInteger Cardinal() {
        return setNextFocusLeftId.Cardinal(this.configure);
    }

    public final boolean CardinalError() {
        return setNextFocusLeftId.configure(this.configure);
    }

    public final int cca_continue() {
        return f2563a.bitLength();
    }

    public final boolean cleanup() {
        return setNextFocusLeftId.getInstance(this.configure);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof getID)) {
            return false;
        }
        return setNextFocusLeftId.Cardinal(this.configure, ((getID) obj).configure);
    }

    public final int hashCode() {
        return f2563a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.configure, 8);
    }

    public getID() {
        this.configure = new int[8];
    }

    public final boolean CardinalActionCode() {
        return (this.configure[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        ErrorMessage.getInstance(this.configure, ((getID) getacstransactionid).configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[8];
        ErrorMessage.init(this.configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        ErrorMessage.configure(this.configure, ((getID) getacstransactionid).configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        ErrorMessage.Cardinal(this.configure, ((getID) getacstransactionid).configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        setAccessibilityTraversalAfter.getInstance(ErrorMessage.f2434a, ((getID) getacstransactionid).configure, iArr);
        ErrorMessage.Cardinal(iArr, this.configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[8];
        ErrorMessage.cca_continue(this.configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[8];
        ErrorMessage.configure(this.configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[8];
        setAccessibilityTraversalAfter.getInstance(ErrorMessage.f2434a, this.configure, iArr);
        return new getID(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.configure;
        if (setNextFocusLeftId.getInstance(iArr) || setNextFocusLeftId.configure(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        int[] iArr3 = new int[8];
        ErrorMessage.configure(iArr, iArr2);
        ErrorMessage.Cardinal(iArr2, iArr, iArr2);
        ErrorMessage.Cardinal(iArr2, 2, iArr3);
        ErrorMessage.Cardinal(iArr3, iArr2, iArr3);
        ErrorMessage.Cardinal(iArr3, 4, iArr2);
        ErrorMessage.Cardinal(iArr2, iArr3, iArr2);
        ErrorMessage.Cardinal(iArr2, 8, iArr3);
        ErrorMessage.Cardinal(iArr3, iArr2, iArr3);
        ErrorMessage.Cardinal(iArr3, 16, iArr2);
        ErrorMessage.Cardinal(iArr2, iArr3, iArr2);
        ErrorMessage.Cardinal(iArr2, 32, iArr2);
        ErrorMessage.Cardinal(iArr2, iArr, iArr2);
        ErrorMessage.Cardinal(iArr2, 96, iArr2);
        ErrorMessage.Cardinal(iArr2, iArr, iArr2);
        ErrorMessage.Cardinal(iArr2, 94, iArr2);
        ErrorMessage.configure(iArr2, iArr3);
        if (setNextFocusLeftId.Cardinal(iArr, iArr3)) {
            return new getID(iArr2);
        }
        return null;
    }
}
