package com.didi.sdk.push;

public enum RouteType {
    RANDOM_ADDRESS(0),
    MULTI_ADDRESS(1),
    FIRST_ADDRESS(2);
    
    private int value;

    private RouteType(int i) {
        this.value = i;
    }

    public static RouteType valueOf(int i) {
        if (i == 0) {
            return RANDOM_ADDRESS;
        }
        if (i == 1) {
            return MULTI_ADDRESS;
        }
        if (i != 2) {
            return RANDOM_ADDRESS;
        }
        return FIRST_ADDRESS;
    }
}
