package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.OldRole */
public enum OldRole implements ProtoEnum {
    OldUnknown(0),
    OldDriver(1),
    OldPassenger(2),
    OldPilot(3);
    
    private final int value;

    private OldRole(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
