package com.cardinalcommerce.p060a;

import com.appsflyer.AppsFlyerLibCore;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.KeyFactorySpi */
public interface KeyFactorySpi {
    public static final ASN1ObjectIdentifier Cardinal;
    public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(Cardinal, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
    public static final ASN1ObjectIdentifier CardinalConfigurationParameters;
    public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(Cardinal, "11");
    public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(Cardinal, "8");
    public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier(Cardinal, DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
    public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(Cardinal, "12");
    public static final ASN1ObjectIdentifier Payment;
    public static final ASN1ObjectIdentifier ValidateResponse = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.7");
    public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(Cardinal, "3");
    public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(Cardinal, "7");
    public static final ASN1ObjectIdentifier configure;
    public static final ASN1ObjectIdentifier getActionCode;
    public static final ASN1ObjectIdentifier getChallengeTimeout = new ASN1ObjectIdentifier(setEnvironment, "5");
    public static final ASN1ObjectIdentifier getEnvironment = new ASN1ObjectIdentifier(setEnvironment, "4");
    public static final ASN1ObjectIdentifier getErrorNumber = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.5");
    public static final ASN1ObjectIdentifier getExtendedData;
    public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier(Cardinal, "4");
    public static final ASN1ObjectIdentifier getJSON;
    public static final ASN1ObjectIdentifier getProcessorTransactionId = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.6");
    public static final ASN1ObjectIdentifier getProxyAddress;
    public static final ASN1ObjectIdentifier getRenderType = new ASN1ObjectIdentifier(setEnvironment, "10").getInstance();
    public static final ASN1ObjectIdentifier getRequestTimeout;
    public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(Cardinal, "10");
    public static final ASN1ObjectIdentifier getString;
    public static final ASN1ObjectIdentifier getThreeDSRequestorAppURL;
    public static final ASN1ObjectIdentifier getType;
    public static final ASN1ObjectIdentifier getUICustomization = new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "8").getInstance();
    public static final ASN1ObjectIdentifier getUiType = new ASN1ObjectIdentifier(setEnvironment, "8").getInstance();
    public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(Cardinal, "5");
    public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(Cardinal, "2");
    public static final ASN1ObjectIdentifier isEnableDFSync = new ASN1ObjectIdentifier("1.2.840.113549.1.7.2").getInstance();
    public static final ASN1ObjectIdentifier isEnableLogging;
    public static final ASN1ObjectIdentifier isLocationDataConsentGiven;
    public static final ASN1ObjectIdentifier isValidated = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.10");
    public static final ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier(setEnvironment, "7").getInstance();
    public static final ASN1ObjectIdentifier setEnableDFSync;
    public static final ASN1ObjectIdentifier setEnableLogging = new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "16").getInstance();
    public static final ASN1ObjectIdentifier setEnvironment;
    public static final ASN1ObjectIdentifier setLocationDataConsentGiven;
    public static final ASN1ObjectIdentifier setProxyAddress = new ASN1ObjectIdentifier(setEnvironment, "9").getInstance();
    public static final ASN1ObjectIdentifier setRenderType = new ASN1ObjectIdentifier(setEnvironment, "11").getInstance();
    public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.1.3"), "1");
    public static final ASN1ObjectIdentifier setThreeDSRequestorAppURL;
    public static final ASN1ObjectIdentifier setUICustomization = new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "2").getInstance();
    public static final ASN1ObjectIdentifier setUiType = new ASN1ObjectIdentifier("1.2.840.113549.1.7.1").getInstance();
    public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(Cardinal, "14");
    public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(Cardinal, "9");

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$EC */
    public interface C1979EC {
        BigInteger cca_continue();

        BigInteger[] configure(byte[] bArr);

        void getInstance(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);

        boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2);
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ECDH */
    public final class ECDH extends KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo {
        public ECDH() {
        }

        public ECDH(String str) {
            super(str);
        }

        public ECDH(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ECDHC */
    public interface ECDHC {
        int Cardinal();

        int Cardinal(byte[] bArr) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalStateException;

        void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) throws IllegalArgumentException;

        void init(byte[] bArr, int i, int i2) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalStateException;
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ECDSA */
    public final class ECDSA extends KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo {
        public ECDSA(String str) {
            super(str);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ECGOST3410 */
    public interface ECGOST3410 {
        setKeyboardNavigationCluster Cardinal(InputStream inputStream) throws IOException;
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ECGOST3410_2012 */
    public interface ECGOST3410_2012 {
        byte[] cca_continue(setKeyboardNavigationCluster setkeyboardnavigationcluster);
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ECMQV */
    public interface ECMQV {
        int configure();

        void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr, int i);

        void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ED25519 */
    public final class ED25519 extends getBorderColor {
        public ED25519(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            super(mQVwithSHA256KDFAndSharedInfo);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$XDH */
    public interface XDH {
        void cca_continue(byte[] bArr);

        void configure(byte[] bArr);
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$ED448 */
    public final class ED448 implements KeyAgreementSpi.ECKAEGwithRIPEMD160KDF {
        public DigestSignatureSpi.SHA512 Cardinal;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.Cardinal = (DigestSignatureSpi.SHA512) gOST3410Util;
        }

        public final ExtendedInvalidKeySpecException init() {
            DigestSignatureSpi.SHA512_256 sha512_256 = this.Cardinal.init;
            SecureRandom secureRandom = this.Cardinal.getInstance;
            BigInteger bigInteger = sha512_256.configure;
            BigInteger bigInteger2 = sha512_256.cca_continue;
            BigInteger bigInteger3 = sha512_256.getInstance;
            while (true) {
                BigInteger configure = setSelected.configure(256, secureRandom);
                if (configure.signum() > 0 && configure.compareTo(bigInteger) < 0 && createTransaction.cca_continue(configure) >= 64) {
                    return new ExtendedInvalidKeySpecException(new DigestSignatureSpi.SHA3_384(bigInteger3.modPow(configure, bigInteger2), sha512_256), new DigestSignatureSpi.SHA512_224(configure, sha512_256));
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$EDDSA */
    public final class EDDSA implements KeyAgreementSpi.ECKAEGwithRIPEMD160KDF {
        private static final BigInteger Cardinal = BigInteger.valueOf(1);
        public PSSSignatureSpi.SHA1withRSA configure;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.configure = (PSSSignatureSpi.SHA1withRSA) gOST3410Util;
        }

        public final ExtendedInvalidKeySpecException init() {
            BigInteger configure2;
            BigInteger configure3;
            BigInteger multiply;
            BigInteger bigInteger;
            EDDSA eddsa = this;
            int i = eddsa.configure.values;
            int i2 = (i + 1) / 2;
            int i3 = i - i2;
            int i4 = i / 2;
            int i5 = i4 - 100;
            int i6 = i / 3;
            if (i5 < i6) {
                i5 = i6;
            }
            int i7 = i >> 2;
            BigInteger pow = BigInteger.valueOf(2).pow(i4);
            BigInteger shiftLeft = Cardinal.shiftLeft(i - 1);
            BigInteger shiftLeft2 = Cardinal.shiftLeft(i5);
            ExtendedInvalidKeySpecException extendedInvalidKeySpecException = null;
            boolean z = false;
            while (!z) {
                BigInteger bigInteger2 = eddsa.configure.cca_continue;
                do {
                    configure2 = eddsa.configure(i2, bigInteger2, shiftLeft);
                    while (true) {
                        configure3 = eddsa.configure(i3, bigInteger2, shiftLeft);
                        BigInteger abs = configure3.subtract(configure2).abs();
                        if (abs.bitLength() >= i5 && abs.compareTo(shiftLeft2) > 0) {
                            multiply = configure2.multiply(configure3);
                            if (multiply.bitLength() == i) {
                                break;
                            }
                            configure2 = configure2.max(configure3);
                        } else {
                            eddsa = this;
                            i = i;
                        }
                    }
                } while (createTransaction.cca_continue(multiply) < i7);
                if (configure2.compareTo(configure3) < 0) {
                    bigInteger = configure2;
                    configure2 = configure3;
                } else {
                    bigInteger = configure3;
                }
                BigInteger subtract = configure2.subtract(Cardinal);
                BigInteger subtract2 = bigInteger.subtract(Cardinal);
                int i8 = i;
                BigInteger modInverse = bigInteger2.modInverse(subtract.divide(subtract.gcd(subtract2)).multiply(subtract2));
                if (modInverse.compareTo(pow) > 0) {
                    BigInteger remainder = modInverse.remainder(subtract);
                    BigInteger remainder2 = modInverse.remainder(subtract2);
                    BigInteger modInverse2 = bigInteger.modInverse(configure2);
                    ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption = new ISOSignatureSpi.WhirlpoolWithRSAEncryption(false, multiply, bigInteger2);
                    PSSSignatureSpi.SHA224withRSA sHA224withRSA = r13;
                    PSSSignatureSpi.SHA224withRSA sHA224withRSA2 = new PSSSignatureSpi.SHA224withRSA(multiply, bigInteger2, modInverse, configure2, bigInteger, remainder, remainder2, modInverse2);
                    extendedInvalidKeySpecException = new ExtendedInvalidKeySpecException(whirlpoolWithRSAEncryption, sHA224withRSA);
                    z = true;
                }
                eddsa = this;
                i = i8;
            }
            return extendedInvalidKeySpecException;
        }

        private BigInteger configure(int i, BigInteger bigInteger, BigInteger bigInteger2) {
            for (int i2 = 0; i2 != i * 5; i2++) {
                BigInteger configure2 = setSelected.configure(i, 1, this.configure.getInstance);
                if (!configure2.mod(bigInteger).equals(Cardinal) && configure2.multiply(configure2).compareTo(bigInteger2) >= 0 && cca_continue(configure2) && bigInteger.gcd(configure2.subtract(Cardinal)).equals(Cardinal)) {
                    return configure2;
                }
            }
            throw new IllegalStateException("unable to generate prime number for RSA key");
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0066 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean cca_continue(java.math.BigInteger r10) {
            /*
                r9 = this;
                int r0 = r10.bitLength()
                com.cardinalcommerce.a.PSSSignatureSpi$SHA1withRSA r1 = r9.configure
                int r1 = r1.init
                r2 = 7
                r3 = 40
                r4 = 5
                r5 = 4
                r6 = 100
                r7 = 1
                r8 = 1536(0x600, float:2.152E-42)
                if (r0 < r8) goto L_0x0024
                if (r1 > r6) goto L_0x0018
                r2 = 3
                goto L_0x0056
            L_0x0018:
                r0 = 128(0x80, float:1.794E-43)
                if (r1 > r0) goto L_0x001d
                goto L_0x002a
            L_0x001d:
                int r1 = r1 - r0
                int r1 = r1 + r7
                int r1 = r1 / 2
                int r2 = r1 + 4
                goto L_0x0056
            L_0x0024:
                r8 = 1024(0x400, float:1.435E-42)
                if (r0 < r8) goto L_0x0038
                if (r1 > r6) goto L_0x002c
            L_0x002a:
                r2 = 4
                goto L_0x0056
            L_0x002c:
                r0 = 112(0x70, float:1.57E-43)
                if (r1 > r0) goto L_0x0031
                goto L_0x0040
            L_0x0031:
                int r1 = r1 - r0
                int r1 = r1 + r7
                int r1 = r1 / 2
                int r2 = r1 + 5
                goto L_0x0056
            L_0x0038:
                r5 = 512(0x200, float:7.175E-43)
                r8 = 80
                if (r0 < r5) goto L_0x004b
                if (r1 > r8) goto L_0x0042
            L_0x0040:
                r2 = 5
                goto L_0x0056
            L_0x0042:
                if (r1 > r6) goto L_0x0045
                goto L_0x0056
            L_0x0045:
                int r1 = r1 - r6
                int r1 = r1 + r7
                int r1 = r1 / 2
                int r2 = r2 + r1
                goto L_0x0056
            L_0x004b:
                if (r1 > r8) goto L_0x0050
                r2 = 40
                goto L_0x0056
            L_0x0050:
                int r1 = r1 - r8
                int r1 = r1 + r7
                int r1 = r1 / 2
                int r2 = r1 + 40
            L_0x0056:
                boolean r0 = com.cardinalcommerce.p060a.getSDKEphemeralPublicKey.getInstance(r10)
                if (r0 != 0) goto L_0x0067
                com.cardinalcommerce.a.PSSSignatureSpi$SHA1withRSA r0 = r9.configure
                java.security.SecureRandom r0 = r0.getInstance
                boolean r10 = com.cardinalcommerce.p060a.getSDKEphemeralPublicKey.getInstance(r10, r0, r2)
                if (r10 == 0) goto L_0x0067
                return r7
            L_0x0067:
                r10 = 0
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.KeyFactorySpi.EDDSA.cca_continue(java.math.BigInteger):boolean");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$X25519 */
    public final class X25519 implements KeyAgreementSpi.ECKAEGwithRIPEMD160KDF {
        private SecureRandom getInstance;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.getInstance = gOST3410Util.getInstance;
        }

        public final ExtendedInvalidKeySpecException init() {
            PSSSignatureSpi.SHA3_224withRSA sHA3_224withRSA = new PSSSignatureSpi.SHA3_224withRSA(this.getInstance);
            byte[] bArr = new byte[32];
            setOnHoverListener.Cardinal(sHA3_224withRSA.configure, 0, bArr, 0);
            return new ExtendedInvalidKeySpecException(new PSSSignatureSpi.SHA3_256withRSA(bArr, 0), sHA3_224withRSA);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyFactorySpi$X448 */
    public final class X448 implements KeyAgreementSpi.ECKAEGwithRIPEMD160KDF {
        private SecureRandom Cardinal;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.Cardinal = gOST3410Util.getInstance;
        }

        public final ExtendedInvalidKeySpecException init() {
            PSSSignatureSpi.SHA512_256withRSA sHA512_256withRSA = new PSSSignatureSpi.SHA512_256withRSA(this.Cardinal);
            byte[] bArr = new byte[56];
            setRevealOnFocusHint.Cardinal(sHA512_256withRSA.getInstance, 0, bArr, 0);
            return new ExtendedInvalidKeySpecException(new PSSSignatureSpi.SHA3_384withRSA(bArr, 0), sHA512_256withRSA);
        }
    }

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.113549.1.1");
        Cardinal = aSN1ObjectIdentifier;
        configure = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
        new ASN1ObjectIdentifier(Cardinal, "6");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = Cardinal;
        String str = DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH;
        getRequestTimeout = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "16");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("1.2.840.113549.1.5");
        CardinalConfigurationParameters = aSN1ObjectIdentifier3;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, "4");
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, "3");
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, "6");
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, "10");
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, "11");
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
        new ASN1ObjectIdentifier(CardinalConfigurationParameters, "12");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.2.840.113549.3");
        getActionCode = aSN1ObjectIdentifier4;
        getString = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "7");
        new ASN1ObjectIdentifier(getActionCode, "2");
        new ASN1ObjectIdentifier(getActionCode, "4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.2.840.113549.2");
        setEnvironment = aSN1ObjectIdentifier5;
        getProxyAddress = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "2");
        new ASN1ObjectIdentifier("1.2.840.113549.1.7").getInstance();
        new ASN1ObjectIdentifier("1.2.840.113549.1.7.3").getInstance();
        new ASN1ObjectIdentifier("1.2.840.113549.1.7.4").getInstance();
        new ASN1ObjectIdentifier("1.2.840.113549.1.7.5").getInstance();
        new ASN1ObjectIdentifier("1.2.840.113549.1.7.6").getInstance();
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("1.2.840.113549.1.9");
        getThreeDSRequestorAppURL = aSN1ObjectIdentifier6;
        setEnableDFSync = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "3").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "4").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "5").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "6").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "7").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "9").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS).getInstance();
        String str2 = "14";
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, str2).getInstance();
        String str3 = str;
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, str3).getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "20").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, ScarShareReportModel.CHANNEL_FACEBOOK).getInstance();
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = getThreeDSRequestorAppURL;
        String str4 = ScarShareReportModel.CHANNEL_FACEBOOK;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "22.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, ScarShareReportModel.CHANNEL_WHATSAPP);
        isLocationDataConsentGiven = aSN1ObjectIdentifier8;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "1").getInstance();
        new ASN1ObjectIdentifier(isLocationDataConsentGiven, "2").getInstance();
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = getThreeDSRequestorAppURL;
        String str5 = ScarShareReportModel.CHANNEL_WHATSAPP;
        new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, ScarShareReportModel.CHANNEL_TWITTER), "1").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "52").getInstance();
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "15.1");
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "15.2");
        new ASN1ObjectIdentifier(getThreeDSRequestorAppURL, "15.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.1");
        setLocationDataConsentGiven = aSN1ObjectIdentifier10;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, "2");
        new ASN1ObjectIdentifier(setLocationDataConsentGiven, "4");
        new ASN1ObjectIdentifier(setLocationDataConsentGiven, "9");
        new ASN1ObjectIdentifier(setLocationDataConsentGiven, ScarShareReportModel.CHANNEL_TWITTER);
        new ASN1ObjectIdentifier(setLocationDataConsentGiven, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier(setEnableLogging, "3");
        isEnableLogging = aSN1ObjectIdentifier11;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "9");
        new ASN1ObjectIdentifier(isEnableLogging, str2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.6");
        setThreeDSRequestorAppURL = aSN1ObjectIdentifier12;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "1");
        new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "2");
        new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "3");
        new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "4");
        new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "5");
        new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "6");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2");
        getExtendedData = aSN1ObjectIdentifier13;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "1");
        new ASN1ObjectIdentifier(getExtendedData, "4");
        new ASN1ObjectIdentifier(getExtendedData, "5");
        new ASN1ObjectIdentifier(getExtendedData, "10");
        new ASN1ObjectIdentifier(getExtendedData, "11");
        new ASN1ObjectIdentifier(getExtendedData, "12");
        new ASN1ObjectIdentifier(getExtendedData, DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CONFIRM);
        new ASN1ObjectIdentifier(getExtendedData, "7");
        new ASN1ObjectIdentifier(getExtendedData, str2);
        new ASN1ObjectIdentifier(getExtendedData, str3);
        new ASN1ObjectIdentifier(getExtendedData, "16");
        new ASN1ObjectIdentifier(getExtendedData, DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
        new ASN1ObjectIdentifier(getExtendedData, DiFaceLogger.EVENT_ID_ENTER_APPEAL_DIALOG);
        new ASN1ObjectIdentifier(getExtendedData, DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL);
        new ASN1ObjectIdentifier(getExtendedData, "20");
        new ASN1ObjectIdentifier(getExtendedData, str4);
        new ASN1ObjectIdentifier(getExtendedData, str5);
        new ASN1ObjectIdentifier(getExtendedData, ScarShareReportModel.CHANNEL_TWITTER);
        new ASN1ObjectIdentifier(getExtendedData, ScarShareReportModel.CHANNEL_MESSENGER);
        new ASN1ObjectIdentifier(getExtendedData, ScarShareReportModel.CHANNEL_EMAIL);
        new ASN1ObjectIdentifier(getExtendedData, ScarShareReportModel.CHANNEL_LINE);
        new ASN1ObjectIdentifier(getExtendedData, "27");
        new ASN1ObjectIdentifier(getExtendedData, "37");
        new ASN1ObjectIdentifier(getExtendedData, AppsFlyerLibCore.f1788);
        new ASN1ObjectIdentifier(getExtendedData, DiFaceLogger.EVENT_ID_CHECK_MODEL_REQ_CALLBACK);
        new ASN1ObjectIdentifier(getExtendedData, "43");
        new ASN1ObjectIdentifier(getExtendedData, "40");
        new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.5.1");
        new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.5.2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("1.2.840.113549.1.12");
        getJSON = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier14, "10.1");
        Payment = aSN1ObjectIdentifier15;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier15, "1");
        new ASN1ObjectIdentifier(Payment, "2");
        new ASN1ObjectIdentifier(Payment, "3");
        new ASN1ObjectIdentifier(Payment, "4");
        new ASN1ObjectIdentifier(Payment, "5");
        new ASN1ObjectIdentifier(Payment, "6");
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = new ASN1ObjectIdentifier(getJSON, "1");
        getType = aSN1ObjectIdentifier16;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier16, "1");
        new ASN1ObjectIdentifier(getType, "2");
        new ASN1ObjectIdentifier(getType, "3");
        new ASN1ObjectIdentifier(getType, "4");
        new ASN1ObjectIdentifier(getType, "5");
        new ASN1ObjectIdentifier(getType, "6");
        new ASN1ObjectIdentifier(getType, "6");
    }
}
