package com.didi.map.setting.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ddmap.sdk.degrade.gnav.GoogleNavDegrade;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.conf.DefaultConfProvider;
import com.didi.map.setting.common.conf.INavSettingConf;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class MapSettingPreferences implements IMapSettingPreferences {

    /* renamed from: a */
    private final SharedPreferences f28921a;

    /* renamed from: b */
    private final Context f28922b;

    /* renamed from: c */
    private INavSettingConf f28923c = DefaultConfProvider.getConfig();

    public MapSettingPreferences(Context context) {
        this.f28922b = context;
        this.f28921a = SystemUtils.getSharedPreferences(context, MapSettingConstant.PJ_NAME, 0);
    }

    public int getNavigationDirection() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(MapSettingConstant.MAP_NAVIGATION_DIRECTION, 2);
        }
        return 2;
    }

    public void setNavigationDirection(int i) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(MapSettingConstant.MAP_NAVIGATION_DIRECTION, i).apply();
        }
    }

    public int getBusinessID() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(MapSettingConstant.MAP_NAV_BUSINESS_ID, 101);
        }
        return 101;
    }

    public long getDriverID() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(MapSettingConstant.MAP_NAV_DRIVER_ID, 0);
        }
        return 0;
    }

    public void setBusinessID(int i, long j) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(MapSettingConstant.MAP_NAV_BUSINESS_ID, i).apply();
            this.f28921a.edit().putLong(MapSettingConstant.MAP_NAV_DRIVER_ID, j).apply();
        }
    }

    public void setCountryCode(String str) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(MapSettingConstant.MAP_COUNTRY_CODE, str).apply();
        }
    }

    public String getCountCode() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(MapSettingConstant.MAP_COUNTRY_CODE, "0");
        }
        return "0";
    }

    public boolean getGoogleLocalNav() {
        SharedPreferences sharedPreferences = this.f28921a;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_GOOGLE_LOCAL_NAV, false);
    }

    public void setGoogleLocalNav(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_GOOGLE_LOCAL_NAV, z).apply();
        }
    }

    public boolean getWindowShow() {
        SharedPreferences sharedPreferences = this.f28921a;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_WINDOW_SHOW, false);
    }

    public void setWindowShow(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_NAV_WINDOW_SHOW, z).apply();
        }
    }

    public boolean getNavDefaultOpen() {
        boolean isAutoStart = this.f28923c.isAutoStart();
        if (getBusinessID() == 101) {
            SharedPreferences sharedPreferences = this.f28921a;
            if (sharedPreferences == null || !sharedPreferences.getBoolean(MapSettingConstant.MAP_OPEN_NAV, isAutoStart)) {
                return false;
            }
            return true;
        } else if (getBusinessID() != 102) {
            return isAutoStart;
        } else {
            SharedPreferences sharedPreferences2 = this.f28921a;
            if (sharedPreferences2 == null || !sharedPreferences2.getBoolean(MapSettingConstant.MAP_OPEN_SEND_NAV, isAutoStart)) {
                return false;
            }
            return true;
        }
    }

    public void setNavDefaultOpen(boolean z) {
        if (this.f28921a == null) {
            return;
        }
        if (getBusinessID() == 101) {
            this.f28921a.edit().putBoolean(MapSettingConstant.MAP_OPEN_NAV, z).apply();
        } else if (getBusinessID() == 102) {
            this.f28921a.edit().putBoolean(MapSettingConstant.MAP_OPEN_SEND_NAV, z).apply();
        }
    }

    public boolean getOpenRouteTraffic() {
        IMapSettingDelegate createMapDelegate = MapSettingFactory.createMapDelegate(this.f28922b);
        boolean z = createMapDelegate != null && createMapDelegate.getTrafficOpenDefault();
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences == null || !sharedPreferences.getBoolean(MapSettingConstant.MAP_ROUTE_TRAFFIC_NEW, z)) {
            return false;
        }
        return true;
    }

    public void setRouteTraffic(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_ROUTE_TRAFFIC_NEW, z).apply();
        }
    }

    public int getNavDayNightMode() {
        int dayNightMode = this.f28923c.getDayNightMode();
        SharedPreferences sharedPreferences = this.f28921a;
        return sharedPreferences != null ? sharedPreferences.getInt(MapSettingConstant.MAP_NAV_NIGHT_MODE, dayNightMode) : dayNightMode;
    }

    public void setNavDayNightMode(int i) {
        if (this.f28921a != null && i != getNavDayNightMode()) {
            this.f28921a.edit().putInt(MapSettingConstant.MAP_NAV_NIGHT_MODE, i).apply();
        }
    }

    public String getNavSelectedPath() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(MapSettingConstant.MAP_NAV_SELECTED, "mDefault");
        return "mDefault".equals(string) ? m20366a() : string;
    }

    public void setNavSelectedPath(String str) {
        if (this.f28921a != null && !TextUtils.equals(getNavSelectedPath(), str)) {
            this.f28921a.edit().putString(MapSettingConstant.MAP_NAV_SELECTED, str).apply();
        }
    }

    public boolean getNavAutoMock() {
        SharedPreferences sharedPreferences = this.f28921a;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_AUTO_MOCK, false);
    }

    public void setNavAutoMock(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_NAV_AUTO_MOCK, z).apply();
        }
    }

    public boolean getNavRemember() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(m20366a());
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences == null || !sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_REMEMBER, z2)) {
            z = false;
        }
        if (z) {
            String navSelectedPath = getNavSelectedPath();
            DLog.m20371d("MapSettingPreferences getNavRemember : selectedPath = " + navSelectedPath, new Object[0]);
            if (!TextUtils.isEmpty(navSelectedPath)) {
                if (!MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(navSelectedPath) && !MapSettingUtils.isInstalledApp(this.f28922b, navSelectedPath)) {
                    setNavRemember(false);
                    setNavSelectedPath("");
                    setLastSelectedNav("");
                    DLog.m20371d("MapSettingPreferences getNavRemember : clearNavSelectedPath && set isRemember is false", new Object[0]);
                } else if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(navSelectedPath) && GoogleNavDegrade.Companion.getInstance().needDegrade(this.f28922b, PlatInfo.getInstance().getClientVersion())) {
                    setNavRemember(false);
                    setNavSelectedPath("");
                    setLastSelectedNav("");
                }
                z = false;
            }
        }
        DLog.m20371d("MapSettingPreferences isRemember = " + z, new Object[0]);
        return z;
    }

    public void setNavRemember(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_NAV_REMEMBER, z).apply();
            if (!z && "mDefault".equals(this.f28921a.getString(MapSettingConstant.MAP_NAV_SELECTED, "mDefault"))) {
                String a = m20366a();
                if (!TextUtils.isEmpty(a)) {
                    this.f28921a.edit().putString(MapSettingConstant.MAP_NAV_SELECTED, a).apply();
                }
            }
        }
    }

    public boolean getOpenGuideLine() {
        SharedPreferences sharedPreferences = this.f28921a;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_ROUTE_GUIDE_LINE, true);
    }

    public void setGuideLine(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_ROUTE_GUIDE_LINE, z).apply();
        }
    }

    public void setInAppNavVoiceOpen(boolean z) {
        if (this.f28921a != null && z != getInAppNavVoiceOpen()) {
            this.f28921a.edit().putBoolean(MapSettingConstant.MAP_NAV_INAPP_VOICE_SWITCH, z).apply();
        }
    }

    public boolean getInAppNavVoiceOpen() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_INAPP_VOICE_SWITCH, this.f28923c.isOpenVoice());
        }
        return this.f28923c.isOpenVoice();
    }

    public boolean getUserCloseAutoNav() {
        SharedPreferences sharedPreferences = this.f28921a;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_USER_CLOSE_AUTO_NAV, false);
    }

    public void setUserCloseAutoNav(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_USER_CLOSE_AUTO_NAV, z).apply();
        }
    }

    public String getLastSelectedNav() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(MapSettingConstant.MAP_USER_LAST_SELECTED_NAV, "");
        }
        return "";
    }

    public void setLastSelectedNav(String str) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(MapSettingConstant.MAP_USER_LAST_SELECTED_NAV, str).apply();
        }
    }

    public void setShowYandexMapTips(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_YANDEX_MAP_SHOW_TIP, z).apply();
        }
    }

    public boolean hasShowYandexMapTips() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_YANDEX_MAP_SHOW_TIP, false);
        }
        return false;
    }

    public void setShowYandexNavTips(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_YANDEX_NAV_SHOW_TIP, z).apply();
        }
    }

    public boolean hasShowYandexNavTips() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_YANDEX_NAV_SHOW_TIP, false);
        }
        return false;
    }

    public void setShowYandexMapTipsInOrder(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_YANDEX_MAP_SHOW_TIP_IN_ORDER, z).apply();
        }
    }

    public boolean hasShowYandexMapTipsInOrder() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_YANDEX_MAP_SHOW_TIP_IN_ORDER, false);
        }
        return false;
    }

    public void setShowYandexNavTipsInOrder(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_YANDEX_NAV_SHOW_TIP_IN_ORDER, z).apply();
        }
    }

    public boolean hasShowYandexNavTipsInOrder() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_YANDEX_NAV_SHOW_TIP_IN_ORDER, false);
        }
        return false;
    }

    public void setYandexNaviUseTimes(TreeSet<Long> treeSet) {
        if (treeSet == null || treeSet.size() <= 0) {
            SharedPreferences sharedPreferences = this.f28921a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(MapSettingConstant.MAP_YANDEX_NAV_USING_TIMES, "").apply();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        DLog.m20371d("YandexNavi", "YandexNaviUseTimes content = " + sb.toString());
        SharedPreferences sharedPreferences2 = this.f28921a;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString(MapSettingConstant.MAP_YANDEX_NAV_USING_TIMES, sb.toString()).apply();
        }
    }

    public TreeSet<Long> getYandexNaviUseTimes() {
        try {
            String string = this.f28921a.getString(MapSettingConstant.MAP_YANDEX_NAV_USING_TIMES, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String[] split = string.split(",");
            TreeSet<Long> treeSet = new TreeSet<>();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    treeSet.add(Long.valueOf(str));
                }
            }
            return treeSet;
        } catch (Exception e) {
            DLog.m20371d("YandexNavi", "getYandexNaviUseTimes Exception =  " + e.toString());
            return null;
        }
    }

    public void setTrafficStatusIntroShown(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_TRAFFIC_STATUS_BAR_INTRO_SHOWN, z).apply();
        }
    }

    public boolean getTrafficStatusIntroShown() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_TRAFFIC_STATUS_BAR_INTRO_SHOWN, false);
        }
        return false;
    }

    public void setShouldShowTrafficStatusBar(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_TRAFFIC_STATUS_BAR_SHOW, z).apply();
        }
    }

    public boolean getShouldShowTrafficStatusBar() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_TRAFFIC_STATUS_BAR_SHOW, true);
        }
        return false;
    }

    public void setIsHawaii(boolean z) {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_VENDOR_IS_HAWAII, z).apply();
        }
    }

    public boolean isHawaii() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(MapSettingConstant.MAP_VENDOR_IS_HAWAII, false);
        }
        return false;
    }

    public boolean hasUserSettingNav() {
        SharedPreferences sharedPreferences = this.f28921a;
        if (sharedPreferences != null) {
            return !"mDefault".equals(sharedPreferences.getString(MapSettingConstant.MAP_NAV_SELECTED, "mDefault"));
        }
        return false;
    }

    /* renamed from: a */
    private String m20366a() {
        List<String> navPkgList = this.f28923c.getNavPkgList();
        if (navPkgList.isEmpty()) {
            return "";
        }
        List<String> showTypeList = DefaultConfProvider.getShowTypeList(this.f28922b);
        for (String next : navPkgList) {
            if ((MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(next) && getGoogleLocalNav() && showTypeList.contains(next)) || (showTypeList.contains(next) && MapSettingUtils.isInstall(this.f28922b, next))) {
                return next;
            }
        }
        return "";
    }
}
