package com.didichuxing.mas.sdk.quality.report.analysis;

import android.os.Process;
import android.text.TextUtils;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Tracker {
    private static AtomicLong eventSeq = new AtomicLong(Long.valueOf(seq).longValue());
    private static Map<String, Object> globalAttrs = new ConcurrentHashMap();
    private static String seq = (getPid() + ((System.currentTimeMillis() / 1000) % 100000) + "0");
    private static CopyOnWriteArrayList<TrackListener> trackListeners = new CopyOnWriteArrayList<>();

    public static void trackEvent(String str) {
        trackEvent(str, "");
    }

    public static void trackEvent(String str, String str2) {
        trackEvent(str, str2, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        if (str == null) {
            OLog.m34418e("invalid event, event is null");
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

    private static void safeTrackEvent(final Event event, float f) {
        if (MASConfig.IS_INIT && MASConfig.SWITCH_EVENT) {
            if (event == null || event.getEventId() == null || event.getEventId().length() == 0) {
                OLog.m34418e("trackEvent fail! event is null.");
                return;
            }
            String eventId = event.getEventId();
            if (MASConfig.DEBUG_MODEL || !EventFilter.filter(event)) {
                Map<String, Integer> special = EventFilter.getSpecial(eventId);
                final boolean z = false;
                if (special != null) {
                    Integer num = special.get(RavenKey.STACK);
                    if (num == null || EventFilter.isSampled(eventId, ((float) num.intValue()) / 10000.0f)) {
                        Integer num2 = special.get("r");
                        if (num2 != null && num2.intValue() == 1) {
                            z = true;
                        }
                        Integer num3 = special.get(RavenConfigKey.PHONE);
                        if (num3 != null) {
                            if ((num3.intValue() & 1) > 0) {
                                event.putNetType();
                            }
                            if ((num3.intValue() & 2) > 0) {
                                event.putMemInfo();
                            }
                            if ((num3.intValue() & 4) > 0) {
                                event.putScreenshot();
                            }
                            if ((num3.intValue() & 8) > 0) {
                                event.putBatteryInfo();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (f >= 1.0f || EventFilter.isSampled(eventId, f)) {
                    Map<String, Object> map = globalAttrs;
                    if (map != null) {
                        event.putAllAttrs(map);
                    }
                    event.setSeq(eventSeq.getAndIncrement());
                    C158381 r6 = new Runnable() {
                        public void run() {
                            EventSendQueue.add(event);
                            if (z) {
                                EventRealtimeQueue.add(event);
                            }
                        }
                    };
                    if (z) {
                        r6.run();
                    } else {
                        ThreadTaskObject.execute(r6);
                    }
                    Iterator<TrackListener> it = trackListeners.iterator();
                    while (it.hasNext()) {
                        it.next().afterTrackEvent(event);
                    }
                }
            }
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

    public static void trackGood(String str, Throwable th) {
        Event event = new Event("OMGGood", str);
        if (th != null) {
            event.putAttr("et", th.getClass().getName());
            event.putAttr("em", th.getMessage());
            event.putAttr("etc", CommonUtil.getTraceInfo(th));
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
            OLog.m34418e("trackCounter fail. counterId is empty.");
        } else {
            CounterStorage.incrementCounter(str);
        }
    }

    private static String getPid() {
        int myPid = Process.myPid();
        String valueOf = String.valueOf(myPid);
        if (valueOf.length() <= 3) {
            return valueOf;
        }
        return String.valueOf(myPid % 1000);
    }
}
