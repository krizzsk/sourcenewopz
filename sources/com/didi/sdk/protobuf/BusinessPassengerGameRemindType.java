package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum BusinessPassengerGameRemindType implements ProtoEnum {
    GameRemindType_Game(0),
    GameRemindType_RedBackground(1),
    GameRemindType_WhiteBackground(2);
    
    private final int value;

    private BusinessPassengerGameRemindType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
