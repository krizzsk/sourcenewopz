package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum PassengerState implements ProtoEnum {
    PassengerStateNormal(0),
    PassengerStateHasPaidOff(1),
    PassengerStateHasCommented(2);
    
    private final int value;

    private PassengerState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
