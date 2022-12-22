package com.didi.map.setting;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.map.setting.common.IMapSettingDelegate;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.global.MapSettingNavUtils;
import com.didi.map.setting.global.MapSettingNavigationActivity;
import com.didi.map.setting.global.MapSettingWindowActivity;
import com.didi.map.setting.global.MapSettingWindowView;
import java.util.List;

public class MapSettingDelegate implements IMapSettingDelegate {
    public boolean getTrafficOpenDefault() {
        return false;
    }

    public boolean isNeedConvertLatLng() {
        return false;
    }

    public void startNavigationActivity(Context context) {
        MapSettingNavigationActivity.startMapSettingActivity(context);
    }

    public void startSettingWindowActivity(Context context, MapSettingNavInfo mapSettingNavInfo) {
        MapSettingWindowActivity.startMapSettingWindowActivity(context, mapSettingNavInfo);
    }

    public String getLanguage(String str) {
        if (TextUtils.isEmpty(str)) {
            return "en-US";
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2100) {
            if (hashCode != 2128) {
                if (hashCode != 2374) {
                    if (hashCode == 2475 && str.equals("MX")) {
                        c = 0;
                    }
                } else if (str.equals("JP")) {
                    c = 3;
                }
            } else if (str.equals("BR")) {
                c = 2;
            }
        } else if (str.equals("AU")) {
            c = 1;
        }
        if (c == 0) {
            return "es-MX";
        }
        if (c == 2) {
            return "pt-BR";
        }
        if (c != 3) {
            return "en-US";
        }
        return "ja-JP";
    }

    public MapSettingWindowView getSelectNavView(ViewGroup viewGroup, MapSettingNavInfo mapSettingNavInfo) {
        MapSettingWindowView mapSettingWindowView = new MapSettingWindowView(viewGroup.getContext());
        mapSettingWindowView.setParentView(viewGroup);
        mapSettingWindowView.setNavInfo(mapSettingNavInfo);
        return mapSettingWindowView;
    }

    public List<MapSettingAppInfo> getInstalledThirdNav(Context context) {
        return MapSettingNavUtils.getInstalledThirdNav(context);
    }

    public boolean isNeedShowNav(String str) {
        return MapSettingNavUtils.isNeedShowNavInListByMap(str);
    }
}
