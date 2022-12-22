package com.didi.safetoolkit.util.statuslightning;

import android.os.Build;

/* renamed from: com.didi.safetoolkit.util.statuslightning.a */
/* compiled from: SystemDetective */
class C11783a {

    /* renamed from: a */
    private static final String f34540a = "ro.miui.ui.version.code";

    /* renamed from: b */
    private static final String f34541b = "ro.miui.ui.version.name";

    /* renamed from: c */
    private static final String f34542c = "ro.miui.internal.storage";

    /* renamed from: d */
    private static final String f34543d = "ro.build.hw_emui_api_level";

    C11783a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[SYNTHETIC, Splitter:B:21:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m24416a() {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0043, all -> 0x003c }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0043, all -> 0x003c }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ Exception -> 0x0043, all -> 0x003c }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0043, all -> 0x003c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0043, all -> 0x003c }
            java.util.Properties r1 = new java.util.Properties     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            r1.<init>()     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            r1.load(r2)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            java.lang.String r3 = "ro.miui.ui.version.code"
            java.lang.String r3 = r1.getProperty(r3)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = "ro.miui.ui.version.name"
            java.lang.String r3 = r1.getProperty(r3)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = "ro.miui.internal.storage"
            java.lang.String r1 = r1.getProperty(r3)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            if (r1 == 0) goto L_0x0033
        L_0x0032:
            r0 = 1
        L_0x0033:
            r2.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return r0
        L_0x0037:
            r0 = move-exception
            r1 = r2
            goto L_0x003d
        L_0x003a:
            r1 = r2
            goto L_0x0044
        L_0x003c:
            r0 = move-exception
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            throw r0
        L_0x0043:
        L_0x0044:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.util.statuslightning.C11783a.m24416a():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[SYNTHETIC, Splitter:B:18:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[SYNTHETIC, Splitter:B:25:0x0043] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m24417b() {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getRootDirectory()
            java.lang.String r2 = "build.prop"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto L_0x004b
            java.util.Properties r1 = new java.util.Properties
            r1.<init>()
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0040, all -> 0x0034 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0040, all -> 0x0034 }
            r1.load(r4)     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            java.lang.String r0 = "ro.build.hw_emui_api_level"
            boolean r0 = r1.containsKey(r0)     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            r4.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x002e:
            return r0
        L_0x002f:
            r0 = move-exception
            r3 = r4
            goto L_0x0035
        L_0x0032:
            r3 = r4
            goto L_0x0041
        L_0x0034:
            r0 = move-exception
        L_0x0035:
            if (r3 == 0) goto L_0x003f
            r3.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003f:
            throw r0
        L_0x0040:
        L_0x0041:
            if (r3 == 0) goto L_0x004b
            r3.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.util.statuslightning.C11783a.m24417b():boolean");
    }

    /* renamed from: c */
    public static boolean m24418c() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    /* renamed from: d */
    public static boolean m24419d() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
