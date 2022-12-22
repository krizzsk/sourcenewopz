package com.didi.common.map.model;

public final class CameraPosition {

    /* renamed from: a */
    private final int f10801a;
    public final float bearing;
    public int gesture;
    public int reason;
    public final LatLng target;
    public final float tilt;
    public final double zoom;

    public int describeContents() {
        return 0;
    }

    CameraPosition(int i, LatLng latLng, double d, float f, float f2) {
        this.f10801a = i;
        this.target = latLng;
        this.zoom = d;
        this.tilt = f + 0.0f;
        this.bearing = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public CameraPosition(LatLng latLng, double d, float f, float f2) {
        this(1, latLng, d, f, f2);
    }

    public int hashCode() {
        return new Object[]{this.target, Double.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)}.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo45168a() {
        return this.f10801a;
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, double d) {
        return new CameraPosition(latLng, d, 0.0f, 0.0f);
    }

    public static final CameraPosition fromLatLng(LatLng latLng) {
        return new CameraPosition(latLng, -1.0d, 0.0f, 0.0f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Double.doubleToLongBits(this.zoom) == Double.doubleToLongBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "target:" + this.target + "zoom:" + Double.valueOf(this.zoom) + "tilt:" + Float.valueOf(this.tilt) + "bearing:" + Float.valueOf(this.bearing);
    }

    public static final class Builder {
        private float bearing;
        private LatLng target;
        private float tilt;
        private double zoom;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.target = cameraPosition.target;
            this.zoom = cameraPosition.zoom;
            this.tilt = cameraPosition.tilt;
            this.bearing = cameraPosition.bearing;
        }

        public Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public Builder zoom(float f) {
            this.zoom = (double) f;
            return this;
        }

        public Builder tilt(float f) {
            this.tilt = f;
            return this;
        }

        public Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
        }
    }
}
