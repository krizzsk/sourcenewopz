package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.BCGOST3410PublicKey;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setActivated;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class DSAUtil {
    public static final ASN1ObjectIdentifier[] configure = {KeyAgreementSpi.ECKAEGwithSHA1KDF.Payment, KeyAgreementSpi.MQVwithSHA512KDF.getWarnings, KeyAgreementSpi.ECKAEGwithSHA1KDF.getType};

    public static boolean Cardinal(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int i = 0;
        while (true) {
            ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = configure;
            if (i == aSN1ObjectIdentifierArr.length) {
                return false;
            }
            if (aSN1ObjectIdentifier.equals(aSN1ObjectIdentifierArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: a */
    static BCGOST3410PublicKey m2191a(DSAParams dSAParams) {
        if (dSAParams != null) {
            return new BCGOST3410PublicKey(dSAParams.getP(), dSAParams.getQ(), dSAParams.getG());
        }
        return null;
    }

    /* renamed from: a */
    static String m2192a(BigInteger bigInteger, DSAParams dSAParams) {
        return new setActivated(setForegroundTintBlendMode.Cardinal(bigInteger.toByteArray(), dSAParams.getP().toByteArray(), dSAParams.getQ().toByteArray(), dSAParams.getG().toByteArray())).toString();
    }

    public static setKeyboardNavigationCluster cca_continue(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof DSAPrivateKey) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) privateKey;
            return new AlgorithmParametersSpi.PSS(dSAPrivateKey.getX(), new BCGOST3410PublicKey(dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG()));
        }
        throw new InvalidKeyException("can't identify DSA private key.");
    }

    public static setKeyboardNavigationCluster init(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCDSAPublicKey) {
            return ((BCDSAPublicKey) publicKey).configure;
        }
        if (publicKey instanceof DSAPublicKey) {
            return new BCDSAPublicKey((DSAPublicKey) publicKey).configure;
        }
        try {
            return new BCDSAPublicKey(SubjectPublicKeyInfo.init(publicKey.getEncoded())).configure;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder("can't identify DSA public key: ");
            sb.append(publicKey.getClass().getName());
            throw new InvalidKeyException(sb.toString());
        }
    }
}
