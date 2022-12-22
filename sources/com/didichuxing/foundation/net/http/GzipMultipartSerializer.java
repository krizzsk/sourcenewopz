package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.MultipartBody;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.util.Introspector;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public class GzipMultipartSerializer extends AbstractSerializer<Object> {

    /* renamed from: a */
    private final MultipartBody.Builder f47572a = new MultipartBody.Builder();

    public InputStream serialize(Object obj) throws IOException {
        Map<String, Object> map;
        if (obj instanceof Map) {
            if (obj instanceof TreeMap) {
                map = new TreeMap<>();
            } else if (obj instanceof LinkedHashMap) {
                map = new LinkedHashMap<>();
            } else {
                map = new HashMap<>();
            }
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                map.put(String.valueOf(entry.getKey()), entry.getValue());
            }
        } else {
            map = Introspector.properties(obj, true);
        }
        MultipartBody.Builder newBuilder = this.f47572a.build().newBuilder();
        for (Map.Entry next : map.entrySet()) {
            newBuilder.addPart(m34042a((String) next.getKey(), next.getValue()));
        }
        return newBuilder.build().getContent();
    }

    /* renamed from: a */
    private MultipartBody.Part m34042a(String str, Object obj) throws IOException {
        HttpHeader parse = HttpHeaders.parse("Content-Encoding: gzip");
        if (obj instanceof byte[]) {
            return new MultipartBody.Part(str, m34047a((byte[]) obj), parse);
        } else if (obj instanceof File) {
            return new MultipartBody.Part(str, m34044a((File) obj), parse);
        } else if (obj instanceof InputStream) {
            return new MultipartBody.Part(str, m34045a((InputStream) obj), parse);
        } else if (obj instanceof MultipartEntity) {
            return new MultipartBody.Part(str, m34043a((MultipartEntity) obj), parse);
        } else {
            return new MultipartBody.Part(str, m34046a(obj), parse);
        }
    }

    /* renamed from: a */
    private MultipartEntity m34046a(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        Okio.buffer((Sink) new GzipSink(buffer)).writeUtf8(String.valueOf(obj)).close();
        return new C15558b(buffer.readByteArray(), MimeType.TEXT_PLAIN);
    }

    public String getBoundary() {
        return this.f47572a.getBoundary();
    }

    /* renamed from: a */
    private MultipartEntity m34047a(byte[] bArr) throws IOException {
        Buffer buffer = new Buffer();
        Okio.buffer((Sink) new GzipSink(buffer)).write(bArr).close();
        return new C15558b(buffer.readByteArray());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private MultipartEntity m34044a(File file) throws IOException {
        final Buffer buffer = new Buffer();
        BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Streams.copy(fileInputStream, buffer2.outputStream());
            buffer2.close();
            Streams.closeQuietly(fileInputStream);
            return new C15560d(file) {
                public long getContentLength() {
                    return -1;
                }

                public void writeTo(OutputStream outputStream) throws IOException {
                    Streams.copy(buffer.inputStream(), outputStream);
                }

                public InputStream getContent() throws IOException {
                    return buffer.inputStream();
                }

                public void close() throws IOException {
                    buffer.close();
                }
            };
        } catch (Throwable th) {
            Streams.closeQuietly(fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private MultipartEntity m34045a(InputStream inputStream) throws IOException {
        Buffer buffer = new Buffer();
        BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
        Streams.copy(inputStream, buffer2.outputStream());
        buffer2.close();
        return new C15561e(buffer.inputStream());
    }

    /* renamed from: a */
    private MultipartEntity m34043a(final MultipartEntity multipartEntity) {
        return new MultipartEntity() {
            public long getContentLength() throws IOException {
                return -1;
            }

            public void writeTo(OutputStream outputStream) throws IOException {
                InputStream content = getContent();
                try {
                    Streams.copy(content, outputStream);
                } finally {
                    Streams.closeQuietly(content);
                }
            }

            public String getTransferEncoding() {
                return multipartEntity.getTransferEncoding();
            }

            public MimeType getContentType() {
                return multipartEntity.getContentType();
            }

            public InputStream getContent() throws IOException {
                Buffer buffer = new Buffer();
                BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
                multipartEntity.writeTo(buffer2.outputStream());
                buffer2.close();
                return buffer.inputStream();
            }

            public Charset getCharset() {
                return multipartEntity.getCharset();
            }

            public void close() throws IOException {
                multipartEntity.close();
            }

            public String getFilename() {
                return multipartEntity.getFilename();
            }
        };
    }
}
