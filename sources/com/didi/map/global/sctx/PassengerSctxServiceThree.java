package com.didi.map.global.sctx;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.didi.common.map.MapVendor;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import com.didi.map.global.sctx.model.ErrorCodeCollect;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.OrderRouteEngineResPack;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.model.SctxDataCache;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.global.sctx.widget.TrafficLineDelegate;
import com.didi.map.google.config.Config;
import com.didi.map.google.manager.OmegaReportManager;
import com.didi.map.google.model.MockMovementInfo;
import com.didi.map.google.util.ApolloUtils;
import com.didi.map.google.util.BizUtil;
import com.didi.map.google.util.ConvertUtil;
import com.didi.map.google.util.DUtils;
import com.didi.map.google.util.EtaEdaChangeTracker;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.google.util.GoogleSyncTripOmegaUtil;
import com.didi.map.google.widget.ISctxViewDelegate;
import com.didi.map.google.widget.SctxViewImpl;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.CarIconsPreloader;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.nav.car.MyLocation;
import com.didi.map.sdk.nav.car.onCarAnimationCancelListener;
import com.didi.map.sdk.nav.car.onCarAnimationListener;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.InertiaEngine;
import com.didi.map.sdk.nav.inertia.OnLocationMatched;
import com.didi.map.sdk.nav.inertia.SctxInertiaSuspiciousStatus;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.nav.traffic.TrafficData;
import com.didi.map.sdk.nav.traffic.TrafficOptions;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.PickupPoint;
import com.didi.map.sdk.proto.driver_gl.SecRouteInfo;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import com.didi.map.utils.MatchPointDisHandler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassengerSctxServiceThree extends AbstractSctxServiceTwo {
    public static final int RecPPState_Cancel = 2;
    public static final int RecPPState_Use = 1;

    /* renamed from: r */
    private static final String f27514r = "PassengerSctxService";

    /* renamed from: s */
    private static final int f27515s = 1;

    /* renamed from: t */
    private static final int f27516t = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f27517A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IInertiaDelegate f27518B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IMyLocationDelegate f27519C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ArrayList<LatLng> f27520D;

    /* renamed from: E */
    private List<LatLng> f27521E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public RouteGuidanceGPSPoint f27522F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public MatchPointDisHandler f27523G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f27524H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f27525I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f27526J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f27527K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f27528L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f27529M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f27530N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f27531O;

    /* renamed from: P */
    private List<OdPoint> f27532P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public TrafficLineDelegate f27533Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public int f27534R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public LatLng f27535S;

    /* renamed from: T */
    private int f27536T;

    /* renamed from: U */
    private OrderRouteEngineResPack f27537U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public RouteGuidanceGPSPoint f27538V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public OmegaReportManager f27539W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public List<MockMovementInfo.SctxAnimData> f27540X = new ArrayList();

    /* renamed from: Y */
    private Handler f27541Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public LatLng f27542Z;

    /* renamed from: aa */
    private List<LatLng> f27543aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public List<LatLng> f27544ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public SctxDataCache f27545ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f27546ad = -2;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public Set<Integer> f27547ae;

    /* renamed from: af */
    private DIDILocationListener f27548af;

    /* renamed from: ag */
    private int f27549ag = -1;

    /* renamed from: ah */
    private BroadcastReceiver f27550ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public long f27551ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public TrafficLineDelegate f27552aj;

    /* renamed from: ak */
    private SecRouteInfo f27553ak;

    /* renamed from: al */
    private int f27554al = 0;

    /* renamed from: am */
    private OnLineClickListener f27555am;

    /* renamed from: an */
    private boolean f27556an = true;

    /* renamed from: ao */
    private boolean f27557ao = true;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public float f27558ap = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f27559aq;

    /* renamed from: ar */
    private boolean f27560ar = false;

    /* renamed from: as */
    private long f27561as = -1;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ISctxViewDelegate f27562u;

    /* renamed from: v */
    private long f27563v;

    /* renamed from: w */
    private EtaEdaChangeTracker f27564w;

    /* renamed from: x */
    private int f27565x;

    /* renamed from: y */
    private int f27566y;

    /* renamed from: z */
    private long f27567z;

    /* renamed from: M */
    private boolean m19612M() {
        return false;
    }

    /* renamed from: s */
    static /* synthetic */ int m19695s(PassengerSctxServiceThree passengerSctxServiceThree) {
        int i = passengerSctxServiceThree.f27517A;
        passengerSctxServiceThree.f27517A = i + 1;
        return i;
    }

    public PassengerSctxServiceThree(SctxTripParam sctxTripParam) {
        super(sctxTripParam);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        m19668f();
        m19681l();
        m19624a();
        m19672h();
        m19674i();
        m19677j();
        m19679k();
        m19595D();
        m19671g();
        m19591B();
        if (this.f27392e.getTripState() == 3) {
            m19649b();
            m19665e();
            m19604I();
        }
        m19630a(this.f27392e.getPickupPoint(), this.f27392e.getEndPoint());
    }

    /* renamed from: a */
    private void m19624a() {
        this.f27398k.setReportCallback(new RuntimeErrorCollect.ReportCallback() {
            public void reportError(String str) {
                PassengerSctxServiceThree.this.f27539W.reportSctxErrorCode(str);
            }
        });
    }

    /* renamed from: b */
    private void m19649b() {
        this.f27548af = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locationSwitchLevel = Utils.getLocationSwitchLevel(PassengerSctxServiceThree.this.f27389b);
                if (PassengerSctxServiceThree.this.f27546ad != locationSwitchLevel) {
                    if (PassengerSctxServiceThree.this.f27546ad != -2) {
                        PassengerSctxServiceThree.this.f27539W.trackPhoneLocationType(PassengerSctxServiceThree.this.f27546ad, locationSwitchLevel);
                    }
                    int unused = PassengerSctxServiceThree.this.f27546ad = locationSwitchLevel;
                }
                PassengerSctxServiceThree.this.m19662d();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (PassengerSctxServiceThree.this.f27547ae == null) {
                    Set unused = PassengerSctxServiceThree.this.f27547ae = new HashSet();
                }
                if (PassengerSctxServiceThree.this.f27547ae.size() == 0) {
                    long unused2 = PassengerSctxServiceThree.this.f27551ai = System.currentTimeMillis();
                }
                PassengerSctxServiceThree.this.f27547ae.add(Integer.valueOf(errInfo.getErrNo()));
            }
        };
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f27389b);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("PassengerSctx");
            defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this.f27548af);
            instance.requestLocationUpdates(this.f27548af, defaultLocationUpdateOption);
        }
    }

    /* renamed from: c */
    private void m19657c() {
        if (this.f27388a != null && this.f27555am == null) {
            this.f27555am = new OnLineClickListener() {
                public void onLineClick(Line line) {
                    if (PassengerSctxServiceThree.this.f27533Q != null && PassengerSctxServiceThree.this.f27552aj != null) {
                        List<Line> lines = PassengerSctxServiceThree.this.f27533Q.getLines();
                        List<Line> lines2 = PassengerSctxServiceThree.this.f27552aj.getLines();
                        if (!CollectionUtil.isEmpty((Collection<?>) lines) && !CollectionUtil.isEmpty((Collection<?>) lines2)) {
                            if (lines.contains(line)) {
                                PassengerSctxServiceThree.this.chooseLine(1);
                            } else if (lines2.contains(line)) {
                                PassengerSctxServiceThree.this.chooseLine(2);
                            }
                        }
                    }
                }
            };
            this.f27388a.addOnLineClickListener(this.f27555am);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19662d() {
        Set<Integer> set = this.f27547ae;
        if (set != null && !set.isEmpty()) {
            this.f27539W.trackLocationErrorInfos(this.f27551ai, this.f27547ae);
            this.f27547ae.clear();
            this.f27551ai = 0;
        }
    }

    /* renamed from: e */
    private void m19665e() {
        this.f27550ah = new BroadcastReceiver() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r6, android.content.Intent r7) {
                /*
                    r5 = this;
                    java.lang.String r6 = r7.getAction()
                    int r7 = r6.hashCode()
                    r0 = -2128145023(0xffffffff81271581, float:-3.0688484E-38)
                    r1 = 0
                    r2 = -1
                    r3 = 2
                    r4 = 1
                    if (r7 == r0) goto L_0x0030
                    r0 = -1454123155(0xffffffffa953d76d, float:-4.7038264E-14)
                    if (r7 == r0) goto L_0x0026
                    r0 = 823795052(0x311a1d6c, float:2.2426674E-9)
                    if (r7 == r0) goto L_0x001c
                    goto L_0x003a
                L_0x001c:
                    java.lang.String r7 = "android.intent.action.USER_PRESENT"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x003a
                    r6 = 2
                    goto L_0x003b
                L_0x0026:
                    java.lang.String r7 = "android.intent.action.SCREEN_ON"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x003a
                    r6 = 0
                    goto L_0x003b
                L_0x0030:
                    java.lang.String r7 = "android.intent.action.SCREEN_OFF"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x003a
                    r6 = 1
                    goto L_0x003b
                L_0x003a:
                    r6 = -1
                L_0x003b:
                    if (r6 == 0) goto L_0x0045
                    if (r6 == r4) goto L_0x0046
                    if (r6 == r3) goto L_0x0043
                    r1 = -1
                    goto L_0x0046
                L_0x0043:
                    r1 = 2
                    goto L_0x0046
                L_0x0045:
                    r1 = 1
                L_0x0046:
                    com.didi.map.global.sctx.PassengerSctxServiceThree r6 = com.didi.map.global.sctx.PassengerSctxServiceThree.this
                    com.didi.map.google.manager.OmegaReportManager r6 = r6.f27539W
                    r6.trackScreenState(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceThree.C98154.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            this.f27389b.registerReceiver(this.f27550ah, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m19668f() {
        this.f27545ac = new SctxDataCache();
        this.f27537U = new OrderRouteEngineResPack();
        this.f27564w = new EtaEdaChangeTracker(m19705x());
        this.f27520D = new ArrayList<>();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f27522F = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f27532P = new ArrayList();
        this.f27562u = new SctxViewImpl(this.f27389b, this.f27388a, this.f27519C, this.f27396i);
        if (m19706y()) {
            this.f27560ar = true;
        }
    }

    /* renamed from: g */
    private void m19671g() {
        this.f27523G = new MatchPointDisHandler();
    }

    /* renamed from: h */
    private void m19672h() {
        InertiaEngine create = InertiaEngine.create(this.f27389b);
        this.f27518B = create;
        create.setPredictionApolloParams(this.f27395h.getSctxPredictionParams());
        this.f27518B.setSimulateEvaluateCallback(this.f27539W.getSimulateCallback());
        this.f27518B.setOrderInfo(this.f27392e.getOrderId(), this.f27392e.getTripState() == 3 ? this.f27392e.isArrivedPickupPoint() ? 1 : 0 : 2);
        this.f27518B.setOnLocationMatched(new OnLocationMatched() {
            public void onOffRoute() {
            }

            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
                if (i >= 0 && !z) {
                    RouteGuidanceGPSPoint unused = PassengerSctxServiceThree.this.f27522F = ConvertUtil.tran2RouteGuidanceGPSPointWithLatLng(latLng, 0);
                    PassengerSctxServiceThree.this.f27522F.shapeOffSet = i2;
                    PassengerSctxServiceThree.this.f27522F.segmentIndex = i;
                }
                PassengerSctxServiceThree.this.f27391d.onMatched(latLng);
                DLog.m7384d(PassengerSctxServiceThree.f27514r, "onMatched - point:" + latLng.toString() + ", segmentIndex:" + i + ", distanceOffset:" + i3 + ", timeoffsett:" + i4 + ", isSimulate:" + z, new Object[0]);
                PassengerSctxServiceThree.this.m19683m();
                CarIconsPreloader.getInstance().preloadCarIcons(i);
                if (!z) {
                    PassengerSctxServiceThree.this.m19685n();
                    DLog.m7384d(PassengerSctxServiceThree.f27514r, "onMatched - 非惯导, mShowEta:" + PassengerSctxServiceThree.this.f27528L + " / mShowDistance:" + PassengerSctxServiceThree.this.f27530N + "显示的均为后台下发值", new Object[0]);
                } else {
                    PassengerSctxServiceThree passengerSctxServiceThree = PassengerSctxServiceThree.this;
                    int unused2 = passengerSctxServiceThree.f27527K = passengerSctxServiceThree.f27527K + i3;
                    PassengerSctxServiceThree passengerSctxServiceThree2 = PassengerSctxServiceThree.this;
                    long unused3 = passengerSctxServiceThree2.f27526J = passengerSctxServiceThree2.f27526J + ((long) i4);
                    DLog.m7384d(PassengerSctxServiceThree.f27514r, "onMatched - 惯导累积, mACCMockDistance:" + PassengerSctxServiceThree.this.f27527K + ", mACCMockTime:" + PassengerSctxServiceThree.this.f27526J, new Object[0]);
                    if (PassengerSctxServiceThree.this.f27528L <= 0 && PassengerSctxServiceThree.this.f27530N <= 0) {
                        PassengerSctxServiceThree passengerSctxServiceThree3 = PassengerSctxServiceThree.this;
                        int unused4 = passengerSctxServiceThree3.f27528L = passengerSctxServiceThree3.f27524H;
                        PassengerSctxServiceThree passengerSctxServiceThree4 = PassengerSctxServiceThree.this;
                        int unused5 = passengerSctxServiceThree4.f27529M = passengerSctxServiceThree4.f27524H * 60;
                        PassengerSctxServiceThree passengerSctxServiceThree5 = PassengerSctxServiceThree.this;
                        int unused6 = passengerSctxServiceThree5.f27530N = passengerSctxServiceThree5.f27525I;
                    }
                    PassengerSctxServiceThree passengerSctxServiceThree6 = PassengerSctxServiceThree.this;
                    int unused7 = passengerSctxServiceThree6.f27529M = passengerSctxServiceThree6.f27529M - i4;
                    PassengerSctxServiceThree passengerSctxServiceThree7 = PassengerSctxServiceThree.this;
                    int unused8 = passengerSctxServiceThree7.f27528L = passengerSctxServiceThree7.f27529M / 60;
                    PassengerSctxServiceThree passengerSctxServiceThree8 = PassengerSctxServiceThree.this;
                    int unused9 = passengerSctxServiceThree8.f27530N = passengerSctxServiceThree8.f27530N - i3;
                    DLog.m7384d(PassengerSctxServiceThree.f27514r, "onMatched - 惯导, mShowEta:" + PassengerSctxServiceThree.this.f27528L + "mShowEtaSeconds:" + PassengerSctxServiceThree.this.f27529M + " / mShowDistance:" + PassengerSctxServiceThree.this.f27530N + "显示的与后台下发值不一定一样: mEta:" + PassengerSctxServiceThree.this.f27524H + " / mDistance:" + PassengerSctxServiceThree.this.f27525I, new Object[0]);
                }
                if (PassengerSctxServiceThree.this.f27562u.getCarMarker() == null) {
                    PassengerSctxServiceThree passengerSctxServiceThree9 = PassengerSctxServiceThree.this;
                    passengerSctxServiceThree9.m19629a(latLng, passengerSctxServiceThree9.f27558ap == -1.0f ? 0.0f : PassengerSctxServiceThree.this.f27558ap);
                }
                if (!PassengerSctxServiceThree.this.m19643a(false)) {
                    if (i < 0) {
                        PassengerSctxServiceThree.m19695s(PassengerSctxServiceThree.this);
                        if (PassengerSctxServiceThree.this.f27517A < 3) {
                            DLog.m7384d(PassengerSctxServiceThree.f27514r, "[不满足惯导条件(sctx2.0效果)] 当前连续绑线失败次数:" + PassengerSctxServiceThree.this.f27517A + ",不足" + 3 + "次，不做动画", new Object[0]);
                            return;
                        }
                    } else {
                        int unused10 = PassengerSctxServiceThree.this.f27517A = 0;
                    }
                }
                PassengerSctxServiceThree.this.f27519C.animateTo(new AnimateNode(latLng, i, i2, true));
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (sctxStateInfo != null && sctxStateInfo.getState() != null && PassengerSctxServiceThree.this.m19643a(false)) {
                    DLog.m7384d(PassengerSctxServiceThree.f27514r, "onUpdateSctxState:" + sctxStateInfo.getState().type, new Object[0]);
                    PassengerSctxServiceThree.this.f27539W.onReceiveSctxState(PassengerSctxServiceThree.this.f27392e.getOrderId(), sctxStateInfo);
                    if (PassengerSctxServiceThree.this.f27391d != null) {
                        PassengerSctxServiceThree.this.f27391d.onSctxStateUpdate(sctxStateInfo);
                    }
                }
            }

            public void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
                if (!PassengerSctxServiceThree.this.f27397j.isEnable()) {
                    return;
                }
                if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR) {
                    PassengerSctxServiceThree.this.f27397j.recordJumpCode(SctxCaseCode.INERTIA_DRIVER_TOO_FAR);
                } else if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL) {
                    PassengerSctxServiceThree.this.f27397j.recordJumpCode(SctxCaseCode.INERTIA_MATCH_FAIL);
                }
            }
        });
    }

    /* renamed from: i */
    private void m19674i() {
        IMyLocationDelegate create = MyLocation.create(this.f27388a);
        this.f27519C = create;
        create.setIsPassenger(true);
        this.f27519C.setCarAnimationListener(new onCarAnimationListener() {
            public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                List unused = PassengerSctxServiceThree.this.f27544ab = list2;
                PassengerSctxServiceThree.this.m19639a(list, list2);
            }

            public void onErase(List<LatLng> list) {
                PassengerSctxServiceThree passengerSctxServiceThree = PassengerSctxServiceThree.this;
                passengerSctxServiceThree.m19639a(list, (List<LatLng>) passengerSctxServiceThree.f27544ab);
            }

            public void onErase(int i, int i2, LatLng latLng) {
                if (i != PassengerSctxServiceThree.this.f27534R || latLng == null || !latLng.equals(PassengerSctxServiceThree.this.f27535S)) {
                    if (PassengerSctxServiceThree.this.f27533Q != null && !PassengerSctxServiceThree.this.f27531O) {
                        PassengerSctxServiceThree.this.f27533Q.erase(i, latLng);
                        PassengerSctxServiceThree.this.m19626a(i, latLng);
                    }
                    int unused = PassengerSctxServiceThree.this.f27534R = i;
                    LatLng unused2 = PassengerSctxServiceThree.this.f27535S = latLng;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19626a(int i, LatLng latLng) {
        TrafficLineDelegate trafficLineDelegate;
        ArrayList<LatLng> arrayList = this.f27520D;
        List<LatLng> list = this.f27521E;
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27552aj != null) {
            int size = arrayList.size();
            int size2 = list.size();
            int i2 = this.f27534R;
            DLog.m7384d(f27514r, "sec points size :" + size2 + "cur points size: " + size + "lastEraseIndex: " + i2 + "segmentIndex: " + i, new Object[0]);
            if (i >= size2 && i2 < size2) {
                int i3 = i2;
                while (i2 < size2) {
                    if (i2 < arrayList.size()) {
                        if (DDSphericalUtil.computeDistanceBetween(arrayList.get(i2), list.get(i2)) <= 5.0d) {
                            i3 = i2;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
                m19627a(i3, list.get(i3), (List<LatLng>) arrayList, list);
            } else if (arrayList.size() > i && size2 > i) {
                int i4 = size2 - 1;
                if (i == i4) {
                    latLng = list.get(i4);
                }
                m19627a(i, latLng, (List<LatLng>) arrayList, list);
            }
            if (this.f27536T > size2 - 3 && (trafficLineDelegate = this.f27552aj) != null && trafficLineDelegate != null) {
                trafficLineDelegate.remove();
                this.f27552aj = null;
                if (this.f27391d != null) {
                    this.f27391d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m19627a(int i, LatLng latLng, List<LatLng> list, List<LatLng> list2) {
        if (DDSphericalUtil.computeDistanceBetween(list.get(i), list2.get(i)) > 5.0d) {
            DLog.m7384d(f27514r, "not eraseSecLine, distance > 5m", new Object[0]);
        } else if (list2.size() > i) {
            this.f27552aj.erase(i, latLng);
            this.f27536T = i;
            DLog.m7384d(f27514r, "eraseSecLine, mSecLastEraseIndex: " + this.f27536T, new Object[0]);
        } else {
            DLog.m7384d(f27514r, "not eraseSecLine, distance < 5m...", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19639a(List<LatLng> list, List<LatLng> list2) {
        if (this.f27545ac.enableDrawLine) {
            this.f27543aa = new ArrayList(list);
            if (list2 != null && list2.size() > 1) {
                this.f27543aa.addAll(list2.subList(1, list2.size()));
            }
        }
    }

    /* renamed from: j */
    private void m19677j() {
        ISctxViewDelegate iSctxViewDelegate = this.f27562u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.setLocationDelegate(this.f27519C);
            this.f27562u.set3DCarEnabled(this.f27392e.isIs3DEnabled());
            this.f27562u.set3DCarIcons(this.f27392e.getCar3DIcons());
            this.f27562u.setCarMarkerBitmap(this.f27392e.getCarBitmapDescriptor());
            this.f27562u.setCarMarkerZIndex(this.f27392e.getzIndex());
        }
    }

    /* renamed from: k */
    private void m19679k() {
        if (this.f27392e.getVamosExpansionParam() != null) {
            this.f27545ac.vamosDriverTripDestPoint = this.f27392e.getVamosExpansionParam().driverTripDestPoint;
        }
        this.f27545ac.orderPickupPoint = this.f27392e.getPickupPoint();
        this.f27545ac.orderDestPoint = this.f27392e.getEndPoint();
        this.f27563v = checkInterval(this.f27392e.getOraRequestInterval());
        m19687o();
        if (this.f27392e.isArrivedPickupPoint()) {
            m19634a(this.f27533Q);
            this.f27545ac.enableDrawLine = false;
        }
        if (this.f27392e.getWayPoints() != null) {
            setWayPoints(this.f27392e.getWayPoints(), this.f27392e.getWayPointsTimestamp());
        }
    }

    /* renamed from: l */
    private void m19681l() {
        this.f27539W = new OmegaReportManager(new OmegaReportManager.SctxReportGetter() {
            public String getUid() {
                return PassengerSctxServiceThree.this.m19700v();
            }

            public String getOrderId() {
                return PassengerSctxServiceThree.this.f27392e.getOrderId();
            }

            public int getOrderState() {
                return PassengerSctxServiceThree.this.f27392e.getTripState();
            }

            public int getProductId() {
                return PassengerSctxServiceThree.this.f27392e.getBizType();
            }

            public String getRole() {
                return PassengerSctxServiceThree.this.m19703w();
            }

            public String getPageReferrer() {
                return PassengerSctxServiceThree.this.m19705x();
            }

            public RouteGuidanceGPSPoint getOriginDriverPoint() {
                return PassengerSctxServiceThree.this.f27538V;
            }

            public int getDriverMatchEda() {
                int i;
                int i2;
                RouteGuidanceGPSPoint g = PassengerSctxServiceThree.this.f27522F;
                int i3 = -1;
                if (g == null) {
                    return -1;
                }
                int distanceToTail = PassengerSctxServiceThree.this.f27523G != null ? PassengerSctxServiceThree.this.f27523G.distanceToTail(g) : -1;
                if (PassengerSctxServiceThree.this.f27518B != null) {
                    i2 = PassengerSctxServiceThree.this.f27518B.distanceLeft();
                    i = PassengerSctxServiceThree.this.f27518B.distanceLeft(g);
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (ApolloUtils.newEdaCalculator() && PassengerSctxServiceThree.this.f27523G != null) {
                    i3 = distanceToTail;
                } else if (PassengerSctxServiceThree.this.f27518B != null) {
                    i3 = i2;
                }
                DLog.m7384d("eda_log", "DriverMatchEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|CurDriverEda:" + i3 + "|OldEda:" + i2 + "|oldEdaParam:" + i + "|NewEda:" + distanceToTail + "|segmentIndex:" + g.segmentIndex, new Object[0]);
                return i3;
            }

            public int getCarAnimEda() {
                return BizUtil.animDistanceLeft(PassengerSctxServiceThree.this.f27519C, PassengerSctxServiceThree.this.f27518B);
            }

            public List<MockMovementInfo.SctxAnimData> getSctxAnimDataList() {
                ArrayList arrayList = new ArrayList(PassengerSctxServiceThree.this.f27540X);
                PassengerSctxServiceThree.this.f27540X.clear();
                return arrayList;
            }

            public boolean isSplitAccounts() {
                return PassengerSctxServiceThree.this.f27392e.isReadOnly();
            }

            public CarMarker getDriverMarker() {
                return PassengerSctxServiceThree.this.getCarMarker();
            }

            public boolean isArrived() {
                return PassengerSctxServiceThree.this.f27392e.isArrivedPickupPoint();
            }

            public boolean isSimulateEtaEdaLimit(boolean z) {
                return PassengerSctxServiceThree.this.m19655b(z);
            }

            public List<LatLng> getSctxRoutePoints() {
                return PassengerSctxServiceThree.this.f27520D;
            }

            public double getMaxMockDistance() {
                return (double) PassengerSctxServiceThree.this.f27395h.getMaxMockDistance(PassengerSctxServiceThree.this.f27518B.getMatchPointType());
            }

            public long getMaxMockTime() {
                return PassengerSctxServiceThree.this.f27395h.getMaxMockTime(PassengerSctxServiceThree.this.f27518B.getMatchPointType());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m19683m() {
        if (m19706y()) {
            this.f27539W.doOmegaOnCarDelayed(this.f27392e.getBizType(), m19703w(), this.f27395h.getSctxPredictionEnable(), this.f27545ac.lastReceiveRouteTime, this.f27519C, this.f27518B);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m19685n() {
        DLog.m7384d(f27514r, "resetEtaEda", new Object[0]);
        this.f27527K = 0;
        this.f27526J = 0;
        int i = this.f27524H;
        this.f27528L = i;
        this.f27529M = i * 60;
        this.f27530N = this.f27525I;
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f27562u.setCarMarkerBitmap(bitmapDescriptor);
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        return this.f27562u.refresh3DCarIcons(z, list);
    }

    public void setOraRequestInterval(long j) {
        long checkInterval = checkInterval(j);
        long j2 = this.f27563v;
        if (checkInterval != j2) {
            DLog.m7384d(f27514r, "setOraRequestInterval :%s -> %s", Long.valueOf(j2), Long.valueOf(checkInterval));
            this.f27563v = checkInterval;
            m19687o();
            refreshSyncInterval();
        }
    }

    /* renamed from: o */
    private void m19687o() {
        IInertiaDelegate iInertiaDelegate = this.f27518B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.setRequestIntervalInMills((int) this.f27563v);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27519C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setAnimationInterval((int) this.f27563v);
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return this.f27563v;
    }

    /* renamed from: a */
    private void m19637a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m7384d(f27514r, "setOrderRouteResponse...", new Object[0]);
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
        this.f27558ap = mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue();
        if (!this.f27400m) {
            m19638a(mapPassengeOrderRouteRes, latLngListFromDiffGeoPoints);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (m19706y()) {
            long j = this.f27561as;
            if (j > 0 && currentTimeMillis - j >= 60000) {
                this.f27560ar = true;
                this.f27561as = currentTimeMillis;
                DLog.m7384d(f27514r, "mNeedTraffic: true", new Object[0]);
                return;
            }
        }
        if (this.f27561as == -1) {
            this.f27561as = currentTimeMillis;
        }
        this.f27560ar = false;
    }

    /* renamed from: a */
    private void m19638a(final MapPassengeOrderRouteRes mapPassengeOrderRouteRes, final List<LatLng> list) {
        if (this.f27545ac.isExtendedAnimating) {
            DLog.m7384d(f27514r, "bIsExtendedAnimating, return", new Object[0]);
        } else if (!m19689p() || !this.f27545ac.isFirstRecvRoutes) {
            m19654b(mapPassengeOrderRouteRes, list);
        } else {
            this.f27545ac.isFirstRecvRoutes = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                m19654b(mapPassengeOrderRouteRes, list);
                return;
            }
            if (this.f27520D.isEmpty()) {
                this.f27520D.addAll(list);
            }
            TrafficLineAnimatorOptions trafficLineAnimatorOptions = new TrafficLineAnimatorOptions();
            trafficLineAnimatorOptions.duration = getRouteExtensionAnimationDuration();
            trafficLineAnimatorOptions.animatorListener = new TrafficLineAnimatorOptions.TrafficLineAnimatorListener() {
                public void onStart() {
                    PassengerSctxServiceThree.this.f27545ac.isExtendedAnimating = true;
                    if (PassengerSctxServiceThree.this.f27391d != null) {
                        PassengerSctxServiceThree.this.f27391d.onRouteAnimationStart();
                    }
                }

                public void onEnd() {
                    PassengerSctxServiceThree.this.f27545ac.isExtendedAnimating = false;
                    if (PassengerSctxServiceThree.this.f27391d != null) {
                        PassengerSctxServiceThree.this.f27391d.onRouteAnimationEnd();
                    }
                    if (!PassengerSctxServiceThree.this.m19654b(mapPassengeOrderRouteRes, (List<LatLng>) list)) {
                        PassengerSctxServiceThree.this.m19629a((LatLng) list.get(0), list.size() > 1 ? (float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1)) : mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue());
                    }
                }
            };
            m19634a(this.f27533Q);
            this.f27533Q = new TrafficLineDelegate();
            m19636a(this.f27533Q, list, mapPassengeOrderRouteRes.traffic, trafficLineAnimatorOptions, false, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19629a(LatLng latLng, float f) {
        ISctxViewDelegate iSctxViewDelegate;
        if (latLng != null && (iSctxViewDelegate = this.f27562u) != null) {
            iSctxViewDelegate.updateCarMarker(latLng);
            this.f27562u.updateCarDirection(f);
        }
    }

    /* renamed from: b */
    private void m19651b(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        this.f27537U.parseFrom(mapPassengeOrderRouteRes);
        boolean z = true;
        this.f27531O = !this.f27537U.lineVisible;
        SctxDataCache sctxDataCache = this.f27545ac;
        if (!this.f27537U.lineVisible || this.f27392e.isArrivedPickupPoint()) {
            z = false;
        }
        sctxDataCache.enableDrawLine = z;
    }

    /* renamed from: p */
    private boolean m19689p() {
        return this.f27545ac.enableDrawLine && this.f27392e.isShowExtendedAnimation() && m19706y();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19654b(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list) {
        int i;
        int i2;
        final MapPassengeOrderRouteRes mapPassengeOrderRouteRes2 = mapPassengeOrderRouteRes;
        final List<LatLng> list2 = list;
        this.f27545ac.isRouteChanged = false;
        if (mapPassengeOrderRouteRes2.logId == null) {
            DLog.m7384d(f27514r, "res.logId == null", new Object[0]);
        } else if (this.f27567z > mapPassengeOrderRouteRes2.logId.longValue()) {
            DLog.m7384d(f27514r, "mResLogId:%d > res.logId:%d, return", Long.valueOf(this.f27567z), mapPassengeOrderRouteRes2.logId);
            return false;
        } else {
            this.f27567z = mapPassengeOrderRouteRes2.logId.longValue();
        }
        if (this.f27391d != null) {
            if (this.f27392e.isReadOnly() && !CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f27391d.onStartDestinationUpdate(list2.get(0), list2.get(list.size() - 1));
            }
            if (mapPassengeOrderRouteRes2.ret != null) {
                if (mapPassengeOrderRouteRes2.ret.intValue() == 33333) {
                    this.f27391d.onWayPointsStateUpdate(true, (List<OdPoint>) null);
                } else if (mapPassengeOrderRouteRes2.ret.intValue() == 0) {
                    this.f27391d.onWayPointsStateUpdate(false, this.f27532P);
                    this.f27391d.onWayPointsStateUpdateForMiniBus(CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes2.odPoints) ? new ArrayList() : mapPassengeOrderRouteRes2.odPoints);
                }
            }
        }
        if (mapPassengeOrderRouteRes2.eta != null && mapPassengeOrderRouteRes2.eta.intValue() >= 0) {
            this.f27524H = mapPassengeOrderRouteRes2.eta.intValue();
            DLog.m7384d(f27514r, "res.eta:" + mapPassengeOrderRouteRes2.eta, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.distance != null && mapPassengeOrderRouteRes2.distance.intValue() >= 0) {
            this.f27525I = mapPassengeOrderRouteRes2.distance.intValue();
            DLog.m7384d(f27514r, "res.distance:" + mapPassengeOrderRouteRes2.distance, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue())) {
            DLog.m7384d(f27514r, "res.driverPoint is error", new Object[0]);
            this.f27396i.setDriverError(3);
            this.f27398k.setErrorCode(202);
            return false;
        }
        final LatLng latLng = new LatLng((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue());
        Object[] objArr = new Object[2];
        objArr[0] = GoogleSyncTripLogUtil.getLatLngLogInfo(latLng);
        if (mapPassengeOrderRouteRes2.direction == null) {
            i = 0;
        } else {
            i = mapPassengeOrderRouteRes2.direction.intValue();
        }
        objArr[1] = Integer.valueOf(i);
        DLog.m7384d(f27514r, "server返回的司机定位:%s，方向:%d", objArr);
        DoublePoint doublePoint = mapPassengeOrderRouteRes2.driverPoint;
        if (mapPassengeOrderRouteRes2.direction == null) {
            i2 = 0;
        } else {
            i2 = mapPassengeOrderRouteRes2.direction.intValue();
        }
        RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint = ConvertUtil.tran2RouteGuidanceGPSPoint(doublePoint, i2);
        this.f27538V = tran2RouteGuidanceGPSPoint;
        IInertiaDelegate iInertiaDelegate = this.f27518B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.onRecvDriverLocation(tran2RouteGuidanceGPSPoint);
        }
        float f = 0.0f;
        if (this.f27531O) {
            m19634a(this.f27533Q);
            if (this.f27562u.getCarMarker() == null) {
                m19629a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
            }
        }
        List<TrafficItem> list3 = this.f27545ac.trafficItems;
        List<TrafficItem> list4 = mapPassengeOrderRouteRes2.traffic;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(list.size());
            objArr2[1] = Long.valueOf(this.f27401n);
            objArr2[2] = Long.valueOf(mapPassengeOrderRouteRes2.routeId == null ? 0 : mapPassengeOrderRouteRes2.routeId.longValue());
            DLog.m7384d(f27514r, "server返回了路线，路线点集个数:%d，重新画线，routeId:[%d -> %d]", objArr2);
            if (hasLine() && mapPassengeOrderRouteRes2.routeId != null && mapPassengeOrderRouteRes2.routeId.longValue() == this.f27401n && list.size() == this.f27520D.size() && m19615a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex) == this.f27402o) {
                DLog.m7384d(f27514r, "后台返回了跟上次一样的routeId，但也返回了路线(按理不该返回)，这里就不再刷新路线", new Object[0]);
                if (!DUtils.isSameTraffics(list3, list4)) {
                    this.f27545ac.trafficItems = list4;
                    m19652b(list2, list4);
                    DLog.m7384d(f27514r, "routes not null, refresh traffic", new Object[0]);
                }
                m19691q();
            } else {
                this.f27561as = -1;
                this.f27545ac.isRouteChanged = true;
                this.f27545ac.trafficItems = mapPassengeOrderRouteRes2.traffic;
                this.f27519C.animateCancel(new onCarAnimationCancelListener() {
                    public void onCancel() {
                        float f;
                        int i = 0;
                        DLog.m7384d(PassengerSctxServiceThree.f27514r, "onCarAnimationCancelListener onCancel() callback", new Object[0]);
                        long j = 0;
                        if (mapPassengeOrderRouteRes2.routeId == null) {
                            PassengerSctxServiceThree.this.f27401n = 0;
                            PassengerSctxServiceThree.this.f27402o = 0;
                        } else {
                            if (PassengerSctxServiceThree.this.m19706y() && PassengerSctxServiceThree.this.f27401n > 0 && PassengerSctxServiceThree.this.getCarMarker() != null) {
                                float computeHeading = (float) DDSphericalUtil.computeHeading(PassengerSctxServiceThree.this.getCarMarker().getPosition(), (LatLng) list2.get(0));
                                if (!(PassengerSctxServiceThree.this.f27518B == null || PassengerSctxServiceThree.this.f27518B.getLastMatchGPSPoint() == null)) {
                                    j = PassengerSctxServiceThree.this.f27518B.getLastMatchGPSPoint().timestamp;
                                }
                                GoogleSyncTripOmegaUtil.map_pax_car_jump(PassengerSctxServiceThree.this.m19700v(), PassengerSctxServiceThree.this.f27392e.getOrderId(), PassengerSctxServiceThree.this.f27392e.getTripState(), PassengerSctxServiceThree.this.f27392e.isArrivedPickupPoint(), computeHeading, !PassengerSctxServiceThree.this.f27531O ? 1 : 0, PassengerSctxServiceThree.this.getCarMarker().getPosition(), j, (LatLng) list2.get(0), mapPassengeOrderRouteRes2.driverPoint.gpsTimestamp.longValue(), PassengerSctxServiceThree.this.f27392e.getBizType(), PassengerSctxServiceThree.this.m19703w(), PassengerSctxServiceThree.this.m19705x());
                            }
                            PassengerSctxServiceThree.this.f27401n = mapPassengeOrderRouteRes2.routeId.longValue();
                            PassengerSctxServiceThree passengerSctxServiceThree = PassengerSctxServiceThree.this;
                            passengerSctxServiceThree.f27402o = passengerSctxServiceThree.m19615a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex);
                        }
                        PassengerSctxServiceThree.this.m19652b((List<LatLng>) list2, mapPassengeOrderRouteRes2.traffic);
                        PassengerSctxServiceThree.this.f27545ac.lastReceiveRouteTime = System.currentTimeMillis();
                        CarIconsPreloader.getInstance().setRoutePoints(PassengerSctxServiceThree.this.f27388a.getContext(), list2);
                        RouteGuidanceGPSPoint unused = PassengerSctxServiceThree.this.f27522F = new RouteGuidanceGPSPoint();
                        PassengerSctxServiceThree.this.f27522F.segmentIndex = -1;
                        PassengerSctxServiceThree.this.f27519C.setNavRoutePoints(list2, false);
                        if (PassengerSctxServiceThree.this.f27518B != null) {
                            if (PassengerSctxServiceThree.this.f27402o > 0) {
                                PassengerSctxServiceThree.this.f27518B.setRoutePoints(list2, PassengerSctxServiceThree.this.f27402o, PassengerSctxServiceThree.this.m19643a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceThree.this.f27523G.setRoutePoints(list2, PassengerSctxServiceThree.this.f27402o);
                                }
                            } else {
                                PassengerSctxServiceThree.this.f27518B.setRoutePoints((List<LatLng>) list2, PassengerSctxServiceThree.this.m19643a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceThree.this.f27523G.setRoutePoints(list2);
                                }
                            }
                        }
                        PassengerSctxServiceThree.this.m19691q();
                        if (PassengerSctxServiceThree.this.f27562u.getCarMarker() != null) {
                            return;
                        }
                        if (!PassengerSctxServiceThree.this.f27392e.isArrivedPickupPoint()) {
                            PassengerSctxServiceThree passengerSctxServiceThree2 = PassengerSctxServiceThree.this;
                            LatLng latLng = (LatLng) list2.get(0);
                            if (list2.size() > 1) {
                                f = (float) DDSphericalUtil.computeHeading((LatLng) list2.get(0), (LatLng) list2.get(1));
                            } else {
                                if (mapPassengeOrderRouteRes2.direction != null) {
                                    i = mapPassengeOrderRouteRes2.direction.intValue();
                                }
                                f = (float) i;
                            }
                            passengerSctxServiceThree2.m19629a(latLng, f);
                            return;
                        }
                        DLog.m7384d(PassengerSctxServiceThree.f27514r, "司机已到达态下发新路线时，初始让小车显示在真实司机位置%s，非路线第一个点", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
                        PassengerSctxServiceThree.this.m19629a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
                    }
                });
            }
            if (!this.f27392e.isReadOnly()) {
                GoogleSyncTripOmegaUtil.com_map_PassengerGetRoute_sw_global(m19700v(), this.f27392e.getOrderId(), this.f27401n, this.f27392e.getTripState(), this.f27392e.isArrivedPickupPoint(), this.f27392e.getCountryId(), this.f27392e.getTripId(), this.f27399l, this.f27392e.getBizType(), m19703w(), m19705x());
            }
        } else {
            if (!CollectionUtil.isEmpty((Collection<?>) this.f27520D) && !CollectionUtil.isEmpty((Collection<?>) list4) && !DUtils.isSameTraffics(list4, list3)) {
                this.f27545ac.trafficItems = list4;
                DLog.m7384d(f27514r, "routes null, refresh traffic", new Object[0]);
            }
            m19691q();
            if (this.f27562u.getCarMarker() == null) {
                if (mapPassengeOrderRouteRes2.direction != null) {
                    f = (float) mapPassengeOrderRouteRes2.direction.intValue();
                }
                m19629a(latLng, f);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19615a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m19691q() {
        IInertiaDelegate iInertiaDelegate = this.f27518B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.getMatchPoint(m19693r());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19643a(boolean z) {
        if (!m19706y() || !TextUtils.isEmpty(this.f27392e.getTripId()) || this.f27392e.isReadOnly()) {
            if (z) {
                DLog.m7384d(f27514r, "[getMatchPoint result] 非接驾段 | 拼车 | 分账人 -> 不开启惯导", new Object[0]);
            }
            return false;
        }
        boolean simulateMotionEnable = this.f27395h.getSimulateMotionEnable();
        if (z) {
            DLog.m7384d(f27514r, "[getMatchPoint] 看是否满足惯导条件：", new Object[0]);
            DLog.m7384d(f27514r, "1.总Apollo开关是否打开：%s", Boolean.valueOf(simulateMotionEnable));
        }
        return simulateMotionEnable;
    }

    /* renamed from: r */
    private boolean m19693r() {
        boolean a = m19643a(true);
        if (!a) {
            return a;
        }
        int maxMockDistance = this.f27395h.getMaxMockDistance(this.f27518B.getMatchPointType());
        long maxMockTime = this.f27395h.getMaxMockTime(this.f27518B.getMatchPointType());
        boolean z = this.f27527K < maxMockDistance && this.f27526J < maxMockTime;
        DLog.m7384d(f27514r, "2.累积惯导距离：%d, 累积惯导时间：%d [距离上限：%d, 时间上限:%d]", Integer.valueOf(this.f27527K), Long.valueOf(this.f27526J), Integer.valueOf(maxMockDistance), Long.valueOf(maxMockTime));
        return z ? !m19655b(true) : z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19655b(boolean z) {
        int allowEDA = this.f27395h.getAllowEDA();
        int allowETA = (int) ((this.f27395h.getAllowETA() / 1000) / 60);
        if (this.f27528L > 0 || this.f27530N > 0) {
            if (z) {
                DLog.m7384d(f27514r, "3.mShowDistance：%d, mShowEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27530N), Integer.valueOf(this.f27528L), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
            }
            if (this.f27530N <= allowEDA || this.f27528L <= allowETA) {
                return true;
            }
            return false;
        }
        if (z) {
            DLog.m7384d(f27514r, "3.mDistance：%d, mEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27525I), Integer.valueOf(this.f27524H), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
        }
        if (this.f27525I <= allowEDA || this.f27524H <= allowETA) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19652b(List<LatLng> list, List<TrafficItem> list2) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            StringBuffer stringBuffer = new StringBuffer();
            for (LatLng next : list) {
                stringBuffer.append(next.longitude + "," + next.latitude + ";");
            }
            DLog.m7384d("ccc", "新路线: " + stringBuffer.toString(), new Object[0]);
        }
        this.f27520D.clear();
        this.f27520D.addAll(list);
        m19685n();
        if (!this.f27545ac.enableDrawLine) {
            return;
        }
        if (!this.f27545ac.isDestModified || DDSphericalUtil.computeDistanceBetween(list.get(list.size() - 1), this.f27392e.getEndPoint()) <= 500.0d) {
            DLog.m7384d(f27514r, "updateNewLine - rebuild TrafficLine", new Object[0]);
            if (this.f27391d != null && !this.f27557ao) {
                this.f27391d.goingOffCourse();
            }
            this.f27557ao = false;
            this.f27553ak = null;
            this.f27521E = null;
            if (m19612M()) {
                this.f27536T = 0;
                TrafficLineDelegate trafficLineDelegate = this.f27552aj;
                if (trafficLineDelegate != null) {
                    m19634a(trafficLineDelegate);
                    this.f27552aj = null;
                    if (this.f27391d != null) {
                        this.f27391d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                    }
                }
            }
            m19634a(this.f27533Q);
            TrafficLineDelegate trafficLineDelegate2 = new TrafficLineDelegate();
            this.f27533Q = trafficLineDelegate2;
            m19636a(trafficLineDelegate2, list, list2, (TrafficLineAnimatorOptions) null, false, false);
            m19635a(this.f27533Q, 1);
            DLog.m7384d(f27514r, "draw line", new Object[0]);
            if (this.f27553ak != null && this.f27521E != null) {
                m19634a(this.f27552aj);
                this.f27552aj = new TrafficLineDelegate();
                m19636a(this.f27552aj, this.f27521E, this.f27553ak.route.traffic, (TrafficLineAnimatorOptions) null, this.f27553ak.route.included.intValue() == 1, true);
                m19635a(this.f27552aj, 2);
                this.f27552aj.highLight(false);
                m19657c();
                if (this.f27391d != null) {
                    this.f27391d.showSecRouteInfoCallback(new SecRouteInfoEx(this.f27553ak), true);
                }
                DLog.m7384d(f27514r, "draw sec back line", new Object[0]);
                return;
            }
            return;
        }
        DLog.m7384d(f27514r, "updateNewLine - 修改了目的地，但是修改后的目的地与后台下发的路线终点距离相差大于%dm --> 不画线", 500);
    }

    /* renamed from: a */
    private void m19636a(TrafficLineDelegate trafficLineDelegate, List<LatLng> list, List<TrafficItem> list2, TrafficLineAnimatorOptions trafficLineAnimatorOptions, boolean z, boolean z2) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.setTrafficOptions(m19619a(list, list2, z, z2));
            trafficLineDelegate.addToMap(this.f27388a, trafficLineAnimatorOptions);
        }
    }

    /* renamed from: a */
    private TrafficOptions m19619a(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        if (!MapVendor.DIDI.equals(this.f27388a.getMapVendor()) || !z2 || (ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture())) {
            return m19648b(list, list2, z, z2);
        }
        return m19620a(list, z);
    }

    /* renamed from: a */
    private TrafficOptions m19620a(List<LatLng> list, boolean z) {
        TrafficOptions trafficOptions = new TrafficOptions();
        trafficOptions.lineWidth = (int) TypedValue.applyDimension(1, (float) (z ? 7 : 6), this.f27389b.getResources().getDisplayMetrics());
        trafficOptions.drawLineType = 2;
        trafficOptions.clickable = true;
        trafficOptions.lineTextureIndex = 1;
        trafficOptions.lineMinorTextureIndex = 2;
        trafficOptions.points = new ArrayList();
        if (list != null) {
            trafficOptions.points.addAll(list);
        }
        return trafficOptions;
    }

    /* renamed from: b */
    private TrafficOptions m19648b(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        int i;
        float f;
        TrafficOptions trafficOptions = new TrafficOptions();
        int lineWidth = this.f27392e.getLineWidth();
        if (lineWidth == 0) {
            int i2 = 6;
            if (z) {
                i2 = 7;
            }
            if (this.f27392e.isNewVersion()) {
                f = TypedValue.applyDimension(1, (float) i2, this.f27389b.getResources().getDisplayMetrics());
            } else {
                f = TypedValue.applyDimension(1, 5.0f, this.f27389b.getResources().getDisplayMetrics());
            }
            lineWidth = (int) f;
        }
        trafficOptions.lineWidth = lineWidth;
        trafficOptions.clickable = true;
        trafficOptions.trafficDatas = new ArrayList();
        int lineColor = this.f27392e.getLineColor();
        boolean z3 = false;
        if (list2 == null || list2.size() <= 0 || z2) {
            if (lineColor == 0) {
                if (this.f27392e.isNewVersion()) {
                    lineColor = SctxViewImpl.NEW_LINE_COLOR;
                } else {
                    lineColor = SctxViewImpl.LINE_COLOR;
                }
            }
            trafficOptions.lineColor = lineColor;
            trafficOptions.lineMinorColor = DUtils.crColorBlend(0.1f, trafficOptions.lineColor, SctxViewImpl.MASK_COLOR);
        } else {
            if (lineColor == 0) {
                if (this.f27392e.isNewVersion()) {
                    lineColor = SctxViewImpl.NEW_LINE_COLOR;
                } else {
                    lineColor = SctxViewImpl.LINE_COLOR_HAS_TRAFFIC;
                }
            }
            trafficOptions.lineColor = lineColor;
            trafficOptions.lineMinorColor = DUtils.crColorBlend(0.1f, trafficOptions.lineColor, SctxViewImpl.MASK_COLOR);
            for (TrafficItem next : list2) {
                if (!(next.startIndex == null || next.endIndex == null)) {
                    TrafficData trafficData = new TrafficData();
                    trafficData.fromIndex = next.startIndex.intValue();
                    trafficData.toIndex = next.endIndex.intValue();
                    if (next.status == null) {
                        i = trafficOptions.lineColor;
                    } else {
                        i = Color.parseColor(String.format("#%06X", new Object[]{Integer.valueOf(next.status.intValue() & 16777215)}));
                    }
                    trafficData.color = i;
                    trafficData.minorColor = DUtils.crColorBlend(0.1f, trafficData.color, SctxViewImpl.MASK_COLOR);
                    trafficOptions.trafficDatas.add(trafficData);
                }
            }
        }
        trafficOptions.points = new ArrayList();
        if (list != null) {
            trafficOptions.points.addAll(list);
        }
        if (MapVendor.DIDI.equals(this.f27388a.getMapVendor()) && ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture()) {
            z3 = true;
        }
        if (z3) {
            trafficOptions.useNewCompLine = true;
            trafficOptions.drawLineType = 2;
        } else {
            trafficOptions.useNewCompLine = ApolloUtils.useCompLineForSctx();
            trafficOptions.drawLineType = 1;
        }
        return trafficOptions;
    }

    public List<LatLng> getRoutePoints() {
        return this.f27520D;
    }

    public List<Line> getLines() {
        TrafficLineDelegate trafficLineDelegate = this.f27533Q;
        if (trafficLineDelegate == null) {
            return null;
        }
        return trafficLineDelegate.getLines();
    }

    public List<LatLng> getRemainingRoutePoints() {
        return this.f27543aa;
    }

    /* renamed from: s */
    private int m19694s() {
        if (!this.f27531O) {
            int i = m19706y() ? this.f27528L : this.f27524H;
            if (Math.abs(this.f27565x - i) >= 1) {
                m19625a(i, m19706y() ? this.f27530N : this.f27525I);
                this.f27565x = i;
            }
            return i;
        } else if (this.f27537U.mEta >= 0) {
            DLog.m7384d(f27514r, "bIsHideRoute, eta:" + this.f27537U.mEta, new Object[0]);
            return this.f27537U.mEta;
        } else {
            DLog.m7384d(f27514r, "bIsHideRoute, eta return %d", 1);
            return 1;
        }
    }

    /* renamed from: t */
    private int m19696t() {
        if (!this.f27531O) {
            int i = m19706y() ? this.f27530N : this.f27525I;
            if (Math.abs(this.f27566y - i) >= 100) {
                m19625a(m19706y() ? this.f27528L : this.f27524H, i);
                this.f27566y = i;
            }
            return i;
        } else if (this.f27537U.mDistance >= 0) {
            DLog.m7384d(f27514r, "bIsHideRoute, eda:" + this.f27537U.mDistance, new Object[0]);
            return this.f27537U.mDistance;
        } else {
            DLog.m7384d(f27514r, "bIsHideRoute, eda return %d", 100);
            return 100;
        }
    }

    /* renamed from: u */
    private LatLng m19698u() {
        DoublePoint location = DUtils.getLocation(this.f27389b);
        return location != null ? new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue()) : new LatLng(0.0d, 0.0d);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public String m19700v() {
        return this.f27393f != null ? this.f27393f.getUserId() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public String m19703w() {
        if (!TextUtils.isEmpty(this.f27545ac.userRole)) {
            return this.f27545ac.userRole;
        }
        if (this.f27393f != null) {
            this.f27545ac.userRole = this.f27393f.getUserRole();
        }
        return this.f27545ac.userRole;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public String m19705x() {
        if (this.f27393f != null) {
            return this.f27393f.getPageReferrer();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public boolean m19706y() {
        return this.f27392e.getTripState() == 3 && !this.f27392e.isArrivedPickupPoint();
    }

    /* renamed from: z */
    private boolean m19709z() {
        return this.f27392e.getTripState() == 3 && this.f27392e.isArrivedPickupPoint();
    }

    /* renamed from: A */
    private boolean m19589A() {
        return this.f27392e.getTripState() == 4;
    }

    public double getRemainingRouteDistance() {
        if (!this.f27392e.isArrivedPickupPoint() || getCarMarker() == null) {
            return 0.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(getCarMarker().getPosition(), this.f27392e.getPickupPoint());
    }

    public LatLng getDriverPoint() {
        IInertiaDelegate iInertiaDelegate = this.f27518B;
        if (iInertiaDelegate == null || iInertiaDelegate.getLastMatchGPSPoint() == null || this.f27518B.getLastMatchGPSPoint().segmentIndex == -1) {
            if (getCarMarker() != null) {
                return getCarMarker().getPosition();
            }
            return null;
        } else if (!this.f27395h.getSctxPredictionEnable() || this.f27518B.getLastMatchGPSPoint().originMatchPoint == null) {
            return ConvertUtil.convertFromGeoPoint(this.f27518B.getLastMatchGPSPoint().point);
        } else {
            return ConvertUtil.convertFromGeoPoint(this.f27518B.getLastMatchGPSPoint().originMatchPoint.point);
        }
    }

    public CarMarker getCarMarker() {
        ISctxViewDelegate iSctxViewDelegate = this.f27562u;
        if (iSctxViewDelegate == null) {
            return null;
        }
        return iSctxViewDelegate.getCarMarker();
    }

    public void updateDestination(LatLng latLng) {
        DLog.m7384d(f27514r, "updateDestination...", new Object[0]);
        m19630a(this.f27392e.getPickupPoint(), latLng);
        if (latLng != null) {
            this.f27545ac.orderDestPoint = latLng;
            if (this.f27392e.getTripState() == 4) {
                DLog.m7384d(f27514r, "updateDestination - 送驾段，removeLine", new Object[0]);
                this.f27545ac.isDestModified = true;
                m19634a(this.f27533Q);
            }
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        m19630a(latLng, this.f27392e.getEndPoint());
        if (latLng != null) {
            this.f27554al = 1;
            this.f27545ac.orderPickupPoint = latLng;
            this.f27401n = 0;
            if (this.f27392e.getTripState() == 3) {
                DLog.m7384d(f27514r, "updateDestination - 接驾段，removeLine", new Object[0]);
                m19610L();
                m19603H();
                m19597E();
                m19595D();
                runImmediately();
            }
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        DLog.m7384d(f27514r, "[途经点信息] setOdPoints:%s, odPointsTimestamp:%d", GoogleSyncTripLogUtil.getOdPointsLogInfo(list), Long.valueOf(j));
        this.f27545ac.lastGetWayPointTime = j;
        List<OdPoint> list2 = this.f27532P;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.f27532P.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        if (TextUtils.isEmpty(this.f27392e.getToken())) {
            return null;
        }
        PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
        if (this.f27545ac.orderPickupPoint != null) {
            builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27545ac.orderPickupPoint.latitude)).lng(Float.valueOf((float) this.f27545ac.orderPickupPoint.longitude)).build());
        }
        if (this.f27545ac.orderDestPoint != null) {
            builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27545ac.orderDestPoint.latitude)).lng(Float.valueOf((float) this.f27545ac.orderDestPoint.longitude)).build());
        }
        if (this.f27545ac.vamosDriverTripDestPoint != null) {
            builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27545ac.vamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.f27545ac.vamosDriverTripDestPoint.longitude)).build()).build());
        }
        String str = "google";
        if (!(this.f27388a == null || this.f27388a.getMapVendor() == null)) {
            String mapVendor = this.f27388a.getMapVendor().toString();
            if (!TextUtils.isEmpty(mapVendor) && mapVendor.equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
                str = "didi";
            }
        }
        String str2 = "0";
        PassengerOrderRouteReq.Builder curRouteId = builder.orderId(this.f27392e.getOrderId()).orderStage(Integer.valueOf(this.f27392e.getTripState())).bizType(Integer.valueOf(this.f27392e.getBizType())).travelMode(this.f27392e.getTravelMode()).isNeedTraj(false).version("5").token(this.f27392e.getToken()).phoneNum(TextUtils.isEmpty(this.f27390c) ? str2 : this.f27390c).driverId(Long.valueOf(this.f27392e.getDriverId())).curRouteId(Long.valueOf(this.f27401n));
        if (!TextUtils.isEmpty(this.f27392e.getImei())) {
            str2 = this.f27392e.getImei();
        }
        curRouteId.imei(str2).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f27392e.getClientVersion()).lastOrderId(this.f27392e.getLastOrderId()).noNeedGeo(false).productId(String.valueOf(this.f27392e.getBizType())).countryId(this.f27392e.getCountryId()).sdkmaptype(str).lang(LocaleCodeHolder.getInstance().getCurrentLang()).travelId(this.f27392e.getTripId()).recPPState(Integer.valueOf(this.f27554al)).psgPoint(DUtils.getLocation(this.f27389b)).pushBtMsg(false).bizGroup(Integer.valueOf(this.f27392e.getBizGroup())).needTraffic(Boolean.valueOf(this.f27560ar));
        if (this.f27392e.getTripState() == 4) {
            if (this.f27545ac.lastGetWayPointTime <= 0) {
                DLog.m7384d(f27514r, "mWayPointTimeStamp(%d) <= 0，不传给后台途经点", Long.valueOf(this.f27545ac.lastGetWayPointTime));
            } else {
                builder.odPoints(this.f27532P);
                builder.odPointsTimestamp(Long.valueOf(this.f27545ac.lastGetWayPointTime));
            }
        }
        builder.readOnly(Boolean.valueOf(this.f27392e.isReadOnly()));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
        OmegaReportManager omegaReportManager;
        DLog.m7384d(f27514r, "onSyncStart...", new Object[0]);
        if (this.f27391d != null) {
            this.f27391d.onSyncStart();
        }
        if (!this.f27392e.isReadOnly() && (omegaReportManager = this.f27539W) != null) {
            omegaReportManager.doOmegaReportByTimeInterval();
        }
    }

    /* renamed from: B */
    private void m19591B() {
        if (this.f27392e.getTripState() == 3) {
            this.f27539W.trackOrderLocationPermission(Utils.getLocationSwitchLevel(this.f27389b), m19606J());
        }
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m7384d(f27514r, "onOraResponse...", new Object[0]);
        if (!this.f27399l) {
            if (Config.DEBUG && mapPassengeOrderRouteRes.ret != null && mapPassengeOrderRouteRes.ret.intValue() == 10000) {
                this.f27391d.orderChanged();
            } else if (mapPassengeOrderRouteRes != null) {
                if (mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() != 30076 || this.f27391d == null) {
                    if (!(mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() == 0 || mapPassengeOrderRouteRes.logId == null)) {
                        this.f27539W.trackOrderRouteResultError(mapPassengeOrderRouteRes.ret.intValue(), mapPassengeOrderRouteRes.logId.longValue());
                    }
                    m19651b(mapPassengeOrderRouteRes);
                    if (m19640a(this.f27537U.serverStage) && this.f27391d != null) {
                        this.f27391d.onAbnormalOrderStageCallback(this.f27537U.serverStage);
                        this.f27398k.setErrorCode(203);
                    }
                    if (this.f27537U.serverStage == 5) {
                        this.f27396i.setDriverError(2);
                        this.f27398k.setErrorCode(203);
                        stop();
                        return;
                    }
                    if (!this.f27399l) {
                        this.f27559aq = true;
                    }
                    m19637a(mapPassengeOrderRouteRes);
                    if (this.f27391d != null) {
                        this.f27391d.onSyncSuccess(mapPassengeOrderRouteRes);
                        this.f27391d.onEtaEdaUpdate(new EtaEdaInfo(m19694s(), m19696t(), SXUtils.getLastOrderEda(this.f27392e.getLastOrderId(), mapPassengeOrderRouteRes)));
                        return;
                    }
                    return;
                }
                DLog.m7384d(f27514r, "error code:" + mapPassengeOrderRouteRes.ret, new Object[0]);
                this.f27391d.onAbnormalOrderStageCallback(4);
            }
        }
    }

    /* renamed from: C */
    private double m19592C() {
        LatLng driverPoint = getDriverPoint();
        List<LatLng> routePoints = getRoutePoints();
        return DDSphericalUtil.computeDistanceBetween(driverPoint, routePoints.get(routePoints.size() - 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m19640a(int r5) {
        /*
            r4 = this;
            com.didi.map.global.sctx.model.SctxTripParam r0 = r4.f27392e
            int r0 = r0.getTripState()
            r1 = 0
            if (r5 <= 0) goto L_0x0025
            if (r0 <= 0) goto L_0x0025
            r2 = 3
            r3 = 1
            if (r0 != r2) goto L_0x001f
            com.didi.map.global.sctx.model.SctxTripParam r0 = r4.f27392e
            boolean r0 = r0.isArrivedPickupPoint()
            if (r0 == 0) goto L_0x001b
            r0 = 2
            if (r5 <= r0) goto L_0x0025
            goto L_0x001d
        L_0x001b:
            if (r5 <= r3) goto L_0x0025
        L_0x001d:
            r1 = 1
            goto L_0x0025
        L_0x001f:
            r2 = 4
            if (r0 != r2) goto L_0x0025
            if (r5 <= r2) goto L_0x0025
            goto L_0x001d
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceThree.m19640a(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
        DLog.m7384d(f27514r, "onOraFail err:%s", str);
        if (this.f27391d != null) {
            this.f27391d.onSyncFail(new Exception(str));
        }
    }

    public void unRegisterSctxCallback(SctxService.SctxCallback sctxCallback) {
        if (sctxCallback == this.f27391d) {
            this.f27391d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPreStart() {
        if (this.f27545ac.isSctxParamUpdated) {
            this.f27545ac.isSctxParamUpdated = false;
            m19599F();
            DLog.m7384d(f27514r, "onPreStart, isSctxParamUpdated is true", new Object[0]);
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        DLog.m7384d(f27514r, "update...", new Object[0]);
        if (sctxTripParam == null || sctxTripParam.equals(this.f27392e)) {
            DLog.m7384d(f27514r, "update,mSctxTripParam is equals.", new Object[0]);
            return;
        }
        stop();
        this.f27545ac.orderId = this.f27392e.getOrderId();
        this.f27545ac.orderState = this.f27392e.getTripState();
        this.f27545ac.isWaitingState = this.f27392e.isArrivedPickupPoint();
        this.f27545ac.isSctxParamUpdated = true;
        initBaseParam(sctxTripParam);
        m19595D();
        if (this.f27392e.getTripState() == 3) {
            m19649b();
            m19665e();
        }
        m19630a(this.f27392e.getPickupPoint(), this.f27392e.getEndPoint());
        start();
    }

    /* renamed from: D */
    private void m19595D() {
        this.f27540X.clear();
        this.f27542Z = null;
        Handler handler = this.f27541Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        } else {
            this.f27541Y = new Handler(Looper.getMainLooper());
        }
        if (this.f27392e != null && !this.f27392e.isArrivedPickupPoint() && this.f27392e.getTripState() == 3) {
            m19628a(1000);
        }
        DLog.m7384d("ccc", "开始记录缓存数据", new Object[0]);
    }

    /* renamed from: E */
    private void m19597E() {
        this.f27540X.clear();
        this.f27542Z = null;
        Handler handler = this.f27541Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27541Y = null;
        }
        DLog.m7384d("ccc", "清除缓存数据", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19628a(long j) {
        this.f27541Y.postDelayed(new Runnable() {
            public void run() {
                if (PassengerSctxServiceThree.this.f27519C == null || PassengerSctxServiceThree.this.getCarMarker() == null) {
                    PassengerSctxServiceThree.this.m19628a(1000);
                    DLog.m7384d("ccc", "未初始化，不缓存轨迹点", new Object[0]);
                } else if (PassengerSctxServiceThree.this.f27403p == 0) {
                    PassengerSctxServiceThree.this.m19628a(1000);
                    DLog.m7384d("ccc", "未可用，不缓存轨迹点", new Object[0]);
                } else if (System.currentTimeMillis() - PassengerSctxServiceThree.this.f27403p < 5000) {
                    PassengerSctxServiceThree.this.m19628a(1000);
                    DLog.m7384d("ccc", "5s内不缓存轨迹数据", new Object[0]);
                } else {
                    if (!PassengerSctxServiceThree.this.f27399l) {
                        MockMovementInfo.SctxAnimData sctxAnimData = new MockMovementInfo.SctxAnimData();
                        if (TimeServiceManager.getInstance().isNTPAvailable()) {
                            sctxAnimData.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        } else {
                            sctxAnimData.ntpTimestamp = -1;
                        }
                        sctxAnimData.localTime = System.currentTimeMillis();
                        LatLng position = PassengerSctxServiceThree.this.getCarMarker().getPosition();
                        sctxAnimData.animLat = position.latitude;
                        sctxAnimData.animLng = position.longitude;
                        int animDistanceLeftCustomed = BizUtil.animDistanceLeftCustomed(PassengerSctxServiceThree.this.f27519C, PassengerSctxServiceThree.this.f27523G);
                        int animDistanceLeft = BizUtil.animDistanceLeft(PassengerSctxServiceThree.this.f27519C, PassengerSctxServiceThree.this.f27518B);
                        if (ApolloUtils.newEdaCalculator()) {
                            sctxAnimData.carAnimEda = animDistanceLeftCustomed;
                        } else {
                            sctxAnimData.carAnimEda = animDistanceLeft;
                        }
                        if (PassengerSctxServiceThree.this.f27542Z != null && PassengerSctxServiceThree.this.f27559aq) {
                            sctxAnimData.animDistance = DDSphericalUtil.computeDistanceBetween(position, PassengerSctxServiceThree.this.f27542Z);
                        }
                        if (PassengerSctxServiceThree.this.f27397j.isEnable()) {
                            sctxAnimData.jumpOverException = PassengerSctxServiceThree.this.f27397j.getCode();
                            PassengerSctxServiceThree.this.f27397j.clearJumpOverData();
                        }
                        PassengerSctxServiceThree.this.f27540X.add(sctxAnimData);
                        LatLng unused = PassengerSctxServiceThree.this.f27542Z = position;
                        DLog.m7384d("eda_log", "CarAnimEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|carAnimEda:" + sctxAnimData.carAnimEda + "|oldCarAnimEda:" + animDistanceLeft + "|newCarAnimEda:" + animDistanceLeftCustomed, new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("新增缓存数据 data.carAnimEda = ");
                        sb.append(sctxAnimData.carAnimEda);
                        sb.append(", data.animDistance=");
                        sb.append(sctxAnimData.animDistance);
                        DLog.m7384d("ccc", sb.toString(), new Object[0]);
                        if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                            String str = Config.DEBUG_TAG;
                            SystemUtils.log(3, str, "------ data.animDistance=" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.global.sctx.PassengerSctxServiceThree$10", 1873);
                        }
                    }
                    PassengerSctxServiceThree.this.m19628a(1000);
                }
            }
        }, j);
    }

    /* renamed from: F */
    private void m19599F() {
        m19674i();
        m19672h();
        m19677j();
        m19679k();
        m19601G();
        m19671g();
    }

    /* renamed from: G */
    private void m19601G() {
        this.f27401n = 0;
        this.f27527K = 0;
        this.f27526J = 0;
        this.f27517A = 0;
        this.f27567z = 0;
        this.f27565x = 0;
        this.f27566y = 0;
        this.f27545ac.clear();
        this.f27539W.clear();
        ArrayList<LatLng> arrayList = this.f27520D;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private void m19625a(int i, int i2) {
        this.f27564w.record(i, i2, m19643a(false), this.f27545ac.isRouteChanged, m19698u(), this.f27392e.isArrivedPickupPoint());
    }

    /* renamed from: H */
    private void m19603H() {
        this.f27564w.doOmega(this.f27392e.getOrderId(), this.f27392e.getTripState(), this.f27392e.isArrivedPickupPoint(), this.f27392e.getCountryId(), m19698u());
        if (!this.f27392e.isReadOnly()) {
            this.f27539W.doOmegaReportCarMoveInfo();
        }
    }

    /* renamed from: a */
    private void m19630a(LatLng latLng, LatLng latLng2) {
        if (this.f27392e != null && this.f27539W != null) {
            if (TextUtils.isEmpty(this.f27392e.getOrderId())) {
                this.f27539W.trackOrderRouteParamError(1);
            } else if (TextUtils.isEmpty(String.valueOf(this.f27392e.getBizType()))) {
                this.f27539W.trackOrderRouteParamError(4);
            } else if (!LatLngUtils.locateCorrect(latLng)) {
                this.f27539W.trackOrderRouteParamError(2);
            } else if (!LatLngUtils.locateCorrect(latLng2)) {
                this.f27539W.trackOrderRouteParamError(3);
            }
        }
    }

    /* renamed from: I */
    private void m19604I() {
        int J = m19606J();
        boolean z = this.f27392e.getTripState() == 3;
        int i = this.f27549ag;
        if (i != J && z) {
            this.f27539W.trackAppLocationPermission(i, J);
        }
        this.f27549ag = J;
    }

    /* renamed from: J */
    private int m19606J() {
        int locationPermissionLevel = Utils.getLocationPermissionLevel(this.f27389b);
        if (locationPermissionLevel <= 0) {
            return 2;
        }
        if (locationPermissionLevel > 3 || Build.VERSION.SDK_INT <= 28) {
            return 0;
        }
        return 1;
    }

    public void enter() {
        super.enter();
    }

    public void resume() {
        super.resume();
        m19595D();
        m19604I();
        this.f27559aq = true;
    }

    public void pause() {
        super.pause();
        m19597E();
        m19603H();
        this.f27559aq = false;
    }

    public void leave() {
        super.leave();
        if (ApolloUtils.getAlarmOmegaToggle()) {
            m19609K();
        }
        m19603H();
        this.f27554al = 2;
        runImmediately();
        SctxDataCache sctxDataCache = this.f27545ac;
        if (sctxDataCache != null && sctxDataCache.orderState == 3) {
            m19662d();
        }
        IInertiaDelegate iInertiaDelegate = this.f27518B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f27518B = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27519C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
            this.f27519C = null;
        }
        ISctxViewDelegate iSctxViewDelegate = this.f27562u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.destroy();
            this.f27562u = null;
        }
        m19610L();
        this.f27536T = 0;
        m19597E();
        if (this.f27550ah != null) {
            try {
                this.f27389b.unregisterReceiver(this.f27550ah);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f27550ah = null;
        }
        if (this.f27548af != null) {
            DIDILocationManager.getInstance(this.f27389b).removeLocationUpdates(this.f27548af);
            this.f27548af = null;
        }
        if (this.f27388a != null && this.f27555am != null) {
            this.f27388a.removeOnLineClickListener(this.f27555am);
            this.f27555am = null;
        }
    }

    /* renamed from: K */
    private void m19609K() {
        String str = "";
        String driverError = getCarMarker() == null ? this.f27396i.getDriverError() : str;
        if ((m19706y() || this.f27392e.getTripState() == 4) && !hasLine()) {
            str = this.f27396i.getRouteError();
        }
        if (!TextUtils.isEmpty(driverError) || !TextUtils.isEmpty(str)) {
            ErrorCodeCollect.trackSctxShowError(driverError, str, LoginOmegaUtil.OLD_USER);
        }
    }

    public boolean hasLine() {
        TrafficLineDelegate trafficLineDelegate = this.f27533Q;
        return trafficLineDelegate != null && !CollectionUtil.isEmpty((Collection<?>) trafficLineDelegate.getLines());
    }

    /* renamed from: a */
    private void m19634a(TrafficLineDelegate trafficLineDelegate) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.remove();
        }
    }

    /* renamed from: L */
    private void m19610L() {
        m19634a(this.f27552aj);
        m19634a(this.f27533Q);
        this.f27552aj = null;
        this.f27533Q = null;
        this.f27536T = 0;
    }

    public void cancelPickupPointRecommend() {
        TrafficLineDelegate trafficLineDelegate = this.f27533Q;
        if (trafficLineDelegate != null) {
            trafficLineDelegate.highLight(true);
        }
        this.f27554al = 2;
        m19634a(this.f27552aj);
        this.f27552aj = null;
        runImmediately();
    }

    public void chooseLine(int i) {
        DLog.m7384d(f27514r, "chooseLine: " + i, new Object[0]);
        TrafficLineDelegate trafficLineDelegate = this.f27533Q;
        if (trafficLineDelegate != null && this.f27552aj != null) {
            if (i == 1) {
                trafficLineDelegate.highLight(true);
                m19635a(this.f27533Q, 1);
                this.f27552aj.highLight(false);
                m19635a(this.f27552aj, 2);
                if (this.f27391d != null) {
                    this.f27391d.selectedPickupPoint(this.f27392e.getPickupPoint());
                }
            } else if (i == 2) {
                trafficLineDelegate.highLight(false);
                m19635a(this.f27533Q, 1);
                this.f27552aj.highLight(true);
                m19635a(this.f27552aj, 2);
                SecRouteInfo secRouteInfo = this.f27553ak;
                if (secRouteInfo != null && secRouteInfo.point != null) {
                    PickupPoint pickupPoint = this.f27553ak.point;
                    if (this.f27391d != null) {
                        this.f27391d.selectedPickupPoint(new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m19635a(TrafficLineDelegate trafficLineDelegate, int i) {
        if (trafficLineDelegate != null) {
            List<Line> lines = trafficLineDelegate.getLines();
            if (!CollectionUtil.isEmpty((Collection<?>) lines)) {
                for (Line zIndex : lines) {
                    zIndex.setZIndex(i);
                }
            }
        }
    }

    public void showRecommendPickupPoint(boolean z) {
        this.f27556an = z;
    }
}
