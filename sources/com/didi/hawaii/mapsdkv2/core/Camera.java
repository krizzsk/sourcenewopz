package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.common.MapTransform;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.map.outer.model.LatLng;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public final class Camera {
    public static final float MAX_SCALE = 4.0f;
    public static final float MAX_SCALE_LEVEL = 22.0f;
    public static final float MIN_SCALE = 1.5258789E-5f;
    public static final int MIN_SCALE_LEVEL = 4;

    /* renamed from: a */
    private final LatLng f23801a;

    /* renamed from: b */
    private float f23802b;

    /* renamed from: c */
    private float f23803c;

    /* renamed from: d */
    private float f23804d;

    /* renamed from: e */
    private float f23805e;

    public Camera(LatLng latLng, float f, float f2, float f3) {
        this.f23801a = new LatLng(latLng);
        this.f23802b = f;
        m16920a();
        this.f23803c = f2;
        this.f23804d = f3;
    }

    public Camera(Camera camera) {
        this.f23801a = new LatLng(camera.f23801a);
        this.f23802b = camera.f23802b;
        this.f23805e = camera.f23805e;
        this.f23803c = camera.f23803c;
        this.f23804d = camera.f23804d;
    }

    public synchronized void setCamera(Camera camera) {
        this.f23801a.longitude = camera.f23801a.longitude;
        this.f23801a.latitude = camera.f23801a.latitude;
        this.f23802b = camera.f23802b;
        this.f23805e = camera.f23805e;
        this.f23803c = MapTransform.normalizeRotate(camera.f23803c);
        this.f23804d = camera.f23804d;
    }

    public synchronized void set(LatLng latLng, float f, float f2, float f3) {
        this.f23801a.longitude = latLng.longitude;
        this.f23801a.latitude = latLng.latitude;
        this.f23802b = f;
        m16920a();
        this.f23803c = MapTransform.normalizeRotate(f2);
        this.f23804d = f3;
    }

    /* renamed from: a */
    private void m16920a() {
        this.f23805e = (float) MathsUtils.getScaleLevel((double) this.f23802b);
    }

    public synchronized LatLng getCenter() {
        return this.f23801a;
    }

    public synchronized void setCenter(LatLng latLng) {
        this.f23801a.longitude = latLng.longitude;
        this.f23801a.latitude = latLng.latitude;
    }

    public synchronized float getScale() {
        return this.f23802b;
    }

    public synchronized void setScale(float f) {
        this.f23802b = f;
        m16920a();
    }

    public float getRotate() {
        return this.f23803c;
    }

    public void setRotate(float f) {
        this.f23803c = MapTransform.normalizeRotate(f);
    }

    public float getSkew() {
        return this.f23804d;
    }

    public void setSkew(float f) {
        this.f23804d = f;
    }

    public synchronized float getScaleLevel() {
        return this.f23805e;
    }

    public synchronized Camera copy() {
        return new Camera(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Camera) {
            Camera camera = (Camera) obj;
            return camera.f23802b == this.f23802b && camera.f23803c == this.f23803c && camera.f23801a.equals(this.f23801a) && camera.f23804d == this.f23804d;
        }
    }

    public String toString() {
        return "[center:" + this.f23801a + ", skew:" + this.f23804d + ", rotate:" + this.f23803c + ", scale:" + this.f23802b + ", scaleLevel:" + this.f23805e + Const.jaRight;
    }
}
