package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.cardinalcommerce.a.e */
final class C1994e {

    /* renamed from: a */
    private static final setUiType f2530a = ECGOST.Mappings.Cardinal;

    C1994e() {
    }

    /* renamed from: a */
    private static String m1842a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String Cardinal = JWSAlgorithm.Cardinal(aSN1ObjectIdentifier);
        int indexOf = Cardinal.indexOf(45);
        if (indexOf <= 0 || Cardinal.startsWith("SHA3")) {
            return JWSAlgorithm.Cardinal(aSN1ObjectIdentifier);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Cardinal.substring(0, indexOf));
        sb.append(Cardinal.substring(indexOf + 1));
        return sb.toString();
    }

    /* renamed from: a */
    static void m1843a(Signature signature, getProxyAddress getproxyaddress) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (getproxyaddress != null && !f2530a.equals(getproxyaddress)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(getproxyaddress.values().getEncoded());
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e) {
                        StringBuilder sb = new StringBuilder("Exception extracting parameters: ");
                        sb.append(e.getMessage());
                        throw new SignatureException(sb.toString());
                    }
                }
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder("IOException decoding parameters: ");
                sb2.append(e2.getMessage());
                throw new SignatureException(sb2.toString());
            }
        }
    }

    /* renamed from: a */
    static String m1841a(DSASigner.stdDSA stddsa) {
        getProxyAddress getproxyaddress = stddsa.cca_continue;
        if (getproxyaddress != null && !f2530a.equals(getproxyaddress)) {
            if (stddsa.init.equals(KeyFactorySpi.getSDKVersion)) {
                BCDSAPrivateKey Cardinal = BCDSAPrivateKey.Cardinal(getproxyaddress);
                StringBuilder sb = new StringBuilder();
                sb.append(m1842a(Cardinal.init.init));
                sb.append("withRSAandMGF1");
                return sb.toString();
            } else if (stddsa.init.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalActionCode)) {
                setThreeDSRequestorAppURL cca_continue = setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m1842a((ASN1ObjectIdentifier) cca_continue.Cardinal(0)));
                sb2.append("withECDSA");
                return sb2.toString();
            }
        }
        Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider != null) {
            StringBuilder sb3 = new StringBuilder("Alg.Alias.Signature.");
            sb3.append(stddsa.init.init);
            String property = provider.getProperty(sb3.toString());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            Provider provider2 = providers[i];
            StringBuilder sb4 = new StringBuilder("Alg.Alias.Signature.");
            sb4.append(stddsa.init.init);
            String property2 = provider2.getProperty(sb4.toString());
            if (property2 != null) {
                return property2;
            }
        }
        return stddsa.init.init;
    }
}
