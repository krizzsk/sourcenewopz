package com.rider.rlab_im_map_plugin.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class ImBusinessBean implements Parcelable {
    public static final Parcelable.Creator<ImBusinessBean> CREATOR = new Parcelable.Creator<ImBusinessBean>() {
        public ImBusinessBean createFromParcel(Parcel parcel) {
            return new ImBusinessBean(parcel);
        }

        public ImBusinessBean[] newArray(int i) {
            return new ImBusinessBean[i];
        }
    };

    /* renamed from: a */
    private double f55832a;

    /* renamed from: b */
    private double f55833b;

    /* renamed from: c */
    private int f55834c;

    /* renamed from: d */
    private int f55835d;

    /* renamed from: e */
    private HashMap<String, Object> f55836e;

    /* renamed from: f */
    private HashMap<String, Object> f55837f;

    /* renamed from: g */
    private String f55838g;

    /* renamed from: h */
    private String f55839h;

    /* renamed from: i */
    private String f55840i;

    /* renamed from: j */
    private String f55841j;

    /* renamed from: k */
    private String f55842k;

    public int describeContents() {
        return 0;
    }

    public ImBusinessBean() {
    }

    protected ImBusinessBean(Parcel parcel) {
        ClassLoader classLoader = Object.class.getClassLoader();
        this.f55832a = parcel.readDouble();
        this.f55833b = parcel.readDouble();
        this.f55835d = parcel.readInt();
        this.f55834c = parcel.readInt();
        this.f55836e = parcel.readHashMap(classLoader);
        this.f55838g = parcel.readString();
        this.f55839h = parcel.readString();
        this.f55840i = parcel.readString();
        this.f55841j = parcel.readString();
        this.f55842k = parcel.readString();
        this.f55837f = parcel.readHashMap(classLoader);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f55832a);
        parcel.writeDouble(this.f55833b);
        parcel.writeInt(this.f55835d);
        parcel.writeInt(this.f55834c);
        parcel.writeMap(this.f55836e);
        parcel.writeString(this.f55838g);
        parcel.writeString(this.f55839h);
        parcel.writeString(this.f55840i);
        parcel.writeString(this.f55841j);
        parcel.writeString(this.f55842k);
        parcel.writeMap(this.f55837f);
    }

    public double getLat() {
        return this.f55832a;
    }

    public void setLat(double d) {
        this.f55832a = d;
    }

    public double getLng() {
        return this.f55833b;
    }

    public void setLng(double d) {
        this.f55833b = d;
    }

    public int getType() {
        return this.f55834c;
    }

    public void setType(int i) {
        this.f55834c = i;
    }

    public int getNav() {
        return this.f55835d;
    }

    public void setNav(int i) {
        this.f55835d = i;
    }

    public String getAddressName() {
        return this.f55838g;
    }

    public void setAddressName(String str) {
        this.f55838g = str;
    }

    public String getSectionName() {
        return this.f55839h;
    }

    public void setSectionName(String str) {
        this.f55839h = str;
    }

    public HashMap<String, Object> getMap() {
        return this.f55836e;
    }

    public void setMap(HashMap<String, Object> hashMap) {
        this.f55836e = hashMap;
    }

    public HashMap<String, Object> getOmegaParams() {
        return this.f55837f;
    }

    public void setOmegaParams(HashMap<String, Object> hashMap) {
        this.f55837f = hashMap;
    }

    public String getNetParams() {
        return this.f55840i;
    }

    public void setNetParams(String str) {
        this.f55840i = str;
    }

    public String getOrderId() {
        return this.f55841j;
    }

    public void setOrderId(String str) {
        this.f55841j = str;
    }

    public String getCOrderId() {
        return this.f55842k;
    }

    public void setCOrderId(String str) {
        this.f55842k = str;
    }
}
