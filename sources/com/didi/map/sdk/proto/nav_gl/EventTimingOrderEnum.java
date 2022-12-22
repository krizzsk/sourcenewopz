package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum EventTimingOrderEnum implements ProtoEnum {
    ETOrder_Null(0),
    ETOrder_BeginPosFirst(1),
    ETOrder_EndPosFirst(2);
    
    private final int value;

    private EventTimingOrderEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
