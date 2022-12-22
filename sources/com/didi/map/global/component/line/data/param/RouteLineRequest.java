package com.didi.map.global.component.line.data.param;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public class RouteLineRequest extends BaseLineRequest {

    /* renamed from: a */
    private LatLng f25812a;

    /* renamed from: b */
    private LatLng f25813b;

    /* renamed from: c */
    private List<LatLng> f25814c;

    /* renamed from: d */
    private TravelMode f25815d;

    /* renamed from: e */
    private String f25816e;

    /* renamed from: f */
    private int f25817f;

    public RouteLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }

    public RouteLineRequest(CallFrom callFrom, String str, LatLng latLng, LatLng latLng2, TravelMode travelMode) {
        super(callFrom, str);
        this.f25812a = latLng;
        this.f25813b = latLng2;
        this.f25815d = travelMode;
    }

    public LatLng getStart() {
        return this.f25812a;
    }

    public void setStart(LatLng latLng) {
        this.f25812a = latLng;
    }

    public LatLng getEnd() {
        return this.f25813b;
    }

    public void setEnd(LatLng latLng) {
        this.f25813b = latLng;
    }

    public List<LatLng> getWayPoint() {
        return this.f25814c;
    }

    public void setWayPoint(List<LatLng> list) {
        this.f25814c = list;
    }

    public TravelMode getTravelMode() {
        return this.f25815d;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.f25815d = travelMode;
    }

    public String getOrderId() {
        return this.f25816e;
    }

    public void setOrderId(String str) {
        this.f25816e = str;
    }

    public void setBizGroup(int i) {
        this.f25817f = i;
    }

    public int getBizGroup() {
        return this.f25817f;
    }
}
