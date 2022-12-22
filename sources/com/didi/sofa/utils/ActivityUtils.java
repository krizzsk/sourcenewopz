package com.didi.sofa.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

public final class ActivityUtils {
    private ActivityUtils() {
    }

    public static void startSystemSettingActivity(Context context) {
        Intent intent = new Intent("android.settings.SETTINGS");
        if (m31274a(context, intent)) {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void startWifiSettingActivity(Context context) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        if (!m31274a(context, intent)) {
            intent = new Intent("android.settings.WIRELESS_SETTINGS");
            if (!m31274a(context, intent)) {
                intent = new Intent("android.settings.SETTINGS");
            }
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startGpsSettingActivity(Context context) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (m31274a(context, intent)) {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void startDialActivity(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        if (!m31274a(context, intent)) {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.setFlags(268435456);
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getScheme())) {
            intent.setData(Uri.parse("tel:" + str));
        } else {
            intent.setData(parse);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    private static boolean m31274a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo.activityInfo.exported) {
                return true;
            }
        }
        return false;
    }
}
