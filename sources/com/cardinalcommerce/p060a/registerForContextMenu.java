package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.registerForContextMenu */
public final class registerForContextMenu {
    public boolean Cardinal;
    public byte[] CardinalActionCode;
    public int CardinalConfigurationParameters;
    public byte[] CardinalEnvironment;
    public byte[] CardinalError;
    public byte[] CardinalRenderType;
    public byte[] CardinalUiType;
    public KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo cca_continue;
    public byte[] cleanup;
    public KeyPairGeneratorSpi.X25519 configure;
    public long getActionCode;
    public byte[] getChallengeTimeout;
    public int getEnvironment;
    public boolean getInstance;
    public long getProxyAddress;
    public int getRequestTimeout;
    public byte[] getSDKVersion;
    public byte[] getString;
    public int getWarnings;
    public KeyFactorySpi.XDH init;
    public long setChallengeTimeout;
    public byte[] setRequestTimeout;
    public byte[] valueOf;
    public byte[] values;

    public registerForContextMenu() {
    }

    /* renamed from: a */
    private static void m1931a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = jArr[9];
        long j11 = jArr[10];
        long j12 = jArr[11];
        long j13 = jArr[12];
        long j14 = jArr[13];
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = (j8 >>> 35) ^ (j9 << 24);
        jArr[8] = (j9 >>> 40) ^ (j10 << 19);
        jArr[9] = (j10 >>> 45) ^ (j11 << 14);
        jArr[10] = (j11 >>> 50) ^ (j12 << 9);
        jArr[11] = ((j12 >>> 55) ^ (j13 << 4)) ^ (j14 << 63);
        jArr[12] = (j13 >>> 60) ^ (j14 >>> 1);
        jArr[13] = 0;
    }

    /* renamed from: a */
    private static void m1932a(long[] jArr, long j, long[] jArr2, int i) {
        long[] jArr3 = new long[8];
        jArr3[1] = j;
        jArr3[2] = jArr3[1] << 1;
        jArr3[3] = jArr3[2] ^ j;
        jArr3[4] = jArr3[2] << 1;
        jArr3[5] = jArr3[4] ^ j;
        jArr3[6] = jArr3[3] << 1;
        jArr3[7] = jArr3[6] ^ j;
        for (int i2 = 0; i2 < 7; i2++) {
            long j2 = jArr[i2];
            int i3 = (int) j2;
            long j3 = 0;
            long j4 = jArr3[i3 & 7] ^ (jArr3[(i3 >>> 3) & 7] << 3);
            int i4 = 54;
            do {
                int i5 = (int) (j2 >>> i4);
                long j5 = (jArr3[(i5 >>> 3) & 7] << 3) ^ jArr3[i5 & 7];
                j4 ^= j5 << i4;
                j3 ^= j5 >>> (-i4);
                i4 -= 6;
            } while (i4 > 0);
            int i6 = i + i2;
            jArr2[i6] = jArr2[i6] ^ (576460752303423487L & j4);
            int i7 = i6 + 1;
            jArr2[i7] = jArr2[i7] ^ ((j3 << 5) ^ (j4 >>> 59));
        }
    }

    /* renamed from: a */
    static void m1933a(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 6; i++) {
            setLabelFor.cca_continue(jArr[i], jArr2, i << 1);
        }
        jArr2[12] = setLabelFor.Cardinal((int) jArr[6]);
    }

    /* renamed from: a */
    static void m1934a(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        m1936b(jArr, jArr4);
        m1936b(jArr2, jArr5);
        for (int i = 0; i < 7; i++) {
            m1932a(jArr4, jArr5[i], jArr3, i);
        }
        m1931a(jArr3);
    }

    /* renamed from: b */
    private static void m1936b(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = ((j3 >>> 49) ^ (j4 << 15)) & 576460752303423487L;
        jArr2[4] = ((j4 >>> 44) ^ (j5 << 20)) & 576460752303423487L;
        jArr2[5] = ((j5 >>> 39) ^ (j6 << 25)) & 576460752303423487L;
        jArr2[6] = (j6 >>> 34) ^ (j7 << 30);
    }

    public static void init(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[12];
        long j10 = j7 ^ ((j9 >>> 25) ^ (j9 << 62));
        long j11 = j8 ^ (j9 >>> 2);
        long j12 = jArr[11];
        long j13 = j5 ^ (j12 << 39);
        long j14 = (j6 ^ (j9 << 39)) ^ ((j12 >>> 25) ^ (j12 << 62));
        long j15 = j10 ^ (j12 >>> 2);
        long j16 = jArr[10];
        long j17 = j4 ^ (j16 << 39);
        long j18 = j13 ^ ((j16 >>> 25) ^ (j16 << 62));
        long j19 = j14 ^ (j16 >>> 2);
        long j20 = jArr[9];
        long j21 = j3 ^ (j20 << 39);
        long j22 = j17 ^ ((j20 >>> 25) ^ (j20 << 62));
        long j23 = j18 ^ (j20 >>> 2);
        long j24 = jArr[8];
        long j25 = j ^ (j11 << 39);
        long j26 = (j21 ^ ((j24 >>> 25) ^ (j24 << 62))) ^ (j11 >>> 2);
        long j27 = j15 >>> 25;
        jArr2[0] = j25 ^ j27;
        long j28 = j27 << 23;
        jArr2[1] = j28 ^ ((j2 ^ (j24 << 39)) ^ ((j11 >>> 25) ^ (j11 << 62)));
        jArr2[2] = j26;
        jArr2[3] = j22 ^ (j24 >>> 2);
        jArr2[4] = j23;
        jArr2[5] = j19;
        jArr2[6] = j15 & 33554431;
    }

    public static long[] cca_continue(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 448) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[7];
        int i = 0;
        while (bigInteger.signum() != 0) {
            jArr[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        long j = jArr[6];
        long j2 = j >>> 25;
        jArr[0] = jArr[0] ^ j2;
        jArr[1] = (j2 << 23) ^ jArr[1];
        jArr[6] = j & 33554431;
        return jArr;
    }

    public static void init(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        m1934a(jArr, jArr2, jArr4);
        init(jArr4, jArr3);
    }

    public static void configure(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        m1934a(jArr, jArr2, jArr4);
        for (int i = 0; i < 13; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
    }

    public static void Cardinal(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[13];
        m1933a(jArr, jArr3);
        init(jArr3, jArr2);
    }

    public static void Cardinal(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[13];
        m1933a(jArr, jArr3);
        while (true) {
            init(jArr3, jArr2);
            i--;
            if (i > 0) {
                m1933a(jArr2, jArr3);
            } else {
                return;
            }
        }
    }

    public registerForContextMenu(KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo, byte b) {
        this(dHwithSHA512KDFAndSharedInfo);
    }

    private registerForContextMenu(KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo) {
        if (dHwithSHA512KDFAndSharedInfo.cca_continue() == 16) {
            SignatureSpi.Ed448 ed448 = new SignatureSpi.Ed448();
            this.cca_continue = dHwithSHA512KDFAndSharedInfo;
            this.init = ed448;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    public final int configure(int i) {
        int i2 = i + this.getRequestTimeout;
        if (this.getInstance) {
            return i2 + this.getWarnings;
        }
        int i3 = this.getWarnings;
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    public final void getInstance(byte[] bArr, int i) {
        m1935b();
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr2 = this.getChallengeTimeout;
            int i3 = this.getEnvironment;
            bArr2[i3] = bArr[i2];
            int i4 = i3 + 1;
            this.getEnvironment = i4;
            if (i4 == 16) {
                byte[] bArr3 = this.CardinalActionCode;
                KeyPairGeneratorSpi.Ed448.Cardinal(bArr3, bArr2);
                this.init.configure(bArr3);
                this.getEnvironment = 0;
                this.setChallengeTimeout += 16;
            }
        }
    }

    /* renamed from: a */
    private void m1928a() {
        if (this.setChallengeTimeout > 0) {
            System.arraycopy(this.CardinalActionCode, 0, this.getString, 0, 16);
            this.getProxyAddress = this.setChallengeTimeout;
        }
        int i = this.getEnvironment;
        if (i > 0) {
            byte[] bArr = this.getString;
            byte[] bArr2 = this.getChallengeTimeout;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                bArr[i] = (byte) (bArr[i] ^ bArr2[i + 0]);
            }
            this.init.configure(bArr);
            this.getProxyAddress += (long) this.getEnvironment;
        }
        if (this.getProxyAddress > 0) {
            System.arraycopy(this.getString, 0, this.CardinalRenderType, 0, 16);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:12:0x0031->B:13:0x0033, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getInstance(byte[] r7, int r8, int r9, byte[] r10) throws com.cardinalcommerce.p060a.KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo {
        /*
            r6 = this;
            r6.m1935b()
            int r0 = r7.length
            if (r0 < r9) goto L_0x006e
            boolean r0 = r6.getInstance
            r1 = 16
            r2 = 0
            if (r0 == 0) goto L_0x0047
            int r0 = r6.getRequestTimeout
            if (r0 == 0) goto L_0x0030
        L_0x0011:
            if (r9 <= 0) goto L_0x0030
            int r9 = r9 + -1
            byte[] r0 = r6.CardinalEnvironment
            int r3 = r6.getRequestTimeout
            int r4 = r8 + 1
            byte r8 = r7[r8]
            r0[r3] = r8
            int r3 = r3 + 1
            r6.getRequestTimeout = r3
            if (r3 != r1) goto L_0x002e
            r6.m1930a((byte[]) r0, (int) r2, (byte[]) r10, (int) r2)
            r6.getRequestTimeout = r2
            r8 = r4
            r0 = 16
            goto L_0x0031
        L_0x002e:
            r8 = r4
            goto L_0x0011
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r9 < r1) goto L_0x003d
            r6.m1930a((byte[]) r7, (int) r8, (byte[]) r10, (int) r0)
            int r8 = r8 + 16
            int r9 = r9 + -16
            int r0 = r0 + 16
            goto L_0x0031
        L_0x003d:
            if (r9 <= 0) goto L_0x006d
            byte[] r10 = r6.CardinalEnvironment
            java.lang.System.arraycopy(r7, r8, r10, r2, r9)
            r6.getRequestTimeout = r9
            goto L_0x006d
        L_0x0047:
            r8 = 0
            r0 = 0
        L_0x0049:
            if (r8 >= r9) goto L_0x006d
            byte[] r3 = r6.CardinalEnvironment
            int r4 = r6.getRequestTimeout
            byte r5 = r7[r8]
            r3[r4] = r5
            int r4 = r4 + 1
            r6.getRequestTimeout = r4
            int r5 = r3.length
            if (r4 != r5) goto L_0x006a
            r6.m1930a((byte[]) r3, (int) r2, (byte[]) r10, (int) r0)
            byte[] r3 = r6.CardinalEnvironment
            int r4 = r6.getWarnings
            java.lang.System.arraycopy(r3, r1, r3, r2, r4)
            int r3 = r6.getWarnings
            r6.getRequestTimeout = r3
            int r0 = r0 + 16
        L_0x006a:
            int r8 = r8 + 1
            goto L_0x0049
        L_0x006d:
            return r0
        L_0x006e:
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo r7 = new com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo
            java.lang.String r8 = "Input buffer too short"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.registerForContextMenu.getInstance(byte[], int, int, byte[]):int");
    }

    public final int cca_continue(byte[] bArr, int i) throws IllegalStateException, KeyFactorySpi.ECDH {
        m1935b();
        if (this.getActionCode == 0) {
            m1928a();
        }
        int i2 = this.getRequestTimeout;
        if (!this.getInstance) {
            int i3 = this.getWarnings;
            if (i2 >= i3) {
                i2 -= i3;
                if (bArr.length - i < i2) {
                    throw new KeyFactorySpi.ECDSA("Output buffer too short");
                }
            } else {
                throw new KeyFactorySpi.ECDH("data too short");
            }
        } else if (bArr.length - i < this.getWarnings + i2) {
            throw new KeyFactorySpi.ECDSA("Output buffer too short");
        }
        if (i2 > 0) {
            byte[] bArr2 = this.CardinalEnvironment;
            byte[] bArr3 = new byte[16];
            m1929a(bArr3);
            if (!this.getInstance) {
                byte[] bArr4 = this.CardinalRenderType;
                int i4 = i2;
                while (true) {
                    i4--;
                    if (i4 < 0) {
                        break;
                    }
                    bArr4[i4] = (byte) (bArr4[i4] ^ bArr2[i4 + 0]);
                }
                this.init.configure(bArr4);
                int i5 = i2;
                while (true) {
                    i5--;
                    if (i5 < 0) {
                        break;
                    }
                    int i6 = i5 + 0;
                    bArr2[i6] = (byte) (bArr2[i6] ^ bArr3[i5]);
                }
            } else {
                int i7 = i2;
                while (true) {
                    i7--;
                    if (i7 < 0) {
                        break;
                    }
                    int i8 = i7 + 0;
                    bArr2[i8] = (byte) (bArr2[i8] ^ bArr3[i7]);
                }
                byte[] bArr5 = this.CardinalRenderType;
                int i9 = i2;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        break;
                    }
                    bArr5[i9] = (byte) (bArr5[i9] ^ bArr2[i9 + 0]);
                }
                this.init.configure(bArr5);
            }
            System.arraycopy(bArr2, 0, bArr, i, i2);
            this.getActionCode += (long) i2;
        }
        long j = this.setChallengeTimeout;
        int i10 = this.getEnvironment;
        long j2 = j + ((long) i10);
        this.setChallengeTimeout = j2;
        if (j2 > this.getProxyAddress) {
            if (i10 > 0) {
                byte[] bArr6 = this.CardinalActionCode;
                byte[] bArr7 = this.getChallengeTimeout;
                while (true) {
                    i10--;
                    if (i10 < 0) {
                        break;
                    }
                    bArr6[i10] = (byte) (bArr6[i10] ^ bArr7[i10 + 0]);
                }
                this.init.configure(bArr6);
            }
            if (this.getProxyAddress > 0) {
                KeyPairGeneratorSpi.Ed448.Cardinal(this.CardinalActionCode, this.getString);
            }
            long j3 = ((this.getActionCode << 3) + 127) >>> 7;
            byte[] bArr8 = new byte[16];
            if (this.configure == null) {
                KeyPairGeneratorSpi.Ed25519 ed25519 = new KeyPairGeneratorSpi.Ed25519();
                this.configure = ed25519;
                ed25519.configure(this.CardinalError);
            }
            this.configure.init(j3, bArr8);
            byte[] bArr9 = this.CardinalActionCode;
            long[] Cardinal2 = KeyPairGeneratorSpi.Ed448.Cardinal(bArr9);
            KeyPairGeneratorSpi.Ed448.Cardinal(Cardinal2, KeyPairGeneratorSpi.Ed448.Cardinal(bArr8));
            KeyPairGeneratorSpi.Ed448.configure(Cardinal2, bArr9);
            KeyPairGeneratorSpi.Ed448.Cardinal(this.CardinalRenderType, this.CardinalActionCode);
        }
        byte[] bArr10 = new byte[16];
        long j4 = this.setChallengeTimeout << 3;
        setMinimumWidth.getInstance((int) (j4 >>> 32), bArr10, 0);
        setMinimumWidth.getInstance((int) j4, bArr10, 4);
        long j5 = this.getActionCode << 3;
        setMinimumWidth.getInstance((int) (j5 >>> 32), bArr10, 8);
        setMinimumWidth.getInstance((int) j5, bArr10, 12);
        byte[] bArr11 = this.CardinalRenderType;
        KeyPairGeneratorSpi.Ed448.Cardinal(bArr11, bArr10);
        this.init.configure(bArr11);
        byte[] bArr12 = new byte[16];
        this.cca_continue.init(this.CardinalUiType, 0, bArr12, 0);
        KeyPairGeneratorSpi.Ed448.Cardinal(bArr12, this.CardinalRenderType);
        int i11 = this.getWarnings;
        byte[] bArr13 = new byte[i11];
        this.valueOf = bArr13;
        System.arraycopy(bArr12, 0, bArr13, 0, i11);
        if (this.getInstance) {
            System.arraycopy(this.valueOf, 0, bArr, i + this.getRequestTimeout, this.getWarnings);
            i2 += this.getWarnings;
        } else {
            int i12 = this.getWarnings;
            byte[] bArr14 = new byte[i12];
            System.arraycopy(this.CardinalEnvironment, i2, bArr14, 0, i12);
            if (!setForegroundTintBlendMode.init(this.valueOf, bArr14)) {
                throw new KeyFactorySpi.ECDH("mac check in GCM failed");
            }
        }
        this.cca_continue.init();
        this.CardinalRenderType = new byte[16];
        this.CardinalActionCode = new byte[16];
        this.getString = new byte[16];
        this.getChallengeTimeout = new byte[16];
        this.getEnvironment = 0;
        this.setChallengeTimeout = 0;
        this.getProxyAddress = 0;
        this.setRequestTimeout = setForegroundTintBlendMode.cca_continue(this.CardinalUiType);
        this.CardinalConfigurationParameters = -2;
        this.getRequestTimeout = 0;
        this.getActionCode = 0;
        byte[] bArr15 = this.CardinalEnvironment;
        if (bArr15 != null) {
            for (int i13 = 0; i13 < bArr15.length; i13++) {
                bArr15[i13] = 0;
            }
        }
        if (this.getInstance) {
            this.Cardinal = false;
        } else {
            byte[] bArr16 = this.values;
            if (bArr16 != null) {
                getInstance(bArr16, bArr16.length);
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m1930a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length - i2 >= 16) {
            if (this.getActionCode == 0) {
                m1928a();
            }
            byte[] bArr3 = new byte[16];
            m1929a(bArr3);
            if (this.getInstance) {
                KeyPairGeneratorSpi.Ed448.configure(bArr3, bArr, i);
                byte[] bArr4 = this.CardinalRenderType;
                KeyPairGeneratorSpi.Ed448.Cardinal(bArr4, bArr3);
                this.init.configure(bArr4);
                System.arraycopy(bArr3, 0, bArr2, i2, 16);
            } else {
                byte[] bArr5 = this.CardinalRenderType;
                KeyPairGeneratorSpi.Ed448.configure(bArr5, bArr, i);
                this.init.configure(bArr5);
                KeyPairGeneratorSpi.Ed448.init(bArr3, bArr, i, bArr2, i2);
            }
            this.getActionCode += 16;
            return;
        }
        throw new KeyFactorySpi.ECDSA("Output buffer too short");
    }

    public void Cardinal(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2 += 16) {
            int min = Math.min(i - i2, 16);
            while (true) {
                min--;
                if (min < 0) {
                    break;
                }
                bArr[min] = (byte) (bArr[min] ^ bArr2[i2 + min]);
            }
            this.init.configure(bArr);
        }
    }

    /* renamed from: a */
    private void m1929a(byte[] bArr) {
        int i = this.CardinalConfigurationParameters;
        if (i != 0) {
            this.CardinalConfigurationParameters = i - 1;
            byte[] bArr2 = this.setRequestTimeout;
            int i2 = (bArr2[15] & 255) + 1;
            bArr2[15] = (byte) i2;
            int i3 = (i2 >>> 8) + (bArr2[14] & 255);
            bArr2[14] = (byte) i3;
            int i4 = (i3 >>> 8) + (bArr2[13] & 255);
            bArr2[13] = (byte) i4;
            bArr2[12] = (byte) ((i4 >>> 8) + (bArr2[12] & 255));
            this.cca_continue.init(bArr2, 0, bArr, 0);
            return;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    /* renamed from: b */
    private void m1935b() {
        if (this.Cardinal) {
            return;
        }
        if (this.getInstance) {
            throw new IllegalStateException("GCM cipher cannot be reused for encryption");
        }
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }
}
