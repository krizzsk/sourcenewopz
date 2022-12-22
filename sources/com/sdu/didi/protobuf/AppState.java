package com.sdu.didi.protobuf;

import com.squareup.wire.ProtoEnum;

public enum AppState implements ProtoEnum {
    FOREGROUND_ACTIVE(1),
    FOREGROUND_INACTIVE(2),
    BACKGROUND(3);
    
    private final int value;

    private AppState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
