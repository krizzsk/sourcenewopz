package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum EventKindEnum implements ProtoEnum {
    EventKind_Voice(0),
    EventKind_Display(1),
    EventKind_Behavior(2);
    
    private final int value;

    private EventKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
