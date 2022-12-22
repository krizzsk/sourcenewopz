package com.didi.map.global.component.streetview;

public enum StreetStatus {
    STREET_LOADING("street_loding"),
    STREET_LOAD_FAILS("street_load_fails"),
    STREET_LOAD_SUCCESS("street_load_success"),
    STREET_INVALID("street_invalid"),
    STREET_LOAD_TIMEOUT("street_timeout");

    private StreetStatus(String str) {
    }
}
