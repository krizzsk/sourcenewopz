package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum LocationType implements ProtoEnum {
    LOC_GPS(1),
    LOC_NET(2),
    LOC_OTHER(3);
    
    private final int value;

    private LocationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
