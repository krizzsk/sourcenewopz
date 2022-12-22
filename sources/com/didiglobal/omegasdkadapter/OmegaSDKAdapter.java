package com.didiglobal.omegasdkadapter;

import android.app.Application;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaAdapterInterceptorManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class OmegaSDKAdapter {
    private static final String TAG = "ruanyandong";
    private static boolean sEnable;

    public static void init(Application application, boolean z) {
        sEnable = z;
        LogUtils.init(application);
    }

    public static void trackEvent(String str) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                OmegaSDK.trackEvent(str);
                return;
            }
            return;
        }
        OmegaSDK.trackEvent(str);
    }

    public static void trackEvent(String str, String str2) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str + " " + str2);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str, str2);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                OmegaSDK.trackEvent(str, eventWrapper.getEventLabel());
                return;
            }
            return;
        }
        OmegaSDK.trackEvent(str, str2);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str + " " + map);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str, map);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                OmegaSDK.trackEvent(str, eventWrapper.getEventParams());
                return;
            }
            return;
        }
        OmegaSDK.trackEvent(str, map);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str + " " + str2 + " " + map);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str, str2, map);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                OmegaSDK.trackEvent(str, eventWrapper.getEventLabel(), eventWrapper.getEventParams());
                return;
            }
            return;
        }
        OmegaSDK.trackEvent(str, str2, map);
    }

    public static void trackEvent(Event event) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + event);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(event);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEvent() != null && !TextUtils.isEmpty(eventWrapper.getEvent().getEventId()) && event != null && !TextUtils.isEmpty(event.getEventId()) && event.getEventId().equals(eventWrapper.getEvent().getEventId())) {
                OmegaSDK.trackEvent(eventWrapper.getEvent());
                return;
            }
            return;
        }
        OmegaSDK.trackEvent(event);
    }

    public static void trackMasEvent(String str) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                Tracker.trackEvent(str);
                return;
            }
            return;
        }
        Tracker.trackEvent(str);
    }

    public static void trackMasEvent(String str, String str2) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str + " " + str2);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str, str2);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                Tracker.trackEvent(str, eventWrapper.getEventLabel());
                return;
            }
            return;
        }
        Tracker.trackEvent(str, str2);
    }

    public static void trackMasEvent(String str, String str2, Map<String, Object> map) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + str + " " + str2 + " " + map);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(str, str2, map);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getEventId() != null && eventWrapper.getEventId().equals(str)) {
                Tracker.trackEvent(str, eventWrapper.getEventLabel(), eventWrapper.getEventParams());
                return;
            }
            return;
        }
        Tracker.trackEvent(str, str2, map);
    }

    public static void trackMasEvent(com.didichuxing.mas.sdk.quality.report.record.Event event) {
        LogUtils.m36222d(TAG, "trackEvent: 代码插入成功 " + event);
        if (sEnable) {
            CopyOnWriteArrayList<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> interceptors = OmegaAdapterInterceptorManager.getInstance().getInterceptors();
            EventWrapper eventWrapper = new EventWrapper(event);
            Iterator<OmegaAdapterInterceptorManager.OmegaAdapterInterceptor> it = interceptors.iterator();
            while (it.hasNext()) {
                OmegaAdapterInterceptorManager.OmegaAdapterInterceptor next = it.next();
                if (eventWrapper == null) {
                    break;
                }
                eventWrapper = next.intercept(eventWrapper);
            }
            if (eventWrapper != null && eventWrapper.getMasEvent() != null && !TextUtils.isEmpty(eventWrapper.getMasEvent().getEventId()) && event != null && !TextUtils.isEmpty(event.getEventId()) && event.getEventId().equals(eventWrapper.getMasEvent().getEventId())) {
                Tracker.trackEvent(eventWrapper.getMasEvent());
                return;
            }
            return;
        }
        Tracker.trackEvent(event);
    }
}
