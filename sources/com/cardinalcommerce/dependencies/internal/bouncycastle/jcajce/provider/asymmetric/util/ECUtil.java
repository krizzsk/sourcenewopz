package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.BCECGOST3410_2012PublicKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.EncryptedJWT;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyLengthException;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.setActivated;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Enumeration;
import java.util.Vector;

public class ECUtil {
    /* renamed from: a */
    static int[] m2208a(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else if (iArr.length != 3) {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        } else if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
            iArr2[0] = iArr[0];
            if (iArr[1] < iArr[2]) {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[1];
            }
        } else if (iArr[1] < iArr[2]) {
            iArr2[0] = iArr[1];
            if (iArr[0] < iArr[2]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[0];
            }
        } else {
            iArr2[0] = iArr[2];
            if (iArr[0] < iArr[1]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[1];
            } else {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[0];
            }
        }
        return iArr2;
    }

    public static ASN1ObjectIdentifier cca_continue(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf > 0) {
            str = str.substring(indexOf + 1);
        }
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                return new ASN1ObjectIdentifier(str);
            }
        } catch (IllegalArgumentException unused) {
        }
        return IESCipher.ECIESwithCipher.getInstance(str);
    }

    public static String getInstance(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IESCipher.ECIESwithCipher.cca_continue(aSN1ObjectIdentifier);
    }

    public static KeyAgreementSpi.C1970DH init(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        KeyAgreementSpi.C1970DH init = BCECGOST3410_2012PublicKey.init(aSN1ObjectIdentifier);
        return init == null ? IESCipher.ECIESwithCipher.configure(aSN1ObjectIdentifier) : init;
    }

    public static KeyAgreementSpi.C1970DH init(String str) {
        KeyAgreementSpi.C1970DH init = BCECGOST3410_2012PublicKey.init(str);
        return init == null ? IESCipher.ECIESwithCipher.configure(str) : init;
    }

    public static BCRSAPublicKey getInstance(NHKeyFactorySpi nHKeyFactorySpi, Container container) {
        if (container instanceof EncryptedJWT) {
            EncryptedJWT encryptedJWT = (EncryptedJWT) container;
            return new CipherSpi.PKCS1v1_5Padding_PublicOnly(cca_continue(encryptedJWT.configure), encryptedJWT.init, encryptedJWT.Cardinal, encryptedJWT.getInstance, encryptedJWT.cca_continue, encryptedJWT.getInstance());
        } else if (container != null) {
            return new BCRSAPublicKey(container.init, container.Cardinal, container.getInstance, container.cca_continue, container.getInstance());
        } else {
            Container cca_continue = nHKeyFactorySpi.cca_continue();
            return new BCRSAPublicKey(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue, cca_continue.getInstance());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.cardinalcommerce.a.KeyAgreementSpi$DH} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.p060a.BCRSAPublicKey Cardinal(com.cardinalcommerce.p060a.NHKeyFactorySpi r7, com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo r8) {
        /*
            boolean r0 = r8.Cardinal()
            if (r0 == 0) goto L_0x003a
            com.cardinalcommerce.a.setLocationDataConsentGiven r8 = r8.configure
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r8)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r8 = com.cardinalcommerce.p060a.BCECGOST3410_2012PublicKey.init((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r1)
            if (r8 != 0) goto L_0x0016
            com.cardinalcommerce.a.KeyAgreementSpi$DH r8 = com.cardinalcommerce.p060a.IESCipher.ECIESwithCipher.configure((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r1)
        L_0x0016:
            if (r8 != 0) goto L_0x0023
            java.util.Map r7 = r7.Cardinal()
            java.lang.Object r7 = r7.get(r1)
            r8 = r7
            com.cardinalcommerce.a.KeyAgreementSpi$DH r8 = (com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH) r8
        L_0x0023:
            com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding_PublicOnly r7 = new com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding_PublicOnly
            com.cardinalcommerce.a.getSDKAppID r2 = r8.cca_continue
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r0 = r8.getInstance
            com.cardinalcommerce.a.ChallengeParameters r3 = r0.cca_continue()
            java.math.BigInteger r4 = r8.Cardinal
            java.math.BigInteger r5 = r8.init
            byte[] r6 = r8.init()
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x0074
        L_0x003a:
            boolean r0 = r8.cca_continue()
            if (r0 == 0) goto L_0x0057
            com.cardinalcommerce.a.Container r7 = r7.cca_continue()
            com.cardinalcommerce.a.BCRSAPublicKey r8 = new com.cardinalcommerce.a.BCRSAPublicKey
            com.cardinalcommerce.a.getSDKAppID r1 = r7.init
            com.cardinalcommerce.a.ChallengeParameters r2 = r7.Cardinal
            java.math.BigInteger r3 = r7.getInstance
            java.math.BigInteger r4 = r7.cca_continue
            byte[] r5 = r7.getInstance()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0073
        L_0x0057:
            com.cardinalcommerce.a.setLocationDataConsentGiven r7 = r8.configure
            com.cardinalcommerce.a.KeyAgreementSpi$DH r7 = com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH.configure(r7)
            com.cardinalcommerce.a.BCRSAPublicKey r8 = new com.cardinalcommerce.a.BCRSAPublicKey
            com.cardinalcommerce.a.getSDKAppID r1 = r7.cca_continue
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r0 = r7.getInstance
            com.cardinalcommerce.a.ChallengeParameters r2 = r0.cca_continue()
            java.math.BigInteger r3 = r7.Cardinal
            java.math.BigInteger r4 = r7.init
            byte[] r5 = r7.init()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0073:
            r7 = r8
        L_0x0074:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.Cardinal(com.cardinalcommerce.a.NHKeyFactorySpi, com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo):com.cardinalcommerce.a.BCRSAPublicKey");
    }

    public static setKeyboardNavigationCluster Cardinal(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ECDSAVerifier) {
            ECDSAVerifier eCDSAVerifier = (ECDSAVerifier) publicKey;
            Container Cardinal = eCDSAVerifier.Cardinal();
            return new DigestSignatureSpi(eCDSAVerifier.configure(), new BCRSAPublicKey(Cardinal.init, Cardinal.Cardinal, Cardinal.getInstance, Cardinal.cca_continue, Cardinal.getInstance()));
        } else if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            Container cca_continue = EC5Util.cca_continue(eCPublicKey.getParams());
            return new DigestSignatureSpi(EC5Util.configure(eCPublicKey.getParams(), eCPublicKey.getW()), new BCRSAPublicKey(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue, cca_continue.getInstance()));
        } else {
            try {
                byte[] encoded = publicKey.getEncoded();
                if (encoded != null) {
                    PublicKey instance = JWK.getInstance(SubjectPublicKeyInfo.init(encoded));
                    if (instance instanceof ECPublicKey) {
                        return Cardinal(instance);
                    }
                    throw new InvalidKeyException("cannot identify EC public key.");
                }
                throw new InvalidKeyException("no encoding for EC public key");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("cannot identify EC public key: ");
                sb.append(e.toString());
                throw new InvalidKeyException(sb.toString());
            }
        }
    }

    public static setKeyboardNavigationCluster getInstance(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof KeyLengthException) {
            KeyLengthException keyLengthException = (KeyLengthException) privateKey;
            Container Cardinal = keyLengthException.Cardinal();
            if (Cardinal == null) {
                Cardinal = JWK.getInstance.cca_continue();
            }
            if (!(keyLengthException.Cardinal() instanceof EncryptedJWT)) {
                return new DigestSignatureSpi.MD2(keyLengthException.getInstance(), new BCRSAPublicKey(Cardinal.init, Cardinal.Cardinal, Cardinal.getInstance, Cardinal.cca_continue, Cardinal.getInstance()));
            }
            return new DigestSignatureSpi.MD2(keyLengthException.getInstance(), new CipherSpi.PKCS1v1_5Padding_PublicOnly(IESCipher.ECIESwithCipher.getInstance(((EncryptedJWT) keyLengthException.Cardinal()).configure), Cardinal.init, Cardinal.Cardinal, Cardinal.getInstance, Cardinal.cca_continue, Cardinal.getInstance()));
        } else if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            Container cca_continue = EC5Util.cca_continue(eCPrivateKey.getParams());
            return new DigestSignatureSpi.MD2(eCPrivateKey.getS(), new BCRSAPublicKey(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue, cca_continue.getInstance()));
        } else {
            try {
                byte[] encoded = privateKey.getEncoded();
                if (encoded != null) {
                    PrivateKey configure = JWK.configure(PrivateKeyInfo.init(encoded));
                    if (configure instanceof ECPrivateKey) {
                        return getInstance(configure);
                    }
                    throw new InvalidKeyException("can't identify EC private key.");
                }
                throw new InvalidKeyException("no encoding for EC private key");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("cannot identify EC private key: ");
                sb.append(e.toString());
                throw new InvalidKeyException(sb.toString());
            }
        }
    }

    public static int init(NHKeyFactorySpi nHKeyFactorySpi, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        Container cca_continue = nHKeyFactorySpi.cca_continue();
        return cca_continue == null ? bigInteger2.bitLength() : cca_continue.getInstance.bitLength();
    }

    public static ASN1ObjectIdentifier init(Container container) {
        Vector vector = new Vector();
        IESCipher.ECIESwithCipher.Cardinal(vector, KeyAgreementSpi.CDHwithSHA384KDFAndSharedInfo.getInstance());
        IESCipher.ECIESwithCipher.Cardinal(vector, DSASigner.detDSA256.configure());
        IESCipher.ECIESwithCipher.Cardinal(vector, KeyAgreementSpi.MQVwithSHA384CKDF.cca_continue());
        IESCipher.ECIESwithCipher.Cardinal(vector, DSASigner.detDSA384.getInstance());
        IESCipher.ECIESwithCipher.Cardinal(vector, KeyAgreementSpi.DHUwithSHA256CKDF.Cardinal());
        IESCipher.ECIESwithCipher.Cardinal(vector, KeyAgreementSpi.DHwithRFC2631KDF.configure());
        IESCipher.ECIESwithCipher.Cardinal(vector, KeyAgreementSpi.DHwithSHA256KDF.getInstance());
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            String str = (String) elements.nextElement();
            KeyAgreementSpi.C1970DH configure = IESCipher.ECIESwithCipher.configure(str);
            if (configure.Cardinal.equals(container.getInstance) && configure.init.equals(container.cca_continue) && configure.cca_continue.configure(container.init) && configure.getInstance.cca_continue().init(container.Cardinal)) {
                return IESCipher.ECIESwithCipher.getInstance(str);
            }
        }
        return null;
    }

    public static String configure(String str, BigInteger bigInteger, Container container) {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        ChallengeParameters CardinalRenderType = container.Cardinal.configure(bigInteger).CardinalRenderType();
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(m2207a(CardinalRenderType, container));
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("            X: ");
        stringBuffer.append(CardinalRenderType.getSDKVersion().Cardinal().toString(16));
        stringBuffer.append(instance);
        stringBuffer.append("            Y: ");
        if (CardinalRenderType.CardinalEnvironment()) {
            stringBuffer.append(CardinalRenderType.CardinalError().Cardinal().toString(16));
            stringBuffer.append(instance);
            return stringBuffer.toString();
        }
        throw new IllegalStateException("point not in normal form");
    }

    public static String configure(String str, ChallengeParameters challengeParameters, Container container) {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(m2207a(challengeParameters, container));
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("            X: ");
        stringBuffer.append(challengeParameters.getSDKVersion().Cardinal().toString(16));
        stringBuffer.append(instance);
        stringBuffer.append("            Y: ");
        if (challengeParameters.CardinalEnvironment()) {
            stringBuffer.append(challengeParameters.CardinalError().Cardinal().toString(16));
            stringBuffer.append(instance);
            return stringBuffer.toString();
        }
        throw new IllegalStateException("point not in normal form");
    }

    /* renamed from: a */
    private static String m2207a(ChallengeParameters challengeParameters, Container container) {
        getSDKAppID getsdkappid = container.init;
        return getsdkappid != null ? new setActivated(setForegroundTintBlendMode.Cardinal(challengeParameters.configure(false), getsdkappid.cleanup().CardinalEnvironment(), getsdkappid.getWarnings().CardinalEnvironment(), container.Cardinal.configure(false))).toString() : new setActivated(challengeParameters.configure(false)).toString();
    }
}
