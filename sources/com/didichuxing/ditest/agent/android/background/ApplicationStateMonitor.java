package com.didichuxing.ditest.agent.android.background;

import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.omega.sdk.analysis.Tracker;
import java.util.ArrayList;
import java.util.Iterator;

public class ApplicationStateMonitor {
    private static long LAST_TRACK_FORCEGROUND_EVENT = 0;
    private static ApplicationStateMonitor instance;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final ArrayList<ApplicationStateListener> applicationStateListeners = new ArrayList<>();
    private int count;
    private final Object foregroundLock = new Object();
    private boolean foregrounded = true;

    public void uiHidden() {
    }

    private ApplicationStateMonitor() {
        log.info("Application state monitor has started");
    }

    public static synchronized ApplicationStateMonitor getInstance() {
        ApplicationStateMonitor applicationStateMonitor;
        synchronized (ApplicationStateMonitor.class) {
            if (instance == null) {
                instance = new ApplicationStateMonitor();
            }
            applicationStateMonitor = instance;
        }
        return applicationStateMonitor;
    }

    public void addApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.applicationStateListeners) {
            this.applicationStateListeners.add(applicationStateListener);
        }
    }

    public void activityStopped() {
        synchronized (this.foregroundLock) {
            int i = this.count - 1;
            this.count = i;
            if (i == 0) {
                log.info("UI has become hidden (app backgrounded)");
                notifyApplicationInBackground();
                this.foregrounded = false;
            }
        }
    }

    public void activityStarted() {
        synchronized (this.foregroundLock) {
            if (this.count == 0) {
                trackForcegroundEvent();
                log.verbose("Application appears to be in the foreground");
                notifyApplicationInForeground();
                this.foregrounded = true;
            }
            this.count++;
        }
    }

    private void notifyApplicationInBackground() {
        ArrayList arrayList;
        log.verbose("Application appears to have gone to the background");
        synchronized (this.applicationStateListeners) {
            arrayList = new ArrayList(this.applicationStateListeners);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationBackgrounded(applicationStateEvent);
        }
    }

    private void notifyApplicationInForeground() {
        ArrayList arrayList;
        synchronized (this.applicationStateListeners) {
            arrayList = new ArrayList(this.applicationStateListeners);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationForegrounded(applicationStateEvent);
        }
    }

    public boolean isForegrounded() {
        return this.foregrounded;
    }

    private void trackForcegroundEvent() {
        if (System.currentTimeMillis() - LAST_TRACK_FORCEGROUND_EVENT > 3600000) {
            Tracker.trackEvent("omg_lag_open");
            Tracker.trackEvent("omg_anr_open");
            LAST_TRACK_FORCEGROUND_EVENT = System.currentTimeMillis();
        }
    }
}
