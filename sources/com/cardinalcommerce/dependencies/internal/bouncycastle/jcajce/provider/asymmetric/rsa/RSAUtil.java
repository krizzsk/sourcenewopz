package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.setActivated;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAUtil {

    /* renamed from: a */
    private static ASN1ObjectIdentifier[] f3215a = {KeyFactorySpi.configure, IESCipher.ECIESwithDESedeCBC.f2447d_, KeyFactorySpi.cleanup, KeyFactorySpi.getSDKVersion};

    /* renamed from: a */
    static ISOSignatureSpi.WhirlpoolWithRSAEncryption m2202a(RSAPrivateKey rSAPrivateKey) {
        if (!(rSAPrivateKey instanceof RSAPrivateCrtKey)) {
            return new ISOSignatureSpi.WhirlpoolWithRSAEncryption(true, rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rSAPrivateKey;
        return new PSSSignatureSpi.SHA224withRSA(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
    }

    /* renamed from: a */
    static ISOSignatureSpi.WhirlpoolWithRSAEncryption m2203a(RSAPublicKey rSAPublicKey) {
        return new ISOSignatureSpi.WhirlpoolWithRSAEncryption(false, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
    }

    /* renamed from: a */
    static String m2204a(BigInteger bigInteger) {
        return new setActivated(bigInteger.toByteArray()).toString();
    }

    /* renamed from: b */
    static String m2205b(BigInteger bigInteger) {
        return new setActivated(bigInteger.toByteArray(), 32).toString();
    }

    public static boolean configure(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int i = 0;
        while (true) {
            ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = f3215a;
            if (i == aSN1ObjectIdentifierArr.length) {
                return false;
            }
            if (aSN1ObjectIdentifier.equals(aSN1ObjectIdentifierArr[i])) {
                return true;
            }
            i++;
        }
    }
}
