package com.didi.map.sdk.sharetrack.google.inner.model;

public class PointInfo {
    public int accuracy;
    public String driver_id;
    public double lat;
    public double lng;

    public String toString() {
        return String.format("poi(%f,%f), accuracy:%d, driver_id:%s", new Object[]{Double.valueOf(this.lat), Double.valueOf(this.lng), Integer.valueOf(this.accuracy), this.driver_id});
    }
}
