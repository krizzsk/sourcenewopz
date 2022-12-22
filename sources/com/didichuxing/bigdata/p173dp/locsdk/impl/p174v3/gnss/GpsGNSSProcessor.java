package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.gnss;

import android.location.GnssStatus;
import android.location.LocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.gnss.GpsGNSSProcessor */
public class GpsGNSSProcessor {

    /* renamed from: b */
    private static final String f45981b = "GpsGNSSProcessor";

    /* renamed from: a */
    LocationManager f45982a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnGNSSDataListener f45983c;

    /* renamed from: d */
    private GnssStatus.Callback f45984d = new GnssStatus.Callback() {
        public void onStarted() {
            DLog.m32737d("gnss gps event started");
        }

        public void onStopped() {
            DLog.m32737d("gnss gps event stopped");
        }

        public void onFirstFix(int i) {
            DLog.m32737d("gnss gps event onFirstFix" + i);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (gnssStatus != null) {
                try {
                    GNSSData gNSSData = new GNSSData();
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    gNSSData.fixedSatelliteNum = 0;
                    gNSSData.signalLevel = 0.0f;
                    for (int i = 0; i < satelliteCount; i++) {
                        if (gnssStatus.usedInFix(i)) {
                            gNSSData.fixedSatelliteNum++;
                        }
                        gNSSData.signalLevel += gnssStatus.getCn0DbHz(i);
                    }
                    DLog.m32737d("GpsGNSSProcessor GnssStatus data: " + gNSSData.toString());
                    if (GpsGNSSProcessor.this.f45983c != null) {
                        GpsGNSSProcessor.this.f45983c.onDataCallback(gNSSData);
                    }
                } catch (Exception e) {
                    DLog.m32737d("GpsGNSSProcessor onSatelliteStatusChanged exce:" + e.getMessage());
                }
            }
        }
    };

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.gnss.GpsGNSSProcessor$OnGNSSDataListener */
    public interface OnGNSSDataListener {
        void onDataCallback(GNSSData gNSSData);
    }

    public GpsGNSSProcessor(LocationManager locationManager) {
        this.f45982a = locationManager;
    }

    public void setOnGNSSDataListener(OnGNSSDataListener onGNSSDataListener) {
        this.f45983c = onGNSSDataListener;
    }

    public void start() {
        LocationManager locationManager = this.f45982a;
        if (locationManager != null) {
            try {
                locationManager.registerGnssStatusCallback(this.f45984d);
            } catch (Exception e) {
                DLog.m32737d("GpsGNSSProcessor start:" + e.getMessage());
            }
        }
    }

    public void stop() {
        LocationManager locationManager = this.f45982a;
        if (locationManager != null) {
            try {
                locationManager.unregisterGnssStatusCallback(this.f45984d);
            } catch (Exception e) {
                DLog.m32737d("GpsGNSSProcessor stop:" + e.getMessage());
            }
        }
    }
}
