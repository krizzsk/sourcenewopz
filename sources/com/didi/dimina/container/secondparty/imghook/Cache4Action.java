package com.didi.dimina.container.secondparty.imghook;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.imghook.Cache4Action;
import com.didi.dimina.container.secondparty.imghook.DiskLruCache;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import didihttp.CipherSuite;
import didihttp.Handshake;
import didihttp.Headers;
import didihttp.MediaType;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import didihttp.ResponseBody;
import didihttp.TlsVersion;
import didihttp.internal.C20747Util;
import didihttp.internal.cache.CacheRequest;
import didihttp.internal.cache.CacheStrategy;
import didihttp.internal.cache.InternalCache;
import didihttp.internal.http.HttpHeaders;
import didihttp.internal.http.HttpMethod;
import didihttp.internal.http.StatusLine;
import didihttp.internal.p228io.FileSystem;
import didihttp.internal.platform.Platform;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache4Action implements InternalCache, Closeable, Flushable {
    public static final int ENTRY_BODY = 1;

    /* renamed from: c */
    private static final int f17131c = 201105;

    /* renamed from: d */
    private static final int f17132d = 0;

    /* renamed from: e */
    private static final int f17133e = 2;

    /* renamed from: a */
    final DiskLruCache f17134a;

    /* renamed from: b */
    FinishAction f17135b;

    interface FinishAction {
        void onAction(String str, String str2, File file, long j, long j2, String str3);
    }

    public void trackConditionalCacheHit() {
    }

    public void trackResponse(CacheStrategy cacheStrategy) {
    }

    public void setFinishAction(FinishAction finishAction) {
        this.f17135b = finishAction;
    }

    public Cache4Action(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache4Action(File file, long j, FileSystem fileSystem) {
        this.f17134a = DiskLruCache.m12718a(fileSystem, file, f17131c, 2, j);
    }

    public static String key(String str) {
        return ByteString.encodeUtf8(str).md5().hex();
    }

    public Response get(Request request) {
        try {
            DiskLruCache.Snapshot a = this.f17134a.mo55645a(key(request.url().toString()));
            if (a == null) {
                return null;
            }
            try {
                Entry entry = new Entry(a.getSource(0));
                Response response = entry.response(a);
                if (entry.matches(request, response)) {
                    return response;
                }
                C20747Util.closeQuietly((Closeable) response.body());
                return null;
            } catch (IOException unused) {
                C20747Util.closeQuietly((Closeable) a);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.f17134a.mo55650b(key(response.request().url().toString()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(this, editor, response);
                } catch (IOException unused2) {
                    m12717a(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                m12717a(editor);
                return null;
            }
        }
    }

    public void remove(Request request) throws IOException {
        this.f17134a.mo55653c(key(request.url().toString()));
    }

    public void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            m12717a(editor);
        }
    }

    /* renamed from: a */
    private void m12717a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public void delete() throws IOException {
        this.f17134a.mo55660h();
    }

    public long size() throws IOException {
        return this.f17134a.mo55655d();
    }

    public void flush() throws IOException {
        this.f17134a.flush();
    }

    public void close() throws IOException {
        this.f17134a.close();
    }

    static final class CacheRequestImpl implements CacheRequest {
        private static final String dot = ",";
        private final Sink body;
        private final Sink cacheOut;
        boolean done;
        private final DiskLruCache.Editor editor;
        private final Cache4Action host;
        /* access modifiers changed from: private */
        public long imgStreamEndTime = -1;
        String mainUrl;
        String resUrl;

        CacheRequestImpl(Cache4Action cache4Action, DiskLruCache.Editor editor2, Response response) {
            this.host = cache4Action;
            this.resUrl = response.request().url().toString();
            this.mainUrl = response.header("mainUrlFlag");
            this.editor = editor2;
            Sink newSink = editor2.newSink(1);
            this.cacheOut = newSink;
            final Cache4Action cache4Action2 = cache4Action;
            final DiskLruCache.Editor editor3 = editor2;
            final Response response2 = response;
            this.body = new ForwardingSink(newSink) {
                public void close() throws IOException {
                    long unused = CacheRequestImpl.this.imgStreamEndTime = System.currentTimeMillis();
                    synchronized (cache4Action2) {
                        if (!CacheRequestImpl.this.done) {
                            CacheRequestImpl.this.done = true;
                            super.close();
                            editor3.commit();
                            LogUtil.m13410e("CacheRequestImpl", "done done " + CacheRequestImpl.this.resUrl);
                            CacheRequestImpl.this.goImgCheck(response2);
                        }
                    }
                }
            };
        }

        /* access modifiers changed from: private */
        public void goImgCheck(Response response) {
            MediaType contentType;
            if (response.body() == null || (contentType = response.body().contentType()) == null || !C7554b.m12760a(contentType.toString())) {
                Request request = response.request();
                String str = null;
                if (request != null) {
                    str = request.header(com.google.common.net.HttpHeaders.ACCEPT);
                }
                if (TextUtils.isEmpty(str) || !C7554b.m12760a(str)) {
                    return;
                }
            }
            this.host.f17134a.mo55648a((Runnable) new Runnable(response) {
                public final /* synthetic */ Response f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Cache4Action.CacheRequestImpl.this.lambda$goImgCheck$0$Cache4Action$CacheRequestImpl(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$goImgCheck$0$Cache4Action$CacheRequestImpl(Response response) {
            DiskLruCache.Snapshot snapshot;
            try {
                snapshot = this.host.f17134a.mo55645a(Cache4Action.key(this.resUrl));
            } catch (IOException e) {
                e.printStackTrace();
                snapshot = null;
            }
            if (snapshot != null) {
                File file = snapshot.getFile(1);
                if (this.imgStreamEndTime == -1) {
                    this.imgStreamEndTime = response.receivedResponseAtMillis();
                }
                this.host.f17135b.onAction(this.mainUrl, this.resUrl, file, response.body().contentLength(), this.imgStreamEndTime - response.sentRequestAtMillis(), txt4CDN(response));
            }
        }

        private String txt4CDN(Response response) {
            ImgHookConfig config = ImgHookConfig.getConfig();
            if (config == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                String lowerCase = headers.name(i).toLowerCase(Locale.US);
                if (lowerCase.matches(config.f17174d.toLowerCase(Locale.US))) {
                    String value = headers.value(i);
                    sb.append(lowerCase);
                    sb.append(":");
                    sb.append(value.toLowerCase(Locale.US));
                    sb.append(",");
                }
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ",".charAt(0)) {
                int length = sb.length();
                sb.delete(length - 1, length);
            }
            return sb.toString();
        }

        public void abort() {
            synchronized (this.host) {
                if (!this.done) {
                    this.done = true;
                    C20747Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.body;
        }
    }

    private static final class Entry {
        private static final String RECEIVED_MILLIS = (Platform.get().getPrefix() + "-Received-Millis");
        private static final String SENT_MILLIS = (Platform.get().getPrefix() + "-Sent-Millis");
        private final int code;
        private Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        Entry(Source source) throws IOException {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.url = buffer.readUtf8LineStrict();
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int a = Cache4Action.m12716a(buffer);
                for (int i = 0; i < a; i++) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    int indexOf = readUtf8LineStrict.indexOf(":", 1);
                    builder.add(readUtf8LineStrict.substring(0, indexOf), readUtf8LineStrict.substring(indexOf + 1));
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int a2 = Cache4Action.m12716a(buffer);
                for (int i2 = 0; i2 < a2; i2++) {
                    String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
                    int indexOf2 = readUtf8LineStrict2.indexOf(":", 1);
                    builder2.add(readUtf8LineStrict2.substring(0, indexOf2), readUtf8LineStrict2.substring(indexOf2 + 1));
                }
                String str = builder2.get(SENT_MILLIS);
                String str2 = builder2.get(RECEIVED_MILLIS);
                builder2.removeAll(SENT_MILLIS);
                builder2.removeAll(RECEIVED_MILLIS);
                long j = 0;
                this.sentRequestMillis = str != null ? Long.parseLong(str) : 0;
                this.receivedResponseMillis = str2 != null ? Long.parseLong(str2) : j;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict3.length() <= 0) {
                        this.handshake = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), readCertificateList(buffer), readCertificateList(buffer));
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict3 + Const.jsQuote);
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                source.close();
            }
        }

        Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.url).writeByte(10);
            buffer.writeUtf8(this.requestMethod).writeByte(10);
            buffer.writeDecimalLong((long) this.varyHeaders.size()).writeByte(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
            buffer.writeDecimalLong((long) (this.responseHeaders.size() + 2)).writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            buffer.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (isHttps()) {
                if (this.handshake == null) {
                    this.handshake = Handshake.get(TlsVersion.TLS_1_1, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, new ArrayList(), new ArrayList());
                }
                buffer.writeByte(10);
                buffer.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
                writeCertList(buffer, this.handshake.peerCertificates());
                writeCertList(buffer, this.handshake.localCertificates());
                buffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int a = Cache4Action.m12716a(bufferedSource);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.m3607of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && HttpHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, (RequestBody) null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }
    }

    /* renamed from: a */
    static int m12716a(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + Const.jsQuote);
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        final DiskLruCache.Snapshot snapshot;

        CacheResponseBody(final DiskLruCache.Snapshot snapshot2, String str, String str2) {
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer((Source) new ForwardingSource(snapshot2.getSource(1)) {
                public void close() throws IOException {
                    snapshot2.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public long contentLength() {
            try {
                if (this.contentLength != null) {
                    return Long.parseLong(this.contentLength);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }
}
