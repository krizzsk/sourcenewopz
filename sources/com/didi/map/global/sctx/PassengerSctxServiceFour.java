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
import com.didi.map.global.sctx.work.core.WorkManager;
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

public class PassengerSctxServiceFour extends AbstractSctxServiceTwo {
    public static final int RecPPState_Cancel = 2;
    public static final int RecPPState_Use = 1;

    /* renamed from: r */
    private static final String f27408r = "PassengerSctxService";

    /* renamed from: s */
    private static final int f27409s = 1;

    /* renamed from: t */
    private static final int f27410t = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f27411A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IInertiaDelegate f27412B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IMyLocationDelegate f27413C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ArrayList<LatLng> f27414D;

    /* renamed from: E */
    private List<LatLng> f27415E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public RouteGuidanceGPSPoint f27416F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public MatchPointDisHandler f27417G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f27418H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f27419I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f27420J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f27421K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f27422L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f27423M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f27424N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f27425O;

    /* renamed from: P */
    private List<OdPoint> f27426P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public TrafficLineDelegate f27427Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public int f27428R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public LatLng f27429S;

    /* renamed from: T */
    private int f27430T;

    /* renamed from: U */
    private OrderRouteEngineResPack f27431U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public RouteGuidanceGPSPoint f27432V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public OmegaReportManager f27433W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public List<MockMovementInfo.SctxAnimData> f27434X = new ArrayList();

    /* renamed from: Y */
    private Handler f27435Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public LatLng f27436Z;

    /* renamed from: aa */
    private List<LatLng> f27437aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public List<LatLng> f27438ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public SctxDataCache f27439ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f27440ad = -2;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public Set<Integer> f27441ae;

    /* renamed from: af */
    private DIDILocationListener f27442af;

    /* renamed from: ag */
    private int f27443ag = -1;

    /* renamed from: ah */
    private BroadcastReceiver f27444ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public long f27445ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public TrafficLineDelegate f27446aj;

    /* renamed from: ak */
    private SecRouteInfo f27447ak;

    /* renamed from: al */
    private int f27448al = 0;

    /* renamed from: am */
    private OnLineClickListener f27449am;

    /* renamed from: an */
    private boolean f27450an = true;

    /* renamed from: ao */
    private boolean f27451ao = true;

    /* renamed from: ap */
    private WorkManager f27452ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public float f27453aq = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f27454ar;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ISctxViewDelegate f27455u;

    /* renamed from: v */
    private long f27456v;

    /* renamed from: w */
    private EtaEdaChangeTracker f27457w;

    /* renamed from: x */
    private int f27458x;

    /* renamed from: y */
    private int f27459y;

    /* renamed from: z */
    private long f27460z;

    /* renamed from: M */
    private boolean m19368M() {
        return false;
    }

    /* renamed from: s */
    static /* synthetic */ int m19451s(PassengerSctxServiceFour passengerSctxServiceFour) {
        int i = passengerSctxServiceFour.f27411A;
        passengerSctxServiceFour.f27411A = i + 1;
        return i;
    }

    public PassengerSctxServiceFour(SctxTripParam sctxTripParam) {
        super(sctxTripParam);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        m19424f();
        m19437l();
        m19380a();
        m19428h();
        m19430i();
        m19433j();
        m19435k();
        m19351D();
        m19427g();
        m19347B();
        if (this.f27392e.getTripState() == 3) {
            m19405b();
            m19421e();
            m19360I();
        }
        m19386a(this.f27392e.getPickupPoint(), this.f27392e.getEndPoint());
    }

    /* renamed from: a */
    private void m19380a() {
        this.f27398k.setReportCallback(new RuntimeErrorCollect.ReportCallback() {
            public void reportError(String str) {
                PassengerSctxServiceFour.this.f27433W.reportSctxErrorCode(str);
            }
        });
    }

    /* renamed from: b */
    private void m19405b() {
        this.f27442af = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locationSwitchLevel = Utils.getLocationSwitchLevel(PassengerSctxServiceFour.this.f27389b);
                if (PassengerSctxServiceFour.this.f27440ad != locationSwitchLevel) {
                    if (PassengerSctxServiceFour.this.f27440ad != -2) {
                        PassengerSctxServiceFour.this.f27433W.trackPhoneLocationType(PassengerSctxServiceFour.this.f27440ad, locationSwitchLevel);
                    }
                    int unused = PassengerSctxServiceFour.this.f27440ad = locationSwitchLevel;
                }
                PassengerSctxServiceFour.this.m19417d();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (PassengerSctxServiceFour.this.f27441ae == null) {
                    Set unused = PassengerSctxServiceFour.this.f27441ae = new HashSet();
                }
                if (PassengerSctxServiceFour.this.f27441ae.size() == 0) {
                    long unused2 = PassengerSctxServiceFour.this.f27445ai = System.currentTimeMillis();
                }
                PassengerSctxServiceFour.this.f27441ae.add(Integer.valueOf(errInfo.getErrNo()));
            }
        };
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f27389b);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("PassengerSctx");
            defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this.f27442af);
            instance.requestLocationUpdates(this.f27442af, defaultLocationUpdateOption);
        }
    }

    /* renamed from: c */
    private void m19411c() {
        if (this.f27388a != null && this.f27449am == null) {
            this.f27449am = new OnLineClickListener() {
                public void onLineClick(Line line) {
                    if (PassengerSctxServiceFour.this.f27427Q != null && PassengerSctxServiceFour.this.f27446aj != null) {
                        List<Line> lines = PassengerSctxServiceFour.this.f27427Q.getLines();
                        List<Line> lines2 = PassengerSctxServiceFour.this.f27446aj.getLines();
                        if (!CollectionUtil.isEmpty((Collection<?>) lines) && !CollectionUtil.isEmpty((Collection<?>) lines2)) {
                            if (lines.contains(line)) {
                                PassengerSctxServiceFour.this.chooseLine(1);
                            } else if (lines2.contains(line)) {
                                PassengerSctxServiceFour.this.chooseLine(2);
                            }
                        }
                    }
                }
            };
            this.f27388a.addOnLineClickListener(this.f27449am);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19417d() {
        Set<Integer> set = this.f27441ae;
        if (set != null && !set.isEmpty()) {
            this.f27433W.trackLocationErrorInfos(this.f27445ai, this.f27441ae);
            this.f27441ae.clear();
            this.f27445ai = 0;
        }
    }

    /* renamed from: e */
    private void m19421e() {
        this.f27444ah = new BroadcastReceiver() {
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
                    com.didi.map.global.sctx.PassengerSctxServiceFour r6 = com.didi.map.global.sctx.PassengerSctxServiceFour.this
                    com.didi.map.google.manager.OmegaReportManager r6 = r6.f27433W
                    r6.trackScreenState(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceFour.C97954.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            this.f27389b.registerReceiver(this.f27444ah, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m19424f() {
        this.f27439ac = new SctxDataCache();
        this.f27431U = new OrderRouteEngineResPack();
        this.f27457w = new EtaEdaChangeTracker(m19461x());
        this.f27414D = new ArrayList<>();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f27416F = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f27426P = new ArrayList();
        this.f27455u = new SctxViewImpl(this.f27389b, this.f27388a, this.f27413C, this.f27396i);
    }

    /* renamed from: g */
    private void m19427g() {
        this.f27417G = new MatchPointDisHandler();
    }

    /* renamed from: h */
    private void m19428h() {
        InertiaEngine create = InertiaEngine.create(this.f27389b);
        this.f27412B = create;
        create.setPredictionApolloParams(this.f27395h.getSctxPredictionParams());
        this.f27412B.setSimulateEvaluateCallback(this.f27433W.getSimulateCallback());
        this.f27412B.setOrderInfo(this.f27392e.getOrderId(), this.f27392e.getTripState() == 3 ? this.f27392e.isArrivedPickupPoint() ? 1 : 0 : 2);
        this.f27412B.setOnLocationMatched(new OnLocationMatched() {
            public void onOffRoute() {
            }

            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
                if (i >= 0 && !z) {
                    RouteGuidanceGPSPoint unused = PassengerSctxServiceFour.this.f27416F = ConvertUtil.tran2RouteGuidanceGPSPointWithLatLng(latLng, 0);
                    PassengerSctxServiceFour.this.f27416F.shapeOffSet = i2;
                    PassengerSctxServiceFour.this.f27416F.segmentIndex = i;
                }
                PassengerSctxServiceFour.this.f27391d.onMatched(latLng);
                DLog.m7384d(PassengerSctxServiceFour.f27408r, "onMatched - point:" + latLng.toString() + ", segmentIndex:" + i + ", shapeOffset:" + i2 + ", distanceOffset:" + i3 + ", timeoffsett:" + i4 + ", isSimulate:" + z, new Object[0]);
                PassengerSctxServiceFour.this.m19439m();
                CarIconsPreloader.getInstance().preloadCarIcons(i);
                if (!z) {
                    PassengerSctxServiceFour.this.m19441n();
                    DLog.m7384d(PassengerSctxServiceFour.f27408r, "onMatched - 非惯导, mShowEta:" + PassengerSctxServiceFour.this.f27422L + " / mShowDistance:" + PassengerSctxServiceFour.this.f27424N + "显示的均为后台下发值", new Object[0]);
                } else {
                    PassengerSctxServiceFour passengerSctxServiceFour = PassengerSctxServiceFour.this;
                    int unused2 = passengerSctxServiceFour.f27421K = passengerSctxServiceFour.f27421K + i3;
                    PassengerSctxServiceFour passengerSctxServiceFour2 = PassengerSctxServiceFour.this;
                    long unused3 = passengerSctxServiceFour2.f27420J = passengerSctxServiceFour2.f27420J + ((long) i4);
                    DLog.m7384d(PassengerSctxServiceFour.f27408r, "onMatched - 惯导累积, mACCMockDistance:" + PassengerSctxServiceFour.this.f27421K + ", mACCMockTime:" + PassengerSctxServiceFour.this.f27420J, new Object[0]);
                    if (PassengerSctxServiceFour.this.f27422L <= 0 && PassengerSctxServiceFour.this.f27424N <= 0) {
                        PassengerSctxServiceFour passengerSctxServiceFour3 = PassengerSctxServiceFour.this;
                        int unused4 = passengerSctxServiceFour3.f27422L = passengerSctxServiceFour3.f27418H;
                        PassengerSctxServiceFour passengerSctxServiceFour4 = PassengerSctxServiceFour.this;
                        int unused5 = passengerSctxServiceFour4.f27423M = passengerSctxServiceFour4.f27418H * 60;
                        PassengerSctxServiceFour passengerSctxServiceFour5 = PassengerSctxServiceFour.this;
                        int unused6 = passengerSctxServiceFour5.f27424N = passengerSctxServiceFour5.f27419I;
                    }
                    PassengerSctxServiceFour passengerSctxServiceFour6 = PassengerSctxServiceFour.this;
                    int unused7 = passengerSctxServiceFour6.f27423M = passengerSctxServiceFour6.f27423M - i4;
                    PassengerSctxServiceFour passengerSctxServiceFour7 = PassengerSctxServiceFour.this;
                    int unused8 = passengerSctxServiceFour7.f27422L = passengerSctxServiceFour7.f27423M / 60;
                    PassengerSctxServiceFour passengerSctxServiceFour8 = PassengerSctxServiceFour.this;
                    int unused9 = passengerSctxServiceFour8.f27424N = passengerSctxServiceFour8.f27424N - i3;
                    DLog.m7384d(PassengerSctxServiceFour.f27408r, "onMatched - 惯导, mShowEta:" + PassengerSctxServiceFour.this.f27422L + "mShowEtaSeconds:" + PassengerSctxServiceFour.this.f27423M + " / mShowDistance:" + PassengerSctxServiceFour.this.f27424N + "显示的与后台下发值不一定一样: mEta:" + PassengerSctxServiceFour.this.f27418H + " / mDistance:" + PassengerSctxServiceFour.this.f27419I, new Object[0]);
                }
                if (PassengerSctxServiceFour.this.f27455u.getCarMarker() == null) {
                    PassengerSctxServiceFour passengerSctxServiceFour9 = PassengerSctxServiceFour.this;
                    passengerSctxServiceFour9.m19385a(latLng, passengerSctxServiceFour9.f27453aq == -1.0f ? 0.0f : PassengerSctxServiceFour.this.f27453aq);
                }
                if (!PassengerSctxServiceFour.this.m19399a(false)) {
                    if (i < 0) {
                        PassengerSctxServiceFour.m19451s(PassengerSctxServiceFour.this);
                        if (PassengerSctxServiceFour.this.f27411A < 3) {
                            DLog.m7384d(PassengerSctxServiceFour.f27408r, "[不满足惯导条件(sctx2.0效果)] 当前连续绑线失败次数:" + PassengerSctxServiceFour.this.f27411A + ",不足" + 3 + "次，不做动画", new Object[0]);
                            return;
                        }
                    } else {
                        int unused10 = PassengerSctxServiceFour.this.f27411A = 0;
                    }
                }
                PassengerSctxServiceFour.this.f27413C.animateTo(new AnimateNode(latLng, i, i2, true));
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (sctxStateInfo != null && sctxStateInfo.getState() != null && PassengerSctxServiceFour.this.m19399a(false)) {
                    DLog.m7384d(PassengerSctxServiceFour.f27408r, "onUpdateSctxState:" + sctxStateInfo.getState().type, new Object[0]);
                    PassengerSctxServiceFour.this.f27433W.onReceiveSctxState(PassengerSctxServiceFour.this.f27392e.getOrderId(), sctxStateInfo);
                    if (PassengerSctxServiceFour.this.f27391d != null) {
                        PassengerSctxServiceFour.this.f27391d.onSctxStateUpdate(sctxStateInfo);
                    }
                }
            }

            public void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
                if (!PassengerSctxServiceFour.this.f27397j.isEnable()) {
                    return;
                }
                if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR) {
                    PassengerSctxServiceFour.this.f27397j.recordJumpCode(SctxCaseCode.INERTIA_DRIVER_TOO_FAR);
                } else if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL) {
                    PassengerSctxServiceFour.this.f27397j.recordJumpCode(SctxCaseCode.INERTIA_MATCH_FAIL);
                }
            }
        });
    }

    /* renamed from: i */
    private void m19430i() {
        IMyLocationDelegate create = MyLocation.create(this.f27388a);
        this.f27413C = create;
        create.setIsPassenger(true);
        this.f27413C.setCarAnimationListener(new onCarAnimationListener() {
            public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                List unused = PassengerSctxServiceFour.this.f27438ab = list2;
                PassengerSctxServiceFour.this.m19395a(list, list2);
            }

            public void onErase(List<LatLng> list) {
                PassengerSctxServiceFour passengerSctxServiceFour = PassengerSctxServiceFour.this;
                passengerSctxServiceFour.m19395a(list, (List<LatLng>) passengerSctxServiceFour.f27438ab);
            }

            public void onErase(int i, int i2, LatLng latLng) {
                if (i != PassengerSctxServiceFour.this.f27428R || latLng == null || !latLng.equals(PassengerSctxServiceFour.this.f27429S)) {
                    if (PassengerSctxServiceFour.this.f27427Q != null && !PassengerSctxServiceFour.this.f27425O) {
                        PassengerSctxServiceFour.this.f27427Q.erase(i, latLng);
                        PassengerSctxServiceFour.this.m19382a(i, latLng);
                    }
                    int unused = PassengerSctxServiceFour.this.f27428R = i;
                    LatLng unused2 = PassengerSctxServiceFour.this.f27429S = latLng;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19382a(int i, LatLng latLng) {
        TrafficLineDelegate trafficLineDelegate;
        ArrayList<LatLng> arrayList = this.f27414D;
        List<LatLng> list = this.f27415E;
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27446aj != null) {
            int size = arrayList.size();
            int size2 = list.size();
            int i2 = this.f27428R;
            DLog.m7384d(f27408r, "sec points size :" + size2 + "cur points size: " + size + "lastEraseIndex: " + i2 + "segmentIndex: " + i, new Object[0]);
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
                m19383a(i3, list.get(i3), (List<LatLng>) arrayList, list);
            } else if (arrayList.size() > i && size2 > i) {
                int i4 = size2 - 1;
                if (i == i4) {
                    latLng = list.get(i4);
                }
                m19383a(i, latLng, (List<LatLng>) arrayList, list);
            }
            if (this.f27430T > size2 - 3 && (trafficLineDelegate = this.f27446aj) != null && trafficLineDelegate != null) {
                trafficLineDelegate.remove();
                this.f27446aj = null;
                if (this.f27391d != null) {
                    this.f27391d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m19383a(int i, LatLng latLng, List<LatLng> list, List<LatLng> list2) {
        if (DDSphericalUtil.computeDistanceBetween(list.get(i), list2.get(i)) > 5.0d) {
            DLog.m7384d(f27408r, "not eraseSecLine, distance > 5m", new Object[0]);
        } else if (list2.size() > i) {
            this.f27446aj.erase(i, latLng);
            this.f27430T = i;
            DLog.m7384d(f27408r, "eraseSecLine, mSecLastEraseIndex: " + this.f27430T, new Object[0]);
        } else {
            DLog.m7384d(f27408r, "not eraseSecLine, distance < 5m...", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19395a(List<LatLng> list, List<LatLng> list2) {
        if (this.f27439ac.enableDrawLine) {
            this.f27437aa = new ArrayList(list);
            if (list2 != null && list2.size() > 1) {
                this.f27437aa.addAll(list2.subList(1, list2.size()));
            }
        }
    }

    /* renamed from: j */
    private void m19433j() {
        ISctxViewDelegate iSctxViewDelegate = this.f27455u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.setLocationDelegate(this.f27413C);
            this.f27455u.set3DCarEnabled(this.f27392e.isIs3DEnabled());
            this.f27455u.set3DCarIcons(this.f27392e.getCar3DIcons());
            this.f27455u.setCarMarkerBitmap(this.f27392e.getCarBitmapDescriptor());
            this.f27455u.setCarMarkerZIndex(this.f27392e.getzIndex());
        }
    }

    /* renamed from: k */
    private void m19435k() {
        if (this.f27392e.getVamosExpansionParam() != null) {
            this.f27439ac.vamosDriverTripDestPoint = this.f27392e.getVamosExpansionParam().driverTripDestPoint;
        }
        this.f27439ac.orderPickupPoint = this.f27392e.getPickupPoint();
        this.f27439ac.orderDestPoint = this.f27392e.getEndPoint();
        this.f27456v = checkInterval(this.f27392e.getOraRequestInterval());
        m19443o();
        if (this.f27392e.isArrivedPickupPoint()) {
            m19390a(this.f27427Q);
            this.f27439ac.enableDrawLine = false;
        }
        if (this.f27392e.getWayPoints() != null) {
            setWayPoints(this.f27392e.getWayPoints(), this.f27392e.getWayPointsTimestamp());
        }
    }

    /* renamed from: l */
    private void m19437l() {
        this.f27433W = new OmegaReportManager(new OmegaReportManager.SctxReportGetter() {
            public String getUid() {
                return PassengerSctxServiceFour.this.m19456v();
            }

            public String getOrderId() {
                return PassengerSctxServiceFour.this.f27392e.getOrderId();
            }

            public int getOrderState() {
                return PassengerSctxServiceFour.this.f27392e.getTripState();
            }

            public int getProductId() {
                return PassengerSctxServiceFour.this.f27392e.getBizType();
            }

            public String getRole() {
                return PassengerSctxServiceFour.this.m19459w();
            }

            public String getPageReferrer() {
                return PassengerSctxServiceFour.this.m19461x();
            }

            public RouteGuidanceGPSPoint getOriginDriverPoint() {
                return PassengerSctxServiceFour.this.f27432V;
            }

            public int getDriverMatchEda() {
                int i;
                int i2;
                RouteGuidanceGPSPoint g = PassengerSctxServiceFour.this.f27416F;
                int i3 = -1;
                if (g == null) {
                    return -1;
                }
                int distanceToTail = PassengerSctxServiceFour.this.f27417G != null ? PassengerSctxServiceFour.this.f27417G.distanceToTail(g) : -1;
                if (PassengerSctxServiceFour.this.f27412B != null) {
                    i2 = PassengerSctxServiceFour.this.f27412B.distanceLeft();
                    i = PassengerSctxServiceFour.this.f27412B.distanceLeft(g);
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (ApolloUtils.newEdaCalculator() && PassengerSctxServiceFour.this.f27417G != null) {
                    i3 = distanceToTail;
                } else if (PassengerSctxServiceFour.this.f27412B != null) {
                    i3 = i2;
                }
                DLog.m7384d("eda_log", "DriverMatchEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|CurDriverEda:" + i3 + "|OldEda:" + i2 + "|oldEdaParam:" + i + "|NewEda:" + distanceToTail + "|segmentIndex:" + g.segmentIndex, new Object[0]);
                return i3;
            }

            public int getCarAnimEda() {
                return BizUtil.animDistanceLeft(PassengerSctxServiceFour.this.f27413C, PassengerSctxServiceFour.this.f27412B);
            }

            public List<MockMovementInfo.SctxAnimData> getSctxAnimDataList() {
                ArrayList arrayList = new ArrayList(PassengerSctxServiceFour.this.f27434X);
                PassengerSctxServiceFour.this.f27434X.clear();
                return arrayList;
            }

            public boolean isSplitAccounts() {
                return PassengerSctxServiceFour.this.f27392e.isReadOnly();
            }

            public CarMarker getDriverMarker() {
                return PassengerSctxServiceFour.this.getCarMarker();
            }

            public boolean isArrived() {
                return PassengerSctxServiceFour.this.f27392e.isArrivedPickupPoint();
            }

            public boolean isSimulateEtaEdaLimit(boolean z) {
                return PassengerSctxServiceFour.this.m19409b(z);
            }

            public List<LatLng> getSctxRoutePoints() {
                return PassengerSctxServiceFour.this.f27414D;
            }

            public double getMaxMockDistance() {
                return (double) PassengerSctxServiceFour.this.f27395h.getMaxMockDistance(PassengerSctxServiceFour.this.f27412B.getMatchPointType());
            }

            public long getMaxMockTime() {
                return PassengerSctxServiceFour.this.f27395h.getMaxMockTime(PassengerSctxServiceFour.this.f27412B.getMatchPointType());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m19439m() {
        if (m19462y()) {
            this.f27433W.doOmegaOnCarDelayed(this.f27392e.getBizType(), m19459w(), this.f27395h.getSctxPredictionEnable(), this.f27439ac.lastReceiveRouteTime, this.f27413C, this.f27412B);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m19441n() {
        DLog.m7384d(f27408r, "resetEtaEda", new Object[0]);
        this.f27421K = 0;
        this.f27420J = 0;
        int i = this.f27418H;
        this.f27422L = i;
        this.f27423M = i * 60;
        this.f27424N = this.f27419I;
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f27455u.setCarMarkerBitmap(bitmapDescriptor);
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        return this.f27455u.refresh3DCarIcons(z, list);
    }

    public void setOraRequestInterval(long j) {
        long checkInterval = checkInterval(j);
        long j2 = this.f27456v;
        if (checkInterval != j2) {
            DLog.m7384d(f27408r, "setOraRequestInterval :%s -> %s", Long.valueOf(j2), Long.valueOf(checkInterval));
            this.f27456v = checkInterval;
            m19443o();
            refreshSyncInterval();
        }
    }

    /* renamed from: o */
    private void m19443o() {
        IInertiaDelegate iInertiaDelegate = this.f27412B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.setRequestIntervalInMills((int) this.f27456v);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27413C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setAnimationInterval((int) this.f27456v);
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return this.f27456v;
    }

    /* renamed from: a */
    private void m19394a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list, List<TrafficItem> list2) {
        DLog.m7384d(f27408r, "setOrderRouteResponse...", new Object[0]);
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
        if (!CollectionUtil.isEmpty((Collection<?>) latLngListFromDiffGeoPoints) || CollectionUtil.isEmpty((Collection<?>) list)) {
            list = latLngListFromDiffGeoPoints;
        }
        float f = 0.0f;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            if (mapPassengeOrderRouteRes.direction != null) {
                f = (float) mapPassengeOrderRouteRes.direction.intValue();
            }
            this.f27453aq = f;
        } else {
            if (list.size() > 1) {
                f = (float) DDSphericalUtil.computeHeading(list.get(0), list.get(1));
            } else if (mapPassengeOrderRouteRes.direction != null) {
                f = (float) mapPassengeOrderRouteRes.direction.intValue();
            }
            this.f27453aq = f;
        }
        if (!this.f27400m) {
            m19407b(mapPassengeOrderRouteRes, list, list2);
        }
    }

    /* renamed from: b */
    private void m19407b(final MapPassengeOrderRouteRes mapPassengeOrderRouteRes, final List<LatLng> list, final List<TrafficItem> list2) {
        if (this.f27439ac.isExtendedAnimating) {
            DLog.m7384d(f27408r, "bIsExtendedAnimating, return", new Object[0]);
        } else if (!m19445p() || !this.f27439ac.isFirstRecvRoutes) {
            m19414c(mapPassengeOrderRouteRes, list, list2);
        } else if (mapPassengeOrderRouteRes == null || mapPassengeOrderRouteRes.secRouteInfo == null) {
            this.f27439ac.isFirstRecvRoutes = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                m19414c(mapPassengeOrderRouteRes, list, list2);
                return;
            }
            if (this.f27414D.isEmpty()) {
                this.f27414D.addAll(list);
            }
            TrafficLineAnimatorOptions trafficLineAnimatorOptions = new TrafficLineAnimatorOptions();
            trafficLineAnimatorOptions.duration = getRouteExtensionAnimationDuration();
            trafficLineAnimatorOptions.animatorListener = new TrafficLineAnimatorOptions.TrafficLineAnimatorListener() {
                public void onStart() {
                    PassengerSctxServiceFour.this.f27439ac.isExtendedAnimating = true;
                    if (PassengerSctxServiceFour.this.f27391d != null) {
                        PassengerSctxServiceFour.this.f27391d.onRouteAnimationStart();
                    }
                }

                public void onEnd() {
                    PassengerSctxServiceFour.this.f27439ac.isExtendedAnimating = false;
                    if (PassengerSctxServiceFour.this.f27391d != null) {
                        PassengerSctxServiceFour.this.f27391d.onRouteAnimationEnd();
                    }
                    if (!PassengerSctxServiceFour.this.m19414c(mapPassengeOrderRouteRes, list, list2)) {
                        PassengerSctxServiceFour.this.m19385a((LatLng) list.get(0), list.size() > 1 ? (float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1)) : mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue());
                    }
                }
            };
            m19390a(this.f27427Q);
            this.f27427Q = new TrafficLineDelegate();
            List<TrafficItem> list3 = mapPassengeOrderRouteRes.traffic;
            m19392a(this.f27427Q, list, (!CollectionUtil.isEmpty((Collection<?>) list3) || CollectionUtil.isEmpty((Collection<?>) list2)) ? list3 : list2, trafficLineAnimatorOptions, false, false);
        } else {
            m19414c(mapPassengeOrderRouteRes, list, list2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19385a(LatLng latLng, float f) {
        ISctxViewDelegate iSctxViewDelegate;
        if (latLng != null && (iSctxViewDelegate = this.f27455u) != null) {
            iSctxViewDelegate.updateCarMarker(latLng);
            this.f27455u.updateCarDirection(f);
        }
    }

    /* renamed from: a */
    private void m19393a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        this.f27431U.parseFrom(mapPassengeOrderRouteRes);
        boolean z = true;
        this.f27425O = !this.f27431U.lineVisible;
        SctxDataCache sctxDataCache = this.f27439ac;
        if (!this.f27431U.lineVisible || this.f27392e.isArrivedPickupPoint()) {
            z = false;
        }
        sctxDataCache.enableDrawLine = z;
    }

    /* renamed from: p */
    private boolean m19445p() {
        return this.f27439ac.enableDrawLine && this.f27392e.isShowExtendedAnimation() && m19462y();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m19414c(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list, List<TrafficItem> list2) {
        int i;
        int i2;
        MapPassengeOrderRouteRes mapPassengeOrderRouteRes2 = mapPassengeOrderRouteRes;
        List<LatLng> list3 = list;
        this.f27439ac.isRouteChanged = false;
        if (mapPassengeOrderRouteRes2.logId == null) {
            DLog.m7384d(f27408r, "res.logId == null", new Object[0]);
        } else if (this.f27460z > mapPassengeOrderRouteRes2.logId.longValue()) {
            DLog.m7384d(f27408r, "mResLogId:%d > res.logId:%d, return", Long.valueOf(this.f27460z), mapPassengeOrderRouteRes2.logId);
            return false;
        } else {
            this.f27460z = mapPassengeOrderRouteRes2.logId.longValue();
        }
        if (this.f27391d != null) {
            if (this.f27392e.isReadOnly() && !CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f27391d.onStartDestinationUpdate(list3.get(0), list3.get(list.size() - 1));
            }
            if (mapPassengeOrderRouteRes2.ret != null) {
                if (mapPassengeOrderRouteRes2.ret.intValue() == 33333) {
                    this.f27391d.onWayPointsStateUpdate(true, (List<OdPoint>) null);
                } else if (mapPassengeOrderRouteRes2.ret.intValue() == 0) {
                    this.f27391d.onWayPointsStateUpdate(false, this.f27426P);
                    this.f27391d.onWayPointsStateUpdateForMiniBus(CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes2.odPoints) ? new ArrayList() : mapPassengeOrderRouteRes2.odPoints);
                }
            }
        }
        if (mapPassengeOrderRouteRes2.eta != null && mapPassengeOrderRouteRes2.eta.intValue() >= 0) {
            this.f27418H = mapPassengeOrderRouteRes2.eta.intValue();
            DLog.m7384d(f27408r, "res.eta:" + mapPassengeOrderRouteRes2.eta, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.distance != null && mapPassengeOrderRouteRes2.distance.intValue() >= 0) {
            this.f27419I = mapPassengeOrderRouteRes2.distance.intValue();
            DLog.m7384d(f27408r, "res.distance:" + mapPassengeOrderRouteRes2.distance, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue())) {
            DLog.m7384d(f27408r, "res.driverPoint is error", new Object[0]);
            this.f27396i.setDriverError(3);
            this.f27398k.setErrorCode(202);
            return false;
        }
        LatLng latLng = new LatLng((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue());
        Object[] objArr = new Object[2];
        objArr[0] = GoogleSyncTripLogUtil.getLatLngLogInfo(latLng);
        if (mapPassengeOrderRouteRes2.direction == null) {
            i = 0;
        } else {
            i = mapPassengeOrderRouteRes2.direction.intValue();
        }
        objArr[1] = Integer.valueOf(i);
        DLog.m7384d(f27408r, "server返回的司机定位:%s，方向:%d", objArr);
        DoublePoint doublePoint = mapPassengeOrderRouteRes2.driverPoint;
        if (mapPassengeOrderRouteRes2.direction == null) {
            i2 = 0;
        } else {
            i2 = mapPassengeOrderRouteRes2.direction.intValue();
        }
        RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint = ConvertUtil.tran2RouteGuidanceGPSPoint(doublePoint, i2);
        this.f27432V = tran2RouteGuidanceGPSPoint;
        IInertiaDelegate iInertiaDelegate = this.f27412B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.onRecvDriverLocation(tran2RouteGuidanceGPSPoint);
        }
        float f = 0.0f;
        if (this.f27425O) {
            m19390a(this.f27427Q);
            if (this.f27455u.getCarMarker() == null) {
                m19385a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
            }
        }
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(list.size());
            objArr2[1] = Long.valueOf(this.f27401n);
            objArr2[2] = Long.valueOf(mapPassengeOrderRouteRes2.routeId == null ? 0 : mapPassengeOrderRouteRes2.routeId.longValue());
            DLog.m7384d(f27408r, "server返回了路线，路线点集个数:%d，重新画线，routeId:[%d -> %d]", objArr2);
            if (hasLine() && mapPassengeOrderRouteRes2.routeId != null && mapPassengeOrderRouteRes2.routeId.longValue() == this.f27401n && list.size() == this.f27414D.size() && m19371a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex) == this.f27402o) {
                DLog.m7384d(f27408r, "后台返回了跟上次一样的routeId，但也返回了路线(按理不该返回)，这里就不再刷新路线", new Object[0]);
                m19447q();
            } else {
                this.f27439ac.isRouteChanged = true;
                this.f27439ac.routePoints = list3;
                this.f27439ac.trafficItems = mapPassengeOrderRouteRes2.traffic;
                final MapPassengeOrderRouteRes mapPassengeOrderRouteRes3 = mapPassengeOrderRouteRes;
                final List<LatLng> list4 = list;
                final List<TrafficItem> list5 = list2;
                final LatLng latLng2 = latLng;
                this.f27413C.animateCancel(new onCarAnimationCancelListener() {
                    public void onCancel() {
                        float f;
                        int i = 0;
                        DLog.m7384d(PassengerSctxServiceFour.f27408r, "onCarAnimationCancelListener onCancel() callback", new Object[0]);
                        long j = 0;
                        if (mapPassengeOrderRouteRes3.routeId == null) {
                            PassengerSctxServiceFour.this.f27401n = 0;
                            PassengerSctxServiceFour.this.f27402o = 0;
                        } else {
                            if (PassengerSctxServiceFour.this.m19462y() && PassengerSctxServiceFour.this.f27401n > 0 && PassengerSctxServiceFour.this.getCarMarker() != null) {
                                float computeHeading = (float) DDSphericalUtil.computeHeading(PassengerSctxServiceFour.this.getCarMarker().getPosition(), (LatLng) list4.get(0));
                                if (!(PassengerSctxServiceFour.this.f27412B == null || PassengerSctxServiceFour.this.f27412B.getLastMatchGPSPoint() == null)) {
                                    j = PassengerSctxServiceFour.this.f27412B.getLastMatchGPSPoint().timestamp;
                                }
                                GoogleSyncTripOmegaUtil.map_pax_car_jump(PassengerSctxServiceFour.this.m19456v(), PassengerSctxServiceFour.this.f27392e.getOrderId(), PassengerSctxServiceFour.this.f27392e.getTripState(), PassengerSctxServiceFour.this.f27392e.isArrivedPickupPoint(), computeHeading, !PassengerSctxServiceFour.this.f27425O ? 1 : 0, PassengerSctxServiceFour.this.getCarMarker().getPosition(), j, (LatLng) list4.get(0), mapPassengeOrderRouteRes3.driverPoint.gpsTimestamp.longValue(), PassengerSctxServiceFour.this.f27392e.getBizType(), PassengerSctxServiceFour.this.m19459w(), PassengerSctxServiceFour.this.m19461x());
                            }
                            PassengerSctxServiceFour.this.f27401n = mapPassengeOrderRouteRes3.routeId.longValue();
                            PassengerSctxServiceFour passengerSctxServiceFour = PassengerSctxServiceFour.this;
                            passengerSctxServiceFour.f27402o = passengerSctxServiceFour.m19371a(mapPassengeOrderRouteRes3.curDstRouteGeoIndex);
                        }
                        if (!CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes3.traffic) || CollectionUtil.isEmpty((Collection<?>) list5)) {
                            PassengerSctxServiceFour passengerSctxServiceFour2 = PassengerSctxServiceFour.this;
                            MapPassengeOrderRouteRes mapPassengeOrderRouteRes = mapPassengeOrderRouteRes3;
                            passengerSctxServiceFour2.m19418d(mapPassengeOrderRouteRes, list4, mapPassengeOrderRouteRes.traffic);
                        } else {
                            PassengerSctxServiceFour.this.m19418d(mapPassengeOrderRouteRes3, list4, list5);
                        }
                        PassengerSctxServiceFour.this.f27439ac.lastReceiveRouteTime = System.currentTimeMillis();
                        CarIconsPreloader.getInstance().setRoutePoints(PassengerSctxServiceFour.this.f27388a.getContext(), list4);
                        RouteGuidanceGPSPoint unused = PassengerSctxServiceFour.this.f27416F = new RouteGuidanceGPSPoint();
                        PassengerSctxServiceFour.this.f27416F.segmentIndex = -1;
                        PassengerSctxServiceFour.this.f27413C.setNavRoutePoints(list4, false);
                        if (PassengerSctxServiceFour.this.f27412B != null) {
                            if (PassengerSctxServiceFour.this.f27402o > 0) {
                                PassengerSctxServiceFour.this.f27412B.setRoutePoints(list4, PassengerSctxServiceFour.this.f27402o, PassengerSctxServiceFour.this.m19399a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceFour.this.f27417G.setRoutePoints(list4, PassengerSctxServiceFour.this.f27402o);
                                }
                            } else {
                                PassengerSctxServiceFour.this.f27412B.setRoutePoints((List<LatLng>) list4, PassengerSctxServiceFour.this.m19399a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceFour.this.f27417G.setRoutePoints(list4);
                                }
                            }
                        }
                        PassengerSctxServiceFour.this.m19447q();
                        if (PassengerSctxServiceFour.this.f27455u.getCarMarker() != null) {
                            return;
                        }
                        if (!PassengerSctxServiceFour.this.f27392e.isArrivedPickupPoint()) {
                            PassengerSctxServiceFour passengerSctxServiceFour3 = PassengerSctxServiceFour.this;
                            LatLng latLng = (LatLng) list4.get(0);
                            if (list4.size() > 1) {
                                f = (float) DDSphericalUtil.computeHeading((LatLng) list4.get(0), (LatLng) list4.get(1));
                            } else {
                                if (mapPassengeOrderRouteRes3.direction != null) {
                                    i = mapPassengeOrderRouteRes3.direction.intValue();
                                }
                                f = (float) i;
                            }
                            passengerSctxServiceFour3.m19385a(latLng, f);
                            return;
                        }
                        DLog.m7384d(PassengerSctxServiceFour.f27408r, "司机已到达态下发新路线时，初始让小车显示在真实司机位置%s，非路线第一个点", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng2));
                        PassengerSctxServiceFour.this.m19385a(latLng2, mapPassengeOrderRouteRes3.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes3.direction.intValue());
                    }
                });
            }
            if (!this.f27392e.isReadOnly()) {
                GoogleSyncTripOmegaUtil.com_map_PassengerGetRoute_sw_global(m19456v(), this.f27392e.getOrderId(), this.f27401n, this.f27392e.getTripState(), this.f27392e.isArrivedPickupPoint(), this.f27392e.getCountryId(), this.f27392e.getTripId(), this.f27399l, this.f27392e.getBizType(), m19459w(), m19461x());
            }
        } else {
            m19447q();
            if (this.f27455u.getCarMarker() == null) {
                if (mapPassengeOrderRouteRes2.direction != null) {
                    f = (float) mapPassengeOrderRouteRes2.direction.intValue();
                }
                m19385a(latLng, f);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19371a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m19447q() {
        IInertiaDelegate iInertiaDelegate = this.f27412B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.getMatchPoint(m19449r());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19399a(boolean z) {
        if (!m19462y() || !TextUtils.isEmpty(this.f27392e.getTripId()) || this.f27392e.isReadOnly()) {
            if (z) {
                DLog.m7384d(f27408r, "[getMatchPoint result] 非接驾段 | 拼车 | 分账人 -> 不开启惯导", new Object[0]);
            }
            return false;
        }
        boolean simulateMotionEnable = this.f27395h.getSimulateMotionEnable();
        if (z) {
            DLog.m7384d(f27408r, "[getMatchPoint] 看是否满足惯导条件：", new Object[0]);
            DLog.m7384d(f27408r, "1.总Apollo开关是否打开：%s", Boolean.valueOf(simulateMotionEnable));
        }
        return simulateMotionEnable;
    }

    /* renamed from: r */
    private boolean m19449r() {
        boolean a = m19399a(true);
        if (!a) {
            return a;
        }
        int maxMockDistance = this.f27395h.getMaxMockDistance(this.f27412B.getMatchPointType());
        long maxMockTime = this.f27395h.getMaxMockTime(this.f27412B.getMatchPointType());
        boolean z = this.f27421K < maxMockDistance && this.f27420J < maxMockTime;
        DLog.m7384d(f27408r, "2.累积惯导距离：%d, 累积惯导时间：%d [距离上限：%d, 时间上限:%d]", Integer.valueOf(this.f27421K), Long.valueOf(this.f27420J), Integer.valueOf(maxMockDistance), Long.valueOf(maxMockTime));
        return z ? !m19409b(true) : z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19409b(boolean z) {
        int allowEDA = this.f27395h.getAllowEDA();
        int allowETA = (int) ((this.f27395h.getAllowETA() / 1000) / 60);
        if (this.f27422L > 0 || this.f27424N > 0) {
            if (z) {
                DLog.m7384d(f27408r, "3.mShowDistance：%d, mShowEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27424N), Integer.valueOf(this.f27422L), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
            }
            if (this.f27424N <= allowEDA || this.f27422L <= allowETA) {
                return true;
            }
            return false;
        }
        if (z) {
            DLog.m7384d(f27408r, "3.mDistance：%d, mEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27419I), Integer.valueOf(this.f27418H), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
        }
        if (this.f27419I <= allowEDA || this.f27418H <= allowETA) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m19418d(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes r12, java.util.List<com.didi.common.map.model.LatLng> r13, java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r14) {
        /*
            r11 = this;
            boolean r0 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r13)
            r1 = 0
            if (r0 != 0) goto L_0x0059
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.util.Iterator r2 = r13.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003d
            java.lang.Object r3 = r2.next()
            com.didi.common.map.model.LatLng r3 = (com.didi.common.map.model.LatLng) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            double r5 = r3.longitude
            r4.append(r5)
            java.lang.String r5 = ","
            r4.append(r5)
            double r5 = r3.latitude
            r4.append(r5)
            java.lang.String r3 = ";"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.append(r3)
            goto L_0x0010
        L_0x003d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "新路线: "
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "ccc"
            com.didi.common.map.util.DLog.m7384d(r3, r0, r2)
        L_0x0059:
            java.util.ArrayList<com.didi.common.map.model.LatLng> r0 = r11.f27414D
            r0.clear()
            java.util.ArrayList<com.didi.common.map.model.LatLng> r0 = r11.f27414D
            r0.addAll(r13)
            r11.m19441n()
            com.didi.map.global.sctx.model.SctxDataCache r0 = r11.f27439ac
            boolean r0 = r0.enableDrawLine
            if (r0 == 0) goto L_0x0170
            com.didi.map.global.sctx.model.SctxDataCache r0 = r11.f27439ac
            boolean r0 = r0.isDestModified
            java.lang.String r2 = "PassengerSctxService"
            r3 = 1
            if (r0 == 0) goto L_0x00a4
            int r0 = r13.size()
            int r0 = r0 - r3
            java.lang.Object r0 = r13.get(r0)
            com.didi.common.map.model.LatLng r0 = (com.didi.common.map.model.LatLng) r0
            com.didi.map.global.sctx.model.SctxTripParam r4 = r11.f27392e
            com.didi.common.map.model.LatLng r4 = r4.getEndPoint()
            double r4 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r0, r4)
            r6 = 4647503709213818880(0x407f400000000000, double:500.0)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a4
            java.lang.Object[] r12 = new java.lang.Object[r3]
            r13 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12[r1] = r13
            java.lang.String r13 = "updateNewLine - 修改了目的地，但是修改后的目的地与后台下发的路线终点距离相差大于%dm --> 不画线"
            com.didi.common.map.util.DLog.m7384d(r2, r13, r12)
            goto L_0x0170
        L_0x00a4:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r4 = "updateNewLine - rebuild TrafficLine"
            com.didi.common.map.util.DLog.m7384d(r2, r4, r0)
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r11.f27391d
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r11.f27451ao
            if (r0 != 0) goto L_0x00b8
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r11.f27391d
            r0.goingOffCourse()
        L_0x00b8:
            r11.f27451ao = r1
            r0 = 0
            r11.f27447ak = r0
            r11.f27415E = r0
            boolean r4 = r11.m19368M()
            if (r4 == 0) goto L_0x00f7
            r11.f27430T = r1
            com.didi.map.global.sctx.widget.TrafficLineDelegate r4 = r11.f27446aj
            if (r4 == 0) goto L_0x00d9
            r11.m19390a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r4)
            r11.f27446aj = r0
            com.didi.map.global.sctx.SctxService$SctxCallback r4 = r11.f27391d
            if (r4 == 0) goto L_0x00d9
            com.didi.map.global.sctx.SctxService$SctxCallback r4 = r11.f27391d
            r4.showSecRouteInfoCallback(r0, r1)
        L_0x00d9:
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r12.secRouteInfo
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.proto.driver_gl.Route r0 = r12.route
            if (r0 == 0) goto L_0x00f7
            boolean r0 = com.didi.map.google.util.DUtils.checkSecRouteInfoValid(r12)
            if (r0 == 0) goto L_0x00f7
            r11.f27447ak = r12
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            com.didi.map.sdk.proto.driver_gl.DiffGeoPoints r12 = r12.routePoints
            java.util.List r12 = com.didi.map.google.util.ConvertUtil.getLatLngListFromDiffGeoPoints(r12)
            r11.f27415E = r12
            r10 = 1
            goto L_0x00f8
        L_0x00f7:
            r10 = 0
        L_0x00f8:
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27427Q
            r11.m19390a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r5 = new com.didi.map.global.sctx.widget.TrafficLineDelegate
            r5.<init>()
            r11.f27427Q = r5
            r8 = 0
            r9 = 0
            r4 = r11
            r6 = r13
            r7 = r14
            r4.m19392a(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27427Q
            r11.m19391a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12, (int) r3)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "draw line"
            com.didi.common.map.util.DLog.m7384d(r2, r13, r12)
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f27447ak
            if (r12 == 0) goto L_0x0170
            java.util.List<com.didi.common.map.model.LatLng> r12 = r11.f27415E
            if (r12 == 0) goto L_0x0170
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27446aj
            r11.m19390a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = new com.didi.map.global.sctx.widget.TrafficLineDelegate
            r12.<init>()
            r11.f27446aj = r12
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f27447ak
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            java.lang.Integer r12 = r12.included
            int r12 = r12.intValue()
            if (r12 != r3) goto L_0x013a
            r9 = 1
            goto L_0x013b
        L_0x013a:
            r9 = 0
        L_0x013b:
            com.didi.map.global.sctx.widget.TrafficLineDelegate r5 = r11.f27446aj
            java.util.List<com.didi.common.map.model.LatLng> r6 = r11.f27415E
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f27447ak
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r7 = r12.traffic
            r8 = 0
            r10 = 1
            r4 = r11
            r4.m19392a(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27446aj
            r13 = 2
            r11.m19391a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12, (int) r13)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27446aj
            r12.highLight(r1)
            r11.m19411c()
            com.didi.map.global.sctx.SctxService$SctxCallback r12 = r11.f27391d
            if (r12 == 0) goto L_0x0169
            com.didi.map.global.sctx.SctxService$SctxCallback r12 = r11.f27391d
            com.didi.map.global.sctx.model.SecRouteInfoEx r13 = new com.didi.map.global.sctx.model.SecRouteInfoEx
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r14 = r11.f27447ak
            r13.<init>(r14)
            r12.showSecRouteInfoCallback(r13, r3)
        L_0x0169:
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "draw sec back line"
            com.didi.common.map.util.DLog.m7384d(r2, r13, r12)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceFour.m19418d(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes, java.util.List, java.util.List):void");
    }

    /* renamed from: a */
    private void m19392a(TrafficLineDelegate trafficLineDelegate, List<LatLng> list, List<TrafficItem> list2, TrafficLineAnimatorOptions trafficLineAnimatorOptions, boolean z, boolean z2) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.setTrafficOptions(m19375a(list, list2, z, z2));
            trafficLineDelegate.addToMap(this.f27388a, trafficLineAnimatorOptions);
        }
    }

    /* renamed from: a */
    private TrafficOptions m19375a(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        if (!MapVendor.DIDI.equals(this.f27388a.getMapVendor()) || !z2 || (ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture())) {
            return m19404b(list, list2, z, z2);
        }
        return m19376a(list, z);
    }

    /* renamed from: a */
    private TrafficOptions m19376a(List<LatLng> list, boolean z) {
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
    private TrafficOptions m19404b(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
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
        return this.f27414D;
    }

    public List<Line> getLines() {
        TrafficLineDelegate trafficLineDelegate = this.f27427Q;
        if (trafficLineDelegate == null) {
            return null;
        }
        return trafficLineDelegate.getLines();
    }

    public List<LatLng> getRemainingRoutePoints() {
        return this.f27437aa;
    }

    /* renamed from: s */
    private int m19450s() {
        if (!this.f27425O) {
            int i = m19462y() ? this.f27422L : this.f27418H;
            if (Math.abs(this.f27458x - i) >= 1) {
                m19381a(i, m19462y() ? this.f27424N : this.f27419I);
                this.f27458x = i;
            }
            return i;
        } else if (this.f27431U.mEta >= 0) {
            DLog.m7384d(f27408r, "bIsHideRoute, eta:" + this.f27431U.mEta, new Object[0]);
            return this.f27431U.mEta;
        } else {
            DLog.m7384d(f27408r, "bIsHideRoute, eta return %d", 1);
            return 1;
        }
    }

    /* renamed from: t */
    private int m19452t() {
        if (!this.f27425O) {
            int i = m19462y() ? this.f27424N : this.f27419I;
            if (Math.abs(this.f27459y - i) >= 100) {
                m19381a(m19462y() ? this.f27422L : this.f27418H, i);
                this.f27459y = i;
            }
            return i;
        } else if (this.f27431U.mDistance >= 0) {
            DLog.m7384d(f27408r, "bIsHideRoute, eda:" + this.f27431U.mDistance, new Object[0]);
            return this.f27431U.mDistance;
        } else {
            DLog.m7384d(f27408r, "bIsHideRoute, eda return %d", 100);
            return 100;
        }
    }

    /* renamed from: u */
    private LatLng m19454u() {
        DoublePoint location = DUtils.getLocation(this.f27389b);
        return location != null ? new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue()) : new LatLng(0.0d, 0.0d);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public String m19456v() {
        return this.f27393f != null ? this.f27393f.getUserId() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public String m19459w() {
        if (!TextUtils.isEmpty(this.f27439ac.userRole)) {
            return this.f27439ac.userRole;
        }
        if (this.f27393f != null) {
            this.f27439ac.userRole = this.f27393f.getUserRole();
        }
        return this.f27439ac.userRole;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public String m19461x() {
        if (this.f27393f != null) {
            return this.f27393f.getPageReferrer();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public boolean m19462y() {
        return this.f27392e.getTripState() == 3 && !this.f27392e.isArrivedPickupPoint();
    }

    /* renamed from: z */
    private boolean m19465z() {
        return this.f27392e.getTripState() == 3 && this.f27392e.isArrivedPickupPoint();
    }

    /* renamed from: A */
    private boolean m19345A() {
        return this.f27392e.getTripState() == 4;
    }

    public double getRemainingRouteDistance() {
        if (!this.f27392e.isArrivedPickupPoint() || getCarMarker() == null) {
            return 0.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(getCarMarker().getPosition(), this.f27392e.getPickupPoint());
    }

    public LatLng getDriverPoint() {
        IInertiaDelegate iInertiaDelegate = this.f27412B;
        if (iInertiaDelegate == null || iInertiaDelegate.getLastMatchGPSPoint() == null || this.f27412B.getLastMatchGPSPoint().segmentIndex == -1) {
            if (getCarMarker() != null) {
                return getCarMarker().getPosition();
            }
            return null;
        } else if (!this.f27395h.getSctxPredictionEnable() || this.f27412B.getLastMatchGPSPoint().originMatchPoint == null) {
            return ConvertUtil.convertFromGeoPoint(this.f27412B.getLastMatchGPSPoint().point);
        } else {
            return ConvertUtil.convertFromGeoPoint(this.f27412B.getLastMatchGPSPoint().originMatchPoint.point);
        }
    }

    public CarMarker getCarMarker() {
        ISctxViewDelegate iSctxViewDelegate = this.f27455u;
        if (iSctxViewDelegate == null) {
            return null;
        }
        return iSctxViewDelegate.getCarMarker();
    }

    public void updateDestination(LatLng latLng) {
        DLog.m7384d(f27408r, "updateDestination...", new Object[0]);
        m19386a(this.f27392e.getPickupPoint(), latLng);
        if (latLng != null) {
            this.f27439ac.orderDestPoint = latLng;
            if (this.f27392e.getTripState() == 4) {
                DLog.m7384d(f27408r, "updateDestination - 送驾段，removeLine", new Object[0]);
                this.f27439ac.isDestModified = true;
                m19390a(this.f27427Q);
            }
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        m19386a(latLng, this.f27392e.getEndPoint());
        if (latLng != null) {
            this.f27448al = 1;
            this.f27439ac.orderPickupPoint = latLng;
            this.f27401n = 0;
            if (this.f27392e.getTripState() == 3) {
                DLog.m7384d(f27408r, "updateDestination - 接驾段，removeLine", new Object[0]);
                m19366L();
                m19359H();
                m19353E();
                m19351D();
                runImmediately();
            }
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        DLog.m7384d(f27408r, "[途经点信息] setOdPoints:%s, odPointsTimestamp:%d", GoogleSyncTripLogUtil.getOdPointsLogInfo(list), Long.valueOf(j));
        this.f27439ac.lastGetWayPointTime = j;
        List<OdPoint> list2 = this.f27426P;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.f27426P.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        if (TextUtils.isEmpty(this.f27392e.getToken())) {
            return null;
        }
        PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
        if (this.f27439ac.orderPickupPoint != null) {
            builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27439ac.orderPickupPoint.latitude)).lng(Float.valueOf((float) this.f27439ac.orderPickupPoint.longitude)).build());
        }
        if (this.f27439ac.orderDestPoint != null) {
            builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27439ac.orderDestPoint.latitude)).lng(Float.valueOf((float) this.f27439ac.orderDestPoint.longitude)).build());
        }
        if (this.f27439ac.vamosDriverTripDestPoint != null) {
            builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27439ac.vamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.f27439ac.vamosDriverTripDestPoint.longitude)).build()).build());
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
        curRouteId.imei(str2).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f27392e.getClientVersion()).lastOrderId(this.f27392e.getLastOrderId()).noNeedGeo(false).productId(String.valueOf(this.f27392e.getBizType())).countryId(this.f27392e.getCountryId()).sdkmaptype(str).lang(LocaleCodeHolder.getInstance().getCurrentLang()).travelId(this.f27392e.getTripId()).recPPState(Integer.valueOf(this.f27448al)).psgPoint(DUtils.getLocation(this.f27389b)).pushBtMsg(false).bizGroup(Integer.valueOf(this.f27392e.getBizGroup()));
        if (this.f27392e.getTripState() == 4) {
            if (this.f27439ac.lastGetWayPointTime <= 0) {
                DLog.m7384d(f27408r, "mWayPointTimeStamp(%d) <= 0，不传给后台途经点", Long.valueOf(this.f27439ac.lastGetWayPointTime));
            } else {
                builder.odPoints(this.f27426P);
                builder.odPointsTimestamp(Long.valueOf(this.f27439ac.lastGetWayPointTime));
            }
        }
        builder.readOnly(Boolean.valueOf(this.f27392e.isReadOnly()));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
        OmegaReportManager omegaReportManager;
        DLog.m7384d(f27408r, "onSyncStart...", new Object[0]);
        if (this.f27391d != null) {
            this.f27391d.onSyncStart();
        }
        if (!this.f27392e.isReadOnly() && (omegaReportManager = this.f27433W) != null) {
            omegaReportManager.doOmegaReportByTimeInterval();
        }
    }

    /* renamed from: B */
    private void m19347B() {
        if (this.f27392e.getTripState() == 3) {
            this.f27433W.trackOrderLocationPermission(Utils.getLocationSwitchLevel(this.f27389b), m19362J());
        }
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m7384d(f27408r, "onOraResponse...", new Object[0]);
        if (!this.f27399l) {
            if (Config.DEBUG && mapPassengeOrderRouteRes.ret != null && mapPassengeOrderRouteRes.ret.intValue() == 10000) {
                this.f27391d.orderChanged();
            } else if (mapPassengeOrderRouteRes != null) {
                if (mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() != 30076 || this.f27391d == null) {
                    if (!(mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() == 0 || mapPassengeOrderRouteRes.logId == null)) {
                        this.f27433W.trackOrderRouteResultError(mapPassengeOrderRouteRes.ret.intValue(), mapPassengeOrderRouteRes.logId.longValue());
                    }
                    m19393a(mapPassengeOrderRouteRes);
                    if (m19396a(this.f27431U.serverStage) && this.f27391d != null) {
                        this.f27391d.onAbnormalOrderStageCallback(this.f27431U.serverStage);
                        this.f27398k.setErrorCode(203);
                    }
                    if (this.f27431U.serverStage == 5) {
                        this.f27396i.setDriverError(2);
                        this.f27398k.setErrorCode(203);
                        stop();
                        return;
                    }
                    if (!this.f27399l) {
                        this.f27454ar = true;
                    }
                    m19394a(mapPassengeOrderRouteRes, this.f27439ac.routePoints, this.f27439ac.trafficItems);
                    if (this.f27391d != null) {
                        this.f27391d.onSyncSuccess(mapPassengeOrderRouteRes);
                        this.f27391d.onEtaEdaUpdate(new EtaEdaInfo(m19450s(), m19452t(), SXUtils.getLastOrderEda(this.f27392e.getLastOrderId(), mapPassengeOrderRouteRes)));
                        return;
                    }
                    return;
                }
                DLog.m7384d(f27408r, "error code:" + mapPassengeOrderRouteRes.ret, new Object[0]);
                this.f27391d.onAbnormalOrderStageCallback(4);
            }
        }
    }

    /* renamed from: C */
    private double m19348C() {
        LatLng driverPoint = getDriverPoint();
        List<LatLng> routePoints = getRoutePoints();
        return DDSphericalUtil.computeDistanceBetween(driverPoint, routePoints.get(routePoints.size() - 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m19396a(int r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceFour.m19396a(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
        DLog.m7384d(f27408r, "onOraFail err:%s", str);
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
        if (this.f27439ac.isSctxParamUpdated) {
            this.f27439ac.isSctxParamUpdated = false;
            m19355F();
            DLog.m7384d(f27408r, "onPreStart, isSctxParamUpdated is true", new Object[0]);
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        DLog.m7384d(f27408r, "update...", new Object[0]);
        if (sctxTripParam == null || sctxTripParam.equals(this.f27392e)) {
            DLog.m7384d(f27408r, "update,mSctxTripParam is equals.", new Object[0]);
            return;
        }
        stop();
        this.f27439ac.orderId = this.f27392e.getOrderId();
        this.f27439ac.orderState = this.f27392e.getTripState();
        this.f27439ac.isWaitingState = this.f27392e.isArrivedPickupPoint();
        this.f27439ac.isSctxParamUpdated = true;
        initBaseParam(sctxTripParam);
        m19351D();
        if (this.f27392e.getTripState() == 3) {
            m19405b();
            m19421e();
        }
        m19386a(this.f27392e.getPickupPoint(), this.f27392e.getEndPoint());
        start();
    }

    /* renamed from: D */
    private void m19351D() {
        this.f27434X.clear();
        this.f27436Z = null;
        Handler handler = this.f27435Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        } else {
            this.f27435Y = new Handler(Looper.getMainLooper());
        }
        if (this.f27392e != null && !this.f27392e.isArrivedPickupPoint() && this.f27392e.getTripState() == 3) {
            m19384a(1000);
        }
        DLog.m7384d("ccc", "开始记录缓存数据", new Object[0]);
    }

    /* renamed from: E */
    private void m19353E() {
        this.f27434X.clear();
        this.f27436Z = null;
        Handler handler = this.f27435Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27435Y = null;
        }
        DLog.m7384d("ccc", "清除缓存数据", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19384a(long j) {
        this.f27435Y.postDelayed(new Runnable() {
            public void run() {
                if (PassengerSctxServiceFour.this.f27413C == null || PassengerSctxServiceFour.this.getCarMarker() == null) {
                    PassengerSctxServiceFour.this.m19384a(1000);
                    DLog.m7384d("ccc", "未初始化，不缓存轨迹点", new Object[0]);
                } else if (PassengerSctxServiceFour.this.f27403p == 0) {
                    PassengerSctxServiceFour.this.m19384a(1000);
                    DLog.m7384d("ccc", "未可用，不缓存轨迹点", new Object[0]);
                } else if (System.currentTimeMillis() - PassengerSctxServiceFour.this.f27403p < 5000) {
                    PassengerSctxServiceFour.this.m19384a(1000);
                    DLog.m7384d("ccc", "5s内不缓存轨迹数据", new Object[0]);
                } else {
                    if (!PassengerSctxServiceFour.this.f27399l) {
                        MockMovementInfo.SctxAnimData sctxAnimData = new MockMovementInfo.SctxAnimData();
                        if (TimeServiceManager.getInstance().isNTPAvailable()) {
                            sctxAnimData.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        } else {
                            sctxAnimData.ntpTimestamp = -1;
                        }
                        sctxAnimData.localTime = System.currentTimeMillis();
                        LatLng position = PassengerSctxServiceFour.this.getCarMarker().getPosition();
                        sctxAnimData.animLat = position.latitude;
                        sctxAnimData.animLng = position.longitude;
                        int animDistanceLeftCustomed = BizUtil.animDistanceLeftCustomed(PassengerSctxServiceFour.this.f27413C, PassengerSctxServiceFour.this.f27417G);
                        int animDistanceLeft = BizUtil.animDistanceLeft(PassengerSctxServiceFour.this.f27413C, PassengerSctxServiceFour.this.f27412B);
                        if (ApolloUtils.newEdaCalculator()) {
                            sctxAnimData.carAnimEda = animDistanceLeftCustomed;
                        } else {
                            sctxAnimData.carAnimEda = animDistanceLeft;
                        }
                        if (PassengerSctxServiceFour.this.f27436Z != null && PassengerSctxServiceFour.this.f27454ar) {
                            sctxAnimData.animDistance = DDSphericalUtil.computeDistanceBetween(position, PassengerSctxServiceFour.this.f27436Z);
                        }
                        if (PassengerSctxServiceFour.this.f27397j.isEnable()) {
                            sctxAnimData.jumpOverException = PassengerSctxServiceFour.this.f27397j.getCode();
                            PassengerSctxServiceFour.this.f27397j.clearJumpOverData();
                        }
                        PassengerSctxServiceFour.this.f27434X.add(sctxAnimData);
                        LatLng unused = PassengerSctxServiceFour.this.f27436Z = position;
                        DLog.m7384d("eda_log", "CarAnimEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|carAnimEda:" + sctxAnimData.carAnimEda + "|oldCarAnimEda:" + animDistanceLeft + "|newCarAnimEda:" + animDistanceLeftCustomed, new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("新增缓存数据 data.carAnimEda = ");
                        sb.append(sctxAnimData.carAnimEda);
                        sb.append(", data.animDistance=");
                        sb.append(sctxAnimData.animDistance);
                        DLog.m7384d("ccc", sb.toString(), new Object[0]);
                        if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                            String str = Config.DEBUG_TAG;
                            SystemUtils.log(3, str, "------ data.animDistance=" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.global.sctx.PassengerSctxServiceFour$10", 1871);
                        }
                    }
                    PassengerSctxServiceFour.this.m19384a(1000);
                }
            }
        }, j);
    }

    /* renamed from: F */
    private void m19355F() {
        m19430i();
        m19428h();
        m19433j();
        m19435k();
        m19357G();
        m19427g();
    }

    /* renamed from: G */
    private void m19357G() {
        this.f27401n = 0;
        this.f27421K = 0;
        this.f27420J = 0;
        this.f27411A = 0;
        this.f27460z = 0;
        this.f27458x = 0;
        this.f27459y = 0;
        this.f27439ac.clear();
        this.f27433W.clear();
        ArrayList<LatLng> arrayList = this.f27414D;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private void m19381a(int i, int i2) {
        this.f27457w.record(i, i2, m19399a(false), this.f27439ac.isRouteChanged, m19454u(), this.f27392e.isArrivedPickupPoint());
    }

    /* renamed from: H */
    private void m19359H() {
        this.f27457w.doOmega(this.f27392e.getOrderId(), this.f27392e.getTripState(), this.f27392e.isArrivedPickupPoint(), this.f27392e.getCountryId(), m19454u());
        if (!this.f27392e.isReadOnly()) {
            this.f27433W.doOmegaReportCarMoveInfo();
        }
    }

    /* renamed from: a */
    private void m19386a(LatLng latLng, LatLng latLng2) {
        if (this.f27392e != null && this.f27433W != null) {
            if (TextUtils.isEmpty(this.f27392e.getOrderId())) {
                this.f27433W.trackOrderRouteParamError(1);
            } else if (TextUtils.isEmpty(String.valueOf(this.f27392e.getBizType()))) {
                this.f27433W.trackOrderRouteParamError(4);
            } else if (!LatLngUtils.locateCorrect(latLng)) {
                this.f27433W.trackOrderRouteParamError(2);
            } else if (!LatLngUtils.locateCorrect(latLng2)) {
                this.f27433W.trackOrderRouteParamError(3);
            }
        }
    }

    /* renamed from: I */
    private void m19360I() {
        int J = m19362J();
        boolean z = this.f27392e.getTripState() == 3;
        int i = this.f27443ag;
        if (i != J && z) {
            this.f27433W.trackAppLocationPermission(i, J);
        }
        this.f27443ag = J;
    }

    /* renamed from: J */
    private int m19362J() {
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
        m19351D();
        m19360I();
        this.f27454ar = true;
    }

    public void pause() {
        super.pause();
        m19353E();
        m19359H();
        this.f27454ar = false;
    }

    public void leave() {
        super.leave();
        if (ApolloUtils.getAlarmOmegaToggle()) {
            m19365K();
        }
        m19359H();
        this.f27448al = 2;
        runImmediately();
        SctxDataCache sctxDataCache = this.f27439ac;
        if (sctxDataCache != null && sctxDataCache.orderState == 3) {
            m19417d();
        }
        IInertiaDelegate iInertiaDelegate = this.f27412B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f27412B = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27413C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
            this.f27413C = null;
        }
        ISctxViewDelegate iSctxViewDelegate = this.f27455u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.destroy();
            this.f27455u = null;
        }
        m19366L();
        this.f27430T = 0;
        m19353E();
        if (this.f27444ah != null) {
            try {
                this.f27389b.unregisterReceiver(this.f27444ah);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f27444ah = null;
        }
        if (this.f27442af != null) {
            DIDILocationManager.getInstance(this.f27389b).removeLocationUpdates(this.f27442af);
            this.f27442af = null;
        }
        if (this.f27388a != null && this.f27449am != null) {
            this.f27388a.removeOnLineClickListener(this.f27449am);
            this.f27449am = null;
        }
    }

    /* renamed from: K */
    private void m19365K() {
        String str = "";
        String driverError = getCarMarker() == null ? this.f27396i.getDriverError() : str;
        if ((m19462y() || this.f27392e.getTripState() == 4) && !hasLine()) {
            str = this.f27396i.getRouteError();
        }
        if (!TextUtils.isEmpty(driverError) || !TextUtils.isEmpty(str)) {
            ErrorCodeCollect.trackSctxShowError(driverError, str, LoginOmegaUtil.OLD_USER);
        }
    }

    public boolean hasLine() {
        TrafficLineDelegate trafficLineDelegate = this.f27427Q;
        return trafficLineDelegate != null && !CollectionUtil.isEmpty((Collection<?>) trafficLineDelegate.getLines());
    }

    /* renamed from: a */
    private void m19390a(TrafficLineDelegate trafficLineDelegate) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.remove();
        }
    }

    /* renamed from: L */
    private void m19366L() {
        m19390a(this.f27446aj);
        m19390a(this.f27427Q);
        this.f27446aj = null;
        this.f27427Q = null;
        this.f27430T = 0;
    }

    public void cancelPickupPointRecommend() {
        TrafficLineDelegate trafficLineDelegate = this.f27427Q;
        if (trafficLineDelegate != null) {
            trafficLineDelegate.highLight(true);
        }
        this.f27448al = 2;
        m19390a(this.f27446aj);
        this.f27446aj = null;
        runImmediately();
    }

    public void chooseLine(int i) {
        DLog.m7384d(f27408r, "chooseLine: " + i, new Object[0]);
        TrafficLineDelegate trafficLineDelegate = this.f27427Q;
        if (trafficLineDelegate != null && this.f27446aj != null) {
            if (i == 1) {
                trafficLineDelegate.highLight(true);
                m19391a(this.f27427Q, 1);
                this.f27446aj.highLight(false);
                m19391a(this.f27446aj, 2);
                if (this.f27391d != null) {
                    this.f27391d.selectedPickupPoint(this.f27392e.getPickupPoint());
                }
            } else if (i == 2) {
                trafficLineDelegate.highLight(false);
                m19391a(this.f27427Q, 1);
                this.f27446aj.highLight(true);
                m19391a(this.f27446aj, 2);
                SecRouteInfo secRouteInfo = this.f27447ak;
                if (secRouteInfo != null && secRouteInfo.point != null) {
                    PickupPoint pickupPoint = this.f27447ak.point;
                    if (this.f27391d != null) {
                        this.f27391d.selectedPickupPoint(new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m19391a(TrafficLineDelegate trafficLineDelegate, int i) {
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
        this.f27450an = z;
    }
}
