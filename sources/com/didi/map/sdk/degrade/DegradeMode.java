package com.didi.map.sdk.degrade;

import com.sdk.poibase.model.RpcPoiBaseInfo;

public enum DegradeMode {
    GOOGLE("gmap"),
    DIDI(RpcPoiBaseInfo.MAP_TYPE_DIDI),
    EMPTY("empty"),
    HUAWEI("hmap");
    
    private final String name;

    private DegradeMode(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
