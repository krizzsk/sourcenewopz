package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum Role implements ProtoEnum {
    Driver(0),
    Passenger(1),
    Pilot(2),
    ESPassenger(3),
    WaliDriver(5),
    GalileoDriver(7),
    GovDriver(25);
    
    private final int value;

    private Role(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
