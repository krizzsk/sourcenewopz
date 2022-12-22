package com.didichuxing.omega.sdk.analysis;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didichuxing.omega.sdk.UIAutoMarker;
import com.didichuxing.omega.sdk.UIAutoTracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.ActivityLifecycleRegister;
import com.didichuxing.omega.sdk.common.backend.BackendThread;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.prism.OmegaPrismMonitorListener;
import com.xiaojuchefu.prism.monitor.model.EventData;
import com.xiaojuchefu.prism.monitor.touch.WebviewEventHelper;
import java.util.ArrayList;
import java.util.List;

public class AnalysisActivityListener implements ActivityLifecycleRegister.ActivityLifecycleListener {
    private static List<AppStateListener> appStateListenerList = new ArrayList();
    private static volatile Activity mCurActivity;
    private static volatile int mFrontCount = 0;
    /* access modifiers changed from: private */
    public static long mLastAppInTs = 0;
    private static long pageDurationResume = 0;
    private static long timeStart;

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            reportOmgAppJump(activity);
        }
    }

    public void onActivityStarted(Activity activity) {
        int i = mFrontCount;
        mFrontCount = i + 1;
        if (i == 0 && !OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            reportOmgAppIn(activity, (EventData) null);
        }
    }

    public void onActivityStopped(Activity activity) {
        int i = mFrontCount;
        mFrontCount = i - 1;
        if (1 == i && !OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            reportOmgAppOut(activity, (EventData) null);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (!OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            reportOmgPageResume(activity, (EventData) null);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (!OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            reportOmgPagePause(activity, (EventData) null);
        }
    }

    public static void reportOmgAppJump(Activity activity) {
        timeStart = System.currentTimeMillis();
        Uri data = activity.getIntent().getData();
        if (data != null) {
            String uri = data.toString();
            if (uri.startsWith("omega")) {
                OmegaConfig.DEBUG_MODEL = true;
                BackendThread.getInstance().wakeup();
                String host = data.getHost();
                if (host != null && host.length() > 0) {
                    OmegaConfig.DEBUG_TEMP_OMEGA_ID = host;
                }
                WebviewEventHelper.startMonitor();
                OLog.m34765i("Start with debug, tempOid:" + host);
            }
            Event event = new Event("OMGAppJump");
            event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
            event.putAttr("url", uri);
            String encryptBlackItem = OmegaConfig.encryptBlackItem(CommonUtil.simplifyClassName(activity.getClass().getName()));
            if (!TextUtils.isEmpty(encryptBlackItem)) {
                event.putAttr("pn", encryptBlackItem);
            }
            event.setSessionId();
            Tracker.trackEvent(event);
        }
    }

    public static void reportOmgAppIn(final Activity activity, final EventData eventData) {
        AnalysisDelegater.setAppIn(true);
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                long unused = AnalysisActivityListener.mLastAppInTs = System.currentTimeMillis();
                PersistentInfoCollector.updateMomentId();
                PersistentInfoCollector.updateSession();
                Event event = new Event("OMGBecomeActive");
                event.putAttr("ub", OmegaConfig.isUnwind ? "un" : "br");
                event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
                String simplifyClassName = CommonUtil.simplifyClassName(activity.getClass().getName());
                String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
                String encryptBlackItem = OmegaConfig.encryptBlackItem(simplifyClassName);
                if (!TextUtils.isEmpty(encryptBlackItem)) {
                    event.putAttr("rpn", encryptBlackItem);
                }
                if (currentFramentName == null) {
                    currentFramentName = encryptBlackItem;
                }
                String encryptBlackItem2 = OmegaConfig.encryptBlackItem(currentFramentName);
                if (!TextUtils.isEmpty(encryptBlackItem2)) {
                    event.putAttr("pn", encryptBlackItem2);
                }
                event.putAttr("is", Integer.valueOf(PersistentInfoCollector.checkAndSaveStartup() ? 1 : 0));
                Security.putBecomeActiveInfo(event);
                Security.setBatteryStatusInfo();
                Security.putPageResumeInfo(event);
                event.putBatteryInfo();
                event.putNetType();
                event.setSessionId();
                OmegaPrismMonitorListener.setPrismAttr(event, eventData);
                Tracker.trackEvent(event);
            }
        }.start();
        applicationForegrounded();
    }

    public static void reportOmgAppOut(final Activity activity, final EventData eventData) {
        AnalysisDelegater.setAppIn(false);
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                PersistentInfoCollector.saveMomentTime();
                Event event = new Event("OMGEnterBackground");
                event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
                event.putAllAttrs(CounterStorage.getAllCounterAndClean());
                String simplifyClassName = CommonUtil.simplifyClassName(activity.getClass().getName());
                String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
                if (currentFramentName == null) {
                    currentFramentName = simplifyClassName;
                }
                String encryptBlackItem = OmegaConfig.encryptBlackItem(simplifyClassName);
                if (!TextUtils.isEmpty(encryptBlackItem)) {
                    event.putAttr("rpn", encryptBlackItem);
                }
                String encryptBlackItem2 = OmegaConfig.encryptBlackItem(currentFramentName);
                if (!TextUtils.isEmpty(encryptBlackItem2)) {
                    event.putAttr("pn", encryptBlackItem2);
                }
                long currentTimeMillis = System.currentTimeMillis() - AnalysisActivityListener.mLastAppInTs;
                if (currentTimeMillis > 7200000 || currentTimeMillis < 0) {
                    currentTimeMillis = 0;
                }
                event.putAttr("pd", Long.valueOf(currentTimeMillis));
                PersistentInfoCollector.saveStartupTime();
                event.putBatteryInfo();
                Security.putBatteryStatusInfo(event);
                event.putNetType();
                event.setSessionId();
                OmegaPrismMonitorListener.setPrismAttr(event, eventData);
                Tracker.trackEvent(event);
            }
        }.start();
        applicationBackgrounded();
    }

    public static void reportOmgPageResume(Activity activity, EventData eventData) {
        mCurActivity = activity;
        AnalysisFragmentListener.mFragmentName = null;
        pageDurationResume = System.currentTimeMillis();
        UIAutoTracker.activityResumed(activity);
        String name = activity.getClass().getName();
        if (!UIAutoMarker.inBlackPages(name)) {
            Event event = new Event("OMGPageResume");
            event.putAttr("ub", OmegaConfig.isUnwind ? "un" : "br");
            event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
            if (OmegaConfig.EX_SWITCH_BATTERY_MONITOR) {
                event.putBatteryInfo();
            }
            String encryptBlackItem = OmegaConfig.encryptBlackItem(name);
            if (!TextUtils.isEmpty(encryptBlackItem)) {
                event.putAttr("pn", encryptBlackItem);
            }
            if (timeStart != 0) {
                event.putAttr("tl", Long.valueOf(System.currentTimeMillis() - timeStart));
            }
            Security.putPageResumeInfo(event);
            OmegaPrismMonitorListener.setPrismAttr(event, eventData);
            Tracker.trackEvent(event);
        }
    }

    public static void reportOmgPagePause(Activity activity, EventData eventData) {
        long j = 0;
        timeStart = 0;
        mCurActivity = null;
        PersistentInfoCollector.saveTimeWhenPagePause();
        UIAutoTracker.activityPaused(activity);
        String name = activity.getClass().getName();
        if (!UIAutoMarker.inBlackPages(name)) {
            Event event = new Event("OMGPagePause");
            event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
            String encryptBlackItem = OmegaConfig.encryptBlackItem(name);
            if (!TextUtils.isEmpty(encryptBlackItem)) {
                event.putAttr("pn", encryptBlackItem);
            }
            long currentTimeMillis = System.currentTimeMillis() - pageDurationResume;
            if (currentTimeMillis <= 7200000 && currentTimeMillis >= 0) {
                j = currentTimeMillis;
            }
            event.putAttr("pd", Long.valueOf(j));
            OmegaPrismMonitorListener.setPrismAttr(event, eventData);
            Tracker.trackEvent(event);
        }
    }

    public static void addAppStateListener(AppStateListener appStateListener) {
        synchronized (appStateListenerList) {
            appStateListenerList.add(appStateListener);
        }
    }

    public static void removeAppStateListener(AppStateListener appStateListener) {
        synchronized (appStateListenerList) {
            appStateListenerList.remove(appStateListener);
        }
    }

    public static void applicationBackgrounded() {
        synchronized (appStateListenerList) {
            for (AppStateListener applicationBackgrounded : appStateListenerList) {
                applicationBackgrounded.applicationBackgrounded();
            }
        }
    }

    public static void applicationForegrounded() {
        synchronized (appStateListenerList) {
            for (AppStateListener applicationForegrounded : appStateListenerList) {
                applicationForegrounded.applicationForegrounded();
            }
        }
    }

    public static boolean isAppIn() {
        return mFrontCount > 0;
    }

    public static Activity getCurActivity() {
        return mCurActivity;
    }
}
