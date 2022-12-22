package com.didi.sdk.connectivity;

enum ConnectivityStatus {
    UNKNOWN(0),
    UNREACHABLE(1),
    REACHABLE(2);
    
    private int value;

    private ConnectivityStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
