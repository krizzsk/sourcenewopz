package com.didi.map.setting.common;

import android.content.Context;

public class MapSettingFactory {
    public static IMapSettingPreferences createMapPreferences(Context context) {
        return new MapSettingPreferences(context);
    }

    public static IMapSettingDelegate createMapDelegate(Context context) {
        try {
            Object newInstance = Class.forName("com.didi.map.setting.MapSettingDelegate").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (newInstance instanceof IMapSettingDelegate) {
                return (IMapSettingDelegate) newInstance;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
