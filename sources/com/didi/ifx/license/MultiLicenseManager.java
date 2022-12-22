package com.didi.ifx.license;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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

public class MultiLicenseManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f24323a = "MultiLicenseManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f24324b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f24325c;

    /* renamed from: d */
    private boolean f24326d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f24327e;

    /* renamed from: f */
    private int f24328f;

    /* renamed from: g */
    private MultiLicense[] f24329g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f24330h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f24331i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f24332j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f24333k;

    /* renamed from: l */
    private IFXTrackCallback f24334l;
    private long token;

    private class MultiLicense {
        /* access modifiers changed from: private */

        /* renamed from: ቮ */
        public String f24335;
        /* access modifiers changed from: private */

        /* renamed from: ᡆ */
        public boolean f24336;
        /* access modifiers changed from: private */

        /* renamed from: ᬪ */
        public long f24337;

        /* renamed from: Ṉ */
        private ScheduledExecutorService f24338;

        /* renamed from: ᾖ */
        private String f24339;
        /* access modifiers changed from: private */

        /* renamed from: ㄲ */
        public LicenseFile f24340;

        /* renamed from: 㑝 */
        private InferenceMonitor f24341;
        /* access modifiers changed from: private */

        /* renamed from: 㕴 */
        public long f24342;
        /* access modifiers changed from: private */

        /* renamed from: 㡼 */
        public long f24343;
        /* access modifiers changed from: private */

        /* renamed from: 㫨 */
        public int f24344;
        /* access modifiers changed from: private */

        /* renamed from: 䞂 */
        public boolean f24345;
        /* access modifiers changed from: private */

        /* renamed from: 䞦 */
        public String f24346;
        /* access modifiers changed from: private */

        /* renamed from: 䠰 */
        public long f24347;

        /* renamed from: 䧁 */
        private final MediaType f24348;

        /* renamed from: 䫅 */
        private OkHttpClient f24349;

        /* renamed from: 䳷 */
        private int f24350;

        /* renamed from: 侷 */
        private long f24352;
        /* access modifiers changed from: private */

        /* renamed from: 俛 */
        public Gson f24353;

        /* renamed from: 偡 */
        private String f24354;
        /* access modifiers changed from: private */

        /* renamed from: 儵 */
        public String f24355;

        private class HeartBeat implements Runnable {

            /* renamed from: 䞂 */
            private long f24358;

            HeartBeat(long j) {
                this.f24358 = j;
            }

            public void run() {
                try {
                    Thread.sleep(((long) new Random().nextInt((int) this.f24358)) * 1000);
                } catch (InterruptedException e) {
                    String a = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(6, a, "[HeartBeat]Heartbeat of " + MultiLicense.this.f24355 + ": " + e.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$HeartBeat", 5);
                    MultiLicenseManager.this.m17374a("IFXLicenseManagerError", (Throwable) e);
                    Thread.currentThread().interrupt();
                }
                MultiLicense.this.m17389();
            }
        }

        private class InferenceMonitor {

            /* renamed from: ቮ */
            private int f24360;

            /* renamed from: ᡆ */
            private int f24361;

            /* renamed from: ᾖ */
            private int f24363;

            /* renamed from: ㄲ */
            private int f24364;

            /* renamed from: 䞂 */
            private ScheduledExecutorService f24365;

            /* renamed from: 䞦 */
            private int f24366;

            /* renamed from: 䧁 */
            private long f24367;

            /* renamed from: 䫅 */
            private long f24368;

            /* renamed from: 䳷 */
            private int f24369;

            /* renamed from: 偡 */
            private long f24370;

            /* renamed from: 儵 */
            private int f24371;

            InferenceMonitor(int i) {
                m17433();
                this.f24361 = i;
                ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                this.f24365 = newSingleThreadScheduledExecutor;
                C92721 r1 = new Runnable(MultiLicense.this) {
                    public void run() {
                        InferenceMonitor.this.m17437();
                    }
                };
                long j = (long) this.f24361;
                newSingleThreadScheduledExecutor.scheduleWithFixedDelay(r1, j, j, TimeUnit.MINUTES);
            }

            /* access modifiers changed from: private */
            /* renamed from: ቮ */
            public synchronized void m17432() {
                ScheduledExecutorService scheduledExecutorService = this.f24365;
                if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                    if (this.f24370 > 0) {
                        m17437();
                    }
                    this.f24365.shutdown();
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0132=Splitter:B:32:0x0132, B:23:0x00f4=Splitter:B:23:0x00f4} */
            /* renamed from: 偡 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void m17437() {
                /*
                    r8 = this;
                    monitor-enter(r8)
                    long r0 = r8.f24370     // Catch:{ all -> 0x0147 }
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x000e
                    r8.m17433()     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x000e:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.f24335     // Catch:{ all -> 0x0147 }
                    if (r0 == 0) goto L_0x0132
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.f24335     // Catch:{ all -> 0x0147 }
                    boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0147 }
                    if (r0 == 0) goto L_0x0024
                    goto L_0x0132
                L_0x0024:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0109 }
                    java.lang.String r0 = r0.f24335     // Catch:{ all -> 0x0109 }
                    java.lang.String r0 = com.didi.ifx.license.C9281a.m17443a((java.lang.String) r0)     // Catch:{ all -> 0x0109 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r2 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    android.content.Context r2 = r2.f24327e     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = com.didi.ifx.license.C9282b.m17452a((android.content.Context) r2)     // Catch:{ all -> 0x0147 }
                    java.lang.String unused = r1.f24346 = r2     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = r1.f24346     // Catch:{ all -> 0x0147 }
                    if (r1 == 0) goto L_0x00f4
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = r1.f24346     // Catch:{ all -> 0x0147 }
                    boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0147 }
                    if (r1 == 0) goto L_0x0053
                    goto L_0x00f4
                L_0x0053:
                    long r1 = r8.f24367     // Catch:{ all -> 0x0147 }
                    double r1 = (double) r1     // Catch:{ all -> 0x0147 }
                    long r3 = r8.f24368     // Catch:{ all -> 0x0147 }
                    double r3 = (double) r3     // Catch:{ all -> 0x0147 }
                    double r1 = r1 / r3
                    r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
                    double r1 = r1 * r3
                    long r1 = java.lang.Math.round(r1)     // Catch:{ all -> 0x0147 }
                    double r1 = (double) r1     // Catch:{ all -> 0x0147 }
                    double r1 = r1 / r3
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0147 }
                    r3.<init>()     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "license_key_checksum"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.f24346     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "device_id"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = "sdk_version"
                    java.lang.String r4 = "2.1.1"
                    r3.put(r0, r4)     // Catch:{ all -> 0x0147 }
                    long r4 = r8.f24370     // Catch:{ all -> 0x0147 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "inference_cnt"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    long r4 = r8.f24368     // Catch:{ all -> 0x0147 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "inference_success_cnt"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    java.lang.Double r0 = java.lang.Double.valueOf(r1)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "inference_avg"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f24360     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_100_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f24364     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_101_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f24366     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_102_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f24369     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_104_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f24363     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_108_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f24371     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_109_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r0 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "tech_ifx_report_inference_agg"
                    r0.m17375a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r3)     // Catch:{ all -> 0x0147 }
                    r8.m17433()     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x00f4:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r0 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = r0.f24323a     // Catch:{ all -> 0x0147 }
                    java.lang.String r3 = "[InferenceMonitor]Device Id is invalid"
                    r1 = 6
                    r4 = 0
                    java.lang.String r5 = "com.didi.ifx.license.MultiLicenseManager$MultiLicense$InferenceMonitor"
                    r6 = 46
                    com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x0109:
                    r0 = move-exception
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r1 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r3 = r1.f24323a     // Catch:{ all -> 0x0147 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
                    r1.<init>()     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = "[InferenceMonitor]Fetch license key checksum fail: "
                    r1.append(r2)     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0147 }
                    r1.append(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0147 }
                    r2 = 6
                    r5 = 0
                    java.lang.String r6 = "com.didi.ifx.license.MultiLicenseManager$MultiLicense$InferenceMonitor"
                    r7 = 47
                    com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x0132:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r0 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = r0.f24323a     // Catch:{ all -> 0x0147 }
                    java.lang.String r3 = "[InferenceMonitor]License key is invalid"
                    r1 = 6
                    r4 = 0
                    java.lang.String r5 = "com.didi.ifx.license.MultiLicenseManager$MultiLicense$InferenceMonitor"
                    r6 = 48
                    com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x0147:
                    r0 = move-exception
                    monitor-exit(r8)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.MultiLicenseManager.MultiLicense.InferenceMonitor.m17437():void");
            }

            /* renamed from: 䞂 */
            private void m17433() {
                this.f24370 = 0;
                this.f24360 = 0;
                this.f24364 = 0;
                this.f24366 = 0;
                this.f24369 = 0;
                this.f24363 = 0;
                this.f24371 = 0;
                this.f24368 = 0;
                this.f24367 = 0;
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
                return;
             */
            /* renamed from: 䞂 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void m17434(long r8) {
                /*
                    r7 = this;
                    monitor-enter(r7)
                    r0 = -666(0xfffffffffffffd66, double:NaN)
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x0009
                    monitor-exit(r7)
                    return
                L_0x0009:
                    long r0 = r7.f24370     // Catch:{ all -> 0x006a }
                    r2 = 1
                    long r0 = r0 + r2
                    r7.f24370 = r0     // Catch:{ all -> 0x006a }
                    r0 = 30000(0x7530, double:1.4822E-319)
                    r4 = -8
                    int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r6 <= 0) goto L_0x0019
                    r8 = r4
                L_0x0019:
                    r0 = 0
                    int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r6 >= 0) goto L_0x0058
                    r0 = -9
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x002c
                    int r8 = r7.f24364     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f24364 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x002c:
                    r0 = -1
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x0039
                    int r8 = r7.f24366     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f24366 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0039:
                    r0 = -3
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x0046
                    int r8 = r7.f24369     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f24369 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0046:
                    int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x0051
                    int r8 = r7.f24363     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f24363 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0051:
                    int r8 = r7.f24371     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f24371 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0058:
                    int r0 = r7.f24360     // Catch:{ all -> 0x006a }
                    int r0 = r0 + 1
                    r7.f24360 = r0     // Catch:{ all -> 0x006a }
                    long r0 = r7.f24368     // Catch:{ all -> 0x006a }
                    long r0 = r0 + r2
                    r7.f24368 = r0     // Catch:{ all -> 0x006a }
                    long r0 = r7.f24367     // Catch:{ all -> 0x006a }
                    long r0 = r0 + r8
                    r7.f24367 = r0     // Catch:{ all -> 0x006a }
                L_0x0068:
                    monitor-exit(r7)
                    return
                L_0x006a:
                    r8 = move-exception
                    monitor-exit(r7)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.MultiLicenseManager.MultiLicense.InferenceMonitor.m17434(long):void");
            }
        }

        private MultiLicense() {
            this.f24348 = MediaType.parse("application/json; charset=utf-8");
            this.f24352 = 2;
            this.f24342 = 5;
            this.f24347 = 15;
            this.f24337 = 5;
        }

        /* access modifiers changed from: private */
        /* renamed from: ᾖ */
        public void m17389() {
            m17415();
            if (MultiLicenseManager.this.f24324b && System.currentTimeMillis() >= this.f24343 * 1000) {
                long currentTimeMillis = System.currentTimeMillis();
                int r3 = m17397(true);
                if (r3 == -6) {
                    m17429(false);
                } else if (r3 == -1) {
                    m17429(true);
                } else if (r3 == 0) {
                    int r2 = !this.f24345 ? m17393(this.f24340) : 0;
                    if (r2 > 0) {
                        String a = MultiLicenseManager.this.f24323a;
                        SystemUtils.log(4, a, "[updateLicense]CheckLicense fail during update when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 15);
                        boolean unused = MultiLicenseManager.this.f24330h = false;
                        m17401(r2, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    }
                    m17429(false);
                    m17401(r2, System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }

        /* renamed from: 䞦 */
        private void m17415() {
            String str = this.f24335;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReport]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 29);
                return;
            }
            try {
                String a = C9281a.m17443a(this.f24335);
                String a2 = C9282b.m17452a(MultiLicenseManager.this.f24327e);
                this.f24346 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReport]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 27);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f24346);
                hashMap.put("sdk_version", "2.1.1");
                MultiLicenseManager.this.m17375a("tech_ifx_report", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f24323a;
                SystemUtils.log(6, a3, "[omegaReport]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 28);
            }
        }

        /* renamed from: 䳷 */
        private void m17420() {
            this.f24338.shutdown();
        }

        /* access modifiers changed from: private */
        /* renamed from: 儵 */
        public boolean m17431() {
            m17415();
            if (MultiLicenseManager.this.f24324b) {
                long currentTimeMillis = System.currentTimeMillis();
                int r3 = m17397(false);
                if (r3 == -6) {
                    String a = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a, "[verifyLicense]License file is broken and need pulled from server when process " + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 36);
                    m17426(this.f24352, this.f24347, this.f24337);
                    return true;
                } else if (r3 == -4) {
                    String a2 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a2, "[verifyLicense]License file may be modified illegally when process " + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 32);
                    return false;
                } else if (r3 == -3) {
                    String a3 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a3, "[verifyLicense]Decode license file fail when process" + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 29);
                    return false;
                } else if (r3 == -2) {
                    String a4 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a4, "[verifyLicense]Read license file fail when process " + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 26);
                    return false;
                } else if (r3 == -1) {
                    m17426(this.f24352, this.f24347, this.f24337);
                    return true;
                } else if (r3 != 0) {
                    String a5 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(6, a5, "[verifyLicense]Fetch local license fail when process " + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 7);
                    return false;
                } else {
                    int r32 = !this.f24345 ? m17393(this.f24340) : 0;
                    if (r32 > 0) {
                        String a6 = MultiLicenseManager.this.f24323a;
                        SystemUtils.log(6, a6, "[verifyLicense]CheckLicense fail when process" + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 15);
                        m17401(r32, System.currentTimeMillis() - currentTimeMillis);
                        return false;
                    }
                    m17401(r32, System.currentTimeMillis() - currentTimeMillis);
                    m17426(this.f24352, this.f24347, this.f24337);
                    return true;
                }
            } else {
                m17426(this.f24352, this.f24347, this.f24337);
                return true;
            }
        }

        /* renamed from: ቮ */
        private void m17385() {
            this.f24349 = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
        }

        /* access modifiers changed from: private */
        /* renamed from: ㄲ */
        public void m17390() {
            m17420();
            InferenceMonitor inferenceMonitor = this.f24341;
            if (inferenceMonitor != null) {
                inferenceMonitor.m17432();
            }
        }

        /* renamed from: 䞂 */
        static /* synthetic */ int m17394(MultiLicense multiLicense) {
            int i = multiLicense.f24344;
            multiLicense.f24344 = i + 1;
            return i;
        }

        /* renamed from: 偡 */
        private void m17429(final boolean z) {
            if (z) {
                if (this.f24344 >= 100) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 6);
                    this.f24344 = 0;
                    return;
                }
            } else if (this.f24344 >= 100) {
                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 13);
                this.f24344 = 0;
                return;
            }
            String str = this.f24335;
            if (str == null || str.isEmpty()) {
                String a = MultiLicenseManager.this.f24323a;
                SystemUtils.log(6, a, "[httpUpdate]License key is empty when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 58);
                return;
            }
            String a2 = C9282b.m17452a(MultiLicenseManager.this.f24327e);
            this.f24346 = a2;
            if (a2 == null || a2.isEmpty()) {
                String a3 = MultiLicenseManager.this.f24323a;
                SystemUtils.log(6, a3, "[httpUpdate]Device Id is empty when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 57);
                return;
            }
            this.f24349.newCall(new Request.Builder().url(MultiLicenseManager.this.f24331i).post(RequestBody.create(this.f24348, this.f24353.toJson((Object) new RegisterRequest(this.f24335, this.f24346, "android", C9285e.m17460a(), C9285e.m17461b(), C9285e.m17462c(), C9285e.m17463d(), System.currentTimeMillis() / 1000, "2.1.1")))).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    String a = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a, "[httpUpdate]HTTP response fail with error: " + iOException.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 1);
                    MultiLicense.this.m17402(0, 0, iOException.getMessage());
                    MultiLicense.m17394(MultiLicense.this);
                }

                public void onResponse(Call call, Response response) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long receivedResponseAtMillis = response.receivedResponseAtMillis() - response.sentRequestAtMillis();
                    MultiLicense.this.m17411(z, receivedResponseAtMillis);
                    int unused = MultiLicense.this.f24344 = 0;
                    if (response.isSuccessful()) {
                        String a = MultiLicenseManager.this.f24323a;
                        SystemUtils.log(3, a, "[httpUpdate]HTTP return code: " + response.code() + " msg: " + response.message(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 8);
                        if (response.body() == null) {
                            SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[httpUpdate]HTTP response body is empty", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 10);
                            MultiLicenseManager.this.m17374a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP response body is empty"));
                            MultiLicense.m17394(MultiLicense.this);
                            return;
                        }
                        try {
                            RegisterResponse registerResponse = (RegisterResponse) MultiLicense.this.f24353.fromJson(response.body().string(), RegisterResponse.class);
                            try {
                                long j = registerResponse.get_code();
                                if (j == 20000) {
                                    try {
                                        String str = registerResponse.get_license_content();
                                        if (str == null || str.isEmpty()) {
                                            String a2 = MultiLicenseManager.this.f24323a;
                                            SystemUtils.log(4, a2, "[httpUpdate]Json license data is null when process " + MultiLicense.this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 110);
                                            MultiLicenseManager multiLicenseManager = MultiLicenseManager.this;
                                            multiLicenseManager.m17374a("IFXLicenseManagerError", new Throwable("[httpUpdate]Json license data is null when process " + MultiLicense.this.f24355));
                                            MultiLicense.m17394(MultiLicense.this);
                                            return;
                                        }
                                        try {
                                            LicenseFile licenseFile = (LicenseFile) MultiLicense.this.f24353.fromJson(str, LicenseFile.class);
                                            int r9 = !MultiLicense.this.f24345 ? MultiLicense.this.m17393(licenseFile) : 0;
                                            if (r9 > 0) {
                                                boolean unused2 = MultiLicenseManager.this.f24330h = false;
                                                MultiLicense.this.m17401(r9, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                                return;
                                            }
                                            MultiLicense.this.m17401(r9, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                            try {
                                                MultiLicense.this.m17428(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                                long heartbeatTime = licenseFile.getHeartbeatTime();
                                                long heartbeatBias = licenseFile.getHeartbeatBias();
                                                if (heartbeatTime < 0 || heartbeatBias < 0) {
                                                    String a3 = MultiLicenseManager.this.f24323a;
                                                    SystemUtils.log(4, a3, "[httpUpdate]Heartbeat time from response is invalid when process " + MultiLicense.this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 100);
                                                    MultiLicenseManager multiLicenseManager2 = MultiLicenseManager.this;
                                                    multiLicenseManager2.m17374a("IFXLicenseManagerError", new Throwable("[httpUpdate]Heartbeat time from response is invalid when process " + MultiLicense.this.f24355));
                                                    return;
                                                }
                                                if (!(heartbeatTime == MultiLicense.this.f24347 && heartbeatBias == MultiLicense.this.f24337)) {
                                                    long unused3 = MultiLicense.this.f24347 = heartbeatTime;
                                                    long unused4 = MultiLicense.this.f24337 = heartbeatBias;
                                                    MultiLicense multiLicense = MultiLicense.this;
                                                    multiLicense.m17404(multiLicense.f24342, MultiLicense.this.f24347, MultiLicense.this.f24337);
                                                }
                                                LicenseFile unused5 = MultiLicense.this.f24340 = licenseFile;
                                                long unused6 = MultiLicense.this.f24343 = licenseFile.getUpdateTimestamp();
                                                boolean unused7 = MultiLicense.this.f24336 = false;
                                            } catch (Throwable th) {
                                                String a4 = MultiLicenseManager.this.f24323a;
                                                SystemUtils.log(6, a4, "[httpUpdate]Write ifx.license fail when process " + MultiLicense.this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 104);
                                                MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th);
                                                MultiLicense.m17394(MultiLicense.this);
                                            }
                                        } catch (Throwable th2) {
                                            String a5 = MultiLicenseManager.this.f24323a;
                                            SystemUtils.log(6, a5, "[httpUpdate]Parse json license data fail when process " + MultiLicense.this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 107);
                                            MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th2);
                                            MultiLicense.m17394(MultiLicense.this);
                                        }
                                    } catch (Throwable th3) {
                                        Throwable th4 = th3;
                                        String a6 = MultiLicenseManager.this.f24323a;
                                        SystemUtils.log(4, a6, "[httpUpdate]Get resp license fail when process " + MultiLicense.this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 113);
                                        MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th4);
                                        MultiLicense.m17394(MultiLicense.this);
                                    }
                                } else if (j == 50000) {
                                    boolean unused8 = MultiLicenseManager.this.f24330h = false;
                                    SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[httpUpdate]HTTP response with code 50000", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 174);
                                    MultiLicense.this.m17402(response.code(), j, registerResponse.get_message());
                                    try {
                                        MultiLicense.this.m17410(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                    } catch (Throwable unused9) {
                                        SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[httpUpdate]ErrorSaveLocal fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 179);
                                        MultiLicenseManager.this.m17374a("IFXLicenseManagerError", new Throwable("[httpUpdate]ErrorSaveLocal fail"));
                                    }
                                } else {
                                    String a7 = MultiLicenseManager.this.f24323a;
                                    SystemUtils.log(4, a7, "[httpUpdate]Response with code " + j, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 185);
                                    MultiLicense.this.m17402(response.code(), j, registerResponse.get_message());
                                    MultiLicense.m17394(MultiLicense.this);
                                }
                            } catch (Throwable th5) {
                                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[httpUpdate]Get resp code fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 188);
                                MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th5);
                                MultiLicense.m17394(MultiLicense.this);
                            }
                        } catch (Throwable th6) {
                            SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[httpUpdate]Parse json response body fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 191);
                            MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th6);
                            MultiLicense.m17394(MultiLicense.this);
                        }
                    } else {
                        String a8 = MultiLicenseManager.this.f24323a;
                        SystemUtils.log(4, a8, "[httpUpdate]HTTP fail with response code " + response.code(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 291);
                        MultiLicenseManager multiLicenseManager3 = MultiLicenseManager.this;
                        multiLicenseManager3.m17374a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP fail with response code " + response.code()));
                        MultiLicense.m17394(MultiLicense.this);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public boolean m17414(String str, int i, int i2) {
            this.f24345 = false;
            this.f24350 = i2;
            this.f24339 = str;
            this.f24355 = "models[" + i + Const.jaRight;
            String r9 = m17399();
            this.f24335 = r9;
            if (r9 == null || r9.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[licenseInit]Fetch " + this.f24355 + " license key fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 47);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.f24343 = currentTimeMillis;
            this.f24343 = currentTimeMillis + (((long) this.f24350) * 60);
            if (MultiLicenseManager.this.f24332j == 1) {
                this.f24341 = new InferenceMonitor(MultiLicenseManager.this.f24333k);
            }
            if (MultiLicenseManager.this.f24324b) {
                String unused = MultiLicenseManager.this.f24331i = "https://ifx-license.didiglobal.com/v1/license/register";
                this.f24336 = true;
                this.f24353 = new GsonBuilder().create();
                m17385();
                this.f24344 = 0;
                String str2 = "model" + this.f24355;
                try {
                    this.f24354 = C9281a.m17449b(this.f24335 + this.f24339) + ".ifx.v1.license";
                } catch (Throwable unused2) {
                    SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[licenseInit]Fetch " + this.f24355 + " file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 44);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(".ifx.v1.license");
                    this.f24354 = sb.toString();
                }
            }
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public int m17393(LicenseFile licenseFile) {
            String str = this.f24335;
            if (str == null || str.isEmpty()) {
                String a = MultiLicenseManager.this.f24323a;
                SystemUtils.log(4, a, "[checkLicense]License key is empty when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 72);
                return 1;
            } else if (!licenseFile.getLicenseKey().equals(this.f24335)) {
                String a2 = MultiLicenseManager.this.f24323a;
                SystemUtils.log(4, a2, "[checkLicense]License key is invalid when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 53);
                return 1;
            } else {
                String a3 = C9282b.m17452a(MultiLicenseManager.this.f24327e);
                this.f24346 = a3;
                if (a3 == null || a3.isEmpty()) {
                    String a4 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a4, "[checkLicense]Device id is empty when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 71);
                    return 2;
                } else if (!licenseFile.getDeviceId().equals(this.f24346)) {
                    String a5 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a5, "[checkLicense]Device_id is invalid when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 64);
                    return 2;
                } else if (System.currentTimeMillis() <= licenseFile.getExpiryTimestamp() * 1000) {
                    return 0;
                } else {
                    String a6 = MultiLicenseManager.this.f24323a;
                    SystemUtils.log(4, a6, "[checkLicense]License is beyond expiry when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 70);
                    return 3;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 偡 */
        public void m17428(String str, String str2) {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            int length = bytes.length;
            FileOutputStream openFileOutput = MultiLicenseManager.this.f24327e.openFileOutput(this.f24354, 0);
            openFileOutput.write(C9281a.m17447a(length));
            openFileOutput.write(bytes);
            openFileOutput.write(bytes2);
            openFileOutput.write(C9281a.m17447a(616));
            openFileOutput.close();
        }

        /* access modifiers changed from: private */
        /* renamed from: 偡 */
        public String m17425() {
            String str = this.f24335;
            if (str == null || str.isEmpty()) {
                this.f24335 = "null";
            }
            return this.f24335;
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m17402(int i, long j, String str) {
            String str2 = this.f24335;
            if (str2 == null || str2.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReportHttpException]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 103);
                return;
            }
            try {
                String a = C9281a.m17443a(this.f24335);
                String a2 = C9282b.m17452a(MultiLicenseManager.this.f24327e);
                this.f24346 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReportHttpException]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 101);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f24346);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("status_code", Integer.valueOf(i));
                hashMap.put("code", Long.valueOf(j));
                hashMap.put("message", str);
                MultiLicenseManager.this.m17375a("tech_ifx_report_http_status", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f24323a;
                SystemUtils.log(6, a3, "[omegaReportHttpException]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 102);
            }
        }

        /* renamed from: 偡 */
        private void m17426(long j, long j2, long j3) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f24338 = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
            String a = MultiLicenseManager.this.f24323a;
            SystemUtils.log(3, a, "[startHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3 + " when process " + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 75);
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m17411(boolean z, long j) {
            String str = this.f24335;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReportNetworkLatency]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 133);
                return;
            }
            try {
                String a = C9281a.m17443a(this.f24335);
                String a2 = C9282b.m17452a(MultiLicenseManager.this.f24327e);
                this.f24346 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReportNetworkLatency]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 131);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f24346);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("first_register", Boolean.valueOf(z));
                hashMap.put("latency", Long.valueOf(j));
                MultiLicenseManager.this.m17375a("tech_ifx_report_http_latency", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f24323a;
                SystemUtils.log(6, a3, "[omegaReportNetworkLatency]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 132);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m17401(int i, long j) {
            String str = this.f24335;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReportLicenseCheck]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 190);
                return;
            }
            try {
                String a = C9281a.m17443a(this.f24335);
                String a2 = C9282b.m17452a(MultiLicenseManager.this.f24327e);
                this.f24346 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[omegaReportLicenseCheck]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 188);
                    return;
                }
                int i2 = 200;
                boolean z = false;
                boolean z2 = true;
                if (i > 0) {
                    i2 = i != 1 ? i != 2 ? i != 3 ? 209 : 203 : 202 : 201;
                    z2 = false;
                }
                if (j > 30000) {
                    j = -8;
                    i2 = 208;
                } else {
                    z = z2;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f24346);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("pass_check", Boolean.valueOf(z));
                hashMap.put("check_time", Long.valueOf(j));
                hashMap.put("code", Integer.valueOf(i2));
                MultiLicenseManager.this.m17375a("tech_ifx_report_check_license", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f24323a;
                SystemUtils.log(6, a3, "[omegaReportLicenseCheck]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 189);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m17403(long j) {
            if (MultiLicenseManager.this.f24332j != 1) {
                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[inferenceStatics]Please use omegaReportInference instead", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 192);
                return;
            }
            InferenceMonitor inferenceMonitor = this.f24341;
            if (inferenceMonitor == null) {
                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[inferenceStatics]InferenceMonitor is not initialized", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 196);
            } else {
                inferenceMonitor.m17434(j);
            }
        }

        /* renamed from: 䞂 */
        private String m17399() {
            InputStream inputStream;
            try {
                if (MultiLicenseManager.this.f24325c) {
                    inputStream = MultiLicenseManager.this.f24327e.getAssets().open(this.f24339);
                } else {
                    inputStream = new FileInputStream(this.f24339);
                }
                try {
                    C9281a.m17441a(inputStream);
                    try {
                        if (C9281a.m17441a(inputStream) % 100 != C9281a.f24380g) {
                            this.f24345 = true;
                            return "b3b9ca1474334e85a2baf43be1ac3595";
                        }
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        while (i < 4) {
                            try {
                                sb.append(String.format("%08x", new Object[]{Integer.valueOf(C9281a.m17441a(inputStream))}));
                                i++;
                            } catch (Throwable th) {
                                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchModelUuid]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 245);
                                MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th);
                                return null;
                            }
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchModelUuid]Fetch model version fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 253);
                        MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th2);
                        return null;
                    }
                } catch (Throwable th3) {
                    SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchModelUuid]Fetch framework version fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 255);
                    MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th3);
                    return null;
                }
            } catch (Throwable th4) {
                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchModelUuid]Open model file fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 257);
                MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th4);
                return null;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m17410(String str, String str2) {
            int length = str.length();
            int length2 = str2.length();
            FileOutputStream openFileOutput = MultiLicenseManager.this.f24327e.openFileOutput(this.f24354, 0);
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

        /* renamed from: 䞂 */
        private int m17397(boolean z) {
            try {
                FileInputStream openFileInput = MultiLicenseManager.this.f24327e.openFileInput(this.f24354);
                if (openFileInput == null) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Open ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 277);
                    MultiLicenseManager.this.m17374a("IFXLicenseManagerError", new Throwable("[fetchLocalLicenseInfo]Open ifx license fail when process " + this.f24339));
                    return -2;
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput);
                try {
                    int available = bufferedInputStream.available();
                    int i = available - 4;
                    try {
                        bufferedInputStream.mark(i);
                        bufferedInputStream.skip((long) i);
                        byte[] bArr = new byte[4];
                        try {
                            bufferedInputStream.read(bArr, 0, 4);
                            bufferedInputStream.reset();
                            if (C9281a.m17442a(bArr, 0) != 616) {
                                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Find ifx.license broken when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 316);
                                return -6;
                            }
                            byte[] bArr2 = new byte[4];
                            try {
                                bufferedInputStream.read(bArr2, 0, 4);
                                int a = C9281a.m17442a(bArr2, 0);
                                byte[] bArr3 = new byte[a];
                                try {
                                    bufferedInputStream.read(bArr3, 0, a);
                                    int i2 = (available - a) - 8;
                                    byte[] bArr4 = new byte[i2];
                                    try {
                                        bufferedInputStream.read(bArr4, 0, i2);
                                        String a2 = C9281a.m17444a(bArr4);
                                        try {
                                            bufferedInputStream.close();
                                            try {
                                                byte[] b = C9281a.m17450b(bArr3);
                                                try {
                                                    LicenseFile licenseFile = (LicenseFile) this.f24353.fromJson(C9281a.m17444a(b), LicenseFile.class);
                                                    try {
                                                        if (!C9284d.m17459a(b, licenseFile.getPublicKey(), a2)) {
                                                            SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Verify license not pass when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 391);
                                                            return -4;
                                                        }
                                                        this.f24340 = licenseFile;
                                                        long updateTimestamp = licenseFile.getUpdateTimestamp();
                                                        this.f24343 = updateTimestamp;
                                                        if (this.f24336) {
                                                            this.f24343 = updateTimestamp + (((long) this.f24350) * 60);
                                                        }
                                                        if (!z) {
                                                            long heartbeatTime = this.f24340.getHeartbeatTime();
                                                            if (heartbeatTime >= 0) {
                                                                this.f24347 = heartbeatTime;
                                                            }
                                                            long heartbeatBias = this.f24340.getHeartbeatBias();
                                                            if (heartbeatBias >= 0) {
                                                                this.f24337 = heartbeatBias;
                                                            }
                                                        }
                                                        return 0;
                                                    } catch (Throwable th) {
                                                        SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Verify license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 410);
                                                        MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th);
                                                        return -4;
                                                    }
                                                } catch (Throwable th2) {
                                                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Parse license file info fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 412);
                                                    MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th2);
                                                    return -3;
                                                }
                                            } catch (Throwable th3) {
                                                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Decode license data fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 414);
                                                MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th3);
                                                return -3;
                                            }
                                        } catch (Throwable th4) {
                                            SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Close ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 416);
                                            MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th4);
                                            return -2;
                                        }
                                    } catch (Throwable th5) {
                                        SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Read signature in ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 418);
                                        MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th5);
                                        return -2;
                                    }
                                } catch (Throwable th6) {
                                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Read license content in ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 420);
                                    MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th6);
                                    return -2;
                                }
                            } catch (Throwable th7) {
                                SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Read license content in ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 422);
                                MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th7);
                                return -2;
                            }
                        } catch (Throwable th8) {
                            SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Read ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 424);
                            MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th8);
                            return -2;
                        }
                    } catch (Throwable th9) {
                        SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Read ifx.license fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 426);
                        MultiLicenseManager.this.m17374a("IFXLicenseManagerError", th9);
                        return -2;
                    }
                } catch (IOException e) {
                    SystemUtils.log(6, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]Read ifx.license size fail when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 428);
                    MultiLicenseManager.this.m17374a("IFXLicenseManagerError", (Throwable) e);
                    return -2;
                }
            } catch (FileNotFoundException unused) {
                SystemUtils.log(4, MultiLicenseManager.this.f24323a, "[fetchLocalLicenseInfo]File ifx.license does not exist when process " + this.f24339, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 430);
                return -1;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m17404(long j, long j2, long j3) {
            this.f24338.shutdown();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f24338 = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
            String a = MultiLicenseManager.this.f24323a;
            SystemUtils.log(3, a, "[resetHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3 + " when process " + this.f24355, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 434);
        }
    }

    public MultiLicenseManager(Context context) {
        this.f24327e = context;
        this.f24324b = true;
        this.f24325c = false;
        this.f24332j = 0;
        this.f24333k = 10;
    }

    public boolean multiLicenseManagerInit(String[] strArr) {
        if (strArr == null) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 1);
            return false;
        }
        int length = strArr.length;
        this.f24328f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 7);
            return false;
        }
        this.f24329g = new MultiLicense[length];
        int[] iArr = new int[length];
        for (int i = 0; i < this.f24328f; i++) {
            iArr[i] = i;
        }
        C9281a.m17445a(iArr);
        for (int i2 = 0; i2 < this.f24328f; i2++) {
            this.f24329g[i2] = new MultiLicense();
            if (!this.f24329g[i2].m17414(strArr[i2], i2, iArr[i2])) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 23);
                return false;
            }
        }
        this.f24330h = false;
        this.token = 0;
        return true;
    }

    public boolean multiLicenseManagerInitWithModelInAssets(String[] strArr) {
        this.f24325c = true;
        if (strArr == null) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 3);
            return false;
        }
        int length = strArr.length;
        this.f24328f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 9);
            return false;
        }
        this.f24329g = new MultiLicense[length];
        int[] iArr = new int[length];
        for (int i = 0; i < this.f24328f; i++) {
            iArr[i] = i;
        }
        C9281a.m17445a(iArr);
        for (int i2 = 0; i2 < this.f24328f; i2++) {
            this.f24329g[i2] = new MultiLicense();
            if (!this.f24329g[i2].m17414(strArr[i2], i2, iArr[i2])) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 25);
                return false;
            }
        }
        this.f24330h = false;
        this.token = 0;
        return true;
    }

    public void multiLicenseMangerRelease() {
        for (int i = 0; i < this.f24328f; i++) {
            this.f24329g[i].m17390();
        }
    }

    public boolean multiLicenseMangerVerifyLicense() {
        for (int i = 0; i < this.f24328f; i++) {
            if (!this.f24329g[i].m17431()) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseMangerVerifyLicense]License verify fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 4);
                this.f24330h = false;
                return false;
            }
        }
        this.f24330h = true;
        return true;
    }

    public void multiLicenseMangerVerifyToken() {
        long currentTimeMillis = System.currentTimeMillis() ^ C9281a.f24374a;
        int i = C9281a.f24377d;
        if (!this.f24330h && ((i = new Random().nextInt(C9281a.f24378e)) == C9281a.f24377d || i == C9281a.f24378e)) {
            i--;
        }
        this.token = (((currentTimeMillis * 100) + ((long) i)) ^ C9281a.f24375b) << C9281a.f24376c;
    }

    public void omegaReportInference(long[] jArr) {
        if (jArr != null && jArr.length > 0) {
            int i = this.f24332j;
            int i2 = 0;
            if (i == 0) {
                while (i2 < jArr.length) {
                    m17373a(this.f24329g[i2].m17425(), jArr[i2]);
                    i2++;
                }
            } else if (i == 1) {
                while (i2 < jArr.length) {
                    this.f24329g[i2].m17403(jArr[i2]);
                    i2++;
                }
            }
        }
    }

    public void setIFXTrackCallback(IFXTrackCallback iFXTrackCallback) {
        this.f24326d = true;
        this.f24334l = iFXTrackCallback;
    }

    public void setLocationCode(int i) {
        if (i != 1) {
            this.f24331i = "https://ifx-license.didiglobal.com/v1/license/register";
        } else {
            this.f24331i = "https://ifx-license.didiglobal.com/v1/license/register";
        }
    }

    public void setOnlineLicenseSwitch(boolean z) {
        this.f24324b = z;
    }

    /* renamed from: a */
    private void m17373a(String str, long j) {
        if (j != -666) {
            if (this.f24332j != 0) {
                SystemUtils.log(4, this.f24323a, "please use inferenceStatics instead", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 7);
            } else if (str == null || str.isEmpty()) {
                SystemUtils.log(6, this.f24323a, "omegaReportInference: License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 52);
            } else {
                try {
                    String a = C9281a.m17443a(str);
                    String a2 = C9282b.m17452a(this.f24327e);
                    if (a2 == null || a2.isEmpty()) {
                        SystemUtils.log(6, this.f24323a, "omegaReportInference: Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 50);
                        return;
                    }
                    int i = 100;
                    if (j < 0) {
                        i = j == -9 ? 101 : j == -1 ? 102 : j == -3 ? 104 : 109;
                    }
                    if (j > 30000) {
                        j = -8;
                        i = 108;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("license_key_checksum", a);
                    hashMap.put("device_id", a2);
                    hashMap.put("sdk_version", "2.1.1");
                    hashMap.put("inference_time", Long.valueOf(j));
                    hashMap.put("code", Integer.valueOf(i));
                    m17375a("tech_ifx_report_inference", (Map<String, Object>) hashMap);
                } catch (Throwable th) {
                    String str2 = this.f24323a;
                    SystemUtils.log(6, str2, "omegaReportInference: fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 51);
                }
            }
        }
    }

    public boolean multiLicenseManagerInit(String[] strArr, int i) {
        if (strArr == null) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 30);
            return false;
        }
        int length = strArr.length;
        this.f24328f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 36);
            return false;
        }
        this.f24329g = new MultiLicense[length];
        this.f24332j = i;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < this.f24328f; i2++) {
            iArr[i2] = i2;
        }
        C9281a.m17445a(iArr);
        for (int i3 = 0; i3 < this.f24328f; i3++) {
            this.f24329g[i3] = new MultiLicense();
            if (!this.f24329g[i3].m17414(strArr[i3], i3, iArr[i3])) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 53);
                return false;
            }
        }
        this.f24330h = false;
        this.token = 0;
        return true;
    }

    public boolean multiLicenseManagerInitWithModelInAssets(String[] strArr, int i) {
        this.f24325c = true;
        if (strArr == null) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 34);
            return false;
        }
        int length = strArr.length;
        this.f24328f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 40);
            return false;
        }
        this.f24329g = new MultiLicense[length];
        this.f24332j = i;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < this.f24328f; i2++) {
            iArr[i2] = i2;
        }
        C9281a.m17445a(iArr);
        for (int i3 = 0; i3 < this.f24328f; i3++) {
            this.f24329g[i3] = new MultiLicense();
            if (!this.f24329g[i3].m17414(strArr[i3], i3, iArr[i3])) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 57);
                return false;
            }
        }
        this.f24330h = false;
        this.token = 0;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17375a(String str, Map<String, Object> map) {
        if (this.f24326d) {
            IFXTrackCallback iFXTrackCallback = this.f24334l;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackEvent(str, map);
                return;
            }
            return;
        }
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17374a(String str, Throwable th) {
        if (this.f24326d) {
            IFXTrackCallback iFXTrackCallback = this.f24334l;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackError(str, th);
                return;
            }
            return;
        }
        OmegaSDK.trackError(str, th);
    }

    public boolean multiLicenseManagerInit(String[] strArr, int i, int i2) {
        if (strArr == null) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 60);
            return false;
        }
        int length = strArr.length;
        this.f24328f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 66);
            return false;
        }
        this.f24329g = new MultiLicense[length];
        this.f24332j = i;
        this.f24333k = i2;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < this.f24328f; i3++) {
            iArr[i3] = i3;
        }
        C9281a.m17445a(iArr);
        for (int i4 = 0; i4 < this.f24328f; i4++) {
            this.f24329g[i4] = new MultiLicense();
            if (!this.f24329g[i4].m17414(strArr[i4], i4, iArr[i4])) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]multiLicenseManager license init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 84);
                return false;
            }
        }
        this.f24330h = false;
        this.token = 0;
        return true;
    }

    public boolean multiLicenseManagerInitWithModelInAssets(String[] strArr, int i, int i2) {
        this.f24325c = true;
        if (strArr == null) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 66);
            return false;
        }
        int length = strArr.length;
        this.f24328f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 72);
            return false;
        }
        this.f24329g = new MultiLicense[length];
        this.f24332j = i;
        this.f24333k = i2;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < this.f24328f; i3++) {
            iArr[i3] = i3;
        }
        C9281a.m17445a(iArr);
        for (int i4 = 0; i4 < this.f24328f; i4++) {
            this.f24329g[i4] = new MultiLicense();
            if (!this.f24329g[i4].m17414(strArr[i4], i4, iArr[i4])) {
                SystemUtils.log(6, this.f24323a, "[multiLicenseManagerInit]multiLicenseManager license init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 90);
                return false;
            }
        }
        this.f24330h = false;
        this.token = 0;
        return true;
    }
}
