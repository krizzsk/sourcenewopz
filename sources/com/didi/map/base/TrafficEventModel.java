package com.didi.map.base;

import com.didi.map.common.TrafficEventManager;
import java.io.Serializable;

public class TrafficEventModel implements Serializable {
    public long event_id;
    public double event_lat;
    public double event_lng;
    public int event_priority;
    public long event_time;
    public int event_type;

    public String toString() {
        return "TrafficEventModel:" + "event_id=" + this.event_id + "event_time=" + TrafficEventManager.getInstance().getDateTime(this.event_time) + "event_lng=" + this.event_lng + "event_lat=" + this.event_lat + "event_type=" + this.event_type;
    }
}
