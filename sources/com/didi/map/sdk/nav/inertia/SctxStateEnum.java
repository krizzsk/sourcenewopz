package com.didi.map.sdk.nav.inertia;

public enum SctxStateEnum {
    IDLE(0),
    NORMAL(1),
    NOT_MOVE(2),
    NO_CAR_LOC_INERTIA(3),
    MATCH_FAIL_INERTIA(4),
    MATCH_SUCCESS_INERTIA(5),
    INERTIA_LIMIT(6),
    NETWORK_ERROR(7),
    WIFI_INERTIA(8),
    NETWORK_INERTIA(9),
    KEEP_NOW_ON_LIMIT(10);
    
    public int type;

    private SctxStateEnum(int i) {
        this.type = i;
    }
}
