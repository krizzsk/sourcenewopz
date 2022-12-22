package com.sdu.didi.protobuf;

import com.squareup.wire.ProtoEnum;

public enum AppPage implements ProtoEnum {
    OTHERS(1),
    DRIVER_FULL_NAVI(2),
    DRIVER_LIGHT_NAVI(3);
    
    private final int value;

    private AppPage(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
