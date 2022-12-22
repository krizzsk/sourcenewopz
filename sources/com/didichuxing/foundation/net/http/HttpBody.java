package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.p188io.Deserializer;
import com.didichuxing.foundation.p188io.Streams;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class HttpBody implements HttpEntity {
    public long getContentLength() throws IOException {
        return -1;
    }

    public String getTransferEncoding() {
        return null;
    }

    public static HttpBody newInstance(final MimeType mimeType, final byte[] bArr, final int i, final int i2) {
        return new HttpBody() {
            public void close() throws IOException {
            }

            public InputStream getContent() throws IOException {
                return new ByteArrayInputStream(bArr, i, i2);
            }

            public MimeType getContentType() {
                return mimeType;
            }

            public long getContentLength() throws IOException {
                return (long) i2;
            }
        };
    }

    public static HttpBody newInstance(String str, byte[] bArr, int i, int i2) {
        return newInstance(MimeType.parse(str), bArr, i, i2);
    }

    public static HttpBody newInstance(MimeType mimeType, byte[] bArr) {
        return newInstance(mimeType, bArr, 0, bArr.length);
    }

    public static HttpBody newInstance(String str, byte[] bArr) {
        return newInstance(str, bArr, 0, bArr.length);
    }

    public static HttpBody newInstance(MimeType mimeType, ByteBuffer byteBuffer) {
        return newInstance(mimeType, byteBuffer.array());
    }

    public static HttpBody newInstance(String str, ByteBuffer byteBuffer) {
        return newInstance(str, byteBuffer.array());
    }

    public static HttpBody newInstance(MimeType mimeType, String str) {
        Charset charset = C15559c.f47592e;
        if (mimeType != null && (charset = mimeType.getCharset()) == null) {
            charset = C15559c.f47592e;
            mimeType = MimeType.parse(mimeType + "; charset=utf-8");
        }
        return newInstance(mimeType, str.getBytes(charset));
    }

    public static HttpBody newInstance(String str, String str2) {
        return newInstance(MimeType.parse(str), str2);
    }

    public static HttpBody newInstance(final MimeType mimeType, final File file) {
        return new HttpBody() {
            private FileInputStream mStream;

            public MimeType getContentType() {
                return MimeType.this;
            }

            public InputStream getContent() throws IOException {
                FileInputStream fileInputStream = new FileInputStream(file);
                this.mStream = fileInputStream;
                return fileInputStream;
            }

            public long getContentLength() throws IOException {
                return file.length();
            }

            public void close() throws IOException {
                FileInputStream fileInputStream = this.mStream;
                if (fileInputStream != null) {
                    fileInputStream.close();
                    this.mStream = null;
                }
            }
        };
    }

    public static HttpBody newInstance(String str, File file) {
        return newInstance(MimeType.parse(str), file);
    }

    public Charset getCharset() {
        MimeType contentType = getContentType();
        return contentType == null ? C15559c.f47592e : contentType.getCharset(C15559c.f47592e);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        InputStream content = getContent();
        Streams.copy(content, outputStream);
        Streams.closeQuietly(content);
    }

    public <T> T getContent(Deserializer<T> deserializer) throws IOException {
        return deserializer.deserialize(getContent());
    }
}
