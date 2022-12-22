package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.CoordinateType */
public enum CoordinateType implements ProtoEnum {
    BD_09(1),
    GCJ_02(2),
    WGS_84(4);
    
    private final int value;

    private CoordinateType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
