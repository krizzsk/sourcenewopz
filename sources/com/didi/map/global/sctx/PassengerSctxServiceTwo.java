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

public class PassengerSctxServiceTwo extends AbstractSctxService {
    public static final int RecPPState_Cancel = 2;
    public static final int RecPPState_Use = 1;

    /* renamed from: r */
    private static final String f27568r = "PassengerSctxService";

    /* renamed from: s */
    private static final int f27569s = 1;

    /* renamed from: t */
    private static final int f27570t = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f27571A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IInertiaDelegate f27572B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IMyLocationDelegate f27573C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ArrayList<LatLng> f27574D;

    /* renamed from: E */
    private List<LatLng> f27575E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public RouteGuidanceGPSPoint f27576F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public MatchPointDisHandler f27577G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f27578H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f27579I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f27580J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f27581K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f27582L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f27583M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f27584N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f27585O;

    /* renamed from: P */
    private List<OdPoint> f27586P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public TrafficLineDelegate f27587Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public int f27588R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public LatLng f27589S;

    /* renamed from: T */
    private int f27590T;

    /* renamed from: U */
    private OrderRouteEngineResPack f27591U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public RouteGuidanceGPSPoint f27592V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public OmegaReportManager f27593W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public List<MockMovementInfo.SctxAnimData> f27594X = new ArrayList();

    /* renamed from: Y */
    private Handler f27595Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public LatLng f27596Z;

    /* renamed from: aa */
    private List<LatLng> f27597aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public List<LatLng> f27598ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public SctxDataCache f27599ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f27600ad = -2;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public Set<Integer> f27601ae;

    /* renamed from: af */
    private DIDILocationListener f27602af;

    /* renamed from: ag */
    private int f27603ag = -1;

    /* renamed from: ah */
    private BroadcastReceiver f27604ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public long f27605ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public TrafficLineDelegate f27606aj;

    /* renamed from: ak */
    private SecRouteInfo f27607ak;

    /* renamed from: al */
    private int f27608al = 0;

    /* renamed from: am */
    private OnLineClickListener f27609am;

    /* renamed from: an */
    private boolean f27610an = true;

    /* renamed from: ao */
    private boolean f27611ao = true;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public float f27612ap = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f27613aq;

    /* renamed from: ar */
    private boolean f27614ar = false;

    /* renamed from: as */
    private long f27615as = -1;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ISctxViewDelegate f27616u;

    /* renamed from: v */
    private long f27617v;

    /* renamed from: w */
    private EtaEdaChangeTracker f27618w;

    /* renamed from: x */
    private int f27619x;

    /* renamed from: y */
    private int f27620y;

    /* renamed from: z */
    private long f27621z;

    /* renamed from: M */
    private boolean m19734M() {
        return false;
    }

    /* renamed from: s */
    static /* synthetic */ int m19817s(PassengerSctxServiceTwo passengerSctxServiceTwo) {
        int i = passengerSctxServiceTwo.f27571A;
        passengerSctxServiceTwo.f27571A = i + 1;
        return i;
    }

    public PassengerSctxServiceTwo(SctxTripParam sctxTripParam) {
        super(sctxTripParam);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        m19790f();
        m19803l();
        m19746a();
        m19794h();
        m19796i();
        m19799j();
        m19801k();
        m19717D();
        m19793g();
        m19713B();
        if (this.f27373e.getTripState() == 3) {
            m19771b();
            m19787e();
            m19726I();
        }
        m19752a(this.f27373e.getPickupPoint(), this.f27373e.getEndPoint());
    }

    /* renamed from: a */
    private void m19746a() {
        this.f27379k.setReportCallback(new RuntimeErrorCollect.ReportCallback() {
            public void reportError(String str) {
                PassengerSctxServiceTwo.this.f27593W.reportSctxErrorCode(str);
            }
        });
    }

    /* renamed from: b */
    private void m19771b() {
        this.f27602af = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locationSwitchLevel = Utils.getLocationSwitchLevel(PassengerSctxServiceTwo.this.f27370b);
                if (PassengerSctxServiceTwo.this.f27600ad != locationSwitchLevel) {
                    if (PassengerSctxServiceTwo.this.f27600ad != -2) {
                        PassengerSctxServiceTwo.this.f27593W.trackPhoneLocationType(PassengerSctxServiceTwo.this.f27600ad, locationSwitchLevel);
                    }
                    int unused = PassengerSctxServiceTwo.this.f27600ad = locationSwitchLevel;
                }
                PassengerSctxServiceTwo.this.m19784d();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (PassengerSctxServiceTwo.this.f27601ae == null) {
                    Set unused = PassengerSctxServiceTwo.this.f27601ae = new HashSet();
                }
                if (PassengerSctxServiceTwo.this.f27601ae.size() == 0) {
                    long unused2 = PassengerSctxServiceTwo.this.f27605ai = System.currentTimeMillis();
                }
                PassengerSctxServiceTwo.this.f27601ae.add(Integer.valueOf(errInfo.getErrNo()));
            }
        };
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f27370b);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("PassengerSctx");
            defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this.f27602af);
            instance.requestLocationUpdates(this.f27602af, defaultLocationUpdateOption);
        }
    }

    /* renamed from: c */
    private void m19779c() {
        if (this.f27369a != null && this.f27609am == null) {
            this.f27609am = new OnLineClickListener() {
                public void onLineClick(Line line) {
                    if (PassengerSctxServiceTwo.this.f27587Q != null && PassengerSctxServiceTwo.this.f27606aj != null) {
                        List<Line> lines = PassengerSctxServiceTwo.this.f27587Q.getLines();
                        List<Line> lines2 = PassengerSctxServiceTwo.this.f27606aj.getLines();
                        if (!CollectionUtil.isEmpty((Collection<?>) lines) && !CollectionUtil.isEmpty((Collection<?>) lines2)) {
                            if (lines.contains(line)) {
                                PassengerSctxServiceTwo.this.chooseLine(1);
                            } else if (lines2.contains(line)) {
                                PassengerSctxServiceTwo.this.chooseLine(2);
                            }
                        }
                    }
                }
            };
            this.f27369a.addOnLineClickListener(this.f27609am);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19784d() {
        Set<Integer> set = this.f27601ae;
        if (set != null && !set.isEmpty()) {
            this.f27593W.trackLocationErrorInfos(this.f27605ai, this.f27601ae);
            this.f27601ae.clear();
            this.f27605ai = 0;
        }
    }

    /* renamed from: e */
    private void m19787e() {
        this.f27604ah = new BroadcastReceiver() {
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
                    com.didi.map.global.sctx.PassengerSctxServiceTwo r6 = com.didi.map.global.sctx.PassengerSctxServiceTwo.this
                    com.didi.map.google.manager.OmegaReportManager r6 = r6.f27593W
                    r6.trackScreenState(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceTwo.C98254.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            this.f27370b.registerReceiver(this.f27604ah, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m19790f() {
        this.f27599ac = new SctxDataCache();
        this.f27591U = new OrderRouteEngineResPack();
        this.f27618w = new EtaEdaChangeTracker(m19827x());
        this.f27574D = new ArrayList<>();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f27576F = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f27586P = new ArrayList();
        this.f27616u = new SctxViewImpl(this.f27370b, this.f27369a, this.f27573C, this.f27377i);
        if (m19828y()) {
            this.f27614ar = true;
        }
    }

    /* renamed from: g */
    private void m19793g() {
        this.f27577G = new MatchPointDisHandler();
    }

    /* renamed from: h */
    private void m19794h() {
        InertiaEngine create = InertiaEngine.create(this.f27370b);
        this.f27572B = create;
        create.setPredictionApolloParams(this.f27376h.getSctxPredictionParams());
        this.f27572B.setSimulateEvaluateCallback(this.f27593W.getSimulateCallback());
        this.f27572B.setOrderInfo(this.f27373e.getOrderId(), this.f27373e.getTripState() == 3 ? this.f27373e.isArrivedPickupPoint() ? 1 : 0 : 2);
        this.f27572B.setOnLocationMatched(new OnLocationMatched() {
            public void onOffRoute() {
            }

            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
                if (i >= 0 && !z) {
                    RouteGuidanceGPSPoint unused = PassengerSctxServiceTwo.this.f27576F = ConvertUtil.tran2RouteGuidanceGPSPointWithLatLng(latLng, 0);
                    PassengerSctxServiceTwo.this.f27576F.shapeOffSet = i2;
                    PassengerSctxServiceTwo.this.f27576F.segmentIndex = i;
                }
                PassengerSctxServiceTwo.this.f27372d.onMatched(latLng);
                DLog.m7384d(PassengerSctxServiceTwo.f27568r, "onMatched - point:" + latLng.toString() + ", segmentIndex:" + i + ", distanceOffset:" + i3 + ", timeoffsett:" + i4 + ", isSimulate:" + z, new Object[0]);
                PassengerSctxServiceTwo.this.m19805m();
                CarIconsPreloader.getInstance().preloadCarIcons(i);
                if (!z) {
                    PassengerSctxServiceTwo.this.m19807n();
                    DLog.m7384d(PassengerSctxServiceTwo.f27568r, "onMatched - 非惯导, mShowEta:" + PassengerSctxServiceTwo.this.f27582L + " / mShowDistance:" + PassengerSctxServiceTwo.this.f27584N + "显示的均为后台下发值", new Object[0]);
                } else {
                    PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                    int unused2 = passengerSctxServiceTwo.f27581K = passengerSctxServiceTwo.f27581K + i3;
                    PassengerSctxServiceTwo passengerSctxServiceTwo2 = PassengerSctxServiceTwo.this;
                    long unused3 = passengerSctxServiceTwo2.f27580J = passengerSctxServiceTwo2.f27580J + ((long) i4);
                    DLog.m7384d(PassengerSctxServiceTwo.f27568r, "onMatched - 惯导累积, mACCMockDistance:" + PassengerSctxServiceTwo.this.f27581K + ", mACCMockTime:" + PassengerSctxServiceTwo.this.f27580J, new Object[0]);
                    if (PassengerSctxServiceTwo.this.f27582L <= 0 && PassengerSctxServiceTwo.this.f27584N <= 0) {
                        PassengerSctxServiceTwo passengerSctxServiceTwo3 = PassengerSctxServiceTwo.this;
                        int unused4 = passengerSctxServiceTwo3.f27582L = passengerSctxServiceTwo3.f27578H;
                        PassengerSctxServiceTwo passengerSctxServiceTwo4 = PassengerSctxServiceTwo.this;
                        int unused5 = passengerSctxServiceTwo4.f27583M = passengerSctxServiceTwo4.f27578H * 60;
                        PassengerSctxServiceTwo passengerSctxServiceTwo5 = PassengerSctxServiceTwo.this;
                        int unused6 = passengerSctxServiceTwo5.f27584N = passengerSctxServiceTwo5.f27579I;
                    }
                    PassengerSctxServiceTwo passengerSctxServiceTwo6 = PassengerSctxServiceTwo.this;
                    int unused7 = passengerSctxServiceTwo6.f27583M = passengerSctxServiceTwo6.f27583M - i4;
                    PassengerSctxServiceTwo passengerSctxServiceTwo7 = PassengerSctxServiceTwo.this;
                    int unused8 = passengerSctxServiceTwo7.f27582L = passengerSctxServiceTwo7.f27583M / 60;
                    PassengerSctxServiceTwo passengerSctxServiceTwo8 = PassengerSctxServiceTwo.this;
                    int unused9 = passengerSctxServiceTwo8.f27584N = passengerSctxServiceTwo8.f27584N - i3;
                    DLog.m7384d(PassengerSctxServiceTwo.f27568r, "onMatched - 惯导, mShowEta:" + PassengerSctxServiceTwo.this.f27582L + "mShowEtaSeconds:" + PassengerSctxServiceTwo.this.f27583M + " / mShowDistance:" + PassengerSctxServiceTwo.this.f27584N + "显示的与后台下发值不一定一样: mEta:" + PassengerSctxServiceTwo.this.f27578H + " / mDistance:" + PassengerSctxServiceTwo.this.f27579I, new Object[0]);
                }
                if (PassengerSctxServiceTwo.this.f27616u.getCarMarker() == null) {
                    PassengerSctxServiceTwo passengerSctxServiceTwo9 = PassengerSctxServiceTwo.this;
                    passengerSctxServiceTwo9.m19751a(latLng, passengerSctxServiceTwo9.f27612ap == -1.0f ? 0.0f : PassengerSctxServiceTwo.this.f27612ap);
                }
                if (!PassengerSctxServiceTwo.this.m19765a(false)) {
                    if (i < 0) {
                        PassengerSctxServiceTwo.m19817s(PassengerSctxServiceTwo.this);
                        if (PassengerSctxServiceTwo.this.f27571A < 3) {
                            DLog.m7384d(PassengerSctxServiceTwo.f27568r, "[不满足惯导条件(sctx2.0效果)] 当前连续绑线失败次数:" + PassengerSctxServiceTwo.this.f27571A + ",不足" + 3 + "次，不做动画", new Object[0]);
                            return;
                        }
                    } else {
                        int unused10 = PassengerSctxServiceTwo.this.f27571A = 0;
                    }
                }
                PassengerSctxServiceTwo.this.f27573C.animateTo(new AnimateNode(latLng, i, i2, true));
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (sctxStateInfo != null && sctxStateInfo.getState() != null && PassengerSctxServiceTwo.this.m19765a(false)) {
                    DLog.m7384d(PassengerSctxServiceTwo.f27568r, "onUpdateSctxState:" + sctxStateInfo.getState().type, new Object[0]);
                    PassengerSctxServiceTwo.this.f27593W.onReceiveSctxState(PassengerSctxServiceTwo.this.f27373e.getOrderId(), sctxStateInfo);
                    if (PassengerSctxServiceTwo.this.f27372d != null) {
                        PassengerSctxServiceTwo.this.f27372d.onSctxStateUpdate(sctxStateInfo);
                    }
                }
            }

            public void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
                if (!PassengerSctxServiceTwo.this.f27378j.isEnable()) {
                    return;
                }
                if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR) {
                    PassengerSctxServiceTwo.this.f27378j.recordJumpCode(SctxCaseCode.INERTIA_DRIVER_TOO_FAR);
                } else if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL) {
                    PassengerSctxServiceTwo.this.f27378j.recordJumpCode(SctxCaseCode.INERTIA_MATCH_FAIL);
                }
            }
        });
    }

    /* renamed from: i */
    private void m19796i() {
        IMyLocationDelegate create = MyLocation.create(this.f27369a);
        this.f27573C = create;
        create.setIsPassenger(true);
        this.f27573C.setCarAnimationListener(new onCarAnimationListener() {
            public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                List unused = PassengerSctxServiceTwo.this.f27598ab = list2;
                PassengerSctxServiceTwo.this.m19761a(list, list2);
            }

            public void onErase(List<LatLng> list) {
                PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                passengerSctxServiceTwo.m19761a(list, (List<LatLng>) passengerSctxServiceTwo.f27598ab);
            }

            public void onErase(int i, int i2, LatLng latLng) {
                if (i != PassengerSctxServiceTwo.this.f27588R || latLng == null || !latLng.equals(PassengerSctxServiceTwo.this.f27589S)) {
                    if (PassengerSctxServiceTwo.this.f27587Q != null && !PassengerSctxServiceTwo.this.f27585O) {
                        PassengerSctxServiceTwo.this.f27587Q.erase(i, latLng);
                        PassengerSctxServiceTwo.this.m19748a(i, latLng);
                    }
                    int unused = PassengerSctxServiceTwo.this.f27588R = i;
                    LatLng unused2 = PassengerSctxServiceTwo.this.f27589S = latLng;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19748a(int i, LatLng latLng) {
        TrafficLineDelegate trafficLineDelegate;
        ArrayList<LatLng> arrayList = this.f27574D;
        List<LatLng> list = this.f27575E;
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27606aj != null) {
            int size = arrayList.size();
            int size2 = list.size();
            int i2 = this.f27588R;
            DLog.m7384d(f27568r, "sec points size :" + size2 + "cur points size: " + size + "lastEraseIndex: " + i2 + "segmentIndex: " + i, new Object[0]);
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
                m19749a(i3, list.get(i3), (List<LatLng>) arrayList, list);
            } else if (arrayList.size() > i && size2 > i) {
                int i4 = size2 - 1;
                if (i == i4) {
                    latLng = list.get(i4);
                }
                m19749a(i, latLng, (List<LatLng>) arrayList, list);
            }
            if (this.f27590T > size2 - 3 && (trafficLineDelegate = this.f27606aj) != null && trafficLineDelegate != null) {
                trafficLineDelegate.remove();
                this.f27606aj = null;
                if (this.f27372d != null) {
                    this.f27372d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m19749a(int i, LatLng latLng, List<LatLng> list, List<LatLng> list2) {
        if (DDSphericalUtil.computeDistanceBetween(list.get(i), list2.get(i)) > 5.0d) {
            DLog.m7384d(f27568r, "not eraseSecLine, distance > 5m", new Object[0]);
        } else if (list2.size() > i) {
            this.f27606aj.erase(i, latLng);
            this.f27590T = i;
            DLog.m7384d(f27568r, "eraseSecLine, mSecLastEraseIndex: " + this.f27590T, new Object[0]);
        } else {
            DLog.m7384d(f27568r, "not eraseSecLine, distance < 5m...", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19761a(List<LatLng> list, List<LatLng> list2) {
        if (this.f27599ac.enableDrawLine) {
            this.f27597aa = new ArrayList(list);
            if (list2 != null && list2.size() > 1) {
                this.f27597aa.addAll(list2.subList(1, list2.size()));
            }
        }
    }

    /* renamed from: j */
    private void m19799j() {
        ISctxViewDelegate iSctxViewDelegate = this.f27616u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.setLocationDelegate(this.f27573C);
            this.f27616u.set3DCarEnabled(this.f27373e.isIs3DEnabled());
            this.f27616u.set3DCarIcons(this.f27373e.getCar3DIcons());
            this.f27616u.setCarMarkerBitmap(this.f27373e.getCarBitmapDescriptor());
            this.f27616u.setCarMarkerZIndex(this.f27373e.getzIndex());
        }
    }

    /* renamed from: k */
    private void m19801k() {
        if (this.f27373e.getVamosExpansionParam() != null) {
            this.f27599ac.vamosDriverTripDestPoint = this.f27373e.getVamosExpansionParam().driverTripDestPoint;
        }
        this.f27599ac.orderPickupPoint = this.f27373e.getPickupPoint();
        this.f27599ac.orderDestPoint = this.f27373e.getEndPoint();
        this.f27617v = checkInterval(this.f27373e.getOraRequestInterval());
        m19809o();
        if (this.f27373e.isArrivedPickupPoint()) {
            m19756a(this.f27587Q);
            this.f27599ac.enableDrawLine = false;
        }
        if (this.f27373e.getWayPoints() != null) {
            setWayPoints(this.f27373e.getWayPoints(), this.f27373e.getWayPointsTimestamp());
        }
    }

    /* renamed from: l */
    private void m19803l() {
        this.f27593W = new OmegaReportManager(new OmegaReportManager.SctxReportGetter() {
            public String getUid() {
                return PassengerSctxServiceTwo.this.m19822v();
            }

            public String getOrderId() {
                return PassengerSctxServiceTwo.this.f27373e.getOrderId();
            }

            public int getOrderState() {
                return PassengerSctxServiceTwo.this.f27373e.getTripState();
            }

            public int getProductId() {
                return PassengerSctxServiceTwo.this.f27373e.getBizType();
            }

            public String getRole() {
                return PassengerSctxServiceTwo.this.m19825w();
            }

            public String getPageReferrer() {
                return PassengerSctxServiceTwo.this.m19827x();
            }

            public RouteGuidanceGPSPoint getOriginDriverPoint() {
                return PassengerSctxServiceTwo.this.f27592V;
            }

            public int getDriverMatchEda() {
                int i;
                int i2;
                RouteGuidanceGPSPoint g = PassengerSctxServiceTwo.this.f27576F;
                int i3 = -1;
                if (g == null) {
                    return -1;
                }
                int distanceToTail = PassengerSctxServiceTwo.this.f27577G != null ? PassengerSctxServiceTwo.this.f27577G.distanceToTail(g) : -1;
                if (PassengerSctxServiceTwo.this.f27572B != null) {
                    i2 = PassengerSctxServiceTwo.this.f27572B.distanceLeft();
                    i = PassengerSctxServiceTwo.this.f27572B.distanceLeft(g);
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (ApolloUtils.newEdaCalculator() && PassengerSctxServiceTwo.this.f27577G != null) {
                    i3 = distanceToTail;
                } else if (PassengerSctxServiceTwo.this.f27572B != null) {
                    i3 = i2;
                }
                DLog.m7384d("eda_log", "DriverMatchEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|CurDriverEda:" + i3 + "|OldEda:" + i2 + "|oldEdaParam:" + i + "|NewEda:" + distanceToTail + "|segmentIndex:" + g.segmentIndex, new Object[0]);
                return i3;
            }

            public int getCarAnimEda() {
                return BizUtil.animDistanceLeft(PassengerSctxServiceTwo.this.f27573C, PassengerSctxServiceTwo.this.f27572B);
            }

            public List<MockMovementInfo.SctxAnimData> getSctxAnimDataList() {
                ArrayList arrayList = new ArrayList(PassengerSctxServiceTwo.this.f27594X);
                PassengerSctxServiceTwo.this.f27594X.clear();
                return arrayList;
            }

            public boolean isSplitAccounts() {
                return PassengerSctxServiceTwo.this.f27373e.isReadOnly();
            }

            public CarMarker getDriverMarker() {
                return PassengerSctxServiceTwo.this.getCarMarker();
            }

            public boolean isArrived() {
                return PassengerSctxServiceTwo.this.f27373e.isArrivedPickupPoint();
            }

            public boolean isSimulateEtaEdaLimit(boolean z) {
                return PassengerSctxServiceTwo.this.m19777b(z);
            }

            public List<LatLng> getSctxRoutePoints() {
                return PassengerSctxServiceTwo.this.f27574D;
            }

            public double getMaxMockDistance() {
                return (double) PassengerSctxServiceTwo.this.f27376h.getMaxMockDistance(PassengerSctxServiceTwo.this.f27572B.getMatchPointType());
            }

            public long getMaxMockTime() {
                return PassengerSctxServiceTwo.this.f27376h.getMaxMockTime(PassengerSctxServiceTwo.this.f27572B.getMatchPointType());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m19805m() {
        if (m19828y()) {
            this.f27593W.doOmegaOnCarDelayed(this.f27373e.getBizType(), m19825w(), this.f27376h.getSctxPredictionEnable(), this.f27599ac.lastReceiveRouteTime, this.f27573C, this.f27572B);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m19807n() {
        DLog.m7384d(f27568r, "resetEtaEda", new Object[0]);
        this.f27581K = 0;
        this.f27580J = 0;
        int i = this.f27578H;
        this.f27582L = i;
        this.f27583M = i * 60;
        this.f27584N = this.f27579I;
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f27616u.setCarMarkerBitmap(bitmapDescriptor);
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        return this.f27616u.refresh3DCarIcons(z, list);
    }

    public void setOraRequestInterval(long j) {
        long checkInterval = checkInterval(j);
        long j2 = this.f27617v;
        if (checkInterval != j2) {
            DLog.m7384d(f27568r, "setOraRequestInterval :%s -> %s", Long.valueOf(j2), Long.valueOf(checkInterval));
            this.f27617v = checkInterval;
            m19809o();
            refreshSyncInterval();
        }
    }

    /* renamed from: o */
    private void m19809o() {
        IInertiaDelegate iInertiaDelegate = this.f27572B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.setRequestIntervalInMills((int) this.f27617v);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27573C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setAnimationInterval((int) this.f27617v);
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return this.f27617v;
    }

    /* renamed from: a */
    private void m19759a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m7384d(f27568r, "setOrderRouteResponse...", new Object[0]);
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
        this.f27612ap = mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue();
        if (!this.f27381m) {
            m19760a(mapPassengeOrderRouteRes, latLngListFromDiffGeoPoints);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (m19828y()) {
            long j = this.f27615as;
            if (j > 0 && currentTimeMillis - j >= 60000) {
                this.f27614ar = true;
                this.f27615as = currentTimeMillis;
                DLog.m7384d(f27568r, "mNeedTraffic: true", new Object[0]);
                return;
            }
        }
        if (this.f27615as == -1) {
            this.f27615as = currentTimeMillis;
        }
        this.f27614ar = false;
    }

    /* renamed from: a */
    private void m19760a(final MapPassengeOrderRouteRes mapPassengeOrderRouteRes, final List<LatLng> list) {
        if (this.f27599ac.isExtendedAnimating) {
            DLog.m7384d(f27568r, "bIsExtendedAnimating, return", new Object[0]);
        } else if (!m19811p() || !this.f27599ac.isFirstRecvRoutes) {
            m19776b(mapPassengeOrderRouteRes, list);
        } else {
            this.f27599ac.isFirstRecvRoutes = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                m19776b(mapPassengeOrderRouteRes, list);
                return;
            }
            if (this.f27574D.isEmpty()) {
                this.f27574D.addAll(list);
            }
            TrafficLineAnimatorOptions trafficLineAnimatorOptions = new TrafficLineAnimatorOptions();
            trafficLineAnimatorOptions.duration = getRouteExtensionAnimationDuration();
            trafficLineAnimatorOptions.animatorListener = new TrafficLineAnimatorOptions.TrafficLineAnimatorListener() {
                public void onStart() {
                    PassengerSctxServiceTwo.this.f27599ac.isExtendedAnimating = true;
                    if (PassengerSctxServiceTwo.this.f27372d != null) {
                        PassengerSctxServiceTwo.this.f27372d.onRouteAnimationStart();
                    }
                }

                public void onEnd() {
                    PassengerSctxServiceTwo.this.f27599ac.isExtendedAnimating = false;
                    if (PassengerSctxServiceTwo.this.f27372d != null) {
                        PassengerSctxServiceTwo.this.f27372d.onRouteAnimationEnd();
                    }
                    if (!PassengerSctxServiceTwo.this.m19776b(mapPassengeOrderRouteRes, (List<LatLng>) list)) {
                        PassengerSctxServiceTwo.this.m19751a((LatLng) list.get(0), list.size() > 1 ? (float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1)) : mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue());
                    }
                }
            };
            m19756a(this.f27587Q);
            this.f27587Q = new TrafficLineDelegate();
            m19758a(this.f27587Q, list, mapPassengeOrderRouteRes.traffic, trafficLineAnimatorOptions, false, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19751a(LatLng latLng, float f) {
        ISctxViewDelegate iSctxViewDelegate;
        if (latLng != null && (iSctxViewDelegate = this.f27616u) != null) {
            iSctxViewDelegate.updateCarMarker(latLng);
            this.f27616u.updateCarDirection(f);
        }
    }

    /* renamed from: b */
    private void m19773b(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        this.f27591U.parseFrom(mapPassengeOrderRouteRes);
        boolean z = true;
        this.f27585O = !this.f27591U.lineVisible;
        SctxDataCache sctxDataCache = this.f27599ac;
        if (!this.f27591U.lineVisible || this.f27373e.isArrivedPickupPoint()) {
            z = false;
        }
        sctxDataCache.enableDrawLine = z;
    }

    /* renamed from: p */
    private boolean m19811p() {
        return this.f27599ac.enableDrawLine && this.f27373e.isShowExtendedAnimation() && m19828y();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19776b(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list) {
        int i;
        int i2;
        final MapPassengeOrderRouteRes mapPassengeOrderRouteRes2 = mapPassengeOrderRouteRes;
        final List<LatLng> list2 = list;
        this.f27599ac.isRouteChanged = false;
        if (mapPassengeOrderRouteRes2.logId == null) {
            DLog.m7384d(f27568r, "res.logId == null", new Object[0]);
        } else if (this.f27621z > mapPassengeOrderRouteRes2.logId.longValue()) {
            DLog.m7384d(f27568r, "mResLogId:%d > res.logId:%d, return", Long.valueOf(this.f27621z), mapPassengeOrderRouteRes2.logId);
            return false;
        } else {
            this.f27621z = mapPassengeOrderRouteRes2.logId.longValue();
        }
        if (this.f27372d != null) {
            if (this.f27373e.isReadOnly() && !CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f27372d.onStartDestinationUpdate(list2.get(0), list2.get(list.size() - 1));
            }
            if (mapPassengeOrderRouteRes2.ret != null) {
                if (mapPassengeOrderRouteRes2.ret.intValue() == 33333) {
                    this.f27372d.onWayPointsStateUpdate(true, (List<OdPoint>) null);
                } else if (mapPassengeOrderRouteRes2.ret.intValue() == 0) {
                    this.f27372d.onWayPointsStateUpdate(false, this.f27586P);
                    this.f27372d.onWayPointsStateUpdateForMiniBus(CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes2.odPoints) ? new ArrayList() : mapPassengeOrderRouteRes2.odPoints);
                }
            }
        }
        if (mapPassengeOrderRouteRes2.eta != null && mapPassengeOrderRouteRes2.eta.intValue() >= 0) {
            this.f27578H = mapPassengeOrderRouteRes2.eta.intValue();
            DLog.m7384d(f27568r, "res.eta:" + mapPassengeOrderRouteRes2.eta, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.distance != null && mapPassengeOrderRouteRes2.distance.intValue() >= 0) {
            this.f27579I = mapPassengeOrderRouteRes2.distance.intValue();
            DLog.m7384d(f27568r, "res.distance:" + mapPassengeOrderRouteRes2.distance, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue())) {
            DLog.m7384d(f27568r, "res.driverPoint is error", new Object[0]);
            this.f27377i.setDriverError(3);
            this.f27379k.setErrorCode(202);
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
        DLog.m7384d(f27568r, "server返回的司机定位:%s，方向:%d", objArr);
        DoublePoint doublePoint = mapPassengeOrderRouteRes2.driverPoint;
        if (mapPassengeOrderRouteRes2.direction == null) {
            i2 = 0;
        } else {
            i2 = mapPassengeOrderRouteRes2.direction.intValue();
        }
        RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint = ConvertUtil.tran2RouteGuidanceGPSPoint(doublePoint, i2);
        this.f27592V = tran2RouteGuidanceGPSPoint;
        IInertiaDelegate iInertiaDelegate = this.f27572B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.onRecvDriverLocation(tran2RouteGuidanceGPSPoint);
        }
        float f = 0.0f;
        if (this.f27585O) {
            m19756a(this.f27587Q);
            if (this.f27616u.getCarMarker() == null) {
                m19751a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
            }
        }
        List<TrafficItem> list3 = this.f27599ac.trafficItems;
        List<TrafficItem> list4 = mapPassengeOrderRouteRes2.traffic;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(list.size());
            objArr2[1] = Long.valueOf(this.f27382n);
            objArr2[2] = Long.valueOf(mapPassengeOrderRouteRes2.routeId == null ? 0 : mapPassengeOrderRouteRes2.routeId.longValue());
            DLog.m7384d(f27568r, "server返回了路线，路线点集个数:%d，重新画线，routeId:[%d -> %d]", objArr2);
            if (hasLine() && mapPassengeOrderRouteRes2.routeId != null && mapPassengeOrderRouteRes2.routeId.longValue() == this.f27382n && list.size() == this.f27574D.size() && m19737a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex) == this.f27383o) {
                DLog.m7384d(f27568r, "后台返回了跟上次一样的routeId，但也返回了路线(按理不该返回)，这里就不再刷新路线", new Object[0]);
                if (!DUtils.isSameTraffics(list3, list4)) {
                    this.f27599ac.trafficItems = list4;
                    m19774b(list2, list4);
                    DLog.m7384d(f27568r, "routes not null, refresh traffic", new Object[0]);
                }
                m19813q();
            } else {
                this.f27615as = -1;
                this.f27599ac.isRouteChanged = true;
                this.f27599ac.trafficItems = mapPassengeOrderRouteRes2.traffic;
                this.f27573C.animateCancel(new onCarAnimationCancelListener() {
                    public void onCancel() {
                        float f;
                        int i = 0;
                        DLog.m7384d(PassengerSctxServiceTwo.f27568r, "onCarAnimationCancelListener onCancel() callback", new Object[0]);
                        long j = 0;
                        if (mapPassengeOrderRouteRes2.routeId == null) {
                            PassengerSctxServiceTwo.this.f27382n = 0;
                            PassengerSctxServiceTwo.this.f27383o = 0;
                        } else {
                            if (PassengerSctxServiceTwo.this.m19828y() && PassengerSctxServiceTwo.this.f27382n > 0 && PassengerSctxServiceTwo.this.getCarMarker() != null) {
                                float computeHeading = (float) DDSphericalUtil.computeHeading(PassengerSctxServiceTwo.this.getCarMarker().getPosition(), (LatLng) list2.get(0));
                                if (!(PassengerSctxServiceTwo.this.f27572B == null || PassengerSctxServiceTwo.this.f27572B.getLastMatchGPSPoint() == null)) {
                                    j = PassengerSctxServiceTwo.this.f27572B.getLastMatchGPSPoint().timestamp;
                                }
                                GoogleSyncTripOmegaUtil.map_pax_car_jump(PassengerSctxServiceTwo.this.m19822v(), PassengerSctxServiceTwo.this.f27373e.getOrderId(), PassengerSctxServiceTwo.this.f27373e.getTripState(), PassengerSctxServiceTwo.this.f27373e.isArrivedPickupPoint(), computeHeading, !PassengerSctxServiceTwo.this.f27585O ? 1 : 0, PassengerSctxServiceTwo.this.getCarMarker().getPosition(), j, (LatLng) list2.get(0), mapPassengeOrderRouteRes2.driverPoint.gpsTimestamp.longValue(), PassengerSctxServiceTwo.this.f27373e.getBizType(), PassengerSctxServiceTwo.this.m19825w(), PassengerSctxServiceTwo.this.m19827x());
                            }
                            PassengerSctxServiceTwo.this.f27382n = mapPassengeOrderRouteRes2.routeId.longValue();
                            PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                            passengerSctxServiceTwo.f27383o = passengerSctxServiceTwo.m19737a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex);
                        }
                        PassengerSctxServiceTwo.this.m19774b((List<LatLng>) list2, mapPassengeOrderRouteRes2.traffic);
                        PassengerSctxServiceTwo.this.f27599ac.lastReceiveRouteTime = System.currentTimeMillis();
                        CarIconsPreloader.getInstance().setRoutePoints(PassengerSctxServiceTwo.this.f27369a.getContext(), list2);
                        RouteGuidanceGPSPoint unused = PassengerSctxServiceTwo.this.f27576F = new RouteGuidanceGPSPoint();
                        PassengerSctxServiceTwo.this.f27576F.segmentIndex = -1;
                        PassengerSctxServiceTwo.this.f27573C.setNavRoutePoints(list2, false);
                        if (PassengerSctxServiceTwo.this.f27572B != null) {
                            if (PassengerSctxServiceTwo.this.f27383o > 0) {
                                PassengerSctxServiceTwo.this.f27572B.setRoutePoints(list2, PassengerSctxServiceTwo.this.f27383o, PassengerSctxServiceTwo.this.m19765a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceTwo.this.f27577G.setRoutePoints(list2, PassengerSctxServiceTwo.this.f27383o);
                                }
                            } else {
                                PassengerSctxServiceTwo.this.f27572B.setRoutePoints((List<LatLng>) list2, PassengerSctxServiceTwo.this.m19765a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceTwo.this.f27577G.setRoutePoints(list2);
                                }
                            }
                        }
                        PassengerSctxServiceTwo.this.m19813q();
                        if (PassengerSctxServiceTwo.this.f27616u.getCarMarker() != null) {
                            return;
                        }
                        if (!PassengerSctxServiceTwo.this.f27373e.isArrivedPickupPoint()) {
                            PassengerSctxServiceTwo passengerSctxServiceTwo2 = PassengerSctxServiceTwo.this;
                            LatLng latLng = (LatLng) list2.get(0);
                            if (list2.size() > 1) {
                                f = (float) DDSphericalUtil.computeHeading((LatLng) list2.get(0), (LatLng) list2.get(1));
                            } else {
                                if (mapPassengeOrderRouteRes2.direction != null) {
                                    i = mapPassengeOrderRouteRes2.direction.intValue();
                                }
                                f = (float) i;
                            }
                            passengerSctxServiceTwo2.m19751a(latLng, f);
                            return;
                        }
                        DLog.m7384d(PassengerSctxServiceTwo.f27568r, "司机已到达态下发新路线时，初始让小车显示在真实司机位置%s，非路线第一个点", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
                        PassengerSctxServiceTwo.this.m19751a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
                    }
                });
            }
            if (!this.f27373e.isReadOnly()) {
                GoogleSyncTripOmegaUtil.com_map_PassengerGetRoute_sw_global(m19822v(), this.f27373e.getOrderId(), this.f27382n, this.f27373e.getTripState(), this.f27373e.isArrivedPickupPoint(), this.f27373e.getCountryId(), this.f27373e.getTripId(), this.f27380l, this.f27373e.getBizType(), m19825w(), m19827x());
            }
        } else {
            if (!CollectionUtil.isEmpty((Collection<?>) this.f27574D) && !CollectionUtil.isEmpty((Collection<?>) list4) && !DUtils.isSameTraffics(list4, list3)) {
                this.f27599ac.trafficItems = list4;
                DLog.m7384d(f27568r, "routes null, refresh traffic", new Object[0]);
            }
            m19813q();
            if (this.f27616u.getCarMarker() == null) {
                if (mapPassengeOrderRouteRes2.direction != null) {
                    f = (float) mapPassengeOrderRouteRes2.direction.intValue();
                }
                m19751a(latLng, f);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19737a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m19813q() {
        IInertiaDelegate iInertiaDelegate = this.f27572B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.getMatchPoint(m19815r());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19765a(boolean z) {
        if (!m19828y() || !TextUtils.isEmpty(this.f27373e.getTripId()) || this.f27373e.isReadOnly()) {
            if (z) {
                DLog.m7384d(f27568r, "[getMatchPoint result] 非接驾段 | 拼车 | 分账人 -> 不开启惯导", new Object[0]);
            }
            return false;
        }
        boolean simulateMotionEnable = this.f27376h.getSimulateMotionEnable();
        if (z) {
            DLog.m7384d(f27568r, "[getMatchPoint] 看是否满足惯导条件：", new Object[0]);
            DLog.m7384d(f27568r, "1.总Apollo开关是否打开：%s", Boolean.valueOf(simulateMotionEnable));
        }
        return simulateMotionEnable;
    }

    /* renamed from: r */
    private boolean m19815r() {
        boolean a = m19765a(true);
        if (!a) {
            return a;
        }
        int maxMockDistance = this.f27376h.getMaxMockDistance(this.f27572B.getMatchPointType());
        long maxMockTime = this.f27376h.getMaxMockTime(this.f27572B.getMatchPointType());
        boolean z = this.f27581K < maxMockDistance && this.f27580J < maxMockTime;
        DLog.m7384d(f27568r, "2.累积惯导距离：%d, 累积惯导时间：%d [距离上限：%d, 时间上限:%d]", Integer.valueOf(this.f27581K), Long.valueOf(this.f27580J), Integer.valueOf(maxMockDistance), Long.valueOf(maxMockTime));
        return z ? !m19777b(true) : z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19777b(boolean z) {
        int allowEDA = this.f27376h.getAllowEDA();
        int allowETA = (int) ((this.f27376h.getAllowETA() / 1000) / 60);
        if (this.f27582L > 0 || this.f27584N > 0) {
            if (z) {
                DLog.m7384d(f27568r, "3.mShowDistance：%d, mShowEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27584N), Integer.valueOf(this.f27582L), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
            }
            if (this.f27584N <= allowEDA || this.f27582L <= allowETA) {
                return true;
            }
            return false;
        }
        if (z) {
            DLog.m7384d(f27568r, "3.mDistance：%d, mEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f27579I), Integer.valueOf(this.f27578H), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
        }
        if (this.f27579I <= allowEDA || this.f27578H <= allowETA) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19774b(List<LatLng> list, List<TrafficItem> list2) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            StringBuffer stringBuffer = new StringBuffer();
            for (LatLng next : list) {
                stringBuffer.append(next.longitude + "," + next.latitude + ";");
            }
            DLog.m7384d("ccc", "新路线: " + stringBuffer.toString(), new Object[0]);
        }
        this.f27574D.clear();
        this.f27574D.addAll(list);
        m19807n();
        if (!this.f27599ac.enableDrawLine) {
            return;
        }
        if (!this.f27599ac.isDestModified || DDSphericalUtil.computeDistanceBetween(list.get(list.size() - 1), this.f27373e.getEndPoint()) <= 500.0d) {
            DLog.m7384d(f27568r, "updateNewLine - rebuild TrafficLine", new Object[0]);
            if (this.f27372d != null && !this.f27611ao) {
                this.f27372d.goingOffCourse();
            }
            this.f27611ao = false;
            this.f27607ak = null;
            this.f27575E = null;
            if (m19734M()) {
                this.f27590T = 0;
                TrafficLineDelegate trafficLineDelegate = this.f27606aj;
                if (trafficLineDelegate != null) {
                    m19756a(trafficLineDelegate);
                    this.f27606aj = null;
                    if (this.f27372d != null) {
                        this.f27372d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                    }
                }
            }
            m19756a(this.f27587Q);
            TrafficLineDelegate trafficLineDelegate2 = new TrafficLineDelegate();
            this.f27587Q = trafficLineDelegate2;
            m19758a(trafficLineDelegate2, list, list2, (TrafficLineAnimatorOptions) null, false, false);
            m19757a(this.f27587Q, 1);
            DLog.m7384d(f27568r, "draw line", new Object[0]);
            if (this.f27607ak != null && this.f27575E != null) {
                m19756a(this.f27606aj);
                this.f27606aj = new TrafficLineDelegate();
                m19758a(this.f27606aj, this.f27575E, this.f27607ak.route.traffic, (TrafficLineAnimatorOptions) null, this.f27607ak.route.included.intValue() == 1, true);
                m19757a(this.f27606aj, 2);
                this.f27606aj.highLight(false);
                m19779c();
                if (this.f27372d != null) {
                    this.f27372d.showSecRouteInfoCallback(new SecRouteInfoEx(this.f27607ak), true);
                }
                DLog.m7384d(f27568r, "draw sec back line", new Object[0]);
                return;
            }
            return;
        }
        DLog.m7384d(f27568r, "updateNewLine - 修改了目的地，但是修改后的目的地与后台下发的路线终点距离相差大于%dm --> 不画线", 500);
    }

    /* renamed from: a */
    private void m19758a(TrafficLineDelegate trafficLineDelegate, List<LatLng> list, List<TrafficItem> list2, TrafficLineAnimatorOptions trafficLineAnimatorOptions, boolean z, boolean z2) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.setTrafficOptions(m19741a(list, list2, z, z2));
            trafficLineDelegate.addToMap(this.f27369a, trafficLineAnimatorOptions);
        }
    }

    /* renamed from: a */
    private TrafficOptions m19741a(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        if (!MapVendor.DIDI.equals(this.f27369a.getMapVendor()) || !z2 || (ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture())) {
            return m19770b(list, list2, z, z2);
        }
        return m19742a(list, z);
    }

    /* renamed from: a */
    private TrafficOptions m19742a(List<LatLng> list, boolean z) {
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
    private TrafficOptions m19770b(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
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
        return this.f27574D;
    }

    public List<Line> getLines() {
        TrafficLineDelegate trafficLineDelegate = this.f27587Q;
        if (trafficLineDelegate == null) {
            return null;
        }
        return trafficLineDelegate.getLines();
    }

    public List<LatLng> getRemainingRoutePoints() {
        return this.f27597aa;
    }

    /* renamed from: s */
    private int m19816s() {
        if (!this.f27585O) {
            int i = m19828y() ? this.f27582L : this.f27578H;
            if (Math.abs(this.f27619x - i) >= 1) {
                m19747a(i, m19828y() ? this.f27584N : this.f27579I);
                this.f27619x = i;
            }
            return i;
        } else if (this.f27591U.mEta >= 0) {
            DLog.m7384d(f27568r, "bIsHideRoute, eta:" + this.f27591U.mEta, new Object[0]);
            return this.f27591U.mEta;
        } else {
            DLog.m7384d(f27568r, "bIsHideRoute, eta return %d", 1);
            return 1;
        }
    }

    /* renamed from: t */
    private int m19818t() {
        if (!this.f27585O) {
            int i = m19828y() ? this.f27584N : this.f27579I;
            if (Math.abs(this.f27620y - i) >= 100) {
                m19747a(m19828y() ? this.f27582L : this.f27578H, i);
                this.f27620y = i;
            }
            return i;
        } else if (this.f27591U.mDistance >= 0) {
            DLog.m7384d(f27568r, "bIsHideRoute, eda:" + this.f27591U.mDistance, new Object[0]);
            return this.f27591U.mDistance;
        } else {
            DLog.m7384d(f27568r, "bIsHideRoute, eda return %d", 100);
            return 100;
        }
    }

    /* renamed from: u */
    private LatLng m19820u() {
        DoublePoint location = DUtils.getLocation(this.f27370b);
        return location != null ? new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue()) : new LatLng(0.0d, 0.0d);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public String m19822v() {
        return this.f27374f != null ? this.f27374f.getUserId() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public String m19825w() {
        if (!TextUtils.isEmpty(this.f27599ac.userRole)) {
            return this.f27599ac.userRole;
        }
        if (this.f27374f != null) {
            this.f27599ac.userRole = this.f27374f.getUserRole();
        }
        return this.f27599ac.userRole;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public String m19827x() {
        if (this.f27374f != null) {
            return this.f27374f.getPageReferrer();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public boolean m19828y() {
        return this.f27373e.getTripState() == 3 && !this.f27373e.isArrivedPickupPoint();
    }

    /* renamed from: z */
    private boolean m19831z() {
        return this.f27373e.getTripState() == 3 && this.f27373e.isArrivedPickupPoint();
    }

    /* renamed from: A */
    private boolean m19711A() {
        return this.f27373e.getTripState() == 4;
    }

    public double getRemainingRouteDistance() {
        if (!this.f27373e.isArrivedPickupPoint() || getCarMarker() == null) {
            return 0.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(getCarMarker().getPosition(), this.f27373e.getPickupPoint());
    }

    public LatLng getDriverPoint() {
        IInertiaDelegate iInertiaDelegate = this.f27572B;
        if (iInertiaDelegate == null || iInertiaDelegate.getLastMatchGPSPoint() == null || this.f27572B.getLastMatchGPSPoint().segmentIndex == -1) {
            if (getCarMarker() != null) {
                return getCarMarker().getPosition();
            }
            return null;
        } else if (!this.f27376h.getSctxPredictionEnable() || this.f27572B.getLastMatchGPSPoint().originMatchPoint == null) {
            return ConvertUtil.convertFromGeoPoint(this.f27572B.getLastMatchGPSPoint().point);
        } else {
            return ConvertUtil.convertFromGeoPoint(this.f27572B.getLastMatchGPSPoint().originMatchPoint.point);
        }
    }

    public CarMarker getCarMarker() {
        ISctxViewDelegate iSctxViewDelegate = this.f27616u;
        if (iSctxViewDelegate == null) {
            return null;
        }
        return iSctxViewDelegate.getCarMarker();
    }

    public void updateDestination(LatLng latLng) {
        DLog.m7384d(f27568r, "updateDestination...", new Object[0]);
        m19752a(this.f27373e.getPickupPoint(), latLng);
        if (latLng != null) {
            this.f27599ac.orderDestPoint = latLng;
            if (this.f27373e.getTripState() == 4) {
                DLog.m7384d(f27568r, "updateDestination - 送驾段，removeLine", new Object[0]);
                this.f27599ac.isDestModified = true;
                m19756a(this.f27587Q);
            }
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        m19752a(latLng, this.f27373e.getEndPoint());
        if (latLng != null) {
            this.f27608al = 1;
            this.f27599ac.orderPickupPoint = latLng;
            this.f27382n = 0;
            if (this.f27373e.getTripState() == 3) {
                DLog.m7384d(f27568r, "updateDestination - 接驾段，removeLine", new Object[0]);
                m19732L();
                m19725H();
                m19719E();
                m19717D();
                runImmediately();
            }
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        DLog.m7384d(f27568r, "[途经点信息] setOdPoints:%s, odPointsTimestamp:%d", GoogleSyncTripLogUtil.getOdPointsLogInfo(list), Long.valueOf(j));
        this.f27599ac.lastGetWayPointTime = j;
        List<OdPoint> list2 = this.f27586P;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.f27586P.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        if (TextUtils.isEmpty(this.f27373e.getToken())) {
            return null;
        }
        PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
        if (this.f27599ac.orderPickupPoint != null) {
            builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27599ac.orderPickupPoint.latitude)).lng(Float.valueOf((float) this.f27599ac.orderPickupPoint.longitude)).build());
        }
        if (this.f27599ac.orderDestPoint != null) {
            builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27599ac.orderDestPoint.latitude)).lng(Float.valueOf((float) this.f27599ac.orderDestPoint.longitude)).build());
        }
        if (this.f27599ac.vamosDriverTripDestPoint != null) {
            builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.f27599ac.vamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.f27599ac.vamosDriverTripDestPoint.longitude)).build()).build());
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
        curRouteId.imei(str2).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f27373e.getClientVersion()).lastOrderId(this.f27373e.getLastOrderId()).noNeedGeo(false).productId(String.valueOf(this.f27373e.getBizType())).countryId(this.f27373e.getCountryId()).sdkmaptype(str).lang(LocaleCodeHolder.getInstance().getCurrentLang()).travelId(this.f27373e.getTripId()).recPPState(Integer.valueOf(this.f27608al)).psgPoint(DUtils.getLocation(this.f27370b)).pushBtMsg(false).bizGroup(Integer.valueOf(this.f27373e.getBizGroup())).needTraffic(Boolean.valueOf(this.f27614ar));
        if (this.f27373e.getTripState() == 4) {
            if (this.f27599ac.lastGetWayPointTime <= 0) {
                DLog.m7384d(f27568r, "mWayPointTimeStamp(%d) <= 0，不传给后台途经点", Long.valueOf(this.f27599ac.lastGetWayPointTime));
            } else {
                builder.odPoints(this.f27586P);
                builder.odPointsTimestamp(Long.valueOf(this.f27599ac.lastGetWayPointTime));
            }
        }
        builder.readOnly(Boolean.valueOf(this.f27373e.isReadOnly()));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
        OmegaReportManager omegaReportManager;
        DLog.m7384d(f27568r, "onSyncStart...", new Object[0]);
        if (this.f27372d != null) {
            this.f27372d.onSyncStart();
        }
        if (!this.f27373e.isReadOnly() && (omegaReportManager = this.f27593W) != null) {
            omegaReportManager.doOmegaReportByTimeInterval();
        }
    }

    /* renamed from: B */
    private void m19713B() {
        if (this.f27373e.getTripState() == 3) {
            this.f27593W.trackOrderLocationPermission(Utils.getLocationSwitchLevel(this.f27370b), m19728J());
        }
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m7384d(f27568r, "onOraResponse...", new Object[0]);
        if (!this.f27380l) {
            if (Config.DEBUG && mapPassengeOrderRouteRes.ret != null && mapPassengeOrderRouteRes.ret.intValue() == 10000) {
                this.f27372d.orderChanged();
            } else if (mapPassengeOrderRouteRes != null) {
                if (mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() != 30076 || this.f27372d == null) {
                    if (!(mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() == 0 || mapPassengeOrderRouteRes.logId == null)) {
                        this.f27593W.trackOrderRouteResultError(mapPassengeOrderRouteRes.ret.intValue(), mapPassengeOrderRouteRes.logId.longValue());
                    }
                    m19773b(mapPassengeOrderRouteRes);
                    if (m19762a(this.f27591U.serverStage) && this.f27372d != null) {
                        this.f27372d.onAbnormalOrderStageCallback(this.f27591U.serverStage);
                        this.f27379k.setErrorCode(203);
                    }
                    if (this.f27591U.serverStage == 5) {
                        this.f27377i.setDriverError(2);
                        this.f27379k.setErrorCode(203);
                        stop();
                        return;
                    }
                    if (!this.f27380l) {
                        this.f27613aq = true;
                    }
                    m19759a(mapPassengeOrderRouteRes);
                    if (this.f27372d != null) {
                        this.f27372d.onSyncSuccess(mapPassengeOrderRouteRes);
                        this.f27372d.onEtaEdaUpdate(new EtaEdaInfo(m19816s(), m19818t(), SXUtils.getLastOrderEda(this.f27373e.getLastOrderId(), mapPassengeOrderRouteRes)));
                        return;
                    }
                    return;
                }
                DLog.m7384d(f27568r, "error code:" + mapPassengeOrderRouteRes.ret, new Object[0]);
                this.f27372d.onAbnormalOrderStageCallback(4);
            }
        }
    }

    /* renamed from: C */
    private double m19714C() {
        LatLng driverPoint = getDriverPoint();
        List<LatLng> routePoints = getRoutePoints();
        return DDSphericalUtil.computeDistanceBetween(driverPoint, routePoints.get(routePoints.size() - 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m19762a(int r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceTwo.m19762a(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
        DLog.m7384d(f27568r, "onOraFail err:%s", str);
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
        if (this.f27599ac.isSctxParamUpdated) {
            this.f27599ac.isSctxParamUpdated = false;
            m19721F();
            DLog.m7384d(f27568r, "onPreStart, isSctxParamUpdated is true", new Object[0]);
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        DLog.m7384d(f27568r, "update...", new Object[0]);
        if (sctxTripParam == null || sctxTripParam.equals(this.f27373e)) {
            DLog.m7384d(f27568r, "update,mSctxTripParam is equals.", new Object[0]);
            return;
        }
        stop();
        this.f27599ac.orderId = this.f27373e.getOrderId();
        this.f27599ac.orderState = this.f27373e.getTripState();
        this.f27599ac.isWaitingState = this.f27373e.isArrivedPickupPoint();
        this.f27599ac.isSctxParamUpdated = true;
        initBaseParam(sctxTripParam);
        m19717D();
        if (this.f27373e.getTripState() == 3) {
            m19771b();
            m19787e();
        }
        m19752a(this.f27373e.getPickupPoint(), this.f27373e.getEndPoint());
        start();
    }

    /* renamed from: D */
    private void m19717D() {
        this.f27594X.clear();
        this.f27596Z = null;
        Handler handler = this.f27595Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        } else {
            this.f27595Y = new Handler(Looper.getMainLooper());
        }
        if (this.f27373e != null && !this.f27373e.isArrivedPickupPoint() && this.f27373e.getTripState() == 3) {
            m19750a(1000);
        }
        DLog.m7384d("ccc", "开始记录缓存数据", new Object[0]);
    }

    /* renamed from: E */
    private void m19719E() {
        this.f27594X.clear();
        this.f27596Z = null;
        Handler handler = this.f27595Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27595Y = null;
        }
        DLog.m7384d("ccc", "清除缓存数据", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19750a(long j) {
        this.f27595Y.postDelayed(new Runnable() {
            public void run() {
                if (PassengerSctxServiceTwo.this.f27573C == null || PassengerSctxServiceTwo.this.getCarMarker() == null) {
                    PassengerSctxServiceTwo.this.m19750a(1000);
                    DLog.m7384d("ccc", "未初始化，不缓存轨迹点", new Object[0]);
                } else if (PassengerSctxServiceTwo.this.f27384p == 0) {
                    PassengerSctxServiceTwo.this.m19750a(1000);
                    DLog.m7384d("ccc", "未可用，不缓存轨迹点", new Object[0]);
                } else if (System.currentTimeMillis() - PassengerSctxServiceTwo.this.f27384p < 5000) {
                    PassengerSctxServiceTwo.this.m19750a(1000);
                    DLog.m7384d("ccc", "5s内不缓存轨迹数据", new Object[0]);
                } else {
                    if (!PassengerSctxServiceTwo.this.f27380l) {
                        MockMovementInfo.SctxAnimData sctxAnimData = new MockMovementInfo.SctxAnimData();
                        if (TimeServiceManager.getInstance().isNTPAvailable()) {
                            sctxAnimData.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        } else {
                            sctxAnimData.ntpTimestamp = -1;
                        }
                        sctxAnimData.localTime = System.currentTimeMillis();
                        LatLng position = PassengerSctxServiceTwo.this.getCarMarker().getPosition();
                        sctxAnimData.animLat = position.latitude;
                        sctxAnimData.animLng = position.longitude;
                        int animDistanceLeftCustomed = BizUtil.animDistanceLeftCustomed(PassengerSctxServiceTwo.this.f27573C, PassengerSctxServiceTwo.this.f27577G);
                        int animDistanceLeft = BizUtil.animDistanceLeft(PassengerSctxServiceTwo.this.f27573C, PassengerSctxServiceTwo.this.f27572B);
                        if (ApolloUtils.newEdaCalculator()) {
                            sctxAnimData.carAnimEda = animDistanceLeftCustomed;
                        } else {
                            sctxAnimData.carAnimEda = animDistanceLeft;
                        }
                        if (PassengerSctxServiceTwo.this.f27596Z != null && PassengerSctxServiceTwo.this.f27613aq) {
                            sctxAnimData.animDistance = DDSphericalUtil.computeDistanceBetween(position, PassengerSctxServiceTwo.this.f27596Z);
                        }
                        if (PassengerSctxServiceTwo.this.f27378j.isEnable()) {
                            sctxAnimData.jumpOverException = PassengerSctxServiceTwo.this.f27378j.getCode();
                            PassengerSctxServiceTwo.this.f27378j.clearJumpOverData();
                        }
                        PassengerSctxServiceTwo.this.f27594X.add(sctxAnimData);
                        LatLng unused = PassengerSctxServiceTwo.this.f27596Z = position;
                        DLog.m7384d("eda_log", "CarAnimEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|carAnimEda:" + sctxAnimData.carAnimEda + "|oldCarAnimEda:" + animDistanceLeft + "|newCarAnimEda:" + animDistanceLeftCustomed, new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("新增缓存数据 data.carAnimEda = ");
                        sb.append(sctxAnimData.carAnimEda);
                        sb.append(", data.animDistance=");
                        sb.append(sctxAnimData.animDistance);
                        DLog.m7384d("ccc", sb.toString(), new Object[0]);
                        if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                            String str = Config.DEBUG_TAG;
                            SystemUtils.log(3, str, "------ data.animDistance=" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.global.sctx.PassengerSctxServiceTwo$10", 1876);
                        }
                    }
                    PassengerSctxServiceTwo.this.m19750a(1000);
                }
            }
        }, j);
    }

    /* renamed from: F */
    private void m19721F() {
        m19796i();
        m19794h();
        m19799j();
        m19801k();
        m19723G();
        m19793g();
    }

    /* renamed from: G */
    private void m19723G() {
        this.f27382n = 0;
        this.f27581K = 0;
        this.f27580J = 0;
        this.f27571A = 0;
        this.f27621z = 0;
        this.f27619x = 0;
        this.f27620y = 0;
        this.f27599ac.clear();
        this.f27593W.clear();
        ArrayList<LatLng> arrayList = this.f27574D;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private void m19747a(int i, int i2) {
        this.f27618w.record(i, i2, m19765a(false), this.f27599ac.isRouteChanged, m19820u(), this.f27373e.isArrivedPickupPoint());
    }

    /* renamed from: H */
    private void m19725H() {
        this.f27618w.doOmega(this.f27373e.getOrderId(), this.f27373e.getTripState(), this.f27373e.isArrivedPickupPoint(), this.f27373e.getCountryId(), m19820u());
        if (!this.f27373e.isReadOnly()) {
            this.f27593W.doOmegaReportCarMoveInfo();
        }
    }

    /* renamed from: a */
    private void m19752a(LatLng latLng, LatLng latLng2) {
        if (this.f27373e != null && this.f27593W != null) {
            if (TextUtils.isEmpty(this.f27373e.getOrderId())) {
                this.f27593W.trackOrderRouteParamError(1);
            } else if (TextUtils.isEmpty(String.valueOf(this.f27373e.getBizType()))) {
                this.f27593W.trackOrderRouteParamError(4);
            } else if (!LatLngUtils.locateCorrect(latLng)) {
                this.f27593W.trackOrderRouteParamError(2);
            } else if (!LatLngUtils.locateCorrect(latLng2)) {
                this.f27593W.trackOrderRouteParamError(3);
            }
        }
    }

    /* renamed from: I */
    private void m19726I() {
        int J = m19728J();
        boolean z = this.f27373e.getTripState() == 3;
        int i = this.f27603ag;
        if (i != J && z) {
            this.f27593W.trackAppLocationPermission(i, J);
        }
        this.f27603ag = J;
    }

    /* renamed from: J */
    private int m19728J() {
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
        m19717D();
        m19726I();
        this.f27613aq = true;
    }

    public void pause() {
        super.pause();
        m19719E();
        m19725H();
        this.f27613aq = false;
    }

    public void leave() {
        super.leave();
        if (ApolloUtils.getAlarmOmegaToggle()) {
            m19731K();
        }
        m19725H();
        this.f27608al = 2;
        runImmediately();
        SctxDataCache sctxDataCache = this.f27599ac;
        if (sctxDataCache != null && sctxDataCache.orderState == 3) {
            m19784d();
        }
        IInertiaDelegate iInertiaDelegate = this.f27572B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f27572B = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27573C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
            this.f27573C = null;
        }
        ISctxViewDelegate iSctxViewDelegate = this.f27616u;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.destroy();
            this.f27616u = null;
        }
        m19732L();
        this.f27590T = 0;
        m19719E();
        if (this.f27604ah != null) {
            try {
                this.f27370b.unregisterReceiver(this.f27604ah);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f27604ah = null;
        }
        if (this.f27602af != null) {
            DIDILocationManager.getInstance(this.f27370b).removeLocationUpdates(this.f27602af);
            this.f27602af = null;
        }
        if (this.f27369a != null && this.f27609am != null) {
            this.f27369a.removeOnLineClickListener(this.f27609am);
            this.f27609am = null;
        }
    }

    /* renamed from: K */
    private void m19731K() {
        String str = "";
        String driverError = getCarMarker() == null ? this.f27377i.getDriverError() : str;
        if ((m19828y() || this.f27373e.getTripState() == 4) && !hasLine()) {
            str = this.f27377i.getRouteError();
        }
        if (!TextUtils.isEmpty(driverError) || !TextUtils.isEmpty(str)) {
            ErrorCodeCollect.trackSctxShowError(driverError, str, LoginOmegaUtil.OLD_USER);
        }
    }

    public boolean hasLine() {
        TrafficLineDelegate trafficLineDelegate = this.f27587Q;
        return trafficLineDelegate != null && !CollectionUtil.isEmpty((Collection<?>) trafficLineDelegate.getLines());
    }

    /* renamed from: a */
    private void m19756a(TrafficLineDelegate trafficLineDelegate) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.remove();
        }
    }

    /* renamed from: L */
    private void m19732L() {
        m19756a(this.f27606aj);
        m19756a(this.f27587Q);
        this.f27606aj = null;
        this.f27587Q = null;
        this.f27590T = 0;
    }

    public void cancelPickupPointRecommend() {
        TrafficLineDelegate trafficLineDelegate = this.f27587Q;
        if (trafficLineDelegate != null) {
            trafficLineDelegate.highLight(true);
        }
        this.f27608al = 2;
        m19756a(this.f27606aj);
        this.f27606aj = null;
        runImmediately();
    }

    public void chooseLine(int i) {
        DLog.m7384d(f27568r, "chooseLine: " + i, new Object[0]);
        TrafficLineDelegate trafficLineDelegate = this.f27587Q;
        if (trafficLineDelegate != null && this.f27606aj != null) {
            if (i == 1) {
                trafficLineDelegate.highLight(true);
                m19757a(this.f27587Q, 1);
                this.f27606aj.highLight(false);
                m19757a(this.f27606aj, 2);
                if (this.f27372d != null) {
                    this.f27372d.selectedPickupPoint(this.f27373e.getPickupPoint());
                }
            } else if (i == 2) {
                trafficLineDelegate.highLight(false);
                m19757a(this.f27587Q, 1);
                this.f27606aj.highLight(true);
                m19757a(this.f27606aj, 2);
                SecRouteInfo secRouteInfo = this.f27607ak;
                if (secRouteInfo != null && secRouteInfo.point != null) {
                    PickupPoint pickupPoint = this.f27607ak.point;
                    if (this.f27372d != null) {
                        this.f27372d.selectedPickupPoint(new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m19757a(TrafficLineDelegate trafficLineDelegate, int i) {
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
        this.f27610an = z;
    }
}
