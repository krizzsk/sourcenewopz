package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.util.DDMathUtil;
import com.didi.common.map.util.DDSphericalUtil;

public class GroundOverlayOptions extends IMapElementOptions {

    /* renamed from: a */
    private float f10817a = 0.5f;

    /* renamed from: b */
    private float f10818b = 0.5f;

    /* renamed from: c */
    private LatLng f10819c;

    /* renamed from: d */
    private float f10820d;

    /* renamed from: e */
    private float f10821e;

    /* renamed from: f */
    private float f10822f;

    /* renamed from: g */
    private BitmapDescriptor f10823g;

    /* renamed from: h */
    private float f10824h;

    /* renamed from: i */
    private LatLngBounds f10825i;

    public float getAlpha() {
        return this.f10824h;
    }

    public GroundOverlayOptions transparency(float f) {
        this.f10824h = f;
        return this;
    }

    public float getAnchorU() {
        return this.f10817a;
    }

    public GroundOverlayOptions anchorU(float f) {
        this.f10817a = f;
        return this;
    }

    public float getAnchorV() {
        return this.f10818b;
    }

    public GroundOverlayOptions anchorV(float f) {
        this.f10818b = f;
        return this;
    }

    public LatLng getPosition() {
        return this.f10819c;
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        this.f10819c = latLng;
        this.f10820d = f;
        this.f10821e = f2;
        this.f10825i = m7346a(latLng, f, f2);
        return this;
    }

    public GroundOverlayOptions position(LatLngBounds latLngBounds) {
        this.f10825i = latLngBounds;
        return this;
    }

    public LatLngBounds getBounds() {
        return this.f10825i;
    }

    public float getWidth() {
        return this.f10820d;
    }

    public float getHeight() {
        return this.f10821e;
    }

    public float getBearing() {
        return this.f10822f;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f10822f = f;
        return this;
    }

    public BitmapDescriptor getImage() {
        return this.f10823g;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f10823g = bitmapDescriptor;
        return this;
    }

    /* renamed from: a */
    private LatLngBounds m7346a(LatLng latLng, float f, float f2) {
        double computeAngle = DDMathUtil.computeAngle(f, f2);
        double sqrt = Math.sqrt((double) ((f * f) + (f2 * f2))) / 2.0d;
        return new LatLngBounds(DDSphericalUtil.computeOffsetOrigin(latLng, sqrt, computeAngle), DDSphericalUtil.computeOffsetOrigin(latLng, sqrt, DDMathUtil.computeAngle(f, f2) + 180.0d));
    }
}
