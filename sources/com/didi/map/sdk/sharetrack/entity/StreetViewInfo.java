package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class StreetViewInfo {
    public int eventListSize = 0;
    public boolean isArrived;
    public boolean isInTheLastEvent;
    public int lastDistance = Integer.MAX_VALUE;
    public LatLng lastEventPoint;
    public List<LatLng> lastTwoEventPoint;
    public LatLng mLastRoutePoint;
    public LatLng mMatchedPoint;
    public LatLng mOriginPoint;
    public int realEDA;

    public String toString() {
        return "StreetViewInfo{realEDA=" + this.realEDA + ", isInTheLastEvent=" + this.isInTheLastEvent + ", isArrived=" + this.isArrived + ", mOriginPoint=" + this.mOriginPoint + ", mMatchedPoint=" + this.mMatchedPoint + ", lastDistance=" + this.lastDistance + ", eventListSize=" + this.eventListSize + ", mLastRoutePoint=" + this.mLastRoutePoint + ", lastEventPoint=" + this.lastEventPoint + '}';
    }
}
