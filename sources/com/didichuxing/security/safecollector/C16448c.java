package com.didichuxing.security.safecollector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.text.DecimalFormat;

/* renamed from: com.didichuxing.security.safecollector.c */
/* compiled from: DeviceInfoCollector */
final class C16448c {

    /* renamed from: a */
    public static DecimalFormat f48999a = new DecimalFormat("######0.00");

    /* renamed from: b */
    public static TelephonyManager f49000b = null;

    /* renamed from: c */
    private static final String f49001c = "didi_uuid";

    /* renamed from: d */
    private static boolean f49002d = false;

    /* renamed from: e */
    private static String f49003e = null;

    C16448c() {
    }

    /* renamed from: a */
    public static String m35233a() {
        try {
            return Build.MODEL;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m35236b() {
        try {
            return Build.BRAND;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC, Splitter:B:15:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035 A[SYNTHETIC, Splitter:B:25:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003c A[SYNTHETIC, Splitter:B:29:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0043 A[SYNTHETIC, Splitter:B:33:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m35238c() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "getprop ro.product.cpu.abi"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x0031 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x002f }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x002f }
            r2.<init>(r3)     // Catch:{ all -> 0x002f }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x002d }
            r3.<init>(r2)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x002b }
            r3.close()     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r2.close()     // Catch:{ all -> 0x0024 }
            goto L_0x0025
        L_0x0024:
        L_0x0025:
            if (r1 == 0) goto L_0x0048
            r1.destroy()     // Catch:{ all -> 0x0048 }
            goto L_0x0048
        L_0x002b:
            r0 = r3
            goto L_0x0033
        L_0x002d:
            goto L_0x0033
        L_0x002f:
            r2 = r0
            goto L_0x0033
        L_0x0031:
            r1 = r0
            r2 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003a
        L_0x0039:
        L_0x003a:
            if (r2 == 0) goto L_0x0041
            r2.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0041
        L_0x0040:
        L_0x0041:
            if (r1 == 0) goto L_0x0046
            r1.destroy()     // Catch:{ all -> 0x0046 }
        L_0x0046:
            java.lang.String r0 = ""
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.safecollector.C16448c.m35238c():java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:19|20|(1:(3:22|23|(2:53|25))(0))|28|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
        if (r0 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006b, code lost:
        if (r0 != null) goto L_0x0053;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005f A[SYNTHETIC, Splitter:B:42:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0066 A[SYNTHETIC, Splitter:B:46:0x0066] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m35239d() {
        /*
            java.lang.String r0 = f49003e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = f49003e
            return r0
        L_0x000b:
            boolean r0 = f49002d
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0014
            f49003e = r1
            return r1
        L_0x0014:
            r0 = 1
            r2 = 0
            f49002d = r0     // Catch:{ all -> 0x005b }
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "cat /proc/cpuinfo"
            java.lang.Process r0 = r0.exec(r3)     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x002a
            if (r0 == 0) goto L_0x0029
            r0.destroy()     // Catch:{ all -> 0x0029 }
        L_0x0029:
            return r2
        L_0x002a:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0059 }
            java.io.InputStream r4 = r0.getInputStream()     // Catch:{ all -> 0x0059 }
            r3.<init>(r4)     // Catch:{ all -> 0x0059 }
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch:{ all -> 0x0057 }
            r4.<init>(r3)     // Catch:{ all -> 0x0057 }
        L_0x0038:
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0047 }
            f49003e = r1     // Catch:{ all -> 0x0047 }
            goto L_0x0049
        L_0x0047:
            r2 = r4
            goto L_0x005d
        L_0x0049:
            r4.close()     // Catch:{ all -> 0x004c }
        L_0x004c:
            r3.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0051
        L_0x0050:
        L_0x0051:
            if (r0 == 0) goto L_0x006e
        L_0x0053:
            r0.destroy()     // Catch:{ all -> 0x006e }
            goto L_0x006e
        L_0x0057:
            goto L_0x005d
        L_0x0059:
            r3 = r2
            goto L_0x005d
        L_0x005b:
            r0 = r2
            r3 = r0
        L_0x005d:
            if (r2 == 0) goto L_0x0064
            r2.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0064
        L_0x0063:
        L_0x0064:
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ all -> 0x006a }
            goto L_0x006b
        L_0x006a:
        L_0x006b:
            if (r0 == 0) goto L_0x006e
            goto L_0x0053
        L_0x006e:
            java.lang.String r0 = f49003e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.safecollector.C16448c.m35239d():java.lang.String");
    }

    /* renamed from: a */
    public static String m35234a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        } catch (Throwable unused) {
            return "0*0";
        }
    }

    /* renamed from: b */
    public static int m35235b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public static int m35237c(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        if (r1 == null) goto L_0x0036;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m35241e() {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "/proc/meminfo"
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x002b }
            r3.<init>(r1)     // Catch:{ all -> 0x002b }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0028 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = "\\s+"
            java.lang.String[] r2 = r2.split(r4)     // Catch:{ all -> 0x0029 }
            int r4 = r2.length     // Catch:{ all -> 0x0029 }
            r5 = 1
            if (r4 <= r5) goto L_0x0021
            r0 = r2[r5]     // Catch:{ all -> 0x0029 }
        L_0x0021:
            r3.close()     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r1.close()     // Catch:{ all -> 0x0036 }
            goto L_0x0036
        L_0x0028:
            r1 = r2
        L_0x0029:
            r2 = r3
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0033
        L_0x0032:
        L_0x0033:
            if (r1 == 0) goto L_0x0036
            goto L_0x0024
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.safecollector.C16448c.m35241e():java.lang.String");
    }

    /* renamed from: d */
    public static String m35240d(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return Formatter.formatFileSize(context, ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static String m35243f() {
        String[] strArr = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
        int i = 0;
        while (i < 14) {
            try {
                String str = strArr[i];
                if (new File(str + "su").exists()) {
                    return "1";
                }
                i++;
            } catch (Throwable unused) {
                return "0";
            }
        }
        return "0";
    }

    /* renamed from: e */
    public static String m35242e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static String m35244f(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            if (context.checkCallingOrSelfPermission(Permission.READ_PHONE_STATE) != 0) {
                return "-1";
            }
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return TextUtils.isEmpty(subscriberId) ? "0" : subscriberId;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: g */
    public static String m35246g(Context context) {
        String str = "";
        try {
            if (TextUtils.isEmpty(str)) {
                str = m35245g();
            }
            return Build.VERSION.SDK_INT >= 29 ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: g */
    public static String m35245g() {
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    /* renamed from: h */
    public static String m35247h(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                String string = C16447b.m35229a().getString(f49001c, "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            return DeviceUtils.m35204a();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: i */
    public static String m35248i(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            DecimalFormat decimalFormat = f48999a;
            float f = (float) i;
            float f2 = (f / displayMetrics.xdpi) * (f / displayMetrics.xdpi);
            float f3 = (float) i2;
            return decimalFormat.format(Math.sqrt((double) (f2 + ((f3 / displayMetrics.ydpi) * (f3 / displayMetrics.ydpi)))));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: j */
    public static int m35249j(Context context) {
        try {
            if (Build.FINGERPRINT.startsWith("generic")) {
                return 1;
            }
            if (Build.FINGERPRINT.toLowerCase().contains("vbox")) {
                return 2;
            }
            if (Build.FINGERPRINT.toLowerCase().contains("test-keys")) {
                return 3;
            }
            if (Build.MODEL.toLowerCase().equals("sdk")) {
                return 4;
            }
            if (Build.MODEL.toLowerCase().contains("google_sdk")) {
                return 5;
            }
            if (Build.MODEL.toLowerCase().contains("emulator")) {
                return 6;
            }
            if (Build.MODEL.toLowerCase().contains("android sdk built for x86")) {
                return 7;
            }
            if (Build.HARDWARE.toLowerCase().contains("goldfish")) {
                return 8;
            }
            if (Build.HOST.toLowerCase().contains("android-test")) {
                return 9;
            }
            if (Build.MANUFACTURER.toLowerCase().contains("genymotion")) {
                return 12;
            }
            if (Build.PRODUCT.toLowerCase().equals("google_sdk")) {
                return 13;
            }
            if (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) {
                return "android".equals(m35250k(context)) ? 18 : 0;
            }
            return 14;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: k */
    public static String m35250k(Context context) {
        try {
            if (f49000b == null) {
                f49000b = (TelephonyManager) context.getSystemService("phone");
            }
            return f49000b.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
