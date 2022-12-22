package com.didichuxing.bigdata.p173dp.locsdk;

import android.location.Location;
import android.os.Bundle;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocation */
public class DIDILocation implements Serializable {
    public static final String CELL_PROVIDER = "didi_cell";
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static final int ERROR_STATUS = 5;
    public static final String EXTRA_KEY_FIX_LOC_SATELLITE_NUM = "EXTRA_KEY_FIX_LOC_SATELLITE_NUM";
    public static final String EXTRA_KEY_FLP_STATIC_STATUS = "EXTRA_KEY_FLP_STATIC_STATUS";
    public static final String EXTRA_KEY_FLP_STRATEGY = "EXTRA_KEY_FLP_STRATEGY";
    public static final String EXTRA_KEY_FLP_VDR_BEARING = "EXTRA_KEY_FLP_VDR_BEARING";
    public static final String EXTRA_KEY_FLP_VDR_BEARING_CONFIDENCE = "EXTRA_KEY_FLP_VDR_BEARING_CONFIDENCE";
    public static final String EXTRA_KEY_FLP_VDR_CONFIDENCE_4USE = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.DIDILocation.EXTRA_KEY_FLP_VDR_CONFIDENCE_4USE";
    public static final String EXTRA_KEY_GPS_SIGNAL_LEVEL = "EXTRA_KEY_GPS_SIGNAL_LEVEL";
    public static final String EXTRA_KEY_RECV_GPS_TICK = "com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_RECV_GPS_TICK";
    public static final String EXTRA_KEY_SIMPLIFIED_FLP_STRATEGY = "EXTRA_KEY_SIMPLIFIED_FLP_STRATEGY";
    public static final String EXTRA_KEY_STRATEGY_FLAGS = "com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STRATEGY_FLAGS";
    public static final String EXTRA_KEY_USE_NTP_TIMESTAMP = "com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_USE_NTP_TIMESTAMP";
    public static final String GPS_PROVIDER = "gps";
    public static final String NLP_PROVIDER = "nlp_network";
    private static final String PROVIDER_FLP = "flp";
    private static final String PROVIDER_GPS = "gps";
    public static final String PROVIDER_INERTIAL = "inertial";
    private static final String PROVIDER_NLP = "nlp";
    private static final String PROVIDER_VDR = "vdr";
    public static final String SOURCE_FLP_FLP = (ETraceSource.flp + "-" + PROVIDER_FLP);
    public static final String SOURCE_FLP_GPS = (ETraceSource.flp + "-" + "gps");
    public static final String SOURCE_FLP_INERTIAL = (ETraceSource.flp + "-" + PROVIDER_INERTIAL);
    public static final String SOURCE_FLP_NLP = (ETraceSource.flp + "-" + PROVIDER_NLP);
    public static final String SOURCE_FLP_VDR = (ETraceSource.flp + "-" + PROVIDER_VDR);
    public static final String SOURCE_GOOGLE_FLP = ETraceSource.googleflp.toString();
    public static final String SOURCE_GPS = ETraceSource.gps.toString();
    public static final String SOURCE_HUAWEI_FLP = ETraceSource.hmsflp.toString();
    public static final String SOURCE_NLP_CELL = ETraceSource.didicell.toString();
    public static final String SOURCE_NLP_WIFI = ETraceSource.didiwifi.toString();
    public static final String SOURCE_OS_NLP = ETraceSource.nlp.toString();
    public static final String SOURCE_TENCENT = ETraceSource.tencent.toString();
    public static final String STATUS_CELL = "cell";
    public static final int STATUS_CELL_AVAILABLE = 0;
    public static final int STATUS_CELL_DENIED = 2;
    public static final int STATUS_CELL_UNAVAILABLE = 1;
    public static final String STATUS_GPS = "gps";
    public static final int STATUS_GPS_AVAILABLE = 768;
    public static final int STATUS_GPS_DENIED = 512;
    public static final int STATUS_GPS_DISABLED = 256;
    public static final int STATUS_GPS_ENABLED = 0;
    public static final int STATUS_GPS_TEMPORARILY_UNAVAILABLE = 1280;
    public static final int STATUS_GPS_UNAVAILABLE = 1024;
    public static final int STATUS_UNKNOWN = -1;
    public static final String STATUS_WIFI = "wifi";
    public static final int STATUS_WIFI_DENIED = 32;
    public static final int STATUS_WIFI_DISABLED = 16;
    public static final int STATUS_WIFI_ENABLED = 0;
    public static final int STATUS_WIFI_LOCATION_SWITCH_OFF = 64;
    public static final String WIFI_PROVIDER = "didi_wifi";
    private float accuracy;
    private double altitude;
    private float bearing;
    private double confidence = -1.0d;
    private int coordinateType;
    private boolean effective = true;
    private long elapsedrealtime;
    private int errorno = 0;
    private boolean isCacheLocation = false;
    private int isMockGps;
    private double latitude;
    private long localTime = 0;
    private double longtitude;
    private Bundle mExtraInfo = new Bundle();
    private String provider;
    private String source = "";
    private float speed;
    private long time;

    @Deprecated
    public String getVdrLocationJson() {
        return null;
    }

    public static DIDILocation loadFromLocData(LocData locData, LocData locData2) {
        if (locData2 == null && locData == null) {
            return null;
        }
        DIDILocation dIDILocation = new DIDILocation();
        if (locData == null) {
            locData = locData2;
        }
        if (locData.provider == null) {
            if (locData.confidence <= 1.0d) {
                locData.provider = CELL_PROVIDER;
            } else {
                locData.provider = WIFI_PROVIDER;
            }
        }
        dIDILocation.time = locData.timestamp;
        dIDILocation.longtitude = locData.lonlat.lon;
        dIDILocation.latitude = locData.lonlat.lat;
        dIDILocation.accuracy = (float) locData.accuracy;
        dIDILocation.altitude = locData.altitude;
        dIDILocation.bearing = locData.bearing;
        dIDILocation.provider = locData.provider;
        dIDILocation.speed = (float) locData.speed;
        dIDILocation.elapsedrealtime = locData.elapsedRealtime;
        dIDILocation.isMockGps = 0;
        dIDILocation.coordinateType = locData.coordinateType;
        dIDILocation.source = locData.lonlat.source;
        dIDILocation.localTime = locData.localTime;
        dIDILocation.confidence = locData.confidence;
        return dIDILocation;
    }

    public static DIDILocation loadFromGps(OSLocationWrapper oSLocationWrapper) {
        return loadFromGps(oSLocationWrapper, false);
    }

    public static DIDILocation loadFromGps(OSLocationWrapper oSLocationWrapper, boolean z, int i) {
        if (oSLocationWrapper == null) {
            return null;
        }
        DIDILocation dIDILocation = new DIDILocation();
        Location location = oSLocationWrapper.getLocation();
        boolean a = Utils.m32751a(location);
        if (i == 1) {
            double[] transform = EvilTransform.transform(location.getLongitude(), location.getLatitude());
            boolean outOfChina = EvilTransform.outOfChina(location.getLongitude(), location.getLatitude());
            dIDILocation.longtitude = transform[0];
            dIDILocation.latitude = transform[1];
            dIDILocation.coordinateType = outOfChina ^ true ? 1 : 0;
        } else {
            dIDILocation.longtitude = location.getLongitude();
            dIDILocation.latitude = location.getLatitude();
            dIDILocation.coordinateType = 0;
        }
        dIDILocation.time = (!z || a) ? location.getTime() : oSLocationWrapper.getLocalTime();
        dIDILocation.accuracy = location.getAccuracy();
        dIDILocation.altitude = location.getAltitude();
        dIDILocation.bearing = location.getBearing();
        dIDILocation.provider = z ? NLP_PROVIDER : "gps";
        dIDILocation.speed = location.getSpeed();
        dIDILocation.elapsedrealtime = Utils.getSystemLocationElapsedRealtime(location);
        dIDILocation.isMockGps = Utils.isMockLocation(location) ? 1 : 0;
        dIDILocation.source = z ? SOURCE_OS_NLP : SOURCE_GPS;
        dIDILocation.localTime = oSLocationWrapper.getLocalTime();
        return dIDILocation;
    }

    public static DIDILocation loadFromGps(OSLocationWrapper oSLocationWrapper, boolean z) {
        return loadFromGps(oSLocationWrapper, z, 1);
    }

    public static DIDILocation loadFromSystemLoc(Location location, ETraceSource eTraceSource, int i) {
        if (location == null) {
            return null;
        }
        boolean z = false;
        double[] dArr = {location.getLongitude(), location.getLatitude()};
        if (i == 1) {
            dArr = EvilTransform.transform(location.getLongitude(), location.getLatitude());
        }
        DIDILocation dIDILocation = new DIDILocation();
        dIDILocation.longtitude = dArr[0];
        dIDILocation.latitude = dArr[1];
        dIDILocation.coordinateType = i;
        if (ETraceSource.gps == eTraceSource || ((ETraceSource.googleflp == eTraceSource && location.getAccuracy() <= 30.0f) || (ETraceSource.hmsflp == eTraceSource && location.getAccuracy() <= 30.0f))) {
            z = true;
        }
        dIDILocation.time = (z || Utils.m32751a(location)) ? location.getTime() : System.currentTimeMillis();
        dIDILocation.accuracy = location.getAccuracy();
        dIDILocation.altitude = location.getAltitude();
        dIDILocation.bearing = location.getBearing();
        dIDILocation.provider = z ? "gps" : NLP_PROVIDER;
        dIDILocation.speed = location.getSpeed();
        dIDILocation.elapsedrealtime = Utils.getSystemLocationElapsedRealtime(location);
        dIDILocation.isMockGps = Utils.isMockLocation(location) ? 1 : 0;
        dIDILocation.source = eTraceSource.toString();
        dIDILocation.localTime = System.currentTimeMillis();
        return dIDILocation;
    }

    public static DIDILocation loadFromSystemLoc(OSLocationWrapper oSLocationWrapper, ETraceSource eTraceSource, int i) {
        if (oSLocationWrapper == null || oSLocationWrapper.getLocation() == null) {
            return null;
        }
        Location location = oSLocationWrapper.getLocation();
        boolean z = false;
        double[] dArr = {location.getLongitude(), location.getLatitude()};
        if (i == 1) {
            dArr = EvilTransform.transform(location.getLongitude(), location.getLatitude());
        }
        DIDILocation dIDILocation = new DIDILocation();
        dIDILocation.longtitude = dArr[0];
        dIDILocation.latitude = dArr[1];
        dIDILocation.coordinateType = i;
        if (ETraceSource.gps == eTraceSource || ((ETraceSource.googleflp == eTraceSource && location.getAccuracy() <= 30.0f) || (ETraceSource.hmsflp == eTraceSource && location.getAccuracy() <= 30.0f))) {
            z = true;
        }
        dIDILocation.time = (z || Utils.m32751a(location)) ? location.getTime() : System.currentTimeMillis();
        dIDILocation.accuracy = location.getAccuracy();
        dIDILocation.altitude = location.getAltitude();
        dIDILocation.bearing = location.getBearing();
        dIDILocation.provider = z ? "gps" : NLP_PROVIDER;
        dIDILocation.speed = location.getSpeed();
        dIDILocation.elapsedrealtime = Utils.getSystemLocationElapsedRealtime(location);
        dIDILocation.isMockGps = Utils.isMockLocation(location) ? 1 : 0;
        dIDILocation.source = eTraceSource.toString();
        dIDILocation.localTime = oSLocationWrapper.getLocalTime();
        return dIDILocation;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getBearing() {
        return this.bearing;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longtitude;
    }

    public String getProvider() {
        return this.provider;
    }

    public float getSpeed() {
        return this.speed;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public long getElapsedRealtime() {
        return this.elapsedrealtime;
    }

    public int getCoordinateType() {
        return this.coordinateType;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public int isMockGps() {
        return this.isMockGps;
    }

    public int getError() {
        return this.errorno;
    }

    public String getSource() {
        return this.source;
    }

    public double distanceTo(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            return distanceTo(dIDILocation.getLongitude(), dIDILocation.getLatitude());
        }
        return 0.0d;
    }

    public double distanceTo(double d, double d2) {
        return EvilTransform.calcdistance(this.longtitude, this.latitude, d, d2);
    }

    public static double distanceBetween(DIDILocation dIDILocation, DIDILocation dIDILocation2) {
        if (dIDILocation == null || dIDILocation2 == null) {
            return 0.0d;
        }
        return dIDILocation.distanceTo(dIDILocation2);
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        return EvilTransform.calcdistance(d, d2, d3, d4);
    }

    /* access modifiers changed from: package-private */
    public void setLocalTime(long j) {
        this.localTime = j;
    }

    public long getLocalTime() {
        return this.localTime;
    }

    public void setEffective(boolean z) {
        this.effective = z;
    }

    public boolean isEffective() {
        return this.effective;
    }

    public boolean isCacheLocation() {
        return this.isCacheLocation;
    }

    public void setCacheLocation(boolean z) {
        this.isCacheLocation = z;
    }

    public String toString() {
        Integer num;
        StringBuilder sb = new StringBuilder(256);
        sb.append(Const.joLeft);
        sb.append(Const.formatDouble(this.longtitude, 6));
        sb.append(",");
        sb.append(Const.formatDouble(this.latitude, 6));
        sb.append(",");
        sb.append(this.accuracy);
        sb.append(",");
        sb.append(this.provider);
        sb.append(",");
        sb.append(this.bearing);
        sb.append(",");
        sb.append(this.time);
        sb.append(",");
        sb.append(this.localTime);
        sb.append(",");
        sb.append(this.speed);
        sb.append(",");
        Bundle bundle = this.mExtraInfo;
        if (bundle == null) {
            num = null;
        } else {
            num = Integer.valueOf(bundle.getInt(EXTRA_KEY_FLP_VDR_CONFIDENCE_4USE));
        }
        sb.append(num);
        sb.append(",");
        sb.append(this.source);
        sb.append(",");
        sb.append(this.coordinateType);
        sb.append("}");
        return sb.toString();
    }

    public Bundle getExtra() {
        return this.mExtraInfo;
    }

    public static DIDILocation cloneFrom(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        DIDILocation dIDILocation2 = new DIDILocation();
        dIDILocation2.longtitude = dIDILocation.longtitude;
        dIDILocation2.latitude = dIDILocation.latitude;
        dIDILocation2.accuracy = dIDILocation.accuracy;
        dIDILocation2.altitude = dIDILocation.altitude;
        dIDILocation2.speed = dIDILocation.speed;
        dIDILocation2.bearing = dIDILocation.bearing;
        dIDILocation2.provider = dIDILocation.provider;
        dIDILocation2.time = dIDILocation.time;
        dIDILocation2.coordinateType = dIDILocation.coordinateType;
        dIDILocation2.elapsedrealtime = dIDILocation.elapsedrealtime;
        dIDILocation2.isMockGps = dIDILocation.isMockGps;
        dIDILocation2.source = dIDILocation.source;
        dIDILocation2.mExtraInfo = dIDILocation.mExtraInfo;
        dIDILocation2.localTime = dIDILocation.localTime;
        dIDILocation2.errorno = dIDILocation.errorno;
        dIDILocation2.effective = dIDILocation.effective;
        dIDILocation2.confidence = dIDILocation.confidence;
        return dIDILocation2;
    }

    public static DIDILocation convert2DidiLocation(Location location, String str, int i, long j) {
        if (location == null) {
            return null;
        }
        double[] dArr = {location.getLongitude(), location.getLatitude()};
        if (i == 1) {
            dArr = EvilTransform.transform(location.getLongitude(), location.getLatitude());
        }
        DIDILocation dIDILocation = new DIDILocation();
        dIDILocation.longtitude = dArr[0];
        dIDILocation.latitude = dArr[1];
        dIDILocation.coordinateType = i;
        dIDILocation.time = "gps".equals(str) ? location.getTime() : System.currentTimeMillis();
        dIDILocation.accuracy = location.getAccuracy();
        dIDILocation.altitude = location.getAltitude();
        dIDILocation.bearing = location.getBearing();
        dIDILocation.provider = str;
        dIDILocation.speed = location.getSpeed();
        dIDILocation.elapsedrealtime = Utils.getSystemLocationElapsedRealtime(location);
        dIDILocation.isMockGps = Utils.isMockLocation(location) ? 1 : 0;
        dIDILocation.localTime = j;
        return dIDILocation;
    }
}
