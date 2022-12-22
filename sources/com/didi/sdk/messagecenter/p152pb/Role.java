package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.Role */
public enum Role implements ProtoEnum {
    Driver(0),
    Passenger(1),
    Pilot(2),
    ESPassenger(3),
    WaliDriver(5);
    
    private final int value;

    private Role(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
