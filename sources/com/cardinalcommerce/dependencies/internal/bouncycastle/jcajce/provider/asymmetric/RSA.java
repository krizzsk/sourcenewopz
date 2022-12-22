package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class RSA {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, String> f3141a;

    static {
        HashMap hashMap = new HashMap();
        f3141a = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.interfaces.RSAPublicKey|javax.crypto.interfaces.RSAPrivateKey");
        f3141a.put("SupportedKeyFormats", "PKCS#8|X.509");
    }

    public static class Mappings extends RainbowKeyFactorySpi {
        private static void configure(McElieceKeyFactorySpi mcElieceKeyFactorySpi, String str, String str2) {
            StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
            sb.append(str);
            sb.append("withRSA/PSS");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("WITHRSAANDMGF1");
            mcElieceKeyFactorySpi.init(obj, sb2.toString());
            StringBuilder sb3 = new StringBuilder("Alg.Alias.Signature.");
            sb3.append(str);
            sb3.append("WithRSA/PSS");
            String obj2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("WITHRSAANDMGF1");
            mcElieceKeyFactorySpi.init(obj2, sb4.toString());
            StringBuilder sb5 = new StringBuilder("Alg.Alias.Signature.");
            sb5.append(str);
            sb5.append("withRSAandMGF1");
            String obj3 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            sb6.append("WITHRSAANDMGF1");
            mcElieceKeyFactorySpi.init(obj3, sb6.toString());
            StringBuilder sb7 = new StringBuilder("Alg.Alias.Signature.");
            sb7.append(str);
            sb7.append("WithRSAAndMGF1");
            String obj4 = sb7.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str);
            sb8.append("WITHRSAANDMGF1");
            mcElieceKeyFactorySpi.init(obj4, sb8.toString());
            StringBuilder sb9 = new StringBuilder("Signature.");
            sb9.append(str);
            sb9.append("WITHRSAANDMGF1");
            mcElieceKeyFactorySpi.init(sb9.toString(), str2);
        }

        private static void getInstance(McElieceKeyFactorySpi mcElieceKeyFactorySpi, String str, String str2) {
            StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
            sb.append(str);
            sb.append("withRSA/ISO9796-2");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("WITHRSA/ISO9796-2");
            mcElieceKeyFactorySpi.init(obj, sb2.toString());
            StringBuilder sb3 = new StringBuilder("Alg.Alias.Signature.");
            sb3.append(str);
            sb3.append("WithRSA/ISO9796-2");
            String obj2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("WITHRSA/ISO9796-2");
            mcElieceKeyFactorySpi.init(obj2, sb4.toString());
            StringBuilder sb5 = new StringBuilder("Signature.");
            sb5.append(str);
            sb5.append("WITHRSA/ISO9796-2");
            mcElieceKeyFactorySpi.init(sb5.toString(), str2);
        }

        private static void getInstance(McElieceKeyFactorySpi mcElieceKeyFactorySpi, String str, String str2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("WITHRSA");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("withRSA");
            String obj2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("WithRSA");
            String obj3 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("/RSA");
            String obj4 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("WITHRSAENCRYPTION");
            String obj5 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            sb6.append("withRSAEncryption");
            String obj6 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str);
            sb7.append("WithRSAEncryption");
            String obj7 = sb7.toString();
            mcElieceKeyFactorySpi.init("Signature.".concat(String.valueOf(obj)), str2);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj2)), obj);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj3)), obj);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj5)), obj);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj6)), obj);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj7)), obj);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(obj4)), obj);
            if (aSN1ObjectIdentifier != null) {
                mcElieceKeyFactorySpi.init("Alg.Alias.Signature.".concat(String.valueOf(aSN1ObjectIdentifier)), obj);
                mcElieceKeyFactorySpi.init("Alg.Alias.Signature.OID.".concat(String.valueOf(aSN1ObjectIdentifier)), obj);
            }
        }

        private static void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi, String str, String str2) {
            StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
            sb.append(str);
            sb.append("withRSA/X9.31");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("WITHRSA/X9.31");
            mcElieceKeyFactorySpi.init(obj, sb2.toString());
            StringBuilder sb3 = new StringBuilder("Alg.Alias.Signature.");
            sb3.append(str);
            sb3.append("WithRSA/X9.31");
            String obj2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("WITHRSA/X9.31");
            mcElieceKeyFactorySpi.init(obj2, sb4.toString());
            StringBuilder sb5 = new StringBuilder("Signature.");
            sb5.append(str);
            sb5.append("WITHRSA/X9.31");
            mcElieceKeyFactorySpi.init(sb5.toString(), str2);
        }

        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("AlgorithmParameters.OAEP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.PSS", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA3-224WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA3-256WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA3-384WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA3-512WITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            mcElieceKeyFactorySpi.init("Cipher.RSA", (Map<String, String>) RSA.f3141a);
            mcElieceKeyFactorySpi.init("Cipher.RSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            mcElieceKeyFactorySpi.init("Cipher.RSA/RAW", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            mcElieceKeyFactorySpi.init("Cipher.RSA/PKCS1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            mcElieceKeyFactorySpi.cca_continue("Cipher", KeyFactorySpi.configure, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            mcElieceKeyFactorySpi.cca_continue("Cipher", IESCipher.ECIESwithDESedeCBC.f2447d_, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            mcElieceKeyFactorySpi.init("Cipher.RSA/1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            mcElieceKeyFactorySpi.init("Cipher.RSA/2", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            mcElieceKeyFactorySpi.init("Cipher.RSA/OAEP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            mcElieceKeyFactorySpi.cca_continue("Cipher", KeyFactorySpi.cleanup, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            mcElieceKeyFactorySpi.init("Cipher.RSA/ISO9796-1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.RSA//RAW", "RSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            mcElieceKeyFactorySpi.init("KeyFactory.RSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.RSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi keyFactorySpi = new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi();
            configure(mcElieceKeyFactorySpi, KeyFactorySpi.configure, "RSA", keyFactorySpi);
            configure(mcElieceKeyFactorySpi, IESCipher.ECIESwithDESedeCBC.f2447d_, "RSA", keyFactorySpi);
            configure(mcElieceKeyFactorySpi, KeyFactorySpi.cleanup, "RSA", keyFactorySpi);
            configure(mcElieceKeyFactorySpi, KeyFactorySpi.getSDKVersion, "RSA", keyFactorySpi);
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(KeyFactorySpi.configure)), "RSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(IESCipher.ECIESwithDESedeCBC.f2447d_)), "RSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(KeyFactorySpi.cleanup)), "OAEP");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(KeyFactorySpi.getSDKVersion)), "PSS");
            mcElieceKeyFactorySpi.init("Signature.RSASSA-PSS", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            StringBuilder sb = new StringBuilder("Signature.");
            sb.append(KeyFactorySpi.getSDKVersion);
            mcElieceKeyFactorySpi.init(sb.toString(), "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            StringBuilder sb2 = new StringBuilder("Signature.OID.");
            sb2.append(KeyFactorySpi.getSDKVersion);
            mcElieceKeyFactorySpi.init(sb2.toString(), "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            mcElieceKeyFactorySpi.init("Signature.RSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            mcElieceKeyFactorySpi.init("Signature.RAWRSASSA-PSS", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.RAWRSA", "RSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.NONEWITHRSA", "RSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            configure(mcElieceKeyFactorySpi, "SHA224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            configure(mcElieceKeyFactorySpi, "SHA256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            configure(mcElieceKeyFactorySpi, "SHA384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            configure(mcElieceKeyFactorySpi, "SHA512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            configure(mcElieceKeyFactorySpi, "SHA512(224)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA");
            configure(mcElieceKeyFactorySpi, "SHA512(256)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA");
            configure(mcElieceKeyFactorySpi, "SHA3-224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSA");
            configure(mcElieceKeyFactorySpi, "SHA3-256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSA");
            configure(mcElieceKeyFactorySpi, "SHA3-384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSA");
            configure(mcElieceKeyFactorySpi, "SHA3-512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSA");
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", MessageDigestAlgorithms.MD2)) {
                getInstance(mcElieceKeyFactorySpi, MessageDigestAlgorithms.MD2, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", KeyFactorySpi.init);
            }
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", "MD4")) {
                getInstance(mcElieceKeyFactorySpi, "MD4", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", KeyFactorySpi.cca_continue);
            }
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", MessageDigestAlgorithms.MD5)) {
                getInstance(mcElieceKeyFactorySpi, MessageDigestAlgorithms.MD5, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", KeyFactorySpi.getInstance);
                getInstance(mcElieceKeyFactorySpi, MessageDigestAlgorithms.MD5, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
            }
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", "SHA1")) {
                mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
                mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
                configure(mcElieceKeyFactorySpi, "SHA1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
                getInstance(mcElieceKeyFactorySpi, "SHA1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", KeyFactorySpi.getWarnings);
                getInstance(mcElieceKeyFactorySpi, "SHA1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
                StringBuilder sb3 = new StringBuilder("Alg.Alias.Signature.");
                sb3.append(KeyAgreementSpi.MQVwithSHA512KDF.cleanup);
                mcElieceKeyFactorySpi.init(sb3.toString(), "SHA1WITHRSA");
                StringBuilder sb4 = new StringBuilder("Alg.Alias.Signature.OID.");
                sb4.append(KeyAgreementSpi.MQVwithSHA512KDF.cleanup);
                mcElieceKeyFactorySpi.init(sb4.toString(), "SHA1WITHRSA");
                init(mcElieceKeyFactorySpi, "SHA1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption");
            }
            getInstance(mcElieceKeyFactorySpi, "SHA224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", KeyFactorySpi.valueOf);
            getInstance(mcElieceKeyFactorySpi, "SHA256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", KeyFactorySpi.CardinalEnvironment);
            getInstance(mcElieceKeyFactorySpi, "SHA384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", KeyFactorySpi.CardinalUiType);
            getInstance(mcElieceKeyFactorySpi, "SHA512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", KeyFactorySpi.CardinalActionCode);
            getInstance(mcElieceKeyFactorySpi, "SHA512(224)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224", KeyFactorySpi.CardinalRenderType);
            getInstance(mcElieceKeyFactorySpi, "SHA512(256)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256", KeyFactorySpi.getRequestTimeout);
            getInstance(mcElieceKeyFactorySpi, "SHA3-224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_224", KeyAgreementSpi.MQVwithSHA224KDF.getPayment);
            getInstance(mcElieceKeyFactorySpi, "SHA3-256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_256", KeyAgreementSpi.MQVwithSHA224KDF.onValidated);
            getInstance(mcElieceKeyFactorySpi, "SHA3-384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384", KeyAgreementSpi.MQVwithSHA224KDF.CardinalInitService);
            getInstance(mcElieceKeyFactorySpi, "SHA3-512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_512", KeyAgreementSpi.MQVwithSHA224KDF.onSetupCompleted);
            getInstance(mcElieceKeyFactorySpi, "SHA224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption");
            getInstance(mcElieceKeyFactorySpi, "SHA256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption");
            getInstance(mcElieceKeyFactorySpi, "SHA384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption");
            getInstance(mcElieceKeyFactorySpi, "SHA512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption");
            getInstance(mcElieceKeyFactorySpi, "SHA512(224)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption");
            getInstance(mcElieceKeyFactorySpi, "SHA512(256)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption");
            init(mcElieceKeyFactorySpi, "SHA224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption");
            init(mcElieceKeyFactorySpi, "SHA256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption");
            init(mcElieceKeyFactorySpi, "SHA384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption");
            init(mcElieceKeyFactorySpi, "SHA512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption");
            init(mcElieceKeyFactorySpi, "SHA512(224)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption");
            init(mcElieceKeyFactorySpi, "SHA512(256)", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption");
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", "RIPEMD128")) {
                getInstance(mcElieceKeyFactorySpi, "RIPEMD128", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", DSASigner.detDSA512.getSDKVersion);
                getInstance(mcElieceKeyFactorySpi, "RMD128", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", (ASN1ObjectIdentifier) null);
                init(mcElieceKeyFactorySpi, "RMD128", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
                init(mcElieceKeyFactorySpi, "RIPEMD128", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
            }
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", "RIPEMD160")) {
                getInstance(mcElieceKeyFactorySpi, "RIPEMD160", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", DSASigner.detDSA512.getWarnings);
                getInstance(mcElieceKeyFactorySpi, "RMD160", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", (ASN1ObjectIdentifier) null);
                mcElieceKeyFactorySpi.init("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
                mcElieceKeyFactorySpi.init("Signature.RIPEMD160withRSA/ISO9796-2", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
                init(mcElieceKeyFactorySpi, "RMD160", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
                init(mcElieceKeyFactorySpi, "RIPEMD160", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
            }
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", "RIPEMD256")) {
                getInstance(mcElieceKeyFactorySpi, "RIPEMD256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", DSASigner.detDSA512.values);
                getInstance(mcElieceKeyFactorySpi, "RMD256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", (ASN1ObjectIdentifier) null);
            }
            if (mcElieceKeyFactorySpi.cca_continue("MessageDigest", "WHIRLPOOL")) {
                getInstance(mcElieceKeyFactorySpi, "Whirlpool", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                getInstance(mcElieceKeyFactorySpi, "WHIRLPOOL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                init(mcElieceKeyFactorySpi, "Whirlpool", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
                init(mcElieceKeyFactorySpi, "WHIRLPOOL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
            }
        }
    }
}
