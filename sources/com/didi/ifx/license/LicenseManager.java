package com.didi.ifx.license;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
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

public class LicenseManager {

    /* renamed from: a */
    private boolean f24280a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f24281b;

    /* renamed from: c */
    private boolean f24282c;

    /* renamed from: d */
    private boolean f24283d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f24284e;

    /* renamed from: f */
    private String f24285f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f24286g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LicenseFile f24287h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f24288i;

    /* renamed from: j */
    private String f24289j;

    /* renamed from: k */
    private OkHttpClient f24290k;

    /* renamed from: l */
    private final MediaType f24291l = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: m */
    private String f24292m;

    /* renamed from: n */
    private ScheduledExecutorService f24293n;

    /* renamed from: o */
    private long f24294o = 2;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f24295p = 5;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f24296q = 15;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f24297r = 5;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f24298s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f24299t;
    private long token;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Gson f24300u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile boolean f24301v;

    /* renamed from: w */
    private int f24302w;

    /* renamed from: x */
    private int f24303x;

    /* renamed from: y */
    private InferenceMonitor f24304y;

    /* renamed from: z */
    private IFXTrackCallback f24305z;

    private class HeartBeat implements Runnable {

        /* renamed from: 䞂 */
        private long f24308;

        public void run() {
            try {
                Thread.sleep(((long) new Random().nextInt((int) this.f24308)) * 1000);
            } catch (InterruptedException e) {
                SystemUtils.log(6, "LicenseManager", "[HeartBeat]" + e.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager$HeartBeat", 5);
                LicenseManager.this.m17336a("IFXLicenseManagerError", (Throwable) e);
                Thread.currentThread().interrupt();
            }
            LicenseManager.this.m17345b();
        }

        private HeartBeat(long j) {
            this.f24308 = j;
        }
    }

    private class InferenceMonitor {

        /* renamed from: ቮ */
        private int f24310;

        /* renamed from: ᡆ */
        private int f24311;

        /* renamed from: ᾖ */
        private int f24313;

        /* renamed from: ㄲ */
        private int f24314;

        /* renamed from: 䞂 */
        private ScheduledExecutorService f24315;

        /* renamed from: 䞦 */
        private int f24316;

        /* renamed from: 䧁 */
        private long f24317;

        /* renamed from: 䫅 */
        private long f24318;

        /* renamed from: 䳷 */
        private int f24319;

        /* renamed from: 偡 */
        private long f24320;

        /* renamed from: 儵 */
        private int f24321;

        InferenceMonitor(int i) {
            m17363();
            this.f24311 = i;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f24315 = newSingleThreadScheduledExecutor;
            C92691 r1 = new Runnable(LicenseManager.this) {
                public void run() {
                    InferenceMonitor.this.m17367();
                }
            };
            long j = (long) this.f24311;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(r1, j, j, TimeUnit.MINUTES);
        }

        /* access modifiers changed from: private */
        /* renamed from: ቮ */
        public synchronized void m17362() {
            ScheduledExecutorService scheduledExecutorService = this.f24315;
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                if (this.f24320 > 0) {
                    m17367();
                }
                this.f24315.shutdown();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 偡 */
        public synchronized void m17367() {
            if (this.f24320 == 0) {
                m17363();
            } else if (LicenseManager.this.f24286g == null || LicenseManager.this.f24286g.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[InferenceMonitor]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager$InferenceMonitor", 48);
            } else {
                try {
                    String a = C9281a.m17443a(LicenseManager.this.f24286g);
                    LicenseManager licenseManager = LicenseManager.this;
                    String unused = licenseManager.f24288i = C9282b.m17452a(licenseManager.f24284e);
                    if (LicenseManager.this.f24288i != null) {
                        if (!LicenseManager.this.f24288i.isEmpty()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("license_key_checksum", a);
                            hashMap.put("device_id", LicenseManager.this.f24288i);
                            hashMap.put("sdk_version", "2.1.1");
                            hashMap.put("inference_cnt", Long.valueOf(this.f24320));
                            hashMap.put("inference_success_cnt", Long.valueOf(this.f24318));
                            hashMap.put("inference_avg", Double.valueOf(((double) Math.round((((double) this.f24317) / ((double) this.f24318)) * 1000.0d)) / 1000.0d));
                            hashMap.put("code_100_cnt", Integer.valueOf(this.f24310));
                            hashMap.put("code_101_cnt", Integer.valueOf(this.f24314));
                            hashMap.put("code_102_cnt", Integer.valueOf(this.f24316));
                            hashMap.put("code_104_cnt", Integer.valueOf(this.f24319));
                            hashMap.put("code_108_cnt", Integer.valueOf(this.f24313));
                            hashMap.put("code_109_cnt", Integer.valueOf(this.f24321));
                            LicenseManager.this.m17337a("tech_ifx_report_inference_agg", (Map<String, Object>) hashMap);
                            m17363();
                            return;
                        }
                    }
                    SystemUtils.log(6, "LicenseManager", "[InferenceMonitor]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager$InferenceMonitor", 46);
                } catch (Throwable th) {
                    SystemUtils.log(6, "LicenseManager", "[InferenceMonitor]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager$InferenceMonitor", 47);
                }
            }
        }

        /* renamed from: 䞂 */
        private void m17363() {
            this.f24320 = 0;
            this.f24310 = 0;
            this.f24314 = 0;
            this.f24316 = 0;
            this.f24319 = 0;
            this.f24313 = 0;
            this.f24321 = 0;
            this.f24318 = 0;
            this.f24317 = 0;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
            return;
         */
        /* renamed from: 䞂 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void m17364(long r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                r0 = -666(0xfffffffffffffd66, double:NaN)
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0009
                monitor-exit(r7)
                return
            L_0x0009:
                long r0 = r7.f24320     // Catch:{ all -> 0x006a }
                r2 = 1
                long r0 = r0 + r2
                r7.f24320 = r0     // Catch:{ all -> 0x006a }
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
                int r8 = r7.f24314     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f24314 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x002c:
                r0 = -1
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0039
                int r8 = r7.f24316     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f24316 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0039:
                r0 = -3
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0046
                int r8 = r7.f24319     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f24319 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0046:
                int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x0051
                int r8 = r7.f24313     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f24313 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0051:
                int r8 = r7.f24321     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f24321 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0058:
                int r0 = r7.f24310     // Catch:{ all -> 0x006a }
                int r0 = r0 + 1
                r7.f24310 = r0     // Catch:{ all -> 0x006a }
                long r0 = r7.f24318     // Catch:{ all -> 0x006a }
                long r0 = r0 + r2
                r7.f24318 = r0     // Catch:{ all -> 0x006a }
                long r0 = r7.f24317     // Catch:{ all -> 0x006a }
                long r0 = r0 + r8
                r7.f24317 = r0     // Catch:{ all -> 0x006a }
            L_0x0068:
                monitor-exit(r7)
                return
            L_0x006a:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.LicenseManager.InferenceMonitor.m17364(long):void");
        }
    }

    public LicenseManager(Context context) {
        this.f24284e = context;
        this.f24280a = true;
        this.f24281b = false;
        this.f24282c = false;
        this.f24283d = false;
        this.f24302w = 0;
        this.f24303x = 10;
    }

    /* renamed from: a */
    static /* synthetic */ int m17318a(LicenseManager licenseManager) {
        int i = licenseManager.f24299t;
        licenseManager.f24299t = i + 1;
        return i;
    }

    public boolean licenseInit(String str) {
        String str2;
        this.f24289j = str;
        String d = m17354d();
        this.f24286g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 26);
            m17336a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f24302w = 0;
        this.f24298s = System.currentTimeMillis() / 1000;
        if (!this.f24280a) {
            return true;
        }
        this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
        try {
            str2 = C9281a.m17449b(this.f24286g + this.f24289j);
        } catch (Throwable th) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 17);
            m17336a("IFXLicenseManagerError", th);
            str2 = "model";
        }
        this.f24285f = str2 + ".ifx.v1.license";
        this.f24300u = new GsonBuilder().create();
        this.f24301v = false;
        this.token = 0;
        m17323a();
        this.f24299t = 0;
        return true;
    }

    public boolean licenseInitWithModelInAssets(String str) {
        String str2;
        this.f24289j = str;
        this.f24282c = true;
        String d = m17354d();
        this.f24286g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 27);
            m17336a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f24302w = 0;
        this.f24298s = System.currentTimeMillis() / 1000;
        if (this.f24280a) {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C9281a.m17449b(this.f24286g + this.f24289j);
            } catch (Throwable th) {
                SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 18);
                m17336a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f24285f = str2 + ".ifx.v1.license";
            this.f24300u = new GsonBuilder().create();
            this.f24301v = false;
            this.token = 0;
            m17323a();
            this.f24299t = 0;
        }
        return true;
    }

    public void licenseRelease() {
        m17356e();
        InferenceMonitor inferenceMonitor = this.f24304y;
        if (inferenceMonitor != null) {
            inferenceMonitor.m17362();
        }
    }

    public void omegaReportInference(long j) {
        int i = this.f24302w;
        if (i == 0) {
            m17326a(j);
        } else if (i == 1) {
            m17346b(j);
        }
    }

    public void setIFXTrackCallback(IFXTrackCallback iFXTrackCallback) {
        this.f24283d = true;
        this.f24305z = iFXTrackCallback;
    }

    public void setLocationCode(int i) {
        if (i != 1) {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
        } else {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
        }
    }

    public void setOnlineLicenseSwitch(boolean z) {
        this.f24280a = z;
    }

    public boolean verifyLicense() {
        m17351c();
        if (this.f24280a) {
            long currentTimeMillis = System.currentTimeMillis();
            int b = m17341b(false);
            if (b == -6) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]License file is broken and need pulled from server", (Throwable) null, "com.didi.ifx.license.LicenseManager", 36);
                this.f24301v = true;
                m17327a(this.f24294o, this.f24296q, this.f24297r);
                return true;
            } else if (b == -4) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]License file may be modified illegally ", (Throwable) null, "com.didi.ifx.license.LicenseManager", 33);
                return false;
            } else if (b == -3) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]Decode license file fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 30);
                return false;
            } else if (b == -2) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]Read license file fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 27);
                return false;
            } else if (b == -1) {
                this.f24301v = true;
                m17327a(this.f24294o, this.f24296q, this.f24297r);
                return true;
            } else if (b != 0) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]Fetch local license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 6);
                return false;
            } else {
                int a = !this.f24281b ? m17317a(this.f24287h) : 0;
                if (a > 0) {
                    SystemUtils.log(4, "LicenseManager", "[verifyLicense]Check license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 14);
                    m17324a(a, System.currentTimeMillis() - currentTimeMillis);
                    return false;
                }
                this.f24301v = true;
                m17324a(a, System.currentTimeMillis() - currentTimeMillis);
                m17327a(this.f24294o, this.f24296q, this.f24297r);
                return true;
            }
        } else {
            this.f24301v = true;
            m17327a(this.f24294o, this.f24296q, this.f24297r);
            return true;
        }
    }

    public void verifyToken() {
        long currentTimeMillis = System.currentTimeMillis() ^ C9281a.f24374a;
        int i = C9281a.f24377d;
        if (!this.f24301v && ((i = new Random().nextInt(C9281a.f24378e)) == C9281a.f24377d || i == C9281a.f24378e)) {
            i--;
        }
        this.token = (((currentTimeMillis * 100) + ((long) i)) ^ C9281a.f24375b) << C9281a.f24376c;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17345b() {
        m17351c();
        if (this.f24280a && System.currentTimeMillis() >= this.f24298s * 1000) {
            long currentTimeMillis = System.currentTimeMillis();
            int b = m17341b(true);
            if (b == -6) {
                m17338a(false);
            } else if (b == -1) {
                m17338a(true);
            } else if (b == 0) {
                int a = !this.f24281b ? m17317a(this.f24287h) : 0;
                if (a > 0) {
                    SystemUtils.log(4, "LicenseManager", "[updateLicense]CheckLicense fail when update", (Throwable) null, "com.didi.ifx.license.LicenseManager", 15);
                    this.f24301v = false;
                    m17324a(a, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                m17338a(false);
                m17324a(a, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* renamed from: e */
    private void m17356e() {
        this.f24293n.shutdown();
    }

    /* renamed from: c */
    private void m17351c() {
        String str = this.f24286g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReport]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 30);
            return;
        }
        try {
            String a = C9281a.m17443a(this.f24286g);
            String a2 = C9282b.m17452a(this.f24284e);
            this.f24288i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReport]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 28);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f24288i);
            hashMap.put("sdk_version", "2.1.1");
            m17337a("tech_ifx_report", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReport]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 29);
        }
    }

    /* renamed from: a */
    private void m17323a() {
        this.f24290k = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
    }

    /* renamed from: a */
    private void m17338a(final boolean z) {
        if (z) {
            if (this.f24299t >= 100) {
                SystemUtils.log(6, "LicenseManager", "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.LicenseManager", 11);
                this.f24301v = false;
                this.f24299t = 0;
                return;
            }
        } else if (this.f24299t >= 100) {
            SystemUtils.log(6, "LicenseManager", "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.LicenseManager", 18);
            this.f24301v = false;
            this.f24299t = 0;
            return;
        }
        String str = this.f24286g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[httpUpdate]License key is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 63);
            return;
        }
        String a = C9282b.m17452a(this.f24284e);
        this.f24288i = a;
        if (a == null || a.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[httpUpdate]Device Id is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 62);
            return;
        }
        this.f24290k.newCall(new Request.Builder().url(this.f24292m).post(RequestBody.create(this.f24291l, this.f24300u.toJson((Object) new RegisterRequest(this.f24286g, this.f24288i, "android", C9285e.m17460a(), C9285e.m17461b(), C9285e.m17462c(), C9285e.m17463d(), System.currentTimeMillis() / 1000, "2.1.1")))).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP response fail with error: " + iOException.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 1);
                LicenseManager.this.m17325a(0, 0, iOException.getMessage());
                LicenseManager.m17318a(LicenseManager.this);
            }

            public void onResponse(Call call, Response response) {
                long currentTimeMillis = System.currentTimeMillis();
                long receivedResponseAtMillis = response.receivedResponseAtMillis() - response.sentRequestAtMillis();
                LicenseManager.this.m17339a(z, receivedResponseAtMillis);
                int unused = LicenseManager.this.f24299t = 0;
                if (response.isSuccessful()) {
                    SystemUtils.log(3, "LicenseManager", "[httpUpdate]HTTP return code: " + response.code() + " msg: " + response.message(), (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 8);
                    if (response.body() == null) {
                        SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP response body is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 10);
                        LicenseManager.this.m17336a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP response body is empty"));
                        LicenseManager.m17318a(LicenseManager.this);
                        return;
                    }
                    try {
                        RegisterResponse registerResponse = (RegisterResponse) LicenseManager.this.f24300u.fromJson(response.body().string(), RegisterResponse.class);
                        try {
                            long j = registerResponse.get_code();
                            if (j == 20000) {
                                try {
                                    String str = registerResponse.get_license_content();
                                    if (str == null || str.isEmpty()) {
                                        SystemUtils.log(4, "LicenseManager", "[httpUpdate]Json license data is null", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 107);
                                        LicenseManager.this.m17336a("IFXLicenseManagerError", new Throwable("[httpUpdate]Json license data is null"));
                                        LicenseManager.m17318a(LicenseManager.this);
                                        return;
                                    }
                                    try {
                                        LicenseFile licenseFile = (LicenseFile) LicenseManager.this.f24300u.fromJson(str, LicenseFile.class);
                                        int a = !LicenseManager.this.f24281b ? LicenseManager.this.m17317a(licenseFile) : 0;
                                        if (a > 0) {
                                            boolean unused2 = LicenseManager.this.f24301v = false;
                                            LicenseManager.this.m17324a(a, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                            return;
                                        }
                                        LicenseManager.this.m17324a(a, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                        try {
                                            LicenseManager.this.m17349b(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                            long heartbeatTime = licenseFile.getHeartbeatTime();
                                            long heartbeatBias = licenseFile.getHeartbeatBias();
                                            if (heartbeatTime < 0 || heartbeatBias < 0) {
                                                SystemUtils.log(4, "LicenseManager", "[httpUpdate]Heartbeat time from response is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 99);
                                                LicenseManager.this.m17336a("IFXLicenseManagerError", new Throwable("[httpUpdate]Heartbeat time from response is invalid"));
                                                return;
                                            }
                                            if (!(heartbeatTime == LicenseManager.this.f24296q && heartbeatBias == LicenseManager.this.f24297r)) {
                                                long unused3 = LicenseManager.this.f24296q = heartbeatTime;
                                                long unused4 = LicenseManager.this.f24297r = heartbeatBias;
                                                LicenseManager licenseManager = LicenseManager.this;
                                                licenseManager.m17347b(licenseManager.f24295p, LicenseManager.this.f24296q, LicenseManager.this.f24297r);
                                            }
                                            LicenseFile unused5 = LicenseManager.this.f24287h = licenseFile;
                                            long unused6 = LicenseManager.this.f24298s = licenseFile.getUpdateTimestamp();
                                        } catch (Throwable th) {
                                            SystemUtils.log(4, "LicenseManager", "[httpUpdate]Write ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 101);
                                            LicenseManager.this.m17336a("IFXLicenseManagerError", th);
                                            LicenseManager.m17318a(LicenseManager.this);
                                        }
                                    } catch (Throwable th2) {
                                        SystemUtils.log(6, "LicenseManager", "[httpUpdate]Parse json license data fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 104);
                                        LicenseManager.this.m17336a("IFXLicenseManagerError", th2);
                                        LicenseManager.m17318a(LicenseManager.this);
                                    }
                                } catch (Throwable th3) {
                                    SystemUtils.log(4, "LicenseManager", "[httpUpdate]Get resp license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 110);
                                    LicenseManager.this.m17336a("IFXLicenseManagerError", th3);
                                    LicenseManager.m17318a(LicenseManager.this);
                                }
                            } else if (j == 50000) {
                                boolean unused7 = LicenseManager.this.f24301v = false;
                                SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP response code is 50000", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 168);
                                LicenseManager.this.m17325a(response.code(), j, registerResponse.get_message());
                                try {
                                    LicenseManager.this.m17335a(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                } catch (Throwable unused8) {
                                    SystemUtils.log(4, "LicenseManager", "[httpUpdate]errorSaveLocal fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 173);
                                    LicenseManager.this.m17336a("IFXLicenseManagerError", new Throwable("[httpUpdate]errorSaveLocal fail"));
                                }
                            } else {
                                SystemUtils.log(4, "LicenseManager", "[httpUpdate]Response with code " + j, (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 179);
                                LicenseManager.this.m17325a(response.code(), j, registerResponse.get_message());
                                LicenseManager.m17318a(LicenseManager.this);
                            }
                        } catch (Throwable th4) {
                            SystemUtils.log(4, "LicenseManager", "[httpUpdate]Get resp code fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 182);
                            LicenseManager.this.m17336a("IFXLicenseManagerError", th4);
                            LicenseManager.m17318a(LicenseManager.this);
                        }
                    } catch (Throwable th5) {
                        SystemUtils.log(4, "LicenseManager", "[httpUpdate]Parse json response body fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 185);
                        LicenseManager.this.m17336a("IFXLicenseManagerError", th5);
                        LicenseManager.m17318a(LicenseManager.this);
                    }
                } else {
                    SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP fail with response code " + response.code(), (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 282);
                    LicenseManager licenseManager2 = LicenseManager.this;
                    licenseManager2.m17336a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP fail with response code:" + response.code()));
                    LicenseManager.m17318a(LicenseManager.this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m17317a(LicenseFile licenseFile) {
        String str = this.f24286g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[checkLicense]License key is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 38);
            return 1;
        } else if (!licenseFile.getLicenseKey().equals(this.f24286g)) {
            SystemUtils.log(4, "LicenseManager", "[checkLicense]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 19);
            return 1;
        } else {
            String a = C9282b.m17452a(this.f24284e);
            this.f24288i = a;
            if (a == null || a.isEmpty()) {
                SystemUtils.log(4, "LicenseManager", "[checkLicense]Device id is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 37);
                return 2;
            } else if (!licenseFile.getDeviceId().equals(this.f24288i)) {
                SystemUtils.log(4, "LicenseManager", "[checkLicense]Device id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 30);
                return 2;
            } else if (System.currentTimeMillis() <= licenseFile.getExpiryTimestamp() * 1000) {
                return 0;
            } else {
                SystemUtils.log(4, "LicenseManager", "[checkLicense]License is beyond expiry", (Throwable) null, "com.didi.ifx.license.LicenseManager", 36);
                return 3;
            }
        }
    }

    public boolean licenseInit(String str, int i) {
        String str2;
        this.f24289j = str;
        String d = m17354d();
        this.f24286g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 56);
            m17336a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f24302w = i;
        if (i == 1) {
            this.f24304y = new InferenceMonitor(this.f24303x);
        }
        this.f24298s = System.currentTimeMillis() / 1000;
        if (this.f24280a) {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C9281a.m17449b(this.f24286g + this.f24289j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 47);
                m17336a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f24285f = str2 + ".ifx.v1.license";
            this.f24300u = new GsonBuilder().create();
            this.f24301v = false;
            this.token = 0;
            m17323a();
            this.f24299t = 0;
        }
        return true;
    }

    public boolean licenseInitWithModelInAssets(String str, int i) {
        String str2;
        this.f24289j = str;
        this.f24282c = true;
        String d = m17354d();
        this.f24286g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 58);
            m17336a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f24302w = i;
        if (i == 1) {
            this.f24304y = new InferenceMonitor(this.f24303x);
        }
        this.f24298s = System.currentTimeMillis() / 1000;
        if (this.f24280a) {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C9281a.m17449b(this.f24286g + this.f24289j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 49);
                m17336a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f24285f = str2 + ".ifx.v1.license";
            this.f24300u = new GsonBuilder().create();
            this.f24301v = false;
            this.token = 0;
            m17323a();
            this.f24299t = 0;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17325a(int i, long j, String str) {
        String str2 = this.f24286g;
        if (str2 == null || str2.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportHttpException]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 69);
            return;
        }
        try {
            String a = C9281a.m17443a(this.f24286g);
            String a2 = C9282b.m17452a(this.f24284e);
            this.f24288i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReportHttpException]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 67);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f24288i);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("status_code", Integer.valueOf(i));
            hashMap.put("code", Long.valueOf(j));
            hashMap.put("message", str);
            m17337a("tech_ifx_report_http_status", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportHttpException]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 68);
        }
    }

    public boolean licenseInit(String str, int i, int i2) {
        String str2;
        this.f24289j = str;
        String d = m17354d();
        this.f24286g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 87);
            m17336a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f24302w = i;
        this.f24303x = i2;
        if (i == 1) {
            this.f24304y = new InferenceMonitor(i2);
        }
        this.f24298s = System.currentTimeMillis() / 1000;
        if (this.f24280a) {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C9281a.m17449b(this.f24286g + this.f24289j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 78);
                m17336a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f24285f = str2 + ".ifx.v1.license";
            this.f24300u = new GsonBuilder().create();
            this.f24301v = false;
            this.token = 0;
            m17323a();
            this.f24299t = 0;
        }
        return true;
    }

    public boolean licenseInitWithModelInAssets(String str, int i, int i2) {
        String str2;
        this.f24289j = str;
        this.f24282c = true;
        String d = m17354d();
        this.f24286g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 90);
            m17336a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f24302w = i;
        this.f24303x = i2;
        if (i == 1) {
            this.f24304y = new InferenceMonitor(i2);
        }
        this.f24298s = System.currentTimeMillis() / 1000;
        if (this.f24280a) {
            this.f24292m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C9281a.m17449b(this.f24286g + this.f24289j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 81);
                m17336a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f24285f = str2 + ".ifx.v1.license";
            this.f24300u = new GsonBuilder().create();
            this.f24301v = false;
            this.token = 0;
            m17323a();
            this.f24299t = 0;
        }
        return true;
    }

    /* renamed from: a */
    private void m17326a(long j) {
        if (j != -666) {
            if (this.f24302w != 0) {
                SystemUtils.log(4, "LicenseManager", "[singleInferenceReport]Please use inferenceStatics instead", (Throwable) null, "com.didi.ifx.license.LicenseManager", 65);
                return;
            }
            String str = this.f24286g;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[singleInferenceReport]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 110);
                return;
            }
            try {
                String a = C9281a.m17443a(this.f24286g);
                String a2 = C9282b.m17452a(this.f24284e);
                this.f24288i = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, "LicenseManager", "[singleInferenceReport]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 108);
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
                hashMap.put("device_id", this.f24288i);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("inference_time", Long.valueOf(j));
                hashMap.put("code", Integer.valueOf(i));
                m17337a("tech_ifx_report_inference", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[singleInferenceReport]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 109);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17339a(boolean z, long j) {
        String str = this.f24286g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportNetworkLatency]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 99);
            return;
        }
        try {
            String a = C9281a.m17443a(this.f24286g);
            String a2 = C9282b.m17452a(this.f24284e);
            this.f24288i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReportNetworkLatency]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 97);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f24288i);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("first_register", Boolean.valueOf(z));
            hashMap.put("latency", Long.valueOf(j));
            m17337a("tech_ifx_report_http_latency", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportNetworkLatency]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 98);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17324a(int i, long j) {
        String str = this.f24286g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportLicenseCheck]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 156);
            return;
        }
        try {
            String a = C9281a.m17443a(this.f24286g);
            String a2 = C9282b.m17452a(this.f24284e);
            this.f24288i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReportLicenseCheck]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 154);
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
            hashMap.put("device_id", this.f24288i);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("pass_check", Boolean.valueOf(z));
            hashMap.put("check_time", Long.valueOf(j));
            hashMap.put("code", Integer.valueOf(i2));
            m17337a("tech_ifx_report_check_license", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportLicenseCheck]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 155);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17349b(String str, String str2) {
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        int length = bytes.length;
        FileOutputStream openFileOutput = this.f24284e.openFileOutput(this.f24285f, 0);
        openFileOutput.write(C9281a.m17447a(length));
        openFileOutput.write(bytes);
        openFileOutput.write(bytes2);
        openFileOutput.write(C9281a.m17447a(616));
        openFileOutput.close();
    }

    /* renamed from: a */
    private void m17327a(long j, long j2, long j3) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f24293n = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
        SystemUtils.log(3, "LicenseManager", "[startHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3, (Throwable) null, "com.didi.ifx.license.LicenseManager", 123);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17337a(String str, Map<String, Object> map) {
        if (this.f24283d) {
            IFXTrackCallback iFXTrackCallback = this.f24305z;
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
    public void m17336a(String str, Throwable th) {
        if (this.f24283d) {
            IFXTrackCallback iFXTrackCallback = this.f24305z;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackError(str, th);
                return;
            }
            return;
        }
        OmegaSDK.trackError(str, th);
    }

    /* renamed from: b */
    private int m17341b(boolean z) {
        try {
            FileInputStream openFileInput = this.f24284e.openFileInput(this.f24285f);
            if (openFileInput == null) {
                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Open ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 177);
                m17336a("IFXLicenseManagerError", new Throwable("[fetchLocalLicenseInfo]Open ifx license fail"));
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
                            SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]Find ifx.license broken", (Throwable) null, "com.didi.ifx.license.LicenseManager", 215);
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
                                                LicenseFile licenseFile = (LicenseFile) this.f24300u.fromJson(C9281a.m17444a(b), LicenseFile.class);
                                                try {
                                                    if (!C9284d.m17459a(b, licenseFile.getPublicKey(), a2)) {
                                                        SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]Verify license not pass", (Throwable) null, "com.didi.ifx.license.LicenseManager", 290);
                                                        return -4;
                                                    }
                                                    this.f24287h = licenseFile;
                                                    this.f24298s = licenseFile.getUpdateTimestamp();
                                                    if (!z) {
                                                        long heartbeatTime = this.f24287h.getHeartbeatTime();
                                                        if (heartbeatTime >= 0) {
                                                            this.f24296q = heartbeatTime;
                                                        }
                                                        long heartbeatBias = this.f24287h.getHeartbeatBias();
                                                        if (heartbeatBias >= 0) {
                                                            this.f24297r = heartbeatBias;
                                                        }
                                                    }
                                                    return 0;
                                                } catch (Throwable th) {
                                                    SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]Verify license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 306);
                                                    m17336a("IFXLicenseManagerError", th);
                                                    return -3;
                                                }
                                            } catch (Throwable th2) {
                                                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Parse license file info fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 308);
                                                m17336a("IFXLicenseManagerError", th2);
                                                return -3;
                                            }
                                        } catch (Throwable th3) {
                                            SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Decode license data fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 310);
                                            m17336a("IFXLicenseManagerError", th3);
                                            return -3;
                                        }
                                    } catch (Throwable th4) {
                                        SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Close ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 312);
                                        m17336a("IFXLicenseManagerError", th4);
                                        return -2;
                                    }
                                } catch (Throwable th5) {
                                    SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read signature in ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 314);
                                    m17336a("IFXLicenseManagerError", th5);
                                    return -2;
                                }
                            } catch (Throwable th6) {
                                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read license content in ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 316);
                                m17336a("IFXLicenseManagerError", th6);
                                return -2;
                            }
                        } catch (Throwable th7) {
                            SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read license content in ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 318);
                            m17336a("IFXLicenseManagerError", th7);
                            return -2;
                        }
                    } catch (Throwable th8) {
                        SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 320);
                        m17336a("IFXLicenseManagerError", th8);
                        return -2;
                    }
                } catch (Throwable th9) {
                    SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 322);
                    m17336a("IFXLicenseManagerError", th9);
                    return -2;
                }
            } catch (IOException e) {
                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read ifx.license size fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 324);
                m17336a("IFXLicenseManagerError", (Throwable) e);
                return -2;
            }
        } catch (FileNotFoundException unused) {
            SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]File ifx.license does not exist", (Throwable) null, "com.didi.ifx.license.LicenseManager", 326);
            return -1;
        }
    }

    /* renamed from: d */
    private String m17354d() {
        InputStream inputStream;
        try {
            if (this.f24282c) {
                inputStream = this.f24284e.getAssets().open(this.f24289j);
            } else {
                inputStream = new FileInputStream(this.f24289j);
            }
            try {
                C9281a.m17441a(inputStream);
                try {
                    if (C9281a.m17441a(inputStream) % 100 != C9281a.f24380g) {
                        this.f24281b = true;
                        return "b3b9ca1474334e85a2baf43be1ac3595";
                    }
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < 4) {
                        try {
                            sb.append(String.format("%08x", new Object[]{Integer.valueOf(C9281a.m17441a(inputStream))}));
                            i++;
                        } catch (Throwable th) {
                            SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 372);
                            m17336a("IFXLicenseManagerError", th);
                            return null;
                        }
                    }
                    return sb.toString();
                } catch (Throwable th2) {
                    SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Fetch model version fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 380);
                    m17336a("IFXLicenseManagerError", th2);
                    return null;
                }
            } catch (Throwable th3) {
                SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Fetch framework version fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 382);
                m17336a("IFXLicenseManagerError", th3);
                return null;
            }
        } catch (Throwable th4) {
            SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Open model file fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 384);
            m17336a("IFXLicenseManagerError", th4);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17335a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        FileOutputStream openFileOutput = this.f24284e.openFileOutput(this.f24285f, 0);
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

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17347b(long j, long j2, long j3) {
        this.f24293n.shutdown();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f24293n = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
        SystemUtils.log(3, "LicenseManager", "[resetHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3, (Throwable) null, "com.didi.ifx.license.LicenseManager", 401);
    }

    /* renamed from: b */
    private void m17346b(long j) {
        if (this.f24302w != 1) {
            SystemUtils.log(4, "LicenseManager", "[inferenceStatics]Please use omegaReportInference instead", (Throwable) null, "com.didi.ifx.license.LicenseManager", 403);
            return;
        }
        InferenceMonitor inferenceMonitor = this.f24304y;
        if (inferenceMonitor == null) {
            SystemUtils.log(4, "LicenseManager", "[inferenceStatics]InferenceMonitor is not initialized", (Throwable) null, "com.didi.ifx.license.LicenseManager", 407);
        } else {
            inferenceMonitor.m17364(j);
        }
    }
}
