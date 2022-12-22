package com.didi.common.map.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public final class LatLng implements Parcelable, Serializable {
    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() {
        public LatLng createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        public LatLng[] newArray(int i) {
            return new LatLng[i];
        }
    };
    public double altitude;
    public double latitude;
    public double longitude;
    private int versionCode;

    public int describeContents() {
        return 0;
    }

    LatLng(int i, double d, double d2, double d3) {
        this.altitude = 0.0d;
        this.versionCode = i;
        this.longitude = d2;
        this.latitude = d;
    }

    public LatLng(double d, double d2) {
        this(1, d, d2, 0.0d);
    }

    public LatLng(double d, double d2, double d3) {
        this(1, d, d2, d3);
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.versionCode);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.altitude);
    }

    private LatLng(Parcel parcel) {
        this.altitude = 0.0d;
        this.versionCode = parcel.readInt();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.altitude = parcel.readDouble();
    }
}
