package com.didichuxing.mas.sdk.quality.report.backend;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ActivityLifecycleRegister {
    /* access modifiers changed from: private */
    public static Queue<ActivityLifecycleListener> mListeners = new ConcurrentLinkedQueue();

    public interface ActivityLifecycleListener {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public static void addActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        mListeners.add(activityLifecycleListener);
    }

    public static void init(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                for (ActivityLifecycleListener onActivityCreated : ActivityLifecycleRegister.mListeners) {
                    onActivityCreated.onActivityCreated(activity, bundle);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                for (ActivityLifecycleListener onActivityDestroyed : ActivityLifecycleRegister.mListeners) {
                    onActivityDestroyed.onActivityDestroyed(activity);
                }
            }

            public void onActivityStarted(Activity activity) {
                for (ActivityLifecycleListener onActivityStarted : ActivityLifecycleRegister.mListeners) {
                    onActivityStarted.onActivityStarted(activity);
                }
            }

            public void onActivityStopped(Activity activity) {
                for (ActivityLifecycleListener onActivityStopped : ActivityLifecycleRegister.mListeners) {
                    onActivityStopped.onActivityStopped(activity);
                }
            }

            public void onActivityResumed(Activity activity) {
                for (ActivityLifecycleListener onActivityResumed : ActivityLifecycleRegister.mListeners) {
                    onActivityResumed.onActivityResumed(activity);
                }
            }

            public void onActivityPaused(Activity activity) {
                for (ActivityLifecycleListener onActivityPaused : ActivityLifecycleRegister.mListeners) {
                    onActivityPaused.onActivityPaused(activity);
                }
            }
        });
        addActivityLifecycleListener(AppStateMonitor.getInstance());
    }
}
