package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* renamed from: com.didichuxing.foundation.net.http.f */
/* compiled from: StringMultipartBody */
class C15562f extends C15558b {
    public String getTransferEncoding() {
        return C15559c.f47589b;
    }

    /* renamed from: a */
    private static byte[] m34057a(String str, MimeType mimeType) {
        Charset charset = mimeType.getCharset();
        if (charset == null) {
            charset = f47591d;
        }
        String name = charset.name();
        try {
            return str.getBytes(name);
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(name);
        }
    }

    public C15562f(String str) {
        super(m34057a(str, MimeType.TEXT_PLAIN), MimeType.TEXT_PLAIN, (String) null);
    }

    public C15562f(String str, MimeType mimeType) {
        super(m34057a(str, mimeType), mimeType, (String) null);
    }
}
