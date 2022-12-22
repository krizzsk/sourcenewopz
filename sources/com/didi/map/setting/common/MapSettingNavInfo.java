package com.didi.map.setting.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public class MapSettingNavInfo implements Parcelable {
    public static final Parcelable.Creator<MapSettingNavInfo> CREATOR = new Parcelable.Creator<MapSettingNavInfo>() {
        public MapSettingNavInfo createFromParcel(Parcel parcel) {
            return new MapSettingNavInfo(parcel);
        }

        public MapSettingNavInfo[] newArray(int i) {
            return new MapSettingNavInfo[i];
        }
    };
    public String destName;
    public boolean isAuto;
    public boolean isCarpool;
    public boolean isHawaii = false;
    public boolean isOutNav;
    public double latitude;
    public double longitude;
    public String navPath;
    public boolean needDiversion;
    public String orderId;
    public PendingIntent pendingIntent;
    public String placeId;
    public boolean shouldExcludeInnerNav;
    public boolean shouldHideRememberNavType;

    public int describeContents() {
        return 0;
    }

    public MapSettingNavInfo(String str, double d, double d2, String str2, boolean z, boolean z2, boolean z3, String str3, String str4, PendingIntent pendingIntent2) {
        this.navPath = str;
        this.latitude = d;
        this.longitude = d2;
        this.destName = str2;
        this.isCarpool = z;
        this.isAuto = z2;
        this.isOutNav = z3;
        this.orderId = str3;
        this.placeId = str4;
        this.pendingIntent = pendingIntent2;
    }

    public MapSettingNavInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.navPath);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.destName);
        parcel.writeByte(this.isCarpool ? (byte) 1 : 0);
        parcel.writeByte(this.isAuto ? (byte) 1 : 0);
        parcel.writeByte(this.isOutNav ? (byte) 1 : 0);
        parcel.writeByte(this.isHawaii ? (byte) 1 : 0);
        parcel.writeString(this.orderId);
        parcel.writeString(this.placeId);
        parcel.writeParcelable(this.pendingIntent, i);
        parcel.writeByte(this.needDiversion ? (byte) 1 : 0);
        parcel.writeByte(this.shouldExcludeInnerNav ? (byte) 1 : 0);
        parcel.writeByte(this.shouldHideRememberNavType ? (byte) 1 : 0);
    }

    protected MapSettingNavInfo(Parcel parcel) {
        boolean z = false;
        this.navPath = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.destName = parcel.readString();
        this.isCarpool = parcel.readByte() != 0;
        this.isAuto = parcel.readByte() != 0;
        this.isOutNav = parcel.readByte() != 0;
        this.isHawaii = parcel.readByte() != 0;
        this.orderId = parcel.readString();
        this.placeId = parcel.readString();
        this.pendingIntent = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.needDiversion = parcel.readByte() != 0;
        this.shouldExcludeInnerNav = parcel.readByte() != 0;
        this.shouldHideRememberNavType = parcel.readByte() != 0 ? true : z;
    }
}
