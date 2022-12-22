package com.didi.map.setting.common;

import android.content.Context;
import android.view.ViewGroup;
import java.util.List;

public interface IMapSettingDelegate {
    List<MapSettingAppInfo> getInstalledThirdNav(Context context);

    String getLanguage(String str);

    Object getSelectNavView(ViewGroup viewGroup, MapSettingNavInfo mapSettingNavInfo);

    boolean getTrafficOpenDefault();

    boolean isNeedConvertLatLng();

    boolean isNeedShowNav(String str);

    void startNavigationActivity(Context context);

    void startSettingWindowActivity(Context context, MapSettingNavInfo mapSettingNavInfo);
}
