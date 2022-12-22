package com.didi.map.outer.model;

import android.graphics.PointF;

public class BaseMarkerOption {
    protected boolean boInfoWindowEnable = true;
    protected boolean boIs3D = false;
    protected boolean boVisible;
    protected boolean clickable = true;
    protected float fAlpha = 1.0f;
    protected float fAngle = 0.0f;
    protected int infoWindowType = 1;
    protected boolean isNoDistanceScale = false;
    protected boolean mAvoidAnno = false;
    protected boolean mClockwise = true;
    protected boolean mFlat = false;
    protected LatLng mlatlng;
    protected PointF offset = new PointF(0.0f, 0.0f);
    protected PointF scaleXY = new PointF(1.0f, 1.0f);
    protected String strSnippet = "test content";
    protected String strtitle = "test infoWindow";
    protected float zIndex = 0.0f;

    public BaseMarkerOption(LatLng latLng) {
        this.mlatlng = latLng;
    }

    public BaseMarkerOption() {
    }

    public BaseMarkerOption position(LatLng latLng) {
        this.mlatlng = latLng;
        return this;
    }

    public BaseMarkerOption infoWindowEnable(boolean z) {
        this.boInfoWindowEnable = z;
        return this;
    }

    public BaseMarkerOption flat(boolean z) {
        this.mFlat = z;
        return this;
    }

    public BaseMarkerOption alpha(float f) {
        this.fAlpha = f;
        return this;
    }

    public BaseMarkerOption visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    public BaseMarkerOption is3D(boolean z) {
        this.boIs3D = z;
        return this;
    }

    public BaseMarkerOption zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public BaseMarkerOption clickable(boolean z) {
        this.clickable = z;
        return this;
    }

    public BaseMarkerOption avoidAnnocation(boolean z) {
        this.mAvoidAnno = z;
        return this;
    }

    public BaseMarkerOption setNoDistanceScale(boolean z) {
        this.isNoDistanceScale = z;
        return this;
    }

    public BaseMarkerOption clockwise(boolean z) {
        this.mClockwise = z;
        return this;
    }

    public BaseMarkerOption infoWindowType(int i) {
        this.infoWindowType = i;
        return this;
    }

    public boolean isAvoidAnnocation() {
        return this.mAvoidAnno;
    }

    public LatLng getPosition() {
        return this.mlatlng;
    }

    public boolean isNoDistanceScale() {
        return this.isNoDistanceScale;
    }

    public boolean isInfoWindowEnable() {
        return this.boInfoWindowEnable;
    }

    public float getAlpha() {
        return this.fAlpha;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean is3D() {
        return this.boIs3D;
    }

    public boolean isFlat() {
        return this.mFlat;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }

    public float getRotateAngle() {
        return this.fAngle;
    }

    public PointF getScaleXY() {
        return this.scaleXY;
    }

    public PointF getOffset() {
        return this.offset;
    }

    public String getTitle() {
        return this.strtitle;
    }

    public String getSnippet() {
        return this.strSnippet;
    }
}
