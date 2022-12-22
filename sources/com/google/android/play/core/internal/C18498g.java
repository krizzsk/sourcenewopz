package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* renamed from: com.google.android.play.core.internal.g */
final class C18498g extends C18499h {

    /* renamed from: a */
    private final byte[] f53188a;

    public C18498g(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f53188a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f53188a;
    }
}
