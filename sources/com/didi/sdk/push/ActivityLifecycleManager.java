package com.didi.sdk.push;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;

class ActivityLifecycleManager {
    private Application.ActivityLifecycleCallbacks callbacks;
    private ArrayList<AppStateListener> mAppStateListeners;
    /* access modifiers changed from: private */
    public ArrayList<Activity> mStartedActivities;

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    private ActivityLifecycleManager() {
        this.mStartedActivities = new ArrayList<>();
        this.mAppStateListeners = new ArrayList<>();
        this.callbacks = new AbsActivityLifecycleCallbacks() {
            public void onActivityStarted(Activity activity) {
                if (ActivityLifecycleManager.this.mStartedActivities.isEmpty()) {
                    ActivityLifecycleManager.this.onNotifyAppStateChanged(1);
                }
                ActivityLifecycleManager.this.mStartedActivities.add(activity);
            }

            public void onActivityStopped(Activity activity) {
                ActivityLifecycleManager.this.mStartedActivities.remove(activity);
                if (ActivityLifecycleManager.this.mStartedActivities.isEmpty()) {
                    ActivityLifecycleManager.this.onNotifyAppStateChanged(0);
                }
            }
        };
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static ActivityLifecycleManager INSTANCE = new ActivityLifecycleManager();

        private SingletonHolder() {
        }
    }

    public static ActivityLifecycleManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(this.callbacks);
    }

    /* access modifiers changed from: package-private */
    public void registerAppStateListener(AppStateListener appStateListener) {
        synchronized (this.mAppStateListeners) {
            this.mAppStateListeners.add(appStateListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterAppStateListener(AppStateListener appStateListener) {
        synchronized (this.mAppStateListeners) {
            this.mAppStateListeners.remove(appStateListener);
        }
    }

    /* access modifiers changed from: private */
    public void onNotifyAppStateChanged(int i) {
        ArrayList<AppStateListener> arrayList = new ArrayList<>();
        synchronized (this.mAppStateListeners) {
            arrayList.addAll(this.mAppStateListeners);
        }
        for (AppStateListener onStateChanged : arrayList) {
            onStateChanged.onStateChanged(i);
        }
    }

    static class AbsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        AbsActivityLifecycleCallbacks() {
        }
    }
}
