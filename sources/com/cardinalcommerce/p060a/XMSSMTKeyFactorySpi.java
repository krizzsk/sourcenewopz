package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cardinalcommerce.a.XMSSMTKeyFactorySpi */
public final class XMSSMTKeyFactorySpi {

    /* renamed from: a */
    private static Set f2491a = new HashSet();

    /* renamed from: b */
    private static Set f2492b = new HashSet();

    /* renamed from: c */
    private static Set f2493c = new HashSet();

    /* renamed from: d */
    private static Set f2494d = new HashSet();

    /* renamed from: e */
    private static Set f2495e = new HashSet();

    /* renamed from: f */
    private static Set f2496f = new HashSet();

    /* renamed from: g */
    private static Set f2497g = new HashSet();

    /* renamed from: h */
    private static Set f2498h = new HashSet();

    /* renamed from: i */
    private static Set f2499i = new HashSet();

    /* renamed from: j */
    private static Set f2500j = new HashSet();

    /* renamed from: k */
    private static Set f2501k = new HashSet();

    /* renamed from: l */
    private static Set f2502l = new HashSet();

    /* renamed from: m */
    private static Map f2503m = new HashMap();

    public static ASN1ObjectIdentifier configure(String str) {
        return (ASN1ObjectIdentifier) f2503m.get(str);
    }

    public static boolean init(String str, String str2) {
        if (f2492b.contains(str) && f2492b.contains(str2)) {
            return true;
        }
        if (f2493c.contains(str) && f2493c.contains(str2)) {
            return true;
        }
        if (f2494d.contains(str) && f2494d.contains(str2)) {
            return true;
        }
        if (f2495e.contains(str) && f2495e.contains(str2)) {
            return true;
        }
        if (f2496f.contains(str) && f2496f.contains(str2)) {
            return true;
        }
        if (f2497g.contains(str) && f2497g.contains(str2)) {
            return true;
        }
        if (f2498h.contains(str) && f2498h.contains(str2)) {
            return true;
        }
        if (f2499i.contains(str) && f2499i.contains(str2)) {
            return true;
        }
        if (f2500j.contains(str) && f2500j.contains(str2)) {
            return true;
        }
        if (f2501k.contains(str) && f2501k.contains(str2)) {
            return true;
        }
        if (!f2502l.contains(str) || !f2502l.contains(str2)) {
            return f2491a.contains(str) && f2491a.contains(str2);
        }
        return true;
    }

    public static KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal(String str) {
        String Cardinal = setAnimation.Cardinal(str);
        if (f2492b.contains(Cardinal)) {
            return new SignatureSpi.ecNR224();
        }
        if (f2491a.contains(Cardinal)) {
            return new SignatureSpi.ecDetDSA512();
        }
        if (f2493c.contains(Cardinal)) {
            return new SignatureSpi.ecNR256();
        }
        if (f2494d.contains(Cardinal)) {
            return new SignatureSpi.ecNR();
        }
        if (f2495e.contains(Cardinal)) {
            return new SignatureSpi.ecNR384();
        }
        if (f2496f.contains(Cardinal)) {
            return new BCECGOST3410PrivateKey();
        }
        if (f2497g.contains(Cardinal)) {
            return new SignatureSpi.ecPlainDSARP160(224);
        }
        if (f2498h.contains(Cardinal)) {
            return new SignatureSpi.ecPlainDSARP160(256);
        }
        if (f2499i.contains(Cardinal)) {
            return new KeyAgreementSpi.ECVKO(224);
        }
        if (f2500j.contains(Cardinal)) {
            return new KeyAgreementSpi.ECVKO(256);
        }
        if (f2501k.contains(Cardinal)) {
            return new KeyAgreementSpi.ECVKO(384);
        }
        if (f2502l.contains(Cardinal)) {
            return new KeyAgreementSpi.ECVKO(512);
        }
        return null;
    }

    static {
        f2491a.add(MessageDigestAlgorithms.MD5);
        f2491a.add(KeyFactorySpi.getChallengeTimeout.init);
        f2492b.add("SHA1");
        f2492b.add("SHA-1");
        f2492b.add(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError.init);
        f2493c.add("SHA224");
        f2493c.add(McElieceCCA2KeyGenParameterSpec.SHA224);
        f2493c.add(KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion.init);
        f2494d.add("SHA256");
        f2494d.add("SHA-256");
        f2494d.add(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal.init);
        f2495e.add("SHA384");
        f2495e.add("SHA-384");
        f2495e.add(KeyAgreementSpi.MQVwithSHA224KDF.configure.init);
        f2496f.add("SHA512");
        f2496f.add("SHA-512");
        f2496f.add(KeyAgreementSpi.MQVwithSHA224KDF.getInstance.init);
        f2497g.add("SHA512(224)");
        f2497g.add("SHA-512(224)");
        f2497g.add(KeyAgreementSpi.MQVwithSHA224KDF.values.init);
        f2498h.add("SHA512(256)");
        f2498h.add("SHA-512(256)");
        f2498h.add(KeyAgreementSpi.MQVwithSHA224KDF.CardinalError.init);
        f2499i.add("SHA3-224");
        f2499i.add(KeyAgreementSpi.MQVwithSHA224KDF.cleanup.init);
        f2500j.add("SHA3-256");
        f2500j.add(KeyAgreementSpi.MQVwithSHA224KDF.getWarnings.init);
        f2501k.add("SHA3-384");
        f2501k.add(KeyAgreementSpi.MQVwithSHA224KDF.CardinalActionCode.init);
        f2502l.add("SHA3-512");
        f2502l.add(KeyAgreementSpi.MQVwithSHA224KDF.CardinalUiType.init);
        f2503m.put(MessageDigestAlgorithms.MD5, KeyFactorySpi.getChallengeTimeout);
        f2503m.put(KeyFactorySpi.getChallengeTimeout.init, KeyFactorySpi.getChallengeTimeout);
        f2503m.put("SHA1", KeyAgreementSpi.MQVwithSHA512KDF.CardinalError);
        f2503m.put("SHA-1", KeyAgreementSpi.MQVwithSHA512KDF.CardinalError);
        f2503m.put(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError.init, KeyAgreementSpi.MQVwithSHA512KDF.CardinalError);
        f2503m.put("SHA224", KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion);
        f2503m.put(McElieceCCA2KeyGenParameterSpec.SHA224, KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion.init, KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion);
        f2503m.put("SHA256", KeyAgreementSpi.MQVwithSHA224KDF.Cardinal);
        f2503m.put("SHA-256", KeyAgreementSpi.MQVwithSHA224KDF.Cardinal);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal.init, KeyAgreementSpi.MQVwithSHA224KDF.Cardinal);
        f2503m.put("SHA384", KeyAgreementSpi.MQVwithSHA224KDF.configure);
        f2503m.put("SHA-384", KeyAgreementSpi.MQVwithSHA224KDF.configure);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.configure.init, KeyAgreementSpi.MQVwithSHA224KDF.configure);
        f2503m.put("SHA512", KeyAgreementSpi.MQVwithSHA224KDF.getInstance);
        f2503m.put("SHA-512", KeyAgreementSpi.MQVwithSHA224KDF.getInstance);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.getInstance.init, KeyAgreementSpi.MQVwithSHA224KDF.getInstance);
        f2503m.put("SHA512(224)", KeyAgreementSpi.MQVwithSHA224KDF.values);
        f2503m.put("SHA-512(224)", KeyAgreementSpi.MQVwithSHA224KDF.values);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.values.init, KeyAgreementSpi.MQVwithSHA224KDF.values);
        f2503m.put("SHA512(256)", KeyAgreementSpi.MQVwithSHA224KDF.CardinalError);
        f2503m.put("SHA-512(256)", KeyAgreementSpi.MQVwithSHA224KDF.CardinalError);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalError.init, KeyAgreementSpi.MQVwithSHA224KDF.CardinalError);
        f2503m.put("SHA3-224", KeyAgreementSpi.MQVwithSHA224KDF.cleanup);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.cleanup.init, KeyAgreementSpi.MQVwithSHA224KDF.cleanup);
        f2503m.put("SHA3-256", KeyAgreementSpi.MQVwithSHA224KDF.getWarnings);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.getWarnings.init, KeyAgreementSpi.MQVwithSHA224KDF.getWarnings);
        f2503m.put("SHA3-384", KeyAgreementSpi.MQVwithSHA224KDF.CardinalActionCode);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalActionCode.init, KeyAgreementSpi.MQVwithSHA224KDF.CardinalActionCode);
        f2503m.put("SHA3-512", KeyAgreementSpi.MQVwithSHA224KDF.CardinalUiType);
        f2503m.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalUiType.init, KeyAgreementSpi.MQVwithSHA224KDF.CardinalUiType);
    }
}
