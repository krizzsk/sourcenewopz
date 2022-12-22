package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum OldRole implements ProtoEnum {
    OldUnknown(0),
    OldDriver(1),
    OldPassenger(2),
    OldPilot(3);
    
    private final int value;

    private OldRole(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
