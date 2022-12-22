package com.didichuxing.mas.sdk.quality.report.record;

import android.text.TextUtils;
import android.util.Base64;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.backend.BatteryChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.collector.ActivityCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.collector.MemoryCollector;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.HashMap;
import java.util.Map;

public class Event {
    private Map<String, Object> eventmap;

    public Event(String str) {
        this(str, (String) null);
    }

    public Event(String str, String str2) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            this.eventmap = hashMap;
            hashMap.put("e", str);
            this.eventmap.put("ts", Long.valueOf(System.currentTimeMillis()));
            if (str2 != null) {
                this.eventmap.put("l", str2);
            }
            this.eventmap.put("mid", Long.valueOf(PersistentInfoCollector.getMomentId()));
            return;
        }
        throw new IllegalArgumentException("EventId is null!");
    }

    public static Event fromJson(String str) {
        Map<String, Object> json2Map = JsonUtil.json2Map(str);
        if (json2Map == null) {
            OLog.m34424w("fromJson fail.");
            return null;
        }
        String str2 = (String) json2Map.get("e");
        if (str2 == null) {
            return null;
        }
        Event event = new Event(str2);
        event.eventMap().putAll(json2Map);
        return event;
    }

    public String getEventId() {
        return String.valueOf(this.eventmap.get("e"));
    }

    public long getTs() {
        return CommonUtil.parseLong(this.eventmap.get("ts"));
    }

    public <T> void putAttr(String str, T t) {
        Map map = (Map) this.eventmap.get("ex");
        if (map == null) {
            map = new HashMap();
            this.eventmap.put("ex", map);
        }
        if (t != null) {
            if (checkAttrType(t)) {
                map.put(str, t);
                return;
            }
            OLog.m34418e("Event:" + getEventId() + "'s attr:" + str + " is NOT type of Number or String or Boolean.");
        }
    }

    public <T> T getAttr(String str) {
        Map map = (Map) this.eventmap.get("ex");
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void putAllAttrs(Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            Map map2 = (Map) this.eventmap.get("ex");
            if (map2 == null) {
                map2 = new HashMap();
                this.eventmap.put("ex", map2);
            }
            for (Map.Entry entry : new HashMap(map).entrySet()) {
                if (entry.getValue() != null) {
                    if (checkAttrType(entry.getValue())) {
                        map2.put(entry.getKey(), entry.getValue());
                    } else {
                        OLog.m34418e("Event:" + getEventId() + "'s attr:" + ((String) entry.getKey()) + " is NOT type of Number or String or Boolean.");
                    }
                }
            }
        }
    }

    public Map<String, Object> getAllAttrs() {
        return (Map) this.eventmap.get("ex");
    }

    public String getFrom() {
        return (String) this.eventmap.get("f");
    }

    public void setFrom(String str) {
        this.eventmap.put("f", str);
    }

    public long getSeq() {
        return CommonUtil.parseLong(this.eventmap.get("q"));
    }

    public void setSeq(long j) {
        this.eventmap.put("q", Long.valueOf(j));
    }

    public long getMid() {
        return CommonUtil.parseLong(this.eventmap.get("mid"));
    }

    public Map<String, Object> eventMap() {
        return this.eventmap;
    }

    public String toString() {
        return toJson();
    }

    public String toJson() {
        return JsonUtil.map2Json(this.eventmap);
    }

    public void putNetType() {
        putAttr("nt", NetworkCollector.getNetworkType());
    }

    public void putWifiSsid() {
        putAttr("ws", NetworkCollector.getWifiSsid());
    }

    public void putMemInfo() {
        putAttr("mi", MemoryCollector.getMemInfo());
    }

    public void putBatteryInfo() {
        putAttr("bi", Integer.valueOf(BatteryChangeReceiver.getBatteryPercent()));
        putAttr("bs", Integer.valueOf(BatteryChangeReceiver.getBatteryIsCharging() ? 1 : 0));
    }

    public void putScreenshot() {
        putAttr("ss", Base64.encodeToString(ActivityCollector.getScreenshot(), 0));
    }

    public void putPageName() {
        String curActivityPage = ActivityCollector.getCurActivityPage();
        String currentFramentName = AnalysisDelegater.getCurrentFramentName();
        String currentPageName = AnalysisDelegater.getCurrentPageName();
        if (!TextUtils.isEmpty(currentPageName)) {
            putAttr("spn", currentPageName);
        }
        putAttr("rpn", curActivityPage);
        if (currentFramentName != null) {
            curActivityPage = currentFramentName;
        }
        putAttr("pn", curActivityPage);
    }

    private boolean checkAttrType(Object obj) {
        return (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean);
    }

    public void putGpsLocation() {
        double[] location;
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation() && (location = LocationCollector.getLocation()) != null && location.length >= 2) {
            putAttr("lng", Double.valueOf(location[0]));
            putAttr("lat", Double.valueOf(location[1]));
        }
    }
}
