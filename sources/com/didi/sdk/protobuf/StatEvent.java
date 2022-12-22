package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum StatEvent implements ProtoEnum {
    kStatEventSend(0),
    kStatEventRecv(1),
    kStatEventView(2);
    
    private final int value;

    private StatEvent(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
