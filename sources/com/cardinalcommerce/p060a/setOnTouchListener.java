package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setOnTouchListener */
public final class setOnTouchListener extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2909a = getProgressView.getWarnings;
    protected int[] Cardinal;

    public setOnTouchListener(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2909a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.Cardinal = setOnFocusChangeListener.Cardinal(bigInteger);
    }

    protected setOnTouchListener(int[] iArr) {
        this.Cardinal = iArr;
    }

    public final boolean CardinalError() {
        return setAccessibilityTraversalBefore.Cardinal(this.Cardinal);
    }

    public final int cca_continue() {
        return f2909a.bitLength();
    }

    public final boolean cleanup() {
        return setAccessibilityTraversalBefore.configure(this.Cardinal);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setOnTouchListener)) {
            return false;
        }
        return setAccessibilityTraversalBefore.configure(this.Cardinal, ((setOnTouchListener) obj).Cardinal);
    }

    public final int hashCode() {
        return f2909a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.Cardinal, 4);
    }

    public setOnTouchListener() {
        this.Cardinal = new int[4];
    }

    public final boolean CardinalActionCode() {
        return (this.Cardinal[0] & 1) == 1;
    }

    public final BigInteger Cardinal() {
        int[] iArr = this.Cardinal;
        byte[] bArr = new byte[16];
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                setMinimumWidth.getInstance(i2, bArr, (3 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[4];
        setOnFocusChangeListener.cca_continue(this.Cardinal, ((setOnTouchListener) getacstransactionid).Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[4];
        setOnFocusChangeListener.getInstance(this.Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[4];
        setOnFocusChangeListener.getInstance(this.Cardinal, ((setOnTouchListener) getacstransactionid).Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[4];
        setOnFocusChangeListener.init(this.Cardinal, ((setOnTouchListener) getacstransactionid).Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[4];
        setAccessibilityTraversalAfter.getInstance(setOnFocusChangeListener.f2901a, ((setOnTouchListener) getacstransactionid).Cardinal, iArr);
        setOnFocusChangeListener.init(iArr, this.Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[4];
        setOnFocusChangeListener.configure(this.Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[4];
        setOnFocusChangeListener.cca_continue(this.Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[4];
        setAccessibilityTraversalAfter.getInstance(setOnFocusChangeListener.f2901a, this.Cardinal, iArr);
        return new setOnTouchListener(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.Cardinal;
        if (setAccessibilityTraversalBefore.configure(iArr) || setAccessibilityTraversalBefore.Cardinal(iArr)) {
            return this;
        }
        int[] iArr2 = new int[4];
        setOnFocusChangeListener.cca_continue(iArr, iArr2);
        setOnFocusChangeListener.init(iArr2, iArr, iArr2);
        int[] iArr3 = new int[4];
        setOnFocusChangeListener.getInstance(iArr2, 2, iArr3);
        setOnFocusChangeListener.init(iArr3, iArr2, iArr3);
        int[] iArr4 = new int[4];
        setOnFocusChangeListener.getInstance(iArr3, 4, iArr4);
        setOnFocusChangeListener.init(iArr4, iArr3, iArr4);
        setOnFocusChangeListener.getInstance(iArr4, 2, iArr3);
        setOnFocusChangeListener.init(iArr3, iArr2, iArr3);
        setOnFocusChangeListener.getInstance(iArr3, 10, iArr2);
        setOnFocusChangeListener.init(iArr2, iArr3, iArr2);
        setOnFocusChangeListener.getInstance(iArr2, 10, iArr4);
        setOnFocusChangeListener.init(iArr4, iArr3, iArr4);
        setOnFocusChangeListener.cca_continue(iArr4, iArr3);
        setOnFocusChangeListener.init(iArr3, iArr, iArr3);
        setOnFocusChangeListener.getInstance(iArr3, 95, iArr3);
        setOnFocusChangeListener.cca_continue(iArr3, iArr4);
        if (setAccessibilityTraversalBefore.configure(iArr, iArr4)) {
            return new setOnTouchListener(iArr3);
        }
        return null;
    }
}
