package com.didi.common.map.model;

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
    private int f10812a;

    /* renamed from: b */
    private int f10813b;

    public int describeContents() {
        return 0;
    }

    public GeoPoint() {
        this.f10812a = -35000001;
        this.f10813b = -135000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.f10812a = geoPoint.f10812a;
        this.f10813b = geoPoint.f10813b;
    }

    public GeoPoint(int i, int i2) {
        this.f10812a = i;
        this.f10813b = i2;
    }

    private GeoPoint(Parcel parcel) {
        this.f10812a = parcel.readInt();
        this.f10813b = parcel.readInt();
    }

    public static GeoPoint formString(String str) {
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split.length == 2) {
                    geoPoint.f10812a = Integer.parseInt(split[0]);
                    geoPoint.f10813b = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return geoPoint;
    }

    public int getLatitudeE6() {
        return this.f10812a;
    }

    public void setLatitudeE6(int i) {
        this.f10812a = i;
    }

    public int getLongitudeE6() {
        return this.f10813b;
    }

    public void setLongitudeE6(int i) {
        this.f10813b = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.f10812a = geoPoint.getLatitudeE6();
        this.f10813b = geoPoint.getLongitudeE6();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f10812a == geoPoint.f10812a && this.f10813b == geoPoint.f10813b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (((double) this.f10813b) / 1000000.0d) + "," + (((double) this.f10812a) / 1000000.0d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10812a);
        parcel.writeInt(this.f10813b);
    }
}
