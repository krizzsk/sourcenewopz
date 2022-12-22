package com.didi.map.sdk.sharetrack.google.inner;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.nav.car.MyLocation;
import com.didi.map.sdk.nav.car.onCarAnimationCancelListener;
import com.didi.map.sdk.nav.car.onCarAnimationListener;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.InertiaEngine;
import com.didi.map.sdk.nav.inertia.OnLocationMatched;
import com.didi.map.sdk.nav.inertia.SctxInertiaSuspiciousStatus;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.IBusinessEventCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.entity.GuideRouteLine;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.RouteEvent;
import com.didi.map.sdk.sharetrack.entity.StreetViewInfo;
import com.didi.map.sdk.sharetrack.entity.WayPoint;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.google.inner.handler.PushEdaHandler;
import com.didi.map.sdk.sharetrack.google.inner.model.RouteUnreachableHandler;
import com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager;
import com.didi.map.sdk.sharetrack.google.inner.state.DriverStateChecker;
import com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils;
import com.didi.map.sdk.sharetrack.google.inner.utils.C10194utils;
import com.didi.map.sdk.sharetrack.google.inner.utils.LocateUtils;
import com.didi.map.sdk.sharetrack.google.inner.utils.OraErrorCodeUtil;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.sdk.push.ServerParam;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.routesearchsdk.CallFrom;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GoogleSctxDriver {

    /* renamed from: T */
    private static final int f28741T = 1;

    /* renamed from: a */
    private static final String f28742a = "GoogleSctxDriver";

    /* renamed from: b */
    private static final String f28743b = "33333";

    /* renamed from: c */
    private static final String f28744c = "0";

    /* renamed from: d */
    private static final int f28745d = 1000;

    /* renamed from: e */
    private static final double f28746e = 500.0d;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public FetcherManager f28747A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IInertiaDelegate f28748B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IMyLocationDelegate f28749C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ISearchRouteCallback f28750D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public ISearchOffRouteCallback f28751E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public INavigationInnerCallback f28752F;

    /* renamed from: G */
    private IBusinessEventCallback f28753G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f28754H = 0;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public AnimateNode f28755I;

    /* renamed from: J */
    private LatLng f28756J;

    /* renamed from: K */
    private LineOptions f28757K;

    /* renamed from: L */
    private LineOptions f28758L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public DMKEventPoint f28759M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public DMKEventPoint f28760N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public List<DMKEventPoint> f28761O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f28762P;

    /* renamed from: Q */
    private int f28763Q = 0;

    /* renamed from: R */
    private int f28764R = 0;

    /* renamed from: S */
    private long f28765S = 0;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public String f28766U = "";
    /* access modifiers changed from: private */

    /* renamed from: V */
    public int f28767V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public DriverStateChecker f28768W;

    /* renamed from: X */
    private double f28769X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public RouteGuidanceGPSPoint f28770Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public RouteGuidanceGPSPoint f28771Z;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public StreetViewInfo f28772aa;

    /* renamed from: ab */
    private RouteUnreachableHandler f28773ab;

    /* renamed from: ac */
    private RouteEvent f28774ac;

    /* renamed from: ad */
    private GuideRouteLine f28775ad;

    /* renamed from: ae */
    private List<OrderPoint> f28776ae;

    /* renamed from: af */
    private PushEdaHandler f28777af;

    /* renamed from: ag */
    private CallFrom f28778ag;

    /* renamed from: ah */
    private LatLng f28779ah;

    /* renamed from: ai */
    private int f28780ai = 0;

    /* renamed from: aj */
    private onCarAnimationListener f28781aj = new onCarAnimationListener() {
        public void onErase(int i, int i2, LatLng latLng) {
        }

        public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
            if (GoogleSctxDriver.this.f28800q != null) {
                GoogleSctxDriver.this.f28800q.updateFirstLineAll(list, list2);
            }
        }

        public void onErase(List<LatLng> list) {
            if (GoogleSctxDriver.this.f28800q != null && list != null && list.size() > 1) {
                GoogleSctxDriver.this.f28800q.updateFirstLineEX(list);
            }
        }
    };

    /* renamed from: ak */
    private OnLocationMatched f28782ak = new OnLocationMatched() {
        public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
        }

        public /* synthetic */ void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
            OnLocationMatched.CC.$default$onSctxSuspiciousJumpError(this, sctxInertiaSuspiciousStatus);
        }

        public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
            boolean z2;
            if (latLng == null || GoogleSctxDriver.this.f28749C == null || !GoogleSctxDriver.this.f28802s || GoogleSctxDriver.this.m20306i() || i >= GoogleSctxDriver.this.f28799p.size()) {
                DLog.m20357d(GoogleSctxDriver.f28742a, "onMatchRoute return at the beginning", new Object[0]);
            } else if (GoogleSctxDriver.this.f28761O == null) {
                DLog.m20357d(GoogleSctxDriver.f28742a, "onMatchRoute return because mEventPointList is null", new Object[0]);
            } else {
                if (!GoogleSctxDriver.this.f28761O.contains(dMKEventPoint)) {
                    GoogleSctxDriver.this.f28761O.add(dMKEventPoint);
                }
                DMKEventPoint unused = GoogleSctxDriver.this.f28759M = dMKEventPoint;
                if (GoogleSctxDriver.this.f28759M != null) {
                    DLog.m20357d(GoogleSctxDriver.f28742a, "onMatched mEventPoint geoIndex = " + GoogleSctxDriver.this.f28759M.geoIndex, new Object[0]);
                }
                if (!(GoogleSctxDriver.this.f28760N == null || GoogleSctxDriver.this.f28772aa == null || GoogleSctxDriver.this.f28748B == null)) {
                    int eventPointSize = GoogleSctxDriver.this.f28748B.getEventPointSize();
                    GoogleSctxDriver.this.f28772aa.isInTheLastEvent = i >= GoogleSctxDriver.this.f28760N.geoIndex;
                    DLog.m20357d(GoogleSctxDriver.f28742a, "StreetView event size is: " + eventPointSize + " segmentIndex: " + i + "last event geo index:" + GoogleSctxDriver.this.f28760N.geoIndex + " point:" + latLng.toString(), new Object[0]);
                }
                if (GoogleSctxDriver.this.f28768W != null) {
                    GoogleSctxDriver.this.f28768W.onMatched(latLng, i);
                }
                if (i == -1) {
                    GoogleSctxDriver.m20311l(GoogleSctxDriver.this);
                    DLog.m20357d(GoogleSctxDriver.f28742a, "onMatchRoute fail count = %d", Integer.valueOf(GoogleSctxDriver.this.f28754H));
                    if (GoogleSctxDriver.this.f28754H > 1) {
                        z2 = false;
                    } else {
                        return;
                    }
                } else {
                    DLog.m20357d(GoogleSctxDriver.f28742a, "onMatchRoute success. segmentIndex = " + i, new Object[0]);
                    if (GoogleSctxDriver.this.f28755I != null && GoogleSctxDriver.this.f28755I.index >= 0) {
                        if (i < GoogleSctxDriver.this.f28755I.index) {
                            DLog.m20357d(GoogleSctxDriver.f28742a, "onMatchRoute success return segmentIndex < last", new Object[0]);
                            return;
                        } else if (i == GoogleSctxDriver.this.f28755I.index && i2 <= GoogleSctxDriver.this.f28755I.offSet) {
                            DLog.m20357d(GoogleSctxDriver.f28742a, "onMatchRoute success return segmentIndex == last & shapeOffSet< last", new Object[0]);
                            return;
                        }
                    }
                    if (GoogleSctxDriver.this.f28747A != null && GoogleSctxDriver.this.f28762P) {
                        GoogleSctxDriver.this.f28747A.startEta();
                    }
                    GoogleSctxDriver googleSctxDriver = GoogleSctxDriver.this;
                    int unused2 = googleSctxDriver.f28808y = googleSctxDriver.getEda(latLng, i, i2);
                    if (GoogleSctxDriver.this.f28772aa != null) {
                        GoogleSctxDriver.this.f28772aa.realEDA = GoogleSctxDriver.this.f28808y;
                    }
                    GoogleSctxDriver.this.m20291c();
                    if (!(GoogleSctxDriver.this.f28748B == null || GoogleSctxDriver.this.f28748B.getLastMatchGPSPoint() == null)) {
                        GoogleSctxDriver googleSctxDriver2 = GoogleSctxDriver.this;
                        RouteGuidanceGPSPoint unused3 = googleSctxDriver2.f28770Y = googleSctxDriver2.f28748B.getLastMatchGPSPoint().originMatchPoint;
                        GoogleSctxDriver googleSctxDriver3 = GoogleSctxDriver.this;
                        RouteGuidanceGPSPoint unused4 = googleSctxDriver3.f28771Z = googleSctxDriver3.f28748B.getLastMatchGPSPoint();
                        if (GoogleSctxDriver.this.f28752F != null) {
                            GoogleSctxDriver.this.f28752F.onRoadSnappedLocationChanged(LocateUtils.convertToGpsLocation(GoogleSctxDriver.this.f28748B.getLastMatchGPSPoint()));
                        }
                    }
                    z2 = GoogleSctxDriver.this.f28754H <= 1 && i >= 0;
                    int unused5 = GoogleSctxDriver.this.f28754H = 0;
                }
                if (!(GoogleSctxDriver.this.f28755I == null || GoogleSctxDriver.this.f28761O.size() <= 1 || GoogleSctxDriver.this.f28761O.get(0) == null)) {
                    int i5 = ((DMKEventPoint) GoogleSctxDriver.this.f28761O.get(0)).geoIndex;
                    if (GoogleSctxDriver.this.f28755I.index >= i5) {
                        GoogleSctxDriver.this.f28761O.remove(0);
                    } else if (i > i5 && GoogleSctxDriver.this.f28759M.geoIndex > i5) {
                        GoogleSctxDriver googleSctxDriver4 = GoogleSctxDriver.this;
                        DMKEventPoint unused6 = googleSctxDriver4.f28759M = (DMKEventPoint) googleSctxDriver4.f28761O.get(0);
                    }
                }
                AnimateNode animateNode = new AnimateNode(latLng, i, i2, z2);
                if (i > 0) {
                    AnimateNode unused7 = GoogleSctxDriver.this.f28755I = animateNode;
                }
                if (GoogleSctxDriver.this.f28749C != null && GoogleSctxDriver.this.f28791h != null) {
                    GoogleSctxDriver.this.f28749C.animateTo(animateNode, GoogleSctxDriver.this.f28759M);
                }
            }
        }

        public void onOffRoute() {
            GoogleSctxDriver.this.m20288b();
        }
    };

    /* renamed from: al */
    private ISearchRouteCallback f28783al = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerEtaCallback onBeginToSearch()", new Object[0]);
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            NaviRoute naviRoute;
            DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerEtaCallback onFinishToSearch()", new Object[0]);
            if (GoogleSctxDriver.this.f28789f) {
                if (str.compareTo(GoogleSctxDriver.f28743b) == 0 && GoogleSctxDriver.this.f28752F != null) {
                    GoogleSctxDriver.this.f28752F.onViaPointExpired((List<LatLng>) null, 0);
                }
                if (arrayList != null && arrayList.size() > 0 && (naviRoute = arrayList.get(0)) != null) {
                    DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerEtaCallback newRoute eta" + naviRoute.getDistanceInfo() + "," + naviRoute.getTime(), new Object[0]);
                    int unused = GoogleSctxDriver.this.f28809z = naviRoute.getTime();
                    if (GoogleSctxDriver.this.f28752F != null) {
                        GoogleSctxDriver.this.f28752F.onReceiveETA(GoogleSctxDriver.this.f28809z);
                    }
                    GoogleSctxDriver googleSctxDriver = GoogleSctxDriver.this;
                    int unused2 = googleSctxDriver.f28767V = googleSctxDriver.f28809z;
                    String unused3 = GoogleSctxDriver.this.f28766U = naviRoute.getRouteId();
                    GoogleSctxDriver.this.m20291c();
                }
            }
        }
    };

    /* renamed from: am */
    private ISearchRouteCallback f28784am = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            if (GoogleSctxDriver.this.f28789f) {
                DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerOffRouteSearchRouteCallback onBeginToSearch()  vr ", new Object[0]);
            }
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            if (!GoogleSctxDriver.this.f28789f) {
                DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerOffRouteSearchRouteCallback onFinishToSearch() ok  vr, return at the entry", new Object[0]);
                return;
            }
            if (str.compareTo(GoogleSctxDriver.f28743b) == 0 && GoogleSctxDriver.this.f28752F != null) {
                GoogleSctxDriver.this.f28752F.onViaPointExpired((List<LatLng>) null, 0);
            }
            DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerOffRouteSearchRouteCallback onFinishToSearch() ok  entry", new Object[0]);
            if (!GoogleSctxDriver.this.m20284a(arrayList, true)) {
                DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerOffRouteSearchRouteCallback onFinishToSearch() fail  vr ", new Object[0]);
                if ((!TextUtils.isEmpty(str) && (str == null || str.equals("0") || str.compareTo(GoogleSctxDriver.f28743b) == 0)) || !GoogleSctxDriver.this.m20283a(str)) {
                    return;
                }
                if (GoogleSctxDriver.this.f28794k < GoogleSctxDriver.this.f28793j) {
                    DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerOffRouteSearchRouteCallback onFinishToSearch()  retry ", new Object[0]);
                    GoogleSctxDriver.m20325z(GoogleSctxDriver.this);
                    if (GoogleSctxDriver.this.f28747A != null) {
                        GoogleSctxDriver.this.f28747A.offRouteTryAgain();
                        return;
                    }
                    return;
                }
                int unused = GoogleSctxDriver.this.f28794k = 0;
                if (GoogleSctxDriver.this.f28751E != null) {
                    GoogleSctxDriver.this.f28751E.onRetryFail();
                }
                DLog.m20357d(GoogleSctxDriver.f28742a, "mInnerOffRouteSearchRouteCallback onFinishToSearch()  retry abort ", new Object[0]);
                return;
            }
            GoogleSctxDriver.this.m20300f();
            if (GoogleSctxDriver.this.f28751E != null) {
                GoogleSctxDriver.this.f28751E.onSuccess(arrayList);
            }
        }
    };

    /* renamed from: an */
    private ISearchRouteCallback f28785an = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            if (GoogleSctxDriver.this.f28750D != null) {
                GoogleSctxDriver.this.f28750D.onBeginToSearch();
                DLog.m20357d(GoogleSctxDriver.f28742a, "ISearchRouteCallback onBeginToSearch() ", new Object[0]);
            }
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            DLog.m20357d(GoogleSctxDriver.f28742a, "ISearchRouteCallback onFinishToSearch success", new Object[0]);
            if (GoogleSctxDriver.this.f28789f) {
                if (str.compareTo(GoogleSctxDriver.f28743b) == 0 && GoogleSctxDriver.this.f28752F != null) {
                    GoogleSctxDriver.this.f28752F.onViaPointExpired((List<LatLng>) null, 0);
                }
                if (GoogleSctxDriver.this.m20284a(arrayList, false)) {
                    DLog.m20357d(GoogleSctxDriver.f28742a, "ISearchRouteCallback route OK,  pickup point mPreOrderStage= " + PlatInfo.getInstance().getOrderStage(), new Object[0]);
                    if (GoogleSctxDriver.this.f28750D != null) {
                        GoogleSctxDriver.this.f28750D.onFinishToSearch(arrayList, str);
                        DLog.m20357d(GoogleSctxDriver.f28742a, "ISearchRouteCallback onFinishToSearch() ok  ", new Object[0]);
                        return;
                    }
                    return;
                }
                if (GoogleSctxDriver.this.f28750D != null) {
                    GoogleSctxDriver.this.f28750D.onFinishToSearch((ArrayList<NaviRoute>) null, str);
                    DLog.m20357d(GoogleSctxDriver.f28742a, "ISearchRouteCallback onFinishToSearch() fail ", new Object[0]);
                }
                if (!GoogleSctxDriver.this.m20283a(str)) {
                    return;
                }
                if (GoogleSctxDriver.this.f28794k < GoogleSctxDriver.this.f28793j) {
                    GoogleSctxDriver.m20325z(GoogleSctxDriver.this);
                    if (GoogleSctxDriver.this.f28747A != null) {
                        GoogleSctxDriver.this.f28747A.updateRoute(3);
                        return;
                    }
                    return;
                }
                int unused = GoogleSctxDriver.this.f28794k = 0;
                if (GoogleSctxDriver.this.f28747A != null) {
                    GoogleSctxDriver.this.f28747A.updateRoute(60);
                }
            }
        }
    };

    /* renamed from: ao */
    private int f28786ao = 0;

    /* renamed from: ap */
    private List<GpsLocation> f28787ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public CameraMode f28788aq = CameraMode.NORTH_UP;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f28789f = false;

    /* renamed from: g */
    private Context f28790g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Map f28791h;

    /* renamed from: i */
    private OrderInfo f28792i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f28793j = 3;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f28794k = 0;

    /* renamed from: l */
    private GpsLocation f28795l;

    /* renamed from: m */
    private GpsLocation f28796m;

    /* renamed from: n */
    private LatLng f28797n;

    /* renamed from: o */
    private NaviRoute f28798o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public List<LatLng> f28799p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public MultiLine f28800q;

    /* renamed from: r */
    private boolean f28801r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f28802s;

    /* renamed from: t */
    private BitmapDescriptor f28803t;

    /* renamed from: u */
    private float f28804u;

    /* renamed from: v */
    private boolean f28805v = false;

    /* renamed from: w */
    private boolean f28806w = false;

    /* renamed from: x */
    private boolean f28807x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f28808y = 0;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f28809z = 0;

    /* renamed from: a */
    private int m20268a(int i) {
        if (1 != i) {
            if (2 == i) {
                return 1;
            }
            if (4 == i) {
                return 2;
            }
        }
        return 0;
    }

    public int getRemainStraightDistance() {
        return 0;
    }

    /* renamed from: l */
    static /* synthetic */ int m20311l(GoogleSctxDriver googleSctxDriver) {
        int i = googleSctxDriver.f28754H;
        googleSctxDriver.f28754H = i + 1;
        return i;
    }

    /* renamed from: z */
    static /* synthetic */ int m20325z(GoogleSctxDriver googleSctxDriver) {
        int i = googleSctxDriver.f28794k;
        googleSctxDriver.f28794k = i + 1;
        return i;
    }

    /* renamed from: a */
    private Marker m20270a(int i, LatLng latLng, float f, float f2, float f3, int i2) {
        Context context;
        BitmapDescriptor fromResource;
        if (this.f28791h == null || (context = this.f28790g) == null || (fromResource = BitmapDescriptorFactory.fromResource(context, i)) == null) {
            return null;
        }
        MarkerOptions rotation = new MarkerOptions().anchor(f2, f3).icon(fromResource).position(new LatLng(latLng.latitude, latLng.longitude)).rotation(f);
        rotation.flat(true);
        rotation.zIndex(i2);
        try {
            return this.f28791h.addMarker(rotation);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m20281a() {
        OrderInfo orderInfo = this.f28792i;
        if (orderInfo == null) {
            return false;
        }
        if (orderInfo.getOrderStage() == 1 || this.f28792i.getOrderStage() == 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20288b() {
        DLog.m20357d(f28742a, "onOffRouteInCommon", new Object[0]);
        if (!this.f28762P) {
            DLog.m20357d(f28742a, "onOffRouteInCommon return because mRequestOra = false", new Object[0]);
            return;
        }
        m20280a(false);
        this.f28761O.clear();
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager == null || !fetcherManager.offRouteReq()) {
            DLog.m20357d(f28742a, "onOffRoute require busy", new Object[0]);
        } else {
            DLog.m20357d(f28742a, "onOffRoute send require ok", new Object[0]);
            AnimateNode animateNode = this.f28755I;
            if (animateNode != null) {
                this.f28756J = animateNode.latLng;
            }
            if (this.f28795l != null) {
                GpsLocation gpsLocation = new GpsLocation();
                this.f28796m = gpsLocation;
                gpsLocation.latitude = this.f28795l.latitude;
                this.f28796m.longitude = this.f28795l.longitude;
                this.f28796m.altitude = this.f28795l.altitude;
                this.f28796m.accuracy = this.f28795l.accuracy;
                this.f28796m.direction = this.f28795l.direction;
                this.f28796m.velocity = this.f28795l.velocity;
                this.f28796m.time = this.f28795l.time;
                this.f28796m.provider = this.f28795l.provider;
                this.f28796m.isCache = this.f28795l.isCache;
                this.f28796m.localTime = this.f28795l.localTime;
                this.f28796m.source = this.f28795l.source;
                m20310k();
            }
        }
        ISearchOffRouteCallback iSearchOffRouteCallback = this.f28751E;
        if (iSearchOffRouteCallback != null) {
            iSearchOffRouteCallback.onOffRoute();
        }
        INavigationInnerCallback iNavigationInnerCallback = this.f28752F;
        if (iNavigationInnerCallback != null) {
            iNavigationInnerCallback.onOffRoute();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        r3 = r10.getWayPoints();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m20284a(java.util.ArrayList<com.didi.map.sdk.sharetrack.entity.NaviRoute> r10, final boolean r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x016c
            int r1 = r10.size()
            if (r1 != 0) goto L_0x000b
            goto L_0x016c
        L_0x000b:
            java.util.List<com.map.sdk.nav.libc.common.DMKEventPoint> r1 = r9.f28761O
            r1.clear()
            java.lang.Object r10 = r10.get(r0)
            com.didi.map.sdk.sharetrack.entity.NaviRoute r10 = (com.didi.map.sdk.sharetrack.entity.NaviRoute) r10
            if (r10 == 0) goto L_0x016c
            java.util.List r1 = r10.getRoutePoints()
            if (r1 == 0) goto L_0x016c
            java.util.List r1 = r10.getRoutePoints()
            int r1 = r1.size()
            r2 = 1
            if (r1 <= r2) goto L_0x016c
            r9.f28798o = r10
            if (r11 != 0) goto L_0x0036
            com.didi.map.sdk.sharetrack.external.GoogleRouteOptManager r1 = com.didi.map.sdk.sharetrack.external.GoogleRouteOptManager.getInstance()
            com.didi.map.sdk.sharetrack.entity.NaviRoute r3 = r9.f28798o
            r1.updateRouteOpt(r3)
        L_0x0036:
            com.didi.map.sdk.sharetrack.entity.RouteEvent r1 = r9.f28774ac
            com.didi.map.sdk.sharetrack.entity.NaviRoute r3 = r9.f28798o
            r1.updateRoute(r3)
            java.util.List r1 = r10.getRoutePoints()
            r9.f28799p = r1
            if (r1 == 0) goto L_0x005a
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x005a
            java.util.List<com.didi.common.map.model.LatLng> r1 = r9.f28799p
            int r3 = r1.size()
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1
            r9.f28779ah = r1
        L_0x005a:
            r1 = 0
            r9.f28755I = r1
            com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager r3 = r9.f28747A
            if (r3 == 0) goto L_0x0075
            r3.setNaviRoute(r10)
            com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager r3 = r9.f28747A
            java.lang.String r4 = r10.getRouteId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            long r4 = r4.longValue()
            r3.setRouteId(r4)
        L_0x0075:
            com.didi.map.sdk.nav.line.MultiLine r3 = r9.f28800q
            r4 = -1
            if (r3 == 0) goto L_0x008b
            java.util.List r3 = r10.getWayPoints()
            if (r3 == 0) goto L_0x008b
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x008b
            int r3 = r10.getDstRouteGeoIndex()
            goto L_0x008c
        L_0x008b:
            r3 = -1
        L_0x008c:
            com.didi.common.map.Map r5 = r9.f28791h
            java.lang.String r6 = "GoogleSctxDriver"
            if (r5 == 0) goto L_0x00ca
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f28800q
            if (r5 == 0) goto L_0x00ca
            com.didi.common.map.model.LineOptions r7 = r9.f28757K
            com.didi.common.map.model.LineOptions r8 = r9.f28758L
            r5.setOptions(r7, r8)
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f28800q
            java.util.List r7 = r10.getRoutePoints()
            r5.setPoints(r7)
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f28800q
            boolean r7 = r9.f28801r
            r5.setVisible(r7)
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f28800q
            r5.init(r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "onRecvNewRoute mLineVisible= "
            r5.append(r7)
            boolean r7 = r9.f28801r
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r7 = new java.lang.Object[r0]
            com.didi.map.sdk.sharetrack.logger.DLog.m20357d(r6, r5, r7)
        L_0x00ca:
            r9.m20278a((com.didi.map.sdk.sharetrack.entity.NaviRoute) r10)
            r9.m20304h()
            r9.f28754H = r0
            com.didi.common.map.Map r5 = r9.f28791h
            if (r5 == 0) goto L_0x00eb
            com.didi.map.sdk.nav.car.IMyLocationDelegate r5 = r9.f28749C
            if (r5 == 0) goto L_0x00eb
            com.didi.map.sdk.nav.car.CarMarker r5 = r5.getCarMarker()
            if (r5 == 0) goto L_0x00eb
            com.didi.map.sdk.nav.car.IMyLocationDelegate r1 = r9.f28749C
            com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver$6 r4 = new com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver$6
            r4.<init>(r11, r10, r3)
            r1.animateCancel(r4)
            goto L_0x010c
        L_0x00eb:
            java.util.List r5 = r10.getRoutePoints()
            if (r3 <= r4) goto L_0x0100
            com.didi.map.sdk.nav.inertia.IInertiaDelegate r4 = r9.f28748B
            if (r4 == 0) goto L_0x0109
            int r3 = r3 + r2
            java.util.List r3 = r5.subList(r0, r3)
            r4.setRoutePoints(r3)
            r9.f28771Z = r1
            goto L_0x0109
        L_0x0100:
            com.didi.map.sdk.nav.inertia.IInertiaDelegate r3 = r9.f28748B
            if (r3 == 0) goto L_0x0109
            r3.setRoutePoints(r5)
            r9.f28771Z = r1
        L_0x0109:
            r9.m20308j()
        L_0x010c:
            java.lang.String r1 = r10.getDistanceInfo()     // Catch:{ Exception -> 0x011b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x011b }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x011b }
            r9.f28808y = r1     // Catch:{ Exception -> 0x011b }
            goto L_0x011f
        L_0x011b:
            r1 = 100
            r9.f28808y = r1
        L_0x011f:
            int r10 = r10.getTime()
            r9.f28809z = r10
            com.didi.map.sdk.sharetrack.entity.StreetViewInfo r10 = r9.f28772aa
            if (r10 == 0) goto L_0x013e
            int r1 = r9.f28808y
            r10.realEDA = r1
            com.didi.map.sdk.sharetrack.entity.StreetViewInfo r10 = r9.f28772aa
            java.util.List<com.didi.common.map.model.LatLng> r1 = r9.f28799p
            int r3 = r1.size()
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1
            r10.mLastRoutePoint = r1
        L_0x013e:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            int r1 = r9.f28809z
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10[r0] = r1
            int r0 = r9.f28808y
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "onRecvNewRoute init: eta= %d, eda = %d"
            com.didi.map.sdk.sharetrack.logger.DLog.m20357d(r6, r0, r10)
            r9.m20291c()
            com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback r10 = r9.f28752F
            if (r10 == 0) goto L_0x0164
            com.didi.map.sdk.sharetrack.entity.NaviRoute r0 = r9.f28798o
            if (r0 == 0) goto L_0x0164
            r10.onRouteUpdate(r0, r11)
        L_0x0164:
            com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager r10 = r9.f28747A
            if (r10 == 0) goto L_0x016b
            r10.startEta()
        L_0x016b:
            return r2
        L_0x016c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver.m20284a(java.util.ArrayList, boolean):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20291c() {
        INavigationInnerCallback iNavigationInnerCallback = this.f28752F;
        if (iNavigationInnerCallback != null) {
            iNavigationInnerCallback.onRemainingTimeOrDistanceChanged();
        }
        m20294d();
        m20298e();
    }

    /* renamed from: d */
    private void m20294d() {
        RouteEvent routeEvent;
        if (this.f28773ab != null && (routeEvent = this.f28774ac) != null) {
            routeEvent.updateEdaEta(this.f28808y, this.f28809z);
            if (this.f28773ab.dispatchEvent(this.f28774ac) && this.f28753G != null) {
                this.f28753G.onRouteUnreachableTts(this.f28808y, this.f28773ab.getCurUnreachableDis());
            }
        }
    }

    /* renamed from: e */
    private void m20298e() {
        PushEdaHandler pushEdaHandler;
        OrderInfo orderInfo = this.f28792i;
        if (orderInfo != null && orderInfo.getOrderStage() == 1 && (pushEdaHandler = this.f28777af) != null && pushEdaHandler.dispatchEvent(this.f28808y)) {
            this.f28747A.pushEdaToServer(this.f28808y);
        }
    }

    public int getEda(LatLng latLng, int i, int i2) {
        int i3;
        int i4;
        if (latLng == null || this.f28795l == null) {
            return 0;
        }
        if (this.f28748B != null) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
            routeGuidanceGPSPoint.point = geoPoint;
            routeGuidanceGPSPoint.accuracy = this.f28795l.accuracy;
            routeGuidanceGPSPoint.segmentIndex = i;
            routeGuidanceGPSPoint.heading = this.f28795l.direction;
            routeGuidanceGPSPoint.velocity = this.f28795l.velocity;
            routeGuidanceGPSPoint.timestamp = this.f28795l.time;
            routeGuidanceGPSPoint.source = this.f28795l.source;
            routeGuidanceGPSPoint.shapeOffSet = i2;
            i3 = this.f28748B.distanceLeft(routeGuidanceGPSPoint);
            DLog.m20357d(f28742a, "eda from NavBaseLib = " + i3, new Object[0]);
        } else {
            i3 = 0;
        }
        NaviRoute naviRoute = this.f28798o;
        if (naviRoute != null) {
            i4 = Integer.parseInt(naviRoute.getDistanceInfo());
            DLog.m20357d(f28742a, "eda from Ora = " + i4, new Object[0]);
            if (i3 <= i4) {
                return i3;
            }
        } else if (this.f28799p == null) {
            return i3;
        } else {
            DLog.m20357d(f28742a, "eda from outside = " + this.f28763Q, new Object[0]);
            i4 = this.f28763Q;
            if (i3 <= i4) {
                return i3;
            }
        }
        return i4;
    }

    public void mockOffRoute() {
        OnLocationMatched onLocationMatched = this.f28782ak;
        if (onLocationMatched != null) {
            onLocationMatched.onOffRoute();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m20300f() {
        double d;
        String str;
        String str2;
        GpsLocation gpsLocation = this.f28796m;
        if (gpsLocation == null) {
            DLog.m20357d(f28742a, "doOffRouteDistanceTrace  mOffRouteGps is null ", new Object[0]);
            return;
        }
        if (this.f28756J != null) {
            d = DDSphericalUtil.computeDistanceBetween(new LatLng(gpsLocation.latitude, this.f28796m.longitude), this.f28756J);
        } else {
            d = -999.0d;
            DLog.m20357d(f28742a, "doOffRouteDistanceTrace matched point is null, set distance -999", new Object[0]);
        }
        NaviRoute naviRoute = this.f28798o;
        if (naviRoute != null) {
            str = naviRoute.getRouteId();
        } else {
            str = this.f28799p != null ? String.valueOf(this.f28765S) : "unknown";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, str);
        hashMap.put("distance", Double.valueOf(d));
        hashMap.put("lat", Double.valueOf(this.f28796m.latitude));
        hashMap.put("lng", Double.valueOf(this.f28796m.longitude));
        hashMap.put(ServerParam.PARAM_ACCURACY, Integer.valueOf(this.f28796m.accuracy));
        hashMap.put("head", Float.valueOf(this.f28796m.direction));
        hashMap.put("speed", Float.valueOf(this.f28796m.velocity));
        hashMap.put("source", Integer.valueOf(this.f28796m.source));
        hashMap.put("driver_phone", PlatInfo.getInstance().getDriverPhoneNumber());
        hashMap.put("travelid", PlatInfo.getInstance().getTraverId());
        OrderInfo orderInfo = this.f28792i;
        if (orderInfo != null) {
            hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(m20268a(orderInfo.getOrderStage())));
            hashMap.put("order_id", this.f28792i.getOrderId());
        }
        String str3 = ",  accuracy = " + this.f28796m.accuracy + ", head=" + this.f28796m.direction + "speed = " + this.f28796m.velocity + this.f28796m.source;
        LatLng latLng = this.f28756J;
        if (latLng == null) {
            str2 = "mOffRouteMatchPoint is null";
        } else {
            str2 = latLng.toString();
        }
        DLog.m20357d(f28742a, " doOffRouteDistanceTrace: route_id=" + str + ", distance=" + d + ", matchPoint=" + str2 + ", [mOffRouteGps] lat=" + this.f28796m.latitude + ", lng=" + this.f28796m.longitude + str3, new Object[0]);
        GlobalDriverOmega.trackEvent("gd_raw_distance_res", hashMap);
        this.f28756J = null;
        this.f28796m = null;
    }

    public GoogleSctxDriver(Context context) {
        this.f28790g = context;
        FetcherManager fetcherManager = new FetcherManager(context);
        this.f28747A = fetcherManager;
        fetcherManager.setInnerEtaCallback(this.f28783al);
        this.f28747A.setInnerOffRouteSearchRouteCallback(this.f28784am);
        this.f28747A.setInnerSearchRouteCallback(this.f28785an);
        NetUtils.init(context);
        this.f28762P = true;
        this.f28761O = new ArrayList();
        this.f28769X = -1.0d;
        this.f28772aa = new StreetViewInfo();
        this.f28773ab = new RouteUnreachableHandler();
        this.f28774ac = new RouteEvent();
        this.f28777af = new PushEdaHandler();
    }

    public void setDiDiMap(Map map) {
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
        }
        this.f28791h = map;
        if (map == null) {
            MultiLine multiLine = this.f28800q;
            if (multiLine != null) {
                multiLine.remove();
                this.f28800q = null;
            }
        } else if (this.f28800q == null) {
            this.f28800q = new MultiLine(map);
        }
        IMyLocationDelegate create = MyLocation.create(this.f28791h);
        this.f28749C = create;
        create.setAnimationInterval(1000);
        this.f28749C.setIsBackground(false);
        this.f28749C.setCarAnimationListener(this.f28781aj);
        double d = this.f28769X;
        if (d > 0.0d) {
            this.f28749C.setCarHeadMaxMapLevel(d);
        }
        GuideRouteLine guideRouteLine = this.f28775ad;
        if (guideRouteLine != null) {
            guideRouteLine.remove();
            this.f28775ad = null;
        }
        Map map2 = this.f28791h;
        if (map2 != null) {
            this.f28775ad = new GuideRouteLine(map2);
        }
    }

    /* renamed from: g */
    private void m20302g() {
        IMyLocationDelegate iMyLocationDelegate;
        if (this.f28791h != null && (iMyLocationDelegate = this.f28749C) != null && iMyLocationDelegate.getCarMarker() == null && this.f28803t != null && this.f28795l != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.visible(this.f28802s);
            markerOptions.icon(this.f28803t);
            markerOptions.draggable(false);
            markerOptions.zIndex((int) this.f28804u);
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.flat(true);
            markerOptions.position(new LatLng(this.f28795l.latitude, this.f28795l.longitude));
            markerOptions.rotation(this.f28795l.direction);
            this.f28749C.setCarMarkerOptions("sharetrack", markerOptions);
        }
    }

    /* renamed from: h */
    private void m20304h() {
        if (this.f28748B == null) {
            InertiaEngine create = InertiaEngine.create(this.f28790g);
            this.f28748B = create;
            create.setOnLocationMatched(this.f28782ak);
            this.f28748B.setRequestIntervalInMills(1000);
            this.f28748B.setPredictionApolloParams(ApolloUtils.getSctxPredictionApolloParams());
            OrderInfo orderInfo = this.f28792i;
            if (orderInfo != null) {
                this.f28748B.setOrderInfo(orderInfo.getOrderId(), m20268a(this.f28792i.getOrderStage()));
            }
            DLog.m20357d(f28742a, "mGoogleNav: init", new Object[0]);
        }
    }

    public void setIsSctx(boolean z) {
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setIsSctx(z);
        }
    }

    /* renamed from: a */
    private void m20280a(boolean z) {
        DLog.m20357d(f28742a, "stopReqEta", new Object[0]);
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.CancelEta();
        }
        if (z) {
            IInertiaDelegate iInertiaDelegate = this.f28748B;
            if (iInertiaDelegate != null) {
                iInertiaDelegate.setRoutePoints((List<LatLng>) null);
                this.f28771Z = null;
            }
            IMyLocationDelegate iMyLocationDelegate = this.f28749C;
            if (iMyLocationDelegate != null) {
                iMyLocationDelegate.setNavRoutePoints((List<LatLng>) null, false);
            }
        }
    }

    public void setDestination(LatLng latLng) {
        this.f28797n = latLng;
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setDest(latLng);
        }
        RouteEvent routeEvent = this.f28774ac;
        if (routeEvent != null) {
            routeEvent.setPickUpPoint(latLng);
        }
    }

    public boolean isSctxStarted() {
        return this.f28789f;
    }

    public void start() {
        if (!this.f28789f) {
            this.f28789f = true;
            Map map = this.f28791h;
            if (map != null) {
                MultiLine multiLine = new MultiLine(map);
                this.f28800q = multiLine;
                multiLine.setOptions(this.f28757K, this.f28758L);
            }
            FetcherManager fetcherManager = this.f28747A;
            if (fetcherManager != null) {
                fetcherManager.initRoute();
            }
        }
    }

    public void stopNav() {
        this.f28789f = false;
        this.f28766U = "";
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setShouldShowRoute(true);
            this.f28747A.setNaviRoute((NaviRoute) null);
            this.f28747A.setRouteId(0);
        }
        MultiLine multiLine = this.f28800q;
        if (multiLine != null) {
            multiLine.remove();
            this.f28800q = null;
        }
        FetcherManager fetcherManager2 = this.f28747A;
        if (fetcherManager2 != null) {
            fetcherManager2.stop();
        }
        GuideRouteLine guideRouteLine = this.f28775ad;
        if (guideRouteLine != null) {
            guideRouteLine.remove();
            this.f28775ad = null;
        }
    }

    public void stop() {
        stopNav();
    }

    public void destroy() {
        stop();
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.destroy();
            this.f28747A = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
            this.f28749C = null;
        }
        IInertiaDelegate iInertiaDelegate = this.f28748B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f28748B = null;
        }
        this.f28761O = null;
        DriverStateChecker driverStateChecker = this.f28768W;
        if (driverStateChecker != null) {
            driverStateChecker.destroy();
            this.f28768W = null;
        }
    }

    public void pause4Navigation() {
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setIsBackground(true);
        }
    }

    public void resumeAfterNavigation() {
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setIsBackground(false);
        }
        onLocationChanged(this.f28795l, this.f28787ap);
    }

    public void setSearchRouteCallbck(ISearchRouteCallback iSearchRouteCallback) {
        this.f28750D = iSearchRouteCallback;
    }

    public void setSearchOffRouteCallback(ISearchOffRouteCallback iSearchOffRouteCallback) {
        this.f28751E = iSearchOffRouteCallback;
    }

    public void setNaviCallback(INavigationInnerCallback iNavigationInnerCallback) {
        this.f28752F = iNavigationInnerCallback;
    }

    public void setBusinessEventCallback(IBusinessEventCallback iBusinessEventCallback) {
        this.f28753G = iBusinessEventCallback;
    }

    public void setRetryCount(int i) {
        this.f28793j = i;
    }

    public void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        MultiLine multiLine = this.f28800q;
        if (multiLine == null || !multiLine.isVisible() || i5 < 0) {
            MultiLine multiLine2 = this.f28800q;
            if (multiLine2 != null && multiLine2.isVisible() && i5 == -1) {
                if (!(this.f28800q.mFirstLine == null || this.f28800q.mFirstLine.getBounderPoints() == null || this.f28800q.mFirstLine.getBounderPoints().size() <= 1)) {
                    arrayList.add(this.f28800q.mFirstLine);
                }
                if (!(this.f28800q.mFirstLine_Ex == null || this.f28800q.mFirstLine_Ex.getBounderPoints() == null || this.f28800q.mFirstLine_Ex.getBounderPoints().size() <= 1)) {
                    arrayList.add(this.f28800q.mFirstLine_Ex);
                }
                if (!(this.f28800q.mSecondLine == null || this.f28800q.mSecondLine.getBounderPoints() == null || this.f28800q.mSecondLine.getBounderPoints().size() <= 1)) {
                    arrayList.add(this.f28800q.mSecondLine);
                }
            }
        } else {
            if (!(this.f28800q.mFirstLine == null || this.f28800q.mFirstLine.getBounderPoints() == null || this.f28800q.mFirstLine.getBounderPoints().size() <= 1)) {
                arrayList.add(this.f28800q.mFirstLine);
            }
            if (!(this.f28800q.mFirstLine_Ex == null || this.f28800q.mFirstLine_Ex.getBounderPoints() == null || this.f28800q.mFirstLine_Ex.getBounderPoints().size() <= 1)) {
                arrayList.add(this.f28800q.mFirstLine_Ex);
            }
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        if (arrayList.size() == 0) {
            IMyLocationDelegate iMyLocationDelegate = this.f28749C;
            if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
                m20277a(this.f28749C.getCarMarker().getPosition(), i, i2, i3, i4);
                return;
            }
            return;
        }
        IMyLocationDelegate iMyLocationDelegate2 = this.f28749C;
        if (!(iMyLocationDelegate2 == null || iMyLocationDelegate2.getCarMarker() == null)) {
            arrayList.add(this.f28749C.getCarMarker());
        }
        Map map = this.f28791h;
        if (map != null) {
            BestViewer.doBestView(map, true, (List<IMapElement>) arrayList, map.getPadding(), new Padding(i, i3, i2, i4), (BestViewer.IBestViewListener) null);
        }
    }

    /* renamed from: a */
    private void m20277a(LatLng latLng, int i, int i2, int i3, int i4) {
        if (latLng != null && this.f28791h != null) {
            double m2L = C10194utils.m2L(f28746e, latLng.longitude);
            double m2L2 = C10194utils.m2L(f28746e, latLng.latitude);
            LatLng latLng2 = new LatLng(latLng.latitude - m2L2, latLng.longitude - m2L);
            this.f28791h.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(new LatLngBounds.Builder().include(latLng2).include(new LatLng(latLng.latitude + m2L2, latLng.longitude + m2L)).build(), i, i2, i3, i4));
        }
    }

    public void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor) {
        this.f28803t = bitmapDescriptor;
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null) {
            m20302g();
        } else {
            this.f28749C.getCarMarker().setIcon(this.f28790g, this.f28803t);
        }
    }

    public void setCarMarkerZindex(float f) {
        this.f28804u = f;
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f28749C.getCarMarker().setZIndex((int) this.f28804u);
        }
    }

    public void setRouteLineVisible(boolean z) {
        this.f28801r = z;
        MultiLine multiLine = this.f28800q;
        if (multiLine != null) {
            multiLine.setVisible(z);
        }
        GuideRouteLine guideRouteLine = this.f28775ad;
        if (guideRouteLine != null) {
            guideRouteLine.setVisible(z);
        }
        DLog.m20357d(f28742a, "setRouteLineVisible：" + z, new Object[0]);
    }

    public void setCarMarkerEnabled(boolean z) {
        this.f28802s = z;
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f28749C.getCarMarker().setVisible(this.f28802s);
        }
    }

    public void onLocationChanged(GpsLocation gpsLocation, List<GpsLocation> list) {
        IInertiaDelegate iInertiaDelegate;
        if (gpsLocation != null) {
            this.f28795l = gpsLocation;
            this.f28787ap = list;
            m20302g();
            if (list != null && this.f28786ao == 5) {
                DLog.m20357d(f28742a, "onLocationChanged  point=%f,%f|accuracy= %d|direction=%f|provider=%s|velocity=%f|time=%d,recentLocList= %d", Double.valueOf(gpsLocation.longitude), Double.valueOf(gpsLocation.latitude), Integer.valueOf(gpsLocation.accuracy), Float.valueOf(gpsLocation.direction), gpsLocation.provider, Float.valueOf(gpsLocation.velocity), Long.valueOf(gpsLocation.time), Integer.valueOf(list.size()));
                this.f28786ao++;
            }
            if (this.f28786ao >= 5) {
                this.f28786ao = 0;
            }
            FetcherManager fetcherManager = this.f28747A;
            if (fetcherManager != null) {
                fetcherManager.setStart(gpsLocation);
                this.f28747A.setRecentLocList(list);
            }
            if (!this.f28789f || (iInertiaDelegate = this.f28748B) == null) {
                IMyLocationDelegate iMyLocationDelegate = this.f28749C;
                if (iMyLocationDelegate != null && this.f28791h != null) {
                    iMyLocationDelegate.animateTo(new AnimateNode(new LatLng(gpsLocation.latitude, gpsLocation.longitude), -1, 0, false), this.f28759M);
                    return;
                }
                return;
            }
            iInertiaDelegate.onRecvDriverLocation(GGConverter.convertFromDiDiLocation(gpsLocation));
            this.f28748B.getMatchPoint(false);
            DLog.m20357d(f28742a, "getMatchPoint", new Object[0]);
        }
    }

    public void setLineOptions(LineOptions lineOptions, LineOptions lineOptions2) {
        this.f28757K = lineOptions;
        this.f28758L = lineOptions2;
        MultiLine multiLine = this.f28800q;
        if (multiLine != null) {
            multiLine.setOptions(lineOptions, lineOptions2);
        }
    }

    public void setGuideRouteLineOpt(LineOptions lineOptions) {
        Map map = this.f28791h;
        if (map != null) {
            GuideRouteLine guideRouteLine = this.f28775ad;
            if (guideRouteLine == null) {
                this.f28775ad = new GuideRouteLine(map, lineOptions);
            } else {
                guideRouteLine.setLineOpt(lineOptions);
            }
        }
    }

    public int getRemainTime(int i) {
        if (this.f28780ai == 2) {
            return 1;
        }
        return this.f28809z;
    }

    public int getRemainDistance(int i) {
        if (this.f28780ai == 2) {
            return 100;
        }
        return this.f28808y;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f28792i = orderInfo;
        if (orderInfo != null && PlatInfo.getInstance().getOrderStage() == -1) {
            DLog.m20357d(f28742a, "setOrderInfo" + orderInfo.toString(), new Object[0]);
            DLog.m20357d(f28742a, "PlatInfo.setOrderStage", new Object[0]);
            PlatInfo.getInstance().setOrderStage(orderInfo.getOrderStage());
        }
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setOrderInfo(this.f28792i);
        }
        if (this.f28790g != null && orderInfo != null && orderInfo.getOrderStage() == 1 && this.f28768W == null) {
            DriverStateChecker driverStateChecker = new DriverStateChecker(this.f28790g);
            this.f28768W = driverStateChecker;
            driverStateChecker.create();
        }
    }

    public MultiLine getLine() {
        return this.f28800q;
    }

    public void setOrderPoints(List<OrderPoint> list) {
        this.f28776ae = list;
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setPassPoints(list);
        }
        RouteEvent routeEvent = this.f28774ac;
        if (routeEvent != null) {
            routeEvent.setWayList(list);
        }
    }

    public void setMultiSctxGroup(String str) {
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setMultiSctxGroup(str);
        }
    }

    public void setOrderPointsTimeStamp(long j) {
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setPassPointTimeStamp(j);
        }
    }

    public List<OrderPoint> getPassPoints() {
        NaviRoute naviRoute = this.f28798o;
        ArrayList arrayList = null;
        if (naviRoute == null) {
            return null;
        }
        List<WayPoint> wayPoints = naviRoute.getWayPoints();
        if (wayPoints != null && wayPoints.size() > 0) {
            arrayList = new ArrayList();
            for (WayPoint wayPoint : wayPoints) {
                OrderPoint orderPoint = new OrderPoint();
                orderPoint.point = wayPoint.point;
                arrayList.add(orderPoint);
            }
        }
        return arrayList;
    }

    public void setIsPassNavi(boolean z) {
        DLog.m20357d(f28742a, "setIsPassNavi:" + z, new Object[0]);
    }

    public Marker getCarMarker() {
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null) {
            return null;
        }
        return this.f28749C.getCarMarker().getMarker();
    }

    public void setCameraMode(CameraMode cameraMode) {
        this.f28788aq = cameraMode;
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setCameraMode(cameraMode);
        }
    }

    public void followMyLocation(boolean z) {
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.followMyLocation(z);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.onNewMargin(i, i2, i3, i4);
        }
    }

    public void zoomToNav() {
        this.f28788aq = CameraMode.CAR_HEAD_UP;
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.zoomToNav();
        }
    }

    public void pauseRequestOra() {
        DLog.m20357d(f28742a, "pauseRequestOra called", new Object[0]);
        this.f28762P = false;
        m20280a(false);
    }

    public void resumeRequestOra() {
        DLog.m20357d(f28742a, "resumeRequestOra called", new Object[0]);
        this.f28762P = true;
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.startEta();
        }
    }

    public boolean isLightNavSctxPaused() {
        return !this.f28762P;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m20306i() {
        List<LatLng> list = this.f28799p;
        return list == null || list.size() == 0;
    }

    public void setOutSideRoute(final List<LatLng> list, int i, int i2, long j, GpsLocation gpsLocation) {
        if (gpsLocation != null) {
            this.f28795l = gpsLocation;
        }
        if (list == null || list.size() <= 1) {
            this.f28763Q = i2;
            this.f28764R = i;
            this.f28808y = i2;
            this.f28809z = i;
            StreetViewInfo streetViewInfo = this.f28772aa;
            if (streetViewInfo != null) {
                streetViewInfo.realEDA = i2;
            }
            DLog.m20357d(f28742a, "setOutSideRoute else: eta= %d, eda = %d", Integer.valueOf(this.f28809z), Integer.valueOf(this.f28808y));
            m20291c();
            return;
        }
        this.f28763Q = i2;
        this.f28764R = i;
        this.f28765S = j;
        if (this.f28791h != null) {
            this.f28798o = null;
            this.f28774ac.updateRoute((NaviRoute) null);
            this.f28799p = list;
            this.f28779ah = list.get(list.size() - 1);
            this.f28755I = null;
            FetcherManager fetcherManager = this.f28747A;
            if (fetcherManager != null) {
                fetcherManager.setNaviRoute((NaviRoute) null);
                this.f28747A.setRouteId(j);
            }
            MultiLine multiLine = this.f28800q;
            if (multiLine != null) {
                multiLine.setOptions(this.f28757K, this.f28758L);
                this.f28800q.setPoints(list);
                this.f28800q.setVisible(this.f28801r);
                this.f28800q.init(-1);
                DLog.m20357d(f28742a, "setOutSideRoute=" + this.f28801r, new Object[0]);
            }
            m20278a(this.f28798o);
            m20304h();
            this.f28754H = 0;
            IMyLocationDelegate iMyLocationDelegate = this.f28749C;
            if (!(iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null)) {
                this.f28749C.animateCancel(new onCarAnimationCancelListener(-1) {
                    public void onCancel() {
                        if (GoogleSctxDriver.this.f28749C != null && GoogleSctxDriver.this.f28749C.getCarMarker() != null) {
                            GoogleSctxDriver.this.f28749C.getCarMarker().setPosition((LatLng) list.get(0));
                            DLog.m20357d(GoogleSctxDriver.f28742a, "setOutSideRoute: the first point of the googleNav route : " + ((LatLng) list.get(0)).toString(), new Object[0]);
                            GoogleSctxDriver.this.f28749C.getCarMarker().setRotation((float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1)));
                            if (-1 > -1) {
                                GoogleSctxDriver.this.f28749C.setNavRoutePoints(list.subList(0, -1 + 1), true);
                                if (GoogleSctxDriver.this.f28748B != null) {
                                    GoogleSctxDriver.this.f28748B.setRoutePoints((List<LatLng>) list.subList(0, -1 + 1), true);
                                    RouteGuidanceGPSPoint unused = GoogleSctxDriver.this.f28771Z = null;
                                }
                            } else {
                                GoogleSctxDriver.this.f28749C.setNavRoutePoints(list, true);
                                if (GoogleSctxDriver.this.f28748B != null) {
                                    GoogleSctxDriver.this.f28748B.setRoutePoints(list);
                                    RouteGuidanceGPSPoint unused2 = GoogleSctxDriver.this.f28771Z = null;
                                }
                            }
                            GoogleSctxDriver.this.m20308j();
                        }
                    }
                });
            }
            this.f28808y = i2;
            this.f28809z = i;
            StreetViewInfo streetViewInfo2 = this.f28772aa;
            if (streetViewInfo2 != null) {
                streetViewInfo2.realEDA = i2;
            }
            DLog.m20357d(f28742a, "setOutSideRoute : eta= %d, eda = %d", Integer.valueOf(this.f28809z), Integer.valueOf(this.f28808y));
            m20291c();
            FetcherManager fetcherManager2 = this.f28747A;
            if (fetcherManager2 != null) {
                fetcherManager2.startEta();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m20308j() {
        ArrayList<DMKEventPoint> eventPointList;
        IInertiaDelegate iInertiaDelegate = this.f28748B;
        if (iInertiaDelegate != null && (eventPointList = iInertiaDelegate.getEventPointList()) != null) {
            StreetViewInfo streetViewInfo = this.f28772aa;
            if (streetViewInfo != null) {
                streetViewInfo.eventListSize = eventPointList.size();
            }
            if (this.f28799p != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<DMKEventPoint> it = eventPointList.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().geoIndex);
                    sb.append(";");
                }
                DLog.m20357d("StreetView event points: ", sb.toString(), new Object[0]);
            }
            if (this.f28772aa != null && eventPointList.size() <= 1) {
                this.f28772aa.lastTwoEventPoint = this.f28799p;
                this.f28772aa.isInTheLastEvent = true;
                this.f28760N = null;
                if (eventPointList.size() == 1) {
                    DMKEventPoint dMKEventPoint = eventPointList.get(0);
                    List<LatLng> list = this.f28799p;
                    if (list != null && list.size() > dMKEventPoint.geoIndex) {
                        this.f28772aa.lastEventPoint = this.f28799p.get(dMKEventPoint.geoIndex);
                    }
                }
                DLog.m20357d(f28742a, "StreetView: only one event point!!!", new Object[0]);
            } else if (this.f28772aa != null) {
                this.f28760N = eventPointList.get(eventPointList.size() - 2);
                this.f28772aa.lastTwoEventPoint = new ArrayList();
                int i = eventPointList.get(eventPointList.size() - 2).geoIndex;
                List<LatLng> list2 = this.f28799p;
                if (list2 != null && i >= 0 && i < list2.size()) {
                    StreetViewInfo streetViewInfo2 = this.f28772aa;
                    List<LatLng> list3 = this.f28799p;
                    streetViewInfo2.lastTwoEventPoint = list3.subList(i, list3.size());
                }
                DMKEventPoint dMKEventPoint2 = eventPointList.get(eventPointList.size() - 2);
                if (dMKEventPoint2 != null) {
                    int i2 = dMKEventPoint2.geoIndex;
                    List<LatLng> list4 = this.f28799p;
                    if (list4 != null && i2 >= 0 && i2 < list4.size()) {
                        StreetViewInfo streetViewInfo3 = this.f28772aa;
                        List<LatLng> list5 = this.f28799p;
                        streetViewInfo3.lastDistance = (int) DDSphericalUtil.computeDistanceBetween(list5.get(list5.size() - 1), this.f28799p.get(i2));
                        this.f28772aa.lastEventPoint = this.f28799p.get(i2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20283a(String str) {
        return ApolloUtils.isRetryRoute() && OraErrorCodeUtil.canBeRetry(str);
    }

    public void setCarHeadMaxMapLevel(double d) {
        this.f28769X = d;
        IMyLocationDelegate iMyLocationDelegate = this.f28749C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setCarHeadMaxMapLevel(d);
        }
    }

    public OrderInfo getOrderInfo() {
        return this.f28792i;
    }

    public GpsLocation getOriginGpsLocation() {
        return this.f28795l;
    }

    public RouteGuidanceGPSPoint getOriginMatchPoint() {
        return this.f28770Y;
    }

    public IMyLocationDelegate getMyLocationEngine() {
        return this.f28749C;
    }

    public RouteGuidanceGPSPoint getMatchedPoint() {
        return this.f28771Z;
    }

    public StreetViewInfo getStreetViewInfo() {
        StreetViewInfo streetViewInfo = this.f28772aa;
        if (streetViewInfo != null) {
            GpsLocation gpsLocation = this.f28795l;
            if (gpsLocation != null) {
                streetViewInfo.mOriginPoint = new LatLng(gpsLocation.latitude, this.f28795l.longitude);
            }
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f28771Z;
            if (!(routeGuidanceGPSPoint == null || routeGuidanceGPSPoint.point == null)) {
                this.f28772aa.mMatchedPoint = new LatLng(((double) this.f28771Z.point.getLatitudeE6()) / 1000000.0d, ((double) this.f28771Z.point.getLongitudeE6()) / 1000000.0d);
            }
        }
        return this.f28772aa;
    }

    /* renamed from: a */
    private void m20278a(NaviRoute naviRoute) {
        OrderInfo orderInfo;
        LatLng latLng;
        LatLng latLng2;
        List<OrderPoint> list;
        if (this.f28775ad != null && naviRoute != null && (orderInfo = this.f28792i) != null) {
            int orderStage = orderInfo.getOrderStage();
            if (orderStage != 1 && orderStage != 2) {
                this.f28775ad.remove();
            } else if (naviRoute.isShowPickUpGuideLine()) {
                if (!ApolloUtils.getBERGuideLineEnable()) {
                    this.f28775ad.remove();
                    return;
                }
                int dstRouteGeoIndex = naviRoute.getDstRouteGeoIndex();
                List<LatLng> routePoints = naviRoute.getRoutePoints();
                if (dstRouteGeoIndex < 0 || dstRouteGeoIndex >= routePoints.size() || (list = this.f28776ae) == null || list.size() <= 0) {
                    latLng = routePoints.get(routePoints.size() - 1);
                    latLng2 = this.f28797n;
                } else {
                    latLng = routePoints.get(dstRouteGeoIndex);
                    latLng2 = this.f28776ae.get(0).point;
                }
                double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
                if (computeDistanceBetween > ((double) ApolloUtils.getBERGuideLineDistance())) {
                    this.f28775ad.add(Arrays.asList(new LatLng[]{latLng2, latLng}));
                    m20276a(computeDistanceBetween);
                    return;
                }
                this.f28775ad.remove();
            }
        }
    }

    /* renamed from: a */
    private void m20276a(double d) {
        HashMap hashMap = new HashMap();
        OrderInfo orderInfo = this.f28792i;
        hashMap.put("order_id", orderInfo != null ? orderInfo.getOrderId() : "");
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId()));
        hashMap.put("distance", Double.valueOf(d));
        GlobalDriverOmega.trackEvent("map_route_guidance_sw", hashMap);
    }

    /* renamed from: k */
    private void m20310k() {
        HashMap hashMap = new HashMap();
        OrderInfo orderInfo = this.f28792i;
        hashMap.put("order_id", orderInfo != null ? orderInfo.getOrderId() : "");
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        GpsLocation gpsLocation = this.f28796m;
        Object obj = "-999";
        hashMap.put("deviate_lat", gpsLocation != null ? Double.valueOf(gpsLocation.latitude) : obj);
        GpsLocation gpsLocation2 = this.f28796m;
        if (gpsLocation2 != null) {
            obj = Double.valueOf(gpsLocation2.longitude);
        }
        hashMap.put("deviate_lng", obj);
        m20279a("map_deviate_driv_sw", (HashMap<String, Object>) hashMap, "trackOffRoutePoint");
    }

    /* renamed from: a */
    private void m20279a(String str, HashMap<String, Object> hashMap, String str2) {
        GlobalDriverOmega.trackEvent(str, hashMap);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> next : hashMap.entrySet()) {
            sb.append(" " + next.toString() + " ");
        }
        DLog.m20357d(str2, sb.toString(), new Object[0]);
    }

    public LatLng getRouteEndPoint() {
        return this.f28779ah;
    }

    public void setArriveStatus(int i) {
        DLog.m20357d(BaseRoundStrategy.TAG, "update arrive status: " + i, new Object[0]);
        this.f28780ai = i;
        m20291c();
    }

    public void setCaller(CallFrom callFrom) {
        this.f28778ag = callFrom;
        FetcherManager fetcherManager = this.f28747A;
        if (fetcherManager != null) {
            fetcherManager.setCaller(callFrom);
        }
    }
}
