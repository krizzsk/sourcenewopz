package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import com.cardinalcommerce.p060a.setImageState;
import com.cardinalcommerce.p060a.setMaxWidth;
import com.cardinalcommerce.p060a.setTextClassifier;
import java.util.Collection;
import javax.crypto.SecretKey;

public class DirectEncrypter extends setImageState implements setTextClassifier {
    public DirectEncrypter(SecretKey secretKey) throws KeyLengthException {
        super(secretKey);
    }

    public JWECryptoParts Cardinal(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        JWEAlgorithm Cardinal = jWEHeader.Cardinal();
        if (Cardinal.equals(JWEAlgorithm.cleanup)) {
            EncryptionMethod encryptionMethod = jWEHeader.init;
            if (encryptionMethod.Cardinal == ByteUtils.Cardinal(init().getEncoded())) {
                return setMaxWidth.configure(jWEHeader, bArr, init(), (Base64URL) null, cca_continue());
            }
            throw new KeyLengthException(encryptionMethod.Cardinal, encryptionMethod);
        }
        throw new JOSEException(AlgorithmSupportMessage.configure(Cardinal, (Collection<JWEAlgorithm>) Cardinal));
    }
}
