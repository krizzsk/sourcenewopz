package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum CoordinateType implements ProtoEnum {
    BD_09(1),
    GCJ_02(2),
    WGS_84(4),
    UNKNOWN(-1);
    
    private final int value;

    private CoordinateType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
