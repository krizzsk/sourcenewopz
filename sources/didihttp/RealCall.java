package didihttp;

import android.os.Process;
import androidx.core.app.NotificationCompat;
import didihttp.DefaultLogEventHandle;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.internal.NamedRunnable;
import didihttp.internal.cache.CacheInterceptor;
import didihttp.internal.connection.ConnectInterceptor;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.http.BridgeInterceptor;
import didihttp.internal.http.CallServerInterceptor;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http.RealInterceptorChain;
import didihttp.internal.http.RetryAndFollowUpInterceptor;
import didihttp.internal.platform.Platform;
import didihttp.internal.trace.Tree;
import didihttp.logging.HttpLoggingInterceptor;
import didihttpdns.HttpDnsApolloConfig;
import didihttpdns.HttpDnsSwitchInterceptor;
import didinet.NetConfig;
import didinet.NetEngine;
import didinet.ParamInterceptor;
import diditransreq.ConnectSwitcherInterceptor;
import diditransreq.Http2SocketInterceptor;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;

final class RealCall implements Call {

    /* renamed from: e */
    private static LogEventListener.Factory f56478e = new DefaultLogEventHandle.FACTORY();

    /* renamed from: a */
    final DidiHttpClient f56479a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f56480b;

    /* renamed from: c */
    final Request f56481c;

    /* renamed from: d */
    final boolean f56482d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LogEventListener f56483f;

    /* renamed from: g */
    private boolean f56484g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public StatisticalContext f56485h;

    private RealCall(DidiHttpClient didiHttpClient, Request request, boolean z) {
        this.f56479a = didiHttpClient;
        this.f56481c = request;
        this.f56482d = z;
        this.f56480b = new RetryAndFollowUpInterceptor(didiHttpClient, z);
        this.f56485h = new StatisticalContext(didiHttpClient, this);
    }

    /* renamed from: a */
    static RealCall m40631a(DidiHttpClient didiHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(didiHttpClient, request, z);
        realCall.f56483f = f56478e.create(realCall);
        return realCall;
    }

    public Request request() {
        return this.f56481c;
    }

    public Response execute() throws IOException {
        this.f56485h.traceTotalStartTime();
        synchronized (this) {
            if (!this.f56484g) {
                this.f56484g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f56483f.callStart(this, Process.myTid());
        m40636f();
        try {
            this.f56479a.dispatcher().mo169586a(this);
            Response e = mo169728e();
            if (e != null) {
                this.f56483f.callEnd(this);
                this.f56479a.dispatcher().mo169588b(this);
                return e;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            this.f56483f.callFailed(this, e2);
            throw e2;
        } catch (Throwable th) {
            this.f56483f.callEnd(this);
            this.f56479a.dispatcher().mo169588b(this);
            throw th;
        }
    }

    /* renamed from: f */
    private void m40636f() {
        this.f56480b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f56484g) {
                this.f56484g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f56483f.enqueue(this);
        m40636f();
        this.f56485h.traceTotalStartTime();
        this.f56479a.dispatcher().mo169585a(new AsyncCall(callback));
    }

    public void cancel() {
        this.f56480b.cancel();
    }

    public synchronized boolean isExecuted() {
        return this.f56484g;
    }

    public boolean isCanceled() {
        return this.f56480b.isCanceled();
    }

    /* renamed from: a */
    public RealCall clone() {
        return m40631a(this.f56479a, this.f56481c, this.f56482d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public StreamAllocation mo169725b() {
        return this.f56480b.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.mo169727d());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.f56481c.url().hostAndPath();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.f56481c;
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0098 A[Catch:{ all -> 0x0087 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00b8 A[Catch:{ all -> 0x0087 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r6 = this;
                didihttp.RealCall r0 = didihttp.RealCall.this
                didihttp.StatisticalContext r0 = r0.f56485h
                r0.traceExecuteTime()
                int r0 = android.os.Process.myTid()
                didihttp.RealCall r1 = didihttp.RealCall.this
                didihttp.LogEventListener r1 = r1.f56483f
                didihttp.RealCall r2 = didihttp.RealCall.this
                r1.callStart(r2, r0)
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.String r0 = r0.getName()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r2 = 1
                java.lang.Object[] r3 = new java.lang.Object[r2]
                didihttp.RealCall r4 = didihttp.RealCall.this
                didihttp.Request r4 = r4.f56481c
                didihttp.HttpUrl r4 = r4.f56486a
                java.lang.String r4 = r4.toString()
                java.lang.String r4 = didihttp.RealCall.m40633a((java.lang.String) r4)
                r5 = 0
                r3[r5] = r4
                java.lang.String r4 = "OneNet %s"
                java.lang.String r3 = java.lang.String.format(r4, r3)
                r1.setName(r3)
                didihttp.RealCall r1 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0089 }
                didihttp.Response r1 = r1.mo169728e()     // Catch:{ IOException -> 0x0089 }
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0089 }
                didihttp.internal.http.RetryAndFollowUpInterceptor r3 = r3.f56480b     // Catch:{ IOException -> 0x0089 }
                boolean r3 = r3.isCanceled()     // Catch:{ IOException -> 0x0089 }
                if (r3 == 0) goto L_0x0060
                didihttp.Callback r1 = r6.responseCallback     // Catch:{ IOException -> 0x0085 }
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0085 }
                java.io.IOException r4 = new java.io.IOException     // Catch:{ IOException -> 0x0085 }
                java.lang.String r5 = "Canceled"
                r4.<init>(r5)     // Catch:{ IOException -> 0x0085 }
                r1.onFailure(r3, r4)     // Catch:{ IOException -> 0x0085 }
                goto L_0x0067
            L_0x0060:
                didihttp.Callback r3 = r6.responseCallback     // Catch:{ IOException -> 0x0085 }
                didihttp.RealCall r4 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0085 }
                r3.onResponse(r4, r1)     // Catch:{ IOException -> 0x0085 }
            L_0x0067:
                didihttp.RealCall r1 = didihttp.RealCall.this
                didihttp.LogEventListener r1 = r1.f56483f
                didihttp.RealCall r2 = didihttp.RealCall.this
                r1.callEnd(r2)
                didihttp.RealCall r1 = didihttp.RealCall.this
                didihttp.DidiHttpClient r1 = r1.f56479a
                didihttp.Dispatcher r1 = r1.dispatcher()
                r1.mo169587b((didihttp.RealCall.AsyncCall) r6)
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.setName(r0)
                goto L_0x00c0
            L_0x0085:
                r1 = move-exception
                goto L_0x008b
            L_0x0087:
                r1 = move-exception
                goto L_0x00c1
            L_0x0089:
                r1 = move-exception
                r2 = 0
            L_0x008b:
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                didihttp.LogEventListener r3 = r3.f56483f     // Catch:{ all -> 0x0087 }
                didihttp.RealCall r4 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                r3.callFailed(r4, r1)     // Catch:{ all -> 0x0087 }
                if (r2 == 0) goto L_0x00b8
                didihttp.internal.platform.Platform r2 = didihttp.internal.platform.Platform.get()     // Catch:{ all -> 0x0087 }
                r3 = 4
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
                r4.<init>()     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                didihttp.RealCall r5 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = r5.mo169726c()     // Catch:{ all -> 0x0087 }
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0087 }
                r2.log(r3, r4, r1)     // Catch:{ all -> 0x0087 }
                goto L_0x0067
            L_0x00b8:
                didihttp.Callback r2 = r6.responseCallback     // Catch:{ all -> 0x0087 }
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0087 }
                goto L_0x0067
            L_0x00c0:
                return
            L_0x00c1:
                didihttp.RealCall r2 = didihttp.RealCall.this
                didihttp.LogEventListener r2 = r2.f56483f
                didihttp.RealCall r3 = didihttp.RealCall.this
                r2.callEnd(r3)
                didihttp.RealCall r2 = didihttp.RealCall.this
                didihttp.DidiHttpClient r2 = r2.f56479a
                didihttp.Dispatcher r2 = r2.dispatcher()
                r2.mo169587b((didihttp.RealCall.AsyncCall) r6)
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.setName(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo169726c() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f56482d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo169727d());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo169727d() {
        return this.f56481c.url().redact();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Response mo169728e() throws IOException {
        NetConfig.UrlConfig urlConfig;
        this.f56485h.newServerCallData();
        Tree tree = new Tree();
        this.f56485h.setInterceptorCallTree(tree);
        NetEngine instance = NetEngine.getInstance();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f56479a.interceptors());
            arrayList.add(new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    ((StatisticalContext) ((RealInterceptorChain) chain).getExtraData()).mo169897a(request);
                    return chain.proceed(request);
                }
            });
            if (NetEngine.getInstance().getNetConfig().isReportRawData() && (urlConfig = NetEngine.getInstance().getNetConfig().getUrlConfig(request().f56486a)) != null && urlConfig.isReportRawData()) {
                arrayList.add(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    public void log(String str) {
                        StatisticalContext a = RealCall.this.f56485h;
                        a.appendRawHttpData(str + "\n");
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY));
            }
            arrayList.add(new ParamInterceptor());
            Interceptor transformInterceptor = instance.getTransformInterceptor();
            if (transformInterceptor != null) {
                arrayList.add(transformInterceptor);
            } else if (!this.f56479a.f56388E) {
                arrayList.add(new HttpDnsSwitchInterceptor());
            }
            arrayList.add(this.f56480b);
            arrayList.add(new BridgeInterceptor(this.f56479a.cookieJar()));
            arrayList.add(new CacheInterceptor(this.f56479a.mo169498a()));
            arrayList.add(new ConnectSwitcherInterceptor(new ConnectInterceptor(this.f56479a)));
            if (!this.f56482d) {
                arrayList.addAll(this.f56479a.networkInterceptors());
            }
            arrayList.add(new Http2SocketInterceptor());
            arrayList.add(new CallServerInterceptor(this.f56482d));
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (Connection) null, 0, this.f56481c, this, this.f56483f, tree);
            realInterceptorChain.setExtraData(this.f56485h);
            Response proceed = realInterceptorChain.proceed(this.f56481c);
            m40634a(this.f56485h);
            return proceed;
        } catch (Throwable th) {
            tree.popAll();
            this.f56485h.mo169898a(th);
            m40634a(this.f56485h);
            if ((th instanceof SecurityException) || (th instanceof UnsatisfiedLinkError) || (th instanceof IllegalArgumentException)) {
                throw new IOException(th);
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m40634a(StatisticalContext statisticalContext) {
        statisticalContext.traceTotalEndTime();
        if (HttpDnsApolloConfig.getConfig().isDegenerateIpv6Detect() && !statisticalContext.hasError() && (statisticalContext.currentServerCallData().getRemoteAddress() instanceof Inet4Address)) {
            HttpDnsApolloConfig.getConfig().setEnableIpv6Apollo(true);
        }
        if (this.f56479a.f56387D) {
            for (StatisticalCallback next : NetEngine.getInstance().getStatisticalCallbacks()) {
                if (next != null) {
                    try {
                        next.onStatisticalDataCallback(statisticalContext);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (this.f56479a.f56386C != null) {
            try {
                this.f56479a.f56386C.onStatisticalDataCallback(statisticalContext);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: a */
    static String m40633a(String str) {
        int indexOf = str.indexOf(63);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
