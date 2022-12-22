package com.koushikdutta.async.http.cache;

import android.net.Uri;
import android.util.Base64;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.SimpleMiddleware;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.Charsets;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.async.util.StreamUtility;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheResponse;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;

public class ResponseCacheMiddleware extends SimpleMiddleware {
    public static final String CACHE = "cache";
    public static final String CONDITIONAL_CACHE = "conditional-cache";
    public static final int ENTRY_BODY = 1;
    public static final int ENTRY_COUNT = 2;
    public static final int ENTRY_METADATA = 0;
    public static final String SERVED_FROM = "X-Served-From";

    /* renamed from: a */
    private static final String f55339a = "AsyncHttpCache";

    /* renamed from: b */
    private boolean f55340b = true;

    /* renamed from: c */
    private int f55341c;

    /* renamed from: d */
    private int f55342d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FileCache f55343e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AsyncServer f55344f;

    /* renamed from: g */
    private int f55345g;

    /* renamed from: h */
    private int f55346h;

    /* renamed from: i */
    private int f55347i;

    /* renamed from: j */
    private int f55348j;

    public static class CacheData {
        C20219d cachedResponseHeaders;
        EntryCacheResponse candidate;
        long contentLength;
        FileInputStream[] snapshot;
    }

    /* renamed from: c */
    static /* synthetic */ int m39885c(ResponseCacheMiddleware responseCacheMiddleware) {
        int i = responseCacheMiddleware.f55341c;
        responseCacheMiddleware.f55341c = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m39886d(ResponseCacheMiddleware responseCacheMiddleware) {
        int i = responseCacheMiddleware.f55342d;
        responseCacheMiddleware.f55342d = i + 1;
        return i;
    }

    private ResponseCacheMiddleware() {
    }

    public static ResponseCacheMiddleware addCache(AsyncHttpClient asyncHttpClient, File file, long j) throws IOException {
        for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : asyncHttpClient.getMiddleware()) {
            if (asyncHttpClientMiddleware instanceof ResponseCacheMiddleware) {
                throw new IOException("Response cache already added to http client");
            }
        }
        ResponseCacheMiddleware responseCacheMiddleware = new ResponseCacheMiddleware();
        responseCacheMiddleware.f55344f = asyncHttpClient.getServer();
        responseCacheMiddleware.f55343e = new FileCache(file, j, false);
        asyncHttpClient.insertMiddleware(responseCacheMiddleware);
        return responseCacheMiddleware;
    }

    public FileCache getFileCache() {
        return this.f55343e;
    }

    public boolean getCaching() {
        return this.f55340b;
    }

    public void setCaching(boolean z) {
        this.f55340b = z;
    }

    public void removeFromCache(Uri uri) {
        getFileCache().remove(FileCache.toKeyString(uri));
    }

    public Cancellable getSocket(final AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        FileInputStream[] fileInputStreamArr;
        C20218c cVar = new C20218c(getSocketData.request.getUri(), C20217b.m39889a((Map<String, List<String>>) getSocketData.request.getHeaders().getMultiMap()));
        getSocketData.state.put("request-headers", cVar);
        if (this.f55343e == null || !this.f55340b || cVar.mo164310e()) {
            this.f55347i++;
            return null;
        }
        try {
            fileInputStreamArr = this.f55343e.get(FileCache.toKeyString(getSocketData.request.getUri()), 2);
            if (fileInputStreamArr == null) {
                try {
                    this.f55347i++;
                    return null;
                } catch (IOException unused) {
                    this.f55347i++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
            } else {
                long available = (long) fileInputStreamArr[1].available();
                Entry entry = new Entry(fileInputStreamArr[0]);
                if (!entry.matches(getSocketData.request.getUri(), getSocketData.request.getMethod(), getSocketData.request.getHeaders().getMultiMap())) {
                    this.f55347i++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
                EntryCacheResponse entryCacheResponse = new EntryCacheResponse(entry, fileInputStreamArr[1]);
                try {
                    Map<String, List<String>> headers = entryCacheResponse.getHeaders();
                    FileInputStream body = entryCacheResponse.getBody();
                    if (headers == null || body == null) {
                        this.f55347i++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    }
                    C20217b a = C20217b.m39889a(headers);
                    C20219d dVar = new C20219d(getSocketData.request.getUri(), a);
                    a.mo164290b(HttpHeaders.CONTENT_LENGTH, String.valueOf(available));
                    a.mo164292c(HttpHeaders.CONTENT_ENCODING);
                    a.mo164292c(HttpHeaders.TRANSFER_ENCODING);
                    dVar.mo164330a(System.currentTimeMillis(), System.currentTimeMillis());
                    ResponseSource a2 = dVar.mo164329a(System.currentTimeMillis(), cVar);
                    if (a2 == ResponseSource.CACHE) {
                        getSocketData.request.logi("Response retrieved from cache");
                        final CachedSocket cachedSSLSocket = entry.isHttps() ? new CachedSSLSocket(entryCacheResponse, available) : new CachedSocket(entryCacheResponse, available);
                        cachedSSLSocket.pending.add(ByteBuffer.wrap(a.mo164296f().getBytes()));
                        this.f55344f.post(new Runnable() {
                            public void run() {
                                getSocketData.connectCallback.onConnectCompleted((Exception) null, cachedSSLSocket);
                                cachedSSLSocket.sendCachedDataOnNetworkThread();
                            }
                        });
                        this.f55346h++;
                        getSocketData.state.put("socket-owner", this);
                        SimpleCancellable simpleCancellable = new SimpleCancellable();
                        simpleCancellable.setComplete();
                        return simpleCancellable;
                    } else if (a2 == ResponseSource.CONDITIONAL_CACHE) {
                        getSocketData.request.logi("Response may be served from conditional cache");
                        CacheData cacheData = new CacheData();
                        cacheData.snapshot = fileInputStreamArr;
                        cacheData.contentLength = available;
                        cacheData.cachedResponseHeaders = dVar;
                        cacheData.candidate = entryCacheResponse;
                        getSocketData.state.put("cache-data", cacheData);
                        return null;
                    } else {
                        getSocketData.request.logd("Response can not be served from cache");
                        this.f55347i++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    }
                } catch (Exception unused2) {
                    this.f55347i++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
            }
        } catch (IOException unused3) {
            fileInputStreamArr = null;
            this.f55347i++;
            StreamUtility.closeQuietly(fileInputStreamArr);
            return null;
        }
    }

    public int getConditionalCacheHitCount() {
        return this.f55345g;
    }

    public int getCacheHitCount() {
        return this.f55346h;
    }

    public int getNetworkCount() {
        return this.f55347i;
    }

    public int getCacheStoreCount() {
        return this.f55348j;
    }

    public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyDecoderData onBodyDecoderData) {
        if (((CachedSocket) C20137Util.getWrappedSocket(onBodyDecoderData.socket, CachedSocket.class)) != null) {
            onBodyDecoderData.response.headers().set(SERVED_FROM, "cache");
            return;
        }
        CacheData cacheData = (CacheData) onBodyDecoderData.state.get("cache-data");
        C20217b a = C20217b.m39889a((Map<String, List<String>>) onBodyDecoderData.response.headers().getMultiMap());
        a.mo164292c(HttpHeaders.CONTENT_LENGTH);
        a.mo164284a(String.format(Locale.ENGLISH, "%s %s %s", new Object[]{onBodyDecoderData.response.protocol(), Integer.valueOf(onBodyDecoderData.response.code()), onBodyDecoderData.response.message()}));
        C20219d dVar = new C20219d(onBodyDecoderData.request.getUri(), a);
        onBodyDecoderData.state.put("response-headers", dVar);
        if (cacheData != null) {
            if (cacheData.cachedResponseHeaders.mo164333a(dVar)) {
                onBodyDecoderData.request.logi("Serving response from conditional cache");
                C20219d b = cacheData.cachedResponseHeaders.mo164335b(dVar);
                onBodyDecoderData.response.headers(new Headers(b.mo164340f().mo164297g()));
                onBodyDecoderData.response.code(b.mo164340f().mo164291c());
                onBodyDecoderData.response.message(b.mo164340f().mo164293d());
                onBodyDecoderData.response.headers().set(SERVED_FROM, CONDITIONAL_CACHE);
                this.f55345g++;
                CachedBodyEmitter cachedBodyEmitter = new CachedBodyEmitter(cacheData.candidate, cacheData.contentLength);
                cachedBodyEmitter.setDataEmitter(onBodyDecoderData.bodyEmitter);
                onBodyDecoderData.bodyEmitter = cachedBodyEmitter;
                cachedBodyEmitter.sendCachedData();
                return;
            }
            onBodyDecoderData.state.remove("cache-data");
            StreamUtility.closeQuietly(cacheData.snapshot);
        }
        if (this.f55340b) {
            C20218c cVar = (C20218c) onBodyDecoderData.state.get("request-headers");
            if (cVar == null || !dVar.mo164332a(cVar) || !onBodyDecoderData.request.getMethod().equals("GET")) {
                this.f55347i++;
                onBodyDecoderData.request.logd("Response is not cacheable");
                return;
            }
            String keyString = FileCache.toKeyString(onBodyDecoderData.request.getUri());
            Entry entry = new Entry(onBodyDecoderData.request.getUri(), cVar.mo164307d().mo164280a(dVar.mo164351q()), onBodyDecoderData.request, dVar.mo164340f());
            BodyCacher bodyCacher = new BodyCacher();
            EntryEditor entryEditor = new EntryEditor(keyString);
            try {
                entry.writeTo(entryEditor);
                entryEditor.newOutputStream(1);
                bodyCacher.editor = entryEditor;
                bodyCacher.setDataEmitter(onBodyDecoderData.bodyEmitter);
                onBodyDecoderData.bodyEmitter = bodyCacher;
                onBodyDecoderData.state.put("body-cacher", bodyCacher);
                onBodyDecoderData.request.logd("Caching response");
                this.f55348j++;
            } catch (Exception unused) {
                entryEditor.abort();
                this.f55347i++;
            }
        }
    }

    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        CacheData cacheData = (CacheData) onResponseCompleteData.state.get("cache-data");
        if (!(cacheData == null || cacheData.snapshot == null)) {
            StreamUtility.closeQuietly(cacheData.snapshot);
        }
        CachedSocket cachedSocket = (CachedSocket) C20137Util.getWrappedSocket(onResponseCompleteData.socket, CachedSocket.class);
        if (cachedSocket != null) {
            StreamUtility.closeQuietly(cachedSocket.cacheResponse.getBody());
        }
        BodyCacher bodyCacher = (BodyCacher) onResponseCompleteData.state.get("body-cacher");
        if (bodyCacher == null) {
            return;
        }
        if (onResponseCompleteData.exception != null) {
            bodyCacher.abort();
        } else {
            bodyCacher.commit();
        }
    }

    public void clear() {
        FileCache fileCache = this.f55343e;
        if (fileCache != null) {
            fileCache.clear();
        }
    }

    private static class BodyCacher extends FilteredDataEmitter {
        ByteBufferList cached;
        EntryEditor editor;

        private BodyCacher() {
        }

        /* access modifiers changed from: protected */
        public void report(Exception exc) {
            super.report(exc);
            if (exc != null) {
                abort();
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0047 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDataAvailable(com.koushikdutta.async.DataEmitter r4, com.koushikdutta.async.ByteBufferList r5) {
            /*
                r3 = this;
                com.koushikdutta.async.ByteBufferList r0 = r3.cached
                if (r0 == 0) goto L_0x0013
                super.onDataAvailable(r4, r0)
                com.koushikdutta.async.ByteBufferList r0 = r3.cached
                int r0 = r0.remaining()
                if (r0 <= 0) goto L_0x0010
                return
            L_0x0010:
                r0 = 0
                r3.cached = r0
            L_0x0013:
                com.koushikdutta.async.ByteBufferList r0 = new com.koushikdutta.async.ByteBufferList
                r0.<init>()
                com.koushikdutta.async.http.cache.ResponseCacheMiddleware$EntryEditor r1 = r3.editor     // Catch:{ Exception -> 0x0047 }
                if (r1 == 0) goto L_0x003e
                com.koushikdutta.async.http.cache.ResponseCacheMiddleware$EntryEditor r1 = r3.editor     // Catch:{ Exception -> 0x0047 }
                r2 = 1
                java.io.FileOutputStream r1 = r1.newOutputStream(r2)     // Catch:{ Exception -> 0x0047 }
                if (r1 == 0) goto L_0x003b
            L_0x0025:
                boolean r2 = r5.isEmpty()     // Catch:{ Exception -> 0x0047 }
                if (r2 != 0) goto L_0x003e
                java.nio.ByteBuffer r2 = r5.remove()     // Catch:{ Exception -> 0x0047 }
                com.koushikdutta.async.ByteBufferList.writeOutputStream(r1, r2)     // Catch:{ all -> 0x0036 }
                r0.add((java.nio.ByteBuffer) r2)     // Catch:{ Exception -> 0x0047 }
                goto L_0x0025
            L_0x0036:
                r1 = move-exception
                r0.add((java.nio.ByteBuffer) r2)     // Catch:{ Exception -> 0x0047 }
                throw r1     // Catch:{ Exception -> 0x0047 }
            L_0x003b:
                r3.abort()     // Catch:{ Exception -> 0x0047 }
            L_0x003e:
                r5.get((com.koushikdutta.async.ByteBufferList) r0)
                r0.get((com.koushikdutta.async.ByteBufferList) r5)
                goto L_0x004b
            L_0x0045:
                r4 = move-exception
                goto L_0x0063
            L_0x0047:
                r3.abort()     // Catch:{ all -> 0x0045 }
                goto L_0x003e
            L_0x004b:
                super.onDataAvailable(r4, r5)
                com.koushikdutta.async.http.cache.ResponseCacheMiddleware$EntryEditor r4 = r3.editor
                if (r4 == 0) goto L_0x0062
                int r4 = r5.remaining()
                if (r4 <= 0) goto L_0x0062
                com.koushikdutta.async.ByteBufferList r4 = new com.koushikdutta.async.ByteBufferList
                r4.<init>()
                r3.cached = r4
                r5.get((com.koushikdutta.async.ByteBufferList) r4)
            L_0x0062:
                return
            L_0x0063:
                r5.get((com.koushikdutta.async.ByteBufferList) r0)
                r0.get((com.koushikdutta.async.ByteBufferList) r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.cache.ResponseCacheMiddleware.BodyCacher.onDataAvailable(com.koushikdutta.async.DataEmitter, com.koushikdutta.async.ByteBufferList):void");
        }

        public void close() {
            abort();
            super.close();
        }

        public void abort() {
            EntryEditor entryEditor = this.editor;
            if (entryEditor != null) {
                entryEditor.abort();
                this.editor = null;
            }
        }

        public void commit() {
            EntryEditor entryEditor = this.editor;
            if (entryEditor != null) {
                entryEditor.commit();
                this.editor = null;
            }
        }
    }

    private static class CachedBodyEmitter extends FilteredDataEmitter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Allocator allocator = new Allocator();
        boolean allowEnd;
        EntryCacheResponse cacheResponse;
        private boolean paused;
        ByteBufferList pending = new ByteBufferList();
        Runnable sendCachedDataRunnable = new Runnable() {
            public void run() {
                CachedBodyEmitter.this.sendCachedDataOnNetworkThread();
            }
        };

        static {
            Class<ResponseCacheMiddleware> cls = ResponseCacheMiddleware.class;
        }

        public CachedBodyEmitter(EntryCacheResponse entryCacheResponse, long j) {
            this.cacheResponse = entryCacheResponse;
            this.allocator.setCurrentAlloc((int) j);
        }

        /* access modifiers changed from: package-private */
        public void sendCachedDataOnNetworkThread() {
            if (this.pending.remaining() > 0) {
                super.onDataAvailable(this, this.pending);
                if (this.pending.remaining() > 0) {
                    return;
                }
            }
            try {
                ByteBuffer allocate = this.allocator.allocate();
                int read = this.cacheResponse.getBody().read(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (read == -1) {
                    ByteBufferList.reclaim(allocate);
                    this.allowEnd = true;
                    report((Exception) null);
                    return;
                }
                this.allocator.track((long) read);
                allocate.limit(read);
                this.pending.add(allocate);
                super.onDataAvailable(this, this.pending);
                if (this.pending.remaining() <= 0) {
                    getServer().postDelayed(this.sendCachedDataRunnable, 10);
                }
            } catch (IOException e) {
                this.allowEnd = true;
                report(e);
            }
        }

        /* access modifiers changed from: package-private */
        public void sendCachedData() {
            getServer().post(this.sendCachedDataRunnable);
        }

        public void resume() {
            this.paused = false;
            sendCachedData();
        }

        public boolean isPaused() {
            return this.paused;
        }

        public void close() {
            if (getServer().getAffinity() != Thread.currentThread()) {
                getServer().post(new Runnable() {
                    public void run() {
                        CachedBodyEmitter.this.close();
                    }
                });
                return;
            }
            this.pending.recycle();
            StreamUtility.closeQuietly(this.cacheResponse.getBody());
            super.close();
        }

        /* access modifiers changed from: protected */
        public void report(Exception exc) {
            if (this.allowEnd) {
                StreamUtility.closeQuietly(this.cacheResponse.getBody());
                super.report(exc);
            }
        }
    }

    private static final class Entry {
        private final String cipherSuite;
        private final Certificate[] localCertificates;
        private final Certificate[] peerCertificates;
        private final String requestMethod;
        /* access modifiers changed from: private */
        public final C20217b responseHeaders;
        private final String uri;
        private final C20217b varyHeaders;

        public Entry(InputStream inputStream) throws IOException {
            C20220e eVar;
            Throwable th;
            try {
                eVar = new C20220e(inputStream, Charsets.US_ASCII);
                try {
                    this.uri = eVar.mo164358a();
                    this.requestMethod = eVar.mo164358a();
                    this.varyHeaders = new C20217b();
                    int b = eVar.mo164359b();
                    for (int i = 0; i < b; i++) {
                        this.varyHeaders.mo164289b(eVar.mo164358a());
                    }
                    C20217b bVar = new C20217b();
                    this.responseHeaders = bVar;
                    bVar.mo164284a(eVar.mo164358a());
                    int b2 = eVar.mo164359b();
                    for (int i2 = 0; i2 < b2; i2++) {
                        this.responseHeaders.mo164289b(eVar.mo164358a());
                    }
                    this.cipherSuite = null;
                    this.peerCertificates = null;
                    this.localCertificates = null;
                    StreamUtility.closeQuietly(eVar, inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    StreamUtility.closeQuietly(eVar, inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                eVar = null;
                th = th4;
                StreamUtility.closeQuietly(eVar, inputStream);
                throw th;
            }
        }

        public Entry(Uri uri2, C20217b bVar, AsyncHttpRequest asyncHttpRequest, C20217b bVar2) {
            this.uri = uri2.toString();
            this.varyHeaders = bVar;
            this.requestMethod = asyncHttpRequest.getMethod();
            this.responseHeaders = bVar2;
            this.cipherSuite = null;
            this.peerCertificates = null;
            this.localCertificates = null;
        }

        public void writeTo(EntryEditor entryEditor) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(entryEditor.newOutputStream(0), Charsets.UTF_8));
            bufferedWriter.write(this.uri + 10);
            bufferedWriter.write(this.requestMethod + 10);
            bufferedWriter.write(Integer.toString(this.varyHeaders.mo164295e()) + 10);
            for (int i = 0; i < this.varyHeaders.mo164295e(); i++) {
                bufferedWriter.write(this.varyHeaders.mo164282a(i) + ": " + this.varyHeaders.mo164288b(i) + 10);
            }
            bufferedWriter.write(this.responseHeaders.mo164281a() + 10);
            bufferedWriter.write(Integer.toString(this.responseHeaders.mo164295e()) + 10);
            for (int i2 = 0; i2 < this.responseHeaders.mo164295e(); i2++) {
                bufferedWriter.write(this.responseHeaders.mo164282a(i2) + ": " + this.responseHeaders.mo164288b(i2) + 10);
            }
            if (isHttps()) {
                bufferedWriter.write(10);
                bufferedWriter.write(this.cipherSuite + 10);
                writeCertArray(bufferedWriter, this.peerCertificates);
                writeCertArray(bufferedWriter, this.localCertificates);
            }
            bufferedWriter.close();
        }

        /* access modifiers changed from: private */
        public boolean isHttps() {
            return this.uri.startsWith("https://");
        }

        private Certificate[] readCertArray(C20220e eVar) throws IOException {
            int b = eVar.mo164359b();
            if (b == -1) {
                return null;
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                Certificate[] certificateArr = new Certificate[b];
                for (int i = 0; i < b; i++) {
                    certificateArr[i] = instance.generateCertificate(new ByteArrayInputStream(Base64.decode(eVar.mo164358a(), 0)));
                }
                return certificateArr;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertArray(Writer writer, Certificate[] certificateArr) throws IOException {
            if (certificateArr == null) {
                writer.write("-1\n");
                return;
            }
            try {
                writer.write(Integer.toString(certificateArr.length) + 10);
                for (Certificate encoded : certificateArr) {
                    writer.write(Base64.encodeToString(encoded.getEncoded(), 0) + 10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Uri uri2, String str, Map<String, List<String>> map) {
            return this.uri.equals(uri2.toString()) && this.requestMethod.equals(str) && new C20219d(uri2, this.responseHeaders).mo164334a(this.varyHeaders.mo164297g(), map);
        }
    }

    static class EntryCacheResponse extends CacheResponse {
        private final Entry entry;
        private final FileInputStream snapshot;

        public EntryCacheResponse(Entry entry2, FileInputStream fileInputStream) {
            this.entry = entry2;
            this.snapshot = fileInputStream;
        }

        public Map<String, List<String>> getHeaders() {
            return this.entry.responseHeaders.mo164297g();
        }

        public FileInputStream getBody() {
            return this.snapshot;
        }
    }

    private class CachedSSLSocket extends CachedSocket implements AsyncSSLSocket {
        public X509Certificate[] getPeerCertificates() {
            return null;
        }

        public SSLEngine getSSLEngine() {
            return null;
        }

        public CachedSSLSocket(EntryCacheResponse entryCacheResponse, long j) {
            super(entryCacheResponse, j);
        }
    }

    private class CachedSocket extends CachedBodyEmitter implements AsyncSocket {
        boolean closed;
        CompletedCallback closedCallback;
        boolean open;

        public void end() {
        }

        public WritableCallback getWriteableCallback() {
            return null;
        }

        public void setWriteableCallback(WritableCallback writableCallback) {
        }

        public CachedSocket(EntryCacheResponse entryCacheResponse, long j) {
            super(entryCacheResponse, j);
            this.allowEnd = true;
        }

        /* access modifiers changed from: protected */
        public void report(Exception exc) {
            super.report(exc);
            if (!this.closed) {
                this.closed = true;
                CompletedCallback completedCallback = this.closedCallback;
                if (completedCallback != null) {
                    completedCallback.onCompleted(exc);
                }
            }
        }

        public void write(ByteBufferList byteBufferList) {
            byteBufferList.recycle();
        }

        public boolean isOpen() {
            return this.open;
        }

        public void close() {
            this.open = false;
        }

        public CompletedCallback getClosedCallback() {
            return this.closedCallback;
        }

        public void setClosedCallback(CompletedCallback completedCallback) {
            this.closedCallback = completedCallback;
        }

        public AsyncServer getServer() {
            return ResponseCacheMiddleware.this.f55344f;
        }
    }

    class EntryEditor {
        boolean done;
        String key;
        FileOutputStream[] outs = new FileOutputStream[2];
        File[] temps;

        public EntryEditor(String str) {
            this.key = str;
            this.temps = ResponseCacheMiddleware.this.f55343e.getTempFiles(2);
        }

        /* access modifiers changed from: package-private */
        public void commit() {
            StreamUtility.closeQuietly(this.outs);
            if (!this.done) {
                ResponseCacheMiddleware.this.f55343e.commitTempFiles(this.key, this.temps);
                ResponseCacheMiddleware.m39885c(ResponseCacheMiddleware.this);
                this.done = true;
            }
        }

        /* access modifiers changed from: package-private */
        public FileOutputStream newOutputStream(int i) throws IOException {
            FileOutputStream[] fileOutputStreamArr = this.outs;
            if (fileOutputStreamArr[i] == null) {
                fileOutputStreamArr[i] = new FileOutputStream(this.temps[i]);
            }
            return this.outs[i];
        }

        /* access modifiers changed from: package-private */
        public void abort() {
            StreamUtility.closeQuietly(this.outs);
            FileCache.removeFiles(this.temps);
            if (!this.done) {
                ResponseCacheMiddleware.m39886d(ResponseCacheMiddleware.this);
                this.done = true;
            }
        }
    }
}
