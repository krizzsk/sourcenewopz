package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setOnCheckedChangeListener */
public final class setOnCheckedChangeListener extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2890a = setCCAOnTouchListener.CardinalError;
    protected int[] getInstance;

    public setOnCheckedChangeListener(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2890a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.getInstance = setId.configure(bigInteger);
    }

    protected setOnCheckedChangeListener(int[] iArr) {
        this.getInstance = iArr;
    }

    public final BigInteger Cardinal() {
        return setScrollContainer.getInstance(this.getInstance);
    }

    public final boolean CardinalError() {
        return setScrollContainer.Cardinal(this.getInstance);
    }

    public final int cca_continue() {
        return f2890a.bitLength();
    }

    public final boolean cleanup() {
        return setScrollContainer.init(this.getInstance);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setOnCheckedChangeListener)) {
            return false;
        }
        return setScrollContainer.configure(this.getInstance, ((setOnCheckedChangeListener) obj).getInstance);
    }

    public final int hashCode() {
        return f2890a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.getInstance, 5);
    }

    public setOnCheckedChangeListener() {
        this.getInstance = new int[5];
    }

    public final boolean CardinalActionCode() {
        return (this.getInstance[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setId.getInstance(this.getInstance, ((setOnCheckedChangeListener) getacstransactionid).getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[5];
        setId.getInstance(this.getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setId.cca_continue(this.getInstance, ((setOnCheckedChangeListener) getacstransactionid).getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setId.init(this.getInstance, ((setOnCheckedChangeListener) getacstransactionid).getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setAccessibilityTraversalAfter.getInstance(setId.f2806a, ((setOnCheckedChangeListener) getacstransactionid).getInstance, iArr);
        setId.init(iArr, this.getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[5];
        setId.Cardinal(this.getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[5];
        setId.cca_continue(this.getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[5];
        setAccessibilityTraversalAfter.getInstance(setId.f2806a, this.getInstance, iArr);
        return new setOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.getInstance;
        if (setScrollContainer.init(iArr) || setScrollContainer.Cardinal(iArr)) {
            return this;
        }
        int[] iArr2 = new int[5];
        setId.cca_continue(iArr, iArr2);
        setId.init(iArr2, iArr, iArr2);
        int[] iArr3 = new int[5];
        setId.cca_continue(iArr2, iArr3);
        setId.init(iArr3, iArr, iArr3);
        int[] iArr4 = new int[5];
        setId.cca_continue(iArr3, iArr4);
        setId.init(iArr4, iArr, iArr4);
        int[] iArr5 = new int[5];
        setId.init(iArr4, 3, iArr5);
        setId.init(iArr5, iArr3, iArr5);
        setId.init(iArr5, 7, iArr4);
        setId.init(iArr4, iArr5, iArr4);
        setId.init(iArr4, 3, iArr5);
        setId.init(iArr5, iArr3, iArr5);
        int[] iArr6 = new int[5];
        setId.init(iArr5, 14, iArr6);
        setId.init(iArr6, iArr4, iArr6);
        setId.init(iArr6, 31, iArr4);
        setId.init(iArr4, iArr6, iArr4);
        setId.init(iArr4, 62, iArr6);
        setId.init(iArr6, iArr4, iArr6);
        setId.init(iArr6, 3, iArr4);
        setId.init(iArr4, iArr3, iArr4);
        setId.init(iArr4, 18, iArr4);
        setId.init(iArr4, iArr5, iArr4);
        setId.init(iArr4, 2, iArr4);
        setId.init(iArr4, iArr, iArr4);
        setId.init(iArr4, 3, iArr4);
        setId.init(iArr4, iArr2, iArr4);
        setId.init(iArr4, 6, iArr4);
        setId.init(iArr4, iArr3, iArr4);
        setId.init(iArr4, 2, iArr4);
        setId.init(iArr4, iArr, iArr4);
        setId.cca_continue(iArr4, iArr2);
        if (setScrollContainer.configure(iArr, iArr2)) {
            return new setOnCheckedChangeListener(iArr4);
        }
        return null;
    }
}
