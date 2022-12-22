package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;

public final class MarkerOptions extends IMapElementOptions {
    public static final float DEFAULT_SIZE = 20.0f;

    /* renamed from: a */
    private int f10866a = 1;

    /* renamed from: b */
    private LatLng f10867b;

    /* renamed from: c */
    private String f10868c;

    /* renamed from: d */
    private String f10869d;

    /* renamed from: e */
    private BitmapDescriptor f10870e = BitmapDescriptorFactory.defaultMarker();

    /* renamed from: f */
    private float f10871f = 0.5f;

    /* renamed from: g */
    private float f10872g = 1.0f;

    /* renamed from: h */
    private boolean f10873h;

    /* renamed from: i */
    private boolean f10874i = true;

    /* renamed from: j */
    private float f10875j = 0.0f;

    /* renamed from: k */
    private float f10876k = 1.0f;

    /* renamed from: l */
    private boolean f10877l = false;

    /* renamed from: m */
    private boolean f10878m = false;

    /* renamed from: n */
    private float f10879n = 20.0f;

    /* renamed from: o */
    private boolean f10880o;

    public int getVersionCode() {
        return this.f10866a;
    }

    public MarkerOptions alpha(float f) {
        this.f10876k = f;
        return this;
    }

    public MarkerOptions avoidAnnocation(boolean z) {
        this.f10880o = z;
        return this;
    }

    public boolean isAvoidAnnocation() {
        return this.f10880o;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f10871f = f;
        this.f10872g = f2;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f10873h = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.f10874i = z;
        return this;
    }

    public float getAlpha() {
        return this.f10876k;
    }

    public float getAnchorU() {
        return this.f10871f;
    }

    public float getAnchorV() {
        return this.f10872g;
    }

    public BitmapDescriptor getIcon() {
        return this.f10870e;
    }

    public LatLng getPosition() {
        return this.f10867b;
    }

    public float getRotation() {
        return this.f10875j;
    }

    public String getSnippet() {
        return this.f10869d;
    }

    public String getTitle() {
        return this.f10868c;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f10870e = bitmapDescriptor;
        return this;
    }

    public boolean isDraggable() {
        return this.f10873h;
    }

    public boolean isFlat() {
        return this.f10874i;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f10867b = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.f10875j = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f10869d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f10868c = str;
        return this;
    }

    public float getSize() {
        return this.f10879n;
    }

    public MarkerOptions size(float f) {
        this.f10879n = f;
        return this;
    }

    public MarkerOptions clockwise(boolean z) {
        this.f10877l = z;
        return this;
    }

    public boolean isClockwise() {
        return this.f10877l;
    }

    public MarkerOptions dodgeAnnotation(boolean z) {
        this.f10878m = z;
        return this;
    }

    public boolean isDodgeAnnotation() {
        return this.f10878m;
    }
}
