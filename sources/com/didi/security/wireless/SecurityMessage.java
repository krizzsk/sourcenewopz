package com.didi.security.wireless;

public class SecurityMessage {
    public static final int WSG_MSG_TYPE_CMD = 3;
    public static final int WSG_MSG_TYPE_LOCAL = 1;
    public static final int WSG_MSG_TYPE_NET = 2;
    public String eventData;
    public String eventType;
    public int msgType;

    private SecurityMessage(int i, String str, String str2) {
        this.msgType = i;
        this.eventType = str;
        this.eventData = str2;
    }

    public static SecurityMessage obtainLocal(String str, String str2) {
        return new SecurityMessage(1, str, str2);
    }

    public static SecurityMessage obtainCmd(String str) {
        return new SecurityMessage(3, (String) null, str);
    }
}
