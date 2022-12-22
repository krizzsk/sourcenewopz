package com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import org.bouncycastle.pqc.crypto.gmss.GMSSKeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceFujisakiCipher;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;

public interface PQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier Cardinal = KeyAgreementSpi.DHUwithSHA384KDF.getSDKVersion;
    public static final ASN1ObjectIdentifier CardinalActionCode = KeyAgreementSpi.DHUwithSHA384KDF.setEnableDFSync;
    public static final ASN1ObjectIdentifier CardinalEnvironment = KeyAgreementSpi.DHUwithSHA384KDF.setUICustomization;
    public static final ASN1ObjectIdentifier CardinalError = KeyAgreementSpi.DHUwithSHA384KDF.valueOf;
    public static final ASN1ObjectIdentifier CardinalRenderType = KeyAgreementSpi.DHUwithSHA384KDF.getThreeDSRequestorAppURL;
    public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    public static final ASN1ObjectIdentifier cleanup = KeyAgreementSpi.DHUwithSHA384KDF.getUICustomization;
    public static final ASN1ObjectIdentifier configure;
    public static final ASN1ObjectIdentifier getInstance;
    public static final ASN1ObjectIdentifier getSDKVersion = KeyAgreementSpi.DHUwithSHA384KDF.isEnableDFSync;
    public static final ASN1ObjectIdentifier getWarnings = KeyAgreementSpi.DHUwithSHA384KDF.getEnvironment;
    public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    public static final ASN1ObjectIdentifier values = KeyAgreementSpi.DHUwithSHA384KDF.setThreeDSRequestorAppURL;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        getInstance = aSN1ObjectIdentifier;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
        new ASN1ObjectIdentifier(getInstance, "2");
        new ASN1ObjectIdentifier(getInstance, "3");
        new ASN1ObjectIdentifier(getInstance, "4");
        new ASN1ObjectIdentifier(getInstance, "5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(GMSSKeyPairGenerator.OID);
        configure = aSN1ObjectIdentifier2;
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        new ASN1ObjectIdentifier(configure, "2");
        new ASN1ObjectIdentifier(configure, "3");
        new ASN1ObjectIdentifier(configure, "4");
        new ASN1ObjectIdentifier(configure, "5");
        new ASN1ObjectIdentifier(McElieceFujisakiCipher.OID);
        new ASN1ObjectIdentifier(McEliecePointchevalCipher.OID);
        new ASN1ObjectIdentifier(McElieceKobaraImaiCipher.OID);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = KeyAgreementSpi.DHUwithSHA384KDF.getWarnings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = KeyAgreementSpi.DHUwithSHA384KDF.CardinalError;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = KeyAgreementSpi.DHUwithSHA384KDF.CardinalEnvironment;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = KeyAgreementSpi.DHUwithSHA384KDF.CardinalRenderType;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = KeyAgreementSpi.DHUwithSHA384KDF.CardinalActionCode;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = KeyAgreementSpi.DHUwithSHA384KDF.CardinalUiType;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = KeyAgreementSpi.DHUwithSHA384KDF.getRequestTimeout;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = KeyAgreementSpi.DHUwithSHA384KDF.getString;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = KeyAgreementSpi.DHUwithSHA384KDF.CardinalConfigurationParameters;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = KeyAgreementSpi.DHUwithSHA384KDF.getActionCode;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = KeyAgreementSpi.DHUwithSHA384KDF.setRequestTimeout;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = KeyAgreementSpi.DHUwithSHA384KDF.getChallengeTimeout;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = KeyAgreementSpi.DHUwithSHA384KDF.setChallengeTimeout;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = KeyAgreementSpi.DHUwithSHA384KDF.getProxyAddress;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = KeyAgreementSpi.DHUwithSHA384KDF.setEnvironment;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = KeyAgreementSpi.DHUwithSHA384KDF.getRenderType;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = KeyAgreementSpi.DHUwithSHA384KDF.setRenderType;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = KeyAgreementSpi.DHUwithSHA384KDF.getUiType;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = KeyAgreementSpi.DHUwithSHA384KDF.setProxyAddress;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = KeyAgreementSpi.DHUwithSHA384KDF.setUiType;
    }
}
