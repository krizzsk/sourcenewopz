package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setBorderWidth */
public final class setBorderWidth extends getAcsTransactionID.getInstance {
    protected long[] Cardinal;

    public setBorderWidth(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.Cardinal = getBorderColor.configure(bigInteger);
    }

    protected setBorderWidth(long[] jArr) {
        this.Cardinal = jArr;
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        return cca_continue(getacstransactionid);
    }

    public final BigInteger Cardinal() {
        return setNextFocusLeftId.cca_continue(this.Cardinal);
    }

    public final boolean CardinalActionCode() {
        return (this.Cardinal[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setNextFocusLeftId.init(this.Cardinal);
    }

    public final int cca_continue() {
        return 193;
    }

    public final boolean cleanup() {
        return setNextFocusLeftId.configure(this.Cardinal);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setBorderWidth)) {
            return false;
        }
        return setNextFocusLeftId.init(this.Cardinal, ((setBorderWidth) obj).Cardinal);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.Cardinal, 4) ^ 1930015;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public setBorderWidth() {
        this.Cardinal = new long[4];
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = this.Cardinal;
        long[] jArr2 = ((setBorderWidth) getacstransactionid).Cardinal;
        return new setBorderWidth(new long[]{jArr[0] ^ jArr2[0], jArr[1] ^ jArr2[1], jArr[2] ^ jArr2[2], jArr[3] ^ jArr2[3]});
    }

    public final getAcsTransactionID init() {
        long[] jArr = this.Cardinal;
        return new setBorderWidth(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        getBorderColor.Cardinal(this.Cardinal, ((setBorderWidth) getacstransactionid).Cardinal, jArr2);
        getBorderColor.getInstance(jArr2, jArr);
        return new setBorderWidth(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.Cardinal;
        long[] jArr2 = ((setBorderWidth) getacstransactionid).Cardinal;
        long[] jArr3 = ((setBorderWidth) getacstransactionid2).Cardinal;
        long[] jArr4 = ((setBorderWidth) getacstransactionid3).Cardinal;
        long[] jArr5 = new long[8];
        long[] jArr6 = new long[8];
        getBorderColor.Cardinal(jArr, jArr2, jArr6);
        getBorderColor.getInstance(jArr5, jArr6, jArr5);
        long[] jArr7 = new long[8];
        getBorderColor.Cardinal(jArr3, jArr4, jArr7);
        getBorderColor.getInstance(jArr5, jArr7, jArr5);
        long[] jArr8 = new long[4];
        getBorderColor.getInstance(jArr5, jArr8);
        return new setBorderWidth(jArr8);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        getBorderColor.Cardinal(this.Cardinal, ((setBorderWidth) getacstransactionid.getSDKVersion()).Cardinal, jArr2);
        getBorderColor.getInstance(jArr2, jArr);
        return new setBorderWidth(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        getBorderColor.Cardinal(this.Cardinal, jArr2);
        getBorderColor.getInstance(jArr2, jArr);
        return new setBorderWidth(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.Cardinal;
        long[] jArr2 = ((setBorderWidth) getacstransactionid).Cardinal;
        long[] jArr3 = ((setBorderWidth) getacstransactionid2).Cardinal;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        getBorderColor.Cardinal(jArr, jArr5);
        getBorderColor.getInstance(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        getBorderColor.Cardinal(jArr2, jArr3, jArr6);
        getBorderColor.getInstance(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        getBorderColor.getInstance(jArr4, jArr7);
        return new setBorderWidth(jArr7);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[4];
        getBorderColor.Cardinal(this.Cardinal, i, jArr);
        return new setBorderWidth(jArr);
    }

    public final int CardinalRenderType() {
        return ((int) this.Cardinal[0]) & 1;
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[4];
        long[] jArr2 = this.Cardinal;
        if (!setNextFocusLeftId.configure(jArr2)) {
            long[] jArr3 = new long[4];
            long[] jArr4 = new long[4];
            long[] jArr5 = new long[8];
            getBorderColor.Cardinal(jArr2, jArr5);
            getBorderColor.getInstance(jArr5, jArr3);
            getBorderColor.Cardinal(jArr3, 1, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr4, 1, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr3, 3, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr3, 6, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr3, 12, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr3, 24, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr3, 48, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr3);
            getBorderColor.Cardinal(jArr3, 96, jArr4);
            getBorderColor.configure(jArr3, jArr4, jArr);
            return new setBorderWidth(jArr);
        }
        throw new IllegalStateException();
    }

    public final getAcsTransactionID values() {
        long[] jArr = this.Cardinal;
        long configure = setLabelFor.configure(jArr[0]);
        long configure2 = setLabelFor.configure(jArr[1]);
        long j = (configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32);
        long j2 = (configure >>> 32) | (configure2 & -4294967296L);
        long configure3 = setLabelFor.configure(jArr[2]);
        long j3 = configure3 >>> 32;
        return new setBorderWidth(new long[]{j ^ (j2 << 8), (((j3 << 8) ^ ((configure3 & InternalZipConstants.ZIP_64_SIZE_LIMIT) ^ (jArr[3] << 32))) ^ (j2 >>> 56)) ^ (j2 << 33), ((j3 >>> 56) ^ (j3 << 33)) ^ (j2 >>> 31), j3 >>> 31});
    }
}
