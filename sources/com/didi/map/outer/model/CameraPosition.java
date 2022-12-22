package com.didi.map.outer.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class CameraPosition implements Parcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator<CameraPosition>() {
        public CameraPosition createFromParcel(Parcel parcel) {
            return new CameraPosition(parcel);
        }

        public CameraPosition[] newArray(int i) {
            return new CameraPosition[i];
        }
    };
    public final float bearing;
    public LatLng target;
    public final float tilt;
    public final float zoom;

    public int describeContents() {
        return 0;
    }

    public static final class Builder {

        /* renamed from: p */
        private LatLng f27904p;

        /* renamed from: q */
        private float f27905q;

        /* renamed from: r */
        private float f27906r = Float.MIN_VALUE;

        /* renamed from: s */
        private float f27907s = Float.MIN_VALUE;

        public Builder target(LatLng latLng) {
            this.f27904p = latLng;
            return this;
        }

        public Builder zoom(float f) {
            this.f27905q = f;
            return this;
        }

        public Builder tilt(float f) {
            this.f27906r = f;
            return this;
        }

        public Builder bearing(float f) {
            this.f27907s = f;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f27904p, this.f27905q, this.f27906r, this.f27907s);
        }

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.f27904p = cameraPosition.target;
            this.f27905q = cameraPosition.zoom;
            this.f27906r = cameraPosition.tilt;
            this.f27907s = cameraPosition.bearing;
        }
    }

    CameraPosition(Parcel parcel) {
        this.target = new LatLng(parcel.readDouble(), parcel.readDouble());
        this.zoom = parcel.readFloat();
        this.tilt = parcel.readFloat();
        this.bearing = parcel.readFloat();
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2;
        this.bearing = f3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.target, i);
        parcel.writeFloat(this.zoom);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.bearing);
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
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "latlng:" + this.target.latitude + "," + this.target.longitude + ",zoom:" + this.zoom + ",tilt=" + this.tilt + ",bearing:" + this.bearing;
    }
}
