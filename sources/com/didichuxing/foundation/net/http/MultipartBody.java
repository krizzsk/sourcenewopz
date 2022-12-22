package com.didichuxing.foundation.net.http;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.p188io.CountingOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MultipartBody extends HttpBody {

    /* renamed from: a */
    private static final String f47574a = "--";

    /* renamed from: b */
    private static final String f47575b = "\r\n";

    /* renamed from: c */
    private static final char[] f47576c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: d */
    private static final String f47577d = "Content-Disposition";

    /* renamed from: e */
    private static final String f47578e = "Content-Type";

    /* renamed from: f */
    private static final String f47579f = "Content-Transfer-Encoding";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Charset f47580g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f47581h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final List<Part> f47582i;

    /* renamed from: j */
    private long f47583j;

    public void close() throws IOException {
    }

    /* renamed from: a */
    static String m34049a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = f47576c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static byte[] m34053a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        int remaining = encode.remaining();
        byte[] bArr = new byte[remaining];
        System.arraycopy(encode.array(), 0, bArr, 0, remaining);
        return bArr;
    }

    /* renamed from: a */
    private static void m34052a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private static void m34051a(String str, OutputStream outputStream) throws IOException {
        outputStream.write(m34053a(C15559c.f47591d, str));
    }

    private MultipartBody(Builder builder) {
        this.f47583j = -1;
        this.f47581h = builder.mBoundary != null ? builder.mBoundary : m34049a();
        this.f47580g = builder.mCharset != null ? builder.mCharset : C15559c.f47592e;
        this.f47582i = Collections.unmodifiableList(builder.mParts);
    }

    public String getBoundary() {
        return this.f47581h;
    }

    public Charset getCharset() {
        return this.f47580g;
    }

    public List<Part> getParts() {
        return this.f47582i;
    }

    public MimeType getContentType() {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(this.f47581h);
        if (this.f47580g != null) {
            sb.append("; charset=");
            sb.append(this.f47580g.name());
        }
        return MimeType.parse(sb.toString());
    }

    public InputStream getContent() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public long getContentLength() throws IOException {
        long j = this.f47583j;
        if (-1 != j) {
            return j;
        }
        CountingOutputStream countingOutputStream = new CountingOutputStream(new OutputStream() {
            public void write(int i) throws IOException {
            }
        });
        writeTo(countingOutputStream);
        long bytesWritten = countingOutputStream.getBytesWritten();
        this.f47583j = bytesWritten;
        return bytesWritten;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        m34048a(outputStream);
    }

    /* renamed from: a */
    private long m34048a(OutputStream outputStream) throws IOException {
        byte[] a = m34053a(this.f47580g, this.f47581h);
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        for (Part next : this.f47582i) {
            m34051a(f47574a, (OutputStream) countingOutputStream);
            m34052a(a, (OutputStream) countingOutputStream);
            m34051a("\r\n", (OutputStream) countingOutputStream);
            for (HttpHeader obj : next.getHeaders()) {
                m34051a(obj.toString(), (OutputStream) countingOutputStream);
                m34051a("\r\n", (OutputStream) countingOutputStream);
            }
            long contentLength = next.getBody().getContentLength();
            if (-1 != contentLength) {
                m34051a("Content-Length: " + contentLength, (OutputStream) countingOutputStream);
                m34051a("\r\n", (OutputStream) countingOutputStream);
            }
            m34051a("\r\n", (OutputStream) countingOutputStream);
            next.getBody().writeTo(countingOutputStream);
            m34051a("\r\n", (OutputStream) countingOutputStream);
        }
        m34051a(f47574a, (OutputStream) countingOutputStream);
        m34052a(a, (OutputStream) countingOutputStream);
        m34051a(f47574a, (OutputStream) countingOutputStream);
        m34051a("\r\n", (OutputStream) countingOutputStream);
        return countingOutputStream.getBytesWritten();
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String mBoundary;
        /* access modifiers changed from: private */
        public Charset mCharset;
        /* access modifiers changed from: private */
        public final List<Part> mParts;

        public Builder() {
            this.mCharset = C15559c.f47592e;
            this.mBoundary = MultipartBody.m34049a();
            this.mParts = new ArrayList();
        }

        private Builder(MultipartBody multipartBody) {
            this.mCharset = C15559c.f47592e;
            this.mBoundary = MultipartBody.m34049a();
            this.mParts = new ArrayList();
            this.mCharset = multipartBody.f47580g;
            this.mBoundary = multipartBody.f47581h;
            this.mParts.addAll(multipartBody.f47582i);
        }

        public Charset getCharset() {
            return this.mCharset;
        }

        public Builder setCharset(Charset charset) {
            this.mCharset = charset;
            return this;
        }

        public String getBoundary() {
            return this.mBoundary;
        }

        public Builder setBoundary(String str) {
            this.mBoundary = str;
            return this;
        }

        public Builder addPart(Part part) {
            this.mParts.add(part);
            return this;
        }

        public Builder addPart(String str, MultipartEntity multipartEntity) {
            return addPart(new Part(str, multipartEntity, new HttpHeader[0]));
        }

        public Builder addPart(String str, byte[] bArr) {
            return addPart(str, (MultipartEntity) new C15558b(bArr));
        }

        public Builder addPart(String str, byte[] bArr, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C15558b(bArr, mimeType));
        }

        public Builder addPart(String str, File file) {
            return addPart(str, (MultipartEntity) new C15560d(file));
        }

        public Builder addPart(String str, File file, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C15560d(file, mimeType));
        }

        public Builder addPart(String str, InputStream inputStream) {
            return addPart(str, (MultipartEntity) new C15561e(inputStream));
        }

        public Builder addPart(String str, InputStream inputStream, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C15561e(inputStream, mimeType));
        }

        public Builder addPart(String str, Object obj) {
            return addPart(str, (MultipartEntity) new C15562f(String.valueOf(obj)));
        }

        public Builder addPart(String str, Object obj, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C15562f(String.valueOf(obj), mimeType));
        }

        public MultipartBody build() {
            return new MultipartBody(this);
        }
    }

    public static class Part {
        private final MultipartEntity mBody;
        private final List<HttpHeader> mHeaders;
        private final String mName;

        public Part(String str, MultipartEntity multipartEntity, HttpHeader... httpHeaderArr) {
            this.mName = str;
            this.mBody = multipartEntity;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SimpleHttpHeader("Content-Disposition", generateContentDisposition(multipartEntity)));
            arrayList.add(new SimpleHttpHeader("Content-Type", multipartEntity.getContentType().toString()));
            arrayList.add(new SimpleHttpHeader("Content-Transfer-Encoding", multipartEntity.getTransferEncoding()));
            if (httpHeaderArr != null && httpHeaderArr.length > 0) {
                for (HttpHeader add : httpHeaderArr) {
                    arrayList.add(add);
                }
            }
            this.mHeaders = Collections.unmodifiableList(arrayList);
        }

        public String getName() {
            return this.mName;
        }

        public List<HttpHeader> getHeaders() {
            return this.mHeaders;
        }

        public MultipartEntity getBody() {
            return this.mBody;
        }

        /* access modifiers changed from: protected */
        public String generateContentDisposition(MultipartEntity multipartEntity) {
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=\"");
            sb.append(getName());
            sb.append(Const.jsQuote);
            String filename = multipartEntity.getFilename();
            if (filename != null) {
                sb.append("; filename=\"");
                sb.append(filename);
                sb.append(Const.jsQuote);
            }
            return sb.toString();
        }
    }
}
