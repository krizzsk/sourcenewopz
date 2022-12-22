package com.didi.sdk.push;

public enum PushRole {
    PSNGER(1),
    DRIVER(0);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    private PushRole(int i) {
        this.value = i;
    }
}
