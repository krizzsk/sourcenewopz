package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.SDKRuntimeException */
public final class SDKRuntimeException extends getAcsTransactionID.getInstance {
    protected long[] init;

    public SDKRuntimeException(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.init = ButtonCustomization.init(bigInteger);
    }

    protected SDKRuntimeException(long[] jArr) {
        this.init = jArr;
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        return cca_continue(getacstransactionid);
    }

    public final boolean CardinalActionCode() {
        return (this.init[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setAccessibilityTraversalBefore.cca_continue(this.init);
    }

    public final int cca_continue() {
        return 113;
    }

    public final boolean cleanup() {
        return setAccessibilityTraversalBefore.Cardinal(this.init);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SDKRuntimeException)) {
            return false;
        }
        return setAccessibilityTraversalBefore.configure(this.init, ((SDKRuntimeException) obj).init);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.init, 2) ^ 113009;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public SDKRuntimeException() {
        this.init = new long[2];
    }

    public final BigInteger Cardinal() {
        long[] jArr = this.init;
        byte[] bArr = new byte[16];
        for (int i = 0; i < 2; i++) {
            long j = jArr[i];
            if (j != 0) {
                int i2 = (1 - i) << 3;
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i2);
                setMinimumWidth.getInstance((int) j, bArr, i2 + 4);
            }
        }
        return new BigInteger(1, bArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = this.init;
        long[] jArr2 = ((SDKRuntimeException) getacstransactionid).init;
        return new SDKRuntimeException(new long[]{jArr[0] ^ jArr2[0], jArr[1] ^ jArr2[1]});
    }

    public final getAcsTransactionID init() {
        long[] jArr = this.init;
        return new SDKRuntimeException(new long[]{jArr[0] ^ 1, jArr[1]});
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[2];
        long[] jArr2 = new long[4];
        ButtonCustomization.m1793b(this.init, ((SDKRuntimeException) getacstransactionid).init, jArr2);
        ButtonCustomization.configure(jArr2, jArr);
        return new SDKRuntimeException(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.init;
        long[] jArr2 = ((SDKRuntimeException) getacstransactionid).init;
        long[] jArr3 = ((SDKRuntimeException) getacstransactionid2).init;
        long[] jArr4 = ((SDKRuntimeException) getacstransactionid3).init;
        long[] jArr5 = new long[4];
        long[] jArr6 = new long[4];
        ButtonCustomization.m1793b(jArr, jArr2, jArr6);
        ButtonCustomization.m1790a(jArr5, jArr6, jArr5);
        long[] jArr7 = new long[4];
        ButtonCustomization.m1793b(jArr3, jArr4, jArr7);
        ButtonCustomization.m1790a(jArr5, jArr7, jArr5);
        long[] jArr8 = new long[2];
        ButtonCustomization.configure(jArr5, jArr8);
        return new SDKRuntimeException(jArr8);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[2];
        long[] jArr2 = new long[4];
        ButtonCustomization.m1793b(this.init, ((SDKRuntimeException) getacstransactionid.getSDKVersion()).init, jArr2);
        ButtonCustomization.configure(jArr2, jArr);
        return new SDKRuntimeException(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[2];
        long[] jArr2 = this.init;
        long[] jArr3 = new long[4];
        setLabelFor.cca_continue(jArr2[0], jArr3, 0);
        setLabelFor.cca_continue(jArr2[1], jArr3, 2);
        ButtonCustomization.configure(jArr3, jArr);
        return new SDKRuntimeException(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.init;
        long[] jArr2 = ((SDKRuntimeException) getacstransactionid).init;
        long[] jArr3 = ((SDKRuntimeException) getacstransactionid2).init;
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        setLabelFor.cca_continue(jArr[0], jArr5, 0);
        setLabelFor.cca_continue(jArr[1], jArr5, 2);
        ButtonCustomization.m1790a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[4];
        ButtonCustomization.m1793b(jArr2, jArr3, jArr6);
        ButtonCustomization.m1790a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[2];
        ButtonCustomization.configure(jArr4, jArr7);
        return new SDKRuntimeException(jArr7);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[2];
        ButtonCustomization.getInstance(this.init, i, jArr);
        return new SDKRuntimeException(jArr);
    }

    public final int CardinalRenderType() {
        return ((int) this.init[0]) & 1;
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[2];
        long[] jArr2 = this.init;
        if (!setAccessibilityTraversalBefore.Cardinal(jArr2)) {
            long[] jArr3 = new long[2];
            long[] jArr4 = new long[2];
            long[] jArr5 = new long[4];
            setLabelFor.cca_continue(jArr2[0], jArr5, 0);
            setLabelFor.cca_continue(jArr2[1], jArr5, 2);
            ButtonCustomization.configure(jArr5, jArr3);
            long[] jArr6 = new long[4];
            ButtonCustomization.m1793b(jArr3, jArr2, jArr6);
            ButtonCustomization.configure(jArr6, jArr3);
            long[] jArr7 = new long[4];
            setLabelFor.cca_continue(jArr3[0], jArr7, 0);
            setLabelFor.cca_continue(jArr3[1], jArr7, 2);
            ButtonCustomization.configure(jArr7, jArr3);
            long[] jArr8 = new long[4];
            ButtonCustomization.m1793b(jArr3, jArr2, jArr8);
            ButtonCustomization.configure(jArr8, jArr3);
            ButtonCustomization.getInstance(jArr3, 3, jArr4);
            long[] jArr9 = new long[4];
            ButtonCustomization.m1793b(jArr4, jArr3, jArr9);
            ButtonCustomization.configure(jArr9, jArr4);
            long[] jArr10 = new long[4];
            setLabelFor.cca_continue(jArr4[0], jArr10, 0);
            setLabelFor.cca_continue(jArr4[1], jArr10, 2);
            ButtonCustomization.configure(jArr10, jArr4);
            long[] jArr11 = new long[4];
            ButtonCustomization.m1793b(jArr4, jArr2, jArr11);
            ButtonCustomization.configure(jArr11, jArr4);
            ButtonCustomization.getInstance(jArr4, 7, jArr3);
            long[] jArr12 = new long[4];
            ButtonCustomization.m1793b(jArr3, jArr4, jArr12);
            ButtonCustomization.configure(jArr12, jArr3);
            ButtonCustomization.getInstance(jArr3, 14, jArr4);
            long[] jArr13 = new long[4];
            ButtonCustomization.m1793b(jArr4, jArr3, jArr13);
            ButtonCustomization.configure(jArr13, jArr4);
            ButtonCustomization.getInstance(jArr4, 28, jArr3);
            long[] jArr14 = new long[4];
            ButtonCustomization.m1793b(jArr3, jArr4, jArr14);
            ButtonCustomization.configure(jArr14, jArr3);
            ButtonCustomization.getInstance(jArr3, 56, jArr4);
            long[] jArr15 = new long[4];
            ButtonCustomization.m1793b(jArr4, jArr3, jArr15);
            ButtonCustomization.configure(jArr15, jArr4);
            long[] jArr16 = new long[4];
            setLabelFor.cca_continue(jArr4[0], jArr16, 0);
            setLabelFor.cca_continue(jArr4[1], jArr16, 2);
            ButtonCustomization.configure(jArr16, jArr);
            return new SDKRuntimeException(jArr);
        }
        throw new IllegalStateException();
    }

    public final getAcsTransactionID values() {
        long[] jArr = this.init;
        long configure = setLabelFor.configure(jArr[0]);
        long configure2 = setLabelFor.configure(jArr[1]);
        long j = (configure >>> 32) | (configure2 & -4294967296L);
        return new SDKRuntimeException(new long[]{((j << 57) ^ ((InternalZipConstants.ZIP_64_SIZE_LIMIT & configure) | (configure2 << 32))) ^ (j << 5), (j >>> 7) ^ (j >>> 59)});
    }
}
