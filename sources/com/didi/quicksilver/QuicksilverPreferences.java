package com.didi.quicksilver;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.didi.quicksilver.util.FileUtils;
import com.didi.quicksilver.util.Maps;
import com.didi.quicksilver.util.QueuedWork;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

final class QuicksilverPreferences implements SharedPreferences {

    /* renamed from: a */
    static boolean f33040a = false;

    /* renamed from: b */
    private static final String f33041b = "QuicksilverPreferences";

    /* renamed from: c */
    private static final Object f33042c = new Object();

    /* renamed from: d */
    private static final long f33043d = 256;

    /* renamed from: t */
    private static final int f33044t = 100;

    /* renamed from: u */
    private static final int f33045u = 16;

    /* renamed from: v */
    private static AtomicInteger f33046v = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final File f33047e;

    /* renamed from: f */
    private final File f33048f;

    /* renamed from: g */
    private final int f33049g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Object f33050h = new Object();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Object f33051i = new Object();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Map<String, Object> f33052j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f33053k = 0;

    /* renamed from: l */
    private boolean f33054l = false;

    /* renamed from: m */
    private long f33055m;

    /* renamed from: n */
    private long f33056n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> f33057o = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f33058p;

    /* renamed from: q */
    private long f33059q;

    /* renamed from: r */
    private int f33060r = 0;

    /* renamed from: s */
    private String f33061s;

    /* renamed from: f */
    static /* synthetic */ int m23249f(QuicksilverPreferences quicksilverPreferences) {
        int i = quicksilverPreferences.f33053k;
        quicksilverPreferences.f33053k = i + 1;
        return i;
    }

    /* renamed from: h */
    static /* synthetic */ long m23251h(QuicksilverPreferences quicksilverPreferences) {
        long j = quicksilverPreferences.f33058p;
        quicksilverPreferences.f33058p = 1 + j;
        return j;
    }

    /* renamed from: k */
    static /* synthetic */ int m23254k(QuicksilverPreferences quicksilverPreferences) {
        int i = quicksilverPreferences.f33053k;
        quicksilverPreferences.f33053k = i - 1;
        return i;
    }

    QuicksilverPreferences(Context context, String str, File file, int i) {
        this.f33061s = str;
        this.f33047e = file;
        this.f33048f = m23233a(file);
        this.f33049g = i;
        this.f33054l = false;
        this.f33052j = null;
        m23242b();
    }

    /* renamed from: b */
    private void m23242b() {
        synchronized (this.f33050h) {
            this.f33054l = false;
        }
        try {
            new Thread("QuicksilverPreferences-" + f33046v.incrementAndGet()) {
                public void run() {
                    QuicksilverPreferences.this.m23244c();
                }
            }.start();
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.util.HashMap<java.lang.String, ?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: com.didi.dimina.v8.utils.V8Map} */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v8, types: [java.io.Closeable] */
    /* access modifiers changed from: private */
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    public void m23244c() {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f33050h
            monitor-enter(r0)
            boolean r1 = r13.f33054l     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x0009:
            java.io.File r1 = r13.f33048f     // Catch:{ all -> 0x011b }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x001d
            java.io.File r1 = r13.f33047e     // Catch:{ all -> 0x011b }
            r1.delete()     // Catch:{ all -> 0x011b }
            java.io.File r1 = r13.f33048f     // Catch:{ all -> 0x011b }
            java.io.File r2 = r13.f33047e     // Catch:{ all -> 0x011b }
            r1.renameTo(r2)     // Catch:{ all -> 0x011b }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            java.io.File r0 = r13.f33047e
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x004b
            java.io.File r0 = r13.f33047e
            boolean r0 = r0.canRead()
            if (r0 != 0) goto L_0x004b
            java.lang.String r0 = "QuicksilverPreferences"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Attempt to read preferences file "
            r1.append(r2)
            java.io.File r2 = r13.f33047e
            r1.append(r2)
            java.lang.String r2 = " without permission"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
        L_0x004b:
            r0 = 1
            r1 = 0
            java.io.File r2 = r13.f33047e     // Catch:{ ErrnoException -> 0x00f7 }
            java.lang.String r2 = r2.getPath()     // Catch:{ ErrnoException -> 0x00f7 }
            com.didi.quicksilver.ext.StructStat r2 = com.didi.quicksilver.util.C11471Os.stat(r2)     // Catch:{ ErrnoException -> 0x00f7 }
            java.io.File r3 = r13.f33047e     // Catch:{ ErrnoException -> 0x00f8 }
            boolean r3 = r3.canRead()     // Catch:{ ErrnoException -> 0x00f8 }
            if (r3 == 0) goto L_0x00f8
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            java.io.File r5 = r13.f33047e     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r5 = 16384(0x4000, float:2.2959E-41)
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            java.util.HashMap r1 = com.didi.quicksilver.util.XmlUtils.readMapXml(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.io.File r4 = r13.f33047e     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            long r4 = r4.length()     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r6 = 102400(0x19000, double:5.05923E-319)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x00be
            boolean r6 = f33040a     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            if (r6 == 0) goto L_0x00be
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r6.<init>()     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r7 = "Found large preferences file "
            r6.append(r7)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.io.File r7 = r13.f33047e     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r6.append(r7)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r7 = " with "
            r6.append(r7)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r7 = "%.2f"
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r9 = 0
            double r4 = (double) r4     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 * r10
            r10 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r4 = r4 / r10
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r8[r9] = r4     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r4 = java.lang.String.format(r7, r8)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r6.append(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r4 = "KB, It's not recommended to use SharedPreferences to store huge amount of resources in an app, You should choose SQLite over SharedPreferences."
            r6.append(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r5 = "QuicksilverPreferences"
            android.util.Log.e(r5, r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
        L_0x00be:
            com.didi.quicksilver.util.IoUtils.closeQuietly((java.io.Closeable) r3)     // Catch:{ ErrnoException -> 0x00f8 }
            goto L_0x00f8
        L_0x00c2:
            r4 = move-exception
            r12 = r3
            r3 = r1
            r1 = r12
            goto L_0x00f3
        L_0x00c7:
            r4 = move-exception
            r12 = r3
            r3 = r1
            r1 = r12
            goto L_0x00d1
        L_0x00cc:
            r4 = move-exception
            r3 = r1
            goto L_0x00f3
        L_0x00cf:
            r4 = move-exception
            r3 = r1
        L_0x00d1:
            java.lang.String r5 = "QuicksilverPreferences"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r6.<init>()     // Catch:{ all -> 0x00f2 }
            java.lang.String r7 = "Cannot read "
            r6.append(r7)     // Catch:{ all -> 0x00f2 }
            java.io.File r7 = r13.f33047e     // Catch:{ all -> 0x00f2 }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ all -> 0x00f2 }
            r6.append(r7)     // Catch:{ all -> 0x00f2 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00f2 }
            android.util.Log.w(r5, r6, r4)     // Catch:{ all -> 0x00f2 }
            com.didi.quicksilver.util.IoUtils.closeQuietly((java.io.Closeable) r1)     // Catch:{ ErrnoException -> 0x00f0 }
        L_0x00f0:
            r1 = r3
            goto L_0x00f8
        L_0x00f2:
            r4 = move-exception
        L_0x00f3:
            com.didi.quicksilver.util.IoUtils.closeQuietly((java.io.Closeable) r1)     // Catch:{ ErrnoException -> 0x00f0 }
            throw r4     // Catch:{ ErrnoException -> 0x00f0 }
        L_0x00f7:
            r2 = r1
        L_0x00f8:
            java.lang.Object r3 = r13.f33050h
            monitor-enter(r3)
            r13.f33054l = r0     // Catch:{ all -> 0x0118 }
            if (r1 == 0) goto L_0x010a
            r13.f33052j = r1     // Catch:{ all -> 0x0118 }
            long r0 = r2.st_mtime     // Catch:{ all -> 0x0118 }
            r13.f33055m = r0     // Catch:{ all -> 0x0118 }
            long r0 = r2.st_size     // Catch:{ all -> 0x0118 }
            r13.f33056n = r0     // Catch:{ all -> 0x0118 }
            goto L_0x0111
        L_0x010a:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0118 }
            r0.<init>()     // Catch:{ all -> 0x0118 }
            r13.f33052j = r0     // Catch:{ all -> 0x0118 }
        L_0x0111:
            java.lang.Object r0 = r13.f33050h     // Catch:{ all -> 0x0118 }
            r0.notifyAll()     // Catch:{ all -> 0x0118 }
            monitor-exit(r3)     // Catch:{ all -> 0x0118 }
            return
        L_0x0118:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0118 }
            throw r0
        L_0x011b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.QuicksilverPreferences.m23244c():void");
    }

    /* renamed from: a */
    static File m23233a(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87066a() {
        synchronized (this.f33050h) {
            if (m23246d()) {
                m23242b();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = com.didi.quicksilver.util.C11471Os.stat(r9.f33047e.getPath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r3 = r9.f33050h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        if (r1.st_mtime != r9.f33055m) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r9.f33056n == r1.st_size) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        return false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m23246d() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f33050h
            monitor-enter(r0)
            int r1 = r9.f33053k     // Catch:{ all -> 0x003b }
            r2 = 0
            if (r1 <= 0) goto L_0x0015
            boolean r1 = f33040a     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = "QuicksilverPreferences"
            java.lang.String r3 = "disk write in flight, not unexpected."
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x003b }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r2
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            r0 = 1
            java.io.File r1 = r9.f33047e     // Catch:{ ErrnoException -> 0x003a }
            java.lang.String r1 = r1.getPath()     // Catch:{ ErrnoException -> 0x003a }
            com.didi.quicksilver.ext.StructStat r1 = com.didi.quicksilver.util.C11471Os.stat(r1)     // Catch:{ ErrnoException -> 0x003a }
            java.lang.Object r3 = r9.f33050h
            monitor-enter(r3)
            long r4 = r1.st_mtime     // Catch:{ all -> 0x0037 }
            long r6 = r9.f33055m     // Catch:{ all -> 0x0037 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0034
            long r4 = r9.f33056n     // Catch:{ all -> 0x0037 }
            long r6 = r1.st_size     // Catch:{ all -> 0x0037 }
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            return r2
        L_0x0037:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            throw r0
        L_0x003a:
            return r0
        L_0x003b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.QuicksilverPreferences.m23246d():boolean");
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.f33050h) {
            this.f33057o.put(onSharedPreferenceChangeListener, f33042c);
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.f33050h) {
            this.f33057o.remove(onSharedPreferenceChangeListener);
        }
    }

    /* renamed from: e */
    private void m23248e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (!this.f33054l) {
            try {
                this.f33050h.wait();
            } catch (InterruptedException unused) {
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 16 && f33040a) {
            Log.e(f33041b, "Long wait for load preferences file " + this.f33047e.getName() + " with " + elapsedRealtime2 + "ms, We should call context.getSharedPreferences(..) ASAP before read or write an SharedPreferences.");
        }
    }

    public Map<String, ?> getAll() {
        HashMap hashMap;
        synchronized (this.f33050h) {
            m23248e();
            hashMap = new HashMap(this.f33052j);
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        synchronized (this.f33050h) {
            m23248e();
            String str3 = (String) this.f33052j.get(str);
            if (str3 != null) {
                str2 = str3;
            }
        }
        return str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        synchronized (this.f33050h) {
            m23248e();
            Set<String> set2 = (Set) this.f33052j.get(str);
            if (set2 != null) {
                set = set2;
            }
        }
        return set;
    }

    public int getInt(String str, int i) {
        synchronized (this.f33050h) {
            m23248e();
            Integer num = (Integer) this.f33052j.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public long getLong(String str, long j) {
        synchronized (this.f33050h) {
            m23248e();
            Long l = (Long) this.f33052j.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public float getFloat(String str, float f) {
        synchronized (this.f33050h) {
            m23248e();
            Float f2 = (Float) this.f33052j.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public boolean getBoolean(String str, boolean z) {
        synchronized (this.f33050h) {
            m23248e();
            Boolean bool = (Boolean) this.f33052j.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public boolean contains(String str) {
        boolean containsKey;
        synchronized (this.f33050h) {
            m23248e();
            containsKey = this.f33052j.containsKey(str);
        }
        return containsKey;
    }

    public SharedPreferences.Editor edit() {
        synchronized (this.f33050h) {
            m23248e();
        }
        return new EditorImpl();
    }

    private static class MemoryCommitResult {
        final List<String> keysModified;
        final Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners;
        final Map<String, Object> mapToWriteToDisk;
        final long memoryStateGeneration;
        boolean wasWritten;
        volatile boolean writeToDiskResult;
        final CountDownLatch writtenToDiskLatch;

        private MemoryCommitResult(long j, List<String> list, Set<SharedPreferences.OnSharedPreferenceChangeListener> set, Map<String, Object> map) {
            this.writtenToDiskLatch = new CountDownLatch(1);
            this.writeToDiskResult = false;
            this.wasWritten = false;
            this.memoryStateGeneration = j;
            this.keysModified = list;
            this.listeners = set;
            this.mapToWriteToDisk = map;
        }

        /* access modifiers changed from: package-private */
        public void setDiskWriteResult(boolean z, boolean z2) {
            this.wasWritten = z;
            this.writeToDiskResult = z2;
            this.writtenToDiskLatch.countDown();
        }
    }

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear = false;
        private final Object mLock = new Object();
        private final Map<String, Object> mModified = Maps.newHashMap();

        public EditorImpl() {
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this.mLock) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            synchronized (this.mLock) {
                this.mModified.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this.mLock) {
                this.mModified.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this.mLock) {
                this.mModified.put(str, Long.valueOf(j));
            }
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this.mLock) {
                this.mModified.put(str, Float.valueOf(f));
            }
            return this;
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this.mLock) {
                this.mModified.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            synchronized (this.mLock) {
                this.mModified.put(str, this);
            }
            return this;
        }

        public SharedPreferences.Editor clear() {
            synchronized (this.mLock) {
                this.mClear = true;
            }
            return this;
        }

        public void apply() {
            final long currentTimeMillis = System.currentTimeMillis();
            final MemoryCommitResult commitToMemory = commitToMemory();
            final C114671 r3 = new Runnable() {
                public void run() {
                    if (QuicksilverPreferences.f33040a && commitToMemory.wasWritten) {
                        Log.d(QuicksilverPreferences.f33041b, QuicksilverPreferences.this.f33047e.getName() + ":" + commitToMemory.memoryStateGeneration + " applied after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                }
            };
            QuicksilverPreferences.this.m23235a(commitToMemory, (Runnable) new Runnable() {
                public void run() {
                    r3.run();
                }
            });
            notifyListeners(commitToMemory);
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x00df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.didi.quicksilver.QuicksilverPreferences.MemoryCommitResult commitToMemory() {
            /*
                r12 = this;
                com.didi.quicksilver.QuicksilverPreferences r0 = com.didi.quicksilver.QuicksilverPreferences.this
                java.lang.Object r0 = r0.f33050h
                monitor-enter(r0)
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                int r1 = r1.f33053k     // Catch:{ all -> 0x0105 }
                if (r1 <= 0) goto L_0x001f
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0105 }
                com.didi.quicksilver.QuicksilverPreferences r3 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                java.util.Map r3 = r3.f33052j     // Catch:{ all -> 0x0105 }
                r2.<init>(r3)     // Catch:{ all -> 0x0105 }
                java.util.Map unused = r1.f33052j = r2     // Catch:{ all -> 0x0105 }
            L_0x001f:
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                java.util.Map r7 = r1.f33052j     // Catch:{ all -> 0x0105 }
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                com.didi.quicksilver.QuicksilverPreferences.m23249f(r1)     // Catch:{ all -> 0x0105 }
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                java.util.WeakHashMap r1 = r1.f33057o     // Catch:{ all -> 0x0105 }
                int r1 = r1.size()     // Catch:{ all -> 0x0105 }
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L_0x003a
                r1 = 1
                goto L_0x003b
            L_0x003a:
                r1 = 0
            L_0x003b:
                r4 = 0
                if (r1 == 0) goto L_0x0055
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
                r4.<init>()     // Catch:{ all -> 0x0105 }
                java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0105 }
                com.didi.quicksilver.QuicksilverPreferences r6 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0105 }
                java.util.WeakHashMap r6 = r6.f33057o     // Catch:{ all -> 0x0105 }
                java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x0105 }
                r5.<init>(r6)     // Catch:{ all -> 0x0105 }
                r6 = r5
                r5 = r4
                goto L_0x0057
            L_0x0055:
                r5 = r4
                r6 = r5
            L_0x0057:
                java.lang.Object r4 = r12.mLock     // Catch:{ all -> 0x0105 }
                monitor-enter(r4)     // Catch:{ all -> 0x0105 }
                boolean r8 = r12.mClear     // Catch:{ all -> 0x0102 }
                if (r8 == 0) goto L_0x0079
                com.didi.quicksilver.QuicksilverPreferences r8 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r8 = r8.f33052j     // Catch:{ all -> 0x0102 }
                boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0102 }
                if (r8 != 0) goto L_0x0075
                com.didi.quicksilver.QuicksilverPreferences r8 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r8 = r8.f33052j     // Catch:{ all -> 0x0102 }
                r8.clear()     // Catch:{ all -> 0x0102 }
                r8 = 1
                goto L_0x0076
            L_0x0075:
                r8 = 0
            L_0x0076:
                r12.mClear = r3     // Catch:{ all -> 0x0102 }
                r3 = r8
            L_0x0079:
                java.util.Map<java.lang.String, java.lang.Object> r8 = r12.mModified     // Catch:{ all -> 0x0102 }
                java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0102 }
                java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0102 }
            L_0x0083:
                boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0102 }
                if (r9 == 0) goto L_0x00e4
                java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0102 }
                java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x0102 }
                java.lang.Object r10 = r9.getKey()     // Catch:{ all -> 0x0102 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0102 }
                java.lang.Object r9 = r9.getValue()     // Catch:{ all -> 0x0102 }
                if (r9 == r12) goto L_0x00c7
                if (r9 != 0) goto L_0x009e
                goto L_0x00c7
            L_0x009e:
                com.didi.quicksilver.QuicksilverPreferences r11 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r11 = r11.f33052j     // Catch:{ all -> 0x0102 }
                boolean r11 = r11.containsKey(r10)     // Catch:{ all -> 0x0102 }
                if (r11 == 0) goto L_0x00bd
                com.didi.quicksilver.QuicksilverPreferences r11 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r11 = r11.f33052j     // Catch:{ all -> 0x0102 }
                java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x0102 }
                if (r11 == 0) goto L_0x00bd
                boolean r11 = r11.equals(r9)     // Catch:{ all -> 0x0102 }
                if (r11 == 0) goto L_0x00bd
                goto L_0x0083
            L_0x00bd:
                com.didi.quicksilver.QuicksilverPreferences r3 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r3 = r3.f33052j     // Catch:{ all -> 0x0102 }
                r3.put(r10, r9)     // Catch:{ all -> 0x0102 }
                goto L_0x00dd
            L_0x00c7:
                com.didi.quicksilver.QuicksilverPreferences r9 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r9 = r9.f33052j     // Catch:{ all -> 0x0102 }
                boolean r9 = r9.containsKey(r10)     // Catch:{ all -> 0x0102 }
                if (r9 != 0) goto L_0x00d4
                goto L_0x0083
            L_0x00d4:
                com.didi.quicksilver.QuicksilverPreferences r3 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                java.util.Map r3 = r3.f33052j     // Catch:{ all -> 0x0102 }
                r3.remove(r10)     // Catch:{ all -> 0x0102 }
            L_0x00dd:
                if (r1 == 0) goto L_0x00e2
                r5.add(r10)     // Catch:{ all -> 0x0102 }
            L_0x00e2:
                r3 = 1
                goto L_0x0083
            L_0x00e4:
                java.util.Map<java.lang.String, java.lang.Object> r1 = r12.mModified     // Catch:{ all -> 0x0102 }
                r1.clear()     // Catch:{ all -> 0x0102 }
                if (r3 == 0) goto L_0x00f0
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                com.didi.quicksilver.QuicksilverPreferences.m23251h(r1)     // Catch:{ all -> 0x0102 }
            L_0x00f0:
                com.didi.quicksilver.QuicksilverPreferences r1 = com.didi.quicksilver.QuicksilverPreferences.this     // Catch:{ all -> 0x0102 }
                long r8 = r1.f33058p     // Catch:{ all -> 0x0102 }
                monitor-exit(r4)     // Catch:{ all -> 0x0102 }
                monitor-exit(r0)     // Catch:{ all -> 0x0105 }
                com.didi.quicksilver.QuicksilverPreferences$MemoryCommitResult r0 = new com.didi.quicksilver.QuicksilverPreferences$MemoryCommitResult
                r1 = 0
                r2 = r0
                r3 = r8
                r8 = r1
                r2.<init>(r3, r5, r6, r7)
                return r0
            L_0x0102:
                r1 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0102 }
                throw r1     // Catch:{ all -> 0x0105 }
            L_0x0105:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0105 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.QuicksilverPreferences.EditorImpl.commitToMemory():com.didi.quicksilver.QuicksilverPreferences$MemoryCommitResult");
        }

        public boolean commit() {
            long currentTimeMillis = QuicksilverPreferences.f33040a ? System.currentTimeMillis() : 0;
            MemoryCommitResult commitToMemory = commitToMemory();
            QuicksilverPreferences.this.m23235a(commitToMemory, (Runnable) null);
            try {
                commitToMemory.writtenToDiskLatch.await();
                if (QuicksilverPreferences.f33040a) {
                    Log.d(QuicksilverPreferences.f33041b, QuicksilverPreferences.this.f33047e.getName() + ":" + commitToMemory.memoryStateGeneration + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                notifyListeners(commitToMemory);
                return commitToMemory.writeToDiskResult;
            } catch (InterruptedException unused) {
                if (QuicksilverPreferences.f33040a) {
                    Log.d(QuicksilverPreferences.f33041b, QuicksilverPreferences.this.f33047e.getName() + ":" + commitToMemory.memoryStateGeneration + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                return false;
            } catch (Throwable th) {
                if (QuicksilverPreferences.f33040a) {
                    Log.d(QuicksilverPreferences.f33041b, QuicksilverPreferences.this.f33047e.getName() + ":" + commitToMemory.memoryStateGeneration + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                throw th;
            }
        }

        /* access modifiers changed from: private */
        public void notifyListeners(final MemoryCommitResult memoryCommitResult) {
            if (memoryCommitResult.listeners != null && memoryCommitResult.keysModified != null && memoryCommitResult.keysModified.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = memoryCommitResult.keysModified.size() - 1; size >= 0; size--) {
                        String str = memoryCommitResult.keysModified.get(size);
                        for (SharedPreferences.OnSharedPreferenceChangeListener next : memoryCommitResult.listeners) {
                            if (next != null) {
                                next.onSharedPreferenceChanged(QuicksilverPreferences.this, str);
                            }
                        }
                    }
                    return;
                }
                QuicksilverPreferencesHelper.f33062a.post(new Runnable() {
                    public void run() {
                        EditorImpl.this.notifyListeners(memoryCommitResult);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23235a(final MemoryCommitResult memoryCommitResult, final Runnable runnable) {
        boolean z = false;
        final boolean z2 = runnable == null;
        C114662 r3 = new Runnable() {
            public void run() {
                synchronized (QuicksilverPreferences.this.f33051i) {
                    QuicksilverPreferences.this.m23236a(memoryCommitResult, z2);
                }
                synchronized (QuicksilverPreferences.this.f33050h) {
                    QuicksilverPreferences.m23254k(QuicksilverPreferences.this);
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        };
        QueuedWork.QueuedTask queuedTask = new QueuedWork.QueuedTask(this.f33061s, r3);
        if (z2) {
            synchronized (this.f33050h) {
                if (this.f33053k == 1) {
                    z = true;
                }
            }
            if (z) {
                r3.run();
                return;
            }
        }
        if (z2) {
            QueuedWork.singleThreadExecutor().execute(r3);
        } else {
            QueuedWork.queueTask(queuedTask);
        }
    }

    /* renamed from: b */
    private static FileOutputStream m23241b(File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException unused) {
            File parentFile = file.getParentFile();
            if (!parentFile.mkdir()) {
                Log.e(f33041b, "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
            FileUtils.setPermissions(parentFile.getPath(), 505, -1, -1);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                Log.e(f33041b, "Couldn't create SharedPreferences file " + file, e);
                return null;
            }
        }
        return fileOutputStream;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00f5 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m23236a(com.didi.quicksilver.QuicksilverPreferences.MemoryCommitResult r24, boolean r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            boolean r0 = f33040a
            if (r0 == 0) goto L_0x000d
            long r5 = java.lang.System.currentTimeMillis()
            goto L_0x000f
        L_0x000d:
            r5 = 0
        L_0x000f:
            java.io.File r0 = r1.f33047e
            boolean r0 = r0.exists()
            boolean r7 = f33040a
            if (r7 == 0) goto L_0x001f
            long r7 = java.lang.System.currentTimeMillis()
            r9 = r7
            goto L_0x0023
        L_0x001f:
            r7 = 0
            r9 = 0
        L_0x0023:
            if (r0 == 0) goto L_0x0093
            long r13 = r1.f33059q
            long r3 = r2.memoryStateGeneration
            int r0 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            if (r25 == 0) goto L_0x0031
            r0 = 1
            goto L_0x0045
        L_0x0031:
            java.lang.Object r3 = r1.f33050h
            monitor-enter(r3)
            long r13 = r1.f33058p     // Catch:{ all -> 0x0041 }
            long r11 = r2.memoryStateGeneration     // Catch:{ all -> 0x0041 }
            int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            throw r0
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 != 0) goto L_0x004d
            r3 = 1
            r4 = 0
            r2.setDiskWriteResult(r4, r3)
            return
        L_0x004d:
            java.io.File r0 = r1.f33048f
            boolean r0 = r0.exists()
            boolean r3 = f33040a
            if (r3 == 0) goto L_0x005b
            long r9 = java.lang.System.currentTimeMillis()
        L_0x005b:
            if (r0 != 0) goto L_0x008e
            java.io.File r0 = r1.f33047e
            java.io.File r3 = r1.f33048f
            boolean r0 = r0.renameTo(r3)
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "QuicksilverPreferences"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Couldn't rename file "
            r3.append(r4)
            java.io.File r4 = r1.f33047e
            r3.append(r4)
            java.lang.String r4 = " to backup file "
            r3.append(r4)
            java.io.File r4 = r1.f33048f
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r0, r3)
            r3 = 0
            r2.setDiskWriteResult(r3, r3)
            return
        L_0x008e:
            java.io.File r0 = r1.f33047e
            r0.delete()
        L_0x0093:
            java.io.File r0 = r1.f33047e     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.io.FileOutputStream r0 = m23241b((java.io.File) r0)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            boolean r3 = f33040a     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            if (r3 == 0) goto L_0x00a2
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            goto L_0x00a4
        L_0x00a2:
            r11 = 0
        L_0x00a4:
            if (r0 != 0) goto L_0x00ab
            r3 = 0
            r2.setDiskWriteResult(r3, r3)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            return
        L_0x00ab:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.mapToWriteToDisk     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            com.didi.quicksilver.util.XmlUtils.writeMapXml(r3, r0)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            com.didi.quicksilver.util.FileUtils.sync(r0)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r0.close()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.io.File r0 = r1.f33047e     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r0 = r0.getPath()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            int r3 = r1.f33049g     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r4 = 0
            com.didi.quicksilver.util.FileUtils.setFilePermissionsFromMode(r0, r3, r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            boolean r0 = f33040a     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            if (r0 == 0) goto L_0x00d5
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r19 = r3
            goto L_0x00d7
        L_0x00d5:
            r19 = 0
        L_0x00d7:
            java.io.File r0 = r1.f33047e     // Catch:{ ErrnoException -> 0x00f3 }
            java.lang.String r0 = r0.getPath()     // Catch:{ ErrnoException -> 0x00f3 }
            com.didi.quicksilver.ext.StructStat r0 = com.didi.quicksilver.util.C11471Os.stat(r0)     // Catch:{ ErrnoException -> 0x00f3 }
            java.lang.Object r3 = r1.f33050h     // Catch:{ ErrnoException -> 0x00f3 }
            monitor-enter(r3)     // Catch:{ ErrnoException -> 0x00f3 }
            r21 = r13
            long r13 = r0.st_mtime     // Catch:{ all -> 0x00f0 }
            r1.f33055m = r13     // Catch:{ all -> 0x00f0 }
            long r13 = r0.st_size     // Catch:{ all -> 0x00f0 }
            r1.f33056n = r13     // Catch:{ all -> 0x00f0 }
            monitor-exit(r3)     // Catch:{ all -> 0x00f0 }
            goto L_0x00f5
        L_0x00f0:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00f0 }
            throw r0     // Catch:{ ErrnoException -> 0x00f5 }
        L_0x00f3:
            r21 = r13
        L_0x00f5:
            boolean r0 = f33040a     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            if (r0 == 0) goto L_0x00ff
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r13 = r3
            goto L_0x0101
        L_0x00ff:
            r13 = 0
        L_0x0101:
            java.io.File r0 = r1.f33048f     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r0.delete()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            boolean r0 = f33040a     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            if (r0 == 0) goto L_0x0110
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r15 = r3
            goto L_0x0112
        L_0x0110:
            r15 = 0
        L_0x0112:
            long r3 = r2.memoryStateGeneration     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r1.f33059q = r3     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r3 = 1
            r2.setDiskWriteResult(r3, r3)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            boolean r0 = f33040a     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            if (r0 == 0) goto L_0x0179
            java.lang.String r0 = "QuicksilverPreferences"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "write: "
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r7 = r7 - r5
            r3.append(r7)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r9 = r9 - r5
            r3.append(r9)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r11 = r11 - r5
            r3.append(r11)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r7 = r21 - r5
            r3.append(r7)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r7 = r17 - r5
            r3.append(r7)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r7 = r19 - r5
            r3.append(r7)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r13 = r13 - r5
            r3.append(r13)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            long r4 = r15 - r5
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            android.util.Log.d(r0, r3)     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
        L_0x0179:
            int r0 = r1.f33060r     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            r3 = 1
            int r0 = r0 + r3
            r1.f33060r = r0     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            boolean r3 = f33040a     // Catch:{ XmlPullParserException -> 0x0190, IOException -> 0x0186 }
            if (r3 != 0) goto L_0x0185
            int r0 = r0 % 1024
        L_0x0185:
            return
        L_0x0186:
            r0 = move-exception
            java.lang.String r3 = "QuicksilverPreferences"
            java.lang.String r4 = "writeToFile: Got exception:"
            android.util.Log.w(r3, r4, r0)
            goto L_0x0199
        L_0x0190:
            r0 = move-exception
            java.lang.String r3 = "QuicksilverPreferences"
            java.lang.String r4 = "writeToFile: Got exception:"
            android.util.Log.w(r3, r4, r0)
        L_0x0199:
            java.io.File r0 = r1.f33047e
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x01c1
            java.io.File r0 = r1.f33047e
            boolean r0 = r0.delete()
            if (r0 != 0) goto L_0x01c1
            java.lang.String r0 = "QuicksilverPreferences"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Couldn't clean up partially-written file "
            r3.append(r4)
            java.io.File r4 = r1.f33047e
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r0, r3)
        L_0x01c1:
            r3 = 0
            r2.setDiskWriteResult(r3, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.QuicksilverPreferences.m23236a(com.didi.quicksilver.QuicksilverPreferences$MemoryCommitResult, boolean):void");
    }
}
