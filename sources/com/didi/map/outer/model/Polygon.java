package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.PolygonControl;
import com.didi.map.outer.map.DidiMap;
import java.util.List;

public final class Polygon implements IMapElement {

    /* renamed from: a */
    private PolygonOptions f27998a = null;

    /* renamed from: b */
    private String f27999b = "";

    /* renamed from: c */
    private PolygonControl f28000c = null;

    public Polygon(PolygonOptions polygonOptions, PolygonControl polygonControl, String str) {
        this.f27999b = str;
        this.f27998a = polygonOptions;
        this.f28000c = polygonControl;
    }

    public void remove() {
        PolygonControl polygonControl = this.f28000c;
        if (polygonControl != null) {
            polygonControl.polygon_remove(this.f27999b);
        }
    }

    public String getId() {
        return this.f27999b;
    }

    public void setBellowRoute(boolean z) {
        PolygonControl polygonControl = this.f28000c;
        if (polygonControl != null) {
            polygonControl.setBellowRoute(this.f27999b, z);
            this.f27998a.bellowRoute(z);
        }
    }

    public void setPoints(List<LatLng> list) {
        PolygonControl polygonControl = this.f28000c;
        if (polygonControl != null) {
            polygonControl.polygon_setPoints(this.f27999b, list);
            this.f27998a.setPoints(list);
        }
    }

    public List<LatLng> getPoints() {
        return this.f27998a.getPoints();
    }

    public void setStrokeWidth(float f) {
        this.f28000c.polygon_setStrokeWidth(this.f27999b, f);
        this.f27998a.strokeWidth(f);
    }

    public float getStrokeWidth() {
        return this.f27998a.getStrokeWidth();
    }

    public void setStrokeColor(int i) {
        this.f28000c.polygon_setStrokeColor(this.f27999b, i);
        this.f27998a.strokeColor(i);
    }

    public int getStrokeColor() {
        return this.f27998a.getStrokeColor();
    }

    public void setFillColor(int i) {
        this.f28000c.polygon_setFillColor(this.f27999b, i);
        this.f27998a.fillColor(i);
    }

    public int getFillColor() {
        return this.f27998a.getFillColor();
    }

    public void setZIndex(float f) {
        this.f28000c.polygon_setZIndex(this.f27999b, f);
        this.f27998a.zIndex(f);
    }

    public float getZIndex() {
        return this.f27998a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.f28000c.polygon_setVisible(this.f27999b, z);
        this.f27998a.visible(z);
    }

    public boolean isVisible() {
        return this.f27998a.isVisible();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77156a(boolean z) {
        this.f28000c.polygon_setGeodesic(this.f27999b, z);
        this.f27998a.geodesic(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo77157a() {
        return this.f27998a.isGeodesic();
    }

    public void setOptions(PolygonOptions polygonOptions) {
        this.f28000c.setOptions(this.f27999b, polygonOptions);
        this.f27998a = polygonOptions;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        return this.f27999b.equals(((Polygon) obj).f27999b);
    }

    public int hashCode() {
        return this.f27999b.hashCode();
    }

    public Rect getBound() {
        PolygonControl polygonControl = this.f28000c;
        if (polygonControl == null) {
            return new Rect();
        }
        return polygonControl.getBound(this.f27999b);
    }

    public RectF getPixel20Bound(float f) {
        PolygonControl polygonControl = this.f28000c;
        if (polygonControl == null) {
            return null;
        }
        return polygonControl.getPixel20Bound(this.f27999b, f);
    }

    public void setOnPolygonClickListener(DidiMap.OnPolygonClickListener onPolygonClickListener) {
        this.f28000c.setOnPolygonClickListener(this.f27999b, onPolygonClickListener);
    }

    public boolean isClickable() {
        return this.f27998a.isClickable();
    }

    public void setClickable(boolean z) {
        this.f28000c.setClickable(this.f27999b, z);
        this.f27998a.setClickable(z);
    }
}
