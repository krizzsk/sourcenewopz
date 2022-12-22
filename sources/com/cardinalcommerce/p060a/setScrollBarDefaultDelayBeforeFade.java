package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cardinalcommerce.a.setScrollBarDefaultDelayBeforeFade */
public final class setScrollBarDefaultDelayBeforeFade implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public CipherSpi.PKCS1v1_5Padding cca_continue;
    public CipherSpi.PKCS1v1_5Padding init;

    setScrollBarDefaultDelayBeforeFade() {
    }

    static DSASigner.stdDSA getInstance(String str) {
        if (str.equals("SHA-1")) {
            return new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError, ECGOST.Mappings.Cardinal);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
            return new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion, ECGOST.Mappings.Cardinal);
        }
        if (str.equals("SHA-256")) {
            return new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal, ECGOST.Mappings.Cardinal);
        }
        if (str.equals("SHA-384")) {
            return new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.configure, ECGOST.Mappings.Cardinal);
        }
        if (str.equals("SHA-512")) {
            return new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA224KDF.getInstance, ECGOST.Mappings.Cardinal);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: ".concat(String.valueOf(str)));
    }

    public static KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getInstance(DSASigner.stdDSA stddsa) {
        if (stddsa.init.equals(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError)) {
            return new SignatureSpi.ecNR224();
        }
        if (stddsa.init.equals(KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion)) {
            return new SignatureSpi.ecNR256();
        }
        if (stddsa.init.equals(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal)) {
            return new SignatureSpi.ecNR();
        }
        if (stddsa.init.equals(KeyAgreementSpi.MQVwithSHA224KDF.configure)) {
            return new SignatureSpi.ecNR384();
        }
        if (stddsa.init.equals(KeyAgreementSpi.MQVwithSHA224KDF.getInstance)) {
            return new BCECGOST3410PrivateKey();
        }
        StringBuilder sb = new StringBuilder("unrecognised OID in digest algorithm identifier: ");
        sb.append(stddsa.init);
        throw new IllegalArgumentException(sb.toString());
    }

    public setScrollBarDefaultDelayBeforeFade(CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding, CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding2) {
        if (pKCS1v1_5Padding == null) {
            throw new NullPointerException("staticPublicKey cannot be null");
        } else if (pKCS1v1_5Padding2 == null) {
            throw new NullPointerException("ephemeralPublicKey cannot be null");
        } else if (pKCS1v1_5Padding.configure.equals(pKCS1v1_5Padding2.configure)) {
            this.cca_continue = pKCS1v1_5Padding;
            this.init = pKCS1v1_5Padding2;
        } else {
            throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
        }
    }
}
