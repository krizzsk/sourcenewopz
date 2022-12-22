package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface AsymmetricKeyInfoConverter {
    PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException;

    PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException;
}
