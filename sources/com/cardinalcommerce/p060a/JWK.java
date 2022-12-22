package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.cardinalcommerce.a.JWK */
public final class JWK extends Provider implements McElieceKeyFactorySpi {
    private static final String[] Cardinal = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
    private static final String[] CardinalEnvironment = {"DRBG"};
    private static final String[] CardinalError = {"GOST3411", "Keccak", MessageDigestAlgorithms.MD2, "MD4", MessageDigestAlgorithms.MD5, "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564"};
    private static final String[] cca_continue = {"SipHash", "Poly1305"};
    private static final String[] cleanup = {"X509", "IES"};
    private static String configure = "BouncyCastle Security Provider v1.62";
    public static final NHKeyFactorySpi getInstance = new C1993d();
    private static final String[] getSDKVersion = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015"};
    private static final String[] getWarnings = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};
    private static final Map init = new HashMap();
    private static final String[] values = {BouncyCastleProvider.PROVIDER_NAME, "BCFKS", "PKCS12"};

    public JWK() {
        super(BouncyCastleProvider.PROVIDER_NAME, 1.62d, configure);
        AccessController.doPrivileged(new PrivilegedAction() {
            public final Object run() {
                JWK.init(JWK.this);
                return null;
            }
        });
    }

    private static AsymmetricKeyInfoConverter cca_continue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        synchronized (init) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) init.get(aSN1ObjectIdentifier);
        }
        return asymmetricKeyInfoConverter;
    }

    private void init(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(strArr[i]);
            sb.append("$Mappings");
            Class instance = ClassUtil.getInstance(JWK.class, sb.toString());
            if (instance != null) {
                try {
                    ((AlgorithmProvider) instance.newInstance()).init(this);
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder("cannot create instance of ");
                    sb2.append(str);
                    sb2.append(strArr[i]);
                    sb2.append("$Mappings : ");
                    sb2.append(e);
                    throw new InternalError(sb2.toString());
                }
            }
        }
    }

    public final void cca_continue(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(aSN1ObjectIdentifier);
        init(sb.toString(), str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".OID.");
        sb2.append(aSN1ObjectIdentifier);
        init(sb2.toString(), str2);
    }

    public final boolean cca_continue(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        if (containsKey(sb.toString())) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder("Alg.Alias.");
        sb2.append(str);
        sb2.append(".");
        sb2.append(str2);
        return containsKey(sb2.toString());
    }

    public final void init(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        synchronized (init) {
            init.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    public final void init(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder("duplicate provider key (");
        sb.append(str);
        sb.append(") found");
        throw new IllegalStateException(sb.toString());
    }

    public final void init(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(next);
            String obj = sb.toString();
            if (!containsKey(obj)) {
                put(obj, map.get(next));
            } else {
                StringBuilder sb2 = new StringBuilder("duplicate provider attribute key (");
                sb2.append(obj);
                sb2.append(") found");
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public static PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter cca_continue2 = cca_continue(subjectPublicKeyInfo.init.init);
        if (cca_continue2 == null) {
            return null;
        }
        return cca_continue2.getInstance(subjectPublicKeyInfo);
    }

    public static PrivateKey configure(PrivateKeyInfo privateKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter cca_continue2 = cca_continue(privateKeyInfo.cca_continue.init);
        if (cca_continue2 == null) {
            return null;
        }
        return cca_continue2.cca_continue(privateKeyInfo);
    }

    static /* synthetic */ void init(JWK jwk) {
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.digest.", CardinalError);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.symmetric.", Cardinal);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.symmetric.", cca_continue);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.symmetric.", getSDKVersion);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.", cleanup);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.", getWarnings);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.keystore.", values);
        jwk.init("com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.drbg.", CardinalEnvironment);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.Cardinal;
        Sphincs256KeyFactorySpi sphincs256KeyFactorySpi = new Sphincs256KeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier, sphincs256KeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PQCObjectIdentifiers.values;
        NHKeyFactorySpi nHKeyFactorySpi = new NHKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier2, nHKeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PQCObjectIdentifiers.CardinalError;
        XMSSKeyFactorySpi xMSSKeyFactorySpi = new XMSSKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier3, xMSSKeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PQCObjectIdentifiers.getWarnings;
        XMSSMTKeyFactorySpi xMSSMTKeyFactorySpi = new XMSSMTKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier4, xMSSMTKeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PQCObjectIdentifiers.init;
        McElieceKeyFactorySpi mcElieceKeyFactorySpi = new McElieceKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier5, mcElieceKeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PQCObjectIdentifiers.cca_continue;
        McElieceCCA2KeyFactorySpi mcElieceCCA2KeyFactorySpi = new McElieceCCA2KeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier6, mcElieceCCA2KeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PQCObjectIdentifiers.getInstance;
        RainbowKeyFactorySpi rainbowKeyFactorySpi = new RainbowKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier7, rainbowKeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PQCObjectIdentifiers.getSDKVersion;
        QTESLAKeyFactorySpi qTESLAKeyFactorySpi = new QTESLAKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier8, qTESLAKeyFactorySpi);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PQCObjectIdentifiers.cleanup;
        QTESLAKeyFactorySpi qTESLAKeyFactorySpi2 = new QTESLAKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier9, qTESLAKeyFactorySpi2);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = PQCObjectIdentifiers.CardinalRenderType;
        QTESLAKeyFactorySpi qTESLAKeyFactorySpi3 = new QTESLAKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier10, qTESLAKeyFactorySpi3);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = PQCObjectIdentifiers.CardinalActionCode;
        QTESLAKeyFactorySpi qTESLAKeyFactorySpi4 = new QTESLAKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier11, qTESLAKeyFactorySpi4);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = PQCObjectIdentifiers.CardinalEnvironment;
        QTESLAKeyFactorySpi qTESLAKeyFactorySpi5 = new QTESLAKeyFactorySpi();
        synchronized (init) {
            init.put(aSN1ObjectIdentifier12, qTESLAKeyFactorySpi5);
        }
        jwk.put("X509Store.CERTIFICATE/COLLECTION", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreCertCollection");
        jwk.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        jwk.put("X509Store.CRL/COLLECTION", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreCRLCollection");
        jwk.put("X509Store.CERTIFICATEPAIR/COLLECTION", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreCertPairCollection");
        jwk.put("X509Store.CERTIFICATE/LDAP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreLDAPCerts");
        jwk.put("X509Store.CRL/LDAP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        jwk.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        jwk.put("X509Store.CERTIFICATEPAIR/LDAP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        jwk.put("X509StreamParser.CERTIFICATE", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509CertParser");
        jwk.put("X509StreamParser.ATTRIBUTECERTIFICATE", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509AttrCertParser");
        jwk.put("X509StreamParser.CRL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509CRLParser");
        jwk.put("X509StreamParser.CERTIFICATEPAIR", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509CertPairParser");
        jwk.put("Cipher.BROKENPBEWITHMD5ANDDES", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        jwk.put("Cipher.BROKENPBEWITHSHA1ANDDES", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        jwk.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        jwk.put("CertPathValidator.RFC3281", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        jwk.put("CertPathBuilder.RFC3281", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        jwk.put("CertPathValidator.RFC3280", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        jwk.put("CertPathBuilder.RFC3280", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        jwk.put("CertPathValidator.PKIX", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        jwk.put("CertPathBuilder.PKIX", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        jwk.put("CertStore.Collection", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.CertStoreCollectionSpi");
        jwk.put("CertStore.LDAP", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        jwk.put("CertStore.Multi", "com.cardinalcommerce.dependencies.internal.bouncycastle.jce.provider.MultiCertStoreSpi");
        jwk.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }
}
