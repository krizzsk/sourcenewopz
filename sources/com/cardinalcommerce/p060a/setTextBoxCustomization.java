package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setTextBoxCustomization */
public final class setTextBoxCustomization extends getAcsTransactionID.getInstance {
    protected long[] init;

    public setTextBoxCustomization(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.init = getLabelCustomization.cca_continue(bigInteger);
    }

    protected setTextBoxCustomization(long[] jArr) {
        this.init = jArr;
    }

    public final boolean CardinalActionCode() {
        return (this.init[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setNextFocusUpId.Cardinal(this.init);
    }

    public final int CardinalRenderType() {
        return getLabelCustomization.configure(this.init);
    }

    public final int cca_continue() {
        return 283;
    }

    public final boolean cleanup() {
        return setNextFocusUpId.getInstance(this.init);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setTextBoxCustomization)) {
            return false;
        }
        return setNextFocusUpId.cca_continue(this.init, ((setTextBoxCustomization) obj).init);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.init, 5) ^ 2831275;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public setTextBoxCustomization() {
        this.init = new long[5];
    }

    public final BigInteger Cardinal() {
        long[] jArr = this.init;
        byte[] bArr = new byte[40];
        for (int i = 0; i < 5; i++) {
            long j = jArr[i];
            if (j != 0) {
                int i2 = (4 - i) << 3;
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i2);
                setMinimumWidth.getInstance((int) j, bArr, i2 + 4);
            }
        }
        return new BigInteger(1, bArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[5];
        getLabelCustomization.Cardinal(this.init, ((setTextBoxCustomization) getacstransactionid).init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID init() {
        long[] jArr = new long[5];
        getLabelCustomization.Cardinal(this.init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[5];
        getLabelCustomization.Cardinal(this.init, ((setTextBoxCustomization) getacstransactionid).init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[5];
        getLabelCustomization.configure(this.init, ((setTextBoxCustomization) getacstransactionid).init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.init;
        long[] jArr2 = ((setTextBoxCustomization) getacstransactionid).init;
        long[] jArr3 = ((setTextBoxCustomization) getacstransactionid2).init;
        long[] jArr4 = ((setTextBoxCustomization) getacstransactionid3).init;
        long[] jArr5 = new long[9];
        getLabelCustomization.init(jArr, jArr2, jArr5);
        getLabelCustomization.init(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[5];
        getLabelCustomization.cca_continue(jArr5, jArr6);
        return new setTextBoxCustomization(jArr6);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[5];
        getLabelCustomization.configure(this.init, ((setTextBoxCustomization) getacstransactionid.getSDKVersion()).init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[5];
        getLabelCustomization.getInstance(this.init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.init;
        long[] jArr2 = ((setTextBoxCustomization) getacstransactionid).init;
        long[] jArr3 = ((setTextBoxCustomization) getacstransactionid2).init;
        long[] jArr4 = new long[9];
        getLabelCustomization.getWarnings(jArr, jArr4);
        getLabelCustomization.init(jArr2, jArr3, jArr4);
        long[] jArr5 = new long[5];
        getLabelCustomization.cca_continue(jArr4, jArr5);
        return new setTextBoxCustomization(jArr5);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[5];
        getLabelCustomization.Cardinal(this.init, i, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[5];
        getLabelCustomization.init(this.init, jArr);
        return new setTextBoxCustomization(jArr);
    }

    public final getAcsTransactionID values() {
        long[] jArr = new long[5];
        getLabelCustomization.configure(this.init, jArr);
        return new setTextBoxCustomization(jArr);
    }
}
