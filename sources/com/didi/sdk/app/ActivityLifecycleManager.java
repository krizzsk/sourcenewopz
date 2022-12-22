package com.didi.sdk.app;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.didi.sdk.util.SingletonHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivityLifecycleManager {

    /* renamed from: a */
    private Application f35097a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile AtomicInteger f35098b = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList<Activity> f35099c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<AppStateListener> f35100d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HashMap<Activity, ActivityTrace> f35101e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f35102f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f35103g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Activity f35104h;

    /* renamed from: i */
    private HomeKeyEventReceiver f35105i;

    /* renamed from: j */
    private ArrayList<HomeKeyEventListener> f35106j = new ArrayList<>();

    /* renamed from: k */
    private AbsActivityLifecycleCallbacks f35107k = new AbsActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MainActivity) {
                ActivityLifecycleManager.this.f35098b.incrementAndGet();
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MainActivity) {
                ActivityLifecycleManager.this.f35098b.decrementAndGet();
            }
        }
    };

    /* renamed from: l */
    private AbsActivityLifecycleCallbacks f35108l = new AbsActivityLifecycleCallbacks() {
        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleManager.this.f35099c.isEmpty()) {
                boolean unused = ActivityLifecycleManager.this.f35102f = true;
                ActivityLifecycleManager.this.m24782a(1);
            }
            ActivityLifecycleManager.this.f35099c.add(activity);
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f35101e.get(activity);
            if (activityTrace != null) {
                activityTrace.startCnt++;
            }
        }

        public void onActivityStopped(Activity activity) {
            ActivityLifecycleManager.this.f35099c.remove(activity);
            if (ActivityLifecycleManager.this.f35099c.isEmpty()) {
                boolean unused = ActivityLifecycleManager.this.f35102f = false;
                ActivityLifecycleManager.this.m24782a(0);
            }
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f35101e.get(activity);
            if (activityTrace != null) {
                activityTrace.stopCnt++;
            }
        }

        public void onActivityResumed(Activity activity) {
            Activity unused = ActivityLifecycleManager.this.f35104h = activity;
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f35101e.get(activity);
            if (activityTrace != null) {
                activityTrace.resumeCnt++;
            }
        }

        public void onActivityPaused(Activity activity) {
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f35101e.get(activity);
            if (activityTrace != null) {
                activityTrace.pauseCnt++;
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MainActivity) {
                int unused = ActivityLifecycleManager.this.f35103g = activity.getTaskId();
            }
            ActivityLifecycleManager.this.f35101e.put(activity, new ActivityTrace(activity));
        }

        public void onActivityDestroyed(Activity activity) {
            ActivityLifecycleManager.this.f35101e.remove(activity);
            ActivityLeakForHuaWei.doWorkaroundIfNeed(activity);
        }
    };

    public static class AbsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
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

        public void onNewIntent(Intent intent) {
        }
    }

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    public interface HomeKeyEventListener {
        void onHomeKeyPressed();
    }

    private ActivityLifecycleManager() {
    }

    public static ActivityLifecycleManager getInstance() {
        return (ActivityLifecycleManager) SingletonHolder.getInstance(ActivityLifecycleManager.class);
    }

    public static void init(Application application) {
        getInstance().f35097a = application;
        getInstance().m24781a();
        getInstance().m24787b();
        getInstance().m24792e();
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.f35097a != null && Build.VERSION.SDK_INT >= 14) {
            this.f35097a.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.f35097a != null && Build.VERSION.SDK_INT >= 14) {
            this.f35097a.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public boolean isMainActivityRunning() {
        return this.f35098b.get() >= 1;
    }

    public boolean isAppActive() {
        return this.f35102f;
    }

    public boolean isMainActivityOnTop() {
        Collection<ActivityTrace> values;
        Activity activity = this.f35104h;
        if ((activity == null || !(activity instanceof MainActivity)) && (values = this.f35101e.values()) != null) {
            for (ActivityTrace next : values) {
                boolean z = next.activity instanceof MainActivity;
                boolean z2 = next.startCnt > 0;
                boolean z3 = next.activity.getTaskId() == this.f35103g;
                if (!z && z2 && z3) {
                    return false;
                }
            }
        }
        return true;
    }

    public Activity getCurrentActivity() {
        return this.f35104h;
    }

    public void addAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f35100d) {
            this.f35100d.add(appStateListener);
        }
    }

    public void removeAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f35100d) {
            this.f35100d.remove(appStateListener);
        }
    }

    public void addHomeKeyEventListener(HomeKeyEventListener homeKeyEventListener) {
        if (homeKeyEventListener != null) {
            synchronized (this.f35106j) {
                this.f35106j.add(homeKeyEventListener);
            }
        }
    }

    public void removeHomeKeyEventListener(HomeKeyEventListener homeKeyEventListener) {
        if (homeKeyEventListener != null) {
            synchronized (this.f35106j) {
                this.f35106j.remove(homeKeyEventListener);
            }
        }
    }

    /* renamed from: a */
    private void m24781a() {
        registerActivityLifecycleCallbacks(this.f35107k);
    }

    /* renamed from: b */
    private void m24787b() {
        registerActivityLifecycleCallbacks(this.f35108l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24782a(int i) {
        Object[] c = m24789c();
        if (c != null) {
            for (int i2 = 0; i2 < c.length; i2++) {
                if (c[i2] != null) {
                    ((AppStateListener) c[i2]).onStateChanged(i);
                }
            }
        }
    }

    /* renamed from: c */
    private Object[] m24789c() {
        Object[] array;
        synchronized (this.f35100d) {
            array = this.f35100d.size() > 0 ? this.f35100d.toArray() : null;
        }
        return array;
    }

    /* renamed from: d */
    private Object[] m24791d() {
        Object[] array;
        synchronized (this.f35106j) {
            array = this.f35106j.size() > 0 ? this.f35106j.toArray() : null;
        }
        return array;
    }

    /* renamed from: e */
    private void m24792e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        HomeKeyEventReceiver homeKeyEventReceiver = new HomeKeyEventReceiver();
        this.f35105i = homeKeyEventReceiver;
        try {
            this.f35097a.registerReceiver(homeKeyEventReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m24793f() {
        try {
            this.f35097a.unregisterReceiver(this.f35105i);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m24794g() {
        Object[] d = m24791d();
        if (d != null) {
            for (Object obj : d) {
                ((HomeKeyEventListener) obj).onHomeKeyPressed();
            }
        }
    }

    static class ActivityTrace {
        public Activity activity;
        public int pauseCnt;
        public int resumeCnt;
        public int startCnt;
        public int stopCnt;

        public ActivityTrace(Activity activity2) {
            this.activity = activity2;
        }
    }

    final class HomeKeyEventReceiver extends BroadcastReceiver {
        private final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        private final String SYSTEM_DIALOG_REASON_KEY = "reason";

        HomeKeyEventReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                ActivityLifecycleManager.this.m24794g();
            }
        }
    }
}
