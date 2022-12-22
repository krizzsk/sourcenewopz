package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.Utf8;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cardinalcommerce.a.SignatureSpi */
public final class SignatureSpi extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private setThreeDSRequestorAppURL f2477a = null;

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$EdDSA */
    public final class EdDSA implements KeyPairGeneratorSpi.XDH {
        public final int configure(byte[] bArr) throws KeyFactorySpi.ECDH {
            byte b = bArr[bArr.length - 1] & 255;
            byte b2 = (byte) b;
            boolean z = (b > bArr.length) | (b == 0);
            for (int i = 0; i < bArr.length; i++) {
                z |= (bArr.length - i <= b) & (bArr[i] != b2);
            }
            if (!z) {
                return b;
            }
            throw new KeyFactorySpi.ECDH("pad block corrupted");
        }

        public final int configure(byte[] bArr, int i) {
            byte length = (byte) (bArr.length - i);
            while (i < bArr.length) {
                bArr[i] = length;
                i++;
            }
            return length;
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSARipeMD160 */
    public final class ecDSARipeMD160 extends ecDSASha3_256 {
        private static final byte[] cca_continue = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        public ecDSARipeMD160() {
            super(cca_continue);
        }

        private ecDSARipeMD160(ecDSARipeMD160 ecdsaripemd160) {
            super(cca_continue);
            cca_continue(ecdsaripemd160);
        }

        public final int configure(byte[] bArr, int i) {
            byte[] bArr2 = new byte[64];
            super.configure(bArr2, 0);
            System.arraycopy(bArr2, 32, bArr, i, 32);
            return 32;
        }

        public final String configure() {
            return "GOST3411-2012-256";
        }

        public final int getInstance() {
            return 32;
        }

        public final setPaddingRelative init() {
            return new ecDSARipeMD160(this);
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSA */
    public final class ecDetDSA implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo, setPaddingRelative {
        private static final byte[] CardinalError = {41, 46, 67, -55, -94, -40, 124, 1, 61, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, 115, -116, -104, -109, 43, -39, PSSSigner.TRAILER_IMPLICIT, 76, -126, -54, Ascii.f53592RS, -101, 87, 60, -3, -44, -32, Ascii.SYN, 103, 66, 111, Ascii.CAN, -118, Ascii.ETB, -27, Ascii.DC2, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, Ascii.NAK, -78, 7, Utf8.REPLACEMENT_BYTE, -108, -62, 16, -119, 11, 34, 95, 33, Byte.MIN_VALUE, Byte.MAX_VALUE, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, Ascii.f53585EM, 48, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, -49, 101, -26, 45, -88, 2, Ascii.ESC, 96, 37, -83, -82, -80, -71, -10, Ascii.f53587FS, 70, 97, 105, 52, 64, 126, Ascii.f53593SI, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, Ascii.f53584CR, 110, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 36, -31, 123, 8, Ascii.f53586FF, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, Ascii.f53588GS, 57, -14, -17, -73, Ascii.f53594SO, 102, 88, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, Ascii.f53596US, Ascii.SUB, -37, -103, -115, 51, -97, 17, -125, Ascii.DC4};
        private byte[] Cardinal = new byte[16];
        private byte[] cca_continue = new byte[48];
        private int cleanup;
        private int configure;
        private int getInstance;
        private byte[] init = new byte[16];

        public ecDetDSA() {
            cca_continue();
        }

        private ecDetDSA(ecDetDSA ecdetdsa) {
            Cardinal(ecdetdsa);
        }

        private void Cardinal(ecDetDSA ecdetdsa) {
            byte[] bArr = ecdetdsa.cca_continue;
            System.arraycopy(bArr, 0, this.cca_continue, 0, bArr.length);
            this.getInstance = ecdetdsa.getInstance;
            byte[] bArr2 = ecdetdsa.init;
            System.arraycopy(bArr2, 0, this.init, 0, bArr2.length);
            this.configure = ecdetdsa.configure;
            byte[] bArr3 = ecdetdsa.Cardinal;
            System.arraycopy(bArr3, 0, this.Cardinal, 0, bArr3.length);
            this.cleanup = ecdetdsa.cleanup;
        }

        private void Cardinal(byte[] bArr) {
            for (int i = 0; i < 16; i++) {
                byte[] bArr2 = this.cca_continue;
                bArr2[i + 16] = bArr[i];
                bArr2[i + 32] = (byte) (bArr[i] ^ bArr2[i]);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 18; i3++) {
                for (int i4 = 0; i4 < 48; i4++) {
                    byte[] bArr3 = this.cca_continue;
                    byte b = (byte) (CardinalError[i2] ^ bArr3[i4]);
                    bArr3[i4] = b;
                    i2 = b & 255;
                }
                i2 = (i2 + i3) % 256;
            }
        }

        private void configure(byte[] bArr) {
            byte b = this.Cardinal[15];
            for (int i = 0; i < 16; i++) {
                byte[] bArr2 = this.Cardinal;
                bArr2[i] = (byte) (CardinalError[(b ^ bArr[i]) & 255] ^ bArr2[i]);
                b = bArr2[i];
            }
        }

        public final int Cardinal() {
            return 16;
        }

        public final void Cardinal(byte b) {
            byte[] bArr = this.init;
            int i = this.configure;
            int i2 = i + 1;
            this.configure = i2;
            bArr[i] = b;
            if (i2 == 16) {
                configure(bArr);
                Cardinal(this.init);
                this.configure = 0;
            }
        }

        public final void cca_continue() {
            this.getInstance = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.cca_continue;
                if (i == bArr.length) {
                    break;
                }
                bArr[i] = 0;
                i++;
            }
            this.configure = 0;
            int i2 = 0;
            while (true) {
                byte[] bArr2 = this.init;
                if (i2 == bArr2.length) {
                    break;
                }
                bArr2[i2] = 0;
                i2++;
            }
            this.cleanup = 0;
            int i3 = 0;
            while (true) {
                byte[] bArr3 = this.Cardinal;
                if (i3 != bArr3.length) {
                    bArr3[i3] = 0;
                    i3++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            Cardinal((ecDetDSA) setpaddingrelative);
        }

        public final int configure(byte[] bArr, int i) {
            int length = this.init.length;
            int i2 = this.configure;
            byte b = (byte) (length - i2);
            while (true) {
                byte[] bArr2 = this.init;
                if (i2 < bArr2.length) {
                    bArr2[i2] = b;
                    i2++;
                } else {
                    configure(bArr2);
                    Cardinal(this.init);
                    Cardinal(this.Cardinal);
                    System.arraycopy(this.cca_continue, this.getInstance, bArr, i, 16);
                    cca_continue();
                    return 16;
                }
            }
        }

        public final String configure() {
            return MessageDigestAlgorithms.MD2;
        }

        public final int getInstance() {
            return 16;
        }

        public final setPaddingRelative init() {
            return new ecDetDSA(this);
        }

        public final void init(byte[] bArr, int i, int i2) {
            while (this.configure != 0 && i2 > 0) {
                Cardinal(bArr[i]);
                i++;
                i2--;
            }
            while (i2 > 16) {
                System.arraycopy(bArr, i, this.init, 0, 16);
                configure(this.init);
                Cardinal(this.init);
                i2 -= 16;
                i += 16;
            }
            while (i2 > 0) {
                Cardinal(bArr[i]);
                i++;
                i2--;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSA224 */
    public abstract class ecDetDSA224 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo, setPaddingRelative {
        private final byte[] configure;
        private int getInstance;
        private long init;

        protected ecDetDSA224() {
            this.configure = new byte[4];
            this.getInstance = 0;
        }

        protected ecDetDSA224(ecDetDSA224 ecdetdsa224) {
            this.configure = new byte[4];
            getInstance(ecdetdsa224);
        }

        public final int Cardinal() {
            return 64;
        }

        public final void Cardinal(byte b) {
            byte[] bArr = this.configure;
            int i = this.getInstance;
            int i2 = i + 1;
            this.getInstance = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                cca_continue(bArr, 0);
                this.getInstance = 0;
            }
            this.init++;
        }

        public void cca_continue() {
            this.init = 0;
            this.getInstance = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.configure;
                if (i < bArr.length) {
                    bArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void cca_continue(byte[] bArr, int i);

        /* access modifiers changed from: protected */
        public abstract void cleanup();

        /* access modifiers changed from: protected */
        public final void getInstance(ecDetDSA224 ecdetdsa224) {
            byte[] bArr = ecdetdsa224.configure;
            System.arraycopy(bArr, 0, this.configure, 0, bArr.length);
            this.getInstance = ecdetdsa224.getInstance;
            this.init = ecdetdsa224.init;
        }

        /* access modifiers changed from: protected */
        public abstract void init(long j);

        public final void init(byte[] bArr, int i, int i2) {
            int i3 = 0;
            int max = Math.max(0, i2);
            if (this.getInstance != 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= max) {
                        i3 = i4;
                        break;
                    }
                    byte[] bArr2 = this.configure;
                    int i5 = this.getInstance;
                    int i6 = i5 + 1;
                    this.getInstance = i6;
                    int i7 = i4 + 1;
                    bArr2[i5] = bArr[i4 + i];
                    if (i6 == 4) {
                        cca_continue(bArr2, 0);
                        this.getInstance = 0;
                        i3 = i7;
                        break;
                    }
                    i4 = i7;
                }
            }
            int i8 = ((max - i3) & -4) + i3;
            while (i3 < i8) {
                cca_continue(bArr, i + i3);
                i3 += 4;
            }
            while (i3 < max) {
                byte[] bArr3 = this.configure;
                int i9 = this.getInstance;
                this.getInstance = i9 + 1;
                bArr3[i9] = bArr[i3 + i];
                i3++;
            }
            this.init += (long) max;
        }

        public final void values() {
            long j = this.init << 3;
            byte b = Byte.MIN_VALUE;
            while (true) {
                Cardinal(b);
                if (this.getInstance != 0) {
                    b = 0;
                } else {
                    init(j);
                    cleanup();
                    return;
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSA256 */
    public final class ecDetDSA256 extends ecDSASha3_256 {
        private static final byte[] init = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        public ecDetDSA256() {
            super(init);
        }

        private ecDetDSA256(ecDetDSA256 ecdetdsa256) {
            super(init);
            cca_continue(ecdetdsa256);
        }

        public final String configure() {
            return "GOST3411-2012-512";
        }

        public final int getInstance() {
            return 64;
        }

        public final setPaddingRelative init() {
            return new ecDetDSA256(this);
        }
    }

    public SignatureSpi(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.f2477a = setthreedsrequestorappurl;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("CRLDistPoint:");
        stringBuffer.append(instance);
        GMCipherSpi.SM2withMD5[] a = m1822a();
        for (int i = 0; i != a.length; i++) {
            stringBuffer.append("    ");
            stringBuffer.append(a[i]);
            stringBuffer.append(instance);
        }
        return stringBuffer.toString();
    }

    public final setLocationDataConsentGiven values() {
        return this.f2477a;
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSASha3_224 */
    public final class ecDetDSASha3_224 implements KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo {
        private C1983init configure = new C1983init((byte) 0);

        public final void Cardinal(byte b) {
            this.configure.write(b);
        }

        public final void cca_continue() {
            this.configure.reset();
        }

        public final String configure() {
            return "NULL";
        }

        public final int getInstance() {
            return this.configure.size();
        }

        public final void init(byte[] bArr, int i, int i2) {
            this.configure.write(bArr, i, i2);
        }

        /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSASha3_224$init */
        static class C1983init extends ByteArrayOutputStream {
            private C1983init() {
            }

            /* synthetic */ C1983init(byte b) {
                this();
            }

            /* access modifiers changed from: package-private */
            public final void init(byte[] bArr, int i) {
                System.arraycopy(this.buf, 0, bArr, i, size());
            }

            public final void reset() {
                super.reset();
                byte[] bArr = this.buf;
                if (bArr != null) {
                    for (int i = 0; i < bArr.length; i++) {
                        bArr[i] = 0;
                    }
                }
            }
        }

        public final int configure(byte[] bArr, int i) {
            int size = this.configure.size();
            this.configure.init(bArr, i);
            this.configure.reset();
            return size;
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecCVCDSA */
    public final class ecCVCDSA implements KeyAgreementSpi.ECKAEGwithSHA224KDF {
        private static final BigInteger init = BigInteger.valueOf(1);
        private CipherSpi cca_continue;
        private BCElGamalPublicKey getInstance;

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                eCKAEGwithSHA512KDF = ((ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance;
            }
            setKeyboardNavigationCluster setkeyboardnavigationcluster = (setKeyboardNavigationCluster) eCKAEGwithSHA512KDF;
            if (setkeyboardnavigationcluster instanceof BCElGamalPublicKey) {
                BCElGamalPublicKey bCElGamalPublicKey = (BCElGamalPublicKey) setkeyboardnavigationcluster;
                this.getInstance = bCElGamalPublicKey;
                this.cca_continue = bCElGamalPublicKey.configure;
                return;
            }
            throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
        }

        public final int cca_continue() {
            return (this.getInstance.configure.Cardinal.bitLength() + 7) / 8;
        }

        public final BigInteger Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding = (CipherSpi.PKCS1v1_5Padding) eCKAEGwithSHA512KDF;
            if (pKCS1v1_5Padding.configure.equals(this.cca_continue)) {
                BigInteger bigInteger = this.cca_continue.Cardinal;
                BigInteger bigInteger2 = pKCS1v1_5Padding.Cardinal;
                if (bigInteger2 == null || bigInteger2.compareTo(init) <= 0 || bigInteger2.compareTo(bigInteger.subtract(init)) >= 0) {
                    throw new IllegalArgumentException("Diffie-Hellman public key is weak");
                }
                BigInteger modPow = bigInteger2.modPow(this.getInstance.Cardinal, bigInteger);
                if (!modPow.equals(init)) {
                    return modPow;
                }
                throw new IllegalStateException("Shared key can't be 1");
            }
            throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecCVCDSA224 */
    public final class ecCVCDSA224 {
        public setVerticalFadingEdgeEnabled getInstance;

        public final byte[] getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            setScrollBarDefaultDelayBeforeFade setscrollbardefaultdelaybeforefade = (setScrollBarDefaultDelayBeforeFade) eCKAEGwithSHA512KDF;
            ecCVCDSA eccvcdsa = new ecCVCDSA();
            ecCVCDSA eccvcdsa2 = new ecCVCDSA();
            eccvcdsa.configure(this.getInstance.getInstance);
            BigInteger Cardinal = eccvcdsa.Cardinal(setscrollbardefaultdelaybeforefade.cca_continue);
            eccvcdsa2.configure(this.getInstance.init);
            return setForegroundTintBlendMode.cca_continue(setSelected.Cardinal((this.getInstance.getInstance.configure.Cardinal.bitLength() + 7) / 8, eccvcdsa2.Cardinal(setscrollbardefaultdelaybeforefade.init)), setSelected.Cardinal((this.getInstance.getInstance.configure.Cardinal.bitLength() + 7) / 8, Cardinal));
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecCVCDSA256 */
    public final class ecCVCDSA256 {
        public setTag getInstance;

        public final byte[] init(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            KeyAgreementSpi.DHwithSHA256KDFAndSharedInfo dHwithSHA256KDFAndSharedInfo = (KeyAgreementSpi.DHwithSHA256KDFAndSharedInfo) eCKAEGwithSHA512KDF;
            ecCVCDSA384 eccvcdsa384 = new ecCVCDSA384();
            ecCVCDSA384 eccvcdsa3842 = new ecCVCDSA384();
            eccvcdsa384.getInstance = this.getInstance.configure;
            BigInteger Cardinal = eccvcdsa384.Cardinal(dHwithSHA256KDFAndSharedInfo.init);
            eccvcdsa3842.getInstance = this.getInstance.getInstance;
            return setForegroundTintBlendMode.cca_continue(setSelected.Cardinal((this.getInstance.configure.init.Cardinal.configure() + 7) / 8, eccvcdsa3842.Cardinal(dHwithSHA256KDFAndSharedInfo.configure)), setSelected.Cardinal((this.getInstance.configure.init.Cardinal.configure() + 7) / 8, Cardinal));
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecCVCDSA384 */
    public final class ecCVCDSA384 implements KeyAgreementSpi.ECKAEGwithSHA224KDF {
        DigestSignatureSpi.MD2 getInstance;

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.getInstance = (DigestSignatureSpi.MD2) eCKAEGwithSHA512KDF;
        }

        public final int cca_continue() {
            return (this.getInstance.init.Cardinal.configure() + 7) / 8;
        }

        public final BigInteger Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
            BCRSAPublicKey bCRSAPublicKey = this.getInstance.init;
            if (bCRSAPublicKey.equals(digestSignatureSpi.init)) {
                BigInteger mod = bCRSAPublicKey.getInstance.multiply(this.getInstance.Cardinal).mod(bCRSAPublicKey.cca_continue);
                ChallengeParameters instance = getDeviceData.getInstance(bCRSAPublicKey.Cardinal, digestSignatureSpi.cca_continue);
                if (!instance.valueOf()) {
                    ChallengeParameters CardinalRenderType = instance.configure(mod).CardinalRenderType();
                    if (!CardinalRenderType.valueOf()) {
                        return CardinalRenderType.getSDKVersion().Cardinal();
                    }
                    throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
                }
                throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
            }
            throw new IllegalStateException("ECDHC public key has wrong domain parameters");
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecCVCDSA512 */
    public final class ecCVCDSA512 implements KeyAgreementSpi.ECKAEGwithSHA224KDF {
        private static final BigInteger cca_continue = BigInteger.valueOf(1);
        private setTransitionVisibility configure;

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.configure = (setTransitionVisibility) eCKAEGwithSHA512KDF;
        }

        public final int cca_continue() {
            return (this.configure.init.configure.Cardinal.bitLength() + 7) / 8;
        }

        public final BigInteger Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            setClipToOutline setcliptooutline = (setClipToOutline) eCKAEGwithSHA512KDF;
            BCElGamalPublicKey bCElGamalPublicKey = this.configure.init;
            if (!this.configure.init.configure.equals(setcliptooutline.configure.configure)) {
                throw new IllegalStateException("MQV public key components have wrong domain parameters");
            } else if (this.configure.init.configure.getInstance != null) {
                CipherSpi cipherSpi = bCElGamalPublicKey.configure;
                CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding = setcliptooutline.configure;
                BCElGamalPublicKey bCElGamalPublicKey2 = this.configure.Cardinal;
                CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding2 = this.configure.cca_continue;
                CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding3 = setcliptooutline.getInstance;
                BigInteger bigInteger = cipherSpi.getInstance;
                BigInteger pow = BigInteger.valueOf(2).pow((bigInteger.bitLength() + 1) / 2);
                BigInteger modPow = pKCS1v1_5Padding3.Cardinal.multiply(pKCS1v1_5Padding.Cardinal.modPow(pKCS1v1_5Padding3.Cardinal.mod(pow).add(pow), cipherSpi.Cardinal)).modPow(bCElGamalPublicKey2.Cardinal.add(pKCS1v1_5Padding2.Cardinal.mod(pow).add(pow).multiply(bCElGamalPublicKey.Cardinal)).mod(bigInteger), cipherSpi.Cardinal);
                if (!modPow.equals(cca_continue)) {
                    return modPow;
                }
                throw new IllegalStateException("1 is not a valid agreement value for MQV");
            } else {
                throw new IllegalStateException("MQV key domain parameters do not have Q set");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSA */
    public final class ecDSA implements KeyAgreementSpi.ECKAEGwithSHA224KDF {
        public ISOSignatureSpi.SHA256WithRSAEncryption getInstance;

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.getInstance = (ISOSignatureSpi.SHA256WithRSAEncryption) eCKAEGwithSHA512KDF;
        }

        public final int cca_continue() {
            return (this.getInstance.init.init.Cardinal.configure() + 7) / 8;
        }

        public final BigInteger Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            if (!setMinimumHeight.Cardinal("com.cardinalcommerce.dependencies.internal.bouncycastle.ec.disable_mqv")) {
                ISOSignatureSpi.SHA512_224WithRSAEncryption sHA512_224WithRSAEncryption = (ISOSignatureSpi.SHA512_224WithRSAEncryption) eCKAEGwithSHA512KDF;
                DigestSignatureSpi.MD2 md2 = this.getInstance.init;
                BCRSAPublicKey bCRSAPublicKey = md2.init;
                if (bCRSAPublicKey.equals(sHA512_224WithRSAEncryption.init.init)) {
                    DigestSignatureSpi.MD2 md22 = this.getInstance.getInstance;
                    DigestSignatureSpi digestSignatureSpi = this.getInstance.cca_continue;
                    DigestSignatureSpi digestSignatureSpi2 = sHA512_224WithRSAEncryption.init;
                    DigestSignatureSpi digestSignatureSpi3 = sHA512_224WithRSAEncryption.getInstance;
                    BigInteger bigInteger = bCRSAPublicKey.cca_continue;
                    int bitLength = (bigInteger.bitLength() + 1) / 2;
                    BigInteger shiftLeft = getSDKReferenceNumber.values.shiftLeft(bitLength);
                    getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
                    ChallengeParameters instance = getDeviceData.getInstance(getsdkappid, digestSignatureSpi.cca_continue);
                    ChallengeParameters instance2 = getDeviceData.getInstance(getsdkappid, digestSignatureSpi2.cca_continue);
                    ChallengeParameters instance3 = getDeviceData.getInstance(getsdkappid, digestSignatureSpi3.cca_continue);
                    BigInteger mod = md2.Cardinal.multiply(instance.getSDKVersion().Cardinal().mod(shiftLeft).setBit(bitLength)).add(md22.Cardinal).mod(bigInteger);
                    BigInteger bit = instance3.getSDKVersion().Cardinal().mod(shiftLeft).setBit(bitLength);
                    BigInteger mod2 = bCRSAPublicKey.getInstance.multiply(mod).mod(bigInteger);
                    ChallengeParameters CardinalRenderType = getDeviceData.init(instance2, bit.multiply(mod2).mod(bigInteger), instance3, mod2).CardinalRenderType();
                    if (!CardinalRenderType.valueOf()) {
                        return CardinalRenderType.getSDKVersion().Cardinal();
                    }
                    throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
                }
                throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
            }
            throw new IllegalStateException("ECMQV explicitly disabled");
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSA224 */
    public final class ecDSA224 implements KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo {
        private final KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal;
        private byte[] cca_continue;
        private ASN1ObjectIdentifier configure;
        private int getInstance;
        private byte[] init;

        public ecDSA224(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            this.Cardinal = mQVwithSHA256KDFAndSharedInfo;
        }

        public final void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            getDeviceData getdevicedata = (getDeviceData) eCKAEGwithSHA512KDF;
            this.configure = getdevicedata.configure;
            this.getInstance = getdevicedata.init;
            this.cca_continue = getdevicedata.init();
            this.init = getdevicedata.Cardinal();
        }

        public final int init(byte[] bArr, int i, int i2) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalArgumentException {
            byte[] bArr2 = bArr;
            int i3 = i2;
            if (bArr2.length - i3 >= 0) {
                long j = (long) i3;
                int instance = this.Cardinal.getInstance();
                if (j <= 8589934591L) {
                    long j2 = (long) instance;
                    int i4 = (int) (((j + j2) - 1) / j2);
                    byte[] bArr3 = new byte[this.Cardinal.getInstance()];
                    int i5 = 0;
                    int i6 = i3;
                    int i7 = 0;
                    int i8 = 1;
                    int i9 = i;
                    while (i7 < i4) {
                        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.Cardinal;
                        byte[] bArr4 = this.cca_continue;
                        mQVwithSHA256KDFAndSharedInfo.init(bArr4, i5, bArr4.length);
                        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
                        setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                        setforegroundtintblendmode2.cca_continue.addElement(this.configure);
                        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(setMinimumWidth.configure(i8)));
                        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
                        byte[] bArr5 = this.init;
                        if (bArr5 != null) {
                            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, i5, new EdEC(bArr5)));
                        }
                        setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 2, new EdEC(setMinimumWidth.configure(this.getInstance))));
                        try {
                            byte[] init2 = new GOST(setforegroundtintblendmode).init(ASN1Encoding.DER);
                            this.Cardinal.init(init2, 0, init2.length);
                            this.Cardinal.configure(bArr3, 0);
                            if (i6 > instance) {
                                System.arraycopy(bArr3, 0, bArr2, i9, instance);
                                i9 += instance;
                                i6 -= instance;
                            } else {
                                System.arraycopy(bArr3, 0, bArr2, i9, i6);
                            }
                            i8++;
                            i7++;
                            i5 = 0;
                        } catch (IOException e) {
                            StringBuilder sb = new StringBuilder("unable to encode parameter info: ");
                            sb.append(e.getMessage());
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    this.Cardinal.cca_continue();
                    return (int) j;
                }
                throw new IllegalArgumentException("Output length too large");
            }
            throw new KeyFactorySpi.ECDSA("output buffer too small");
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSA512 */
    public final class ecDSA512 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo {
        private static int cca_continue = 12;
        private static final long[] getInstance = {7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};
        private static final byte[][] init = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Ascii.f53586FF, Ascii.f53584CR, Ascii.f53594SO, Ascii.f53593SI}, new byte[]{Ascii.f53594SO, 10, 4, 8, 9, Ascii.f53593SI, Ascii.f53584CR, 6, 1, Ascii.f53586FF, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, Ascii.f53586FF, 0, 5, 2, Ascii.f53593SI, Ascii.f53584CR, 10, Ascii.f53594SO, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, Ascii.f53584CR, Ascii.f53586FF, 11, Ascii.f53594SO, 2, 6, 5, 10, 4, 0, Ascii.f53593SI, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, Ascii.f53593SI, Ascii.f53594SO, 1, 11, Ascii.f53586FF, 6, 8, 3, Ascii.f53584CR}, new byte[]{2, Ascii.f53586FF, 6, 10, 0, 11, 8, 3, 4, Ascii.f53584CR, 7, 5, Ascii.f53593SI, Ascii.f53594SO, 1, 9}, new byte[]{Ascii.f53586FF, 5, 1, Ascii.f53593SI, Ascii.f53594SO, Ascii.f53584CR, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{Ascii.f53584CR, 11, 7, Ascii.f53594SO, Ascii.f53586FF, 1, 3, 9, 5, 0, Ascii.f53593SI, 4, 8, 6, 2, 10}, new byte[]{6, Ascii.f53593SI, Ascii.f53594SO, 9, 11, 3, 0, 8, Ascii.f53586FF, 2, Ascii.f53584CR, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, Ascii.f53593SI, 11, 9, Ascii.f53594SO, 3, Ascii.f53586FF, Ascii.f53584CR, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Ascii.f53586FF, Ascii.f53584CR, Ascii.f53594SO, Ascii.f53593SI}, new byte[]{Ascii.f53594SO, 10, 4, 8, 9, Ascii.f53593SI, Ascii.f53584CR, 6, 1, Ascii.f53586FF, 0, 2, 11, 7, 5, 3}};
        private int Cardinal;
        private int CardinalError;
        private long CardinalUiType;
        private long[] cleanup;
        private byte[] configure;
        private long getSDKVersion;
        private long[] getWarnings;
        private long values;

        public ecDSA512() {
            this((byte) 0);
        }

        public ecDSA512(byte b) {
            this.Cardinal = 64;
            this.configure = null;
            this.CardinalError = 0;
            this.cleanup = new long[16];
            this.getWarnings = null;
            this.values = 0;
            this.getSDKVersion = 0;
            this.CardinalUiType = 0;
            this.configure = new byte[128];
            this.Cardinal = 64;
            init();
        }

        private void getWarnings() {
            long[] jArr = this.getWarnings;
            System.arraycopy(jArr, 0, this.cleanup, 0, jArr.length);
            System.arraycopy(getInstance, 0, this.cleanup, this.getWarnings.length, 4);
            long[] jArr2 = this.cleanup;
            long j = this.values;
            long[] jArr3 = getInstance;
            jArr2[12] = j ^ jArr3[4];
            jArr2[13] = this.getSDKVersion ^ jArr3[5];
            jArr2[14] = this.CardinalUiType ^ jArr3[6];
            jArr2[15] = jArr3[7];
        }

        private void init() {
            if (this.getWarnings == null) {
                long[] jArr = new long[8];
                this.getWarnings = jArr;
                long[] jArr2 = getInstance;
                jArr[0] = jArr2[0] ^ ((long) (this.Cardinal | 16842752));
                jArr[1] = jArr2[1];
                jArr[2] = jArr2[2];
                jArr[3] = jArr2[3];
                jArr[4] = jArr2[4];
                jArr[5] = jArr2[5];
                jArr[6] = jArr2[6];
                jArr[7] = jArr2[7];
            }
        }

        public final int Cardinal() {
            return 128;
        }

        public final String configure() {
            return "BLAKE2b";
        }

        public final int getInstance() {
            return this.Cardinal;
        }

        public final void Cardinal(byte b) {
            int i = this.CardinalError;
            if (128 - i == 0) {
                long j = this.values + 128;
                this.values = j;
                if (j == 0) {
                    this.getSDKVersion++;
                }
                Cardinal(this.configure, 0);
                byte[] bArr = this.configure;
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = 0;
                }
                this.configure[0] = b;
                this.CardinalError = 1;
                return;
            }
            this.configure[i] = b;
            this.CardinalError = i + 1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void init(byte[] r12, int r13, int r14) {
            /*
                r11 = this;
                if (r12 == 0) goto L_0x0066
                if (r14 != 0) goto L_0x0005
                goto L_0x0066
            L_0x0005:
                int r0 = r11.CardinalError
                r1 = 1
                r3 = 0
                r5 = 128(0x80, double:6.32E-322)
                r7 = 0
                if (r0 == 0) goto L_0x0044
                int r8 = 128 - r0
                if (r8 >= r14) goto L_0x0039
                byte[] r9 = r11.configure
                java.lang.System.arraycopy(r12, r13, r9, r0, r8)
                long r9 = r11.values
                long r9 = r9 + r5
                r11.values = r9
                int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r0 != 0) goto L_0x0027
                long r9 = r11.getSDKVersion
                long r9 = r9 + r1
                r11.getSDKVersion = r9
            L_0x0027:
                byte[] r0 = r11.configure
                r11.Cardinal(r0, r7)
                r11.CardinalError = r7
                byte[] r0 = r11.configure
                r9 = 0
            L_0x0031:
                int r10 = r0.length
                if (r9 >= r10) goto L_0x0045
                r0[r9] = r7
                int r9 = r9 + 1
                goto L_0x0031
            L_0x0039:
                byte[] r1 = r11.configure
                java.lang.System.arraycopy(r12, r13, r1, r0, r14)
            L_0x003e:
                int r12 = r11.CardinalError
                int r12 = r12 + r14
                r11.CardinalError = r12
                return
            L_0x0044:
                r8 = 0
            L_0x0045:
                int r14 = r14 + r13
                int r0 = r14 + -128
                int r13 = r13 + r8
            L_0x0049:
                if (r13 >= r0) goto L_0x005f
                long r8 = r11.values
                long r8 = r8 + r5
                r11.values = r8
                int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r10 != 0) goto L_0x0059
                long r8 = r11.getSDKVersion
                long r8 = r8 + r1
                r11.getSDKVersion = r8
            L_0x0059:
                r11.Cardinal(r12, r13)
                int r13 = r13 + 128
                goto L_0x0049
            L_0x005f:
                byte[] r0 = r11.configure
                int r14 = r14 - r13
                java.lang.System.arraycopy(r12, r13, r0, r7, r14)
                goto L_0x003e
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.SignatureSpi.ecDSA512.init(byte[], int, int):void");
        }

        public final int configure(byte[] bArr, int i) {
            int i2;
            this.CardinalUiType = -1;
            long j = this.values;
            int i3 = this.CardinalError;
            long j2 = j + ((long) i3);
            this.values = j2;
            if (i3 > 0 && j2 == 0) {
                this.getSDKVersion++;
            }
            Cardinal(this.configure, 0);
            byte[] bArr2 = this.configure;
            for (int i4 = 0; i4 < bArr2.length; i4++) {
                bArr2[i4] = 0;
            }
            long[] jArr = this.cleanup;
            for (int i5 = 0; i5 < jArr.length; i5++) {
                jArr[i5] = 0;
            }
            int i6 = 0;
            while (true) {
                long[] jArr2 = this.getWarnings;
                if (i6 >= jArr2.length || (i2 = i6 << 3) >= this.Cardinal) {
                    long[] jArr3 = this.getWarnings;
                } else {
                    byte[] Cardinal2 = setMinimumWidth.Cardinal(jArr2[i6]);
                    int i7 = this.Cardinal;
                    if (i2 < i7 - 8) {
                        System.arraycopy(Cardinal2, 0, bArr, i2 + i, 8);
                    } else {
                        System.arraycopy(Cardinal2, 0, bArr, i + i2, i7 - i2);
                    }
                    i6++;
                }
            }
            long[] jArr32 = this.getWarnings;
            for (int i8 = 0; i8 < jArr32.length; i8++) {
                jArr32[i8] = 0;
            }
            cca_continue();
            return this.Cardinal;
        }

        public final void cca_continue() {
            this.CardinalError = 0;
            this.CardinalUiType = 0;
            this.values = 0;
            this.getSDKVersion = 0;
            this.getWarnings = null;
            byte[] bArr = this.configure;
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
            init();
        }

        private void Cardinal(byte[] bArr, int i) {
            byte[] bArr2 = bArr;
            getWarnings();
            long[] jArr = new long[16];
            int i2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                int i4 = i + (i3 << 3);
                jArr[i3] = (((long) setMinimumWidth.getInstance(bArr, i4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) setMinimumWidth.getInstance(bArr, i4 + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32);
            }
            for (int i5 = 0; i5 < cca_continue; i5++) {
                byte[][] bArr3 = init;
                Cardinal(jArr[bArr3[i5][0]], jArr[bArr3[i5][1]], 0, 4, 8, 12);
                byte[][] bArr4 = init;
                Cardinal(jArr[bArr4[i5][2]], jArr[bArr4[i5][3]], 1, 5, 9, 13);
                byte[][] bArr5 = init;
                Cardinal(jArr[bArr5[i5][4]], jArr[bArr5[i5][5]], 2, 6, 10, 14);
                byte[][] bArr6 = init;
                Cardinal(jArr[bArr6[i5][6]], jArr[bArr6[i5][7]], 3, 7, 11, 15);
                byte[][] bArr7 = init;
                Cardinal(jArr[bArr7[i5][8]], jArr[bArr7[i5][9]], 0, 5, 10, 15);
                byte[][] bArr8 = init;
                Cardinal(jArr[bArr8[i5][10]], jArr[bArr8[i5][11]], 1, 6, 11, 12);
                byte[][] bArr9 = init;
                Cardinal(jArr[bArr9[i5][12]], jArr[bArr9[i5][13]], 2, 7, 8, 13);
                byte[][] bArr10 = init;
                Cardinal(jArr[bArr10[i5][14]], jArr[bArr10[i5][15]], 3, 4, 9, 14);
            }
            while (true) {
                long[] jArr2 = this.getWarnings;
                if (i2 < jArr2.length) {
                    long j = jArr2[i2];
                    long[] jArr3 = this.cleanup;
                    jArr2[i2] = (j ^ jArr3[i2]) ^ jArr3[i2 + 8];
                    i2++;
                } else {
                    return;
                }
            }
        }

        private void Cardinal(long j, long j2, int i, int i2, int i3, int i4) {
            long[] jArr = this.cleanup;
            jArr[i] = jArr[i] + jArr[i2] + j;
            long j3 = jArr[i4] ^ jArr[i];
            jArr[i4] = (j3 << 32) | (j3 >>> 32);
            jArr[i3] = jArr[i3] + jArr[i4];
            long j4 = jArr[i2] ^ jArr[i3];
            jArr[i2] = (j4 << 40) | (j4 >>> 24);
            jArr[i] = jArr[i] + jArr[i2] + j2;
            long j5 = jArr[i4] ^ jArr[i];
            jArr[i4] = (j5 << 48) | (j5 >>> 16);
            jArr[i3] = jArr[i3] + jArr[i4];
            long j6 = jArr[i2] ^ jArr[i3];
            jArr[i2] = (j6 << 1) | (j6 >>> 63);
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSASha3_224 */
    public final class ecDSASha3_224 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo {
        private static final byte[][] cca_continue = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Ascii.f53586FF, Ascii.f53584CR, Ascii.f53594SO, Ascii.f53593SI}, new byte[]{Ascii.f53594SO, 10, 4, 8, 9, Ascii.f53593SI, Ascii.f53584CR, 6, 1, Ascii.f53586FF, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, Ascii.f53586FF, 0, 5, 2, Ascii.f53593SI, Ascii.f53584CR, 10, Ascii.f53594SO, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, Ascii.f53584CR, Ascii.f53586FF, 11, Ascii.f53594SO, 2, 6, 5, 10, 4, 0, Ascii.f53593SI, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, Ascii.f53593SI, Ascii.f53594SO, 1, 11, Ascii.f53586FF, 6, 8, 3, Ascii.f53584CR}, new byte[]{2, Ascii.f53586FF, 6, 10, 0, 11, 8, 3, 4, Ascii.f53584CR, 7, 5, Ascii.f53593SI, Ascii.f53594SO, 1, 9}, new byte[]{Ascii.f53586FF, 5, 1, Ascii.f53593SI, Ascii.f53594SO, Ascii.f53584CR, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{Ascii.f53584CR, 11, 7, Ascii.f53594SO, Ascii.f53586FF, 1, 3, 9, 5, 0, Ascii.f53593SI, 4, 8, 6, 2, 10}, new byte[]{6, Ascii.f53593SI, Ascii.f53594SO, 9, 11, 3, 0, 8, Ascii.f53586FF, 2, Ascii.f53584CR, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, Ascii.f53593SI, 11, 9, Ascii.f53594SO, 3, Ascii.f53586FF, Ascii.f53584CR, 0}};
        private static final int[] configure = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};
        private int Cardinal;
        private int[] CardinalActionCode;
        private int CardinalConfigurationParameters;
        private int CardinalEnvironment;
        private byte[] CardinalError;
        private int CardinalRenderType;
        private int[] CardinalUiType;
        private byte[] cleanup;
        private int getInstance;
        private int getSDKVersion;
        private byte[] getWarnings;
        private byte[] init;
        private int valueOf;
        private int values;

        public ecDSASha3_224() {
            this((byte) 0);
        }

        public ecDSASha3_224(byte b) {
            this.getInstance = 32;
            this.Cardinal = 0;
            this.init = null;
            this.cleanup = null;
            this.getWarnings = null;
            this.getSDKVersion = 1;
            this.values = 1;
            this.CardinalError = null;
            this.CardinalEnvironment = 0;
            this.CardinalActionCode = new int[16];
            this.CardinalUiType = null;
            this.valueOf = 0;
            this.CardinalRenderType = 0;
            this.CardinalConfigurationParameters = 0;
            this.getInstance = 32;
            init((byte[]) null, (byte[]) null, (byte[]) null);
        }

        private void Cardinal(byte[] bArr, int i) {
            init();
            int[] iArr = new int[16];
            int i2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                iArr[i3] = setMinimumWidth.getInstance(bArr, (i3 << 2) + i);
            }
            for (int i4 = 0; i4 < 10; i4++) {
                byte[][] bArr2 = cca_continue;
                init(iArr[bArr2[i4][0]], iArr[bArr2[i4][1]], 0, 4, 8, 12);
                byte[][] bArr3 = cca_continue;
                init(iArr[bArr3[i4][2]], iArr[bArr3[i4][3]], 1, 5, 9, 13);
                byte[][] bArr4 = cca_continue;
                init(iArr[bArr4[i4][4]], iArr[bArr4[i4][5]], 2, 6, 10, 14);
                byte[][] bArr5 = cca_continue;
                init(iArr[bArr5[i4][6]], iArr[bArr5[i4][7]], 3, 7, 11, 15);
                byte[][] bArr6 = cca_continue;
                init(iArr[bArr6[i4][8]], iArr[bArr6[i4][9]], 0, 5, 10, 15);
                byte[][] bArr7 = cca_continue;
                init(iArr[bArr7[i4][10]], iArr[bArr7[i4][11]], 1, 6, 11, 12);
                byte[][] bArr8 = cca_continue;
                init(iArr[bArr8[i4][12]], iArr[bArr8[i4][13]], 2, 7, 8, 13);
                byte[][] bArr9 = cca_continue;
                init(iArr[bArr9[i4][14]], iArr[bArr9[i4][15]], 3, 4, 9, 14);
            }
            while (true) {
                int[] iArr2 = this.CardinalUiType;
                if (i2 < iArr2.length) {
                    int i5 = iArr2[i2];
                    int[] iArr3 = this.CardinalActionCode;
                    iArr2[i2] = (i5 ^ iArr3[i2]) ^ iArr3[i2 + 8];
                    i2++;
                } else {
                    return;
                }
            }
        }

        private void init() {
            int[] iArr = this.CardinalUiType;
            System.arraycopy(iArr, 0, this.CardinalActionCode, 0, iArr.length);
            System.arraycopy(configure, 0, this.CardinalActionCode, this.CardinalUiType.length, 4);
            int[] iArr2 = this.CardinalActionCode;
            int i = this.valueOf;
            int[] iArr3 = configure;
            iArr2[12] = i ^ iArr3[4];
            iArr2[13] = this.CardinalRenderType ^ iArr3[5];
            iArr2[14] = this.CardinalConfigurationParameters ^ iArr3[6];
            iArr2[15] = iArr3[7];
        }

        private void init(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.CardinalError = new byte[64];
            if (bArr3 != null && bArr3.length > 0) {
                if (bArr3.length <= 32) {
                    byte[] bArr4 = new byte[bArr3.length];
                    this.getWarnings = bArr4;
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                    this.Cardinal = bArr3.length;
                    System.arraycopy(bArr3, 0, this.CardinalError, 0, bArr3.length);
                    this.CardinalEnvironment = 64;
                } else {
                    throw new IllegalArgumentException("Keys > 32 bytes are not supported");
                }
            }
            if (this.CardinalUiType == null) {
                int[] iArr = new int[8];
                this.CardinalUiType = iArr;
                int[] iArr2 = configure;
                iArr[0] = iArr2[0] ^ ((this.getInstance | (this.Cardinal << 8)) | ((this.getSDKVersion << 16) | (this.values << 24)));
                iArr[1] = iArr2[1];
                iArr[2] = iArr2[2];
                iArr[3] = iArr2[3];
                iArr[4] = iArr2[4];
                iArr[5] = iArr2[5];
                if (bArr != null) {
                    if (bArr.length == 8) {
                        byte[] bArr5 = new byte[8];
                        this.init = bArr5;
                        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
                        int[] iArr3 = this.CardinalUiType;
                        iArr3[4] = iArr3[4] ^ setMinimumWidth.getInstance(bArr, 0);
                        int[] iArr4 = this.CardinalUiType;
                        iArr4[5] = setMinimumWidth.getInstance(bArr, 4) ^ iArr4[5];
                    } else {
                        throw new IllegalArgumentException("Salt length must be exactly 8 bytes");
                    }
                }
                int[] iArr5 = this.CardinalUiType;
                int[] iArr6 = configure;
                iArr5[6] = iArr6[6];
                iArr5[7] = iArr6[7];
                if (bArr2 == null) {
                    return;
                }
                if (bArr2.length == 8) {
                    byte[] bArr6 = new byte[8];
                    this.cleanup = bArr6;
                    System.arraycopy(bArr2, 0, bArr6, 0, bArr2.length);
                    int[] iArr7 = this.CardinalUiType;
                    iArr7[6] = iArr7[6] ^ setMinimumWidth.getInstance(bArr2, 0);
                    int[] iArr8 = this.CardinalUiType;
                    iArr8[7] = setMinimumWidth.getInstance(bArr2, 4) ^ iArr8[7];
                    return;
                }
                throw new IllegalArgumentException("Personalization length must be exactly 8 bytes");
            }
        }

        public final int Cardinal() {
            return 64;
        }

        public final String configure() {
            return "BLAKE2s";
        }

        public final int getInstance() {
            return this.getInstance;
        }

        public final void Cardinal(byte b) {
            int i = this.CardinalEnvironment;
            if (64 - i == 0) {
                int i2 = this.valueOf + 64;
                this.valueOf = i2;
                if (i2 == 0) {
                    this.CardinalRenderType++;
                }
                Cardinal(this.CardinalError, 0);
                byte[] bArr = this.CardinalError;
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    bArr[i3] = 0;
                }
                this.CardinalError[0] = b;
                this.CardinalEnvironment = 1;
                return;
            }
            this.CardinalError[i] = b;
            this.CardinalEnvironment = i + 1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void init(byte[] r6, int r7, int r8) {
            /*
                r5 = this;
                if (r6 == 0) goto L_0x0060
                if (r8 != 0) goto L_0x0005
                goto L_0x0060
            L_0x0005:
                int r0 = r5.CardinalEnvironment
                r1 = 0
                if (r0 == 0) goto L_0x003e
                int r2 = 64 - r0
                if (r2 >= r8) goto L_0x0033
                byte[] r3 = r5.CardinalError
                java.lang.System.arraycopy(r6, r7, r3, r0, r2)
                int r0 = r5.valueOf
                int r0 = r0 + 64
                r5.valueOf = r0
                if (r0 != 0) goto L_0x0021
                int r0 = r5.CardinalRenderType
                int r0 = r0 + 1
                r5.CardinalRenderType = r0
            L_0x0021:
                byte[] r0 = r5.CardinalError
                r5.Cardinal(r0, r1)
                r5.CardinalEnvironment = r1
                byte[] r0 = r5.CardinalError
                r3 = 0
            L_0x002b:
                int r4 = r0.length
                if (r3 >= r4) goto L_0x003f
                r0[r3] = r1
                int r3 = r3 + 1
                goto L_0x002b
            L_0x0033:
                byte[] r1 = r5.CardinalError
                java.lang.System.arraycopy(r6, r7, r1, r0, r8)
            L_0x0038:
                int r6 = r5.CardinalEnvironment
                int r6 = r6 + r8
                r5.CardinalEnvironment = r6
                return
            L_0x003e:
                r2 = 0
            L_0x003f:
                int r8 = r8 + r7
                int r0 = r8 + -64
                int r7 = r7 + r2
            L_0x0043:
                if (r7 >= r0) goto L_0x0059
                int r2 = r5.valueOf
                int r2 = r2 + 64
                r5.valueOf = r2
                if (r2 != 0) goto L_0x0053
                int r2 = r5.CardinalRenderType
                int r2 = r2 + 1
                r5.CardinalRenderType = r2
            L_0x0053:
                r5.Cardinal(r6, r7)
                int r7 = r7 + 64
                goto L_0x0043
            L_0x0059:
                byte[] r0 = r5.CardinalError
                int r8 = r8 - r7
                java.lang.System.arraycopy(r6, r7, r0, r1, r8)
                goto L_0x0038
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.SignatureSpi.ecDSASha3_224.init(byte[], int, int):void");
        }

        public final int configure(byte[] bArr, int i) {
            int i2;
            this.CardinalConfigurationParameters = -1;
            int i3 = this.valueOf;
            int i4 = this.CardinalEnvironment;
            int i5 = i3 + i4;
            this.valueOf = i5;
            if (i5 < 0 && i4 > (-i5)) {
                this.CardinalRenderType++;
            }
            Cardinal(this.CardinalError, 0);
            byte[] bArr2 = this.CardinalError;
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                bArr2[i6] = 0;
            }
            int[] iArr = this.CardinalActionCode;
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr[i7] = 0;
            }
            int i8 = 0;
            while (true) {
                int[] iArr2 = this.CardinalUiType;
                if (i8 >= iArr2.length || (i2 = i8 << 2) >= this.getInstance) {
                    int[] iArr3 = this.CardinalUiType;
                } else {
                    byte[] init2 = setMinimumWidth.init(iArr2[i8]);
                    int i9 = this.getInstance;
                    if (i2 < i9 - 4) {
                        System.arraycopy(init2, 0, bArr, i2 + i, 4);
                    } else {
                        System.arraycopy(init2, 0, bArr, i + i2, i9 - i2);
                    }
                    i8++;
                }
            }
            int[] iArr32 = this.CardinalUiType;
            for (int i10 = 0; i10 < iArr32.length; i10++) {
                iArr32[i10] = 0;
            }
            cca_continue();
            return this.getInstance;
        }

        public final void cca_continue() {
            this.CardinalEnvironment = 0;
            this.CardinalConfigurationParameters = 0;
            this.valueOf = 0;
            this.CardinalRenderType = 0;
            this.CardinalUiType = null;
            byte[] bArr = this.CardinalError;
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
            byte[] bArr2 = this.getWarnings;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, this.CardinalError, 0, bArr2.length);
                this.CardinalEnvironment = 64;
            }
            init(this.init, this.cleanup, this.getWarnings);
        }

        private void init(int i, int i2, int i3, int i4, int i5, int i6) {
            int[] iArr = this.CardinalActionCode;
            iArr[i3] = iArr[i3] + iArr[i4] + i;
            int i7 = iArr[i6] ^ iArr[i3];
            iArr[i6] = (i7 << 16) | (i7 >>> 16);
            iArr[i5] = iArr[i5] + iArr[i6];
            int i8 = iArr[i4] ^ iArr[i5];
            iArr[i4] = (i8 << 20) | (i8 >>> 12);
            iArr[i3] = iArr[i3] + iArr[i4] + i2;
            int i9 = iArr[i6] ^ iArr[i3];
            iArr[i6] = (i9 << 24) | (i9 >>> 8);
            iArr[i5] = iArr[i5] + iArr[i6];
            int i10 = iArr[i4] ^ iArr[i5];
            iArr[i4] = (i10 << 25) | (i10 >>> 7);
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSASha3_256 */
    public abstract class ecDSASha3_256 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo, setPaddingRelative {
        private static final byte[] CardinalEnvironment = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        private static final long[][] CardinalRenderType = {new long[]{-1803552715625652272L, 2703135593145367062L, -4014430758819158872L, 6577092334268629354L, 806964168861892974L, -6063472769050256282L, -713936367173212554L, -730696462206134965L, 5215999108449717233L, -46053480858810939L, -3782322580877781099L, 7409386412115095689L, 3849627103271945136L, 8988319201874450849L, 3938119337751376013L, -7010230157848027178L, -8423426398366749129L, -7147294794814685941L, -4896405975937806502L, -1930949658557223699L, -3548053845353340974L, -1407348811753517218L, -5094482946371975395L, -8349570678062906195L, 8519831221648263471L, 6380786457702773335L, 4606327678483665726L, 1135139788101916873L, -1296744055254569597L, 1220450159802546598L, 6759235690777098768L, 5340123591806085420L, 6034809048673841977L, -5407401691594998519L, 6896344311240562893L, -1690488634981198087L, 9184934662348565148L, -4183792988264456516L, -6457042926775703950L, 3364644269219363704L, 989048157634869780L, -9056160079784030844L, 3387584785362250392L, 6665082552186727408L, 8806730920978768603L, -8943992543361557404L, -3499218176542634446L, -8832779848047991010L, -5384180315986760471L, -5116578973163071747L, 2007762480278943944L, 7071029175581714734L, -245446995445778696L, -7098459127742649109L, 5517131305049330262L, 2524355749569298796L, 3276936053954857029L, -833575805165058901L, -4774104785891107142L, 4227838725751020409L, -1108816769305830132L, 2880731531503622347L, -8547577275558851350L, 1904883134495025448L, -8015005427386181889L, 4850405589464713887L, -602049820529576042L, 2081972218582700626L, 1379356218675464859L, -6509842815274707633L, 3166351970529817407L, -2925410023548009017L, -6354163580723349614L, -2675396450584002605L, -8745932894798146525L, 4095269026725968292L, 7284836791436182452L, 178206167350026973L, -8587687698711814902L, -7849942517349325374L, 5686309239594266763L, 3626867272058218794L, 4695292606739097666L, -5584978786571663757L, 7805587275216445447L, 6553870956925915274L, 2247080073069027695L, -4360880972299377210L, 4136504802722867268L, 2992705483290644962L, 4655464135170259362L, -1641371007467190503L, 867873424238963700L, 6139766898342725699L, 5048711494641582808L, 2360957084007330385L, 7917754814463914471L, -6851982712723858168L, 8900603062938514235L, 4819584321579539327L, -2835569523292644082L, -4162535888497939071L, 2409792751347803057L, 7449496838093054313L, 2608138101170875382L, -3089532541034338534L, 6775169570724432173L, 2898833334747545602L, -8076149933667584112L, 1717647244194337596L, -2273374492424215382L, 8669102231478190086L, 7938185699155198682L, -8713704321949088317L, 3969222566346957165L, -5988784469396818180L, 9134972545477524348L, -4561983676892834053L, -443809933158089025L, 8321595681021526376L, 3740161260836255946L, -6223083854011302213L, -1981192628965753587L, -8189443922177186192L, 5892660270079857124L, 2502541675832561804L, -2804466300730962706L, 3575476887658224151L, -3200685872914850720L, 669897467106812851L, -7208553650918336623L, -3694119084499141361L, 3809516679850545744L, 5718256960103440747L, -2332953186743126124L, 2758712437335984427L, -4627477833875620761L, -2457079737070004919L, 4334551115747581955L, -7965043308780665057L, 7539375937215052192L, -5292836362296451116L, 1449546416188301313L, -7476662035618257748L, 7253733569142936148L, -4410843088901983194L, 4494160142329627358L, 5797380680492875780L, 5033684639528710629L, 6942380200648117235L, -311213848885666718L, -6820034994775438104L, 5452010138718157004L, 646676091767009875L, -4539043153625528549L, -6988416084379726282L, 471514214048988026L, -1312069221898101058L, 8614828720478738639L, 3471190102295415799L, -8245283892968532659L, -547814629229383841L, -1516815754241838044L, -6167477462292361850L, -7381664543912200884L, 0, -1067861853971886868L, 8143953700710785973L, -5825391166404688447L, -7494732077575095195L, 1847633384726895125L, -7672935903076573512L, -2570373723287288663L, -7766808051888107688L, -9211246677606207655L, -4304686731880476836L, -424225740051214974L, -944158789619597359L, 7698943044753169277L, 5558086220651709366L, 273485755470967613L, -2437239977867205004L, 3045458228384031455L, 8041346034719003450L, -3121761119376230662L, -4956810279513479744L, -7615625819989316219L, -1494719728652540476L, 378507382706538567L, -6621729356152879953L, -2037663147516029033L, -9108086336008503623L, -5865219631939627999L, -912211069378859471L, 7175315966437357774L, 5161723385538695992L, -6691429997208146379L, 8789995975362646502L, 122301190315135456L, 1339527752872090491L, 8500289773969701394L, -2635286024337609165L, 2206125151973814415L, 5912507865751560921L, -2158837887763724681L, -76874749012421595L, -3877320079976692107L, 7055674186596964883L, -1780331338551374288L, 3226973935617776037L, 1613642550683796188L, -6336095750669684901L, 2113919936262685618L, -5242593384495067596L, -3431887019008757923L, -205618523608504552L, 6290905146667117214L, 520631834711206554L, 6090649271097153955L, 6268809121346255742L, -4722757421728125561L, 9011259725410191425L, 4260067298331642521L, 7571604515825379392L, -5957963198686648548L, -5641402047464721074L, 4929679943725850629L, 1562558313115120097L, 8378270681804975090L, 6431029428379739063L, -1174442872063853469L, 7740178818457750173L, 4437711457076851171L, -6732384918571794475L, 1735746844117158901L, 1251271430781151302L, -5005927899907263456L, -3319719480029724995L, -5762576781129063250L, -8874015624313325826L, 8122139634094273109L, 1040986648309745961L, 356411355647007143L, 756721191328944270L, 5318878451677075985L, -8454529626693894185L, -3672305017614193425L, -3892411666385996472L, -7872883033760648158L, -4068663746806629279L, -2179221354102278838L, -3303846208210219648L, -7330572744817539471L, -5490825646511057005L, 8272760012479254664L, -2966645796984155097L}, new long[]{-4030255449738619426L, 7346976492199675417L, -626116132630139325L, -8818858909562055882L, 6533467991705271684L, -448178970784563971L, -6764453224091262193L, -3624289984018954899L, -9205540189538630779L, -5585462176368193220L, -7429905405277353951L, -4656326962959550440L, 1151735774811599048L, -6151769618714846568L, 6942284815962019498L, -703557647758734283L, 3304311495801540674L, -4831136898697919614L, 7559468737934159677L, -6359765666358135876L, 2957424603572281991L, -5197658860964970097L, -2809702287761406565L, -2956007109283531437L, -3067203235521704247L, -1571434816639601324L, 8085181091649676441L, -3591952015147155721L, -209953567916339656L, 7642183762405766865L, 6618156441656008690L, -3821456694203446222L, -5721068125790025520L, 6768646983239759067L, 1229560361235927109L, 2545497942825370364L, -4247812575351915270L, 8332055718082846467L, 9018811952317763005L, 4566156016530439069L, -8867871107904474816L, 4447555131281990257L, 1889868047608435272L, 9132310989383824935L, 8423405394594584156L, 1791576812070341540L, 895921998879640402L, -4136132749925103776L, 8686043850126826766L, -259527717632742322L, 3505479608743889749L, 3164974344323824491L, -2463388277714864290L, -7381315281960506793L, 1491256427646959862L, -4922222727044511011L, 5832729293860314623L, -1668591102639493960L, 5588041959860897512L, -4477392520457318849L, 8960651507453538251L, 3404044757246527918L, 7427396029290209269L, 1567782000193888896L, 2125332809319160599L, -2696297740110004735L, -8684132036093703462L, -3781732998293770684L, 405965478745608371L, 1334608620921465823L, -8162931759184195269L, 6009835698019100261L, 6362838478626120808L, -2915579863370524891L, -6253885823018934014L, -8424766350955232888L, -3400959220014064006L, 5388605995385671607L, 4789436484882904608L, 8273825248612433269L, 6807803589745610561L, -803141104343149095L, -8044273462534131274L, -8959238411213129697L, -4562432827018040247L, -6847432110282425629L, -6617847203449567194L, -5916573000348838969L, -5876878730644248483L, -4287606846705721716L, -5388300036355532701L, 447961557886364457L, -6806372268832745323L, 7989344413684106260L, 7745519667033183399L, -3162377592575071041L, -1888435642254047844L, -6670898553424985735L, 5873227033075236745L, -4286789270562860L, -7115147458626955118L, 2021362311995275617L, -1046827325327899286L, -7348342965477568051L, 4652678544566382540L, 1850721214614677970L, 3779734978877634960L, -2226104194499971239L, -5091849455076895951L, -7985129142130994240L, 1609153642657618202L, 4480481336861891051L, -8473849124741782530L, -8335690430216009513L, 4986581067319345023L, 209097870346312172L, -2276381894218689233L, -4447261871345863259L, 7798271984477724152L, 7243570012128126063L, -3333018702976353268L, -5544050972775074998L, -9018030957147481495L, -7191672837363402012L, -409121388910540953L, -7001735332191755512L, -5177453641450868409L, -7244442712347462725L, -4041310443283782378L, 1180970181547717171L, 5176105366933055123L, 7188535108749356336L, 3071419591516346653L, 8871593212975408788L, 7377047836268559747L, 745784333737205883L, 523712867556149599L, 3218003841565405748L, 2276692251301888763L, 4042724623974101698L, 6062869490421444410L, 1668368207247227756L, -107200675243772510L, 2916365256580759793L, -744980879059175505L, -8610870969725437422L, 6147487227497352524L, -2362538166529167694L, 347243151226876613L, 6999741710823961820L, 2806071973676585551L, -8788735839226091348L, -1183493220983118361L, 3821216675772636134L, -1789001426630173584L, -3217716098546522656L, -2430408108131136316L, -7873943064266053542L, -1149811373353720036L, -4750585183628141970L, -892221251657868154L, 5286400504730760237L, 7609746906341231947L, -2548006234371058392L, 944934528471361828L, 0, 6430778939292435998L, 3336736409998420952L, 7875361642996334478L, -1846528539907703290L, 8821948844834997474L, -6010057508961455695L, 706136312374746081L, -8506197141978474396L, 8606606803205598662L, 6252543065422558934L, 258180561991695258L, 3932361041049477244L, 2228031909561065613L, 3591083712976693539L, 8046871333151188578L, 4829160237163942998L, -6065391445415380754L, -5835889602077783509L, 4380598834454315015L, -7797487710135793108L, -4378688104862656557L, 5548248045526197406L, -5626880067174045018L, 4026619618737144330L, 8789027980293848952L, 5914590821894013971L, 5201360692628199003L, 1438508405363181993L, 1047132165489660606L, 5627682402975382898L, -3692934325936855269L, 1966322907280535614L, 2694302999865518549L, 2361664381868374374L, -4989108504807806805L, -941866114256437520L, -9129718635683421709L, -7638464970933853947L, 6673472819996841645L, -7559179876038510359L, -4789654982222634508L, 4917937056650714377L, -1335952497386210293L, 8472979738121466922L, -5455256526993655275L, -7607840574798439777L, -1233841633585051759L, 3621785006072287929L, -6321264663560567948L, -525690647958430069L, 2600818822502173603L, -350890450751740655L, 5457179844010077633L, 104674322205155958L, 2459119713154539658L, -8087180229934124211L, -1965524969523353622L, 8162692825194907375L, 2847061296053530681L, -1439358620438684035L, 2429042753721621264L, -2601053358443111305L, -6942520436352876162L, -3506841683981296511L, -2850200109117495315L, 4291817720210491736L, 4250406047929019182L, -1611134702235742514L, 6848231166907919671L, 5722504929196957444L, -5283333209384213511L, -8276968459716351327L, -3935503167711873112L, -2018290618604048715L, 804576823300162061L, -1494415651414517982L, -7742435248677485709L, 9209752147493311569L, -6531539192194323888L, 630314289831180695L, 5090994841956713701L, -3302404079808903274L, 6320413364043601056L, 4136912626218684596L, 3688671278293774543L, -2121626579602862909L, 7111516025665441606L, -6427073794025991734L, 4747430357904739770L, 8503693248481660848L}, new long[]{5022191610516858060L, -5800904701749453560L, 325196729119310435L, -7902632335432024366L, -1275020129832272985L, 1619663718359036237L, -355156193309366908L, 5335828035754758151L, -7067565944566412775L, -3798526433470663894L, -5359911709110765600L, -2532208113978446666L, 1287844858498292800L, -2071692252756128045L, -6862984376374597181L, 550964732710513933L, 8585995564513096669L, -2760271765158838268L, -5121668511014600044L, -816004031260028593L, 8916962000159598712L, -4254160368123066399L, 8560921352511315212L, 7426955371667046732L, 7096434795747339774L, 2543027200294554449L, -8026787735162470547L, 5721517685081291957L, 1937338776563641064L, -4710672869224480440L, -1339811264550726455L, 4899378514713126672L, -3673650654185164554L, -1748370356318745424L, 3710095511616993728L, 7340570904524980467L, 5918098101825092432L, -7642223448383253537L, -8716653984131915535L, 4697601972911171247L, -7966292763585932868L, 5151346661287437683L, 3331340938598661669L, -9051540132384224189L, -7204664438506969912L, 2915854855682031097L, 1492126639482712306L, 6290138385502410722L, -8595407305453562822L, 1856873279258002822L, 5831708560246045423L, 9075623880903535524L, 8815370023405405865L, -5279349609657657202L, 4378109956818586891L, -3439845308874787053L, -1139502944774581460L, 2668061343609997453L, -2889519392695838178L, 6825682518352077045L, -8922186867811676257L, 8172884461239939073L, -6254526210459476268L, 4603827798664618597L, 2867088101655710002L, 8332998285759836606L, -7775381576435942130L, 4672530790940461182L, 1134559637999613131L, 3897488771451098482L, -8137000561907140297L, -772950844530606178L, -1728738397008545669L, 7221495326637043234L, -1849396657442790815L, -9174585730886234628L, 7909827430729881909L, -2444081354433843959L, -4163290364782213538L, -7577480709912625999L, -2101268725598167038L, 137665338910158545L, -5931204152994046793L, -7457759296736876885L, 6746265954835287963L, -189638032760625576L, -1024927361995588099L, -1527455564586976828L, -1177935295216069258L, 5838760703968564286L, -4415126550633053123L, 780392312595241081L, -110204031714277066L, -5604537100301722899L, -4790021541885448666L, 7015947325939974800L, 3645098545556231953L, -561819241209197846L, -934053641427354558L, 2066784160966486324L, -5034171952356883669L, 2661572689932379740L, 1033530071105264154L, -5489401038314458052L, -4578618083660511870L, 3121291101747188375L, 6662680657495023946L, 4471231211228269748L, -3022117047982312241L, -5866468419329903655L, 4219404094166535895L, 4762278602948970945L, -8967953485935648110L, -8547850243595879701L, -3473479388290731703L, 453876631214605276L, 4407685011702703066L, 6616899736578362439L, -5443495875284215503L, -6027728514849410458L, 7990341289637279323L, -4004030578970043324L, -7230942222439593531L, -5114619702887027643L, 1373724075619900927L, -4663118841695326311L, -3086804419763741791L, -5694935987874440366L, 6083572248920684684L, 3484333688484746926L, -3924950286951517547L, -6508957907156220559L, 9139255992929895626L, -8224492325301274488L, -6190959931998490182L, 2189202321390233739L, 716843780901418775L, 8359149623152811187L, 2415494092048157422L, 5243176795453837752L, -236631585242642295L, 4154687863979303353L, 2272222198031926874L, 8690072078618429206L, 202427615156584895L, -8807048875170750130L, -31120709530589209L, 8942462418363155829L, 907753262429150117L, -6636063805428332883L, 7665181140788048952L, -7548467744294317472L, 3239326427400699802L, 6868174095610514980L, 3808219771792118989L, 7543278091629671815L, 9168270020997671451L, -6053858953487310997L, 968811775037617524L, -2306417983241649192L, 584245825585813958L, -2630487407999745605L, -4915095507370037766L, 8750568181363911111L, 1698743779072106396L, 0, -1502945925515520235L, 8236472591980224367L, -5236861298165303713L, 4035151075898375075L, -8144050755230148634L, -1591076393697569110L, 1948891778265760825L, -8727645643825394144L, -7392198592007632774L, -361643978915034283L, 390196158411648178L, 6501762612143760022L, 2496032298569901440L, 6037175610368660865L, -5683947345327655549L, -4242608233385727696L, -2298557723295997507L, -1404809561562629608L, 4925668384127994397L, -6279600722624450555L, 6410254435445760809L, -3116382805945223824L, -3593119323321426024L, 6421246412478107128L, -8389988771804185772L, -692478471504998160L, -2857359617058050347L, 3832728561082858012L, 1367237356757087022L, -3275211779544041812L, 5272189459801538409L, 3250881896629883211L, 8001331881476413578L, 6968391399550921793L, -3214151934877001603L, 809969847888836264L, -7004002273151654537L, -6769223851252275076L, -1974066071074724898L, -6610549085535179872L, -2695487635533189270L, -3680135972265730521L, 3078237133952334918L, -6978929124704531546L, -4495596308024530093L, -6384798519481826098L, 3445914570843754740L, 6242581091097786675L, -1913008689637290737L, 1539119056502398499L, 7794692769390540772L, 1168206872894059153L, -2507695994495548825L, 226938317788999534L, 7419906245093191581L, -8343571233385605543L, 3581420404919564415L, -7801043624446046205L, 7585766634561542998L, 2998877762491110184L, 7174951347083690799L, 8107322624236560080L, -4868539441222958857L, 5494625981129708507L, 8496251452686250594L, 5596216022932782346L, 5661024595188978276L, 2747447103066187747L, -2165963102470172820L, -3338817622691620414L, -4048717794990741361L, -8468508584617454203L, 5085786205181774754L, 4053661314365738856L, 2109836211124176869L, 2336412667751326783L, -6833968380723247342L, -9132096051380542675L, -945607710981729645L, 1742301027778505559L, -3845518068317741573L, 7748764524654516969L, -442177925414869957L, 5468987013722291926L, 6162091280534394461L, 4280460676255686662L, -6445294871958312417L, -609455332283285983L, -4372075848610567444L, -7327464649345800428L}, new long[]{412778415529865760L, 3577342882794069583L, -5641231359968545580L, -8360354891303721342L, -8815395659090061125L, -7417517676636177975L, -6818951615660906963L, 8540370589362648094L, -520997537338351428L, -4727129576760171852L, 7380585705851070183L, 5532990722829248072L, -7691855626550785470L, 2363770411641709807L, 4799219136276863089L, 886827555711267723L, -3685573774419866413L, -7576141180696842327L, -4392773903311365453L, -3287291658763706349L, 152494743391849906L, -3649364066632473462L, -6378955412281134618L, 3618765265895209892L, -1716595120412069307L, 6638666397703976113L, 6746862217775881448L, -6012164977874911745L, 6325409020385589416L, -6565038336846621683L, 4058193356686090212L, 7086287341885701278L, -2771917532509164534L, -7963598493027905477L, -6718493157917047866L, -1989525455461826098L, -642177714062068004L, -8668117067627047671L, -5832910844866177004L, -5472952995583047948L, 3891946276334412253L, -3179016605330421686L, -484727283259111195L, 8437586805018431989L, -7825470045915439735L, -7014338722660612517L, 5716202677831336867L, 3243582143937888061L, -2579911156235362774L, -1571570467631317001L, 2399609570378190006L, 7345426154655236876L, 7619693495944769671L, -2623928864797007432L, -3315748747819219464L, -9075084495080790231L, 7194324827586368711L, 4309013456660281871L, -8196421247265975134L, 4166240605864818621L, 1366177816882650955L, -6109201961362406803L, 6217414342487101681L, 7783606731388437159L, -1326567251088752539L, 9037712741102696455L, -1434402495440951236L, -2328508569491276863L, 8304362858347251262L, 8707177795482651175L, -3423592723977556575L, -5061374920767775450L, -2142416718843079163L, -8088294678366913285L, -371319742740009714L, -6682230743172060257L, -7272631905926302597L, -7308630489489105886L, 1945973140213898976L, 4200834197375652438L, 5435457027409418714L, 7756135292223372597L, -1729698296506932187L, 2508515451320396125L, -8923459624282869534L, -4128744637691189101L, 609168629503044082L, 3755788431048666223L, -1294151922135947890L, 5399380291345002883L, -6145392908131276236L, -6257184306882179105L, 8884253657276313548L, 7648167075477099884L, 1809525021741863762L, 6185017703168619802L, -3936060424307441933L, 2064551487375270258L, -2436564695348784232L, 3469367101608228374L, 1536322983539794137L, 5796100959046534970L, 1773386847580617483L, 108346540153546841L, 9001722862285623390L, 2544785687349641476L, -1185903330127508009L, 551619354788593554L, -1881618742578288233L, 6486896028513362810L, -5327214006029481146L, 717443701121057195L, 2214371934970162368L, -5219386590255766753L, 1140410460104840800L, 7488913346602372798L, -5017208032223676211L, -2034369453084459428L, 994812197283306450L, -8332306493105563376L, 2804228341285155620L, 260410206251574763L, -6978049983912956414L, -6292961768551667834L, 4835367340339408936L, -3510802620212598472L, 6348897592219414216L, -4866111242788671738L, -7999675210372286366L, 2250650893928301721L, 7511575676904462558L, -7453665862510849648L, -2879832976648862637L, 443413779826989003L, -1463594670408230994L, -1838018357033071492L, 1500526641193339008L, 8152292870049500044L, -8468208622468673829L, -6854800545328525708L, -5976114712830143066L, 858245894210178073L, -8224311796882886327L, -4619232891496756499L, -3000621152483837334L, 8743440194190385790L, 1218336215312585465L, 1032276353674575417L, -3546598980344807071L, -44273616367427794L, -7539923910483671056L, 5903954706119241571L, 3395223664118723215L, 5940852870679710344L, -5868829237233520563L, 4685830293981560218L, -5500138837814560410L, -9217998094083183973L, -6528916603821540268L, -1066837721018687209L, 9183300283681142197L, 4649831692234020291L, 9147178532201324012L, -3150721088639387688L, -960114386881264388L, 0, 6898510060154343770L, 1643589765241144626L, -5749199594764804979L, 1402114711967872786L, -4909020925620612972L, -8509612328854475984L, 4353588900056941981L, -4274472907005860575L, 5292673456375059560L, -3819786587920884968L, -2732275386223179295L, -8617879545117768855L, 3999781539141355908L, -7154578025966711831L, -2892636494603496909L, -6414945272642414145L, -7118720227070778448L, 6049120102845506257L, 7933416458737094421L, 4461908978498334148L, 6790446112744143107L, 3726873057198478333L, 7237529453753559893L, 3864037041512891446L, 7046626506133690741L, 304722305440127609L, -180302004885450084L, -4238193929723523720L, 2934657069911674141L, 6076891152586415427L, -3783717699158133951L, 4953135073593642938L, 5569207977274658321L, 4501008218251986991L, 4608914949056012406L, -4428912061564865814L, 4989423796032989155L, -7727641956932165093L, 3207522108247185252L, -924344479047095131L, 3108845752482162934L, -5608256674910105281L, 5256746322603637809L, 3359313093287303894L, 1679799455245938027L, 5680416363222969338L, -7861397160959494704L, 5089304188877242888L, 5125161971465923153L, 2663698829192085142L, -1103038706126747314L, -80402905395234953L, 2840208181611518845L, -4757783617672493217L, 6456820608799639185L, 7891434163331525374L, 8401668394735843756L, -2280687896300332105L, 3072644785963581615L, -789462627719562386L, -8967161494941511824L, -4569866251420565672L, 8268585413250313831L, 1254405120516291232L, 1909966976157497017L, 8848404743649085333L, -4092879008052510518L, -8776312905484698288L, -678237734114500987L, -1608487313068402148L, 8116101939860513749L, 750401899863958592L, -5169412425057929857L, 6938439418119057708L, 6595232530173053731L, -2172508620443159570L, 2970426959157404996L, -3971997302950668630L, -5364694639978582355L, -9109661608865496382L, -3042586965901860991L, -216281829035099451L, 8576420872327912519L, 2100417098697099563L, -335480565948299945L, -2471705565500754317L, 2699828134389257935L, 8041674830518265676L, -4533860103266674943L, -825373182915865801L}, new long[]{4535860555263248921L, -1593883792362675665L, 6140263643322089338L, -6967817572884739277L, -9068728722506311860L, -5119179363064467534L, -3726516434561966253L, 3976828915743059002L, -7597780219754517232L, 1674533312481288529L, -5886538279117927405L, -194983811068225421L, 1971238590622152549L, 3457832774275448914L, -2295860740536826868L, -6652315346019870505L, 4727861667757458726L, -360640838872845927L, 258683541723454221L, -4212320325738251920L, -4700056087296932696L, 2233564259985426290L, 1378062126584976310L, 595850907021173971L, 1148729542089166137L, 7220711707371485274L, 4275768676387371534L, 3496324401055548880L, 5165544922527804988L, -956350612060285622L, 8412095690608439521L, -3467835190780509090L, -1868861577046741226L, 8847930418030264104L, 3309372870217980335L, -6026061361088047634L, -3133105345988201669L, 4387469920445666276L, -3377435183918791892L, 7765336488733668707L, 7626271911434349726L, -7284186450594579676L, -3896518737231810748L, -2984469520196638010L, -4320040328300053632L, 4089712366057758979L, 2084822880951770767L, -3228798250034046255L, -2818438179677494001L, -5677050606033188463L, 8115270375799669254L, 5758785072471788271L, -1421612514850123208L, 6401431119593581502L, 2607396063788253068L, 149165799264492029L, -8017447770816002550L, -7703331937915472355L, -6791485476041195222L, 3161051439931945653L, 2862129545546507393L, -5714533272975881375L, 1786865009825524840L, -3262866899008497631L, 3531814185980970784L, 1489042636343605852L, 7953372014297400692L, 4127379132466308083L, 703148615521134115L, 3051392466055327813L, 8884721462095101400L, -7563314075847069728L, 8288941250235652363L, -82120263218953346L, 2902931453887900088L, 8254758264932555771L, 446716860198103834L, 6435790520947517774L, -4979585920924371377L, -3856260413246245815L, 9043176952977856194L, 5945702658036389520L, 5618980515518141202L, -7981861276107848454L, -2502052263308094184L, 4424111993825693972L, -4449788790258986854L, -2948734028505389002L, -3412032698246774308L, 2457938976092230806L, -1165748696601507531L, 1042563110803492809L, -3747776250095536455L, 1000057432295396548L, 298081034413880039L, -474645568105829740L, 9182311907627011903L, 4237995257073580286L, 7360269973856297383L, -5295414172587761541L, -6373502291430987216L, -4063613031681449843L, 6575665438039683251L, 6873491385755763284L, 5461089107914913800L, -3577775055518873938L, -8086901795456695416L, -9208569554887962959L, -919672336669616198L, -4944387025271606081L, -3097896520644005429L, -7107622129831046450L, -8928832832669205418L, -8475347371214605409L, 4759102407226695211L, -1068097064803381689L, 8551269127753525532L, 3200854107087625055L, -230332776909038973L, 2268055074172700034L, -1104598319098278729L, -2187201184074365188L, 7467557820838912855L, 5842407176390331805L, -4665450842291730856L, -6901417610102864934L, 406460662087397399L, -6198315592433244679L, 2713878548564622716L, -2632949749941649918L, -5537491248627724180L, -1759061912934011418L, -5083451602578264766L, -2353380153490207515L, -1273221880008422459L, 1340149631943889222L, -509101851032934300L, -5259045396831739253L, -4598494993368938137L, -7842091911972561657L, 8063408691889325956L, 2565552841162102374L, 4619087852284151766L, 5214791045043151621L, -6621485381509140163L, 8447401294454977041L, -7386369256688836567L, 2118998135578172543L, -46523907001319026L, 1638138058256147361L, -6512991288666475571L, -7423992098470976807L, 7923814141646626425L, 8745197289204327461L, -8195571213428113032L, 110046607829271280L, -1445494248467825710L, -4839123971720012459L, -5919462946550491362L, 852275931467612126L, -6166501560576966924L, 6838009262779170980L, -788230540367692640L, 1935925255570044309L, -1551942601407268574L, 0, -8822376749060931930L, 5055648419791580364L, 744521925918424366L, 8708792173461317333L, 3012835619118082888L, 2417128113004220315L, 1525826018450700460L, -8961158816430844484L, -4343200236693384598L, -7004328756879980093L, 555623154201897450L, 9144795202799799759L, 3942477176883605194L, -8788888637889305173L, -326429747316083863L, 5511376580148613602L, -2782077065878689793L, 2755821882842654321L, 7814304129864883337L, 5354596692910111480L, -2669767160806458126L, 6280103384783087239L, 1191443428809820347L, -8615256373451920798L, 3349066620751495842L, 7030425627006208077L, -6305639805172127991L, -2540001088809363480L, -1314034877561220920L, -6482311944371394368L, -4492292368662033513L, 4572398174778067177L, -6761929720943764953L, -6058791419533034492L, -826038134467559856L, 6698133237560285529L, 6924249334748056253L, 4915877947555788081L, -8335447238620784507L, -5398145166680982666L, 893432504920462900L, -5434972439063135866L, -7144308136435675074L, 3644679859973545005L, 1822496103478537880L, 4867631031866531035L, -7246386587163018796L, -9101106301180867519L, -2390870482918994411L, 5651355959728424991L, 6102500154237255050L, 5321106438415311349L, -5780327991925453085L, -677612315386943571L, 6541340121823556163L, -8226814104810431883L, -8505466570320058222L, -3616892129401250397L, 5982354661116236896L, 7656949129855104915L, 6733579076392590249L, -2147505281628267023L, 6242444349043369079L, -4170944906378075523L, -1907416263749389285L, -7737550691966192403L, 7063352394543305536L, 7169984984404332976L, -8365591653203775121L, 5805861825662078829L, -1700225492413652769L, 9005272120822338610L, -4005320658966647372L, 8149771120223764726L, -2017179644254701845L, -7877433215864021001L, -5575430213156515172L, 2309691269046898027L, 3794159109699761975L, -2038879809766744319L, 5025527060452063169L, -639979543376370339L, 7517355687739125358L, 7328458050963454634L, 8586890291714583532L, -8682537007609370789L, 1228969994608986699L, 3680135560314805981L, -4805045392508215387L, 3828474564935022023L}, new long[]{-8453070235243615635L, 4884127456122942266L, 633234397777501925L, 4175331866391974078L, -4485881859065591886L, 3179702086296496554L, -1512837584588167014L, -7752573287164883235L, 2821567796802171918L, -8429518127726092206L, 8620367719189969058L, -6534403333025349498L, 2483193514877514189L, -2626196862965158658L, 6709821147687032714L, 1033155461149792359L, -1270162888182207143L, -5769827404365637859L, 7895548116537857006L, -731649153213821910L, -713343999045677205L, -7647763973851249438L, -1429157854399929305L, -3576825843976268310L, -4260165995353210255L, 5087312367917758201L, 4403136284925796162L, -7001683542362597050L, 3775805186400799640L, 7039684027147830007L, -4097783045094489808L, -8749424154144572556L, -8707936849463168693L, -3223332091657620965L, 7393281011622612554L, -3839783834919855594L, -6564596451137123655L, 4010248068099147993L, 1391157335655481238L, -9045169530825444216L, 4570854599768479292L, -8189094146226821743L, 6677411409753660853L, 1869614486838700045L, 2692552123250949488L, 5803321545042218156L, 2939237684151739990L, -5883521838890148574L, 979419644422445862L, 3673082354135452954L, -6913296576561183419L, -415785719237910926L, -834198937845742059L, 8160101394646269472L, 8665997893524695802L, -4821127355493817676L, -211357278447627569L, 5384800866856167392L, -5530020817350821165L, -4854011018389182325L, 1572125733959825684L, -2126792025060737984L, 5756880660441440803L, 9141459606454807672L, 5643134515567552540L, -1831053266724195396L, 3878345071173861799L, -9219713781305836042L, 2223083610095396016L, 7793025783231257041L, 270525564056519489L, -599737493290351276L, -3630580481258694997L, -3980128841890065560L, -3372763326975378587L, 2096675571659106289L, -2722105626296801599L, -6792565267702591622L, -7982779848137766114L, 3546709370140069467L, -2740375726023973504L, 177299642257213822L, 5128824965654363334L, 3284371762775499669L, -5027102895479968247L, -1791810028540380797L, -43630025795953743L, -3929600256180692649L, -4338348378199077172L, -6738813919702414277L, -7350213990308637189L, 1469770529583346475L, -2180581718931620095L, 8788550027033796805L, 7435101501630170229L, -4431564408731826957L, 7273261710249789236L, -1324515669982335464L, -320272809040341939L, 4054715969654905473L, 7599903567200476178L, 5246485543787097758L, 2066061333143563726L, 8899911909190592955L, -7128040995085149689L, 6203347905963379246L, -5167386234789582985L, 8982737327710905606L, -5677756788191890515L, 4733860583378205252L, 8385890890472733667L, -8870358421544177142L, 1983784429268132211L, 1144615724587504216L, -8949243203173892425L, 874653248460230937L, 8806272569836118916L, -5323464818055102704L, 8490507753801150940L, 4996983704035276216L, -2547329411460620221L, -8242880533652363568L, 3101674511553930519L, 8063548039483480720L, 2782314667368316465L, 7188904195392064393L, -5211864924090600145L, 9015613289737121593L, -6285131514020389984L, 6918945025995344072L, -8075373294475235410L, 6314684983379722257L, -241532845093005072L, 516733887222336701L, 5295035016025023649L, 4372970618206377341L, 1367579971541251497L, -1675255866329961509L, 4788193436127426821L, -8033431620036738783L, -1920834373681827587L, 8286510523341552993L, 4528946180991933443L, -1115059448466290199L, 354332099228667900L, 1703685653761847402L, -2033127364819077505L, -554171441618135284L, 1749306493112033842L, 6593587578816598280L, -3139112079942074714L, 3696774096474081061L, 6359145787360465481L, -4695297660307955211L, 7551609152712119853L, -3421199581619080870L, -85565928058662514L, 5408360666650553823L, 1887903149406137164L, -6643353753801603580L, 1193308391354416343L, -6122745256225810207L, 7714012032021747052L, -940295458348941161L, 3338705706857455828L, 0, -3818308703608942551L, -1953665223426671934L, 8307846011238545246L, 7949845912698622127L, 123000737600621119L, -3465393072583450667L, 3896669045897085670L, 1241734746156300008L, 3450192318869875435L, -1624472154218651164L, 773588076271081371L, -5446358391519529362L, 4966387029739569031L, -6444585804073991225L, 9180589562619618887L, -7518677962122949220L, -2516687689508984196L, -4227713340001105842L, -8591376611877854445L, 5589364474795928413L, -5728452502948824686L, -5341733827254846383L, -9099519005106489399L, -5551364006150524692L, 795073098915667364L, -1066649621789244458L, -5937835998867923357L, 7690267545386164051L, 2659693781377578831L, -5044808816750465720L, -7856985207392810913L, 6500344023943830327L, -2390298213912958659L, -4608855104520647283L, -4933455855289899978L, 1589851584549665365L, 2429422383846896268L, 6482023338771290230L, -3036729392062401383L, 6185590308720085359L, -6236844791758827105L, -8839769439558879179L, 6080806279852835664L, 2576885667214146546L, -6962009294672981127L, 6001208834408615917L, 6836195239104500939L, -6040333039102815140L, -2905178410103177753L, 3080356643708727080L, -2860693619659558977L, 2306958247692105907L, -6402773006393882120L, 477155333442143874L, -3735336985853682540L, 386794645880882627L, 7093418736453091766L, 4288595764497750464L, -3246936939308599260L, 5979776620583929298L, -4137334106762671345L, -2303035963802815170L, 7303480121366170891L, -7473099242571571260L, -1534127960405515611L, -7331909943831013702L, -7160476017532022728L, 5486956530453307746L, -2348898833569914110L, -4656142419646682166L, -7835527709155294624L, 683790475565323482L, -8345280785751675665L, 8109430964352234527L, 4193092754259694591L, 4613640514157211771L, 6875861785975561972L, 2264473090495966863L, -433528061428458189L, 3498327026982732900L, -8542852432728676052L, -3019022379190732840L, -1158686167486945434L, -7630022740424964189L, -6146464449756130594L, 8508793109654811293L, 5853965616021964435L, -916593816117900632L, -7238641104478299003L, 2990031287613762665L}, new long[]{9094991057681989827L, 8606138803235823195L, -2286200986180536915L, -8724216130027185838L, -1649148858432656587L, 4026406244121087995L, -7635863337866995078L, 793466831469952157L, -875870498908510964L, 7069806061322532341L, 9025437343642800970L, 7902240744518357090L, -6962787910639909662L, -1403860579092282445L, 169507756355412485L, -6287132366789145831L, -396162960508142700L, -5352074804142321757L, 8708198706664012748L, -2075344634876451292L, -4084819757827458690L, 1669125631761648043L, -4407130716549885448L, 6740073072435942682L, -8819606099442431269L, 2010954567078870965L, -702210179433312886L, -3237789452609264804L, 734067863229058321L, -1715852844487206215L, -6780347474255882879L, -1234467515678383690L, -939753275567238016L, 919214179616323102L, -4836479128919502533L, 3253262042600145346L, 8178958160323126612L, 3337947751052939851L, -434695500023977955L, -7029504953396562578L, -3596390815882237978L, 1052577896389186587L, 2193586592470914867L, 2442179127876909020L, -3778948349093605536L, -8171637376153569722L, 5137708932055784227L, -6227768720359261547L, -8303875261599624125L, 4815958689639822245L, 84753878177706380L, 6315843737766598667L, -64743613097569518L, 3871579785502944766L, -3903411312947434139L, 5793075969118851720L, 249718177605522313L, -8430187655510548800L, -514890802992621167L, 5498396982908774334L, -5688626311019391319L, 7667703386526505697L, -1763570622529142994L, -9138337821371313199L, -311433546468111848L, 1929022448056995385L, 1586665506641377319L, -6475019125594218750L, 8445678447034858590L, 7274058453835599610L, 2629305166521655130L, -2637746980779504568L, 8787833086900898368L, 1545819354008644526L, 3789645467455986802L, 5856993792710681348L, -1103552092532705659L, 2091361543251510458L, 7459518732372467059L, 7397325080452181247L, -3111338451506714145L, 4059487177496226412L, 559362848516098691L, 3155811880282733261L, 339015512710764810L, 499436355210984207L, 4260721118560188901L, 673503137787469464L, -3365532740684676775L, 4141949501641595872L, -8664854682622924578L, -5969827484503727201L, 5626135598191838651L, -3026606838441060269L, -6860593217317067763L, -3647879656817937297L, -8883511003774190761L, -2378568021286198066L, 5444143179324534077L, -7294069234986242972L, 609631631123197716L, -5523727707549764436L, 5576337977799677490L, -1321411723963813313L, -618078659199583226L, -4151521544861120270L, 4387173184941765478L, -5082267926572090947L, -4572121610279439363L, 5708620050009289783L, 6430542613299891216L, -2988006129208833062L, 1851664366124113328L, -5434569976195760593L, -9054144591182708648L, -8004677230250270347L, -1044133607961229559L, -7755831154581784449L, 4978440652618840358L, 4581695294717042927L, -5164165273538705359L, 3091344129077791553L, 7147744857192531065L, 4652093626960253344L, -1156491198976405446L, -3430015610173165355L, -8613457947268510391L, -6533824529218007925L, -2204279587396795359L, -857080412230766705L, 1346746777927262509L, -2717416407949558332L, 2259738658050909887L, 6111753265489546114L, -5801516065654160998L, -1555388365253904196L, -1883419760710312661L, -5585908440206867168L, 7729369582102031213L, 8912221009216268357L, 4519477316101755235L, 1281193087194051236L, -3297738211024334128L, -8091393832113813558L, 8118974354974954712L, -8549025517874578235L, 8521442237103337431L, 8066035438451585639L, 4453855455643222762L, 5377403871458974897L, 6345848246193028508L, 6845086483143640723L, 7988624098924168171L, 8365446172989525458L, 1467823520972380706L, 2935396374752471364L, 2813067799104965843L, -7553963791875298314L, 403485462937118854L, 2688701935736925910L, -2483016523405101241L, -4245213868322808965L, 3468874151188153720L, -5196122377024721498L, 1132260792577222039L, 0, 3535028415789053172L, 2491459977799754837L, 1003369614229768082L, 6675627174024062102L, 2029743588748113206L, 4729507165508558892L, 3637180897245407101L, -4494147492598365583L, 1413426849607831713L, -5885706822078681066L, -2876680564085760063L, -6049474784002780653L, 2575613213387593177L, 5320806183970131768L, -7132290993934539033L, 3422699430205023175L, -6593786619212038905L, -7371988033351401491L, 5071567999032830639L, -2319147337689098942L, -2546901499085257013L, -5755341154755156187L, -5039803533475599820L, -1949596290422182745L, -4307443116932011273L, -7809662711198584068L, -8219159179136522801L, 3173053820371464270L, -2907808627218761130L, 2362498430710285904L, 4897844766612488745L, 6236211556551125383L, -9222526378770226595L, -777413184082125309L, 1774266358176803900L, -7678395900680418829L, -4962370478595122248L, 8283899003267266269L, 4916772258018216106L, -2152722576735774808L, -197091380988415721L, -3845122679784571156L, -129224283564645730L, -8974499490705067564L, -3514471616123578774L, -6132310581227493092L, 2749198491462122847L, -7943022304666578695L, 8966051432100897478L, 9158911080295248207L, -3965042186711950103L, -6410584497178874226L, 6195919557778536974L, 5258610333024763572L, 7340795562680270710L, 7820356866570772974L, -3725255399656372765L, -4703049166709492930L, 1218977307603845928L, -5274083438005724118L, -4770362110272610121L, 5926479337025089677L, -7449951293353308575L, -7211571863907705368L, -8490147546478973108L, -6648039220059424892L, -1493156917619619536L, -4324684060446515084L, -7194473925616724117L, 7508364738339027172L, 6905068089466205983L, -257037940377878373L, 3949006037152890487L, 2995320669031979208L, -6732757501548149240L, 5985863049541370113L, 4182723086503020649L, 7574503472341076328L, 8348347100700559185L, 8828052517901670857L, 6506238233651847065L, 6937453620375099376L, -1825203695318757726L, 3698801050773903089L, -2792546844826423731L, 7019935873167451772L, -7875781928866380944L, -6068403477874304880L, -4641396440150900046L, 6586468308675751445L}, new long[]{-3444757183192547354L, 1637721477308921125L, -6297248449898319672L, 7646921253694161755L, 7930897700415732235L, 7354091399752226219L, 8517004666874317814L, 5453187778286554101L, -1043976743468927160L, -4194833387358178817L, -7708955174336155445L, -8563204505528125338L, -5712286124442861259L, -6823037065440364932L, -8275920727835279050L, -2974881390760536930L, 3965582442916511115L, 818990539008627868L, 6511022660614307004L, -1320077589205483547L, -3262719323413484082L, 6797246517703968236L, 2154964243676750265L, -5954292490194018164L, 3398770582681996406L, 6305239209379988312L, 4529647259392179007L, -3901986219323627761L, -8953700191097190930L, -6484135588680797168L, 1169952615461543517L, 3200289132027606858L, 4147956921301236051L, 708224122457687732L, -3614636676010189217L, -459997231093475096L, -7147120204223564161L, -4852545587358263355L, 8231768351619019430L, 8694883466081947438L, 1455760652066973453L, -8866994048856881278L, -7431164614507622609L, -1132130964538483108L, -2635626018905855110L, 7243836256093423491L, 3660620939660078543L, 2208053939432577669L, -1611933249001666891L, -174895080934727240L, -4029722790011892197L, 3377712478417560930L, -551951845368008196L, -1501670271861746531L, 6217894297849621068L, 7825436358742779939L, 4987043392780078893L, -6063885576440067084L, -5030923433844245315L, 8746199649574856250L, 869662533239166704L, -3796286352345451225L, -1521602510851146359L, 2911244210510417434L, -64431099335674992L, -6948146172091560637L, -7618076501429580809L, 5928147536793457436L, -7233802500807019501L, 5738424067781505701L, 4545920254677684779L, -4088906883540786217L, -7905997789725412697L, -3210311977975446310L, 2538748850867346054L, -6590450082657491400L, -5425002303774099355L, -2455945396081426430L, 763205940277591432L, -4430134953212300397L, -8385457009380595122L, 3093811003563252786L, 4790004205042634049L, 8356374131917757362L, 525807322001048172L, -8472943208417328294L, 8060006530596508447L, -4140047660305118525L, 4971791225320957497L, -2090548950504402391L, -6769791891600257728L, 1866917567049488617L, -844781378265929972L, 4878334347704591445L, -2869059261100175290L, 5838476093026002976L, -1785299366336707987L, 585131888633540512L, 4258502335484898171L, 9216164226481474882L, 1051613531605566680L, -9135643629782968378L, -5660125035251783647L, 7592012931346331751L, -662303645644098268L, 1921896258116084693L, 3288584640079142494L, 182885720694182440L, -8015847144335122289L, 4347442274373970199L, -6191868403371105568L, 470303682846092152L, -2691269845522873746L, -4373505448783357305L, 7877737635941138743L, -263331292381624148L, 8981595325954651774L, -354518366482511168L, -4617554474609824519L, 7536474657577537907L, -3847708088685798349L, -4907725647172659799L, 998525038457700324L, 8121292137418072206L, -1983208384017991343L, -8292017801529169886L, -1230246063685679911L, 1689003026191473713L, 6955846591918243539L, -5477907817628009975L, -7995247020750796389L, 1104161065046732236L, 5822238831865856308L, 7770259743761115727L, -7724066638932354593L, 3109098905151763750L, 7477148998953467071L, 5270373732550072797L, 235152363269307196L, 2264823631868769169L, -6879983194860478616L, -3152901566336629066L, 129144564315678996L, -6010956629246162536L, 6107963510664673380L, 2809900646717377218L, -2402152012640863426L, 292565944326076752L, -1895757919103578043L, -933739123822025376L, 7062097245496290555L, -1699102754331938911L, -3738854843827800245L, 6021262719684655624L, 1972895747902540481L, 3945791491441759391L, 8801111098641915142L, -4746241057700133395L, -3503934099848459145L, -646875556056753104L, 5560617129282953357L, 6890080809738628344L, 2627701227983280362L, -8756221997843360342L, 5539875718724946329L, 0, -1412735959647742223L, -5369322743027527311L, -4483453897402251089L, 7299656588959035031L, 1583357035284794905L, -5141091716070003051L, -6246073038520247844L, 6400302286636641940L, 6420058603497817984L, 6691528990365472708L, -9046393196149773062L, -3316034865972881678L, 9038681643377794922L, -5314466647222146483L, 4440522822651396099L, 8411535559894538718L, -2350026657572040150L, 4238992274866487919L, -369665565213580332L, -4607954124316941893L, -8847097543996772714L, -4322851948414609173L, 5169063728564034821L, -5775964245203979612L, -7526087252531780893L, -5085131195746564223L, 2428230993188407470L, 3570877924549138163L, -3560844495143377565L, 4060646644394037319L, 3855408526229221283L, -1804949614949815431L, -2272807811582181375L, 8928671747737777170L, 1348049825574685813L, 3677174894530839771L, -8093047239747710178L, -2745544849441605294L, 8644847306339132130L, 2719514554751545854L, 8462570783810646218L, 1405101508380157281L, 3478079366649118695L, -6538992612182536404L, -2584948672878155498L, 6598086612559222184L, -5606876459814153443L, 3768380308409468599L, 6708048310613262032L, 1739040292966674941L, -7036336127295658921L, -7325510790119301881L, -6645608358396189612L, 9091840505278506070L, -8669017857895383874L, 4700331558701315709L, -7415771159533754821L, 4679309188558905193L, 2030323828767328429L, 5649811934742993841L, 415940168518455364L, -2179868550282598123L, -954655941116998540L, -5190986870181543079L, 7190925116101314031L, -7126238021551530133L, -2074417242192479427L, -3029668045542985822L, -753108823078777320L, 5077496726762238993L, 2339654594279481786L, -4800103607302455599L, -5900428737983865936L, -85066957045458300L, 6127437837148246384L, 3002776577694476046L, -6356433652615537404L, -8186022235176912374L, 1294312070793836361L, -2918955505047487094L, -1213832296285327923L, 5255402455948538057L, 2517972805691405202L, 7008429859484506055L, 5361338717396067041L, -9152021663061328174L, 8178097563976550810L, -7817526943664710733L, -8582820119530581646L, 2824906557929530326L}};
        private static final byte[][] values = {new byte[]{-79, 8, 91, -38, Ascii.f53592RS, -54, -38, -23, -21, -53, 47, -127, -64, 101, 124, Ascii.f53596US, 47, 106, 118, 67, 46, 69, -48, Ascii.SYN, 113, 78, -72, -115, 117, -123, -60, -4, 75, 124, -32, -111, -110, 103, 105, 1, -94, 66, 42, 8, -92, 96, -45, Ascii.NAK, 5, 118, 116, 54, -52, 116, 77, 35, -35, Byte.MIN_VALUE, 101, 89, -14, -90, 69, 7}, new byte[]{111, -93, -75, -118, -87, -99, 47, Ascii.SUB, 79, -29, -99, 70, Ascii.f53593SI, 112, -75, -41, -13, -2, -22, 114, 10, 35, 43, -104, 97, -43, 94, Ascii.f53593SI, Ascii.SYN, -75, 1, 49, -102, -75, Ascii.ETB, 107, Ascii.DC2, -42, -103, 88, 92, -75, 97, -62, -37, 10, -89, -54, 85, -35, -94, Ascii.ESC, -41, -53, -51, 86, -26, 121, 4, 112, 33, -79, -101, -73}, new byte[]{-11, 116, -36, -84, 43, -50, 47, -57, 10, 57, -4, 40, 106, 61, -124, 53, 6, -15, 94, 95, 82, -100, Ascii.f53596US, -117, -14, -22, 117, Ascii.DC4, -79, 41, 123, 123, -45, -30, Ascii.f53593SI, -28, -112, 53, -98, -79, -63, -55, 58, 55, 96, 98, -37, 9, -62, -74, -12, 67, -122, 122, -37, 49, -103, Ascii.f53592RS, -106, -11, 10, -70, 10, -78}, new byte[]{-17, Ascii.f53596US, -33, -77, -24, Ascii.NAK, 102, -46, -7, 72, -31, -96, 93, 113, -28, -35, 72, -114, -123, 126, 51, 92, 60, 125, -99, 114, Ascii.f53587FS, -83, 104, 94, 53, Utf8.REPLACEMENT_BYTE, -87, -41, 44, -126, -19, 3, -42, 117, -40, -73, 19, 51, -109, 82, 3, -66, 52, 83, -22, -95, -109, -24, 55, -15, 34, Ascii.f53586FF, -66, PSSSigner.TRAILER_IMPLICIT, -124, -29, -47, 46}, new byte[]{75, -22, 107, -84, -83, 71, 71, -103, -102, Utf8.REPLACEMENT_BYTE, 65, Ascii.f53586FF, 108, -87, 35, 99, Byte.MAX_VALUE, Ascii.NAK, Ascii.f53587FS, Ascii.f53596US, Ascii.SYN, -122, 16, 74, 53, -98, 53, -41, Byte.MIN_VALUE, Ascii.f53593SI, -1, -67, -65, -51, Ascii.ETB, 71, 37, 58, -11, -93, -33, -1, 0, -73, 35, 39, Ascii.SUB, Ascii.SYN, 122, 86, -94, 126, -87, -22, 99, -11, 96, Ascii.ETB, 88, -3, 124, 108, -2, 87}, new byte[]{-82, 79, -82, -82, Ascii.f53588GS, 58, -45, -39, 111, -92, -61, 59, 122, 48, 57, -64, 45, 102, -60, -7, 81, 66, -92, 108, Ascii.CAN, Byte.MAX_VALUE, -102, -76, -102, -16, -114, -58, -49, -6, -90, -73, Ascii.f53587FS, -102, -73, -76, 10, -14, Ascii.f53596US, 102, -62, -66, -58, -74, -65, 113, -59, 114, 54, -112, 79, 53, -6, 104, 64, 122, 70, 100, 125, 110}, new byte[]{-12, -57, Ascii.f53594SO, Ascii.SYN, -18, -86, -59, -20, 81, -84, -122, -2, -65, 36, 9, 84, 57, -98, -58, -57, -26, -65, -121, -55, -45, 71, 62, 51, Ascii.f53585EM, 122, -109, -55, 9, -110, -85, -59, 45, -126, 44, 55, 6, 71, 105, -125, 40, 74, 5, 4, 53, Ascii.ETB, 69, 76, -94, 60, 74, -13, -120, -122, 86, 77, 58, Ascii.DC4, -44, -109}, new byte[]{-101, Ascii.f53596US, 91, 66, 77, -109, -55, -89, 3, -25, -86, 2, Ascii.f53586FF, 110, 65, 65, 78, -73, -8, 113, -100, 54, -34, Ascii.f53592RS, -119, -76, 68, 59, 77, -37, -60, -102, -12, -119, 43, -53, -110, -101, 6, -112, 105, -47, -115, 43, -47, -91, -60, 47, 54, -84, -62, 53, 89, 81, -88, -39, -92, Byte.MAX_VALUE, Ascii.f53584CR, -44, -65, 2, -25, Ascii.f53592RS}, new byte[]{55, -113, 90, 84, Ascii.SYN, 49, 34, -101, -108, 76, -102, -40, -20, Ascii.SYN, 95, -34, 58, 125, 58, Ascii.ESC, 37, -119, 66, 36, 60, -39, 85, -73, -32, Ascii.f53584CR, 9, -124, Byte.MIN_VALUE, 10, 68, 11, -37, -78, -50, -79, 123, 43, -118, -102, -90, 7, -100, 84, Ascii.f53594SO, 56, -36, -110, -53, Ascii.f53596US, 42, 96, 114, 97, 68, 81, -125, 35, 90, -37}, new byte[]{-85, -66, -34, -90, Byte.MIN_VALUE, 5, 111, 82, 56, 42, -27, 72, -78, -28, -13, -13, -119, 65, -25, Ascii.f53587FS, -1, -118, 120, -37, Ascii.f53596US, -1, -31, -118, Ascii.ESC, 51, 97, 3, -97, -25, 103, 2, -81, 105, 51, 75, 122, Ascii.f53592RS, 108, 48, 59, 118, 82, -12, 54, -104, -6, -47, Ascii.NAK, 59, -74, -61, 116, -76, -57, -5, -104, 69, -100, -19}, new byte[]{123, -51, -98, -48, -17, -56, -119, -5, 48, 2, -58, -51, 99, 90, -2, -108, -40, -6, 107, -69, -21, -85, 7, 97, 32, 1, Byte.MIN_VALUE, 33, Ascii.DC4, -124, 102, 121, -118, Ascii.f53588GS, 113, -17, -22, 72, -71, -54, -17, -70, -51, Ascii.f53588GS, 125, 71, 110, -104, -34, -94, 89, 74, -64, 111, -40, 93, 107, -54, -92, -51, -127, -13, 45, Ascii.ESC}, new byte[]{55, -114, -25, 103, -15, Ascii.SYN, 49, -70, -46, 19, Byte.MIN_VALUE, -80, 4, 73, -79, 122, -51, -92, 60, 50, PSSSigner.TRAILER_IMPLICIT, -33, Ascii.f53588GS, 119, -8, 32, Ascii.DC2, -44, 48, 33, -97, -101, 93, Byte.MIN_VALUE, -17, -99, Ascii.CAN, -111, -52, -122, -25, Ascii.f53588GS, -92, -86, -120, -31, 40, 82, -6, -12, Ascii.ETB, -43, -39, -78, Ascii.ESC, -103, 72, PSSSigner.TRAILER_IMPLICIT, -110, 74, -15, Ascii.ESC, -41, 32}};
        private final byte[] Cardinal = new byte[64];
        private final byte[] CardinalError = new byte[64];
        private final byte[] cca_continue;
        private final byte[] cleanup = new byte[64];
        private final byte[] configure = new byte[64];
        private final byte[] getInstance = new byte[64];
        private final byte[] getSDKVersion = new byte[64];
        private int getWarnings = 64;
        private final byte[] init = new byte[64];

        public ecDSASha3_256(byte[] bArr) {
            byte[] bArr2 = new byte[64];
            this.cca_continue = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 64);
            System.arraycopy(bArr, 0, this.getSDKVersion, 0, 64);
        }

        private static void Cardinal(byte[] bArr, int i) {
            int i2 = (bArr[63] & 255) + (i & 255);
            bArr[63] = (byte) i2;
            int i3 = (bArr[62] & 255) + ((i >> 8) & 255) + (i2 >> 8);
            bArr[62] = (byte) i3;
            for (int i4 = 61; i4 >= 0 && i3 > 0; i4--) {
                i3 = (bArr[i4] & 255) + (i3 >> 8);
                bArr[i4] = (byte) i3;
            }
        }

        private static void getInstance(byte[] bArr) {
            long[][] jArr = CardinalRenderType;
            long[] jArr2 = {(((((((jArr[0][bArr[56] & 255] ^ 0) ^ jArr[1][bArr[48] & 255]) ^ jArr[2][bArr[40] & 255]) ^ jArr[3][bArr[32] & 255]) ^ jArr[4][bArr[24] & 255]) ^ jArr[5][bArr[16] & 255]) ^ jArr[6][bArr[8] & 255]) ^ jArr[7][bArr[0] & 255], (((((((jArr[0][bArr[57] & 255] ^ 0) ^ jArr[1][bArr[49] & 255]) ^ jArr[2][bArr[41] & 255]) ^ jArr[3][bArr[33] & 255]) ^ jArr[4][bArr[25] & 255]) ^ jArr[5][bArr[17] & 255]) ^ jArr[6][bArr[9] & 255]) ^ jArr[7][bArr[1] & 255], (((((((jArr[0][bArr[58] & 255] ^ 0) ^ jArr[1][bArr[50] & 255]) ^ jArr[2][bArr[42] & 255]) ^ jArr[3][bArr[34] & 255]) ^ jArr[4][bArr[26] & 255]) ^ jArr[5][bArr[18] & 255]) ^ jArr[6][bArr[10] & 255]) ^ jArr[7][bArr[2] & 255], (((((((jArr[0][bArr[59] & 255] ^ 0) ^ jArr[1][bArr[51] & 255]) ^ jArr[2][bArr[43] & 255]) ^ jArr[3][bArr[35] & 255]) ^ jArr[4][bArr[27] & 255]) ^ jArr[5][bArr[19] & 255]) ^ jArr[6][bArr[11] & 255]) ^ jArr[7][bArr[3] & 255], (((((((jArr[0][bArr[60] & 255] ^ 0) ^ jArr[1][bArr[52] & 255]) ^ jArr[2][bArr[44] & 255]) ^ jArr[3][bArr[36] & 255]) ^ jArr[4][bArr[28] & 255]) ^ jArr[5][bArr[20] & 255]) ^ jArr[6][bArr[12] & 255]) ^ jArr[7][bArr[4] & 255], (((((((jArr[0][bArr[61] & 255] ^ 0) ^ jArr[1][bArr[53] & 255]) ^ jArr[2][bArr[45] & 255]) ^ jArr[3][bArr[37] & 255]) ^ jArr[4][bArr[29] & 255]) ^ jArr[5][bArr[21] & 255]) ^ jArr[6][bArr[13] & 255]) ^ jArr[7][bArr[5] & 255], (((((((jArr[0][bArr[62] & 255] ^ 0) ^ jArr[1][bArr[54] & 255]) ^ jArr[2][bArr[46] & 255]) ^ jArr[3][bArr[38] & 255]) ^ jArr[4][bArr[30] & 255]) ^ jArr[5][bArr[22] & 255]) ^ jArr[6][bArr[14] & 255]) ^ jArr[7][bArr[6] & 255], (((((((jArr[0][bArr[63] & 255] ^ 0) ^ jArr[1][bArr[55] & 255]) ^ jArr[2][bArr[47] & 255]) ^ jArr[3][bArr[39] & 255]) ^ jArr[4][bArr[31] & 255]) ^ jArr[5][bArr[23] & 255]) ^ jArr[6][bArr[15] & 255]) ^ jArr[7][bArr[7] & 255]};
            long j = jArr2[0];
            bArr[7] = (byte) ((int) (j >> 56));
            bArr[6] = (byte) ((int) (j >> 48));
            bArr[5] = (byte) ((int) (j >> 40));
            bArr[4] = (byte) ((int) (j >> 32));
            bArr[3] = (byte) ((int) (j >> 24));
            bArr[2] = (byte) ((int) (j >> 16));
            bArr[1] = (byte) ((int) (j >> 8));
            bArr[0] = (byte) ((int) j);
            long j2 = jArr2[1];
            bArr[15] = (byte) ((int) (j2 >> 56));
            bArr[14] = (byte) ((int) (j2 >> 48));
            bArr[13] = (byte) ((int) (j2 >> 40));
            bArr[12] = (byte) ((int) (j2 >> 32));
            bArr[11] = (byte) ((int) (j2 >> 24));
            bArr[10] = (byte) ((int) (j2 >> 16));
            bArr[9] = (byte) ((int) (j2 >> 8));
            bArr[8] = (byte) ((int) j2);
            long j3 = jArr2[2];
            bArr[23] = (byte) ((int) (j3 >> 56));
            bArr[22] = (byte) ((int) (j3 >> 48));
            bArr[21] = (byte) ((int) (j3 >> 40));
            bArr[20] = (byte) ((int) (j3 >> 32));
            bArr[19] = (byte) ((int) (j3 >> 24));
            bArr[18] = (byte) ((int) (j3 >> 16));
            bArr[17] = (byte) ((int) (j3 >> 8));
            bArr[16] = (byte) ((int) j3);
            long j4 = jArr2[3];
            bArr[31] = (byte) ((int) (j4 >> 56));
            bArr[30] = (byte) ((int) (j4 >> 48));
            bArr[29] = (byte) ((int) (j4 >> 40));
            bArr[28] = (byte) ((int) (j4 >> 32));
            bArr[27] = (byte) ((int) (j4 >> 24));
            bArr[26] = (byte) ((int) (j4 >> 16));
            bArr[25] = (byte) ((int) (j4 >> 8));
            bArr[24] = (byte) ((int) j4);
            long j5 = jArr2[4];
            bArr[39] = (byte) ((int) (j5 >> 56));
            bArr[38] = (byte) ((int) (j5 >> 48));
            bArr[37] = (byte) ((int) (j5 >> 40));
            bArr[36] = (byte) ((int) (j5 >> 32));
            bArr[35] = (byte) ((int) (j5 >> 24));
            bArr[34] = (byte) ((int) (j5 >> 16));
            bArr[33] = (byte) ((int) (j5 >> 8));
            bArr[32] = (byte) ((int) j5);
            long j6 = jArr2[5];
            bArr[47] = (byte) ((int) (j6 >> 56));
            bArr[46] = (byte) ((int) (j6 >> 48));
            bArr[45] = (byte) ((int) (j6 >> 40));
            bArr[44] = (byte) ((int) (j6 >> 32));
            bArr[43] = (byte) ((int) (j6 >> 24));
            bArr[42] = (byte) ((int) (j6 >> 16));
            bArr[41] = (byte) ((int) (j6 >> 8));
            bArr[40] = (byte) ((int) j6);
            long j7 = jArr2[6];
            bArr[55] = (byte) ((int) (j7 >> 56));
            bArr[54] = (byte) ((int) (j7 >> 48));
            bArr[53] = (byte) ((int) (j7 >> 40));
            bArr[52] = (byte) ((int) (j7 >> 32));
            bArr[51] = (byte) ((int) (j7 >> 24));
            bArr[50] = (byte) ((int) (j7 >> 16));
            bArr[49] = (byte) ((int) (j7 >> 8));
            bArr[48] = (byte) ((int) j7);
            long j8 = jArr2[7];
            bArr[63] = (byte) ((int) (j8 >> 56));
            bArr[62] = (byte) ((int) (j8 >> 48));
            bArr[61] = (byte) ((int) (j8 >> 40));
            bArr[60] = (byte) ((int) (j8 >> 32));
            bArr[59] = (byte) ((int) (j8 >> 24));
            bArr[58] = (byte) ((int) (j8 >> 16));
            bArr[57] = (byte) ((int) (j8 >> 8));
            bArr[56] = (byte) ((int) j8);
        }

        private static void init(byte[] bArr, byte[] bArr2) {
            int i = 0;
            for (int i2 = 63; i2 >= 0; i2--) {
                i = (i >> 8) + (bArr[i2] & 255) + (bArr2[i2] & 255);
                bArr[i2] = (byte) i;
            }
        }

        public final int Cardinal() {
            return 64;
        }

        public final void Cardinal(byte b) {
            byte[] bArr = this.cleanup;
            int i = this.getWarnings - 1;
            this.getWarnings = i;
            bArr[i] = b;
            if (i == 0) {
                cca_continue(this.getSDKVersion, this.init, bArr);
                Cardinal(this.init, 512);
                init(this.Cardinal, this.cleanup);
                this.getWarnings = 64;
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            ecDSASha3_256 ecdsasha3_256 = (ecDSASha3_256) setpaddingrelative;
            System.arraycopy(ecdsasha3_256.cca_continue, 0, this.cca_continue, 0, 64);
            System.arraycopy(ecdsasha3_256.init, 0, this.init, 0, 64);
            System.arraycopy(ecdsasha3_256.Cardinal, 0, this.Cardinal, 0, 64);
            System.arraycopy(ecdsasha3_256.getInstance, 0, this.getInstance, 0, 64);
            System.arraycopy(ecdsasha3_256.configure, 0, this.configure, 0, 64);
            System.arraycopy(ecdsasha3_256.getSDKVersion, 0, this.getSDKVersion, 0, 64);
            System.arraycopy(ecdsasha3_256.cleanup, 0, this.cleanup, 0, 64);
            this.getWarnings = ecdsasha3_256.getWarnings;
        }

        public final void init(byte[] bArr, int i, int i2) {
            while (this.getWarnings != 64 && i2 > 0) {
                Cardinal(bArr[i]);
                i2--;
                i++;
            }
            while (i2 >= 64) {
                System.arraycopy(bArr, i, this.CardinalError, 0, 64);
                byte[] bArr2 = this.CardinalError;
                byte[] bArr3 = this.cleanup;
                int length = bArr2.length;
                for (int i3 = 0; i3 < length; i3++) {
                    bArr3[(length - 1) - i3] = bArr2[i3];
                }
                cca_continue(this.getSDKVersion, this.init, this.cleanup);
                Cardinal(this.init, 512);
                init(this.Cardinal, this.cleanup);
                i2 -= 64;
                i += 64;
            }
            while (i2 > 0) {
                Cardinal(bArr[i]);
                i2--;
                i++;
            }
        }

        public int configure(byte[] bArr, int i) {
            int i2;
            int i3 = 64 - this.getWarnings;
            int i4 = 0;
            while (true) {
                i2 = 64 - i3;
                if (i4 == i2) {
                    break;
                }
                this.configure[i4] = 0;
                i4++;
            }
            byte[] bArr2 = this.configure;
            bArr2[63 - i3] = 1;
            int i5 = this.getWarnings;
            if (i5 != 64) {
                System.arraycopy(this.cleanup, i5, bArr2, i2, i3);
            }
            cca_continue(this.getSDKVersion, this.init, this.configure);
            Cardinal(this.init, i3 << 3);
            init(this.Cardinal, this.configure);
            cca_continue(this.getSDKVersion, CardinalEnvironment, this.init);
            cca_continue(this.getSDKVersion, CardinalEnvironment, this.Cardinal);
            byte[] bArr3 = this.getSDKVersion;
            byte[] bArr4 = this.CardinalError;
            int length = bArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                bArr4[(length - 1) - i6] = bArr3[i6];
            }
            System.arraycopy(this.CardinalError, 0, bArr, i, 64);
            cca_continue();
            return 64;
        }

        public final void cca_continue() {
            this.getWarnings = 64;
            byte[] bArr = this.init;
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
            byte[] bArr2 = this.Cardinal;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr2[i2] = 0;
            }
            System.arraycopy(this.cca_continue, 0, this.getSDKVersion, 0, 64);
            byte[] bArr3 = this.cleanup;
            for (int i3 = 0; i3 < bArr3.length; i3++) {
                bArr3[i3] = 0;
            }
        }

        private void cca_continue(byte[] bArr, byte[] bArr2) {
            System.arraycopy(bArr, 0, this.getInstance, 0, 64);
            for (int i = 0; i < 64; i++) {
                bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
            getInstance(bArr);
            for (int i2 = 0; i2 < 11; i2++) {
                byte[] bArr3 = this.getInstance;
                byte[] bArr4 = values[i2];
                for (int i3 = 0; i3 < 64; i3++) {
                    bArr3[i3] = (byte) (bArr3[i3] ^ bArr4[i3]);
                }
                getInstance(this.getInstance);
                byte[] bArr5 = this.getInstance;
                for (int i4 = 0; i4 < 64; i4++) {
                    bArr[i4] = (byte) (bArr[i4] ^ bArr5[i4]);
                }
                getInstance(bArr);
            }
            byte[] bArr6 = this.getInstance;
            byte[] bArr7 = values[11];
            for (int i5 = 0; i5 < 64; i5++) {
                bArr6[i5] = (byte) (bArr6[i5] ^ bArr7[i5]);
            }
            getInstance(this.getInstance);
            byte[] bArr8 = this.getInstance;
            for (int i6 = 0; i6 < 64; i6++) {
                bArr[i6] = (byte) (bArr[i6] ^ bArr8[i6]);
            }
        }

        private void cca_continue(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            System.arraycopy(bArr, 0, this.CardinalError, 0, 64);
            for (int i = 0; i < 64; i++) {
                bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
            getInstance(bArr);
            cca_continue(bArr, bArr3);
            byte[] bArr4 = this.CardinalError;
            for (int i2 = 0; i2 < 64; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ bArr4[i2]);
            }
            for (int i3 = 0; i3 < 64; i3++) {
                bArr[i3] = (byte) (bArr[i3] ^ bArr3[i3]);
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSASha3_384 */
    public final class ecDSASha3_384 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo, setPaddingRelative {
        private static final byte[] CardinalConfigurationParameters = {0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
        private byte[] Cardinal = new byte[32];
        private byte[] CardinalActionCode = new byte[32];
        private short[] CardinalEnvironment = new short[16];
        private byte[] CardinalError;
        private short[] CardinalRenderType = new short[16];
        private byte[] CardinalUiType = new byte[32];
        private byte[] cca_continue = new byte[32];
        private KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo cleanup = new BCXDHPublicKey();
        private byte[] configure = new byte[32];
        private byte[] getInstance = new byte[32];
        private byte[] getRequestTimeout = new byte[32];
        private long getSDKVersion;
        private byte[] getString = new byte[32];
        private byte[] getWarnings = new byte[32];
        private byte[][] init = ((byte[][]) Array.newInstance(byte.class, new int[]{4, 32}));
        private byte[] setRequestTimeout = new byte[32];
        private byte[] valueOf = new byte[8];
        private int values;

        public ecDSASha3_384() {
            byte[] instance = BCXDHPublicKey.getInstance("D-A");
            this.CardinalError = instance;
            this.cleanup.Cardinal(true, new PSSSignatureSpi(instance));
            cca_continue();
        }

        private ecDSASha3_384(ecDSASha3_384 ecdsasha3_384) {
            cca_continue((setPaddingRelative) ecdsasha3_384);
        }

        public ecDSASha3_384(byte[] bArr) {
            byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr);
            this.CardinalError = cca_continue2;
            this.cleanup.Cardinal(true, new PSSSignatureSpi(cca_continue2));
            cca_continue();
        }

        private void Cardinal(byte[] bArr) {
            System.arraycopy(bArr, 0, this.cca_continue, 0, 32);
            System.arraycopy(this.getInstance, 0, this.setRequestTimeout, 0, 32);
            System.arraycopy(this.cca_continue, 0, this.getString, 0, 32);
            for (int i = 0; i < 32; i++) {
                this.getRequestTimeout[i] = (byte) (this.setRequestTimeout[i] ^ this.getString[i]);
            }
            getInstance(configure(this.getRequestTimeout), this.CardinalUiType, 0, this.getInstance, 0);
            for (int i2 = 1; i2 < 4; i2++) {
                byte[] cca_continue2 = cca_continue(this.setRequestTimeout);
                for (int i3 = 0; i3 < 32; i3++) {
                    this.setRequestTimeout[i3] = (byte) (cca_continue2[i3] ^ this.init[i2][i3]);
                }
                this.getString = cca_continue(cca_continue(this.getString));
                for (int i4 = 0; i4 < 32; i4++) {
                    this.getRequestTimeout[i4] = (byte) (this.setRequestTimeout[i4] ^ this.getString[i4]);
                }
                int i5 = i2 << 3;
                getInstance(configure(this.getRequestTimeout), this.CardinalUiType, i5, this.getInstance, i5);
            }
            for (int i6 = 0; i6 < 12; i6++) {
                getInstance(this.CardinalUiType);
            }
            for (int i7 = 0; i7 < 32; i7++) {
                byte[] bArr2 = this.CardinalUiType;
                bArr2[i7] = (byte) (bArr2[i7] ^ this.cca_continue[i7]);
            }
            getInstance(this.CardinalUiType);
            for (int i8 = 0; i8 < 32; i8++) {
                byte[] bArr3 = this.CardinalUiType;
                bArr3[i8] = (byte) (this.getInstance[i8] ^ bArr3[i8]);
            }
            for (int i9 = 0; i9 < 61; i9++) {
                getInstance(this.CardinalUiType);
            }
            byte[] bArr4 = this.CardinalUiType;
            byte[] bArr5 = this.getInstance;
            System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
        }

        private byte[] cca_continue(byte[] bArr) {
            for (int i = 0; i < 8; i++) {
                this.valueOf[i] = (byte) (bArr[i] ^ bArr[i + 8]);
            }
            System.arraycopy(bArr, 8, bArr, 0, 24);
            System.arraycopy(this.valueOf, 0, bArr, 24, 8);
            return bArr;
        }

        private byte[] configure(byte[] bArr) {
            for (int i = 0; i < 8; i++) {
                byte[] bArr2 = this.CardinalActionCode;
                int i2 = i * 4;
                bArr2[i2] = bArr[i];
                bArr2[i2 + 1] = bArr[i + 8];
                bArr2[i2 + 2] = bArr[i + 16];
                bArr2[i2 + 3] = bArr[i + 24];
            }
            return this.CardinalActionCode;
        }

        private void getInstance(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
            this.cleanup.Cardinal(true, new ISOSignatureSpi.MD5WithRSAEncryption(bArr));
            this.cleanup.init(bArr3, i2, bArr2, i);
        }

        private void init(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            while (true) {
                byte[] bArr2 = this.Cardinal;
                if (i != bArr2.length) {
                    int i3 = (bArr2[i] & 255) + (bArr[i] & 255) + i2;
                    bArr2[i] = (byte) i3;
                    i2 = i3 >>> 8;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final int Cardinal() {
            return 32;
        }

        public final void Cardinal(byte b) {
            byte[] bArr = this.getWarnings;
            int i = this.values;
            int i2 = i + 1;
            this.values = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                init(bArr);
                Cardinal(this.getWarnings);
                this.values = 0;
            }
            this.getSDKVersion++;
        }

        public final void cca_continue() {
            this.getSDKVersion = 0;
            this.values = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.getInstance;
                if (i >= bArr.length) {
                    break;
                }
                bArr[i] = 0;
                i++;
            }
            int i2 = 0;
            while (true) {
                byte[] bArr2 = this.configure;
                if (i2 >= bArr2.length) {
                    break;
                }
                bArr2[i2] = 0;
                i2++;
            }
            int i3 = 0;
            while (true) {
                byte[] bArr3 = this.cca_continue;
                if (i3 >= bArr3.length) {
                    break;
                }
                bArr3[i3] = 0;
                i3++;
            }
            int i4 = 0;
            while (true) {
                byte[][] bArr4 = this.init;
                if (i4 >= bArr4[1].length) {
                    break;
                }
                bArr4[1][i4] = 0;
                i4++;
            }
            int i5 = 0;
            while (true) {
                byte[][] bArr5 = this.init;
                if (i5 >= bArr5[3].length) {
                    break;
                }
                bArr5[3][i5] = 0;
                i5++;
            }
            int i6 = 0;
            while (true) {
                byte[] bArr6 = this.Cardinal;
                if (i6 >= bArr6.length) {
                    break;
                }
                bArr6[i6] = 0;
                i6++;
            }
            int i7 = 0;
            while (true) {
                byte[] bArr7 = this.getWarnings;
                if (i7 < bArr7.length) {
                    bArr7[i7] = 0;
                    i7++;
                } else {
                    byte[] bArr8 = CardinalConfigurationParameters;
                    System.arraycopy(bArr8, 0, this.init[2], 0, bArr8.length);
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            ecDSASha3_384 ecdsasha3_384 = (ecDSASha3_384) setpaddingrelative;
            byte[] bArr = ecdsasha3_384.CardinalError;
            this.CardinalError = bArr;
            this.cleanup.Cardinal(true, new PSSSignatureSpi(bArr));
            cca_continue();
            byte[] bArr2 = ecdsasha3_384.getInstance;
            System.arraycopy(bArr2, 0, this.getInstance, 0, bArr2.length);
            byte[] bArr3 = ecdsasha3_384.configure;
            System.arraycopy(bArr3, 0, this.configure, 0, bArr3.length);
            byte[] bArr4 = ecdsasha3_384.cca_continue;
            System.arraycopy(bArr4, 0, this.cca_continue, 0, bArr4.length);
            byte[] bArr5 = ecdsasha3_384.Cardinal;
            System.arraycopy(bArr5, 0, this.Cardinal, 0, bArr5.length);
            byte[][] bArr6 = ecdsasha3_384.init;
            System.arraycopy(bArr6[1], 0, this.init[1], 0, bArr6[1].length);
            byte[][] bArr7 = ecdsasha3_384.init;
            System.arraycopy(bArr7[2], 0, this.init[2], 0, bArr7[2].length);
            byte[][] bArr8 = ecdsasha3_384.init;
            System.arraycopy(bArr8[3], 0, this.init[3], 0, bArr8[3].length);
            byte[] bArr9 = ecdsasha3_384.getWarnings;
            System.arraycopy(bArr9, 0, this.getWarnings, 0, bArr9.length);
            this.values = ecdsasha3_384.values;
            this.getSDKVersion = ecdsasha3_384.getSDKVersion;
        }

        public final String configure() {
            return "GOST3411";
        }

        public final int getInstance() {
            return 32;
        }

        public final setPaddingRelative init() {
            return new ecDSASha3_384(this);
        }

        public final void init(byte[] bArr, int i, int i2) {
            while (this.values != 0 && i2 > 0) {
                Cardinal(bArr[i]);
                i++;
                i2--;
            }
            while (true) {
                byte[] bArr2 = this.getWarnings;
                if (i2 <= bArr2.length) {
                    break;
                }
                System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
                init(this.getWarnings);
                Cardinal(this.getWarnings);
                byte[] bArr3 = this.getWarnings;
                i += bArr3.length;
                i2 -= bArr3.length;
                this.getSDKVersion += (long) bArr3.length;
            }
            while (i2 > 0) {
                Cardinal(bArr[i]);
                i++;
                i2--;
            }
        }

        private void getInstance(byte[] bArr) {
            short[] sArr = this.CardinalRenderType;
            for (int i = 0; i < bArr.length / 2; i++) {
                int i2 = i << 1;
                sArr[i] = (short) ((bArr[i2] & 255) | ((bArr[i2 + 1] << 8) & 65280));
            }
            short[] sArr2 = this.CardinalEnvironment;
            short[] sArr3 = this.CardinalRenderType;
            sArr2[15] = (short) (((((sArr3[0] ^ sArr3[1]) ^ sArr3[2]) ^ sArr3[3]) ^ sArr3[12]) ^ sArr3[15]);
            System.arraycopy(sArr3, 1, sArr2, 0, 15);
            short[] sArr4 = this.CardinalEnvironment;
            for (int i3 = 0; i3 < bArr.length / 2; i3++) {
                int i4 = i3 << 1;
                bArr[i4 + 1] = (byte) (sArr4[i3] >> 8);
                bArr[i4] = (byte) sArr4[i3];
            }
        }

        public final int configure(byte[] bArr, int i) {
            long j = this.getSDKVersion << 3;
            byte[] bArr2 = this.configure;
            setMinimumWidth.configure((int) j, bArr2, 0);
            setMinimumWidth.configure((int) (j >>> 32), bArr2, 4);
            while (this.values != 0) {
                Cardinal((byte) 0);
            }
            Cardinal(this.configure);
            Cardinal(this.Cardinal);
            byte[] bArr3 = this.getInstance;
            System.arraycopy(bArr3, 0, bArr, i, bArr3.length);
            cca_continue();
            return 32;
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSASha3_512 */
    public abstract class ecDSASha3_512 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo, setPaddingRelative {
        private static long[] CardinalActionCode = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
        protected long Cardinal;
        private long CardinalEnvironment;
        protected long CardinalError;
        private int CardinalRenderType;
        private long[] CardinalUiType;
        protected long cca_continue;
        private int cleanup;
        protected long configure;
        protected long getInstance;
        protected long getSDKVersion;
        protected long getWarnings;
        protected long init;
        private long valueOf;
        private byte[] values;

        protected ecDSASha3_512() {
            this.values = new byte[8];
            this.CardinalUiType = new long[80];
            this.cleanup = 0;
            cca_continue();
        }

        protected ecDSASha3_512(ecDSASha3_512 ecdsasha3_512) {
            this.values = new byte[8];
            this.CardinalUiType = new long[80];
            configure(ecdsasha3_512);
        }

        private void getWarnings() {
            long j = this.CardinalEnvironment;
            if (j > 2305843009213693951L) {
                this.valueOf += j >>> 61;
                this.CardinalEnvironment = j & 2305843009213693951L;
            }
        }

        public final int Cardinal() {
            return 128;
        }

        public final void Cardinal(byte b) {
            byte[] bArr = this.values;
            int i = this.cleanup;
            int i2 = i + 1;
            this.cleanup = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                getInstance(bArr, 0);
                this.cleanup = 0;
            }
            this.CardinalEnvironment++;
        }

        public void cca_continue() {
            this.CardinalEnvironment = 0;
            this.valueOf = 0;
            int i = 0;
            this.cleanup = 0;
            int i2 = 0;
            while (true) {
                byte[] bArr = this.values;
                if (i2 >= bArr.length) {
                    break;
                }
                bArr[i2] = 0;
                i2++;
            }
            this.CardinalRenderType = 0;
            while (true) {
                long[] jArr = this.CardinalUiType;
                if (i != jArr.length) {
                    jArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void configure(ecDSASha3_512 ecdsasha3_512) {
            byte[] bArr = ecdsasha3_512.values;
            System.arraycopy(bArr, 0, this.values, 0, bArr.length);
            this.cleanup = ecdsasha3_512.cleanup;
            this.CardinalEnvironment = ecdsasha3_512.CardinalEnvironment;
            this.valueOf = ecdsasha3_512.valueOf;
            this.configure = ecdsasha3_512.configure;
            this.getInstance = ecdsasha3_512.getInstance;
            this.cca_continue = ecdsasha3_512.cca_continue;
            this.init = ecdsasha3_512.init;
            this.Cardinal = ecdsasha3_512.Cardinal;
            this.getWarnings = ecdsasha3_512.getWarnings;
            this.CardinalError = ecdsasha3_512.CardinalError;
            this.getSDKVersion = ecdsasha3_512.getSDKVersion;
            long[] jArr = ecdsasha3_512.CardinalUiType;
            System.arraycopy(jArr, 0, this.CardinalUiType, 0, jArr.length);
            this.CardinalRenderType = ecdsasha3_512.CardinalRenderType;
        }

        public final void init(byte[] bArr, int i, int i2) {
            while (this.cleanup != 0 && i2 > 0) {
                Cardinal(bArr[i]);
                i++;
                i2--;
            }
            while (i2 > this.values.length) {
                getInstance(bArr, i);
                byte[] bArr2 = this.values;
                i += bArr2.length;
                i2 -= bArr2.length;
                this.CardinalEnvironment += (long) bArr2.length;
            }
            while (i2 > 0) {
                Cardinal(bArr[i]);
                i++;
                i2--;
            }
        }

        public final void CardinalError() {
            getWarnings();
            long j = this.CardinalEnvironment << 3;
            long j2 = this.valueOf;
            byte b = Byte.MIN_VALUE;
            while (true) {
                Cardinal(b);
                if (this.cleanup == 0) {
                    break;
                }
                b = 0;
            }
            if (this.CardinalRenderType > 14) {
                getSDKVersion();
            }
            long[] jArr = this.CardinalUiType;
            jArr[14] = j2;
            jArr[15] = j;
            getSDKVersion();
        }

        private void getInstance(byte[] bArr, int i) {
            long[] jArr = this.CardinalUiType;
            int i2 = this.CardinalRenderType;
            int cca_continue2 = setMinimumWidth.cca_continue(bArr, i);
            jArr[i2] = (((long) setMinimumWidth.cca_continue(bArr, i + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) cca_continue2) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32);
            int i3 = this.CardinalRenderType + 1;
            this.CardinalRenderType = i3;
            if (i3 == 16) {
                getSDKVersion();
            }
        }

        private void getSDKVersion() {
            ecDSASha3_512 ecdsasha3_512 = this;
            getWarnings();
            for (int i = 16; i <= 79; i++) {
                long[] jArr = ecdsasha3_512.CardinalUiType;
                long j = jArr[i - 2];
                long j2 = ((j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)))) + jArr[i - 7];
                long j3 = jArr[i - 15];
                jArr[i] = j2 + ((j3 >>> 7) ^ (((j3 << 63) | (j3 >>> 1)) ^ ((j3 << 56) | (j3 >>> 8)))) + jArr[i - 16];
            }
            long j4 = ecdsasha3_512.configure;
            long j5 = ecdsasha3_512.getInstance;
            long j6 = ecdsasha3_512.cca_continue;
            long j7 = ecdsasha3_512.init;
            long j8 = ecdsasha3_512.Cardinal;
            long j9 = ecdsasha3_512.getWarnings;
            long j10 = ecdsasha3_512.CardinalError;
            long j11 = j4;
            long j12 = ecdsasha3_512.getSDKVersion;
            long j13 = j6;
            int i2 = 0;
            int i3 = 0;
            while (i2 < 10) {
                long j14 = ((((j8 << 50) | (j8 >>> 14)) ^ ((j8 << 46) | (j8 >>> 18))) ^ ((j8 << 23) | (j8 >>> 41))) + ((j8 & j9) ^ ((~j8) & j10));
                long[] jArr2 = CardinalActionCode;
                long j15 = j14 + jArr2[i3];
                long[] jArr3 = ecdsasha3_512.CardinalUiType;
                int i4 = i3 + 1;
                long j16 = j12 + j15 + jArr3[i3];
                long j17 = j7 + j16;
                long j18 = j11 & j5;
                long j19 = j16 + ((((j11 << 36) | (j11 >>> 28)) ^ ((j11 << 30) | (j11 >>> 34))) ^ ((j11 << 25) | (j11 >>> 39))) + ((j18 ^ (j11 & j13)) ^ (j5 & j13));
                long j20 = j8;
                long j21 = ((((j17 << 50) | (j17 >>> 14)) ^ ((j17 << 46) | (j17 >>> 18))) ^ ((j17 << 23) | (j17 >>> 41))) + ((j17 & j8) ^ ((~j17) & j9)) + jArr2[i4];
                int i5 = i4 + 1;
                long j22 = j10 + j21 + jArr3[i4];
                long j23 = j13 + j22;
                long j24 = j19 & j11;
                long j25 = j22 + ((((j19 << 36) | (j19 >>> 28)) ^ ((j19 << 30) | (j19 >>> 34))) ^ ((j19 << 25) | (j19 >>> 39))) + ((j24 ^ (j19 & j5)) ^ j18);
                long j26 = j17;
                long j27 = ((((j23 << 50) | (j23 >>> 14)) ^ ((j23 << 46) | (j23 >>> 18))) ^ ((j23 << 23) | (j23 >>> 41))) + ((j23 & j17) ^ ((~j23) & j20)) + jArr2[i5];
                int i6 = i5 + 1;
                long j28 = j9 + j27 + jArr3[i5];
                long j29 = j5 + j28;
                long j30 = j25 & j19;
                long j31 = j28 + ((((j25 << 36) | (j25 >>> 28)) ^ ((j25 << 30) | (j25 >>> 34))) ^ ((j25 << 25) | (j25 >>> 39))) + ((j30 ^ (j25 & j11)) ^ j24);
                long j32 = j23;
                long j33 = ((((j29 << 50) | (j29 >>> 14)) ^ ((j29 << 46) | (j29 >>> 18))) ^ ((j29 << 23) | (j29 >>> 41))) + ((j29 & j23) ^ ((~j29) & j26)) + jArr2[i6];
                int i7 = i6 + 1;
                long j34 = j20 + j33 + jArr3[i6];
                long[] jArr4 = jArr3;
                long j35 = j11 + j34;
                long j36 = j31 & j25;
                long j37 = j34 + ((((j31 << 36) | (j31 >>> 28)) ^ ((j31 << 30) | (j31 >>> 34))) ^ ((j31 << 25) | (j31 >>> 39))) + ((j36 ^ (j31 & j19)) ^ j30);
                int i8 = i2;
                long j38 = j29;
                int i9 = i7 + 1;
                long j39 = j26 + ((((j35 << 50) | (j35 >>> 14)) ^ ((j35 << 46) | (j35 >>> 18))) ^ ((j35 << 23) | (j35 >>> 41))) + ((j35 & j29) ^ ((~j35) & j32)) + jArr2[i7] + jArr4[i7];
                long j40 = j19 + j39;
                long j41 = j37 & j31;
                long j42 = j39 + ((((j37 << 36) | (j37 >>> 28)) ^ ((j37 << 30) | (j37 >>> 34))) ^ ((j37 << 25) | (j37 >>> 39))) + ((j41 ^ (j37 & j25)) ^ j36);
                long j43 = j35;
                long j44 = ((((j40 << 50) | (j40 >>> 14)) ^ ((j40 << 46) | (j40 >>> 18))) ^ ((j40 << 23) | (j40 >>> 41))) + ((j40 & j35) ^ ((~j40) & j38)) + jArr2[i9];
                int i10 = i9 + 1;
                long j45 = j32 + j44 + jArr4[i9];
                long j46 = j25 + j45;
                long j47 = j42 & j37;
                j13 = j45 + ((((j42 << 36) | (j42 >>> 28)) ^ ((j42 << 30) | (j42 >>> 34))) ^ ((j42 << 25) | (j42 >>> 39))) + ((j47 ^ (j42 & j31)) ^ j41);
                long j48 = j40;
                int i11 = i10 + 1;
                long j49 = j38 + ((((j46 << 50) | (j46 >>> 14)) ^ ((j46 << 46) | (j46 >>> 18))) ^ ((j46 << 23) | (j46 >>> 41))) + ((j46 & j40) ^ ((~j46) & j43)) + jArr2[i10] + jArr4[i10];
                long j50 = j31 + j49;
                long j51 = j13 & j42;
                long j52 = j49 + ((((j13 << 36) | (j13 >>> 28)) ^ ((j13 << 30) | (j13 >>> 34))) ^ ((j13 << 25) | (j13 >>> 39))) + ((j51 ^ (j13 & j37)) ^ j47);
                long j53 = j43 + ((((j50 << 50) | (j50 >>> 14)) ^ ((j50 << 46) | (j50 >>> 18))) ^ ((j50 << 23) | (j50 >>> 41))) + ((j50 & j46) ^ ((~j50) & j48)) + jArr2[i11] + jArr4[i11];
                j11 = j53 + ((((j52 << 36) | (j52 >>> 28)) ^ ((j52 << 30) | (j52 >>> 34))) ^ ((j52 << 25) | (j52 >>> 39))) + (((j52 & j13) ^ (j52 & j42)) ^ j51);
                i3 = i11 + 1;
                j8 = j37 + j53;
                j10 = j46;
                i2 = i8 + 1;
                j9 = j50;
                ecdsasha3_512 = this;
                j7 = j42;
                j5 = j52;
                j12 = j48;
            }
            ecdsasha3_512.configure += j11;
            ecdsasha3_512.getInstance += j5;
            ecdsasha3_512.cca_continue += j13;
            ecdsasha3_512.init += j7;
            ecdsasha3_512.Cardinal += j8;
            ecdsasha3_512.getWarnings += j9;
            ecdsasha3_512.CardinalError += j10;
            ecdsasha3_512.getSDKVersion += j12;
            ecdsasha3_512.CardinalRenderType = 0;
            for (int i12 = 0; i12 < 16; i12++) {
                ecdsasha3_512.CardinalUiType[i12] = 0;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSAnone */
    public class ecDSAnone implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo {
        private static long[] getInstance = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
        protected boolean Cardinal;
        private int CardinalError;
        private long[] cca_continue;
        protected int configure;
        private int getWarnings;
        private byte[] init;

        public ecDSAnone() {
            this(288);
        }

        public ecDSAnone(int i) {
            this.cca_continue = new long[25];
            this.init = new byte[192];
            Cardinal(i);
        }

        private void Cardinal(int i) {
            if (i == 128 || i == 224 || i == 256 || i == 288 || i == 384 || i == 512) {
                init(1600 - (i << 1));
                return;
            }
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }

        private void cca_continue(byte[] bArr, int i, int i2) {
            int i3;
            int i4 = this.CardinalError;
            if (i4 % 8 != 0) {
                throw new IllegalStateException("attempt to absorb with odd length queue");
            } else if (!this.Cardinal) {
                int i5 = i4 >> 3;
                int i6 = this.getWarnings >> 3;
                int i7 = 0;
                while (i7 < i2) {
                    if (i5 != 0 || i7 > (i3 = i2 - i6)) {
                        int min = Math.min(i6 - i5, i2 - i7);
                        System.arraycopy(bArr, i + i7, this.init, i5, min);
                        i5 += min;
                        i7 += min;
                        if (i5 == i6) {
                            cca_continue(this.init, 0);
                            i5 = 0;
                        }
                    } else {
                        do {
                            cca_continue(bArr, i + i7);
                            i7 += i6;
                        } while (i7 <= i3);
                    }
                }
                this.CardinalError = i5 << 3;
            } else {
                throw new IllegalStateException("attempt to absorb while squeezing");
            }
        }

        private void init(int i) {
            if (i <= 0 || i >= 1600 || i % 64 != 0) {
                throw new IllegalStateException("invalid rate value");
            }
            this.getWarnings = i;
            int i2 = 0;
            while (true) {
                long[] jArr = this.cca_continue;
                if (i2 < jArr.length) {
                    jArr[i2] = 0;
                    i2++;
                } else {
                    setForegroundTintBlendMode.configure(this.init, (byte) 0);
                    this.CardinalError = 0;
                    this.Cardinal = false;
                    this.configure = (1600 - i) / 2;
                    return;
                }
            }
        }

        private void values() {
            long[] jArr = this.cca_continue;
            int i = 0;
            long j = jArr[0];
            boolean z = true;
            long j2 = jArr[1];
            long j3 = jArr[2];
            char c = 3;
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
            long j15 = jArr[14];
            long j16 = jArr[15];
            long j17 = jArr[16];
            long j18 = jArr[17];
            long j19 = jArr[18];
            long j20 = jArr[19];
            long j21 = jArr[20];
            long j22 = jArr[21];
            long j23 = jArr[22];
            long j24 = jArr[23];
            int i2 = 24;
            long j25 = jArr[24];
            while (i < i2) {
                long j26 = (((j ^ j6) ^ j11) ^ j16) ^ j21;
                long j27 = (((j2 ^ j7) ^ j12) ^ j17) ^ j22;
                long j28 = (((j3 ^ j8) ^ j13) ^ j18) ^ j23;
                long j29 = (((j4 ^ j9) ^ j14) ^ j19) ^ j24;
                long j30 = (((j5 ^ j10) ^ j15) ^ j20) ^ j25;
                long j31 = ((j27 << (z ? 1 : 0)) | (j27 >>> -1)) ^ j30;
                long j32 = ((j28 << z) | (j28 >>> -1)) ^ j26;
                long j33 = ((j29 << z) | (j29 >>> -1)) ^ j27;
                long j34 = ((j30 << z) | (j30 >>> -1)) ^ j28;
                long j35 = ((j26 << z) | (j26 >>> -1)) ^ j29;
                long j36 = j ^ j31;
                long j37 = j6 ^ j31;
                long j38 = j11 ^ j31;
                long j39 = j16 ^ j31;
                long j40 = j21 ^ j31;
                long j41 = j2 ^ j32;
                long j42 = j7 ^ j32;
                long j43 = j12 ^ j32;
                long j44 = j17 ^ j32;
                long j45 = j22 ^ j32;
                long j46 = j8 ^ j33;
                long j47 = j13 ^ j33;
                long j48 = j18 ^ j33;
                long j49 = j23 ^ j33;
                long j50 = j9 ^ j34;
                long j51 = j14 ^ j34;
                long j52 = j19 ^ j34;
                long j53 = j24 ^ j34;
                long j54 = j10 ^ j35;
                long j55 = j15 ^ j35;
                long j56 = j20 ^ j35;
                long j57 = j25 ^ j35;
                long j58 = (j41 << z) | (j41 >>> 63);
                long j59 = (j42 << 44) | (j42 >>> 20);
                long j60 = j5 ^ j35;
                long j61 = (j54 << 20) | (j54 >>> 44);
                long j62 = j49 << 61;
                long j63 = j49 >>> c;
                long j64 = j4 ^ j34;
                long j65 = j62 | j63;
                long j66 = j3 ^ j33;
                long j67 = (j55 << 39) | (j55 >>> 25);
                long j68 = (j47 << 43) | (j47 >>> 21);
                long j69 = (j66 << 62) | (j66 >>> 2);
                long j70 = (j51 << 25) | (j51 >>> 39);
                long j71 = (j40 << 18) | (j40 >>> 46);
                long j72 = (j56 << 8) | (j56 >>> 56);
                long j73 = j39 << 41;
                long j74 = j39 >>> 23;
                long j75 = (j53 << 56) | (j53 >>> 8);
                long j76 = j73 | j74;
                long j77 = (j60 << 27) | (j60 >>> 37);
                long j78 = (j57 << 14) | (j57 >>> 50);
                long j79 = j45 << 2;
                long j80 = j45 >>> 62;
                long j81 = j70;
                long j82 = j79 | j80;
                long j83 = (j50 << 55) | (j50 >>> 9);
                long j84 = j44 << 45;
                long j85 = j44 >>> 19;
                long j86 = j83;
                long j87 = j84 | j85;
                long j88 = j65;
                long j89 = (j37 << 36) | (j37 >>> 28);
                long j90 = j64 << 28;
                long j91 = j64 >>> 36;
                long j92 = j89;
                long j93 = j90 | j91;
                long j94 = j52 << 21;
                long j95 = j52 >>> 43;
                long j96 = j87;
                long j97 = j94 | j95;
                long j98 = j48 << 15;
                long j99 = j48 >>> 49;
                long j100 = j93;
                long j101 = j98 | j99;
                long j102 = j43 << 10;
                long j103 = j43 >>> 54;
                long j104 = j101;
                long j105 = j102 | j103;
                long j106 = j46 << 6;
                long j107 = j46 >>> 58;
                long j108 = j105;
                long j109 = j106 | j107;
                long j110 = j38 << 3;
                long j111 = j38 >>> 61;
                long j112 = j110 | j111;
                long j113 = ((~j59) & j68) ^ j36;
                long j114 = ((~j68) & j97) ^ j59;
                j3 = j68 ^ ((~j97) & j78);
                j4 = j97 ^ ((~j78) & j36);
                long j115 = j78 ^ ((~j36) & j59);
                long j116 = j112;
                long j117 = ((~j116) & j96) ^ j61;
                long j118 = j115;
                long j119 = j96;
                long j120 = j100 ^ ((~j61) & j112);
                long j121 = ((~j119) & j88) ^ j116;
                long j122 = j88;
                long j123 = j121;
                long j124 = j119 ^ ((~j122) & j100);
                long j125 = ((~j100) & j61) ^ j122;
                long j126 = j109;
                j11 = j58 ^ ((~j126) & j81);
                long j127 = j124;
                long j128 = j81;
                long j129 = ((~j128) & j72) ^ j126;
                long j130 = j72;
                long j131 = j125;
                long j132 = ((~j130) & j71) ^ j128;
                long j133 = j71;
                long j134 = j132;
                long j135 = j130 ^ ((~j133) & j58);
                long j136 = ((~j58) & j126) ^ j133;
                long j137 = j92;
                long j138 = j77 ^ ((~j137) & j108);
                long j139 = j135;
                long j140 = j108;
                long j141 = j136;
                long j142 = ((~j140) & j104) ^ j137;
                long j143 = j104;
                long j144 = j117;
                long j145 = j75;
                long j146 = j140 ^ ((~j143) & j75);
                long j147 = ((~j145) & j77) ^ j143;
                long j148 = ((~j77) & j137) ^ j145;
                long j149 = j86;
                long j150 = j147;
                long j151 = j67;
                long j152 = j148;
                long j153 = ((~j151) & j76) ^ j149;
                long j154 = j76;
                j21 = j69 ^ ((~j149) & j67);
                long j155 = j82;
                long j156 = j151 ^ ((~j154) & j82);
                long j157 = ((~j155) & j69) ^ j154;
                long j158 = j113 ^ getInstance[i];
                i++;
                j7 = j144;
                j13 = j134;
                j12 = j129;
                j14 = j139;
                j22 = j153;
                c = 3;
                j24 = j157;
                j23 = j156;
                j10 = j131;
                jArr = jArr;
                j20 = j152;
                j15 = j141;
                j8 = j123;
                j9 = j127;
                j18 = j146;
                j16 = j138;
                j5 = j118;
                j6 = j120;
                i2 = 24;
                j19 = j150;
                j17 = j142;
                long j159 = j158;
                z = true;
                j2 = j114;
                j25 = ((~j69) & j149) ^ j155;
                j = j159;
            }
            long[] jArr2 = jArr;
            jArr2[0] = j;
            jArr2[1] = j2;
            jArr2[2] = j3;
            jArr2[3] = j4;
            jArr2[4] = j5;
            jArr2[5] = j6;
            jArr2[6] = j7;
            jArr2[7] = j8;
            jArr2[8] = j9;
            jArr2[9] = j10;
            jArr2[10] = j11;
            jArr2[11] = j12;
            jArr2[12] = j13;
            jArr2[13] = j14;
            jArr2[14] = j15;
            jArr2[15] = j16;
            jArr2[16] = j17;
            jArr2[17] = j18;
            jArr2[18] = j19;
            jArr2[19] = j20;
            jArr2[20] = j21;
            jArr2[21] = j22;
            jArr2[22] = j23;
            jArr2[23] = j24;
            jArr2[24] = j25;
        }

        public final int Cardinal() {
            return this.getWarnings / 8;
        }

        public final void Cardinal(byte b) {
            cca_continue(new byte[]{b}, 0, 1);
        }

        /* access modifiers changed from: protected */
        public final void Cardinal(int i, int i2) {
            if (i2 <= 0 || i2 > 7) {
                throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
            }
            int i3 = this.CardinalError;
            if (i3 % 8 != 0) {
                throw new IllegalStateException("attempt to absorb with odd length queue");
            } else if (!this.Cardinal) {
                this.init[i3 >> 3] = (byte) (i & ((1 << i2) - 1));
                this.CardinalError = i3 + i2;
            } else {
                throw new IllegalStateException("attempt to absorb while squeezing");
            }
        }

        /* access modifiers changed from: protected */
        public final void Cardinal(byte[] bArr, int i, long j) {
            if (!this.Cardinal) {
                init();
            }
            long j2 = 0;
            if (j % 8 == 0) {
                while (j2 < j) {
                    if (this.CardinalError == 0) {
                        values();
                        getSDKVersion();
                        this.CardinalError = this.getWarnings;
                    }
                    int min = (int) Math.min((long) this.CardinalError, j - j2);
                    System.arraycopy(this.init, (this.getWarnings - this.CardinalError) / 8, bArr, ((int) (j2 / 8)) + i, min / 8);
                    this.CardinalError -= min;
                    j2 += (long) min;
                }
                return;
            }
            throw new IllegalStateException("outputLength not a multiple of 8");
        }

        public final void cca_continue() {
            Cardinal(this.configure);
        }

        public String configure() {
            StringBuilder sb = new StringBuilder("Keccak-");
            sb.append(this.configure);
            return sb.toString();
        }

        public final int getInstance() {
            return this.configure / 8;
        }

        public final void init(byte[] bArr, int i, int i2) {
            cca_continue(bArr, i, i2);
        }

        public int configure(byte[] bArr, int i) {
            Cardinal(bArr, i, (long) this.configure);
            Cardinal(this.configure);
            return this.configure / 8;
        }

        private void init() {
            byte[] bArr = this.init;
            int i = this.CardinalError;
            int i2 = i >> 3;
            bArr[i2] = (byte) (bArr[i2] | ((byte) ((int) (1 << (i & 7)))));
            int i3 = i + 1;
            this.CardinalError = i3;
            if (i3 == this.getWarnings) {
                cca_continue(bArr, 0);
                this.CardinalError = 0;
            }
            int i4 = this.CardinalError;
            int i5 = i4 >> 6;
            int i6 = i4 & 63;
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5) {
                long[] jArr = this.cca_continue;
                long j = jArr[i7];
                byte[] bArr2 = this.init;
                int instance = setMinimumWidth.getInstance(bArr2, i8);
                int i9 = i5;
                jArr[i7] = ((((long) instance) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) setMinimumWidth.getInstance(bArr2, i8 + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32)) ^ j;
                i8 += 8;
                i7++;
                i5 = i9;
            }
            int i10 = i5;
            if (i6 > 0) {
                long[] jArr2 = this.cca_continue;
                long j2 = jArr2[i10];
                byte[] bArr3 = this.init;
                jArr2[i10] = j2 ^ (((1 << i6) - 1) & ((((long) setMinimumWidth.getInstance(bArr3, i8)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) setMinimumWidth.getInstance(bArr3, i8 + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32)));
            }
            long[] jArr3 = this.cca_continue;
            int i11 = (this.getWarnings - 1) >> 6;
            jArr3[i11] = jArr3[i11] ^ Long.MIN_VALUE;
            values();
            long[] jArr4 = this.cca_continue;
            int i12 = this.getWarnings >> 6;
            byte[] bArr4 = this.init;
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                long j3 = jArr4[i14];
                setMinimumWidth.configure((int) j3, bArr4, i13);
                setMinimumWidth.configure((int) (j3 >>> 32), bArr4, i13 + 4);
                i13 += 8;
            }
            this.CardinalError = this.getWarnings;
            this.Cardinal = true;
        }

        private void cca_continue(byte[] bArr, int i) {
            int i2 = this.getWarnings >> 6;
            for (int i3 = 0; i3 < i2; i3++) {
                long[] jArr = this.cca_continue;
                jArr[i3] = jArr[i3] ^ (((((long) setMinimumWidth.getInstance(bArr, i + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32) | (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) setMinimumWidth.getInstance(bArr, i))));
                i += 8;
            }
            values();
        }

        private void getSDKVersion() {
            long[] jArr = this.cca_continue;
            int i = this.getWarnings >> 6;
            byte[] bArr = this.init;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                long j = jArr[i3];
                setMinimumWidth.configure((int) j, bArr, i2);
                setMinimumWidth.configure((int) (j >>> 32), bArr, i2 + 4);
                i2 += 8;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSA512 */
    public final class ecDetDSA512 extends ecDetDSA224 {
        private int Cardinal;
        private int CardinalError;
        private int[] cca_continue = new int[16];
        private int configure;
        private int getInstance;
        private int init;

        public ecDetDSA512() {
            cca_continue();
        }

        private ecDetDSA512(ecDetDSA512 ecdetdsa512) {
            super(ecdetdsa512);
            getInstance(ecdetdsa512);
        }

        private static void cca_continue(int i, byte[] bArr, int i2) {
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >>> 8);
            bArr[i2 + 2] = (byte) (i >>> 16);
            bArr[i2 + 3] = (byte) (i >>> 24);
        }

        private void getInstance(ecDetDSA512 ecdetdsa512) {
            super.getInstance(ecdetdsa512);
            this.Cardinal = ecdetdsa512.Cardinal;
            this.configure = ecdetdsa512.configure;
            this.getInstance = ecdetdsa512.getInstance;
            this.init = ecdetdsa512.init;
            int[] iArr = ecdetdsa512.cca_continue;
            System.arraycopy(iArr, 0, this.cca_continue, 0, iArr.length);
            this.CardinalError = ecdetdsa512.CardinalError;
        }

        public final void cca_continue() {
            super.cca_continue();
            this.Cardinal = 1732584193;
            this.configure = -271733879;
            this.getInstance = -1732584194;
            this.init = 271733878;
            this.CardinalError = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.cca_continue;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            getInstance((ecDetDSA512) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int[] iArr = this.cca_continue;
            int i2 = this.CardinalError;
            int i3 = i2 + 1;
            this.CardinalError = i3;
            iArr[i2] = ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            if (i3 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            cca_continue(this.Cardinal, bArr, i);
            cca_continue(this.configure, bArr, i + 4);
            cca_continue(this.getInstance, bArr, i + 8);
            cca_continue(this.init, bArr, i + 12);
            cca_continue();
            return 16;
        }

        public final String configure() {
            return MessageDigestAlgorithms.MD5;
        }

        public final int getInstance() {
            return 16;
        }

        public final setPaddingRelative init() {
            return new ecDetDSA512(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.CardinalError > 14) {
                cleanup();
            }
            int[] iArr = this.cca_continue;
            iArr[14] = (int) j;
            iArr[15] = (int) (j >>> 32);
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            int i = this.Cardinal;
            int i2 = this.configure;
            int i3 = this.getInstance;
            int i4 = this.init;
            int[] iArr = this.cca_continue;
            int i5 = ((((i2 & i3) | ((~i2) & i4)) + i) + iArr[0]) - 680876936;
            int i6 = ((i5 >>> 25) | (i5 << 7)) + i2;
            int i7 = ((((i6 & i2) | ((~i6) & i3)) + i4) + iArr[1]) - 389564586;
            int i8 = ((i7 >>> 20) | (i7 << 12)) + i6;
            int i9 = ((i8 & i6) | ((~i8) & i2)) + i3 + iArr[2] + 606105819;
            int i10 = ((i9 >>> 15) | (i9 << 17)) + i8;
            int i11 = ((((i10 & i8) | ((~i10) & i6)) + i2) + iArr[3]) - 1044525330;
            int i12 = ((i11 >>> 10) | (i11 << 22)) + i10;
            int i13 = ((i6 + (((~i12) & i8) | (i12 & i10))) + iArr[4]) - 176418897;
            int i14 = ((i13 >>> 25) | (i13 << 7)) + i12;
            int i15 = i8 + (((~i14) & i10) | (i14 & i12)) + iArr[5] + 1200080426;
            int i16 = ((i15 >>> 20) | (i15 << 12)) + i14;
            int i17 = ((i10 + (((~i16) & i12) | (i16 & i14))) + iArr[6]) - 1473231341;
            int i18 = ((i17 >>> 15) | (i17 << 17)) + i16;
            int i19 = ((i12 + (((~i18) & i14) | (i18 & i16))) + iArr[7]) - 45705983;
            int i20 = ((i19 >>> 10) | (i19 << 22)) + i18;
            int i21 = i14 + (((~i20) & i16) | (i20 & i18)) + iArr[8] + 1770035416;
            int i22 = ((i21 >>> 25) | (i21 << 7)) + i20;
            int i23 = ((i16 + (((~i22) & i18) | (i22 & i20))) + iArr[9]) - 1958414417;
            int i24 = ((i23 >>> 20) | (i23 << 12)) + i22;
            int i25 = ((i18 + (((~i24) & i20) | (i24 & i22))) + iArr[10]) - 42063;
            int i26 = ((i25 >>> 15) | (i25 << 17)) + i24;
            int i27 = ((i20 + ((i26 & i24) | ((~i26) & i22))) + iArr[11]) - 1990404162;
            int i28 = ((i27 >>> 10) | (i27 << 22)) + i26;
            int i29 = i22 + (((~i28) & i24) | (i28 & i26)) + iArr[12] + 1804603682;
            int i30 = ((i29 >>> 25) | (i29 << 7)) + i28;
            int i31 = ((i24 + (((~i30) & i26) | (i30 & i28))) + iArr[13]) - 40341101;
            int i32 = ((i31 << 12) | (i31 >>> 20)) + i30;
            int i33 = ~i32;
            int i34 = ((i26 + ((i32 & i30) | (i33 & i28))) + iArr[14]) - 1502002290;
            int i35 = ((i34 << 17) | (i34 >>> 15)) + i32;
            int i36 = ~i35;
            int i37 = i28 + ((i35 & i32) | (i36 & i30)) + iArr[15] + 1236535329;
            int i38 = ((i37 << 22) | (i37 >>> 10)) + i35;
            int i39 = ((i30 + ((i38 & i32) | (i33 & i35))) + iArr[1]) - 165796510;
            int i40 = ((i39 >>> 27) | (i39 << 5)) + i38;
            int i41 = ((i32 + ((i36 & i38) | (i40 & i35))) + iArr[6]) - 1069501632;
            int i42 = ((i41 >>> 23) | (i41 << 9)) + i40;
            int i43 = i35 + ((i42 & i38) | ((~i38) & i40)) + iArr[11] + 643717713;
            int i44 = ((i43 << 14) | (i43 >>> 18)) + i42;
            int i45 = ((i38 + ((i44 & i40) | ((~i40) & i42))) + iArr[0]) - 373897302;
            int i46 = ((i45 << 20) | (i45 >>> 12)) + i44;
            int i47 = ((i40 + ((i46 & i42) | ((~i42) & i44))) + iArr[5]) - 701558691;
            int i48 = ((i47 >>> 27) | (i47 << 5)) + i46;
            int i49 = i42 + ((i48 & i44) | ((~i44) & i46)) + iArr[10] + 38016083;
            int i50 = ((i49 >>> 23) | (i49 << 9)) + i48;
            int i51 = ((i44 + ((i50 & i46) | ((~i46) & i48))) + iArr[15]) - 660478335;
            int i52 = ((i51 >>> 18) | (i51 << 14)) + i50;
            int i53 = ((i46 + ((i52 & i48) | ((~i48) & i50))) + iArr[4]) - 405537848;
            int i54 = ((i53 >>> 12) | (i53 << 20)) + i52;
            int i55 = i48 + ((i54 & i50) | ((~i50) & i52)) + iArr[9] + 568446438;
            int i56 = ((i55 >>> 27) | (i55 << 5)) + i54;
            int i57 = ((i50 + ((i56 & i52) | ((~i52) & i54))) + iArr[14]) - 1019803690;
            int i58 = ((i57 >>> 23) | (i57 << 9)) + i56;
            int i59 = ((i52 + ((i58 & i54) | ((~i54) & i56))) + iArr[3]) - 187363961;
            int i60 = ((i59 >>> 18) | (i59 << 14)) + i58;
            int i61 = i54 + ((i60 & i56) | ((~i56) & i58)) + iArr[8] + 1163531501;
            int i62 = ((i61 >>> 12) | (i61 << 20)) + i60;
            int i63 = ((i56 + ((i62 & i58) | ((~i58) & i60))) + iArr[13]) - 1444681467;
            int i64 = ((i63 >>> 27) | (i63 << 5)) + i62;
            int i65 = ((i58 + ((i64 & i60) | ((~i60) & i62))) + iArr[2]) - 51403784;
            int i66 = ((i65 >>> 23) | (i65 << 9)) + i64;
            int i67 = i60 + ((i66 & i62) | ((~i62) & i64)) + iArr[7] + 1735328473;
            int i68 = ((i67 >>> 18) | (i67 << 14)) + i66;
            int i69 = ((i62 + ((i68 & i64) | ((~i64) & i66))) + iArr[12]) - 1926607734;
            int i70 = ((i69 >>> 12) | (i69 << 20)) + i68;
            int i71 = ((i64 + ((i70 ^ i68) ^ i66)) + iArr[5]) - 378558;
            int i72 = ((i71 >>> 28) | (i71 << 4)) + i70;
            int i73 = ((i66 + ((i72 ^ i70) ^ i68)) + iArr[8]) - 2022574463;
            int i74 = ((i73 >>> 21) | (i73 << 11)) + i72;
            int i75 = i68 + ((i74 ^ i72) ^ i70) + iArr[11] + 1839030562;
            int i76 = ((i75 >>> 16) | (i75 << 16)) + i74;
            int i77 = ((i70 + ((i76 ^ i74) ^ i72)) + iArr[14]) - 35309556;
            int i78 = ((i77 >>> 9) | (i77 << 23)) + i76;
            int i79 = ((i72 + ((i78 ^ i76) ^ i74)) + iArr[1]) - 1530992060;
            int i80 = ((i79 >>> 28) | (i79 << 4)) + i78;
            int i81 = i74 + ((i80 ^ i78) ^ i76) + iArr[4] + 1272893353;
            int i82 = ((i81 >>> 21) | (i81 << 11)) + i80;
            int i83 = ((i76 + ((i82 ^ i80) ^ i78)) + iArr[7]) - 155497632;
            int i84 = ((i83 >>> 16) | (i83 << 16)) + i82;
            int i85 = ((i78 + ((i84 ^ i82) ^ i80)) + iArr[10]) - 1094730640;
            int i86 = ((i85 >>> 9) | (i85 << 23)) + i84;
            int i87 = i80 + ((i86 ^ i84) ^ i82) + iArr[13] + 681279174;
            int i88 = ((i87 >>> 28) | (i87 << 4)) + i86;
            int i89 = ((i82 + ((i88 ^ i86) ^ i84)) + iArr[0]) - 358537222;
            int i90 = ((i89 >>> 21) | (i89 << 11)) + i88;
            int i91 = ((i84 + ((i90 ^ i88) ^ i86)) + iArr[3]) - 722521979;
            int i92 = ((i91 >>> 16) | (i91 << 16)) + i90;
            int i93 = i86 + ((i92 ^ i90) ^ i88) + iArr[6] + 76029189;
            int i94 = ((i93 >>> 9) | (i93 << 23)) + i92;
            int i95 = ((i88 + ((i94 ^ i92) ^ i90)) + iArr[9]) - 640364487;
            int i96 = ((i95 >>> 28) | (i95 << 4)) + i94;
            int i97 = ((i90 + ((i96 ^ i94) ^ i92)) + iArr[12]) - 421815835;
            int i98 = ((i97 >>> 21) | (i97 << 11)) + i96;
            int i99 = i92 + ((i98 ^ i96) ^ i94) + iArr[15] + 530742520;
            int i100 = ((i99 >>> 16) | (i99 << 16)) + i98;
            int i101 = ((i94 + ((i100 ^ i98) ^ i96)) + iArr[2]) - 995338651;
            int i102 = ((i101 >>> 9) | (i101 << 23)) + i100;
            int i103 = ((i96 + (((~i98) | i102) ^ i100)) + iArr[0]) - 198630844;
            int i104 = ((i103 >>> 26) | (i103 << 6)) + i102;
            int i105 = i98 + (((~i100) | i104) ^ i102) + iArr[7] + 1126891415;
            int i106 = ((i105 >>> 22) | (i105 << 10)) + i104;
            int i107 = ((i100 + (((~i102) | i106) ^ i104)) + iArr[14]) - 1416354905;
            int i108 = ((i107 >>> 17) | (i107 << 15)) + i106;
            int i109 = ((i102 + (((~i104) | i108) ^ i106)) + iArr[5]) - 57434055;
            int i110 = ((i109 >>> 11) | (i109 << 21)) + i108;
            int i111 = i104 + (((~i106) | i110) ^ i108) + iArr[12] + 1700485571;
            int i112 = ((i111 >>> 26) | (i111 << 6)) + i110;
            int i113 = ((i106 + (((~i108) | i112) ^ i110)) + iArr[3]) - 1894986606;
            int i114 = ((i113 >>> 22) | (i113 << 10)) + i112;
            int i115 = ((i108 + (((~i110) | i114) ^ i112)) + iArr[10]) - 1051523;
            int i116 = ((i115 >>> 17) | (i115 << 15)) + i114;
            int i117 = ((i110 + (((~i112) | i116) ^ i114)) + iArr[1]) - 2054922799;
            int i118 = ((i117 << 21) | (i117 >>> 11)) + i116;
            int i119 = i112 + (((~i114) | i118) ^ i116) + iArr[8] + 1873313359;
            int i120 = ((i119 >>> 26) | (i119 << 6)) + i118;
            int i121 = ((i114 + (((~i116) | i120) ^ i118)) + iArr[15]) - 30611744;
            int i122 = ((i121 >>> 22) | (i121 << 10)) + i120;
            int i123 = ((i116 + (((~i118) | i122) ^ i120)) + iArr[6]) - 1560198380;
            int i124 = ((i123 >>> 17) | (i123 << 15)) + i122;
            int i125 = i118 + (((~i120) | i124) ^ i122) + iArr[13] + 1309151649;
            int i126 = ((i125 >>> 11) | (i125 << 21)) + i124;
            int i127 = ((i120 + (((~i122) | i126) ^ i124)) + iArr[4]) - 145523070;
            int i128 = ((i127 >>> 26) | (i127 << 6)) + i126;
            int i129 = ((i122 + (((~i124) | i128) ^ i126)) + iArr[11]) - 1120210379;
            int i130 = ((i129 >>> 22) | (i129 << 10)) + i128;
            int i131 = i124 + (((~i126) | i130) ^ i128) + iArr[2] + 718787259;
            int i132 = ((i131 >>> 17) | (i131 << 15)) + i130;
            int i133 = ((i126 + (((~i128) | i132) ^ i130)) + iArr[9]) - 343485551;
            this.Cardinal = i + i128;
            this.configure = i2 + ((i133 << 21) | (i133 >>> 11)) + i132;
            this.getInstance = i3 + i132;
            this.init = i4 + i130;
            this.CardinalError = 0;
            int i134 = 0;
            while (true) {
                int[] iArr2 = this.cca_continue;
                if (i134 != iArr2.length) {
                    iArr2[i134] = 0;
                    i134++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSASha3_256 */
    public final class ecDetDSASha3_256 extends ecDetDSA224 {
        private int Cardinal;
        private int cca_continue;
        private int configure;
        private int getInstance;
        private int getSDKVersion;
        private int init;
        private int[] values = new int[16];

        public ecDetDSASha3_256() {
            cca_continue();
        }

        private ecDetDSASha3_256(ecDetDSASha3_256 ecdetdsasha3_256) {
            super(ecdetdsasha3_256);
            init(ecdetdsasha3_256);
        }

        private static int Cardinal(int i, int i2, int i3) {
            return ((~i) & i3) | (i2 & i);
        }

        private static int cca_continue(int i, int i2, int i3) {
            return i ^ (i2 | (~i3));
        }

        private static int configure(int i, int i2, int i3) {
            return (i ^ i2) ^ i3;
        }

        private static void configure(int i, byte[] bArr, int i2) {
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >>> 8);
            bArr[i2 + 2] = (byte) (i >>> 16);
            bArr[i2 + 3] = (byte) (i >>> 24);
        }

        private static int getInstance(int i, int i2, int i3) {
            return (i | (~i2)) ^ i3;
        }

        private static int init(int i, int i2) {
            return (i >>> (32 - i2)) | (i << i2);
        }

        private static int init(int i, int i2, int i3) {
            return (i & i3) | (i2 & (~i3));
        }

        private void init(ecDetDSASha3_256 ecdetdsasha3_256) {
            super.getInstance(ecdetdsasha3_256);
            this.cca_continue = ecdetdsasha3_256.cca_continue;
            this.Cardinal = ecdetdsasha3_256.Cardinal;
            this.getInstance = ecdetdsasha3_256.getInstance;
            this.init = ecdetdsasha3_256.init;
            this.configure = ecdetdsasha3_256.configure;
            int[] iArr = ecdetdsasha3_256.values;
            System.arraycopy(iArr, 0, this.values, 0, iArr.length);
            this.getSDKVersion = ecdetdsasha3_256.getSDKVersion;
        }

        public final void cca_continue() {
            super.cca_continue();
            this.cca_continue = 1732584193;
            this.Cardinal = -271733879;
            this.getInstance = -1732584194;
            this.init = 271733878;
            this.configure = -1009589776;
            this.getSDKVersion = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.values;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            init((ecDetDSASha3_256) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int[] iArr = this.values;
            int i2 = this.getSDKVersion;
            int i3 = i2 + 1;
            this.getSDKVersion = i3;
            iArr[i2] = ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            if (i3 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            configure(this.cca_continue, bArr, i);
            configure(this.Cardinal, bArr, i + 4);
            configure(this.getInstance, bArr, i + 8);
            configure(this.init, bArr, i + 12);
            configure(this.configure, bArr, i + 16);
            cca_continue();
            return 20;
        }

        public final String configure() {
            return "RIPEMD160";
        }

        public final int getInstance() {
            return 20;
        }

        public final setPaddingRelative init() {
            return new ecDetDSASha3_256(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.getSDKVersion > 14) {
                cleanup();
            }
            int[] iArr = this.values;
            iArr[14] = (int) j;
            iArr[15] = (int) (j >>> 32);
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            int i = this.cca_continue;
            int i2 = this.Cardinal;
            int i3 = this.getInstance;
            int i4 = this.init;
            int i5 = this.configure;
            int[] iArr = this.values;
            int i6 = ((i2 ^ i3) ^ i4) + i + iArr[0];
            int i7 = ((i6 >>> 21) | (i6 << 11)) + i5;
            int i8 = (i3 << 10) | (i3 >>> 22);
            int i9 = ((i7 ^ i2) ^ i8) + i5 + iArr[1];
            int i10 = ((i9 >>> 18) | (i9 << 14)) + i4;
            int i11 = (i2 << 10) | (i2 >>> 22);
            int i12 = ((i10 ^ i7) ^ i11) + i4 + iArr[2];
            int i13 = ((i12 >>> 17) | (i12 << 15)) + i8;
            int i14 = (i7 >>> 22) | (i7 << 10);
            int i15 = ((i13 ^ i10) ^ i14) + i8 + iArr[3];
            int i16 = ((i15 >>> 20) | (i15 << 12)) + i11;
            int i17 = (i10 >>> 22) | (i10 << 10);
            int i18 = ((i16 ^ i13) ^ i17) + i11 + iArr[4];
            int i19 = ((i18 << 5) | (i18 >>> 27)) + i14;
            int i20 = (i13 << 10) | (i13 >>> 22);
            int i21 = i14 + ((i19 ^ i16) ^ i20) + iArr[5];
            int i22 = ((i21 << 8) | (i21 >>> 24)) + i17;
            int i23 = (i16 << 10) | (i16 >>> 22);
            int i24 = i17 + ((i22 ^ i19) ^ i23) + iArr[6];
            int i25 = ((i24 << 7) | (i24 >>> 25)) + i20;
            int i26 = (i19 << 10) | (i19 >>> 22);
            int i27 = i20 + ((i25 ^ i22) ^ i26) + iArr[7];
            int i28 = ((i27 << 9) | (i27 >>> 23)) + i23;
            int i29 = (i22 << 10) | (i22 >>> 22);
            int i30 = i23 + ((i28 ^ i25) ^ i29) + iArr[8];
            int i31 = ((i30 << 11) | (i30 >>> 21)) + i26;
            int i32 = (i25 << 10) | (i25 >>> 22);
            int i33 = i26 + ((i31 ^ i28) ^ i32) + iArr[9];
            int i34 = ((i33 << 13) | (i33 >>> 19)) + i29;
            int i35 = (i28 << 10) | (i28 >>> 22);
            int i36 = i29 + ((i34 ^ i31) ^ i35) + iArr[10];
            int i37 = ((i36 << 14) | (i36 >>> 18)) + i32;
            int i38 = (i31 << 10) | (i31 >>> 22);
            int i39 = i32 + ((i37 ^ i34) ^ i38) + iArr[11];
            int i40 = ((i39 << 15) | (i39 >>> 17)) + i35;
            int i41 = (i34 << 10) | (i34 >>> 22);
            int i42 = i35 + ((i40 ^ i37) ^ i41) + iArr[12];
            int i43 = ((i42 << 6) | (i42 >>> 26)) + i38;
            int i44 = (i37 << 10) | (i37 >>> 22);
            int i45 = i38 + ((i43 ^ i40) ^ i44) + iArr[13];
            int i46 = ((i45 << 7) | (i45 >>> 25)) + i41;
            int i47 = (i40 << 10) | (i40 >>> 22);
            int i48 = i41 + ((i46 ^ i43) ^ i47) + iArr[14];
            int i49 = ((i48 << 9) | (i48 >>> 23)) + i44;
            int i50 = (i43 << 10) | (i43 >>> 22);
            int i51 = i44 + ((i49 ^ i46) ^ i50) + iArr[15];
            int i52 = ((i51 << 8) | (i51 >>> 24)) + i47;
            int i53 = (i46 << 10) | (i46 >>> 22);
            int i54 = i + ((i3 | (~i4)) ^ i2) + iArr[5] + 1352829926;
            int i55 = ((i54 >>> 24) | (i54 << 8)) + i5;
            int i56 = i5 + ((i2 | (~i8)) ^ i55) + iArr[14] + 1352829926;
            int i57 = ((i56 << 9) | (i56 >>> 23)) + i4;
            int i58 = i4 + (((~i11) | i55) ^ i57) + iArr[7] + 1352829926;
            int i59 = ((i58 >>> 23) | (i58 << 9)) + i8;
            int i60 = (i55 >>> 22) | (i55 << 10);
            int i61 = i8 + (((~i60) | i57) ^ i59) + iArr[0] + 1352829926;
            int i62 = ((i61 << 11) | (i61 >>> 21)) + i11;
            int i63 = (i57 >>> 22) | (i57 << 10);
            int i64 = i11 + (((~i63) | i59) ^ i62) + iArr[9] + 1352829926;
            int i65 = ((i64 << 13) | (i64 >>> 19)) + i60;
            int i66 = (i59 >>> 22) | (i59 << 10);
            int i67 = i60 + (((~i66) | i62) ^ i65) + iArr[2] + 1352829926;
            int i68 = ((i67 >>> 17) | (i67 << 15)) + i63;
            int i69 = (i62 >>> 22) | (i62 << 10);
            int i70 = i63 + (((~i69) | i65) ^ i68) + iArr[11] + 1352829926;
            int i71 = ((i70 >>> 17) | (i70 << 15)) + i66;
            int i72 = (i65 >>> 22) | (i65 << 10);
            int i73 = i66 + (((~i72) | i68) ^ i71) + iArr[4] + 1352829926;
            int i74 = ((i73 >>> 27) | (i73 << 5)) + i69;
            int i75 = (i68 >>> 22) | (i68 << 10);
            int i76 = i69 + (((~i75) | i71) ^ i74) + iArr[13] + 1352829926;
            int i77 = ((i76 >>> 25) | (i76 << 7)) + i72;
            int i78 = (i71 >>> 22) | (i71 << 10);
            int i79 = i72 + (((~i78) | i74) ^ i77) + iArr[6] + 1352829926;
            int i80 = ((i79 >>> 25) | (i79 << 7)) + i75;
            int i81 = (i74 >>> 22) | (i74 << 10);
            int i82 = i75 + (((~i81) | i77) ^ i80) + iArr[15] + 1352829926;
            int i83 = ((i82 >>> 24) | (i82 << 8)) + i78;
            int i84 = (i77 >>> 22) | (i77 << 10);
            int i85 = i78 + (((~i84) | i80) ^ i83) + iArr[8] + 1352829926;
            int i86 = ((i85 >>> 21) | (i85 << 11)) + i81;
            int i87 = (i80 >>> 22) | (i80 << 10);
            int i88 = i81 + (((~i87) | i83) ^ i86) + iArr[1] + 1352829926;
            int i89 = ((i88 >>> 18) | (i88 << 14)) + i84;
            int i90 = (i83 >>> 22) | (i83 << 10);
            int i91 = i84 + (((~i90) | i86) ^ i89) + iArr[10] + 1352829926;
            int i92 = ((i91 >>> 18) | (i91 << 14)) + i87;
            int init2 = init(i86, 10);
            int init3 = init(i87 + cca_continue(i92, i89, init2) + this.values[3] + 1352829926, 12) + i90;
            int init4 = init(i89, 10);
            int init5 = init(i90 + cca_continue(init3, i92, init4) + this.values[12] + 1352829926, 6) + init2;
            int init6 = init(i92, 10);
            int init7 = init(i47 + Cardinal(i52, i49, i53) + this.values[7] + 1518500249, 7) + i50;
            int init8 = init(i49, 10);
            int init9 = init(i50 + Cardinal(init7, i52, init8) + this.values[4] + 1518500249, 6) + i53;
            int init10 = init(i52, 10);
            int init11 = init(i53 + Cardinal(init9, init7, init10) + this.values[13] + 1518500249, 8) + init8;
            int init12 = init(init7, 10);
            int init13 = init(init8 + Cardinal(init11, init9, init12) + this.values[1] + 1518500249, 13) + init10;
            int init14 = init(init9, 10);
            int init15 = init(init10 + Cardinal(init13, init11, init14) + this.values[10] + 1518500249, 11) + init12;
            int init16 = init(init11, 10);
            int init17 = init(init12 + Cardinal(init15, init13, init16) + this.values[6] + 1518500249, 9) + init14;
            int init18 = init(init13, 10);
            int init19 = init(init14 + Cardinal(init17, init15, init18) + this.values[15] + 1518500249, 7) + init16;
            int init20 = init(init15, 10);
            int init21 = init(init16 + Cardinal(init19, init17, init20) + this.values[3] + 1518500249, 15) + init18;
            int init22 = init(init17, 10);
            int init23 = init(init18 + Cardinal(init21, init19, init22) + this.values[12] + 1518500249, 7) + init20;
            int init24 = init(init19, 10);
            int init25 = init(init20 + Cardinal(init23, init21, init24) + this.values[0] + 1518500249, 12) + init22;
            int init26 = init(init21, 10);
            int init27 = init(init22 + Cardinal(init25, init23, init26) + this.values[9] + 1518500249, 15) + init24;
            int init28 = init(init23, 10);
            int init29 = init(init24 + Cardinal(init27, init25, init28) + this.values[5] + 1518500249, 9) + init26;
            int init30 = init(init25, 10);
            int init31 = init(init26 + Cardinal(init29, init27, init30) + this.values[2] + 1518500249, 11) + init28;
            int init32 = init(init27, 10);
            int init33 = init(init28 + Cardinal(init31, init29, init32) + this.values[14] + 1518500249, 7) + init30;
            int init34 = init(init29, 10);
            int init35 = init(init30 + Cardinal(init33, init31, init34) + this.values[11] + 1518500249, 13) + init32;
            int init36 = init(init31, 10);
            int init37 = init(init32 + Cardinal(init35, init33, init36) + this.values[8] + 1518500249, 12) + init34;
            int init38 = init(init33, 10);
            int init39 = init(init2 + init(init5, init3, init6) + this.values[6] + 1548603684, 9) + init4;
            int init40 = init(init3, 10);
            int init41 = init(init4 + init(init39, init5, init40) + this.values[11] + 1548603684, 13) + init6;
            int init42 = init(init5, 10);
            int init43 = init(init6 + init(init41, init39, init42) + this.values[3] + 1548603684, 15) + init40;
            int init44 = init(init39, 10);
            int init45 = init(init40 + init(init43, init41, init44) + this.values[7] + 1548603684, 7) + init42;
            int init46 = init(init41, 10);
            int init47 = init(init42 + init(init45, init43, init46) + this.values[0] + 1548603684, 12) + init44;
            int init48 = init(init43, 10);
            int init49 = init(init44 + init(init47, init45, init48) + this.values[13] + 1548603684, 8) + init46;
            int init50 = init(init45, 10);
            int init51 = init(init46 + init(init49, init47, init50) + this.values[5] + 1548603684, 9) + init48;
            int init52 = init(init47, 10);
            int init53 = init(init48 + init(init51, init49, init52) + this.values[10] + 1548603684, 11) + init50;
            int init54 = init(init49, 10);
            int init55 = init(init50 + init(init53, init51, init54) + this.values[14] + 1548603684, 7) + init52;
            int init56 = init(init51, 10);
            int init57 = init(init52 + init(init55, init53, init56) + this.values[15] + 1548603684, 7) + init54;
            int init58 = init(init53, 10);
            int init59 = init(init54 + init(init57, init55, init58) + this.values[8] + 1548603684, 12) + init56;
            int init60 = init(init55, 10);
            int init61 = init(init56 + init(init59, init57, init60) + this.values[12] + 1548603684, 7) + init58;
            int init62 = init(init57, 10);
            int init63 = init(init58 + init(init61, init59, init62) + this.values[4] + 1548603684, 6) + init60;
            int init64 = init(init59, 10);
            int init65 = init(init60 + init(init63, init61, init64) + this.values[9] + 1548603684, 15) + init62;
            int init66 = init(init61, 10);
            int init67 = init(init62 + init(init65, init63, init66) + this.values[1] + 1548603684, 13) + init64;
            int init68 = init(init63, 10);
            int init69 = init(init64 + init(init67, init65, init68) + this.values[2] + 1548603684, 11) + init66;
            int init70 = init(init65, 10);
            int init71 = init(init34 + getInstance(init37, init35, init38) + this.values[3] + 1859775393, 11) + init36;
            int init72 = init(init35, 10);
            int init73 = init(init36 + getInstance(init71, init37, init72) + this.values[10] + 1859775393, 13) + init38;
            int init74 = init(init37, 10);
            int init75 = init(init38 + getInstance(init73, init71, init74) + this.values[14] + 1859775393, 6) + init72;
            int init76 = init(init71, 10);
            int init77 = init(init72 + getInstance(init75, init73, init76) + this.values[4] + 1859775393, 7) + init74;
            int init78 = init(init73, 10);
            int init79 = init(init74 + getInstance(init77, init75, init78) + this.values[9] + 1859775393, 14) + init76;
            int init80 = init(init75, 10);
            int init81 = init(init76 + getInstance(init79, init77, init80) + this.values[15] + 1859775393, 9) + init78;
            int init82 = init(init77, 10);
            int init83 = init(init78 + getInstance(init81, init79, init82) + this.values[8] + 1859775393, 13) + init80;
            int init84 = init(init79, 10);
            int init85 = init(init80 + getInstance(init83, init81, init84) + this.values[1] + 1859775393, 15) + init82;
            int init86 = init(init81, 10);
            int init87 = init(init82 + getInstance(init85, init83, init86) + this.values[2] + 1859775393, 14) + init84;
            int init88 = init(init83, 10);
            int init89 = init(init84 + getInstance(init87, init85, init88) + this.values[7] + 1859775393, 8) + init86;
            int init90 = init(init85, 10);
            int init91 = init(init86 + getInstance(init89, init87, init90) + this.values[0] + 1859775393, 13) + init88;
            int init92 = init(init87, 10);
            int init93 = init(init88 + getInstance(init91, init89, init92) + this.values[6] + 1859775393, 6) + init90;
            int init94 = init(init89, 10);
            int init95 = init(init90 + getInstance(init93, init91, init94) + this.values[13] + 1859775393, 5) + init92;
            int init96 = init(init91, 10);
            int init97 = init(init92 + getInstance(init95, init93, init96) + this.values[11] + 1859775393, 12) + init94;
            int init98 = init(init93, 10);
            int init99 = init(init94 + getInstance(init97, init95, init98) + this.values[5] + 1859775393, 7) + init96;
            int init100 = init(init95, 10);
            int init101 = init(init96 + getInstance(init99, init97, init100) + this.values[12] + 1859775393, 5) + init98;
            int init102 = init(init97, 10);
            int init103 = init(init66 + getInstance(init69, init67, init70) + this.values[15] + 1836072691, 9) + init68;
            int init104 = init(init67, 10);
            int init105 = init(init68 + getInstance(init103, init69, init104) + this.values[5] + 1836072691, 7) + init70;
            int init106 = init(init69, 10);
            int init107 = init(init70 + getInstance(init105, init103, init106) + this.values[1] + 1836072691, 15) + init104;
            int init108 = init(init103, 10);
            int init109 = init(init104 + getInstance(init107, init105, init108) + this.values[3] + 1836072691, 11) + init106;
            int init110 = init(init105, 10);
            int init111 = init(init106 + getInstance(init109, init107, init110) + this.values[7] + 1836072691, 8) + init108;
            int init112 = init(init107, 10);
            int init113 = init(init108 + getInstance(init111, init109, init112) + this.values[14] + 1836072691, 6) + init110;
            int init114 = init(init109, 10);
            int init115 = init(init110 + getInstance(init113, init111, init114) + this.values[6] + 1836072691, 6) + init112;
            int init116 = init(init111, 10);
            int init117 = init(init112 + getInstance(init115, init113, init116) + this.values[9] + 1836072691, 14) + init114;
            int init118 = init(init113, 10);
            int init119 = init(init114 + getInstance(init117, init115, init118) + this.values[11] + 1836072691, 12) + init116;
            int init120 = init(init115, 10);
            int init121 = init(init116 + getInstance(init119, init117, init120) + this.values[8] + 1836072691, 13) + init118;
            int init122 = init(init117, 10);
            int init123 = init(init118 + getInstance(init121, init119, init122) + this.values[12] + 1836072691, 5) + init120;
            int init124 = init(init119, 10);
            int init125 = init(init120 + getInstance(init123, init121, init124) + this.values[2] + 1836072691, 14) + init122;
            int init126 = init(init121, 10);
            int init127 = init(init122 + getInstance(init125, init123, init126) + this.values[10] + 1836072691, 13) + init124;
            int init128 = init(init123, 10);
            int init129 = init(init124 + getInstance(init127, init125, init128) + this.values[0] + 1836072691, 13) + init126;
            int init130 = init(init125, 10);
            int init131 = init(init126 + getInstance(init129, init127, init130) + this.values[4] + 1836072691, 7) + init128;
            int init132 = init(init127, 10);
            int init133 = init(init128 + getInstance(init131, init129, init132) + this.values[13] + 1836072691, 5) + init130;
            int init134 = init(init129, 10);
            int init135 = init(((init98 + init(init101, init99, init102)) + this.values[1]) - 1894007588, 11) + init100;
            int init136 = init(init99, 10);
            int init137 = init(((init100 + init(init135, init101, init136)) + this.values[9]) - 1894007588, 12) + init102;
            int init138 = init(init101, 10);
            int init139 = init(((init102 + init(init137, init135, init138)) + this.values[11]) - 1894007588, 14) + init136;
            int init140 = init(init135, 10);
            int init141 = init(((init136 + init(init139, init137, init140)) + this.values[10]) - 1894007588, 15) + init138;
            int init142 = init(init137, 10);
            int init143 = init(((init138 + init(init141, init139, init142)) + this.values[0]) - 1894007588, 14) + init140;
            int init144 = init(init139, 10);
            int init145 = init(((init140 + init(init143, init141, init144)) + this.values[8]) - 1894007588, 15) + init142;
            int init146 = init(init141, 10);
            int init147 = init(((init142 + init(init145, init143, init146)) + this.values[12]) - 1894007588, 9) + init144;
            int init148 = init(init143, 10);
            int init149 = init(((init144 + init(init147, init145, init148)) + this.values[4]) - 1894007588, 8) + init146;
            int init150 = init(init145, 10);
            int init151 = init(((init146 + init(init149, init147, init150)) + this.values[13]) - 1894007588, 9) + init148;
            int init152 = init(init147, 10);
            int init153 = init(((init148 + init(init151, init149, init152)) + this.values[3]) - 1894007588, 14) + init150;
            int init154 = init(init149, 10);
            int init155 = init(((init150 + init(init153, init151, init154)) + this.values[7]) - 1894007588, 5) + init152;
            int init156 = init(init151, 10);
            int init157 = init(((init152 + init(init155, init153, init156)) + this.values[15]) - 1894007588, 6) + init154;
            int init158 = init(init153, 10);
            int init159 = init(((init154 + init(init157, init155, init158)) + this.values[14]) - 1894007588, 8) + init156;
            int init160 = init(init155, 10);
            int init161 = init(((init156 + init(init159, init157, init160)) + this.values[5]) - 1894007588, 6) + init158;
            int init162 = init(init157, 10);
            int init163 = init(((init158 + init(init161, init159, init162)) + this.values[6]) - 1894007588, 5) + init160;
            int init164 = init(init159, 10);
            int init165 = init(((init160 + init(init163, init161, init164)) + this.values[2]) - 1894007588, 12) + init162;
            int init166 = init(init161, 10);
            int init167 = init(init130 + Cardinal(init133, init131, init134) + this.values[8] + 2053994217, 15) + init132;
            int init168 = init(init131, 10);
            int init169 = init(init132 + Cardinal(init167, init133, init168) + this.values[6] + 2053994217, 5) + init134;
            int init170 = init(init133, 10);
            int init171 = init(init134 + Cardinal(init169, init167, init170) + this.values[4] + 2053994217, 8) + init168;
            int init172 = init(init167, 10);
            int init173 = init(init168 + Cardinal(init171, init169, init172) + this.values[1] + 2053994217, 11) + init170;
            int init174 = init(init169, 10);
            int init175 = init(init170 + Cardinal(init173, init171, init174) + this.values[3] + 2053994217, 14) + init172;
            int init176 = init(init171, 10);
            int init177 = init(init172 + Cardinal(init175, init173, init176) + this.values[11] + 2053994217, 14) + init174;
            int init178 = init(init173, 10);
            int init179 = init(init174 + Cardinal(init177, init175, init178) + this.values[15] + 2053994217, 6) + init176;
            int init180 = init(init175, 10);
            int init181 = init(init176 + Cardinal(init179, init177, init180) + this.values[0] + 2053994217, 14) + init178;
            int init182 = init(init177, 10);
            int init183 = init(init178 + Cardinal(init181, init179, init182) + this.values[5] + 2053994217, 6) + init180;
            int init184 = init(init179, 10);
            int init185 = init(init180 + Cardinal(init183, init181, init184) + this.values[12] + 2053994217, 9) + init182;
            int init186 = init(init181, 10);
            int init187 = init(init182 + Cardinal(init185, init183, init186) + this.values[2] + 2053994217, 12) + init184;
            int init188 = init(init183, 10);
            int init189 = init(init184 + Cardinal(init187, init185, init188) + this.values[13] + 2053994217, 9) + init186;
            int init190 = init(init185, 10);
            int init191 = init(init186 + Cardinal(init189, init187, init190) + this.values[9] + 2053994217, 12) + init188;
            int init192 = init(init187, 10);
            int init193 = init(init188 + Cardinal(init191, init189, init192) + this.values[7] + 2053994217, 5) + init190;
            int init194 = init(init189, 10);
            int init195 = init(init190 + Cardinal(init193, init191, init194) + this.values[10] + 2053994217, 15) + init192;
            int init196 = init(init191, 10);
            int init197 = init(init192 + Cardinal(init195, init193, init196) + this.values[14] + 2053994217, 8) + init194;
            int init198 = init(init193, 10);
            int init199 = init(((init162 + cca_continue(init165, init163, init166)) + this.values[4]) - 1454113458, 9) + init164;
            int init200 = init(init163, 10);
            int init201 = init(((init164 + cca_continue(init199, init165, init200)) + this.values[0]) - 1454113458, 15) + init166;
            int init202 = init(init165, 10);
            int init203 = init(((init166 + cca_continue(init201, init199, init202)) + this.values[5]) - 1454113458, 5) + init200;
            int init204 = init(init199, 10);
            int init205 = init(((init200 + cca_continue(init203, init201, init204)) + this.values[9]) - 1454113458, 11) + init202;
            int init206 = init(init201, 10);
            int init207 = init(((init202 + cca_continue(init205, init203, init206)) + this.values[7]) - 1454113458, 6) + init204;
            int init208 = init(init203, 10);
            int init209 = init(((init204 + cca_continue(init207, init205, init208)) + this.values[12]) - 1454113458, 8) + init206;
            int init210 = init(init205, 10);
            int init211 = init(((init206 + cca_continue(init209, init207, init210)) + this.values[2]) - 1454113458, 13) + init208;
            int init212 = init(init207, 10);
            int init213 = init(((init208 + cca_continue(init211, init209, init212)) + this.values[10]) - 1454113458, 12) + init210;
            int init214 = init(init209, 10);
            int init215 = init(((init210 + cca_continue(init213, init211, init214)) + this.values[14]) - 1454113458, 5) + init212;
            int init216 = init(init211, 10);
            int init217 = init(((init212 + cca_continue(init215, init213, init216)) + this.values[1]) - 1454113458, 12) + init214;
            int init218 = init(init213, 10);
            int init219 = init(((init214 + cca_continue(init217, init215, init218)) + this.values[3]) - 1454113458, 13) + init216;
            int init220 = init(init215, 10);
            int init221 = init(((init216 + cca_continue(init219, init217, init220)) + this.values[8]) - 1454113458, 14) + init218;
            int init222 = init(init217, 10);
            int init223 = init(((init218 + cca_continue(init221, init219, init222)) + this.values[11]) - 1454113458, 11) + init220;
            int init224 = init(init219, 10);
            int init225 = init(((init220 + cca_continue(init223, init221, init224)) + this.values[6]) - 1454113458, 8) + init222;
            int init226 = init(init221, 10);
            int init227 = init(((init222 + cca_continue(init225, init223, init226)) + this.values[15]) - 1454113458, 5) + init224;
            int init228 = init(init223, 10);
            int init229 = init(init225, 10);
            int init230 = init(init194 + ((init197 ^ init195) ^ init198) + this.values[12], 8) + init196;
            int init231 = init(init195, 10);
            int init232 = init(init196 + configure(init230, init197, init231) + this.values[15], 5) + init198;
            int init233 = init(init197, 10);
            int init234 = init(init198 + configure(init232, init230, init233) + this.values[10], 12) + init231;
            int init235 = init(init230, 10);
            int init236 = init(init231 + configure(init234, init232, init235) + this.values[4], 9) + init233;
            int init237 = init(init232, 10);
            int init238 = init(init233 + configure(init236, init234, init237) + this.values[1], 12) + init235;
            int init239 = init(init234, 10);
            int init240 = init(init235 + configure(init238, init236, init239) + this.values[5], 5) + init237;
            int init241 = init(init236, 10);
            int init242 = init(init237 + configure(init240, init238, init241) + this.values[8], 14) + init239;
            int init243 = init(init238, 10);
            int init244 = init(init239 + configure(init242, init240, init243) + this.values[7], 6) + init241;
            int init245 = init(init240, 10);
            int init246 = init(init241 + configure(init244, init242, init245) + this.values[6], 8) + init243;
            int init247 = init(init242, 10);
            int init248 = init(init243 + configure(init246, init244, init247) + this.values[2], 13) + init245;
            int init249 = init(init244, 10);
            int init250 = init(init245 + configure(init248, init246, init249) + this.values[13], 6) + init247;
            int init251 = init(init246, 10);
            int init252 = init(init247 + configure(init250, init248, init251) + this.values[14], 5) + init249;
            int init253 = init(init248, 10);
            int init254 = init(init249 + configure(init252, init250, init253) + this.values[0], 15) + init251;
            int init255 = init(init250, 10);
            int init256 = init(init251 + configure(init254, init252, init255) + this.values[3], 13) + init253;
            int init257 = init(init252, 10);
            int init258 = init(init253 + configure(init256, init254, init257) + this.values[9], 11) + init255;
            int init259 = init(init254, 10);
            int init260 = init(init255 + configure(init258, init256, init259) + this.values[11], 11) + init257;
            this.Cardinal = this.getInstance + init229 + init259;
            this.getInstance = this.init + init228 + init257;
            this.init = this.configure + init226 + init260;
            this.configure = this.cca_continue + init(((init224 + cca_continue(init227, init225, init228)) + this.values[13]) - 1454113458, 6) + init226 + init258;
            this.cca_continue = init(init256, 10) + init227 + this.Cardinal;
            this.getSDKVersion = 0;
            int i93 = 0;
            while (true) {
                int[] iArr2 = this.values;
                if (i93 != iArr2.length) {
                    iArr2[i93] = 0;
                    i93++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSASha3_384 */
    public final class ecDetDSASha3_384 extends ecDetDSA224 {
        private int Cardinal;
        private int[] cca_continue = new int[16];
        private int configure;
        private int getInstance;
        private int getWarnings;
        private int init;

        public ecDetDSASha3_384() {
            cca_continue();
        }

        private ecDetDSASha3_384(ecDetDSASha3_384 ecdetdsasha3_384) {
            super(ecdetdsasha3_384);
            init(ecdetdsasha3_384);
        }

        private static void configure(int i, byte[] bArr, int i2) {
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >>> 8);
            bArr[i2 + 2] = (byte) (i >>> 16);
            bArr[i2 + 3] = (byte) (i >>> 24);
        }

        private void init(ecDetDSASha3_384 ecdetdsasha3_384) {
            super.getInstance(ecdetdsasha3_384);
            this.Cardinal = ecdetdsasha3_384.Cardinal;
            this.configure = ecdetdsasha3_384.configure;
            this.getInstance = ecdetdsasha3_384.getInstance;
            this.init = ecdetdsasha3_384.init;
            int[] iArr = ecdetdsasha3_384.cca_continue;
            System.arraycopy(iArr, 0, this.cca_continue, 0, iArr.length);
            this.getWarnings = ecdetdsasha3_384.getWarnings;
        }

        public final void cca_continue() {
            super.cca_continue();
            this.Cardinal = 1732584193;
            this.configure = -271733879;
            this.getInstance = -1732584194;
            this.init = 271733878;
            this.getWarnings = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.cca_continue;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            init((ecDetDSASha3_384) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int[] iArr = this.cca_continue;
            int i2 = this.getWarnings;
            int i3 = i2 + 1;
            this.getWarnings = i3;
            iArr[i2] = ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            if (i3 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            configure(this.Cardinal, bArr, i);
            configure(this.configure, bArr, i + 4);
            configure(this.getInstance, bArr, i + 8);
            configure(this.init, bArr, i + 12);
            cca_continue();
            return 16;
        }

        public final String configure() {
            return "MD4";
        }

        public final int getInstance() {
            return 16;
        }

        public final setPaddingRelative init() {
            return new ecDetDSASha3_384(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.getWarnings > 14) {
                cleanup();
            }
            int[] iArr = this.cca_continue;
            iArr[14] = (int) j;
            iArr[15] = (int) (j >>> 32);
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            int i = this.Cardinal;
            int i2 = this.configure;
            int i3 = this.getInstance;
            int i4 = this.init;
            int[] iArr = this.cca_continue;
            int i5 = ((i2 & i3) | ((~i2) & i4)) + i + iArr[0];
            int i6 = (i5 >>> 29) | (i5 << 3);
            int i7 = ((i6 & i2) | ((~i6) & i3)) + i4 + iArr[1];
            int i8 = (i7 >>> 25) | (i7 << 7);
            int i9 = ((i8 & i6) | ((~i8) & i2)) + i3 + iArr[2];
            int i10 = (i9 >>> 21) | (i9 << 11);
            int i11 = ((i10 & i8) | ((~i10) & i6)) + i2 + iArr[3];
            int i12 = (i11 >>> 13) | (i11 << 19);
            int i13 = i6 + (((~i12) & i8) | (i12 & i10)) + iArr[4];
            int i14 = (i13 >>> 29) | (i13 << 3);
            int i15 = i8 + (((~i14) & i10) | (i14 & i12)) + iArr[5];
            int i16 = (i15 >>> 25) | (i15 << 7);
            int i17 = i10 + (((~i16) & i12) | (i16 & i14)) + iArr[6];
            int i18 = (i17 >>> 21) | (i17 << 11);
            int i19 = i12 + (((~i18) & i14) | (i18 & i16)) + iArr[7];
            int i20 = (i19 >>> 13) | (i19 << 19);
            int i21 = i14 + (((~i20) & i16) | (i20 & i18)) + iArr[8];
            int i22 = (i21 >>> 29) | (i21 << 3);
            int i23 = i16 + (((~i22) & i18) | (i22 & i20)) + iArr[9];
            int i24 = (i23 >>> 25) | (i23 << 7);
            int i25 = i18 + (((~i24) & i20) | (i24 & i22)) + iArr[10];
            int i26 = (i25 << 11) | (i25 >>> 21);
            int i27 = i20 + ((i26 & i24) | ((~i26) & i22)) + iArr[11];
            int i28 = (i27 >>> 13) | (i27 << 19);
            int i29 = i22 + (((~i28) & i24) | (i28 & i26)) + iArr[12];
            int i30 = (i29 >>> 29) | (i29 << 3);
            int i31 = i24 + ((i30 & i28) | ((~i30) & i26)) + iArr[13];
            int i32 = (i31 >>> 25) | (i31 << 7);
            int i33 = i26 + ((i32 & i30) | ((~i32) & i28)) + iArr[14];
            int i34 = (i33 >>> 21) | (i33 << 11);
            int i35 = i34 & i32;
            int i36 = i28 + (((~i34) & i30) | i35) + iArr[15];
            int i37 = (i36 << 19) | (i36 >>> 13);
            int i38 = i37 & i34;
            int i39 = i30 + (i38 | (i37 & i32) | i35) + iArr[0] + 1518500249;
            int i40 = (i39 << 3) | (i39 >>> 29);
            int i41 = i40 & i37;
            int i42 = i32 + (i41 | (i40 & i34) | i38) + iArr[4] + 1518500249;
            int i43 = (i42 << 5) | (i42 >>> 27);
            int i44 = i43 & i40;
            int i45 = i34 + (i44 | (i43 & i37) | i41) + iArr[8] + 1518500249;
            int i46 = (i45 << 9) | (i45 >>> 23);
            int i47 = i46 & i43;
            int i48 = i37 + (i47 | (i46 & i40) | i44) + iArr[12] + 1518500249;
            int i49 = (i48 << 13) | (i48 >>> 19);
            int i50 = i49 & i46;
            int i51 = i40 + (i50 | (i49 & i43) | i47) + iArr[1] + 1518500249;
            int i52 = (i51 << 3) | (i51 >>> 29);
            int i53 = i52 & i49;
            int i54 = i43 + (i53 | (i52 & i46) | i50) + iArr[5] + 1518500249;
            int i55 = (i54 << 5) | (i54 >>> 27);
            int i56 = i55 & i52;
            int i57 = i46 + (i56 | (i55 & i49) | i53) + iArr[9] + 1518500249;
            int i58 = (i57 << 9) | (i57 >>> 23);
            int i59 = i58 & i55;
            int i60 = i49 + (i59 | (i58 & i52) | i56) + iArr[13] + 1518500249;
            int i61 = (i60 << 13) | (i60 >>> 19);
            int i62 = i61 & i58;
            int i63 = i52 + (i62 | (i61 & i55) | i59) + iArr[2] + 1518500249;
            int i64 = (i63 << 3) | (i63 >>> 29);
            int i65 = i64 & i61;
            int i66 = i55 + (i65 | (i64 & i58) | i62) + iArr[6] + 1518500249;
            int i67 = (i66 << 5) | (i66 >>> 27);
            int i68 = i67 & i64;
            int i69 = i58 + (i68 | (i67 & i61) | i65) + iArr[10] + 1518500249;
            int i70 = (i69 << 9) | (i69 >>> 23);
            int i71 = i70 & i67;
            int i72 = i61 + (i71 | (i70 & i64) | i68) + iArr[14] + 1518500249;
            int i73 = (i72 << 13) | (i72 >>> 19);
            int i74 = i73 & i70;
            int i75 = i64 + (i74 | (i73 & i67) | i71) + iArr[3] + 1518500249;
            int i76 = (i75 << 3) | (i75 >>> 29);
            int i77 = i76 & i73;
            int i78 = i67 + (i77 | (i76 & i70) | i74) + iArr[7] + 1518500249;
            int i79 = (i78 << 5) | (i78 >>> 27);
            int i80 = i79 & i76;
            int i81 = i70 + (i80 | (i79 & i73) | i77) + iArr[11] + 1518500249;
            int i82 = (i81 << 9) | (i81 >>> 23);
            int i83 = i73 + ((i82 & i79) | (i82 & i76) | i80) + iArr[15] + 1518500249;
            int i84 = (i83 << 13) | (i83 >>> 19);
            int i85 = i76 + ((i84 ^ i82) ^ i79) + iArr[0] + 1859775393;
            int i86 = (i85 << 3) | (i85 >>> 29);
            int i87 = i79 + ((i86 ^ i84) ^ i82) + iArr[8] + 1859775393;
            int i88 = (i87 >>> 23) | (i87 << 9);
            int i89 = i82 + ((i88 ^ i86) ^ i84) + iArr[4] + 1859775393;
            int i90 = (i89 >>> 21) | (i89 << 11);
            int i91 = i84 + ((i90 ^ i88) ^ i86) + iArr[12] + 1859775393;
            int i92 = (i91 >>> 17) | (i91 << 15);
            int i93 = i86 + ((i92 ^ i90) ^ i88) + iArr[2] + 1859775393;
            int i94 = (i93 >>> 29) | (i93 << 3);
            int i95 = i88 + ((i94 ^ i92) ^ i90) + iArr[10] + 1859775393;
            int i96 = (i95 >>> 23) | (i95 << 9);
            int i97 = i90 + ((i96 ^ i94) ^ i92) + iArr[6] + 1859775393;
            int i98 = (i97 >>> 21) | (i97 << 11);
            int i99 = i92 + ((i98 ^ i96) ^ i94) + iArr[14] + 1859775393;
            int i100 = (i99 >>> 17) | (i99 << 15);
            int i101 = i94 + ((i100 ^ i98) ^ i96) + iArr[1] + 1859775393;
            int i102 = (i101 >>> 29) | (i101 << 3);
            int i103 = i96 + ((i102 ^ i100) ^ i98) + iArr[9] + 1859775393;
            int i104 = (i103 >>> 23) | (i103 << 9);
            int i105 = i98 + ((i104 ^ i102) ^ i100) + iArr[5] + 1859775393;
            int i106 = (i105 >>> 21) | (i105 << 11);
            int i107 = i100 + ((i106 ^ i104) ^ i102) + iArr[13] + 1859775393;
            int i108 = (i107 >>> 17) | (i107 << 15);
            int i109 = i102 + ((i108 ^ i106) ^ i104) + iArr[3] + 1859775393;
            int i110 = (i109 >>> 29) | (i109 << 3);
            int i111 = i104 + ((i110 ^ i108) ^ i106) + iArr[11] + 1859775393;
            int i112 = (i111 >>> 23) | (i111 << 9);
            int i113 = i106 + ((i112 ^ i110) ^ i108) + iArr[7] + 1859775393;
            int i114 = (i113 >>> 21) | (i113 << 11);
            int i115 = i108 + ((i114 ^ i112) ^ i110) + iArr[15] + 1859775393;
            this.Cardinal = i + i110;
            this.configure = i2 + ((i115 << 15) | (i115 >>> 17));
            this.getInstance = i3 + i114;
            this.init = i4 + i112;
            this.getWarnings = 0;
            int i116 = 0;
            while (true) {
                int[] iArr2 = this.cca_continue;
                if (i116 != iArr2.length) {
                    iArr2[i116] = 0;
                    i116++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecNR */
    public final class ecNR extends ecDetDSA224 {
        private static int[] CardinalRenderType = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
        private int Cardinal;
        private int CardinalError;
        private int cca_continue;
        private int cleanup;
        private int configure;
        private int getInstance;
        private int getSDKVersion;
        private int getWarnings;
        private int init;
        private int[] values = new int[64];

        public ecNR() {
            cca_continue();
        }

        private ecNR(ecNR ecnr) {
            super(ecnr);
            configure(ecnr);
        }

        private void configure(ecNR ecnr) {
            super.getInstance(ecnr);
            this.init = ecnr.init;
            this.getInstance = ecnr.getInstance;
            this.configure = ecnr.configure;
            this.Cardinal = ecnr.Cardinal;
            this.cca_continue = ecnr.cca_continue;
            this.getWarnings = ecnr.getWarnings;
            this.getSDKVersion = ecnr.getSDKVersion;
            this.cleanup = ecnr.cleanup;
            int[] iArr = ecnr.values;
            System.arraycopy(iArr, 0, this.values, 0, iArr.length);
            this.CardinalError = ecnr.CardinalError;
        }

        public final void cca_continue() {
            super.cca_continue();
            this.init = 1779033703;
            this.getInstance = -1150833019;
            this.configure = 1013904242;
            this.Cardinal = -1521486534;
            this.cca_continue = 1359893119;
            this.getWarnings = -1694144372;
            this.getSDKVersion = 528734635;
            this.cleanup = 1541459225;
            this.CardinalError = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.values;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            configure((ecNR) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            int[] iArr = this.values;
            int i5 = this.CardinalError;
            iArr[i5] = i4;
            int i6 = i5 + 1;
            this.CardinalError = i6;
            if (i6 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            setMinimumWidth.getInstance(this.init, bArr, i);
            setMinimumWidth.getInstance(this.getInstance, bArr, i + 4);
            setMinimumWidth.getInstance(this.configure, bArr, i + 8);
            setMinimumWidth.getInstance(this.Cardinal, bArr, i + 12);
            setMinimumWidth.getInstance(this.cca_continue, bArr, i + 16);
            setMinimumWidth.getInstance(this.getWarnings, bArr, i + 20);
            setMinimumWidth.getInstance(this.getSDKVersion, bArr, i + 24);
            setMinimumWidth.getInstance(this.cleanup, bArr, i + 28);
            cca_continue();
            return 32;
        }

        public final String configure() {
            return "SHA-256";
        }

        public final int getInstance() {
            return 32;
        }

        public final setPaddingRelative init() {
            return new ecNR(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.CardinalError > 14) {
                cleanup();
            }
            int[] iArr = this.values;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) j;
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            ecNR ecnr = this;
            for (int i = 16; i <= 63; i++) {
                int[] iArr = ecnr.values;
                int i2 = iArr[i - 2];
                int i3 = ((i2 >>> 10) ^ (((i2 >>> 17) | (i2 << 15)) ^ ((i2 >>> 19) | (i2 << 13)))) + iArr[i - 7];
                int i4 = iArr[i - 15];
                iArr[i] = i3 + ((i4 >>> 3) ^ (((i4 >>> 7) | (i4 << 25)) ^ ((i4 >>> 18) | (i4 << 14)))) + iArr[i - 16];
            }
            int i5 = ecnr.init;
            int i6 = ecnr.getInstance;
            int i7 = ecnr.configure;
            int i8 = ecnr.Cardinal;
            int i9 = ecnr.cca_continue;
            int i10 = ecnr.getWarnings;
            int i11 = ecnr.getSDKVersion;
            int i12 = ecnr.cleanup;
            int i13 = 0;
            int i14 = 0;
            while (i13 < 8) {
                int i15 = ((((i9 >>> 6) | (i9 << 26)) ^ ((i9 >>> 11) | (i9 << 21))) ^ ((i9 >>> 25) | (i9 << 7))) + ((i9 & i10) ^ ((~i9) & i11));
                int[] iArr2 = CardinalRenderType;
                int i16 = i15 + iArr2[i14];
                int[] iArr3 = ecnr.values;
                int i17 = i12 + i16 + iArr3[i14];
                int i18 = i8 + i17;
                int i19 = i5 & i6;
                int i20 = i17 + ((((i5 >>> 2) | (i5 << 30)) ^ ((i5 >>> 13) | (i5 << 19))) ^ ((i5 >>> 22) | (i5 << 10))) + ((i19 ^ (i5 & i7)) ^ (i6 & i7));
                int i21 = i14 + 1;
                int i22 = i11 + ((((i18 >>> 6) | (i18 << 26)) ^ ((i18 >>> 11) | (i18 << 21))) ^ ((i18 >>> 25) | (i18 << 7))) + ((i18 & i9) ^ ((~i18) & i10)) + iArr2[i21] + iArr3[i21];
                int i23 = i7 + i22;
                int i24 = i20 & i5;
                int i25 = i22 + ((((i20 >>> 2) | (i20 << 30)) ^ ((i20 >>> 13) | (i20 << 19))) ^ ((i20 >>> 22) | (i20 << 10))) + ((i24 ^ (i20 & i6)) ^ i19);
                int i26 = i21 + 1;
                int i27 = i10 + ((((i23 >>> 6) | (i23 << 26)) ^ ((i23 >>> 11) | (i23 << 21))) ^ ((i23 >>> 25) | (i23 << 7))) + ((i23 & i18) ^ ((~i23) & i9)) + iArr2[i26] + iArr3[i26];
                int i28 = i6 + i27;
                int i29 = i25 & i20;
                int i30 = i27 + ((((i25 >>> 2) | (i25 << 30)) ^ ((i25 >>> 13) | (i25 << 19))) ^ ((i25 >>> 22) | (i25 << 10))) + ((i29 ^ (i25 & i5)) ^ i24);
                int i31 = i26 + 1;
                int i32 = i9 + ((((i28 >>> 6) | (i28 << 26)) ^ ((i28 >>> 11) | (i28 << 21))) ^ ((i28 >>> 25) | (i28 << 7))) + (((~i28) & i18) ^ (i28 & i23)) + iArr2[i31] + iArr3[i31];
                int i33 = i5 + i32;
                int i34 = i30 & i25;
                int i35 = i32 + ((((i30 >>> 2) | (i30 << 30)) ^ ((i30 >>> 13) | (i30 << 19))) ^ ((i30 >>> 22) | (i30 << 10))) + (i29 ^ ((i30 & i20) ^ i34));
                int i36 = i31 + 1;
                int i37 = i18 + ((((i33 >>> 6) | (i33 << 26)) ^ ((i33 >>> 11) | (i33 << 21))) ^ ((i33 >>> 25) | (i33 << 7))) + ((i33 & i28) ^ ((~i33) & i23)) + iArr2[i36] + iArr3[i36];
                i12 = i20 + i37;
                int i38 = i35 & i30;
                i8 = i37 + ((((i35 >>> 2) | (i35 << 30)) ^ ((i35 >>> 13) | (i35 << 19))) ^ ((i35 >>> 22) | (i35 << 10))) + (i34 ^ ((i35 & i25) ^ i38));
                int i39 = i36 + 1;
                int i40 = i23 + ((((i12 >>> 6) | (i12 << 26)) ^ ((i12 >>> 11) | (i12 << 21))) ^ ((i12 >>> 25) | (i12 << 7))) + ((i12 & i33) ^ ((~i12) & i28)) + iArr2[i39] + iArr3[i39];
                i11 = i25 + i40;
                int i41 = i8 & i35;
                i7 = i40 + ((((i8 >>> 2) | (i8 << 30)) ^ ((i8 >>> 13) | (i8 << 19))) ^ ((i8 >>> 22) | (i8 << 10))) + (i38 ^ ((i8 & i30) ^ i41));
                int i42 = i39 + 1;
                int i43 = i28 + ((((i11 >>> 6) | (i11 << 26)) ^ ((i11 >>> 11) | (i11 << 21))) ^ ((i11 >>> 25) | (i11 << 7))) + ((i11 & i12) ^ ((~i11) & i33)) + iArr2[i42] + iArr3[i42];
                i10 = i30 + i43;
                int i44 = i7 & i8;
                i6 = i43 + ((((i7 >>> 2) | (i7 << 30)) ^ ((i7 >>> 13) | (i7 << 19))) ^ ((i7 >>> 22) | (i7 << 10))) + (i41 ^ ((i7 & i35) ^ i44));
                int i45 = i42 + 1;
                int i46 = i33 + ((((i10 >>> 6) | (i10 << 26)) ^ ((i10 >>> 11) | (i10 << 21))) ^ ((i10 >>> 25) | (i10 << 7))) + ((i10 & i11) ^ ((~i10) & i12)) + iArr2[i45] + iArr3[i45];
                i9 = i35 + i46;
                i5 = i46 + ((((i6 >>> 2) | (i6 << 30)) ^ ((i6 >>> 13) | (i6 << 19))) ^ ((i6 >>> 22) | (i6 << 10))) + (((i6 & i7) ^ (i6 & i8)) ^ i44);
                i14 = i45 + 1;
                i13++;
                ecnr = this;
            }
            ecnr.init += i5;
            ecnr.getInstance += i6;
            ecnr.configure += i7;
            ecnr.Cardinal += i8;
            ecnr.cca_continue += i9;
            ecnr.getWarnings += i10;
            ecnr.getSDKVersion += i11;
            ecnr.cleanup += i12;
            ecnr.CardinalError = 0;
            for (int i47 = 0; i47 < 16; i47++) {
                ecnr.values[i47] = 0;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecNR224 */
    public final class ecNR224 extends ecDetDSA224 {
        private int Cardinal;
        private int CardinalError;
        private int cca_continue;
        private int configure;
        private int getInstance;
        private int[] getSDKVersion = new int[80];
        private int init;

        public ecNR224() {
            cca_continue();
        }

        private ecNR224(ecNR224 ecnr224) {
            super(ecnr224);
            configure(ecnr224);
        }

        private void configure(ecNR224 ecnr224) {
            this.init = ecnr224.init;
            this.getInstance = ecnr224.getInstance;
            this.configure = ecnr224.configure;
            this.cca_continue = ecnr224.cca_continue;
            this.Cardinal = ecnr224.Cardinal;
            int[] iArr = ecnr224.getSDKVersion;
            System.arraycopy(iArr, 0, this.getSDKVersion, 0, iArr.length);
            this.CardinalError = ecnr224.CardinalError;
        }

        public final void cca_continue() {
            super.cca_continue();
            this.init = 1732584193;
            this.getInstance = -271733879;
            this.configure = -1732584194;
            this.cca_continue = 271733878;
            this.Cardinal = -1009589776;
            this.CardinalError = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.getSDKVersion;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            ecNR224 ecnr224 = (ecNR224) setpaddingrelative;
            super.getInstance(ecnr224);
            configure(ecnr224);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            int[] iArr = this.getSDKVersion;
            int i5 = this.CardinalError;
            iArr[i5] = i4;
            int i6 = i5 + 1;
            this.CardinalError = i6;
            if (i6 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            setMinimumWidth.getInstance(this.init, bArr, i);
            setMinimumWidth.getInstance(this.getInstance, bArr, i + 4);
            setMinimumWidth.getInstance(this.configure, bArr, i + 8);
            setMinimumWidth.getInstance(this.cca_continue, bArr, i + 12);
            setMinimumWidth.getInstance(this.Cardinal, bArr, i + 16);
            cca_continue();
            return 20;
        }

        public final String configure() {
            return "SHA-1";
        }

        public final int getInstance() {
            return 20;
        }

        public final setPaddingRelative init() {
            return new ecNR224(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.CardinalError > 14) {
                cleanup();
            }
            int[] iArr = this.getSDKVersion;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) j;
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            for (int i = 16; i < 80; i++) {
                int[] iArr = this.getSDKVersion;
                int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                iArr[i] = (i2 >>> 31) | (i2 << 1);
            }
            int i3 = this.init;
            int i4 = this.getInstance;
            int i5 = this.configure;
            int i6 = this.cca_continue;
            int i7 = this.Cardinal;
            int i8 = 0;
            int i9 = 0;
            while (i8 < 4) {
                int i10 = ((i3 << 5) | (i3 >>> 27)) + ((i4 & i5) | ((~i4) & i6));
                int[] iArr2 = this.getSDKVersion;
                int i11 = i9 + 1;
                int i12 = i7 + i10 + iArr2[i9] + 1518500249;
                int i13 = (i4 >>> 2) | (i4 << 30);
                int i14 = i11 + 1;
                int i15 = i6 + ((i12 << 5) | (i12 >>> 27)) + ((i3 & i13) | ((~i3) & i5)) + iArr2[i11] + 1518500249;
                int i16 = (i3 >>> 2) | (i3 << 30);
                int i17 = i14 + 1;
                int i18 = i5 + ((i15 << 5) | (i15 >>> 27)) + ((i12 & i16) | ((~i12) & i13)) + iArr2[i14] + 1518500249;
                i7 = (i12 >>> 2) | (i12 << 30);
                int i19 = i17 + 1;
                i4 = i13 + ((i18 << 5) | (i18 >>> 27)) + ((i15 & i7) | ((~i15) & i16)) + iArr2[i17] + 1518500249;
                i6 = (i15 >>> 2) | (i15 << 30);
                i3 = i16 + ((i4 << 5) | (i4 >>> 27)) + ((i18 & i6) | ((~i18) & i7)) + iArr2[i19] + 1518500249;
                i5 = (i18 >>> 2) | (i18 << 30);
                i8++;
                i9 = i19 + 1;
            }
            int i20 = 0;
            while (i20 < 4) {
                int[] iArr3 = this.getSDKVersion;
                int i21 = i9 + 1;
                int i22 = i7 + ((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6) + iArr3[i9] + 1859775393;
                int i23 = (i4 >>> 2) | (i4 << 30);
                int i24 = i21 + 1;
                int i25 = i6 + ((i22 << 5) | (i22 >>> 27)) + ((i3 ^ i23) ^ i5) + iArr3[i21] + 1859775393;
                int i26 = (i3 >>> 2) | (i3 << 30);
                int i27 = i24 + 1;
                int i28 = i5 + ((i25 << 5) | (i25 >>> 27)) + ((i22 ^ i26) ^ i23) + iArr3[i24] + 1859775393;
                i7 = (i22 >>> 2) | (i22 << 30);
                int i29 = i27 + 1;
                i4 = i23 + ((i28 << 5) | (i28 >>> 27)) + ((i25 ^ i7) ^ i26) + iArr3[i27] + 1859775393;
                i6 = (i25 >>> 2) | (i25 << 30);
                i3 = i26 + ((i4 << 5) | (i4 >>> 27)) + ((i28 ^ i6) ^ i7) + iArr3[i29] + 1859775393;
                i5 = (i28 >>> 2) | (i28 << 30);
                i20++;
                i9 = i29 + 1;
            }
            int i30 = 0;
            while (i30 < 4) {
                int[] iArr4 = this.getSDKVersion;
                int i31 = i9 + 1;
                int i32 = i7 + (((((i3 << 5) | (i3 >>> 27)) + (((i4 & i5) | (i4 & i6)) | (i5 & i6))) + iArr4[i9]) - 1894007588);
                int i33 = (i4 >>> 2) | (i4 << 30);
                int i34 = i31 + 1;
                int i35 = i6 + (((((i32 << 5) | (i32 >>> 27)) + (((i3 & i33) | (i3 & i5)) | (i33 & i5))) + iArr4[i31]) - 1894007588);
                int i36 = (i3 >>> 2) | (i3 << 30);
                int i37 = i34 + 1;
                int i38 = i5 + (((((i35 << 5) | (i35 >>> 27)) + (((i32 & i36) | (i32 & i33)) | (i36 & i33))) + iArr4[i34]) - 1894007588);
                i7 = (i32 >>> 2) | (i32 << 30);
                int i39 = i37 + 1;
                i4 = i33 + (((((i38 << 5) | (i38 >>> 27)) + (((i35 & i7) | (i35 & i36)) | (i7 & i36))) + iArr4[i37]) - 1894007588);
                i6 = (i35 >>> 2) | (i35 << 30);
                i3 = i36 + (((((i4 << 5) | (i4 >>> 27)) + (((i38 & i6) | (i38 & i7)) | (i6 & i7))) + iArr4[i39]) - 1894007588);
                i5 = (i38 >>> 2) | (i38 << 30);
                i30++;
                i9 = i39 + 1;
            }
            int i40 = 0;
            while (i40 <= 3) {
                int[] iArr5 = this.getSDKVersion;
                int i41 = i9 + 1;
                int i42 = i7 + (((((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6)) + iArr5[i9]) - 899497514);
                int i43 = (i4 >>> 2) | (i4 << 30);
                int i44 = i41 + 1;
                int i45 = i6 + (((((i42 << 5) | (i42 >>> 27)) + ((i3 ^ i43) ^ i5)) + iArr5[i41]) - 899497514);
                int i46 = (i3 >>> 2) | (i3 << 30);
                int i47 = i44 + 1;
                int i48 = i5 + (((((i45 << 5) | (i45 >>> 27)) + ((i42 ^ i46) ^ i43)) + iArr5[i44]) - 899497514);
                i7 = (i42 >>> 2) | (i42 << 30);
                int i49 = i47 + 1;
                i4 = i43 + (((((i48 << 5) | (i48 >>> 27)) + ((i45 ^ i7) ^ i46)) + iArr5[i47]) - 899497514);
                i6 = (i45 >>> 2) | (i45 << 30);
                i3 = i46 + (((((i4 << 5) | (i4 >>> 27)) + ((i48 ^ i6) ^ i7)) + iArr5[i49]) - 899497514);
                i5 = (i48 >>> 2) | (i48 << 30);
                i40++;
                i9 = i49 + 1;
            }
            this.init += i3;
            this.getInstance += i4;
            this.configure += i5;
            this.cca_continue += i6;
            this.Cardinal += i7;
            this.CardinalError = 0;
            for (int i50 = 0; i50 < 16; i50++) {
                this.getSDKVersion[i50] = 0;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecNR256 */
    public final class ecNR256 extends ecDetDSA224 {
        private static int[] CardinalActionCode = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
        private int Cardinal;
        private int CardinalError;
        private int cca_continue;
        private int cleanup;
        private int configure;
        private int getInstance;
        private int getSDKVersion;
        private int getWarnings;
        private int init;
        private int[] values = new int[64];

        public ecNR256() {
            cca_continue();
        }

        private ecNR256(ecNR256 ecnr256) {
            super(ecnr256);
            getInstance(ecnr256);
        }

        private void getInstance(ecNR256 ecnr256) {
            super.getInstance(ecnr256);
            this.getInstance = ecnr256.getInstance;
            this.configure = ecnr256.configure;
            this.init = ecnr256.init;
            this.Cardinal = ecnr256.Cardinal;
            this.cca_continue = ecnr256.cca_continue;
            this.getWarnings = ecnr256.getWarnings;
            this.getSDKVersion = ecnr256.getSDKVersion;
            this.CardinalError = ecnr256.CardinalError;
            int[] iArr = ecnr256.values;
            System.arraycopy(iArr, 0, this.values, 0, iArr.length);
            this.cleanup = ecnr256.cleanup;
        }

        public final void cca_continue() {
            super.cca_continue();
            this.getInstance = -1056596264;
            this.configure = 914150663;
            this.init = 812702999;
            this.Cardinal = -150054599;
            this.cca_continue = -4191439;
            this.getWarnings = 1750603025;
            this.getSDKVersion = 1694076839;
            this.CardinalError = -1090891868;
            this.cleanup = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.values;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            getInstance((ecNR256) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            int[] iArr = this.values;
            int i5 = this.cleanup;
            iArr[i5] = i4;
            int i6 = i5 + 1;
            this.cleanup = i6;
            if (i6 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            setMinimumWidth.getInstance(this.getInstance, bArr, i);
            setMinimumWidth.getInstance(this.configure, bArr, i + 4);
            setMinimumWidth.getInstance(this.init, bArr, i + 8);
            setMinimumWidth.getInstance(this.Cardinal, bArr, i + 12);
            setMinimumWidth.getInstance(this.cca_continue, bArr, i + 16);
            setMinimumWidth.getInstance(this.getWarnings, bArr, i + 20);
            setMinimumWidth.getInstance(this.getSDKVersion, bArr, i + 24);
            cca_continue();
            return 28;
        }

        public final String configure() {
            return McElieceCCA2KeyGenParameterSpec.SHA224;
        }

        public final int getInstance() {
            return 28;
        }

        public final setPaddingRelative init() {
            return new ecNR256(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.cleanup > 14) {
                cleanup();
            }
            int[] iArr = this.values;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) j;
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            ecNR256 ecnr256 = this;
            for (int i = 16; i <= 63; i++) {
                int[] iArr = ecnr256.values;
                int i2 = iArr[i - 2];
                int i3 = ((i2 >>> 10) ^ (((i2 >>> 17) | (i2 << 15)) ^ ((i2 >>> 19) | (i2 << 13)))) + iArr[i - 7];
                int i4 = iArr[i - 15];
                iArr[i] = i3 + ((i4 >>> 3) ^ (((i4 >>> 7) | (i4 << 25)) ^ ((i4 >>> 18) | (i4 << 14)))) + iArr[i - 16];
            }
            int i5 = ecnr256.getInstance;
            int i6 = ecnr256.configure;
            int i7 = ecnr256.init;
            int i8 = ecnr256.Cardinal;
            int i9 = ecnr256.cca_continue;
            int i10 = ecnr256.getWarnings;
            int i11 = ecnr256.getSDKVersion;
            int i12 = ecnr256.CardinalError;
            int i13 = 0;
            int i14 = 0;
            while (i13 < 8) {
                int i15 = ((((i9 >>> 6) | (i9 << 26)) ^ ((i9 >>> 11) | (i9 << 21))) ^ ((i9 >>> 25) | (i9 << 7))) + ((i9 & i10) ^ ((~i9) & i11));
                int[] iArr2 = CardinalActionCode;
                int i16 = i15 + iArr2[i14];
                int[] iArr3 = ecnr256.values;
                int i17 = i12 + i16 + iArr3[i14];
                int i18 = i8 + i17;
                int i19 = i5 & i6;
                int i20 = i17 + ((((i5 >>> 2) | (i5 << 30)) ^ ((i5 >>> 13) | (i5 << 19))) ^ ((i5 >>> 22) | (i5 << 10))) + ((i19 ^ (i5 & i7)) ^ (i6 & i7));
                int i21 = i14 + 1;
                int i22 = i11 + ((((i18 >>> 6) | (i18 << 26)) ^ ((i18 >>> 11) | (i18 << 21))) ^ ((i18 >>> 25) | (i18 << 7))) + ((i18 & i9) ^ ((~i18) & i10)) + iArr2[i21] + iArr3[i21];
                int i23 = i7 + i22;
                int i24 = i20 & i5;
                int i25 = i22 + ((((i20 >>> 2) | (i20 << 30)) ^ ((i20 >>> 13) | (i20 << 19))) ^ ((i20 >>> 22) | (i20 << 10))) + ((i24 ^ (i20 & i6)) ^ i19);
                int i26 = i21 + 1;
                int i27 = i10 + ((((i23 >>> 6) | (i23 << 26)) ^ ((i23 >>> 11) | (i23 << 21))) ^ ((i23 >>> 25) | (i23 << 7))) + ((i23 & i18) ^ ((~i23) & i9)) + iArr2[i26] + iArr3[i26];
                int i28 = i6 + i27;
                int i29 = i25 & i20;
                int i30 = i27 + ((((i25 >>> 2) | (i25 << 30)) ^ ((i25 >>> 13) | (i25 << 19))) ^ ((i25 >>> 22) | (i25 << 10))) + ((i29 ^ (i25 & i5)) ^ i24);
                int i31 = i26 + 1;
                int i32 = i9 + ((((i28 >>> 6) | (i28 << 26)) ^ ((i28 >>> 11) | (i28 << 21))) ^ ((i28 >>> 25) | (i28 << 7))) + (((~i28) & i18) ^ (i28 & i23)) + iArr2[i31] + iArr3[i31];
                int i33 = i5 + i32;
                int i34 = i30 & i25;
                int i35 = i32 + ((((i30 >>> 2) | (i30 << 30)) ^ ((i30 >>> 13) | (i30 << 19))) ^ ((i30 >>> 22) | (i30 << 10))) + (i29 ^ ((i30 & i20) ^ i34));
                int i36 = i31 + 1;
                int i37 = i18 + ((((i33 >>> 6) | (i33 << 26)) ^ ((i33 >>> 11) | (i33 << 21))) ^ ((i33 >>> 25) | (i33 << 7))) + ((i33 & i28) ^ ((~i33) & i23)) + iArr2[i36] + iArr3[i36];
                i12 = i20 + i37;
                int i38 = i35 & i30;
                i8 = i37 + ((((i35 >>> 2) | (i35 << 30)) ^ ((i35 >>> 13) | (i35 << 19))) ^ ((i35 >>> 22) | (i35 << 10))) + (i34 ^ ((i35 & i25) ^ i38));
                int i39 = i36 + 1;
                int i40 = i23 + ((((i12 >>> 6) | (i12 << 26)) ^ ((i12 >>> 11) | (i12 << 21))) ^ ((i12 >>> 25) | (i12 << 7))) + ((i12 & i33) ^ ((~i12) & i28)) + iArr2[i39] + iArr3[i39];
                i11 = i25 + i40;
                int i41 = i8 & i35;
                i7 = i40 + ((((i8 >>> 2) | (i8 << 30)) ^ ((i8 >>> 13) | (i8 << 19))) ^ ((i8 >>> 22) | (i8 << 10))) + (i38 ^ ((i8 & i30) ^ i41));
                int i42 = i39 + 1;
                int i43 = i28 + ((((i11 >>> 6) | (i11 << 26)) ^ ((i11 >>> 11) | (i11 << 21))) ^ ((i11 >>> 25) | (i11 << 7))) + ((i11 & i12) ^ ((~i11) & i33)) + iArr2[i42] + iArr3[i42];
                i10 = i30 + i43;
                int i44 = i7 & i8;
                i6 = i43 + ((((i7 >>> 2) | (i7 << 30)) ^ ((i7 >>> 13) | (i7 << 19))) ^ ((i7 >>> 22) | (i7 << 10))) + (i41 ^ ((i7 & i35) ^ i44));
                int i45 = i42 + 1;
                int i46 = i33 + ((((i10 >>> 6) | (i10 << 26)) ^ ((i10 >>> 11) | (i10 << 21))) ^ ((i10 >>> 25) | (i10 << 7))) + ((i10 & i11) ^ ((~i10) & i12)) + iArr2[i45] + iArr3[i45];
                i9 = i35 + i46;
                i5 = i46 + ((((i6 >>> 2) | (i6 << 30)) ^ ((i6 >>> 13) | (i6 << 19))) ^ ((i6 >>> 22) | (i6 << 10))) + (((i6 & i7) ^ (i6 & i8)) ^ i44);
                i14 = i45 + 1;
                i13++;
                ecnr256 = this;
            }
            ecnr256.getInstance += i5;
            ecnr256.configure += i6;
            ecnr256.init += i7;
            ecnr256.Cardinal += i8;
            ecnr256.cca_continue += i9;
            ecnr256.getWarnings += i10;
            ecnr256.getSDKVersion += i11;
            ecnr256.CardinalError += i12;
            ecnr256.cleanup = 0;
            for (int i47 = 0; i47 < 16; i47++) {
                ecnr256.values[i47] = 0;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecNR384 */
    public final class ecNR384 extends ecDSASha3_512 {
        public ecNR384() {
        }

        private ecNR384(ecNR384 ecnr384) {
            super(ecnr384);
        }

        public final void cca_continue() {
            super.cca_continue();
            this.configure = -3766243637369397544L;
            this.getInstance = 7105036623409894663L;
            this.cca_continue = -7973340178411365097L;
            this.init = 1526699215303891257L;
            this.Cardinal = 7436329637833083697L;
            this.getWarnings = -8163818279084223215L;
            this.CardinalError = -2662702644619276377L;
            this.getSDKVersion = 5167115440072839076L;
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            super.configure((ecNR384) setpaddingrelative);
        }

        public final String configure() {
            return "SHA-384";
        }

        public final int getInstance() {
            return 48;
        }

        public final setPaddingRelative init() {
            return new ecNR384(this);
        }

        public final int configure(byte[] bArr, int i) {
            CardinalError();
            long j = this.configure;
            setMinimumWidth.getInstance((int) (j >>> 32), bArr, i);
            setMinimumWidth.getInstance((int) j, bArr, i + 4);
            long j2 = this.getInstance;
            int i2 = i + 8;
            setMinimumWidth.getInstance((int) (j2 >>> 32), bArr, i2);
            setMinimumWidth.getInstance((int) j2, bArr, i2 + 4);
            long j3 = this.cca_continue;
            int i3 = i + 16;
            setMinimumWidth.getInstance((int) (j3 >>> 32), bArr, i3);
            setMinimumWidth.getInstance((int) j3, bArr, i3 + 4);
            long j4 = this.init;
            int i4 = i + 24;
            setMinimumWidth.getInstance((int) (j4 >>> 32), bArr, i4);
            setMinimumWidth.getInstance((int) j4, bArr, i4 + 4);
            long j5 = this.Cardinal;
            int i5 = i + 32;
            setMinimumWidth.getInstance((int) (j5 >>> 32), bArr, i5);
            setMinimumWidth.getInstance((int) j5, bArr, i5 + 4);
            long j6 = this.getWarnings;
            int i6 = i + 40;
            setMinimumWidth.getInstance((int) (j6 >>> 32), bArr, i6);
            setMinimumWidth.getInstance((int) j6, bArr, i6 + 4);
            cca_continue();
            return 48;
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecNR512 */
    public final class ecNR512 extends ecDSAnone implements KeyPairGeneratorSpi.ECDH {
        public ecNR512() {
            this(128);
        }

        public final String configure() {
            StringBuilder sb = new StringBuilder("SHAKE");
            sb.append(this.configure);
            return sb.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ecNR512(int i) {
            super(i);
            if (i == 128 || i == 256) {
                return;
            }
            StringBuilder sb = new StringBuilder("'bitLength' ");
            sb.append(i);
            sb.append(" not supported for SHAKE");
            throw new IllegalArgumentException(sb.toString());
        }

        public final int configure(byte[] bArr, int i) {
            int instance = getInstance();
            if (!this.Cardinal) {
                Cardinal(15, 4);
            }
            Cardinal(bArr, i, ((long) instance) << 3);
            cca_continue();
            return instance;
        }

        public final int getInstance(byte[] bArr, int i, int i2) {
            if (!this.Cardinal) {
                Cardinal(15, 4);
            }
            Cardinal(bArr, 0, ((long) i2) << 3);
            cca_continue();
            return i2;
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecPlainDSARP160 */
    public final class ecPlainDSARP160 extends ecDSASha3_512 {
        private long CardinalActionCode;
        private long CardinalEnvironment;
        private long CardinalRenderType;
        private long CardinalUiType;
        private long cleanup;
        private long getActionCode;
        private long setRequestTimeout;
        private long valueOf;
        private int values;

        private ecPlainDSARP160(ecPlainDSARP160 ecplaindsarp160) {
            super(ecplaindsarp160);
            this.values = ecplaindsarp160.values;
            cca_continue(ecplaindsarp160);
        }

        private static void getInstance(long j, byte[] bArr, int i, int i2) {
            if (i2 > 0) {
                init((int) (j >>> 32), bArr, i, i2);
                if (i2 > 4) {
                    init((int) j, bArr, i + 4, i2 - 4);
                }
            }
        }

        private static void init(int i, byte[] bArr, int i2, int i3) {
            int min = Math.min(4, i3);
            while (true) {
                min--;
                if (min >= 0) {
                    bArr[i2 + min] = (byte) (i >>> ((3 - min) * 8));
                } else {
                    return;
                }
            }
        }

        public final void cca_continue() {
            super.cca_continue();
            this.configure = this.cleanup;
            this.getInstance = this.valueOf;
            this.cca_continue = this.CardinalEnvironment;
            this.init = this.CardinalRenderType;
            this.Cardinal = this.CardinalUiType;
            this.getWarnings = this.CardinalActionCode;
            this.CardinalError = this.getActionCode;
            this.getSDKVersion = this.setRequestTimeout;
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            ecPlainDSARP160 ecplaindsarp160 = (ecPlainDSARP160) setpaddingrelative;
            if (this.values == ecplaindsarp160.values) {
                super.configure(ecplaindsarp160);
                this.cleanup = ecplaindsarp160.cleanup;
                this.valueOf = ecplaindsarp160.valueOf;
                this.CardinalEnvironment = ecplaindsarp160.CardinalEnvironment;
                this.CardinalRenderType = ecplaindsarp160.CardinalRenderType;
                this.CardinalUiType = ecplaindsarp160.CardinalUiType;
                this.CardinalActionCode = ecplaindsarp160.CardinalActionCode;
                this.getActionCode = ecplaindsarp160.getActionCode;
                this.setRequestTimeout = ecplaindsarp160.setRequestTimeout;
                return;
            }
            throw new setSystemUiVisibility("digestLength inappropriate in other");
        }

        public final int configure(byte[] bArr, int i) {
            CardinalError();
            getInstance(this.configure, bArr, i, this.values);
            getInstance(this.getInstance, bArr, i + 8, this.values - 8);
            getInstance(this.cca_continue, bArr, i + 16, this.values - 16);
            getInstance(this.init, bArr, i + 24, this.values - 24);
            getInstance(this.Cardinal, bArr, i + 32, this.values - 32);
            getInstance(this.getWarnings, bArr, i + 40, this.values - 40);
            getInstance(this.CardinalError, bArr, i + 48, this.values - 48);
            getInstance(this.getSDKVersion, bArr, i + 56, this.values - 56);
            cca_continue();
            return this.values;
        }

        public final String configure() {
            StringBuilder sb = new StringBuilder("SHA-512/");
            sb.append(Integer.toString(this.values << 3));
            return sb.toString();
        }

        public final int getInstance() {
            return this.values;
        }

        public final setPaddingRelative init() {
            return new ecPlainDSARP160(this);
        }

        public ecPlainDSARP160(int i) {
            if (i >= 512) {
                throw new IllegalArgumentException("bitLength cannot be >= 512");
            } else if (i % 8 != 0) {
                throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
            } else if (i != 384) {
                int i2 = i / 8;
                this.values = i2;
                int i3 = i2 << 3;
                this.configure = -3482333909917012819L;
                this.getInstance = 2216346199247487646L;
                this.cca_continue = -7364697282686394994L;
                this.init = 65953792586715988L;
                this.Cardinal = -816286391624063116L;
                this.getWarnings = 4512832404995164602L;
                this.CardinalError = -5033199132376557362L;
                this.getSDKVersion = -124578254951840548L;
                Cardinal((byte) 83);
                Cardinal((byte) 72);
                Cardinal((byte) 65);
                Cardinal((byte) 45);
                Cardinal((byte) 53);
                Cardinal((byte) 49);
                Cardinal((byte) 50);
                Cardinal((byte) 47);
                if (i3 > 100) {
                    Cardinal((byte) ((i3 / 100) + 48));
                    int i4 = i3 % 100;
                    Cardinal((byte) ((i4 / 10) + 48));
                    i3 = i4 % 10;
                } else if (i3 > 10) {
                    Cardinal((byte) ((i3 / 10) + 48));
                    i3 %= 10;
                }
                Cardinal((byte) (i3 + 48));
                CardinalError();
                this.cleanup = this.configure;
                this.valueOf = this.getInstance;
                this.CardinalEnvironment = this.cca_continue;
                this.CardinalRenderType = this.init;
                this.CardinalUiType = this.Cardinal;
                this.CardinalActionCode = this.getWarnings;
                this.getActionCode = this.CardinalError;
                this.setRequestTimeout = this.getSDKVersion;
                cca_continue();
            } else {
                throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
            }
        }
    }

    /* renamed from: a */
    private GMCipherSpi.SM2withMD5[] m1822a() {
        GMCipherSpi.SM2withMD5 sM2withMD5;
        GMCipherSpi.SM2withMD5[] sM2withMD5Arr = new GMCipherSpi.SM2withMD5[this.f2477a.getInstance()];
        for (int i = 0; i != this.f2477a.getInstance(); i++) {
            getProxyAddress Cardinal = this.f2477a.Cardinal(i);
            if (Cardinal == null || (Cardinal instanceof GMCipherSpi.SM2withMD5)) {
                sM2withMD5 = (GMCipherSpi.SM2withMD5) Cardinal;
            } else if (Cardinal instanceof setThreeDSRequestorAppURL) {
                sM2withMD5 = new GMCipherSpi.SM2withMD5((setThreeDSRequestorAppURL) Cardinal);
            } else {
                StringBuilder sb = new StringBuilder("Invalid DistributionPoint: ");
                sb.append(Cardinal.getClass().getName());
                throw new IllegalArgumentException(sb.toString());
            }
            sM2withMD5Arr[i] = sM2withMD5;
        }
        return sM2withMD5Arr;
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$Ed25519 */
    public final class Ed25519 extends GOST3410Util {
        public CipherSpi init;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Ed25519(java.security.SecureRandom r2, com.cardinalcommerce.p060a.CipherSpi r3) {
            /*
                r1 = this;
                int r0 = r3.getSDKVersion
                if (r0 == 0) goto L_0x0007
                int r0 = r3.getSDKVersion
                goto L_0x000d
            L_0x0007:
                java.math.BigInteger r0 = r3.Cardinal
                int r0 = r0.bitLength()
            L_0x000d:
                r1.<init>(r2, r0)
                r1.init = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.SignatureSpi.Ed25519.<init>(java.security.SecureRandom, com.cardinalcommerce.a.CipherSpi):void");
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$Ed448 */
    public final class Ed448 implements KeyFactorySpi.XDH {
        private long[][] Cardinal;
        private byte[] configure;

        public final void cca_continue(byte[] bArr) {
            if (this.Cardinal == null) {
                this.Cardinal = (long[][]) Array.newInstance(long.class, new int[]{256, 2});
                byte[] bArr2 = bArr;
            } else if (setForegroundTintBlendMode.Cardinal(this.configure, bArr)) {
                return;
            }
            byte[] cca_continue = setForegroundTintBlendMode.cca_continue(bArr);
            this.configure = cca_continue;
            long[] jArr = this.Cardinal[1];
            int i = 0;
            for (int i2 = 0; i2 < jArr.length; i2++) {
                int cca_continue2 = setMinimumWidth.cca_continue(cca_continue, i);
                jArr[i2] = (((long) setMinimumWidth.cca_continue(cca_continue, i + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) cca_continue2) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32);
                i += 8;
            }
            long[][] jArr2 = this.Cardinal;
            long[] jArr3 = jArr2[1];
            long[] jArr4 = jArr2[1];
            long j = jArr3[0];
            long j2 = jArr3[1];
            long j3 = j2 << 57;
            jArr4[0] = (j3 >>> 7) ^ ((((j >>> 7) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
            jArr4[1] = (j << 57) | (j2 >>> 7);
            for (int i3 = 2; i3 < 256; i3 += 2) {
                long[][] jArr5 = this.Cardinal;
                long[] jArr6 = jArr5[i3 >> 1];
                long[] jArr7 = jArr5[i3];
                long j4 = jArr6[0];
                long j5 = jArr6[1];
                long j6 = j4 >> 63;
                jArr7[0] = ((j4 ^ (-2233785415175766016L & j6)) << 1) | (j5 >>> 63);
                jArr7[1] = (j5 << 1) | (-j6);
                long[] jArr8 = jArr5[i3];
                long[] jArr9 = jArr5[1];
                long[] jArr10 = jArr5[i3 + 1];
                jArr10[0] = jArr8[0] ^ jArr9[0];
                jArr10[1] = jArr8[1] ^ jArr9[1];
            }
        }

        public final void configure(byte[] bArr) {
            byte[] bArr2 = bArr;
            long[] jArr = this.Cardinal[bArr2[15] & 255];
            long j = jArr[0];
            long j2 = jArr[1];
            for (int i = 14; i >= 0; i--) {
                long[] jArr2 = this.Cardinal[bArr2[i] & 255];
                long j3 = j2 << 56;
                j2 = ((j2 >>> 8) | (j << 56)) ^ jArr2[1];
                j = (((((j >>> 8) ^ jArr2[0]) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
            }
            setMinimumWidth.getInstance((int) (j >>> 32), bArr2, 0);
            setMinimumWidth.getInstance((int) j, bArr2, 4);
            setMinimumWidth.getInstance((int) (j2 >>> 32), bArr2, 8);
            setMinimumWidth.getInstance((int) j2, bArr2, 12);
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSA256 */
    public final class ecDSA256 implements KeyFactorySpi.ECMQV {
        private PSSSignatureSpi.SHA3_224withRSA configure;

        public final int configure() {
            return 32;
        }

        public final void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.configure = (PSSSignatureSpi.SHA3_224withRSA) eCKAEGwithSHA512KDF;
        }

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr, int i) {
            PSSSignatureSpi.SHA3_224withRSA sHA3_224withRSA = this.configure;
            byte[] bArr2 = new byte[32];
            System.arraycopy(((PSSSignatureSpi.SHA3_256withRSA) eCKAEGwithSHA512KDF).configure, 0, bArr2, 0, 32);
            if (!setOnHoverListener.Cardinal(sHA3_224withRSA.configure, bArr2, bArr, i)) {
                throw new IllegalStateException("X25519 agreement failed");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDSA384 */
    public final class ecDSA384 implements KeyFactorySpi.ECMQV {
        private PSSSignatureSpi.SHA512_256withRSA Cardinal;

        public final int configure() {
            return 56;
        }

        public final void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.Cardinal = (PSSSignatureSpi.SHA512_256withRSA) eCKAEGwithSHA512KDF;
        }

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr, int i) {
            PSSSignatureSpi.SHA512_256withRSA sHA512_256withRSA = this.Cardinal;
            byte[] bArr2 = new byte[56];
            System.arraycopy(((PSSSignatureSpi.SHA3_384withRSA) eCKAEGwithSHA512KDF).configure, 0, bArr2, 0, 56);
            if (!setRevealOnFocusHint.getInstance(sHA512_256withRSA.getInstance, bArr2, bArr, i)) {
                throw new IllegalStateException("X448 agreement failed");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSA384 */
    public final class ecDetDSA384 extends ecDetDSA224 {
        private int Cardinal;
        private int cca_continue;
        private int[] configure = new int[16];
        private int getInstance;
        private int getSDKVersion;
        private int init;

        public ecDetDSA384() {
            cca_continue();
        }

        private ecDetDSA384(ecDetDSA384 ecdetdsa384) {
            super(ecdetdsa384);
            getInstance(ecdetdsa384);
        }

        private static int Cardinal(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = ((i + ((i2 & i4) | (i3 & (~i4)))) + i5) - 1894007588;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int cca_continue(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + ((i2 | (~i3)) ^ i4) + i5 + 1548603684;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static void cca_continue(int i, byte[] bArr, int i2) {
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >>> 8);
            bArr[i2 + 2] = (byte) (i >>> 16);
            bArr[i2 + 3] = (byte) (i >>> 24);
        }

        private static int configure(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + (((~i2) & i4) | (i3 & i2)) + i5 + 1518500249;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int getInstance(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + ((i2 | (~i3)) ^ i4) + i5 + 1859775393;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private void getInstance(ecDetDSA384 ecdetdsa384) {
            super.getInstance(ecdetdsa384);
            this.init = ecdetdsa384.init;
            this.Cardinal = ecdetdsa384.Cardinal;
            this.cca_continue = ecdetdsa384.cca_continue;
            this.getInstance = ecdetdsa384.getInstance;
            int[] iArr = ecdetdsa384.configure;
            System.arraycopy(iArr, 0, this.configure, 0, iArr.length);
            this.getSDKVersion = ecdetdsa384.getSDKVersion;
        }

        private static int getWarnings(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + ((i2 & i4) | (i3 & (~i4))) + i5 + 1352829926;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int init(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + (((~i2) & i4) | (i3 & i2)) + i5 + 1836072691;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        public final void cca_continue() {
            super.cca_continue();
            this.init = 1732584193;
            this.Cardinal = -271733879;
            this.cca_continue = -1732584194;
            this.getInstance = 271733878;
            this.getSDKVersion = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.configure;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            getInstance((ecDetDSA384) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int[] iArr = this.configure;
            int i2 = this.getSDKVersion;
            int i3 = i2 + 1;
            this.getSDKVersion = i3;
            iArr[i2] = ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            if (i3 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            cca_continue(this.init, bArr, i);
            cca_continue(this.Cardinal, bArr, i + 4);
            cca_continue(this.cca_continue, bArr, i + 8);
            cca_continue(this.getInstance, bArr, i + 12);
            cca_continue();
            return 16;
        }

        public final String configure() {
            return "RIPEMD128";
        }

        public final int getInstance() {
            return 16;
        }

        public final setPaddingRelative init() {
            return new ecDetDSA384(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.getSDKVersion > 14) {
                cleanup();
            }
            int[] iArr = this.configure;
            iArr[14] = (int) j;
            iArr[15] = (int) (j >>> 32);
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            int i = this.init;
            int i2 = this.Cardinal;
            int i3 = this.cca_continue;
            int i4 = this.getInstance;
            int[] iArr = this.configure;
            int i5 = ((i2 ^ i3) ^ i4) + i + iArr[0];
            int i6 = (i5 << 11) | (i5 >>> 21);
            int i7 = ((i6 ^ i2) ^ i3) + i4 + iArr[1];
            int i8 = (i7 << 14) | (i7 >>> 18);
            int i9 = ((i8 ^ i6) ^ i2) + i3 + iArr[2];
            int i10 = (i9 << 15) | (i9 >>> 17);
            int i11 = ((i10 ^ i8) ^ i6) + i2 + iArr[3];
            int i12 = (i11 << 12) | (i11 >>> 20);
            int i13 = i6 + ((i12 ^ i10) ^ i8) + iArr[4];
            int i14 = (i13 >>> 27) | (i13 << 5);
            int i15 = i8 + ((i14 ^ i12) ^ i10) + iArr[5];
            int i16 = (i15 << 8) | (i15 >>> 24);
            int i17 = i10 + ((i16 ^ i14) ^ i12) + iArr[6];
            int i18 = (i17 << 7) | (i17 >>> 25);
            int i19 = i12 + ((i18 ^ i16) ^ i14) + iArr[7];
            int i20 = (i19 << 9) | (i19 >>> 23);
            int i21 = i14 + ((i20 ^ i18) ^ i16) + iArr[8];
            int i22 = (i21 << 11) | (i21 >>> 21);
            int i23 = i16 + ((i22 ^ i20) ^ i18) + iArr[9];
            int i24 = (i23 << 13) | (i23 >>> 19);
            int i25 = i18 + ((i24 ^ i22) ^ i20) + iArr[10];
            int i26 = (i25 << 14) | (i25 >>> 18);
            int i27 = i20 + ((i26 ^ i24) ^ i22) + iArr[11];
            int i28 = (i27 << 15) | (i27 >>> 17);
            int i29 = i22 + ((i28 ^ i26) ^ i24) + iArr[12];
            int i30 = (i29 << 6) | (i29 >>> 26);
            int i31 = i24 + ((i30 ^ i28) ^ i26) + iArr[13];
            int i32 = (i31 << 7) | (i31 >>> 25);
            int i33 = i26 + ((i32 ^ i30) ^ i28) + iArr[14];
            int i34 = (i33 << 9) | (i33 >>> 23);
            int i35 = i28 + ((i34 ^ i32) ^ i30) + iArr[15];
            int i36 = (i35 << 8) | (i35 >>> 24);
            int configure2 = configure(i30, i36, i34, i32, iArr[7], 7);
            int configure3 = configure(i32, configure2, i36, i34, this.configure[4], 6);
            int configure4 = configure(i34, configure3, configure2, i36, this.configure[13], 8);
            int configure5 = configure(i36, configure4, configure3, configure2, this.configure[1], 13);
            int configure6 = configure(configure2, configure5, configure4, configure3, this.configure[10], 11);
            int configure7 = configure(configure3, configure6, configure5, configure4, this.configure[6], 9);
            int configure8 = configure(configure4, configure7, configure6, configure5, this.configure[15], 7);
            int configure9 = configure(configure5, configure8, configure7, configure6, this.configure[3], 15);
            int configure10 = configure(configure6, configure9, configure8, configure7, this.configure[12], 7);
            int configure11 = configure(configure7, configure10, configure9, configure8, this.configure[0], 12);
            int configure12 = configure(configure8, configure11, configure10, configure9, this.configure[9], 15);
            int configure13 = configure(configure9, configure12, configure11, configure10, this.configure[5], 9);
            int configure14 = configure(configure10, configure13, configure12, configure11, this.configure[2], 11);
            int configure15 = configure(configure11, configure14, configure13, configure12, this.configure[14], 7);
            int configure16 = configure(configure12, configure15, configure14, configure13, this.configure[11], 13);
            int configure17 = configure(configure13, configure16, configure15, configure14, this.configure[8], 12);
            int instance = getInstance(configure14, configure17, configure16, configure15, this.configure[3], 11);
            int instance2 = getInstance(configure15, instance, configure17, configure16, this.configure[10], 13);
            int instance3 = getInstance(configure16, instance2, instance, configure17, this.configure[14], 6);
            int instance4 = getInstance(configure17, instance3, instance2, instance, this.configure[4], 7);
            int instance5 = getInstance(instance, instance4, instance3, instance2, this.configure[9], 14);
            int instance6 = getInstance(instance2, instance5, instance4, instance3, this.configure[15], 9);
            int instance7 = getInstance(instance3, instance6, instance5, instance4, this.configure[8], 13);
            int instance8 = getInstance(instance4, instance7, instance6, instance5, this.configure[1], 15);
            int instance9 = getInstance(instance5, instance8, instance7, instance6, this.configure[2], 14);
            int instance10 = getInstance(instance6, instance9, instance8, instance7, this.configure[7], 8);
            int instance11 = getInstance(instance7, instance10, instance9, instance8, this.configure[0], 13);
            int instance12 = getInstance(instance8, instance11, instance10, instance9, this.configure[6], 6);
            int instance13 = getInstance(instance9, instance12, instance11, instance10, this.configure[13], 5);
            int instance14 = getInstance(instance10, instance13, instance12, instance11, this.configure[11], 12);
            int instance15 = getInstance(instance11, instance14, instance13, instance12, this.configure[5], 7);
            int instance16 = getInstance(instance12, instance15, instance14, instance13, this.configure[12], 5);
            int Cardinal2 = Cardinal(instance13, instance16, instance15, instance14, this.configure[1], 11);
            int Cardinal3 = Cardinal(instance14, Cardinal2, instance16, instance15, this.configure[9], 12);
            int Cardinal4 = Cardinal(instance15, Cardinal3, Cardinal2, instance16, this.configure[11], 14);
            int Cardinal5 = Cardinal(instance16, Cardinal4, Cardinal3, Cardinal2, this.configure[10], 15);
            int Cardinal6 = Cardinal(Cardinal2, Cardinal5, Cardinal4, Cardinal3, this.configure[0], 14);
            int Cardinal7 = Cardinal(Cardinal3, Cardinal6, Cardinal5, Cardinal4, this.configure[8], 15);
            int Cardinal8 = Cardinal(Cardinal4, Cardinal7, Cardinal6, Cardinal5, this.configure[12], 9);
            int Cardinal9 = Cardinal(Cardinal5, Cardinal8, Cardinal7, Cardinal6, this.configure[4], 8);
            int Cardinal10 = Cardinal(Cardinal6, Cardinal9, Cardinal8, Cardinal7, this.configure[13], 9);
            int Cardinal11 = Cardinal(Cardinal7, Cardinal10, Cardinal9, Cardinal8, this.configure[3], 14);
            int Cardinal12 = Cardinal(Cardinal8, Cardinal11, Cardinal10, Cardinal9, this.configure[7], 5);
            int Cardinal13 = Cardinal(Cardinal9, Cardinal12, Cardinal11, Cardinal10, this.configure[15], 6);
            int Cardinal14 = Cardinal(Cardinal10, Cardinal13, Cardinal12, Cardinal11, this.configure[14], 8);
            int Cardinal15 = Cardinal(Cardinal11, Cardinal14, Cardinal13, Cardinal12, this.configure[5], 6);
            int Cardinal16 = Cardinal(Cardinal12, Cardinal15, Cardinal14, Cardinal13, this.configure[6], 5);
            int Cardinal17 = Cardinal(Cardinal13, Cardinal16, Cardinal15, Cardinal14, this.configure[2], 12);
            int warnings = getWarnings(i, i2, i3, i4, this.configure[5], 8);
            int warnings2 = getWarnings(i4, warnings, i2, i3, this.configure[14], 9);
            int warnings3 = getWarnings(i3, warnings2, warnings, i2, this.configure[7], 9);
            int warnings4 = getWarnings(i2, warnings3, warnings2, warnings, this.configure[0], 11);
            int warnings5 = getWarnings(warnings, warnings4, warnings3, warnings2, this.configure[9], 13);
            int warnings6 = getWarnings(warnings2, warnings5, warnings4, warnings3, this.configure[2], 15);
            int warnings7 = getWarnings(warnings3, warnings6, warnings5, warnings4, this.configure[11], 15);
            int warnings8 = getWarnings(warnings4, warnings7, warnings6, warnings5, this.configure[4], 5);
            int warnings9 = getWarnings(warnings5, warnings8, warnings7, warnings6, this.configure[13], 7);
            int warnings10 = getWarnings(warnings6, warnings9, warnings8, warnings7, this.configure[6], 7);
            int warnings11 = getWarnings(warnings7, warnings10, warnings9, warnings8, this.configure[15], 8);
            int warnings12 = getWarnings(warnings8, warnings11, warnings10, warnings9, this.configure[8], 11);
            int i37 = warnings12;
            int warnings13 = getWarnings(warnings9, i37, warnings11, warnings10, this.configure[1], 14);
            int warnings14 = getWarnings(warnings10, warnings13, warnings12, warnings11, this.configure[10], 14);
            int warnings15 = getWarnings(warnings11, warnings14, warnings13, warnings12, this.configure[3], 12);
            int warnings16 = getWarnings(i37, warnings15, warnings14, warnings13, this.configure[12], 6);
            int cca_continue2 = cca_continue(warnings13, warnings16, warnings15, warnings14, this.configure[6], 9);
            int cca_continue3 = cca_continue(warnings14, cca_continue2, warnings16, warnings15, this.configure[11], 13);
            int cca_continue4 = cca_continue(warnings15, cca_continue3, cca_continue2, warnings16, this.configure[3], 15);
            int cca_continue5 = cca_continue(warnings16, cca_continue4, cca_continue3, cca_continue2, this.configure[7], 7);
            int cca_continue6 = cca_continue(cca_continue2, cca_continue5, cca_continue4, cca_continue3, this.configure[0], 12);
            int cca_continue7 = cca_continue(cca_continue3, cca_continue6, cca_continue5, cca_continue4, this.configure[13], 8);
            int cca_continue8 = cca_continue(cca_continue4, cca_continue7, cca_continue6, cca_continue5, this.configure[5], 9);
            int cca_continue9 = cca_continue(cca_continue5, cca_continue8, cca_continue7, cca_continue6, this.configure[10], 11);
            int cca_continue10 = cca_continue(cca_continue6, cca_continue9, cca_continue8, cca_continue7, this.configure[14], 7);
            int cca_continue11 = cca_continue(cca_continue7, cca_continue10, cca_continue9, cca_continue8, this.configure[15], 7);
            int cca_continue12 = cca_continue(cca_continue8, cca_continue11, cca_continue10, cca_continue9, this.configure[8], 12);
            int cca_continue13 = cca_continue(cca_continue9, cca_continue12, cca_continue11, cca_continue10, this.configure[12], 7);
            int cca_continue14 = cca_continue(cca_continue10, cca_continue13, cca_continue12, cca_continue11, this.configure[4], 6);
            int i38 = cca_continue14;
            int cca_continue15 = cca_continue(cca_continue11, i38, cca_continue13, cca_continue12, this.configure[9], 15);
            int cca_continue16 = cca_continue(cca_continue12, cca_continue15, cca_continue14, cca_continue13, this.configure[1], 13);
            int cca_continue17 = cca_continue(cca_continue13, cca_continue16, cca_continue15, cca_continue14, this.configure[2], 11);
            int init2 = init(i38, cca_continue17, cca_continue16, cca_continue15, this.configure[15], 9);
            int i39 = init2;
            int init3 = init(cca_continue15, i39, cca_continue17, cca_continue16, this.configure[5], 7);
            int init4 = init(cca_continue16, init3, init2, cca_continue17, this.configure[1], 15);
            int init5 = init(cca_continue17, init4, init3, init2, this.configure[3], 11);
            int init6 = init(i39, init5, init4, init3, this.configure[7], 8);
            int init7 = init(init3, init6, init5, init4, this.configure[14], 6);
            int i40 = init7;
            int init8 = init(init4, i40, init6, init5, this.configure[6], 6);
            int init9 = init(init5, init8, init7, init6, this.configure[9], 14);
            int init10 = init(init6, init9, init8, init7, this.configure[11], 12);
            int init11 = init(i40, init10, init9, init8, this.configure[8], 13);
            int init12 = init(init8, init11, init10, init9, this.configure[12], 5);
            int init13 = init(init9, init12, init11, init10, this.configure[2], 14);
            int init14 = init(init10, init13, init12, init11, this.configure[10], 13);
            int init15 = init(init11, init14, init13, init12, this.configure[0], 13);
            int init16 = init(init12, init15, init14, init13, this.configure[4], 7);
            int init17 = init(init13, init16, init15, init14, this.configure[13], 5);
            int[] iArr2 = this.configure;
            int i41 = init14 + ((init17 ^ init16) ^ init15) + iArr2[8];
            int i42 = (i41 >>> 17) | (i41 << 15);
            int i43 = init15 + ((i42 ^ init17) ^ init16) + iArr2[6];
            int i44 = (i43 >>> 27) | (i43 << 5);
            int i45 = init16 + ((i44 ^ i42) ^ init17) + iArr2[4];
            int i46 = (i45 >>> 24) | (i45 << 8);
            int i47 = init17 + ((i46 ^ i44) ^ i42) + iArr2[1];
            int i48 = (i47 >>> 21) | (i47 << 11);
            int i49 = i42 + ((i48 ^ i46) ^ i44) + iArr2[3];
            int i50 = (i49 >>> 18) | (i49 << 14);
            int i51 = i44 + ((i50 ^ i48) ^ i46) + iArr2[11];
            int i52 = (i51 >>> 18) | (i51 << 14);
            int i53 = i46 + ((i52 ^ i50) ^ i48) + iArr2[15];
            int i54 = (i53 >>> 26) | (i53 << 6);
            int i55 = i48 + ((i54 ^ i52) ^ i50) + iArr2[0];
            int i56 = (i55 >>> 18) | (i55 << 14);
            int i57 = i50 + ((i56 ^ i54) ^ i52) + iArr2[5];
            int i58 = (i57 >>> 26) | (i57 << 6);
            int i59 = i52 + ((i58 ^ i56) ^ i54) + iArr2[12];
            int i60 = (i59 >>> 23) | (i59 << 9);
            int i61 = i54 + ((i60 ^ i58) ^ i56) + iArr2[2];
            int i62 = (i61 >>> 20) | (i61 << 12);
            int i63 = i56 + ((i62 ^ i60) ^ i58) + iArr2[13];
            int i64 = (i63 >>> 23) | (i63 << 9);
            int i65 = i58 + ((i64 ^ i62) ^ i60) + iArr2[9];
            int i66 = (i65 >>> 20) | (i65 << 12);
            int i67 = i60 + ((i66 ^ i64) ^ i62) + iArr2[7];
            int i68 = (i67 >>> 27) | (i67 << 5);
            int i69 = i62 + ((i68 ^ i66) ^ i64) + iArr2[10];
            int i70 = (i69 >>> 17) | (i69 << 15);
            int i71 = i64 + ((i70 ^ i68) ^ i66) + iArr2[14];
            this.Cardinal = this.cca_continue + Cardinal15 + i66;
            this.cca_continue = this.getInstance + Cardinal14 + ((i71 >>> 24) | (i71 << 8));
            this.getInstance = this.init + Cardinal17 + i70;
            this.init = i68 + Cardinal16 + this.Cardinal;
            this.getSDKVersion = 0;
            int i72 = 0;
            while (true) {
                int[] iArr3 = this.configure;
                if (i72 != iArr3.length) {
                    iArr3[i72] = 0;
                    i72++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.SignatureSpi$ecDetDSASha3_512 */
    public final class ecDetDSASha3_512 extends ecDetDSA224 {
        private int Cardinal;
        private int CardinalError;
        private int cca_continue;
        private int[] cleanup = new int[16];
        private int configure;
        private int getInstance;
        private int getSDKVersion;
        private int getWarnings;
        private int init;
        private int values;

        public ecDetDSASha3_512() {
            cca_continue();
        }

        private ecDetDSASha3_512(ecDetDSASha3_512 ecdetdsasha3_512) {
            super(ecdetdsasha3_512);
            Cardinal(ecdetdsasha3_512);
        }

        private static int Cardinal(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = ((i + ((i2 & i4) | (i3 & (~i4)))) + i5) - 1894007588;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static void Cardinal(int i, byte[] bArr, int i2) {
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >>> 8);
            bArr[i2 + 2] = (byte) (i >>> 16);
            bArr[i2 + 3] = (byte) (i >>> 24);
        }

        private void Cardinal(ecDetDSASha3_512 ecdetdsasha3_512) {
            super.getInstance(ecdetdsasha3_512);
            this.Cardinal = ecdetdsasha3_512.Cardinal;
            this.configure = ecdetdsasha3_512.configure;
            this.cca_continue = ecdetdsasha3_512.cca_continue;
            this.getInstance = ecdetdsasha3_512.getInstance;
            this.init = ecdetdsasha3_512.init;
            this.getWarnings = ecdetdsasha3_512.getWarnings;
            this.getSDKVersion = ecdetdsasha3_512.getSDKVersion;
            this.values = ecdetdsasha3_512.values;
            int[] iArr = ecdetdsasha3_512.cleanup;
            System.arraycopy(iArr, 0, this.cleanup, 0, iArr.length);
            this.CardinalError = ecdetdsasha3_512.CardinalError;
        }

        private static int CardinalError(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + ((i2 & i4) | (i3 & (~i4))) + i5 + 1352829926;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int cca_continue(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + (((~i2) & i4) | (i3 & i2)) + i5 + 1518500249;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int configure(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + (((~i2) & i4) | (i3 & i2)) + i5 + 1836072691;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int getInstance(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + ((i2 | (~i3)) ^ i4) + i5 + 1859775393;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        private static int init(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7 = i + ((i2 | (~i3)) ^ i4) + i5 + 1548603684;
            return (i7 >>> (32 - i6)) | (i7 << i6);
        }

        public final void cca_continue() {
            super.cca_continue();
            this.Cardinal = 1732584193;
            this.configure = -271733879;
            this.cca_continue = -1732584194;
            this.getInstance = 271733878;
            this.init = 1985229328;
            this.getWarnings = -19088744;
            this.getSDKVersion = -1985229329;
            this.values = 19088743;
            this.CardinalError = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.cleanup;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        public final void cca_continue(setPaddingRelative setpaddingrelative) {
            Cardinal((ecDetDSASha3_512) setpaddingrelative);
        }

        /* access modifiers changed from: protected */
        public final void cca_continue(byte[] bArr, int i) {
            int[] iArr = this.cleanup;
            int i2 = this.CardinalError;
            int i3 = i2 + 1;
            this.CardinalError = i3;
            iArr[i2] = ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            if (i3 == 16) {
                cleanup();
            }
        }

        public final int configure(byte[] bArr, int i) {
            values();
            Cardinal(this.Cardinal, bArr, i);
            Cardinal(this.configure, bArr, i + 4);
            Cardinal(this.cca_continue, bArr, i + 8);
            Cardinal(this.getInstance, bArr, i + 12);
            Cardinal(this.init, bArr, i + 16);
            Cardinal(this.getWarnings, bArr, i + 20);
            Cardinal(this.getSDKVersion, bArr, i + 24);
            Cardinal(this.values, bArr, i + 28);
            cca_continue();
            return 32;
        }

        public final String configure() {
            return "RIPEMD256";
        }

        public final int getInstance() {
            return 32;
        }

        public final setPaddingRelative init() {
            return new ecDetDSASha3_512(this);
        }

        /* access modifiers changed from: protected */
        public final void init(long j) {
            if (this.CardinalError > 14) {
                cleanup();
            }
            int[] iArr = this.cleanup;
            iArr[14] = (int) j;
            iArr[15] = (int) (j >>> 32);
        }

        /* access modifiers changed from: protected */
        public final void cleanup() {
            int i = this.Cardinal;
            int i2 = this.configure;
            int i3 = this.cca_continue;
            int i4 = this.getInstance;
            int i5 = this.init;
            int i6 = this.getWarnings;
            int i7 = this.getSDKVersion;
            int i8 = this.values;
            int[] iArr = this.cleanup;
            int i9 = i + ((i2 ^ i3) ^ i4) + iArr[0];
            int i10 = (i9 >>> 21) | (i9 << 11);
            int i11 = i4 + ((i10 ^ i2) ^ i3) + iArr[1];
            int i12 = (i11 >>> 18) | (i11 << 14);
            int i13 = i3 + ((i12 ^ i10) ^ i2) + iArr[2];
            int i14 = (i13 >>> 17) | (i13 << 15);
            int i15 = i2 + ((i14 ^ i12) ^ i10) + iArr[3];
            int i16 = (i15 >>> 20) | (i15 << 12);
            int i17 = i10 + ((i16 ^ i14) ^ i12) + iArr[4];
            int i18 = (i17 >>> 27) | (i17 << 5);
            int i19 = i12 + ((i18 ^ i16) ^ i14) + iArr[5];
            int i20 = (i19 >>> 24) | (i19 << 8);
            int i21 = i14 + ((i20 ^ i18) ^ i16) + iArr[6];
            int i22 = (i21 >>> 25) | (i21 << 7);
            int i23 = i16 + ((i22 ^ i20) ^ i18) + iArr[7];
            int i24 = (i23 >>> 23) | (i23 << 9);
            int i25 = i18 + ((i24 ^ i22) ^ i20) + iArr[8];
            int i26 = (i25 >>> 21) | (i25 << 11);
            int i27 = i20 + ((i26 ^ i24) ^ i22) + iArr[9];
            int i28 = (i27 >>> 19) | (i27 << 13);
            int i29 = i22 + ((i28 ^ i26) ^ i24) + iArr[10];
            int i30 = (i29 >>> 18) | (i29 << 14);
            int i31 = i24 + ((i30 ^ i28) ^ i26) + iArr[11];
            int i32 = (i31 >>> 17) | (i31 << 15);
            int i33 = i26 + ((i32 ^ i30) ^ i28) + iArr[12];
            int i34 = (i33 << 6) | (i33 >>> 26);
            int i35 = i28 + ((i34 ^ i32) ^ i30) + iArr[13];
            int i36 = (i35 >>> 25) | (i35 << 7);
            int i37 = i30 + ((i36 ^ i34) ^ i32) + iArr[14];
            int i38 = (i37 >>> 23) | (i37 << 9);
            int i39 = i32 + ((i38 ^ i36) ^ i34) + iArr[15];
            int i40 = (i39 >>> 24) | (i39 << 8);
            int CardinalError2 = CardinalError(i5, i6, i7, i8, iArr[5], 8);
            int CardinalError3 = CardinalError(i8, CardinalError2, i6, i7, this.cleanup[14], 9);
            int CardinalError4 = CardinalError(i7, CardinalError3, CardinalError2, i6, this.cleanup[7], 9);
            int CardinalError5 = CardinalError(i6, CardinalError4, CardinalError3, CardinalError2, this.cleanup[0], 11);
            int CardinalError6 = CardinalError(CardinalError2, CardinalError5, CardinalError4, CardinalError3, this.cleanup[9], 13);
            int CardinalError7 = CardinalError(CardinalError3, CardinalError6, CardinalError5, CardinalError4, this.cleanup[2], 15);
            int CardinalError8 = CardinalError(CardinalError4, CardinalError7, CardinalError6, CardinalError5, this.cleanup[11], 15);
            int CardinalError9 = CardinalError(CardinalError5, CardinalError8, CardinalError7, CardinalError6, this.cleanup[4], 5);
            int CardinalError10 = CardinalError(CardinalError6, CardinalError9, CardinalError8, CardinalError7, this.cleanup[13], 7);
            int CardinalError11 = CardinalError(CardinalError7, CardinalError10, CardinalError9, CardinalError8, this.cleanup[6], 7);
            int CardinalError12 = CardinalError(CardinalError8, CardinalError11, CardinalError10, CardinalError9, this.cleanup[15], 8);
            int CardinalError13 = CardinalError(CardinalError9, CardinalError12, CardinalError11, CardinalError10, this.cleanup[8], 11);
            int CardinalError14 = CardinalError(CardinalError10, CardinalError13, CardinalError12, CardinalError11, this.cleanup[1], 14);
            int CardinalError15 = CardinalError(CardinalError11, CardinalError14, CardinalError13, CardinalError12, this.cleanup[10], 14);
            int CardinalError16 = CardinalError(CardinalError12, CardinalError15, CardinalError14, CardinalError13, this.cleanup[3], 12);
            int CardinalError17 = CardinalError(CardinalError13, CardinalError16, CardinalError15, CardinalError14, this.cleanup[12], 6);
            int cca_continue2 = cca_continue(CardinalError14, i40, i38, i36, this.cleanup[7], 7);
            int cca_continue3 = cca_continue(i36, cca_continue2, i40, i38, this.cleanup[4], 6);
            int cca_continue4 = cca_continue(i38, cca_continue3, cca_continue2, i40, this.cleanup[13], 8);
            int cca_continue5 = cca_continue(i40, cca_continue4, cca_continue3, cca_continue2, this.cleanup[1], 13);
            int cca_continue6 = cca_continue(cca_continue2, cca_continue5, cca_continue4, cca_continue3, this.cleanup[10], 11);
            int cca_continue7 = cca_continue(cca_continue3, cca_continue6, cca_continue5, cca_continue4, this.cleanup[6], 9);
            int cca_continue8 = cca_continue(cca_continue4, cca_continue7, cca_continue6, cca_continue5, this.cleanup[15], 7);
            int cca_continue9 = cca_continue(cca_continue5, cca_continue8, cca_continue7, cca_continue6, this.cleanup[3], 15);
            int cca_continue10 = cca_continue(cca_continue6, cca_continue9, cca_continue8, cca_continue7, this.cleanup[12], 7);
            int cca_continue11 = cca_continue(cca_continue7, cca_continue10, cca_continue9, cca_continue8, this.cleanup[0], 12);
            int cca_continue12 = cca_continue(cca_continue8, cca_continue11, cca_continue10, cca_continue9, this.cleanup[9], 15);
            int cca_continue13 = cca_continue(cca_continue9, cca_continue12, cca_continue11, cca_continue10, this.cleanup[5], 9);
            int cca_continue14 = cca_continue(cca_continue10, cca_continue13, cca_continue12, cca_continue11, this.cleanup[2], 11);
            int cca_continue15 = cca_continue(cca_continue11, cca_continue14, cca_continue13, cca_continue12, this.cleanup[14], 7);
            int cca_continue16 = cca_continue(cca_continue12, cca_continue15, cca_continue14, cca_continue13, this.cleanup[11], 13);
            int cca_continue17 = cca_continue(cca_continue13, cca_continue16, cca_continue15, cca_continue14, this.cleanup[8], 12);
            int init2 = init(i34, CardinalError17, CardinalError16, CardinalError15, this.cleanup[6], 9);
            int init3 = init(CardinalError15, init2, CardinalError17, CardinalError16, this.cleanup[11], 13);
            int init4 = init(CardinalError16, init3, init2, CardinalError17, this.cleanup[3], 15);
            int init5 = init(CardinalError17, init4, init3, init2, this.cleanup[7], 7);
            int init6 = init(init2, init5, init4, init3, this.cleanup[0], 12);
            int init7 = init(init3, init6, init5, init4, this.cleanup[13], 8);
            int init8 = init(init4, init7, init6, init5, this.cleanup[5], 9);
            int init9 = init(init5, init8, init7, init6, this.cleanup[10], 11);
            int init10 = init(init6, init9, init8, init7, this.cleanup[14], 7);
            int init11 = init(init7, init10, init9, init8, this.cleanup[15], 7);
            int init12 = init(init8, init11, init10, init9, this.cleanup[8], 12);
            int init13 = init(init9, init12, init11, init10, this.cleanup[12], 7);
            int init14 = init(init10, init13, init12, init11, this.cleanup[4], 6);
            int init15 = init(init11, init14, init13, init12, this.cleanup[9], 15);
            int init16 = init(init12, init15, init14, init13, this.cleanup[1], 13);
            int init17 = init(init13, init16, init15, init14, this.cleanup[2], 11);
            int instance = getInstance(cca_continue14, init17, cca_continue16, cca_continue15, this.cleanup[3], 11);
            int instance2 = getInstance(cca_continue15, instance, init17, cca_continue16, this.cleanup[10], 13);
            int instance3 = getInstance(cca_continue16, instance2, instance, init17, this.cleanup[14], 6);
            int instance4 = getInstance(init17, instance3, instance2, instance, this.cleanup[4], 7);
            int instance5 = getInstance(instance, instance4, instance3, instance2, this.cleanup[9], 14);
            int instance6 = getInstance(instance2, instance5, instance4, instance3, this.cleanup[15], 9);
            int instance7 = getInstance(instance3, instance6, instance5, instance4, this.cleanup[8], 13);
            int instance8 = getInstance(instance4, instance7, instance6, instance5, this.cleanup[1], 15);
            int instance9 = getInstance(instance5, instance8, instance7, instance6, this.cleanup[2], 14);
            int instance10 = getInstance(instance6, instance9, instance8, instance7, this.cleanup[7], 8);
            int instance11 = getInstance(instance7, instance10, instance9, instance8, this.cleanup[0], 13);
            int instance12 = getInstance(instance8, instance11, instance10, instance9, this.cleanup[6], 6);
            int instance13 = getInstance(instance9, instance12, instance11, instance10, this.cleanup[13], 5);
            int instance14 = getInstance(instance10, instance13, instance12, instance11, this.cleanup[11], 12);
            int instance15 = getInstance(instance11, instance14, instance13, instance12, this.cleanup[5], 7);
            int instance16 = getInstance(instance12, instance15, instance14, instance13, this.cleanup[12], 5);
            int configure2 = configure(init14, cca_continue17, init16, init15, this.cleanup[15], 9);
            int configure3 = configure(init15, configure2, cca_continue17, init16, this.cleanup[5], 7);
            int configure4 = configure(init16, configure3, configure2, cca_continue17, this.cleanup[1], 15);
            int configure5 = configure(cca_continue17, configure4, configure3, configure2, this.cleanup[3], 11);
            int configure6 = configure(configure2, configure5, configure4, configure3, this.cleanup[7], 8);
            int configure7 = configure(configure3, configure6, configure5, configure4, this.cleanup[14], 6);
            int configure8 = configure(configure4, configure7, configure6, configure5, this.cleanup[6], 6);
            int configure9 = configure(configure5, configure8, configure7, configure6, this.cleanup[9], 14);
            int configure10 = configure(configure6, configure9, configure8, configure7, this.cleanup[11], 12);
            int configure11 = configure(configure7, configure10, configure9, configure8, this.cleanup[8], 13);
            int configure12 = configure(configure8, configure11, configure10, configure9, this.cleanup[12], 5);
            int configure13 = configure(configure9, configure12, configure11, configure10, this.cleanup[2], 14);
            int configure14 = configure(configure10, configure13, configure12, configure11, this.cleanup[10], 13);
            int configure15 = configure(configure11, configure14, configure13, configure12, this.cleanup[0], 13);
            int configure16 = configure(configure12, configure15, configure14, configure13, this.cleanup[4], 7);
            int configure17 = configure(configure13, configure16, configure15, configure14, this.cleanup[13], 5);
            int Cardinal2 = Cardinal(instance13, instance16, configure16, instance14, this.cleanup[1], 11);
            int Cardinal3 = Cardinal(instance14, Cardinal2, instance16, configure16, this.cleanup[9], 12);
            int Cardinal4 = Cardinal(configure16, Cardinal3, Cardinal2, instance16, this.cleanup[11], 14);
            int Cardinal5 = Cardinal(instance16, Cardinal4, Cardinal3, Cardinal2, this.cleanup[10], 15);
            int Cardinal6 = Cardinal(Cardinal2, Cardinal5, Cardinal4, Cardinal3, this.cleanup[0], 14);
            int Cardinal7 = Cardinal(Cardinal3, Cardinal6, Cardinal5, Cardinal4, this.cleanup[8], 15);
            int Cardinal8 = Cardinal(Cardinal4, Cardinal7, Cardinal6, Cardinal5, this.cleanup[12], 9);
            int Cardinal9 = Cardinal(Cardinal5, Cardinal8, Cardinal7, Cardinal6, this.cleanup[4], 8);
            int Cardinal10 = Cardinal(Cardinal6, Cardinal9, Cardinal8, Cardinal7, this.cleanup[13], 9);
            int Cardinal11 = Cardinal(Cardinal7, Cardinal10, Cardinal9, Cardinal8, this.cleanup[3], 14);
            int Cardinal12 = Cardinal(Cardinal8, Cardinal11, Cardinal10, Cardinal9, this.cleanup[7], 5);
            int Cardinal13 = Cardinal(Cardinal9, Cardinal12, Cardinal11, Cardinal10, this.cleanup[15], 6);
            int Cardinal14 = Cardinal(Cardinal10, Cardinal13, Cardinal12, Cardinal11, this.cleanup[14], 8);
            int Cardinal15 = Cardinal(Cardinal11, Cardinal14, Cardinal13, Cardinal12, this.cleanup[5], 6);
            int Cardinal16 = Cardinal(Cardinal12, Cardinal15, Cardinal14, Cardinal13, this.cleanup[6], 5);
            int Cardinal17 = Cardinal(Cardinal13, Cardinal16, Cardinal15, Cardinal14, this.cleanup[2], 12);
            int[] iArr2 = this.cleanup;
            int i41 = configure14 + ((configure17 ^ instance15) ^ configure15) + iArr2[8];
            int i42 = (i41 >>> 17) | (i41 << 15);
            int i43 = configure15 + ((i42 ^ configure17) ^ instance15) + iArr2[6];
            int i44 = (i43 >>> 27) | (i43 << 5);
            int i45 = instance15 + ((i44 ^ i42) ^ configure17) + iArr2[4];
            int i46 = (i45 >>> 24) | (i45 << 8);
            int i47 = configure17 + ((i46 ^ i44) ^ i42) + iArr2[1];
            int i48 = (i47 >>> 21) | (i47 << 11);
            int i49 = i42 + ((i48 ^ i46) ^ i44) + iArr2[3];
            int i50 = (i49 >>> 18) | (i49 << 14);
            int i51 = i44 + ((i50 ^ i48) ^ i46) + iArr2[11];
            int i52 = (i51 >>> 18) | (i51 << 14);
            int i53 = i46 + ((i52 ^ i50) ^ i48) + iArr2[15];
            int i54 = (i53 >>> 26) | (i53 << 6);
            int i55 = i48 + ((i54 ^ i52) ^ i50) + iArr2[0];
            int i56 = (i55 >>> 18) | (i55 << 14);
            int i57 = i50 + ((i56 ^ i54) ^ i52) + iArr2[5];
            int i58 = (i57 >>> 26) | (i57 << 6);
            int i59 = i52 + ((i58 ^ i56) ^ i54) + iArr2[12];
            int i60 = (i59 >>> 23) | (i59 << 9);
            int i61 = i54 + ((i60 ^ i58) ^ i56) + iArr2[2];
            int i62 = (i61 >>> 20) | (i61 << 12);
            int i63 = i56 + ((i62 ^ i60) ^ i58) + iArr2[13];
            int i64 = (i63 << 9) | (i63 >>> 23);
            int i65 = i58 + ((i64 ^ i62) ^ i60) + iArr2[9];
            int i66 = (i65 << 12) | (i65 >>> 20);
            int i67 = i60 + ((i66 ^ i64) ^ i62) + iArr2[7];
            int i68 = (i67 >>> 27) | (i67 << 5);
            int i69 = i62 + ((i68 ^ i66) ^ i64) + iArr2[10];
            int i70 = (i69 >>> 17) | (i69 << 15);
            int i71 = i64 + ((i70 ^ i68) ^ i66) + iArr2[14];
            this.Cardinal += Cardinal14;
            this.configure += Cardinal17;
            this.cca_continue += Cardinal16;
            this.getInstance += i68;
            this.init += i66;
            this.getWarnings += (i71 >>> 24) | (i71 << 8);
            this.getSDKVersion += i70;
            this.values += Cardinal15;
            this.CardinalError = 0;
            int i72 = 0;
            while (true) {
                int[] iArr3 = this.cleanup;
                if (i72 != iArr3.length) {
                    iArr3[i72] = 0;
                    i72++;
                } else {
                    return;
                }
            }
        }
    }
}
