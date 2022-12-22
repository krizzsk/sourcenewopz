package com.didi.map.sdk.passengerlocation;

import android.graphics.Bitmap;
import com.didi.common.map.model.GpsLocation;

public class PassengerInfo {

    /* renamed from: a */
    private String f28575a = "";

    /* renamed from: b */
    private long f28576b;

    /* renamed from: c */
    private GpsLocation f28577c = null;

    /* renamed from: d */
    private String f28578d = null;

    /* renamed from: e */
    private Bitmap f28579e = null;

    /* renamed from: f */
    private int f28580f;

    /* renamed from: g */
    private GpsLocation f28581g = null;

    /* renamed from: h */
    private String f28582h = "";

    public PassengerInfo() {
    }

    public PassengerInfo(String str, GpsLocation gpsLocation, Bitmap bitmap) {
        this.f28575a = str;
        this.f28577c = gpsLocation;
        this.f28579e = bitmap;
    }

    public PassengerInfo(String str, String str2, int i) {
        this.f28575a = str;
        this.f28580f = i;
        this.f28582h = str2;
    }

    public PassengerInfo(PassengerInfo passengerInfo) {
        if (passengerInfo != null) {
            this.f28575a = passengerInfo.getId();
            this.f28576b = passengerInfo.getPassengerId();
            this.f28577c = passengerInfo.getGpsLocation();
            this.f28578d = passengerInfo.getHeadUrl();
            this.f28579e = passengerInfo.getHeadIcon();
            this.f28580f = passengerInfo.getColorIndex();
            this.f28581g = passengerInfo.getFinalPos();
            this.f28582h = passengerInfo.getOrderId();
        }
    }

    public String getId() {
        return this.f28575a;
    }

    public void setId(String str) {
        this.f28575a = str;
    }

    public long getPassengerId() {
        return this.f28576b;
    }

    public void setPassengerId(long j) {
        this.f28576b = j;
    }

    public GpsLocation getGpsLocation() {
        return this.f28577c;
    }

    public void setGpsLocation(GpsLocation gpsLocation) {
        this.f28577c = gpsLocation;
    }

    public String getHeadUrl() {
        return this.f28578d;
    }

    public void setHeadUrl(String str) {
        this.f28578d = str;
    }

    public Bitmap getHeadIcon() {
        return this.f28579e;
    }

    public void setHeadIcon(Bitmap bitmap) {
        this.f28579e = bitmap;
    }

    public int getColorIndex() {
        return this.f28580f;
    }

    public void setColorIndex(int i) {
        this.f28580f = i;
    }

    public GpsLocation getFinalPos() {
        return this.f28581g;
    }

    public void setFinalPos(GpsLocation gpsLocation) {
        this.f28581g = gpsLocation;
    }

    public String getOrderId() {
        return this.f28582h;
    }

    public void setOrderId(String str) {
        this.f28582h = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:" + this.f28575a);
        sb.append("|colorIndex:" + this.f28580f);
        sb.append("|oid:" + this.f28582h);
        if (this.f28577c != null) {
            sb.append("|origin.lat:" + this.f28577c.latitude);
            sb.append("|origin:lon" + this.f28577c.longitude);
        } else {
            sb.append("|origin:null");
        }
        if (this.f28581g != null) {
            sb.append("|final.lat:" + this.f28581g.latitude);
            sb.append("|final:lon" + this.f28581g.longitude);
        } else {
            sb.append("|final:null");
        }
        sb.append("|headUrl:" + this.f28578d);
        return sb.toString();
    }
}
