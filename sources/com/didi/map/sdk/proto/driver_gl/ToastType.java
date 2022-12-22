package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum ToastType implements ProtoEnum {
    TrafficJam(1),
    TrafficRestriction(2),
    FutureTraffic(3),
    PictureJam(4),
    EventTypeAccident(21),
    EventTypeConstruction(22),
    EventTypeTrafficControl(23),
    EventTypeRoadClosure(24),
    EventTypeWater(25),
    TrafficRestrictionSelf(41),
    CommonDefault(61);
    
    private final int value;

    private ToastType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
