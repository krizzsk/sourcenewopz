package com.didi.sdk.push.common;

public class PushAckParams {
    public static final int STATE_ARRIVED = 2;
    public static final int STATE_ARRIVED_PASS = 3;
    public static final int STATE_CLICK = 4;
    public int appType;
    public String host;
    public String pId;
    public int state;
    public String testHost;
    public String token;

    public String toString() {
        return "PushAckParams{pId=" + this.pId + ", state=" + this.state + ", appType=" + this.appType + ", token='" + this.token + '\'' + '}';
    }
}
