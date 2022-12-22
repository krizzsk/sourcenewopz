package com.didichuxing.routesearchsdk;

import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.io.Serializable;

public enum CallFrom implements Serializable {
    UNKNOWN("unknown"),
    ORDERROUTEAPI_BROADCAST("OrderRouteAPI_broadcast"),
    ORDERROUTEAPI_BUBBLE("OrderRouteAPI_bubble"),
    ORDERROUTEAPI_BUBBLE_WAYPOINT("OrderRouteAPI_bubble_waypoint"),
    ORDERROUTEAPI_DRIVER_DISPATCH("OrderRouteAPI_driver_dispatch"),
    ORDERROUTEAPI_SODA("OrderRouteAPI_soda"),
    ORDERROUTEAPI_SODA_BICYCLE("OrderRouteAPI_soda_bicycle"),
    ORDERROUTEAPI_SODA_WALK("OrderRouteAPI_soda_walk"),
    ORDERROUTEAPI_VAMOS("OrderRouteApi_Vamos"),
    ORDERROUTEAPI_MINBUS_BROADCAST("OrderRouteAPI_minbus_broadcast"),
    ORDERROUTEAPI_MINBUS_BUBBULE("OrderRouteAPI_minbus_bubble"),
    ORDERROUTEAPI("OrderRouteAPI"),
    AMAP(RpcPoiBaseInfo.MAP_TYPE_GAODE),
    ORDERROUTEAPI_WALK("OrderRouteAPI_walk");
    
    private final String name;

    private CallFrom(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(CallFrom callFrom) {
        return callFrom != null && callFrom.toString().equals(this.name);
    }
}
