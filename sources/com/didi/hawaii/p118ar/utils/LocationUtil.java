package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import com.didi.hawaii.p118ar.jni.DARCGPSData;
import com.didi.hawaii.p118ar.jni.DARCGeoPoint;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

/* renamed from: com.didi.hawaii.ar.utils.LocationUtil */
public class LocationUtil {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static GpscurLocation f23320a = new GpscurLocation();

    /* renamed from: b */
    private static DIDILocationListener f23321b = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            LocationUtil.f23320a.longitude = dIDILocation.getLongitude();
            LocationUtil.f23320a.latitude = dIDILocation.getLatitude();
            LocationUtil.f23320a.time = dIDILocation.getTime();
            LocationUtil.f23320a.accuracy = dIDILocation.getAccuracy();
            LocationUtil.f23320a.altitude = dIDILocation.getAltitude();
            LocationUtil.f23320a.direction = dIDILocation.getBearing();
            LocationUtil.f23320a.provider = dIDILocation.getProvider();
            LocationUtil.f23320a.velocity = dIDILocation.getSpeed();
            LocationUtil.f23320a.localTime = dIDILocation.getLocalTime();
            if (LocationUtil.f23322c != null) {
                LocationUtil.f23322c.onLocationChanged(LocationUtil.f23320a);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static NotifyLocationListener f23322c = null;

    /* renamed from: com.didi.hawaii.ar.utils.LocationUtil$GpscurLocation */
    public static class GpscurLocation {
        public float accuracy = 0.0f;
        public double altitude = 0.0d;
        public float direction = -1.0f;
        public double latitude = 0.0d;
        public long localTime = -1;
        public double longitude = 0.0d;
        public String provider = "";
        public long time = 0;
        public float velocity = 0.0f;
    }

    /* renamed from: com.didi.hawaii.ar.utils.LocationUtil$NotifyLocationListener */
    public interface NotifyLocationListener {
        void onLocationChanged(GpscurLocation gpscurLocation);
    }

    public static void startGetLocation(Context context) {
        DIDILocationUpdateOption defaultLocationUpdateOption = DIDILocationManager.getInstance(context).getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey("ar");
        DIDILocationManager.getInstance(context).requestLocationUpdates(f23321b, defaultLocationUpdateOption);
    }

    public static void stopGetLocation(Context context) {
        DIDILocationManager.getInstance(context).removeLocationUpdates(f23321b);
    }

    public static void setNotifyLocationListener(NotifyLocationListener notifyLocationListener) {
        f23322c = notifyLocationListener;
    }

    public static DARCGPSData getCurLocation2DARCGPSData() {
        DARCGPSData dARCGPSData = new DARCGPSData();
        dARCGPSData.setVerticalAccuracy((double) f23320a.accuracy);
        dARCGPSData.setHorizontalAccuracy((double) f23320a.accuracy);
        dARCGPSData.setAltitude(f23320a.altitude);
        DARCGeoPoint dARCGeoPoint = new DARCGeoPoint();
        dARCGeoPoint.setLon(f23320a.longitude);
        dARCGeoPoint.setLat(f23320a.latitude);
        dARCGPSData.setLocation(dARCGeoPoint);
        return dARCGPSData;
    }

    public static GpscurLocation DARCGPSData2Location(DARCGPSData dARCGPSData) {
        GpscurLocation gpscurLocation = new GpscurLocation();
        gpscurLocation.longitude = dARCGPSData.getLocation().getLon();
        gpscurLocation.latitude = dARCGPSData.getLocation().getLat();
        gpscurLocation.localTime = (long) dARCGPSData.getTimestamp();
        gpscurLocation.accuracy = (float) dARCGPSData.getHorizontalAccuracy();
        gpscurLocation.velocity = (float) dARCGPSData.getSpeed();
        gpscurLocation.altitude = dARCGPSData.getAltitude();
        return gpscurLocation;
    }

    public static GpscurLocation getCurLocation() {
        return f23320a;
    }
}
