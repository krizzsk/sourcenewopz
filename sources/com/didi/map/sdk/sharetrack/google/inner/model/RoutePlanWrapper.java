package com.didi.map.sdk.sharetrack.google.inner.model;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.LegInfo;
import com.didi.map.sdk.proto.driver_gl.PickupHint;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import com.didi.map.sdk.sharetrack.delegate.INaviRouteDelegate;
import com.didi.map.sdk.sharetrack.entity.WayPoint;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.RouteConverter;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanWrapper implements INaviRouteDelegate {

    /* renamed from: a */
    private RoutePlanRes f28825a;

    public /* synthetic */ boolean avoidTolls() {
        return INaviRouteDelegate.CC.$default$avoidTolls(this);
    }

    public LineOptions.MultiColorLineInfo[] getLineColorInfos() {
        return new LineOptions.MultiColorLineInfo[0];
    }

    public String getNavEndPlaceId() {
        return "";
    }

    public /* synthetic */ int getNaviAddtionalLine() {
        return INaviRouteDelegate.CC.$default$getNaviAddtionalLine(this);
    }

    public PickupHint getPickUpHint() {
        return null;
    }

    public List<String> getRoadNames() {
        return null;
    }

    public String getRouteRecommendMsg() {
        return null;
    }

    public List<Integer> getRouteTrafficIndex() {
        return null;
    }

    public int getSegmentDistance(int i) {
        return 0;
    }

    public int getSegmentSize() {
        return 0;
    }

    public List<LatLng> getTrafficInsertPoint() {
        return null;
    }

    public List<WayPoint> getWayPoints() {
        return null;
    }

    public boolean hasFeeSegment() {
        return false;
    }

    public boolean isRouteTypePersonal() {
        return false;
    }

    public /* synthetic */ boolean routeShorter() {
        return INaviRouteDelegate.CC.$default$routeShorter(this);
    }

    public RoutePlanWrapper(RoutePlanRes routePlanRes) {
        this.f28825a = routePlanRes;
    }

    public List<LatLng> getRoutePoints() {
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null) {
            return null;
        }
        return m20327a(routePlanRes);
    }

    /* renamed from: a */
    private List<LatLng> m20327a(RoutePlanRes routePlanRes) {
        double d;
        if (routePlanRes == null || routePlanRes.routeGeos == null || routePlanRes.routeGeos.size() != 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        DiffGeoPoints diffGeoPoints = routePlanRes.routeGeos.get(0);
        if (diffGeoPoints != null) {
            DoublePoint doublePoint = diffGeoPoints.base;
            double d2 = 0.0d;
            if (doublePoint != null) {
                d2 = (double) doublePoint.lat.floatValue();
                d = (double) doublePoint.lng.floatValue();
                arrayList.add(new LatLng(d2 / 100000.0d, d / 100000.0d));
            } else {
                d = 0.0d;
            }
            List<Integer> list = diffGeoPoints.dlats;
            List<Integer> list2 = diffGeoPoints.dlngs;
            if (!(list == null || list2 == null || list.size() != list2.size())) {
                for (int i = 0; i < list.size(); i++) {
                    d2 += ((double) list.get(i).intValue()) / 100.0d;
                    d += ((double) list2.get(i).intValue()) / 100.0d;
                    arrayList.add(new LatLng(d2 / 100000.0d, d / 100000.0d));
                }
            }
        }
        return arrayList;
    }

    public String getDistanceInfo() {
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null) {
            return null;
        }
        if (routePlanRes.legsInfo != null && this.f28825a.legsInfo.size() > 0) {
            return "" + this.f28825a.legsInfo.get(0).eda;
        } else if (this.f28825a.distance == null) {
            return null;
        } else {
            return "" + this.f28825a.distance;
        }
    }

    public int getTime() {
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null || routePlanRes.eta == null) {
            return 0;
        }
        return this.f28825a.eta.intValue();
    }

    public LatLng getRouteStartPoint() {
        List<LatLng> a = m20327a(this.f28825a);
        if (a == null || a.size() == 0) {
            return null;
        }
        return a.get(0);
    }

    public LatLng getRouteDestPoint() {
        List<LatLng> a = m20327a(this.f28825a);
        if (a == null || a.size() == 0) {
            return null;
        }
        return a.get(a.size() - 1);
    }

    public String getRouteId() {
        RoutePlanRes routePlanRes = this.f28825a;
        return routePlanRes == null ? "0" : String.valueOf(routePlanRes.hashCode());
    }

    public int getDstRouteGeoIndex() {
        LegInfo legInfo;
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null || routePlanRes.legsInfo == null || this.f28825a.legsInfo.size() <= 0 || (legInfo = this.f28825a.legsInfo.get(0)) == null || legInfo.geos == null || legInfo.geos.size() <= 1) {
            return 0;
        }
        return legInfo.geos.size() - 1;
    }

    public boolean isNearby() {
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null || routePlanRes.beyondPickup == null || ShareTrackApolloHelper.INSTANCE.isV3Enable() == 1) {
            return false;
        }
        SystemUtils.log(6, "mapglobal", "route plan : beyondPickup=" + this.f28825a.beyondPickup, (Throwable) null, "com.didi.map.sdk.sharetrack.google.inner.model.RoutePlanWrapper", 220);
        return this.f28825a.beyondPickup.booleanValue();
    }

    public int getParkingStatus() {
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null || routePlanRes.parking == null || ShareTrackApolloHelper.INSTANCE.isV3Enable() == 1) {
            return 0;
        }
        SystemUtils.log(6, "mapglobal", "route plan : parking=" + this.f28825a.parking, (Throwable) null, "com.didi.map.sdk.sharetrack.google.inner.model.RoutePlanWrapper", 230);
        return this.f28825a.parking.intValue();
    }

    public List<List<LatLng>> getRouteSegmentList() {
        RoutePlanRes routePlanRes = this.f28825a;
        if (routePlanRes == null || routePlanRes.legsInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LegInfo latLngListFromLegInfo : this.f28825a.legsInfo) {
            arrayList.add(RouteConverter.getLatLngListFromLegInfo(latLngListFromLegInfo));
        }
        return arrayList;
    }
}
