package com.didi.sdk.apm;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.apm.utils.ApmUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.apm.d */
/* compiled from: PreLoaders */
class C11888d {

    /* renamed from: a */
    private static final String f35010a = "PreLoaders";

    /* renamed from: b */
    private static final String f35011b = "global_app_preload_webview";

    /* renamed from: c */
    private static final boolean f35012c = false;

    /* renamed from: d */
    private static final String f35013d = "global_app_preload_assets";

    /* renamed from: e */
    private static final boolean f35014e = false;

    /* renamed from: f */
    private static final String f35015f = "global_app_preload_storage";

    /* renamed from: g */
    private static final boolean f35016g = false;

    /* renamed from: h */
    private static final String f35017h = "global_app_preload_so";

    /* renamed from: i */
    private static final boolean f35018i = false;

    /* renamed from: j */
    private static final String f35019j = "so_list";

    /* renamed from: k */
    private static final String f35020k = ",";

    /* renamed from: l */
    private static final String f35021l = ";";

    /* renamed from: m */
    private static WeakReference<Logger> f35022m;

    C11888d() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized Logger m24751b() {
        Logger logger;
        synchronized (C11888d.class) {
            if (f35022m != null) {
                logger = (Logger) f35022m.get();
                if (logger == null) {
                    logger = LoggerFactory.getLogger(f35010a);
                }
                f35022m = new WeakReference<>(logger);
            } else {
                logger = LoggerFactory.getLogger(f35010a);
                f35022m = new WeakReference<>(logger);
            }
        }
        return logger;
    }

    /* renamed from: a */
    static void m24750a(Context context) {
        m24752b(context);
    }

    /* renamed from: b */
    private static void m24752b(Context context) {
        m24758h(context);
    }

    /* renamed from: c */
    private static void m24753c(Context context) {
        ApmThreadPool.execute((Runnable) new PreLoaders$1());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m24754d(android.content.Context r7) {
        /*
            java.lang.String r0 = "PreLoaders"
            r1 = 0
        L_0x0003:
            r2 = 2
            if (r1 >= r2) goto L_0x0052
            android.content.Context r2 = r7.getApplicationContext()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "WebView preload start "
            android.util.Log.i(r0, r3)     // Catch:{ all -> 0x0043 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0043 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0043 }
            r6 = 17
            if (r5 < r6) goto L_0x0021
            android.webkit.WebSettings.getDefaultUserAgent(r2)     // Catch:{ Exception -> 0x001d }
            goto L_0x0024
        L_0x001d:
            android.webkit.WebViewDatabase.getInstance(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x0024
        L_0x0021:
            android.webkit.WebViewDatabase.getInstance(r2)     // Catch:{ all -> 0x0043 }
        L_0x0024:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r5 = "WebView preload time use "
            r2.append(r5)     // Catch:{ all -> 0x0043 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0043 }
            long r5 = r5 - r3
            r2.append(r5)     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "ms"
            r2.append(r3)     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0043 }
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0043 }
            goto L_0x0052
        L_0x0043:
            r2 = move-exception
            com.didi.sdk.logging.Logger r3 = m24751b()     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "WebView preload err: "
            r3.error((java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            goto L_0x0003
        L_0x0050:
            r7 = move-exception
            throw r7
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.apm.C11888d.m24754d(android.content.Context):void");
    }

    /* renamed from: e */
    private static void m24755e(Context context) {
        if (Build.VERSION.SDK_INT <= 27) {
            ApmThreadPool.execute((Runnable) new PreLoaders$2(context));
        }
    }

    /* renamed from: f */
    private static void m24756f(Context context) {
        ApmThreadPool.execute((Runnable) new PreLoaders$3());
    }

    /* renamed from: g */
    private static void m24757g(Context context) {
        ApmThreadPool.execute((Runnable) new PreLoaders$4());
    }

    /* renamed from: h */
    private static void m24758h(Context context) {
        if (!ApmUtils.isAppForeground(context)) {
            Log.d(f35010a, "backgroud will not preloadSp");
            return;
        }
        IToggle toggle = Apollo.getToggle("global_app_sp_preload");
        if (toggle.allow()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str = (String) toggle.getExperiment().getParam("sync_load", "");
            if (!TextUtils.isEmpty(str)) {
                for (String sharedPreferences : str.split(f35021l)) {
                    SystemUtils.getSharedPreferences(context, sharedPreferences, 0);
                }
            }
            String str2 = (String) toggle.getExperiment().getParam("async_load", "");
            if (!TextUtils.isEmpty(str2)) {
                ApmThreadPool.postDelay(new PreLoaders$5(str2, context), 10000);
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            HashMap hashMap = new HashMap();
            hashMap.put("cost_time", Long.valueOf(elapsedRealtime2));
            OmegaSDKAdapter.trackEvent("gp_preload_sp", (Map<String, Object>) hashMap);
            Log.d(f35010a, "preloadSp time is :" + elapsedRealtime2);
        }
    }
}
