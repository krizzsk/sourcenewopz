package com.didi.map.global.component.line.component;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.line.component.traffic.TrafficData;
import java.util.List;

public class LineParams {

    /* renamed from: a */
    private int f25678a;

    /* renamed from: b */
    private int f25679b = -1;

    /* renamed from: c */
    private int f25680c;

    /* renamed from: d */
    private int f25681d;

    /* renamed from: e */
    private List<LatLng> f25682e;

    /* renamed from: f */
    private int f25683f;

    /* renamed from: g */
    private List<TrafficData> f25684g;

    /* renamed from: h */
    private LineExParam f25685h;

    /* renamed from: i */
    private float f25686i;

    /* renamed from: j */
    private boolean f25687j;

    /* renamed from: k */
    private boolean f25688k;

    /* renamed from: l */
    private boolean f25689l = true;

    public LineParams(List<LatLng> list, int i, int i2) {
        this.f25678a = i;
        this.f25681d = i2;
        this.f25682e = list;
    }

    public LineParams(List<TrafficData> list, List<LatLng> list2, int i, int i2) {
        this.f25678a = i;
        this.f25681d = i2;
        this.f25684g = list;
        this.f25682e = list2;
    }

    public int getLineColorWithArgb() {
        return this.f25678a;
    }

    public void setLineColorWithArgb(int i) {
        this.f25678a = i;
    }

    public int getDidiColor() {
        return this.f25679b;
    }

    public void setDidiColor(int i) {
        this.f25679b = i;
    }

    public int getLineWidth() {
        return this.f25681d;
    }

    public void setLineWidth(int i) {
        this.f25681d = i;
    }

    public List<LatLng> getLinePoints() {
        return this.f25682e;
    }

    public void setLinePoints(List<LatLng> list) {
        this.f25682e = list;
    }

    public int getZIndex() {
        return this.f25683f;
    }

    public void setZIndex(int i) {
        this.f25683f = i;
    }

    public List<TrafficData> getTrafficData() {
        return this.f25684g;
    }

    public void setTrafficData(List<TrafficData> list) {
        this.f25684g = list;
    }

    public LineExParam getExParam() {
        return this.f25685h;
    }

    public int getDottedIconRes() {
        return this.f25680c;
    }

    public void setDottedIconRes(int i) {
        this.f25680c = i;
    }

    public float getDotSpace() {
        return this.f25686i;
    }

    public void setDotSpace(float f) {
        this.f25686i = f;
    }

    public void setExParam(LineExParam lineExParam) {
        this.f25685h = lineExParam;
    }

    public boolean isEnableEarthWormLine() {
        return this.f25687j;
    }

    public void setEnableEarthWormLine(boolean z) {
        this.f25687j = z;
    }

    public boolean isClickable() {
        return this.f25688k;
    }

    public void setClickable(boolean z) {
        this.f25688k = z;
    }

    public void setEnableDirArrow(boolean z) {
        this.f25689l = z;
    }

    public boolean isEnableDirArrow() {
        return this.f25689l;
    }
}
