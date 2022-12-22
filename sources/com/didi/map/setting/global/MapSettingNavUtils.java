package com.didi.map.setting.global;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.ddmap.sdk.degrade.gnav.GoogleNavDegrade;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapSettingNavUtils {

    /* renamed from: a */
    private static Map<String, String> f28961a;

    /* renamed from: b */
    private static boolean f28962b;

    /* renamed from: c */
    private static IMapSettingPreferences f28963c;

    public static List<String> getInstallNavTypeList(List<MapSettingAppInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (MapSettingAppInfo next : list) {
                if (!next.isInstalled) {
                    break;
                } else if (!TextUtils.isEmpty(next.navType)) {
                    arrayList.add(next.navType);
                } else {
                    String navTypeByPkgName = getNavTypeByPkgName(next.pkgName);
                    if (!TextUtils.isEmpty(navTypeByPkgName)) {
                        arrayList.add(navTypeByPkgName);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<MapSettingAppInfo> getInstalledThirdNav(Context context) {
        return getInstalledThirdNav(context, false);
    }

    public static List<MapSettingAppInfo> getInstalledThirdNav(Context context, boolean z) {
        Context context2 = context;
        List<MapSettingAppInfo> arrayList = new ArrayList<>();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:q=39.94447,116.274628"));
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            IMapSettingPreferences createMapPreferences = MapSettingFactory.createMapPreferences(context);
            if (!z && createMapPreferences.getGoogleLocalNav()) {
                if (!GoogleNavDegrade.Companion.getInstance().needDegrade(context2, PlatInfo.getInstance().getClientVersion())) {
                    m20377a(context2, arrayList);
                }
            }
            String string = context.getResources().getString(R.string.map_setting_nav_not_install);
            DLog.m20371d("MapSettingNavUtils", "[getInstalledThirdNav] countryCode = " + PlatInfo.getInstance().getCountryCode());
            String countryCode = PlatInfo.getInstance().getCountryCode();
            char c = 65535;
            int hashCode = countryCode.hashCode();
            if (hashCode != 2100) {
                if (hashCode != 2128) {
                    if (hashCode != 2374) {
                        if (hashCode != 2415) {
                            if (hashCode != 2475) {
                                if (hashCode == 2627 && countryCode.equals(MapSettingNavConstant.MAP_COUNTRY_CODE_RUSSIA)) {
                                    c = 4;
                                }
                            } else if (countryCode.equals("MX")) {
                                c = 0;
                            }
                        } else if (countryCode.equals(MapSettingNavConstant.MAP_COUNTRY_CODE_KAZAKHSTAN)) {
                            c = 5;
                        }
                    } else if (countryCode.equals("JP")) {
                        c = 3;
                    }
                } else if (countryCode.equals("BR")) {
                    c = 2;
                }
            } else if (countryCode.equals("AU")) {
                c = 1;
            }
            if (c == 0) {
                MapSettingAppInfo map = MapSettingUtils.getMap(packageManager, "com.google.android.apps.maps", queryIntentActivities);
                if (map == null || TextUtils.isEmpty(map.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.google.android.apps.maps")) {
                    MapSettingAppInfo mapSettingAppInfo = new MapSettingAppInfo();
                    mapSettingAppInfo.isInstalled = false;
                    mapSettingAppInfo.appLabel = getAppNoInstallTips("Google Maps", string);
                    mapSettingAppInfo.pkgName = "com.google.android.apps.maps";
                    mapSettingAppInfo.navType = "1";
                    mapSettingAppInfo.appIcon = context.getResources().getDrawable(R.drawable.map_setting_google_map_ic_not_install);
                    arrayList.add(mapSettingAppInfo);
                } else {
                    m20376a(context2, map);
                    arrayList.add(map);
                }
                MapSettingAppInfo map2 = MapSettingUtils.getMap(packageManager, "com.waze", queryIntentActivities);
                if (map2 == null || TextUtils.isEmpty(map2.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.waze")) {
                    MapSettingAppInfo mapSettingAppInfo2 = new MapSettingAppInfo();
                    mapSettingAppInfo2.isInstalled = false;
                    mapSettingAppInfo2.appLabel = getAppNoInstallTips("Waze", string);
                    mapSettingAppInfo2.pkgName = "com.waze";
                    mapSettingAppInfo2.navType = "2";
                    mapSettingAppInfo2.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_not_install);
                    arrayList.add(mapSettingAppInfo2);
                } else {
                    map2.appLabel = "Waze";
                    map2.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_normal);
                    map2.navType = "2";
                    arrayList.add(map2);
                }
            } else if (c == 1) {
                MapSettingAppInfo map3 = MapSettingUtils.getMap(packageManager, "com.google.android.apps.maps", queryIntentActivities);
                if (map3 == null || TextUtils.isEmpty(map3.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.google.android.apps.maps")) {
                    MapSettingAppInfo mapSettingAppInfo3 = new MapSettingAppInfo();
                    mapSettingAppInfo3.isInstalled = false;
                    mapSettingAppInfo3.appLabel = getAppNoInstallTips("Google Maps", string);
                    mapSettingAppInfo3.pkgName = "com.google.android.apps.maps";
                    mapSettingAppInfo3.navType = "1";
                    mapSettingAppInfo3.appIcon = context.getResources().getDrawable(R.drawable.map_setting_google_map_ic_not_install);
                    arrayList.add(mapSettingAppInfo3);
                } else {
                    m20376a(context2, map3);
                    arrayList.add(map3);
                }
                MapSettingAppInfo map4 = MapSettingUtils.getMap(packageManager, "com.waze", queryIntentActivities);
                if (map4 == null || TextUtils.isEmpty(map4.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.waze")) {
                    MapSettingAppInfo mapSettingAppInfo4 = new MapSettingAppInfo();
                    mapSettingAppInfo4.isInstalled = false;
                    mapSettingAppInfo4.appLabel = getAppNoInstallTips("Waze", string);
                    mapSettingAppInfo4.pkgName = "com.waze";
                    mapSettingAppInfo4.navType = "2";
                    mapSettingAppInfo4.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_not_install);
                    arrayList.add(mapSettingAppInfo4);
                } else {
                    map4.appLabel = "Waze";
                    map4.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_normal);
                    map4.navType = "2";
                    arrayList.add(map4);
                }
            } else if (c == 2) {
                MapSettingAppInfo map5 = MapSettingUtils.getMap(packageManager, "com.google.android.apps.maps", queryIntentActivities);
                if (map5 == null || TextUtils.isEmpty(map5.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.google.android.apps.maps")) {
                    MapSettingAppInfo mapSettingAppInfo5 = new MapSettingAppInfo();
                    mapSettingAppInfo5.isInstalled = false;
                    mapSettingAppInfo5.appLabel = getAppNoInstallTips("Google Maps", string);
                    mapSettingAppInfo5.pkgName = "com.google.android.apps.maps";
                    mapSettingAppInfo5.navType = "1";
                    mapSettingAppInfo5.appIcon = context.getResources().getDrawable(R.drawable.map_setting_google_map_ic_not_install);
                    arrayList.add(mapSettingAppInfo5);
                } else {
                    m20376a(context2, map5);
                    arrayList.add(map5);
                }
                MapSettingAppInfo map6 = MapSettingUtils.getMap(packageManager, "com.waze", queryIntentActivities);
                if (map6 == null || TextUtils.isEmpty(map6.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.waze")) {
                    MapSettingAppInfo mapSettingAppInfo6 = new MapSettingAppInfo();
                    mapSettingAppInfo6.isInstalled = false;
                    mapSettingAppInfo6.appLabel = getAppNoInstallTips("Waze", string);
                    mapSettingAppInfo6.pkgName = "com.waze";
                    mapSettingAppInfo6.navType = "2";
                    mapSettingAppInfo6.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_not_install);
                    arrayList.add(mapSettingAppInfo6);
                } else {
                    map6.appLabel = "Waze";
                    map6.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_normal);
                    map6.navType = "2";
                    arrayList.add(map6);
                }
            } else if (c == 3) {
                MapSettingAppInfo map7 = MapSettingUtils.getMap(packageManager, MapSettingNavConstant.JP_YAHOO, queryIntentActivities);
                if (map7 != null && !TextUtils.isEmpty(map7.pkgName) && MapSettingApolloUtil.isShowYahoo() && MapSettingUtils.isInstalledApp(context2, MapSettingNavConstant.JP_YAHOO)) {
                    map7.appLabel = "Yahoo!カーナビ";
                    map7.appIcon = MapSettingUtils.getAppIcon(context2, MapSettingNavConstant.JP_YAHOO);
                    map7.pkgName = MapSettingNavConstant.JP_YAHOO;
                    arrayList.add(map7);
                }
                MapSettingAppInfo mapSettingAppInfo7 = new MapSettingAppInfo();
                if (MapSettingApolloUtil.isShowNaviTime() && MapSettingUtils.isInstalledApp(context2, MapSettingNavConstant.NAVI_TIME)) {
                    mapSettingAppInfo7.appLabel = "カーナビタイム";
                    mapSettingAppInfo7.appIcon = MapSettingUtils.getAppIcon(context2, MapSettingNavConstant.NAVI_TIME);
                    mapSettingAppInfo7.pkgName = MapSettingNavConstant.NAVI_TIME;
                    arrayList.add(mapSettingAppInfo7);
                }
            } else if (c == 4 || c == 5) {
                MapSettingAppInfo map8 = MapSettingUtils.getMap(packageManager, MapSettingNavConstant.YANDEX_NAV, queryIntentActivities);
                String string2 = context.getResources().getString(R.string.map_setting_nav_yandex_nav);
                if (map8 == null || !MapSettingUtils.isInstalledApp(context2, MapSettingNavConstant.YANDEX_NAV)) {
                    map8 = new MapSettingAppInfo();
                    map8.isInstalled = false;
                    map8.pkgName = MapSettingNavConstant.YANDEX_NAV;
                    map8.appLabel = string2 + "(" + string + ")";
                    map8.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_yandex_navigation_ic_not_install);
                } else {
                    map8.isInstalled = true;
                    map8.appLabel = string2;
                    map8.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_yandex_navigation_ic_normal);
                }
                map8.navType = "4";
                arrayList.add(map8);
                MapSettingAppInfo map9 = MapSettingUtils.getMap(packageManager, MapSettingNavConstant.YANDEX_MAP, queryIntentActivities);
                String string3 = context.getResources().getString(R.string.map_setting_nav_yandex_map);
                if (map9 == null || !MapSettingUtils.isInstalledApp(context2, MapSettingNavConstant.YANDEX_MAP)) {
                    map9 = new MapSettingAppInfo();
                    map9.isInstalled = false;
                    map9.pkgName = MapSettingNavConstant.YANDEX_MAP;
                    map9.appLabel = string3 + "(" + string + ")";
                    map9.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_yandex_map_ic_not_install);
                } else {
                    map9.isInstalled = true;
                    map9.appLabel = string3;
                    map9.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_yandex_map_ic_normal);
                }
                map9.navType = "3";
                arrayList.add(map9);
                MapSettingAppInfo map10 = MapSettingUtils.getMap(packageManager, MapSettingNavConstant.RU_2GIS, queryIntentActivities);
                if (map10 == null || !MapSettingUtils.isInstalledApp(context2, MapSettingNavConstant.RU_2GIS)) {
                    map10 = new MapSettingAppInfo();
                    map10.pkgName = MapSettingNavConstant.RU_2GIS;
                    map10.isInstalled = false;
                    map10.appLabel = "2GIS" + "(" + string + ")";
                    map10.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_2gis_ic_not_install);
                } else {
                    map10.isInstalled = true;
                    map10.appLabel = "2GIS";
                    map10.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_2gis_ic_normal);
                }
                map10.navType = "5";
                arrayList.add(map10);
                MapSettingAppInfo map11 = MapSettingUtils.getMap(packageManager, "com.waze", queryIntentActivities);
                String string4 = context.getResources().getString(R.string.map_setting_nav_waze);
                if (map11 == null || !MapSettingUtils.isInstalledApp(context2, "com.waze")) {
                    map11 = new MapSettingAppInfo();
                    map11.pkgName = "com.waze";
                    map11.isInstalled = false;
                    map11.appLabel = string4 + "(" + string + ")";
                    map11.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_waze_ic_not_install);
                } else {
                    map11.isInstalled = true;
                    map11.appLabel = string4;
                    map11.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_waze_ic_normal);
                }
                map11.navType = "2";
                arrayList.add(map11);
                MapSettingAppInfo map12 = MapSettingUtils.getMap(packageManager, "com.google.android.apps.maps", queryIntentActivities);
                String string5 = context.getResources().getString(R.string.map_setting_google_maps);
                if (map12 == null || !MapSettingUtils.isInstalledApp(context2, "com.google.android.apps.maps")) {
                    map12 = new MapSettingAppInfo();
                    map12.pkgName = "com.google.android.apps.maps";
                    map12.isInstalled = false;
                    map12.appLabel = string5 + "(" + string + ")";
                    map12.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_google_map_ic_not_install);
                } else {
                    map12.appLabel = string5;
                    map12.isInstalled = true;
                    map12.appIcon = ContextCompat.getDrawable(context2, R.drawable.map_setting_google_map_ic_normal);
                }
                map12.navType = "1";
                arrayList.add(map12);
            } else {
                MapSettingAppInfo map13 = MapSettingUtils.getMap(packageManager, "com.google.android.apps.maps", queryIntentActivities);
                if (map13 == null || TextUtils.isEmpty(map13.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.google.android.apps.maps")) {
                    MapSettingAppInfo mapSettingAppInfo8 = new MapSettingAppInfo();
                    mapSettingAppInfo8.isInstalled = false;
                    mapSettingAppInfo8.appLabel = getAppNoInstallTips("Google Maps", string);
                    mapSettingAppInfo8.pkgName = "com.google.android.apps.maps";
                    mapSettingAppInfo8.navType = "1";
                    mapSettingAppInfo8.appIcon = context.getResources().getDrawable(R.drawable.map_setting_google_map_ic_not_install);
                    arrayList.add(mapSettingAppInfo8);
                } else {
                    m20376a(context2, map13);
                    arrayList.add(map13);
                }
                MapSettingAppInfo map14 = MapSettingUtils.getMap(packageManager, "com.waze", queryIntentActivities);
                if (map14 == null || TextUtils.isEmpty(map14.pkgName) || !MapSettingUtils.isInstalledApp(context2, "com.waze")) {
                    MapSettingAppInfo mapSettingAppInfo9 = new MapSettingAppInfo();
                    mapSettingAppInfo9.isInstalled = false;
                    mapSettingAppInfo9.appLabel = getAppNoInstallTips("Waze", string);
                    mapSettingAppInfo9.pkgName = "com.waze";
                    mapSettingAppInfo9.navType = "2";
                    mapSettingAppInfo9.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_not_install);
                    arrayList.add(mapSettingAppInfo9);
                } else {
                    map14.appLabel = "Waze";
                    map14.appIcon = context.getResources().getDrawable(R.drawable.map_setting_waze_ic_normal);
                    map14.navType = "2";
                    arrayList.add(map14);
                }
            }
            if (MapSettingApolloUtil.isNeedFilterNav()) {
                arrayList = filterNav(arrayList);
            }
            Collections.sort(arrayList, $$Lambda$MapSettingNavUtils$kY1CQJFyX6HmHEjkEyi_XfDaQzU.INSTANCE);
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m20375a(MapSettingAppInfo mapSettingAppInfo, MapSettingAppInfo mapSettingAppInfo2) {
        if (mapSettingAppInfo == null || mapSettingAppInfo2 == null) {
            return 0;
        }
        return Integer.compare(mapSettingAppInfo.getWeight(), mapSettingAppInfo2.getWeight());
    }

    public static String getAppNoInstallTips(String str, String str2) {
        return str + " (" + str2 + ")";
    }

    /* renamed from: a */
    private static void m20377a(Context context, List<MapSettingAppInfo> list) {
        MapSettingAppInfo mapSettingAppInfo = new MapSettingAppInfo();
        mapSettingAppInfo.appLabel = context.getResources().getString(R.string.map_setting_navigation_build_in);
        mapSettingAppInfo.pkgName = MapSettingNavConstant.LOCAL_GOOGLE_NAVI;
        mapSettingAppInfo.appIcon = context.getResources().getDrawable(R.drawable.map_setting_inner_nav_ic);
        mapSettingAppInfo.navType = "0";
        list.add(mapSettingAppInfo);
    }

    /* renamed from: a */
    private static void m20376a(Context context, MapSettingAppInfo mapSettingAppInfo) {
        mapSettingAppInfo.appLabel = context.getResources().getString(R.string.map_setting_google_maps);
        mapSettingAppInfo.navType = "1";
        mapSettingAppInfo.appIcon = context.getResources().getDrawable(R.drawable.map_setting_google_map_ic_normal);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNavPkgNameByType(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case 48: goto L_0x003f;
                case 49: goto L_0x0035;
                case 50: goto L_0x002b;
                case 51: goto L_0x0021;
                case 52: goto L_0x0017;
                case 53: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "5"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 5
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "4"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 4
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 3
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "2"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 2
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "1"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "0"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 0
            goto L_0x004a
        L_0x0049:
            r6 = -1
        L_0x004a:
            if (r6 == 0) goto L_0x0068
            if (r6 == r5) goto L_0x0065
            if (r6 == r4) goto L_0x0062
            if (r6 == r3) goto L_0x005f
            if (r6 == r2) goto L_0x005c
            if (r6 == r1) goto L_0x0059
            java.lang.String r6 = "unknown"
            return r6
        L_0x0059:
            java.lang.String r6 = "ru.dublgis.dgismobile"
            return r6
        L_0x005c:
            java.lang.String r6 = "ru.yandex.yandexnavi"
            return r6
        L_0x005f:
            java.lang.String r6 = "ru.yandex.yandexmaps"
            return r6
        L_0x0062:
            java.lang.String r6 = "com.waze"
            return r6
        L_0x0065:
            java.lang.String r6 = "com.google.android.apps.maps"
            return r6
        L_0x0068:
            java.lang.String r6 = "local_google"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.global.MapSettingNavUtils.getNavPkgNameByType(java.lang.String):java.lang.String");
    }

    public static String getNavTypeByPkgName(String str) {
        return f28961a.get(str);
    }

    static {
        HashMap hashMap = new HashMap();
        f28961a = hashMap;
        f28962b = false;
        hashMap.put(MapSettingNavConstant.LOCAL_GOOGLE_NAVI, "0");
        f28961a.put("com.google.android.apps.maps", "1");
        f28961a.put("com.waze", "2");
        f28961a.put(MapSettingNavConstant.YANDEX_MAP, "3");
        f28961a.put(MapSettingNavConstant.YANDEX_NAV, "4");
        f28961a.put(MapSettingNavConstant.RU_2GIS, "5");
        String navFilter = MapSettingApolloUtil.getNavFilter();
        if (!TextUtils.isEmpty(navFilter)) {
            try {
                JSONArray jSONArray = new JSONArray(navFilter);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("navi_type");
                        String navPkgNameByType = getNavPkgNameByType(optString);
                        if (!f28962b && !"unknown".equals(navPkgNameByType)) {
                            f28961a.clear();
                            f28962b = true;
                        }
                        f28961a.put(navPkgNameByType, optString);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isNeedShowNavInListByMap(String str) {
        return f28961a.containsKey(str);
    }

    public static List<MapSettingAppInfo> filterNav(List<MapSettingAppInfo> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                MapSettingAppInfo mapSettingAppInfo = list.get(size);
                if (!isNeedShowNavInListByMap(mapSettingAppInfo.pkgName)) {
                    list.remove(mapSettingAppInfo);
                }
            }
        }
        return list;
    }

    public static int getYandexNavLeftTimes(Context context) {
        if (f28963c == null) {
            f28963c = MapSettingFactory.createMapPreferences(context);
        }
        TreeSet<Long> yandexNaviUseTimes = f28963c.getYandexNaviUseTimes();
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

    public static void addYandexNavUsedTimes(Context context) {
        if (f28963c == null) {
            f28963c = MapSettingFactory.createMapPreferences(context);
        }
        TreeSet<Long> treeSet = null;
        if (getYandexNavLeftTimes(context) > 0) {
            TreeSet<Long> yandexNaviUseTimes = f28963c.getYandexNaviUseTimes();
            if (yandexNaviUseTimes == null) {
                yandexNaviUseTimes = new TreeSet<>();
            }
            treeSet = yandexNaviUseTimes;
            while (treeSet.size() >= MapSettingApolloUtil.getYandexNavLimitCallTimes()) {
                treeSet.remove(treeSet.first());
            }
            treeSet.add(Long.valueOf(System.currentTimeMillis()));
        }
        f28963c.setYandexNaviUseTimes(treeSet);
    }
}
