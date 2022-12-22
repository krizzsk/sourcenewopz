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

public class PassengerSctxServiceImp extends AbstractSctxService {
    public static final int RecPPState_Cancel = 2;
    public static final int RecPPState_Use = 1;

    /* renamed from: r */
    private static final String f27461r = "PassengerSctxService";

    /* renamed from: s */
    private static final int f27462s = 1;

    /* renamed from: t */
    private static final int f27463t = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f27464A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IInertiaDelegate f27465B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IMyLocationDelegate f27466C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ArrayList<LatLng> f27467D;

    /* renamed from: E */
    private List<LatLng> f27468E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public RouteGuidanceGPSPoint f27469F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public MatchPointDisHandler f27470G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f27471H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f27472I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f27473J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f27474K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f27475L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f27476M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f27477N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f27478O;

    /* renamed from: P */
    private List<OdPoint> f27479P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public TrafficLineDelegate f27480Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public int f27481R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public LatLng f27482S;

    /* renamed from: T */
    private int f27483T;

    /* renamed from: U */
    private OrderRouteEngineResPack f27484U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public RouteGuidanceGPSPoint f27485V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public OmegaReportManager f27486W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public List<MockMovementInfo.SctxAnimData> f27487X = new ArrayList();

    /* renamed from: Y */
    private Handler f27488Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public LatLng f27489Z;

    /* renamed from: aa */
    private List<LatLng> f27490aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public List<LatLng> f27491ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public SctxDataCache f27492ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f27493ad = -2;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public Set<Integer> f27494ae;

    /* renamed from: af */
    private DIDILocationListener f27495af;

    /* renamed from: ag */
    private int f27496ag = -1;

    /* renamed from: ah */
    private BroadcastReceiver f27497ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public long f27498ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public TrafficLineDelegate f27499aj;

    /* renamed from: ak */
    private SecRouteInfo f27500ak;

    /* renamed from: al */
    private int f27501al = 0;

    /* renamed from: am */
    private OnLineClickListener f27502am;

    /* renamed from: an */
    private boolean f27503an = true;

    /* renamed from: ao */
    private boolean f27504ao = true;

    /* renamed from: ap */
    private WorkManager f27505ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public float f27506aq = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f27507ar;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ISctxViewDelegate f27508u;

    /* renamed from: v */
    private long f27509v;

    /* renamed from: w */
    private EtaEdaChangeTracker f27510w;

    /* renamed from: x */
    private int f27511x;

    /* renamed from: y */
    private int f27512y;

    /* renamed from: z */
    private long f27513z;

    /* renamed from: M */
    private boolean m19490M() {
        return false;
    }

    /* renamed from: s */
    static /* synthetic */ int m19573s(PassengerSctxServiceImp passengerSctxServiceImp) {
        int i = passengerSctxServiceImp.f27464A;
        passengerSctxServiceImp.f27464A = i + 1;
        return i;
    }

    public PassengerSctxServiceImp(SctxTripParam sctxTripParam) {
        super(sctxTripParam);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        m19546f();
        m19559l();
        m19502a();
        m19550h();
        m19552i();
        m19555j();
        m19557k();
        m19473D();
        m19549g();
        m19469B();
        if (this.f27373e.getTripState() == 3) {
            m19527b();
            m19543e();
            m19482I();
        }
        m19508a(this.f27373e.getPickupPoint(), this.f27373e.getEndPoint());
    }

    /* renamed from: a */
    private void m19502a() {
        this.f27379k.setReportCallback(new RuntimeErrorCollect.ReportCallback() {
            public void reportError(String str) {
                PassengerSctxServiceImp.this.f27486W.reportSctxErrorCode(str);
            }
        });
    }

    /* renamed from: b */
    private void m19527b() {
        this.f27495af = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locationSwitchLevel = Utils.getLocationSwitchLevel(PassengerSctxServiceImp.this.f27370b);
                if (PassengerSctxServiceImp.this.f27493ad != locationSwitchLevel) {
                    if (PassengerSctxServiceImp.this.f27493ad != -2) {
                        PassengerSctxServiceImp.this.f27486W.trackPhoneLocationType(PassengerSctxServiceImp.this.f27493ad, locationSwitchLevel);
                    }
                    int unused = PassengerSctxServiceImp.this.f27493ad = locationSwitchLevel;
                }
                PassengerSctxServiceImp.this.m19539d();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (PassengerSctxServiceImp.this.f27494ae == null) {
                    Set unused = PassengerSctxServiceImp.this.f27494ae = new HashSet();
                }
                if (PassengerSctxServiceImp.this.f27494ae.size() == 0) {
                    long unused2 = PassengerSctxServiceImp.this.f27498ai = System.currentTimeMillis();
                }
                PassengerSctxServiceImp.this.f27494ae.add(Integer.valueOf(errInfo.getErrNo()));
            }
        };
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f27370b);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("PassengerSctx");
            defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this.f27495af);
            instance.requestLocationUpdates(this.f27495af, defaultLocationUpdateOption);
        }
    }

    /* renamed from: c */
    private void m19533c() {
        if (this.f27369a != null && this.f27502am == null) {
            this.f27502am = new OnLineClickListener() {
                public void onLineClick(Line line) {
                    if (PassengerSctxServiceImp.this.f27480Q != null && PassengerSctxServiceImp.this.f27499aj != null) {
                        List<Line> lines = PassengerSctxServiceImp.this.f27480Q.getLines();
                        List<Line> lines2 = PassengerSctxServiceImp.this.f27499aj.getLines();
                        if (!CollectionUtil.isEmpty((Collection<?>) lines) && !CollectionUtil.isEmpty((Collection<?>) lines2)) {
                            if (lines.contains(line)) {
                                PassengerSctxServiceImp.this.chooseLine(1);
                            } else if (lines2.contains(line)) {
                                PassengerSctxServiceImp.this.chooseLine(2);
                            }
                        }
                    }
                }
            };
            this.f27369a.addOnLineClickListener(this.f27502am);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19539d() {
        Set<Integer> set = this.f27494ae;
        if (set != null && !set.isEmpty()) {
            this.f27486W.trackLocationErrorInfos(this.f27498ai, this.f27494ae);
            this.f27494ae.clear();
            this.f27498ai = 0;
        }
    }

    /* renamed from: e */
    private void m19543e() {
        this.f27497ah = new BroadcastReceiver() {
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
                    com.didi.map.global.sctx.PassengerSctxServiceImp r6 = com.didi.map.global.sctx.PassengerSctxServiceImp.this
                    com.didi.map.google.manager.OmegaReportManager r6 = r6.f27486W
                    r6.trackScreenState(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceImp.C98054.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            this.f27370b.registerReceiver(this.f27497ah, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m19546f() {
        this.f27492ac = new SctxDataCache();
        this.f27484U = new OrderRouteEngineResPack();
        this.f27510w = new EtaEdaChangeTracker(m19583x());
        this.f27467D = new ArrayList<>();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f27469F = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f27479P = new ArrayList();
        this.f27508u = new SctxViewImpl(this.f27370b, this.f27369a, this.f27466C, this.f27377i);
    }

    /* renamed from: g */
    private void m19549g() {
        this.f27470G = new MatchPointDisHandler();
    }

    /* renamed from: h */
    private void m19550h() {
        InertiaEngine create = InertiaEngine.create(this.f27370b);
        this.f27465B = create;
        create.setPredictionApolloParams(this.f27376h.getSctxPredictionParams());
        this.f27465B.setSimulateEvaluateCallback(this.f27486W.getSimulateCallback());
        this.f27465B.setOrderInfo(this.f27373e.getOrderId(), this.f27373e.getTripState() == 3 ? this.f27373e.isArrivedPickupPoint() ? 1 : 0 : 2);
        this.f27465B.setOnLocationMatched(new OnLocationMatched() {
            public void onOffRoute() {
            }

            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
                if (i >= 0 && !z) {
                    RouteGuidanceGPSPoint unused = PassengerSctxServiceImp.this.f27469F = ConvertUtil.tran2RouteGuidanceGPSPointWithLatLng(latLng, 0);
                    PassengerSctxServiceImp.this.f27469F.shapeOffSet = i2;
                    PassengerSctxServiceImp.this.f27469F.segmentIndex = i;
                }
                PassengerSctxServiceImp.this.f27372d.onMatched(latLng);
                DLog.m7384d(PassengerSctxServiceImp.f27461r, "onMatched - point:" + latLng.toString() + ", segmentIndex:" + i + ", shapeOffset:" + i2 + ", distanceOffset:" + i3 + ", timeoffsett:" + i4 + ", isSimulate:" + z, new Object[0]);
                PassengerSctxServiceImp.this.m19561m();
                CarIconsPreloader.getInstance().preloadCarIcons(i);
                if (!z) {
                    PassengerSctxServiceImp.this.m19563n();
                    DLog.m7384d(PassengerSctxServiceImp.f27461r, "onMatched - 非惯导, mShowEta:" + PassengerSctxServiceImp.this.f27475L + " / mShowDistance:" + PassengerSctxServiceImp.this.f27477N + "显示的均为后台下发值", new Object[0]);
                } else {
                    PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                    int unused2 = passengerSctxServiceImp.f27474K = passengerSctxServiceImp.f27474K + i3;
                    PassengerSctxServiceImp passengerSctxServiceImp2 = PassengerSctxServiceImp.this;
                    long unused3 = passengerSctxServiceImp2.f27473J = passengerSctxServiceImp2.f27473J + ((long) i4);
                    DLog.m7384d(PassengerSctxServiceImp.f27461r, "onMatched - 惯导累积, mACCMockDistance:" + PassengerSctxServiceImp.this.f27474K + ", mACCMockTime:" + PassengerSctxServiceImp.this.f27473J, new Object[0]);
                    if (PassengerSctxServiceImp.this.f27475L <= 0 && PassengerSctxServiceImp.this.f27477N <= 0) {
                        PassengerSctxServiceImp passengerSctxServiceImp3 = PassengerSctxServiceImp.this;
                        int unused4 = passengerSctxServiceImp3.f27475L = passengerSctxServiceImp3.f27471H;
                        PassengerSctxServiceImp passengerSctxServiceImp4 = PassengerSctxServiceImp.this;
                        int unused5 = passengerSctxServiceImp4.f27476M = passengerSctxServiceImp4.f27471H * 60;
                        PassengerSctxServiceImp passengerSctxServiceImp5 = PassengerSctxServiceImp.this;
                        int unused6 = passengerSctxServiceImp5.f27477N = passengerSctxServiceImp5.f27472I;
                    }
                    PassengerSctxServiceImp passengerSctxServiceImp6 = PassengerSctxServiceImp.this;
                    int unused7 = passengerSctxServiceImp6.f27476M = passengerSctxServiceImp6.f27476M - i4;
                    PassengerSctxServiceImp passengerSctxServiceImp7 = PassengerSctxServiceImp.this;
                    int unused8 = passengerSctxServiceImp7.f27475L = passengerSctxServiceImp7.f27476M / 60;
                    PassengerSctxServiceImp passengerSctxServiceImp8 = PassengerSctxServiceImp.this;
                    int unused9 = passengerSctxServiceImp8.f27477N = passengerSctxServiceImp8.f27477N - i3;
                    DLog.m7384d(PassengerSctxServiceImp.f27461r, "onMatched - 惯导, mShowEta:" + PassengerSctxServiceImp.this.f27475L + "mShowEtaSeconds:" + PassengerSctxServiceImp.this.f27476M + " / mShowDistance:" + PassengerSctxServiceImp.this.f27477N + "显示的与后台下发值不一定一样: mEta:" + PassengerSctxServiceImp.this.f27471H + " / mDistance:" + PassengerSctxServiceImp.this.f27472I, new Object[0]);
                }
                if (PassengerSctxServiceImp.this.f27508u.getCarMarker() == null) {
                    PassengerSctxServiceImp passengerSctxServiceImp9 = PassengerSctxServiceImp.this;
                    passengerSctxServiceImp9.m19507a(latLng, passengerSctxServiceImp9.f27506aq == -1.0f ? 0.0f : PassengerSctxServiceImp.this.f27506aq);
                }
                if (!PassengerSctxServiceImp.this.m19521a(false)) {
                    if (i < 0) {
                        PassengerSctxServiceImp.m19573s(PassengerSctxServiceImp.this);
                        if (PassengerSctxServiceImp.this.f27464A < 3) {
                            DLog.m7384d(PassengerSctxServiceImp.f27461r, "[不满足惯导条件(sctx2.0效果)] 当前连续绑线失败次数:" + PassengerSctxServiceImp.this.f27464A + ",不足" + 3 + "次，不做动画", new Object[0]);
                            return;
                        }
                    } else {
                        int unused10 = PassengerSctxServiceImp.this.f27464A = 0;
                    }
                }
                PassengerSctxServiceImp.this.f27466C.animateTo(new AnimateNode(latLng, i, i2, true));
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (sctxStateInfo != null && sctxStateInfo.getState() != null && PassengerSctxServiceImp.this.m19521a(false)) {
                    DLog.m7384d(PassengerSctxServiceImp.f27461r, "onUpdateSctxState:" + sctxStateInfo.getState().type, new Object[0]);
                    PassengerSctxServiceImp.this.f27486W.onReceiveSctxState(PassengerSctxServiceImp.this.f27373e.getOrderId(), sctxStateInfo);
                    if (PassengerSctxServiceImp.this.f27372d != null) {
                        PassengerSctxServiceImp.this.f27372d.onSctxStateUpdate(sctxStateInfo);
                    }
                }
            }

            public void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
                if (!PassengerSctxServiceImp.this.f27378j.isEnable()) {
                    return;
                }
                if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR) {
                    PassengerSctxServiceImp.this.f27378j.recordJumpCode(SctxCaseCode.INERTIA_DRIVER_TOO_FAR);
                } else if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL) {
                    PassengerSctxServiceImp.this.f27378j.recordJumpCode(SctxCaseCode.INERTIA_MATCH_FAIL);
                }
            }
        });
    }

    /* renamed from: i */
    private void m19552i() {
        IMyLocationDelegate create = MyLocation.create(this.f27369a);
        this.f27466C = create;
        create.setIsPassenger(true);
        this.f27466C.setCarAnimationListener(new onCarAnimationListener() {
            public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                List unused = PassengerSctxServiceImp.this.f27491ab = list2;
                PassengerSctxServiceImp.this.m19517a(list, list2);
            }

            public void onErase(List<LatLng> list) {
                PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                passengerSctxServiceImp.m19517a(list, (List<LatLng>) passengerSctxServiceImp.f27491ab);
            }

            public void onErase(int i, int i2, LatLng latLng) {
                if (i != PassengerSctxServiceImp.this.f27481R || latLng == null || !latLng.equals(PassengerSctxServiceImp.this.f27482S)) {
                    if (PassengerSctxServiceImp.this.f27480Q != null && !PassengerSctxServiceImp.this.f27478O) {
                        PassengerSctxServiceImp.this.f27480Q.erase(i, latLng);
                        PassengerSctxServiceImp.this.m19504a(i, latLng);
                    }
                    int unused = PassengerSctxServiceImp.this.f27481R = i;
                    LatLng unused2 = PassengerSctxServiceImp.this.f27482S = latLng;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19504a(int i, LatLng latLng) {
        TrafficLineDelegate trafficLineDelegate;
        ArrayList<LatLng> arrayList = this.f27467D;
        List<LatLng> list = this.f27468E;
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27499aj != null) {
            int size = arrayList.size();
            int size2 = list.size();
            int i2 = this.f27481R;
            DLog.m7384d(f27461r, "sec points size :" + size2 + "cur points size: " + size + "lastEraseIndex: " + i2 + "segmentIndex: " + i, new Object[0]);
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
                m19505a(i3, list.get(i3), (List<LatLng>) arrayList, list);
            } else if (arrayList.size() > i && size2 > i) {
                int i4 = size2 - 1;
                if (i == i4) {
                    latLng = list.get(i4);
                }
                m19505a(i, latLng, (List<LatLng>) arrayList, list);
            }
            if (this.f27483T > size2 - 3 && (trafficLineDelegate = this.f27499aj) != null && trafficLineDelegate != null) {
                trafficLineDelegate.remove();
                this.f27499aj = null;
                if (this.f27372d != null) {
                    this.f27372d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m19505a(int i, LatLng latLng, List<LatLng> list, List<LatLng> list2) {
        if (DDSphericalUtil.computeDistanceBetween(list.get(i), list2.get(i)) > 5.0d) {
            DLog.m7384d(f27461r, "not eraseSecLine, distance > 5m", new Object[0]);
        } else if (list2.size() > i) {
            this.f27499aj.erase(i, latLng);
            this.f27483T = i;
            DLog.m7384d(f27461r, "eraseSecLine, mSecLastEraseIndex: " + this.f27483T, new Object[0]);
        } else {
            DLog.m7384d(f27461r, "not eraseSecLine, distance < 5m...", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19517a(List<LatLng> list, List<LatLng> list2) {
        if (this.f27492ac.enableDrawLine) {
            this.f27490aa = new ArrayList(list);
            if (list2 != null && list2.size() > 1) {
                this.f27490aa.addAll(list2.subList(1, list2.size()));
            }
        }
    }

    /* renamed from: j */
    private void m19555j() {
        ISctxViewDelegate iSctxViewDelegate = this.f27508u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.setLocationDelegate(this.f27466C);
            this.f27508u.set3DCarEnabled(this.f27373e.isIs3DEnabled());
            this.f27508u.set3DCarIcons(this.f27373e.getCar3DIcons());
            this.f27508u.setCarMarkerBitmap(this.f27373e.getCarBitmapDescriptor());
            this.f27508u.setCarMarkerZIndex(this.f27373e.getzIndex());
        }
    }

    /* renamed from: k */
    private void m19557k() {
        if (this.f27373e.getVamosExpansionParam() != null) {
            this.f27492ac.vamosDriverTripDestPoint = this.f27373e.getVamosExpansionParam().driverTripDestPoint;
        }
        this.f27492ac.orderPickupPoint = this.f27373e.getPickupPoint();
        this.f27492ac.orderDestPoint = this.f27373e.getEndPoint();
        this.f27509v = checkInterval(this.f27373e.getOraRequestInterval());
        m19565o();
        if (this.f27373e.isArrivedPickupPoint()) {
            m19512a(this.f27480Q);
            this.f27492ac.enableDrawLine = false;
        }
        if (this.f27373e.getWayPoints() != null) {
            setWayPoints(this.f27373e.getWayPoints(), this.f27373e.getWayPointsTimestamp());
        }
    }

    /* renamed from: l */
    private void m19559l() {
        this.f27486W = new OmegaReportManager(new OmegaReportManager.SctxReportGetter() {
            public String getUid() {
                return PassengerSctxServiceImp.this.m19578v();
            }

            public String getOrderId() {
                return PassengerSctxServiceImp.this.f27373e.getOrderId();
            }

            public int getOrderState() {
                return PassengerSctxServiceImp.this.f27373e.getTripState();
            }

            public int getProductId() {
                return PassengerSctxServiceImp.this.f27373e.getBizType();
            }

            public String getRole() {
                return PassengerSctxServiceImp.this.m19581w();
            }

            public String getPageReferrer() {
                return PassengerSctxServiceImp.this.m19583x();
            }

            public RouteGuidanceGPSPoint getOriginDriverPoint() {
                return PassengerSctxServiceImp.this.f27485V;
            }

            public int getDriverMatchEda() {
                int i;
                int i2;
                RouteGuidanceGPSPoint g = PassengerSctxServiceImp.this.f27469F;
                int i3 = -1;
                if (g == null) {
                    return -1;
                }
                int distanceToTail = PassengerSctxServiceImp.this.f27470G != null ? PassengerSctxServiceImp.this.f27470G.distanceToTail(g) : -1;
                if (PassengerSctxServiceImp.this.f27465B != null) {
                    i2 = PassengerSctxServiceImp.this.f27465B.distanceLeft();
                    i = PassengerSctxServiceImp.this.f27465B.distanceLeft(g);
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (ApolloUtils.newEdaCalculator() && PassengerSctxServiceImp.this.f27470G != null) {
                    i3 = distanceToTail;
                } else if (PassengerSctxServiceImp.this.f27465B != null) {
                    i3 = i2;
                }
                DLog.m7384d("eda_log", "DriverMatchEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|CurDriverEda:" + i3 + "|OldEda:" + i2 + "|oldEdaParam:" + i + "|NewEda:" + distanceToTail + "|segmentIndex:" + g.segmentIndex, new Object[0]);
                return i3;
            }

            public int getCarAnimEda() {
                return BizUtil.animDistanceLeft(PassengerSctxServiceImp.this.f27466C, PassengerSctxServiceImp.this.f27465B);
            }

            public List<MockMovementInfo.SctxAnimData> getSctxAnimDataList() {
                ArrayList arrayList = new ArrayList(PassengerSctxServiceImp.this.f27487X);
                PassengerSctxServiceImp.this.f27487X.clear();
                return arrayList;
            }

            public boolean isSplitAccounts() {
                return PassengerSctxServiceImp.this.f27373e.isReadOnly();
            }

            public CarMarker getDriverMarker() {
                return PassengerSctxServiceImp.this.getCarMarker();
            }

            public boolean isArrived() {
                return PassengerSctxServiceImp.this.f27373e.isArrivedPickupPoint();
            }

            public boolean isSimulateEtaEdaLimit(boolean z) {
                return PassengerSctxServiceImp.this.m19531b(z);
            }

            public List<LatLng> getSctxRoutePoints() {
                return PassengerSctxServiceImp.this.f27467D;
            }

            public double getMaxMockDistance() {
                return (double) PassengerSctxServiceImp.this.f27376h.getMaxMockDistance(PassengerSctxServiceImp.this.f27465B.getMatchPointType());
            }

            public long getMaxMockTime() {
                return PassengerSctxServiceImp.this.f27376h.getMaxMockTime(PassengerSctxServiceImp.this.f27465B.getMatchPointType());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m19561m() {
        if (m19584y()) {
            this.f27486W.doOmegaOnCarDelayed(this.f27373e.getBizType(), m19581w(), this.f27376h.getSctxPredictionEnable(), this.f27492ac.lastReceiveRouteTime, this.f27466C, this.f27465B);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m19563n() {
        DLog.m7384d(f27461r, "resetEtaEda", new Object[0]);
        this.f27474K = 0;
        this.f27473J = 0;
        int i = this.f27471H;
        this.f27475L = i;
        this.f27476M = i * 60;
        this.f27477N = this.f27472I;
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f27508u.setCarMarkerBitmap(bitmapDescriptor);
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        return this.f27508u.refresh3DCarIcons(z, list);
    }

    public void setOraRequestInterval(long j) {
        long checkInterval = checkInterval(j);
        long j2 = this.f27509v;
        if (checkInterval != j2) {
            DLog.m7384d(f27461r, "setOraRequestInterval :%s -> %s", Long.valueOf(j2), Long.valueOf(checkInterval));
            this.f27509v = checkInterval;
            m19565o();
            refreshSyncInterval();
        }
    }

    /* renamed from: o */
    private void m19565o() {
        IInertiaDelegate iInertiaDelegate = this.f27465B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.setRequestIntervalInMills((int) this.f27509v);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27466C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setAnimationInterval((int) this.f27509v);
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return this.f27509v;
    }

    /* renamed from: a */
    private void m19516a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list, List<TrafficItem> list2) {
        DLog.m7384d(f27461r, "setOrderRouteResponse...", new Object[0]);
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
        if (!CollectionUtil.isEmpty((Collection<?>) latLngListFromDiffGeoPoints) || CollectionUtil.isEmpty((Collection<?>) list)) {
            list = latLngListFromDiffGeoPoints;
        }
        float f = 0.0f;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            if (mapPassengeOrderRouteRes.direction != null) {
                f = (float) mapPassengeOrderRouteRes.direction.intValue();
            }
            this.f27506aq = f;
        } else {
            if (list.size() > 1) {
                f = (float) DDSphericalUtil.computeHeading(list.get(0), list.get(1));
            } else if (mapPassengeOrderRouteRes.direction != null) {
                f = (float) mapPassengeOrderRouteRes.direction.intValue();
            }
            this.f27506aq = f;
        }
        if (!this.f27381m) {
            m19529b(mapPassengeOrderRouteRes, list, list2);
        }
    }

    /* renamed from: b */
    private void m19529b(final MapPassengeOrderRouteRes mapPassengeOrderRouteRes, final List<LatLng> list, final List<TrafficItem> list2) {
        if (this.f27492ac.isExtendedAnimating) {
            DLog.m7384d(f27461r, "bIsExtendedAnimating, return", new Object[0]);
        } else if (!m19567p() || !this.f27492ac.isFirstRecvRoutes) {
            m19536c(mapPassengeOrderRouteRes, list, list2);
        } else if (mapPassengeOrderRouteRes == null || mapPassengeOrderRouteRes.secRouteInfo == null) {
            this.f27492ac.isFirstRecvRoutes = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                m19536c(mapPassengeOrderRouteRes, list, list2);
                return;
            }
            if (this.f27467D.isEmpty()) {
                this.f27467D.addAll(list);
            }
            TrafficLineAnimatorOptions trafficLineAnimatorOptions = new TrafficLineAnimatorOptions();
            trafficLineAnimatorOptions.duration = getRouteExtensionAnimationDuration();
            trafficLineAnimatorOptions.animatorListener = new TrafficLineAnimatorOptions.TrafficLineAnimatorListener() {
                public void onStart() {
                    PassengerSctxServiceImp.this.f27492ac.isExtendedAnimating = true;
                    if (PassengerSctxServiceImp.this.f27372d != null) {
                        PassengerSctxServiceImp.this.f27372d.onRouteAnimationStart();
                    }
                }

                public void onEnd() {
                    PassengerSctxServiceImp.this.f27492ac.isExtendedAnimating = false;
                    if (PassengerSctxServiceImp.this.f27372d != null) {
                        PassengerSctxServiceImp.this.f27372d.onRouteAnimationEnd();
                    }
                    if (!PassengerSctxServiceImp.this.m19536c(mapPassengeOrderRouteRes, list, list2)) {
                        PassengerSctxServiceImp.this.m19507a((LatLng) list.get(0), list.size() > 1 ? (float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1)) : mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue());
                    }
                }
            };
            m19512a(this.f27480Q);
            this.f27480Q = new TrafficLineDelegate();
            List<TrafficItem> list3 = mapPassengeOrderRouteRes.traffic;
            m19514a(this.f27480Q, list, (!CollectionUtil.isEmpty((Collection<?>) list3) || CollectionUtil.isEmpty((Collection<?>) list2)) ? list3 : list2, trafficLineAnimatorOptions, false, false);
        } else {
            m19536c(mapPassengeOrderRouteRes, list, list2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19507a(LatLng latLng, float f) {
        ISctxViewDelegate iSctxViewDelegate;
        if (latLng != null && (iSctxViewDelegate = this.f27508u) != null) {
            iSctxViewDelegate.updateCarMarker(latLng);
            this.f27508u.updateCarDirection(f);
        }
    }

    /* renamed from: a */
    private void m19515a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        this.f27484U.parseFrom(mapPassengeOrderRouteRes);
        boolean z = true;
        this.f27478O = !this.f27484U.lineVisible;
        SctxDataCache sctxDataCache = this.f27492ac;
        if (!this.f27484U.lineVisible || this.f27373e.isArrivedPickupPoint()) {
            z = false;
        }
        sctxDataCache.enableDrawLine = z;
    }

    /* renamed from: p */
    private boolean m19567p() {
        return this.f27492ac.enableDrawLine && this.f27373e.isShowExtendedAnimation() && m19584y();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m19536c(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list, List<TrafficItem> list2) {
        int i;
        int i2;
        MapPassengeOrderRouteRes mapPassengeOrderRouteRes2 = mapPassengeOrderRouteRes;
        List<LatLng> list3 = list;
        this.f27492ac.isRouteChanged = false;
        if (mapPassengeOrderRouteRes2.logId == null) {
            DLog.m7384d(f27461r, "res.logId == null", new Object[0]);
        } else if (this.f27513z > mapPassengeOrderRouteRes2.logId.longValue()) {
            DLog.m7384d(f27461r, "mResLogId:%d > res.logId:%d, return", Long.valueOf(this.f27513z), mapPassengeOrderRouteRes2.logId);
            return false;
        } else {
            this.f27513z = mapPassengeOrderRouteRes2.logId.longValue();
        }
        if (this.f27372d != null) {
            if (this.f27373e.isReadOnly() && !CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f27372d.onStartDestinationUpdate(list3.get(0), list3.get(list.size() - 1));
            }
            if (mapPassengeOrderRouteRes2.ret != null) {
                if (mapPassengeOrderRouteRes2.ret.intValue() == 33333) {
                    this.f27372d.onWayPointsStateUpdate(true, (List<OdPoint>) null);
                } else if (mapPassengeOrderRouteRes2.ret.intValue() == 0) {
                    this.f27372d.onWayPointsStateUpdate(false, this.f27479P);
                    this.f27372d.onWayPointsStateUpdateForMiniBus(CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes2.odPoints) ? new ArrayList() : mapPassengeOrderRouteRes2.odPoints);
                }
            }
        }
        if (mapPassengeOrderRouteRes2.eta != null && mapPassengeOrderRouteRes2.eta.intValue() >= 0) {
            this.f27471H = mapPassengeOrderRouteRes2.eta.intValue();
            DLog.m7384d(f27461r, "res.eta:" + mapPassengeOrderRouteRes2.eta, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.distance != null && mapPassengeOrderRouteRes2.distance.intValue() >= 0) {
            this.f27472I = mapPassengeOrderRouteRes2.distance.intValue();
            DLog.m7384d(f27461r, "res.distance:" + mapPassengeOrderRouteRes2.distance, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue())) {
            DLog.m7384d(f27461r, "res.driverPoint is error", new Object[0]);
            this.f27377i.setDriverError(3);
            this.f27379k.setErrorCode(202);
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
        DLog.m7384d(f27461r, "server返回的司机定位:%s，方向:%d", objArr);
        DoublePoint doublePoint = mapPassengeOrderRouteRes2.driverPoint;
        if (mapPassengeOrderRouteRes2.direction == null) {
            i2 = 0;
        } else {
            i2 = mapPassengeOrderRouteRes2.direction.intValue();
        }
        RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint = ConvertUtil.tran2RouteGuidanceGPSPoint(doublePoint, i2);
        this.f27485V = tran2RouteGuidanceGPSPoint;
        IInertiaDelegate iInertiaDelegate = this.f27465B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.onRecvDriverLocation(tran2RouteGuidanceGPSPoint);
        }
        float f = 0.0f;
        if (this.f27478O) {
            m19512a(this.f27480Q);
            if (this.f27508u.getCarMarker() == null) {
                m19507a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
            }
        }
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(list.size());
            objArr2[1] = Long.valueOf(this.f27382n);
            objArr2[2] = Long.valueOf(mapPassengeOrderRouteRes2.routeId == null ? 0 : mapPassengeOrderRouteRes2.routeId.longValue());
            DLog.m7384d(f27461r, "server返回了路线，路线点集个数:%d，重新画线，routeId:[%d -> %d]", objArr2);
            if (hasLine() && mapPassengeOrderRouteRes2.routeId != null && mapPassengeOrderRouteRes2.routeId.longValue() == this.f27382n && list.size() == this.f27467D.size() && m19493a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex) == this.f27383o) {
                DLog.m7384d(f27461r, "后台返回了跟上次一样的routeId，但也返回了路线(按理不该返回)，这里就不再刷新路线", new Object[0]);
                m19569q();
            } else {
                this.f27492ac.isRouteChanged = true;
                this.f27492ac.routePoints = list3;
                this.f27492ac.trafficItems = mapPassengeOrderRouteRes2.traffic;
                final MapPassengeOrderRouteRes mapPassengeOrderRouteRes3 = mapPassengeOrderRouteRes;
                final List<LatLng> list4 = list;
                final List<TrafficItem> list5 = list2;
                final LatLng latLng2 = latLng;
                this.f27466C.animateCancel(new onCarAnimationCancelListener() {
                    public void onCancel() {
                        float f;
                        int i = 0;
                        DLog.m7384d(PassengerSctxServiceImp.f27461r, "onCarAnimationCancelListener onCancel() callback", new Object[0]);
                        long j = 0;
                        if (mapPassengeOrderRouteRes3.routeId == null) {
                            PassengerSctxServiceImp.this.f27382n = 0;
                            PassengerSctxServiceImp.this.f27383o = 0;
                        } else {
                            if (PassengerSctxServiceImp.this.m19584y() && PassengerSctxServiceImp.this.f27382n > 0 && PassengerSctxServiceImp.this.getCarMarker() != null) {
                                float computeHeading = (float) DDSphericalUtil.computeHeading(PassengerSctxServiceImp.this.getCarMarker().getPosition(), (LatLng) list4.get(0));
                                if (!(PassengerSctxServiceImp.this.f27465B == null || PassengerSctxServiceImp.this.f27465B.getLastMatchGPSPoint() == null)) {
                                    j = PassengerSctxServiceImp.this.f27465B.getLastMatchGPSPoint().timestamp;
                                }
                                GoogleSyncTripOmegaUtil.map_pax_car_jump(PassengerSctxServiceImp.this.m19578v(), PassengerSctxServiceImp.this.f27373e.getOrderId(), PassengerSctxServiceImp.this.f27373e.getTripState(), PassengerSctxServiceImp.this.f27373e.isArrivedPickupPoint(), computeHeading, !PassengerSctxServiceImp.this.f27478O ? 1 : 0, PassengerSctxServiceImp.this.getCarMarker().getPosition(), j, (LatLng) list4.get(0), mapPassengeOrderRouteRes3.driverPoint.gpsTimestamp.longValue(), PassengerSctxServiceImp.this.f27373e.getBizType(), PassengerSctxServiceImp.this.m19581w(), PassengerSctxServiceImp.this.m19583x());
                            }
                            PassengerSctxServiceImp.this.f27382n = mapPassengeOrderRouteRes3.routeId.longValue();
                            PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                            passengerSctxServiceImp.f27383o = passengerSctxServiceImp.m19493a(mapPassengeOrderRouteRes3.curDstRouteGeoIndex);
                        }
                        if (!CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes3.traffic) || CollectionUtil.isEmpty((Collection<?>) list5)) {
                            PassengerSctxServiceImp passengerSctxServiceImp2 = PassengerSctxServiceImp.this;
                            MapPassengeOrderRouteRes mapPassengeOrderRouteRes = mapPassengeOrderRouteRes3;
                            passengerSctxServiceImp2.m19540d(mapPassengeOrderRouteRes, list4, mapPassengeOrderRouteRes.traffic);
                        } else {
                            PassengerSctxServiceImp.this.m19540d(mapPassengeOrderRouteRes3, list4, list5);
                        }
                        PassengerSctxServiceImp.this.f27492ac.lastReceiveRouteTime = System.currentTimeMillis();
                        CarIconsPreloader.getInstance().setRoutePoints(PassengerSctxServiceImp.this.f27369a.getContext(), list4);
                        RouteGuidanceGPSPoint unused = PassengerSctxServiceImp.this.f27469F = new RouteGuidanceGPSPoint();
                        PassengerSctxServiceImp.this.f27469F.segmentIndex = -1;
                        PassengerSctxServiceImp.this.f27466C.setNavRoutePoints(list4, false);
                        if (PassengerSctxServiceImp.this.f27465B != null) {
                            if (PassengerSctxServiceImp.this.f27383o > 0) {
                                PassengerSctxServiceImp.this.f27465B.setRoutePoints(list4, PassengerSctxServiceImp.this.f27383o, PassengerSctxServiceImp.this.m19521a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceImp.this.f27470G.setRoutePoints(list4, PassengerSctxServiceImp.this.f27383o);
                                }
                            } else {
                                PassengerSctxServiceImp.this.f27465B.setRoutePoints((List<LatLng>) list4, PassengerSctxServiceImp.this.m19521a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceImp.this.f27470G.setRoutePoints(list4);
                                }
                            }
                        }
                        PassengerSctxServiceImp.this.m19569q();
                        if (PassengerSctxServiceImp.this.f27508u.getCarMarker() != null) {
                            return;
                        }
                        if (!PassengerSctxServiceImp.this.f27373e.isArrivedPickupPoint()) {
                            PassengerSctxServiceImp passengerSctxServiceImp3 = PassengerSctxServiceImp.this;
                            LatLng latLng = (LatLng) list4.get(0);
                            if (list4.size() > 1) {
                                f = (float) DDSphericalUtil.computeHeading((LatLng) list4.get(0), (LatLng) list4.get(1));
                            } else {
                                if (mapPassengeOrderRouteRes3.direction != null) {
                                    i = mapPassengeOrderRouteRes3.direction.intValue();
                                }
                                f = (float) i;
                            }
                            passengerSctxServiceImp3.m19507a(latLng, f);
                            return;
                        }
                        DLog.m7384d(PassengerSctxServiceImp.f27461r, "司机已到达态下发新路线时，初始让小车显示在真实司机位置%s，非路线第一个点", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng2));
                        PassengerSctxServiceImp.this.m19507a(latLng2, mapPassengeOrderRouteRes3.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes3.direction.intValue());
                    }
                });
            }
            if (!this.f27373e.isReadOnly()) {
                GoogleSyncTripOmegaUtil.com_map_PassengerGetRoute_sw_global(m19578v(), this.f27373e.getOrderId(), this.f27382n, this.f27373e.getTripState(), this.f27373e.isArrivedPickupPoint(), this.f27373e.getCountryId(), this.f27373e.getTripId(), this.f27380l, this.f27373e.getBizType(), m19581w(), m19583x());
            }
        } else {
            m19569q();
            if (this.f27508u.getCarMarker() == null) {
                if (mapPassengeOrderRouteRes2.direction != null) {
                    f = (float) mapPassengeOrderRouteRes2.direction.intValue();
                }
                m19507a(latLng, f);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19493a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m19569q() {
        IInertiaDelegate iInertiaDelegate = this.f27465B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.getMatchPoint(m19571r());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19521a(boolean z) {
        if (!m19584y() || !TextUtils.isEmpty(this.f27373e.getTripId()) || this.f27373e.isReadOnly()) {
            if (z) {
                DLog.m7384d(f27461r, "[getMatchPoint result] 非接驾段 | 拼车 | 分账人 -> 不开启惯导", new Object[0]);
            }
            return false;
        }
        boolean simulateMotionEnable = this.f27376h.getSimulateMotionEnable();
        if (z) {
            DLog.m7384d(f27461r, "[getMatchPoint] 看是否满足惯导条件：", new Object[0]);
            DLog.m7384d(f27461r, "1.总Apollo开关是否打开：%s", Boolean.valueOf(simulateMotionEnable));
        }
        return simulateMotionEnable;
    }

    /* renamed from: r */
    private boolean m19571r() {
        boolean a = m19521a(true);
        if (!a) {
            return a;
        }
        int maxMockDistance = this.f27376h.getMaxMockDistance(this.f27465B.getMatchPointType());
        long maxMockTime = this.f27376h.getMaxMockTime(this.f27465B.getMatchPointType());
        boolean z = this.f27474K < maxMockDistance && this.f27473J < maxMockTime;
        DLog.m7384d(f27461r, "2.累积惯导距离：%d, 累积惯导时间：%d [距离上限：%d, 时间上限:%d]", Integer.valueOf(this.f27474K), Long.valueOf(this.f27473J), Integer.valueOf(maxMockDistance), Long.valueOf(maxMockTime));
        return z ? !m19531b(true) : z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19531b(boolean z) {
        int allowEDA = this.f27376h.getAllowEDA();
        int allowETA = (int) ((this.f27376h.getAllowETA() / 1000) / 60);
        if (this.f27475L > 0 || this.f27477N > 0) {
            if (z) {
                DLog.m7384d(f27461r, "3.mShowDistance：%d, mShowEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27477N), Integer.valueOf(this.f27475L), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
            }
            if (this.f27477N <= allowEDA || this.f27475L <= allowETA) {
                return true;
            }
            return false;
        }
        if (z) {
            DLog.m7384d(f27461r, "3.mDistance：%d, mEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27472I), Integer.valueOf(this.f27471H), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
        }
        if (this.f27472I <= allowEDA || this.f27471H <= allowETA) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m19540d(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes r12, java.util.List<com.didi.common.map.model.LatLng> r13, java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r14) {
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
            java.util.ArrayList<com.didi.common.map.model.LatLng> r0 = r11.f27467D
            r0.clear()
            java.util.ArrayList<com.didi.common.map.model.LatLng> r0 = r11.f27467D
            r0.addAll(r13)
            r11.m19563n()
            com.didi.map.global.sctx.model.SctxDataCache r0 = r11.f27492ac
            boolean r0 = r0.enableDrawLine
            if (r0 == 0) goto L_0x0170
            com.didi.map.global.sctx.model.SctxDataCache r0 = r11.f27492ac
            boolean r0 = r0.isDestModified
            java.lang.String r2 = "PassengerSctxService"
            r3 = 1
            if (r0 == 0) goto L_0x00a4
            int r0 = r13.size()
            int r0 = r0 - r3
            java.lang.Object r0 = r13.get(r0)
            com.didi.common.map.model.LatLng r0 = (com.didi.common.map.model.LatLng) r0
            com.didi.map.global.sctx.model.SctxTripParam r4 = r11.f27373e
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
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r11.f27372d
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r11.f27504ao
            if (r0 != 0) goto L_0x00b8
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r11.f27372d
            r0.goingOffCourse()
        L_0x00b8:
            r11.f27504ao = r1
            r0 = 0
            r11.f27500ak = r0
            r11.f27468E = r0
            boolean r4 = r11.m19490M()
            if (r4 == 0) goto L_0x00f7
            r11.f27483T = r1
            com.didi.map.global.sctx.widget.TrafficLineDelegate r4 = r11.f27499aj
            if (r4 == 0) goto L_0x00d9
            r11.m19512a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r4)
            r11.f27499aj = r0
            com.didi.map.global.sctx.SctxService$SctxCallback r4 = r11.f27372d
            if (r4 == 0) goto L_0x00d9
            com.didi.map.global.sctx.SctxService$SctxCallback r4 = r11.f27372d
            r4.showSecRouteInfoCallback(r0, r1)
        L_0x00d9:
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r12.secRouteInfo
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.proto.driver_gl.Route r0 = r12.route
            if (r0 == 0) goto L_0x00f7
            boolean r0 = com.didi.map.google.util.DUtils.checkSecRouteInfoValid(r12)
            if (r0 == 0) goto L_0x00f7
            r11.f27500ak = r12
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            com.didi.map.sdk.proto.driver_gl.DiffGeoPoints r12 = r12.routePoints
            java.util.List r12 = com.didi.map.google.util.ConvertUtil.getLatLngListFromDiffGeoPoints(r12)
            r11.f27468E = r12
            r10 = 1
            goto L_0x00f8
        L_0x00f7:
            r10 = 0
        L_0x00f8:
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27480Q
            r11.m19512a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r5 = new com.didi.map.global.sctx.widget.TrafficLineDelegate
            r5.<init>()
            r11.f27480Q = r5
            r8 = 0
            r9 = 0
            r4 = r11
            r6 = r13
            r7 = r14
            r4.m19514a(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27480Q
            r11.m19513a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12, (int) r3)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "draw line"
            com.didi.common.map.util.DLog.m7384d(r2, r13, r12)
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f27500ak
            if (r12 == 0) goto L_0x0170
            java.util.List<com.didi.common.map.model.LatLng> r12 = r11.f27468E
            if (r12 == 0) goto L_0x0170
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27499aj
            r11.m19512a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = new com.didi.map.global.sctx.widget.TrafficLineDelegate
            r12.<init>()
            r11.f27499aj = r12
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f27500ak
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            java.lang.Integer r12 = r12.included
            int r12 = r12.intValue()
            if (r12 != r3) goto L_0x013a
            r9 = 1
            goto L_0x013b
        L_0x013a:
            r9 = 0
        L_0x013b:
            com.didi.map.global.sctx.widget.TrafficLineDelegate r5 = r11.f27499aj
            java.util.List<com.didi.common.map.model.LatLng> r6 = r11.f27468E
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f27500ak
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r7 = r12.traffic
            r8 = 0
            r10 = 1
            r4 = r11
            r4.m19514a(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27499aj
            r13 = 2
            r11.m19513a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12, (int) r13)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f27499aj
            r12.highLight(r1)
            r11.m19533c()
            com.didi.map.global.sctx.SctxService$SctxCallback r12 = r11.f27372d
            if (r12 == 0) goto L_0x0169
            com.didi.map.global.sctx.SctxService$SctxCallback r12 = r11.f27372d
            com.didi.map.global.sctx.model.SecRouteInfoEx r13 = new com.didi.map.global.sctx.model.SecRouteInfoEx
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r14 = r11.f27500ak
            r13.<init>(r14)
            r12.showSecRouteInfoCallback(r13, r3)
        L_0x0169:
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "draw sec back line"
            com.didi.common.map.util.DLog.m7384d(r2, r13, r12)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceImp.m19540d(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes, java.util.List, java.util.List):void");
    }

    /* renamed from: a */
    private void m19514a(TrafficLineDelegate trafficLineDelegate, List<LatLng> list, List<TrafficItem> list2, TrafficLineAnimatorOptions trafficLineAnimatorOptions, boolean z, boolean z2) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.setTrafficOptions(m19497a(list, list2, z, z2));
            trafficLineDelegate.addToMap(this.f27369a, trafficLineAnimatorOptions);
        }
    }

    /* renamed from: a */
    private TrafficOptions m19497a(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        if (!MapVendor.DIDI.equals(this.f27369a.getMapVendor()) || !z2 || (ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture())) {
            return m19526b(list, list2, z, z2);
        }
        return m19498a(list, z);
    }

    /* renamed from: a */
    private TrafficOptions m19498a(List<LatLng> list, boolean z) {
        TrafficOptions trafficOptions = new TrafficOptions();
        trafficOptions.lineWidth = (int) TypedValue.applyDimension(1, (float) (z ? 7 : 6), this.f27370b.getResources().getDisplayMetrics());
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
    private TrafficOptions m19526b(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        int i;
        float f;
        TrafficOptions trafficOptions = new TrafficOptions();
        int lineWidth = this.f27373e.getLineWidth();
        if (lineWidth == 0) {
            int i2 = 6;
            if (z) {
                i2 = 7;
            }
            if (this.f27373e.isNewVersion()) {
                f = TypedValue.applyDimension(1, (float) i2, this.f27370b.getResources().getDisplayMetrics());
            } else {
                f = TypedValue.applyDimension(1, 5.0f, this.f27370b.getResources().getDisplayMetrics());
            }
            lineWidth = (int) f;
        }
        trafficOptions.lineWidth = lineWidth;
        trafficOptions.clickable = true;
        trafficOptions.trafficDatas = new ArrayList();
        int lineColor = this.f27373e.getLineColor();
        boolean z3 = false;
        if (list2 == null || list2.size() <= 0 || z2) {
            if (lineColor == 0) {
                if (this.f27373e.isNewVersion()) {
                    lineColor = SctxViewImpl.NEW_LINE_COLOR;
                } else {
                    lineColor = SctxViewImpl.LINE_COLOR;
                }
            }
            trafficOptions.lineColor = lineColor;
            trafficOptions.lineMinorColor = DUtils.crColorBlend(0.1f, trafficOptions.lineColor, SctxViewImpl.MASK_COLOR);
        } else {
            if (lineColor == 0) {
                if (this.f27373e.isNewVersion()) {
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
        if (MapVendor.DIDI.equals(this.f27369a.getMapVendor()) && ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture()) {
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
        return this.f27467D;
    }

    public List<Line> getLines() {
        TrafficLineDelegate trafficLineDelegate = this.f27480Q;
        if (trafficLineDelegate == null) {
            return null;
        }
        return trafficLineDelegate.getLines();
    }

    public List<LatLng> getRemainingRoutePoints() {
        return this.f27490aa;
    }

    /* renamed from: s */
    private int m19572s() {
        if (!this.f27478O) {
            int i = m19584y() ? this.f27475L : this.f27471H;
            if (Math.abs(this.f27511x - i) >= 1) {
                m19503a(i, m19584y() ? this.f27477N : this.f27472I);
                this.f27511x = i;
            }
            return i;
        } else if (this.f27484U.mEta >= 0) {
            DLog.m7384d(f27461r, "bIsHideRoute, eta:" + this.f27484U.mEta, new Object[0]);
            return this.f27484U.mEta;
        } else {
            DLog.m7384d(f27461r, "bIsHideRoute, eta return %d", 1);
            return 1;
        }
    }

    /* renamed from: t */
    private int m19574t() {
        if (!this.f27478O) {
            int i = m19584y() ? this.f27477N : this.f27472I;
            if (Math.abs(this.f27512y - i) >= 100) {
                m19503a(m19584y() ? this.f27475L : this.f27471H, i);
                this.f27512y = i;
            }
            return i;
        } else if (this.f27484U.mDistance >= 0) {
            DLog.m7384d(f27461r, "bIsHideRoute, eda:" + this.f27484U.mDistance, new Object[0]);
            return this.f27484U.mDistance;
        } else {
            DLog.m7384d(f27461r, "bIsHideRoute, eda return %d", 100);
            return 100;
        }
    }

    /* renamed from: u */
    private LatLng m19576u() {
        DoublePoint location = DUtils.getLocation(this.f27370b);
        return location != null ? new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue()) : new LatLng(0.0d, 0.0d);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public String m19578v() {
        return this.f27374f != null ? this.f27374f.getUserId() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public String m19581w() {
        if (!TextUtils.isEmpty(this.f27492ac.userRole)) {
            return this.f27492ac.userRole;
        }
        if (this.f27374f != null) {
            this.f27492ac.userRole = this.f27374f.getUserRole();
        }
        return this.f27492ac.userRole;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public String m19583x() {
        if (this.f27374f != null) {
            return this.f27374f.getPageReferrer();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public boolean m19584y() {
        return this.f27373e.getTripState() == 3 && !this.f27373e.isArrivedPickupPoint();
    }

    /* renamed from: z */
    private boolean m19587z() {
        return this.f27373e.getTripState() == 3 && this.f27373e.isArrivedPickupPoint();
    }

    /* renamed from: A */
    private boolean m19467A() {
        return this.f27373e.getTripState() == 4;
    }

    public double getRemainingRouteDistance() {
        if (!this.f27373e.isArrivedPickupPoint() || getCarMarker() == null) {
            return 0.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(getCarMarker().getPosition(), this.f27373e.getPickupPoint());
    }

    public LatLng getDriverPoint() {
        IInertiaDelegate iInertiaDelegate = this.f27465B;
        if (iInertiaDelegate == null || iInertiaDelegate.getLastMatchGPSPoint() == null || this.f27465B.getLastMatchGPSPoint().segmentIndex == -1) {
            if (getCarMarker() != null) {
                return getCarMarker().getPosition();
            }
            return null;
        } else if (!this.f27376h.getSctxPredictionEnable() || this.f27465B.getLastMatchGPSPoint().originMatchPoint == null) {
            return ConvertUtil.convertFromGeoPoint(this.f27465B.getLastMatchGPSPoint().point);
        } else {
            return ConvertUtil.convertFromGeoPoint(this.f27465B.getLastMatchGPSPoint().originMatchPoint.point);
        }
    }

    public CarMarker getCarMarker() {
        ISctxViewDelegate iSctxViewDelegate = this.f27508u;
        if (iSctxViewDelegate == null) {
            return null;
        }
        return iSctxViewDelegate.getCarMarker();
    }

    public void updateDestination(LatLng latLng) {
        DLog.m7384d(f27461r, "updateDestination...", new Object[0]);
        m19508a(this.f27373e.getPickupPoint(), latLng);
        if (latLng != null) {
            this.f27492ac.orderDestPoint = latLng;
            if (this.f27373e.getTripState() == 4) {
                DLog.m7384d(f27461r, "updateDestination - 送驾段，removeLine", new Object[0]);
                this.f27492ac.isDestModified = true;
                m19512a(this.f27480Q);
            }
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        m19508a(latLng, this.f27373e.getEndPoint());
        if (latLng != null) {
            this.f27501al = 1;
            this.f27492ac.orderPickupPoint = latLng;
            this.f27382n = 0;
            if (this.f27373e.getTripState() == 3) {
                DLog.m7384d(f27461r, "updateDestination - 接驾段，removeLine", new Object[0]);
                m19488L();
                m19481H();
                m19475E();
                m19473D();
                runImmediately();
            }
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        DLog.m7384d(f27461r, "[途经点信息] setOdPoints:%s, odPointsTimestamp:%d", GoogleSyncTripLogUtil.getOdPointsLogInfo(list), Long.valueOf(j));
        this.f27492ac.lastGetWayPointTime = j;
        List<OdPoint> list2 = this.f27479P;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.f27479P.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        if (TextUtils.isEmpty(this.f27373e.getToken())) {
            return null;
        }
        PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
        if (this.f27492ac.orderPickupPoint != null) {
            builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27492ac.orderPickupPoint.latitude)).lng(Float.valueOf((float) this.f27492ac.orderPickupPoint.longitude)).build());
        }
        if (this.f27492ac.orderDestPoint != null) {
            builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27492ac.orderDestPoint.latitude)).lng(Float.valueOf((float) this.f27492ac.orderDestPoint.longitude)).build());
        }
        if (this.f27492ac.vamosDriverTripDestPoint != null) {
            builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27492ac.vamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.f27492ac.vamosDriverTripDestPoint.longitude)).build()).build());
        }
        String str = "google";
        if (!(this.f27369a == null || this.f27369a.getMapVendor() == null)) {
            String mapVendor = this.f27369a.getMapVendor().toString();
            if (!TextUtils.isEmpty(mapVendor) && mapVendor.equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
                str = "didi";
            }
        }
        String str2 = "0";
        PassengerOrderRouteReq.Builder curRouteId = builder.orderId(this.f27373e.getOrderId()).orderStage(Integer.valueOf(this.f27373e.getTripState())).bizType(Integer.valueOf(this.f27373e.getBizType())).travelMode(this.f27373e.getTravelMode()).isNeedTraj(false).version("5").token(this.f27373e.getToken()).phoneNum(TextUtils.isEmpty(this.f27371c) ? str2 : this.f27371c).driverId(Long.valueOf(this.f27373e.getDriverId())).curRouteId(Long.valueOf(this.f27382n));
        if (!TextUtils.isEmpty(this.f27373e.getImei())) {
            str2 = this.f27373e.getImei();
        }
        curRouteId.imei(str2).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f27373e.getClientVersion()).lastOrderId(this.f27373e.getLastOrderId()).noNeedGeo(false).productId(String.valueOf(this.f27373e.getBizType())).countryId(this.f27373e.getCountryId()).sdkmaptype(str).lang(LocaleCodeHolder.getInstance().getCurrentLang()).travelId(this.f27373e.getTripId()).recPPState(Integer.valueOf(this.f27501al)).psgPoint(DUtils.getLocation(this.f27370b)).pushBtMsg(false).bizGroup(Integer.valueOf(this.f27373e.getBizGroup()));
        if (this.f27373e.getTripState() == 4) {
            if (this.f27492ac.lastGetWayPointTime <= 0) {
                DLog.m7384d(f27461r, "mWayPointTimeStamp(%d) <= 0，不传给后台途经点", Long.valueOf(this.f27492ac.lastGetWayPointTime));
            } else {
                builder.odPoints(this.f27479P);
                builder.odPointsTimestamp(Long.valueOf(this.f27492ac.lastGetWayPointTime));
            }
        }
        builder.readOnly(Boolean.valueOf(this.f27373e.isReadOnly()));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
        OmegaReportManager omegaReportManager;
        DLog.m7384d(f27461r, "onSyncStart...", new Object[0]);
        if (this.f27372d != null) {
            this.f27372d.onSyncStart();
        }
        if (!this.f27373e.isReadOnly() && (omegaReportManager = this.f27486W) != null) {
            omegaReportManager.doOmegaReportByTimeInterval();
        }
    }

    /* renamed from: B */
    private void m19469B() {
        if (this.f27373e.getTripState() == 3) {
            this.f27486W.trackOrderLocationPermission(Utils.getLocationSwitchLevel(this.f27370b), m19484J());
        }
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m7384d(f27461r, "onOraResponse...", new Object[0]);
        if (!this.f27380l) {
            if (Config.DEBUG && mapPassengeOrderRouteRes.ret != null && mapPassengeOrderRouteRes.ret.intValue() == 10000) {
                this.f27372d.orderChanged();
            } else if (mapPassengeOrderRouteRes != null) {
                if (mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() != 30076 || this.f27372d == null) {
                    if (!(mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() == 0 || mapPassengeOrderRouteRes.logId == null)) {
                        this.f27486W.trackOrderRouteResultError(mapPassengeOrderRouteRes.ret.intValue(), mapPassengeOrderRouteRes.logId.longValue());
                    }
                    m19515a(mapPassengeOrderRouteRes);
                    if (m19518a(this.f27484U.serverStage) && this.f27372d != null) {
                        this.f27372d.onAbnormalOrderStageCallback(this.f27484U.serverStage);
                        this.f27379k.setErrorCode(203);
                    }
                    if (this.f27484U.serverStage == 5) {
                        this.f27377i.setDriverError(2);
                        this.f27379k.setErrorCode(203);
                        stop();
                        return;
                    }
                    if (!this.f27380l) {
                        this.f27507ar = true;
                    }
                    m19516a(mapPassengeOrderRouteRes, this.f27492ac.routePoints, this.f27492ac.trafficItems);
                    if (this.f27372d != null) {
                        this.f27372d.onSyncSuccess(mapPassengeOrderRouteRes);
                        this.f27372d.onEtaEdaUpdate(new EtaEdaInfo(m19572s(), m19574t(), SXUtils.getLastOrderEda(this.f27373e.getLastOrderId(), mapPassengeOrderRouteRes)));
                        return;
                    }
                    return;
                }
                DLog.m7384d(f27461r, "error code:" + mapPassengeOrderRouteRes.ret, new Object[0]);
                this.f27372d.onAbnormalOrderStageCallback(4);
            }
        }
    }

    /* renamed from: C */
    private double m19470C() {
        LatLng driverPoint = getDriverPoint();
        List<LatLng> routePoints = getRoutePoints();
        return DDSphericalUtil.computeDistanceBetween(driverPoint, routePoints.get(routePoints.size() - 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m19518a(int r5) {
        /*
            r4 = this;
            com.didi.map.global.sctx.model.SctxTripParam r0 = r4.f27373e
            int r0 = r0.getTripState()
            r1 = 0
            if (r5 <= 0) goto L_0x0025
            if (r0 <= 0) goto L_0x0025
            r2 = 3
            r3 = 1
            if (r0 != r2) goto L_0x001f
            com.didi.map.global.sctx.model.SctxTripParam r0 = r4.f27373e
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceImp.m19518a(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
        DLog.m7384d(f27461r, "onOraFail err:%s", str);
        if (this.f27372d != null) {
            this.f27372d.onSyncFail(new Exception(str));
        }
    }

    public void unRegisterSctxCallback(SctxService.SctxCallback sctxCallback) {
        if (sctxCallback == this.f27372d) {
            this.f27372d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPreStart() {
        if (this.f27492ac.isSctxParamUpdated) {
            this.f27492ac.isSctxParamUpdated = false;
            m19477F();
            DLog.m7384d(f27461r, "onPreStart, isSctxParamUpdated is true", new Object[0]);
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        DLog.m7384d(f27461r, "update...", new Object[0]);
        if (sctxTripParam == null || sctxTripParam.equals(this.f27373e)) {
            DLog.m7384d(f27461r, "update,mSctxTripParam is equals.", new Object[0]);
            return;
        }
        stop();
        this.f27492ac.orderId = this.f27373e.getOrderId();
        this.f27492ac.orderState = this.f27373e.getTripState();
        this.f27492ac.isWaitingState = this.f27373e.isArrivedPickupPoint();
        this.f27492ac.isSctxParamUpdated = true;
        initBaseParam(sctxTripParam);
        m19473D();
        if (this.f27373e.getTripState() == 3) {
            m19527b();
            m19543e();
        }
        m19508a(this.f27373e.getPickupPoint(), this.f27373e.getEndPoint());
        start();
    }

    /* renamed from: D */
    private void m19473D() {
        this.f27487X.clear();
        this.f27489Z = null;
        Handler handler = this.f27488Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        } else {
            this.f27488Y = new Handler(Looper.getMainLooper());
        }
        if (this.f27373e != null && !this.f27373e.isArrivedPickupPoint() && this.f27373e.getTripState() == 3) {
            m19506a(1000);
        }
        DLog.m7384d("ccc", "开始记录缓存数据", new Object[0]);
    }

    /* renamed from: E */
    private void m19475E() {
        this.f27487X.clear();
        this.f27489Z = null;
        Handler handler = this.f27488Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27488Y = null;
        }
        DLog.m7384d("ccc", "清除缓存数据", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19506a(long j) {
        this.f27488Y.postDelayed(new Runnable() {
            public void run() {
                if (PassengerSctxServiceImp.this.f27466C == null || PassengerSctxServiceImp.this.getCarMarker() == null) {
                    PassengerSctxServiceImp.this.m19506a(1000);
                    DLog.m7384d("ccc", "未初始化，不缓存轨迹点", new Object[0]);
                } else if (PassengerSctxServiceImp.this.f27384p == 0) {
                    PassengerSctxServiceImp.this.m19506a(1000);
                    DLog.m7384d("ccc", "未可用，不缓存轨迹点", new Object[0]);
                } else if (System.currentTimeMillis() - PassengerSctxServiceImp.this.f27384p < 5000) {
                    PassengerSctxServiceImp.this.m19506a(1000);
                    DLog.m7384d("ccc", "5s内不缓存轨迹数据", new Object[0]);
                } else {
                    if (!PassengerSctxServiceImp.this.f27380l) {
                        MockMovementInfo.SctxAnimData sctxAnimData = new MockMovementInfo.SctxAnimData();
                        if (TimeServiceManager.getInstance().isNTPAvailable()) {
                            sctxAnimData.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        } else {
                            sctxAnimData.ntpTimestamp = -1;
                        }
                        sctxAnimData.localTime = System.currentTimeMillis();
                        LatLng position = PassengerSctxServiceImp.this.getCarMarker().getPosition();
                        sctxAnimData.animLat = position.latitude;
                        sctxAnimData.animLng = position.longitude;
                        int animDistanceLeftCustomed = BizUtil.animDistanceLeftCustomed(PassengerSctxServiceImp.this.f27466C, PassengerSctxServiceImp.this.f27470G);
                        int animDistanceLeft = BizUtil.animDistanceLeft(PassengerSctxServiceImp.this.f27466C, PassengerSctxServiceImp.this.f27465B);
                        if (ApolloUtils.newEdaCalculator()) {
                            sctxAnimData.carAnimEda = animDistanceLeftCustomed;
                        } else {
                            sctxAnimData.carAnimEda = animDistanceLeft;
                        }
                        if (PassengerSctxServiceImp.this.f27489Z != null && PassengerSctxServiceImp.this.f27507ar) {
                            sctxAnimData.animDistance = DDSphericalUtil.computeDistanceBetween(position, PassengerSctxServiceImp.this.f27489Z);
                        }
                        if (PassengerSctxServiceImp.this.f27378j.isEnable()) {
                            sctxAnimData.jumpOverException = PassengerSctxServiceImp.this.f27378j.getCode();
                            PassengerSctxServiceImp.this.f27378j.clearJumpOverData();
                        }
                        PassengerSctxServiceImp.this.f27487X.add(sctxAnimData);
                        LatLng unused = PassengerSctxServiceImp.this.f27489Z = position;
                        DLog.m7384d("eda_log", "CarAnimEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|carAnimEda:" + sctxAnimData.carAnimEda + "|oldCarAnimEda:" + animDistanceLeft + "|newCarAnimEda:" + animDistanceLeftCustomed, new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("新增缓存数据 data.carAnimEda = ");
                        sb.append(sctxAnimData.carAnimEda);
                        sb.append(", data.animDistance=");
                        sb.append(sctxAnimData.animDistance);
                        DLog.m7384d("ccc", sb.toString(), new Object[0]);
                        if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                            String str = Config.DEBUG_TAG;
                            SystemUtils.log(3, str, "------ data.animDistance=" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.global.sctx.PassengerSctxServiceImp$10", 1871);
                        }
                    }
                    PassengerSctxServiceImp.this.m19506a(1000);
                }
            }
        }, j);
    }

    /* renamed from: F */
    private void m19477F() {
        m19552i();
        m19550h();
        m19555j();
        m19557k();
        m19479G();
        m19549g();
    }

    /* renamed from: G */
    private void m19479G() {
        this.f27382n = 0;
        this.f27474K = 0;
        this.f27473J = 0;
        this.f27464A = 0;
        this.f27513z = 0;
        this.f27511x = 0;
        this.f27512y = 0;
        this.f27492ac.clear();
        this.f27486W.clear();
        ArrayList<LatLng> arrayList = this.f27467D;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private void m19503a(int i, int i2) {
        this.f27510w.record(i, i2, m19521a(false), this.f27492ac.isRouteChanged, m19576u(), this.f27373e.isArrivedPickupPoint());
    }

    /* renamed from: H */
    private void m19481H() {
        this.f27510w.doOmega(this.f27373e.getOrderId(), this.f27373e.getTripState(), this.f27373e.isArrivedPickupPoint(), this.f27373e.getCountryId(), m19576u());
        if (!this.f27373e.isReadOnly()) {
            this.f27486W.doOmegaReportCarMoveInfo();
        }
    }

    /* renamed from: a */
    private void m19508a(LatLng latLng, LatLng latLng2) {
        if (this.f27373e != null && this.f27486W != null) {
            if (TextUtils.isEmpty(this.f27373e.getOrderId())) {
                this.f27486W.trackOrderRouteParamError(1);
            } else if (TextUtils.isEmpty(String.valueOf(this.f27373e.getBizType()))) {
                this.f27486W.trackOrderRouteParamError(4);
            } else if (!LatLngUtils.locateCorrect(latLng)) {
                this.f27486W.trackOrderRouteParamError(2);
            } else if (!LatLngUtils.locateCorrect(latLng2)) {
                this.f27486W.trackOrderRouteParamError(3);
            }
        }
    }

    /* renamed from: I */
    private void m19482I() {
        int J = m19484J();
        boolean z = this.f27373e.getTripState() == 3;
        int i = this.f27496ag;
        if (i != J && z) {
            this.f27486W.trackAppLocationPermission(i, J);
        }
        this.f27496ag = J;
    }

    /* renamed from: J */
    private int m19484J() {
        int locationPermissionLevel = Utils.getLocationPermissionLevel(this.f27370b);
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
        m19473D();
        m19482I();
        this.f27507ar = true;
    }

    public void pause() {
        super.pause();
        m19475E();
        m19481H();
        this.f27507ar = false;
    }

    public void leave() {
        super.leave();
        if (ApolloUtils.getAlarmOmegaToggle()) {
            m19487K();
        }
        m19481H();
        this.f27501al = 2;
        runImmediately();
        SctxDataCache sctxDataCache = this.f27492ac;
        if (sctxDataCache != null && sctxDataCache.orderState == 3) {
            m19539d();
        }
        IInertiaDelegate iInertiaDelegate = this.f27465B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f27465B = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27466C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
            this.f27466C = null;
        }
        ISctxViewDelegate iSctxViewDelegate = this.f27508u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.destroy();
            this.f27508u = null;
        }
        m19488L();
        this.f27483T = 0;
        m19475E();
        if (this.f27497ah != null) {
            try {
                this.f27370b.unregisterReceiver(this.f27497ah);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f27497ah = null;
        }
        if (this.f27495af != null) {
            DIDILocationManager.getInstance(this.f27370b).removeLocationUpdates(this.f27495af);
            this.f27495af = null;
        }
        if (this.f27369a != null && this.f27502am != null) {
            this.f27369a.removeOnLineClickListener(this.f27502am);
            this.f27502am = null;
        }
    }

    /* renamed from: K */
    private void m19487K() {
        String str = "";
        String driverError = getCarMarker() == null ? this.f27377i.getDriverError() : str;
        if ((m19584y() || this.f27373e.getTripState() == 4) && !hasLine()) {
            str = this.f27377i.getRouteError();
        }
        if (!TextUtils.isEmpty(driverError) || !TextUtils.isEmpty(str)) {
            ErrorCodeCollect.trackSctxShowError(driverError, str, LoginOmegaUtil.OLD_USER);
        }
    }

    public boolean hasLine() {
        TrafficLineDelegate trafficLineDelegate = this.f27480Q;
        return trafficLineDelegate != null && !CollectionUtil.isEmpty((Collection<?>) trafficLineDelegate.getLines());
    }

    /* renamed from: a */
    private void m19512a(TrafficLineDelegate trafficLineDelegate) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.remove();
        }
    }

    /* renamed from: L */
    private void m19488L() {
        m19512a(this.f27499aj);
        m19512a(this.f27480Q);
        this.f27499aj = null;
        this.f27480Q = null;
        this.f27483T = 0;
    }

    public void cancelPickupPointRecommend() {
        TrafficLineDelegate trafficLineDelegate = this.f27480Q;
        if (trafficLineDelegate != null) {
            trafficLineDelegate.highLight(true);
        }
        this.f27501al = 2;
        m19512a(this.f27499aj);
        this.f27499aj = null;
        runImmediately();
    }

    public void chooseLine(int i) {
        DLog.m7384d(f27461r, "chooseLine: " + i, new Object[0]);
        TrafficLineDelegate trafficLineDelegate = this.f27480Q;
        if (trafficLineDelegate != null && this.f27499aj != null) {
            if (i == 1) {
                trafficLineDelegate.highLight(true);
                m19513a(this.f27480Q, 1);
                this.f27499aj.highLight(false);
                m19513a(this.f27499aj, 2);
                if (this.f27372d != null) {
                    this.f27372d.selectedPickupPoint(this.f27373e.getPickupPoint());
                }
            } else if (i == 2) {
                trafficLineDelegate.highLight(false);
                m19513a(this.f27480Q, 1);
                this.f27499aj.highLight(true);
                m19513a(this.f27499aj, 2);
                SecRouteInfo secRouteInfo = this.f27500ak;
                if (secRouteInfo != null && secRouteInfo.point != null) {
                    PickupPoint pickupPoint = this.f27500ak.point;
                    if (this.f27372d != null) {
                        this.f27372d.selectedPickupPoint(new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m19513a(TrafficLineDelegate trafficLineDelegate, int i) {
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
        this.f27503an = z;
    }
}
