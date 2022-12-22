package com.didi.map.sdk.sharetrack.google.inner.model;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.DriverOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.PickupHint;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import com.didi.map.sdk.sharetrack.delegate.INaviRouteDelegate;
import com.didi.map.sdk.sharetrack.entity.WayPoint;
import com.didi.map.sdk.sharetrack.external.GoogleRouteOptManager;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.ArrayList;
import java.util.List;

public class GRoute implements INaviRouteDelegate {

    /* renamed from: a */
    private static final String f28821a = "GRoute";

    /* renamed from: b */
    private DriverOrderRouteRes f28822b;

    /* renamed from: c */
    private List<LatLng> f28823c;

    /* renamed from: d */
    private List<WayPoint> f28824d;

    public LineOptions.MultiColorLineInfo[] getLineColorInfos() {
        return new LineOptions.MultiColorLineInfo[0];
    }

    public List<String> getRoadNames() {
        return null;
    }

    public String getRouteRecommendMsg() {
        return null;
    }

    public /* synthetic */ List<List<LatLng>> getRouteSegmentList() {
        return INaviRouteDelegate.CC.$default$getRouteSegmentList(this);
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

    public boolean hasFeeSegment() {
        return false;
    }

    public boolean isRouteTypePersonal() {
        return false;
    }

    public GRoute(DriverOrderRouteRes driverOrderRouteRes) {
        this.f28822b = driverOrderRouteRes;
    }

    public List<LatLng> getRoutePoints() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null) {
            return null;
        }
        if (this.f28823c == null) {
            this.f28823c = m20326a(driverOrderRouteRes);
        }
        return this.f28823c;
    }

    /* renamed from: a */
    private List<LatLng> m20326a(DriverOrderRouteRes driverOrderRouteRes) {
        double d;
        if (driverOrderRouteRes == null || driverOrderRouteRes.routeGeos == null || driverOrderRouteRes.routeGeos.size() != 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        DiffGeoPoints diffGeoPoints = driverOrderRouteRes.routeGeos.get(0);
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
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        return (driverOrderRouteRes == null || driverOrderRouteRes.distance == null) ? "0" : this.f28822b.distance.toString();
    }

    public int getTime() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null || driverOrderRouteRes.eta == null) {
            return 0;
        }
        return this.f28822b.eta.intValue();
    }

    public List<WayPoint> getWayPoints() {
        if (this.f28824d == null) {
            this.f28824d = new ArrayList();
            DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
            if (!(driverOrderRouteRes == null || driverOrderRouteRes.odPoints == null)) {
                for (int i = 0; i < this.f28822b.odPoints.size() - 1; i++) {
                    OdPoint odPoint = this.f28822b.odPoints.get(i);
                    if (!(odPoint == null || odPoint.point == null || odPoint.point.lat == null || odPoint.point.lng == null)) {
                        WayPoint wayPoint = new WayPoint();
                        wayPoint.passPointIndex = i;
                        wayPoint.coorIndex = this.f28822b.curDstRouteGeoIndex == null ? -1 : this.f28822b.curDstRouteGeoIndex.intValue();
                        wayPoint.point = new LatLng((double) odPoint.point.lat.floatValue(), (double) odPoint.point.lng.floatValue());
                        DLog.m20357d(f28821a, "getWayPoints = %s", wayPoint.point.toString());
                        this.f28824d.add(wayPoint);
                    }
                }
            }
        }
        return this.f28824d;
    }

    public LatLng getRouteStartPoint() {
        List<LatLng> a = m20326a(this.f28822b);
        if (a == null || a.size() == 0) {
            return null;
        }
        return a.get(0);
    }

    public LatLng getRouteDestPoint() {
        List<LatLng> a = m20326a(this.f28822b);
        if (a == null || a.size() == 0) {
            return null;
        }
        return a.get(a.size() - 1);
    }

    public String getRouteId() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        return (driverOrderRouteRes == null || driverOrderRouteRes.routeIds == null || this.f28822b.routeIds.isEmpty()) ? "0" : String.valueOf(this.f28822b.routeIds.get(0));
    }

    public int getDstRouteGeoIndex() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null || driverOrderRouteRes.curDstRouteGeoIndex == null) {
            DLog.m20357d(f28821a, "curDstRouteGeoIndex = null", new Object[0]);
            return -1;
        }
        DLog.m20357d(f28821a, "curDstRouteGeoIndex = %d", Integer.valueOf(this.f28822b.curDstRouteGeoIndex.intValue()));
        return this.f28822b.curDstRouteGeoIndex.intValue();
    }

    public String getNavEndPlaceId() {
        String[] split;
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        String str = "";
        if (driverOrderRouteRes != null && driverOrderRouteRes.extendData != null) {
            String utf8 = this.f28822b.extendData.utf8();
            DLog.m20357d(f28821a, "mDriverOrderRouteRes.extendData = " + utf8, new Object[0]);
            if (!TextUtil.isEmpty(utf8) && utf8.contains("curDstRouteGeoPlaceID")) {
                if (utf8.contains(ParamKeys.SIGN_AND)) {
                    String[] split2 = utf8.split(ParamKeys.SIGN_AND);
                    int length = split2.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String str2 = split2[i];
                            if (str2 != null && str2.contains("curDstRouteGeoPlaceID") && (split = str2.split("=")) != null && split.length > 1) {
                                str = split[1];
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                } else {
                    String[] split3 = utf8.split("=");
                    if (split3 != null && split3.length > 1) {
                        str = split3[1];
                    }
                }
            }
        }
        DLog.m20357d(f28821a, "curDstRouteGeoPlaceID = " + str, new Object[0]);
        return str;
    }

    public PickupHint getPickUpHint() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null) {
            return null;
        }
        return driverOrderRouteRes.pickupHint;
    }

    public boolean isNearby() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null || driverOrderRouteRes.pickupHint == null || this.f28822b.pickupHint.driverBeyondPickupFunc == null || this.f28822b.pickupHint.driverBeyondPickupFunc.BeyondPickup == null || ShareTrackApolloHelper.INSTANCE.isV3Enable() == 0) {
            return false;
        }
        SystemUtils.log(6, "mapglobal", "route plan : beyondPickup=" + this.f28822b.pickupHint.driverBeyondPickupFunc.BeyondPickup, (Throwable) null, "com.didi.map.sdk.sharetrack.google.inner.model.GRoute", 262);
        return this.f28822b.pickupHint.driverBeyondPickupFunc.BeyondPickup.booleanValue();
    }

    public int getParkingStatus() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null || driverOrderRouteRes.pickupHint == null || this.f28822b.pickupHint.driverBeyondPickupFunc == null || this.f28822b.pickupHint.driverBeyondPickupFunc.Parking == null || ShareTrackApolloHelper.INSTANCE.isV3Enable() == 0) {
            return 0;
        }
        SystemUtils.log(6, "mapglobal", "route plan : Parking=" + this.f28822b.pickupHint.driverBeyondPickupFunc.Parking, (Throwable) null, "com.didi.map.sdk.sharetrack.google.inner.model.GRoute", 275);
        return this.f28822b.pickupHint.driverBeyondPickupFunc.Parking.intValue();
    }

    public int getNaviAddtionalLine() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (driverOrderRouteRes == null || driverOrderRouteRes.naviAddtionalLine == null) {
            return 0;
        }
        return this.f28822b.naviAddtionalLine.intValue();
    }

    public boolean avoidTolls() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (!(driverOrderRouteRes == null || driverOrderRouteRes.extendData == null)) {
            String utf8 = this.f28822b.extendData.utf8();
            GoogleRouteOptManager.getInstance().log("extendData.avoidtolls = " + utf8);
            if (!TextUtil.isEmpty(utf8) && utf8.contains("avoidtolls")) {
                if (utf8.contains(ParamKeys.SIGN_AND)) {
                    for (String str : utf8.split(ParamKeys.SIGN_AND)) {
                        if (str != null && str.contains("avoidtolls")) {
                            String[] split = str.split("=");
                            if (split.length > 1) {
                                return "1".equals(split[1]);
                            }
                        }
                    }
                } else {
                    String[] split2 = utf8.split("=");
                    if (split2.length > 1) {
                        return "1".equals(split2[1]);
                    }
                }
            }
        }
        return false;
    }

    public boolean routeShorter() {
        DriverOrderRouteRes driverOrderRouteRes = this.f28822b;
        if (!(driverOrderRouteRes == null || driverOrderRouteRes.extendData == null)) {
            String utf8 = this.f28822b.extendData.utf8();
            GoogleRouteOptManager.getInstance().log("extendData.shortest = " + utf8);
            if (!TextUtil.isEmpty(utf8) && utf8.contains("shortest")) {
                if (utf8.contains(ParamKeys.SIGN_AND)) {
                    for (String str : utf8.split(ParamKeys.SIGN_AND)) {
                        if (str != null && str.contains("shortest")) {
                            String[] split = str.split("=");
                            if (split.length > 1) {
                                return "1".equals(split[1]);
                            }
                        }
                    }
                } else {
                    String[] split2 = utf8.split("=");
                    if (split2.length > 1) {
                        return "1".equals(split2[1]);
                    }
                }
            }
        }
        return false;
    }
}
