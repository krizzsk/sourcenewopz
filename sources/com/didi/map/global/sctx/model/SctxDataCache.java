package com.didi.map.global.sctx.model;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import java.util.List;

public class SctxDataCache {
    public boolean enableDrawLine = true;
    public boolean isDestModified;
    public boolean isExtendedAnimating;
    public boolean isFirstRecvRoutes = true;
    public boolean isRouteChanged;
    public boolean isSctxParamUpdated = false;
    public boolean isWaitingState;
    public long lastGetWayPointTime;
    public long lastReceiveRouteTime;
    public LatLng orderDestPoint;
    public String orderId;
    public LatLng orderPickupPoint;
    public int orderState;
    public List<LatLng> routePoints;
    public List<TrafficItem> trafficItems;
    public String userRole;
    public LatLng vamosDriverTripDestPoint;

    public void clear() {
        this.userRole = "";
        this.isFirstRecvRoutes = true;
        this.isExtendedAnimating = false;
        this.isDestModified = false;
    }
}
