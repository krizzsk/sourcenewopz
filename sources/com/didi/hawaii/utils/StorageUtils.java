package com.didi.hawaii.utils;

import android.content.Context;

public class StorageUtils {

    /* renamed from: a */
    private static boolean f24220a = false;
    public static Context mContext;

    public static void init(Context context) {
        if (!f24220a) {
            mContext = context.getApplicationContext();
            f24220a = true;
        }
    }

    public static synchronized String getSDRootPath() {
        synchronized (StorageUtils.class) {
            if (mContext == null) {
                return "";
            }
            String a = m17279a();
            return a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String m17279a() {
        /*
            java.lang.Class<com.didi.hawaii.utils.StorageUtils> r0 = com.didi.hawaii.utils.StorageUtils.class
            monitor-enter(r0)
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "mounted"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = ""
            android.content.Context r2 = mContext     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "hawaii"
            java.io.File r2 = r2.getExternalFilesDir(r3)     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x001f
            java.lang.String r1 = r2.getAbsolutePath()     // Catch:{ all -> 0x002d }
        L_0x001f:
            monitor-exit(r0)
            return r1
        L_0x0021:
            android.content.Context r1 = mContext     // Catch:{ all -> 0x002d }
            java.io.File r1 = r1.getFilesDir()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x002d }
            monitor-exit(r0)
            return r1
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.StorageUtils.m17279a():java.lang.String");
    }
}
