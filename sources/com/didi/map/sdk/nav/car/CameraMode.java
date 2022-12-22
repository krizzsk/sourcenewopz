package com.didi.map.sdk.nav.car;

public enum CameraMode {
    NORTH_UP(1),
    CAR_HEAD_UP(2);
    
    public int mode;

    private CameraMode(int i) {
        this.mode = i;
    }
}
