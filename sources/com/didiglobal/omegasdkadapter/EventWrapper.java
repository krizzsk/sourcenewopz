package com.didiglobal.omegasdkadapter;

import com.didichuxing.omega.sdk.common.record.Event;
import java.util.Map;

public class EventWrapper {
    private Event event;
    private String eventId;
    private String eventLabel;
    private Map<String, Object> eventParams;
    private com.didichuxing.mas.sdk.quality.report.record.Event masEvent;

    public EventWrapper(String str) {
        this(str, (String) null, (Map<String, Object>) null);
    }

    public EventWrapper(Event event2) {
        this((String) null, (String) null, (Map<String, Object>) null, event2, (com.didichuxing.mas.sdk.quality.report.record.Event) null);
    }

    public EventWrapper(com.didichuxing.mas.sdk.quality.report.record.Event event2) {
        this((String) null, (String) null, (Map<String, Object>) null, (Event) null, event2);
    }

    public EventWrapper(String str, String str2) {
        this(str, str2, (Map<String, Object>) null);
    }

    public EventWrapper(String str, Map<String, Object> map) {
        this(str, (String) null, map);
    }

    public EventWrapper(String str, String str2, Map<String, Object> map) {
        this(str, str2, map, (Event) null, (com.didichuxing.mas.sdk.quality.report.record.Event) null);
    }

    public EventWrapper(String str, String str2, Map<String, Object> map, Event event2, com.didichuxing.mas.sdk.quality.report.record.Event event3) {
        this.eventId = str;
        this.eventLabel = str2;
        this.eventParams = map;
        this.event = event2;
        this.masEvent = event3;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public String getEventLabel() {
        return this.eventLabel;
    }

    public void setEventLabel(String str) {
        this.eventLabel = str;
    }

    public Map<String, Object> getEventParams() {
        return this.eventParams;
    }

    public void setEventParams(Map<String, Object> map) {
        this.eventParams = map;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event2) {
        this.event = event2;
    }

    public com.didichuxing.mas.sdk.quality.report.record.Event getMasEvent() {
        return this.masEvent;
    }

    public void setMasEvent(com.didichuxing.mas.sdk.quality.report.record.Event event2) {
        this.masEvent = event2;
    }
}
