package com.didi.ifx.license;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class IFXLicenseClient {

    /* renamed from: a */
    private static volatile IFXLicenseClient f24221a = null;

    /* renamed from: b */
    private static volatile boolean f24222b = false;

    /* renamed from: c */
    private static volatile boolean f24223c = true;

    /* renamed from: d */
    private final MediaType f24224d = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: e */
    private String f24225e;

    /* renamed from: f */
    private Context f24226f;

    /* renamed from: g */
    private int f24227g;

    /* renamed from: h */
    private String f24228h;

    /* renamed from: i */
    private volatile boolean f24229i;

    /* renamed from: j */
    private volatile int f24230j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile HashMap<Integer, IFXModel> f24231k;

    /* renamed from: l */
    private OkHttpClient f24232l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Gson f24233m;

    /* renamed from: n */
    private ScheduledExecutorService f24234n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f24235o;

    /* renamed from: p */
    private volatile boolean f24236p;

    /* renamed from: q */
    private boolean f24237q;

    /* renamed from: r */
    private ScheduledExecutorService f24238r;

    /* renamed from: s */
    private int f24239s;

    /* renamed from: t */
    private volatile boolean f24240t;

    /* renamed from: u */
    private MonitorThread f24241u;

    /* renamed from: v */
    private volatile boolean f24242v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C9283c f24243w;

    private class HeartBeat implements Runnable {
        private HeartBeat() {
        }

        public void run() {
            if (IFXLicenseClient.this.f24231k.size() > 0) {
                for (IFXModel a : IFXLicenseClient.this.f24231k.values()) {
                    IFXLicenseClient.this.m17290a(a);
                }
            }
        }
    }

    private class InferenceReporter implements Runnable {
        private InferenceReporter() {
        }

        public void run() {
            if (IFXLicenseClient.this.f24231k.size() > 0) {
                for (IFXModel iFXModel : IFXLicenseClient.this.f24231k.values()) {
                    if (iFXModel.f24270q > 0 && iFXModel.f24273t % iFXModel.f24272s == 0) {
                        iFXModel.mo71621a();
                    }
                    int i = iFXModel.f24273t + 1;
                    iFXModel.f24273t = i;
                    if (i >= iFXModel.f24272s) {
                        iFXModel.f24273t = 0;
                    }
                }
            }
        }
    }

    private class MonitorThread extends Thread {
        private MonitorThread() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(IFXLicenseClient.this.f24235o * 1000);
                    IFXLicenseClient.this.m17300c();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    private IFXLicenseClient(Context context) {
        this.f24226f = context;
        this.f24227g = 100;
        this.f24231k = new HashMap<>();
        this.f24230j = 0;
        this.f24228h = C9282b.m17452a(this.f24226f);
        this.f24233m = new GsonBuilder().create();
        this.f24225e = "https://ifx-license.didiglobal.com/v1/license/register";
        this.f24235o = 2;
        this.f24236p = false;
        this.f24242v = false;
        this.f24229i = true;
        this.f24237q = false;
        this.f24240t = false;
        f24222b = true;
        m17283a();
        this.f24243w = new C9283c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m17300c() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService;
        if (this.f24231k.size() > 0) {
            long j = Long.MAX_VALUE;
            for (IFXModel iFXModel : this.f24231k.values()) {
                long j2 = iFXModel.f24263j;
                if (j2 < j) {
                    j = j2;
                }
            }
            if (j != this.f24235o) {
                this.f24235o = j;
                z = true;
                if (z && (scheduledExecutorService = this.f24234n) != null && !scheduledExecutorService.isShutdown()) {
                    this.f24234n.shutdown();
                    ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                    this.f24234n = newSingleThreadScheduledExecutor;
                    newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(), 5, this.f24235o, TimeUnit.SECONDS);
                    this.f24236p = true;
                    SystemUtils.log(3, "IFXLicenseClient", "Reset heartbeat thread with time(s) " + this.f24235o, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 23);
                }
            }
        }
        z = false;
        this.f24234n.shutdown();
        ScheduledExecutorService newSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor();
        this.f24234n = newSingleThreadScheduledExecutor2;
        newSingleThreadScheduledExecutor2.scheduleWithFixedDelay(new HeartBeat(), 5, this.f24235o, TimeUnit.SECONDS);
        this.f24236p = true;
        SystemUtils.log(3, "IFXLicenseClient", "Reset heartbeat thread with time(s) " + this.f24235o, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 23);
    }

    /* renamed from: d */
    private synchronized void m17304d() {
        ScheduledExecutorService scheduledExecutorService = this.f24234n;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        this.f24236p = false;
    }

    /* renamed from: f */
    private synchronized void m17307f() {
        MonitorThread monitorThread = this.f24241u;
        if (monitorThread != null) {
            monitorThread.interrupt();
        }
        this.f24242v = false;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.didi.ifx.license.IFXLicenseClient getIFXLicenseClient(android.content.Context r2) {
        /*
            java.lang.Class<com.didi.ifx.license.IFXLicenseClient> r0 = com.didi.ifx.license.IFXLicenseClient.class
            monitor-enter(r0)
            com.didi.ifx.license.IFXLicenseClient r1 = f24221a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.didi.ifx.license.IFXLicenseClient r1 = f24221a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.didi.ifx.license.IFXLicenseClient r1 = new com.didi.ifx.license.IFXLicenseClient     // Catch:{ all -> 0x0015 }
            r1.<init>(r2)     // Catch:{ all -> 0x0015 }
            f24221a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.didi.ifx.license.IFXLicenseClient r2 = f24221a     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXLicenseClient.getIFXLicenseClient(android.content.Context):com.didi.ifx.license.IFXLicenseClient");
    }

    public static IFXLicenseClient getIFXLicenseClientInJni() {
        if (f24222b) {
            return f24221a;
        }
        return null;
    }

    /* renamed from: i */
    private synchronized void m17310i() {
        if (this.f24238r != null) {
            for (IFXModel a : this.f24231k.values()) {
                a.mo71621a();
            }
            this.f24238r.shutdown();
        }
        this.f24240t = false;
    }

    public static synchronized void releaseIFXLicenseClient() {
        synchronized (IFXLicenseClient.class) {
            if (f24221a != null) {
                f24221a.clearAllModels();
                f24221a = null;
            }
        }
    }

    public synchronized int addModel(IFXModel iFXModel) {
        if (f24223c) {
            f24223c = false;
        }
        if (this.f24231k.size() >= this.f24227g) {
            SystemUtils.log(4, "IFXLicenseClient", "Cannot add more ifx model", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 6);
            return -1;
        }
        int size = this.f24231k.size();
        iFXModel.f24269p = this.f24243w;
        if (!m17301c(iFXModel)) {
            SystemUtils.log(4, "IFXLicenseClient", "Fetch ifx model uuid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 15);
            return -4;
        } else if (!iFXModel.mo71622a(size, this.f24230j, this.f24228h)) {
            SystemUtils.log(4, "IFXLicenseClient", "Init ifx model fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 20);
            return -2;
        } else {
            this.f24231k.put(Integer.valueOf(size), iFXModel);
            if (m17292a(size)) {
                return size;
            }
            SystemUtils.log(4, "IFXLicenseClient", "verify ifx model fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 27);
            return -3;
        }
    }

    public boolean allRegistered() {
        if (this.f24231k.isEmpty()) {
            return false;
        }
        for (IFXModel iFXModel : this.f24231k.values()) {
            if (!iFXModel.f24261h) {
                return false;
            }
        }
        return true;
    }

    public synchronized void clearAllModels() {
        this.f24231k.clear();
        if (this.f24229i) {
            m17307f();
            m17304d();
        }
        if (this.f24237q) {
            m17310i();
        }
        f24223c = true;
    }

    public int getGroups() {
        return this.f24230j;
    }

    public int getIFXModelsNum() {
        if (this.f24231k == null) {
            return -1;
        }
        return this.f24231k.size();
    }

    public synchronized IFXModel getModel(int i) {
        return this.f24231k.get(Integer.valueOf(i));
    }

    public long getModelVerifyToken(int i) {
        IFXModel iFXModel = this.f24231k.get(Integer.valueOf(i));
        if (iFXModel != null) {
            return iFXModel.generateToken();
        }
        SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Get model according to mid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 3);
        return 0;
    }

    public boolean isInitialized() {
        return f24222b;
    }

    public boolean midIsValid(int i) {
        if (i < 0 || this.f24231k == null) {
            return false;
        }
        return this.f24231k.containsKey(Integer.valueOf(i));
    }

    public boolean modelIsRegistered(int i) {
        IFXModel iFXModel;
        if (i < 0 || this.f24231k == null || !this.f24231k.containsKey(Integer.valueOf(i)) || (iFXModel = this.f24231k.get(Integer.valueOf(i))) == null) {
            return false;
        }
        return iFXModel.f24261h;
    }

    public void omegaReportInference(int i, long j) {
        IFXModel iFXModel = this.f24231k.get(Integer.valueOf(i));
        if (iFXModel == null) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Get model according to mid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 3);
            return;
        }
        iFXModel.reportInferenceTimeByOMG(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerAllModels() {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.util.HashMap<java.lang.Integer, com.didi.ifx.license.IFXModel> r1 = r5.f24231k     // Catch:{ all -> 0x0051 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0051 }
            r2 = 1
        L_0x000d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0051 }
            com.didi.ifx.license.IFXModel r3 = (com.didi.ifx.license.IFXModel) r3     // Catch:{ all -> 0x0051 }
            boolean r4 = r3.f24261h     // Catch:{ all -> 0x0051 }
            if (r4 != 0) goto L_0x000d
            boolean r0 = r3.f24266m     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0023
            r3.f24262i = r2     // Catch:{ all -> 0x0051 }
        L_0x0023:
            r3.f24261h = r2     // Catch:{ all -> 0x0051 }
            r0 = 1
            goto L_0x000d
        L_0x0027:
            if (r0 != 0) goto L_0x002b
            monitor-exit(r5)
            return
        L_0x002b:
            int r0 = r5.f24230j     // Catch:{ all -> 0x0051 }
            int r0 = r0 + r2
            r5.f24230j = r0     // Catch:{ all -> 0x0051 }
            boolean r0 = r5.f24229i     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0046
            boolean r0 = r5.f24236p     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x003c
            r5.m17300c()     // Catch:{ all -> 0x0051 }
            goto L_0x003f
        L_0x003c:
            r5.m17295b()     // Catch:{ all -> 0x0051 }
        L_0x003f:
            boolean r0 = r5.f24242v     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x0046
            r5.m17305e()     // Catch:{ all -> 0x0051 }
        L_0x0046:
            boolean r0 = r5.m17308g()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x004f
            r5.m17309h()     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXLicenseClient.registerAllModels():void");
    }

    public synchronized boolean setIFXAuthSwitch(boolean z) {
        if (!f24223c) {
            SystemUtils.log(4, "IFXLicenseClient", "Cannot set ifx auth switch after adding IFXModel", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 2);
            return false;
        }
        this.f24229i = z;
        return true;
    }

    public synchronized void setIFXTrackCallback(IFXTrackCallback iFXTrackCallback) {
        C9283c cVar = this.f24243w;
        cVar.f24381a = true;
        cVar.f24382b = iFXTrackCallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean setLocationCode(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = f24223c     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0014
            java.lang.String r2 = "IFXLicenseClient"
            java.lang.String r3 = "Cannot set location code after adding IFXModel"
            r1 = 4
            r4 = 0
            java.lang.String r5 = "com.didi.ifx.license.IFXLicenseClient"
            r6 = 2
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0022 }
            r8 = 0
            monitor-exit(r7)
            return r8
        L_0x0014:
            r0 = 1
            if (r8 == r0) goto L_0x001c
            java.lang.String r8 = "https://ifx-license.didiglobal.com/v1/license/register"
            r7.f24225e = r8     // Catch:{ all -> 0x0022 }
            goto L_0x0020
        L_0x001c:
            java.lang.String r8 = "https://ifx-license.didiglobal.com/v1/license/register"
            r7.f24225e = r8     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r7)
            return r0
        L_0x0022:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXLicenseClient.setLocationCode(int):boolean");
    }

    public synchronized boolean setMaxModelNum(int i) {
        if (!f24223c) {
            SystemUtils.log(4, "IFXLicenseClient", "Cannot set max model num after adding IFXModel", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 2);
            return false;
        }
        this.f24227g = i;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17290a(IFXModel iFXModel) {
        int i;
        m17284a(iFXModel.f24255b, iFXModel.f24256c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= iFXModel.f24265l * 1000) {
            int d = m17302d(iFXModel);
            if (d == -6) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] License file is broken in heartbeat", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 28);
                m17296b(iFXModel.f24255b);
            } else if (d == -1) {
                m17296b(iFXModel.f24255b);
            } else if (d != 0) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Fetch local license fail in heartbeat", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 8);
                iFXModel.f24262i = false;
            } else {
                if (!iFXModel.f24254a) {
                    i = m17280a(iFXModel.f24255b, iFXModel.f24256c, iFXModel.f24268o);
                    m17285a(iFXModel.f24255b, iFXModel.f24256c, i, System.currentTimeMillis() - currentTimeMillis);
                } else {
                    i = 0;
                }
                if (i > 0) {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Check license fail in heartbeat", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 18);
                    iFXModel.f24262i = false;
                    return;
                }
                m17296b(iFXModel.f24255b);
            }
        }
    }

    /* renamed from: e */
    private synchronized void m17305e() {
        this.f24242v = true;
        MonitorThread monitorThread = new MonitorThread();
        this.f24241u = monitorThread;
        monitorThread.setDaemon(true);
        this.f24241u.start();
    }

    /* renamed from: g */
    private boolean m17308g() {
        if (this.f24231k.size() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (IFXModel next : this.f24231k.values()) {
            if (next.f24270q > 0 && next.f24261h) {
                this.f24237q = true;
                arrayList.add(Integer.valueOf(next.f24271r));
            }
        }
        if (!this.f24237q) {
            return false;
        }
        int i = 1;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 == 0) {
                i = ((Integer) arrayList.get(i2)).intValue();
            } else {
                i = C9281a.m17440a(i, ((Integer) arrayList.get(i2)).intValue());
            }
        }
        for (IFXModel next2 : this.f24231k.values()) {
            if (next2.f24270q > 0) {
                next2.f24273t = 0;
                next2.f24272s = next2.f24271r / i;
            }
        }
        if (this.f24240t && i == this.f24239s) {
            return false;
        }
        this.f24239s = i;
        return true;
    }

    /* renamed from: a */
    private boolean m17292a(int i) {
        int i2 = i;
        IFXModel iFXModel = this.f24231k.get(Integer.valueOf(i));
        if (iFXModel == null) {
            return false;
        }
        m17284a(iFXModel.f24255b, iFXModel.f24256c);
        if (this.f24229i) {
            long currentTimeMillis = System.currentTimeMillis();
            int b = m17293b(iFXModel);
            if (b == -6) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] License file is broken and need pulled from server", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 42);
                iFXModel.f24262i = true;
                return true;
            } else if (b == -4) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] License file may be modified illegally ", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 39);
                return false;
            } else if (b == -3) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Decode license file fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 36);
                return false;
            } else if (b == -2) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Read license file fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 33);
                return false;
            } else if (b == -1) {
                iFXModel.f24266m = true;
                return true;
            } else if (b != 0) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Fetch local license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 14);
                return false;
            } else {
                int a = !iFXModel.f24254a ? m17280a(iFXModel.f24255b, iFXModel.f24256c, iFXModel.f24268o) : 0;
                if (a > 0) {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Check license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 22);
                    m17285a(iFXModel.f24255b, iFXModel.f24256c, a, System.currentTimeMillis() - currentTimeMillis);
                    return false;
                }
                iFXModel.f24262i = true;
                m17285a(iFXModel.f24255b, iFXModel.f24256c, a, System.currentTimeMillis() - currentTimeMillis);
                return true;
            }
        } else {
            iFXModel.f24262i = true;
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m17280a(int i, String str, LicenseFile licenseFile) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] License key is empty when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 28);
            return 1;
        } else if (!licenseFile.getLicenseKey().equals(str)) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] License key is invalid when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 11);
            return 1;
        } else {
            String a = C9282b.m17452a(this.f24226f);
            if (a == null || a.isEmpty()) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Device id is empty when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 27);
                return 2;
            } else if (!licenseFile.getDeviceId().equals(a)) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Device id is invalid when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 21);
                return 2;
            } else if (System.currentTimeMillis() <= licenseFile.getExpiryTimestamp() * 1000) {
                return 0;
            } else {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] License is beyond expiry when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 26);
                return 3;
            }
        }
    }

    /* renamed from: d */
    private int m17302d(IFXModel iFXModel) {
        int i = iFXModel.f24255b;
        try {
            FileInputStream openFileInput = this.f24226f.openFileInput(iFXModel.f24257d);
            if (openFileInput == null) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Open ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 18);
                this.f24243w.mo71681a("IFXLicenseClientError", new Throwable("Open ifx license file fail"));
                return -2;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput);
            try {
                int available = bufferedInputStream.available();
                int i2 = available - 4;
                try {
                    bufferedInputStream.mark(i2);
                    bufferedInputStream.skip((long) i2);
                    byte[] bArr = new byte[4];
                    try {
                        bufferedInputStream.read(bArr, 0, 4);
                        bufferedInputStream.reset();
                        if (C9281a.m17442a(bArr, 0) != 616) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Find ifx.v2.license broken", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 55);
                            return -6;
                        }
                        byte[] bArr2 = new byte[4];
                        try {
                            bufferedInputStream.read(bArr2, 0, 4);
                            int a = C9281a.m17442a(bArr2, 0);
                            byte[] bArr3 = new byte[a];
                            try {
                                bufferedInputStream.read(bArr3, 0, a);
                                int i3 = (available - a) - 8;
                                byte[] bArr4 = new byte[i3];
                                try {
                                    bufferedInputStream.read(bArr4, 0, i3);
                                    String a2 = C9281a.m17444a(bArr4);
                                    try {
                                        bufferedInputStream.close();
                                        try {
                                            byte[] b = C9281a.m17450b(bArr3);
                                            try {
                                                try {
                                                    if (C9284d.m17459a(b, ((LicenseFile) this.f24233m.fromJson(C9281a.m17444a(b), LicenseFile.class)).getPublicKey(), a2)) {
                                                        return 0;
                                                    }
                                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license not pass", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 128);
                                                    return -4;
                                                } catch (Throwable th) {
                                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 129);
                                                    this.f24243w.mo71681a("IFXLicenseClientError", th);
                                                    return -3;
                                                }
                                            } catch (Throwable th2) {
                                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Parse license file info fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 131);
                                                this.f24243w.mo71681a("IFXLicenseClientError", th2);
                                                return -3;
                                            }
                                        } catch (Throwable th3) {
                                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Decode license data fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 133);
                                            this.f24243w.mo71681a("IFXLicenseClientError", th3);
                                            return -3;
                                        }
                                    } catch (Throwable th4) {
                                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Close ifx.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 135);
                                        this.f24243w.mo71681a("IFXLicenseClientError", th4);
                                        return -2;
                                    }
                                } catch (Throwable th5) {
                                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read signature in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 137);
                                    this.f24243w.mo71681a("IFXLicenseClientError", th5);
                                    return -2;
                                }
                            } catch (Throwable th6) {
                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 139);
                                this.f24243w.mo71681a("IFXLicenseClientError", th6);
                                return -2;
                            }
                        } catch (Throwable th7) {
                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 141);
                            this.f24243w.mo71681a("IFXLicenseClientError", th7);
                            return -2;
                        }
                    } catch (Throwable th8) {
                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 143);
                        this.f24243w.mo71681a("IFXLicenseClientError", th8);
                        return -2;
                    }
                } catch (Throwable th9) {
                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 145);
                    this.f24243w.mo71681a("IFXLicenseClientError", th9);
                    return -2;
                }
            } catch (IOException e) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license size fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 147);
                this.f24243w.mo71681a("IFXLicenseClientError", (Throwable) e);
                return -2;
            }
        } catch (FileNotFoundException unused) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] File ifx.v2.license does not exist", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 149);
            return -1;
        }
    }

    /* renamed from: a */
    private void m17284a(int i, String str) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] License key is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 55);
            return;
        }
        try {
            String a = C9281a.m17443a(str);
            String a2 = C9282b.m17452a(this.f24226f);
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Device Id is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 53);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", a2);
            hashMap.put("sdk_version", "2.1.1");
            this.f24243w.mo71682a("tech_ifx_report", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 54);
        }
    }

    /* renamed from: h */
    private synchronized void m17309h() {
        ScheduledExecutorService scheduledExecutorService;
        if (this.f24240t && (scheduledExecutorService = this.f24238r) != null && !scheduledExecutorService.isShutdown()) {
            this.f24238r.shutdown();
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f24238r = newSingleThreadScheduledExecutor;
        InferenceReporter inferenceReporter = new InferenceReporter();
        long j = (long) this.f24239s;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(inferenceReporter, j, j, TimeUnit.MINUTES);
        this.f24240t = true;
        SystemUtils.log(3, "IFXLicenseClient", "Launch inference reporter thread with time(min) " + this.f24239s, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 36);
    }

    /* renamed from: b */
    private synchronized void m17295b() {
        if (this.f24231k.size() > 0) {
            long j = Long.MAX_VALUE;
            for (IFXModel iFXModel : this.f24231k.values()) {
                long j2 = iFXModel.f24263j;
                if (j2 < j) {
                    j = j2;
                }
            }
            if (j != this.f24235o) {
                this.f24235o = j;
            }
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f24234n = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(), 2, this.f24235o, TimeUnit.SECONDS);
        this.f24236p = true;
        SystemUtils.log(3, "IFXLicenseClient", "Launch heartbeat thread with time(s) " + this.f24235o, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 64);
    }

    /* renamed from: a */
    private void m17285a(int i, String str, int i2, long j) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] License key is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 112);
            return;
        }
        try {
            String a = C9281a.m17443a(str);
            String a2 = C9282b.m17452a(this.f24226f);
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Device Id is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 110);
                return;
            }
            int i3 = 200;
            boolean z = false;
            if (j > 60000) {
                i3 = 208;
                j = -8;
            } else if (i2 > 0) {
                i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? 209 : 203 : 202 : 201;
            } else {
                z = true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", a2);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("pass_check", Boolean.valueOf(z));
            hashMap.put("check_time", Long.valueOf(j));
            hashMap.put("code", Integer.valueOf(i3));
            this.f24243w.mo71682a("tech_ifx_report_check_license", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 111);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17291a(String str, String str2, String str3) {
        byte[] bytes = str2.getBytes();
        byte[] bytes2 = str3.getBytes();
        int length = bytes.length;
        FileOutputStream openFileOutput = this.f24226f.openFileOutput(str, 0);
        openFileOutput.write(C9281a.m17447a(length));
        openFileOutput.write(bytes);
        openFileOutput.write(bytes2);
        openFileOutput.write(C9281a.m17447a(616));
        openFileOutput.close();
    }

    /* renamed from: c */
    private boolean m17301c(IFXModel iFXModel) {
        InputStream inputStream;
        try {
            if (iFXModel.f24260g) {
                inputStream = this.f24226f.getAssets().open(iFXModel.f24259f);
            } else {
                inputStream = new FileInputStream(iFXModel.f24259f);
            }
            try {
                C9281a.m17441a(inputStream);
                try {
                    if (C9281a.m17441a(inputStream) % 100 != C9281a.f24380g) {
                        iFXModel.f24254a = true;
                        iFXModel.f24256c = C9281a.f24379f;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < 4) {
                        try {
                            sb.append(String.format("%08x", new Object[]{Integer.valueOf(C9281a.m17441a(inputStream))}));
                            i++;
                        } catch (Throwable th) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 120);
                            this.f24243w.mo71681a("IFXLicenseClientError", th);
                            return false;
                        }
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() != 32) {
                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Model uuid with invalid length", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 128);
                        return false;
                    }
                    iFXModel.f24256c = sb2;
                    return true;
                } catch (Throwable th2) {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Fetch model version fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 132);
                    this.f24243w.mo71681a("IFXLicenseClientError", th2);
                    return false;
                }
            } catch (Throwable th3) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Fetch framework version fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 134);
                this.f24243w.mo71681a("IFXLicenseClientError", th3);
                return false;
            }
        } catch (Throwable th4) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Open model file fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 136);
            this.f24243w.mo71681a("IFXLicenseClientError", th4);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17286a(int i, String str, int i2, long j, String str2) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] License key is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 142);
            return;
        }
        try {
            String a = C9281a.m17443a(str);
            String a2 = C9282b.m17452a(this.f24226f);
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Device Id is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 140);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", a2);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("status_code", Integer.valueOf(i2));
            hashMap.put("code", Long.valueOf(j));
            hashMap.put("message", str2);
            this.f24243w.mo71682a("tech_ifx_report_http_status", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 141);
        }
    }

    /* renamed from: a */
    private void m17283a() {
        this.f24232l = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    }

    /* renamed from: b */
    private void m17296b(int i) {
        int i2 = i;
        final IFXModel iFXModel = this.f24231k.get(Integer.valueOf(i));
        if (iFXModel == null) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] HTTP update license fail because of no such IFXModelManager", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 150);
            return;
        }
        if (iFXModel.f24266m) {
            if (iFXModel.f24267n >= 40) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP pull license fail because of not in network", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 156);
                iFXModel.f24262i = false;
                iFXModel.f24267n = 0;
                return;
            }
        } else if (iFXModel.f24267n >= 24) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP update license fail because of not in network", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 163);
            iFXModel.f24262i = false;
            iFXModel.f24267n = 0;
            return;
        }
        String str = iFXModel.f24256c;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP fail because of empty license key", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 206);
            iFXModel.f24267n = iFXModel.f24267n + 1;
            return;
        }
        String str2 = this.f24228h;
        if (str2 == null || str2.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP fail because of empty device id", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 204);
            iFXModel.f24267n = iFXModel.f24267n + 1;
            return;
        }
        this.f24232l.newCall(new Request.Builder().url(this.f24225e).post(RequestBody.create(this.f24224d, this.f24233m.toJson((Object) new RegisterRequest(str, this.f24228h, "android", C9285e.m17460a(), C9285e.m17461b(), C9285e.m17462c(), C9285e.m17463d(), System.currentTimeMillis() / 1000, "2.1.1")))).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] HTTP response fail with error: " + iOException.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 1);
                IFXLicenseClient iFXLicenseClient = IFXLicenseClient.this;
                IFXModel iFXModel = iFXModel;
                iFXLicenseClient.m17286a(iFXModel.f24255b, iFXModel.f24256c, 0, 0, iOException.getMessage());
                IFXModel iFXModel2 = iFXModel;
                iFXModel2.f24267n = iFXModel2.f24267n + 1;
            }

            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    SystemUtils.log(3, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] HTTP return code: " + response.code() + " msg: " + response.message(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 2);
                    if (response.body() == null) {
                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] HTTP response body is empty", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 4);
                        IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", new Throwable("HTTP response body is empty"));
                        IFXModel iFXModel = iFXModel;
                        iFXModel.f24267n = iFXModel.f24267n + 1;
                        return;
                    }
                    try {
                        RegisterResponse registerResponse = (RegisterResponse) IFXLicenseClient.this.f24233m.fromJson(response.body().string(), RegisterResponse.class);
                        try {
                            long j = registerResponse.get_code();
                            if (j == 20000) {
                                try {
                                    String str = registerResponse.get_license_content();
                                    if (str == null || str.isEmpty()) {
                                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Json license data is null", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 91);
                                        IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", new Throwable("Json license data is null"));
                                        IFXModel iFXModel2 = iFXModel;
                                        iFXModel2.f24267n = iFXModel2.f24267n + 1;
                                        return;
                                    }
                                    try {
                                        LicenseFile licenseFile = (LicenseFile) IFXLicenseClient.this.f24233m.fromJson(str, LicenseFile.class);
                                        IFXModel iFXModel3 = iFXModel;
                                        iFXModel3.f24268o = licenseFile;
                                        if ((!iFXModel3.f24254a ? IFXLicenseClient.this.m17280a(iFXModel3.f24255b, iFXModel3.f24256c, licenseFile) : 0) > 0) {
                                            iFXModel.f24262i = false;
                                            return;
                                        }
                                        try {
                                            IFXLicenseClient.this.m17291a(iFXModel.f24257d, registerResponse.get_license_file(), registerResponse.get_sign_data());
                                            long heartbeatTime = licenseFile.getHeartbeatTime();
                                            long heartbeatBias = licenseFile.getHeartbeatBias();
                                            if (heartbeatTime >= 0 && heartbeatBias >= 0) {
                                                IFXModel iFXModel4 = iFXModel;
                                                iFXModel4.f24263j = heartbeatTime;
                                                iFXModel4.f24264k = heartbeatBias;
                                            }
                                            iFXModel.f24265l = licenseFile.getUpdateTimestamp();
                                            iFXModel.f24266m = false;
                                            iFXModel.f24267n = 0;
                                        } catch (Throwable th) {
                                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Write ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 85);
                                            IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", th);
                                            IFXModel iFXModel5 = iFXModel;
                                            iFXModel5.f24267n = iFXModel5.f24267n + 1;
                                        }
                                    } catch (Throwable th2) {
                                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Parse json license data fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 88);
                                        IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", th2);
                                        IFXModel iFXModel6 = iFXModel;
                                        iFXModel6.f24267n = iFXModel6.f24267n + 1;
                                    }
                                } catch (Throwable th3) {
                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Get resp license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 94);
                                    IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", th3);
                                    IFXModel iFXModel7 = iFXModel;
                                    iFXModel7.f24267n = iFXModel7.f24267n + 1;
                                }
                            } else if (j == 50000) {
                                iFXModel.f24262i = false;
                                iFXModel.f24267n = 0;
                                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] HTTP response code is 50000", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 146);
                                try {
                                    IFXLicenseClient.this.m17298b(iFXModel.f24257d, registerResponse.get_license_file(), registerResponse.get_sign_data());
                                } catch (Throwable unused) {
                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Write fake ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 150);
                                    IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", new Throwable("Write fake ifx.v2.license fail"));
                                }
                            } else {
                                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] HTTP response with code " + j, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 156);
                                IFXLicenseClient iFXLicenseClient = IFXLicenseClient.this;
                                IFXModel iFXModel8 = iFXModel;
                                iFXLicenseClient.m17286a(iFXModel8.f24255b, iFXModel8.f24256c, response.code(), j, registerResponse.get_message());
                                IFXModel iFXModel9 = iFXModel;
                                iFXModel9.f24267n = iFXModel9.f24267n + 1;
                            }
                        } catch (Throwable th4) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Get resp code fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 159);
                            IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", th4);
                            IFXModel iFXModel10 = iFXModel;
                            iFXModel10.f24267n = iFXModel10.f24267n + 1;
                        }
                    } catch (Throwable th5) {
                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] Parse json response body fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 162);
                        IFXLicenseClient.this.f24243w.mo71681a("IFXLicenseClientError", th5);
                        IFXModel iFXModel11 = iFXModel;
                        iFXModel11.f24267n = iFXModel11.f24267n + 1;
                    }
                } else {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f24255b + "] HTTP fail with response code " + response.code(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 252);
                    C9283c a = IFXLicenseClient.this.f24243w;
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP fail with response code:");
                    sb.append(response.code());
                    a.mo71681a("IFXLicenseClientError", new Throwable(sb.toString()));
                    iFXModel.f24267n++;
                }
            }
        });
    }

    /* renamed from: b */
    private int m17293b(IFXModel iFXModel) {
        int i = iFXModel.f24255b;
        try {
            FileInputStream openFileInput = this.f24226f.openFileInput(iFXModel.f24257d);
            if (openFileInput == null) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Open ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 219);
                this.f24243w.mo71681a("IFXLicenseClientError", new Throwable("Open ifx license file fail"));
                return -2;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput);
            try {
                int available = bufferedInputStream.available();
                int i2 = available - 4;
                try {
                    bufferedInputStream.mark(i2);
                    bufferedInputStream.skip((long) i2);
                    byte[] bArr = new byte[4];
                    try {
                        bufferedInputStream.read(bArr, 0, 4);
                        bufferedInputStream.reset();
                        if (C9281a.m17442a(bArr, 0) != 616) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Find ifx.v2.license broken", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 256);
                            return -6;
                        }
                        byte[] bArr2 = new byte[4];
                        try {
                            bufferedInputStream.read(bArr2, 0, 4);
                            int a = C9281a.m17442a(bArr2, 0);
                            byte[] bArr3 = new byte[a];
                            try {
                                bufferedInputStream.read(bArr3, 0, a);
                                int i3 = (available - a) - 8;
                                byte[] bArr4 = new byte[i3];
                                try {
                                    bufferedInputStream.read(bArr4, 0, i3);
                                    String a2 = C9281a.m17444a(bArr4);
                                    try {
                                        bufferedInputStream.close();
                                        try {
                                            byte[] b = C9281a.m17450b(bArr3);
                                            try {
                                                LicenseFile licenseFile = (LicenseFile) this.f24233m.fromJson(C9281a.m17444a(b), LicenseFile.class);
                                                try {
                                                    if (!C9284d.m17459a(b, licenseFile.getPublicKey(), a2)) {
                                                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license not pass", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 329);
                                                        return -4;
                                                    }
                                                    iFXModel.f24268o = licenseFile;
                                                    iFXModel.f24265l = licenseFile.getUpdateTimestamp();
                                                    long heartbeatTime = iFXModel.f24268o.getHeartbeatTime();
                                                    long heartbeatBias = iFXModel.f24268o.getHeartbeatBias();
                                                    if (heartbeatTime >= 0 && heartbeatBias >= 0) {
                                                        iFXModel.f24263j = heartbeatTime;
                                                        iFXModel.f24264k = heartbeatBias;
                                                    }
                                                    return 0;
                                                } catch (Throwable th) {
                                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 340);
                                                    this.f24243w.mo71681a("IFXLicenseClientError", th);
                                                    return -3;
                                                }
                                            } catch (Throwable th2) {
                                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Parse license file info fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 342);
                                                this.f24243w.mo71681a("IFXLicenseClientError", th2);
                                                return -3;
                                            }
                                        } catch (Throwable th3) {
                                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Decode license data fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 344);
                                            this.f24243w.mo71681a("IFXLicenseClientError", th3);
                                            return -3;
                                        }
                                    } catch (Throwable th4) {
                                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Close ifx.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 346);
                                        this.f24243w.mo71681a("IFXLicenseClientError", th4);
                                        return -2;
                                    }
                                } catch (Throwable th5) {
                                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read signature in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 348);
                                    this.f24243w.mo71681a("IFXLicenseClientError", th5);
                                    return -2;
                                }
                            } catch (Throwable th6) {
                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 350);
                                this.f24243w.mo71681a("IFXLicenseClientError", th6);
                                return -2;
                            }
                        } catch (Throwable th7) {
                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 352);
                            this.f24243w.mo71681a("IFXLicenseClientError", th7);
                            return -2;
                        }
                    } catch (Throwable th8) {
                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 354);
                        this.f24243w.mo71681a("IFXLicenseClientError", th8);
                        return -2;
                    }
                } catch (Throwable th9) {
                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 356);
                    this.f24243w.mo71681a("IFXLicenseClientError", th9);
                    return -2;
                }
            } catch (IOException e) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license size fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 358);
                this.f24243w.mo71681a("IFXLicenseClientError", (Throwable) e);
                return -2;
            }
        } catch (FileNotFoundException unused) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] File ifx.v2.license does not exist", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 360);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17298b(String str, String str2, String str3) {
        int length = str2.length();
        int length2 = str3.length();
        FileOutputStream openFileOutput = this.f24226f.openFileOutput(str, 0);
        openFileOutput.write(C9281a.m17447a(length));
        openFileOutput.write(C9281a.m17448b(length).getBytes());
        openFileOutput.write(C9281a.m17448b(length2).getBytes());
        int a = C9281a.m17439a();
        if (a % 2 == 0) {
            a++;
        }
        openFileOutput.write(C9281a.m17447a(a));
        openFileOutput.close();
    }
}
