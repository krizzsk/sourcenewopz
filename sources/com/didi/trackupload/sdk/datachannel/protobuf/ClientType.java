package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum ClientType implements ProtoEnum {
    DRIVER(1),
    DRIVER_GLOBAL(2),
    PASSENGER(3),
    PASSENGER_CARMATE(4),
    DRIVER_BRAZIL(5),
    DRIVER_MEXICO(6),
    DRIVER_AUSTRALIA(7),
    DRIVER_JAPAN(8),
    PASSENGER_ENTERPRISE(9),
    DRIVER_HEAT(10),
    PASSENGER_GLOBAL(11);
    
    private final int value;

    private ClientType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static ClientType valueOf(int i) {
        for (ClientType clientType : values()) {
            if (clientType.value == i) {
                return clientType;
            }
        }
        return null;
    }
}
