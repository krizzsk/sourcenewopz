package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.a.JOSEException */
public final class JOSEException implements AlgorithmParameterSpec {
    public final ASN1ObjectIdentifier Cardinal;
    public final ASN1ObjectIdentifier getInstance;
    public final ASN1ObjectIdentifier init;

    private JOSEException(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.getInstance = aSN1ObjectIdentifier;
        this.init = aSN1ObjectIdentifier2;
        this.Cardinal = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JOSEException(String str) {
        this(KeyAgreementSpi.DHwithRFC2631KDF.configure(str), str.indexOf("12-512") > 0 ? DSASigner.detDSA224.cca_continue : str.indexOf("12-256") > 0 ? DSASigner.detDSA224.configure : KeyAgreementSpi.DHUwithSHA512CKDF.CardinalError);
    }
}
