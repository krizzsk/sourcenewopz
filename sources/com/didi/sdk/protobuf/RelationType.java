package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum RelationType implements ProtoEnum {
    kRelationTypeRealTime(0),
    kRelationTypeReservation(1);
    
    private final int value;

    private RelationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
