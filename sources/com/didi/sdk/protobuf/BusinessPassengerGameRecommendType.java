package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum BusinessPassengerGameRecommendType implements ProtoEnum {
    GameRecommendType_Html5(0),
    GameRecommendType_Native(1);
    
    private final int value;

    private BusinessPassengerGameRecommendType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
