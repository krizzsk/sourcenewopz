package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.getHeaderText */
public final class getHeaderText extends getAcsTransactionID.getInstance {
    protected long[] cca_continue;

    public getHeaderText(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.cca_continue = ToolbarCustomization.configure(bigInteger);
    }

    protected getHeaderText(long[] jArr) {
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
        return 233;
    }

    public final boolean cleanup() {
        return setNextFocusLeftId.configure(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof getHeaderText)) {
            return false;
        }
        return setNextFocusLeftId.init(this.cca_continue, ((getHeaderText) obj).cca_continue);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.cca_continue, 4) ^ 2330074;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public getHeaderText() {
        this.cca_continue = new long[4];
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((getHeaderText) getacstransactionid).cca_continue;
        return new getHeaderText(new long[]{jArr[0] ^ jArr2[0], jArr[1] ^ jArr2[1], jArr[2] ^ jArr2[2], jArr[3] ^ jArr2[3]});
    }

    public final getAcsTransactionID init() {
        long[] jArr = this.cca_continue;
        return new getHeaderText(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        ToolbarCustomization.m1831b(this.cca_continue, ((getHeaderText) getacstransactionid).cca_continue, jArr2);
        ToolbarCustomization.init(jArr2, jArr);
        return new getHeaderText(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((getHeaderText) getacstransactionid).cca_continue;
        long[] jArr3 = ((getHeaderText) getacstransactionid2).cca_continue;
        long[] jArr4 = ((getHeaderText) getacstransactionid3).cca_continue;
        long[] jArr5 = new long[8];
        long[] jArr6 = new long[8];
        ToolbarCustomization.m1831b(jArr, jArr2, jArr6);
        ToolbarCustomization.m1829a(jArr5, jArr6, jArr5);
        long[] jArr7 = new long[8];
        ToolbarCustomization.m1831b(jArr3, jArr4, jArr7);
        ToolbarCustomization.m1829a(jArr5, jArr7, jArr5);
        long[] jArr8 = new long[4];
        ToolbarCustomization.init(jArr5, jArr8);
        return new getHeaderText(jArr8);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        ToolbarCustomization.m1831b(this.cca_continue, ((getHeaderText) getacstransactionid.getSDKVersion()).cca_continue, jArr2);
        ToolbarCustomization.init(jArr2, jArr);
        return new getHeaderText(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        ToolbarCustomization.m1828a(this.cca_continue, jArr2);
        ToolbarCustomization.init(jArr2, jArr);
        return new getHeaderText(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((getHeaderText) getacstransactionid).cca_continue;
        long[] jArr3 = ((getHeaderText) getacstransactionid2).cca_continue;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        ToolbarCustomization.m1828a(jArr, jArr5);
        ToolbarCustomization.m1829a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        ToolbarCustomization.m1831b(jArr2, jArr3, jArr6);
        ToolbarCustomization.m1829a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        ToolbarCustomization.init(jArr4, jArr7);
        return new getHeaderText(jArr7);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[4];
        ToolbarCustomization.getInstance(this.cca_continue, i, jArr);
        return new getHeaderText(jArr);
    }

    public final int CardinalRenderType() {
        long[] jArr = this.cca_continue;
        return ((int) (jArr[0] ^ (jArr[2] >>> 31))) & 1;
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[4];
        long[] jArr2 = this.cca_continue;
        if (!setNextFocusLeftId.configure(jArr2)) {
            long[] jArr3 = new long[4];
            long[] jArr4 = new long[4];
            long[] jArr5 = new long[8];
            ToolbarCustomization.m1828a(jArr2, jArr5);
            ToolbarCustomization.init(jArr5, jArr3);
            ToolbarCustomization.init(jArr3, jArr2, jArr3);
            long[] jArr6 = new long[8];
            ToolbarCustomization.m1828a(jArr3, jArr6);
            ToolbarCustomization.init(jArr6, jArr3);
            ToolbarCustomization.init(jArr3, jArr2, jArr3);
            ToolbarCustomization.getInstance(jArr3, 3, jArr4);
            ToolbarCustomization.init(jArr4, jArr3, jArr4);
            long[] jArr7 = new long[8];
            ToolbarCustomization.m1828a(jArr4, jArr7);
            ToolbarCustomization.init(jArr7, jArr4);
            ToolbarCustomization.init(jArr4, jArr2, jArr4);
            ToolbarCustomization.getInstance(jArr4, 7, jArr3);
            ToolbarCustomization.init(jArr3, jArr4, jArr3);
            ToolbarCustomization.getInstance(jArr3, 14, jArr4);
            ToolbarCustomization.init(jArr4, jArr3, jArr4);
            long[] jArr8 = new long[8];
            ToolbarCustomization.m1828a(jArr4, jArr8);
            ToolbarCustomization.init(jArr8, jArr4);
            ToolbarCustomization.init(jArr4, jArr2, jArr4);
            ToolbarCustomization.getInstance(jArr4, 29, jArr3);
            ToolbarCustomization.init(jArr3, jArr4, jArr3);
            ToolbarCustomization.getInstance(jArr3, 58, jArr4);
            ToolbarCustomization.init(jArr4, jArr3, jArr4);
            ToolbarCustomization.getInstance(jArr4, 116, jArr3);
            ToolbarCustomization.init(jArr3, jArr4, jArr3);
            long[] jArr9 = new long[8];
            ToolbarCustomization.m1828a(jArr3, jArr9);
            ToolbarCustomization.init(jArr9, jArr);
            return new getHeaderText(jArr);
        }
        throw new IllegalStateException();
    }

    public final getAcsTransactionID values() {
        long[] jArr = new long[4];
        long[] jArr2 = this.cca_continue;
        int i = 0;
        long configure = setLabelFor.configure(jArr2[0]);
        long configure2 = setLabelFor.configure(jArr2[1]);
        long j = (configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32);
        long j2 = (configure >>> 32) | (configure2 & -4294967296L);
        long configure3 = setLabelFor.configure(jArr2[2]);
        int i2 = 3;
        long configure4 = setLabelFor.configure(jArr2[3]);
        long j3 = (InternalZipConstants.ZIP_64_SIZE_LIMIT & configure3) | (configure4 << 32);
        long j4 = (configure3 >>> 32) | (configure4 & -4294967296L);
        long j5 = j4 >>> 27;
        long j6 = j4 ^ ((j2 >>> 27) | (j4 << 37));
        long j7 = j2 ^ (j2 << 37);
        long[] jArr3 = new long[8];
        int[] iArr = {32, 117, 191};
        while (i < i2) {
            int i3 = iArr[i] >>> 6;
            int i4 = iArr[i] & 63;
            jArr3[i3] = jArr3[i3] ^ (j7 << i4);
            int i5 = i3 + 1;
            int i6 = -i4;
            jArr3[i5] = jArr3[i5] ^ ((j6 << i4) | (j7 >>> i6));
            int i7 = i3 + 2;
            jArr3[i7] = jArr3[i7] ^ ((j5 << i4) | (j6 >>> i6));
            i2 = 3;
            int i8 = i3 + 3;
            jArr3[i8] = jArr3[i8] ^ (j5 >>> i6);
            i++;
        }
        ToolbarCustomization.init(jArr3, jArr);
        jArr[0] = jArr[0] ^ j;
        jArr[1] = jArr[1] ^ j3;
        return new getHeaderText(jArr);
    }
}
