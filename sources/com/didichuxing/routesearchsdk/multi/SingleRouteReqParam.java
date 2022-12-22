package com.didichuxing.routesearchsdk.multi;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.List;

public class SingleRouteReqParam {

    /* renamed from: a */
    private DoublePoint f48562a;

    /* renamed from: b */
    private DoublePoint f48563b;

    /* renamed from: c */
    private List<OdPoint> f48564c;

    /* renamed from: d */
    private TravelMode f48565d;

    /* renamed from: e */
    private int f48566e;

    public SingleRouteReqParam(DoublePoint doublePoint, DoublePoint doublePoint2, List<OdPoint> list, TravelMode travelMode) {
        this.f48562a = doublePoint;
        this.f48563b = doublePoint2;
        this.f48564c = list;
        this.f48565d = travelMode;
    }

    public SingleRouteReqParam(DoublePoint doublePoint, DoublePoint doublePoint2, List<OdPoint> list, TravelMode travelMode, int i) {
        this.f48562a = doublePoint;
        this.f48563b = doublePoint2;
        this.f48564c = list;
        this.f48565d = travelMode;
        this.f48566e = i;
    }

    public DoublePoint getStart() {
        return this.f48562a;
    }

    public DoublePoint getEnd() {
        return this.f48563b;
    }

    public List<OdPoint> getWayPoints() {
        return this.f48564c;
    }

    public TravelMode getTravelMode() {
        return this.f48565d;
    }

    public int getExpectStyle() {
        return this.f48566e;
    }
}
