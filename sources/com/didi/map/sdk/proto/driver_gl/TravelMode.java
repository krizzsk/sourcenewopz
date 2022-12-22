package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum TravelMode implements ProtoEnum {
    DRIVING(0),
    WALKING(1),
    BYCYCLING(2),
    TWOWHEELER(3);
    
    private final int value;

    private TravelMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
