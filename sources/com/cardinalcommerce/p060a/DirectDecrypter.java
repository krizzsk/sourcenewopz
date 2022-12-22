package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.IESCipher;
import java.io.IOException;
import java.security.Principal;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.DirectDecrypter */
public final class DirectDecrypter extends IESCipher.ECIESwithAESCBC implements Principal {
    public DirectDecrypter(DSASigner.dsaSha3_224 dsasha3_224) {
        super((setThreeDSRequestorAppURL) dsasha3_224.values());
    }

    public final byte[] getEncoded() {
        try {
            return init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public final String getName() {
        return toString();
    }
}
