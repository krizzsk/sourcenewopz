package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum GulfstreamOrderType implements ProtoEnum {
    NONCARPOOL(1),
    CARPOOL(2);
    
    private final int value;

    private GulfstreamOrderType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
