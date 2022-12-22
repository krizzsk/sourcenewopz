package com.didi.map.setting.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.sdk.apm.SystemUtils;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class MapSettingUtils {

    /* renamed from: a */
    private static long f28955a;

    public static MapSettingAppInfo getMap(PackageManager packageManager, String str, List<ResolveInfo> list) {
        for (ResolveInfo next : list) {
            if (!(next == null || next.activityInfo == null)) {
                String str2 = next.activityInfo.packageName;
                if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                    String str3 = next.activityInfo.name;
                    MapSettingAppInfo mapSettingAppInfo = new MapSettingAppInfo();
                    mapSettingAppInfo.appLabel = (String) next.loadLabel(packageManager);
                    mapSettingAppInfo.pkgName = str2;
                    mapSettingAppInfo.appIcon = next.loadIcon(packageManager);
                    mapSettingAppInfo.activityName = str3;
                    return mapSettingAppInfo;
                }
            }
        }
        return null;
    }

    public static boolean isInstallBdMap(Context context) {
        if (!isInstalledApp(context, MapSettingNavConstant.BD_MAP)) {
            return false;
        }
        String a = m20373a(context, MapSettingNavConstant.BD_MAP);
        return !TextUtils.isEmpty(a) && m20372a(a, "4.3") >= 0;
    }

    public static boolean isInstallGdNav(Context context) {
        if (!isInstalledApp(context, MapSettingNavConstant.AMAP_NAVI)) {
            return false;
        }
        String a = m20373a(context, MapSettingNavConstant.AMAP_NAVI);
        return !TextUtils.isEmpty(a) && m20372a(a, "9.1") >= 0;
    }

    public static boolean isInstallGdMap(Context context) {
        if (!isInstalledApp(context, MapSettingNavConstant.AMAP)) {
            return false;
        }
        String a = m20373a(context, MapSettingNavConstant.AMAP);
        return !TextUtils.isEmpty(a) && m20372a(a, "4.1.3") >= 0;
    }

    /* renamed from: a */
    private static String m20373a(Context context, String str) {
        String str2 = "";
        try {
            String str3 = SystemUtils.getPackageInfo(context.getPackageManager(), str, 0).versionName;
            try {
                if (TextUtils.isEmpty(str3)) {
                    return str2;
                }
                return str3;
            } catch (Exception e) {
                e = e;
                str2 = str3;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str2;
        }
    }

    /* renamed from: a */
    private static int m20372a(String str, String str2) {
        int i;
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        String[] split = str.split("[^a-zA-Z0-9]+");
        String[] split2 = str2.split("[^a-zA-Z0-9]+");
        int min = Math.min(split.length, split2.length);
        int i2 = 0;
        while (i2 <= min) {
            if (i2 == split.length) {
                if (i2 == split2.length) {
                    return 0;
                }
                return -1;
            } else if (i2 == split2.length) {
                return 1;
            } else {
                int i3 = Integer.MAX_VALUE;
                try {
                    i = Integer.parseInt(split[i2]);
                } catch (Exception unused) {
                    i = Integer.MAX_VALUE;
                }
                try {
                    i3 = Integer.parseInt(split2[i2]);
                } catch (Exception unused2) {
                }
                if (i != i3) {
                    return i - i3;
                }
                int compareTo = split[i2].compareTo(split2[i2]);
                if (compareTo != 0) {
                    return compareTo;
                }
                i2++;
            }
        }
        return 0;
    }

    public static boolean isInstalledApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            PackageManager packageManager = context.getPackageManager();
            for (String str2 : split) {
                try {
                    PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, str2, 1);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str2);
                    if (!(packageInfo == null || launchIntentForPackage == null)) {
                        return true;
                    }
                } catch (Exception e) {
                    DLog.m20371d("MapSettingUtils isInstalledApp NameNotFoundException =  " + e + " pkg = " + str, new Object[0]);
                }
            }
        } catch (Exception e2) {
            DLog.m20371d("MapSettingUtils isInstalledApp exception =  " + e2 + " pkg = " + str, new Object[0]);
        }
        return false;
    }

    public static boolean isContainMap(List<MapSettingAppInfo> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (MapSettingAppInfo next : list) {
            if (next != null && next.pkgName.equalsIgnoreCase(str) && next.isInstalled) {
                return true;
            }
        }
        return false;
    }

    public static String isContainPath(List<MapSettingAppInfo> list, String str) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (MapSettingAppInfo next : list) {
            if (next != null && next.pkgName.equalsIgnoreCase(str)) {
                return next.appLabel;
            }
        }
        return null;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f28955a;
        if (0 < j && j < 300) {
            return true;
        }
        f28955a = currentTimeMillis;
        return false;
    }

    public static void getCurLan(Context context) {
        String str;
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            try {
                if (Build.VERSION.SDK_INT < 24) {
                    str = configuration.locale.toString();
                } else if (!(configuration.getLocales() == null || configuration.getLocales().isEmpty() || configuration.getLocales().get(0) == null)) {
                    str = configuration.getLocales().get(0).toString();
                }
                DLog.m20371d("The app's language = " + str + ", the countryCode = " + PlatInfo.getInstance().getCountryCode(), new Object[0]);
            } catch (Exception e) {
                DLog.m20371d("get app's language exception, e =" + e.toString(), new Object[0]);
                return;
            }
        }
        str = "";
        DLog.m20371d("The app's language = " + str + ", the countryCode = " + PlatInfo.getInstance().getCountryCode(), new Object[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x001f A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.drawable.Drawable getAppIcon(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.didi.map.setting.common.utils.MapSettingUtils> r0 = com.didi.map.setting.common.utils.MapSettingUtils.class
            monitor-enter(r0)
            r1 = 0
            if (r3 == 0) goto L_0x002d
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x000d
            goto L_0x002d
        L_0x000d:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ NameNotFoundException -> 0x001b }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001b }
            r2 = 0
            android.content.pm.ApplicationInfo r4 = com.didi.sdk.apm.SystemUtils.getApplicationInfo(r3, r4, r2)     // Catch:{ NameNotFoundException -> 0x001c }
            goto L_0x001d
        L_0x001b:
            r3 = r1
        L_0x001c:
            r4 = r1
        L_0x001d:
            if (r4 == 0) goto L_0x0028
            if (r3 != 0) goto L_0x0022
            goto L_0x0028
        L_0x0022:
            android.graphics.drawable.Drawable r3 = r3.getApplicationIcon(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)
            return r3
        L_0x0028:
            monitor-exit(r0)
            return r1
        L_0x002a:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x002d:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.common.utils.MapSettingUtils.getAppIcon(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNavType(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1628283507: goto L_0x0044;
                case -660073534: goto L_0x003a;
                case 0: goto L_0x0030;
                case 19650874: goto L_0x0026;
                case 19680841: goto L_0x001c;
                case 40719148: goto L_0x0012;
                case 1944259826: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "ru.dublgis.dgismobile"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 5
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "com.google.android.apps.maps"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 1
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "ru.yandex.yandexnavi"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 4
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "ru.yandex.yandexmaps"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 3
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = ""
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "com.waze"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "local_google"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 0
            goto L_0x004f
        L_0x004e:
            r1 = -1
        L_0x004f:
            switch(r1) {
                case 0: goto L_0x0067;
                case 1: goto L_0x0064;
                case 2: goto L_0x0061;
                case 3: goto L_0x005e;
                case 4: goto L_0x005b;
                case 5: goto L_0x0058;
                case 6: goto L_0x0055;
                default: goto L_0x0052;
            }
        L_0x0052:
            java.lang.String r1 = "999"
            return r1
        L_0x0055:
            java.lang.String r1 = "-1"
            return r1
        L_0x0058:
            java.lang.String r1 = "5"
            return r1
        L_0x005b:
            java.lang.String r1 = "4"
            return r1
        L_0x005e:
            java.lang.String r1 = "3"
            return r1
        L_0x0061:
            java.lang.String r1 = "2"
            return r1
        L_0x0064:
            java.lang.String r1 = "1"
            return r1
        L_0x0067:
            java.lang.String r1 = "0"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.common.utils.MapSettingUtils.getNavType(java.lang.String):java.lang.String");
    }

    public static boolean isInstall(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, str, 1);
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (packageInfo == null || launchIntentForPackage == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static int getYandexNavLeftTimes(Context context) {
        TreeSet<Long> yandexNaviUseTimes = MapSettingFactory.createMapPreferences(context).getYandexNaviUseTimes();
        int i = 0;
        if (yandexNaviUseTimes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Long> it = yandexNaviUseTimes.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (currentTimeMillis - longValue > ((long) (MapSettingApolloUtil.getYandexNavLimitHours() * 60 * 60 * 1000))) {
                    it.remove();
                    DLog.m20371d("YandexNavi", "[MapSettingNavUtils][getYandexNavLeftTimes] remove " + longValue);
                }
            }
            i = yandexNaviUseTimes.size();
        }
        return MapSettingApolloUtil.getYandexNavLimitCallTimes() - i;
    }
}
