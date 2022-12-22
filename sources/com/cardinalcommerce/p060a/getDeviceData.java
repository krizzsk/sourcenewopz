package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getDeviceData */
public final class getDeviceData implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    private byte[] Cardinal;
    public ASN1ObjectIdentifier configure;
    private byte[] getInstance;
    public int init;

    public getDeviceData() {
    }

    private static ChallengeParameters Cardinal(ChallengeParameters[] challengeParametersArr, ChallengeParameters[] challengeParametersArr2, byte[] bArr, ChallengeParameters[] challengeParametersArr3, ChallengeParameters[] challengeParametersArr4, byte[] bArr2) {
        ChallengeParameters challengeParameters;
        int max = Math.max(bArr.length, bArr2.length);
        ChallengeParameters init2 = challengeParametersArr[0].cca_continue().init();
        int i = max - 1;
        ChallengeParameters challengeParameters2 = init2;
        int i2 = 0;
        while (i >= 0) {
            byte b = i < bArr.length ? bArr[i] : 0;
            byte b2 = i < bArr2.length ? bArr2[i] : 0;
            if ((b | b2) == 0) {
                i2++;
            } else {
                if (b != 0) {
                    challengeParameters = init2.getInstance((b < 0 ? challengeParametersArr2 : challengeParametersArr)[Math.abs(b) >>> 1]);
                } else {
                    challengeParameters = init2;
                }
                if (b2 != 0) {
                    challengeParameters = challengeParameters.getInstance((b2 < 0 ? challengeParametersArr4 : challengeParametersArr3)[Math.abs(b2) >>> 1]);
                }
                if (i2 > 0) {
                    challengeParameters2 = challengeParameters2.getInstance(i2);
                    i2 = 0;
                }
                challengeParameters2 = challengeParameters2.Cardinal(challengeParameters);
            }
            i--;
        }
        return i2 > 0 ? challengeParameters2.getInstance(i2) : challengeParameters2;
    }

    public static ChallengeParameters cca_continue(ChallengeParameters challengeParameters, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        ChallengeParameters init2 = challengeParameters.cca_continue().init();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                init2 = challengeParameters;
            }
            for (int i = 1; i < bitLength; i++) {
                challengeParameters = challengeParameters.getRequestTimeout();
                if (abs.testBit(i)) {
                    init2 = init2.getInstance(challengeParameters);
                }
            }
        }
        return bigInteger.signum() < 0 ? init2.getString() : init2;
    }

    private static boolean cca_continue(setAccessibilityPaneTitle setaccessibilitypanetitle) {
        return setaccessibilitypanetitle.getInstance() > 1 && setaccessibilitypanetitle.Cardinal().equals(getSDKReferenceNumber.CardinalEnvironment) && (setaccessibilitypanetitle instanceof setContentCaptureSession);
    }

    public static void configure(getAcsTransactionID[] getacstransactionidArr, int i, getAcsTransactionID getacstransactionid) {
        getAcsTransactionID[] getacstransactionidArr2 = new getAcsTransactionID[i];
        getacstransactionidArr2[0] = getacstransactionidArr[0];
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 >= i) {
                break;
            }
            getacstransactionidArr2[i2] = getacstransactionidArr2[i2 - 1].init(getacstransactionidArr[i2]);
        }
        int i3 = i2 - 1;
        if (getacstransactionid != null) {
            getacstransactionidArr2[i3] = getacstransactionidArr2[i3].init(getacstransactionid);
        }
        getAcsTransactionID sDKVersion = getacstransactionidArr2[i3].getSDKVersion();
        while (i3 > 0) {
            int i4 = i3 - 1;
            int i5 = i3 + 0;
            getAcsTransactionID getacstransactionid2 = getacstransactionidArr[i5];
            getacstransactionidArr[i5] = getacstransactionidArr2[i4].init(sDKVersion);
            sDKVersion = sDKVersion.init(getacstransactionid2);
            i3 = i4;
        }
        getacstransactionidArr[0] = sDKVersion;
    }

    public static ChallengeParameters getInstance(getSDKAppID getsdkappid, ChallengeParameters challengeParameters) {
        if (getsdkappid.configure(challengeParameters.cca_continue())) {
            return getsdkappid.configure(challengeParameters.configure(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean init(setAccessibilityPaneTitle setaccessibilitypanetitle) {
        return setaccessibilitypanetitle.getInstance() == 1;
    }

    public static boolean Cardinal(getSDKAppID getsdkappid) {
        return cca_continue(getsdkappid.configure);
    }

    public static boolean getInstance(getSDKAppID getsdkappid) {
        return init(getsdkappid.configure);
    }

    public static ChallengeParameters init(ChallengeParameters challengeParameters, BigInteger bigInteger, ChallengeParameters challengeParameters2, BigInteger bigInteger2) {
        getSDKAppID cca_continue = challengeParameters.cca_continue();
        if (cca_continue.configure(challengeParameters2.cca_continue())) {
            ChallengeParameters Cardinal2 = cca_continue.Cardinal(challengeParameters2);
            if (!(cca_continue instanceof getSDKAppID.Cardinal) || !((getSDKAppID.Cardinal) cca_continue).CardinalRenderType()) {
                setOnLongClickListener CardinalEnvironment = cca_continue.CardinalEnvironment();
                if (CardinalEnvironment instanceof setOnGenericMotionListener) {
                    ChallengeParameters instance = getInstance(new ChallengeParameters[]{challengeParameters, Cardinal2}, new BigInteger[]{bigInteger, bigInteger2}, (setOnGenericMotionListener) CardinalEnvironment);
                    if (instance.setRequestTimeout()) {
                        return instance;
                    }
                    throw new IllegalStateException("Invalid result");
                }
                ChallengeParameters instance2 = getInstance(challengeParameters, bigInteger, Cardinal2, bigInteger2);
                if (instance2.setRequestTimeout()) {
                    return instance2;
                }
                throw new IllegalStateException("Invalid result");
            }
            ChallengeParameters instance3 = challengeParameters.configure(bigInteger).getInstance(Cardinal2.configure(bigInteger2));
            if (instance3.setRequestTimeout()) {
                return instance3;
            }
            throw new IllegalStateException("Invalid result");
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    private static ChallengeParameters getInstance(ChallengeParameters challengeParameters, BigInteger bigInteger, ChallengeParameters challengeParameters2, BigInteger bigInteger2) {
        ChallengeParameters[] challengeParametersArr;
        ChallengeParameters[] challengeParametersArr2;
        ChallengeParameters[] challengeParametersArr3;
        ChallengeParameters[] challengeParametersArr4;
        boolean z = false;
        boolean z2 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, createTransaction.Cardinal(abs.bitLength())));
        int max2 = Math.max(2, Math.min(16, createTransaction.Cardinal(abs2.bitLength())));
        cancelled Cardinal2 = createTransaction.Cardinal(challengeParameters, max, true);
        cancelled Cardinal3 = createTransaction.Cardinal(challengeParameters2, max2, true);
        if (z2) {
            challengeParametersArr = Cardinal2.cca_continue;
        } else {
            challengeParametersArr = Cardinal2.configure;
        }
        ChallengeParameters[] challengeParametersArr5 = challengeParametersArr;
        if (z) {
            challengeParametersArr2 = Cardinal3.cca_continue;
        } else {
            challengeParametersArr2 = Cardinal3.configure;
        }
        ChallengeParameters[] challengeParametersArr6 = challengeParametersArr2;
        if (z2) {
            challengeParametersArr3 = Cardinal2.configure;
        } else {
            challengeParametersArr3 = Cardinal2.cca_continue;
        }
        ChallengeParameters[] challengeParametersArr7 = challengeParametersArr3;
        if (z) {
            challengeParametersArr4 = Cardinal3.configure;
        } else {
            challengeParametersArr4 = Cardinal3.cca_continue;
        }
        return Cardinal(challengeParametersArr5, challengeParametersArr7, createTransaction.cca_continue(max, abs), challengeParametersArr6, challengeParametersArr4, createTransaction.cca_continue(max2, abs2));
    }

    static ChallengeParameters getInstance(ChallengeParameters challengeParameters, BigInteger bigInteger, get3DSServerTransactionID get3dsservertransactionid, BigInteger bigInteger2) {
        ChallengeParameters[] challengeParametersArr;
        ChallengeParameters[] challengeParametersArr2;
        ChallengeParameters[] challengeParametersArr3;
        ChallengeParameters[] challengeParametersArr4;
        boolean z = true;
        boolean z2 = bigInteger.signum() < 0;
        if (bigInteger2.signum() >= 0) {
            z = false;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, createTransaction.Cardinal(Math.max(abs.bitLength(), abs2.bitLength()))));
        ChallengeParameters Cardinal2 = createTransaction.Cardinal(challengeParameters, max, get3dsservertransactionid);
        cancelled Cardinal3 = createTransaction.Cardinal(challengeParameters);
        cancelled Cardinal4 = createTransaction.Cardinal(Cardinal2);
        if (z2) {
            challengeParametersArr = Cardinal3.cca_continue;
        } else {
            challengeParametersArr = Cardinal3.configure;
        }
        ChallengeParameters[] challengeParametersArr5 = challengeParametersArr;
        if (z) {
            challengeParametersArr2 = Cardinal4.cca_continue;
        } else {
            challengeParametersArr2 = Cardinal4.configure;
        }
        ChallengeParameters[] challengeParametersArr6 = challengeParametersArr2;
        if (z2) {
            challengeParametersArr3 = Cardinal3.configure;
        } else {
            challengeParametersArr3 = Cardinal3.cca_continue;
        }
        ChallengeParameters[] challengeParametersArr7 = challengeParametersArr3;
        if (z) {
            challengeParametersArr4 = Cardinal4.configure;
        } else {
            challengeParametersArr4 = Cardinal4.cca_continue;
        }
        return Cardinal(challengeParametersArr5, challengeParametersArr7, createTransaction.cca_continue(max, abs), challengeParametersArr6, challengeParametersArr4, createTransaction.cca_continue(max, abs2));
    }

    private static ChallengeParameters getInstance(ChallengeParameters[] challengeParametersArr, BigInteger[] bigIntegerArr, setOnGenericMotionListener setongenericmotionlistener) {
        ChallengeParameters[] challengeParametersArr2;
        ChallengeParameters[] challengeParametersArr3 = challengeParametersArr;
        BigInteger values = challengeParametersArr3[0].cca_continue().values();
        BigInteger[] bigIntegerArr2 = new BigInteger[4];
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            BigInteger[] init2 = setongenericmotionlistener.init(bigIntegerArr[i2].mod(values));
            int i3 = i + 1;
            bigIntegerArr2[i] = init2[0];
            i = i3 + 1;
            bigIntegerArr2[i3] = init2[1];
        }
        setOnGenericMotionListener setongenericmotionlistener2 = setongenericmotionlistener;
        get3DSServerTransactionID cca_continue = setongenericmotionlistener.cca_continue();
        int length = challengeParametersArr3.length;
        int i4 = length << 1;
        boolean[] zArr = new boolean[i4];
        cancelled[] cancelledArr = new cancelled[i4];
        byte[][] bArr = new byte[i4][];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 << 1;
            int i7 = i6 + 1;
            BigInteger bigInteger = bigIntegerArr2[i6];
            zArr[i6] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr2[i7];
            zArr[i7] = bigInteger2.signum() < 0;
            BigInteger abs2 = bigInteger2.abs();
            int max = Math.max(2, Math.min(16, createTransaction.Cardinal(Math.max(abs.bitLength(), abs2.bitLength()))));
            ChallengeParameters challengeParameters = challengeParametersArr3[i5];
            ChallengeParameters Cardinal2 = createTransaction.Cardinal(challengeParameters, max, cca_continue);
            cancelledArr[i6] = createTransaction.Cardinal(challengeParameters);
            cancelledArr[i7] = createTransaction.Cardinal(Cardinal2);
            bArr[i6] = createTransaction.cca_continue(max, abs);
            bArr[i7] = createTransaction.cca_continue(max, abs2);
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            i8 = Math.max(i8, bArr[i9].length);
        }
        ChallengeParameters init3 = cancelledArr[0].configure[0].cca_continue().init();
        int i10 = i8 - 1;
        ChallengeParameters challengeParameters2 = init3;
        int i11 = 0;
        while (i10 >= 0) {
            ChallengeParameters challengeParameters3 = init3;
            for (int i12 = 0; i12 < i4; i12++) {
                byte[] bArr2 = bArr[i12];
                byte b = i10 < bArr2.length ? bArr2[i10] : 0;
                if (b != 0) {
                    int abs3 = Math.abs(b);
                    cancelled cancelled = cancelledArr[i12];
                    if ((b < 0) == zArr[i12]) {
                        challengeParametersArr2 = cancelled.configure;
                    } else {
                        challengeParametersArr2 = cancelled.cca_continue;
                    }
                    challengeParameters3 = challengeParameters3.getInstance(challengeParametersArr2[abs3 >>> 1]);
                }
            }
            if (challengeParameters3 == init3) {
                i11++;
            } else {
                if (i11 > 0) {
                    challengeParameters2 = challengeParameters2.getInstance(i11);
                    i11 = 0;
                }
                challengeParameters2 = challengeParameters2.Cardinal(challengeParameters3);
            }
            i10--;
        }
        return i11 > 0 ? challengeParameters2.getInstance(i11) : challengeParameters2;
    }

    public getDeviceData(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.configure = aSN1ObjectIdentifier;
        this.init = i;
        this.getInstance = bArr;
        this.Cardinal = bArr2;
    }

    public final byte[] init() {
        return this.getInstance;
    }

    public final byte[] Cardinal() {
        return this.Cardinal;
    }
}
