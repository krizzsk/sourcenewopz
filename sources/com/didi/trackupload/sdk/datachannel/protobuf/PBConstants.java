package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum PBConstants implements ProtoEnum {
    kMagic(22612),
    kNodeTypeMask(15),
    kNodeTypeShiftBits(8);
    
    private final int value;

    private PBConstants(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
