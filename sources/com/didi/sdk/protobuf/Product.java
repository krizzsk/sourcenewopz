package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum Product implements ProtoEnum {
    ProductNone(0),
    ProductTaxi(257),
    ProductPrivate(258),
    ProductCarPool(259),
    ProductFast(260),
    ProdcutWali(261),
    ProductESP(262),
    ProductGOVP(263),
    ProductGOVD(264),
    ProductNova(268),
    ProductGalileo(269),
    ProductAmOil(270);
    
    private final int value;

    private Product(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
