package com.didi.map.common.accessibility;

import android.content.Context;
import android.provider.Settings;

public class AccessibilityUtils {
    public static boolean isAccessibilityTackbackEnable(Context context) {
        int i;
        String string;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        if (i != 1 || (string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services")) == null) {
            return false;
        }
        return string.contains("com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService");
    }
}
