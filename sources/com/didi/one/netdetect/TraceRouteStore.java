package com.didi.one.netdetect;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.model.TraceRouteCacheItem;
import com.didi.one.netdetect.model.TraceRouteReportInfo;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.one.netdetect.util.IOUtil;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;

class TraceRouteStore {

    /* renamed from: a */
    private static String f29415a = "OND_TraceRouteStore";

    /* renamed from: f */
    private static final String f29416f = "/traceroutes";

    /* renamed from: g */
    private static final int f29417g = 3;

    /* renamed from: h */
    private static final long f29418h = 604800000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f29419b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DetectionParam f29420c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SignGenerator f29421d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public File f29422e;

    private TraceRouteStore() {
    }

    private static class SingletonHolader {
        /* access modifiers changed from: private */
        public static TraceRouteStore INSTANCE = new TraceRouteStore();

        private SingletonHolader() {
        }
    }

    /* renamed from: a */
    public static TraceRouteStore m20718a() {
        return SingletonHolader.INSTANCE;
    }

    /* renamed from: a */
    public void mo80419a(Context context, DetectionParam detectionParam, SignGenerator signGenerator) {
        this.f29419b = context;
        this.f29420c = detectionParam;
        this.f29421d = signGenerator;
        m20725c();
        if (m20727d()) {
            mo80422b();
        }
    }

    /* renamed from: c */
    private void m20725c() {
        this.f29422e = IOUtil.createPath(this.f29419b.getFilesDir().getAbsolutePath() + f29416f);
    }

    /* renamed from: a */
    public void mo80421a(String str, int i, TraceRouteReportInfo traceRouteReportInfo) {
        File file = new File(this.f29422e, "traceroute_" + String.valueOf(System.currentTimeMillis()));
        TraceRouteCacheItem traceRouteCacheItem = new TraceRouteCacheItem();
        traceRouteCacheItem.setHost(str);
        traceRouteCacheItem.setFailCount(i);
        traceRouteCacheItem.setInfo(traceRouteReportInfo);
        mo80420a(file, traceRouteCacheItem);
    }

    /* renamed from: a */
    public void mo80420a(File file, TraceRouteCacheItem traceRouteCacheItem) {
        try {
            IOUtil.save(file, new Gson().toJson((Object) traceRouteCacheItem));
        } catch (IOException e) {
            if (file.exists()) {
                file.delete();
            }
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private boolean m20727d() {
        String str = f29415a;
        SystemUtils.log(3, str, this.f29422e.getAbsolutePath() + " is exist: " + this.f29422e.exists(), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 104);
        try {
            String[] list = this.f29422e.list();
            if (list == null || list.length <= 0) {
                return false;
            }
            return true;
        } catch (OutOfMemoryError e) {
            m20728e();
            String str2 = f29415a;
            SystemUtils.log(6, str2, "OOM occur in checkCachedTraceRoute() => " + e.getLocalizedMessage(), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 112);
            System.gc();
            String[] list2 = this.f29422e.list();
            String str3 = f29415a;
            StringBuilder sb = new StringBuilder();
            sb.append("fileCount: ");
            sb.append(list2 == null ? "null" : Integer.valueOf(list2.length));
            SystemUtils.log(3, str3, sb.toString(), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 117);
            return false;
        }
    }

    /* renamed from: e */
    private void m20728e() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        String str = f29415a;
        SystemUtils.log(6, str, "java maxMemory: " + m20720a(maxMemory), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 130);
        String str2 = f29415a;
        SystemUtils.log(6, str2, "java totalMemory: " + m20720a(j), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 131);
        String str3 = f29415a;
        SystemUtils.log(6, str3, "java freeMemory: " + m20720a(freeMemory), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 132);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) this.f29419b.getSystemService("activity")).getMemoryInfo(memoryInfo);
        String str4 = f29415a;
        SystemUtils.log(6, str4, "MemoryInfo availMem: " + m20720a(memoryInfo.availMem), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 137);
        String str5 = f29415a;
        SystemUtils.log(6, str5, "MemoryInfo totalMem: " + m20720a(memoryInfo.totalMem), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 138);
        String str6 = f29415a;
        SystemUtils.log(6, str6, "MemoryInfo lowMemory: " + memoryInfo.lowMemory, (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 139);
        String str7 = f29415a;
        SystemUtils.log(6, str7, "MemoryInfo threshold: " + m20720a(memoryInfo.threshold), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 140);
    }

    /* renamed from: a */
    private String m20720a(long j) {
        return Formatter.formatFileSize(this.f29419b, j);
    }

    /* renamed from: b */
    public void mo80422b() {
        Thread thread = new Thread(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|23) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0073 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r14 = this;
                    com.didi.one.netdetect.TraceRouteStore r0 = com.didi.one.netdetect.TraceRouteStore.this
                    java.io.File r0 = r0.f29422e
                    java.lang.String[] r0 = r0.list()
                    com.google.gson.Gson r1 = new com.google.gson.Gson
                    r1.<init>()
                    if (r0 == 0) goto L_0x007e
                    int r2 = r0.length
                    r3 = 0
                L_0x0013:
                    if (r3 >= r2) goto L_0x007e
                    r4 = r0[r3]
                    java.io.File r5 = new java.io.File
                    r5.<init>(r4)
                    com.didi.one.netdetect.TraceRouteStore r4 = com.didi.one.netdetect.TraceRouteStore.this
                    boolean r4 = r4.m20722a((java.io.File) r5)
                    if (r4 == 0) goto L_0x0025
                    goto L_0x007b
                L_0x0025:
                    java.lang.String r4 = com.didi.one.netdetect.util.IOUtil.read(r5)     // Catch:{ IOException -> 0x0077 }
                    boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0077 }
                    if (r6 == 0) goto L_0x0033
                    r5.delete()     // Catch:{ IOException -> 0x0077 }
                    goto L_0x007b
                L_0x0033:
                    java.lang.Class<com.didi.one.netdetect.model.TraceRouteCacheItem> r6 = com.didi.one.netdetect.model.TraceRouteCacheItem.class
                    java.lang.Object r4 = r1.fromJson((java.lang.String) r4, r6)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.model.TraceRouteCacheItem r4 = (com.didi.one.netdetect.model.TraceRouteCacheItem) r4     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.String r6 = r4.getHost()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    int r7 = r4.getFailCount()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.model.TraceRouteReportInfo r11 = r4.getInfo()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JsonSyntaxException -> 0x0073 }
                    r8.<init>()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    r8.append(r6)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.String r6 = "/appNetMonitor/v2/trInfoReport"
                    r8.append(r6)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.String r9 = r8.toString()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore r6 = com.didi.one.netdetect.TraceRouteStore.this     // Catch:{ JsonSyntaxException -> 0x0073 }
                    android.content.Context r8 = r6.f29419b     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore r6 = com.didi.one.netdetect.TraceRouteStore.this     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.model.DetectionParam r10 = r6.f29420c     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore r6 = com.didi.one.netdetect.TraceRouteStore.this     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.security.SignGenerator r12 = r6.f29421d     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore$1$1 r13 = new com.didi.one.netdetect.TraceRouteStore$1$1     // Catch:{ JsonSyntaxException -> 0x0073 }
                    r13.<init>(r5, r7, r4)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.http.HttpService.traceRouteInfoReport(r8, r9, r10, r11, r12, r13)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    goto L_0x007b
                L_0x0073:
                    r5.delete()     // Catch:{ IOException -> 0x0077 }
                    goto L_0x007b
                L_0x0077:
                    r4 = move-exception
                    r4.printStackTrace()
                L_0x007b:
                    int r3 = r3 + 1
                    goto L_0x0013
                L_0x007e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.TraceRouteStore.C103251.run():void");
            }
        });
        thread.setPriority(10);
        thread.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20722a(File file) {
        String[] split = file.getName().split("_");
        if (split.length != 2) {
            return false;
        }
        try {
            if (System.currentTimeMillis() - Long.parseLong(split[1]) <= 604800000) {
                return false;
            }
            file.delete();
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
