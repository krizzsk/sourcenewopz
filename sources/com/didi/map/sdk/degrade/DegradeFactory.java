package com.didi.map.sdk.degrade;

public class DegradeFactory {
    public static IDegradeToggle create() {
        return new DegradeToggleImpl();
    }
}
