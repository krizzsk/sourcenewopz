package com.didi.beatles.p099im.utils;

import android.text.TextUtils;

/* renamed from: com.didi.beatles.im.utils.IMOSUtil */
public class IMOSUtil {

    /* renamed from: a */
    private static final String f9778a = "ro.miui.ui.version.name";

    /* renamed from: b */
    private static final String f9779b = "ro.build.version.emui";

    /* renamed from: c */
    private static String f9780c;

    /* renamed from: d */
    private static String f9781d;

    /* renamed from: e */
    private static String f9782e;

    public static boolean isMIUI() {
        if (f9780c == null) {
            f9780c = m6639a(f9778a, "");
        }
        return !TextUtils.isEmpty(f9780c);
    }

    public static boolean isEMUI() {
        if (f9781d == null) {
            f9781d = m6639a(f9779b, "");
        }
        return !TextUtils.isEmpty(f9781d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[SYNTHETIC, Splitter:B:20:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a A[SYNTHETIC, Splitter:B:28:0x006a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6639a(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "getSystemProperty"
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r5.<init>()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r6 = "getprop "
            r5.append(r6)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r5.append(r7)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.lang.Process r4 = r4.exec(r5)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            if (r4 == 0) goto L_0x0065
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r4 = 1024(0x400, float:1.435E-42)
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r3 = r5.readLine()     // Catch:{ Exception -> 0x0044 }
            r5.close()     // Catch:{ Exception -> 0x0044 }
            r5.close()     // Catch:{ Exception -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r7 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r1]
            r8[r2] = r7
            com.didi.beatles.p099im.utils.IMLog.m6632e(r0, r8)
        L_0x0043:
            return r3
        L_0x0044:
            r3 = move-exception
            goto L_0x004b
        L_0x0046:
            r7 = move-exception
            goto L_0x0068
        L_0x0048:
            r4 = move-exception
            r5 = r3
            r3 = r4
        L_0x004b:
            java.lang.String r4 = "getSystemProperty#IOException#"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0066 }
            r6[r2] = r7     // Catch:{ all -> 0x0066 }
            r6[r1] = r3     // Catch:{ all -> 0x0066 }
            com.didi.beatles.p099im.utils.IMLog.m6632e(r4, r6)     // Catch:{ all -> 0x0066 }
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x0065
        L_0x005d:
            r7 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r7
            com.didi.beatles.p099im.utils.IMLog.m6632e(r0, r1)
        L_0x0065:
            return r8
        L_0x0066:
            r7 = move-exception
            r3 = r5
        L_0x0068:
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0076
        L_0x006e:
            r8 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r8
            com.didi.beatles.p099im.utils.IMLog.m6632e(r0, r1)
        L_0x0076:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.utils.IMOSUtil.m6639a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1") || "MagicUI 3".equals(eMUIVersion) || eMUIVersion.contains("MagicUI_3.1");
    }

    public static boolean isEMUI3_0() {
        String eMUIVersion = getEMUIVersion();
        return eMUIVersion.contains("EmotionUI_3.0") || eMUIVersion.contains("MagicUI_3.0");
    }

    public static String getEMUIVersion() {
        if (f9782e == null) {
            String str = "";
            if (isEMUI()) {
                str = m6639a(f9779b, str);
            }
            f9782e = str;
        }
        return f9782e;
    }
}
