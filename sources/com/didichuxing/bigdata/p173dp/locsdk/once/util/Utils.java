package com.didichuxing.bigdata.p173dp.locsdk.once.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.LocData;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.util.Utils */
public class Utils {

    /* renamed from: a */
    private static int f46156a = 0;

    /* renamed from: b */
    private static int f46157b = 1;

    /* renamed from: c */
    private static boolean f46158c = false;

    /* renamed from: d */
    private static boolean f46159d = false;

    /* renamed from: e */
    private static volatile String f46160e;

    /* renamed from: f */
    private static String[] f46161f;

    public static int asu2Dbm(int i) {
        return (i * 2) + Const.iDefCgiSig;
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        return 0;
    }

    public static long getTimeBoot() {
        return SystemClock.elapsedRealtime();
    }

    public static int getSdk() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isLocationSwitchOff(Context context) {
        return getLocationSwitchLevel(context) == 0;
    }

    public static int getLocationSwitchLevel(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                return -1;
            }
            int i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            if (i != 3) {
                return i;
            }
            return 3;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean isLocationPermissionGranted(Context context) {
        return checkSystemPermission(context, Permission.ACCESS_FINE_LOCATION) == 0 || checkSystemPermission(context, Permission.ACCESS_COARSE_LOCATION) == 0;
    }

    public static boolean isLocateAllTheTimePermissionGranted(Context context) {
        if (!isLocationPermissionGranted(context)) {
            return false;
        }
        if ((Build.VERSION.SDK_INT > 28 || "Q".equals(Build.VERSION.CODENAME)) && checkSystemPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
            return false;
        }
        return true;
    }

    public static int getLocationPermissionLevel(Context context) {
        int i = checkSystemPermission(context, Permission.ACCESS_FINE_LOCATION) == 0 ? 2 : 0;
        if (checkSystemPermission(context, Permission.ACCESS_COARSE_LOCATION) == 0) {
            i |= 1;
        }
        return isLocateAllTheTimePermissionGranted(context) ? i | 4 : i;
    }

    public static int getNetT(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static void saveAppVersion(Context context, String str) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, Const.PREFS_NAME_APPVERSION, 0).edit();
        edit.putString(Const.PREFS_NAME_APPVERSION, str);
        edit.apply();
    }

    public static String readAppVersion(Context context) {
        try {
            return SystemUtils.getSharedPreferences(context, Const.PREFS_NAME_APPVERSION, 0).getString(Const.PREFS_NAME_APPVERSION, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Object getServ(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasGpsProvider(LocationManager locationManager) {
        List<String> allProviders;
        if (locationManager == null || (allProviders = locationManager.getAllProviders()) == null) {
            return false;
        }
        return allProviders.contains("gps");
    }

    public static boolean hasPassiveProvider(LocationManager locationManager) {
        List<String> allProviders;
        if (locationManager == null || (allProviders = locationManager.getAllProviders()) == null) {
            return false;
        }
        return allProviders.contains("passive");
    }

    public static boolean locCorrect(Location location) {
        if (location == null) {
            return false;
        }
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if (longitude == 0.0d && latitude == 0.0d && !location.hasAccuracy()) {
            return false;
        }
        if (longitude > 180.0d || latitude > 90.0d) {
            DLog.m32737d("invalid loc lon:lat : " + longitude + ":" + latitude);
            return false;
        } else if (longitude >= -180.0d && latitude >= -90.0d) {
            return true;
        } else {
            DLog.m32737d("invalid loc lon:lat : " + longitude + ":" + latitude);
            return false;
        }
    }

    public static int getCellLocT(CellLocation cellLocation, Context context) {
        if (airPlaneModeOn(context) || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Exception e) {
            DLog.m32737d(e.toString());
            return 0;
        }
    }

    public static boolean airPlaneModeOn(Context context) {
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT < 17) {
            try {
                if (Settings.System.getInt(contentResolver, "airplane_mode_on") == 1) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                DLog.m32737d("AIRPLANE_MODE: exceptioin 0: " + e.toString());
                return false;
            }
        } else {
            try {
                if (Settings.Global.getInt(contentResolver, "airplane_mode_on") == 1) {
                    return true;
                }
                return false;
            } catch (Exception e2) {
                DLog.m32737d("AIRPLANE_MODE: exceptioin 1: " + e2.toString());
                return false;
            }
        }
    }

    public static String[] getMccMnc(TelephonyManager telephonyManager) {
        boolean z;
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if (!strArr2[0].equals("0") && !strArr2[1].equals("0")) {
            f46161f = strArr2;
            return strArr2;
        } else if (!strArr2[0].equals("0") || !strArr2[1].equals("0") || (strArr = f46161f) == null) {
            return strArr2;
        } else {
            DLog.m32737d("try to fix mnc_sid mcc");
            return strArr;
        }
    }

    public static boolean isGoogleNlp(Context context) {
        ServiceInfo[] serviceInfoArr;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"com.baidu.map.location", "com.amap.android.location", "android.htc.china.location.service"};
            PackageInfo packageInfo = null;
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                try {
                    packageInfo = SystemUtils.getPackageInfo(packageManager, str, 4);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo != null) {
                    DLog.m32737d("nlp provider: " + str);
                    return false;
                }
            }
            if (getSdk() >= 19) {
                String[] strArr2 = {"GmsCore.apk", "PrebuiltGmsCore.apk"};
                for (int i2 = 0; i2 < 2; i2++) {
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo("/system/priv-app/" + strArr2[i2], 4);
                    if (packageArchiveInfo != null) {
                        if ("com.google.android.gms".equals(packageArchiveInfo.packageName)) {
                            DLog.m32737d("nlp provider: " + packageArchiveInfo.packageName);
                            return true;
                        }
                    }
                }
            } else {
                packageInfo = SystemUtils.getPackageInfo(packageManager, "com.google.android.location", 4);
                if (!(packageInfo == null || (serviceInfoArr = packageInfo.services) == null)) {
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (!TextUtils.isEmpty(serviceInfo.name)) {
                            if (serviceInfo.name.startsWith("com.google.android.location")) {
                                DLog.m32737d("nlp provider: " + serviceInfo.name);
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            DLog.m32737d(e.toString());
        } catch (Throwable th) {
            DLog.m32737d(th.toString());
        }
        return false;
    }

    public static int getConnectedType(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            return activeNetworkInfo.getType() == 1 ? 1 : 2;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isMockLocation(Location location) {
        if (Build.VERSION.SDK_INT >= 18) {
            return location.isFromMockProvider();
        }
        return false;
    }

    public static int getCoordinateType() {
        return f46157b;
    }

    public static boolean isGlobal() {
        return f46157b == 0;
    }

    public static void setCoordinateType(int i) {
        f46157b = i;
    }

    public static boolean isMockSettingsON(Context context) {
        return MockLocationChecker.isMockSettingsOn(context);
    }

    public static int checkSystemPermission(Context context, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int checkSelfPermission = ContextCompat.checkSelfPermission(context, str);
            DLog.m32737d("checkSystemPermission-->nlp" + (System.currentTimeMillis() - currentTimeMillis));
            return checkSelfPermission;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void setIsGpsMocked(boolean z) {
        f46158c = z;
    }

    public static boolean isGpsMocked() {
        return f46158c;
    }

    public static void setOnlyOSLocationAbroad(boolean z) {
        f46159d = z;
    }

    public static boolean isOnlyOSLocationAbroad() {
        return f46159d;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.util.Utils$1 */
    static /* synthetic */ class C151711 {

        /* renamed from: $SwitchMap$com$didichuxing$bigdata$dp$locsdk$Config$LocatePermissonStrategy */
        static final /* synthetic */ int[] f46162xbd3682fa;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didichuxing.bigdata.dp.locsdk.Config$LocatePermissonStrategy[] r0 = com.didichuxing.bigdata.p173dp.locsdk.Config.LocatePermissonStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f46162xbd3682fa = r0
                com.didichuxing.bigdata.dp.locsdk.Config$LocatePermissonStrategy r1 = com.didichuxing.bigdata.p173dp.locsdk.Config.LocatePermissonStrategy.LOCATE_INGORE_PERMISSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f46162xbd3682fa     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.bigdata.dp.locsdk.Config$LocatePermissonStrategy r1 = com.didichuxing.bigdata.p173dp.locsdk.Config.LocatePermissonStrategy.LOCATE_IF_APP_PERMISSON_ALLOWED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f46162xbd3682fa     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.bigdata.dp.locsdk.Config$LocatePermissonStrategy r1 = com.didichuxing.bigdata.p173dp.locsdk.Config.LocatePermissonStrategy.LOCATE_IF_SYSTEM_PERMISSON_ALLOWED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f46162xbd3682fa     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didichuxing.bigdata.dp.locsdk.Config$LocatePermissonStrategy r1 = com.didichuxing.bigdata.p173dp.locsdk.Config.LocatePermissonStrategy.LOCATE_IF_ALL_PERMISSION_ALLOWED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.once.util.Utils.C151711.<clinit>():void");
        }
    }

    public static boolean isPermissionStrategyAllowed(Context context) {
        int i = C151711.f46162xbd3682fa[Config.sPermissionStrategy.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return isLocationPermissionGranted(context);
        }
        if (i == 3) {
            return !isLocationSwitchOff(context);
        }
        if (i == 4 && isLocationPermissionGranted(context) && !isLocationSwitchOff(context)) {
            return true;
        }
        return false;
    }

    public static boolean needCheckAppPermissionStrategy() {
        Config.LocatePermissonStrategy locatePermissonStrategy = Config.sPermissionStrategy;
        return locatePermissonStrategy == Config.LocatePermissonStrategy.LOCATE_IF_APP_PERMISSON_ALLOWED || locatePermissonStrategy == Config.LocatePermissonStrategy.LOCATE_IF_ALL_PERMISSION_ALLOWED;
    }

    public static boolean needCheckSystemPermissionStrategy() {
        Config.LocatePermissonStrategy locatePermissonStrategy = Config.sPermissionStrategy;
        return locatePermissonStrategy == Config.LocatePermissonStrategy.LOCATE_IF_SYSTEM_PERMISSON_ALLOWED || locatePermissonStrategy == Config.LocatePermissonStrategy.LOCATE_IF_ALL_PERMISSION_ALLOWED;
    }

    /* renamed from: a */
    static boolean m33150a(Location location) {
        if (!(location == null || location.getExtras() == null)) {
            try {
                return location.getExtras().getBoolean(DIDILocation.EXTRA_KEY_USE_NTP_TIMESTAMP, false);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void setSystemLocationNTPFlag(Location location, boolean z) {
        if (location != null) {
            try {
                Bundle extras = location.getExtras() != null ? location.getExtras() : new Bundle();
                extras.putBoolean(DIDILocation.EXTRA_KEY_USE_NTP_TIMESTAMP, z);
                location.setExtras(extras);
            } catch (Exception unused) {
            }
        }
    }

    public static String executeShell(String... strArr) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (Exception unused) {
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String getChipInfo() {
        if (f46160e == null) {
            f46160e = executeShell("getprop", "ro.board.platform");
        }
        return f46160e;
    }

    public static LocData getMaxConfiLoc(List<LocData> list) {
        LocData locData = list.get(0);
        for (LocData next : list) {
            DLog.m32737d("-getMaxConfiLoc- confi=" + next.confidence);
            if (locData.confidence < next.confidence) {
                locData = next;
            }
        }
        return locData;
    }

    public static LocData getMaxConfiTransprobLoc(List<LocData> list) {
        LocData locData = list.get(0);
        for (LocData next : list) {
            DLog.m32737d("-getMaxConfiTransprobLoc- confi*transprob=" + (next.confidence * next.transprob));
            if (locData.confidence * locData.transprob < next.confidence * next.transprob) {
                locData = next;
            }
        }
        return locData;
    }

    public static String getSelfVersionName(Context context) {
        return getVersionName(context, context.getPackageName());
    }

    public static String getVersionName(Context context, String str) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getSelfVersionCode(Context context) {
        return getVersionCode(context, context.getPackageName());
    }

    public static int getVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static String getSelfLabel(Context context) {
        return getLabel(context, context.getPackageName());
    }

    public static String getLabel(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, str, 0);
            return (packageInfo == null || packageInfo.applicationInfo == null) ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isOnViechleMounted(Context context) {
        return "com.didi.drivingrecorder".equals(context.getPackageName());
    }

    public static long getSystemLocationElapsedRealtime(Location location) {
        if (location == null || Build.VERSION.SDK_INT < 17) {
            return SystemClock.elapsedRealtime();
        }
        return location.getElapsedRealtimeNanos() / 1000000;
    }
}
