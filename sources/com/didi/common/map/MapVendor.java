package com.didi.common.map;

import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.io.Serializable;

public enum MapVendor implements Serializable {
    TENCENT(RpcPoiBaseInfo.MAP_TYPE_TENCENT),
    AMAP(RpcPoiBaseInfo.MAP_TYPE_GAODE),
    GOOGLE("gmap"),
    DIDI(RpcPoiBaseInfo.MAP_TYPE_DIDI),
    G_DIDI("g_dmap"),
    NUTITEQ("ntmap"),
    HUAWEI("hmap"),
    Empty("empty");
    
    private final String name;

    private MapVendor(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
