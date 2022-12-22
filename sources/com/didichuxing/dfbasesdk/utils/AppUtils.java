package com.didichuxing.dfbasesdk.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class AppUtils {

    /* renamed from: a */
    private static int f46688a;

    /* renamed from: b */
    private static String f46689b;

    private AppUtils() {
    }

    public static int getVersionCode(Context context) {
        return WsgSecInfo.appVersionCode(context);
    }

    public static String getVersionName(Context context) {
        return WsgSecInfo.appVersionName(context);
    }

    public static void changeAppBrightness(Activity activity, int i) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (i == -1) {
            attributes.screenBrightness = -1.0f;
        } else {
            if (i <= 0) {
                i = 1;
            }
            attributes.screenBrightness = ((float) i) / 255.0f;
        }
        window.setAttributes(attributes);
    }
}
