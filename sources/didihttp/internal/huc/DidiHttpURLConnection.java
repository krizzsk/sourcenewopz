package didihttp.internal.huc;

import com.datadog.android.core.internal.net.DataOkHttpUploader;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import didihttp.Cache;
import didihttp.Call;
import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.Dispatcher;
import didihttp.Handshake;
import didihttp.Headers;
import didihttp.HttpUrl;
import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didihttp.internal.C20747Util;
import didihttp.internal.Internal;
import didihttp.internal.JavaNetHeaders;
import didihttp.internal.URLFilter;
import didihttp.internal.http.HttpDate;
import didihttp.internal.http.HttpHeaders;
import didihttp.internal.http.HttpMethod;
import didihttp.internal.http.StatusLine;
import didihttp.internal.platform.Platform;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class DidiHttpURLConnection extends HttpURLConnection implements Callback {
    public static final String RESPONSE_SOURCE = (Platform.get().getPrefix() + "-Response-Source");
    public static final String SELECTED_PROTOCOL = (Platform.get().getPrefix() + "-Selected-Protocol");

    /* renamed from: h */
    private static final Set<String> f56847h = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", "GET", AsyncHttpHead.METHOD, "POST", "PUT", AsyncHttpDelete.METHOD, "TRACE", "PATCH"}));

    /* renamed from: a */
    DidiHttpClient f56848a;

    /* renamed from: b */
    Call f56849b;

    /* renamed from: c */
    URLFilter f56850c;

    /* renamed from: d */
    Response f56851d;

    /* renamed from: e */
    boolean f56852e;

    /* renamed from: f */
    Proxy f56853f;

    /* renamed from: g */
    Handshake f56854g;

    /* renamed from: i */
    private final NetworkInterceptor f56855i;

    /* renamed from: j */
    private Headers.Builder f56856j;

    /* renamed from: k */
    private boolean f56857k;

    /* renamed from: l */
    private Headers f56858l;

    /* renamed from: m */
    private long f56859m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Object f56860n;

    /* renamed from: o */
    private Response f56861o;

    /* renamed from: p */
    private Throwable f56862p;

    public DidiHttpURLConnection(URL url, DidiHttpClient didiHttpClient) {
        super(url);
        this.f56855i = new NetworkInterceptor();
        this.f56856j = new Headers.Builder();
        this.f56859m = -1;
        this.f56860n = new Object();
        this.f56852e = true;
        this.f56848a = didiHttpClient;
    }

    public DidiHttpURLConnection(URL url, DidiHttpClient didiHttpClient, URLFilter uRLFilter) {
        this(url, didiHttpClient);
        this.f56850c = uRLFilter;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.f56857k
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            didihttp.Call r0 = r2.m40816b()
            r1 = 1
            r2.f56857k = r1
            r0.enqueue(r2)
            java.lang.Object r0 = r2.f56860n
            monitor-enter(r0)
        L_0x0012:
            boolean r1 = r2.f56852e     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 == 0) goto L_0x0024
            didihttp.Response r1 = r2.f56861o     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Throwable r1 = r2.f56862p     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Object r1 = r2.f56860n     // Catch:{ InterruptedException -> 0x0033 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0033 }
            goto L_0x0012
        L_0x0024:
            java.lang.Throwable r1 = r2.f56862p     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x002a:
            java.lang.Throwable r1 = r2.f56862p     // Catch:{ InterruptedException -> 0x0033 }
            java.io.IOException r1 = m40812a((java.lang.Throwable) r1)     // Catch:{ InterruptedException -> 0x0033 }
            throw r1     // Catch:{ InterruptedException -> 0x0033 }
        L_0x0031:
            r1 = move-exception
            goto L_0x0039
        L_0x0033:
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0031 }
            r1.<init>()     // Catch:{ all -> 0x0031 }
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.huc.DidiHttpURLConnection.connect():void");
    }

    public void disconnect() {
        if (this.f56849b != null) {
            this.f56855i.proceed();
            this.f56849b.cancel();
        }
    }

    public InputStream getErrorStream() {
        try {
            Response a = m40811a(true);
            if (HttpHeaders.hasBody(a) && a.code() >= 400) {
                return a.body().byteStream();
            }
        } catch (IOException unused) {
        }
        return null;
    }

    /* renamed from: a */
    private Headers m40810a() throws IOException {
        if (this.f56858l == null) {
            Response a = m40811a(true);
            this.f56858l = a.headers().newBuilder().add(SELECTED_PROTOCOL, a.protocol().toString()).add(RESPONSE_SOURCE, m40814a(a)).build();
        }
        return this.f56858l;
    }

    /* renamed from: a */
    private static String m40814a(Response response) {
        if (response.networkResponse() == null) {
            if (response.cacheResponse() == null) {
                return IStoreCallback.DEFAULT_API_DETAIL_KEY;
            }
            return "CACHE " + response.code();
        } else if (response.cacheResponse() == null) {
            return "NETWORK " + response.code();
        } else {
            return "CONDITIONAL_CACHE " + response.networkResponse().code();
        }
    }

    public String getHeaderField(int i) {
        try {
            Headers a = m40810a();
            if (i >= 0) {
                if (i < a.size()) {
                    return a.value(i);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderField(String str) {
        if (str != null) {
            return m40810a().get(str);
        }
        try {
            return StatusLine.get(m40811a(true)).toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getHeaderFieldKey(int i) {
        try {
            Headers a = m40810a();
            if (i >= 0) {
                if (i < a.size()) {
                    return a.name(i);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        try {
            return JavaNetHeaders.toMultimap(m40810a(), StatusLine.get(m40811a(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return JavaNetHeaders.toMultimap(this.f56856j.build(), (String) null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public InputStream getInputStream() throws IOException {
        if (this.doInput) {
            Response a = m40811a(false);
            if (a.code() < 400) {
                return a.body().byteStream();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public OutputStream getOutputStream() throws IOException {
        C20777c cVar = (C20777c) m40816b().request().body();
        if (cVar != null) {
            if (cVar instanceof C20778d) {
                connect();
                this.f56855i.proceed();
            }
            if (!cVar.mo170311c()) {
                return cVar.mo170308a();
            }
            throw new ProtocolException("cannot write request body after response has been read");
        }
        throw new ProtocolException("method does not support a request body: " + this.method);
    }

    public Permission getPermission() throws IOException {
        int i;
        URL url = getURL();
        String host = url.getHost();
        if (url.getPort() != -1) {
            i = url.getPort();
        } else {
            i = HttpUrl.defaultPort(url.getProtocol());
        }
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f56848a.proxy().address();
            host = inetSocketAddress.getHostName();
            i = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + i, "connect, resolve");
    }

    public String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.f56856j.get(str);
    }

    public void setConnectTimeout(int i) {
        this.f56848a = this.f56848a.newBuilder().connectTimeout((long) i, TimeUnit.MILLISECONDS).build();
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f56848a = this.f56848a.newBuilder().followRedirects(z).build();
    }

    public boolean getInstanceFollowRedirects() {
        return this.f56848a.followRedirects();
    }

    public int getConnectTimeout() {
        return this.f56848a.connectTimeoutMillis();
    }

    public void setReadTimeout(int i) {
        this.f56848a = this.f56848a.newBuilder().readTimeout((long) i, TimeUnit.MILLISECONDS).build();
    }

    public int getReadTimeout() {
        return this.f56848a.readTimeoutMillis();
    }

    /* renamed from: b */
    private Call m40816b() throws IOException {
        C20777c cVar;
        Call call = this.f56849b;
        if (call != null) {
            return call;
        }
        boolean z = true;
        this.connected = true;
        if (this.doOutput) {
            if (this.method.equals("GET")) {
                this.method = "POST";
            } else if (!HttpMethod.permitsRequestBody(this.method)) {
                throw new ProtocolException(this.method + " does not support writing");
            }
        }
        if (this.f56856j.get("User-Agent") == null) {
            this.f56856j.add("User-Agent", m40817c());
        }
        if (HttpMethod.permitsRequestBody(this.method)) {
            if (this.f56856j.get("Content-Type") == null) {
                this.f56856j.add("Content-Type", "application/x-www-form-urlencoded");
            }
            long j = -1;
            if (this.f56859m == -1 && this.chunkLength <= 0) {
                z = false;
            }
            String str = this.f56856j.get(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            long j2 = this.f56859m;
            if (j2 != -1) {
                j = j2;
            } else if (str != null) {
                j = Long.parseLong(str);
            }
            cVar = z ? new C20778d(j) : new C20775a(j);
            cVar.mo170310b().timeout((long) this.f56848a.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        } else {
            cVar = null;
        }
        Request build = new Request.Builder().url(Internal.instance.getHttpUrlChecked(getURL().toString())).headers(this.f56856j.build()).method(this.method, cVar).build();
        URLFilter uRLFilter = this.f56850c;
        if (uRLFilter != null) {
            uRLFilter.checkURLPermitted(build.url().url());
        }
        DidiHttpClient.Builder newBuilder = this.f56848a.newBuilder();
        newBuilder.interceptors().clear();
        newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
        newBuilder.networkInterceptors().clear();
        newBuilder.networkInterceptors().add(this.f56855i);
        newBuilder.dispatcher(new Dispatcher(this.f56848a.dispatcher().executorService()));
        if (!getUseCaches()) {
            newBuilder.cache((Cache) null);
        }
        Call newCall = newBuilder.build().newCall(build);
        this.f56849b = newCall;
        return newCall;
    }

    /* renamed from: c */
    private String m40817c() {
        String property = System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        return property != null ? C20747Util.toHumanReadableAscii(property) : "didihttp";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        r3 = m40816b();
        r2.f56855i.proceed();
        r0 = (didihttp.internal.huc.C20777c) r3.request().body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r0 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r0.mo170308a().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r2.f56857k == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        r0 = r2.f56860n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r2.f56861o != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (r2.f56862p != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        r2.f56860n.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005e, code lost:
        r2.f56857k = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        onResponse(r3, r3.execute());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0069, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006a, code lost:
        onFailure(r3, r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private didihttp.Response m40811a(boolean r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f56860n
            monitor-enter(r0)
            didihttp.Response r1 = r2.f56861o     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x000b
            didihttp.Response r3 = r2.f56861o     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r3
        L_0x000b:
            java.lang.Throwable r1 = r2.f56862p     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0020
            if (r3 == 0) goto L_0x0019
            didihttp.Response r3 = r2.f56851d     // Catch:{ all -> 0x008d }
            if (r3 == 0) goto L_0x0019
            didihttp.Response r3 = r2.f56851d     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r3
        L_0x0019:
            java.lang.Throwable r3 = r2.f56862p     // Catch:{ all -> 0x008d }
            java.io.IOException r3 = m40812a((java.lang.Throwable) r3)     // Catch:{ all -> 0x008d }
            throw r3     // Catch:{ all -> 0x008d }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            didihttp.Call r3 = r2.m40816b()
            didihttp.internal.huc.DidiHttpURLConnection$NetworkInterceptor r0 = r2.f56855i
            r0.proceed()
            didihttp.Request r0 = r3.request()
            didihttp.RequestBody r0 = r0.body()
            didihttp.internal.huc.c r0 = (didihttp.internal.huc.C20777c) r0
            if (r0 == 0) goto L_0x003d
            java.io.OutputStream r0 = r0.mo170308a()
            r0.close()
        L_0x003d:
            boolean r0 = r2.f56857k
            if (r0 == 0) goto L_0x005e
            java.lang.Object r0 = r2.f56860n
            monitor-enter(r0)
        L_0x0044:
            didihttp.Response r3 = r2.f56861o     // Catch:{ InterruptedException -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.Throwable r3 = r2.f56862p     // Catch:{ InterruptedException -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.Object r3 = r2.f56860n     // Catch:{ InterruptedException -> 0x0056 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0056 }
            goto L_0x0044
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            goto L_0x006d
        L_0x0054:
            r3 = move-exception
            goto L_0x005c
        L_0x0056:
            java.io.InterruptedIOException r3 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r3
        L_0x005e:
            r0 = 1
            r2.f56857k = r0
            didihttp.Response r0 = r3.execute()     // Catch:{ IOException -> 0x0069 }
            r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r2.onFailure(r3, r0)
        L_0x006d:
            java.lang.Object r3 = r2.f56860n
            monitor-enter(r3)
            java.lang.Throwable r0 = r2.f56862p     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0083
            didihttp.Response r0 = r2.f56861o     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x007c
            didihttp.Response r0 = r2.f56861o     // Catch:{ all -> 0x008a }
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            return r0
        L_0x007c:
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x0083:
            java.lang.Throwable r0 = r2.f56862p     // Catch:{ all -> 0x008a }
            java.io.IOException r0 = m40812a((java.lang.Throwable) r0)     // Catch:{ all -> 0x008a }
            throw r0     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            throw r0
        L_0x008d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.huc.DidiHttpURLConnection.m40811a(boolean):didihttp.Response");
    }

    public boolean usingProxy() {
        if (this.f56853f != null) {
            return true;
        }
        Proxy proxy = this.f56848a.proxy();
        if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
            return false;
        }
        return true;
    }

    public String getResponseMessage() throws IOException {
        return m40811a(true).message();
    }

    public int getResponseCode() throws IOException {
        return m40811a(true).code();
    }

    public void setRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            Platform platform = Platform.get();
            platform.log(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
        } else {
            this.f56856j.set(str, str2);
        }
    }

    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (this.ifModifiedSince != 0) {
            this.f56856j.set(com.google.common.net.HttpHeaders.IF_MODIFIED_SINCE, HttpDate.format(new Date(this.ifModifiedSince)));
        } else {
            this.f56856j.removeAll(com.google.common.net.HttpHeaders.IF_MODIFIED_SINCE);
        }
    }

    public void addRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            Platform platform = Platform.get();
            platform.log(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
        } else {
            this.f56856j.add(str, str2);
        }
    }

    public void setRequestMethod(String str) throws ProtocolException {
        if (f56847h.contains(str)) {
            this.method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + f56847h + " but was " + str);
    }

    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode((long) i);
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j >= 0) {
            this.f56859m = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        } else {
            throw new IllegalArgumentException("contentLength < 0");
        }
    }

    public void onFailure(Call call, IOException iOException) {
        synchronized (this.f56860n) {
            boolean z = iOException instanceof UnexpectedException;
            Throwable th = iOException;
            if (z) {
                th = iOException.getCause();
            }
            this.f56862p = th;
            this.f56860n.notifyAll();
        }
    }

    public void onResponse(Call call, Response response) {
        synchronized (this.f56860n) {
            this.f56861o = response;
            this.f56854g = response.handshake();
            this.url = response.request().url().url();
            this.f56860n.notifyAll();
        }
    }

    static final class UnexpectedException extends IOException {
        static final Interceptor INTERCEPTOR = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                try {
                    return chain.proceed(chain.request());
                } catch (Error | RuntimeException e) {
                    throw new UnexpectedException(e);
                }
            }
        };

        public UnexpectedException(Throwable th) {
            super(th);
        }
    }

    /* renamed from: a */
    private static IOException m40812a(Throwable th) throws IOException {
        if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new AssertionError();
        }
    }

    final class NetworkInterceptor implements Interceptor {
        private boolean proceed;

        NetworkInterceptor() {
        }

        public void proceed() {
            synchronized (DidiHttpURLConnection.this.f56860n) {
                this.proceed = true;
                DidiHttpURLConnection.this.f56860n.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:28|29|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0096 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public didihttp.Response intercept(didihttp.Interceptor.Chain r5) throws java.io.IOException {
            /*
                r4 = this;
                didihttp.Request r0 = r5.request()
                didihttp.internal.huc.DidiHttpURLConnection r1 = didihttp.internal.huc.DidiHttpURLConnection.this
                didihttp.internal.URLFilter r1 = r1.f56850c
                if (r1 == 0) goto L_0x0019
                didihttp.internal.huc.DidiHttpURLConnection r1 = didihttp.internal.huc.DidiHttpURLConnection.this
                didihttp.internal.URLFilter r1 = r1.f56850c
                didihttp.HttpUrl r2 = r0.url()
                java.net.URL r2 = r2.url()
                r1.checkURLPermitted(r2)
            L_0x0019:
                didihttp.internal.huc.DidiHttpURLConnection r1 = didihttp.internal.huc.DidiHttpURLConnection.this
                java.lang.Object r1 = r1.f56860n
                monitor-enter(r1)
                didihttp.internal.huc.DidiHttpURLConnection r2 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ all -> 0x009c }
                r3 = 0
                r2.f56852e = r3     // Catch:{ all -> 0x009c }
                didihttp.Connection r2 = r5.connection()     // Catch:{ all -> 0x009c }
                if (r2 == 0) goto L_0x0047
                didihttp.internal.huc.DidiHttpURLConnection r2 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ all -> 0x009c }
                didihttp.Connection r3 = r5.connection()     // Catch:{ all -> 0x009c }
                didihttp.Route r3 = r3.route()     // Catch:{ all -> 0x009c }
                java.net.Proxy r3 = r3.proxy()     // Catch:{ all -> 0x009c }
                r2.f56853f = r3     // Catch:{ all -> 0x009c }
                didihttp.internal.huc.DidiHttpURLConnection r2 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ all -> 0x009c }
                didihttp.Connection r3 = r5.connection()     // Catch:{ all -> 0x009c }
                didihttp.Handshake r3 = r3.handshake()     // Catch:{ all -> 0x009c }
                r2.f56854g = r3     // Catch:{ all -> 0x009c }
            L_0x0047:
                didihttp.internal.huc.DidiHttpURLConnection r2 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ all -> 0x009c }
                java.lang.Object r2 = r2.f56860n     // Catch:{ all -> 0x009c }
                r2.notifyAll()     // Catch:{ all -> 0x009c }
            L_0x0050:
                boolean r2 = r4.proceed     // Catch:{ InterruptedException -> 0x0096 }
                if (r2 != 0) goto L_0x005e
                didihttp.internal.huc.DidiHttpURLConnection r2 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ InterruptedException -> 0x0096 }
                java.lang.Object r2 = r2.f56860n     // Catch:{ InterruptedException -> 0x0096 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0096 }
                goto L_0x0050
            L_0x005e:
                monitor-exit(r1)     // Catch:{ all -> 0x009c }
                didihttp.RequestBody r1 = r0.body()
                boolean r1 = r1 instanceof didihttp.internal.huc.C20777c
                if (r1 == 0) goto L_0x0071
                didihttp.RequestBody r1 = r0.body()
                didihttp.internal.huc.c r1 = (didihttp.internal.huc.C20777c) r1
                didihttp.Request r0 = r1.mo170307a(r0)
            L_0x0071:
                didihttp.Response r5 = r5.proceed(r0)
                didihttp.internal.huc.DidiHttpURLConnection r0 = didihttp.internal.huc.DidiHttpURLConnection.this
                java.lang.Object r0 = r0.f56860n
                monitor-enter(r0)
                didihttp.internal.huc.DidiHttpURLConnection r1 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ all -> 0x0093 }
                r1.f56851d = r5     // Catch:{ all -> 0x0093 }
                didihttp.internal.huc.DidiHttpURLConnection r1 = didihttp.internal.huc.DidiHttpURLConnection.this     // Catch:{ all -> 0x0093 }
                didihttp.Request r2 = r5.request()     // Catch:{ all -> 0x0093 }
                didihttp.HttpUrl r2 = r2.url()     // Catch:{ all -> 0x0093 }
                java.net.URL r2 = r2.url()     // Catch:{ all -> 0x0093 }
                java.net.URL unused = r1.url = r2     // Catch:{ all -> 0x0093 }
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                return r5
            L_0x0093:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                throw r5
            L_0x0096:
                java.io.InterruptedIOException r5 = new java.io.InterruptedIOException     // Catch:{ all -> 0x009c }
                r5.<init>()     // Catch:{ all -> 0x009c }
                throw r5     // Catch:{ all -> 0x009c }
            L_0x009c:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x009c }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.huc.DidiHttpURLConnection.NetworkInterceptor.intercept(didihttp.Interceptor$Chain):didihttp.Response");
        }
    }
}
