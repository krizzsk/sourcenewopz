package com.appsflyer.internal;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerParameters;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ai */
public final class C1683ai {

    /* renamed from: ɩ */
    public static C1683ai f1911;

    /* renamed from: ı */
    private JSONArray f1912;

    /* renamed from: ǃ */
    private JSONObject f1913;

    /* renamed from: ɹ */
    private int f1914 = 0;

    /* renamed from: Ι */
    private boolean f1915 = true;

    /* renamed from: ι */
    public boolean f1916;

    /* renamed from: І */
    private boolean f1917;

    /* renamed from: і */
    private boolean f1918;

    /* renamed from: Ӏ */
    private String f1919 = "-1";

    public C1683ai() {
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.f1917 = z;
        this.f1916 = true ^ z;
        this.f1912 = new JSONArray();
        this.f1914 = 0;
        this.f1918 = false;
    }

    /* renamed from: ɩ */
    public final synchronized void mo16120(String str) {
        this.f1919 = str;
    }

    /* renamed from: ǃ */
    public final synchronized void mo16118() {
        this.f1918 = true;
        mo16117("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* renamed from: ι */
    public final synchronized void mo16123() {
        mo16117("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.f1918 = false;
        this.f1915 = false;
    }

    /* renamed from: ɩ */
    public final synchronized void mo16119() {
        this.f1913 = null;
        this.f1912 = null;
        f1911 = null;
    }

    /* renamed from: ɹ */
    private boolean m1632() {
        if (this.f1916) {
            return this.f1915 || this.f1918;
        }
        return false;
    }

    /* renamed from: ι */
    private synchronized void m1633(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.f1913.put("brand", str);
            this.f1913.put("model", str2);
            this.f1913.put("platform", "Android");
            this.f1913.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.f1913.put(ServerParameters.ADVERTISING_ID_PARAM, str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.f1913.put("imei", str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.f1913.put("android_id", str6);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ǃ */
    private synchronized void m1630(String str, String str2, String str3, String str4) {
        try {
            this.f1913.put("sdk_version", str);
            if (str2 != null && str2.length() > 0) {
                this.f1913.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.f1913.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.f1913.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ɩ */
    private synchronized void m1631(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.f1913.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.f1913.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f1913.put("channel", str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.f1913.put("preInstall", str4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a9, code lost:
        return;
     */
    /* renamed from: ı */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo16117(java.lang.String r12, java.lang.String r13, java.lang.String... r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.m1632()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00a8
            int r0 = r11.f1914     // Catch:{ all -> 0x00aa }
            r1 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r1) goto L_0x0010
            goto L_0x00a8
        L_0x0010:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = ""
            int r3 = r14.length     // Catch:{ all -> 0x00a6 }
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x003a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r2.<init>()     // Catch:{ all -> 0x00a6 }
            int r3 = r14.length     // Catch:{ all -> 0x00a6 }
            int r3 = r3 - r5
        L_0x0022:
            if (r3 <= 0) goto L_0x0031
            r6 = r14[r3]     // Catch:{ all -> 0x00a6 }
            r2.append(r6)     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = ", "
            r2.append(r6)     // Catch:{ all -> 0x00a6 }
            int r3 = r3 + -1
            goto L_0x0022
        L_0x0031:
            r14 = r14[r4]     // Catch:{ all -> 0x00a6 }
            r2.append(r14)     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a6 }
        L_0x003a:
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = "MM-dd HH:mm:ss.SSS"
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00a6 }
            r14.<init>(r3, r6)     // Catch:{ all -> 0x00a6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r14 = r14.format(r0)     // Catch:{ all -> 0x00a6 }
            r0 = 4
            r1 = 3
            r3 = 2
            r6 = 5
            if (r12 == 0) goto L_0x0075
            java.lang.String r7 = "%18s %5s _/%s [%s] %s %s"
            r8 = 6
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a6 }
            r8[r4] = r14     // Catch:{ all -> 0x00a6 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00a6 }
            long r9 = r14.getId()     // Catch:{ all -> 0x00a6 }
            java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x00a6 }
            r8[r5] = r14     // Catch:{ all -> 0x00a6 }
            java.lang.String r14 = "AppsFlyer_5.4.0"
            r8[r3] = r14     // Catch:{ all -> 0x00a6 }
            r8[r1] = r12     // Catch:{ all -> 0x00a6 }
            r8[r0] = r13     // Catch:{ all -> 0x00a6 }
            r8[r6] = r2     // Catch:{ all -> 0x00a6 }
            java.lang.String r12 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x00a6 }
            goto L_0x0095
        L_0x0075:
            java.lang.String r12 = "%18s %5s %s/%s %s"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a6 }
            r6[r4] = r14     // Catch:{ all -> 0x00a6 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00a6 }
            long r7 = r14.getId()     // Catch:{ all -> 0x00a6 }
            java.lang.Long r14 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00a6 }
            r6[r5] = r14     // Catch:{ all -> 0x00a6 }
            r6[r3] = r13     // Catch:{ all -> 0x00a6 }
            java.lang.String r13 = "AppsFlyer_5.4.0"
            r6[r1] = r13     // Catch:{ all -> 0x00a6 }
            r6[r0] = r2     // Catch:{ all -> 0x00a6 }
            java.lang.String r12 = java.lang.String.format(r12, r6)     // Catch:{ all -> 0x00a6 }
        L_0x0095:
            org.json.JSONArray r13 = r11.f1912     // Catch:{ all -> 0x00a6 }
            r13.put(r12)     // Catch:{ all -> 0x00a6 }
            int r13 = r11.f1914     // Catch:{ all -> 0x00a6 }
            byte[] r12 = r12.getBytes()     // Catch:{ all -> 0x00a6 }
            int r12 = r12.length     // Catch:{ all -> 0x00a6 }
            int r13 = r13 + r12
            r11.f1914 = r13     // Catch:{ all -> 0x00a6 }
            monitor-exit(r11)
            return
        L_0x00a6:
            monitor-exit(r11)
            return
        L_0x00a8:
            monitor-exit(r11)
            return
        L_0x00aa:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1683ai.mo16117(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r0 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: Ι */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String mo16121() {
        /*
            r3 = this;
            monitor-enter(r3)
            org.json.JSONObject r0 = r3.f1913     // Catch:{ JSONException -> 0x0017, all -> 0x0014 }
            java.lang.String r1 = "data"
            org.json.JSONArray r2 = r3.f1912     // Catch:{ JSONException -> 0x0017, all -> 0x0014 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0017, all -> 0x0014 }
            org.json.JSONObject r0 = r3.f1913     // Catch:{ JSONException -> 0x0017, all -> 0x0014 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0017, all -> 0x0014 }
            r3.m1634()     // Catch:{ JSONException -> 0x0018, all -> 0x0014 }
            goto L_0x0018
        L_0x0014:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0017:
            r0 = 0
        L_0x0018:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1683ai.mo16121():java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)(8:6|7|8|9|10|11|13|14)|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007f */
    /* renamed from: Ι */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo16122(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0090 }
            com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0019
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x007f }
            r11.<init>(r2)     // Catch:{ all -> 0x007f }
            r10.f1913 = r11     // Catch:{ all -> 0x007f }
            goto L_0x007f
        L_0x0019:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            r10.f1913 = r2     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "advertiserId"
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r8 = r1.f1812     // Catch:{ all -> 0x0090 }
            java.lang.String r9 = r1.f1813     // Catch:{ all -> 0x0090 }
            r3 = r10
            r3.m1633(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "5.4.0."
            r1.<init>(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = com.appsflyer.AppsFlyerLibCore.f1788     // Catch:{ all -> 0x0090 }
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0090 }
            r10.m1630(r1, r2, r3, r4)     // Catch:{ all -> 0x0090 }
            r1 = 0
            android.content.pm.PackageInfo r12 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r12, r11, r1)     // Catch:{ all -> 0x0074 }
            int r12 = r12.versionCode     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = "channel"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0074 }
            r10.m1631(r11, r12, r1, r2)     // Catch:{ all -> 0x0074 }
        L_0x0074:
            java.lang.String r11 = "remote_debug_static_data"
            org.json.JSONObject r12 = r10.f1913     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0090 }
            r0.set((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0090 }
        L_0x007f:
            org.json.JSONObject r11 = r10.f1913     // Catch:{ JSONException -> 0x008a }
            java.lang.String r12 = "launch_counter"
            java.lang.String r0 = r10.f1919     // Catch:{ JSONException -> 0x008a }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x008a }
            monitor-exit(r10)
            return
        L_0x008a:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0090 }
            monitor-exit(r10)
            return
        L_0x0090:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1683ai.mo16122(java.lang.String, android.content.pm.PackageManager):void");
    }

    /* renamed from: і */
    private synchronized void m1634() {
        this.f1912 = null;
        this.f1912 = new JSONArray();
        this.f1914 = 0;
    }

    /* renamed from: ı */
    public final synchronized void mo16116() {
        this.f1915 = false;
        m1634();
    }

    /* renamed from: І */
    public final boolean mo16124() {
        return this.f1918;
    }
}
