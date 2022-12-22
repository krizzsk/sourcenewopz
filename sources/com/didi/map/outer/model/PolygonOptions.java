package com.didi.map.outer.model;

import android.graphics.Typeface;
import com.didi.map.alpha.adapt.MapUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonOptions {

    /* renamed from: a */
    private final List<LatLng> f28001a = new ArrayList();

    /* renamed from: b */
    private float f28002b = 1.0f;

    /* renamed from: c */
    private int f28003c = -16777216;

    /* renamed from: d */
    private int f28004d = MapUtil.COLOR_DEFAULT_POLYLINE;

    /* renamed from: e */
    private float f28005e = 0.0f;

    /* renamed from: f */
    private boolean f28006f = true;

    /* renamed from: g */
    private boolean f28007g = false;

    /* renamed from: h */
    private String f28008h = "";

    /* renamed from: i */
    private int f28009i = -16777216;

    /* renamed from: j */
    private Typeface f28010j = Typeface.DEFAULT;

    /* renamed from: k */
    private int f28011k = Integer.MAX_VALUE;

    /* renamed from: l */
    private int f28012l = 1;

    /* renamed from: m */
    private int f28013m = -1;

    /* renamed from: n */
    private boolean f28014n = false;

    /* renamed from: o */
    private boolean f28015o = false;

    /* renamed from: p */
    private boolean f28016p = false;

    public PolygonOptions setForceLoad(boolean z) {
        this.f28014n = z;
        return this;
    }

    public boolean getIsForceLoad() {
        return this.f28014n;
    }

    public void setPoints(Iterable<LatLng> iterable) {
        List<LatLng> list = this.f28001a;
        if (list != null) {
            list.clear();
            if (iterable != null) {
                addAll(iterable);
            }
        }
    }

    public PolygonOptions add(LatLng latLng) {
        this.f28001a.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f28001a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        this.f28001a.addAll(list);
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f28001a.add(add);
        }
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f28002b = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f28003c = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f28004d = i;
        return this;
    }

    public PolygonOptions zIndex(float f) {
        this.f28005e = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f28006f = z;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f28007g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f28001a;
    }

    public float getStrokeWidth() {
        return this.f28002b;
    }

    public int getStrokeColor() {
        return this.f28003c;
    }

    public int getFillColor() {
        return this.f28004d;
    }

    public float getZIndex() {
        return this.f28005e;
    }

    public boolean isVisible() {
        return this.f28006f;
    }

    public boolean isGeodesic() {
        return this.f28007g;
    }

    public PolygonOptions text(String str) {
        this.f28008h = str;
        return this;
    }

    public String getText() {
        return this.f28008h;
    }

    public PolygonOptions textColor(int i) {
        this.f28009i = i;
        return this;
    }

    public int getTextColor() {
        return this.f28009i;
    }

    public PolygonOptions textTypeface(Typeface typeface) {
        this.f28010j = typeface;
        return this;
    }

    public PolygonOptions bellowRoute(boolean z) {
        this.f28015o = z;
        return this;
    }

    public boolean getIsBellowRoute() {
        return this.f28015o;
    }

    public Typeface getTypeface() {
        return this.f28010j;
    }

    public PolygonOptions maxTextSize(int i) {
        this.f28011k = i;
        return this;
    }

    public int getMaxTextSize() {
        return this.f28011k;
    }

    public PolygonOptions minTextSize(int i) {
        this.f28012l = i;
        return this;
    }

    public int getMinTextSize() {
        return this.f28012l;
    }

    /* renamed from: a */
    private PolygonOptions m19949a(int i) {
        this.f28013m = i;
        return this;
    }

    /* renamed from: a */
    private int m19948a() {
        return this.f28013m;
    }

    public boolean isClickable() {
        return this.f28016p;
    }

    public PolygonOptions setClickable(boolean z) {
        this.f28016p = z;
        return this;
    }
}
