package com.didichuxing.omega.sdk.analysis;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.corelink.LinkManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tracker {
    private static Map<String, Object> globalAttrs = new ConcurrentHashMap();
    private static CopyOnWriteArrayList<TrackListener> trackListeners = new CopyOnWriteArrayList<>();

    @Deprecated
    public static void trackGood(String str, Throwable th) {
    }

    public static void trackEvent(String str) {
        trackEvent(str, "");
    }

    public static void trackEvent(String str, String str2) {
        trackEvent(str, str2, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        if (str == null) {
            OLog.m34763e("invalid event, event is null");
            return;
        }
        Event event = new Event(str, str2);
        event.putAllAttrs(map);
        trackEvent(event);
    }

    public static void trackEvent(Event event) {
        safeTrackEvent(event, 1.0f);
    }

    @Deprecated
    public static void trackRealtimeEvent(Event event) {
        safeTrackEvent(event, 1.0f);
    }

    public static void trackEventSampled(Event event, float f) {
        safeTrackEvent(event, f);
    }

    private static void safeTrackEvent(Event event, float f) {
        LinkManager.track(event, f);
        Iterator<TrackListener> it = trackListeners.iterator();
        while (it.hasNext()) {
            it.next().afterTrackEvent(event);
        }
    }

    public static void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
        Event event = new Event("OMGError");
        if (map != null) {
            event.putAllAttrs(map);
        }
        if (str != null) {
            event.putAttr("mn", str);
        }
        event.putAttr("en", str2);
        event.putAttr("et", str3);
        event.putAttr("em", str4);
        trackEvent(event);
    }

    public static void trackError(String str, Throwable th) {
        trackError(str, (String) null, th);
    }

    public static void trackError(String str, String str2, Throwable th) {
        String str3;
        Event event = new Event("OMGError", str2);
        if (th != null) {
            if (str != null) {
                event.putAttr("mn", str);
            }
            String name = th.getClass().getName();
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage != null) {
                str3 = name + ": " + localizedMessage;
            } else {
                str3 = name;
            }
            event.putAttr("en", str3);
            event.putAttr("et", name);
            event.putAttr("em", CommonUtil.getTraceInfo(th));
        }
        trackEvent(event);
    }

    public static <T> void putGlobalAttr(String str, T t) {
        if (!TextUtils.isEmpty(str) && t != null) {
            globalAttrs.put(str, t);
        }
    }

    public static Object getGlobalAttr(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = globalAttrs) == null) {
            return null;
        }
        return map.get(str);
    }

    public static Map<String, Object> getGlobalAttrs() {
        return globalAttrs;
    }

    public static void removeGlobalAttr(String str) {
        globalAttrs.remove(str);
    }

    public static void addTrackListener(TrackListener trackListener) {
        trackListeners.add(trackListener);
    }

    public static void removeTrackListener(TrackListener trackListener) {
        if (trackListeners.contains(trackListener)) {
            trackListeners.remove(trackListener);
        }
    }

    public static void removeAllTrackListener() {
        trackListeners.clear();
    }

    public static void trackCounter(String str) {
        if (str == null || str.length() == 0) {
            OLog.m34763e("trackCounter fail. counterId is empty.");
        } else {
            CounterStorage.incrementCounter(str);
        }
    }
}
