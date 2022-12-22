package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum VoiceDistanceKindEnum implements ProtoEnum {
    VoiceDistanceKind_Null(0),
    VoiceDistanceKind_Round0(1),
    VoiceDistanceKind_Far(2),
    VoiceDistanceKind_Middle(3),
    VoiceDistanceKind_Near(4),
    VoiceDistanceKind_Act(5);
    
    private final int value;

    private VoiceDistanceKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
