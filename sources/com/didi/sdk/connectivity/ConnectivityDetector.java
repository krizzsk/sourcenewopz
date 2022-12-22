package com.didi.sdk.connectivity;

import android.content.Context;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.connectivity.NetworkChangeHandler;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectivityDetector {

    /* renamed from: a */
    private static final String f35725a = "didi-connectivity";

    /* renamed from: b */
    private static ConnectivityDetector f35726b = null;

    /* renamed from: i */
    private static final int f35727i = 1000;

    /* renamed from: c */
    private AtomicBoolean f35728c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f35729d;

    /* renamed from: e */
    private ExecutorService f35730e = new ThreadPoolExecutor(0, 10, 60, TimeUnit.SECONDS, new SynchronousQueue(), new C12169e(f35725a, false), new ThreadPoolExecutor.DiscardPolicy() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (!threadPoolExecutor.isShutdown() && (runnable instanceof FutureTask)) {
                ((FutureTask) runnable).cancel(true);
            }
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Config f35731f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f35732g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile long f35733h;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile ConnectivityStatistics f35734j;

    private ConnectivityDetector() {
    }

    public static ConnectivityDetector getsInstance() {
        if (f35726b == null) {
            synchronized (ConnectivityDetector.class) {
                if (f35726b == null) {
                    f35726b = new ConnectivityDetector();
                }
            }
        }
        return f35726b;
    }

    public void init(Context context) {
        this.f35729d = context.getApplicationContext();
        if (this.f35728c.compareAndSet(false, true)) {
            NetworkChangeHandler.m25306a().mo91468a(context);
            NetworkChangeHandler.m25306a().mo91469a((NetworkChangeHandler.NetworkChangedCallback) new NetworkChangeHandler.NetworkChangedCallback() {
                public void onAvailable(Context context) {
                    if (ConnectivityDetector.this.f35731f != null) {
                        C12167c.m25331a(String.format("无网到有网，触发连通性检测。[当前网络 %s]", new Object[]{NetworkChangeHandler.m25308d(context)}));
                        ConnectivityDetector.this.detect();
                    }
                }

                public void onLost(Context context) {
                    if (ConnectivityDetector.this.f35731f != null) {
                        String d = NetworkChangeHandler.m25308d(context);
                        C12167c.m25331a(String.format("网络断开，当前网络[%s]", new Object[]{d}));
                        if (ConnectivityDetector.this.f35734j == null || ConnectivityDetector.this.f35734j.f35747l != ConnectivityStatusSource.NETWORK_CHANGED || ConnectivityDetector.this.f35734j.f35746k != ConnectivityStatus.UNREACHABLE) {
                            ConnectivityDetector connectivityDetector = ConnectivityDetector.this;
                            ConnectivityStatistics unused = connectivityDetector.f35734j = ConnectivityStatistics.m25303a(false, connectivityDetector.f35731f, d);
                        }
                    }
                }
            });
            Config config = (Config) new C12165a().provider();
            this.f35731f = config;
            if (config != null) {
                this.f35734j = ConnectivityStatistics.m25302a(NetworkChangeHandler.m25308d(context));
            }
        }
    }

    public void detect() {
        detect((String) null, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        if ((java.lang.System.currentTimeMillis() - r13.f35733h) >= ((long) (r13.f35731f.f35718e * 1000))) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        com.didi.sdk.connectivity.C12167c.m25331a("距离上次检测小于阈值，本次退出！");
        r13.f35732g = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r1 = new java.util.ArrayList();
        r2 = r13.f35731f.f35722i.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r2.hasNext() == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r3 = r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (com.didi.one.netdetect.util.NetUtil.isIpAddress(r3.host) == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        r4 = didihttpdns.HttpDnsManager.getInstance().lookup(r3.f35723ip);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r3.f35723ip = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006c, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0076, code lost:
        if (r15 <= 0) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        r6 = new com.didi.sdk.connectivity.Config.Item(r14, r15, r13.f35731f.f35716c, r13.f35731f.f35719f, r13.f35731f.f35720g, r13.f35731f.f35721h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0094, code lost:
        if (com.didi.one.netdetect.util.NetUtil.isIpAddress(r14) == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
        r1.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        r14 = didihttpdns.HttpDnsManager.getInstance().lookup(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a6, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        r6.f35723ip = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        r1.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        if (r1.size() != 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b3, code lost:
        r13.f35732g = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b6, code lost:
        r13.f35733h = java.lang.System.currentTimeMillis();
        com.didi.sdk.connectivity.C12167c.m25331a(java.lang.String.format("开始检测[当前网络 %s]", new java.lang.Object[]{com.didi.sdk.connectivity.NetworkChangeHandler.m25308d(r13.f35729d)}));
        r14 = r13.f35730e;
        r14.execute(new com.didi.sdk.connectivity.Task(r13.f35729d, r14, r1, new com.didi.sdk.connectivity.ConnectivityDetector.C121543(r13)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void detect(java.lang.String r14, int r15) {
        /*
            r13 = this;
            com.didi.sdk.connectivity.Config r0 = r13.f35731f
            if (r0 == 0) goto L_0x00e4
            android.content.Context r0 = r13.f35729d
            if (r0 != 0) goto L_0x000a
            goto L_0x00e4
        L_0x000a:
            monitor-enter(r13)
            boolean r0 = r13.f35732g     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x0016
            java.lang.String r14 = "正在检测，本次退出！"
            com.didi.sdk.connectivity.C12167c.m25331a((java.lang.String) r14)     // Catch:{ all -> 0x00e1 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            return
        L_0x0016:
            r0 = 1
            r13.f35732g = r0     // Catch:{ all -> 0x00e1 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r13.f35733h
            long r1 = r1 - r3
            com.didi.sdk.connectivity.Config r3 = r13.f35731f
            int r3 = r3.f35718e
            int r3 = r3 * 1000
            long r3 = (long) r3
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0035
            java.lang.String r14 = "距离上次检测小于阈值，本次退出！"
            com.didi.sdk.connectivity.C12167c.m25331a((java.lang.String) r14)
            r13.f35732g = r5
            return
        L_0x0035:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.didi.sdk.connectivity.Config r2 = r13.f35731f
            java.util.List<com.didi.sdk.connectivity.Config$Item> r2 = r2.f35722i
            java.util.Iterator r2 = r2.iterator()
        L_0x0042:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0070
            java.lang.Object r3 = r2.next()
            com.didi.sdk.connectivity.Config$Item r3 = (com.didi.sdk.connectivity.Config.Item) r3
            java.lang.String r4 = r3.host
            boolean r4 = com.didi.one.netdetect.util.NetUtil.isIpAddress(r4)
            if (r4 == 0) goto L_0x005a
            r1.add(r3)
            goto L_0x0042
        L_0x005a:
            didihttpdns.HttpDnsManager r4 = didihttpdns.HttpDnsManager.getInstance()
            java.lang.String r6 = r3.f35723ip
            java.lang.String r4 = r4.lookup(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x006c
            r3.f35723ip = r4
        L_0x006c:
            r1.add(r3)
            goto L_0x0042
        L_0x0070:
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 != 0) goto L_0x00ad
            if (r15 <= 0) goto L_0x00ad
            com.didi.sdk.connectivity.Config$Item r2 = new com.didi.sdk.connectivity.Config$Item
            com.didi.sdk.connectivity.Config r3 = r13.f35731f
            int r9 = r3.f35716c
            com.didi.sdk.connectivity.Config r3 = r13.f35731f
            int r10 = r3.f35719f
            com.didi.sdk.connectivity.Config r3 = r13.f35731f
            int r11 = r3.f35720g
            com.didi.sdk.connectivity.Config r3 = r13.f35731f
            int r12 = r3.f35721h
            r6 = r2
            r7 = r14
            r8 = r15
            r6.<init>(r7, r8, r9, r10, r11, r12)
            boolean r15 = com.didi.one.netdetect.util.NetUtil.isIpAddress(r14)
            if (r15 == 0) goto L_0x009a
            r1.add(r2)
            goto L_0x00ad
        L_0x009a:
            didihttpdns.HttpDnsManager r15 = didihttpdns.HttpDnsManager.getInstance()
            java.lang.String r14 = r15.lookup(r14)
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x00aa
            r2.f35723ip = r14
        L_0x00aa:
            r1.add(r2)
        L_0x00ad:
            int r14 = r1.size()
            if (r14 != 0) goto L_0x00b6
            r13.f35732g = r5
            return
        L_0x00b6:
            long r14 = java.lang.System.currentTimeMillis()
            r13.f35733h = r14
            java.lang.String r14 = "开始检测[当前网络 %s]"
            java.lang.Object[] r15 = new java.lang.Object[r0]
            android.content.Context r0 = r13.f35729d
            java.lang.String r0 = com.didi.sdk.connectivity.NetworkChangeHandler.m25308d(r0)
            r15[r5] = r0
            java.lang.String r14 = java.lang.String.format(r14, r15)
            com.didi.sdk.connectivity.C12167c.m25331a((java.lang.String) r14)
            java.util.concurrent.ExecutorService r14 = r13.f35730e
            com.didi.sdk.connectivity.Task r15 = new com.didi.sdk.connectivity.Task
            android.content.Context r0 = r13.f35729d
            com.didi.sdk.connectivity.ConnectivityDetector$3 r2 = new com.didi.sdk.connectivity.ConnectivityDetector$3
            r2.<init>()
            r15.<init>(r0, r14, r1, r2)
            r14.execute(r15)
            return
        L_0x00e1:
            r14 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            throw r14
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.connectivity.ConnectivityDetector.detect(java.lang.String, int):void");
    }

    public void trigger(String str, boolean z, Throwable th) {
        if (this.f35731f != null) {
            if (z) {
                if (this.f35734j == null || this.f35734j.f35747l != ConnectivityStatusSource.REQUEST_SUCCESS) {
                    C12167c.m25331a(String.format("%s 请求成功，标记为有网", new Object[]{str}));
                    this.f35734j = ConnectivityStatistics.m25300a(this.f35731f);
                }
            } else if (th == null || th.getMessage() == null || !th.getMessage().contains("Canceled")) {
                try {
                    URL url = new URL(str);
                    String host = url.getHost();
                    String protocol = url.getProtocol();
                    int i = "https".equals(protocol) ? 443 : "http".equals(protocol) ? 80 : 0;
                    C12167c.m25331a(String.format("%s 请求失败，触发检测", new Object[]{str}));
                    detect(host, i);
                } catch (Throwable th2) {
                    SystemUtils.log(3, f35725a, Log.getStackTraceString(th2), (Throwable) null, "com.didi.sdk.connectivity.ConnectivityDetector", 220);
                }
            }
        }
    }

    public ConnectivityStatistics getLastConnStatistics() {
        if (this.f35731f != null) {
            return this.f35734j;
        }
        return null;
    }
}
