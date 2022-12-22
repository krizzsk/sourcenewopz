package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum VoiceTargetKindEnum implements ProtoEnum {
    VoiceTargetKind_Intersection(0),
    VoiceTargetKind_Camera(1),
    VoiceTargetKind_WarningSign(2),
    VoiceTargetKind_SA(3),
    VoiceTargetKind_Tollgate(4),
    VoiceTargetKind_Tunnel(5),
    VoiceTargetKind_Traffic(6),
    VoiceTargetKind_Heart(7),
    VoiceTargetKind_Opening(8),
    VoiceTargetKind_PassLight(9),
    VoiceTargetKind_FCross(10),
    VoiceTargetKind_Destination(11),
    VoiceTargetKind_CameraLimitSpeedSection(500),
    VoiceTargetKind_LimitRoadSection(501),
    VoiceTargetKind_Alternative(1000),
    VoiceTargetKind_Other(10000);
    
    private final int value;

    private VoiceTargetKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
