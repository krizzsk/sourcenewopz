package com.didi.map.setting.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class MapSettingUtils {

    /* renamed from: a */
    private static long f28927a;

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
        String a = m20368a(context, MapSettingNavConstant.BD_MAP);
        return !TextUtils.isEmpty(a) && m20367a(a, "4.3") >= 0;
    }

    public static boolean isInstallGdNav(Context context) {
        if (!isInstalledApp(context, MapSettingNavConstant.AMAP_NAVI)) {
            return false;
        }
        String a = m20368a(context, MapSettingNavConstant.AMAP_NAVI);
        return !TextUtils.isEmpty(a) && m20367a(a, "9.1") >= 0;
    }

    public static boolean isInstallGdMap(Context context) {
        if (!isInstalledApp(context, MapSettingNavConstant.AMAP)) {
            return false;
        }
        String a = m20368a(context, MapSettingNavConstant.AMAP);
        return !TextUtils.isEmpty(a) && m20367a(a, "4.1.3") >= 0;
    }

    /* renamed from: a */
    private static String m20368a(Context context, String str) {
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
    private static int m20367a(String str, String str2) {
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
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public static boolean isContainMap(List<MapSettingAppInfo> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (MapSettingAppInfo next : list) {
            if (next != null && next.pkgName.equalsIgnoreCase(str)) {
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
        long j = currentTimeMillis - f28927a;
        if (0 < j && j < 300) {
            return true;
        }
        f28927a = currentTimeMillis;
        return false;
    }
}
