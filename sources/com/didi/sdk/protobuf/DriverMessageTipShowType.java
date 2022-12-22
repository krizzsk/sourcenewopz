package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum DriverMessageTipShowType implements ProtoEnum {
    DriverMessageTipShowTypeWindow(1),
    DriverMessageTipShowTypeBubble(2),
    DriverMessageTipShowTypePic(3);
    
    private final int value;

    private DriverMessageTipShowType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
