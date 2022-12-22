package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum NotifyMsgType implements ProtoEnum {
    PullNavi(1),
    PushTraffic(2);
    
    private final int value;

    private NotifyMsgType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
