package com.didi.sdk.apm;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.didi.sdk.apm.utils.BackgroundThread;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateMonitor implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final int STATE_BACKGROUND = 0;
    public static final int STATE_FOREGROUND = 1;
    public static final String TAG = "ApplicationState";

    /* renamed from: b */
    private static final AppStateMonitor f34927b = new AppStateMonitor();

    /* renamed from: a */
    final Logger f34928a = LoggerFactory.getLogger("ApplicationState");

    /* renamed from: c */
    private final ArrayList<StateListener> f34929c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicInteger f34930d = new AtomicInteger(0);

    /* renamed from: e */
    private int f34931e = 0;

    /* renamed from: f */
    private Handler f34932f = BackgroundThread.getHandler();

    /* renamed from: g */
    private boolean f34933g = false;

    /* renamed from: h */
    private Runnable f34934h;

    public interface StateListener {
        void onInBackground();

        void onInForeground();
    }

    public static AppStateMonitor getInstance() {
        return f34927b;
    }

    public int getState() {
        return this.f34931e;
    }

    public void init(Context context) {
        if (!this.f34933g) {
            this.f34933g = true;
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
            C118701 r4 = new Runnable() {
                public void run() {
                    if (AppStateMonitor.this.f34930d.get() == 0) {
                        AppStateMonitor.this.m24693a(0);
                    }
                }
            };
            this.f34934h = r4;
            this.f34932f.postDelayed(r4, 15000);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m24695a("onActivityCreated: " + activity + ", savedInstanceState:" + bundle + ", intent:" + activity.getIntent().clone() + ", callingPackage:" + activity.getCallingPackage() + ", callingActivity:" + activity.getCallingActivity());
    }

    public void onActivityStarted(Activity activity) {
        m24695a("onActivityStarted: " + activity);
        if (this.f34930d.getAndIncrement() == 0) {
            m24693a(1);
        }
        Runnable runnable = this.f34934h;
        if (runnable != null) {
            this.f34932f.removeCallbacks(runnable);
            this.f34934h = null;
        }
    }

    public void onActivityResumed(Activity activity) {
        m24695a("onActivityResumed: " + activity);
    }

    public void onActivityPaused(Activity activity) {
        m24695a("onActivityPaused: " + activity);
    }

    public void onActivityStopped(Activity activity) {
        m24695a("onActivityStopped: " + activity);
        if (this.f34930d.decrementAndGet() == 0) {
            m24693a(0);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m24695a("onActivitySaveInstanceState: " + activity + " outState:" + bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        m24695a("onActivityDestroyed: " + activity);
    }

    public void onTrimMemory(int i) {
        m24695a("onTrimMemory: level:" + i);
    }

    public void onConfigurationChanged(Configuration configuration) {
        m24695a("onConfigurationChanged: " + configuration);
    }

    public void onLowMemory() {
        m24695a("onLowMemory: ");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24693a(int i) {
        this.f34931e = i;
        if (i == 0) {
            m24695a("App into background");
            m24692a();
        }
        if (i == 1) {
            m24695a("App into foreground");
            m24696b();
        }
    }

    /* renamed from: a */
    private void m24692a() {
        Object[] c = m24697c();
        if (c != null) {
            for (Object obj : c) {
                ((StateListener) obj).onInBackground();
            }
        }
    }

    /* renamed from: b */
    private void m24696b() {
        Object[] c = m24697c();
        if (c != null) {
            for (Object obj : c) {
                ((StateListener) obj).onInForeground();
            }
        }
    }

    /* renamed from: c */
    private Object[] m24697c() {
        Object[] array;
        synchronized (this.f34929c) {
            array = this.f34929c.size() > 0 ? this.f34929c.toArray() : null;
        }
        return array;
    }

    public void registerStateListener(StateListener stateListener) {
        if (stateListener != null) {
            synchronized (this.f34929c) {
                this.f34929c.add(stateListener);
            }
        }
    }

    public void unregisterStateListener(StateListener stateListener) {
        if (stateListener != null) {
            synchronized (this.f34929c) {
                this.f34929c.remove(stateListener);
            }
        }
    }

    /* renamed from: a */
    private void m24695a(String str) {
        this.f34928a.info(str, new Object[0]);
        if (!this.f34928a.isDebugEnabled()) {
            Log.i("ApplicationState", str);
        }
    }
}
