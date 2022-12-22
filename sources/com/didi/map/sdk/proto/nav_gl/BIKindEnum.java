package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum BIKindEnum implements ProtoEnum {
    BIKind_Arrive(0),
    BIKind_Hint(1),
    BIKind_DownloadEnlargeMap(2);
    
    private final int value;

    private BIKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
