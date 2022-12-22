package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.didi.mapbizinterface.MapBizInterface;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.biz.BizManager;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocCenter;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocationListenerWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocationStorage;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.ThreadDispatcher;
import com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.utils.TraceUtils;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationManager */
public class DIDILocationManager implements IDIDILocationManager {

    /* renamed from: a */
    private static volatile DIDILocationManager f45677a = null;
    protected static String appid = "test";

    /* renamed from: c */
    private static Context f45678c = null;
    public static boolean enableMockLocation = false;
    protected static volatile long startstamp;

    /* renamed from: b */
    private final Object f45679b = new Object();

    /* renamed from: d */
    private boolean f45680d = false;

    /* renamed from: e */
    private LocCenter f45681e = null;

    /* renamed from: f */
    private HashSet<DIDILocationListener> f45682f;

    /* renamed from: g */
    private DIDILocationListener f45683g;

    /* renamed from: h */
    private DIDILocationUpdateOption f45684h;

    public String getBuildBranch() {
        return BuildConfig.BUILD_BRANCH;
    }

    public String getBuildVersion() {
        return BuildConfig.BUILD_VERSION;
    }

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam, int i) {
        return -1;
    }

    public int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, String str, int i) {
        return -1;
    }

    @Deprecated
    public void setApolloToggleName(String str) {
    }

    public void setLogPath(File file) {
    }

    @Deprecated
    public void setTimeServiceImpl(Object obj) {
    }

    public void setUseFlp(boolean z) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32723a(DIDILocation dIDILocation) {
        HashSet<DIDILocationListener> hashSet = this.f45682f;
        if (hashSet != null) {
            Iterator<DIDILocationListener> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().onLocationChanged(dIDILocation);
            }
        }
    }

    private DIDILocationManager(Context context) {
        f45678c = context.getApplicationContext();
        this.f45682f = new HashSet<>();
        this.f45683g = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                DIDILocationManager.this.m32723a(dIDILocation);
                DIDILocationManager.this.m32733b();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                DIDILocationManager.this.m32722a(i, errInfo);
                DIDILocationManager.this.m32733b();
            }
        };
        DIDILocationUpdateOption defaultLocationUpdateOption = getDefaultLocationUpdateOption();
        this.f45684h = defaultLocationUpdateOption;
        defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
        BizManager.getIntance().init(context);
        MapBizInterface.getInstance().init(context);
        SystemUtil.init(context.getApplicationContext());
        DLog.m32737d("DIDILocationManager single instance constructed!!");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32722a(int i, ErrInfo errInfo) {
        HashSet<DIDILocationListener> hashSet = this.f45682f;
        if (hashSet != null) {
            Iterator<DIDILocationListener> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().onLocationError(i, errInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32733b() {
        this.f45682f.clear();
        this.f45684h.setModuleKey((String) null);
        removeLocationUpdates(this.f45683g);
    }

    public static DIDILocationManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        f45678c = context.getApplicationContext();
        if (f45677a == null) {
            synchronized (DIDILocationManager.class) {
                if (f45677a == null) {
                    f45677a = new DIDILocationManager(f45678c);
                }
            }
        }
        return f45677a;
    }

    /* renamed from: a */
    private synchronized int m32720a(LocationListenerWrapper locationListenerWrapper) {
        if (Build.VERSION.SDK_INT < 9) {
            return 1;
        }
        startstamp = System.currentTimeMillis();
        DLog.m32737d("LocManager # startLocService called, locListener hash " + locationListenerWrapper.hashCode());
        DLog.m32737d("SDK VER : 1.1.016, BUILD : 202208121644");
        if (this.f45681e == null) {
            DLog.m32737d("startLocService: new mLocCenter");
            this.f45681e = new LocCenter(f45678c);
        }
        this.f45681e.start(locationListenerWrapper, appid);
        DIDILocBusinessHelper.getInstance().init(f45678c);
        this.f45680d = true;
        DLog.m32737d("-startLocService- : success!");
        return 0;
    }

    public void setPhonenum(String str) {
        TraceUtils.setPhone(f45678c, str);
    }

    /* renamed from: a */
    static Context m32721a() {
        return f45678c;
    }

    public void setAppVersionName(String str) {
        Utils.saveAppVersion(f45678c, str);
    }

    public void setAppid(String str) {
        appid = str;
    }

    /* renamed from: c */
    private void m32735c() {
        if (Build.VERSION.SDK_INT >= 9) {
            if (this.f45680d || this.f45681e != null) {
                DLog.m32737d("LocManager # stop loc service");
                LocCenter locCenter = this.f45681e;
                if (locCenter != null) {
                    locCenter.stop();
                }
                this.f45681e = null;
                DIDILocBusinessHelper.getInstance().destroy();
                this.f45680d = false;
                return;
            }
            DLog.m32737d("LocManager # loc service is not running");
        }
    }

    public String getAppid() {
        return appid;
    }

    public DIDILocation getLastKnownLocation() {
        return LocationStorage.getInstance().getLastKnownLocation();
    }

    public boolean isRunning() {
        return this.f45680d;
    }

    public int requestLocationUpdateOnce(final DIDILocationListener dIDILocationListener, final String str) {
        if (dIDILocationListener == null) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            final ErrInfo errInfo = new ErrInfo(202);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_MODULE_PERMISSION);
            ThreadDispatcher.getMainThread().post(new Runnable() {
                public void run() {
                    dIDILocationListener.onLocationError(202, errInfo);
                }
            });
            return -1;
        }
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m32726a(dIDILocationListener, str);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32726a(DIDILocationListener dIDILocationListener, String str) {
        this.f45682f.add(dIDILocationListener);
        String moduleKey = this.f45684h.getModuleKey();
        if (!TextUtils.isEmpty(moduleKey)) {
            str = moduleKey + "|" + str;
        }
        this.f45684h.setModuleKey(str);
        m32725a(this.f45683g, this.f45684h);
    }

    public int requestLocationUpdates(final DIDILocationListener dIDILocationListener, final DIDILocationUpdateOption dIDILocationUpdateOption) {
        if (dIDILocationListener == null || dIDILocationUpdateOption == null) {
            return -1;
        }
        if (dIDILocationUpdateOption.getInterval() == DIDILocationUpdateOption.IntervalMode.SUPER_HIGH_FREQUENCY && !Utils.isOnViechleMounted(f45678c)) {
            dIDILocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
        }
        if (TextUtils.isEmpty(dIDILocationUpdateOption.getModuleKey())) {
            final ErrInfo errInfo = new ErrInfo(202);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_MODULE_PERMISSION);
            ThreadDispatcher.getMainThread().post(new Runnable() {
                public void run() {
                    dIDILocationListener.onLocationError(202, errInfo);
                }
            });
            return -1;
        }
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m32725a(dIDILocationListener, dIDILocationUpdateOption);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32725a(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption dIDILocationUpdateOption) {
        LocationListenerWrapper locationListenerWrapper = new LocationListenerWrapper(dIDILocationListener, dIDILocationUpdateOption);
        if (!this.f45680d || this.f45681e == null) {
            m32720a(locationListenerWrapper);
            return;
        }
        DIDILocation lastKnownLocation = LocationStorage.getInstance().getLastKnownLocation();
        if (lastKnownLocation == null || !lastKnownLocation.isEffective()) {
            if (this.f45681e.getLastErrInfo() != null) {
                dIDILocationListener.onLocationError(this.f45681e.getLastErrInfo().getErrNo(), this.f45681e.getLastErrInfo());
            }
        } else if (this.f45681e.getLastErrInfo() == null || this.f45681e.getLastErrInfo().getLocalTime() <= lastKnownLocation.getLocalTime()) {
            dIDILocationListener.onLocationChanged(lastKnownLocation);
        } else {
            dIDILocationListener.onLocationError(this.f45681e.getLastErrInfo().getErrNo(), this.f45681e.getLastErrInfo());
        }
        this.f45681e.addLocListener(locationListenerWrapper);
    }

    public int removeLocationUpdates(final DIDILocationListener dIDILocationListener) {
        if (dIDILocationListener == null) {
            return -1;
        }
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m32724a(dIDILocationListener);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32724a(DIDILocationListener dIDILocationListener) {
        if (this.f45680d && this.f45681e != null) {
            if (dIDILocationListener != this.f45683g || this.f45682f.size() <= 0) {
                this.f45681e.removeLocListener(dIDILocationListener);
                if (this.f45681e.getLocListenersLength() == 0 && this.f45682f.size() == 0) {
                    m32735c();
                }
            }
        }
    }

    public void removeAllListeners() {
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m32736d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32736d() {
        if (ThreadDispatcher.getMainThread().isCurrentThread() && this.f45680d && this.f45681e != null) {
            m32733b();
            this.f45681e.removeAllLocListeners();
            m32735c();
        }
    }

    public void enableMockLocation(boolean z) {
        enableMockLocation = z;
        if (z) {
            DLog.m32737d("enable mock location:\n" + Log.getStackTraceString(new Exception()));
        }
    }

    public DIDILocationUpdateOption getDefaultLocationUpdateOption() {
        return new DIDILocationUpdateOption();
    }

    public int getGpsStatus() {
        int i = 0;
        int i2 = !SensorMonitor.getInstance(f45678c).isGpsEnabled() ? 256 : 0;
        if (Utils.checkSystemPermission(f45678c, Permission.ACCESS_FINE_LOCATION) != 0) {
            i = 512;
        }
        return i2 | i;
    }

    public int getWifiStatus() {
        int i = 0;
        int i2 = !SensorMonitor.getInstance(f45678c).isWifiEnabled() ? 16 : 0;
        int i3 = !Utils.isLocationPermissionGranted(f45678c) ? 32 : 0;
        if (Utils.isLocationSwitchOff(f45678c)) {
            i = 64;
        }
        return i2 | i3 | i;
    }

    public int getCellStatus() {
        int simState = ((TelephonyManager) f45678c.getSystemService("phone")).getSimState();
        int i = 0;
        int i2 = (simState == 0 || simState == 1) ? 0 : 1;
        if (!Utils.isLocationPermissionGranted(f45678c) && Build.VERSION.SDK_INT >= 23) {
            i = 2;
        }
        return (i2 ^ 1) | i;
    }

    public void setCoordinateType(int i) {
        if (this.f45680d) {
            DLog.m32737d("set coordinate type: " + i + " failed already ruuning");
        } else if (i == 1 || i == 0) {
            Utils.setCoordinateType(i);
            DLog.m32737d("set coordinate type success " + i);
        }
    }

    public String getListenersInfo() {
        LocCenter locCenter = this.f45681e;
        return locCenter != null ? locCenter.getListenersInfo() : "";
    }

    public synchronized int startNavLocate(DIDILocationListener dIDILocationListener, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Config.mNaviLocListener = dIDILocationListener;
        DIDILocationUpdateOption defaultLocationUpdateOption = getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey(str);
        defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
        defaultLocationUpdateOption.setDirectNotify(true);
        return requestLocationUpdates(dIDILocationListener, defaultLocationUpdateOption);
    }

    public synchronized void stopNavLocate() {
        removeLocationUpdates(Config.mNaviLocListener);
    }

    public boolean isHighAccuracyLocationAvailable() {
        if (!Utils.isLocationPermissionGranted(m32721a()) || Utils.getLocationSwitchLevel(m32721a()) != 3) {
            return false;
        }
        return true;
    }

    public boolean isGpsLocationAvailable() {
        if (!Utils.isLocationPermissionGranted(m32721a())) {
            return false;
        }
        int locationSwitchLevel = Utils.getLocationSwitchLevel(m32721a());
        if (locationSwitchLevel == 3 || locationSwitchLevel == 1) {
            return true;
        }
        return false;
    }

    public boolean isNetLocationAvailable() {
        if (!Utils.isLocationPermissionGranted(m32721a())) {
            return false;
        }
        int locationSwitchLevel = Utils.getLocationSwitchLevel(m32721a());
        if (locationSwitchLevel == 3 || locationSwitchLevel == 2) {
            return true;
        }
        return false;
    }

    public boolean isLocationSwitchOff() {
        return Utils.isLocationSwitchOff(f45678c);
    }

    public List<DIDILocation> getRecentLocation(int i) {
        return LocationStorage.getInstance().getRecentLocations(i);
    }

    public void setOnlyOSLocationAbroad(boolean z) {
        if (!this.f45680d) {
            Utils.setOnlyOSLocationAbroad(z);
        }
    }

    public void setLocatePermissonStrategy(Config.LocatePermissonStrategy locatePermissonStrategy) {
        DLog.m32737d("setLocatePermissonStrategy strategy=" + locatePermissonStrategy + " isRunning=" + this.f45680d);
        if (!this.f45680d && locatePermissonStrategy != null) {
            Config.sPermissionStrategy = locatePermissonStrategy;
        }
    }

    public void setLocateMode(Config.LocateMode locateMode) {
        if (ApolloProxy.getInstance().isAllowLowPowerGPSMode() && Config.getConigLocateMode() != locateMode) {
            Config.setLocateMode(locateMode);
            if (locateMode == Config.LocateMode.SAVE_GPS_POWER) {
                DLog.m32737d("set save GPS mode:\n" + Log.getStackTraceString(new Exception()));
            }
        }
    }
}
