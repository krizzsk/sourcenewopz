package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.os.SystemClock;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.GpsManager;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManagerWrapper */
public class GpsManagerWrapper {

    /* renamed from: a */
    private Context f45843a;

    /* renamed from: b */
    private GpsManager f45844b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f45845c;

    /* renamed from: d */
    private Set<LocationUpdateInternalListener> f45846d;

    /* renamed from: e */
    private GpsManager.GPSListener f45847e;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManagerWrapper$HOLDER */
    private static class HOLDER {
        /* access modifiers changed from: private */
        public static GpsManagerWrapper instance = new GpsManagerWrapper();

        private HOLDER() {
        }
    }

    public static GpsManagerWrapper getInstance() {
        return HOLDER.instance;
    }

    private GpsManagerWrapper() {
        this.f45846d = new HashSet();
        this.f45847e = new GpsManager.GPSListener() {
            public void onLocationChanged(OSLocationWrapper oSLocationWrapper) {
                DIDILocation unused = GpsManagerWrapper.this.f45845c = DIDILocation.loadFromGps(oSLocationWrapper, false, Utils.getCoordinateType());
                GpsManagerWrapper.this.f45845c.getExtra().putLong(DIDILocation.EXTRA_KEY_RECV_GPS_TICK, SystemClock.elapsedRealtime());
                GpsManagerWrapper gpsManagerWrapper = GpsManagerWrapper.this;
                gpsManagerWrapper.m32875a(gpsManagerWrapper.f45845c);
                GpsManagerWrapper.this.m32879c();
            }
        };
    }

    public void init(Context context) {
        this.f45843a = context;
    }

    public synchronized void requestLocationUpdates(LocationUpdateInternalListener locationUpdateInternalListener) {
        if (this.f45846d.isEmpty()) {
            m32874a();
        }
        this.f45846d.add(locationUpdateInternalListener);
    }

    public synchronized void removeLocationUpdates(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45846d.remove(locationUpdateInternalListener);
        if (this.f45846d.isEmpty()) {
            m32876b();
        }
    }

    public boolean isLocationValid(DIDILocation dIDILocation) {
        return System.currentTimeMillis() - dIDILocation.getLocalTime() < 30000;
    }

    public DIDILocation getGpsLocation() {
        DIDILocation dIDILocation = this.f45845c;
        if (dIDILocation != null && isLocationValid(dIDILocation)) {
            return this.f45845c;
        }
        GpsManager gpsManager = this.f45844b;
        if (gpsManager == null) {
            return null;
        }
        gpsManager.tryInitWhenPermissionGranted();
        return null;
    }

    public DIDILocation getLastGpsLocation() {
        return this.f45845c;
    }

    public void tryRebootGPS() {
        if (this.f45844b != null) {
            GpsManager instance = GpsManager.getInstance();
            long timeBoot = Utils.getTimeBoot();
            if (timeBoot - instance.getReceiveGpsSignalTime() > 120000 && timeBoot - instance.getStartedTime() > 120000 && !Utils.airPlaneModeOn(this.f45843a) && SensorMonitor.getInstance(this.f45843a).isGpsEnabled()) {
                DLog.m32737d("restart gps");
                instance.reset();
            }
        }
    }

    /* renamed from: a */
    private void m32874a() {
        if (this.f45844b == null) {
            GpsManager instance = GpsManager.getInstance();
            this.f45844b = instance;
            instance.init(this.f45843a);
            this.f45844b.requestListenGps(this.f45847e);
        }
    }

    /* renamed from: b */
    private void m32876b() {
        GpsManager gpsManager = this.f45844b;
        if (gpsManager != null) {
            gpsManager.removeListenGps(this.f45847e);
            this.f45844b = null;
        }
        this.f45845c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m32879c() {
        for (LocationUpdateInternalListener onLocationUpdate : this.f45846d) {
            onLocationUpdate.onLocationUpdate(this.f45845c, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32875a(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            dIDILocation.getExtra().putInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, GpsManager.getInstance().getFixLocSatelliteNum());
            dIDILocation.getExtra().putFloat(DIDILocation.EXTRA_KEY_GPS_SIGNAL_LEVEL, GpsManager.getInstance().getGpsSignalLevel());
        }
    }
}
