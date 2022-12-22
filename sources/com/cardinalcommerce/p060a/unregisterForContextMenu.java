package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.unregisterForContextMenu */
public final class unregisterForContextMenu extends getAcsTransactionID.getInstance {
    protected long[] cca_continue;

    public unregisterForContextMenu(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.cca_continue = registerForContextMenu.cca_continue(bigInteger);
    }

    protected unregisterForContextMenu(long[] jArr) {
        this.cca_continue = jArr;
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        return cca_continue(getacstransactionid);
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setNextClusterForwardId.getInstance(this.cca_continue);
    }

    public final int cca_continue() {
        return 409;
    }

    public final boolean cleanup() {
        return setNextClusterForwardId.configure(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof unregisterForContextMenu)) {
            return false;
        }
        return setNextClusterForwardId.configure(this.cca_continue, ((unregisterForContextMenu) obj).cca_continue);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.cca_continue, 7) ^ 4090087;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public unregisterForContextMenu() {
        this.cca_continue = new long[7];
    }

    public final BigInteger Cardinal() {
        long[] jArr = this.cca_continue;
        byte[] bArr = new byte[56];
        for (int i = 0; i < 7; i++) {
            long j = jArr[i];
            if (j != 0) {
                int i2 = (6 - i) << 3;
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i2);
                setMinimumWidth.getInstance((int) j, bArr, i2 + 4);
            }
        }
        return new BigInteger(1, bArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((unregisterForContextMenu) getacstransactionid).cca_continue;
        return new unregisterForContextMenu(new long[]{jArr[0] ^ jArr2[0], jArr[1] ^ jArr2[1], jArr[2] ^ jArr2[2], jArr[3] ^ jArr2[3], jArr[4] ^ jArr2[4], jArr[5] ^ jArr2[5], jArr[6] ^ jArr2[6]});
    }

    public final getAcsTransactionID init() {
        long[] jArr = this.cca_continue;
        return new unregisterForContextMenu(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3], jArr[4], jArr[5], jArr[6]});
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[7];
        long[] jArr2 = new long[14];
        registerForContextMenu.m1934a(this.cca_continue, ((unregisterForContextMenu) getacstransactionid).cca_continue, jArr2);
        registerForContextMenu.init(jArr2, jArr);
        return new unregisterForContextMenu(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((unregisterForContextMenu) getacstransactionid).cca_continue;
        long[] jArr3 = ((unregisterForContextMenu) getacstransactionid2).cca_continue;
        long[] jArr4 = ((unregisterForContextMenu) getacstransactionid3).cca_continue;
        long[] jArr5 = new long[13];
        registerForContextMenu.configure(jArr, jArr2, jArr5);
        registerForContextMenu.configure(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[7];
        registerForContextMenu.init(jArr5, jArr6);
        return new unregisterForContextMenu(jArr6);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[7];
        long[] jArr2 = new long[14];
        registerForContextMenu.m1934a(this.cca_continue, ((unregisterForContextMenu) getacstransactionid.getSDKVersion()).cca_continue, jArr2);
        registerForContextMenu.init(jArr2, jArr);
        return new unregisterForContextMenu(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[7];
        long[] jArr2 = new long[13];
        registerForContextMenu.m1933a(this.cca_continue, jArr2);
        registerForContextMenu.init(jArr2, jArr);
        return new unregisterForContextMenu(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((unregisterForContextMenu) getacstransactionid).cca_continue;
        long[] jArr3 = ((unregisterForContextMenu) getacstransactionid2).cca_continue;
        long[] jArr4 = new long[13];
        long[] jArr5 = new long[13];
        registerForContextMenu.m1933a(jArr, jArr5);
        for (int i = 0; i < 13; i++) {
            jArr4[i] = jArr4[i] ^ jArr5[i];
        }
        registerForContextMenu.configure(jArr2, jArr3, jArr4);
        long[] jArr6 = new long[7];
        registerForContextMenu.init(jArr4, jArr6);
        return new unregisterForContextMenu(jArr6);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[7];
        registerForContextMenu.Cardinal(this.cca_continue, i, jArr);
        return new unregisterForContextMenu(jArr);
    }

    public final int CardinalRenderType() {
        return ((int) this.cca_continue[0]) & 1;
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[7];
        long[] jArr2 = this.cca_continue;
        if (!setNextClusterForwardId.configure(jArr2)) {
            long[] jArr3 = new long[7];
            long[] jArr4 = new long[7];
            long[] jArr5 = new long[7];
            registerForContextMenu.Cardinal(jArr2, jArr3);
            registerForContextMenu.Cardinal(jArr3, 1, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr4, 1, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr3, 3, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr3, 6, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr3, 12, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr5);
            registerForContextMenu.Cardinal(jArr5, 24, jArr3);
            registerForContextMenu.Cardinal(jArr3, 24, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr3, 48, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr3, 96, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.Cardinal(jArr3, 192, jArr4);
            registerForContextMenu.init(jArr3, jArr4, jArr3);
            registerForContextMenu.init(jArr3, jArr5, jArr);
            return new unregisterForContextMenu(jArr);
        }
        throw new IllegalStateException();
    }

    public final getAcsTransactionID values() {
        long[] jArr = this.cca_continue;
        long configure = setLabelFor.configure(jArr[0]);
        long configure2 = setLabelFor.configure(jArr[1]);
        long j = (configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32);
        long j2 = (configure >>> 32) | (configure2 & -4294967296L);
        long configure3 = setLabelFor.configure(jArr[2]);
        long configure4 = setLabelFor.configure(jArr[3]);
        long j3 = (configure3 & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure4 << 32);
        long j4 = (configure3 >>> 32) | (configure4 & -4294967296L);
        long configure5 = setLabelFor.configure(jArr[4]);
        long configure6 = setLabelFor.configure(jArr[5]);
        long j5 = (configure5 & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure6 << 32);
        long j6 = (configure5 >>> 32) | (configure6 & -4294967296L);
        long configure7 = setLabelFor.configure(jArr[6]);
        long j7 = configure7 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = configure7 >>> 32;
        return new unregisterForContextMenu(new long[]{j ^ (j2 << 44), (j3 ^ (j4 << 44)) ^ (j2 >>> 20), (j5 ^ (j6 << 44)) ^ (j4 >>> 20), (((j8 << 44) ^ j7) ^ (j6 >>> 20)) ^ (j2 << 13), (j2 >>> 51) ^ ((j8 >>> 20) ^ (j4 << 13)), (j6 << 13) ^ (j4 >>> 51), (j6 >>> 51) ^ (j8 << 13)});
    }
}
