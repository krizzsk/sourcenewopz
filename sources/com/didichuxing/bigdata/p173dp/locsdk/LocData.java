package com.didichuxing.bigdata.p173dp.locsdk;

import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.LocData */
public class LocData implements Serializable {
    public int accuracy;
    public double altitude;
    public float bearing;
    public double confidence;
    public int coordinateType;
    public long elapsedRealtime;
    public boolean isCache;
    public long localTime;
    public DDLonLat lonlat;
    public String provider;
    public int speed;
    public long timestamp;
    public double transprob;

    public LocData(double d, double d2, int i, double d3, int i2, long j, long j2, long j3, String str) {
        this.lonlat = new DDLonLat(d, d2, str);
        this.accuracy = i;
        this.confidence = d3;
        this.speed = i2;
        this.timestamp = j;
        this.localTime = j2;
        this.elapsedRealtime = j3;
        this.coordinateType = 1;
    }

    public LocData(double d, double d2, int i, double d3, int i2, long j, long j2, long j3, String str, int i3) {
        this.lonlat = new DDLonLat(d, d2, str);
        this.accuracy = i;
        this.confidence = d3;
        this.speed = i2;
        this.timestamp = j;
        this.localTime = j2;
        this.elapsedRealtime = j3;
        this.coordinateType = i3;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public void setBearing(float f) {
        this.bearing = f;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setCache(boolean z) {
        this.isCache = z;
    }

    public String toJson() {
        return "{\"lon\":" + Const.formatDouble(this.lonlat.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lonlat.lat, 6) + "," + Const.js_rsp_loc_accuracy + ":" + this.accuracy + "," + Const.js_rsp_loc_confidence + ":" + Const.formatDouble(this.confidence, 3) + "," + "\"timestamp\"" + ":" + this.timestamp + "," + "\"localTime\"" + ":" + this.localTime + "," + "\"elapsedRealtime\"" + ":" + this.elapsedRealtime + "," + "\"speed\"" + ":" + this.speed + "," + "\"transprob\"" + ":" + Const.formatDouble(this.transprob, 3) + "}";
    }

    public static LocData fromDIDILocation(DIDILocation dIDILocation, double d) {
        LocData locData = r0;
        LocData locData2 = new LocData(dIDILocation.getLongitude(), dIDILocation.getLatitude(), (int) dIDILocation.getAccuracy(), d, (int) dIDILocation.getSpeed(), dIDILocation.getTime(), dIDILocation.getLocalTime(), dIDILocation.getElapsedRealtime(), dIDILocation.getSource(), dIDILocation.getCoordinateType());
        LocData locData3 = locData;
        locData3.altitude = dIDILocation.getAltitude();
        locData3.bearing = dIDILocation.getBearing();
        locData3.provider = dIDILocation.getProvider();
        return locData3;
    }
}
