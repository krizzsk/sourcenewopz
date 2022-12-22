package com.didi.quicksilver;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public final class QuicksilverPreferencesHelper {

    /* renamed from: a */
    static Handler f33062a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Map<String, Map<String, SoftReference<QuicksilverPreferences>>> f33063b;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if ((r6 & 4) != 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r4.getApplicationInfo().targetSdkVersion >= 11) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r2.mo87066a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.SharedPreferences getSharedPreferences(android.content.Context r4, java.lang.String r5, int r6) {
        /*
            if (r4 == 0) goto L_0x0055
            android.content.pm.ApplicationInfo r0 = r4.getApplicationInfo()
            int r0 = r0.targetSdkVersion
            r1 = 19
            if (r0 >= r1) goto L_0x0010
            if (r5 != 0) goto L_0x0010
            java.lang.String r5 = "null"
        L_0x0010:
            java.lang.Class<com.didi.quicksilver.QuicksilverPreferencesHelper> r0 = com.didi.quicksilver.QuicksilverPreferencesHelper.class
            monitor-enter(r0)
            java.util.Map r1 = m23257a(r4)     // Catch:{ all -> 0x0052 }
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0052 }
            java.lang.ref.SoftReference r2 = (java.lang.ref.SoftReference) r2     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x0021
            r2 = 0
            goto L_0x0027
        L_0x0021:
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0052 }
            com.didi.quicksilver.QuicksilverPreferences r2 = (com.didi.quicksilver.QuicksilverPreferences) r2     // Catch:{ all -> 0x0052 }
        L_0x0027:
            if (r2 != 0) goto L_0x003f
            m23258a((android.content.Context) r4, (int) r6)     // Catch:{ all -> 0x0052 }
            java.io.File r2 = m23256a((android.content.Context) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0052 }
            com.didi.quicksilver.QuicksilverPreferences r3 = new com.didi.quicksilver.QuicksilverPreferences     // Catch:{ all -> 0x0052 }
            r3.<init>(r4, r5, r2, r6)     // Catch:{ all -> 0x0052 }
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x0052 }
            r4.<init>(r3)     // Catch:{ all -> 0x0052 }
            r1.put(r5, r4)     // Catch:{ all -> 0x0052 }
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return r3
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            r5 = r6 & 4
            if (r5 != 0) goto L_0x004e
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()
            int r4 = r4.targetSdkVersion
            r5 = 11
            if (r4 >= r5) goto L_0x0051
        L_0x004e:
            r2.mo87066a()
        L_0x0051:
            return r2
        L_0x0052:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r4
        L_0x0055:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.QuicksilverPreferencesHelper.getSharedPreferences(android.content.Context, java.lang.String, int):android.content.SharedPreferences");
    }

    public static SharedPreferences getPreferences(Activity activity, int i) {
        return getSharedPreferences(activity, activity.getLocalClassName(), i);
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return getSharedPreferences(context, context.getPackageName() + "_preferences", 0);
    }

    /* renamed from: a */
    private static Map<String, SoftReference<QuicksilverPreferences>> m23257a(Context context) {
        if (f33063b == null) {
            f33063b = new HashMap();
        }
        String packageName = context.getPackageName();
        Map<String, SoftReference<QuicksilverPreferences>> map = f33063b.get(packageName);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        f33063b.put(packageName, hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private static File m23256a(Context context, String str) {
        File file;
        if (Build.VERSION.SDK_INT >= 24) {
            file = context.getDataDir();
        } else {
            String str2 = context.getApplicationInfo().dataDir;
            file = str2 != null ? new File(str2) : null;
        }
        if (file == null) {
            file = context.getFilesDir().getParentFile();
        }
        File file2 = new File(file, "shared_prefs");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, str + ".xml");
    }

    /* renamed from: a */
    private static void m23258a(Context context, int i) {
        if (context.getApplicationInfo().targetSdkVersion < 24) {
            return;
        }
        if ((i & 1) != 0) {
            throw new SecurityException("MODE_WORLD_READABLE no longer supported");
        } else if ((i & 2) != 0) {
            throw new SecurityException("MODE_WORLD_WRITEABLE no longer supported");
        }
    }
}
