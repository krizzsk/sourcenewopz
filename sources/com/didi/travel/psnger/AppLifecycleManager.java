package com.didi.travel.psnger;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;

public class AppLifecycleManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<Activity> f44009a;

    /* renamed from: b */
    private ArrayList<AppStateListener> f44010b;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f44011c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f44012d;

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    private AppLifecycleManager() {
        this.f44009a = new ArrayList<>();
        this.f44010b = new ArrayList<>();
        this.f44011c = new AbsActivityLifecycleCallbacks() {
            public void onActivityStarted(Activity activity) {
                AppLifecycleManager.this.f44009a.add(activity);
                if (AppLifecycleManager.this.f44009a.size() == 1) {
                    AppLifecycleManager.this.m31345a(1);
                }
                boolean unused = AppLifecycleManager.this.f44012d = true;
            }

            public void onActivityStopped(Activity activity) {
                AppLifecycleManager.this.f44009a.remove(activity);
                if (AppLifecycleManager.this.f44009a.isEmpty()) {
                    AppLifecycleManager.this.m31345a(0);
                }
                boolean unused = AppLifecycleManager.this.f44012d = true;
            }
        };
    }

    public static AppLifecycleManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo109675a(Application application) {
        application.registerActivityLifecycleCallbacks(this.f44011c);
    }

    public boolean isAppFront() {
        if (!this.f44012d) {
            return true;
        }
        return !this.f44009a.isEmpty();
    }

    public void registerAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f44010b) {
            this.f44010b.add(appStateListener);
        }
    }

    public void unregisterAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f44010b) {
            this.f44010b.remove(appStateListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31345a(int i) {
        ArrayList<AppStateListener> arrayList = new ArrayList<>();
        synchronized (this.f44010b) {
            arrayList.addAll(this.f44010b);
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

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static AppLifecycleManager INSTANCE = new AppLifecycleManager();

        private SingletonHolder() {
        }
    }
}
