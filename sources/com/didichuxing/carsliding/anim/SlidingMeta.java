package com.didichuxing.carsliding.anim;

import com.didichuxing.carsliding.filter.VectorCoordinateFilter;
import com.didichuxing.carsliding.model.VectorCoordinate;
import java.util.List;

public class SlidingMeta {

    /* renamed from: a */
    private VectorCoordinate f46239a;

    /* renamed from: b */
    private boolean f46240b;

    /* renamed from: c */
    private float f46241c;

    /* renamed from: d */
    private int f46242d;

    /* renamed from: e */
    private List<VectorCoordinateFilter> f46243e;

    public SlidingMeta(VectorCoordinate vectorCoordinate, boolean z, float f, int i, List<VectorCoordinateFilter> list) {
        this.f46239a = vectorCoordinate;
        this.f46240b = z;
        this.f46241c = f;
        this.f46242d = i;
        this.f46243e = list;
    }

    public VectorCoordinate getVectorCoordinate() {
        return this.f46239a;
    }

    public boolean isAngleSensitive() {
        return this.f46240b;
    }

    public float getAngle() {
        return this.f46241c;
    }

    public int getSlideAnimDuration() {
        return this.f46242d;
    }

    public List<VectorCoordinateFilter> getFilterList() {
        return this.f46243e;
    }
}
