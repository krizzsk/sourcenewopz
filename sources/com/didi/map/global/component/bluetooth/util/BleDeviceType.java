package com.didi.map.global.component.bluetooth.util;

public enum BleDeviceType {
    IOS("1"),
    ANDROID("2"),
    UNKNOWN("3");
    
    private final String type;

    private BleDeviceType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}
