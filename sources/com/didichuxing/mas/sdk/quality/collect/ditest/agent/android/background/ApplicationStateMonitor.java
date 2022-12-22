package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ApplicationStateMonitor {

    /* renamed from: a */
    private static final AgentLog f47934a = AgentLogManager.getAgentLog();

    /* renamed from: f */
    private static ApplicationStateMonitor f47935f;

    /* renamed from: g */
    private static long f47936g = 0;

    /* renamed from: b */
    private int f47937b;

    /* renamed from: c */
    private final ArrayList<ApplicationStateListener> f47938c = new ArrayList<>();

    /* renamed from: d */
    private boolean f47939d = true;

    /* renamed from: e */
    private final Object f47940e = new Object();

    public void uiHidden() {
    }

    private ApplicationStateMonitor() {
        f47934a.info("Application state monitor has started");
    }

    public static synchronized ApplicationStateMonitor getInstance() {
        ApplicationStateMonitor applicationStateMonitor;
        synchronized (ApplicationStateMonitor.class) {
            if (f47935f == null) {
                f47935f = new ApplicationStateMonitor();
            }
            applicationStateMonitor = f47935f;
        }
        return applicationStateMonitor;
    }

    public void addApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.f47938c) {
            this.f47938c.add(applicationStateListener);
        }
    }

    public void activityStopped() {
        synchronized (this.f47940e) {
            int i = this.f47937b - 1;
            this.f47937b = i;
            if (i == 0) {
                f47934a.info("UI has become hidden (app backgrounded)");
                m34220a();
                this.f47939d = false;
            }
        }
    }

    public void activityStarted() {
        synchronized (this.f47940e) {
            if (this.f47937b == 0) {
                m34222c();
                f47934a.verbose("Application appears to be in the foreground");
                m34221b();
                this.f47939d = true;
            }
            this.f47937b++;
        }
    }

    /* renamed from: a */
    private void m34220a() {
        ArrayList arrayList;
        f47934a.verbose("Application appears to have gone to the background");
        synchronized (this.f47938c) {
            arrayList = new ArrayList(this.f47938c);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationBackgrounded(applicationStateEvent);
        }
    }

    /* renamed from: b */
    private void m34221b() {
        ArrayList arrayList;
        synchronized (this.f47938c) {
            arrayList = new ArrayList(this.f47938c);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationForegrounded(applicationStateEvent);
        }
    }

    public boolean isForegrounded() {
        return this.f47939d;
    }

    /* renamed from: c */
    private void m34222c() {
        if (System.currentTimeMillis() - f47936g > 3600000) {
            OmegaSDKAdapter.trackMasEvent("omg_lag_open");
            OmegaSDKAdapter.trackMasEvent("omg_anr_open");
            f47936g = System.currentTimeMillis();
        }
    }
}
