package com.didichuxing.omega.sdk.leak;

import android.app.Activity;
import android.os.Bundle;
import com.didichuxing.omega.sdk.common.backend.ActivityLifecycleRegister;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;

public class LeakFacade {
    private static boolean sLeakedWatchTOOGLE = false;

    public static void init(boolean z) {
        if (z) {
            sLeakedWatchTOOGLE = true;
            if (CommonUtil.getAPILevel() >= 14) {
                ActivityLifecycleRegister.addActivityLifecycleListener(new ActivityLifecycleRegister.ActivityLifecycleListener() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public void onActivityPaused(Activity activity) {
                    }

                    public void onActivityResumed(Activity activity) {
                    }

                    public void onActivityStarted(Activity activity) {
                    }

                    public void onActivityStopped(Activity activity) {
                    }

                    public void onActivityDestroyed(Activity activity) {
                        LeakFacade.watch(activity);
                    }
                });
            }
        }
    }

    public static void watch(Object obj) {
        if (sLeakedWatchTOOGLE) {
            LeakWatcherWrapper.getInstance().watch(obj);
        }
    }

    public static void watch(Object obj, String str) {
        if (sLeakedWatchTOOGLE) {
            LeakWatcherWrapper.getInstance().watch(obj, str);
        }
    }
}
