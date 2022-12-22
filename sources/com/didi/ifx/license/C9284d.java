package com.didi.ifx.license;

import com.facebook.internal.security.OidcSecurityUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.didi.ifx.license.d */
/* compiled from: RSAUtils */
class C9284d {
    C9284d() {
    }

    /* renamed from: a */
    static boolean m17459a(byte[] bArr, String str, String str2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C9281a.m17450b(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----\n", "").getBytes())));
        Signature instance = Signature.getInstance(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256);
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(C9281a.m17450b(str2.getBytes()));
    }
}
