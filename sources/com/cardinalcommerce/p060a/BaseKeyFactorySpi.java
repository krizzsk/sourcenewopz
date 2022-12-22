package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.BaseCipherSpi;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.BaseKeyFactorySpi */
public final class BaseKeyFactorySpi implements KeyPairGeneratorSpi.ECDSA, getSDKReferenceNumber {

    /* renamed from: a */
    private final X931SignatureSpi f2325a;

    /* renamed from: b */
    private final X931SignatureSpi.RIPEMD128WithRSAEncryption f2326b;

    /* renamed from: c */
    private BCRSAPublicKey f2327c;

    /* renamed from: d */
    private ChallengeParameters f2328d;

    /* renamed from: e */
    private DigestSignatureSpi.MD4 f2329e;

    /* renamed from: f */
    private byte[] f2330f;
    public final KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getInstance;

    public BaseKeyFactorySpi() {
        this(DESUtil.cca_continue, new BCECGOST3410PublicKey());
    }

    public BaseKeyFactorySpi(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this(DESUtil.cca_continue, mQVwithSHA256KDFAndSharedInfo);
    }

    private BaseKeyFactorySpi(X931SignatureSpi.RIPEMD128WithRSAEncryption rIPEMD128WithRSAEncryption, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.f2325a = new BaseCipherSpi.ErasableOutputStream();
        this.f2326b = rIPEMD128WithRSAEncryption;
        this.getInstance = mQVwithSHA256KDFAndSharedInfo;
    }

    public final void cca_continue(byte[] bArr, int i, int i2) {
        this.getInstance.init(bArr, i, i2);
    }

    public final void init(byte b) {
        this.getInstance.Cardinal(b);
    }

    public final void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        byte[] bArr;
        if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA512WithRSAEncryption) {
            ISOSignatureSpi.SHA512WithRSAEncryption sHA512WithRSAEncryption = (ISOSignatureSpi.SHA512WithRSAEncryption) eCKAEGwithSHA512KDF;
            KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF2 = sHA512WithRSAEncryption.cca_continue;
            byte[] init = sHA512WithRSAEncryption.init();
            if (init.length < 8192) {
                KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF3 = eCKAEGwithSHA512KDF2;
                bArr = init;
                eCKAEGwithSHA512KDF = eCKAEGwithSHA512KDF3;
            } else {
                throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
            }
        } else {
            bArr = setTextDirection.getInstance("31323334353637383132333435363738");
        }
        if (z) {
            if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                DigestSignatureSpi.MD4 md4 = (DigestSignatureSpi.MD4) sHA224WithRSAEncryption.getInstance;
                this.f2329e = md4;
                BCRSAPublicKey bCRSAPublicKey = md4.init;
                this.f2327c = bCRSAPublicKey;
                this.f2325a.init(bCRSAPublicKey.cca_continue, sHA224WithRSAEncryption.configure);
            } else {
                DigestSignatureSpi.MD4 md42 = (DigestSignatureSpi.MD4) eCKAEGwithSHA512KDF;
                this.f2329e = md42;
                BCRSAPublicKey bCRSAPublicKey2 = md42.init;
                this.f2327c = bCRSAPublicKey2;
                this.f2325a.init(bCRSAPublicKey2.cca_continue, KeyAgreementSpi.MQV.cca_continue());
            }
            this.f2328d = new setAcsRefNumber().configure(this.f2327c.init, ((DigestSignatureSpi.MD2) this.f2329e).Cardinal).CardinalRenderType();
        } else {
            DigestSignatureSpi.MD4 md43 = (DigestSignatureSpi.MD4) eCKAEGwithSHA512KDF;
            this.f2329e = md43;
            this.f2327c = md43.init;
            this.f2328d = ((DigestSignatureSpi) this.f2329e).cca_continue;
        }
        byte[] a = m1788a(bArr);
        this.f2330f = a;
        this.getInstance.init(a, 0, a.length);
    }

    public final boolean init(byte[] bArr) {
        try {
            BigInteger[] configure = this.f2326b.configure(this.f2327c.cca_continue, bArr);
            return m1786a(configure[0], configure[1]);
        } catch (Exception unused) {
            return false;
        }
    }

    public final byte[] Cardinal() throws KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo {
        byte[] a = m1787a();
        BigInteger bigInteger = this.f2327c.cca_continue;
        BigInteger bigInteger2 = new BigInteger(1, a);
        BigInteger bigInteger3 = ((DigestSignatureSpi.MD2) this.f2329e).Cardinal;
        setAcsRefNumber setacsrefnumber = new setAcsRefNumber();
        while (true) {
            BigInteger Cardinal = this.f2325a.Cardinal();
            BigInteger mod = bigInteger2.add(setacsrefnumber.configure(this.f2327c.init, Cardinal).CardinalRenderType().getSDKVersion().Cardinal()).mod(bigInteger);
            if (!mod.equals(CardinalError) && !mod.add(Cardinal).equals(bigInteger)) {
                BigInteger mod2 = bigInteger3.add(values).modInverse(bigInteger).multiply(Cardinal.subtract(mod.multiply(bigInteger3)).mod(bigInteger)).mod(bigInteger);
                if (!mod2.equals(CardinalError)) {
                    try {
                        return this.f2326b.getInstance(this.f2327c.cca_continue, mod, mod2);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder("unable to encode signature: ");
                        sb.append(e.getMessage());
                        throw new KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo(sb.toString(), e);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m1786a(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = this.f2327c.cca_continue;
        if (bigInteger.compareTo(values) < 0 || bigInteger.compareTo(bigInteger3) >= 0 || bigInteger2.compareTo(values) < 0 || bigInteger2.compareTo(bigInteger3) >= 0) {
            return false;
        }
        BigInteger bigInteger4 = new BigInteger(1, m1787a());
        BigInteger mod = bigInteger.add(bigInteger2).mod(bigInteger3);
        if (mod.equals(CardinalError)) {
            return false;
        }
        ChallengeParameters CardinalRenderType = getDeviceData.init(this.f2327c.init, bigInteger2, ((DigestSignatureSpi) this.f2329e).cca_continue, mod).CardinalRenderType();
        if (CardinalRenderType.valueOf()) {
            return false;
        }
        return bigInteger4.add(CardinalRenderType.getSDKVersion().Cardinal()).mod(bigInteger3).equals(bigInteger);
    }

    /* renamed from: a */
    private byte[] m1787a() {
        byte[] bArr = new byte[this.getInstance.getInstance()];
        this.getInstance.configure(bArr, 0);
        this.getInstance.cca_continue();
        byte[] bArr2 = this.f2330f;
        if (bArr2 != null) {
            this.getInstance.init(bArr2, 0, bArr2.length);
        }
        return bArr;
    }

    /* renamed from: a */
    private byte[] m1788a(byte[] bArr) {
        this.getInstance.cca_continue();
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
        int length = bArr.length << 3;
        mQVwithSHA256KDFAndSharedInfo.Cardinal((byte) (length >> 8));
        mQVwithSHA256KDFAndSharedInfo.Cardinal((byte) length);
        mQVwithSHA256KDFAndSharedInfo.init(bArr, 0, bArr.length);
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
        byte[] CardinalEnvironment = this.f2327c.Cardinal.cleanup().CardinalEnvironment();
        mQVwithSHA256KDFAndSharedInfo2.init(CardinalEnvironment, 0, CardinalEnvironment.length);
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo3 = this.getInstance;
        byte[] CardinalEnvironment2 = this.f2327c.Cardinal.getWarnings().CardinalEnvironment();
        mQVwithSHA256KDFAndSharedInfo3.init(CardinalEnvironment2, 0, CardinalEnvironment2.length);
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo4 = this.getInstance;
        byte[] CardinalEnvironment3 = this.f2327c.init.getSDKVersion().CardinalEnvironment();
        mQVwithSHA256KDFAndSharedInfo4.init(CardinalEnvironment3, 0, CardinalEnvironment3.length);
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo5 = this.getInstance;
        ChallengeParameters challengeParameters = this.f2327c.init;
        if (challengeParameters.CardinalEnvironment()) {
            byte[] CardinalEnvironment4 = challengeParameters.CardinalError().CardinalEnvironment();
            mQVwithSHA256KDFAndSharedInfo5.init(CardinalEnvironment4, 0, CardinalEnvironment4.length);
            KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo6 = this.getInstance;
            byte[] CardinalEnvironment5 = this.f2328d.getSDKVersion().CardinalEnvironment();
            mQVwithSHA256KDFAndSharedInfo6.init(CardinalEnvironment5, 0, CardinalEnvironment5.length);
            KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo7 = this.getInstance;
            ChallengeParameters challengeParameters2 = this.f2328d;
            if (challengeParameters2.CardinalEnvironment()) {
                byte[] CardinalEnvironment6 = challengeParameters2.CardinalError().CardinalEnvironment();
                mQVwithSHA256KDFAndSharedInfo7.init(CardinalEnvironment6, 0, CardinalEnvironment6.length);
                byte[] bArr2 = new byte[this.getInstance.getInstance()];
                this.getInstance.configure(bArr2, 0);
                return bArr2;
            }
            throw new IllegalStateException("point not in normal form");
        }
        throw new IllegalStateException("point not in normal form");
    }
}
