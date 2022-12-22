package com.didi.sdk.push.manager;

import java.util.Arrays;

public class DPushBody {
    private long activityId;
    private byte[] data;
    private Long pid;
    private String topic;

    public DPushBody(String str, byte[] bArr) {
        this.topic = str;
        this.data = bArr;
    }

    public DPushBody() {
    }

    public Long getPid() {
        return this.pid;
    }

    public void setPid(Long l) {
        this.pid = l;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long j) {
        this.activityId = j;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public String toString() {
        return "DPushBody{topic='" + this.topic + '\'' + ", data=" + Arrays.toString(this.data) + ", activityId=" + this.activityId + ", pid=" + this.pid + '}';
    }
}
