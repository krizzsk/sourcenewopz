package com.didi.map.sdk.sharetrack.google.inner.omega;

import com.google.gson.annotations.SerializedName;

public class LightNavOmegaInfo {
    @SerializedName("eda_anim_driv")
    public int carAnimEDA = -1;
    @SerializedName("lat_anim_driv")
    public double carAnimLat = -1.0d;
    @SerializedName("lng_anim_driv")
    public double carAnimLng = -1.0d;
    @SerializedName("eda_driv")
    public int curEDA = -1;
    @SerializedName("distance_anim")
    public int distanceBetweenLastNode = -1;
    @SerializedName("gpstime")
    public long gpsTime = -1;
    @SerializedName("lat_driv")
    public double matchedLat = -1.0d;
    @SerializedName("lng_driv")
    public double matchedLng = -1.0d;
    @SerializedName("timestamp_ntp")
    public long ntpTimestamp = -1;
    @SerializedName("lat_ori_driv")
    public double originLat = -1.0d;
    @SerializedName("lng_ori_driv")
    public double originLng = -1.0d;
    @SerializedName("timestamp_driv")
    public long sysTime = -1;
}
