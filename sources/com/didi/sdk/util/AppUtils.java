package com.didi.sdk.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.commoninterfacelib.statuslightning.impl.NoneLightningCompatImpl;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.debug.AppDebugger;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didichuxing.omega.sdk.Omega;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class AppUtils {

    /* renamed from: a */
    private static HashMap<String, String> f37554a = new HashMap<>();

    private AppUtils() {
    }

    public static boolean isMainProcess(Context context, int i) {
        try {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (packageName.equals(next.processName)) {
                    if (next.pid == i) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasLoadDexProcess(Context context) {
        try {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                Log.d("AppUtils", "runningAppProcesses is null");
                return false;
            }
            String str = packageName + ":loaddex";
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                Log.d("AppUtils", "find process:" + next.processName + " pid:" + next.pid);
                if (str.equals(next.processName)) {
                    Log.d("AppUtils", "has loaddex Process");
                    return true;
                }
            }
            Log.d("AppUtils", "don't have loaddex Process");
            return false;
        } catch (Exception unused) {
        }
    }

    public static boolean isAppForeground(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null) {
                if (!runningTasks.isEmpty()) {
                    return runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName());
                }
            }
            return false;
        } catch (Throwable th) {
            Omega.trackError("AppForeground", th);
            return false;
        }
    }

    public static boolean isRunningInForeground(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                if (!runningAppProcesses.isEmpty()) {
                    String packageName = context.getPackageName();
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (next.importance == 100 && next.importanceReasonCode == 0) {
                            return next.pkgList[0].equals(packageName);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int getVersionCodeByPackageName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isTestNow(Context context) {
        return AppDebugger.isDebuggable() && DevModeUtil.DevEnvironment.RELEASE != DevModeUtil.getDevEnvironment(context);
    }

    public static String getParamSig(String str) {
        try {
            return m26670a("didiwuxiankejiyouxian2013q" + str);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m26670a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m26671a(instance.digest());
    }

    /* renamed from: a */
    private static String m26671a(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str;
    }

    public static int getTimeZoneUtcOffset() {
        CountryInfo countryInfo = ConfProxy.getInstance().getCountryInfo();
        if (countryInfo != null && countryInfo.getUtcOffSet() != 0) {
            return countryInfo.getUtcOffSet();
        }
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone == null) {
            return -1;
        }
        int rawOffset = timeZone.getRawOffset() / 60000;
        return timeZone.inDaylightTime(new Date()) ? rawOffset + 60 : rawOffset;
    }

    public static String getMetaDataByKey(String str) {
        Object obj;
        if (!TextUtil.isEmpty(f37554a.get(str))) {
            return f37554a.get(str);
        }
        String str2 = "";
        try {
            PackageInfo packageInfo = DIDIApplicationDelegate.getAppContext().getPackageManager().getPackageInfo(DIDIApplicationDelegate.getAppContext().getPackageName(), 16512);
            if (!(packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (obj = packageInfo.applicationInfo.metaData.get(str)) == null)) {
                str2 = obj.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f37554a.put(str, str2);
        return str2;
    }

    public static Point getNavigationBarSize(Context context) {
        Point appUsableScreenSize = getAppUsableScreenSize(context);
        Point realScreenSize = getRealScreenSize(context);
        if (appUsableScreenSize.x < realScreenSize.x) {
            return new Point(realScreenSize.x - appUsableScreenSize.x, appUsableScreenSize.y);
        }
        if (appUsableScreenSize.y < realScreenSize.y) {
            return new Point(appUsableScreenSize.x, realScreenSize.y - appUsableScreenSize.y);
        }
        return new Point();
    }

    public static Point getAppUsableScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[ExcHandler: IllegalAccessException | NoSuchMethodException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:9:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Point getRealScreenSize(android.content.Context r5) {
        /*
            java.lang.String r0 = "window"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.view.WindowManager r5 = (android.view.WindowManager) r5
            android.view.Display r5 = r5.getDefaultDisplay()
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x001c
            r5.getRealSize(r0)
            goto L_0x0058
        L_0x001c:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 14
            if (r1 < r2) goto L_0x0058
            r1 = 0
            java.lang.Class<android.view.Display> r2 = android.view.Display.class
            java.lang.String r3 = "getRawWidth"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ InvocationTargetException -> 0x003c }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ InvocationTargetException -> 0x003c }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ InvocationTargetException -> 0x003c }
            java.lang.Object r2 = r2.invoke(r5, r3)     // Catch:{ InvocationTargetException -> 0x003c }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ InvocationTargetException -> 0x003c }
            int r2 = r2.intValue()     // Catch:{ InvocationTargetException -> 0x003c }
            r0.x = r2     // Catch:{ InvocationTargetException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
        L_0x0040:
            java.lang.Class<android.view.Display> r2 = android.view.Display.class
            java.lang.String r3 = "getRawHeight"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
            java.lang.Object r5 = r2.invoke(r5, r1)     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
            r0.y = r5     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058, IllegalAccessException | NoSuchMethodException -> 0x0058 }
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.AppUtils.getRealScreenSize(android.content.Context):android.graphics.Point");
    }

    public static Drawable getAppIcon(Context context) {
        try {
            return context.getPackageManager().getApplicationIcon(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isGlobalApp(Context context) {
        if (context == null) {
            return false;
        }
        return "com.didiglobal.passenger".equalsIgnoreCase(context.getPackageName());
    }

    public static boolean isBrazilApp(Context context) {
        if (context == null) {
            return false;
        }
        return TextUtils.equals(context.getPackageName(), "com.taxis99");
    }

    public static int getAppId(Context context) {
        if (isBrazilApp(context)) {
            return 60004;
        }
        return isGlobalApp(context) ? 60000 : -1;
    }

    public static int getStatusBarHeight(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        if (StatusBarLightingCompat.getImpl() == null || !(StatusBarLightingCompat.getImpl() instanceof NoneLightningCompatImpl)) {
            return getStatusHeight(context);
        }
        return 0;
    }

    public static int getStatusHeight(Context context) {
        if (context == null) {
            context = DIDIApplication.getAppContext();
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getCountryCodeISO3166() {
        return Locale.getDefault().getCountry();
    }
}
