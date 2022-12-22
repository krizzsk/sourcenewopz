package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.GulfstreamOrderType */
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
