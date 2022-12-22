package com.sdu.didi.protobuf;

import com.squareup.wire.ProtoEnum;

public enum NetworkState implements ProtoEnum {
    NET_WIFI(1),
    NET_2G(2),
    NET_3G(3),
    NET_4G(4),
    NET_5G(5),
    NET_UNKNOWN(6);
    
    private final int value;

    private NetworkState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
