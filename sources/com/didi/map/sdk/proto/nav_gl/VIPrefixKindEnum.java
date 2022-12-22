package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum VIPrefixKindEnum implements ProtoEnum {
    VIPrefixKind_Null(0),
    VIPrefixKind_Ding(1),
    VIPrefixKind_Passed(2);
    
    private final int value;

    private VIPrefixKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
