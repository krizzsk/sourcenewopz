package com.didi.map.sdk.env;

public enum PointType {
    START(0),
    END(1),
    WAY_POINT(2),
    OTHER(-1);
    
    private int type;

    private PointType(int i) {
        this.type = i;
    }

    public int getValue() {
        return this.type;
    }
}
