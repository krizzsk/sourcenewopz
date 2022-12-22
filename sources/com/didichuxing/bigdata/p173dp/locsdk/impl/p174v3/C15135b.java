package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.FLPDiffInfoGetter;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocConfessor;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter.AccTimeFilter;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter.AccTimeFilterHelper;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator.GoogleFusionFilter;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator.IFLPLocator;
import com.didichuxing.bigdata.p173dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.utils.LocExceptionTracker;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.b */
/* compiled from: GlobalLocationStrategy */
class C15135b implements C15136c {

    /* renamed from: a */
    private static final String f45923a = "GlobalLocationStrategy";

    /* renamed from: b */
    private final Context f45924b;

    /* renamed from: c */
    private OSNLPManager f45925c;

    /* renamed from: d */
    private IFLPLocator f45926d;

    /* renamed from: e */
    private WifiManagerWrapper f45927e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LocationUpdateInternalListener f45928f;

    /* renamed from: g */
    private volatile boolean f45929g = false;

    /* renamed from: h */
    private GpsManagerWrapper f45930h;

    /* renamed from: i */
    private GoogleFusionFilter f45931i;

    /* renamed from: j */
    private AccTimeFilter f45932j;

    /* renamed from: a */
    public void mo114555a(long j) {
    }

    /* renamed from: a */
    public void mo114559a(StringBuilder sb) {
    }

    /* renamed from: b */
    public void mo114560b(long j) {
    }

    public C15135b(Context context) {
        this.f45924b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo114558a(String str) {
        m32967d();
        OSNLPManager instance = OSNLPManager.getInstance();
        this.f45925c = instance;
        instance.mo114515a(this.f45924b);
        this.f45925c.mo114514a();
        m32965b();
        GpsManager.getInstance().init(this.f45924b);
        if (ApolloProxy.getInstance().isAlwaysScanWifiAllowed()) {
            WifiManagerWrapper instance2 = WifiManagerWrapper.getInstance();
            this.f45927e = instance2;
            instance2.init(this.f45924b);
        }
        CellManager.getInstance().init(this.f45924b);
        CellManager.getInstance().getCellLocation();
        this.f45929g = true;
    }

    /* renamed from: a */
    public void mo114554a() {
        IFLPLocator iFLPLocator = this.f45926d;
        if (iFLPLocator != null) {
            iFLPLocator.destroy();
        }
        OSNLPManager oSNLPManager = this.f45925c;
        if (oSNLPManager != null) {
            oSNLPManager.mo114516b();
            this.f45925c = null;
        }
        WifiManagerWrapper wifiManagerWrapper = this.f45927e;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.destroy();
            this.f45927e = null;
        }
        CellManager.getInstance().destroy();
        GoogleFusionFilter googleFusionFilter = this.f45931i;
        if (googleFusionFilter != null) {
            googleFusionFilter.destroy();
            this.f45931i = null;
        }
        AccTimeFilter accTimeFilter = this.f45932j;
        if (accTimeFilter != null) {
            accTimeFilter.destroy();
            this.f45932j = null;
        }
        m32966c();
        this.f45928f = null;
        this.f45929g = false;
    }

    /* renamed from: b */
    private void m32965b() {
        GpsManagerWrapper instance = GpsManagerWrapper.getInstance();
        this.f45930h = instance;
        instance.init(this.f45924b);
        this.f45930h.requestLocationUpdates(this.f45928f);
    }

    /* renamed from: c */
    private void m32966c() {
        GpsManagerWrapper gpsManagerWrapper = this.f45930h;
        if (gpsManagerWrapper != null) {
            gpsManagerWrapper.removeLocationUpdates(this.f45928f);
            this.f45930h = null;
        }
    }

    /* renamed from: a */
    public void mo114556a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback) {
        m32963a(retrieveLocationCallback, 0);
    }

    /* renamed from: a */
    private void m32963a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback, long j) {
        IFLPLocator iFLPLocator = this.f45926d;
        DIDILocation dIDILocation = null;
        DIDILocation fLPLocation = iFLPLocator != null ? iFLPLocator.getFLPLocation() : null;
        OSNLPManager oSNLPManager = this.f45925c;
        OSLocationWrapper originNLPLocation = oSNLPManager != null ? oSNLPManager.getOriginNLPLocation() : null;
        GpsManagerWrapper gpsManagerWrapper = this.f45930h;
        DIDILocation gpsLocation = gpsManagerWrapper != null ? gpsManagerWrapper.getGpsLocation() : null;
        GpsManagerWrapper gpsManagerWrapper2 = this.f45930h;
        DIDILocation lastGpsLocation = gpsManagerWrapper2 != null ? gpsManagerWrapper2.getLastGpsLocation() : null;
        if (AccTimeFilterHelper.getInstance().shouldUseThisFilter()) {
            if (this.f45932j == null) {
                this.f45932j = new AccTimeFilter(this.f45924b);
            }
            dIDILocation = this.f45932j.getTargetLocation(fLPLocation, originNLPLocation, gpsLocation, lastGpsLocation);
        } else if (ETraceSource.googleflp == FLPDiffInfoGetter.getInstance().getInfoSource()) {
            if (this.f45931i == null) {
                this.f45931i = new GoogleFusionFilter();
            }
            dIDILocation = this.f45931i.getTargetLocation(fLPLocation, originNLPLocation, gpsLocation, lastGpsLocation);
        } else if (fLPLocation != null) {
            dIDILocation = fLPLocation;
        } else if (originNLPLocation != null) {
            dIDILocation = DIDILocation.loadFromSystemLoc(originNLPLocation, ETraceSource.nlp, Utils.getCoordinateType());
        } else if (gpsLocation != null) {
            dIDILocation = gpsLocation;
        } else if (lastGpsLocation != null) {
            dIDILocation = lastGpsLocation;
        }
        if (dIDILocation != null) {
            m32961a(dIDILocation, j);
            m32964a(retrieveLocationCallback, dIDILocation);
            return;
        }
        ErrInfo e = m32968e();
        m32962a(retrieveLocationCallback, e.getErrNo(), e);
    }

    /* renamed from: a */
    public void mo114557a(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45928f = locationUpdateInternalListener;
    }

    /* renamed from: d */
    private void m32967d() {
        try {
            IFLPLocator iFLPLocator = (IFLPLocator) ServiceLoader.load(IFLPLocator.class).get();
            this.f45926d = iFLPLocator;
            if (iFLPLocator == null) {
                DLog.m32737d("GlobalLocationStrategyflp locator init NULL!");
                return;
            }
            iFLPLocator.setLocationListener(new GlobalLocationStrategy$1(this));
            this.f45926d.init(this.f45924b, 1000);
        } catch (Throwable th) {
            if (LocExceptionTracker.getInstance().enable()) {
                LocExceptionTracker instance = LocExceptionTracker.getInstance();
                instance.trackInnerException(7, "Other_" + th.getClass().getCanonicalName());
            }
            DLog.m32737d("GlobalLocationStrategyinit flp exception: " + th.getMessage() + ", " + th.getClass() + th.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    private void m32964a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback, DIDILocation dIDILocation) {
        if (this.f45929g) {
            LocNTPHelper.adjustLocTimestampWhenDispatch(dIDILocation);
            retrieveLocationCallback.onLocationChanged(dIDILocation);
        }
    }

    /* renamed from: a */
    private void m32962a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback, int i, ErrInfo errInfo) {
        if (this.f45929g) {
            retrieveLocationCallback.onLocationError(i, errInfo);
        }
    }

    /* renamed from: e */
    private ErrInfo m32968e() {
        ErrInfo errInfo = new ErrInfo();
        if (!Utils.isLocationPermissionGranted(this.f45924b) || !SensorMonitor.getInstance(this.f45924b).isGpsEnabled()) {
            errInfo.setErrNo(101);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_LOCATION_PERMISSION);
        } else if (!NetUtils.isNetWorkConnected(this.f45924b)) {
            errInfo.setErrNo(301);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_NETWORK_CONNECTION);
        } else {
            errInfo.setErrNo(1000);
            errInfo.setErrMessage("其他原因引起的定位失败。");
        }
        return errInfo;
    }

    /* renamed from: a */
    private static void m32961a(DIDILocation dIDILocation, long j) {
        if (dIDILocation != null && dIDILocation.getExtra() != null) {
            dIDILocation.getExtra().putLong(DIDILocation.EXTRA_KEY_STRATEGY_FLAGS, j);
        }
    }
}
