package com.didichuxing.mlcp.drtc.enums;

public enum DrtcMessageType {
    message,
    trickle,
    detach,
    destroy,
    keepalive,
    create,
    attach,
    event,
    error,
    ack,
    success,
    webrtcup,
    hangup,
    detached,
    leave,
    slowlink,
    timeout,
    media;

    public static DrtcMessageType fromString(String str) {
        return (DrtcMessageType) Enum.valueOf(DrtcMessageType.class, str.toLowerCase());
    }

    public boolean EqualsString(String str) {
        return toString().equals(str);
    }

    public String toString() {
        return name();
    }
}
