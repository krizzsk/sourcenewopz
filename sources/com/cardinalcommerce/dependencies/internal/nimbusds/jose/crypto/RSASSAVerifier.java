package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSVerifier;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.CardinalEnvironment;
import com.cardinalcommerce.p060a.setButtonTintList;
import com.cardinalcommerce.p060a.setScaleType;
import com.cardinalcommerce.p060a.setShowDividers;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.util.Collections;

public class RSASSAVerifier extends setShowDividers implements JWSVerifier {

    /* renamed from: a */
    private final setScaleType f3241a;

    /* renamed from: b */
    private final RSAPublicKey f3242b;

    public RSASSAVerifier(RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey, (byte) 0);
    }

    private RSASSAVerifier(RSAPublicKey rSAPublicKey, byte b) {
        setScaleType setscaletype = new setScaleType();
        this.f3241a = setscaletype;
        if (rSAPublicKey != null) {
            this.f3242b = rSAPublicKey;
            setscaletype.getInstance = Collections.emptySet();
            return;
        }
        throw new IllegalArgumentException("The public RSA key must not be null");
    }

    public final boolean configure(setButtonTintList setbuttontintlist, byte[] bArr, Base64URL base64URL) throws JOSEException {
        if (!this.f3241a.cca_continue(setbuttontintlist)) {
            return false;
        }
        Signature configure = CardinalEnvironment.configure(setbuttontintlist.getInstance(), Cardinal().Cardinal);
        try {
            configure.initVerify(this.f3242b);
            try {
                configure.update(bArr);
                return configure.verify(base64URL.cca_continue());
            } catch (SignatureException unused) {
                return false;
            }
        } catch (InvalidKeyException e) {
            StringBuilder sb = new StringBuilder("Invalid public RSA key: ");
            sb.append(e.getMessage());
            throw new JOSEException(sb.toString(), e);
        }
    }
}
