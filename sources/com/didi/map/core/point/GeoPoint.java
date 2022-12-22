package com.didi.map.core.point;

import android.os.Parcel;
import android.os.Parcelable;

public class GeoPoint implements Parcelable {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator<GeoPoint>() {
        public GeoPoint createFromParcel(Parcel parcel) {
            return new GeoPoint(parcel);
        }

        public GeoPoint[] newArray(int i) {
            return new GeoPoint[i];
        }
    };

    /* renamed from: a */
    private int f24755a;

    /* renamed from: b */
    private int f24756b;

    public int describeContents() {
        return 0;
    }

    public GeoPoint() {
        this.f24755a = -35000001;
        this.f24756b = -135000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.f24755a = geoPoint.f24755a;
        this.f24756b = geoPoint.f24756b;
    }

    public GeoPoint(int i, int i2) {
        this.f24755a = i;
        this.f24756b = i2;
    }

    public int getLatitudeE6() {
        return this.f24755a;
    }

    public int getLongitudeE6() {
        return this.f24756b;
    }

    public void setLatitudeE6(int i) {
        this.f24755a = i;
    }

    public void setLongitudeE6(int i) {
        this.f24756b = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.f24755a = geoPoint.getLatitudeE6();
        this.f24756b = geoPoint.getLongitudeE6();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f24755a == geoPoint.f24755a && this.f24756b == geoPoint.f24756b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (((double) this.f24756b) / 1000000.0d) + "," + (((double) this.f24755a) / 1000000.0d);
    }

    public static GeoPoint formString(String str) {
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split.length == 2) {
                    geoPoint.f24755a = Integer.parseInt(split[0]);
                    geoPoint.f24756b = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return geoPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24755a);
        parcel.writeInt(this.f24756b);
    }

    private GeoPoint(Parcel parcel) {
        this.f24755a = parcel.readInt();
        this.f24756b = parcel.readInt();
    }
}
