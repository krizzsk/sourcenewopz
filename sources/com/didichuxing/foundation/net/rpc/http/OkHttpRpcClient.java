package com.didichuxing.foundation.net.rpc.http;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.net.DnsResolver;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.OkHttpRpc;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcNetworkInterceptor;
import com.didichuxing.foundation.rpc.RpcProtocol;
import com.didichuxing.foundation.spi.ServiceLoader;
import didihttp.Call;
import didihttp.Cookie;
import didihttp.CookieJar;
import didihttp.DidiHttpClient;
import didihttp.DidiUrlFactory;
import didihttp.Dispatcher;
import didihttp.Dns;
import didihttp.Headers;
import didihttp.HttpUrl;
import didihttp.Interceptor;
import didihttp.Protocol;
import didihttp.Response;
import didihttp.logging.HttpLoggingInterceptor;
import didinet.ProblemTracking;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

class OkHttpRpcClient extends HttpRpcClient implements C15577a, Cloneable {
    static final DidiHttpClient CLIENT = newDefaultOkHttpClientBuilder().build();
    static final CookieJar COOKIE_JAR = new DefaultCookieJar();
    private static final String SDCARD_CLASSLOADER_CRASH_DUMP_LOG = "/sdcard/.classloader_crash_dump.log";
    static final Map<String, String> USER_AGENTS = new ConcurrentHashMap();
    final Context mContext;
    final DidiHttpClient mDelegate;
    final String mUserAgent;

    static {
        Class<OkHttpRpcClient> cls = OkHttpRpcClient.class;
        DidiHttpClient.Builder newBuilder = CLIENT.newBuilder();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(128);
        dispatcher.setMaxRequestsPerHost(32);
        newBuilder.dispatcher(dispatcher);
        DidiHttpClient build = newBuilder.build();
        OkHttpRpcClient okHttpRpcClient = new OkHttpRpcClient(build, (Context) null);
        for (Interceptor next : build.interceptors()) {
            if (next instanceof OkHttpRpc.OkHttpRpcInterceptor) {
                ((OkHttpRpc.OkHttpRpcInterceptor) next).mClient = okHttpRpcClient;
            }
        }
        try {
            URL.setURLStreamHandlerFactory(new DidiUrlFactory(build));
            ProblemTracking.getInstance().recordContextInfo(cls, false, SDCARD_CLASSLOADER_CRASH_DUMP_LOG);
        } catch (Throwable unused) {
            ProblemTracking.getInstance().recordContextInfo(cls, true, SDCARD_CLASSLOADER_CRASH_DUMP_LOG);
        }
    }

    private static DidiHttpClient.Builder newDefaultOkHttpClientBuilder() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(256);
        dispatcher.setMaxRequestsPerHost(32);
        DidiHttpClient.Builder dispatcher2 = new DidiHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)).connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).cookieJar(COOKIE_JAR).dispatcher(dispatcher);
        Iterator<S> it = ServiceLoader.load(RpcInterceptor.class).iterator();
        while (it.hasNext()) {
            RpcInterceptor rpcInterceptor = (RpcInterceptor) it.next();
            if (rpcInterceptor != null) {
                if (rpcInterceptor instanceof RpcNetworkInterceptor) {
                    dispatcher2.networkInterceptors().add(new OkHttpRpc.OkHttpRpcInterceptor(rpcInterceptor));
                } else {
                    dispatcher2.interceptors().add(new OkHttpRpc.OkHttpRpcInterceptor(rpcInterceptor));
                }
            }
        }
        return dispatcher2;
    }

    private static String buildUserAgent(Context context) {
        String packageName = context == null ? "" : context.getPackageName();
        if (!USER_AGENTS.containsKey(packageName)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Android/");
            sb.append(Build.VERSION.RELEASE);
            sb.append(" ");
            sb.append("didihttp");
            sb.append(" ");
            sb.append("OneNet/");
            sb.append("2.1.1.18");
            if (context != null) {
                try {
                    String str = SystemUtils.getPackageInfo(context.getPackageManager(), packageName, 0).versionName;
                    sb.append(" ");
                    sb.append(packageName);
                    sb.append("/");
                    sb.append(str);
                } catch (Exception unused) {
                }
            }
            USER_AGENTS.put(packageName, sb.toString());
        }
        return USER_AGENTS.get(packageName);
    }

    OkHttpRpcClient(DidiHttpClient didiHttpClient, Context context) {
        this.mDelegate = didiHttpClient;
        this.mContext = context;
        this.mUserAgent = buildUserAgent(context);
    }

    private OkHttpRpcClient(Builder builder) {
        Iterator<Interceptor> it = builder.mDelegateBuilder.interceptors().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof UserAgentInterceptor) {
                it.remove();
            }
        }
        this.mContext = builder.mContext;
        this.mUserAgent = buildUserAgent(builder.mContext);
        DidiHttpClient build = builder.mDelegateBuilder.addInterceptor(new UserAgentInterceptor(this.mUserAgent)).build();
        this.mDelegate = build;
        for (Interceptor next : build.interceptors()) {
            if (next instanceof OkHttpRpc.OkHttpRpcInterceptor) {
                ((OkHttpRpc.OkHttpRpcInterceptor) next).mClient = this;
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public ExecutorService getExecutorService() {
        return this.mDelegate.dispatcher().executorService();
    }

    public void setInnerRetry(boolean z) {
        this.mDelegate.setRetryOnConnectionFailure(z);
    }

    public boolean getInnerRetry() {
        return this.mDelegate.retryOnConnectionFailure();
    }

    public void setDns(Dns dns) {
        this.mDelegate.setDns(dns);
    }

    public void setConnectTimeout(long j) {
        this.mDelegate.setConnectTimeout((int) j);
    }

    public long getConnectTimeout() {
        return (long) this.mDelegate.connectTimeoutMillis();
    }

    public void setReadTimeout(long j) {
        this.mDelegate.setReadTimeout((int) j);
    }

    public long getReadTimeout() {
        return (long) this.mDelegate.readTimeoutMillis();
    }

    public void setWriteTimeout(long j) {
        this.mDelegate.setWriteTimeout((int) j);
    }

    public long getWriteTimeout() {
        return (long) this.mDelegate.writeTimeoutMillis();
    }

    public SocketFactory getSocketFactory() {
        return this.mDelegate.socketFactory();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.mDelegate.sslSocketFactory();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.mDelegate.hostnameVerifier();
    }

    public CookieHandler getCookieHandler() {
        CookieJar cookieJar = this.mDelegate.cookieJar();
        if (cookieJar instanceof DefaultCookieJar) {
            return ((DefaultCookieJar) cookieJar).mCookieHandler;
        }
        return CookieHandler.getDefault();
    }

    public Proxy getProxy() {
        return this.mDelegate.proxy();
    }

    public DnsResolver getDnsResolver() {
        final Dns dns = this.mDelegate.dns();
        return dns == null ? DnsResolver.SYSTEM : new DnsResolver() {
            public List<InetAddress> resolve(String str) throws UnknownHostException {
                return dns.lookup(str);
            }
        };
    }

    public List<RpcProtocol> getProtocols() {
        ArrayList arrayList = new ArrayList();
        for (Protocol ordinal : this.mDelegate.protocols()) {
            int i = C155752.$SwitchMap$didihttp$Protocol[ordinal.ordinal()];
            if (i == 1) {
                arrayList.add(HttpRpcProtocol.HTTP_1_0);
            } else if (i == 2) {
                arrayList.add(HttpRpcProtocol.HTTP_1_1);
            } else if (i == 3) {
                arrayList.add(HttpRpcProtocol.HTTP_2_0);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public synchronized void cancel(Object obj) {
        if (obj instanceof Rpc) {
            ((Rpc) obj).cancel();
            return;
        }
        for (Call next : this.mDelegate.dispatcher().queuedCalls()) {
            if (next.request().tag().equals(obj)) {
                next.cancel();
            }
        }
        for (Call next2 : this.mDelegate.dispatcher().runningCalls()) {
            if (next2.request().tag().equals(obj)) {
                next2.cancel();
            }
        }
    }

    public OkHttpRpcClient clone() {
        return new OkHttpRpcClient(this.mDelegate.newBuilder().build(), this.mContext);
    }

    public HttpRpc newRpc(HttpRpcRequest httpRpcRequest) {
        return new OkHttpRpc(this, httpRpcRequest);
    }

    static final class Builder extends HttpRpcClient.Builder {
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public final DidiHttpClient.Builder mDelegateBuilder;

        public Builder() {
            this.mDelegateBuilder = OkHttpRpcClient.CLIENT.newBuilder();
        }

        public Builder(DidiHttpClient didiHttpClient) {
            this.mDelegateBuilder = didiHttpClient.newBuilder();
        }

        public Builder(OkHttpRpcClient okHttpRpcClient) {
            this.mContext = okHttpRpcClient.mContext;
            this.mDelegateBuilder = okHttpRpcClient.mDelegate.newBuilder();
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setProtocols(String... strArr) {
            if (strArr != null && strArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String parse : strArr) {
                    int i = C155752.f47607x61b6579[HttpRpcProtocol.parse(parse).ordinal()];
                    if (i == 1) {
                        arrayList.add(Protocol.HTTP_1_0);
                    } else if (i == 2) {
                        arrayList.add(Protocol.HTTP_1_1);
                    } else if (i == 3) {
                        arrayList.add(Protocol.HTTP_2);
                    }
                }
                this.mDelegateBuilder.protocols(arrayList);
            }
            return this;
        }

        public HttpRpcClient.Builder setInnerRetryOnConnectionFailure(boolean z) {
            this.mDelegateBuilder.retryOnConnectionFailure(z);
            return this;
        }

        public Builder setConnectTimeout(long j) {
            this.mDelegateBuilder.connectTimeout(j, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setReadTimeout(long j) {
            this.mDelegateBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setWriteTimeout(long j) {
            this.mDelegateBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setCookieHandler(CookieHandler cookieHandler) {
            this.mDelegateBuilder.cookieJar(new DefaultCookieJar(cookieHandler));
            return this;
        }

        public Builder setSocketFactory(SocketFactory socketFactory) {
            this.mDelegateBuilder.socketFactory(socketFactory);
            return this;
        }

        public Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.mDelegateBuilder.sslSocketFactory(sSLSocketFactory);
            return this;
        }

        public Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory, TrustManager trustManager) {
            this.mDelegateBuilder.sslSocketFactory(sSLSocketFactory, (X509TrustManager) trustManager);
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.mDelegateBuilder.hostnameVerifier(hostnameVerifier);
            return this;
        }

        public Builder setProxy(Proxy proxy) {
            this.mDelegateBuilder.proxy(proxy);
            return this;
        }

        public Builder setDnsResolver(final DnsResolver dnsResolver) {
            if (dnsResolver != null) {
                this.mDelegateBuilder.dns(new Dns() {
                    public List<InetAddress> lookup(String str) throws UnknownHostException {
                        try {
                            List<InetAddress> resolve = dnsResolver.resolve(str);
                            if (resolve != null && resolve.size() > 0) {
                                return resolve;
                            }
                        } catch (UnknownHostException unused) {
                        }
                        return Dns.SYSTEM.lookup(str);
                    }
                });
                return this;
            }
            throw new NullPointerException("DNS resolver is null");
        }

        public Builder setExecutorService(ExecutorService executorService) {
            this.mDelegateBuilder.dispatcher(new Dispatcher(executorService));
            return this;
        }

        public Builder addInterceptor(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor) {
            OkHttpRpc.OkHttpRpcInterceptor okHttpRpcInterceptor = new OkHttpRpc.OkHttpRpcInterceptor(rpcInterceptor);
            if (rpcInterceptor instanceof RpcNetworkInterceptor) {
                this.mDelegateBuilder.addNetworkInterceptor(okHttpRpcInterceptor);
            } else {
                this.mDelegateBuilder.addInterceptor(okHttpRpcInterceptor);
            }
            return this;
        }

        public OkHttpRpcClient build() {
            return new OkHttpRpcClient(this);
        }
    }

    /* renamed from: com.didichuxing.foundation.net.rpc.http.OkHttpRpcClient$2 */
    static /* synthetic */ class C155752 {

        /* renamed from: $SwitchMap$com$didichuxing$foundation$net$rpc$http$HttpRpcProtocol */
        static final /* synthetic */ int[] f47607x61b6579;
        static final /* synthetic */ int[] $SwitchMap$didihttp$Protocol;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol[] r0 = com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47607x61b6579 = r0
                r1 = 1
                com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol r2 = com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol.HTTP_1_0     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f47607x61b6579     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol r3 = com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol.HTTP_1_1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f47607x61b6579     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol r4 = com.didichuxing.foundation.net.rpc.http.HttpRpcProtocol.HTTP_2_0     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                didihttp.Protocol[] r3 = didihttp.Protocol.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$didihttp$Protocol = r3
                didihttp.Protocol r4 = didihttp.Protocol.HTTP_1_0     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$didihttp$Protocol     // Catch:{ NoSuchFieldError -> 0x0043 }
                didihttp.Protocol r3 = didihttp.Protocol.HTTP_1_1     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$didihttp$Protocol     // Catch:{ NoSuchFieldError -> 0x004d }
                didihttp.Protocol r1 = didihttp.Protocol.HTTP_2     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.net.rpc.http.OkHttpRpcClient.C155752.<clinit>():void");
        }
    }

    private static final class DefaultCookieJar implements CookieJar {
        /* access modifiers changed from: private */
        public final CookieHandler mCookieHandler;

        public DefaultCookieJar() {
            this(CookieHandler.getDefault());
        }

        public DefaultCookieJar(CookieHandler cookieHandler) {
            this.mCookieHandler = cookieHandler == null ? new CookieManager() : cookieHandler;
        }

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Cookie cookie : list) {
                linkedHashMap.put("Set-Cookie", Collections.singletonList(cookie.toString()));
            }
            try {
                this.mCookieHandler.put(new URI(httpUrl.toString()), linkedHashMap);
            } catch (Exception unused) {
            }
        }

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            try {
                Map<String, List<String>> map = this.mCookieHandler.get(new URI(httpUrl.toString()), Collections.emptyMap());
                Headers.Builder builder = new Headers.Builder();
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    for (String add : (List) next.getValue()) {
                        builder.add(str, add);
                    }
                }
                return Cookie.parseAll(httpUrl, builder.build());
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        }
    }

    private static final class UserAgentInterceptor implements Interceptor {
        final String mUserAgent;

        public UserAgentInterceptor(String str) {
            this.mUserAgent = str;
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", this.mUserAgent).build());
        }
    }
}
