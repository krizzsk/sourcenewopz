package com.didi.map.outer.model;

public final class MyLocationOption {
    public static final int DEFAULT_MAX_RADIUS = 1000;
    public static final int DEFAULT_MIN_RADIUS = 15;
    public static final int LOCATION_TYPE_FOLLOW_CENTER = 2;
    public static final int LOCATION_TYPE_NORMAL = 1;

    /* renamed from: a */
    private final BitmapDescriptor f27990a;

    /* renamed from: b */
    private final BitmapDescriptor f27991b;

    /* renamed from: c */
    private final Float[] f27992c;

    /* renamed from: d */
    private final Integer f27993d;

    /* renamed from: e */
    private final LatLng f27994e;

    /* renamed from: f */
    private final Integer f27995f;

    /* renamed from: g */
    private final Integer f27996g;

    /* renamed from: h */
    private final Boolean f27997h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MyLocationOption(com.didi.map.outer.model.MyLocationOption r11) {
        /*
            r10 = this;
            com.didi.map.outer.model.BitmapDescriptor r1 = r11.f27990a
            com.didi.map.outer.model.BitmapDescriptor r2 = r11.f27991b
            java.lang.Float[] r0 = r11.f27992c
            r3 = 0
            r3 = r0[r3]
            r4 = 1
            r4 = r0[r4]
            java.lang.Integer r5 = r11.f27993d
            com.didi.map.outer.model.LatLng r6 = r11.f27994e
            java.lang.Integer r7 = r11.f27995f
            java.lang.Integer r8 = r11.f27996g
            java.lang.Boolean r9 = r11.f27997h
            r0 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.outer.model.MyLocationOption.<init>(com.didi.map.outer.model.MyLocationOption):void");
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, float f, float f2, int i, LatLng latLng) {
        this(bitmapDescriptor, (BitmapDescriptor) null, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), latLng, 15, 1000, true);
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, float f, float f2, int i, LatLng latLng, int i2, int i3) {
        this(bitmapDescriptor, (BitmapDescriptor) null, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), latLng, Integer.valueOf(i2), Integer.valueOf(i3), true);
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2, Float f, Float f2, Integer num, LatLng latLng, Integer num2, Integer num3) {
        this(bitmapDescriptor, bitmapDescriptor2, f, f2, num, latLng, num2, num3, true);
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2, Float f, Float f2, Integer num, LatLng latLng, Integer num2, Integer num3, Boolean bool) {
        Float valueOf = Float.valueOf(0.5f);
        Float[] fArr = {valueOf, valueOf};
        this.f27992c = fArr;
        this.f27990a = bitmapDescriptor;
        this.f27991b = bitmapDescriptor2;
        this.f27993d = num;
        fArr[0] = f;
        fArr[1] = f2;
        this.f27994e = latLng;
        this.f27995f = num2;
        this.f27996g = num3;
        this.f27997h = bool;
    }

    public BitmapDescriptor getIcon() {
        return this.f27990a;
    }

    public Float getAnchorX() {
        return this.f27992c[0];
    }

    public Float getAnchorY() {
        return this.f27992c[1];
    }

    public Integer getLocationType() {
        return this.f27993d;
    }

    public LatLng getPosition() {
        return this.f27994e;
    }

    public Integer getMinRadius() {
        return this.f27995f;
    }

    public Integer getMaxRadius() {
        return this.f27996g;
    }

    public BitmapDescriptor getFailedIcon() {
        return this.f27991b;
    }

    public Boolean isShowRing() {
        return this.f27997h;
    }

    public String toString() {
        return "MyLocationOption{locationType=" + this.f27993d + ", position=" + this.f27994e + ", minRadius=" + this.f27995f + ", maxRadius=" + this.f27996g + ", showRing=" + this.f27997h + '}';
    }

    public static class Builder {
        private Float anchorX;
        private Float anchorY;
        private BitmapDescriptor failedIcon;
        private BitmapDescriptor icon;
        private Integer locationType;
        private Integer maxRadius;
        private Integer minRadius;
        private LatLng position;
        private Boolean showRing;

        public Builder setAnchorX(float f) {
            this.anchorX = Float.valueOf(f);
            return this;
        }

        public Builder setAnchorY(float f) {
            this.anchorY = Float.valueOf(f);
            return this;
        }

        public Builder setIcon(BitmapDescriptor bitmapDescriptor) {
            this.icon = bitmapDescriptor;
            return this;
        }

        public Builder setFailedIcon(BitmapDescriptor bitmapDescriptor) {
            this.failedIcon = bitmapDescriptor;
            return this;
        }

        public Builder setLocationType(int i) {
            this.locationType = Integer.valueOf(i);
            return this;
        }

        public Builder setPosition(LatLng latLng) {
            this.position = latLng;
            return this;
        }

        public Builder setMinRadius(int i) {
            this.minRadius = Integer.valueOf(i);
            return this;
        }

        public Builder setMaxRadius(int i) {
            this.maxRadius = Integer.valueOf(i);
            return this;
        }

        public Builder setShowRing(boolean z) {
            this.showRing = Boolean.valueOf(z);
            return this;
        }

        public MyLocationOption build() {
            return new MyLocationOption(this.icon, this.failedIcon, this.anchorX, this.anchorY, this.locationType, this.position, this.minRadius, this.maxRadius, this.showRing);
        }
    }
}
