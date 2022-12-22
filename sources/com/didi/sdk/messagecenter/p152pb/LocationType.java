package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.LocationType */
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
