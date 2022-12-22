package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;

/* renamed from: com.cardinalcommerce.a.setScrollY */
public final class setScrollY {

    /* renamed from: a */
    private static DSASigner.stdDSA f2973a = new DSASigner.stdDSA(PQCObjectIdentifiers.getSDKVersion);

    /* renamed from: b */
    private static DSASigner.stdDSA f2974b = new DSASigner.stdDSA(PQCObjectIdentifiers.cleanup);

    /* renamed from: c */
    private static DSASigner.stdDSA f2975c = new DSASigner.stdDSA(PQCObjectIdentifiers.CardinalRenderType);

    /* renamed from: d */
    private static DSASigner.stdDSA f2976d = new DSASigner.stdDSA(PQCObjectIdentifiers.CardinalActionCode);

    /* renamed from: e */
    private static DSASigner.stdDSA f2977e = new DSASigner.stdDSA(PQCObjectIdentifiers.CardinalEnvironment);

    /* renamed from: f */
    private static DSASigner.stdDSA f2978f = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.getWarnings);

    /* renamed from: g */
    private static DSASigner.stdDSA f2979g = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.CardinalError);

    /* renamed from: h */
    private static DSASigner.stdDSA f2980h = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal);

    /* renamed from: i */
    private static DSASigner.stdDSA f2981i = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.getInstance);

    /* renamed from: j */
    private static DSASigner.stdDSA f2982j = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.valueOf);

    /* renamed from: k */
    private static DSASigner.stdDSA f2983k = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.CardinalRenderType);

    /* renamed from: l */
    private static Map f2984l;

    setScrollY() {
    }

    /* renamed from: a */
    static KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo m2088a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
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

    public static DSASigner.stdDSA cca_continue(int i) {
        if (i == 0) {
            return f2973a;
        }
        if (i == 1) {
            return f2974b;
        }
        if (i == 2) {
            return f2975c;
        }
        if (i == 3) {
            return f2976d;
        }
        if (i == 4) {
            return f2977e;
        }
        throw new IllegalArgumentException("unknown security category: ".concat(String.valueOf(i)));
    }

    public static DSASigner.stdDSA getInstance(String str) {
        if (str.equals("SHA3-256")) {
            return f2978f;
        }
        if (str.equals(SPHINCSKeyParameters.SHA512_256)) {
            return f2979g;
        }
        throw new IllegalArgumentException("unknown tree digest: ".concat(String.valueOf(str)));
    }

    public static DSASigner.stdDSA init(String str) {
        if (str.equals("SHA-256")) {
            return f2980h;
        }
        if (str.equals("SHA-512")) {
            return f2981i;
        }
        if (str.equals("SHAKE128")) {
            return f2982j;
        }
        if (str.equals("SHAKE256")) {
            return f2983k;
        }
        throw new IllegalArgumentException("unknown tree digest: ".concat(String.valueOf(str)));
    }

    /* renamed from: a */
    static int m2087a(DSASigner.stdDSA stddsa) {
        return ((Integer) f2984l.get(stddsa.init)).intValue();
    }

    /* renamed from: a */
    static String m2089a(setSoundEffectsEnabled setsoundeffectsenabled) {
        DSASigner.stdDSA stddsa = setsoundeffectsenabled.cca_continue;
        if (stddsa.init.equals(f2978f.init)) {
            return "SHA3-256";
        }
        if (stddsa.init.equals(f2979g.init)) {
            return SPHINCSKeyParameters.SHA512_256;
        }
        StringBuilder sb = new StringBuilder("unknown tree digest: ");
        sb.append(stddsa.init);
        throw new IllegalArgumentException(sb.toString());
    }

    static {
        HashMap hashMap = new HashMap();
        f2984l = hashMap;
        hashMap.put(PQCObjectIdentifiers.getSDKVersion, 0);
        f2984l.put(PQCObjectIdentifiers.cleanup, 1);
        f2984l.put(PQCObjectIdentifiers.CardinalRenderType, 2);
        f2984l.put(PQCObjectIdentifiers.CardinalActionCode, 3);
        f2984l.put(PQCObjectIdentifiers.CardinalEnvironment, 4);
    }
}
