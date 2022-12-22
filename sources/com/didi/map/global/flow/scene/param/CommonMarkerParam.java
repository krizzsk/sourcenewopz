package com.didi.map.global.flow.scene.param;

import android.graphics.Bitmap;
import com.didi.common.map.model.LatLng;

public class CommonMarkerParam {

    /* renamed from: a */
    private LatLng f27026a;

    /* renamed from: b */
    private Bitmap f27027b;

    /* renamed from: c */
    private float f27028c;

    /* renamed from: d */
    private float f27029d;

    /* renamed from: e */
    private String f27030e;

    /* renamed from: f */
    private MapElementId f27031f;

    /* renamed from: g */
    private int f27032g;

    /* renamed from: h */
    private int f27033h;

    /* renamed from: i */
    private int f27034i;

    /* renamed from: j */
    private boolean f27035j;

    /* renamed from: k */
    private int f27036k;
    public String poiId;

    public CommonMarkerParam(LatLng latLng, Bitmap bitmap, float f, float f2, MapElementId mapElementId) {
        this.f27026a = latLng;
        this.f27027b = bitmap;
        this.f27028c = f;
        this.f27029d = f2;
        this.f27031f = mapElementId;
    }

    public CommonMarkerParam(Builder builder) {
        this.f27026a = builder.point;
        this.f27027b = builder.markerIcon;
        this.f27028c = builder.anchorU;
        this.f27029d = builder.anchorV;
        this.f27030e = builder.addressName;
        this.f27031f = builder.f27037id;
        this.f27032g = builder.zIndex;
        this.f27033h = builder.addressNameColorResId;
        this.f27034i = builder.markerIconResId;
        this.f27035j = builder.showSensingCircle;
        this.f27036k = builder.sensingCircleColorRes;
        this.poiId = builder.poiId;
    }

    public MapElementId getId() {
        MapElementId mapElementId = this.f27031f;
        return mapElementId == null ? MapElementId.ID_MARKER_DEFAULT : mapElementId;
    }

    public void setId(MapElementId mapElementId) {
        this.f27031f = mapElementId;
    }

    public LatLng getPoint() {
        return this.f27026a;
    }

    public void setPoint(LatLng latLng) {
        this.f27026a = latLng;
    }

    public Bitmap getMarkerIcon() {
        return this.f27027b;
    }

    public void setMarkerIcon(Bitmap bitmap) {
        this.f27027b = bitmap;
    }

    public int getMarkerIconResId() {
        return this.f27034i;
    }

    public void setMarkerIconResId(int i) {
        this.f27034i = i;
    }

    public float getAnchorU() {
        return this.f27028c;
    }

    public void setAnchorU(float f) {
        this.f27028c = f;
    }

    public float getAnchorV() {
        return this.f27029d;
    }

    public void setAnchorV(float f) {
        this.f27029d = f;
    }

    public String getAddressName() {
        return this.f27030e;
    }

    public void setAddressName(String str) {
        this.f27030e = str;
    }

    public int getZIndex() {
        return this.f27032g;
    }

    public void setZIndex(int i) {
        this.f27032g = i;
    }

    public void setAddressNameColorResId(int i) {
        this.f27033h = i;
    }

    public int getAddressNameColorResId() {
        return this.f27033h;
    }

    public void setSensingCircle(boolean z) {
        this.f27035j = z;
    }

    public boolean showSensingCircle() {
        return this.f27035j;
    }

    public int getSensingCircleColorRes() {
        return this.f27036k;
    }

    public void setSensingCircleColorRes(int i) {
        this.f27036k = i;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public String toString() {
        return "CommonMarkerParam{point=" + this.f27026a + ", markerIcon=" + this.f27027b + ", anchorU=" + this.f27028c + ", anchorV=" + this.f27029d + ", addressName='" + this.f27030e + '\'' + ", id='" + this.f27031f + '\'' + ", zIndex=" + this.f27032g + ", poiId=" + this.poiId + ", addressNameColorResId=" + this.f27033h + ", markerIconResId=" + this.f27034i + ", showSensingCircle=" + this.f27035j + ", sensingCircleColorRes=" + this.f27036k + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String addressName;
        /* access modifiers changed from: private */
        public int addressNameColorResId;
        /* access modifiers changed from: private */
        public float anchorU;
        /* access modifiers changed from: private */
        public float anchorV;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public MapElementId f27037id;
        /* access modifiers changed from: private */
        public Bitmap markerIcon;
        /* access modifiers changed from: private */
        public int markerIconResId;
        public String poiId;
        /* access modifiers changed from: private */
        public LatLng point;
        /* access modifiers changed from: private */
        public int sensingCircleColorRes;
        /* access modifiers changed from: private */
        public boolean showSensingCircle;
        /* access modifiers changed from: private */
        public int zIndex;

        public Builder point(LatLng latLng) {
            this.point = latLng;
            return this;
        }

        public Builder markerIcon(Bitmap bitmap) {
            this.markerIcon = bitmap;
            return this;
        }

        public Builder anchorU(float f) {
            this.anchorU = f;
            return this;
        }

        public Builder anchorV(float f) {
            this.anchorV = f;
            return this;
        }

        public Builder addressName(String str) {
            this.addressName = str;
            return this;
        }

        /* renamed from: id */
        public Builder mo75597id(MapElementId mapElementId) {
            this.f27037id = mapElementId;
            return this;
        }

        public Builder zIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public Builder addressNameColorResId(int i) {
            this.addressNameColorResId = i;
            return this;
        }

        public Builder markerIconResId(int i) {
            this.markerIconResId = i;
            return this;
        }

        public Builder showSensingCircle(boolean z) {
            this.showSensingCircle = z;
            return this;
        }

        public Builder sensingCircleColorRes(int i) {
            this.sensingCircleColorRes = i;
            return this;
        }

        public Builder poiId(String str) {
            this.poiId = str;
            return this;
        }
    }
}
