package com.didi.map.intl.commonwalkengine.impl.navbase;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.intl.commonwalkengine.IWalkEngine;
import com.map.global.nav.libc.common.Convertor;
import com.map.global.nav.libc.common.DMKEventPoint;
import com.map.global.nav.libc.common.DMKMatchResult;
import com.map.global.nav.libc.common.GeoPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;

public class NavBaseEngineImpl implements IWalkEngine {

    /* renamed from: a */
    private static final String f27821a = "NavBaseEngineImpl";

    /* renamed from: b */
    private static final int f27822b = 1;

    /* renamed from: c */
    private static final int f27823c = 3;

    /* renamed from: d */
    private static final int f27824d = 4;

    /* renamed from: e */
    private List<LatLng> f27825e;

    /* renamed from: f */
    private IWalkEngine.IWalkEngineEventCallback f27826f;

    /* renamed from: g */
    private NavBaseJniWrapper f27827g;

    /* renamed from: h */
    private DMKMatchResult f27828h;

    /* renamed from: i */
    private DMKEventPoint f27829i;

    /* renamed from: j */
    private MatchPointType f27830j = MatchPointType.UNKNOWN;

    /* renamed from: k */
    private RouteGuidanceGPSPoint f27831k;

    /* renamed from: l */
    private RouteGuidanceGPSPoint f27832l;

    /* renamed from: m */
    private RouteGuidanceGPSPoint f27833m;

    /* renamed from: n */
    private RouteGuidanceGPSPoint f27834n;

    /* renamed from: o */
    private long f27835o = 1000;

    public NavBaseEngineImpl() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f27831k = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f27829i = new DMKEventPoint();
        this.f27828h = new DMKMatchResult();
    }

    public void destroy() {
        DLog.m7384d(f27821a, "destroy", new Object[0]);
        NavBaseJniWrapper navBaseJniWrapper = this.f27827g;
        if (navBaseJniWrapper != null) {
            navBaseJniWrapper.destroy();
            this.f27827g = null;
        }
        this.f27831k = null;
        this.f27832l = null;
        this.f27825e = null;
        this.f27829i = null;
    }

    public void setRoutePoints(List<LatLng> list) {
        DLog.m7384d(f27821a, " setRoutePoints", new Object[0]);
        this.f27825e = list;
        NavBaseJniWrapper navBaseJniWrapper = this.f27827g;
        if (navBaseJniWrapper != null) {
            navBaseJniWrapper.destroy();
            this.f27827g = null;
        }
        this.f27832l = null;
        this.f27834n = null;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f27831k = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        if (list != null && list.size() > 1) {
            NavBaseJniWrapper navBaseJniWrapper2 = new NavBaseJniWrapper();
            this.f27827g = navBaseJniWrapper2;
            navBaseJniWrapper2.setRoutePoints(m19918a(list));
            this.f27827g.setNextRoutePoints((List<LatLng>) null);
        }
    }

    public void setRoutePoints(List<LatLng> list, int i) {
        if (list == null || list.size() <= 1 || list.size() <= i) {
            setRoutePoints(list);
            return;
        }
        setRoutePoints(list.subList(0, i));
        List<LatLng> subList = list.subList(i, list.size());
        NavBaseJniWrapper navBaseJniWrapper = this.f27827g;
        if (navBaseJniWrapper != null) {
            navBaseJniWrapper.setNextRoutePoints(subList);
        }
    }

    public void setWalkEngineEventCallback(IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback) {
        this.f27826f = iWalkEngineEventCallback;
    }

    public int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        NavBaseJniWrapper navBaseJniWrapper = this.f27827g;
        if (navBaseJniWrapper != null) {
            return navBaseJniWrapper.distanceLeft(routeGuidanceGPSPoint);
        }
        return 0;
    }

    public int distanceLeft() {
        NavBaseJniWrapper navBaseJniWrapper = this.f27827g;
        if (navBaseJniWrapper != null) {
            return navBaseJniWrapper.distanceLeft2();
        }
        return 0;
    }

    public MatchPointType getMatchPointType() {
        DLog.m7384d(f27821a, "getMatchPointType = " + this.f27830j, new Object[0]);
        return this.f27830j;
    }

    public void setRequestIntervalInMills(int i) {
        this.f27835o = (long) i;
    }

    public RouteGuidanceGPSPoint getLastMatchGPSPoint() {
        return this.f27831k;
    }

    public void getMatchPoint(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        this.f27833m = routeGuidanceGPSPoint;
        if (routeGuidanceGPSPoint == null) {
            this.f27830j = MatchPointType.UNKNOWN;
            DLog.m7384d(f27821a, "onMatchRoute gps is null", new Object[0]);
            m19916a(1);
            return;
        }
        DLog.m7384d(f27821a, "onRecvDriverLocation: %s ", routeGuidanceGPSPoint.toString());
        if (this.f27832l == null) {
            this.f27832l = this.f27833m.copy();
        }
        this.f27834n = this.f27833m;
        if (m19917a()) {
            m19919b();
            if (this.f27827g.isOutWay()) {
                IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback = this.f27826f;
                if (iWalkEngineEventCallback != null) {
                    iWalkEngineEventCallback.onOffRoute();
                }
                m19916a(3);
                return;
            }
            m19916a(4);
            return;
        }
        m19916a(3);
    }

    /* renamed from: a */
    private boolean m19917a() {
        if (this.f27827g == null) {
            return false;
        }
        if (this.f27828h == null) {
            this.f27828h = new DMKMatchResult();
        }
        this.f27828h.resGpsFrequency = ((float) this.f27835o) / 1000.0f;
        RouteGuidanceGPSPoint matchResult = this.f27827g.matchResult(this.f27833m, this.f27828h);
        DMKMatchResult dMKMatchResult = this.f27828h;
        if (dMKMatchResult == null) {
            return false;
        }
        RouteGuidanceGPSPoint convertFromDMKGPSPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint);
        this.f27831k.point = convertFromDMKGPSPoint.point;
        this.f27831k.velocity = convertFromDMKGPSPoint.velocity;
        this.f27831k.timestamp = convertFromDMKGPSPoint.timestamp;
        this.f27831k.source = convertFromDMKGPSPoint.source;
        this.f27831k.shapeOffSet = convertFromDMKGPSPoint.shapeOffSet;
        this.f27831k.segmentIndex = convertFromDMKGPSPoint.segmentIndex;
        this.f27831k.matchedStatus = convertFromDMKGPSPoint.matchedStatus;
        this.f27831k.heading = convertFromDMKGPSPoint.heading;
        this.f27831k.accuracy = convertFromDMKGPSPoint.accuracy;
        if (matchResult != null) {
            this.f27831k.originMatchPoint = matchResult.originMatchPoint;
        }
        this.f27830j = MatchPointType.valueOf(this.f27828h.resPointType);
        this.f27829i = this.f27828h.resEventPoint;
        return true;
    }

    /* renamed from: a */
    private void m19916a(int i) {
        DLog.m7384d(f27821a, "doInertiaNavi, matchType:" + i, new Object[0]);
        if (i == 4) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f27831k;
            if (routeGuidanceGPSPoint != null) {
                this.f27832l = routeGuidanceGPSPoint.copy();
            }
        } else {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = this.f27833m;
            if (routeGuidanceGPSPoint2 != null) {
                RouteGuidanceGPSPoint copy = routeGuidanceGPSPoint2.copy();
                this.f27832l = copy;
                copy.segmentIndex = -1;
            }
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = this.f27832l;
        if (routeGuidanceGPSPoint3 != null && routeGuidanceGPSPoint3.point != null) {
            LatLng latLng = new LatLng(((double) this.f27832l.point.getLatitudeE6()) / 1000000.0d, ((double) this.f27832l.point.getLongitudeE6()) / 1000000.0d);
            IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback = this.f27826f;
            if (iWalkEngineEventCallback != null) {
                iWalkEngineEventCallback.onMatched(latLng, this.f27832l.segmentIndex, this.f27832l.shapeOffSet, 0, 0, this.f27829i);
            }
        }
    }

    /* renamed from: b */
    private void m19919b() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f27831k;
        if (routeGuidanceGPSPoint != null && routeGuidanceGPSPoint.segmentIndex > -1 && this.f27825e != null && this.f27831k.segmentIndex < this.f27825e.size()) {
            double computeDistanceBetween = ((double) this.f27831k.shapeOffSet) / DDSphericalUtil.computeDistanceBetween(this.f27825e.get(this.f27831k.segmentIndex), this.f27825e.get(this.f27831k.segmentIndex + 1));
            if (computeDistanceBetween > 0.0d && computeDistanceBetween < 1.0d) {
                LatLng interpolate = DDSphericalUtil.interpolate(this.f27825e.get(this.f27831k.segmentIndex), this.f27825e.get(this.f27831k.segmentIndex + 1), computeDistanceBetween);
                this.f27831k.point = new GeoPoint((int) (interpolate.latitude * 1000000.0d), (int) (interpolate.longitude * 1000000.0d));
            }
        }
    }

    /* renamed from: a */
    private GeoPoint[] m19918a(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        GeoPoint[] geoPointArr = new GeoPoint[size];
        for (int i = 0; i < size; i++) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (list.get(i).latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (list.get(i).longitude * 1000000.0d));
            geoPointArr[i] = geoPoint;
        }
        return geoPointArr;
    }
}
