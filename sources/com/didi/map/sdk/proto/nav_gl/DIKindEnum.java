package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum DIKindEnum implements ProtoEnum {
    DIKind_Intersection(0),
    DIKind_EnlargeMap(1),
    DIKind_Tollgate(2),
    DIKind_Lane(3),
    DIKind_Tunnel(4),
    DIKind_Sa(5),
    DIKind_Junction(6),
    DIKind_WarningSign(7),
    DIKind_Camera(8),
    DIKind_LimitSpeedSection_Camera(9),
    DIKind_LimitSpeedSection_CameraContinues(10),
    DIKind_LimitSpeedSection_Road(11),
    DIKind_TrafficPoint(12),
    DIKind_Destination(13),
    DIKind_Marker(14);
    
    private final int value;

    private DIKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
