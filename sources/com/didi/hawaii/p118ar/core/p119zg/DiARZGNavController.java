package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.p118ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCGPSData;
import com.didi.hawaii.p118ar.jni.DARCGeoPoint;
import com.didi.hawaii.p118ar.jni.DARCHTTPRequest;
import com.didi.hawaii.p118ar.jni.DARCMatrix4F;
import com.didi.hawaii.p118ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p118ar.jni.DARCNAVEDStatusChange;
import com.didi.hawaii.p118ar.jni.DARCNAVEvent;
import com.didi.hawaii.p118ar.jni.DARCPoint4F;
import com.didi.hawaii.p118ar.jni.DARCZGNavCreateData;
import com.didi.hawaii.p118ar.jni.DARCZGNavDistanceEvent;
import com.didi.hawaii.p118ar.jni.DARCZGNavEDDistanceChange;
import com.didi.hawaii.p118ar.jni.DARCZGNavEDGPSFusion;
import com.didi.hawaii.p118ar.jni.DARCZGNavEDGPSWeakChange;
import com.didi.hawaii.p118ar.jni.DARCZGNavEDStatusChange;
import com.didi.hawaii.p118ar.jni.DARCZGNavEvent;
import com.didi.hawaii.p118ar.jni.DARCZGNavStatus;
import com.didi.hawaii.p118ar.jni.DARCZGNavUpdateData;
import com.didi.hawaii.p118ar.jni.SwigARCallback;
import com.didi.hawaii.p118ar.utils.ARAPollo;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p118ar.utils.AROmega;
import com.didi.hawaii.p118ar.utils.LocationUtil;
import com.didi.hawaii.p118ar.utils.SensorUtil;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGNavController */
public class DiARZGNavController extends SwigARCallback implements LocationUtil.NotifyLocationListener, SensorUtil.SensorUtilListener {

    /* renamed from: e */
    private static final int f23115e = ARAPollo.getARNavVersion();

    /* renamed from: f */
    private static final boolean f23116f = ARAPollo.getZGUsePDR();

    /* renamed from: g */
    private static final int f23117g = ARAPollo.getDistanceArrived();

    /* renamed from: h */
    private static boolean f23118h = false;

    /* renamed from: i */
    private static final float f23119i = 45.0f;

    /* renamed from: j */
    private static final float f23120j = 0.1f;

    /* renamed from: k */
    private static final float f23121k = 1000.0f;

    /* renamed from: l */
    private static final int f23122l = 25;

    /* renamed from: m */
    private static final int f23123m = 6000;

    /* renamed from: n */
    private static final int f23124n = 30000;

    /* renamed from: o */
    private static final long f23125o = 30;

    /* renamed from: p */
    private static long f23126p = 0;

    /* renamed from: a */
    boolean f23127a = false;

    /* renamed from: b */
    int f23128b = -1;

    /* renamed from: c */
    boolean f23129c = false;

    /* renamed from: d */
    boolean f23130d = false;

    /* renamed from: q */
    private boolean f23131q = false;

    /* renamed from: r */
    private ZGGlobalUIManager f23132r = null;

    /* renamed from: s */
    private ZGGlobalMapManager f23133s = null;

    /* renamed from: t */
    private DARCMatrix4F f23134t = null;

    /* renamed from: u */
    private DiARZGEngineImpl f23135u = null;

    /* renamed from: v */
    private DARCGPSData f23136v = null;

    /* renamed from: w */
    private DARCZGNavUpdateData f23137w = null;

    /* renamed from: x */
    private DARCPoint4F f23138x = null;

    /* renamed from: y */
    private LatLng f23139y = null;

    /* renamed from: z */
    private boolean f23140z = false;

    public void LogHandler(String str) {
    }

    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDShowAlert dARCNAVEDShowAlert) {
    }

    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDStatusChange dARCNAVEDStatusChange) {
    }

    public void navigatorSendHTTPRequest(DARCHTTPRequest dARCHTTPRequest) {
    }

    public DiARZGNavController(Context context, ViewGroup viewGroup) throws CreateDiARNavViewException {
        DARCZGNavCreateData a = m16606a(viewGroup);
        if (a != null) {
            DiARZGEngineImpl diARZGEngineImpl = new DiARZGEngineImpl();
            this.f23135u = diARZGEngineImpl;
            diARZGEngineImpl.ARZGEngineCreate(a, context.getApplicationContext());
            this.f23135u.ARZGEngineSetCallbacks(this);
            DLog.m7384d("AR-ZG", "ARZGEngineCreate", new Object[0]);
        }
        this.f23137w = new DARCZGNavUpdateData();
        this.f23138x = new DARCPoint4F();
        ZGGlobalUIManager zGGlobalUIManager = new ZGGlobalUIManager(context, viewGroup, this.f23135u);
        this.f23132r = zGGlobalUIManager;
        ZGGlobalMapManager zGGlobalMapManager = new ZGGlobalMapManager(context, zGGlobalUIManager.getArcLayout(), !ArcLayout.disableclippath);
        this.f23133s = zGGlobalMapManager;
        LatLng latLng = this.f23139y;
        if (latLng != null) {
            zGGlobalMapManager.setDestLocation(new LatLng(latLng.latitude, this.f23139y.longitude));
        }
        this.f23134t = AREngineJNI.perspectiveFov((float) Math.toRadians(45.0d), this.f23132r.getWindowWidthDP(), this.f23132r.getWindowHeightDP(), 0.1f, f23121k);
    }

    /* renamed from: a */
    private DARCZGNavCreateData m16606a(ViewGroup viewGroup) throws CreateDiARNavViewException {
        try {
            if (ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption() == null) {
                return null;
            }
            DARCZGNavCreateData alloc = DARCZGNavCreateData.alloc();
            AREngineJNI.DARCZGNavCreateData_containerView_set(alloc, viewGroup);
            this.f23139y = new LatLng(ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getDestLocation().latitude, ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getDestLocation().longitude);
            DARCGeoPoint dARCGeoPoint = new DARCGeoPoint();
            dARCGeoPoint.setLat(this.f23139y.latitude);
            dARCGeoPoint.setLon(this.f23139y.longitude);
            alloc.setTrackSupport(false);
            alloc.setUsePDR(f23116f);
            alloc.setTargetPoint(dARCGeoPoint);
            alloc.setDistanceArrived(f23117g);
            return alloc;
        } catch (Exception e) {
            DLog.m7384d("buildZGNavCreateData", e.toString(), new Object[0]);
            throw new CreateDiARNavViewException();
        }
    }

    public void setUiManagerListener(ZGUIListener zGUIListener) {
        ZGGlobalUIManager zGGlobalUIManager = this.f23132r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.setListener(zGUIListener);
        }
    }

    public void checkInitialDistanceReachEnd() {
        int i;
        if (this.f23129c && (i = this.f23128b) >= 0 && !this.f23130d) {
            if (i > 25) {
                this.f23132r.onReachEnd(0);
            } else {
                this.f23132r.onReachEnd(6000);
            }
            this.f23130d = true;
            AROmega.zgMapARNavDirectArrive();
        }
    }

    public void onDriverArrived(String str) {
        ZGGlobalUIManager zGGlobalUIManager = this.f23132r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.onDriverArrived(str);
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_FusionGPSPosUpdate) {
            this.f23136v = dARCZGNavEDGPSFusion.getGpsFusitionData();
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_GPSWeakChanged) {
            this.f23132r.onGpsWeak(dARCZGNavEDGPSWeakChange.getIsWeak());
            if (dARCZGNavEDGPSWeakChange.getIsWeak()) {
                AROmega.zgMapARNavDirectGpsToast(LocationUtil.getCurLocation().latitude, LocationUtil.getCurLocation().longitude);
            }
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDStatusChange dARCZGNavEDStatusChange) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_StatusChanged) {
            if (dARCZGNavEDStatusChange.getStatusTo() == DARCZGNavStatus.DARCZGNavStatus_ReachEnd) {
                this.f23129c = true;
                checkInitialDistanceReachEnd();
            }
            if ((dARCZGNavEDStatusChange.getStatusFrom() == DARCZGNavStatus.DARCZGNavStatus_Init && dARCZGNavEDStatusChange.getStatusTo() == DARCZGNavStatus.DARCZGNavStatus_Running) || dARCZGNavEDStatusChange.getStatusTo() == DARCZGNavStatus.DARCZGNavStatus_LocEnd) {
                AROmega.zgMapARNavDirectLocate();
            }
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_DistanceEventChanged) {
            DARCZGNavDistanceEvent distanceStatusFrom = dARCZGNavEDDistanceChange.getDistanceStatusFrom();
            DARCZGNavDistanceEvent distanceStatusTo = dARCZGNavEDDistanceChange.getDistanceStatusTo();
            if (DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_Invalid == distanceStatusFrom && DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_InitialDistance == distanceStatusTo) {
                this.f23128b = dARCZGNavEDDistanceChange.getDistanceOfTarget();
                checkInitialDistanceReachEnd();
                AROmega.zgMapARNavDirectDistance((float) dARCZGNavEDDistanceChange.getDistanceOfTarget());
            } else if (DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_MoreThan200Meter == distanceStatusFrom && DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_LessThan200Meter == distanceStatusTo) {
                AROmega.zgMapARNavDirect200Distance();
            } else if (DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_LessThan200Meter == distanceStatusFrom && DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_LessThan100Meter == distanceStatusTo) {
                AROmega.zgMapARNavDirect100Distance();
            }
        }
    }

    public void onOrientationChanged(float f, float f2, float f3, float[] fArr) {
        boolean needShowBehindTips;
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onOrientationChanged(f3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f23126p >= f23125o) {
            f23126p = currentTimeMillis;
            if (this.f23135u != null && this.f23127a) {
                try {
                    this.f23137w.setProjection(this.f23134t);
                    this.f23138x.setX(fArr[0]);
                    this.f23138x.setY(fArr[1]);
                    this.f23138x.setZ(fArr[2]);
                    this.f23138x.setW(fArr[3]);
                    this.f23137w.setArOriginTimeStamp(0.0d);
                    this.f23137w.setRotationVector(this.f23138x);
                    this.f23137w.setGpsData(LocationUtil.getCurLocation2DARCGPSData());
                    this.f23135u.updateZG(this.f23137w);
                    if (!(this.f23132r == null || (needShowBehindTips = this.f23135u.needShowBehindTips()) == this.f23131q)) {
                        this.f23132r.onBehindTipsMsg(needShowBehindTips);
                        this.f23131q = needShowBehindTips;
                    }
                    if (!f23118h) {
                        f23118h = true;
                        AROmega.zgMapARNavDirectEn();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    DLog.m7384d("updateZG", e.toString(), new Object[0]);
                }
            }
        }
    }

    public void activeZGNav() {
        this.f23127a = true;
        DiARZGEngineImpl diARZGEngineImpl = this.f23135u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.activeZG();
        }
        ZGGlobalUIManager zGGlobalUIManager = this.f23132r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.showSafeTips(30000);
        }
    }

    /* renamed from: a */
    private void m16607a() {
        this.f23127a = false;
        DiARZGEngineImpl diARZGEngineImpl = this.f23135u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.inactiveZG();
        }
    }

    public void onStart() {
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onStart();
        }
    }

    public void onRestart() {
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onRestart();
        }
    }

    public void onStop() {
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onStop();
        }
    }

    public void onResume() {
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onResume();
        }
    }

    public void onPause() {
        m16607a();
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onPause();
        }
    }

    public void onDestroy() {
        ZGGlobalUIManager zGGlobalUIManager = this.f23132r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.release();
        }
        DiARZGEngineImpl diARZGEngineImpl = this.f23135u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.destroyEngineContext();
            DLog.m7384d("AR-ZG", "ARZGEngineDestroy", new Object[0]);
        }
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onDestroy();
        }
    }

    public void onLocationChanged(LocationUtil.GpscurLocation gpscurLocation) {
        DiARZGEngineImpl diARZGEngineImpl = this.f23135u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.updateZGGPS(LocationUtil.getCurLocation2DARCGPSData());
        }
        ZGGlobalMapManager zGGlobalMapManager = this.f23133s;
        if (zGGlobalMapManager != null) {
            DARCGPSData dARCGPSData = this.f23136v;
            if (dARCGPSData != null) {
                zGGlobalMapManager.onLocationChanged(LocationUtil.DARCGPSData2Location(dARCGPSData));
            } else {
                zGGlobalMapManager.onLocationChanged(gpscurLocation);
            }
        }
    }
}
