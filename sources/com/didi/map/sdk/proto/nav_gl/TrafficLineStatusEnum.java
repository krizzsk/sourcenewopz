package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum TrafficLineStatusEnum implements ProtoEnum {
    TLS_Unknow(0),
    TLS_Fast(1),
    TLS_Slow(2),
    TLS_Jam(3),
    TLS_Jamer(4);
    
    private final int value;

    private TrafficLineStatusEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
