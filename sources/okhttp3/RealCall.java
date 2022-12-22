package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

final class RealCall implements Call {

    /* renamed from: a */
    final OkHttpClient f5226a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f5227b;

    /* renamed from: c */
    final AsyncTimeout f5228c;

    /* renamed from: d */
    final Request f5229d;

    /* renamed from: e */
    final boolean f5230e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public EventListener f5231f;

    /* renamed from: g */
    private boolean f5232g;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f5226a = okHttpClient;
        this.f5229d = request;
        this.f5230e = z;
        this.f5227b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        C24281 r4 = new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.f5228c = r4;
        r4.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    static RealCall m3373a(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.f5231f = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public Request request() {
        return this.f5229d;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.f5232g) {
                this.f5232g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m3374f();
        this.f5228c.enter();
        this.f5231f.callStart(this);
        try {
            this.f5226a.dispatcher().mo24753a(this);
            Response e = mo24996e();
            if (e != null) {
                this.f5226a.dispatcher().mo24755b(this);
                return e;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            IOException a = mo24991a(e2);
            this.f5231f.callFailed(this, a);
            throw a;
        } catch (Throwable th) {
            this.f5226a.dispatcher().mo24755b(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public IOException mo24991a(@Nullable IOException iOException) {
        if (!this.f5228c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: f */
    private void m3374f() {
        this.f5227b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f5232g) {
                this.f5232g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m3374f();
        this.f5231f.callStart(this);
        this.f5226a.dispatcher().mo24752a(new AsyncCall(callback));
    }

    public void cancel() {
        this.f5227b.cancel();
    }

    public Timeout timeout() {
        return this.f5228c;
    }

    public synchronized boolean isExecuted() {
        return this.f5232g;
    }

    public boolean isCanceled() {
        return this.f5227b.isCanceled();
    }

    /* renamed from: a */
    public RealCall clone() {
        return m3373a(this.f5226a, this.f5229d, this.f5230e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public StreamAllocation mo24993b() {
        return this.f5227b.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.mo24995d());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.f5229d.url().host();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.f5229d;
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                RealCall.this.f5231f.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.f5226a.dispatcher().mo24754b(this);
            } catch (Throwable th) {
                RealCall.this.f5226a.dispatcher().mo24754b(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ all -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[Catch:{ all -> 0x003d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okio.AsyncTimeout r0 = r0.f5228c
                r0.enter()
                r0 = 1
                r1 = 0
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.Response r2 = r2.mo24996e()     // Catch:{ IOException -> 0x003f }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.internal.http.RetryAndFollowUpInterceptor r3 = r3.f5227b     // Catch:{ IOException -> 0x003f }
                boolean r1 = r3.isCanceled()     // Catch:{ IOException -> 0x003f }
                if (r1 == 0) goto L_0x0028
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x003b }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003b }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x003b }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x003b }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x003b }
                goto L_0x002f
            L_0x0028:
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x003b }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003b }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x003b }
            L_0x002f:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.f5226a
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.mo24754b((okhttp3.RealCall.AsyncCall) r5)
                goto L_0x007d
            L_0x003b:
                r1 = move-exception
                goto L_0x0042
            L_0x003d:
                r0 = move-exception
                goto L_0x007e
            L_0x003f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0042:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                java.io.IOException r1 = r2.mo24991a((java.io.IOException) r1)     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x006a
                okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x003d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
                r3.<init>()     // Catch:{ all -> 0x003d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                java.lang.String r4 = r4.mo24994c()     // Catch:{ all -> 0x003d }
                r3.append(r4)     // Catch:{ all -> 0x003d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003d }
                r0.log(r2, r3, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x006a:
                okhttp3.RealCall r0 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                okhttp3.EventListener r0 = r0.f5231f     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                r0.callFailed(r2, r1)     // Catch:{ all -> 0x003d }
                okhttp3.Callback r0 = r5.responseCallback     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x007d:
                return
            L_0x007e:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.f5226a
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.mo24754b((okhttp3.RealCall.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo24994c() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f5230e ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo24995d());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo24995d() {
        return this.f5229d.url().redact();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Response mo24996e() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5226a.interceptors());
        arrayList.add(this.f5227b);
        arrayList.add(new BridgeInterceptor(this.f5226a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f5226a.mo24909a()));
        arrayList.add(new ConnectInterceptor(this.f5226a));
        if (!this.f5230e) {
            arrayList.addAll(this.f5226a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.f5230e));
        return new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.f5229d, this, this.f5231f, this.f5226a.connectTimeoutMillis(), this.f5226a.readTimeoutMillis(), this.f5226a.writeTimeoutMillis()).proceed(this.f5229d);
    }
}
