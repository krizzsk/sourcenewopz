package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum TrafficPointKindEnum implements ProtoEnum {
    TPK_Slow(0),
    TPK_Jam(1),
    TPK_Accident(2),
    TPK_Police(3),
    TPK_DrunkDrivine(4),
    TPK_Construction(5),
    TPK_Danger(6),
    TPK_Water(7),
    TPK_Freeze(8),
    TPK_TrafficControl(9),
    TPK_Show(10),
    TPK_Other(11),
    TPK_FAST(12);
    
    private final int value;

    private TrafficPointKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
