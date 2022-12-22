package com.didi.foundation.sdk.location;

import android.content.Context;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.service.ApplicationService;
import com.didi.sdk.logging.Logger;
import com.didi.soda.andy.tools.LogUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.File;

@ServiceProvider({LocationServiceProvider.class})
public class LocationPerformerImpl implements LocationServiceProvider {

    /* renamed from: a */
    private static final String f21207a = "LocationPerformerImpl";

    /* renamed from: b */
    private static boolean f21208b = false;

    /* renamed from: c */
    private Logger f21209c = LogService.getLogger((Class<?>) LocationPerformerImpl.class);

    /* renamed from: d */
    private DIDILocationManager f21210d;

    /* renamed from: e */
    private DIDILocationUpdateOption f21211e;

    /* renamed from: f */
    private MonitorLocationListener f21212f = new MonitorLocationListener();

    /* renamed from: g */
    private String f21213g;

    /* renamed from: h */
    private Config.LocateMode f21214h;

    /* renamed from: i */
    private DIDILocationUpdateOption.IntervalMode f21215i;

    /* renamed from: j */
    private int f21216j = 0;

    public DIDILocation getLastKnownLocation() {
        DIDILocationManager dIDILocationManager = this.f21210d;
        if (dIDILocationManager == null) {
            return null;
        }
        return dIDILocationManager.getLastKnownLocation();
    }

    public double getLatitude() {
        if (getLastKnownLocation() != null) {
            return getLastKnownLocation().getLatitude();
        }
        return 0.0d;
    }

    public double getLongitude() {
        if (getLastKnownLocation() != null) {
            return getLastKnownLocation().getLongitude();
        }
        return 0.0d;
    }

    public LocationServiceProvider registerLocationListener(BaseLocationListener baseLocationListener) {
        this.f21212f.add(baseLocationListener);
        return this;
    }

    public void requestOnceLocation(DIDILocationListener dIDILocationListener) {
        DIDILocationManager dIDILocationManager = this.f21210d;
        if (dIDILocationManager != null) {
            dIDILocationManager.requestLocationUpdateOnce(dIDILocationListener, this.f21213g);
        }
    }

    public LocationServiceProvider setInterval(DIDILocationUpdateOption.IntervalMode intervalMode) {
        if (intervalMode == null) {
            return this;
        }
        this.f21215i = intervalMode;
        return this;
    }

    public LocationServiceProvider setLocateMode(Config.LocateMode locateMode) {
        if (locateMode == null) {
            return this;
        }
        this.f21214h = locateMode;
        return this;
    }

    public LocationServiceProvider setCoordinateType(int i) {
        this.f21216j = i;
        DIDILocationManager dIDILocationManager = this.f21210d;
        if (dIDILocationManager != null) {
            if (dIDILocationManager.isRunning()) {
                Logger logger = this.f21209c;
                logger.error(LogUtils.getLineText("⚠️setCoordinateType() called with: type = [" + i + "] fail LocationManager isRunning"), new Object[0]);
            } else {
                this.f21210d.setCoordinateType(this.f21216j);
            }
        }
        return this;
    }

    public LocationServiceProvider setLogPath(File file) {
        DIDILocationManager dIDILocationManager = this.f21210d;
        if (dIDILocationManager != null) {
            dIDILocationManager.setLogPath(file);
        }
        return this;
    }

    public LocationServiceProvider startLocation(Context context) {
        LogUtils.m27515t(f21207a, "⚠️startLocation() called with: context = [" + context + Const.jaRight);
        DIDILocationManager dIDILocationManager = this.f21210d;
        if (dIDILocationManager != null && dIDILocationManager.isRunning()) {
            return this;
        }
        if (this.f21210d == null) {
            this.f21209c.error(LogUtils.getLineText("⚠️ startLocation() called with: mLocationManager == null"), new Object[0]);
            initLocationManager(context);
        }
        int requestLocationUpdates = this.f21210d.requestLocationUpdates(this.f21212f, this.f21211e);
        Logger logger = this.f21209c;
        logger.debug("code: " + requestLocationUpdates, new Object[0]);
        return this;
    }

    public LocationServiceProvider stopLocation() {
        LogUtils.m27507d(f21207a, "⚠️stopLocation() called");
        DIDILocationManager dIDILocationManager = this.f21210d;
        if (dIDILocationManager != null) {
            dIDILocationManager.removeLocationUpdates(this.f21212f);
        }
        return this;
    }

    public LocationServiceProvider enableMock(boolean z) {
        f21208b = z;
        DIDILocationManager.getInstance(FoundationApplicationListener.getApplication()).enableMockLocation(z);
        return this;
    }

    public boolean isMockEnabled() {
        return f21208b;
    }

    public LocationServiceProvider unRegisterLocationListener(BaseLocationListener baseLocationListener) {
        this.f21212f.remove(baseLocationListener);
        return this;
    }

    public void initLocationManager(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        this.f21210d = instance;
        this.f21211e = instance.getDefaultLocationUpdateOption();
        this.f21213g = context.getPackageName();
        DIDILocationUpdateOption.IntervalMode intervalMode = this.f21215i;
        if (intervalMode != null) {
            this.f21211e.setInterval(intervalMode);
        } else {
            this.f21211e.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
        }
        Config.LocateMode locateMode = this.f21214h;
        if (locateMode != null) {
            this.f21210d.setLocateMode(locateMode);
        }
        this.f21211e.setModuleKey(ApplicationService.getInstance().getVersionName());
        this.f21211e.setModuleKey(this.f21213g);
        this.f21210d.setAppVersionName(ApplicationService.getInstance().getVersionName());
        try {
            this.f21210d.setPhonenum(AccountService.getInstance().getPhone());
        } catch (Exception e) {
            Logger logger = this.f21209c;
            logger.info(LogUtils.getLineText("⚠️initLocationManager() called with: context = [" + context + Const.jaRight), (Throwable) e);
        }
        this.f21210d.setAppid(this.f21213g);
        this.f21210d.setCoordinateType(this.f21216j);
    }
}
