package com.didi.mapbizinterface.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppStateMonitor {

    /* renamed from: a */
    private final AppStateCallbacks f29065a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile boolean f29066b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile int f29067c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile String f29068d;

    /* renamed from: e */
    private CopyOnWriteArrayList<OnAppStateChangedListener> f29069e;

    public enum AppState {
        FOREGROUND,
        BACKGROUND,
        UNKNOWN
    }

    public interface OnAppStateChangedListener {
        void onAppStateChanged(AppState appState, String str);
    }

    /* renamed from: a */
    static /* synthetic */ int m20478a(AppStateMonitor appStateMonitor) {
        int i = appStateMonitor.f29067c + 1;
        appStateMonitor.f29067c = i;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m20485c(AppStateMonitor appStateMonitor) {
        int i = appStateMonitor.f29067c - 1;
        appStateMonitor.f29067c = i;
        return i;
    }

    private AppStateMonitor() {
        this.f29065a = new AppStateCallbacks();
        this.f29066b = false;
        this.f29067c = 0;
        this.f29069e = new CopyOnWriteArrayList<>();
    }

    private static class SingletonHolder {
        static AppStateMonitor INSTANCE = new AppStateMonitor();

        private SingletonHolder() {
        }
    }

    public static AppStateMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.f29065a);
        }
    }

    public AppState getAppState() {
        if (this.f29066b) {
            return this.f29067c > 0 ? AppState.FOREGROUND : AppState.BACKGROUND;
        }
        return AppState.UNKNOWN;
    }

    public String getCurrentAppPage() {
        return this.f29068d;
    }

    public void addOnAppStateChangedListener(OnAppStateChangedListener onAppStateChangedListener) {
        if (onAppStateChangedListener != null) {
            this.f29069e.add(onAppStateChangedListener);
        }
    }

    public void removeOnAppStateChangedListener(OnAppStateChangedListener onAppStateChangedListener) {
        if (onAppStateChangedListener != null) {
            this.f29069e.remove(onAppStateChangedListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20481a(AppState appState, String str) {
        Iterator<OnAppStateChangedListener> it = this.f29069e.iterator();
        while (it.hasNext()) {
            it.next().onAppStateChanged(appState, str);
        }
    }

    private class AppStateCallbacks implements Application.ActivityLifecycleCallbacks {
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

        private AppStateCallbacks() {
        }

        public void onActivityStarted(Activity activity) {
            AppStateMonitor.m20478a(AppStateMonitor.this);
            String unused = AppStateMonitor.this.f29068d = activity.getClass().getSimpleName();
            boolean unused2 = AppStateMonitor.this.f29066b = true;
            AppStateMonitor appStateMonitor = AppStateMonitor.this;
            appStateMonitor.m20481a(appStateMonitor.getAppState(), AppStateMonitor.this.getCurrentAppPage());
        }

        public void onActivityStopped(Activity activity) {
            AppStateMonitor appStateMonitor = AppStateMonitor.this;
            int unused = appStateMonitor.f29067c = appStateMonitor.f29067c > 0 ? AppStateMonitor.m20485c(AppStateMonitor.this) : 0;
            if (TextUtils.equals(activity.getClass().getSimpleName(), AppStateMonitor.this.f29068d)) {
                String unused2 = AppStateMonitor.this.f29068d = null;
            }
            AppStateMonitor appStateMonitor2 = AppStateMonitor.this;
            appStateMonitor2.m20481a(appStateMonitor2.getAppState(), AppStateMonitor.this.getCurrentAppPage());
        }
    }
}
