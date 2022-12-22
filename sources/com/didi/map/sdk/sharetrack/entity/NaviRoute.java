package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.proto.driver_gl.PickupHint;
import com.didi.map.sdk.sharetrack.delegate.INaviRouteDelegate;
import java.util.List;

public class NaviRoute {

    /* renamed from: a */
    private INaviRouteDelegate f28643a;

    public NaviRoute(INaviRouteDelegate iNaviRouteDelegate) {
        this.f28643a = iNaviRouteDelegate;
    }

    public INaviRouteDelegate getDelegate() {
        return this.f28643a;
    }

    public List<LatLng> getRoutePoints() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRoutePoints();
    }

    public List<String> getRoadNames() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRoadNames();
    }

    public String getDistanceInfo() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getDistanceInfo();
    }

    public int getTime() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return 0;
        }
        return iNaviRouteDelegate.getTime();
    }

    public List<WayPoint> getWayPoints() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getWayPoints();
    }

    public int getSegmentSize() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return 0;
        }
        return iNaviRouteDelegate.getSegmentSize();
    }

    public int getSegmentDistance(int i) {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return 0;
        }
        return iNaviRouteDelegate.getSegmentDistance(i);
    }

    public boolean hasFeeSegment() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return false;
        }
        return iNaviRouteDelegate.hasFeeSegment();
    }

    public LatLng getRouteStartPoint() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRouteStartPoint();
    }

    public LatLng getRouteDestPoint() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRouteDestPoint();
    }

    public boolean isRouteTypePersonal() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return false;
        }
        return iNaviRouteDelegate.isRouteTypePersonal();
    }

    public String getRouteRecommendMsg() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRouteRecommendMsg();
    }

    public LineOptions.MultiColorLineInfo[] getLineColorInfos() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getLineColorInfos();
    }

    public String getRouteId() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRouteId();
    }

    public List<LatLng> getTrafficInsertPoint() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getTrafficInsertPoint();
    }

    public List<Integer> getRouteTrafficIndex() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return null;
        }
        return iNaviRouteDelegate.getRouteTrafficIndex();
    }

    public int getDstRouteGeoIndex() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null) {
            return -1;
        }
        return iNaviRouteDelegate.getDstRouteGeoIndex();
    }

    public String getNavEndPlaceId() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        return iNaviRouteDelegate != null ? iNaviRouteDelegate.getNavEndPlaceId() : "";
    }

    public PickupHint getPickupHint() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate != null) {
            return iNaviRouteDelegate.getPickUpHint();
        }
        return null;
    }

    public boolean isNearby() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate != null) {
            return iNaviRouteDelegate.isNearby();
        }
        return false;
    }

    public int getParkingStatus() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate != null) {
            return iNaviRouteDelegate.getParkingStatus();
        }
        return 0;
    }

    public boolean isShowPickUpGuideLine() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate == null || iNaviRouteDelegate.getNaviAddtionalLine() != 1) {
            return false;
        }
        return true;
    }

    public boolean avoidTolls() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate != null) {
            return iNaviRouteDelegate.avoidTolls();
        }
        return false;
    }

    public boolean routeShorter() {
        INaviRouteDelegate iNaviRouteDelegate = this.f28643a;
        if (iNaviRouteDelegate != null) {
            return iNaviRouteDelegate.routeShorter();
        }
        return false;
    }
}
