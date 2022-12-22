package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum VICondAttrEnum implements ProtoEnum {
    VICondAttr_Speed(1),
    VICondAttr_RepeatPlaySecondsAtSampeState(2),
    VICondAttr_DriveDistance(4),
    VICondAttr_DriveTime(8),
    VICondAttr_RouteGetTime(16);
    
    private final int value;

    private VICondAttrEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
