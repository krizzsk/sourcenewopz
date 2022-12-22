package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.setCameraDistance */
public final class setCameraDistance {

    /* renamed from: a */
    private static Map<String, ASN1ObjectIdentifier> f2736a;

    static {
        HashMap hashMap = new HashMap();
        f2736a = hashMap;
        hashMap.put("SHA-256", KeyAgreementSpi.MQVwithSHA224KDF.Cardinal);
        f2736a.put("SHA-512", KeyAgreementSpi.MQVwithSHA224KDF.getInstance);
        f2736a.put("SHAKE128", KeyAgreementSpi.MQVwithSHA224KDF.valueOf);
        f2736a.put("SHAKE256", KeyAgreementSpi.MQVwithSHA224KDF.CardinalRenderType);
    }

    setCameraDistance() {
    }

    public static KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal)) {
            return new SignatureSpi.ecNR();
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.MQVwithSHA224KDF.getInstance)) {
            return new BCECGOST3410PrivateKey();
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.MQVwithSHA224KDF.valueOf)) {
            return new SignatureSpi.ecNR512(128);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.MQVwithSHA224KDF.CardinalRenderType)) {
            return new SignatureSpi.ecNR512(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: ".concat(String.valueOf(aSN1ObjectIdentifier)));
    }
}
