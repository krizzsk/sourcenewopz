package com.rider.rlab_im_map_plugin.tool;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class VersionTools {

    /* renamed from: a */
    private static String f55969a = "";

    public static String getVersionName(Context context) {
        if (!TextUtils.isEmpty(f55969a)) {
            return f55969a;
        }
        String str = "";
        try {
            str = SystemUtils.getPackageInfo(context.getPackageManager(), context.getApplicationInfo().packageName, 0).versionName;
            if (str != null) {
                f55969a = str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
