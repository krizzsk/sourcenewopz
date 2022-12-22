package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;
import com.appsflyer.AFLogger;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: com.appsflyer.internal.c */
public final class C1692c {

    /* renamed from: ı */
    private static char[] f1952 = {61163, 22514, 40130, 50618, 2749, 29581, 47210, 57662, 9806, 28457, 54330, 7453, 17394, 35068, 61905, 13998, 32659, 42194, 60754, 21069, 39774, 49185, 2334, 19992, 46325, 64962, 8911, 27541, 53379, 6554, 24191, 34631, 52271, 13614, 52353, 60956, 4935, 43601, 24939, 14341, 63307, 36381, 17911, 7305, 56298, 37532, 10685, 57476, 48766, 30029, 3175, 51975, 33325, 22802, 21602, 60791, 9806, 32551, 45113, 51467, 692, 23471, 40073, 54690, 28393, 42945, 63849, 12924, 19213, 35961, 50516, 7696, 22456, 59591, 8588, 31403, 46032, 62666, 3700, 18207, 38925, 53556, 27226, 41806, 58533, 15771, 47429, IOUtils.DIR_SEPARATOR_WINDOWS, 52076, 37396, 23827, 9251, 61380, 46736, 29179, 14481, 33750, 19092, 5197, 57166, 42596, 24843, 10294, 62251, 47845, 1511, 52466, 38795, 24231, 6587, 58182, 30898, 49579, 2715, 21475, 40164, 58836, 11827, 30567, 45067, 63860, 17021, 35653, 54700, 7852, 26517, 41212, 59805, 13046, 31546, 50207, 3352, 22130, 40773, 42262, 7183, 55103, 36423, 16704, 14448, 62359, 43715, 28072, 9410, 40837, 22212, 2060, 49936, 47661, 32094, 13379, 61280, 42632, 6590, 'a', 47480, 29256, 11056, 58423, 40199, 22240, 4020, 51422, 33187, 15016, 62428, 44381, 26220, 8029, 49716, 45998, 2762, 64061, 17184, 34829, 53620, 7713, 26448, 44220, 62947, 12947, 31740, 49403, 2497, 22326, 39995, IOUtils.DIR_SEPARATOR_UNIX, 47477, 29261, 11041, 58416, 40203, 13489, 36259, 18076, 8065, 53428, 43483, 25139, 15147, 64517, 46448, 'C', 47486, 29257, 11041, 58419, 40221, 22257, 4087, 51445, 33214, 15039, 62359, 44408, 26218, 8029, 55333, 37134, 50529, 31824, 46946, 60937, 8474, 22573, 37763, 51913, 3576, 17601, 65436, 14000, 26715, 41753, 55920, 7436, 21540, 36665, 50894, 31141, 45295, 60296, 8887, 26037, 40727, 54902, 2418, 16385, 64295, 12921, 30166, 44277, 59268, 7828, 20923, 35665, 49750, 1382, 48141, 63303, 11895, 17313, 64181, 12702, 26829, 42992, 57051, 5430, 19517, 35610, 49772, 31103, 45136, 61071, 9640, 23682, 39904, 53967, 2515, 16427, 65296, 13847, 28007, 42060, 58191, 48803, 1950, 52393, 38337, 23251, 9213, 59409, 45335, 30210, 16195, 33882, 19838, 5005, 55453, 41376, 26351, 12280, 62709, 48393, 562, 52012, 36935, 22891, 7796, 48359, 1494, 52964, 38799, 22684, 8619, 59909, 45906, 29823, 15633, 34322, 20280, 4556, 55967, 41959, 25742, 11687, 63163, 48968, '`', 51565, 37386, 23329, 7291, 59100, 45026, 28905, 14747, 33446, 19387, 3093, 54652, 40456, 26371, 10277, 62083, 48092, 31991, 50566, 36510, 22433, 6227, 57684, 43644, 29447, 13381, 64885};

    /* renamed from: ǃ */
    private static int f1953 = 0;

    /* renamed from: Ι */
    private static long f1954 = 5583085843407419670L;

    /* renamed from: ι */
    private static int f1955 = 1;

    C1692c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b5  */
    /* renamed from: ı */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1653(android.content.Context r15, long r16) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 61066(0xee8a, float:8.5572E-41)
            r4 = 0
            r5 = 34
            java.lang.String r3 = m1658(r4, r3, r5)
            java.lang.String r3 = r3.intern()
            boolean r3 = m1654((java.lang.String) r3)
            r6 = 2
            r7 = 60972(0xee2c, float:8.544E-41)
            r8 = 35
            r9 = 52400(0xccb0, float:7.3428E-41)
            r10 = 1
            if (r3 == 0) goto L_0x0048
            int r3 = f1953
            int r3 = r3 + 73
            int r11 = r3 % 128
            f1955 = r11
            int r3 = r3 % r6
            if (r3 != 0) goto L_0x0043
            r3 = 113(0x71, float:1.58E-43)
            java.lang.String r3 = m1658(r3, r9, r4)
            java.lang.String r3 = r3.intern()
            goto L_0x0050
        L_0x0043:
            java.lang.String r3 = m1658(r5, r9, r10)
            goto L_0x004c
        L_0x0048:
            java.lang.String r3 = m1658(r8, r7, r10)
        L_0x004c:
            java.lang.String r3 = r3.intern()
        L_0x0050:
            r1.append(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r11 = r15.getPackageName()
            java.lang.String r12 = m1657(r11)
            java.lang.String r13 = m1658(r5, r9, r10)
            java.lang.String r13 = r13.intern()
            r1.append(r13)
            r3.append(r12)
            java.lang.String r12 = m1652((android.content.Context) r15)
            if (r12 != 0) goto L_0x0076
            r12 = 1
            goto L_0x0077
        L_0x0076:
            r12 = 0
        L_0x0077:
            if (r12 == r10) goto L_0x0088
            java.lang.String r12 = m1658(r5, r9, r10)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r3.append(r11)
            goto L_0x0096
        L_0x0088:
            java.lang.String r12 = m1658(r8, r7, r10)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r3.append(r11)
        L_0x0096:
            java.lang.String r12 = m1655(r15)
            r13 = 53
            if (r12 != 0) goto L_0x00a1
            r14 = 94
            goto L_0x00a3
        L_0x00a1:
            r14 = 53
        L_0x00a3:
            if (r14 == r13) goto L_0x00b4
            java.lang.String r12 = m1658(r8, r7, r10)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r3.append(r11)
            goto L_0x00c2
        L_0x00b4:
            java.lang.String r13 = m1658(r5, r9, r10)
            java.lang.String r13 = r13.intern()
            r1.append(r13)
            r3.append(r12)
        L_0x00c2:
            r12 = r15
            java.lang.String r11 = m1656(r15, r11)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            android.content.pm.PackageManager r3 = r15.getPackageManager()     // Catch:{ NameNotFoundException -> 0x022e }
            java.lang.String r11 = r15.getPackageName()     // Catch:{ NameNotFoundException -> 0x022e }
            android.content.pm.PackageInfo r3 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r3, r11, r4)     // Catch:{ NameNotFoundException -> 0x022e }
            long r11 = r3.firstInstallTime     // Catch:{ NameNotFoundException -> 0x022e }
            r3 = 36
            r13 = 4926(0x133e, float:6.903E-42)
            r14 = 18
            java.lang.String r3 = m1658(r3, r13, r14)     // Catch:{ NameNotFoundException -> 0x022e }
            java.lang.String r3 = r3.intern()     // Catch:{ NameNotFoundException -> 0x022e }
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ NameNotFoundException -> 0x022e }
            java.util.Locale r14 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x022e }
            r13.<init>(r3, r14)     // Catch:{ NameNotFoundException -> 0x022e }
            java.util.Date r3 = new java.util.Date     // Catch:{ NameNotFoundException -> 0x022e }
            r3.<init>(r11)     // Catch:{ NameNotFoundException -> 0x022e }
            java.lang.String r3 = r13.format(r3)     // Catch:{ NameNotFoundException -> 0x022e }
            r0.append(r3)     // Catch:{ NameNotFoundException -> 0x022e }
            r11 = r16
            r0.append(r11)
            r3 = 86
            r13 = 47396(0xb924, float:6.6416E-41)
            r14 = 25
            java.lang.String r3 = m1658(r3, r13, r14)
            java.lang.String r3 = r3.intern()
            boolean r3 = m1654((java.lang.String) r3)
            if (r3 == 0) goto L_0x011c
            r3 = 0
            goto L_0x011d
        L_0x011c:
            r3 = 1
        L_0x011d:
            if (r3 == 0) goto L_0x0131
            java.lang.String r3 = m1658(r8, r7, r10)
            java.lang.String r3 = r3.intern()
            int r13 = f1955
            int r13 = r13 + 91
            int r14 = r13 % 128
            f1953 = r14
            int r13 = r13 % r6
            goto L_0x0139
        L_0x0131:
            java.lang.String r3 = m1658(r5, r9, r10)
            java.lang.String r3 = r3.intern()
        L_0x0139:
            r2.append(r3)
            r3 = 111(0x6f, float:1.56E-43)
            r13 = 30931(0x78d3, float:4.3344E-41)
            r14 = 23
            java.lang.String r3 = m1658(r3, r13, r14)
            java.lang.String r3 = r3.intern()
            boolean r3 = m1654((java.lang.String) r3)
            r13 = 4
            if (r3 == 0) goto L_0x0153
            r3 = 4
            goto L_0x0155
        L_0x0153:
            r3 = 47
        L_0x0155:
            if (r3 == r13) goto L_0x015c
            java.lang.String r3 = m1658(r8, r7, r10)
            goto L_0x0160
        L_0x015c:
            java.lang.String r3 = m1658(r5, r9, r10)
        L_0x0160:
            java.lang.String r3 = r3.intern()
            r2.append(r3)
            r3 = 134(0x86, float:1.88E-43)
            r13 = 42359(0xa577, float:5.9358E-41)
            r14 = 20
            java.lang.String r3 = m1658(r3, r13, r14)
            java.lang.String r3 = r3.intern()
            boolean r3 = m1654((java.lang.String) r3)
            if (r3 == 0) goto L_0x018a
            int r3 = f1955
            int r3 = r3 + 105
            int r13 = r3 % 128
            f1953 = r13
            int r3 = r3 % r6
            java.lang.String r3 = m1658(r5, r9, r10)
            goto L_0x018e
        L_0x018a:
            java.lang.String r3 = m1658(r8, r7, r10)
        L_0x018e:
            java.lang.String r3 = r3.intern()
            r2.append(r3)
            r3 = 154(0x9a, float:2.16E-43)
            r13 = 15
            java.lang.String r3 = m1658(r3, r4, r13)
            java.lang.String r3 = r3.intern()
            boolean r3 = m1654((java.lang.String) r3)
            if (r3 == 0) goto L_0x01a9
            r3 = 1
            goto L_0x01aa
        L_0x01a9:
            r3 = 0
        L_0x01aa:
            if (r3 == r10) goto L_0x01b5
            java.lang.String r3 = m1658(r8, r7, r10)
        L_0x01b0:
            java.lang.String r3 = r3.intern()
            goto L_0x01d8
        L_0x01b5:
            int r3 = f1955
            int r3 = r3 + 91
            int r7 = r3 % 128
            f1953 = r7
            int r3 = r3 % r6
            r7 = 52
            if (r3 == 0) goto L_0x01c5
            r3 = 52
            goto L_0x01c7
        L_0x01c5:
            r3 = 98
        L_0x01c7:
            if (r3 == r7) goto L_0x01ce
            java.lang.String r3 = m1658(r5, r9, r10)
            goto L_0x01b0
        L_0x01ce:
            r3 = 97
            java.lang.String r3 = m1658(r3, r9, r4)
            java.lang.String r3 = r3.intern()
        L_0x01d8:
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.appsflyer.internal.C1723z.m1704(r0)
            java.lang.String r0 = com.appsflyer.internal.C1723z.m1703(r0)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r0 = 17
            int r1 = java.lang.Integer.parseInt(r1, r6)
            r5 = 16
            java.lang.String r1 = java.lang.Integer.toString(r1, r5)
            char r1 = r1.charAt(r4)
            r3.setCharAt(r0, r1)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = r2.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r0 = 27
            int r1 = java.lang.Integer.parseInt(r1, r6)
            java.lang.String r1 = java.lang.Integer.toString(r1, r5)
            char r1 = r1.charAt(r4)
            r2.setCharAt(r0, r1)
            java.lang.String r0 = r2.toString()
            java.lang.Long r1 = java.lang.Long.valueOf(r16)
            java.lang.String r0 = m1659(r0, r1)
            return r0
        L_0x022e:
            r0 = 54
            r1 = 21504(0x5400, float:3.0134E-41)
            r2 = 32
            java.lang.String r0 = m1658(r0, r1, r2)
            java.lang.String r0 = r0.intern()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1692c.m1653(android.content.Context, long):java.lang.String");
    }

    /* renamed from: ι */
    private static String m1659(String str, Long l) {
        if (!(str == null)) {
            int i = f1955 + 125;
            f1953 = i % 128;
            int i2 = i % 2;
            if (!(l == null)) {
                int i3 = f1953 + 59;
                f1955 = i3 % 128;
                int i4 = i3 % 2;
                if (str.length() == 32) {
                    StringBuilder sb = new StringBuilder(str);
                    String obj = l.toString();
                    long j = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        i5 += Character.getNumericValue(obj.charAt(i6));
                    }
                    String hexString = Integer.toHexString(i5);
                    sb.replace(7, hexString.length() + 7, hexString);
                    for (int i7 = 0; i7 < sb.length(); i7++) {
                        j += (long) Character.getNumericValue(sb.charAt(i7));
                    }
                    while (true) {
                        if (!(j > 100)) {
                            break;
                        }
                        j %= 100;
                    }
                    sb.insert(23, (int) j);
                    if ((j < 10 ? 'Q' : '`') != '`') {
                        sb.insert(23, m1658(35, 60972, 1).intern());
                    }
                    return sb.toString();
                }
            }
        }
        return m1658(54, 21504, 32).intern();
    }

    /* renamed from: ı */
    private static boolean m1654(String str) {
        int i = f1953 + 89;
        f1955 = i % 128;
        int i2 = i % 2;
        try {
            Class.forName(str);
            int i3 = f1955 + 49;
            f1953 = i3 % 128;
            int i4 = i3 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: Ι */
    private static String m1657(String str) {
        int i = f1955 + 65;
        f1953 = i % 128;
        int i2 = i % 2;
        if (!(str.contains(m1658(169, 49690, 1).intern()))) {
            return str;
        }
        String[] split = str.split(m1658(170, 46066, 2).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i3 = length - 1;
        sb.append(split[i3]);
        sb.append(m1658(169, 49690, 1).intern());
        int i4 = f1953 + 103;
        f1955 = i4 % 128;
        int i5 = i4 % 2;
        int i6 = 1;
        while (true) {
            if (i6 < i3) {
                int i7 = f1953 + 61;
                f1955 = i7 % 128;
                int i8 = i7 % 2;
                sb.append(split[i6]);
                sb.append(m1658(169, 49690, 1).intern());
                i6++;
            } else {
                sb.append(split[0]);
                return sb.toString();
            }
        }
    }

    /* renamed from: ı */
    private static String m1652(Context context) {
        if ((System.getProperties().containsKey(m1658(172, 64087, 14).intern()) ? '.' : 'C') == 'C') {
            return null;
        }
        int i = f1953 + 51;
        f1955 = i % 128;
        int i2 = i % 2;
        try {
            Matcher matcher = Pattern.compile(m1658(192, 13471, 10).intern()).matcher(context.getCacheDir().getPath().replace(m1658(186, 0, 6).intern(), ""));
            if ((matcher.find() ? VersionRange.RIGHT_OPEN : 'c') != ')') {
                return null;
            }
            int i3 = f1955 + 89;
            f1953 = i3 % 128;
            if (i3 % 2 != 0) {
            }
            return matcher.group(1);
        } catch (Exception e) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
                int i4 = f1953 + 87;
                f1955 = i4 % 128;
                int i5 = i4 % 2;
            }
            C1683ai aiVar = C1683ai.f1911;
            String intern = m1658(202, 0, 17).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m1658(219, 50471, 41).intern());
            sb.append(e);
            aiVar.mo16117((String) null, intern, sb.toString());
            return null;
        }
    }

    /* renamed from: ǃ */
    private static String m1655(Context context) {
        try {
            String str = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).packageName;
            int i = f1953 + 83;
            f1955 = i % 128;
            int i2 = i % 2;
            int i3 = f1955 + 79;
            f1953 = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: Ι */
    private static String m1656(Context context, String str) {
        boolean z;
        int i = f1955 + 27;
        f1953 = i % 128;
        int i2 = i % 2;
        try {
            Iterator it = ((List) PackageManager.class.getDeclaredMethod(m1658(260, 17350, 24).intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{0})).iterator();
            int i3 = f1955 + 1;
            f1953 = i3 % 128;
            int i4 = i3 % 2;
            do {
                if ((it.hasNext() ? '7' : 7) != '7') {
                    return Boolean.FALSE.toString();
                }
                if (((ApplicationInfo) it.next()).packageName.equals(str)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (!z);
            int i5 = f1953 + 101;
            f1955 = i5 % 128;
            if (i5 % 2 != 0) {
                return Boolean.TRUE.toString();
            }
            int i6 = 75 / 0;
            return Boolean.TRUE.toString();
        } catch (IllegalAccessException e) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai aiVar = C1683ai.f1911;
            String intern = m1658(284, 48864, 24).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m1658(308, 48289, 47).intern());
            sb.append(e);
            aiVar.mo16117((String) null, intern, sb.toString());
        } catch (NoSuchMethodException e2) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
                int i7 = f1953 + 25;
                f1955 = i7 % 128;
                int i8 = i7 % 2;
            }
            C1683ai aiVar2 = C1683ai.f1911;
            String intern2 = m1658(284, 48864, 24).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m1658(308, 48289, 47).intern());
            sb2.append(e2);
            aiVar2.mo16117((String) null, intern2, sb2.toString());
        } catch (InvocationTargetException e3) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai aiVar3 = C1683ai.f1911;
            String intern3 = m1658(284, 48864, 24).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m1658(308, 48289, 47).intern());
            sb3.append(e3);
            aiVar3.mo16117((String) null, intern3, sb3.toString());
        }
    }

    /* renamed from: com.appsflyer.internal.c$a */
    public static class C1693a extends HashMap<String, Object> {

        /* renamed from: ǃ */
        private static long f1956 = -8771784815112425056L;

        /* renamed from: Ι */
        private static int f1957 = 0;

        /* renamed from: ι */
        private static char[] f1958 = {'a', 61894, 58143, 54420, 50921, 47181, 43429, 39699, 36212, 32449, 28717, 24976, 'b', 61906, 58145, 54414, 50916, 'N', 61935, 58143, 54434, 50898, 47201, 43406, 39716, 'k', 61893, 58150, 'f', 61889, 58153, 54412, 50917, 47172, 43488, 39687, 36197, 32462, 28709, 24978, 21473, 17748, 13993, 10254, 6759, 2944, 64811, 61061, 57574, 53760, 50091, 46341, 42873, 39040, 35383, 31625, 28148, 24392, 20704, 16901, 13432, 9667, 5925, 2192, 64244, 60489, 56751, 53006, 49466, 45696, 14536, 51558, 56197, 60538, 65050, 32954, 37210, 'f', 61897, 58162, 54419, 50932, 47212, 43425, 39701, 36206, 32451, 28712, 24996, 21473, 17748, 13989, '5', 61838, 58228, 54478, 50864, 24553, 44566, 48359, 35594, 39278, 14334, 50777, 54449, 58132, 61821, 36828, 40568, 44191, 47869, 18774, 18365, 22026, 25721, 29388, 305, 8086, 11775, 15384, 51891, 55581, 55166, 58776, 62510, 33433, 37108, 44877, 48573, 19544, 23151, 26833, 26412, 30096, 952, 4701, 8352, 16155, 52605, 56264, 59948, 63633, 63223, 34134, 37858, 41560, 51824, 15315, 10544, 7831, 3315, 29271, 25570, 20807, 18214, 46210, 47670, 43979, 39331, 36692, 64736, 57922, 53283, 49546, 'a', 61902, 58148, 54418, 50927, 47177, 43428, 39758, 36201, 32462, 28724, 24965, 21486, 17748, 14062, 10241, 6755, 3028, 64809, 61071, 57582, 53774, 50050, 46369, 42836, 39156, 35333, 31666, 28121, 24447, 20611, 16936, 13377, 9710, 5895, 2213, 64196, 't', 61893, 58157, 54416, 50917, 47186, 43425, 39700, 36213, 32466, 28709, 64752, 3344, 8190, 26734, 39384, 35635, 48270, 44786, 53327, 24021, 33232, 28718, Typography.amp, 61907, Typography.amp, 61904, 'f', 61840, 58161, 54480, 50929, 47121, 43440, 39761, 36208, 32402, 28786, 24963, 21480, 17748, 13985, 10253};

        /* renamed from: І */
        private static int f1959 = 1;

        /* renamed from: ı */
        private final Map<String, Object> f1960;

        /* renamed from: ɩ */
        private final Context f1961;

        public C1693a(Map<String, Object> map, Context context) {
            this.f1960 = map;
            this.f1961 = context;
            put(m1662(), m1660());
        }

        /* renamed from: Ι */
        private static StringBuilder m1663(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if ((i < 3 ? 22 : CharUtils.f5620CR) == 13) {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i].length()));
                i++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < intValue; i2++) {
                int i3 = f1957 + 105;
                f1959 = i3 % 128;
                int i4 = i3 % 2;
                Integer num = null;
                int i5 = 0;
                while (true) {
                    if (!(i5 < 3)) {
                        break;
                    }
                    char charAt = strArr[i5].charAt(i2);
                    if (num == null) {
                        int i6 = f1957 + 95;
                        f1959 = i6 % 128;
                        int i7 = i6 % 2;
                    } else {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                    i5++;
                    int i8 = f1957 + 87;
                    f1959 = i8 % 128;
                    int i9 = i8 % 2;
                }
                sb.append(Integer.toHexString(num.intValue()));
            }
            return sb;
        }

        /* renamed from: Ι */
        private String m1662() {
            int i = f1959 + 49;
            f1957 = i % 128;
            int i2 = i % 2;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.f1960.get(m1661(0, 0, 12).intern()).toString();
                String obj2 = this.f1960.get(m1661(12, 0, 5).intern()).toString();
                if (obj2 == null) {
                    obj2 = m1661(17, 0, 8).intern();
                    int i3 = f1959 + 117;
                    f1957 = i3 % 128;
                    int i4 = i3 % 2;
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder r3 = m1663(num, obj2, sb.toString());
                int length = r3.length();
                if (length > 4) {
                    int i5 = f1959 + 73;
                    f1957 = i5 % 128;
                    if (!(i5 % 2 == 0)) {
                        r3.delete(3, length);
                    } else {
                        r3.delete(4, length);
                    }
                } else {
                    while (true) {
                        if (length >= 4) {
                            break;
                        }
                        length++;
                        r3.append('1');
                        int i6 = f1959 + 67;
                        f1957 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                }
                r3.insert(0, m1661(25, 0, 3).intern());
                return r3.toString();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m1661(28, 0, 42).intern());
                sb2.append(e);
                AFLogger.afRDLog(sb2.toString());
                return m1661(70, 14499, 7).intern();
            }
        }

        /* renamed from: ı */
        private String m1660() {
            String str;
            int i;
            try {
                String obj = this.f1960.get(m1661(0, 0, 12).intern()).toString();
                String obj2 = this.f1960.get(m1661(77, 0, 15).intern()).toString();
                String replaceAll = m1661(92, 0, 5).intern().replaceAll(m1661(97, 24516, 5).intern(), "");
                StringBuilder sb = new StringBuilder();
                sb.append(obj);
                sb.append(obj2);
                sb.append(replaceAll);
                String r7 = C1723z.m1704(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(r7.substring(0, 16));
                str = sb2.toString();
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m1661(102, 14232, 44).intern());
                sb3.append(e);
                AFLogger.afRDLog(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(m1661(146, 51730, 18).intern());
                str = sb4.toString();
            }
            try {
                Intent intent = null;
                try {
                    intent = this.f1961.registerReceiver((BroadcastReceiver) null, new IntentFilter(m1661(164, 0, 37).intern()));
                } catch (Exception e2) {
                    Log.d("Context", "registerReceiver", e2);
                }
                int i2 = -2700;
                if (intent != null) {
                    int i3 = f1959 + 51;
                    f1957 = i3 % 128;
                    i2 = i3 % 2 != 0 ? intent.getIntExtra(m1661(15579, 0, 109).intern(), 25996) : intent.getIntExtra(m1661(201, 0, 11).intern(), -2700);
                }
                String str2 = this.f1961.getApplicationInfo().nativeLibraryDir;
                if ((str2 != null ? '0' : 'V') == '0') {
                    int i4 = f1959 + 15;
                    f1957 = i4 % 128;
                    int i5 = i4 % 2;
                    if (str2.contains(m1661(212, 64648, 3).intern())) {
                        int i6 = f1959 + 111;
                        f1957 = i6 % 128;
                        if ((i6 % 2 != 0 ? '4' : 'O') == 'O') {
                            i = 1;
                            int size = ((SensorManager) this.f1961.getSystemService(m1661(215, 26653, 6).intern())).getSensorList(-1).size();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(m1661(221, 23991, 1).intern());
                            sb5.append(i2);
                            sb5.append(m1661(222, 33270, 2).intern());
                            sb5.append(i);
                            sb5.append(m1661(224, 0, 2).intern());
                            sb5.append(size);
                            sb5.append(m1661(226, 0, 2).intern());
                            sb5.append(this.f1960.size());
                            String obj3 = sb5.toString();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str);
                            sb6.append(C1694c.m1668(C1694c.m1666(C1694c.m1665(obj3))));
                            String obj4 = sb6.toString();
                            int i7 = f1959 + 13;
                            f1957 = i7 % 128;
                            int i8 = i7 % 2;
                            return obj4;
                        }
                    }
                }
                i = 0;
                int size2 = ((SensorManager) this.f1961.getSystemService(m1661(215, 26653, 6).intern())).getSensorList(-1).size();
                StringBuilder sb52 = new StringBuilder();
                sb52.append(m1661(221, 23991, 1).intern());
                sb52.append(i2);
                sb52.append(m1661(222, 33270, 2).intern());
                sb52.append(i);
                sb52.append(m1661(224, 0, 2).intern());
                sb52.append(size2);
                sb52.append(m1661(226, 0, 2).intern());
                sb52.append(this.f1960.size());
                String obj32 = sb52.toString();
                StringBuilder sb62 = new StringBuilder();
                sb62.append(str);
                sb62.append(C1694c.m1668(C1694c.m1666(C1694c.m1665(obj32))));
                String obj42 = sb62.toString();
                int i72 = f1959 + 13;
                f1957 = i72 % 128;
                int i82 = i72 % 2;
                return obj42;
            } catch (Exception e3) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(m1661(102, 14232, 44).intern());
                sb7.append(e3);
                AFLogger.afRDLog(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str);
                sb8.append(m1661(228, 0, 16).intern());
                return sb8.toString();
            }
        }

        /* renamed from: com.appsflyer.internal.c$a$c */
        public static class C1694c {

            /* renamed from: ı */
            private final Object f1962;

            /* renamed from: ɩ */
            public String f1963;

            /* renamed from: Ι */
            private long f1964;

            C1694c() {
            }

            /* renamed from: ɩ */
            static byte[] m1665(String str) throws Exception {
                return str.getBytes();
            }

            /* renamed from: Ι */
            static byte[] m1666(byte[] bArr) throws Exception {
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
                }
                return bArr;
            }

            /* renamed from: ι */
            static String m1668(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte hexString : bArr) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = "0".concat(String.valueOf(hexString2));
                    }
                    sb.append(hexString2);
                }
                return sb.toString();
            }

            public C1694c(long j, String str) {
                this.f1962 = new Object();
                this.f1964 = 0;
                this.f1963 = "";
                this.f1964 = j;
                this.f1963 = str;
            }

            /* renamed from: ι */
            public static C1694c m1667(String str) {
                if (str == null) {
                    return new C1694c(0, "");
                }
                String[] split = str.split(",");
                return split.length < 2 ? new C1694c(0, "") : new C1694c(Long.parseLong(split[0]), split[1]);
            }

            /* renamed from: ɩ */
            public final boolean mo16137(C1694c cVar) {
                return m1664(cVar.f1964, cVar.f1963);
            }

            /* renamed from: ı */
            private boolean m1664(long j, String str) {
                synchronized (this.f1962) {
                    if (str != null) {
                        if (!str.equals(this.f1963) && m1669(j)) {
                            this.f1964 = j;
                            this.f1963 = str;
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* renamed from: ι */
            private boolean m1669(long j) {
                return j - this.f1964 > 2000;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f1964);
                sb.append(",");
                sb.append(this.f1963);
                return sb.toString();
            }
        }

        /* renamed from: ɩ */
        private static String m1661(int i, char c, int i2) {
            int i3 = f1957 + 19;
            f1959 = i3 % 128;
            int i4 = i3 % 2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (true) {
                if (!(i5 < i2)) {
                    return new String(cArr);
                }
                int i6 = f1959 + 95;
                f1957 = i6 % 128;
                int i7 = i6 % 2;
                cArr[i5] = (char) ((int) ((((long) f1958[i + i5]) ^ (((long) i5) * f1956)) ^ ((long) c)));
                i5++;
                int i8 = f1957 + 125;
                f1959 = i8 % 128;
                int i9 = i8 % 2;
            }
        }
    }

    /* renamed from: ι */
    private static String m1658(int i, char c, int i2) {
        char[] cArr = new char[i2];
        int i3 = 0;
        while (true) {
            if ((i3 < i2 ? 'J' : 'Y') == 'Y') {
                return new String(cArr);
            }
            int i4 = f1955 + 85;
            f1953 = i4 % 128;
            if (i4 % 2 != 0) {
                cArr[i3] = (char) ((int) ((((long) f1952[i + i3]) | (((long) i3) % f1954)) * ((long) c)));
                i3 += 37;
            } else {
                cArr[i3] = (char) ((int) ((((long) f1952[i + i3]) ^ (((long) i3) * f1954)) ^ ((long) c)));
                i3++;
            }
            int i5 = f1955 + 109;
            f1953 = i5 % 128;
            int i6 = i5 % 2;
        }
    }
}
