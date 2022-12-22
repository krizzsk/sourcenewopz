package com.didichuxing.carsliding.model;

import com.didichuxing.carsliding.filter.VectorCoordinateFilter;
import java.util.ArrayList;
import java.util.List;

public class RenderParams {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DriverCollection f46256a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f46257b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RenderStrategy f46258c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f46259d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f46260e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f46261f;

    /* renamed from: g */
    private int f46262g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<VectorCoordinateFilter> f46263h;

    private RenderParams() {
        this.f46256a = new DriverCollection();
        this.f46258c = RenderStrategy.SLIDE;
        this.f46261f = true;
        this.f46262g = 0;
        this.f46263h = new ArrayList();
    }

    public String toString() {
        return "driverCollection=" + this.f46256a + ",slidingTimeMillis=" + this.f46257b + ",renderStrategy=" + this.f46258c + ",fadeInAnimEnable=" + this.f46259d + ",fadeOutAnimEnable=" + this.f46260e + ",angleSensitive=" + this.f46261f;
    }

    public int getDriverMarkerZindex() {
        return this.f46262g;
    }

    public void setDriverMarkerZindex(int i) {
        this.f46262g = i;
    }

    public DriverCollection getDriverCollection() {
        return this.f46256a;
    }

    public long getSlidingTimeMillis() {
        return this.f46257b;
    }

    public RenderStrategy getRenderStrategy() {
        return this.f46258c;
    }

    public boolean isFadeInAnimEnable() {
        return this.f46259d;
    }

    public boolean isFadeOutAnimEnable() {
        return this.f46260e;
    }

    public boolean isAngleSensitive() {
        return this.f46261f;
    }

    public List<VectorCoordinateFilter> getFilterList() {
        return this.f46263h;
    }

    public static class Builder {

        /* renamed from: P */
        private RenderParams f46264P = new RenderParams();

        public Builder setDriverCollection(DriverCollection driverCollection) {
            if (driverCollection != null) {
                DriverCollection unused = this.f46264P.f46256a = driverCollection;
            }
            return this;
        }

        public Builder setSlidingTimeMillis(long j) {
            long unused = this.f46264P.f46257b = j;
            return this;
        }

        public Builder setRenderStrategy(RenderStrategy renderStrategy) {
            RenderStrategy unused = this.f46264P.f46258c = renderStrategy;
            return this;
        }

        public Builder setFadeAnimEnable(boolean z, boolean z2) {
            boolean unused = this.f46264P.f46259d = z;
            boolean unused2 = this.f46264P.f46260e = z2;
            return this;
        }

        public Builder setAngleSensitive(boolean z) {
            boolean unused = this.f46264P.f46261f = z;
            return this;
        }

        public Builder addVectorCoordinateFilter(VectorCoordinateFilter vectorCoordinateFilter) {
            this.f46264P.f46263h.add(vectorCoordinateFilter);
            return this;
        }

        public RenderParams create() {
            return this.f46264P;
        }
    }
}
