package com.didi.flutter.nacho2.p115v2.container;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.didi.flutter.nacho2.v2.container.NachoActivityLifecycleCallbacks */
public class NachoActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        NachoActivityManager.getInstance().getActivities().add(new WeakReference(activity));
    }

    public void onActivityResumed(Activity activity) {
        NachoActivityManager.getInstance().setTopActivity(new WeakReference(activity));
        if (NachoActivityManager.getInstance().isFlutterContainer(activity)) {
            NachoActivityManager.getInstance().setPaddingOpenContainer(false);
        }
    }

    public void onActivityPaused(Activity activity) {
        WeakReference<Activity> topActivity = NachoActivityManager.getInstance().getTopActivity();
        if (topActivity != null && topActivity.get() == activity) {
            topActivity.clear();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        LinkedList<WeakReference<Activity>> activities = NachoActivityManager.getInstance().getActivities();
        int size = activities.size();
        for (int i = 0; i < size; i++) {
            if (activities.get(i).get() == activity) {
                activities.remove(i);
                return;
            }
        }
    }
}
