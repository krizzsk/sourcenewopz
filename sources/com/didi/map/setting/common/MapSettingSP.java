package com.didi.map.setting.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class MapSettingSP {

    /* renamed from: a */
    private static MapSettingSP f28924a;

    /* renamed from: b */
    private SharedPreferences f28925b;

    /* renamed from: c */
    private Context f28926c;

    public String getNavSelectedLabel() {
        return "";
    }

    private MapSettingSP(Context context) {
        this.f28926c = context;
        this.f28925b = SystemUtils.getSharedPreferences(context, MapSettingConstant.PJ_NAME, 0);
    }

    public static MapSettingSP getInstance(Context context) {
        if (f28924a == null) {
            synchronized (MapSettingPreferences.class) {
                if (f28924a == null) {
                    f28924a = new MapSettingSP(context);
                }
            }
        }
        return f28924a;
    }

    public int getNavigationDirection() {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(MapSettingConstant.MAP_NAVIGATION_DIRECTION, 1);
        }
        return 1;
    }

    public void setNavigationDirection(int i) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(MapSettingConstant.MAP_NAVIGATION_DIRECTION, i).apply();
        }
    }

    public int getBusinessID() {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(MapSettingConstant.MAP_NAV_BUSINESS_ID, 101);
        }
        return 101;
    }

    public long getDriverID() {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(MapSettingConstant.MAP_NAV_DRIVER_ID, 0);
        }
        return 0;
    }

    public void setBusinessID(int i, long j) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(MapSettingConstant.MAP_NAV_BUSINESS_ID, i).apply();
            this.f28925b.edit().putLong(MapSettingConstant.MAP_NAV_DRIVER_ID, j).apply();
        }
    }

    public void setCountryCode(String str) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(MapSettingConstant.MAP_COUNTRY_CODE, str).apply();
        }
    }

    public String getCountCode() {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(MapSettingConstant.MAP_COUNTRY_CODE, "0");
        }
        return "0";
    }

    public boolean getGoogleLocalNav() {
        SharedPreferences sharedPreferences = this.f28925b;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_GOOGLE_LOCAL_NAV, false);
    }

    public void setGoogleLocalNav(boolean z) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_GOOGLE_LOCAL_NAV, z).apply();
        }
    }

    public boolean getWindowShow() {
        SharedPreferences sharedPreferences = this.f28925b;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_WINDOW_SHOW, false);
    }

    public void setWindowShow(boolean z) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_NAV_WINDOW_SHOW, z).apply();
        }
    }

    public boolean getNavDefaultOpen() {
        SharedPreferences sharedPreferences;
        if (getBusinessID() == 101) {
            SharedPreferences sharedPreferences2 = this.f28925b;
            if (sharedPreferences2 == null || !sharedPreferences2.getBoolean(MapSettingConstant.MAP_OPEN_NAV, false)) {
                return false;
            }
            return true;
        } else if (getBusinessID() != 102 || (sharedPreferences = this.f28925b) == null || !sharedPreferences.getBoolean(MapSettingConstant.MAP_OPEN_SEND_NAV, false)) {
            return false;
        } else {
            return true;
        }
    }

    public void setNavDefaultOpen(boolean z) {
        if (this.f28925b == null) {
            return;
        }
        if (getBusinessID() == 101) {
            this.f28925b.edit().putBoolean(MapSettingConstant.MAP_OPEN_NAV, z).apply();
        } else if (getBusinessID() == 102) {
            this.f28925b.edit().putBoolean(MapSettingConstant.MAP_OPEN_SEND_NAV, z).apply();
        }
    }

    public boolean getOpenRouteTraffic() {
        IMapSettingDelegate createMapDelegate = MapSettingFactory.createMapDelegate(this.f28926c);
        boolean z = createMapDelegate != null && createMapDelegate.getTrafficOpenDefault();
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences == null || !sharedPreferences.getBoolean(MapSettingConstant.MAP_ROUTE_TRAFFIC_NEW, z)) {
            return false;
        }
        return true;
    }

    public void setRouteTraffic(boolean z) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_ROUTE_TRAFFIC_NEW, z).apply();
        }
    }

    public int getMapNightMode() {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(MapSettingConstant.MAP_NAV_NIGHT_MODE, 1);
        }
        return 1;
    }

    public void setMapNightMode(int i) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(MapSettingConstant.MAP_NAV_NIGHT_MODE, i).apply();
        }
    }

    public String getNavSelectedPath() {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(MapSettingConstant.MAP_NAV_SELECTED, "");
        }
        return "";
    }

    public void setNavSelectedPath(String str, String str2) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(MapSettingConstant.MAP_NAV_SELECTED, str);
            this.f28925b.edit().apply();
        }
    }

    public boolean getNavAutoMock() {
        SharedPreferences sharedPreferences = this.f28925b;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_AUTO_MOCK, false);
    }

    public void setNavAutoMock(boolean z) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_NAV_AUTO_MOCK, z).apply();
        }
    }

    public boolean getNavRemember() {
        SharedPreferences sharedPreferences = this.f28925b;
        return sharedPreferences != null && sharedPreferences.getBoolean(MapSettingConstant.MAP_NAV_REMEMBER, false);
    }

    public void setNavRemember(boolean z) {
        SharedPreferences sharedPreferences = this.f28925b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(MapSettingConstant.MAP_NAV_REMEMBER, z).apply();
        }
    }

    public void destroy() {
        if (this.f28925b != null) {
            this.f28925b = null;
        }
        if (this.f28926c != null) {
            this.f28926c = null;
        }
    }
}
