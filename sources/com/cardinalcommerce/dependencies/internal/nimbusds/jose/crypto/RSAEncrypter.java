package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.CardinalEnvironment;
import com.cardinalcommerce.p060a.setBaseline;
import com.cardinalcommerce.p060a.setBaselineAlignBottom;
import com.cardinalcommerce.p060a.setMaxWidth;
import com.cardinalcommerce.p060a.setMeasureWithLargestChildEnabled;
import com.cardinalcommerce.p060a.setTextClassifier;
import com.cardinalcommerce.p060a.valueOf;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import javax.crypto.SecretKey;

public class RSAEncrypter extends setBaselineAlignBottom implements setTextClassifier {

    /* renamed from: a */
    private final RSAPublicKey f3239a;

    /* renamed from: b */
    private final SecretKey f3240b;

    public RSAEncrypter(RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey, (byte) 0);
    }

    private RSAEncrypter(RSAPublicKey rSAPublicKey, byte b) {
        if (rSAPublicKey != null) {
            this.f3239a = rSAPublicKey;
            this.f3240b = null;
            return;
        }
        throw new IllegalArgumentException("The public RSA key must not be null");
    }

    public final JWECryptoParts Cardinal(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        Base64URL base64URL;
        JWEAlgorithm Cardinal = jWEHeader.Cardinal();
        EncryptionMethod encryptionMethod = jWEHeader.init;
        setMeasureWithLargestChildEnabled cca_continue = cca_continue();
        SecretKey init = setMaxWidth.init(encryptionMethod, cca_continue.configure != null ? cca_continue.configure : new SecureRandom());
        if (Cardinal.equals(JWEAlgorithm.init)) {
            base64URL = Base64URL.cca_continue(valueOf.cca_continue(this.f3239a, init, cca_continue().Cardinal));
        } else if (Cardinal.equals(JWEAlgorithm.Cardinal)) {
            base64URL = Base64URL.cca_continue(CardinalEnvironment.configure(this.f3239a, init, cca_continue().Cardinal));
        } else if (Cardinal.equals(JWEAlgorithm.getInstance)) {
            base64URL = Base64URL.cca_continue(setBaseline.cca_continue(this.f3239a, init, cca_continue().Cardinal));
        } else {
            throw new JOSEException(AlgorithmSupportMessage.configure(Cardinal, (Collection<JWEAlgorithm>) configure));
        }
        return setMaxWidth.configure(jWEHeader, bArr, init, base64URL, cca_continue());
    }
}
