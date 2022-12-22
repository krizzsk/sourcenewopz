package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum enumAppPage implements ProtoEnum {
    UnSet(0),
    LightNavi(1),
    FullNavi(2),
    Others(999);
    
    private final int value;

    private enumAppPage(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
