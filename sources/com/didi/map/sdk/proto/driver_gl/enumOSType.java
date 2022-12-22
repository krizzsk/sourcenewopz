package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum enumOSType implements ProtoEnum {
    Android(1),
    IOS(2),
    WebApp(3);
    
    private final int value;

    private enumOSType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
