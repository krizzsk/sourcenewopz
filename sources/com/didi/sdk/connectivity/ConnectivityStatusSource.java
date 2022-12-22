package com.didi.sdk.connectivity;

public enum ConnectivityStatusSource {
    UNKNOWN(0),
    TCP_CONNECT(1),
    REQUEST_SUCCESS(2),
    NETWORK_CHANGED(3);
    
    private int value;

    private ConnectivityStatusSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
