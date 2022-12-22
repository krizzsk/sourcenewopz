package com.didichuxing.dfbasesdk.utils;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.Window;
import android.view.WindowManager;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class SystemUtils {
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

    public static int getMediaMaxVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(3);
    }

    public static int getMediaVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
    }

    public static void halfMediaVolume(Context context) {
        int mediaMaxVolume = getMediaMaxVolume(context) / 2;
        if (getMediaVolume(context) < mediaMaxVolume) {
            changeMediaVolume(context, mediaMaxVolume);
        }
    }

    public static void changeMediaVolume(Context context, int i) {
        ((AudioManager) context.getSystemService("audio")).setStreamVolume(3, i, 0);
    }

    @Deprecated
    public static String getCpuName() {
        return WsgSecInfo.cpu();
    }
}
