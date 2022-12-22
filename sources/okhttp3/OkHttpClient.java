package okhttp3;

import com.didiglobal.privacy.domainmonitor.okhttp.OkHttpHooker;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.C2434Util;
import okhttp3.internal.Internal;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p070ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {

    /* renamed from: a */
    static final List<Protocol> f5196a = C2434Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: b */
    static final List<ConnectionSpec> f5197b = C2434Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});

    /* renamed from: A */
    final int f5198A;

    /* renamed from: B */
    final int f5199B;

    /* renamed from: C */
    final int f5200C;

    /* renamed from: D */
    final int f5201D;

    /* renamed from: c */
    final Dispatcher f5202c;
    @Nullable

    /* renamed from: d */
    final Proxy f5203d;

    /* renamed from: e */
    final List<Protocol> f5204e;

    /* renamed from: f */
    final List<ConnectionSpec> f5205f;

    /* renamed from: g */
    final List<Interceptor> f5206g;

    /* renamed from: h */
    final List<Interceptor> f5207h;

    /* renamed from: i */
    final EventListener.Factory f5208i;

    /* renamed from: j */
    final ProxySelector f5209j;

    /* renamed from: k */
    final CookieJar f5210k;
    @Nullable

    /* renamed from: l */
    final Cache f5211l;
    @Nullable

    /* renamed from: m */
    final InternalCache f5212m;

    /* renamed from: n */
    final SocketFactory f5213n;

    /* renamed from: o */
    final SSLSocketFactory f5214o;

    /* renamed from: p */
    final CertificateChainCleaner f5215p;

    /* renamed from: q */
    final HostnameVerifier f5216q;

    /* renamed from: r */
    final CertificatePinner f5217r;

    /* renamed from: s */
    final Authenticator f5218s;

    /* renamed from: t */
    final Authenticator f5219t;

    /* renamed from: u */
    final ConnectionPool f5220u;

    /* renamed from: v */
    final Dns f5221v;

    /* renamed from: w */
    final boolean f5222w;

    /* renamed from: x */
    final boolean f5223x;

    /* renamed from: y */
    final boolean f5224y;

    /* renamed from: z */
    final int f5225z;

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
                return connectionPool.mo24705b(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.mo24703a(address, streamAllocation, route);
            }

            public boolean equalsNonHost(Address address, Address address2) {
                return address.mo24586a(address2);
            }

            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo24702a(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.mo24704a(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f5118a;
            }

            public int code(Response.Builder builder) {
                return builder.code;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.mo24710a(sSLSocket, z);
            }

            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).mo24993b();
            }

            @Nullable
            public IOException timeoutExit(Call call, @Nullable IOException iOException) {
                return ((RealCall) call).mo24991a(iOException);
            }

            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.m3373a(okHttpClient, request, true);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        boolean z;
        this.f5202c = builder.dispatcher;
        this.f5203d = builder.proxy;
        this.f5204e = builder.protocols;
        this.f5205f = builder.connectionSpecs;
        this.f5206g = C2434Util.immutableList(builder.interceptors);
        this.f5207h = C2434Util.immutableList(builder.networkInterceptors);
        this.f5208i = builder.eventListenerFactory;
        this.f5209j = builder.proxySelector;
        this.f5210k = builder.cookieJar;
        this.f5211l = builder.cache;
        this.f5212m = builder.internalCache;
        this.f5213n = builder.socketFactory;
        Iterator<ConnectionSpec> it = this.f5205f.iterator();
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
            this.f5214o = builder.sslSocketFactory;
            this.f5215p = builder.certificateChainCleaner;
        } else {
            X509TrustManager platformTrustManager = C2434Util.platformTrustManager();
            this.f5214o = m3370a(platformTrustManager);
            this.f5215p = CertificateChainCleaner.get(platformTrustManager);
        }
        if (this.f5214o != null) {
            Platform.get().configureSslSocketFactory(this.f5214o);
        }
        this.f5216q = builder.hostnameVerifier;
        this.f5217r = builder.certificatePinner.mo24674a(this.f5215p);
        this.f5218s = builder.proxyAuthenticator;
        this.f5219t = builder.authenticator;
        this.f5220u = builder.connectionPool;
        this.f5221v = builder.dns;
        this.f5222w = builder.followSslRedirects;
        this.f5223x = builder.followRedirects;
        this.f5224y = builder.retryOnConnectionFailure;
        this.f5225z = builder.callTimeout;
        this.f5198A = builder.connectTimeout;
        this.f5199B = builder.readTimeout;
        this.f5200C = builder.writeTimeout;
        this.f5201D = builder.pingInterval;
        if (this.f5206g.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f5206g);
        } else if (this.f5207h.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f5207h);
        }
    }

    /* renamed from: a */
    private static SSLSocketFactory m3370a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C2434Util.assertionError("No System TLS", e);
        }
    }

    public int callTimeoutMillis() {
        return this.f5225z;
    }

    public int connectTimeoutMillis() {
        return this.f5198A;
    }

    public int readTimeoutMillis() {
        return this.f5199B;
    }

    public int writeTimeoutMillis() {
        return this.f5200C;
    }

    public int pingIntervalMillis() {
        return this.f5201D;
    }

    @Nullable
    public Proxy proxy() {
        return this.f5203d;
    }

    public ProxySelector proxySelector() {
        return this.f5209j;
    }

    public CookieJar cookieJar() {
        return this.f5210k;
    }

    @Nullable
    public Cache cache() {
        return this.f5211l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InternalCache mo24909a() {
        Cache cache = this.f5211l;
        return cache != null ? cache.f5089a : this.f5212m;
    }

    public Dns dns() {
        return this.f5221v;
    }

    public SocketFactory socketFactory() {
        return this.f5213n;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f5214o;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f5216q;
    }

    public CertificatePinner certificatePinner() {
        return this.f5217r;
    }

    public Authenticator authenticator() {
        return this.f5219t;
    }

    public Authenticator proxyAuthenticator() {
        return this.f5218s;
    }

    public ConnectionPool connectionPool() {
        return this.f5220u;
    }

    public boolean followSslRedirects() {
        return this.f5222w;
    }

    public boolean followRedirects() {
        return this.f5223x;
    }

    public boolean retryOnConnectionFailure() {
        return this.f5224y;
    }

    public Dispatcher dispatcher() {
        return this.f5202c;
    }

    public List<Protocol> protocols() {
        return this.f5204e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f5205f;
    }

    public List<Interceptor> interceptors() {
        return this.f5206g;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f5207h;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.f5208i;
    }

    public Call newCall(Request request) {
        return RealCall.m3373a(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), (long) this.f5201D);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        Authenticator authenticator;
        @Nullable
        Cache cache;
        int callTimeout;
        @Nullable
        CertificateChainCleaner certificateChainCleaner;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        EventListener.Factory eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        @Nullable
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;
        @Nullable
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        @Nullable
        SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.f5196a;
            this.connectionSpecs = OkHttpClient.f5197b;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            ProxySelector proxySelector2 = ProxySelector.getDefault();
            this.proxySelector = proxySelector2;
            if (proxySelector2 == null) {
                this.proxySelector = new NullProxySelector();
            }
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
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
            this.networkInterceptors.addAll(OkHttpHooker.globalNetworkInterceptors);
        }

        Builder(OkHttpClient okHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.f5202c;
            this.proxy = okHttpClient.f5203d;
            this.protocols = okHttpClient.f5204e;
            this.connectionSpecs = okHttpClient.f5205f;
            this.interceptors.addAll(okHttpClient.f5206g);
            this.networkInterceptors.addAll(okHttpClient.f5207h);
            this.eventListenerFactory = okHttpClient.f5208i;
            this.proxySelector = okHttpClient.f5209j;
            this.cookieJar = okHttpClient.f5210k;
            this.internalCache = okHttpClient.f5212m;
            this.cache = okHttpClient.f5211l;
            this.socketFactory = okHttpClient.f5213n;
            this.sslSocketFactory = okHttpClient.f5214o;
            this.certificateChainCleaner = okHttpClient.f5215p;
            this.hostnameVerifier = okHttpClient.f5216q;
            this.certificatePinner = okHttpClient.f5217r;
            this.proxyAuthenticator = okHttpClient.f5218s;
            this.authenticator = okHttpClient.f5219t;
            this.connectionPool = okHttpClient.f5220u;
            this.dns = okHttpClient.f5221v;
            this.followSslRedirects = okHttpClient.f5222w;
            this.followRedirects = okHttpClient.f5223x;
            this.retryOnConnectionFailure = okHttpClient.f5224y;
            this.callTimeout = okHttpClient.f5225z;
            this.connectTimeout = okHttpClient.f5198A;
            this.readTimeout = okHttpClient.f5199B;
            this.writeTimeout = okHttpClient.f5200C;
            this.pingInterval = okHttpClient.f5201D;
            this.networkInterceptors.addAll(OkHttpHooker.globalNetworkInterceptors);
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.callTimeout = C2434Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder callTimeout(Duration duration) {
            this.callTimeout = C2434Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = C2434Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder connectTimeout(Duration duration) {
            this.connectTimeout = C2434Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = C2434Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(Duration duration) {
            this.readTimeout = C2434Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = C2434Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(Duration duration) {
            this.writeTimeout = C2434Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = C2434Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public Builder pingInterval(Duration duration) {
            this.pingInterval = C2434Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder proxy(@Nullable Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector2) {
            if (proxySelector2 != null) {
                this.proxySelector = proxySelector2;
                return this;
            }
            throw new NullPointerException("proxySelector == null");
        }

        public Builder cookieJar(CookieJar cookieJar2) {
            if (cookieJar2 != null) {
                this.cookieJar = cookieJar2;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        /* access modifiers changed from: package-private */
        public void setInternalCache(@Nullable InternalCache internalCache2) {
            this.internalCache = internalCache2;
            this.cache = null;
        }

        public Builder cache(@Nullable Cache cache2) {
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
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                return this;
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
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.protocols = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = C2434Util.immutableList(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener != null) {
                this.eventListenerFactory = EventListener.factory(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory != null) {
                this.eventListenerFactory = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }
    }
}
