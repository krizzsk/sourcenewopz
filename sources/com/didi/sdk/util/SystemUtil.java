package com.didi.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.ActivityCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.log.Logger;
import com.didi.sdk.utdevice.UTDeviceHolder;
import com.didi.sdk.utdevice.UTDeviceListener;
import com.google.common.base.Ascii;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class SystemUtil {
    public static final String CHANNEL_ID = "channel_id";
    private static final String LOC_GPS = "gps";
    private static final Lock MAIN_PROCESS_LOCK = new ReentrantLock();
    private static volatile int MAIN_PROCESS_PID = -1;
    private static final String TAG = "SystemUtil";
    private static final Pattern VERSION_NAME_PATTERN = Pattern.compile("(\\d+\\.\\d+\\.\\d+)\\-*.*");
    private static boolean isCPUSerialnoObtained = false;
    private static boolean isMacSerialnoObtained = false;
    private static String mCPUSerial;
    private static String mDeviceId = null;
    private static String mImsi = "";
    private static String mMacSerial;
    private static String sAppVersion;
    private static Context sContext;
    private static int sVersionCode = -1;
    private static String strImei;

    private static final char getHexchar(int i) {
        return (char) (i < 10 ? i + 48 : (i + 65) - 10);
    }

    public static String getMacSerialno() {
        return "";
    }

    public static void init(Context context) {
        if (sContext == null && context != null) {
            sContext = context.getApplicationContext();
            DeviceUtils.init(context);
            SystemUtils.startThread(new Thread(new Runnable() {
                public void run() {
                    SystemUtil.getChannelId();
                    SystemUtil.getIMEI();
                    SystemUtil.getCPUSerialno();
                    SystemUtil.getIMSI();
                    SystemUtil.getMacSerialno();
                }
            }));
        }
    }

    public static String getModel() {
        String str = Build.MODEL;
        return TextUtil.isEmpty(str) ? "" : str;
    }

    public static String getVersion() {
        String str = Build.VERSION.SDK;
        return TextUtil.isEmpty(str) ? "" : str;
    }

    public static String getDeviceTime() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis + "";
    }

    public static String getIMEI() {
        return DeviceUtils.getDeviceId();
    }

    public static boolean isSameChar(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        int i = 0;
        while (i < str.length() - 1) {
            char charAt = str.charAt(i);
            i++;
            if (charAt != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static String getIMSI() {
        String str;
        if (!TextUtils.isEmpty(mImsi) || !checkPermission(sContext, Permission.READ_PHONE_STATE)) {
            return mImsi;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) sContext.getSystemService("phone");
            if (!TextUtils.isEmpty(telephonyManager.getSubscriberId())) {
                str = telephonyManager.getSubscriberId();
            } else {
                str = "";
            }
            mImsi = str;
            return str;
        } catch (Exception e) {
            Logger.m25808d(e.toString(), new Object[0]);
            return "";
        }
    }

    public static String getCPUSerialno() {
        if (!TextUtil.isEmpty(mCPUSerial)) {
            return mCPUSerial;
        }
        String str = "";
        if (isCPUSerialnoObtained) {
            mCPUSerial = str;
            return str;
        }
        try {
            isCPUSerialnoObtained = true;
            Process exec = Runtime.getRuntime().exec("cat /proc/cpuinfo");
            if (exec == null) {
                return null;
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                if (str != null) {
                    str = lineNumberReader.readLine();
                    if (str != null) {
                        mCPUSerial = str.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
            return mCPUSerial;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAndroidID() {
        return Settings.Secure.getString(sContext.getContentResolver(), "android_id");
    }

    public static int getScreenWidth() {
        return sContext.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return sContext.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenDpi() {
        return sContext.getResources().getDisplayMetrics().densityDpi;
    }

    @Deprecated
    public static String getVersionName() {
        return getVersionName(sContext);
    }

    public static String getVersionName(Context context) {
        if (!TextUtils.isEmpty(sAppVersion)) {
            return sAppVersion;
        }
        try {
            String str = SystemUtils.getPackageInfo(context.getPackageManager(), context.getApplicationInfo().packageName, 0).versionName;
            if (str == null || str.length() <= 0) {
                return str;
            }
            Matcher matcher = VERSION_NAME_PATTERN.matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            sAppVersion = group;
            return group;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getVersionCode() {
        int i = sVersionCode;
        if (i != -1) {
            return i;
        }
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(sContext.getPackageManager(), sContext.getPackageName(), 16384);
            if (packageInfo == null) {
                return 1;
            }
            int i2 = packageInfo.versionCode;
            sVersionCode = i2;
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static String getChannelId() {
        return ChannelUtil.m26672a(sContext);
    }

    public static String getAllInstalledPkg() {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = sContext.getPackageManager().queryIntentActivities(intent, 0);
            StringBuilder sb = new StringBuilder();
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    sb.append(queryIntentActivities.get(i).activityInfo.packageName);
                    sb.append("*");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) sContext.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                if (1 == activeNetworkInfo.getType()) {
                    return "WIFI";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "UNKNOWN";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TelephonyManager telephonyManager = (TelephonyManager) sContext.getSystemService("phone");
        if (telephonyManager == null) {
            return "UNKNOWN";
        }
        int i = 0;
        if (ActivityCompat.checkSelfPermission(sContext, Permission.READ_PHONE_STATE) == 0) {
            if (Build.VERSION.SDK_INT >= 24) {
                i = telephonyManager.getDataNetworkType();
            } else {
                i = telephonyManager.getNetworkType();
            }
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean isWifiEnabled() {
        return ((WifiManager) sContext.getSystemService("wifi")).isWifiEnabled();
    }

    public static boolean isGpsEnabled() {
        String string = Settings.System.getString(sContext.getContentResolver(), "location_providers_allowed");
        return !TextUtils.isEmpty(string) && string.contains("gps");
    }

    private static final String getLastModifiedMD5Str() {
        char[] md5 = md5(Long.valueOf(new File("/system/build.prop").lastModified()).toString());
        if (md5 == null) {
            return null;
        }
        return new String(md5);
    }

    private static final char[] md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length << 1;
            char[] cArr = new char[length];
            byte b = 0;
            for (int i = 0; i < length; i += 2) {
                byte b2 = digest[b] & 255;
                b = (byte) (b + 1);
                if (b2 < 16) {
                    cArr[i] = '0';
                    cArr[i + 1] = getHexchar(b2);
                } else {
                    cArr[i] = getHexchar(b2 >> 4);
                    cArr[i + 1] = getHexchar(b2 & Ascii.f53593SI);
                }
            }
            return cArr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showSofyKeyboard(final View view) {
        view.postDelayed(new Runnable() {
            public void run() {
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
                view.requestFocus();
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
            }
        }, 500);
    }

    public static void hideSoftKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        } else {
            activity.getWindow().setSoftInputMode(3);
        }
    }

    public static void hideSoftKeyboard(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static boolean isSoftInputOpen(Context context) {
        return ((InputMethodManager) context.getSystemService("input_method")).isActive();
    }

    public static boolean isMainProcess(Context context, int i) {
        if (MAIN_PROCESS_PID == -1) {
            MAIN_PROCESS_LOCK.lock();
            try {
                if (MAIN_PROCESS_PID == -1) {
                    String packageName = context.getPackageName();
                    Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (packageName.equals(next.processName)) {
                            MAIN_PROCESS_PID = next.pid;
                            break;
                        }
                    }
                }
            } finally {
                MAIN_PROCESS_LOCK.unlock();
            }
        }
        return MAIN_PROCESS_PID != -1 && MAIN_PROCESS_PID == i;
    }

    public static String getProcessName(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == i) {
                return next.processName;
            }
        }
        return null;
    }

    public static String getPhoneNumber() {
        if (!checkPermission(sContext, Permission.READ_PHONE_STATE) || !checkPermission(sContext, Permission.READ_PHONE_NUMBERS)) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) sContext.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getLine1Number();
    }

    public static boolean checkPermission(Context context, String str) {
        boolean checkPermission = checkPermission(context, str, false);
        if (!checkPermission) {
            SystemUtils.log(6, TAG, " permission:" + str + "  disable", (Throwable) null, "com.didi.sdk.util.SystemUtil", 711);
        }
        return checkPermission;
    }

    public static boolean checkPermission(Context context, String str, boolean z) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception unused) {
            return z;
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        try {
            if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            return wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCellID(Context context) {
        TelephonyManager telephonyManager;
        CellLocation cellLocation;
        CdmaCellLocation cdmaCellLocation;
        if (!checkPermission(context, Permission.ACCESS_COARSE_LOCATION) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (cellLocation = telephonyManager.getCellLocation()) == null) {
            return null;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation == null) {
                return null;
            }
            return Integer.toString(gsmCellLocation.getCid());
        } else if (!(cellLocation instanceof CdmaCellLocation) || (cdmaCellLocation = (CdmaCellLocation) cellLocation) == null) {
            return null;
        } else {
            return Integer.toString(cdmaCellLocation.getBaseStationId());
        }
    }

    public static String getLac(Context context) {
        TelephonyManager telephonyManager;
        CellLocation cellLocation;
        CdmaCellLocation cdmaCellLocation;
        if (!checkPermission(context, Permission.ACCESS_COARSE_LOCATION) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (cellLocation = telephonyManager.getCellLocation()) == null) {
            return null;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation == null) {
                return null;
            }
            return Integer.toString(gsmCellLocation.getLac());
        } else if (!(cellLocation instanceof CdmaCellLocation) || (cdmaCellLocation = (CdmaCellLocation) cellLocation) == null) {
            return null;
        } else {
            return Integer.toString(cdmaCellLocation.getNetworkId());
        }
    }

    public static String getUtDid(Context context) {
        try {
            UTDeviceListener deviceListener = UTDeviceHolder.getInstance().getDeviceListener();
            if (deviceListener != null) {
                return deviceListener.getUtdid(context);
            }
            return "";
        } catch (Exception e) {
            Logger.m25809e(e.toString(), new Object[0]);
            return "";
        }
    }

    public static boolean isRoot() {
        String[] strArr = {"/system/bin/su", "/system/xbin/su"};
        for (int i = 0; i < 2; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRunningOnEmualtor(android.content.Context r7) {
        /*
            r0 = 1
            r1 = 0
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            boolean r2 = checkPermission(r7, r2)     // Catch:{ Exception -> 0x0081 }
            if (r2 != 0) goto L_0x000b
            return r1
        L_0x000b:
            java.lang.String r2 = "phone"
            java.lang.Object r7 = r7.getSystemService(r2)     // Catch:{ Exception -> 0x0081 }
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = mDeviceId     // Catch:{ Exception -> 0x0081 }
            boolean r2 = com.didi.sdk.util.TextUtil.isEmpty(r2)     // Catch:{ Exception -> 0x0081 }
            if (r2 == 0) goto L_0x0022
            java.lang.String r2 = r7.getDeviceId()     // Catch:{ Exception -> 0x0081 }
            mDeviceId = r2     // Catch:{ Exception -> 0x0081 }
        L_0x0022:
            r2 = 0
            if (r7 != 0) goto L_0x0027
            r7 = r2
            goto L_0x0029
        L_0x0027:
            java.lang.String r7 = mDeviceId     // Catch:{ Exception -> 0x0081 }
        L_0x0029:
            if (r7 == 0) goto L_0x0035
            java.lang.String r3 = "000000000000000"
            boolean r7 = r7.equals(r3)     // Catch:{ Exception -> 0x0081 }
            if (r7 == 0) goto L_0x0035
            r7 = 1
            goto L_0x0036
        L_0x0035:
            r7 = 0
        L_0x0036:
            java.lang.String r3 = "android.os.SystemProperties"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0082 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r1] = r6     // Catch:{ Exception -> 0x0082 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0082 }
            if (r3 == 0) goto L_0x005f
            r3.setAccessible(r0)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = "1"
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0082 }
            java.lang.String r6 = "ro.kernel.qemu"
            r5[r1] = r6     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r2 = r3.invoke(r2, r5)     // Catch:{ Exception -> 0x0082 }
            boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0083 }
            java.lang.String r4 = "sdk"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0083 }
            if (r3 != 0) goto L_0x007f
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0083 }
            java.lang.String r4 = "google_sdk"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0083 }
            if (r3 != 0) goto L_0x007f
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0083 }
            java.lang.String r4 = "Droid4X"
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x0083 }
            if (r3 == 0) goto L_0x0083
        L_0x007f:
            r3 = 1
            goto L_0x0084
        L_0x0081:
            r7 = 0
        L_0x0082:
            r2 = 0
        L_0x0083:
            r3 = 0
        L_0x0084:
            if (r2 != 0) goto L_0x008c
            if (r3 != 0) goto L_0x008c
            if (r7 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.SystemUtil.isRunningOnEmualtor(android.content.Context):boolean");
    }

    @Deprecated
    public static String getIMEI(Context context) {
        return DeviceUtils.getDeviceId();
    }

    public static String getServiceProvider(Context context) {
        String str;
        if (!checkPermission(context, Permission.READ_PHONE_STATE)) {
            return "None";
        }
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (TextUtil.isEmpty(str)) {
            return "None";
        }
        if (str.startsWith("46000") || str.startsWith("46002")) {
            return context.getString(R.string.china_mobile);
        }
        if (str.startsWith("46001")) {
            return context.getString(R.string.china_unicom);
        }
        if (str.startsWith("46003")) {
            return context.getString(R.string.china_telecom);
        }
        if (str.startsWith("30272")) {
            return context.getString(R.string.ata);
        }
        if (str.startsWith("36251")) {
            return context.getString(R.string.telcel);
        }
        if (str.startsWith("21402") || str.startsWith("21407")) {
            return context.getString(R.string.movistart);
        }
        return str;
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getNavigationBarHeight(android.content.Context r3) {
        /*
            boolean r0 = hasNavBar(r3)
            if (r0 == 0) goto L_0x001b
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r0 = "navigation_bar_height"
            java.lang.String r1 = "dimen"
            java.lang.String r2 = "android"
            int r0 = r3.getIdentifier(r0, r1, r2)
            if (r0 <= 0) goto L_0x001b
            int r3 = r3.getDimensionPixelSize(r0)
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.SystemUtil.getNavigationBarHeight(android.content.Context):int");
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String navBarOverride = getNavBarOverride();
        if ("1".equals(navBarOverride)) {
            return false;
        }
        if ("0".equals(navBarOverride)) {
            return true;
        }
        return z;
    }

    private static String getNavBarOverride() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isAccessibilitySettingsOn(Context context) {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            SystemUtils.log(3, "AccessibilitySettings", "isAccessibilityEnabled:" + isEnabled + "   isExploreByTouchEnabled:" + isTouchExplorationEnabled, (Throwable) null, "com.didi.sdk.util.SystemUtil", 1012);
            if (!isEnabled || !isTouchExplorationEnabled) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getIPAddress(Context context) {
        WifiInfo connectionInfo;
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        if (activeNetworkInfo.getType() == 0) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                                return nextElement.getHostAddress();
                            }
                        }
                    }
                }
                return null;
            } catch (SocketException e) {
                e.printStackTrace();
                return null;
            }
        } else if (activeNetworkInfo.getType() != 1 || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null) {
            return null;
        } else {
            return intIP2StringIP(connectionInfo.getIpAddress());
        }
    }

    public static String intIP2StringIP(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }
}
