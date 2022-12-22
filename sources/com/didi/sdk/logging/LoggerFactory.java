package com.didi.sdk.logging;

import android.content.Context;
import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didi.sdk.logging.upload.UploadTaskManager;
import com.didi.sdk.logging.util.Objects;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class LoggerFactory {

    /* renamed from: a */
    static Map<String, WeakReference<Logger>> f36511a = new ConcurrentHashMap();

    /* renamed from: b */
    private static final String f36512b = "global_app_logcat_filter";

    /* renamed from: c */
    private static LoggerConfig f36513c = LoggerConfig.newBuilder().build();

    /* renamed from: d */
    private static boolean f36514d;

    /* renamed from: e */
    private static boolean f36515e = false;

    /* renamed from: f */
    private static int f36516f = 99;

    /* renamed from: g */
    private static String f36517g = "";

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r4, com.didi.sdk.logging.LoggerConfig r5) {
        /*
            java.lang.Class<com.didi.sdk.logging.LoggerFactory> r0 = com.didi.sdk.logging.LoggerFactory.class
            monitor-enter(r0)
            boolean r1 = f36514d     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            f36514d = r1     // Catch:{ all -> 0x0070 }
            com.didi.sdk.logging.util.Objects.requireNonNull(r4)     // Catch:{ all -> 0x0070 }
            com.didi.sdk.logging.util.Objects.requireNonNull(r5)     // Catch:{ all -> 0x0070 }
            f36513c = r5     // Catch:{ all -> 0x0070 }
            boolean r2 = r4 instanceof android.app.Application     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0070 }
        L_0x001d:
            com.didi.sdk.logging.LoggerContext r2 = com.didi.sdk.logging.LoggerContext.getDefault()     // Catch:{ all -> 0x0070 }
            r2.init(r4)     // Catch:{ all -> 0x0070 }
            com.didi.sdk.logging.LoggerContext r4 = com.didi.sdk.logging.LoggerContext.getDefault()     // Catch:{ all -> 0x0070 }
            r4.update(r5)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "global_app_logcat_filter"
            r5 = 0
            com.didichuxing.apollo.sdk.IToggle r4 = com.didichuxing.apollo.sdk.Apollo.getToggle(r4, r5)     // Catch:{ all -> 0x0070 }
            boolean r2 = r4.allow()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x006e
            f36515e = r1     // Catch:{ all -> 0x0070 }
            com.didichuxing.apollo.sdk.IExperiment r1 = r4.getExperiment()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "level"
            r3 = 99
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0070 }
            java.lang.Object r1 = r1.getParam(r2, r3)     // Catch:{ all -> 0x0070 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0070 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0070 }
            f36516f = r1     // Catch:{ all -> 0x0070 }
            com.didichuxing.apollo.sdk.IExperiment r4 = r4.getExperiment()     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = "tag"
            java.lang.String r2 = ""
            java.lang.Object r4 = r4.getParam(r1, r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0070 }
            f36517g = r4     // Catch:{ all -> 0x0070 }
            int r1 = f36516f     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x006e
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x006e
            f36515e = r5     // Catch:{ all -> 0x0070 }
        L_0x006e:
            monitor-exit(r0)
            return
        L_0x0070:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.LoggerFactory.init(android.content.Context, com.didi.sdk.logging.LoggerConfig):void");
    }

    public static synchronized void init2(Context context, LoggerConfig loggerConfig) {
        synchronized (LoggerFactory.class) {
            init(context, loggerConfig);
            UploadTaskManager.getInstance().init(context);
        }
    }

    public static boolean isInitial() {
        return f36514d;
    }

    public static LoggerConfig getConfig() {
        return f36513c;
    }

    public static Logger getLogger(Class<?> cls) {
        Objects.requireNonNull(cls);
        return getLogger(cls.getName(), NachoConstants.NACHO_ENTRYPOINT_NAME);
    }

    public static Logger getLogger(String str) {
        Objects.requireNonNull(str);
        return getLogger(str, NachoConstants.NACHO_ENTRYPOINT_NAME);
    }

    public static Logger getLogger(Class<?> cls, String str) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(str);
        return m25876a(cls.getName(), str, cls);
    }

    public static Logger getLogger(String str, String str2) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return m25876a(str, str2, (Class<?>) null);
    }

    /* renamed from: a */
    private static Logger m25876a(String str, String str2, Class<?> cls) {
        Logger logger;
        String str3 = str + "-" + str2;
        WeakReference weakReference = f36511a.get(str3);
        if (weakReference != null && (logger = (Logger) weakReference.get()) != null) {
            return logger;
        }
        for (Map.Entry next : f36511a.entrySet()) {
            WeakReference weakReference2 = (WeakReference) next.getValue();
            if (weakReference2 == null || weakReference2.get() == null) {
                f36511a.remove(next.getKey());
            }
        }
        C12395c cVar = new C12395c(str, str2, f36513c);
        f36511a.put(str3, new WeakReference(cVar));
        return cVar;
    }

    public static int getFilterLevel() {
        return f36516f;
    }

    public static String getFilterTag() {
        return f36517g;
    }

    private LoggerFactory() {
    }
}
