package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum WalkState implements ProtoEnum {
    STATE_STANDING(0),
    STATE_WALKING(1),
    STATE_RUNNING(2);
    
    private final int value;

    private WalkState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
