package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import com.cardinalcommerce.p060a.setIndeterminateDrawable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class AAD {
    /* renamed from: a */
    private static byte[] m2214a(Base64URL base64URL) {
        return base64URL.toString().getBytes(Charset.forName("ASCII"));
    }

    public static byte[] cca_continue(byte[] bArr) throws setIndeterminateDrawable {
        return ByteBuffer.allocate(8).putLong((long) ByteUtils.Cardinal(bArr)).array();
    }

    public static byte[] configure(JWEHeader jWEHeader) {
        Base64URL base64URL;
        if (jWEHeader.getInstance == null) {
            base64URL = Base64URL.init(jWEHeader.toString());
        } else {
            base64URL = jWEHeader.getInstance;
        }
        return m2214a(base64URL);
    }
}
