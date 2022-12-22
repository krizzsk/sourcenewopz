package com.didi.map.outer.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.hawaii.utils.BitmapUtil;

public class BubbleOptions {

    /* renamed from: a */
    private Marker f27893a;

    /* renamed from: b */
    private String f27894b;

    /* renamed from: c */
    private LatLng f27895c;

    /* renamed from: d */
    private int f27896d = 0;

    /* renamed from: e */
    private int f27897e = 0;

    /* renamed from: f */
    private float f27898f = 0.5f;

    /* renamed from: g */
    private float f27899g = 0.5f;

    /* renamed from: h */
    private int f27900h = 0;

    /* renamed from: i */
    private View f27901i;

    /* renamed from: j */
    private Drawable[] f27902j = null;

    /* renamed from: k */
    private boolean f27903k = false;

    public BubbleOptions marker(Marker marker) {
        this.f27893a = marker;
        position(marker.getPosition());
        markerAnchor(marker.getAnchorU(), marker.getAnchorV());
        return this;
    }

    public Marker getMarker() {
        return this.f27893a;
    }

    public BubbleOptions markerSize(int i, int i2) {
        this.f27896d = i;
        this.f27897e = i2;
        return this;
    }

    public int getMarkerWidth() {
        return this.f27896d;
    }

    public int getMarkerHeight() {
        return this.f27897e;
    }

    public BubbleOptions markerAnchor(float f, float f2) {
        this.f27898f = f;
        this.f27899g = f2;
        return this;
    }

    public float getMarkerAnchorU() {
        return this.f27898f;
    }

    public float getMarkerAnchorV() {
        return this.f27899g;
    }

    public BubbleOptions content(String str) {
        this.f27894b = str;
        return this;
    }

    public String getContent() {
        return this.f27894b;
    }

    public BubbleOptions position(LatLng latLng) {
        this.f27895c = latLng;
        return this;
    }

    public LatLng getPosition() {
        return this.f27895c;
    }

    public BubbleOptions displayLevel(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f27900h = i;
        return this;
    }

    public int getDisplayLevel() {
        return this.f27900h;
    }

    public BubbleOptions contentView(View view) {
        this.f27901i = view;
        return this;
    }

    public View getContentView() {
        return this.f27901i;
    }

    public BubbleOptions background(Drawable[] drawableArr) {
        this.f27902j = drawableArr;
        return this;
    }

    public BubbleOptions background(Bitmap[] bitmapArr) {
        if (bitmapArr != null) {
            this.f27902j = new Drawable[4];
            int length = bitmapArr.length;
            for (int i = 0; i < length; i++) {
                this.f27902j[i] = BitmapUtil.bitmapToDrawable(bitmapArr[i]);
            }
        }
        return this;
    }

    public Drawable[] getBackground() {
        return this.f27902j;
    }

    public BubbleOptions setOnTapHidden(boolean z) {
        this.f27903k = z;
        return this;
    }

    public boolean getOnTapHidden() {
        return this.f27903k;
    }
}
