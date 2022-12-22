package com.sdk.poibase.util;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sdk.poibase.util.BaseGpsStatusHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SatelliteManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f56013a = SatelliteManager.class.getCanonicalName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Handler f56014b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private static volatile SatelliteManager f56015d;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f56016c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BaseGpsStatusHelper f56017e;

    /* renamed from: f */
    private BaseGpsStatusHelper.IGpsStatusChanged f56018f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LocationManager f56019g;

    /* renamed from: h */
    private LocationListener f56020h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnSatelliteStatusChangedListener f56021i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f56022j = 3000;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f56023k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<GpsSatellite> f56024l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Location f56025m;

    public interface OnSatelliteStatusChangedListener {
        void onSatelliteStatusChanged(List<GpsSatellite> list, Location location);
    }

    public static SatelliteManager getInstance(Context context) {
        if (f56015d == null) {
            synchronized (SatelliteManager.class) {
                if (f56015d == null) {
                    f56015d = new SatelliteManager(context);
                }
            }
        }
        return f56015d;
    }

    private SatelliteManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f56016c = applicationContext;
        this.f56019g = (LocationManager) applicationContext.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 24) {
            this.f56017e = new GpsStatusHelperN(this.f56019g);
        } else {
            this.f56017e = new GpsStatusHelperOlder(this.f56019g);
        }
    }

    public boolean isGPSEnabled() {
        LocationManager locationManager = this.f56019g;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps");
        }
        return false;
    }

    public void setIntervalMilliseconds(long j) {
        this.f56022j = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public LocationListener m40348c() {
        if (this.f56020h == null) {
            this.f56020h = new LocationListener() {
                public void onLocationChanged(Location location) {
                }

                public void onProviderDisabled(String str) {
                }

                public void onProviderEnabled(String str) {
                }

                public void onStatusChanged(String str, int i, Bundle bundle) {
                }
            };
        }
        return this.f56020h;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public BaseGpsStatusHelper.IGpsStatusChanged m40350d() {
        if (this.f56018f == null) {
            this.f56018f = new BaseGpsStatusHelper.IGpsStatusChanged() {
                public void onFirstFix() {
                }

                public void onStarted() {
                    SystemUtils.log(3, SatelliteManager.f56013a, "GPS_EVENT_STARTED", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$2", 109);
                }

                public void onStopped() {
                    SystemUtils.log(3, SatelliteManager.f56013a, "GPS_EVENT_STOPPED", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$2", 114);
                }

                public void onSatelliteStatusChanged() {
                    SatelliteManager satelliteManager = SatelliteManager.this;
                    List unused = satelliteManager.f56024l = satelliteManager.m40353e();
                    SatelliteManager satelliteManager2 = SatelliteManager.this;
                    Location unused2 = satelliteManager2.f56025m = satelliteManager2.f56019g.getLastKnownLocation("gps");
                    if (SatelliteManager.this.f56021i != null) {
                        SatelliteManager.f56014b.post(new Runnable() {
                            public void run() {
                                SatelliteManager.this.f56021i.onSatelliteStatusChanged(SatelliteManager.this.f56024l, SatelliteManager.this.f56025m);
                            }
                        });
                    }
                }
            };
        }
        return this.f56018f;
    }

    public boolean isRunning() {
        return this.f56023k;
    }

    public void start() {
        SystemUtils.log(5, f56013a, "start() is called", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 145);
        new Thread(new Runnable() {
            public void run() {
                if (!SatelliteManager.this.isGPSEnabled()) {
                    SystemUtils.log(6, SatelliteManager.f56013a, "isGPSEnabled() = false", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$3", 150);
                } else if (!PermissionUtil.isLocationPermissionsGranted(SatelliteManager.this.f56016c)) {
                    SystemUtils.log(6, SatelliteManager.f56013a, "isLocationPermissionsGranted(mContext) = false", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$3", 155);
                } else if (SatelliteManager.this.f56023k) {
                    SystemUtils.log(5, SatelliteManager.f56013a, "isRunning = true", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$3", 160);
                } else if (PermissionUtil.isLocationPermissionsGranted(SatelliteManager.this.f56016c)) {
                    boolean unused = SatelliteManager.this.f56023k = true;
                    Looper.prepare();
                    SatelliteManager.this.f56017e.registerGpsStatusListener(SatelliteManager.this.m40350d());
                    SatelliteManager.this.f56019g.requestLocationUpdates("gps", SatelliteManager.this.f56022j, 1.0f, SatelliteManager.this.m40348c());
                    Looper.loop();
                }
            }
        }).start();
    }

    public void stop() {
        SystemUtils.log(5, f56013a, "stop() is called", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 176);
        if (!this.f56023k) {
            SystemUtils.log(5, f56013a, "isRunning = false", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 178);
            return;
        }
        this.f56023k = false;
        if (this.f56019g != null) {
            BaseGpsStatusHelper.IGpsStatusChanged iGpsStatusChanged = this.f56018f;
            if (iGpsStatusChanged != null) {
                this.f56017e.unRegisterGpsStatusListener(iGpsStatusChanged);
                this.f56018f = null;
            }
            LocationListener locationListener = this.f56020h;
            if (locationListener != null) {
                this.f56019g.removeUpdates(locationListener);
                this.f56020h = null;
            }
        }
        this.f56024l = null;
        this.f56025m = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<GpsSatellite> m40353e() {
        LocationManager locationManager = this.f56019g;
        if (locationManager == null) {
            SystemUtils.log(6, f56013a, "getGpsSatellites() mLocationManager == null", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 200);
            return null;
        }
        try {
            GpsStatus gpsStatus = locationManager.getGpsStatus((GpsStatus) null);
            int maxSatellites = gpsStatus.getMaxSatellites();
            if (maxSatellites <= 0) {
                return null;
            }
            Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
            int i = 0;
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && i <= maxSatellites) {
                GpsSatellite next = it.next();
                if (next != null) {
                    i++;
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GpsSatellite> getLastSatellites() {
        return this.f56024l;
    }

    public Location getLastLocation() {
        return this.f56025m;
    }

    public static class SatelliteInfo {
        public int almanac;
        public float azimuth;
        public float elevation;
        public int ephemeris;
        public int prn;
        public float snr;
        public int use;

        public SatelliteInfo(GpsSatellite gpsSatellite) {
            this.azimuth = gpsSatellite.getAzimuth();
            this.elevation = gpsSatellite.getElevation();
            this.snr = gpsSatellite.getSnr();
            this.prn = gpsSatellite.getPrn();
            this.almanac = gpsSatellite.hasAlmanac() ? 1 : 0;
            this.ephemeris = gpsSatellite.hasEphemeris() ? 1 : 0;
            this.use = gpsSatellite.usedInFix() ? 1 : 0;
        }
    }

    public String getLastSatellitesInfo() {
        try {
            if (CollectionUtil.isEmpty((Collection<?>) this.f56024l)) {
                SystemUtils.log(6, f56013a, "CollectionUtil.isEmpty(mSatellites)", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 257);
                return null;
            }
            JsonArray jsonArray = new JsonArray();
            for (GpsSatellite next : this.f56024l) {
                if (next != null) {
                    jsonArray.add((JsonElement) m40341a(next));
                }
            }
            String jsonArray2 = jsonArray.toString();
            SystemUtils.log(3, f56013a, jsonArray2, (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 269);
            return jsonArray2;
        } catch (Exception e) {
            SystemUtils.log(3, f56013a, e.getMessage(), (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 273);
            return "";
        }
    }

    /* renamed from: a */
    private static JsonObject m40341a(GpsSatellite gpsSatellite) {
        JsonObject jsonObject = new JsonObject();
        if (gpsSatellite != null) {
            jsonObject.addProperty("ephemeris", (Number) Integer.valueOf(gpsSatellite.hasEphemeris() ? 1 : 0));
            jsonObject.addProperty("almanac", (Number) Integer.valueOf(gpsSatellite.hasAlmanac() ? 1 : 0));
            jsonObject.addProperty("prn", (Number) Integer.valueOf(gpsSatellite.getPrn()));
            jsonObject.addProperty("snr", (Number) Float.valueOf(gpsSatellite.getSnr()));
            jsonObject.addProperty("elevation", (Number) Float.valueOf(gpsSatellite.getElevation()));
            jsonObject.addProperty("azimuth", (Number) Float.valueOf(gpsSatellite.getAzimuth()));
            jsonObject.addProperty("use", (Number) Integer.valueOf(gpsSatellite.usedInFix() ? 1 : 0));
        }
        return jsonObject;
    }

    public void setOnSatelliteStatusChangedListener(OnSatelliteStatusChangedListener onSatelliteStatusChangedListener) {
        this.f56021i = onSatelliteStatusChangedListener;
    }
}
