package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.TaxiChargeType */
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
