package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import java.util.Random;

/* renamed from: com.cardinalcommerce.a.setImageResource */
public final class setImageResource extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2816a = setCCAImageBitmap.CardinalError;
    protected int[] cca_continue;

    public setImageResource(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2816a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.cca_continue = setCCAImageIcon.getInstance(bigInteger);
    }

    protected setImageResource(int[] iArr) {
        this.cca_continue = iArr;
    }

    /* renamed from: a */
    private static void m1998a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        setCCAImageIcon.configure(iArr2, iArr, iArr2);
        setCCAImageIcon.cca_continue(iArr2, iArr2);
        setCCAImageIcon.configure(iArr, iArr4);
        setCCAImageIcon.init(iArr3, iArr4, iArr);
        setCCAImageIcon.configure(iArr3, iArr4, iArr3);
        setCCAImageIcon.cca_continue(setDrawingCacheQuality.getInstance(7, iArr3, 0), iArr3);
    }

    public final BigInteger Cardinal() {
        return setNextFocusDownId.init(this.cca_continue);
    }

    public final boolean CardinalError() {
        return setNextFocusDownId.getInstance(this.cca_continue);
    }

    public final int cca_continue() {
        return f2816a.bitLength();
    }

    public final boolean cleanup() {
        return setNextFocusDownId.cca_continue(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setImageResource)) {
            return false;
        }
        return setNextFocusDownId.Cardinal(this.cca_continue, ((setImageResource) obj).cca_continue);
    }

    public final int hashCode() {
        return f2816a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.cca_continue, 7);
    }

    public setImageResource() {
        this.cca_continue = new int[7];
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[7];
        setCCAImageIcon.init(this.cca_continue, ((setImageResource) getacstransactionid).cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[7];
        setCCAImageIcon.Cardinal(this.cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[7];
        setCCAImageIcon.cca_continue(this.cca_continue, ((setImageResource) getacstransactionid).cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[7];
        setCCAImageIcon.configure(this.cca_continue, ((setImageResource) getacstransactionid).cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[7];
        setAccessibilityTraversalAfter.getInstance(setCCAImageIcon.f2720a, ((setImageResource) getacstransactionid).cca_continue, iArr);
        setCCAImageIcon.configure(iArr, this.cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[7];
        setCCAImageIcon.getInstance(this.cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[7];
        setCCAImageIcon.configure(this.cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[7];
        setAccessibilityTraversalAfter.getInstance(setCCAImageIcon.f2720a, this.cca_continue, iArr);
        return new setImageResource(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.cca_continue;
        if (setNextFocusDownId.cca_continue(iArr) || setNextFocusDownId.getInstance(iArr)) {
            return this;
        }
        int[] iArr2 = new int[7];
        setCCAImageIcon.getInstance(iArr, iArr2);
        int[] iArr3 = setCCAImageIcon.f2720a;
        int length = iArr3.length;
        Random random = new Random();
        int[] iArr4 = new int[length];
        int i = length - 1;
        int i2 = iArr3[i];
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        do {
            for (int i8 = 0; i8 != length; i8++) {
                iArr4[i8] = random.nextInt();
            }
            iArr4[i] = iArr4[i] & i7;
        } while (setDrawingCacheQuality.init(length, iArr4, iArr3));
        int[] iArr5 = new int[7];
        if (!m1999a(iArr)) {
            return null;
        }
        while (!m2000a(iArr2, iArr4, iArr5)) {
            setCCAImageIcon.Cardinal(iArr4, iArr4);
        }
        setCCAImageIcon.configure(iArr5, iArr4);
        if (setNextFocusDownId.Cardinal(iArr, iArr4)) {
            return new setImageResource(iArr5);
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m1999a(int[] iArr) {
        int[] iArr2 = new int[7];
        int[] iArr3 = new int[7];
        setNextFocusDownId.init(iArr, iArr2);
        for (int i = 0; i < 7; i++) {
            setNextFocusDownId.init(iArr2, iArr3);
            setCCAImageIcon.cca_continue(iArr2, 1 << i, iArr2);
            setCCAImageIcon.configure(iArr2, iArr3, iArr2);
        }
        setCCAImageIcon.cca_continue(iArr2, 95, iArr2);
        return setNextFocusDownId.getInstance(iArr2);
    }

    /* renamed from: a */
    private static boolean m2000a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[7];
        setNextFocusDownId.init(iArr2, iArr4);
        int[] iArr5 = new int[7];
        iArr5[0] = 1;
        int[] iArr6 = new int[7];
        setNextFocusDownId.init(iArr, iArr6);
        int[] iArr7 = new int[7];
        int[] iArr8 = new int[7];
        for (int i = 0; i < 7; i++) {
            setNextFocusDownId.init(iArr4, iArr7);
            setNextFocusDownId.init(iArr5, iArr8);
            int i2 = 1 << i;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                m1998a(iArr4, iArr5, iArr6, iArr3);
            }
            setCCAImageIcon.configure(iArr5, iArr8, iArr3);
            setCCAImageIcon.configure(iArr3, iArr, iArr3);
            setCCAImageIcon.configure(iArr4, iArr7, iArr6);
            setCCAImageIcon.init(iArr6, iArr3, iArr6);
            setCCAImageIcon.configure(iArr4, iArr8, iArr3);
            setNextFocusDownId.init(iArr6, iArr4);
            setCCAImageIcon.configure(iArr5, iArr7, iArr5);
            setCCAImageIcon.init(iArr5, iArr3, iArr5);
            setCCAImageIcon.configure(iArr5, iArr6);
            setCCAImageIcon.configure(iArr6, iArr, iArr6);
        }
        int[] iArr9 = new int[7];
        int[] iArr10 = new int[7];
        for (int i3 = 1; i3 < 96; i3++) {
            setNextFocusDownId.init(iArr4, iArr9);
            setNextFocusDownId.init(iArr5, iArr10);
            m1998a(iArr4, iArr5, iArr6, iArr3);
            if (setNextFocusDownId.cca_continue(iArr4)) {
                setAccessibilityTraversalAfter.getInstance(setCCAImageIcon.f2720a, iArr10, iArr3);
                setCCAImageIcon.configure(iArr3, iArr9, iArr3);
                return true;
            }
        }
        return false;
    }
}
