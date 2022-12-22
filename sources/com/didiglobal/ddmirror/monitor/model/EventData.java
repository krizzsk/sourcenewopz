package com.didiglobal.ddmirror.monitor.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class EventData {
    @SerializedName("data")
    public HashMap<String, Object> data;
    @SerializedName("eventId")
    public String eventId;
    @SerializedName("eventTime")
    public long eventTime = System.currentTimeMillis();
    @SerializedName("eventType")
    public int eventType;

    public EventData(int i) {
        this.eventType = i;
    }

    public String getUnionId() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("e_&_");
        sb.append(this.eventType);
        if (this.eventId != null) {
            str = "_^_" + this.eventId;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
