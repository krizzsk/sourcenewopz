package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.os.SystemClock;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.GpsManager;
import com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GPSFLPUnifier */
public class GPSFLPUnifier {

    /* renamed from: a */
    GpsManager.GPSListener f45801a;

    /* renamed from: b */
    private Context f45802b;

    /* renamed from: c */
    private CopyOnWriteArraySet<LocationUpdateInternalListener> f45803c;

    /* renamed from: d */
    private CopyOnWriteArraySet<LocationUpdateInternalListener> f45804d;

    /* renamed from: e */
    private GpsManager f45805e;

    /* renamed from: f */
    private int f45806f;

    /* renamed from: g */
    private Config.LocateMode f45807g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public DIDILocation f45808h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DIDILocation f45809i;

    public void tryRebootGPS() {
        if (this.f45805e != null) {
            GpsManager instance = GpsManager.getInstance();
            long timeBoot = Utils.getTimeBoot();
            if (timeBoot - instance.getReceiveGpsSignalTime() > 120000 && timeBoot - instance.getStartedTime() > 120000 && !Utils.airPlaneModeOn(this.f45802b) && SensorMonitor.getInstance(this.f45802b).isGpsEnabled()) {
                DLog.m32737d("restart gps");
                instance.reset();
            }
        }
    }

    public void applyLocateMode(Config.LocateMode locateMode, long j) {
        GpsManager gpsManager;
        if (this.f45807g != locateMode) {
            GpsManager gpsManager2 = this.f45805e;
            if (gpsManager2 != null) {
                gpsManager2.reset();
            }
            this.f45807g = locateMode;
        }
        if (this.f45807g == Config.LocateMode.SAVE_GPS_POWER && (gpsManager = this.f45805e) != null) {
            gpsManager.delayExecuteSingleGpsLocate(j);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GPSFLPUnifier$InstanceHolder */
    private static class InstanceHolder {
        static final GPSFLPUnifier sInstance = new GPSFLPUnifier();

        private InstanceHolder() {
        }
    }

    public static GPSFLPUnifier getInstance() {
        return InstanceHolder.sInstance;
    }

    private GPSFLPUnifier() {
        this.f45803c = new CopyOnWriteArraySet<>();
        this.f45804d = new CopyOnWriteArraySet<>();
        this.f45806f = 0;
        this.f45807g = Config.getFinalLocateMode();
        this.f45801a = new GpsManager.GPSListener() {
            public void onLocationChanged(OSLocationWrapper oSLocationWrapper) {
                DIDILocation unused = GPSFLPUnifier.this.f45808h = DIDILocation.loadFromGps(oSLocationWrapper);
                GPSFLPUnifier.this.f45808h.getExtra().putLong(DIDILocation.EXTRA_KEY_RECV_GPS_TICK, SystemClock.elapsedRealtime());
                GPSFLPUnifier gPSFLPUnifier = GPSFLPUnifier.this;
                gPSFLPUnifier.m32820a(gPSFLPUnifier.f45808h);
                DIDILocation unused2 = GPSFLPUnifier.this.f45809i = DIDILocation.loadFromGps(oSLocationWrapper, false, 0);
                GPSFLPUnifier gPSFLPUnifier2 = GPSFLPUnifier.this;
                gPSFLPUnifier2.m32822b(gPSFLPUnifier2.f45808h);
                GPSFLPUnifier gPSFLPUnifier3 = GPSFLPUnifier.this;
                gPSFLPUnifier3.m32825c(gPSFLPUnifier3.f45808h);
            }
        };
    }

    public void init(Context context) {
        this.f45802b = context;
    }

    public synchronized void removeListenLoc(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45803c.remove(locationUpdateInternalListener);
        if (this.f45803c.size() == 0) {
            m32821b();
        }
    }

    public synchronized void requestListenLoc(LocationUpdateInternalListener locationUpdateInternalListener) {
        if (this.f45803c.size() == 0) {
            m32819a();
        }
        this.f45803c.add(locationUpdateInternalListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32820a(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            dIDILocation.getExtra().putInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, GpsManager.getInstance().getFixLocSatelliteNum());
            dIDILocation.getExtra().putFloat(DIDILocation.EXTRA_KEY_GPS_SIGNAL_LEVEL, GpsManager.getInstance().getGpsSignalLevel());
        }
    }

    /* renamed from: a */
    private void m32819a() {
        this.f45807g = Config.getFinalLocateMode();
        GpsManager instance = GpsManager.getInstance();
        this.f45805e = instance;
        instance.init(this.f45802b);
        this.f45805e.requestListenGps(this.f45801a);
    }

    /* renamed from: b */
    private void m32821b() {
        GpsManager gpsManager = this.f45805e;
        if (gpsManager != null) {
            gpsManager.removeListenGps(this.f45801a);
            this.f45805e = null;
        }
        this.f45806f = 0;
        this.f45808h = null;
        this.f45809i = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32822b(DIDILocation dIDILocation) {
        Iterator<LocationUpdateInternalListener> it = this.f45803c.iterator();
        while (it.hasNext()) {
            it.next().onLocationUpdate(dIDILocation, 0);
        }
        if (DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource())) {
            OmegaUtils.trackVDRInertial(dIDILocation);
        }
    }

    public boolean isLocationValid(DIDILocation dIDILocation) {
        OSLocationWrapper gPSLocation = GpsManager.getInstance().getGPSLocation();
        if (dIDILocation == null) {
            if (gPSLocation != null) {
                long localTime = gPSLocation.getLocalTime();
                if (System.currentTimeMillis() - localTime < 3000) {
                    int i = this.f45806f + 1;
                    this.f45806f = i;
                    if (i == 3) {
                        OmegaUtils.trackSystemGpsButSdkNoGpsOrFlp(localTime, -1);
                        this.f45806f = 0;
                    }
                }
            }
            return false;
        }
        if (gPSLocation != null) {
            long localTime2 = gPSLocation.getLocalTime();
            long localTime3 = dIDILocation.getLocalTime();
            if (localTime2 - localTime3 > 3000) {
                OmegaUtils.trackSystemGpsButSdkNoGpsOrFlp(localTime2, localTime3);
            }
        }
        if (System.currentTimeMillis() - dIDILocation.getLocalTime() < 30000) {
            return true;
        }
        return false;
    }

    public void addPassiveListener(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45804d.add(locationUpdateInternalListener);
    }

    public void removePassiveListener(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45804d.remove(locationUpdateInternalListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m32825c(DIDILocation dIDILocation) {
        Iterator<LocationUpdateInternalListener> it = this.f45804d.iterator();
        while (it.hasNext()) {
            it.next().onLocationUpdate(dIDILocation, 0);
        }
    }

    public DIDILocation getValidGPSFLPLocation() {
        if (isLocationValid(this.f45808h)) {
            return this.f45808h;
        }
        return null;
    }

    public DIDILocation getGPSFLPLocationWGS84() {
        return this.f45809i;
    }
}
