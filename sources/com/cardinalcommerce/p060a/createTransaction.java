package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import org.bouncycastle.math.p082ec.WNafUtil;

/* renamed from: com.cardinalcommerce.a.createTransaction */
public abstract class createTransaction {

    /* renamed from: a */
    private static final int[] f2519a = {13, 41, 121, 337, 897, 2305};

    /* renamed from: b */
    private static final byte[] f2520b = new byte[0];

    /* renamed from: c */
    private static final int[] f2521c = new int[0];
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final ChallengeParameters[] f2522d = new ChallengeParameters[0];

    public static cancelled Cardinal(final ChallengeParameters challengeParameters, final int i, boolean z) {
        final getSDKAppID cca_continue = challengeParameters.cca_continue();
        return (cancelled) cca_continue.getInstance(challengeParameters, WNafUtil.PRECOMP_NAME, new ConfigParameters(true) {
            private static boolean cca_continue(ChallengeParameters[] challengeParametersArr, int i) {
                return challengeParametersArr != null && challengeParametersArr.length >= i;
            }

            /* JADX WARNING: Removed duplicated region for block: B:41:0x00bf A[LOOP:0: B:40:0x00bd->B:41:0x00bf, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x00e4 A[LOOP:1: B:51:0x00e2->B:52:0x00e4, LOOP_END] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA512KDF init(com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA512KDF r12) {
                /*
                    r11 = this;
                    boolean r0 = r12 instanceof com.cardinalcommerce.p060a.cancelled
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    com.cardinalcommerce.a.cancelled r12 = (com.cardinalcommerce.p060a.cancelled) r12
                    goto L_0x0009
                L_0x0008:
                    r12 = r1
                L_0x0009:
                    int r0 = r3
                    r2 = 2
                    int r0 = r0 - r2
                    r3 = 0
                    int r0 = java.lang.Math.max(r3, r0)
                    r4 = 1
                    int r0 = r4 << r0
                    boolean r5 = true
                    boolean r5 = Cardinal(r12, r0, r5)
                    if (r5 == 0) goto L_0x001e
                    return r12
                L_0x001e:
                    if (r12 == 0) goto L_0x0027
                    com.cardinalcommerce.a.ChallengeParameters[] r5 = r12.configure
                    com.cardinalcommerce.a.ChallengeParameters[] r6 = r12.cca_continue
                    com.cardinalcommerce.a.ChallengeParameters r12 = r12.getInstance
                    goto L_0x002a
                L_0x0027:
                    r12 = r1
                    r5 = r12
                    r6 = r5
                L_0x002a:
                    if (r5 != 0) goto L_0x0032
                    com.cardinalcommerce.a.ChallengeParameters[] r5 = com.cardinalcommerce.p060a.createTransaction.f2522d
                    r7 = 0
                    goto L_0x0033
                L_0x0032:
                    int r7 = r5.length
                L_0x0033:
                    if (r7 >= r0) goto L_0x00d0
                    com.cardinalcommerce.a.ChallengeParameters[] r5 = com.cardinalcommerce.p060a.createTransaction.m1840a((com.cardinalcommerce.p060a.ChallengeParameters[]) r5, (int) r0)
                    if (r0 != r4) goto L_0x0045
                    com.cardinalcommerce.a.ChallengeParameters r1 = r2
                    com.cardinalcommerce.a.ChallengeParameters r1 = r1.CardinalRenderType()
                    r5[r3] = r1
                    goto L_0x00d0
                L_0x0045:
                    if (r7 != 0) goto L_0x004d
                    com.cardinalcommerce.a.ChallengeParameters r8 = r2
                    r5[r3] = r8
                    r8 = 1
                    goto L_0x004e
                L_0x004d:
                    r8 = r7
                L_0x004e:
                    if (r0 != r2) goto L_0x005a
                    com.cardinalcommerce.a.ChallengeParameters r2 = r2
                    com.cardinalcommerce.a.ChallengeParameters r2 = r2.getChallengeTimeout()
                    r5[r4] = r2
                    goto L_0x00c9
                L_0x005a:
                    int r4 = r8 + -1
                    r4 = r5[r4]
                    if (r12 != 0) goto L_0x00bc
                    r12 = r5[r3]
                    com.cardinalcommerce.a.ChallengeParameters r12 = r12.getRequestTimeout()
                    boolean r9 = r12.valueOf()
                    if (r9 != 0) goto L_0x00bc
                    com.cardinalcommerce.a.getSDKAppID r9 = r4
                    boolean r9 = com.cardinalcommerce.p060a.getDeviceData.getInstance(r9)
                    if (r9 == 0) goto L_0x00bc
                    com.cardinalcommerce.a.getSDKAppID r9 = r4
                    int r9 = r9.configure()
                    r10 = 64
                    if (r9 < r10) goto L_0x00bc
                    com.cardinalcommerce.a.getSDKAppID r9 = r4
                    int r9 = r9.CardinalActionCode()
                    if (r9 == r2) goto L_0x008d
                    r2 = 3
                    if (r9 == r2) goto L_0x008d
                    r2 = 4
                    if (r9 == r2) goto L_0x008d
                    goto L_0x00bc
                L_0x008d:
                    com.cardinalcommerce.a.getAcsTransactionID r1 = r12.cca_continue((int) r3)
                    com.cardinalcommerce.a.getSDKAppID r2 = r4
                    com.cardinalcommerce.a.getAcsTransactionID r9 = r12.values()
                    java.math.BigInteger r9 = r9.Cardinal()
                    com.cardinalcommerce.a.getAcsTransactionID r10 = r12.CardinalError()
                    java.math.BigInteger r10 = r10.Cardinal()
                    com.cardinalcommerce.a.ChallengeParameters r2 = r2.Cardinal(r9, r10, r3)
                    com.cardinalcommerce.a.getAcsTransactionID r9 = r1.configure()
                    com.cardinalcommerce.a.getAcsTransactionID r10 = r9.init(r1)
                    com.cardinalcommerce.a.ChallengeParameters r4 = r4.getInstance((com.cardinalcommerce.p060a.getAcsTransactionID) r9)
                    com.cardinalcommerce.a.ChallengeParameters r4 = r4.Cardinal((com.cardinalcommerce.p060a.getAcsTransactionID) r10)
                    if (r7 != 0) goto L_0x00bd
                    r5[r3] = r4
                    goto L_0x00bd
                L_0x00bc:
                    r2 = r12
                L_0x00bd:
                    if (r8 >= r0) goto L_0x00c9
                    int r9 = r8 + 1
                    com.cardinalcommerce.a.ChallengeParameters r4 = r4.getInstance((com.cardinalcommerce.p060a.ChallengeParameters) r2)
                    r5[r8] = r4
                    r8 = r9
                    goto L_0x00bd
                L_0x00c9:
                    com.cardinalcommerce.a.getSDKAppID r2 = r4
                    int r4 = r0 - r7
                    r2.init(r5, r7, r4, r1)
                L_0x00d0:
                    boolean r1 = true
                    if (r1 == 0) goto L_0x00ef
                    if (r6 != 0) goto L_0x00da
                    com.cardinalcommerce.a.ChallengeParameters[] r1 = new com.cardinalcommerce.p060a.ChallengeParameters[r0]
                L_0x00d8:
                    r6 = r1
                    goto L_0x00e2
                L_0x00da:
                    int r3 = r6.length
                    if (r3 >= r0) goto L_0x00e2
                    com.cardinalcommerce.a.ChallengeParameters[] r1 = com.cardinalcommerce.p060a.createTransaction.m1840a((com.cardinalcommerce.p060a.ChallengeParameters[]) r6, (int) r0)
                    goto L_0x00d8
                L_0x00e2:
                    if (r3 >= r0) goto L_0x00ef
                    r1 = r5[r3]
                    com.cardinalcommerce.a.ChallengeParameters r1 = r1.getString()
                    r6[r3] = r1
                    int r3 = r3 + 1
                    goto L_0x00e2
                L_0x00ef:
                    com.cardinalcommerce.a.cancelled r0 = new com.cardinalcommerce.a.cancelled
                    r0.<init>()
                    r0.configure = r5
                    r0.cca_continue = r6
                    r0.getInstance = r12
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.createTransaction.C19912.init(com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF):com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF");
            }

            private static boolean Cardinal(cancelled cancelled, int i, boolean z) {
                if (cancelled == null || !cca_continue(cancelled.configure, i)) {
                    return false;
                }
                return !z || cca_continue(cancelled.cca_continue, i);
            }
        });
    }

    /* renamed from: a */
    private static byte[] m1837a(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return f2520b;
        }
        BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
        int bitLength = add.bitLength() - 1;
        byte[] bArr = new byte[bitLength];
        BigInteger xor = add.xor(bigInteger);
        int i = 1;
        while (i < bitLength) {
            if (xor.testBit(i)) {
                bArr[i - 1] = (byte) (bigInteger.testBit(i) ? -1 : 1);
                i++;
            }
            i++;
        }
        bArr[bitLength - 1] = 1;
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m1838a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public static int cca_continue(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static byte[] cca_continue(int i, BigInteger bigInteger) {
        if (i == 2) {
            return m1837a(bigInteger);
        }
        if (i < 2 || i > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        } else if (bigInteger.signum() == 0) {
            return f2520b;
        } else {
            int bitLength = bigInteger.bitLength() + 1;
            byte[] bArr = new byte[bitLength];
            int i2 = 1 << i;
            int i3 = i2 - 1;
            int i4 = i2 >>> 1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i5) == z) {
                    i5++;
                } else {
                    bigInteger = bigInteger.shiftRight(i5);
                    int intValue = bigInteger.intValue() & i3;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i4) != 0;
                    if (z) {
                        intValue -= i2;
                    }
                    if (i6 > 0) {
                        i5--;
                    }
                    int i7 = i6 + i5;
                    bArr[i7] = (byte) intValue;
                    i6 = i7 + 1;
                    i5 = i;
                }
            }
            return bitLength > i6 ? m1838a(bArr, i6) : bArr;
        }
    }

    public static int[] getInstance(int i, BigInteger bigInteger) {
        if (i == 2) {
            if ((bigInteger.bitLength() >>> 16) != 0) {
                throw new IllegalArgumentException("'k' must have bitlength < 2^16");
            } else if (bigInteger.signum() == 0) {
                return f2521c;
            } else {
                BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
                int bitLength = add.bitLength();
                int i2 = bitLength >> 1;
                int[] iArr = new int[i2];
                BigInteger xor = add.xor(bigInteger);
                int i3 = bitLength - 1;
                int i4 = 1;
                int i5 = 0;
                int i6 = 0;
                while (i4 < i3) {
                    if (!xor.testBit(i4)) {
                        i6++;
                    } else {
                        iArr[i5] = i6 | ((bigInteger.testBit(i4) ? -1 : 1) << 16);
                        i4++;
                        i5++;
                        i6 = 1;
                    }
                    i4++;
                }
                int i7 = i5 + 1;
                iArr[i5] = 65536 | i6;
                if (i2 <= i7) {
                    return iArr;
                }
                int[] iArr2 = new int[i7];
                System.arraycopy(iArr, 0, iArr2, 0, i7);
                return iArr2;
            }
        } else if (i < 2 || i > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        } else if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return f2521c;
        } else {
            int bitLength2 = (bigInteger.bitLength() / i) + 1;
            int[] iArr3 = new int[bitLength2];
            int i8 = 1 << i;
            int i9 = i8 - 1;
            int i10 = i8 >>> 1;
            int i11 = 0;
            int i12 = 0;
            boolean z = false;
            while (i11 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i11) == z) {
                    i11++;
                } else {
                    bigInteger = bigInteger.shiftRight(i11);
                    int intValue = bigInteger.intValue() & i9;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i10) != 0;
                    if (z) {
                        intValue -= i8;
                    }
                    if (i12 > 0) {
                        i11--;
                    }
                    iArr3[i12] = i11 | (intValue << 16);
                    i11 = i;
                    i12++;
                }
            }
            if (bitLength2 <= i12) {
                return iArr3;
            }
            int[] iArr4 = new int[i12];
            System.arraycopy(iArr3, 0, iArr4, 0, i12);
            return iArr4;
        }
    }

    public static cancelled Cardinal(ChallengeParameters challengeParameters) {
        KeyAgreementSpi.ECKAEGwithSHA512KDF instance = challengeParameters.cca_continue().getInstance(challengeParameters, WNafUtil.PRECOMP_NAME);
        if (instance instanceof cancelled) {
            return (cancelled) instance;
        }
        return null;
    }

    public static int Cardinal(int i) {
        int[] iArr = f2519a;
        int i2 = 0;
        while (i2 < iArr.length && i >= iArr[i2]) {
            i2++;
        }
        return i2 + 2;
    }

    public static ChallengeParameters Cardinal(final ChallengeParameters challengeParameters, final int i, get3DSServerTransactionID get3dsservertransactionid) {
        getSDKAppID cca_continue = challengeParameters.cca_continue();
        final getSDKAppID cca_continue2 = challengeParameters.cca_continue();
        ChallengeParameters cca_continue3 = get3dsservertransactionid.cca_continue(challengeParameters);
        cca_continue.getInstance(cca_continue3, WNafUtil.PRECOMP_NAME, new ConfigParameters((cancelled) cca_continue2.getInstance(challengeParameters, WNafUtil.PRECOMP_NAME, new ConfigParameters(true) {
            private static boolean cca_continue(ChallengeParameters[] challengeParametersArr, int i) {
                return challengeParametersArr != null && challengeParametersArr.length >= i;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA512KDF init(com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA512KDF r12) {
                /*
                    r11 = this;
                    boolean r0 = r12 instanceof com.cardinalcommerce.p060a.cancelled
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    com.cardinalcommerce.a.cancelled r12 = (com.cardinalcommerce.p060a.cancelled) r12
                    goto L_0x0009
                L_0x0008:
                    r12 = r1
                L_0x0009:
                    int r0 = r3
                    r2 = 2
                    int r0 = r0 - r2
                    r3 = 0
                    int r0 = java.lang.Math.max(r3, r0)
                    r4 = 1
                    int r0 = r4 << r0
                    boolean r5 = true
                    boolean r5 = Cardinal(r12, r0, r5)
                    if (r5 == 0) goto L_0x001e
                    return r12
                L_0x001e:
                    if (r12 == 0) goto L_0x0027
                    com.cardinalcommerce.a.ChallengeParameters[] r5 = r12.configure
                    com.cardinalcommerce.a.ChallengeParameters[] r6 = r12.cca_continue
                    com.cardinalcommerce.a.ChallengeParameters r12 = r12.getInstance
                    goto L_0x002a
                L_0x0027:
                    r12 = r1
                    r5 = r12
                    r6 = r5
                L_0x002a:
                    if (r5 != 0) goto L_0x0032
                    com.cardinalcommerce.a.ChallengeParameters[] r5 = com.cardinalcommerce.p060a.createTransaction.f2522d
                    r7 = 0
                    goto L_0x0033
                L_0x0032:
                    int r7 = r5.length
                L_0x0033:
                    if (r7 >= r0) goto L_0x00d0
                    com.cardinalcommerce.a.ChallengeParameters[] r5 = com.cardinalcommerce.p060a.createTransaction.m1840a((com.cardinalcommerce.p060a.ChallengeParameters[]) r5, (int) r0)
                    if (r0 != r4) goto L_0x0045
                    com.cardinalcommerce.a.ChallengeParameters r1 = r2
                    com.cardinalcommerce.a.ChallengeParameters r1 = r1.CardinalRenderType()
                    r5[r3] = r1
                    goto L_0x00d0
                L_0x0045:
                    if (r7 != 0) goto L_0x004d
                    com.cardinalcommerce.a.ChallengeParameters r8 = r2
                    r5[r3] = r8
                    r8 = 1
                    goto L_0x004e
                L_0x004d:
                    r8 = r7
                L_0x004e:
                    if (r0 != r2) goto L_0x005a
                    com.cardinalcommerce.a.ChallengeParameters r2 = r2
                    com.cardinalcommerce.a.ChallengeParameters r2 = r2.getChallengeTimeout()
                    r5[r4] = r2
                    goto L_0x00c9
                L_0x005a:
                    int r4 = r8 + -1
                    r4 = r5[r4]
                    if (r12 != 0) goto L_0x00bc
                    r12 = r5[r3]
                    com.cardinalcommerce.a.ChallengeParameters r12 = r12.getRequestTimeout()
                    boolean r9 = r12.valueOf()
                    if (r9 != 0) goto L_0x00bc
                    com.cardinalcommerce.a.getSDKAppID r9 = r4
                    boolean r9 = com.cardinalcommerce.p060a.getDeviceData.getInstance(r9)
                    if (r9 == 0) goto L_0x00bc
                    com.cardinalcommerce.a.getSDKAppID r9 = r4
                    int r9 = r9.configure()
                    r10 = 64
                    if (r9 < r10) goto L_0x00bc
                    com.cardinalcommerce.a.getSDKAppID r9 = r4
                    int r9 = r9.CardinalActionCode()
                    if (r9 == r2) goto L_0x008d
                    r2 = 3
                    if (r9 == r2) goto L_0x008d
                    r2 = 4
                    if (r9 == r2) goto L_0x008d
                    goto L_0x00bc
                L_0x008d:
                    com.cardinalcommerce.a.getAcsTransactionID r1 = r12.cca_continue((int) r3)
                    com.cardinalcommerce.a.getSDKAppID r2 = r4
                    com.cardinalcommerce.a.getAcsTransactionID r9 = r12.values()
                    java.math.BigInteger r9 = r9.Cardinal()
                    com.cardinalcommerce.a.getAcsTransactionID r10 = r12.CardinalError()
                    java.math.BigInteger r10 = r10.Cardinal()
                    com.cardinalcommerce.a.ChallengeParameters r2 = r2.Cardinal(r9, r10, r3)
                    com.cardinalcommerce.a.getAcsTransactionID r9 = r1.configure()
                    com.cardinalcommerce.a.getAcsTransactionID r10 = r9.init(r1)
                    com.cardinalcommerce.a.ChallengeParameters r4 = r4.getInstance((com.cardinalcommerce.p060a.getAcsTransactionID) r9)
                    com.cardinalcommerce.a.ChallengeParameters r4 = r4.Cardinal((com.cardinalcommerce.p060a.getAcsTransactionID) r10)
                    if (r7 != 0) goto L_0x00bd
                    r5[r3] = r4
                    goto L_0x00bd
                L_0x00bc:
                    r2 = r12
                L_0x00bd:
                    if (r8 >= r0) goto L_0x00c9
                    int r9 = r8 + 1
                    com.cardinalcommerce.a.ChallengeParameters r4 = r4.getInstance((com.cardinalcommerce.p060a.ChallengeParameters) r2)
                    r5[r8] = r4
                    r8 = r9
                    goto L_0x00bd
                L_0x00c9:
                    com.cardinalcommerce.a.getSDKAppID r2 = r4
                    int r4 = r0 - r7
                    r2.init(r5, r7, r4, r1)
                L_0x00d0:
                    boolean r1 = true
                    if (r1 == 0) goto L_0x00ef
                    if (r6 != 0) goto L_0x00da
                    com.cardinalcommerce.a.ChallengeParameters[] r1 = new com.cardinalcommerce.p060a.ChallengeParameters[r0]
                L_0x00d8:
                    r6 = r1
                    goto L_0x00e2
                L_0x00da:
                    int r3 = r6.length
                    if (r3 >= r0) goto L_0x00e2
                    com.cardinalcommerce.a.ChallengeParameters[] r1 = com.cardinalcommerce.p060a.createTransaction.m1840a((com.cardinalcommerce.p060a.ChallengeParameters[]) r6, (int) r0)
                    goto L_0x00d8
                L_0x00e2:
                    if (r3 >= r0) goto L_0x00ef
                    r1 = r5[r3]
                    com.cardinalcommerce.a.ChallengeParameters r1 = r1.getString()
                    r6[r3] = r1
                    int r3 = r3 + 1
                    goto L_0x00e2
                L_0x00ef:
                    com.cardinalcommerce.a.cancelled r0 = new com.cardinalcommerce.a.cancelled
                    r0.<init>()
                    r0.configure = r5
                    r0.cca_continue = r6
                    r0.getInstance = r12
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.createTransaction.C19912.init(com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF):com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF");
            }

            private static boolean Cardinal(cancelled cancelled, int i, boolean z) {
                if (cancelled == null || !cca_continue(cancelled.configure, i)) {
                    return false;
                }
                return !z || cca_continue(cancelled.cca_continue, i);
            }
        }), get3dsservertransactionid, true) {
            private /* synthetic */ get3DSServerTransactionID cca_continue;
            private /* synthetic */ boolean getInstance = true;
            private /* synthetic */ cancelled init;

            {
                this.init = r1;
                this.cca_continue = r2;
            }

            public final KeyAgreementSpi.ECKAEGwithSHA512KDF init(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
                cancelled cancelled = new cancelled();
                ChallengeParameters challengeParameters = this.init.getInstance;
                if (challengeParameters != null) {
                    cancelled.getInstance = this.cca_continue.cca_continue(challengeParameters);
                }
                ChallengeParameters[] challengeParametersArr = this.init.configure;
                int length = challengeParametersArr.length;
                ChallengeParameters[] challengeParametersArr2 = new ChallengeParameters[length];
                for (int i = 0; i < challengeParametersArr.length; i++) {
                    challengeParametersArr2[i] = this.cca_continue.cca_continue(challengeParametersArr[i]);
                }
                cancelled.configure = challengeParametersArr2;
                if (this.getInstance) {
                    ChallengeParameters[] challengeParametersArr3 = new ChallengeParameters[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        challengeParametersArr3[i2] = challengeParametersArr2[i2].getString();
                    }
                    cancelled.cca_continue = challengeParametersArr3;
                }
                return cancelled;
            }
        });
        return cca_continue3;
    }

    /* renamed from: a */
    static /* synthetic */ ChallengeParameters[] m1840a(ChallengeParameters[] challengeParametersArr, int i) {
        ChallengeParameters[] challengeParametersArr2 = new ChallengeParameters[i];
        System.arraycopy(challengeParametersArr, 0, challengeParametersArr2, 0, challengeParametersArr.length);
        return challengeParametersArr2;
    }
}
