package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum NotifyType implements ProtoEnum {
    kRouteUpdate(1);
    
    private final int value;

    private NotifyType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
