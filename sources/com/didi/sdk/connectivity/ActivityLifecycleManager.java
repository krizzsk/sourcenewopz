package com.didi.sdk.connectivity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;

class ActivityLifecycleManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<Activity> f35711a;

    /* renamed from: b */
    private ArrayList<AppStateListener> f35712b;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f35713c;

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    private ActivityLifecycleManager() {
        this.f35711a = new ArrayList<>();
        this.f35712b = new ArrayList<>();
        this.f35713c = new AbsActivityLifecycleCallbacks() {
            public void onActivityStarted(Activity activity) {
                if (ActivityLifecycleManager.this.f35711a.isEmpty()) {
                    ActivityLifecycleManager.this.m25288a(1);
                }
                ActivityLifecycleManager.this.f35711a.add(activity);
            }

            public void onActivityStopped(Activity activity) {
                ActivityLifecycleManager.this.f35711a.remove(activity);
                if (ActivityLifecycleManager.this.f35711a.isEmpty()) {
                    ActivityLifecycleManager.this.m25288a(0);
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

    /* renamed from: a */
    public static ActivityLifecycleManager m25286a() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91432a(Application application) {
        application.registerActivityLifecycleCallbacks(this.f35713c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91433a(AppStateListener appStateListener) {
        synchronized (this.f35712b) {
            this.f35712b.add(appStateListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91434b(AppStateListener appStateListener) {
        synchronized (this.f35712b) {
            this.f35712b.remove(appStateListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25288a(int i) {
        ArrayList<AppStateListener> arrayList = new ArrayList<>();
        synchronized (this.f35712b) {
            arrayList.addAll(this.f35712b);
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
