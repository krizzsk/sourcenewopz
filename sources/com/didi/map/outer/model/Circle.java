package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.CircleControl;
import com.didi.map.common.utils.TransformUtil;

public final class Circle implements IMapElement {

    /* renamed from: a */
    private CircleOptions f27908a = null;

    /* renamed from: b */
    private String f27909b = "";

    /* renamed from: c */
    private CircleControl f27910c = null;

    public int hashCode() {
        return 0;
    }

    public Circle(CircleOptions circleOptions, CircleControl circleControl, String str) {
        this.f27909b = str;
        this.f27908a = circleOptions;
        this.f27910c = circleControl;
    }

    public boolean contains(LatLng latLng) {
        return TransformUtil.distanceBetween(getCenter().latitude, getCenter().longitude, latLng.latitude, latLng.longitude) <= getRadius();
    }

    public void setCenter(LatLng latLng) {
        CircleControl circleControl = this.f27910c;
        if (circleControl != null) {
            circleControl.circle_setCenter(this.f27909b, latLng);
            this.f27908a.center(latLng);
        }
    }

    public LatLng getCenter() {
        return new LatLng(this.f27908a.getCenter().latitude, this.f27908a.getCenter().longitude);
    }

    public LatLngBounds getLatLngBounds() {
        CircleOptions circleOptions = this.f27908a;
        if (circleOptions == null) {
            return null;
        }
        return this.f27910c.getBound(new LatLng(circleOptions.getCenter().latitude, this.f27908a.getCenter().longitude), this.f27908a.getRadius());
    }

    public void setRadius(double d) {
        CircleControl circleControl;
        if (d >= 0.0d && (circleControl = this.f27910c) != null) {
            circleControl.circle_setRadius(this.f27909b, d);
            this.f27908a.radius(d);
        }
    }

    public double getRadius() {
        return this.f27908a.getRadius();
    }

    public void setStrokeWidth(float f) {
        if (f >= 0.0f) {
            this.f27910c.circle_setStrokeWidth(this.f27909b, f);
            this.f27908a.strokeWidth(f);
        }
    }

    public float getStrokeWidth() {
        return this.f27908a.getStrokeWidth();
    }

    public void setStrokeColor(int i) {
        this.f27910c.circle_setStrokeColor(this.f27909b, i);
        this.f27908a.strokeColor(i);
    }

    public int getStrokeColor() {
        return this.f27908a.getStrokeColor();
    }

    public void setFillColor(int i) {
        this.f27910c.circle_setFillColor(this.f27909b, i);
        this.f27908a.fillColor(i);
    }

    public int getFillColor() {
        return this.f27908a.getFillColor();
    }

    public void setZIndex(float f) {
        this.f27910c.circle_setZIndex(this.f27909b, f);
        this.f27908a.zIndex(f);
    }

    public float getZIndex() {
        return this.f27908a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.f27910c.circle_setVisible(this.f27909b, z);
        this.f27908a.visible(z);
    }

    public boolean isVisible() {
        return this.f27908a.isVisible();
    }

    public void setOptions(CircleOptions circleOptions) {
        this.f27910c.setOptions(this.f27909b, circleOptions);
        this.f27908a = circleOptions;
    }

    public void remove() {
        CircleControl circleControl = this.f27910c;
        if (circleControl != null) {
            circleControl.circle_remove(this.f27909b);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        return this.f27909b.equals(((Circle) obj).f27909b);
    }

    public Rect getBound() {
        CircleControl circleControl = this.f27910c;
        if (circleControl == null) {
            return new Rect();
        }
        return circleControl.getBound(this.f27909b);
    }

    public RectF getPixel20Bound(float f) {
        CircleControl circleControl = this.f27910c;
        if (circleControl == null) {
            return null;
        }
        return circleControl.getPixel20Bound(this.f27909b, f);
    }
}
