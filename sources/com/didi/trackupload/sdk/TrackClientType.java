package com.didi.trackupload.sdk;

import com.didi.trackupload.sdk.datachannel.protobuf.ClientType;

public enum TrackClientType {
    PASSENGER(ClientType.PASSENGER),
    PASSENGER_CARMATE(ClientType.PASSENGER_CARMATE),
    PASSENGER_ENTERPRISE(ClientType.PASSENGER_ENTERPRISE),
    DRIVER(ClientType.DRIVER),
    DRIVER_GLOBAL(ClientType.DRIVER_GLOBAL),
    DRIVER_BRAZIL(ClientType.DRIVER_BRAZIL),
    DRIVER_MEXICO(ClientType.DRIVER_MEXICO),
    DRIVER_AUSTRALIA(ClientType.DRIVER_AUSTRALIA),
    DRIVER_JAPAN(ClientType.DRIVER_JAPAN),
    DRIVER_HEAT(ClientType.DRIVER_HEAT),
    PASSENGER_GLOBAL(ClientType.PASSENGER_GLOBAL);
    
    private ClientType mValue;

    private TrackClientType(ClientType clientType) {
        this.mValue = clientType;
    }

    public ClientType getProtoValue() {
        return this.mValue;
    }
}
