package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.DSAEncoder */
public final class DSAEncoder {

    /* renamed from: a */
    private static Set f2354a;

    static {
        HashSet hashSet = new HashSet(5);
        f2354a = hashSet;
        hashSet.add(KeyAgreementSpi.DHUwithSHA512CKDF.CardinalEnvironment);
        f2354a.add(KeyAgreementSpi.DHUwithSHA512CKDF.CardinalUiType);
        f2354a.add(KeyAgreementSpi.DHUwithSHA512CKDF.getString);
        f2354a.add(KeyAgreementSpi.DHUwithSHA512CKDF.getActionCode);
        f2354a.add(KeyAgreementSpi.DHUwithSHA512CKDF.CardinalConfigurationParameters);
    }

    /* renamed from: a */
    private static void m1800a(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != i; i2++) {
            bArr[i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    public static PrivateKeyInfo configure(setKeyboardNavigationCluster setkeyboardnavigationcluster) throws IOException {
        return Cardinal(setkeyboardnavigationcluster, (isEnableLogging) null);
    }

    public static PrivateKeyInfo Cardinal(setKeyboardNavigationCluster setkeyboardnavigationcluster, isEnableLogging isenablelogging) throws IOException {
        int i;
        KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo cDHwithSHA512KDFAndSharedInfo;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (setkeyboardnavigationcluster instanceof ISOSignatureSpi.WhirlpoolWithRSAEncryption) {
            PSSSignatureSpi.SHA224withRSA sHA224withRSA = (PSSSignatureSpi.SHA224withRSA) setkeyboardnavigationcluster;
            return new PrivateKeyInfo(new DSASigner.stdDSA(KeyFactorySpi.configure, ECGOST.Mappings.Cardinal), new DSASigner(sHA224withRSA.configure, sHA224withRSA.getInstance, sHA224withRSA.Cardinal, sHA224withRSA.cca_continue, sHA224withRSA.init, sHA224withRSA.values, sHA224withRSA.CardinalError, sHA224withRSA.getSDKVersion), isenablelogging);
        } else if (setkeyboardnavigationcluster instanceof AlgorithmParametersSpi.PSS) {
            AlgorithmParametersSpi.PSS pss = (AlgorithmParametersSpi.PSS) setkeyboardnavigationcluster;
            BCGOST3410PublicKey bCGOST3410PublicKey = pss.Cardinal;
            return new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.Payment, new GMCipherSpi.SM2withBlake2s(bCGOST3410PublicKey.init, bCGOST3410PublicKey.getInstance, bCGOST3410PublicKey.cca_continue)), new setProxyAddress(pss.init), isenablelogging);
        } else {
            int i2 = 32;
            boolean z = false;
            if (setkeyboardnavigationcluster instanceof DigestSignatureSpi.MD2) {
                DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) setkeyboardnavigationcluster;
                BCRSAPublicKey bCRSAPublicKey = md2.init;
                if (bCRSAPublicKey == null) {
                    cDHwithSHA512KDFAndSharedInfo = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo((setUiType) ECGOST.Mappings.Cardinal);
                    i = md2.Cardinal.bitLength();
                } else if (bCRSAPublicKey instanceof CipherSpi.ISO9796d1Padding) {
                    CipherSpi.ISO9796d1Padding iSO9796d1Padding = (CipherSpi.ISO9796d1Padding) bCRSAPublicKey;
                    KeyAgreementSpi.DHwithSHA1CKDF dHwithSHA1CKDF = new KeyAgreementSpi.DHwithSHA1CKDF(iSO9796d1Padding.configure, iSO9796d1Padding.getWarnings, iSO9796d1Padding.cleanup);
                    if (f2354a.contains(dHwithSHA1CKDF.cca_continue)) {
                        aSN1ObjectIdentifier = KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion;
                    } else {
                        if (md2.Cardinal.bitLength() > 256) {
                            z = true;
                        }
                        aSN1ObjectIdentifier = z ? DSASigner.detDSA224.Cardinal : DSASigner.detDSA224.init;
                        if (z) {
                            i2 = 64;
                        }
                    }
                    byte[] bArr = new byte[i2];
                    m1800a(bArr, i2, md2.Cardinal);
                    return new PrivateKeyInfo(new DSASigner.stdDSA(aSN1ObjectIdentifier, dHwithSHA1CKDF), new EdEC(bArr));
                } else if (bCRSAPublicKey instanceof CipherSpi.PKCS1v1_5Padding_PublicOnly) {
                    cDHwithSHA512KDFAndSharedInfo = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(((CipherSpi.PKCS1v1_5Padding_PublicOnly) bCRSAPublicKey).getSDKVersion);
                    i = bCRSAPublicKey.cca_continue.bitLength();
                } else {
                    KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo cDHwithSHA512KDFAndSharedInfo2 = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(new KeyAgreementSpi.C1970DH(bCRSAPublicKey.Cardinal, bCRSAPublicKey.init, bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance, bCRSAPublicKey.init()));
                    i = bCRSAPublicKey.cca_continue.bitLength();
                    cDHwithSHA512KDFAndSharedInfo = cDHwithSHA512KDFAndSharedInfo2;
                }
                return new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType, cDHwithSHA512KDFAndSharedInfo), new DSASigner.detDSASha3_256(i, md2.Cardinal, new PrivateKeyInfo(bCRSAPublicKey.init.configure(md2.Cardinal).configure(false)), cDHwithSHA512KDFAndSharedInfo), isenablelogging);
            } else if (setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA512_256withRSA) {
                PSSSignatureSpi.SHA512_256withRSA sHA512_256withRSA = (PSSSignatureSpi.SHA512_256withRSA) setkeyboardnavigationcluster;
                return new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHwithSHA256CKDF.configure), new EdEC(sHA512_256withRSA.getEncoded()), isenablelogging, sHA512_256withRSA.Cardinal().getEncoded());
            } else if (setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA3_224withRSA) {
                PSSSignatureSpi.SHA3_224withRSA sHA3_224withRSA = (PSSSignatureSpi.SHA3_224withRSA) setkeyboardnavigationcluster;
                DSASigner.stdDSA stddsa = new DSASigner.stdDSA(KeyAgreementSpi.DHwithSHA256CKDF.cca_continue);
                EdEC edEC = new EdEC(sHA3_224withRSA.getEncoded());
                byte[] bArr2 = new byte[32];
                setOnHoverListener.Cardinal(sHA3_224withRSA.configure, 0, bArr2, 0);
                return new PrivateKeyInfo(stddsa, edEC, isenablelogging, new PSSSignatureSpi.SHA3_256withRSA(bArr2, 0).getEncoded());
            } else if (setkeyboardnavigationcluster instanceof DigestSignatureSpi.SHA1) {
                DigestSignatureSpi.SHA1 sha1 = (DigestSignatureSpi.SHA1) setkeyboardnavigationcluster;
                DSASigner.stdDSA stddsa2 = new DSASigner.stdDSA(KeyAgreementSpi.DHwithSHA256CKDF.init);
                EdEC edEC2 = new EdEC(sha1.getEncoded());
                byte[] bArr3 = new byte[57];
                setAutofillId.init(sha1.cca_continue, bArr3);
                return new PrivateKeyInfo(stddsa2, edEC2, isenablelogging, new DigestSignatureSpi.RIPEMD128(bArr3, 0).getEncoded());
            } else if (setkeyboardnavigationcluster instanceof DigestSignatureSpi.MD5) {
                DigestSignatureSpi.MD5 md5 = (DigestSignatureSpi.MD5) setkeyboardnavigationcluster;
                DSASigner.stdDSA stddsa3 = new DSASigner.stdDSA(KeyAgreementSpi.DHwithSHA256CKDF.Cardinal);
                EdEC edEC3 = new EdEC(md5.getEncoded());
                byte[] bArr4 = new byte[32];
                setImportantForAutofill.cca_continue(md5.Cardinal, bArr4);
                return new PrivateKeyInfo(stddsa3, edEC3, isenablelogging, new DigestSignatureSpi.RIPEMD256(bArr4, 0).getEncoded());
            } else {
                throw new IOException("key parameters not recognized");
            }
        }
    }
}
