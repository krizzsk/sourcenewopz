package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setButtonText */
public final class setButtonText extends getAcsTransactionID.getInstance {
    protected long[] cca_continue;

    public setButtonText(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.cca_continue = getButtonCustomization.init(bigInteger);
    }

    protected setButtonText(long[] jArr) {
        this.cca_continue = jArr;
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        return cca_continue(getacstransactionid);
    }

    public final BigInteger Cardinal() {
        return setNextFocusLeftId.cca_continue(this.cca_continue);
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setNextFocusLeftId.init(this.cca_continue);
    }

    public final int cca_continue() {
        return 239;
    }

    public final boolean cleanup() {
        return setNextFocusLeftId.configure(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setButtonText)) {
            return false;
        }
        return setNextFocusLeftId.init(this.cca_continue, ((setButtonText) obj).cca_continue);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.cca_continue, 4) ^ 23900158;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public setButtonText() {
        this.cca_continue = new long[4];
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((setButtonText) getacstransactionid).cca_continue;
        return new setButtonText(new long[]{jArr[0] ^ jArr2[0], jArr[1] ^ jArr2[1], jArr[2] ^ jArr2[2], jArr[3] ^ jArr2[3]});
    }

    public final getAcsTransactionID init() {
        long[] jArr = this.cca_continue;
        return new setButtonText(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        getButtonCustomization.m1888b(this.cca_continue, ((setButtonText) getacstransactionid).cca_continue, jArr2);
        getButtonCustomization.init(jArr2, jArr);
        return new setButtonText(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((setButtonText) getacstransactionid).cca_continue;
        long[] jArr3 = ((setButtonText) getacstransactionid2).cca_continue;
        long[] jArr4 = ((setButtonText) getacstransactionid3).cca_continue;
        long[] jArr5 = new long[8];
        long[] jArr6 = new long[8];
        getButtonCustomization.m1888b(jArr, jArr2, jArr6);
        getButtonCustomization.m1886a(jArr5, jArr6, jArr5);
        long[] jArr7 = new long[8];
        getButtonCustomization.m1888b(jArr3, jArr4, jArr7);
        getButtonCustomization.m1886a(jArr5, jArr7, jArr5);
        long[] jArr8 = new long[4];
        getButtonCustomization.init(jArr5, jArr8);
        return new setButtonText(jArr8);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        getButtonCustomization.m1888b(this.cca_continue, ((setButtonText) getacstransactionid.getSDKVersion()).cca_continue, jArr2);
        getButtonCustomization.init(jArr2, jArr);
        return new setButtonText(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        getButtonCustomization.m1885a(this.cca_continue, jArr2);
        getButtonCustomization.init(jArr2, jArr);
        return new setButtonText(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((setButtonText) getacstransactionid).cca_continue;
        long[] jArr3 = ((setButtonText) getacstransactionid2).cca_continue;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        getButtonCustomization.m1885a(jArr, jArr5);
        getButtonCustomization.m1886a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        getButtonCustomization.m1888b(jArr2, jArr3, jArr6);
        getButtonCustomization.m1886a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        getButtonCustomization.init(jArr4, jArr7);
        return new setButtonText(jArr7);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[4];
        getButtonCustomization.cca_continue(this.cca_continue, i, jArr);
        return new setButtonText(jArr);
    }

    public final int CardinalRenderType() {
        long[] jArr = this.cca_continue;
        return ((int) ((jArr[0] ^ (jArr[1] >>> 17)) ^ (jArr[2] >>> 34))) & 1;
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[4];
        long[] jArr2 = this.cca_continue;
        if (!setNextFocusLeftId.configure(jArr2)) {
            long[] jArr3 = new long[4];
            long[] jArr4 = new long[4];
            long[] jArr5 = new long[8];
            getButtonCustomization.m1885a(jArr2, jArr5);
            getButtonCustomization.init(jArr5, jArr3);
            getButtonCustomization.cca_continue(jArr3, jArr2, jArr3);
            long[] jArr6 = new long[8];
            getButtonCustomization.m1885a(jArr3, jArr6);
            getButtonCustomization.init(jArr6, jArr3);
            getButtonCustomization.cca_continue(jArr3, jArr2, jArr3);
            getButtonCustomization.cca_continue(jArr3, 3, jArr4);
            getButtonCustomization.cca_continue(jArr4, jArr3, jArr4);
            long[] jArr7 = new long[8];
            getButtonCustomization.m1885a(jArr4, jArr7);
            getButtonCustomization.init(jArr7, jArr4);
            getButtonCustomization.cca_continue(jArr4, jArr2, jArr4);
            getButtonCustomization.cca_continue(jArr4, 7, jArr3);
            getButtonCustomization.cca_continue(jArr3, jArr4, jArr3);
            getButtonCustomization.cca_continue(jArr3, 14, jArr4);
            getButtonCustomization.cca_continue(jArr4, jArr3, jArr4);
            long[] jArr8 = new long[8];
            getButtonCustomization.m1885a(jArr4, jArr8);
            getButtonCustomization.init(jArr8, jArr4);
            getButtonCustomization.cca_continue(jArr4, jArr2, jArr4);
            getButtonCustomization.cca_continue(jArr4, 29, jArr3);
            getButtonCustomization.cca_continue(jArr3, jArr4, jArr3);
            long[] jArr9 = new long[8];
            getButtonCustomization.m1885a(jArr3, jArr9);
            getButtonCustomization.init(jArr9, jArr3);
            getButtonCustomization.cca_continue(jArr3, jArr2, jArr3);
            getButtonCustomization.cca_continue(jArr3, 59, jArr4);
            getButtonCustomization.cca_continue(jArr4, jArr3, jArr4);
            long[] jArr10 = new long[8];
            getButtonCustomization.m1885a(jArr4, jArr10);
            getButtonCustomization.init(jArr10, jArr4);
            getButtonCustomization.cca_continue(jArr4, jArr2, jArr4);
            getButtonCustomization.cca_continue(jArr4, 119, jArr3);
            getButtonCustomization.cca_continue(jArr3, jArr4, jArr3);
            long[] jArr11 = new long[8];
            getButtonCustomization.m1885a(jArr3, jArr11);
            getButtonCustomization.init(jArr11, jArr);
            return new setButtonText(jArr);
        }
        throw new IllegalStateException();
    }

    public final getAcsTransactionID values() {
        long[] jArr = new long[4];
        long[] jArr2 = this.cca_continue;
        long configure = setLabelFor.configure(jArr2[0]);
        long configure2 = setLabelFor.configure(jArr2[1]);
        long j = (configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32);
        long j2 = (configure >>> 32) | (configure2 & -4294967296L);
        long configure3 = setLabelFor.configure(jArr2[2]);
        long configure4 = setLabelFor.configure(jArr2[3]);
        long j3 = (configure3 & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure4 << 32);
        long j4 = (configure3 >>> 32) | (configure4 & -4294967296L);
        long j5 = j4 >>> 49;
        long j6 = (j2 >>> 49) | (j4 << 15);
        long j7 = j4 ^ (j2 << 15);
        long[] jArr3 = new long[8];
        int[] iArr = {39, 120};
        int i = 0;
        for (int i2 = 2; i < i2; i2 = 2) {
            int i3 = iArr[i] >>> 6;
            int i4 = iArr[i] & 63;
            jArr3[i3] = jArr3[i3] ^ (j2 << i4);
            int i5 = i3 + 1;
            int i6 = -i4;
            jArr3[i5] = jArr3[i5] ^ ((j7 << i4) | (j2 >>> i6));
            int i7 = i3 + 2;
            jArr3[i7] = jArr3[i7] ^ ((j6 << i4) | (j7 >>> i6));
            int i8 = i3 + 3;
            jArr3[i8] = jArr3[i8] ^ ((j5 << i4) | (j6 >>> i6));
            int i9 = i3 + 4;
            jArr3[i9] = jArr3[i9] ^ (j5 >>> i6);
            i++;
        }
        getButtonCustomization.init(jArr3, jArr);
        jArr[0] = jArr[0] ^ j;
        jArr[1] = jArr[1] ^ j3;
        return new setButtonText(jArr);
    }
}
