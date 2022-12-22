package com.didichuxing.omega.sdk.analysis.duration;

import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OmegaPageDuration {
    private static final String TAG = "OMGDE";
    private List<DurationEvent> durationEvents = new ArrayList();
    private String pageName;

    public static void setLoggable(boolean z) {
    }

    public OmegaPageDuration(String str) {
        this.pageName = str;
    }

    public void startDurationStatistics(String str) {
        boolean z = false;
        for (DurationEvent mainName : this.durationEvents) {
            if (mainName.getMainName().equals(str)) {
                z = true;
            }
        }
        if (!z) {
            this.durationEvents.add(new DurationEvent(str));
            if (OmegaConfig.LOG_PAGE_DURATION) {
                SystemUtils.log(3, TAG, "start main: " + logDurationEvents(this.durationEvents), (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 49);
            }
        } else if (OmegaConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, TAG, str + " has start already! ", (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 53);
        }
    }

    public void startDurationStatistics(String str, String str2) {
        boolean z = false;
        for (DurationEvent next : this.durationEvents) {
            if (next.getMainName().equals(str)) {
                next.startSub(str2);
                z = true;
            }
        }
        if (!OmegaConfig.LOG_PAGE_DURATION) {
            return;
        }
        if (!z) {
            SystemUtils.log(3, TAG, str + " has NOT start, should start main first. ", (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 75);
            return;
        }
        SystemUtils.log(3, TAG, "start sub: " + logDurationEvents(this.durationEvents), (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 77);
    }

    public void endDurationStatistics(String str) {
        boolean z = false;
        for (DurationEvent next : this.durationEvents) {
            if (next.getMainName().equals(str)) {
                z = true;
                next.endMain();
            }
        }
        if (!OmegaConfig.LOG_PAGE_DURATION) {
            return;
        }
        if (!z) {
            SystemUtils.log(3, TAG, str + " has NOT start, you should start first! ", (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 97);
            return;
        }
        SystemUtils.log(3, TAG, "end main: " + logDurationEvents(this.durationEvents), (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 99);
    }

    public void endDurationStatistics(String str, String str2) {
        boolean z = false;
        for (DurationEvent next : this.durationEvents) {
            if (next.getMainName().equals(str)) {
                z = true;
                next.endSub(str2);
            }
        }
        if (!OmegaConfig.LOG_PAGE_DURATION) {
            return;
        }
        if (!z) {
            SystemUtils.log(3, TAG, str + " has NOT start, you should start first! ", (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 120);
            return;
        }
        SystemUtils.log(3, TAG, "end sub: " + logDurationEvents(this.durationEvents), (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 122);
    }

    public void commitDurationStatistics() {
        Iterator<DurationEvent> it = this.durationEvents.iterator();
        while (it.hasNext()) {
            DurationEvent next = it.next();
            long mainTime = next.getMainTime();
            if (0 < mainTime && mainTime < 86400000) {
                Event event = new Event(EventConst.Technology.PAGE_LAUNCH_TIME);
                event.putAttr("pn", this.pageName);
                event.putAttr(ParamConst.PARAM_OMEGA_PAGE_RENDERING_TIME, Long.valueOf(mainTime));
                event.putAttr(ParamConst.PARAM_OMEGA_PAGE_NAME, next.getMainName());
                event.putAttr("sub_events_time", next.getSubInfoInJson());
                event.putAttr("nt", NetworkCollector.getNetworkType());
                Tracker.trackEvent(event);
                if (OmegaConfig.LOG_PAGE_DURATION) {
                    SystemUtils.log(3, TAG, "commit : " + event.toString(), (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.OmegaPageDuration", 144);
                }
            }
            it.remove();
        }
    }

    private String logDurationEvents(List<DurationEvent> list) {
        if (list == null || list.size() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (DurationEvent durationEvent : list) {
            sb.append(durationEvent.toString());
        }
        return sb.toString();
    }
}
