package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class ChannelUtil {

    /* renamed from: a */
    private static final String f37572a = "channel_";

    /* renamed from: b */
    private static final String f37573b = "didichannel_version";

    /* renamed from: c */
    private static final String f37574c = "ChannelUtils";

    /* renamed from: d */
    private static String f37575d;

    /* renamed from: a */
    static String m26672a(Context context) {
        return m26673a(context, "0");
    }

    /* renamed from: a */
    static String m26673a(Context context, String str) {
        if (!TextUtil.isEmpty(f37575d)) {
            SystemUtils.log(3, f37574c, "cache meme channel = " + f37575d, (Throwable) null, "com.didi.sdk.util.ChannelUtil", 53);
            return f37575d;
        }
        String c = m26676c(context);
        f37575d = c;
        if (!TextUtils.isEmpty(c)) {
            SystemUtils.log(3, f37574c, "cache sp channel = " + f37575d, (Throwable) null, "com.didi.sdk.util.ChannelUtil", 58);
            return f37575d;
        }
        f37575d = m26674b(context);
        SystemUtils.log(3, f37574c, "apk channel = " + f37575d, (Throwable) null, "com.didi.sdk.util.ChannelUtil", 64);
        if (!TextUtils.isEmpty(f37575d)) {
            m26677c(context, f37575d);
            SystemUtils.log(3, f37574c, "cache save = " + f37575d, (Throwable) null, "com.didi.sdk.util.ChannelUtil", 69);
        } else {
            f37575d = str;
        }
        SystemUtils.log(3, f37574c, "cache return = " + f37575d, (Throwable) null, "com.didi.sdk.util.ChannelUtil", 73);
        return f37575d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[SYNTHETIC, Splitter:B:23:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[Catch:{ Exception -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065 A[SYNTHETIC, Splitter:B:33:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m26674b(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = "miui.os.MiuiInit"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.lang.String r2 = "getMiuiChannelPath"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            if (r1 == 0) goto L_0x006d
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            r2[r6] = r8     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.lang.Object r8 = r1.invoke(r0, r2)     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            boolean r8 = r1.exists()     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            if (r8 == 0) goto L_0x006d
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0062, all -> 0x0053 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0063, all -> 0x004e }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0063, all -> 0x004e }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0063, all -> 0x004e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0063, all -> 0x004e }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r1.close()     // Catch:{ Exception -> 0x0049 }
            r8.close()     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            return r0
        L_0x004a:
            r0 = move-exception
            goto L_0x0057
        L_0x004c:
            r0 = r1
            goto L_0x0063
        L_0x004e:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0057
        L_0x0053:
            r8 = move-exception
            r1 = r0
            r0 = r8
            r8 = r1
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ Exception -> 0x0061 }
        L_0x005c:
            if (r8 == 0) goto L_0x0061
            r8.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            throw r0
        L_0x0062:
            r8 = r0
        L_0x0063:
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ Exception -> 0x006d }
        L_0x0068:
            if (r8 == 0) goto L_0x006d
            r8.close()     // Catch:{ Exception -> 0x006d }
        L_0x006d:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ChannelUtil.m26674b(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[SYNTHETIC, Splitter:B:23:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[SYNTHETIC, Splitter:B:34:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m26675b(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()
            java.lang.String r4 = r4.sourceDir
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "META-INF/"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x004c }
            r2.<init>(r4)     // Catch:{ IOException -> 0x004c }
            java.util.Enumeration r4 = r2.entries()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
        L_0x0023:
            boolean r1 = r4.hasMoreElements()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r4.nextElement()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            java.lang.String r1 = r1.getName()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            boolean r3 = r1.startsWith(r5)     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            if (r3 == 0) goto L_0x0023
            goto L_0x003b
        L_0x003a:
            r1 = r0
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x005b
        L_0x003f:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x005b
        L_0x0044:
            r4 = move-exception
            r1 = r2
            goto L_0x0075
        L_0x0047:
            r4 = move-exception
            r1 = r2
            goto L_0x004d
        L_0x004a:
            r4 = move-exception
            goto L_0x0075
        L_0x004c:
            r4 = move-exception
        L_0x004d:
            r4.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005a:
            r1 = r0
        L_0x005b:
            java.lang.String r4 = "_"
            java.lang.String[] r4 = r1.split(r4)
            if (r4 == 0) goto L_0x0074
            int r5 = r4.length
            r2 = 2
            if (r5 < r2) goto L_0x0074
            r5 = 0
            r4 = r4[r5]
            int r4 = r4.length()
            int r4 = r4 + 1
            java.lang.String r0 = r1.substring(r4)
        L_0x0074:
            return r0
        L_0x0075:
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ChannelUtil.m26675b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    private static void m26677c(Context context, String str) {
        SharedPreferences.Editor edit = SystemUtils.getDefaultSharedPreferences(context).edit();
        edit.putString(f37572a, str);
        edit.putInt(f37573b, m26678d(context));
        edit.apply();
    }

    /* renamed from: c */
    private static String m26676c(Context context) {
        int i;
        SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
        int d = m26678d(context);
        if (d == -1 || (i = defaultSharedPreferences.getInt(f37573b, -1)) == -1 || d != i) {
            return "";
        }
        return defaultSharedPreferences.getString(f37572a, "");
    }

    /* renamed from: d */
    private static int m26678d(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
