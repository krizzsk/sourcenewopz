package com.didichuxing.mas.sdk.quality.report.backend;

import android.app.Activity;
import android.os.Bundle;
import com.didichuxing.mas.sdk.quality.report.backend.ActivityLifecycleRegister;
import java.util.ArrayList;

public class AppStateMonitor implements ActivityLifecycleRegister.ActivityLifecycleListener {
    public static final int STATE_BACKGROUND = 0;
    public static final int STATE_FOREGROUND = 1;
    public static final String TAG = "ApplicationState";
    private static final AppStateMonitor sInstance = new AppStateMonitor();
    private final ArrayList<AppStateListener> mAppStateListeners = new ArrayList<>();
    private ArrayList<Activity> mStartedActivities = new ArrayList<>();
    private int mState = 0;

    public interface AppStateListener {
        void onInBackground();

        void onInForeground();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public static AppStateMonitor getInstance() {
        return sInstance;
    }

    public int getState() {
        return this.mState;
    }

    public synchronized boolean isInForeground() {
        boolean z;
        z = true;
        if (this.mState != 1) {
            z = false;
        }
        return z;
    }

    public synchronized boolean isInBackground() {
        return this.mState == 0;
    }

    public void onActivityStarted(Activity activity) {
        if (this.mStartedActivities.isEmpty()) {
            onStateChanged(1);
        }
        this.mStartedActivities.add(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.mStartedActivities.remove(activity);
        if (this.mStartedActivities.isEmpty()) {
            onStateChanged(0);
        }
    }

    private void onStateChanged(int i) {
        this.mState = i;
        if (i == 0) {
            dispatchOnInBackground();
        }
        if (i == 1) {
            dispatchOnInForeground();
        }
    }

    private void dispatchOnInBackground() {
        Object[] collectAppStateListeners = collectAppStateListeners();
        if (collectAppStateListeners != null) {
            for (Object obj : collectAppStateListeners) {
                ((AppStateListener) obj).onInBackground();
            }
        }
    }

    private void dispatchOnInForeground() {
        Object[] collectAppStateListeners = collectAppStateListeners();
        if (collectAppStateListeners != null) {
            for (Object obj : collectAppStateListeners) {
                ((AppStateListener) obj).onInForeground();
            }
        }
    }

    private Object[] collectAppStateListeners() {
        Object[] array;
        synchronized (this.mAppStateListeners) {
            array = this.mAppStateListeners.size() > 0 ? this.mAppStateListeners.toArray() : null;
        }
        return array;
    }

    public void registerAppStateListener(AppStateListener appStateListener) {
        if (appStateListener != null) {
            synchronized (this.mAppStateListeners) {
                this.mAppStateListeners.add(appStateListener);
            }
        }
    }

    public void unregisterAppStateListener(AppStateListener appStateListener) {
        if (appStateListener != null) {
            synchronized (this.mAppStateListeners) {
                this.mAppStateListeners.remove(appStateListener);
            }
        }
    }
}
