package com.didi.map.global.rpc.util;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SatelliteManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f27357a = SatelliteManager.class.getCanonicalName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Handler f27358b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private static volatile SatelliteManager f27359d;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f27360c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LocationManager f27361e;

    /* renamed from: f */
    private LocationListener f27362f;

    /* renamed from: g */
    private GpsStatus.Listener f27363g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnSatelliteStatusChangedListener f27364h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f27365i = 3000;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f27366j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<GpsSatellite> f27367k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Location f27368l;

    public interface OnSatelliteStatusChangedListener {
        void onSatelliteStatusChanged(List<GpsSatellite> list, Location location);
    }

    public static SatelliteManager getInstance(Context context) {
        if (f27359d == null) {
            synchronized (SatelliteManager.class) {
                if (f27359d == null) {
                    f27359d = new SatelliteManager(context);
                }
            }
        }
        return f27359d;
    }

    private SatelliteManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f27360c = applicationContext;
        this.f27361e = (LocationManager) applicationContext.getSystemService("location");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m19324d() {
        return Apollo.getToggle("android_passenger_global_base_lib_satellite_info_toggle").allow();
    }

    public boolean isGPSEnabled() {
        LocationManager locationManager = this.f27361e;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps");
        }
        return false;
    }

    public void setIntervalMilliseconds(long j) {
        this.f27365i = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public LocationListener m19326e() {
        if (this.f27362f == null) {
            this.f27362f = new LocationListener() {
                public void onLocationChanged(Location location) {
                    String a = SatelliteManager.f27357a;
                    SystemUtils.log(3, a, "卫星定位经度：" + location.getLongitude(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 81);
                    String a2 = SatelliteManager.f27357a;
                    SystemUtils.log(3, a2, "卫星定位纬度：" + location.getLatitude(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 82);
                    String a3 = SatelliteManager.f27357a;
                    SystemUtils.log(3, a3, "卫星定位时间：" + location.getTime(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 83);
                }

                public void onStatusChanged(String str, int i, Bundle bundle) {
                    SystemUtils.log(3, SatelliteManager.f27357a, "onStatusChanged()", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 89);
                }

                public void onProviderEnabled(String str) {
                    SystemUtils.log(3, SatelliteManager.f27357a, "onProviderEnabled()", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 95);
                }

                public void onProviderDisabled(String str) {
                    SystemUtils.log(3, SatelliteManager.f27357a, "onProviderDisabled()", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 101);
                }
            };
        }
        return this.f27362f;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public GpsStatus.Listener m19328f() {
        if (this.f27363g == null) {
            this.f27363g = new GpsStatus.Listener() {
                public void onGpsStatusChanged(int i) {
                    if (i == 1) {
                        SystemUtils.log(3, SatelliteManager.f27357a, "GPS_EVENT_STARTED", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 115);
                    } else if (i == 2) {
                        SystemUtils.log(3, SatelliteManager.f27357a, "GPS_EVENT_STOPPED", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 118);
                    } else if (i == 3) {
                        SystemUtils.log(3, SatelliteManager.f27357a, "GPS_EVENT_FIRST_FIX", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 121);
                    } else if (i == 4) {
                        SystemUtils.log(3, SatelliteManager.f27357a, "GPS_EVENT_SATELLITE_STATUS", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 124);
                        SatelliteManager satelliteManager = SatelliteManager.this;
                        List unused = satelliteManager.f27367k = satelliteManager.m19329g();
                        SatelliteManager satelliteManager2 = SatelliteManager.this;
                        Location unused2 = satelliteManager2.f27368l = satelliteManager2.f27361e.getLastKnownLocation("gps");
                        if (SatelliteManager.this.f27364h != null) {
                            SatelliteManager.f27358b.post(new Runnable() {
                                public void run() {
                                    SatelliteManager.this.f27364h.onSatelliteStatusChanged(SatelliteManager.this.f27367k, SatelliteManager.this.f27368l);
                                }
                            });
                        }
                    }
                }
            };
        }
        return this.f27363g;
    }

    public boolean isRunning() {
        return this.f27366j;
    }

    public void start() {
        SystemUtils.log(5, f27357a, "start() is called", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 148);
        new Thread(new Runnable() {
            public void run() {
                if (!SatelliteManager.m19324d()) {
                    SystemUtils.log(6, SatelliteManager.f27357a, "isSatelliteInfoToggleEnabled() = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 153);
                } else if (!SatelliteManager.this.isGPSEnabled()) {
                    SystemUtils.log(6, SatelliteManager.f27357a, "isGPSEnabled() = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 158);
                } else if (!PermissionUtil.isLocationPermissionsGranted(SatelliteManager.this.f27360c)) {
                    SystemUtils.log(6, SatelliteManager.f27357a, "isLocationPermissionsGranted(mContext) = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 163);
                } else if (SatelliteManager.this.f27366j) {
                    SystemUtils.log(5, SatelliteManager.f27357a, "isRunning = true", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 168);
                } else {
                    boolean unused = SatelliteManager.this.f27366j = true;
                    Looper.prepare();
                    SatelliteManager.this.f27361e.addGpsStatusListener(SatelliteManager.this.m19328f());
                    SatelliteManager.this.f27361e.requestLocationUpdates("gps", SatelliteManager.this.f27365i, 1.0f, SatelliteManager.this.m19326e());
                    Looper.loop();
                }
            }
        }).start();
    }

    public void stop() {
        SystemUtils.log(5, f27357a, "stop() is called", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 182);
        if (!this.f27366j) {
            SystemUtils.log(5, f27357a, "isRunning = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 184);
            return;
        }
        this.f27366j = false;
        LocationManager locationManager = this.f27361e;
        if (locationManager != null) {
            GpsStatus.Listener listener = this.f27363g;
            if (listener != null) {
                locationManager.removeGpsStatusListener(listener);
                this.f27363g = null;
            }
            LocationListener locationListener = this.f27362f;
            if (locationListener != null) {
                this.f27361e.removeUpdates(locationListener);
                this.f27362f = null;
            }
        }
        this.f27367k = null;
        this.f27368l = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public List<GpsSatellite> m19329g() {
        LocationManager locationManager = this.f27361e;
        if (locationManager == null) {
            SystemUtils.log(6, f27357a, "getGpsSatellites() mLocationManager == null", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 206);
            return null;
        }
        try {
            GpsStatus gpsStatus = locationManager.getGpsStatus((GpsStatus) null);
            int maxSatellites = gpsStatus.getMaxSatellites();
            if (maxSatellites <= 0) {
                return null;
            }
            String str = f27357a;
            SystemUtils.log(3, str, "FirstFixTime: " + gpsStatus.getTimeToFirstFix(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 214);
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
            String str2 = f27357a;
            SystemUtils.log(3, str2, "count: " + i, (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 226);
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GpsSatellite> getLastSatellites() {
        return this.f27367k;
    }

    public Location getLastLocation() {
        return this.f27368l;
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
        String str = null;
        if (CollectionUtil.isEmpty((Collection<?>) this.f27367k)) {
            SystemUtils.log(6, f27357a, "CollectionUtil.isEmpty(mSatellites)", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 264);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (GpsSatellite next : this.f27367k) {
            if (next != null) {
                arrayList.add(new SatelliteInfo(next));
            }
        }
        try {
            str = new Gson().toJson((Object) arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null) {
            return "";
        }
        SystemUtils.log(3, f27357a, str, (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 286);
        return str;
    }

    public void setOnSatelliteStatusChangedListener(OnSatelliteStatusChangedListener onSatelliteStatusChangedListener) {
        this.f27364h = onSatelliteStatusChangedListener;
    }
}
