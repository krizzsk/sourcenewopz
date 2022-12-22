package com.didi.map.location;

import com.didi.map.outer.model.LatLng;

public class LocationResult {
    public static final int STATUS_GPS_LOCATION_SUCC = 2;
    public static final int STATUS_LOCATION_UNKNOWN = -1;
    public static final int STATUS_NET_LOCATION_SUCC = 0;
    public double accuracy = 0.0d;
    @Deprecated
    public double accuracyRevised = 0.0d;
    public double altitude = 0.0d;
    public double direction = 0.0d;
    public float flpBearing = -1.0f;
    public float flpConfidence = -1.0f;
    public int flpStatus = -1;
    public int flpVdrConfidence = 0;
    public int gpsSource = -1;
    public double latitude = 0.0d;
    public String locAddr = null;
    public String locName = null;
    public String locSvid = null;
    public long localTime = System.currentTimeMillis();
    public double longitude = 0.0d;
    public float orgAcc = -1.0f;
    public float orgDir = -1.0f;
    public double orgLat = -1.0d;
    public double orgLng = -1.0d;
    public int rssi = 0;
    public int satellitesNum = -1;
    public double speed = 0.0d;
    public int status = -1;
    public long timestamp = 0;

    public void setLocation(LocationResult locationResult) {
        this.status = locationResult.status;
        this.latitude = locationResult.latitude;
        this.longitude = locationResult.longitude;
        this.altitude = locationResult.altitude;
        this.accuracy = locationResult.accuracy;
        this.direction = locationResult.direction;
        this.rssi = locationResult.rssi;
        this.locAddr = locationResult.locAddr;
        this.locName = locationResult.locName;
        this.locSvid = locationResult.locSvid;
        this.speed = locationResult.speed;
        this.timestamp = locationResult.timestamp;
        this.flpStatus = locationResult.flpStatus;
        this.flpConfidence = locationResult.flpConfidence;
        this.flpBearing = locationResult.flpBearing;
        this.gpsSource = locationResult.gpsSource;
        this.localTime = locationResult.localTime;
        this.orgLng = locationResult.orgLng;
        this.orgLat = locationResult.orgLat;
        this.orgDir = locationResult.orgDir;
        this.orgAcc = locationResult.orgAcc;
        this.satellitesNum = locationResult.satellitesNum;
    }

    public void setLatLng(LatLng latLng) {
        this.latitude = latLng.latitude;
        this.longitude = latLng.longitude;
    }
}
