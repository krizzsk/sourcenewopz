package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.KeyUtil */
public final class KeyUtil {

    /* renamed from: a */
    private final KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2457a;

    /* renamed from: b */
    private DigestSignatureSpi.MD2 f2458b;

    /* renamed from: c */
    private BigInteger f2459c;

    KeyUtil() {
    }

    public static boolean init(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return !init(bArr, bArr);
        }
        byte b = 0;
        for (int i = 0; i != bArr.length; i++) {
            b |= bArr[i] ^ bArr2[i];
        }
        return b == 0;
    }

    public static String Cardinal(String str, String str2, setKeyboardNavigationCluster setkeyboardnavigationcluster) {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        byte[] encoded = setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA3_384withRSA ? ((PSSSignatureSpi.SHA3_384withRSA) setkeyboardnavigationcluster).getEncoded() : setkeyboardnavigationcluster instanceof DigestSignatureSpi.RIPEMD128 ? ((DigestSignatureSpi.RIPEMD128) setkeyboardnavigationcluster).getEncoded() : setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA3_256withRSA ? ((PSSSignatureSpi.SHA3_256withRSA) setkeyboardnavigationcluster).getEncoded() : ((DigestSignatureSpi.RIPEMD256) setkeyboardnavigationcluster).getEncoded();
        stringBuffer.append(str2);
        stringBuffer.append(" ");
        stringBuffer.append(str);
        stringBuffer.append(" [");
        stringBuffer.append(new setActivated(encoded).toString());
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("    public data: ");
        stringBuffer.append(setTextDirection.cca_continue(encoded));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    public KeyUtil(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.f2457a = mQVwithSHA256KDFAndSharedInfo;
    }

    public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        ISOSignatureSpi.SHA512_256WithRSAEncryption sHA512_256WithRSAEncryption = (ISOSignatureSpi.SHA512_256WithRSAEncryption) eCKAEGwithSHA512KDF;
        this.f2458b = (DigestSignatureSpi.MD2) sHA512_256WithRSAEncryption.init;
        byte[] configure = sHA512_256WithRSAEncryption.configure();
        int length = configure.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = configure[(configure.length - i) - 1];
        }
        this.f2459c = new BigInteger(1, bArr);
    }

    public final byte[] Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
        BCRSAPublicKey bCRSAPublicKey = this.f2458b.init;
        if (bCRSAPublicKey.equals(digestSignatureSpi.init)) {
            BigInteger mod = bCRSAPublicKey.getInstance.multiply(this.f2459c).multiply(this.f2458b.Cardinal).mod(bCRSAPublicKey.cca_continue);
            ChallengeParameters instance = getDeviceData.getInstance(bCRSAPublicKey.Cardinal, digestSignatureSpi.cca_continue);
            if (!instance.valueOf()) {
                ChallengeParameters CardinalRenderType = instance.configure(mod).CardinalRenderType();
                if (!CardinalRenderType.valueOf()) {
                    return m1818a(CardinalRenderType);
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
            }
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        throw new IllegalStateException("ECVKO public key has wrong domain parameters");
    }

    /* renamed from: a */
    private byte[] m1818a(ChallengeParameters challengeParameters) {
        BigInteger Cardinal = challengeParameters.getSDKVersion().Cardinal();
        if (challengeParameters.CardinalEnvironment()) {
            BigInteger Cardinal2 = challengeParameters.CardinalError().Cardinal();
            int i = Cardinal.toByteArray().length > 33 ? 64 : 32;
            int i2 = i * 2;
            byte[] bArr = new byte[i2];
            byte[] Cardinal3 = setSelected.Cardinal(i, Cardinal);
            byte[] Cardinal4 = setSelected.Cardinal(i, Cardinal2);
            for (int i3 = 0; i3 != i; i3++) {
                bArr[i3] = Cardinal3[(i - i3) - 1];
            }
            for (int i4 = 0; i4 != i; i4++) {
                bArr[i + i4] = Cardinal4[(i - i4) - 1];
            }
            this.f2457a.init(bArr, 0, i2);
            byte[] bArr2 = new byte[this.f2457a.getInstance()];
            this.f2457a.configure(bArr2, 0);
            return bArr2;
        }
        throw new IllegalStateException("point not in normal form");
    }
}
