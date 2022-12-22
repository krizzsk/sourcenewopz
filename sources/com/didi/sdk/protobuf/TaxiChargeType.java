package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum TaxiChargeType implements ProtoEnum {
    kChargeTypeRoad(1),
    kChargeTypePrice(2);
    
    private final int value;

    private TaxiChargeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
