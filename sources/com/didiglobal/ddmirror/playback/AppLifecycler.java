package com.didiglobal.ddmirror.playback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppLifecycler {
    private static AppLifecycler sAppLifecycler;
    private ActivityLifecycleListener mActivityLifecycleListener = new ActivityLifecycleListener();
    private AppLifecycleListener mAppLifecycleListener = new AppLifecycleListener();
    /* access modifiers changed from: private */
    public WeakReference<Activity> mCurrentActivity;
    /* access modifiers changed from: private */
    public List<ForegroundListener> mForegroundListeners = new ArrayList();
    private boolean mInitialized;

    public interface ForegroundListener {
        void onForegroundChanged(boolean z);
    }

    private AppLifecycler() {
    }

    public static AppLifecycler getInstance() {
        AppLifecycler appLifecycler;
        synchronized (AppLifecycler.class) {
            if (sAppLifecycler == null) {
                sAppLifecycler = new AppLifecycler();
            }
            appLifecycler = sAppLifecycler;
        }
        return appLifecycler;
    }

    public void init(Application application) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            application.unregisterActivityLifecycleCallbacks(this.mActivityLifecycleListener);
            application.registerActivityLifecycleCallbacks(this.mActivityLifecycleListener);
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.mAppLifecycleListener);
        }
    }

    public Activity getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    public void addForegroundListener(ForegroundListener foregroundListener) {
        if (foregroundListener != null) {
            this.mForegroundListeners.add(foregroundListener);
        }
    }

    public void removeForegroundListener(ForegroundListener foregroundListener) {
        this.mForegroundListeners.remove(foregroundListener);
    }

    private class ActivityLifecycleListener implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private ActivityLifecycleListener() {
        }

        public void onActivityResumed(Activity activity) {
            WeakReference unused = AppLifecycler.this.mCurrentActivity = new WeakReference(activity);
        }
    }

    private class AppLifecycleListener implements LifecycleObserver {
        private AppLifecycleListener() {
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        private void onAppBackground() {
            for (int i = 0; i < AppLifecycler.this.mForegroundListeners.size(); i++) {
                ((ForegroundListener) AppLifecycler.this.mForegroundListeners.get(i)).onForegroundChanged(false);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private void onAppForeground() {
            for (int i = 0; i < AppLifecycler.this.mForegroundListeners.size(); i++) {
                ((ForegroundListener) AppLifecycler.this.mForegroundListeners.get(i)).onForegroundChanged(true);
            }
        }
    }
}
