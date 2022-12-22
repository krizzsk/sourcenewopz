package com.didi.map.global.component.line.data.param;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public class BubblePageLineRequest extends BaseLineRequest {

    /* renamed from: a */
    private LatLng f25796a;

    /* renamed from: b */
    private int f25797b;

    /* renamed from: c */
    private LatLng f25798c;

    /* renamed from: d */
    private int f25799d;

    /* renamed from: e */
    private List<LatLng> f25800e;

    /* renamed from: f */
    private EpfOrderType f25801f;

    /* renamed from: g */
    private String f25802g;

    /* renamed from: h */
    private int f25803h;

    public BubblePageLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }

    public BubblePageLineRequest(CallFrom callFrom, String str, LatLng latLng, LatLng latLng2) {
        super(callFrom, str);
        this.f25796a = latLng;
        this.f25798c = latLng2;
    }

    public LatLng getStart() {
        return this.f25796a;
    }

    public void setStart(LatLng latLng) {
        this.f25796a = latLng;
    }

    public int getStartCityId() {
        return this.f25797b;
    }

    public void setStartCityId(int i) {
        this.f25797b = i;
    }

    public LatLng getEnd() {
        return this.f25798c;
    }

    public void setEnd(LatLng latLng) {
        this.f25798c = latLng;
    }

    public int getEndCityId() {
        return this.f25799d;
    }

    public void setEndCityId(int i) {
        this.f25799d = i;
    }

    public List<LatLng> getWayPoint() {
        return this.f25800e;
    }

    public void setWayPoint(List<LatLng> list) {
        this.f25800e = list;
    }

    public EpfOrderType getEpfOrderType() {
        return this.f25801f;
    }

    public void setEpfOrderType(EpfOrderType epfOrderType) {
        this.f25801f = epfOrderType;
    }

    public String getCurrentLang() {
        return this.f25802g;
    }

    public void setCurrentLang(String str) {
        this.f25802g = str;
    }

    public void setBizGroup(int i) {
        this.f25803h = i;
    }

    public int getBizGroup() {
        return this.f25803h;
    }
}
