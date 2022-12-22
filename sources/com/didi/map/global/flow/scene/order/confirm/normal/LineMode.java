package com.didi.map.global.flow.scene.order.confirm.normal;

public enum LineMode {
    MODE_ARC("arc"),
    MODE_SINGLE_ROUTE("single_route"),
    MODE_MULTI_ROUTE("multi_route"),
    MODE_NONE("none");
    
    private String mName;

    private LineMode(String str) {
        this.mName = str;
    }

    public String toString() {
        return this.mName;
    }
}
