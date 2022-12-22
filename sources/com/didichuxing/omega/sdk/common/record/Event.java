package com.didichuxing.omega.sdk.common.record;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.analysis.AnalysisDelegater;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.ActivityCollector;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.util.HashMap;
import java.util.Map;

public class Event {
    private Map<String, Object> eventmap;

    public void putScreenshot() {
    }

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
            OLog.m34763e("Event:" + getEventId() + "'s attr:" + str + " is NOT type of Number or String or Boolean.");
        }
    }

    public <T> void removeAttr(String str) {
        Map map = (Map) this.eventmap.get("ex");
        if (map != null) {
            map.remove(str);
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
                        OLog.m34763e("Event:" + getEventId() + "'s attr:" + ((String) entry.getKey()) + " is NOT type of Number or String or Boolean.");
                    }
                }
            }
        }
    }

    public Map<String, Object> getAllAttrs() {
        return (Map) this.eventmap.get("ex");
    }

    public void setFrom(String str) {
        this.eventmap.put("f", str);
    }

    public String getFrom() {
        return (String) this.eventmap.get("f");
    }

    public void setSeq(long j) {
        this.eventmap.put("q", Long.valueOf(j));
    }

    public long getSeq() {
        return CommonUtil.parseLong(this.eventmap.get("q"));
    }

    public long getMid() {
        return CommonUtil.parseLong(this.eventmap.get("mid"));
    }

    public void setSessionId() {
        putAttr(Constants.JSON_KEY_PRISM_SID, CustomCollector.getNewSessionId());
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

    public static Event fromJson(String str) {
        Map<String, Object> json2Map = JsonUtil.json2Map(str);
        if (json2Map == null) {
            OLog.m34769w("fromJson fail.");
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

    public void putNetType() {
        Security.putNetType(this);
    }

    public void putWifiSsid() {
        putAttr("ws", NetworkCollector.getWifiSsid());
    }

    public void putMemInfo() {
        Security.putMemInfo(this);
    }

    public void putBatteryInfo() {
        Security.putBatteryInfo(this);
    }

    public void putPageName() {
        String curActivityPage = ActivityCollector.getCurActivityPage();
        String currentFramentName = AnalysisDelegater.getCurrentFramentName();
        String encryptBlackItem = OmegaConfig.encryptBlackItem(AnalysisDelegater.getCurrentPageName());
        if (!TextUtils.isEmpty(encryptBlackItem)) {
            putAttr("spn", encryptBlackItem);
        }
        String encryptBlackItem2 = OmegaConfig.encryptBlackItem(curActivityPage);
        if (!TextUtils.isEmpty(encryptBlackItem2)) {
            putAttr("rpn", encryptBlackItem2);
        }
        if (currentFramentName == null) {
            currentFramentName = encryptBlackItem2;
        }
        String encryptBlackItem3 = OmegaConfig.encryptBlackItem(currentFramentName);
        if (!TextUtils.isEmpty(encryptBlackItem3)) {
            putAttr("pn", encryptBlackItem3);
        }
    }

    private boolean checkAttrType(Object obj) {
        return (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean);
    }

    public void putGpsLocation() {
        Security.putGpsLocation(this);
    }
}
