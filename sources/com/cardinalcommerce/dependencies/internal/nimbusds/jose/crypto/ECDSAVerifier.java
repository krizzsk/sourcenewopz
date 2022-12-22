package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSVerifier;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setButtonTintList;
import com.cardinalcommerce.p060a.setCropToPadding;
import com.cardinalcommerce.p060a.setScaleType;
import com.cardinalcommerce.p060a.valueOf;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;

public class ECDSAVerifier extends setCropToPadding implements JWSVerifier {

    /* renamed from: a */
    private final setScaleType f3237a;

    /* renamed from: b */
    private final ECPublicKey f3238b;

    public ECDSAVerifier(ECPublicKey eCPublicKey) throws JOSEException {
        this(eCPublicKey, (byte) 0);
    }

    public final boolean configure(setButtonTintList setbuttontintlist, byte[] bArr, Base64URL base64URL) throws JOSEException {
        JWSAlgorithm instance = setbuttontintlist.getInstance();
        if (!getInstance().contains(instance)) {
            throw new JOSEException(AlgorithmSupportMessage.init(instance, getInstance()));
        } else if (!this.f3237a.cca_continue(setbuttontintlist)) {
            return false;
        } else {
            try {
                byte[] init = valueOf.init(base64URL.cca_continue());
                Signature instance2 = valueOf.getInstance(instance, Cardinal().Cardinal);
                try {
                    instance2.initVerify(this.f3238b);
                    instance2.update(bArr);
                    return instance2.verify(init);
                } catch (InvalidKeyException e) {
                    StringBuilder sb = new StringBuilder("Invalid EC public key: ");
                    sb.append(e.getMessage());
                    throw new JOSEException(sb.toString(), e);
                } catch (SignatureException unused) {
                    return false;
                }
            } catch (JOSEException unused2) {
                return false;
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ECDSAVerifier(java.security.interfaces.ECPublicKey r2, byte r3) throws com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException {
        /*
            r1 = this;
            java.security.spec.ECParameterSpec r3 = r2.getParams()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve.Cardinal((java.security.spec.ECParameterSpec) r3)
            if (r3 == 0) goto L_0x0088
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve r0 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve.getInstance
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0015
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.getWarnings
            goto L_0x0035
        L_0x0015:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve r0 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve.Cardinal
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0020
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.CardinalError
            goto L_0x0035
        L_0x0020:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve r0 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve.init
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x002b
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.values
            goto L_0x0035
        L_0x002b:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve r0 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve.cca_continue
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0078
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.cleanup
        L_0x0035:
            r1.<init>(r3)
            com.cardinalcommerce.a.setScaleType r3 = new com.cardinalcommerce.a.setScaleType
            r3.<init>()
            r1.f3237a = r3
            r1.f3238b = r2
            java.util.Set r3 = r1.getInstance()
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r3 = r3.next()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = (com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm) r3
            java.util.Set r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve.Cardinal((com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm) r3)
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r3 = r3.next()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve r3 = (com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve) r3
            java.security.spec.ECParameterSpec r3 = com.cardinalcommerce.p060a.setDividerDrawable.Cardinal(r3)
            boolean r2 = com.cardinalcommerce.p060a.valueOf.configure((java.security.interfaces.ECPublicKey) r2, (java.security.spec.ECParameterSpec) r3)
            if (r2 == 0) goto L_0x0070
            com.cardinalcommerce.a.setScaleType r2 = r1.f3237a
            java.util.Set r3 = java.util.Collections.emptySet()
            r2.getInstance = r3
            return
        L_0x0070:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException r2 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException
            java.lang.String r3 = "Curve / public key parameters mismatch"
            r2.<init>(r3)
            throw r2
        L_0x0078:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException r2 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = "Unexpected curve: "
            java.lang.String r3 = r0.concat(r3)
            r2.<init>(r3)
            throw r2
        L_0x0088:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException r2 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException
            java.lang.String r3 = "The EC key curve is not supported, must be P-256, P-384 or P-521"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.ECDSAVerifier.<init>(java.security.interfaces.ECPublicKey, byte):void");
    }
}
