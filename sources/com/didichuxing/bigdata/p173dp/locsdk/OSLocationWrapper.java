package com.didichuxing.bigdata.p173dp.locsdk;

import android.location.Location;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.OSLocationWrapper */
public class OSLocationWrapper {
    public static final int GPS_SOURCE_TYPE_CALLBACK = 0;
    public static final int GPS_SOURCE_TYPE_LAST_LOCATION = 1;

    /* renamed from: a */
    private Location f45709a;

    /* renamed from: b */
    private long f45710b;

    /* renamed from: c */
    private int f45711c = -1;

    public int getGpsSourceType() {
        return this.f45711c;
    }

    public void setGpsSourceType(int i) {
        this.f45711c = i;
    }

    public OSLocationWrapper(Location location, long j) {
        this.f45709a = location;
        this.f45710b = j;
    }

    public Location getLocation() {
        return this.f45709a;
    }

    public void setLocation(Location location) {
        this.f45709a = location;
    }

    public long getLocalTime() {
        return this.f45710b;
    }

    public void setLocalTime(long j) {
        this.f45710b = j;
    }

    public String info() {
        if (this.f45709a == null) {
            return "";
        }
        return Const.joLeft + Const.formatDouble(this.f45709a.getLongitude(), 6) + "," + Const.formatDouble(this.f45709a.getLatitude(), 6) + "," + this.f45709a.getAccuracy() + "," + this.f45709a.getBearing() + "," + this.f45709a.getTime() + "," + this.f45709a.getSpeed() + "," + "nlp" + "," + "}";
    }
}
