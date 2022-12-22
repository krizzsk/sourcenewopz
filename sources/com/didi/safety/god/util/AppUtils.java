package com.didi.safety.god.util;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class AppUtils {
    private AppUtils() {
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
