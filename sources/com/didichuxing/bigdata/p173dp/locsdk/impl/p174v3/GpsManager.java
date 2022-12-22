package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.PermRetryApollo;
import com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter.AccTimeFilterHelper;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.gnss.GNSSData;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.gnss.GpsGNSSProcessor;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeSource;
import com.didichuxing.bigdata.p173dp.locsdk.utils.MockLocationChecker;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager */
public class GpsManager extends C15137d<Location> {

    /* renamed from: c */
    private static final String f45810c = "GpsManager";

    /* renamed from: t */
    private static final long f45811t = 15000;

    /* renamed from: A */
    private GpsStatus.Listener f45812A;

    /* renamed from: B */
    private LocationListener f45813B;

    /* renamed from: C */
    private SingleGPSLocationListener f45814C;

    /* renamed from: D */
    private long f45815D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public RetrieveLastGPSLocTask f45816E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public List<GPSListener> f45817F;

    /* renamed from: G */
    private LocationListener f45818G;

    /* renamed from: a */
    OSLocationWrapper f45819a;

    /* renamed from: b */
    CopyOnWriteArraySet<GPSListener> f45820b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f45821d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LocationManager f45822e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f45823f;

    /* renamed from: g */
    private long f45824g;

    /* renamed from: h */
    private GpsStatus f45825h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f45826i;

    /* renamed from: j */
    private int f45827j;

    /* renamed from: k */
    private long f45828k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f45829l;

    /* renamed from: m */
    private boolean f45830m;

    /* renamed from: n */
    private volatile int f45831n;

    /* renamed from: o */
    private boolean f45832o;

    /* renamed from: p */
    private long f45833p;

    /* renamed from: q */
    private C15138e<Location> f45834q;

    /* renamed from: r */
    private boolean f45835r;

    /* renamed from: s */
    private long f45836s;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f45837u;

    /* renamed from: v */
    private GpsGNSSProcessor f45838v;

    /* renamed from: w */
    private GpsGNSSProcessor.OnGNSSDataListener f45839w;

    /* renamed from: x */
    private Runnable f45840x;

    /* renamed from: y */
    private Runnable f45841y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f45842z;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$GPSListener */
    public interface GPSListener {
        void onLocationChanged(OSLocationWrapper oSLocationWrapper);
    }

    /* renamed from: e */
    static /* synthetic */ int m32857e(GpsManager gpsManager) {
        int i = gpsManager.f45837u;
        gpsManager.f45837u = i + 1;
        return i;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$InstanceHolder */
    private static class InstanceHolder {
        static final GpsManager sInstance = new GpsManager();

        private InstanceHolder() {
        }
    }

    public static GpsManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private GpsManager() {
        this.f45823f = 0;
        this.f45824g = 0;
        this.f45825h = null;
        this.f45826i = -1.0f;
        this.f45827j = 0;
        this.f45829l = -1;
        this.f45830m = false;
        this.f45831n = -1;
        this.f45832o = false;
        this.f45833p = 8000;
        this.f45835r = false;
        this.f45837u = 0;
        this.f45839w = new GpsGNSSProcessor.OnGNSSDataListener() {
            public void onDataCallback(GNSSData gNSSData) {
                if (!GpsManager.this.m32858e() && gNSSData != null) {
                    long unused = GpsManager.this.f45823f = Utils.getTimeBoot();
                    int unused2 = GpsManager.this.f45829l = gNSSData.fixedSatelliteNum;
                    float unused3 = GpsManager.this.f45826i = gNSSData.signalLevel;
                    AccTimeFilterHelper.getInstance().setCurrentSatelliteNum(GpsManager.this.f45829l);
                }
            }
        };
        this.f45840x = new WaitSingleGPSTask();
        this.f45841y = new SingleGPSLocateTask();
        this.f45842z = 0;
        this.f45812A = new GpsStatus.Listener() {
            public void onGpsStatusChanged(int i) {
                long unused = GpsManager.this.f45842z = Utils.getTimeBoot();
                GpsManager.this.m32832a(i);
            }
        };
        this.f45813B = new LocationListener() {
            public void onLocationChanged(Location location) {
                if (Utils.locCorrect(location)) {
                    ThreadDispatcher.getWorkThread().removeCallbacks((Runnable) GpsManager.this.f45816E);
                }
                GpsManager.this.m32834a(location);
                ThreadDispatcher.getWorkThread().postDelayed(GpsManager.this.f45816E, Const.DELAY_TIME4LAST_GPS_TASK);
                GpsManager.m32857e(GpsManager.this);
                if (GpsManager.this.f45837u == 10) {
                    int unused = GpsManager.this.f45837u = 0;
                    DLog.m32737d("GpsManager location arrived: gps");
                }
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
                GpsManager.this.m32842a(str, i, bundle);
            }

            public void onProviderEnabled(String str) {
                DLog.m32737d("gps provider enabled");
            }

            public void onProviderDisabled(String str) {
                DLog.m32737d("gps provider disabled");
            }
        };
        this.f45814C = new SingleGPSLocationListener();
        this.f45815D = 0;
        this.f45816E = new RetrieveLastGPSLocTask();
        this.f45820b = new CopyOnWriteArraySet<>();
        this.f45817F = new ArrayList();
        this.f45818G = new LocationListener() {
            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            public void onLocationChanged(Location location) {
                if (location != null && TextUtils.equals(location.getProvider(), "gps")) {
                    if (DIDILocationManager.enableMockLocation || !MockLocationChecker.isMockLocation(GpsManager.this.f45821d, location)) {
                        for (GPSListener onLocationChanged : GpsManager.this.f45817F) {
                            onLocationChanged.onLocationChanged(new OSLocationWrapper(location, System.currentTimeMillis()));
                        }
                    }
                }
            }
        };
    }

    public void init(Context context) {
        this.f45821d = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32831a() {
        Context context = this.f45821d;
        if (context != null && !this.f45830m) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            this.f45822e = locationManager;
            boolean hasGpsProvider = Utils.hasGpsProvider(locationManager);
            this.f45832o = hasGpsProvider;
            if (!hasGpsProvider) {
                DLog.m32737d("initGpsListeners: does not found gps provider");
                return;
            }
            try {
                boolean sendExtraCommand = this.f45822e.sendExtraCommand("gps", "force_xtra_injection", (Bundle) null);
                DLog.m32737d("using agps: " + sendExtraCommand);
            } catch (Exception unused) {
            }
            m32870k();
            Config.LocateMode finalLocateMode = Config.getFinalLocateMode();
            boolean z = false;
            if (finalLocateMode == Config.LocateMode.HIGH_ACCURATE) {
                m32853c();
            } else if (finalLocateMode == Config.LocateMode.SAVE_GPS_POWER) {
                m32844a(false);
                this.f45828k = Utils.getTimeBoot();
                this.f45816E.setContinuousRun(z);
                ThreadDispatcher.getWorkThread().postDelayed(this.f45816E, 4025);
                FilterJumpGPSStrategyInterceptor instance = FilterJumpGPSStrategyInterceptor.getInstance(this.f45821d);
                this.f45834q = instance;
                mo114562a((C15138e) instance);
                this.f45830m = true;
            }
            z = true;
            this.f45828k = Utils.getTimeBoot();
            this.f45816E.setContinuousRun(z);
            ThreadDispatcher.getWorkThread().postDelayed(this.f45816E, 4025);
            FilterJumpGPSStrategyInterceptor instance2 = FilterJumpGPSStrategyInterceptor.getInstance(this.f45821d);
            this.f45834q = instance2;
            mo114562a((C15138e) instance2);
            this.f45830m = true;
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$WaitSingleGPSTask */
    private class WaitSingleGPSTask implements Runnable {
        private WaitSingleGPSTask() {
        }

        public void run() {
            GpsManager.this.m32848b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32848b() {
        if (this.f45832o) {
            try {
                this.f45822e.removeUpdates(this.f45814C);
                this.f45814C.setIsUsing(false);
            } catch (Throwable th) {
                DLog.m32737d("remove single GPS exception, " + th.getMessage());
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$SingleGPSLocateTask */
    private class SingleGPSLocateTask implements Runnable {
        private SingleGPSLocateTask() {
        }

        public void run() {
            GpsManager.this.m32844a(true);
        }
    }

    public void delayExecuteSingleGpsLocate(long j) {
        long j2 = j - Const.DELAY_TIME4LAST_GPS_TASK;
        if (j2 <= 0) {
            j2 = 0;
        }
        ThreadDispatcher.getWorkThread().postDelayed(this.f45841y, j2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32844a(boolean z) {
        if (this.f45832o && !this.f45814C.isUsing()) {
            try {
                this.f45822e.requestSingleUpdate("gps", this.f45814C, ThreadDispatcher.getWorkThread().getLooper());
                this.f45814C.setIsUsing(true);
                ThreadDispatcher.getWorkThread().postDelayed(this.f45840x, this.f45833p);
                if (z) {
                    this.f45816E.setContinuousRun(false);
                    ThreadDispatcher.getWorkThread().postDelayed(this.f45816E, 3800);
                }
            } catch (SecurityException e) {
                m32843a((Throwable) e);
            } catch (Throwable th) {
                m32843a(th);
            }
        }
    }

    /* renamed from: c */
    private void m32853c() {
        try {
            this.f45835r = false;
            this.f45822e.requestLocationUpdates("gps", Utils.isOnViechleMounted(this.f45821d) ? 200 : 1000, 0.0f, this.f45813B, ThreadDispatcher.getWorkThread().getLooper());
        } catch (SecurityException e) {
            m32843a((Throwable) e);
        } catch (Throwable th) {
            m32843a(th);
        }
    }

    /* renamed from: a */
    private void m32843a(Throwable th) {
        int i;
        DLog.m32737d("GpsManager GPSManager exception, " + th.getMessage() + "," + th.getClass() + "," + th.getLocalizedMessage());
        if (th instanceof SecurityException) {
            i = 512;
            this.f45835r = true;
        } else {
            i = 1024;
        }
        m32841a("gps", i);
    }

    public void tryInitWhenPermissionGranted() {
        if (PermRetryApollo.getInstance().shouldRetryLoc() && this.f45830m && this.f45835r && this.f45821d != null && SystemClock.elapsedRealtime() - this.f45836s > 15000) {
            this.f45836s = SystemClock.elapsedRealtime();
            DLog.m32737d("GpsManager retry loc google gps");
            if (Utils.isLocationPermissionGranted(this.f45821d) && Config.getFinalLocateMode() == Config.LocateMode.HIGH_ACCURATE) {
                DLog.m32737d("GpsManager RESTART loc when permission granted");
                m32853c();
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$SingleGPSLocationListener */
    private class SingleGPSLocationListener implements LocationListener {
        private boolean mIsUsing;

        private SingleGPSLocationListener() {
            this.mIsUsing = false;
        }

        public boolean isUsing() {
            return this.mIsUsing;
        }

        public void setIsUsing(boolean z) {
            this.mIsUsing = z;
        }

        public void onLocationChanged(Location location) {
            if (Utils.locCorrect(location)) {
                ThreadDispatcher.getWorkThread().removeCallbacks((Runnable) GpsManager.this.f45816E);
            }
            setIsUsing(false);
            GpsManager.this.m32856d();
            GpsManager.this.m32848b();
            GpsManager.this.m32834a(location);
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            GpsManager.this.m32842a(str, i, bundle);
        }

        public void onProviderEnabled(String str) {
            DLog.m32737d("gps provider enabled");
        }

        public void onProviderDisabled(String str) {
            DLog.m32737d("gps provider disabled");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32856d() {
        ThreadDispatcher.getWorkThread().removeCallbacks(this.f45840x);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32842a(String str, int i, Bundle bundle) {
        if ("gps".equals(str)) {
            this.f45831n = i;
            if (i == 0) {
                m32841a("gps", 1024);
                DLog.m32737d("gps provider out of service");
            } else if (i == 1) {
                m32841a("gps", 1280);
                DLog.m32737d("gps provider temporarily unavailable");
            } else if (i == 2) {
                m32841a("gps", 768);
                DLog.m32737d("gps provider available");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32834a(Location location) {
        this.f45842z = Utils.getTimeBoot();
        if (Utils.locCorrect(location)) {
            boolean isMockLocation = Utils.isMockLocation(location);
            Utils.setIsGpsMocked(isMockLocation);
            if (!isMockLocation || DIDILocationManager.enableMockLocation) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f45815D > 15000) {
                    DLog.m32737d("-onLocationChanged-: type gps, location: " + location.getLongitude() + "," + location.getLatitude() + ", " + location.getSpeed() + ", " + location.getBearing() + ", " + location.getAccuracy() + ", " + location.getTime());
                    this.f45815D = currentTimeMillis;
                }
                if (mo114561a(location) != null) {
                    TimeServiceManager.getInstance().updateStandardTimeRef(TimeSource.GPS, location.getTime());
                    LocNTPHelper.adjustSystemLocationTimestamp(location);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    OSLocationWrapper oSLocationWrapper = new OSLocationWrapper(location, currentTimeMillis2);
                    this.f45819a = oSLocationWrapper;
                    m32835a(oSLocationWrapper);
                    SensorMonitor.getInstance(this.f45821d).setGpsFixedTimestamp(currentTimeMillis2);
                    return;
                }
                return;
            }
            DLog.m32737d("on gps callback, mock loc and disable mock!");
        }
    }

    public OSLocationWrapper getGPSLocation() {
        return this.f45819a;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$RetrieveLastGPSLocTask */
    private class RetrieveLastGPSLocTask implements Runnable {
        private boolean mContinuousRun;

        private RetrieveLastGPSLocTask() {
            this.mContinuousRun = true;
        }

        public void setContinuousRun(boolean z) {
            this.mContinuousRun = z;
        }

        public void run() {
            if (GpsManager.this.f45822e != null) {
                try {
                    Location lastKnownLocation = GpsManager.this.f45822e.getLastKnownLocation("gps");
                    if (lastKnownLocation != null && ((!Utils.isMockLocation(lastKnownLocation) && !Utils.isMockSettingsON(GpsManager.this.f45821d)) || DIDILocationManager.enableMockLocation)) {
                        long nTPCurrenTimeMillis = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        if (Utils.locCorrect(lastKnownLocation) && nTPCurrenTimeMillis - lastKnownLocation.getTime() < 8000 && ((GpsManager.this.f45819a == null || lastKnownLocation.getTime() > GpsManager.this.f45819a.getLocation().getTime()) && GpsManager.this.mo114561a(lastKnownLocation) != null)) {
                            TimeServiceManager.getInstance().updateStandardTimeRef(TimeSource.GPS, lastKnownLocation.getTime());
                            LocNTPHelper.adjustSystemLocationTimestamp(lastKnownLocation);
                            GpsManager.this.f45819a = new OSLocationWrapper(lastKnownLocation, System.currentTimeMillis());
                            GpsManager.this.f45819a.setGpsSourceType(1);
                            GpsManager.this.m32835a(GpsManager.this.f45819a);
                            DLog.m32737d("updateFromLastKnownLocation for gps success");
                        }
                    }
                    if (this.mContinuousRun) {
                        ThreadDispatcher.getWorkThread().postDelayed(GpsManager.this.f45816E, 1000);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32835a(OSLocationWrapper oSLocationWrapper) {
        Iterator<GPSListener> it = this.f45820b.iterator();
        while (it.hasNext()) {
            it.next().onLocationChanged(oSLocationWrapper);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32832a(int i) {
        LocationManager locationManager = this.f45822e;
        if (locationManager != null) {
            try {
                if (locationManager.isProviderEnabled("gps")) {
                    if (i == 1) {
                        DLog.m32737d("gps event started");
                    } else if (i == 2) {
                        DLog.m32737d("gps event stopped");
                    } else if (i == 3) {
                        DLog.m32737d("gps event first fix");
                    } else if (i == 4 && !m32858e()) {
                        try {
                            this.f45823f = Utils.getTimeBoot();
                            this.f45826i = 0.0f;
                            GpsStatus gpsStatus = this.f45822e.getGpsStatus((GpsStatus) null);
                            this.f45825h = gpsStatus;
                            int maxSatellites = gpsStatus.getMaxSatellites();
                            Iterator<GpsSatellite> it = this.f45825h.getSatellites().iterator();
                            this.f45827j = 0;
                            this.f45829l = 0;
                            while (it.hasNext() && this.f45827j <= maxSatellites) {
                                GpsSatellite next = it.next();
                                this.f45826i += next.getSnr();
                                this.f45827j++;
                                if (next.usedInFix()) {
                                    this.f45829l++;
                                }
                            }
                            AccTimeFilterHelper.getInstance().setCurrentSatelliteNum(this.f45829l);
                            if (!m32860f()) {
                                this.f45824g = Utils.getTimeBoot();
                                DLog.m32737d("GpsManagergps satellite number:(" + this.f45829l + ")/" + this.f45827j + " level:" + this.f45826i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m32858e() {
        if (this.f45823f != 0 && Utils.getTimeBoot() - this.f45823f < 950) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private boolean m32860f() {
        if (this.f45824g != 0 && Utils.getTimeBoot() - this.f45824g < 10000) {
            return true;
        }
        return false;
    }

    public int getFixLocSatelliteNum() {
        if (Utils.getTimeBoot() - this.f45823f < 5000) {
            return this.f45829l;
        }
        return -1;
    }

    public float getGpsSignalLevel() {
        if (Utils.getTimeBoot() - this.f45823f < 5000) {
            return this.f45826i;
        }
        return -1.0f;
    }

    public int getLastGpsStatus() {
        return this.f45831n;
    }

    /* renamed from: g */
    private void m32861g() {
        if (this.f45821d != null && this.f45822e != null && this.f45830m) {
            try {
                m32866i();
                m32864h();
            } catch (Throwable th) {
                DLog.m32737d("destroy exception, " + th.getMessage());
            }
            m32871l();
            this.f45819a = null;
            this.f45822e = null;
            ThreadDispatcher.getWorkThread().removeCallbacks((Runnable) this.f45816E);
            mo114563b(this.f45834q);
            this.f45830m = false;
        }
    }

    /* renamed from: h */
    private void m32864h() {
        m32848b();
        m32867j();
        m32856d();
    }

    /* renamed from: i */
    private void m32866i() {
        this.f45822e.removeUpdates(this.f45813B);
    }

    /* renamed from: j */
    private void m32867j() {
        ThreadDispatcher.getWorkThread().removeCallbacks(this.f45841y);
    }

    public long getReceiveGpsSignalTime() {
        return this.f45842z;
    }

    public long getStartedTime() {
        return this.f45828k;
    }

    public synchronized void removeListenGps(GPSListener gPSListener) {
        this.f45820b.remove(gPSListener);
        if (this.f45820b.size() == 0) {
            m32861g();
        }
    }

    public synchronized void requestListenGps(GPSListener gPSListener) {
        if (this.f45820b.size() == 0) {
            m32831a();
        }
        this.f45820b.add(gPSListener);
    }

    public void reset() {
        if (this.f45820b.size() > 0) {
            m32861g();
            ThreadDispatcher.getWorkThread().postDelayed(new Runnable() {
                public void run() {
                    if (GpsManager.this.f45820b.size() > 0) {
                        DLog.m32737d("restart gps->start");
                        GpsManager.this.m32831a();
                    }
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32833a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                locationManager.requestLocationUpdates("passive", 1000, 0.0f, this.f45818G, ThreadDispatcher.getMainThread().getLooper());
                DLog.m32737d("GpsManager-->" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception | SecurityException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32849b(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.f45818G);
            } catch (Exception | SecurityException unused) {
            }
        }
    }

    public void requestSysPassiveListener(final Context context, final GPSListener gPSListener) {
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                GpsManager.this.f45817F.add(gPSListener);
                if (GpsManager.this.f45817F.size() == 1) {
                    GpsManager.this.m32833a(context);
                }
            }
        });
    }

    public void removeSysPassiveListener(final Context context, final GPSListener gPSListener) {
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                GpsManager.this.f45817F.remove(gPSListener);
                if (GpsManager.this.f45817F.size() == 0) {
                    GpsManager.this.m32849b(context);
                }
            }
        });
    }

    /* renamed from: k */
    private void m32870k() {
        try {
            if (this.f45822e != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    if (this.f45838v == null) {
                        this.f45838v = new GpsGNSSProcessor(this.f45822e);
                    }
                    this.f45838v.setOnGNSSDataListener(this.f45839w);
                    this.f45838v.start();
                    return;
                }
                this.f45822e.addGpsStatusListener(this.f45812A);
            }
        } catch (SecurityException e) {
            DLog.m32737d("GpsManagerstartGpsStatusMonitor: se: " + e.getMessage());
        } catch (Exception e2) {
            DLog.m32737d("GpsManagerstartGpsStatusMonitor: " + e2.getMessage());
        }
    }

    /* renamed from: l */
    private void m32871l() {
        try {
            if (this.f45822e != null) {
                if (Build.VERSION.SDK_INT < 24) {
                    this.f45822e.removeGpsStatusListener(this.f45812A);
                } else if (this.f45838v != null) {
                    this.f45838v.setOnGNSSDataListener((GpsGNSSProcessor.OnGNSSDataListener) null);
                    this.f45838v.stop();
                }
                this.f45831n = -1;
            }
        } catch (SecurityException e) {
            DLog.m32737d("GpsManagerstopGpsStatusMonitor: se: " + e.getMessage());
        } catch (Exception e2) {
            DLog.m32737d("GpsManagerstopGpsStatusMonitor: " + e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m32841a(String str, int i) {
        StatusBroadcastManager.getInstance().broadcastStatus(str, i);
    }
}
