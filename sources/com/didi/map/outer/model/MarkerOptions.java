package com.didi.map.outer.model;

import android.graphics.PointF;
import com.didi.map.alpha.maps.internal.BitmapFormater;

public class MarkerOptions extends BaseMarkerOption {

    /* renamed from: a */
    private BitmapDescriptor f27972a;

    /* renamed from: b */
    private float f27973b = 0.5f;

    /* renamed from: c */
    private float f27974c = 1.0f;

    /* renamed from: d */
    private boolean f27975d;

    /* renamed from: e */
    private boolean f27976e = false;

    /* renamed from: f */
    private int f27977f = 0;

    /* renamed from: g */
    private boolean f27978g = false;

    /* renamed from: h */
    private boolean f27979h = false;

    /* renamed from: i */
    private boolean f27980i = false;

    /* renamed from: j */
    private LatLngBounds f27981j;

    /* renamed from: k */
    private long f27982k;

    /* renamed from: l */
    private MarkerInfoWindowOption f27983l = new MarkerInfoWindowOption();

    public long getBubbleId() {
        return this.f27982k;
    }

    public MarkerOptions bubbleId(long j) {
        this.f27982k = j;
        return this;
    }

    public MarkerOptions setMarkerInfoOption(MarkerInfoWindowOption markerInfoWindowOption) {
        this.f27983l = markerInfoWindowOption;
        return this;
    }

    public MarkerInfoWindowOption getInfoWindowOption() {
        return this.f27983l;
    }

    public boolean isCollideRouteLableBubble() {
        return this.f27979h;
    }

    public MarkerOptions setCollideRouteLableBubble(boolean z) {
        this.f27979h = z;
        return this;
    }

    public boolean isNoDistanceScale() {
        return this.isNoDistanceScale;
    }

    public MarkerOptions setNoDistanceScale(boolean z) {
        this.isNoDistanceScale = z;
        return this;
    }

    public MarkerOptions(LatLng latLng) {
        super(latLng);
        this.boVisible = true;
        this.mlatlng = latLng;
    }

    public MarkerOptions() {
        this.boVisible = true;
    }

    public MarkerOptions position(LatLng latLng) {
        this.mlatlng = latLng;
        return this;
    }

    public MarkerOptions ground(boolean z) {
        this.f27980i = z;
        return this;
    }

    public MarkerOptions groundBounds(LatLngBounds latLngBounds) {
        this.f27981j = latLngBounds;
        return this;
    }

    public MarkerOptions infoWindowEnable(boolean z) {
        this.boInfoWindowEnable = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.mFlat = z;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f27972a = bitmapDescriptor;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f27973b = f;
        this.f27974c = f2;
        return this;
    }

    public MarkerOptions title(String str) {
        this.strtitle = str;
        return this;
    }

    public MarkerOptions rotateAngle(float f) {
        this.fAngle = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.strSnippet = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f27975d = z;
        return this;
    }

    public MarkerOptions scaleXY(PointF pointF) {
        this.scaleXY = pointF;
        return this;
    }

    public PointF getScaleXY() {
        return this.scaleXY;
    }

    public MarkerOptions offset(PointF pointF) {
        this.offset = pointF;
        return this;
    }

    public PointF getOffset() {
        return this.offset;
    }

    public MarkerOptions alpha(float f) {
        this.fAlpha = f;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    public MarkerOptions is3D(boolean z) {
        this.boIs3D = z;
        return this;
    }

    public MarkerOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public MarkerOptions loggable(boolean z) {
        this.f27976e = z;
        return this;
    }

    public MarkerOptions clickable(boolean z) {
        this.clickable = z;
        return this;
    }

    public boolean getLogaable() {
        return this.f27976e;
    }

    public MarkerOptions avoidAnnocation(boolean z) {
        this.mAvoidAnno = z;
        return this;
    }

    public boolean isAvoidAnnocation() {
        return this.mAvoidAnno;
    }

    public LatLng getPosition() {
        return this.mlatlng;
    }

    public String getTitle() {
        return this.strtitle;
    }

    public String getSnippet() {
        return this.strSnippet;
    }

    public BitmapDescriptor getIcon() {
        if (this.f27972a == null) {
            this.f27972a = new BitmapDescriptor(new BitmapFormater(5));
        }
        return this.f27972a;
    }

    public float getAnchorU() {
        return this.f27973b;
    }

    public float getAnchorV() {
        return this.f27974c;
    }

    public boolean isDraggable() {
        return this.f27975d;
    }

    public boolean isVisible() {
        return this.boVisible;
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

    public float getRotateAngle() {
        return this.fAngle;
    }

    public int getDisplayLevel() {
        return this.f27977f;
    }

    public MarkerOptions displayLevel(int i) {
        this.f27977f = i;
        return this;
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.f27978g;
    }

    public MarkerOptions autoOverturnInfoWindow(boolean z) {
        this.f27978g = z;
        return this;
    }

    public MarkerOptions clockwise(boolean z) {
        this.mClockwise = z;
        return this;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public boolean is2DGround() {
        return this.f27980i;
    }

    public LatLngBounds groundBounds() {
        return this.f27981j;
    }

    public MarkerOptions infoWindowType(int i) {
        this.infoWindowType = i;
        return this;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }
}
