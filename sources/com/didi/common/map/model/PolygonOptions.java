package com.didi.common.map.model;

import android.graphics.Typeface;
import com.didi.common.map.internal.IMapElementOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends IMapElementOptions {

    /* renamed from: a */
    private List<LatLng> f10890a;

    /* renamed from: b */
    private List<List<LatLng>> f10891b;

    /* renamed from: c */
    private float f10892c;

    /* renamed from: d */
    private int f10893d;

    /* renamed from: e */
    private int f10894e;

    /* renamed from: f */
    private boolean f10895f;

    /* renamed from: g */
    private String f10896g;

    /* renamed from: h */
    private int f10897h;

    /* renamed from: i */
    private Typeface f10898i;

    /* renamed from: j */
    private int f10899j;

    /* renamed from: k */
    private int f10900k;

    /* renamed from: l */
    private int f10901l;

    /* renamed from: m */
    private float f10902m;

    /* renamed from: n */
    private float f10903n;

    public static final class PolygonType {
        public static final int POLYGON_PATTERN_DASHED = 1;
        public static final int POLYGON_PATTERN_SOLID = 0;
    }

    public PolygonOptions() {
        this.f10892c = -1.0f;
        this.f10893d = -1;
        this.f10894e = -1;
        this.f10895f = false;
        this.f10896g = null;
        this.f10897h = -16777216;
        this.f10898i = Typeface.DEFAULT;
        this.f10899j = Integer.MAX_VALUE;
        this.f10900k = 1;
        this.f10901l = 0;
        this.f10890a = new ArrayList();
        this.f10891b = new ArrayList();
    }

    public PolygonOptions(List<LatLng> list, List list2, float f, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f10892c = -1.0f;
        this.f10893d = -1;
        this.f10894e = -1;
        this.f10895f = false;
        this.f10896g = null;
        this.f10897h = -16777216;
        this.f10898i = Typeface.DEFAULT;
        this.f10899j = Integer.MAX_VALUE;
        this.f10900k = 1;
        this.f10901l = 0;
        this.f10890a = list;
        this.f10891b = list2;
        this.f10892c = f;
        this.f10893d = i;
        this.f10894e = i2;
        this.f10895f = z2;
        zIndex(i3);
        visible(z);
        clickable(z3);
    }

    public PolygonOptions add(LatLng latLng) {
        this.f10890a.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f10890a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        this.f10890a.addAll(list);
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable == null) {
            return this;
        }
        for (LatLng next : iterable) {
            if (next != null) {
                this.f10890a.add(next);
            }
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng next : iterable) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.f10891b.add(arrayList);
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f10892c = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f10893d = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f10894e = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f10895f = z;
        return this;
    }

    public PolygonOptions text(String str) {
        this.f10896g = str;
        return this;
    }

    public PolygonOptions textColor(int i) {
        this.f10897h = i;
        return this;
    }

    public PolygonOptions textTypeface(Typeface typeface) {
        this.f10898i = typeface;
        return this;
    }

    public PolygonOptions maxTextSize(int i) {
        this.f10899j = i;
        return this;
    }

    public PolygonOptions minTextSize(int i) {
        this.f10900k = i;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f10890a;
    }

    public List<List<LatLng>> getHoles() {
        return this.f10891b;
    }

    public float getStrokeWidth() {
        return this.f10892c;
    }

    public int getStrokeColor() {
        return this.f10893d;
    }

    public int getFillColor() {
        return this.f10894e;
    }

    public boolean isGeodesic() {
        return this.f10895f;
    }

    public String getText() {
        return this.f10896g;
    }

    public int getTextColor() {
        return this.f10897h;
    }

    public Typeface getTextTypeface() {
        return this.f10898i;
    }

    public int getMaxTextSize() {
        return this.f10899j;
    }

    public int getMinTextSize() {
        return this.f10900k;
    }

    public int getPolygonPatternType() {
        return this.f10901l;
    }

    public void setPolygonPatternType(int i) {
        this.f10901l = i;
    }

    public float getDashLengthPx() {
        return this.f10902m;
    }

    public void setDashLengthPx(int i) {
        this.f10902m = (float) i;
    }

    public float getGapLengthPx() {
        return this.f10903n;
    }

    public void setGapLengthPx(int i) {
        this.f10903n = (float) i;
    }
}
