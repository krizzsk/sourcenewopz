package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setChecked;
import com.cardinalcommerce.p060a.setImageState;
import com.cardinalcommerce.p060a.setMaxWidth;
import com.cardinalcommerce.p060a.setScaleType;
import java.util.Collection;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DirectDecrypter extends setImageState implements setChecked {

    /* renamed from: a */
    private final boolean f3235a;

    /* renamed from: b */
    private final setScaleType f3236b;

    private DirectDecrypter(SecretKey secretKey) throws KeyLengthException {
        super(secretKey);
        this.f3236b = new setScaleType();
        this.f3235a = false;
    }

    public DirectDecrypter(byte[] bArr) throws KeyLengthException {
        this((SecretKey) new SecretKeySpec(bArr, "AES"));
    }

    public final byte[] configure(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) throws JOSEException {
        JWEAlgorithm Cardinal = jWEHeader.Cardinal();
        if (!Cardinal.equals(JWEAlgorithm.cleanup)) {
            throw new JOSEException(AlgorithmSupportMessage.configure(Cardinal, (Collection<JWEAlgorithm>) Cardinal));
        } else if (base64URL != null) {
            throw new JOSEException("Unexpected present JWE encrypted key");
        } else if (base64URL2 == null) {
            throw new JOSEException("Unexpected present JWE initialization vector (IV)");
        } else if (base64URL4 == null) {
            throw new JOSEException("Missing JWE authentication tag");
        } else if (this.f3236b.cca_continue(jWEHeader)) {
            return setMaxWidth.init(jWEHeader, base64URL2, base64URL3, base64URL4, init(), cca_continue());
        } else {
            throw new JOSEException("Unsupported critical header parameter(s)");
        }
    }
}
