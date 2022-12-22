package com.didi.map.global.component.departure.departure;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy1.IDMarkerContractV1;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.apolllo.LocFollowToggleApollo;
import com.didi.map.global.component.departure.bubble.DepartureWalkGuide;
import com.didi.map.global.component.departure.carpool.CarpoolDepartureController;
import com.didi.map.global.component.departure.circle.ZoneCircleController;
import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.controller.DepartureControllerParams;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.departure.DeparturePresenter;
import com.didi.map.global.component.departure.fence.FenceController;
import com.didi.map.global.component.departure.manager.DepartureOmegaManager;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.model.SpecialPois;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;
import com.didi.map.global.component.departure.pin.DeparturePinView;
import com.didi.map.global.component.departure.pin.IDeparturePinView;
import com.didi.map.global.component.departure.pin.IPinDrawer;
import com.didi.map.global.component.departure.util.DepartureOmegaUtils;
import com.didi.map.global.component.departure.util.DepartureStyleUtils;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.departure.util.FenceUtils;
import com.didi.map.global.component.departure.util.PinActionUtils;
import com.didi.map.global.component.departure.util.TerminalUtils;
import com.didi.map.global.component.departure.util.ThreadManager;
import com.didi.map.global.component.departure.view.DepartureCardViewController;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;
import com.didi.map.global.component.departure.view.RichTextInfo;
import com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper;
import com.didi.map.global.component.departure.walkdrop.WalkDropWrapper;
import com.didi.map.global.component.recmarker.IRecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerCallback;
import com.didi.map.global.component.recmarker.RecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerControllerParam;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.component.recmarker.view.IRecMarker;
import com.didi.map.global.component.recmarker.view.OnRecMarkClickListener;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DepartureView implements IDepartureView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f25074A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public AtomicBoolean f25075B;

    /* renamed from: C */
    private boolean f25076C;

    /* renamed from: D */
    private int f25077D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Handler f25078E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Padding f25079F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public Runnable f25080G;

    /* renamed from: H */
    private int f25081H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public DepartureInterceptController f25082I;

    /* renamed from: J */
    private boolean f25083J;

    /* renamed from: K */
    private LatLng f25084K;

    /* renamed from: L */
    private ICollideStrategy f25085L;

    /* renamed from: M */
    private boolean f25086M;

    /* renamed from: N */
    private boolean f25087N;

    /* renamed from: O */
    private DepartureAddress f25088O;

    /* renamed from: P */
    private DepartureWalkGuide f25089P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f25090Q;

    /* renamed from: R */
    private RpcPoi f25091R;

    /* renamed from: S */
    private long f25092S;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f25093a = "DepartureView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureCompParams f25094b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f25095c;

    /* renamed from: d */
    private Context f25096d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDepartureCompContract.IDepartureComponentCallback f25097e;

    /* renamed from: f */
    private boolean f25098f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDeparturePinView f25099g;

    /* renamed from: h */
    private FenceController f25100h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IRecMarkerController f25101i;

    /* renamed from: j */
    private DepartureCardViewController f25102j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CarpoolDepartureController f25103k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public DepartureOmegaManager f25104l = new DepartureOmegaManager();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ZoneCircleController f25105m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public DeparturePresenter f25106n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IWalkDropWrapper f25107o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f25108p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f25109q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f25110r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public DepartureLocationInfo f25111s;

    /* renamed from: t */
    private boolean f25112t = true;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public LatLng f25113u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<RpcPoi> f25114v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public DepartureAddress f25115w;

    /* renamed from: x */
    private MapListener f25116x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ReverseStationsInfo f25117y;

    /* renamed from: z */
    private DIDILocation f25118z;

    public DepartureView(Map map, Context context, DepartureCompParams departureCompParams) {
        DepartureLocationInfo departureLocationInfo = null;
        this.f25113u = null;
        this.f25114v = null;
        this.f25116x = new MapListener();
        this.f25074A = 0;
        this.f25075B = new AtomicBoolean(false);
        this.f25076C = false;
        this.f25078E = new Handler(Looper.getMainLooper());
        this.f25080G = new Runnable() {
            public void run() {
                if (DepartureView.this.f25075B.get() || DepartureView.this.f25108p) {
                    if (DepartureView.this.f25078E != null && DepartureView.this.f25079F != null) {
                        DepartureView.this.f25078E.postDelayed(DepartureView.this.f25080G, 100);
                    }
                } else if (DepartureView.this.f25095c != null && DepartureView.this.f25095c.getCameraPosition() != null && DepartureView.this.f25079F != null) {
                    if (DepartureView.this.f25079F == null || !DepartureView.this.f25079F.equals(DepartureView.this.f25095c.getPadding())) {
                        DepartureView departureView = DepartureView.this;
                        departureView.m17997g(departureView.f25095c.getCameraPosition().target);
                    }
                }
            }
        };
        this.f25091R = null;
        this.f25092S = System.currentTimeMillis();
        if (departureCompParams != null) {
            DepartureOmegaUtils.isFirst = true;
            this.f25095c = map;
            this.f25096d = context;
            this.f25094b = departureCompParams;
            this.f25081H = DisplayUtils.dp2px(context, 10.0f);
            this.f25079F = m18032y();
            DepartureCompParams departureCompParams2 = this.f25094b;
            this.f25111s = m17931a(departureCompParams2 != null ? departureCompParams2.getLocationInfo() : departureLocationInfo);
            m17933a();
            DeparturePresenter departurePresenter = new DeparturePresenter(map, context, departureCompParams);
            this.f25106n = departurePresenter;
            departurePresenter.setResponseCallback(new DeparturePresenter.IResponseCallback() {
                public void onLoading(LatLng latLng) {
                    if (DepartureView.this.f25094b.isBubbleVisible() && DepartureView.this.f25099g != null) {
                        DepartureView.this.f25099g.startLoading(DepartureView.this.m17979c(latLng) || DepartureView.this.m17986d(latLng));
                    }
                    if (DepartureView.this.f25097e != null) {
                        DepartureView.this.f25097e.onDepartureLoading(latLng);
                    }
                }

                public void onHandleResult(ReverseStationsInfo reverseStationsInfo) {
                    DepartureView.this.m17956a(reverseStationsInfo);
                }

                public void onLocationChange(DIDILocation dIDILocation) {
                    DepartureView.this.m17953a(dIDILocation);
                }
            });
            Address endPoint = this.f25094b.getEndPoint();
            if (endPoint != null) {
                this.f25084K = new LatLng(endPoint.getLatitude(), endPoint.getLongitude());
            }
            boolean isHasWayPoint = this.f25094b.isHasWayPoint();
            this.f25083J = isHasWayPoint;
            this.f25082I = new DepartureInterceptController(new DepartureControllerParams(this.f25096d, this.f25095c, this.f25077D, isHasWayPoint, this.f25084K, (DepartureAddress) null, this.f25100h));
        }
    }

    /* renamed from: a */
    private DepartureLocationInfo m17931a(DepartureLocationInfo departureLocationInfo) {
        DIDILocation lastKnownLocation;
        if (departureLocationInfo == null) {
            m17957a("初始化 locationInfo= null");
            departureLocationInfo = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
        } else {
            m17957a("初始化 locationInfo= " + departureLocationInfo.toString());
        }
        if (departureLocationInfo.sugPoi != null) {
            this.f25074A = departureLocationInfo.sugPoi.operationType;
            m17957a("初始化mInnerOperationType= " + this.f25074A);
        }
        if (departureLocationInfo.sugPoi != null && departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = new LatLng(departureLocationInfo.sugPoi.latitude, departureLocationInfo.sugPoi.longitude);
            m17957a("从sug初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureDataStore.getInstance().getPinLocation();
            m17957a("从缓存初始化latLng");
        }
        if (departureLocationInfo.latLng == null && (lastKnownLocation = LocationHelper.getLastKnownLocation(this.f25096d)) != null) {
            departureLocationInfo.latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            m17957a("从定位初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(this.f25095c);
            m17957a("从map初始化latLng");
        }
        if (departureLocationInfo.latLng != null) {
            m17957a("初始化latLng : " + departureLocationInfo.latLng.toString());
            return departureLocationInfo;
        }
        throw new IllegalArgumentException("departureView don't have a default location");
    }

    /* renamed from: a */
    private void m17933a() {
        DepartureCompParams departureCompParams = this.f25094b;
        if (departureCompParams != null) {
            DepartureFenceOptions fenceOptions = departureCompParams.getFenceOptions();
            if (fenceOptions != null) {
                this.f25100h = new FenceController(this.f25095c, fenceOptions);
            }
            ZoneCircleOption circleOption = this.f25094b.getCircleOption();
            if (circleOption != null) {
                this.f25105m = new ZoneCircleController(this.f25095c, circleOption, this.f25096d);
            }
            int sceneType = this.f25094b.getSceneType();
            this.f25077D = sceneType;
            if (sceneType == 1) {
                this.f25103k = new CarpoolDepartureController(this.f25095c, sceneType);
            }
            if (this.f25094b.isWalkDropVisible() || this.f25094b.isGuideLineVisible()) {
                WalkDropWrapper walkDropWrapper = new WalkDropWrapper(this.f25096d, this.f25095c);
                this.f25107o = walkDropWrapper;
                walkDropWrapper.setSceneType(this.f25077D);
                this.f25107o.setGuideLineEnable(this.f25094b.isGuideLineVisible());
                this.f25107o.setWalkDropEnable(this.f25094b.isWalkDropVisible());
                this.f25107o.setDestPoint(this.f25094b.getEndPoint());
                this.f25107o.onCreate();
            }
        }
    }

    /* renamed from: b */
    private void m17963b() {
        Map map = this.f25095c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f25116x);
            this.f25095c.addOnMapGestureListener(this.f25116x);
        }
    }

    /* renamed from: c */
    private void m17976c() {
        Map map = this.f25095c;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f25116x);
            this.f25095c.removeOnMapGestureListener(this.f25116x);
        }
    }

    /* renamed from: d */
    private boolean m17985d() {
        DepartureFenceOptions fenceOptions;
        if (!(!this.f25094b.isTerminalViewVisible() || (fenceOptions = this.f25094b.getFenceOptions()) == null || fenceOptions.cardWizardStart == 0)) {
            if (fenceOptions.cardWizardStart == 2) {
                return this.f25102j.isWelcomeViewValid();
            }
            if (fenceOptions.cardWizardStart == 1) {
                return this.f25102j.isWaitCheckPickupSpot();
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m17991e() {
        DepartureCompParams departureCompParams = this.f25094b;
        return departureCompParams != null && departureCompParams.isRecPointVisible() && (this.f25102j == null || !m17985d());
    }

    /* renamed from: f */
    private void m17993f() {
        DepartureCompParams departureCompParams = this.f25094b;
        if (departureCompParams != null && this.f25095c != null && departureCompParams.isPinVisible()) {
            m17996g();
            DeparturePinView departurePinView = new DeparturePinView(this.f25095c.getContext());
            this.f25099g = departurePinView;
            departurePinView.create(this.f25096d, this.f25095c);
            this.f25099g.setConfigParam(this.f25094b.getPinStyle());
            this.f25099g.add();
        }
    }

    public void registerCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        this.f25097e = iDepartureComponentCallback;
    }

    /* renamed from: g */
    private void m17996g() {
        IDeparturePinView iDeparturePinView = this.f25099g;
        if (iDeparturePinView != null) {
            iDeparturePinView.destroy();
            this.f25099g = null;
        }
    }

    /* renamed from: h */
    private void m17999h() {
        ZoneCircleController zoneCircleController = this.f25105m;
        if (zoneCircleController != null) {
            zoneCircleController.showCircle();
        }
    }

    /* renamed from: a */
    private void m17948a(DepartureAddress departureAddress) {
        DepartureCompParams departureCompParams;
        if (this.f25100h != null && (departureCompParams = this.f25094b) != null && departureCompParams.isFenceVisible()) {
            this.f25100h.showFence(departureAddress);
            ReverseStationsInfo reverseStationsInfo = this.f25117y;
            if (reverseStationsInfo != null) {
                this.f25100h.showAroundFenceList(reverseStationsInfo.aroundFenceList);
            }
        }
    }

    /* renamed from: a */
    private void m17958a(List<RecPoint> list, boolean z) {
        if (this.f25117y == null || CollectionUtil.isEmpty((Collection<?>) list) || this.f25094b == null || this.f25095c == null || this.f25096d == null) {
            m17957a("showRecMarkers() return");
            return;
        }
        m18004k();
        if (!m17991e()) {
            m17957a("showRecMarkers() isRecPointVisible is false,return");
            return;
        }
        RecMarkerController recMarkerController = new RecMarkerController();
        this.f25101i = recMarkerController;
        recMarkerController.create(this.f25095c.getContext(), this.f25095c);
        RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
        recMarkerControllerParam.list = list;
        RecPointStyle pinRecStyle = DepartureStyleUtils.getPinRecStyle(this.f25096d, this.f25094b);
        if (pinRecStyle != null) {
            recMarkerControllerParam.icon = pinRecStyle.icon;
            recMarkerControllerParam.selectedIcon = pinRecStyle.selectedIcon;
        }
        recMarkerControllerParam.isClickable = true;
        recMarkerControllerParam.markerClickListener = new OnRecMarkClickListener(z, list) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(IRecMarker iRecMarker) {
                DepartureView.this.m17959a(this.f$1, this.f$2, iRecMarker);
            }
        };
        recMarkerControllerParam.markerCallback = new RecMarkerCallback() {
            public void onRecMarkerShow(RecPoint recPoint, boolean z) {
                DepartureOmegaUtils.trackShowRecMarker(recPoint, z ? 1 : 0);
            }
        };
        recMarkerControllerParam.isShowLabel = false;
        ICollideStrategy collideStrategyV1 = CollideStrategyFactory.getCollideStrategyV1(new IDMarkerContractV1() {
            public /* synthetic */ int getDefaultLabelPosition() {
                return IDMarkerContractV1.CC.$default$getDefaultLabelPosition(this);
            }

            public /* synthetic */ List<Rect> getDisabledRect() {
                return IDMarkerContractV1.CC.$default$getDisabledRect(this);
            }

            public /* synthetic */ int getEnableLabelPosition() {
                return IDMarkerContractV1.CC.$default$getEnableLabelPosition(this);
            }

            public /* synthetic */ int getHot(String str) {
                return IDMarkerContractV1.CC.$default$getHot(this, str);
            }

            public /* synthetic */ boolean getIsLabelHideWhenPined() {
                return IDMarkerContractV1.CC.$default$getIsLabelHideWhenPined(this);
            }

            public boolean isCanWork() {
                return true;
            }

            public /* synthetic */ boolean isLabelDirectClockwise() {
                return IDMarkerContractV1.CC.$default$isLabelDirectClockwise(this);
            }

            public /* synthetic */ boolean isPined(String str) {
                return IDMarkerContractV1.CC.$default$isPined(this, str);
            }

            public /* synthetic */ boolean isZoomConditionOnly() {
                return IDMarkerContractV1.CC.$default$isZoomConditionOnly(this);
            }

            public /* synthetic */ void setLabelDirect(String str, int i) {
                IDMarkerContractV1.CC.$default$setLabelDirect(this, str, i);
            }

            public Map getMap() {
                return DepartureView.this.f25095c;
            }

            public void setVisible(String str, boolean z) {
                if (DepartureView.this.f25101i != null) {
                    DepartureView.this.f25101i.setVisible(str, z);
                }
            }
        });
        this.f25085L = collideStrategyV1;
        recMarkerControllerParam.strategy = collideStrategyV1;
        this.f25101i.setConfigParam(recMarkerControllerParam);
        this.f25101i.add();
        if (DepartureUtils.isAllowShowCircles(this.f25117y)) {
            this.f25101i.showCircles();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17959a(boolean z, List list, IRecMarker iRecMarker) {
        if (!LatLngUtils.isSameLatLng(iRecMarker.getLocation(), DepartureUtils.getMapCenterPoint(this.f25095c))) {
            DepartureCardViewController departureCardViewController = this.f25102j;
            boolean z2 = false;
            boolean z3 = departureCardViewController != null && departureCardViewController.isTerminalViewValid();
            if (!z || !z3) {
                RpcPoi findTargetRecommend = DepartureUtils.findTargetRecommend(iRecMarker.getLocation(), this.f25114v);
                this.f25115w = m17930a(findTargetRecommend);
                StringBuilder sb = new StringBuilder();
                sb.append("recMarker.Onclick adsorbPoi is null:");
                if (findTargetRecommend == null) {
                    z2 = true;
                }
                sb.append(z2);
                m17957a(sb.toString());
                if (findTargetRecommend != null) {
                    LatLng latLng = new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng);
                    this.f25113u = latLng;
                    if (z3) {
                        this.f25102j.setSelectedDeparture(findTargetRecommend);
                        m17954a(findTargetRecommend, this.f25113u, true, true);
                        this.f25104l.reportOmegaOnTerminalRecPickupChange(findTargetRecommend, 2);
                        return;
                    }
                    m17954a(findTargetRecommend, latLng, true, true);
                    m17966b(this.f25115w);
                    IWalkDropWrapper iWalkDropWrapper = this.f25107o;
                    if (iWalkDropWrapper != null) {
                        iWalkDropWrapper.onNormalAdsorbedOk(this.f25113u, this.f25115w);
                        return;
                    }
                    return;
                }
                return;
            }
            RecPoint findTargetRecPoint = DepartureUtils.findTargetRecPoint(iRecMarker.getLocation(), list);
            if (findTargetRecPoint != null && !TextUtils.isEmpty(findTargetRecPoint.addrName)) {
                SPoi adsorbTerminalAreaByName = TerminalUtils.getAdsorbTerminalAreaByName(m18018r(), findTargetRecPoint.addrName);
                m17951a(adsorbTerminalAreaByName);
                this.f25104l.setSelectedTerminalSPoi(adsorbTerminalAreaByName);
                this.f25102j.setSelectedTerminalArea(adsorbTerminalAreaByName);
                m17957a("recMarker.Onclick mTerminalView.isValid() is true");
                IWalkDropWrapper iWalkDropWrapper2 = this.f25107o;
                if (iWalkDropWrapper2 != null) {
                    iWalkDropWrapper2.onRspAirport();
                }
            }
        }
    }

    /* renamed from: i */
    private void m18001i() {
        FenceController fenceController = this.f25100h;
        if (fenceController != null) {
            fenceController.removeFence();
            this.f25100h.removeAroundFenceList();
        }
    }

    /* renamed from: j */
    private void m18003j() {
        ZoneCircleController zoneCircleController = this.f25105m;
        if (zoneCircleController != null) {
            zoneCircleController.hideCircle();
        }
    }

    /* renamed from: k */
    private void m18004k() {
        ICollideStrategy iCollideStrategy = this.f25085L;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f25085L = null;
        }
        IRecMarkerController iRecMarkerController = this.f25101i;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f25101i = null;
        }
    }

    public void setFenceVisible(boolean z) {
        FenceController fenceController = this.f25100h;
        if (fenceController != null) {
            fenceController.setFenceVisible(z);
        }
    }

    public void onMapVisible(boolean z) {
        this.f25098f = z;
    }

    class MapListener implements OnCameraChangeListener, OnMapGestureListener {
        public boolean onDoubleTap(float f, float f2) {
            return false;
        }

        public boolean onFling(float f, float f2) {
            return false;
        }

        public boolean onLongPress(float f, float f2) {
            return false;
        }

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        public boolean onUp(float f, float f2) {
            return false;
        }

        MapListener() {
        }

        public boolean onScroll(float f, float f2) {
            LatLng mapCenterPoint;
            boolean unused = DepartureView.this.f25110r = true;
            if (!DepartureView.this.f25109q) {
                DepartureView.this.m17957a("start dragging");
                if (DepartureView.this.f25101i != null) {
                    DepartureView.this.f25101i.onMapScroll();
                }
                if (!(DepartureView.this.f25105m == null || DepartureView.this.f25105m.getCircle() == null || (mapCenterPoint = DepartureUtils.getMapCenterPoint(DepartureView.this.f25095c)) == null || !DepartureView.this.f25105m.getCircle().contains(mapCenterPoint))) {
                    DepartureView.this.f25104l.reportOmegaChangeStartCircle(1);
                }
                if (DepartureView.this.f25103k != null) {
                    DepartureView.this.f25103k.removeCircle(true);
                }
                if (DepartureView.this.f25106n != null) {
                    DepartureView.this.f25106n.stopRequest();
                }
                if (DepartureView.this.f25082I != null) {
                    DepartureView.this.f25082I.setHasDragged(true);
                }
                if (DepartureView.this.f25107o != null) {
                    DepartureView.this.f25107o.onMapDragStart();
                }
            }
            DepartureOmegaUtils.OmegaParams.scrollType = 0;
            DepartureOmegaUtils.hasDragged = true;
            DepartureView.this.m18035z();
            boolean unused2 = DepartureView.this.f25109q = true;
            return false;
        }

        public boolean onDown(float f, float f2) {
            boolean unused = DepartureView.this.f25108p = true;
            if (DepartureView.this.f25078E != null) {
                DepartureView.this.f25078E.removeCallbacks(DepartureView.this.f25080G);
            }
            int unused2 = DepartureView.this.f25074A = 1;
            return false;
        }

        public void onMapStable() {
            DepartureView.this.m18007l();
            boolean unused = DepartureView.this.f25109q = false;
            boolean unused2 = DepartureView.this.f25108p = false;
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            if (DepartureView.this.f25095c != null) {
                if (DepartureView.this.f25105m != null) {
                    DepartureView.this.f25105m.handleMapDrag(DepartureUtils.getMapCenterPoint(DepartureView.this.f25095c));
                }
                if (DepartureView.this.f25107o != null) {
                    DepartureView.this.f25107o.onCameraChange(DepartureUtils.getMapCenterPoint(DepartureView.this.f25095c));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m18007l() {
        DepartureLocationInfo departureLocationInfo = this.f25111s;
        if (departureLocationInfo == null || !LatLngUtils.isSameLatLng(departureLocationInfo.latLng, DepartureUtils.getMapCenterPoint(this.f25095c))) {
            LatLng latLng = this.f25113u;
            if (latLng != null && LatLngUtils.isSameLatLng(latLng, DepartureUtils.getMapCenterPoint(this.f25095c))) {
                m17957a("handleMapStable 相同吸附点");
            } else if (this.f25110r) {
                IRecMarkerController iRecMarkerController = this.f25101i;
                if (!(iRecMarkerController == null || iRecMarkerController.findMarker(DepartureUtils.getMapCenterPoint(this.f25095c)) == null)) {
                    this.f25101i.hideCircles();
                }
                IRecMarkerController iRecMarkerController2 = this.f25101i;
                if (iRecMarkerController2 != null) {
                    iRecMarkerController2.setNeedShowInfoWindow(false);
                    this.f25101i.onMapStable();
                }
                if (this.f25094b.isRequireByDrag()) {
                    m17936a(DepartureUtils.getMapCenterPoint(this.f25095c));
                }
                IWalkDropWrapper iWalkDropWrapper = this.f25107o;
                if (iWalkDropWrapper != null) {
                    iWalkDropWrapper.onMapDragEnd();
                }
            }
        } else {
            m17957a("handleMapStable 相同请求点");
        }
    }

    /* renamed from: b */
    private boolean m17974b(DepartureLocationInfo departureLocationInfo) {
        return departureLocationInfo != null && LatLngUtils.locateCorrect(departureLocationInfo.latLng);
    }

    public void onConfirmClickInBroadOther() {
        this.f25090Q = false;
        this.f25086M = true;
        m17956a(this.f25117y);
    }

    public void setPadding(Padding padding) {
        if (this.f25095c != null && padding != null) {
            padding.left = Math.max(padding.left, this.f25081H);
            padding.right = Math.max(padding.right, this.f25081H);
            if (!this.f25095c.getPadding().equals(padding)) {
                this.f25079F = padding;
                DLog.m7384d("DepartureView", "setPadding ->: " + this.f25079F.toString(), new Object[0]);
                Handler handler = this.f25078E;
                if (handler != null) {
                    handler.removeCallbacks(this.f25080G);
                    this.f25078E.postDelayed(this.f25080G, 100);
                }
            }
        }
    }

    /* renamed from: a */
    private void m17936a(LatLng latLng) {
        DepartureLocationInfo departureLocationInfo;
        m17957a("doSomethingWhenMapStable =====" + latLng.toString());
        if (!LatLngUtils.locateCorrect(latLng) || (departureLocationInfo = this.f25111s) == null || !this.f25098f) {
            m17994f(latLng);
            m17957a("doSomethingWhenMapStable :异常情况");
        } else if (this.f25105m != null) {
            if (m17924B()) {
                LatLng center = this.f25105m.getCenter();
                if (!(this.f25111s.latLng == null || this.f25105m.getCircle() == null || !this.f25105m.getCircle().contains(this.f25111s.latLng))) {
                    center = this.f25111s.latLng;
                }
                m17990e(center);
                this.f25111s.latLng = center;
                m17957a("doSomethingWhenMapStable :修改上车点圆外");
            } else {
                this.f25111s.latLng = latLng;
                m17957a("doSomethingWhenMapStable :修改上车点圆内");
            }
            m17950a(this.f25111s, this.f25074A);
        } else if (this.f25117y == null) {
            departureLocationInfo.latLng = latLng;
            m17950a(this.f25111s, this.f25074A);
            m17957a("doSomethingWhenMapStable :首次移动地图");
        } else if (m17979c(latLng)) {
            RpcPoi findTargetRecommend = DepartureUtils.findTargetRecommend(latLng, this.f25114v);
            if (findTargetRecommend != null) {
                LatLng latLng2 = new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng);
                this.f25113u = latLng2;
                m17954a(findTargetRecommend, latLng2, true, true);
                DepartureAddress a = m17930a(findTargetRecommend);
                m17966b(a);
                if (!(this.f25107o == null || findTargetRecommend.base_info == null)) {
                    this.f25107o.onNormalAdsorbedOk(new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng), a);
                }
                m17957a("doSomethingWhenMapStable :禁停吸附");
                return;
            }
            this.f25111s.latLng = latLng;
            m17950a(this.f25111s, this.f25074A);
            m17957a("doSomethingWhenMapStable :禁停未吸附");
        } else {
            FenceController fenceController = this.f25100h;
            if (fenceController == null || fenceController.getFenceType() != 0) {
                DeparturePresenter departurePresenter = this.f25106n;
                RpcPoi sensing = departurePresenter != null ? departurePresenter.sensing(this.f25114v) : null;
                if (!(sensing == null || this.f25101i == null)) {
                    m17957a("doSomethingWhenMapStable is 5% poi");
                    LatLng latLng3 = new LatLng(sensing.base_info.lat, sensing.base_info.lng);
                    this.f25113u = latLng3;
                    if (this.f25101i.findMarker(latLng3) != null) {
                        m17954a(sensing, this.f25113u, true, true);
                        DepartureAddress a2 = m17930a(sensing);
                        m17966b(a2);
                        if (!(this.f25107o == null || sensing == null || sensing.base_info == null)) {
                            this.f25107o.onNormalAdsorbedOk(this.f25113u, a2);
                        }
                        m17957a("doSomethingWhenMapStable :普通场景吸附");
                        return;
                    }
                }
                m17957a("doSomethingWhenMapStable :普通场景未吸附");
                this.f25111s.latLng = latLng;
                m17950a(this.f25111s, this.f25074A);
                return;
            }
            IWalkDropWrapper iWalkDropWrapper = this.f25107o;
            if (iWalkDropWrapper != null) {
                iWalkDropWrapper.onRspAirport();
            }
            if (m17970b(latLng)) {
                m17957a("doSomethingWhenMapStable :场站外请求");
                this.f25111s.latLng = latLng;
                m17950a(this.f25111s, this.f25074A);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.sdk.poibase.model.RpcPoi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.didi.map.global.component.recmarker.model.RecPoint} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m17970b(com.didi.common.map.model.LatLng r9) {
        /*
            r8 = this;
            r0 = 0
            r8.f25087N = r0
            com.didi.common.map.Map r1 = r8.f25095c
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r8.f25117y
            com.sdk.poibase.model.poi.FenceInfo r2 = r2.startFenceInfo
            boolean r1 = com.didi.map.global.component.departure.util.FenceUtils.positionIsInFence(r1, r2, r9)
            r2 = 1
            if (r1 == 0) goto L_0x00bc
            boolean r1 = r8.f25090Q
            if (r1 == 0) goto L_0x0024
            r8.m17994f((com.didi.common.map.model.LatLng) r9)
            com.didi.map.global.component.departure.IDepartureCompContract$IDepartureComponentCallback r9 = r8.f25097e
            if (r9 == 0) goto L_0x001e
            r9.onBroadOtherMapCallback(r0)
        L_0x001e:
            java.lang.String r9 = "doSomethingWhenMapStable :不在此区域上车"
            r8.m17957a((java.lang.String) r9)
            return r0
        L_0x0024:
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f25102j
            if (r1 == 0) goto L_0x005f
            boolean r1 = r1.isTerminal()
            if (r1 == 0) goto L_0x005f
            com.didi.map.global.component.departure.model.SpecialPois r1 = r8.m18018r()
            java.util.List r1 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointList(r1)
            com.didi.map.global.component.recmarker.model.RecPoint r1 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecPoint(r9, r1)
            if (r1 == 0) goto L_0x0056
            java.lang.String r2 = r1.addrName
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0056
            com.didi.map.global.component.departure.model.SpecialPois r2 = r8.m18018r()
            java.lang.String r1 = r1.addrName
            com.didi.map.global.component.departure.model.SPoi r1 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r2, r1)
            r8.m17951a((com.didi.map.global.component.departure.model.SPoi) r1)
            com.didi.map.global.component.departure.view.DepartureCardViewController r2 = r8.f25102j
            r2.setSelectedTerminalArea(r1)
        L_0x0056:
            r8.m17994f((com.didi.common.map.model.LatLng) r9)
            java.lang.String r9 = "doSomethingWhenMapStable :吸附到功能区"
            r8.m17957a((java.lang.String) r9)
            return r0
        L_0x005f:
            java.util.List<com.sdk.poibase.model.RpcPoi> r1 = r8.f25114v
            com.sdk.poibase.model.RpcPoi r9 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r9, r1)
            if (r9 == 0) goto L_0x015b
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r9.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r5 = r9.base_info
            double r5 = r5.lng
            r1.<init>((double) r3, (double) r5)
            r8.f25113u = r1
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f25102j
            if (r1 == 0) goto L_0x00a4
            boolean r1 = r1.isTerminalViewValid()
            if (r1 == 0) goto L_0x00a4
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f25102j
            r1.setSelectedDeparture(r9)
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r8.f25101i
            if (r1 == 0) goto L_0x008e
            com.didi.common.map.model.LatLng r1 = r8.f25113u
            r8.m17954a(r9, r1, r2, r2)
        L_0x008e:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r1 = r8.f25104l
            com.didi.map.global.component.departure.view.DepartureCardViewController r3 = r8.f25102j
            com.didi.map.global.component.departure.model.SPoi r3 = r3.getSelectedTerminalArea()
            r1.setSelectedTerminalSPoi(r3)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r1 = r8.f25104l
            r1.reportOmegaOnTerminalRecPickupChange(r9, r2)
            java.lang.String r1 = "doSomethingWhenMapStable :吸附站场内的推荐点1 有卡片"
            r8.m17957a((java.lang.String) r1)
            goto L_0x00b2
        L_0x00a4:
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r8.f25101i
            if (r1 == 0) goto L_0x00ad
            com.didi.common.map.model.LatLng r1 = r8.f25113u
            r8.m17954a(r9, r1, r2, r2)
        L_0x00ad:
            java.lang.String r1 = "doSomethingWhenMapStable :吸附站场内的推荐点2 无卡片"
            r8.m17957a((java.lang.String) r1)
        L_0x00b2:
            com.didi.map.global.component.departure.model.DepartureAddress r9 = r8.m17930a((com.sdk.poibase.model.RpcPoi) r9)
            r8.m17966b((com.didi.map.global.component.departure.model.DepartureAddress) r9)
            r8.f25087N = r2
            return r0
        L_0x00bc:
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f25102j
            r3 = 0
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r1.isTerminal()
            if (r1 == 0) goto L_0x00fc
            com.didi.map.global.component.departure.model.SpecialPois r1 = r8.m18018r()
            java.util.List r1 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointList(r1)
            com.didi.map.global.component.departure.departure.DeparturePresenter r4 = r8.f25106n
            if (r4 == 0) goto L_0x00d7
            com.didi.map.global.component.recmarker.model.RecPoint r3 = r4.sensing_terminal(r1)
        L_0x00d7:
            if (r3 == 0) goto L_0x015b
            java.lang.String r1 = r3.addrName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x015b
            com.didi.map.global.component.departure.model.SpecialPois r1 = r8.m18018r()
            java.lang.String r2 = r3.addrName
            com.didi.map.global.component.departure.model.SPoi r1 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r1, r2)
            r8.m17951a((com.didi.map.global.component.departure.model.SPoi) r1)
            com.didi.map.global.component.departure.view.DepartureCardViewController r2 = r8.f25102j
            r2.setSelectedTerminalArea(r1)
            r8.m17994f((com.didi.common.map.model.LatLng) r9)
            java.lang.String r9 = "doSomethingWhenMapStable :吸附围栏外功能区"
            r8.m17957a((java.lang.String) r9)
            return r0
        L_0x00fc:
            com.didi.map.global.component.departure.departure.DeparturePresenter r9 = r8.f25106n
            if (r9 == 0) goto L_0x0106
            java.util.List<com.sdk.poibase.model.RpcPoi> r1 = r8.f25114v
            com.sdk.poibase.model.RpcPoi r3 = r9.sensing(r1)
        L_0x0106:
            if (r3 == 0) goto L_0x015b
            com.didi.common.map.model.LatLng r9 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r3.base_info
            double r4 = r1.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r3.base_info
            double r6 = r1.lng
            r9.<init>((double) r4, (double) r6)
            r8.f25113u = r9
            com.didi.map.global.component.departure.view.DepartureCardViewController r9 = r8.f25102j
            if (r9 == 0) goto L_0x0145
            boolean r9 = r9.isTerminalViewValid()
            if (r9 == 0) goto L_0x0145
            com.didi.map.global.component.departure.view.DepartureCardViewController r9 = r8.f25102j
            r9.setSelectedDeparture(r3)
            com.didi.map.global.component.recmarker.IRecMarkerController r9 = r8.f25101i
            if (r9 == 0) goto L_0x012f
            com.didi.common.map.model.LatLng r9 = r8.f25113u
            r8.m17954a(r3, r9, r2, r2)
        L_0x012f:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r9 = r8.f25104l
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f25102j
            com.didi.map.global.component.departure.model.SPoi r1 = r1.getSelectedTerminalArea()
            r9.setSelectedTerminalSPoi(r1)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r9 = r8.f25104l
            r9.reportOmegaOnTerminalRecPickupChange(r3, r2)
            java.lang.String r9 = "doSomethingWhenMapStable :吸附围栏外推荐点，有卡片"
            r8.m17957a((java.lang.String) r9)
            goto L_0x0153
        L_0x0145:
            com.didi.map.global.component.recmarker.IRecMarkerController r9 = r8.f25101i
            if (r9 == 0) goto L_0x014e
            com.didi.common.map.model.LatLng r9 = r8.f25113u
            r8.m17954a(r3, r9, r2, r2)
        L_0x014e:
            java.lang.String r9 = "doSomethingWhenMapStable :吸附围栏外推荐点，无卡片"
            r8.m17957a((java.lang.String) r9)
        L_0x0153:
            com.didi.map.global.component.departure.model.DepartureAddress r9 = r8.m17930a((com.sdk.poibase.model.RpcPoi) r3)
            r8.m17966b((com.didi.map.global.component.departure.model.DepartureAddress) r9)
            return r0
        L_0x015b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m17970b(com.didi.common.map.model.LatLng):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17950a(DepartureLocationInfo departureLocationInfo, int i) {
        boolean z = true;
        if (this.f25094b != null) {
            boolean z2 = CallFrom.PICKUP_PAGE == this.f25094b.getReqCallerId() && (departureLocationInfo.latLng == null || i == 0);
            this.f25076C = z2;
            if (z2) {
                LocFollowToggleApollo.initFollowApolloParam();
            }
        }
        if (!(this.f25106n == null || departureLocationInfo == null)) {
            this.f25111s = departureLocationInfo;
            CarpoolDepartureController carpoolDepartureController = this.f25103k;
            if (carpoolDepartureController != null) {
                carpoolDepartureController.drawCircle(departureLocationInfo.latLng);
            }
            this.f25074A = i;
            if (this.f25117y == null || i != 0) {
                z = false;
            }
            this.f25106n.startRequest(departureLocationInfo, i, z);
            m17957a("startPoiRequest..." + departureLocationInfo.latLng.toString());
        }
        IWalkDropWrapper iWalkDropWrapper = this.f25107o;
        if (iWalkDropWrapper != null) {
            iWalkDropWrapper.onRequestStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m17979c(LatLng latLng) {
        FenceController fenceController = this.f25100h;
        return fenceController != null && fenceController.isInFence(latLng) == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m17986d(LatLng latLng) {
        FenceController fenceController = this.f25100h;
        return fenceController != null && fenceController.isInFence(latLng) == 3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17956a(ReverseStationsInfo reverseStationsInfo) {
        if (this.f25098f) {
            DepartureCompParams departureCompParams = this.f25094b;
            if (departureCompParams == null || departureCompParams.getApiType() != ApiType.DEPARTURE_POI_INFO) {
                m17978c(reverseStationsInfo);
                this.f25112t = false;
                return;
            }
            if (this.f25090Q) {
                this.f25090Q = false;
            }
            m17969b(reverseStationsInfo);
            this.f25112t = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f6  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17969b(com.sdk.poibase.model.poi.ReverseStationsInfo r14) {
        /*
            r13 = this;
            java.lang.String r0 = "handlePoiResult()  start"
            r13.m17957a((java.lang.String) r0)
            if (r14 != 0) goto L_0x000b
            r13.m18015p()
            return
        L_0x000b:
            r0 = 1
            com.didi.map.global.component.departure.util.DepartureOmegaUtils.OmegaParams.type = r0
            r13.f25117y = r14
            r13.m18001i()
            r13.m18004k()
            java.util.ArrayList r14 = r14.getRecStartPoints()
            r13.f25114v = r14
            boolean r14 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r14)
            if (r14 == 0) goto L_0x002a
            com.sdk.poibase.model.poi.ReverseStationsInfo r14 = r13.f25117y
            java.util.List r14 = com.didi.map.global.component.departure.util.TerminalUtils.getSelectedSpecialRpcPoiList(r14)
            r13.f25114v = r14
        L_0x002a:
            java.util.List<com.sdk.poibase.model.RpcPoi> r14 = r13.f25114v
            com.sdk.poibase.model.RpcPoi r14 = com.didi.map.global.component.departure.util.DepartureUtils.findRecommendAdsorbPoint(r14)
            boolean r1 = r13.f25086M
            r2 = 0
            if (r1 == 0) goto L_0x0054
            com.didi.common.map.Map r1 = r13.f25095c
            com.didi.common.map.model.LatLng r1 = com.didi.map.global.component.departure.util.DepartureUtils.getMapCenterPoint(r1)
            com.sdk.poibase.model.poi.ReverseStationsInfo r3 = r13.f25117y
            com.didi.map.global.component.departure.model.SPoi r3 = com.didi.map.global.component.departure.util.TerminalUtils.getNearestSpoi(r1, r3)
            if (r3 == 0) goto L_0x0055
            java.util.List<com.sdk.poibase.model.RpcPoi> r4 = r3.list
            boolean r4 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r4)
            if (r4 != 0) goto L_0x0055
            java.util.List<com.sdk.poibase.model.RpcPoi> r14 = r3.list
            r13.f25114v = r14
            com.sdk.poibase.model.RpcPoi r14 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r1, r14)
            goto L_0x0055
        L_0x0054:
            r3 = r2
        L_0x0055:
            if (r14 == 0) goto L_0x0067
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r4 = r14.base_info
            double r4 = r4.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r6 = r14.base_info
            double r6 = r6.lng
            r1.<init>((double) r4, (double) r6)
            r13.f25113u = r1
            goto L_0x0078
        L_0x0067:
            boolean r1 = r13.f25086M
            if (r1 == 0) goto L_0x0071
            java.lang.String r1 = "handleResult() 场站内未找到吸附点"
            r13.m17957a((java.lang.String) r1)
            goto L_0x0076
        L_0x0071:
            java.lang.String r1 = "handleResult() 普通场景未找到吸附点"
            r13.m17957a((java.lang.String) r1)
        L_0x0076:
            r13.f25113u = r2
        L_0x0078:
            com.didi.map.global.component.departure.model.DepartureAddress r1 = r13.m17930a((com.sdk.poibase.model.RpcPoi) r14)
            r13.f25115w = r1
            r13.m17949a((com.didi.map.global.component.departure.model.DepartureAddress) r1, (com.sdk.poibase.model.RpcPoi) r14)
            boolean r1 = r13.f25086M
            r11 = 0
            if (r1 == 0) goto L_0x0091
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r13.f25102j
            if (r1 == 0) goto L_0x0091
            if (r1 == 0) goto L_0x008f
            r1.performSelectedArea(r3, r14)
        L_0x008f:
            r13.f25086M = r11
        L_0x0091:
            com.didi.map.global.component.departure.model.DepartureAddress r1 = r13.f25115w
            r13.m17948a((com.didi.map.global.component.departure.model.DepartureAddress) r1)
            com.didi.map.global.component.departure.model.SpecialPois r1 = r13.m18018r()
            java.util.List r1 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointListWithoutPointFirst(r1)
            boolean r3 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r1)
            if (r3 != 0) goto L_0x00a6
            r3 = r1
            goto L_0x00ac
        L_0x00a6:
            java.util.List<com.sdk.poibase.model.RpcPoi> r3 = r13.f25114v
            java.util.List r3 = com.didi.map.global.component.departure.util.TerminalUtils.getRecPointList(r3)
        L_0x00ac:
            com.sdk.poibase.model.poi.ReverseStationsInfo r4 = r13.f25117y
            boolean r12 = com.didi.map.global.component.departure.util.DepartureUtils.inAirportByTag(r4)
            com.didi.map.global.component.departure.view.DepartureCardViewController r4 = r13.f25102j
            if (r4 == 0) goto L_0x011f
            boolean r4 = r4.isValidAndTerminal()
            if (r4 == 0) goto L_0x011f
            boolean r4 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r1)
            if (r4 != 0) goto L_0x011f
            int r4 = r13.f25077D
            if (r4 == r0) goto L_0x011f
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r14 = r13.f25107o
            if (r14 == 0) goto L_0x00cd
            r14.onRspAirport()
        L_0x00cd:
            com.didi.common.map.Map r14 = r13.f25095c
            com.didi.common.map.model.LatLng r14 = com.didi.map.global.component.departure.util.DepartureUtils.getMapCenterPoint(r14)
            com.didi.map.global.component.recmarker.model.RecPoint r14 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecPoint(r14, r1)
            if (r14 == 0) goto L_0x0119
            java.lang.String r4 = r14.addrName
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x00e2
            goto L_0x0119
        L_0x00e2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleResult() 场站内-吸附,recPoint="
            r4.append(r5)
            com.didi.common.map.model.LatLng r5 = r14.location
            java.lang.String r5 = r5.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r13.m17957a((java.lang.String) r4)
            com.didi.map.global.component.departure.model.SpecialPois r4 = r13.m18018r()
            java.lang.String r5 = r14.addrName
            com.didi.map.global.component.departure.model.SPoi r4 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r4, r5)
            com.didi.map.global.component.departure.view.DepartureCardViewController r5 = r13.f25102j
            r5.setSelectedTerminalArea(r4)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r5 = r13.f25104l
            r5.setSelectedTerminalSPoi(r4)
            com.didi.common.map.model.LatLng r14 = r14.location
            r13.f25113u = r14
            r13.m17954a(r2, r14, r0, r0)
            goto L_0x01f1
        L_0x0119:
            java.lang.String r14 = "handleResult() 场站内-未吸附"
            r13.m17957a((java.lang.String) r14)
            return
        L_0x011f:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r2 = r13.f25104l
            r2.clearTerminalCache()
            if (r3 != 0) goto L_0x0169
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "handlePoiResult,is normal poi, mRecMakerController is null,mLocationInfo="
            r14.append(r0)
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r13.f25111s
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            r13.m17957a((java.lang.String) r14)
            com.didi.common.map.model.LatLng r14 = r13.m18026v()
            com.didi.map.global.component.departure.DepartureCompParams r0 = r13.f25094b
            boolean r0 = r0.isPinVisible()
            if (r0 != 0) goto L_0x0150
            com.didi.map.global.component.departure.DepartureCompParams r0 = r13.f25094b
            com.didi.map.global.component.departure.model.PinStyle r0 = r0.getPinStyle()
            if (r0 == 0) goto L_0x0153
        L_0x0150:
            r13.m17990e((com.didi.common.map.model.LatLng) r14)
        L_0x0153:
            com.didi.map.global.component.departure.model.DepartureAddress r14 = r13.f25115w
            r13.m17966b((com.didi.map.global.component.departure.model.DepartureAddress) r14)
            r13.m17926C()
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r14 = r13.f25107o
            if (r14 == 0) goto L_0x0168
            if (r12 == 0) goto L_0x0165
            r14.onRspAirport()
            goto L_0x0168
        L_0x0165:
            r14.onNormalReverseGeo()
        L_0x0168:
            return
        L_0x0169:
            com.didi.common.map.model.LatLng r2 = r13.f25113u
            if (r2 == 0) goto L_0x01c5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "handleResult() 普通推荐点-吸附: "
            r2.append(r4)
            com.didi.common.map.model.LatLng r4 = r13.f25113u
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r13.m17957a((java.lang.String) r2)
            boolean r2 = r13.m17961a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3)
            if (r2 == 0) goto L_0x019a
            com.didi.common.map.model.LatLng r6 = r13.f25113u
            r7 = 1
            r8 = 1
            r9 = 1
            r10 = 1101004800(0x41a00000, float:20.0)
            r4 = r13
            r5 = r14
            r4.m17955a(r5, r6, r7, r8, r9, r10)
            goto L_0x019f
        L_0x019a:
            com.didi.common.map.model.LatLng r2 = r13.f25113u
            r13.m17954a(r14, r2, r0, r0)
        L_0x019f:
            com.didi.map.global.component.departure.model.DepartureAddress r2 = r13.f25115w
            if (r2 == 0) goto L_0x01ae
            int r2 = r2.getZoneType()
            if (r2 != 0) goto L_0x01ae
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r2 = r13.f25104l
            r2.setDefaultRecTerminalPickupPoi(r14)
        L_0x01ae:
            com.didi.map.global.component.departure.view.DepartureCardViewController r14 = r13.f25102j
            if (r14 == 0) goto L_0x01c3
            boolean r14 = r14.isTerminalViewValid()
            if (r14 == 0) goto L_0x01c3
            com.didi.map.global.component.departure.view.DepartureCardViewController r14 = r13.f25102j
            com.didi.map.global.component.departure.model.SPoi r14 = r14.getSelectedTerminalArea()
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r2 = r13.f25104l
            r2.setSelectedTerminalSPoi(r14)
        L_0x01c3:
            r14 = 1
            goto L_0x01f2
        L_0x01c5:
            java.lang.String r14 = "handleResult() 普通推荐点-未吸附"
            r13.m17957a((java.lang.String) r14)
            boolean r14 = r13.m17961a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3)
            if (r14 == 0) goto L_0x01f1
            com.didi.common.map.Map r14 = r13.f25095c
            if (r14 == 0) goto L_0x01f1
            com.didi.common.map.model.CameraPosition r14 = r14.getCameraPosition()
            if (r14 == 0) goto L_0x01f1
            com.didi.common.map.Map r4 = r13.f25095c
            r5 = 1
            r14 = 1101004800(0x41a00000, float:20.0)
            java.lang.Float r6 = java.lang.Float.valueOf(r14)
            com.didi.common.map.Map r14 = r13.f25095c
            com.didi.common.map.model.CameraPosition r14 = r14.getCameraPosition()
            com.didi.common.map.model.LatLng r7 = r14.target
            com.didi.common.map.model.Padding r8 = r13.f25079F
            r9 = 0
            com.didi.common.map.BestViewer.doBestView((com.didi.common.map.Map) r4, (boolean) r5, (java.lang.Float) r6, (com.didi.common.map.model.LatLng) r7, (com.didi.common.map.model.Padding) r8, (com.didi.common.map.BestViewer.IBestViewListener) r9)
        L_0x01f1:
            r14 = 0
        L_0x01f2:
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r2 = r13.f25107o
            if (r2 == 0) goto L_0x0224
            if (r12 == 0) goto L_0x01fc
            r2.onRspAirport()
            goto L_0x0213
        L_0x01fc:
            if (r14 == 0) goto L_0x0208
            com.didi.common.map.model.LatLng r4 = r13.f25113u
            if (r4 == 0) goto L_0x0208
            com.didi.map.global.component.departure.model.DepartureAddress r5 = r13.f25115w
            r2.onNormalAdsorbedOk(r4, r5)
            goto L_0x0213
        L_0x0208:
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r2 = r13.f25107o
            com.didi.common.map.Map r4 = r13.f25095c
            com.didi.common.map.model.LatLng r4 = com.didi.map.global.component.departure.util.DepartureUtils.getMapCenterPoint(r4)
            r2.onNormalAdsorbedFail(r4)
        L_0x0213:
            if (r14 != 0) goto L_0x021d
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r14 = r13.f25107o
            boolean r14 = r14.isRecMarkerVisible()
            if (r14 == 0) goto L_0x022a
        L_0x021d:
            if (r1 == 0) goto L_0x0220
            r11 = 1
        L_0x0220:
            r13.m17958a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3, (boolean) r11)
            goto L_0x022a
        L_0x0224:
            if (r1 == 0) goto L_0x0227
            r11 = 1
        L_0x0227:
            r13.m17958a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3, (boolean) r11)
        L_0x022a:
            int r14 = r13.f25077D
            if (r14 != r0) goto L_0x0231
            r13.m18001i()
        L_0x0231:
            com.didi.map.global.component.departure.model.DepartureAddress r14 = r13.f25115w
            r13.m17966b((com.didi.map.global.component.departure.model.DepartureAddress) r14)
            r13.m17926C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m17969b(com.sdk.poibase.model.poi.ReverseStationsInfo):void");
    }

    /* renamed from: a */
    private boolean m17961a(List<RecPoint> list) {
        IDeparturePinView iDeparturePinView;
        if (this.f25112t && this.f25095c != null) {
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                for (RecPoint next : list) {
                    IDeparturePinView iDeparturePinView2 = this.f25099g;
                    if (iDeparturePinView2 != null && DepartureUtils.LatLngIsInRect(this.f25095c, iDeparturePinView2.getWindowPosition(), next.location)) {
                        DLog.m7384d(this.f25093a, "吸附点被遮挡", new Object[0]);
                        return true;
                    }
                }
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f25096d);
            if (lastKnownLocation == null || (iDeparturePinView = this.f25099g) == null || !DepartureUtils.LatLngIsInRect(this.f25095c, iDeparturePinView.getWindowPosition(), new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()))) {
                DLog.m7384d(this.f25093a, "无遮挡", new Object[0]);
            } else {
                DLog.m7384d(this.f25093a, "定位点被遮挡", new Object[0]);
                return true;
            }
        }
        this.f25112t = false;
        return false;
    }

    /* renamed from: c */
    private void m17978c(ReverseStationsInfo reverseStationsInfo) {
        DepartureOmegaUtils.OmegaParams.type = 0;
        if (reverseStationsInfo != null) {
            DepartureAddress a = m17930a((RpcPoi) null);
            this.f25115w = a;
            if (a != null) {
                m17990e(m18026v());
                this.f25117y = reverseStationsInfo;
                PinActionUtils.startAdsorbRecommendAnimation((IPinDrawer) null, 10, (DepartureMarkerView.AnimationFinishListener) null);
                m17966b(this.f25115w);
                return;
            }
        }
        m17957a("handleReverseGeoResult() is null, return.");
        m18015p();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17954a(RpcPoi rpcPoi, LatLng latLng, boolean z, boolean z2) {
        m17955a(rpcPoi, latLng, z, z2, false, this.f25094b.getZoom());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17955a(com.sdk.poibase.model.RpcPoi r15, com.didi.common.map.model.LatLng r16, boolean r17, boolean r18, boolean r19, float r20) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            if (r1 != 0) goto L_0x000c
            if (r16 != 0) goto L_0x000c
            java.lang.String r1 = "animateToAdsorbPoi() is null, return."
            r14.m17957a((java.lang.String) r1)
            return
        L_0x000c:
            boolean r2 = r14.m17991e()
            if (r2 != 0) goto L_0x0018
            java.lang.String r1 = "animateToAdsorbPoi() recMarkerShowable is false, return."
            r14.m17957a((java.lang.String) r1)
            return
        L_0x0018:
            java.lang.String r2 = "animateToAdsorbPoi 吸附开始"
            r14.m17957a((java.lang.String) r2)
            com.didi.map.global.component.departure.util.DepartureOmegaUtils.mapDragRecommend(r15)
            r2 = 0
            if (r1 == 0) goto L_0x0035
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r1.base_info
            if (r3 == 0) goto L_0x0035
            com.didi.common.map.model.LatLng r2 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r1.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r1.base_info
            double r5 = r1.lng
            r2.<init>((double) r3, (double) r5)
            goto L_0x003a
        L_0x0035:
            if (r16 == 0) goto L_0x003a
            r8 = r16
            goto L_0x003b
        L_0x003a:
            r8 = r2
        L_0x003b:
            if (r8 == 0) goto L_0x0066
            com.didi.map.global.component.departure.DepartureCompParams r1 = r0.f25094b
            if (r1 != 0) goto L_0x0042
            goto L_0x0066
        L_0x0042:
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r0.f25101i
            if (r1 == 0) goto L_0x004b
            com.didi.map.global.component.recmarker.RecMarkerController r1 = (com.didi.map.global.component.recmarker.RecMarkerController) r1
            r1.updateMarkerPinedState(r8)
        L_0x004b:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f25075B
            r2 = 1
            r1.set(r2)
            com.didi.common.map.Map r7 = r0.f25095c
            r9 = 1
            com.didi.common.map.model.Padding r12 = r0.f25079F
            com.didi.map.global.component.departure.departure.DepartureView$5 r13 = new com.didi.map.global.component.departure.departure.DepartureView$5
            r1 = r17
            r2 = r18
            r13.<init>(r1, r2, r8)
            r10 = r19
            r11 = r20
            com.didi.map.global.component.departure.util.PinActionUtils.animateCamera(r7, r8, r9, r10, r11, r12, r13)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m17955a(com.sdk.poibase.model.RpcPoi, com.didi.common.map.model.LatLng, boolean, boolean, boolean, float):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m17990e(LatLng latLng) {
        if (latLng != null) {
            boolean z = (this.f25105m == null && this.f25103k == null) ? this.f25074A == 0 : false;
            this.f25075B.set(true);
            PinActionUtils.animateCamera(this.f25095c, latLng, true, z, this.f25094b.getZoom(), this.f25079F, new BestViewer.IBestViewListener() {
                public void onFinished() {
                    DepartureView.this.f25075B.set(false);
                    int t = DepartureView.this.m17921A();
                    if (DepartureView.this.f25097e != null) {
                        DepartureView.this.f25097e.onDragging(t);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private void m17994f(LatLng latLng) {
        if (this.f25094b.isBubbleVisible() && this.f25099g != null) {
            DepartureCardViewController departureCardViewController = this.f25102j;
            boolean z = true;
            if (departureCardViewController == null || !departureCardViewController.isTerminalViewValid() || this.f25102j.isWelcomeViewValid() || this.f25102j.isTerminal() || this.f25102j.isWaitCheckPickupSpot() || this.f25077D == 1) {
                z = false;
            }
            AddressWalkGuide n = m18011n();
            if (n == null || !z) {
                if (m17979c(latLng) || m17986d(latLng)) {
                    this.f25099g.toNoParking();
                } else if (m18009m()) {
                    this.f25099g.startDragging_Ex();
                } else {
                    String o = m18013o();
                    DepartureCardViewController departureCardViewController2 = this.f25102j;
                    if (departureCardViewController2 != null && (departureCardViewController2.isWelcomeViewValid() || this.f25102j.isWaitCheckPickupSpot() || this.f25102j.isTerminal())) {
                        o = this.f25095c.getContext().getString(R.string.GRider_Homepage0714_Get_in_tpiW);
                    } else if (TextUtils.isEmpty(o)) {
                        o = this.f25095c.getContext().getString(R.string.GRider_Homepage0714_Get_on_XNNb);
                    }
                    this.f25099g.showText(o);
                }
            } else if (this.f25087N) {
                this.f25087N = false;
                m17957a("场站上车点已经刷新过实景图!!!");
                return;
            } else {
                if (this.f25089P == null) {
                    DepartureWalkGuide departureWalkGuide = new DepartureWalkGuide(this.f25095c.getContext());
                    this.f25089P = departureWalkGuide;
                    departureWalkGuide.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            DepartureView.this.m17935a(view);
                        }
                    });
                }
                this.f25089P.setData(n);
                IDeparturePinView iDeparturePinView = this.f25099g;
                DepartureWalkGuide departureWalkGuide2 = this.f25089P;
                iDeparturePinView.showView(departureWalkGuide2, departureWalkGuide2.getWIDTH(), this.f25089P.getHEIGHT(), this.f25089P.getANGLE());
                m17957a("场站上车点刷新实景图");
            }
        }
        ThreadManager.getHandler(0).postDelayed(new Runnable() {
            public void run() {
                DepartureOmegaUtils.trackPinMove(DepartureUtils.getMapCenterPoint(DepartureView.this.f25095c));
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17935a(View view) {
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f25097e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onClickBubble();
        }
    }

    /* renamed from: m */
    private boolean m18009m() {
        DepartureCompParams departureCompParams = this.f25094b;
        if (departureCompParams == null || departureCompParams.getReqCallerId() == null) {
            return false;
        }
        if (this.f25094b.getReqCallerId().equals(CallFrom.GLOBAL_ENDSUG_DRAG) || this.f25094b.getReqCallerId().equals(CallFrom.GLOBAL_STARTSUG_DRAG) || this.f25094b.getReqCallerId().equals(CallFrom.GLOBAL_FROMBUBBLE_ENDSUG_DRAG) || this.f25094b.getReqCallerId().equals(CallFrom.GLOBAL_FROMBUBBLE_STARTSUG_DRAG) || this.f25094b.getReqCallerId().equals(CallFrom.GLOBAL_FROMHOME_ENDSUG_DRAG) || this.f25094b.getReqCallerId().equals(CallFrom.GLOBAL_FROMHOME_STARTSUG_DRAG)) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    private AddressWalkGuide m18011n() {
        DepartureAddress departureAddress = this.f25088O;
        if (departureAddress == null || departureAddress.getExtendInfo() == null || this.f25088O.getExtendInfo().getWalkGuide() == null || !this.f25088O.getExtendInfo().getWalkGuide().isValid()) {
            return null;
        }
        return this.f25088O.getExtendInfo().getWalkGuide();
    }

    /* renamed from: o */
    private String m18013o() {
        DepartureAddress departureAddress = this.f25088O;
        if (departureAddress == null || departureAddress.getExtendInfo() == null) {
            return null;
        }
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(this.f25088O.getExtendInfo().getBubbleText());
        return richTextInfo.getContent();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17966b(DepartureAddress departureAddress) {
        this.f25088O = departureAddress;
        DepartureInterceptController departureInterceptController = this.f25082I;
        if (departureInterceptController != null) {
            ReverseStationsInfo reverseStationsInfo = this.f25117y;
            departureInterceptController.updateNewRequestLocation(departureAddress, reverseStationsInfo == null ? null : reverseStationsInfo.locLevel);
        }
        m17957a("onDepartureAddrSuccess callback");
        if (departureAddress == null || departureAddress.getPosition() == null) {
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f25097e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onFetchAddressFail(m18016q());
            }
            m17994f(m18016q());
            return;
        }
        m17977c(departureAddress);
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback2 = this.f25097e;
        if (iDepartureComponentCallback2 != null) {
            iDepartureComponentCallback2.onDepartureAddressChanged(departureAddress);
        }
        m17994f(departureAddress.getPosition());
        m17937a(departureAddress.getPosition(), false);
    }

    /* renamed from: p */
    private void m18015p() {
        m17994f(m18016q());
        DepartureInterceptController departureInterceptController = this.f25082I;
        if (departureInterceptController != null) {
            departureInterceptController.updateNewRequestLocation((DepartureAddress) null, (String) null);
        }
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f25097e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onFetchAddressFail(m18016q());
        }
        m17937a(m18016q(), true);
        IWalkDropWrapper iWalkDropWrapper = this.f25107o;
        if (iWalkDropWrapper != null) {
            iWalkDropWrapper.onRequestFail();
        }
    }

    /* renamed from: a */
    private void m17937a(LatLng latLng, boolean z) {
        LatLng latLng2;
        String str;
        DepartureCompParams departureCompParams = this.f25094b;
        if (departureCompParams != null && departureCompParams.getReqCallerId() != null && CallFrom.PICKUP_PAGE == this.f25094b.getReqCallerId()) {
            if (this.f25095c == null || !LatLngUtils.locateCorrect(latLng)) {
                DLog.m7384d("禁停内发单异常", "map == null || center point 异常", new Object[0]);
            } else if (m17979c(latLng) || m17986d(latLng)) {
                FenceInfo fenceInfo = this.f25100h.getFenceInfo();
                DepartureAddress departureAddress = this.f25115w;
                String str2 = null;
                if (departureAddress == null || departureAddress.getAddress() == null) {
                    str = null;
                    latLng2 = null;
                } else {
                    str = this.f25115w.getAddress().poiId;
                    latLng2 = this.f25115w.getPosition();
                }
                if (fenceInfo != null) {
                    str2 = fenceInfo.fenceId;
                }
                if (str2 == null) {
                    str2 = this.f25100h.isInAroundFence(latLng);
                }
                if (!TextUtils.isEmpty(str2)) {
                    DLog.m7384d("trackNoParkingError--->center", latLng != null ? latLng.toString() : "center is null", new Object[0]);
                    DepartureLocationInfo departureLocationInfo = this.f25111s;
                    DLog.m7384d("trackNoParkingError--->location", (departureLocationInfo == null || departureLocationInfo.latLng == null) ? "mLocation is null" : this.f25111s.latLng.toString(), new Object[0]);
                    DLog.m7384d("trackNoParkingError--->mapCenter", DepartureUtils.getMapCenterPoint(this.f25095c) != null ? DepartureUtils.getMapCenterPoint(this.f25095c).toString() : "map center is null", new Object[0]);
                    DLog.m7384d("trackNoParkingError--->position", latLng2 != null ? latLng2.toString() : "position is null", new Object[0]);
                    DepartureOmegaUtils.trackNoParkingError(latLng2, str, str2, z ? 1 : 0);
                }
            }
        }
    }

    /* renamed from: c */
    private void m17977c(DepartureAddress departureAddress) {
        m17984d(departureAddress);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17984d(DepartureAddress departureAddress) {
        DepartureOmegaManager departureOmegaManager = this.f25104l;
        if (departureOmegaManager != null) {
            departureOmegaManager.setPickupPoiDescription(DepartureUtils.getMainTitleFromDepartureAddr(departureAddress));
        }
    }

    /* renamed from: q */
    private LatLng m18016q() {
        DepartureLocationInfo departureLocationInfo = this.f25111s;
        if (departureLocationInfo != null) {
            return departureLocationInfo.latLng;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r0 = r0.getDepartureAddress();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.map.global.component.departure.model.DepartureAddress m17930a(com.sdk.poibase.model.RpcPoi r8) {
        /*
            r7 = this;
            com.didi.map.global.component.departure.departure.DeparturePresenter r0 = r7.f25106n
            r1 = 0
            if (r0 == 0) goto L_0x005c
            if (r8 == 0) goto L_0x0027
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r8.base_info
            if (r0 == 0) goto L_0x0027
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r8.base_info
            double r2 = r0.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r8.base_info
            double r4 = r0.lng
            boolean r0 = com.didi.common.map.util.LatLngUtils.locateCorrect(r2, r4)
            if (r0 == 0) goto L_0x0027
            com.didi.common.map.model.LatLng r0 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r2 = r8.base_info
            double r2 = r2.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r4 = r8.base_info
            double r4 = r4.lng
            r0.<init>((double) r2, (double) r4)
            goto L_0x0045
        L_0x0027:
            com.sdk.poibase.model.poi.ReverseStationsInfo r0 = r7.f25117y
            if (r0 == 0) goto L_0x0044
            com.sdk.poibase.model.RpcPoi r0 = r0.getDepartureAddress()
            if (r0 == 0) goto L_0x0044
            com.sdk.poibase.model.RpcPoiBaseInfo r2 = r0.base_info
            if (r2 == 0) goto L_0x0044
            com.didi.common.map.model.LatLng r2 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r0.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r0.base_info
            double r5 = r0.lng
            r2.<init>((double) r3, (double) r5)
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r7.f25117y
            if (r2 == 0) goto L_0x004d
            com.sdk.poibase.model.RpcPoi r1 = r2.getDepartureAddress()
        L_0x004d:
            com.didi.map.global.component.departure.departure.DeparturePresenter r2 = r7.f25106n
            com.didi.common.map.model.LatLng r3 = r7.m18016q()
            boolean r0 = r7.m17979c((com.didi.common.map.model.LatLng) r0)
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r2.getDepartureAddress(r8, r1, r3, r0)
            return r8
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m17930a(com.sdk.poibase.model.RpcPoi):com.didi.map.global.component.departure.model.DepartureAddress");
    }

    /* renamed from: r */
    private SpecialPois m18018r() {
        DepartureAddress departureAddress = this.f25115w;
        if (departureAddress != null) {
            return departureAddress.getSpecialPois();
        }
        return null;
    }

    /* renamed from: a */
    private void m17949a(DepartureAddress departureAddress, RpcPoi rpcPoi) {
        if (this.f25094b.isTerminalViewVisible()) {
            m17957a("handleTerminalView() isTerminalViewVisible is true");
            if (departureAddress != null && departureAddress.getZoneType() == 0) {
                m18023t();
            }
            DepartureCardViewController departureCardViewController = this.f25102j;
            if (departureCardViewController != null) {
                departureCardViewController.setData(departureAddress, DepartureUtils.getFenceInfo(this.f25117y), rpcPoi);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m18020s() {
        this.f25090Q = true;
        m18004k();
    }

    /* renamed from: t */
    private void m18023t() {
        if (this.f25102j == null) {
            DepartureCardViewController departureCardViewController = new DepartureCardViewController(this.f25096d, this.f25094b);
            this.f25102j = departureCardViewController;
            departureCardViewController.setTerminalViewCallback(new ITerminalView.Callback() {
                public void onTerminalAreaSelected(SPoi sPoi, int i) {
                    DepartureView.this.m17951a(sPoi);
                    DepartureView.this.f25104l.setSelectedTerminalSPoi(sPoi);
                }

                public void onDepartureSelected(RpcPoi rpcPoi, int i) {
                    DepartureView.this.m17968b(rpcPoi);
                    DepartureView departureView = DepartureView.this;
                    departureView.m17957a("onDepartureSelected eventCode=" + i);
                    if (i == 2) {
                        DepartureView.this.f25104l.reportOmegaOnTerminalRecPickupChange(rpcPoi, 3);
                    }
                }

                public void onClickChange(SpecialPois specialPois) {
                    DepartureView.this.m17952a(specialPois);
                }

                public void onClickNext(SPoi sPoi) {
                    DepartureView.this.m17967b(sPoi);
                }

                public void onClickConfirmPickup(RpcPoi rpcPoi) {
                    if (DepartureView.this.f25097e != null) {
                        DepartureView.this.m17984d(DepartureView.this.m17930a(rpcPoi));
                        DepartureView.this.f25097e.onConfirmPickup(DepartureView.this.m17930a(rpcPoi));
                    }
                    DepartureView.this.f25104l.reportOmegaOnTerminalConfirmButtonClick(rpcPoi);
                }

                public void onClickBroadOther() {
                    DepartureView.this.m18020s();
                    FenceInfo fenceInfo = DepartureView.this.f25115w.getFenceInfo();
                    if (!(fenceInfo == null || DepartureView.this.f25115w.getAddress() == null)) {
                        DepartureView.this.f25115w.getAddress().displayName = fenceInfo.fenceName;
                    }
                    if (DepartureView.this.f25097e != null) {
                        DepartureView.this.f25097e.onClickBroadOtherInStationCard(DepartureView.this.f25115w);
                    }
                    DepartureView.this.f25104l.reportOmegaStationAreaBroadFromOther();
                }
            });
            this.f25102j.setWelcomeViewCallback(new ITerminalWelcomeView.Callback() {
                public void onClickSetPickupSpot() {
                    if (DepartureView.this.f25097e != null) {
                        DepartureView.this.f25097e.onStartTerminalWindow(DepartureView.this.f25115w);
                    }
                    DepartureView.this.f25104l.reportOmegaOnWelcomeButtonClick();
                }

                public void onClickSelectOtherArea() {
                    if (DepartureView.this.f25097e != null) {
                        DepartureView.this.f25097e.onStartSugPage(DepartureView.this.f25115w);
                    }
                    DepartureView.this.f25104l.reportOmegaOnOtherAreaClick();
                }
            });
        }
    }

    /* renamed from: u */
    private void m18024u() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f25095c);
        if (mapCenterPoint != null) {
            this.f25111s.latLng = mapCenterPoint;
            m17950a(this.f25111s, 1);
        }
    }

    public DepartureAddress getDepartureAddress() {
        return this.f25115w;
    }

    public void startTerminalSelect() {
        DepartureCardViewController departureCardViewController = this.f25102j;
        if (departureCardViewController != null) {
            departureCardViewController.setPickupSpotChecked(true);
            m18024u();
        }
    }

    public boolean isShowTerminalViewOnSetPickupSpotAfter() {
        DepartureCardViewController departureCardViewController;
        if (this.f25094b.isTerminalViewVisible() && (departureCardViewController = this.f25102j) != null && departureCardViewController.isWaitCheckPickupSpot()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17951a(SPoi sPoi) {
        m17957a("terminalAreaSelected()");
        if (!(sPoi == null || sPoi.area == null || sPoi.area.centre_point == null)) {
            LatLng latLng = new LatLng(sPoi.area.centre_point.lat, sPoi.area.centre_point.lng);
            this.f25113u = latLng;
            m17954a((RpcPoi) null, latLng, true, false);
        }
        this.f25091R = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17968b(RpcPoi rpcPoi) {
        m17957a("departureSelected()");
        if (rpcPoi != null && rpcPoi.base_info != null) {
            LatLng latLng = new LatLng(rpcPoi.base_info.lat, rpcPoi.base_info.lng);
            this.f25113u = latLng;
            m17954a(rpcPoi, latLng, true, false);
            RpcPoi rpcPoi2 = this.f25091R;
            String str = (rpcPoi2 == null || rpcPoi2.base_info == null) ? "" : this.f25091R.base_info.poi_id;
            if (TextUtils.isEmpty(str) || !str.equals(rpcPoi.base_info.poi_id)) {
                this.f25091R = rpcPoi;
                if (this.f25097e != null) {
                    DepartureAddress a = m17930a(rpcPoi);
                    DepartureCardViewController departureCardViewController = this.f25102j;
                    if (departureCardViewController != null) {
                        departureCardViewController.refreshTerminalCardViewSubNotice(a);
                    }
                    m17984d(a);
                    this.f25088O = a;
                    if (a != null) {
                        m17977c(a);
                        this.f25097e.onDepartureAddressChanged(a);
                        m17994f(a.getPosition());
                        return;
                    }
                    this.f25097e.onFetchAddressFail(m18016q());
                    m17994f(m18016q());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17952a(SpecialPois specialPois) {
        m17957a("clickChangeToShowTerminalAreaList()");
        List<RecPoint> terminalRecPointList = TerminalUtils.getTerminalRecPointList(specialPois);
        DepartureCardViewController departureCardViewController = this.f25102j;
        if (departureCardViewController != null && departureCardViewController.hasTerminalView()) {
            m17958a(terminalRecPointList, true);
            SPoi selectedTerminalArea = this.f25102j.getSelectedTerminalArea();
            if (selectedTerminalArea == null) {
                selectedTerminalArea = TerminalUtils.getAdsorbTerminalArea(specialPois);
            }
            m17951a(selectedTerminalArea);
            m17994f((LatLng) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17967b(SPoi sPoi) {
        m17957a("clickNextToSelectTerminalArea()");
        if (sPoi != null && !CollectionUtil.isEmpty((Collection<?>) sPoi.list)) {
            this.f25114v = sPoi.list;
            m17958a(TerminalUtils.getRecPointList(sPoi.list), false);
            RpcPoi findRecommendAdsorbPoint = DepartureUtils.findRecommendAdsorbPoint(sPoi.list);
            m17968b(findRecommendAdsorbPoint);
            this.f25104l.setSelectedTerminalSPoi(sPoi);
            this.f25104l.setDefaultRecTerminalPickupPoi(findRecommendAdsorbPoint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public LatLng m18026v() {
        DepartureLocationInfo departureLocationInfo = this.f25111s;
        if (departureLocationInfo == null || departureLocationInfo.latLng == null || this.f25111s.latLng.latitude == 0.0d) {
            return DepartureUtils.getMapCenterPoint(this.f25095c);
        }
        return this.f25111s.latLng;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f25111s;
    }

    public View getDepartureCardView() {
        DepartureCardViewController departureCardViewController = this.f25102j;
        if (departureCardViewController != null) {
            return departureCardViewController.getDepartureCardView();
        }
        return null;
    }

    /* renamed from: w */
    private void m18028w() {
        DeparturePresenter departurePresenter = this.f25106n;
        if (departurePresenter != null) {
            departurePresenter.stopRequest();
        }
    }

    public void start() {
        m17963b();
        m17993f();
        m17999h();
        m17950a(this.f25111s, this.f25074A);
        DepartureLocationInfo departureLocationInfo = this.f25111s;
        if (departureLocationInfo != null) {
            m17997g(departureLocationInfo.latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m17997g(LatLng latLng) {
        this.f25075B.set(true);
        if (latLng == null) {
            latLng = DepartureUtils.getMapCenterPoint(this.f25095c);
        }
        ZoneCircleController zoneCircleController = this.f25105m;
        if (zoneCircleController != null && !CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
            BestViewer.doBestView(this.f25095c, false, latLng, this.f25105m.getBestViewPoints(), this.f25079F, (Padding) null, (BestViewer.IBestViewListener) null);
        } else if (LatLngUtils.locateCorrect(latLng)) {
            CarpoolDepartureController carpoolDepartureController = this.f25103k;
            if (carpoolDepartureController != null) {
                BestViewer.doBestView(this.f25095c, false, latLng, carpoolDepartureController.getBestViewPoints(latLng), this.f25079F, (Padding) null, (BestViewer.IBestViewListener) null);
            } else {
                float zoom = this.f25094b.getZoom();
                if (this.f25094b.getPinStyle() != null || this.f25094b.isPinVisible()) {
                    PinActionUtils.animateCamera(this.f25095c, latLng, false, true, zoom, this.f25079F, (BestViewer.IBestViewListener) null);
                }
            }
        }
        this.f25075B.set(false);
    }

    public void updateDepartureLocation(final DepartureLocationInfo departureLocationInfo, final boolean z) {
        if (this.f25098f && m17974b(departureLocationInfo)) {
            m17957a("updateDepartureLocation=" + departureLocationInfo);
            DepartureOmegaUtils.OmegaParams.scrollType = 1;
            C942410 r7 = new BestViewer.IBestViewListener() {
                public void onFinished() {
                    RpcPoi findTargetRecommend;
                    DepartureView.this.m17957a("updateDepartureLocation onFinished");
                    DepartureView.this.f25075B.set(false);
                    if (DepartureView.this.m17924B()) {
                        LatLng center = DepartureView.this.f25105m.getCenter();
                        if (!(DepartureView.this.f25111s == null || DepartureView.this.f25111s.latLng == null || DepartureView.this.f25105m.getCircle() == null || !DepartureView.this.f25105m.getCircle().contains(DepartureView.this.f25111s.latLng))) {
                            center = DepartureView.this.f25111s.latLng;
                        }
                        DepartureView.this.m17990e(center);
                        departureLocationInfo.latLng = center;
                    } else {
                        departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(DepartureView.this.f25095c);
                    }
                    int i = 1;
                    if (DepartureView.this.f25090Q && DepartureView.this.f25117y != null) {
                        LatLng latLng = departureLocationInfo.latLng;
                        FenceInfo fenceInfo = DepartureView.this.f25117y.startFenceInfo;
                        if (FenceUtils.isFenceMustAbsorb(fenceInfo)) {
                            if (!FenceUtils.positionIsInFence(DepartureView.this.f25095c, fenceInfo, latLng)) {
                                boolean unused = DepartureView.this.f25090Q = false;
                            } else {
                                return;
                            }
                        }
                    } else if (DepartureView.this.m17979c(departureLocationInfo.latLng) && (findTargetRecommend = DepartureUtils.findTargetRecommend(departureLocationInfo.latLng, DepartureView.this.f25114v)) != null) {
                        LatLng unused2 = DepartureView.this.f25113u = new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng);
                        DepartureView departureView = DepartureView.this;
                        departureView.m17954a(findTargetRecommend, departureView.f25113u, true, true);
                        DepartureView.this.m17966b(DepartureView.this.m17930a(findTargetRecommend));
                        return;
                    }
                    DepartureView departureView2 = DepartureView.this;
                    DepartureLocationInfo departureLocationInfo = departureLocationInfo;
                    if (z) {
                        i = departureView2.f25074A;
                    }
                    departureView2.m17950a(departureLocationInfo, i);
                }
            };
            if (!z || !this.f25075B.get()) {
                this.f25075B.set(true);
                LatLng latLng = departureLocationInfo != null ? departureLocationInfo.latLng : null;
                ZoneCircleController zoneCircleController = this.f25105m;
                if (zoneCircleController != null && !CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
                    m17957a("mZoneCircleCtr bestview");
                    BestViewer.doBestView(this.f25095c, true, latLng, this.f25105m.getBestViewPoints(), this.f25079F, (Padding) null, r7);
                } else if (this.f25103k != null) {
                    m17957a("mCarpoolController bestview");
                    BestViewer.doBestView(this.f25095c, true, latLng, this.f25103k.getBestViewPoints(latLng), this.f25079F, (Padding) null, r7);
                } else {
                    float zoom = this.f25094b.getZoom();
                    m17957a("正常 BestView");
                    PinActionUtils.animateCamera(this.f25095c, latLng, true, true, zoom, this.f25079F, r7);
                }
                DeparturePresenter departurePresenter = this.f25106n;
                if (departurePresenter != null) {
                    departurePresenter.stopRequest();
                }
            }
        }
    }

    /* renamed from: x */
    private Padding m18030x() {
        int i = this.f25081H;
        return new Padding(i, i, i, i);
    }

    /* renamed from: y */
    private Padding m18032y() {
        Map map = this.f25095c;
        if (map == null) {
            return m18030x();
        }
        Padding padding = map.getPadding();
        if (padding == null) {
            return m18030x();
        }
        int i = padding.bottom;
        int i2 = this.f25081H;
        if (i < i2) {
            padding.bottom = i2;
        }
        int i3 = padding.left;
        int i4 = this.f25081H;
        if (i3 < i4) {
            padding.left = i4;
        }
        int i5 = padding.top;
        int i6 = this.f25081H;
        if (i5 < i6) {
            padding.top = i6;
        }
        int i7 = padding.right;
        int i8 = this.f25081H;
        if (i7 < i8) {
            padding.right = i8;
        }
        return padding;
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m18035z() {
        if (this.f25094b.isPinVisible() && this.f25094b.isRequireByDrag()) {
            if (this.f25097e != null && !this.f25109q) {
                m17957a("onStartDragging");
                this.f25097e.onStartDragging();
            }
            int A = m17921A();
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f25097e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onDragging(A);
            }
            m17934a(A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public int m17921A() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f25095c);
        FenceController fenceController = this.f25100h;
        int isInFence = fenceController != null ? fenceController.isInFence(mapCenterPoint) : 2;
        ZoneCircleController zoneCircleController = this.f25105m;
        if (zoneCircleController == null || zoneCircleController.allowDragToOuter()) {
            return isInFence;
        }
        if (this.f25105m.handleMapDrag(mapCenterPoint)) {
            return 1;
        }
        return 2;
    }

    /* renamed from: a */
    private void m17934a(int i) {
        DepartureCompParams departureCompParams = this.f25094b;
        if (departureCompParams != null && this.f25099g != null) {
            if (!departureCompParams.isBubbleVisible()) {
                this.f25099g.startDragging_Ex();
            } else if (i == 1 || i == 3) {
                this.f25099g.toNoParking();
            } else {
                this.f25099g.startDragging();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public boolean m17924B() {
        ZoneCircleController zoneCircleController = this.f25105m;
        return zoneCircleController != null && !zoneCircleController.allowDragToOuter() && this.f25105m.isOutside();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17957a(String str) {
        DLog.m7384d(this.f25093a, str, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17953a(DIDILocation dIDILocation) {
        if (this.f25095c != null && this.f25096d != null && this.f25098f && dIDILocation != null && this.f25111s != null) {
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (!LatLngUtils.locateCorrect(latLng)) {
                DLog.m7384d("departure", "onReceiveLocationUpdate error " + latLng.toString(), new Object[0]);
                return;
            }
            if (this.f25118z == null) {
                this.f25118z = dIDILocation;
                DLog.m7384d("departure", "onReceiveLocationUpdate 首次定位成功 " + latLng.toString(), new Object[0]);
            }
            IWalkDropWrapper iWalkDropWrapper = this.f25107o;
            if (iWalkDropWrapper != null) {
                iWalkDropWrapper.onReceiveLocationUpdate(dIDILocation);
            }
            DepartureOmegaManager departureOmegaManager = this.f25104l;
            if (departureOmegaManager != null) {
                departureOmegaManager.setLocationAccuracy(dIDILocation.getAccuracy());
            }
            DepartureInterceptController departureInterceptController = this.f25082I;
            if (departureInterceptController != null) {
                departureInterceptController.upDateCurrentLocation(dIDILocation);
            }
            if (System.currentTimeMillis() - this.f25092S > ((long) (LocFollowToggleApollo.frequency * 1000))) {
                this.f25092S = System.currentTimeMillis();
                if (this.f25074A == 0 && this.f25105m == null && this.f25103k == null && this.f25076C && LocFollowToggleApollo.enable) {
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(new LatLng(this.f25118z.getLatitude(), this.f25118z.getLongitude()), latLng);
                    boolean z = computeDistanceBetween > ((double) LocFollowToggleApollo.distance);
                    boolean z2 = dIDILocation.getAccuracy() < ((float) LocFollowToggleApollo.accuracy);
                    if (z && z2) {
                        String str = this.f25093a;
                        DLog.m7384d(str, "check 30m follow distance-->" + computeDistanceBetween + "Accuracy-->" + dIDILocation.getAccuracy(), new Object[0]);
                        this.f25111s.latLng = latLng;
                        this.f25118z = dIDILocation;
                        DepartureOmegaUtils.trackOnLocFollow();
                        updateDepartureLocation(this.f25111s, true);
                    }
                }
            }
        }
    }

    /* renamed from: C */
    private void m17926C() {
        this.f25104l.reportOmegaOnShowTerminalWelcome(this.f25102j, DepartureUtils.getFenceInfo(this.f25117y), this.f25074A == 0);
    }

    public void stop() {
        m17976c();
        m17996g();
        m18003j();
        m18028w();
        CarpoolDepartureController carpoolDepartureController = this.f25103k;
        if (carpoolDepartureController != null) {
            carpoolDepartureController.removeCircle(false);
        }
    }

    public void destroy() {
        stop();
        m18004k();
        m18001i();
        IWalkDropWrapper iWalkDropWrapper = this.f25107o;
        if (iWalkDropWrapper != null) {
            iWalkDropWrapper.onDestroy();
            this.f25107o = null;
        }
        Map map = this.f25095c;
        if (map != null) {
            map.stopAnimation();
        }
        DeparturePresenter departurePresenter = this.f25106n;
        if (departurePresenter != null) {
            departurePresenter.destroy();
            this.f25106n = null;
        }
        this.f25090Q = false;
        DepartureOmegaUtils.hasDragged = false;
        DepartureOmegaUtils.OmegaParams.scrollType = -1;
        Handler handler = this.f25078E;
        if (handler != null) {
            handler.removeCallbacks(this.f25080G);
            this.f25078E.removeCallbacksAndMessages((Object) null);
            this.f25078E = null;
        }
        this.f25102j = null;
    }

    public void addOrderInterceptListener(final DepartureInterceptController.IInterceptListener iInterceptListener) {
        DepartureInterceptController departureInterceptController = this.f25082I;
        if (departureInterceptController != null) {
            departureInterceptController.addInterceptListener(new DepartureInterceptController.IInterceptListener() {
                public void onIntercept(OrderInterceptMode orderInterceptMode, boolean z) {
                    String D = DepartureView.this.f25093a;
                    DLog.m7384d(D, "getInterceptStatus : onIntercept model=" + orderInterceptMode + ",newPoi=" + z, new Object[0]);
                    DepartureDataStore.getInstance().saveInterceptTime();
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onIntercept(orderInterceptMode, z);
                    }
                }

                public void onContinue() {
                    DLog.m7384d(DepartureView.this.f25093a, "getInterceptStatus : onContinue", new Object[0]);
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onContinue();
                    }
                }

                public void onStart() {
                    DLog.m7384d(DepartureView.this.f25093a, "getInterceptStatus : onStart", new Object[0]);
                    DepartureView.this.f25111s.latLng = DepartureView.this.m18026v();
                    DepartureView departureView = DepartureView.this;
                    departureView.m17950a(departureView.f25111s, DepartureView.this.f25074A);
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onStart();
                    }
                }
            });
        }
    }

    public void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo) {
        Map map;
        DepartureLocationInfo a = m17931a(departureLocationInfo);
        this.f25111s = a;
        FenceController fenceController = this.f25100h;
        if (fenceController != null && a != null && (map = this.f25095c) != null) {
            boolean positionIsInFence = FenceUtils.positionIsInFence(map, fenceController.getFenceInfo(), this.f25111s.latLng);
            Map map2 = this.f25095c;
            if (map2 != null) {
                BestViewer.doBestView_Move(map2, this.f25111s.latLng, this.f25079F);
            }
            if (positionIsInFence) {
                m17994f(this.f25111s.latLng);
                IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f25097e;
                if (iDepartureComponentCallback != null) {
                    iDepartureComponentCallback.onBroadOtherMapCallback(1);
                }
                DLog.m7384d(this.f25093a, "updatePositionWhenOutStation->选择sug点在场站内", new Object[0]);
                return;
            }
            m17950a(this.f25111s, this.f25074A);
            DLog.m7384d(this.f25093a, "updatePositionWhenOutStation->选择sug点在场站外", new Object[0]);
        }
    }
}
