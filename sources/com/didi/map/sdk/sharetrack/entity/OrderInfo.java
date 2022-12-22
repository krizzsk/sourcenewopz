package com.didi.map.sdk.sharetrack.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderInfo implements Parcelable {
    public static final Parcelable.Creator<OrderInfo> CREATOR = new Parcelable.Creator<OrderInfo>() {
        public OrderInfo createFromParcel(Parcel parcel) {
            return new OrderInfo(parcel);
        }

        public OrderInfo[] newArray(int i) {
            return new OrderInfo[i];
        }
    };

    /* renamed from: a */
    private long f28644a;

    /* renamed from: b */
    private String f28645b = "";

    /* renamed from: c */
    private int f28646c;

    /* renamed from: d */
    private String f28647d;

    /* renamed from: e */
    private String f28648e;

    public int describeContents() {
        return 0;
    }

    public OrderInfo() {
    }

    protected OrderInfo(Parcel parcel) {
        this.f28644a = parcel.readLong();
        this.f28645b = parcel.readString();
        this.f28646c = parcel.readInt();
        this.f28647d = parcel.readString();
        this.f28648e = parcel.readString();
    }

    public long getPassengerId() {
        return this.f28644a;
    }

    public void setPassengerId(long j) {
        this.f28644a = j;
    }

    public String getOrderId() {
        return this.f28645b;
    }

    public void setOrderId(String str) {
        this.f28645b = str;
    }

    public int getOrderStage() {
        return this.f28646c;
    }

    public void setOrderStage(int i) {
        this.f28646c = i;
    }

    public String getPassengerHeadUrl() {
        return this.f28647d;
    }

    public void setPassengerHeadUrl(String str) {
        this.f28647d = str;
    }

    public String getPassengerPhoneNumber() {
        return this.f28648e;
    }

    public void setPassengerPhoneNumber(String str) {
        this.f28648e = str;
    }

    public String toString() {
        return "OrderInfo{passengerId=" + this.f28644a + ", orderId='" + this.f28645b + '\'' + ", orderStage=" + this.f28646c + ", passengerHeadUrl='" + this.f28647d + '\'' + ", passengerPhoneNumber='" + this.f28648e + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f28644a);
        parcel.writeString(this.f28645b);
        parcel.writeInt(this.f28646c);
        parcel.writeString(this.f28647d);
        parcel.writeString(this.f28648e);
    }
}
