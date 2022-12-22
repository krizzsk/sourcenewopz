package com.didichuxing.omega.sdk.uicomponents.floatingview;

import android.app.Application;
import com.didi.sdk.apm.SystemUtils;

public class UIComponentCache {
    private static String KEY_USER_CLOSED_FLOATING_VIEW = "user_closed_floating_view";
    private static SavedState savedState;

    public static void init(Application application) {
        if (savedState == null && application != null) {
            savedState = new SavedState(application);
            try {
                KEY_USER_CLOSED_FLOATING_VIEW += SystemUtils.getPackageInfo(application.getPackageManager(), application.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isUserClosedFloatingView() {
        return savedState.getBoolean(KEY_USER_CLOSED_FLOATING_VIEW);
    }

    public static void userClosedFloatingView() {
        savedState.save(KEY_USER_CLOSED_FLOATING_VIEW, true);
    }
}
