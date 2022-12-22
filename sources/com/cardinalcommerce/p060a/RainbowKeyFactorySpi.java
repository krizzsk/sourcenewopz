package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* renamed from: com.cardinalcommerce.a.RainbowKeyFactorySpi */
public abstract class RainbowKeyFactorySpi extends AlgorithmProvider {
    protected static void cca_continue(McElieceKeyFactorySpi mcElieceKeyFactorySpi, String str, String str2, String str3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("WITH");
        sb.append(str2);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("with");
        sb2.append(str2);
        String obj2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("With");
        sb3.append(str2);
        String obj3 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append("/");
        sb4.append(str2);
        String obj4 = sb4.toString();
        mcElieceKeyFactorySpi.init("Signature.".concat(String.valueOf(obj)), str3);
        mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj2)), obj);
        mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj3)), obj);
        mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj4)), obj);
        mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(aSN1ObjectIdentifier)), obj);
        mcElieceKeyFactorySpi.init("Alg.Alias.Signature.OID.".concat(String.valueOf(aSN1ObjectIdentifier)), obj);
    }

    protected static void configure(McElieceKeyFactorySpi mcElieceKeyFactorySpi, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.".concat(String.valueOf(aSN1ObjectIdentifier)), str);
        mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.".concat(String.valueOf(aSN1ObjectIdentifier)), str);
        mcElieceKeyFactorySpi.init(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    protected static void getInstance(McElieceKeyFactorySpi mcElieceKeyFactorySpi, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameterGenerator.".concat(String.valueOf(aSN1ObjectIdentifier)), str);
        mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(aSN1ObjectIdentifier)), str);
    }
}
