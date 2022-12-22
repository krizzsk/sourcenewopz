package didihttp;

import android.os.Build;
import didihttp.Call;
import didihttp.Headers;
import didihttp.Response;
import didihttp.WebSocket;
import didihttp.internal.C20747Util;
import didihttp.internal.Internal;
import didihttp.internal.cache.InternalCache;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.RouteDatabase;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.p229ws.RealWebSocket;
import didihttp.internal.platform.Platform;
import didihttp.internal.tls.CertificateChainCleaner;
import didihttp.internal.tls.OkHostnameVerifier;
import didihttp.internal.tls.TLSSocketFactory;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class DidiHttpClient implements Call.Factory, WebSocket.Factory, Cloneable {

    /* renamed from: a */
    static final List<Protocol> f56382a = C20747Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: b */
    static final List<ConnectionSpec> f56383b = C20747Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT});

    /* renamed from: A */
    int f56384A;

    /* renamed from: B */
    final int f56385B;

    /* renamed from: C */
    final StatisticalCallback f56386C;

    /* renamed from: D */
    final boolean f56387D;

    /* renamed from: E */
    final boolean f56388E;

    /* renamed from: c */
    final Dispatcher f56389c;

    /* renamed from: d */
    final Proxy f56390d;

    /* renamed from: e */
    final List<Protocol> f56391e;

    /* renamed from: f */
    final List<ConnectionSpec> f56392f;

    /* renamed from: g */
    final List<Interceptor> f56393g;

    /* renamed from: h */
    final List<Interceptor> f56394h;

    /* renamed from: i */
    final ProxySelector f56395i;

    /* renamed from: j */
    final CookieJar f56396j;

    /* renamed from: k */
    final Cache f56397k;

    /* renamed from: l */
    final InternalCache f56398l;

    /* renamed from: m */
    final SocketFactory f56399m;

    /* renamed from: n */
    final SSLSocketFactory f56400n;

    /* renamed from: o */
    final CertificateChainCleaner f56401o;

    /* renamed from: p */
    final HostnameVerifier f56402p;

    /* renamed from: q */
    final CertificatePinner f56403q;

    /* renamed from: r */
    final Authenticator f56404r;

    /* renamed from: s */
    final Authenticator f56405s;

    /* renamed from: t */
    final ConnectionPool f56406t;

    /* renamed from: u */
    Dns f56407u;

    /* renamed from: v */
    final boolean f56408v;

    /* renamed from: w */
    final boolean f56409w;

    /* renamed from: x */
    boolean f56410x;

    /* renamed from: y */
    int f56411y;

    /* renamed from: z */
    int f56412z;

    static {
        Internal.instance = new Internal() {
            public void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }

            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.mo169428b(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo169425a(address, streamAllocation);
            }

            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo169427b(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.mo169426a(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f56350a;
            }

            public int code(Response.Builder builder) {
                return builder.code;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.mo169433a(sSLSocket, z);
            }

            public HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
                return HttpUrl.m40625b(str);
            }

            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).mo169725b();
            }

            public Call newWebSocketCall(DidiHttpClient didiHttpClient, Request request) {
                return RealCall.m40631a(didiHttpClient, request, true);
            }
        };
    }

    public DidiHttpClient() {
        this(new Builder());
    }

    DidiHttpClient(Builder builder) {
        boolean z;
        this.f56389c = builder.dispatcher;
        this.f56390d = builder.proxy;
        this.f56391e = builder.protocols;
        this.f56392f = builder.connectionSpecs;
        this.f56393g = C20747Util.immutableList(builder.interceptors);
        this.f56394h = C20747Util.immutableList(builder.networkInterceptors);
        this.f56395i = builder.proxySelector;
        this.f56396j = builder.cookieJar;
        this.f56397k = builder.cache;
        this.f56398l = builder.internalCache;
        this.f56399m = builder.socketFactory;
        this.f56386C = builder.callback;
        this.f56387D = builder.useGlobalStatisticalDataManagerCallback;
        this.f56388E = builder.httpDnsOwner;
        Iterator<ConnectionSpec> it = this.f56392f.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.isTls()) {
                    z = true;
                }
            }
        }
        if (builder.sslSocketFactory != null || !z) {
            this.f56400n = builder.sslSocketFactory;
            this.f56401o = builder.certificateChainCleaner;
        } else {
            X509TrustManager b = m40588b();
            this.f56400n = m40587a(b);
            this.f56401o = CertificateChainCleaner.get(b);
        }
        this.f56402p = builder.hostnameVerifier;
        this.f56403q = builder.certificatePinner.mo169401a(this.f56401o);
        this.f56404r = builder.proxyAuthenticator;
        this.f56405s = builder.authenticator;
        this.f56406t = builder.connectionPool;
        this.f56407u = builder.dns;
        this.f56408v = builder.followSslRedirects;
        this.f56409w = builder.followRedirects;
        this.f56410x = builder.retryOnConnectionFailure;
        this.f56411y = builder.connectTimeout;
        this.f56412z = builder.readTimeout;
        this.f56384A = builder.writeTimeout;
        this.f56385B = builder.pingInterval;
    }

    /* renamed from: b */
    private X509TrustManager m40588b() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m40587a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m40586a(instance);
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m40586a(SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT <= 19) {
            return new TLSSocketFactory(sSLContext);
        }
        return sSLContext.getSocketFactory();
    }

    public int connectTimeoutMillis() {
        return this.f56411y;
    }

    public void setConnectTimeout(int i) {
        this.f56411y = i;
    }

    public int readTimeoutMillis() {
        return this.f56412z;
    }

    public void setReadTimeout(int i) {
        this.f56412z = i;
    }

    public int writeTimeoutMillis() {
        return this.f56384A;
    }

    public void setWriteTimeout(int i) {
        this.f56384A = i;
    }

    public int pingIntervalMillis() {
        return this.f56385B;
    }

    public Proxy proxy() {
        return this.f56390d;
    }

    public ProxySelector proxySelector() {
        return this.f56395i;
    }

    public CookieJar cookieJar() {
        return this.f56396j;
    }

    public Cache cache() {
        return this.f56397k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InternalCache mo169498a() {
        Cache cache = this.f56397k;
        return cache != null ? cache.f56323a : this.f56398l;
    }

    public void setDns(Dns dns) {
        this.f56407u = dns;
    }

    public Dns dns() {
        return this.f56407u;
    }

    public SocketFactory socketFactory() {
        return this.f56399m;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f56400n;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f56402p;
    }

    public CertificatePinner certificatePinner() {
        return this.f56403q;
    }

    public Authenticator authenticator() {
        return this.f56405s;
    }

    public Authenticator proxyAuthenticator() {
        return this.f56404r;
    }

    public ConnectionPool connectionPool() {
        return this.f56406t;
    }

    public boolean followSslRedirects() {
        return this.f56408v;
    }

    public boolean followRedirects() {
        return this.f56409w;
    }

    public void setRetryOnConnectionFailure(boolean z) {
        this.f56410x = z;
    }

    public boolean retryOnConnectionFailure() {
        return this.f56410x;
    }

    public Dispatcher dispatcher() {
        return this.f56389c;
    }

    public List<Protocol> protocols() {
        return this.f56391e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f56392f;
    }

    public List<Interceptor> interceptors() {
        return this.f56393g;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f56394h;
    }

    public Call newCall(Request request) {
        return RealCall.m40631a(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new SecureRandom());
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        Authenticator authenticator;
        Cache cache;
        StatisticalCallback callback;
        CertificateChainCleaner certificateChainCleaner;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        boolean httpDnsOwner;
        final List<Interceptor> interceptors;
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        SSLSocketFactory sslSocketFactory;
        boolean useGlobalStatisticalDataManagerCallback;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.useGlobalStatisticalDataManagerCallback = true;
            this.httpDnsOwner = false;
            this.dispatcher = new Dispatcher();
            this.protocols = DidiHttpClient.f56382a;
            this.connectionSpecs = DidiHttpClient.f56383b;
            this.proxySelector = ProxySelector.getDefault();
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.proxyAuthenticator = Authenticator.NONE;
            this.authenticator = Authenticator.NONE;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        Builder(DidiHttpClient didiHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.useGlobalStatisticalDataManagerCallback = true;
            this.httpDnsOwner = false;
            this.dispatcher = didiHttpClient.f56389c;
            this.proxy = didiHttpClient.f56390d;
            this.protocols = didiHttpClient.f56391e;
            this.connectionSpecs = didiHttpClient.f56392f;
            this.interceptors.addAll(didiHttpClient.f56393g);
            this.networkInterceptors.addAll(didiHttpClient.f56394h);
            this.proxySelector = didiHttpClient.f56395i;
            this.cookieJar = didiHttpClient.f56396j;
            this.internalCache = didiHttpClient.f56398l;
            this.cache = didiHttpClient.f56397k;
            this.socketFactory = didiHttpClient.f56399m;
            this.sslSocketFactory = didiHttpClient.f56400n;
            this.certificateChainCleaner = didiHttpClient.f56401o;
            this.hostnameVerifier = didiHttpClient.f56402p;
            this.certificatePinner = didiHttpClient.f56403q;
            this.proxyAuthenticator = didiHttpClient.f56404r;
            this.authenticator = didiHttpClient.f56405s;
            this.connectionPool = didiHttpClient.f56406t;
            this.dns = didiHttpClient.f56407u;
            this.followSslRedirects = didiHttpClient.f56408v;
            this.followRedirects = didiHttpClient.f56409w;
            this.retryOnConnectionFailure = didiHttpClient.f56410x;
            this.connectTimeout = didiHttpClient.f56411y;
            this.readTimeout = didiHttpClient.f56412z;
            this.writeTimeout = didiHttpClient.f56384A;
            this.pingInterval = didiHttpClient.f56385B;
            this.callback = didiHttpClient.f56386C;
            this.useGlobalStatisticalDataManagerCallback = didiHttpClient.f56387D;
            this.httpDnsOwner = didiHttpClient.f56388E;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = checkDuration("interval", j, timeUnit);
            return this;
        }

        private static int checkDuration(String str, long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public Builder proxy(Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector2) {
            this.proxySelector = proxySelector2;
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar2) {
            if (cookieJar2 != null) {
                this.cookieJar = cookieJar2;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        /* access modifiers changed from: package-private */
        public void setInternalCache(InternalCache internalCache2) {
            this.internalCache = internalCache2;
            this.cache = null;
        }

        public Builder cache(Cache cache2) {
            this.cache = cache2;
            this.internalCache = null;
            return this;
        }

        public Builder dns(Dns dns2) {
            if (dns2 != null) {
                this.dns = dns2;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder socketFactory(SocketFactory socketFactory2) {
            if (socketFactory2 != null) {
                this.socketFactory = socketFactory2;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                X509TrustManager trustManager = Platform.get().trustManager(sSLSocketFactory);
                if (trustManager != null) {
                    this.sslSocketFactory = sSLSocketFactory;
                    this.certificateChainCleaner = CertificateChainCleaner.get(trustManager);
                    return this;
                }
                throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier2) {
            if (hostnameVerifier2 != null) {
                this.hostnameVerifier = hostnameVerifier2;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public Builder certificatePinner(CertificatePinner certificatePinner2) {
            if (certificatePinner2 != null) {
                this.certificatePinner = certificatePinner2;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder authenticator(Authenticator authenticator2) {
            if (authenticator2 != null) {
                this.authenticator = authenticator2;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public Builder proxyAuthenticator(Authenticator authenticator2) {
            if (authenticator2 != null) {
                this.proxyAuthenticator = authenticator2;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder connectionPool(ConnectionPool connectionPool2) {
            if (connectionPool2 != null) {
                this.connectionPool = connectionPool2;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher2) {
            if (dispatcher2 != null) {
                this.dispatcher = dispatcher2;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                if (arrayList.contains(Protocol.SPDY_3)) {
                    arrayList.remove(Protocol.SPDY_3);
                }
                this.protocols = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = C20747Util.immutableList(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public Builder setStatisticalCallback(StatisticalCallback statisticalCallback) {
            this.callback = statisticalCallback;
            return this;
        }

        public void setUseGlobalStatisticalManagerCallback(boolean z) {
            this.useGlobalStatisticalDataManagerCallback = z;
        }

        public void setHttpDnsOwner(boolean z) {
            this.httpDnsOwner = z;
        }

        public DidiHttpClient build() {
            return new DidiHttpClient(this);
        }
    }
}
