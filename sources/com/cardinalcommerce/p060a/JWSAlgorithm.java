package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cardinalcommerce.a.JWSAlgorithm */
public final class JWSAlgorithm {

    /* renamed from: a */
    private static Map<ASN1ObjectIdentifier, String> f2451a;

    static {
        HashMap hashMap = new HashMap();
        f2451a = hashMap;
        hashMap.put(KeyFactorySpi.getProxyAddress, MessageDigestAlgorithms.MD2);
        f2451a.put(KeyFactorySpi.getEnvironment, "MD4");
        f2451a.put(KeyFactorySpi.getChallengeTimeout, MessageDigestAlgorithms.MD5);
        f2451a.put(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError, "SHA-1");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion, McElieceCCA2KeyGenParameterSpec.SHA224);
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal, "SHA-256");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.configure, "SHA-384");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.getInstance, "SHA-512");
        f2451a.put(DSASigner.detDSA512.cca_continue, "RIPEMD-128");
        f2451a.put(DSASigner.detDSA512.Cardinal, "RIPEMD-160");
        f2451a.put(DSASigner.detDSA512.init, "RIPEMD-128");
        f2451a.put(KeyAgreementSpi.DHwithSHA384KDF.configure, "RIPEMD-128");
        f2451a.put(KeyAgreementSpi.DHwithSHA384KDF.init, "RIPEMD-160");
        f2451a.put(KeyAgreementSpi.DHUwithSHA512CKDF.init, "GOST3411");
        f2451a.put(KeyAgreementSpi.DHwithSHA384CKDF.configure, "Tiger");
        f2451a.put(KeyAgreementSpi.DHwithSHA384KDF.Cardinal, "Whirlpool");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.cleanup, "SHA3-224");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.getWarnings, "SHA3-256");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalActionCode, "SHA3-384");
        f2451a.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalUiType, "SHA3-512");
        f2451a.put(KeyAgreementSpi.DHwithSHA224KDF.getString, "SM3");
    }

    public static String Cardinal(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = f2451a.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.init;
    }
}
