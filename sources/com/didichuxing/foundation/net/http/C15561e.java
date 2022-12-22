package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.didichuxing.foundation.net.http.e */
/* compiled from: InputStreamMultipartBody */
class C15561e extends C15557a {

    /* renamed from: g */
    private final InputStream f47594g;

    public String getTransferEncoding() {
        return "binary";
    }

    public C15561e(InputStream inputStream) {
        this(inputStream, MimeType.APPLICATION_OCTET_STREAM);
    }

    public C15561e(InputStream inputStream, MimeType mimeType) {
        this(inputStream, mimeType, (String) null);
    }

    public C15561e(InputStream inputStream, MimeType mimeType, String str) {
        super(mimeType, str);
        this.f47594g = inputStream;
    }

    public long getContentLength() {
        try {
            return (long) this.f47594g.available();
        } catch (IOException unused) {
            return -1;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = this.f47594g.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            } finally {
                this.f47594g.close();
            }
        }
    }

    /* renamed from: a */
    public InputStream mo117204a() {
        return this.f47594g;
    }

    public InputStream getContent() throws IOException {
        return this.f47594g;
    }

    public void close() throws IOException {
        this.f47594g.close();
    }
}
