package com.didi.map.global.component.departure.canoe;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
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
import com.didi.map.global.component.departure.bubble.DepartureWalkGuide;
import com.didi.map.global.component.departure.canoe.view.AbsCanoeAddressView;
import com.didi.map.global.component.departure.canoe.view.CanoeAddressFailView;
import com.didi.map.global.component.departure.canoe.view.CanoeAddressView;
import com.didi.map.global.component.departure.canoe.view.CanoeDeparturePinView;
import com.didi.map.global.component.departure.canoe.view.DestinationFlagView;
import com.didi.map.global.component.departure.carpool.CarpoolDepartureController;
import com.didi.map.global.component.departure.circle.ZoneCircleController;
import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.controller.DepartureControllerParams;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.departure.DeparturePresenter;
import com.didi.map.global.component.departure.departure.IDepartureView;
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
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CanoeDepartureView implements IDepartureView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public AtomicBoolean f24909A;

    /* renamed from: B */
    private boolean f24910B;

    /* renamed from: C */
    private int f24911C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Handler f24912D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Padding f24913E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Runnable f24914F;

    /* renamed from: G */
    private int f24915G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public DepartureInterceptController f24916H;

    /* renamed from: I */
    private boolean f24917I;

    /* renamed from: J */
    private LatLng f24918J;

    /* renamed from: K */
    private ICollideStrategy f24919K;

    /* renamed from: L */
    private boolean f24920L;

    /* renamed from: M */
    private CanoeAddressView f24921M;

    /* renamed from: N */
    private CanoeAddressFailView f24922N;

    /* renamed from: O */
    private DestinationFlagView f24923O;

    /* renamed from: P */
    private DepartureAddress f24924P;

    /* renamed from: Q */
    private DepartureWalkGuide f24925Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f24926R;

    /* renamed from: S */
    private RpcPoi f24927S;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f24928a = "CanoeDepartureView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureCompParams f24929b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f24930c;

    /* renamed from: d */
    private Context f24931d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDepartureCompContract.IDepartureComponentCallback f24932e;

    /* renamed from: f */
    private boolean f24933f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDeparturePinView f24934g;

    /* renamed from: h */
    private FenceController f24935h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IRecMarkerController f24936i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GuideLine f24937j;

    /* renamed from: k */
    private DepartureCardViewController f24938k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CarpoolDepartureController f24939l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DepartureOmegaManager f24940m = new DepartureOmegaManager();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ZoneCircleController f24941n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DeparturePresenter f24942o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f24943p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f24944q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public DepartureLocationInfo f24945r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RpcPoi f24946s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public List<RpcPoi> f24947t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public LatLng f24948u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public DepartureAddress f24949v;

    /* renamed from: w */
    private MapListener f24950w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ReverseStationsInfo f24951x;

    /* renamed from: y */
    private DIDILocation f24952y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f24953z;

    public CanoeDepartureView(Map map, Context context, DepartureCompParams departureCompParams) {
        DepartureLocationInfo departureLocationInfo = null;
        this.f24947t = null;
        this.f24950w = new MapListener();
        this.f24953z = 0;
        this.f24909A = new AtomicBoolean(false);
        this.f24910B = false;
        this.f24912D = new Handler(Looper.getMainLooper());
        this.f24914F = new Runnable() {
            public void run() {
                if (CanoeDepartureView.this.f24909A.get() || CanoeDepartureView.this.f24943p) {
                    CanoeDepartureView.this.m17753a("mPaddingRunnable delay");
                    if (CanoeDepartureView.this.f24912D != null && CanoeDepartureView.this.f24913E != null) {
                        CanoeDepartureView.this.f24912D.postDelayed(CanoeDepartureView.this.f24914F, 100);
                    }
                } else if (CanoeDepartureView.this.f24930c != null && CanoeDepartureView.this.f24930c.getCameraPosition() != null && CanoeDepartureView.this.f24913E != null) {
                    CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                    canoeDepartureView.m17753a("mPaddingRunnable do best view：" + CanoeDepartureView.this.f24930c.getCameraPosition().target);
                    if (CanoeDepartureView.this.f24913E != null && CanoeDepartureView.this.f24913E.equals(CanoeDepartureView.this.f24930c.getPadding())) {
                        CanoeDepartureView canoeDepartureView2 = CanoeDepartureView.this;
                        canoeDepartureView2.m17753a("mPaddingRunnable same return ; " + CanoeDepartureView.this.f24913E.toString());
                    } else if (CanoeDepartureView.this.f24930c.getMapVendor() == MapVendor.DIDI) {
                        CanoeDepartureView.this.f24930c.setPadding(CanoeDepartureView.this.f24913E.left, CanoeDepartureView.this.f24913E.top, CanoeDepartureView.this.f24913E.right, CanoeDepartureView.this.f24913E.bottom);
                    } else {
                        BestViewer.doBestView(CanoeDepartureView.this.f24930c, false, Float.valueOf((float) CanoeDepartureView.this.f24930c.getCameraPosition().zoom), CanoeDepartureView.this.f24930c.getCameraPosition().target, CanoeDepartureView.this.f24913E, (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                            public void onFinished() {
                                CanoeDepartureView.this.m17753a("mPaddingRunnable do best view onFinished");
                            }
                        });
                    }
                }
            }
        };
        this.f24927S = null;
        if (departureCompParams != null) {
            DepartureOmegaUtils.isFirst = true;
            this.f24930c = map;
            this.f24931d = context;
            this.f24929b = departureCompParams;
            this.f24915G = DisplayUtils.dp2px(context, 10.0f);
            this.f24913E = m17824w();
            DepartureCompParams departureCompParams2 = this.f24929b;
            this.f24945r = m17730a(departureCompParams2 != null ? departureCompParams2.getLocationInfo() : departureLocationInfo);
            m17732a();
            DeparturePresenter departurePresenter = new DeparturePresenter(map, context, departureCompParams);
            this.f24942o = departurePresenter;
            departurePresenter.setResponseCallback(new DeparturePresenter.IResponseCallback() {
                public void onLoading(LatLng latLng) {
                    if (CanoeDepartureView.this.f24929b.isBubbleVisible() && CanoeDepartureView.this.f24934g != null) {
                        CanoeDepartureView.this.f24934g.startLoading(CanoeDepartureView.this.m17768b(latLng) || CanoeDepartureView.this.m17779c(latLng));
                    }
                    if (CanoeDepartureView.this.f24932e != null) {
                        CanoeDepartureView.this.f24932e.onDepartureLoading(latLng);
                    }
                }

                public void onHandleResult(ReverseStationsInfo reverseStationsInfo) {
                    CanoeDepartureView.this.m17752a(reverseStationsInfo);
                }

                public void onLocationChange(DIDILocation dIDILocation) {
                    CanoeDepartureView.this.m17750a(dIDILocation);
                }
            });
            Address endPoint = this.f24929b.getEndPoint();
            if (endPoint != null) {
                this.f24918J = new LatLng(endPoint.getLatitude(), endPoint.getLongitude());
            }
            boolean isHasWayPoint = this.f24929b.isHasWayPoint();
            this.f24917I = isHasWayPoint;
            this.f24916H = new DepartureInterceptController(new DepartureControllerParams(this.f24931d, this.f24930c, this.f24911C, isHasWayPoint, this.f24918J, (DepartureAddress) null, this.f24935h));
        }
    }

    /* renamed from: a */
    private DepartureLocationInfo m17730a(DepartureLocationInfo departureLocationInfo) {
        DIDILocation lastKnownLocation;
        if (departureLocationInfo == null) {
            m17753a("初始化 locationInfo= null");
            departureLocationInfo = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
        } else {
            m17753a("初始化 locationInfo= " + departureLocationInfo.toString());
        }
        if (departureLocationInfo.sugPoi != null) {
            this.f24953z = departureLocationInfo.sugPoi.operationType;
            m17753a("初始化mInnerOperationType= " + this.f24953z);
        }
        if (departureLocationInfo.sugPoi != null && departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = new LatLng(departureLocationInfo.sugPoi.latitude, departureLocationInfo.sugPoi.longitude);
            m17753a("从sug初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureDataStore.getInstance().getPinLocation();
            m17753a("从缓存初始化latLng");
        }
        if (departureLocationInfo.latLng == null && (lastKnownLocation = LocationHelper.getLastKnownLocation(this.f24931d)) != null) {
            departureLocationInfo.latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            m17753a("从定位初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(this.f24930c);
            m17753a("从map初始化latLng");
        }
        if (departureLocationInfo.latLng != null) {
            m17753a("初始化latLng : " + departureLocationInfo.latLng.toString());
            return departureLocationInfo;
        }
        throw new IllegalArgumentException("departureView don't have a default location");
    }

    /* renamed from: a */
    private void m17732a() {
        LatLng latLng;
        DepartureCompParams departureCompParams = this.f24929b;
        if (departureCompParams != null) {
            DepartureFenceOptions fenceOptions = departureCompParams.getFenceOptions();
            if (fenceOptions != null) {
                this.f24935h = new FenceController(this.f24930c, fenceOptions);
            }
            if (this.f24929b.isGuideLineVisible()) {
                this.f24937j = new GuideLine();
                DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f24931d);
                int guideLineColor = this.f24929b.getGuideLineColor();
                if (guideLineColor == 0) {
                    guideLineColor = -13386753;
                }
                if (lastKnownLocation == null) {
                    latLng = null;
                } else {
                    latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                }
                this.f24937j.setConfigParam(new GuideLineParam(guideLineColor, latLng, DepartureUtils.getMapCenterPoint(this.f24930c)));
                this.f24937j.create(this.f24931d, this.f24930c);
            }
            ZoneCircleOption circleOption = this.f24929b.getCircleOption();
            if (circleOption != null) {
                this.f24941n = new ZoneCircleController(this.f24930c, circleOption, this.f24931d);
            }
            int sceneType = this.f24929b.getSceneType();
            this.f24911C = sceneType;
            if (sceneType == 1) {
                this.f24939l = new CarpoolDepartureController(this.f24930c, sceneType);
            }
        }
    }

    /* renamed from: b */
    private void m17760b() {
        Map map = this.f24930c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f24950w);
            this.f24930c.addOnMapGestureListener(this.f24950w);
        }
    }

    /* renamed from: c */
    private void m17776c() {
        Map map = this.f24930c;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f24950w);
            this.f24930c.removeOnMapGestureListener(this.f24950w);
        }
    }

    /* renamed from: d */
    private boolean m17785d() {
        DepartureFenceOptions fenceOptions;
        if (!(!this.f24929b.isTerminalViewVisible() || (fenceOptions = this.f24929b.getFenceOptions()) == null || fenceOptions.cardWizardStart == 0)) {
            if (fenceOptions.cardWizardStart == 2) {
                return this.f24938k.isWelcomeViewValid();
            }
            if (fenceOptions.cardWizardStart == 1) {
                return this.f24938k.isWaitCheckPickupSpot();
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m17789e() {
        DepartureCompParams departureCompParams = this.f24929b;
        return departureCompParams != null && departureCompParams.isRecPointVisible() && (this.f24938k == null || !m17785d());
    }

    /* renamed from: f */
    private void m17791f() {
        DepartureCompParams departureCompParams = this.f24929b;
        if (departureCompParams != null && this.f24930c != null && departureCompParams.isPinVisible()) {
            m17793g();
            CanoeDeparturePinView canoeDeparturePinView = new CanoeDeparturePinView(this.f24930c.getContext());
            this.f24934g = canoeDeparturePinView;
            canoeDeparturePinView.create(this.f24931d, this.f24930c);
            this.f24934g.setConfigParam(this.f24929b.getPinStyle());
            this.f24934g.add();
        }
    }

    public void registerCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        this.f24932e = iDepartureComponentCallback;
    }

    /* renamed from: g */
    private void m17793g() {
        IDeparturePinView iDeparturePinView = this.f24934g;
        if (iDeparturePinView != null) {
            iDeparturePinView.destroy();
            this.f24934g = null;
        }
    }

    /* renamed from: h */
    private void m17795h() {
        ZoneCircleController zoneCircleController = this.f24941n;
        if (zoneCircleController != null) {
            zoneCircleController.showCircle();
        }
    }

    /* renamed from: a */
    private void m17746a(DepartureAddress departureAddress) {
        DepartureCompParams departureCompParams;
        if (this.f24935h != null && (departureCompParams = this.f24929b) != null && departureCompParams.isFenceVisible()) {
            this.f24935h.showFence(departureAddress);
            ReverseStationsInfo reverseStationsInfo = this.f24951x;
            if (reverseStationsInfo != null) {
                this.f24935h.showAroundFenceList(reverseStationsInfo.aroundFenceList);
            }
        }
    }

    /* renamed from: a */
    private void m17754a(List<RecPoint> list, boolean z) {
        if (this.f24951x == null || CollectionUtil.isEmpty((Collection<?>) list) || this.f24929b == null || this.f24930c == null || this.f24931d == null) {
            m17753a("showRecMarkers() return");
            return;
        }
        m17800k();
        if (!m17789e()) {
            m17753a("showRecMarkers() isRecPointVisible is false,return");
            return;
        }
        RecMarkerController recMarkerController = new RecMarkerController();
        this.f24936i = recMarkerController;
        recMarkerController.create(this.f24930c.getContext(), this.f24930c);
        RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
        recMarkerControllerParam.list = list;
        RecPointStyle pinRecStyle = DepartureStyleUtils.getPinRecStyle(this.f24931d, this.f24929b);
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
                CanoeDepartureView.this.m17755a(this.f$1, this.f$2, iRecMarker);
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
                return CanoeDepartureView.this.f24930c;
            }

            public void setVisible(String str, boolean z) {
                if (CanoeDepartureView.this.f24936i != null) {
                    CanoeDepartureView.this.f24936i.setVisible(str, z);
                }
            }
        });
        this.f24919K = collideStrategyV1;
        recMarkerControllerParam.strategy = collideStrategyV1;
        this.f24936i.setConfigParam(recMarkerControllerParam);
        this.f24936i.add();
        if (DepartureUtils.isAllowShowCircles(this.f24951x)) {
            this.f24936i.showCircles();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17755a(boolean z, List list, IRecMarker iRecMarker) {
        if (!LatLngUtils.isSameLatLng(iRecMarker.getLocation(), DepartureUtils.getMapCenterPoint(this.f24930c))) {
            DepartureCardViewController departureCardViewController = this.f24938k;
            boolean z2 = false;
            boolean z3 = departureCardViewController != null && departureCardViewController.isTerminalViewValid();
            if (!z || !z3) {
                RpcPoi findTargetRecommend = DepartureUtils.findTargetRecommend(iRecMarker.getLocation(), this.f24947t);
                this.f24946s = findTargetRecommend;
                this.f24949v = m17729a(findTargetRecommend);
                StringBuilder sb = new StringBuilder();
                sb.append("recMarker.Onclick mAdsorbPoi is null:");
                if (this.f24946s == null) {
                    z2 = true;
                }
                sb.append(z2);
                m17753a(sb.toString());
                RpcPoi rpcPoi = this.f24946s;
                if (rpcPoi != null && rpcPoi.base_info != null) {
                    LatLng latLng = new LatLng(this.f24946s.base_info.lat, this.f24946s.base_info.lng);
                    if (z3) {
                        this.f24938k.setSelectedDeparture(this.f24946s);
                        m17751a(this.f24946s, latLng, true, true);
                        this.f24940m.reportOmegaOnTerminalRecPickupChange(this.f24946s, 2);
                        return;
                    }
                    m17751a(this.f24946s, latLng, true, true);
                    m17764b(this.f24949v);
                    return;
                }
                return;
            }
            RecPoint findTargetRecPoint = DepartureUtils.findTargetRecPoint(iRecMarker.getLocation(), list);
            if (findTargetRecPoint != null && !TextUtils.isEmpty(findTargetRecPoint.addrName)) {
                SPoi adsorbTerminalAreaByName = TerminalUtils.getAdsorbTerminalAreaByName(m17813q(), findTargetRecPoint.addrName);
                m17748a(adsorbTerminalAreaByName);
                this.f24940m.setSelectedTerminalSPoi(adsorbTerminalAreaByName);
                this.f24938k.setSelectedTerminalArea(adsorbTerminalAreaByName);
                m17753a("recMarker.Onclick mTerminalView.isValid() is true");
            }
        }
    }

    /* renamed from: i */
    private void m17797i() {
        FenceController fenceController = this.f24935h;
        if (fenceController != null) {
            fenceController.removeFence();
            this.f24935h.removeAroundFenceList();
        }
    }

    /* renamed from: j */
    private void m17799j() {
        ZoneCircleController zoneCircleController = this.f24941n;
        if (zoneCircleController != null) {
            zoneCircleController.hideCircle();
        }
    }

    /* renamed from: k */
    private void m17800k() {
        ICollideStrategy iCollideStrategy = this.f24919K;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f24919K = null;
        }
        IRecMarkerController iRecMarkerController = this.f24936i;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f24936i = null;
        }
    }

    public void setFenceVisible(boolean z) {
        FenceController fenceController = this.f24935h;
        if (fenceController != null) {
            fenceController.setFenceVisible(z);
        }
    }

    public void onMapVisible(boolean z) {
        this.f24933f = z;
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

        MapListener() {
        }

        public boolean onScroll(float f, float f2) {
            if (!CanoeDepartureView.this.f24944q) {
                CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                LatLng unused = canoeDepartureView.f24948u = DepartureUtils.getMapCenterPoint(canoeDepartureView.f24930c);
                CanoeDepartureView.this.m17753a("start dragging");
                if (CanoeDepartureView.this.f24936i != null) {
                    CanoeDepartureView.this.f24936i.onMapScroll();
                }
                if (!(CanoeDepartureView.this.f24941n == null || CanoeDepartureView.this.f24941n.getCircle() == null || !CanoeDepartureView.this.f24941n.getCircle().contains(CanoeDepartureView.this.f24948u))) {
                    CanoeDepartureView.this.f24940m.reportOmegaChangeStartCircle(1);
                }
                if (CanoeDepartureView.this.f24939l != null) {
                    CanoeDepartureView.this.f24939l.removeCircle(true);
                }
                if (CanoeDepartureView.this.f24942o != null) {
                    CanoeDepartureView.this.f24942o.stopRequest();
                }
                if (CanoeDepartureView.this.f24916H != null) {
                    CanoeDepartureView.this.f24916H.setHasDragged(true);
                }
            }
            DepartureOmegaUtils.OmegaParams.scrollType = 0;
            DepartureOmegaUtils.hasDragged = true;
            CanoeDepartureView.this.m17827x();
            boolean unused2 = CanoeDepartureView.this.f24944q = true;
            return false;
        }

        public boolean onDown(float f, float f2) {
            CanoeDepartureView.this.m17753a("onDown");
            boolean unused = CanoeDepartureView.this.f24943p = true;
            if (CanoeDepartureView.this.f24912D == null) {
                return false;
            }
            CanoeDepartureView.this.f24912D.removeCallbacks(CanoeDepartureView.this.f24914F);
            return false;
        }

        public boolean onUp(float f, float f2) {
            boolean unused = CanoeDepartureView.this.f24943p = false;
            if (CanoeDepartureView.this.f24932e != null) {
                CanoeDepartureView.this.f24932e.onUp();
            }
            return false;
        }

        public void onMapStable() {
            if (CanoeDepartureView.this.f24944q) {
                CanoeDepartureView.this.m17803l();
            }
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            if (CanoeDepartureView.this.f24930c != null) {
                if (CanoeDepartureView.this.f24941n != null) {
                    CanoeDepartureView.this.f24941n.handleMapDrag(DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f24930c));
                }
                if (CanoeDepartureView.this.f24937j != null) {
                    CanoeDepartureView.this.f24937j.updateEndPosition(DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f24930c));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m17803l() {
        IRecMarkerController iRecMarkerController = this.f24936i;
        if (!(iRecMarkerController == null || iRecMarkerController.findMarker(DepartureUtils.getMapCenterPoint(this.f24930c)) == null)) {
            this.f24936i.hideCircles();
        }
        IRecMarkerController iRecMarkerController2 = this.f24936i;
        if (iRecMarkerController2 != null) {
            iRecMarkerController2.setNeedShowInfoWindow(false);
            this.f24936i.onMapStable();
        }
        m17753a("handleMapStable() mDragging=" + this.f24944q + ",isRequireByDrag=" + this.f24929b.isRequireByDrag());
        if (this.f24944q && this.f24929b.isRequireByDrag()) {
            m17735a(DepartureUtils.getMapCenterPoint(this.f24930c));
            this.f24948u = null;
        }
        this.f24944q = false;
    }

    /* renamed from: b */
    private boolean m17772b(DepartureLocationInfo departureLocationInfo) {
        return departureLocationInfo != null && LatLngUtils.locateCorrect(departureLocationInfo.latLng);
    }

    public void onConfirmClickInBroadOther() {
        this.f24926R = false;
        this.f24920L = true;
        m17752a(this.f24951x);
    }

    public void setPadding(Padding padding) {
        Map map = this.f24930c;
        if (map != null && padding != null && !map.getPadding().equals(padding)) {
            this.f24913E = padding;
            padding.left = Math.max(padding.left, this.f24915G);
            this.f24913E.right = Math.max(padding.right, this.f24915G);
            DLog.m7384d("DepartureView", "setPadding ->: " + this.f24913E.toString(), new Object[0]);
            Handler handler = this.f24912D;
            if (handler != null) {
                handler.removeCallbacks(this.f24914F);
                this.f24912D.postDelayed(this.f24914F, 100);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0198  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17735a(com.didi.common.map.model.LatLng r8) {
        /*
            r7 = this;
            boolean r0 = com.didi.common.map.util.LatLngUtils.locateCorrect(r8)
            if (r0 == 0) goto L_0x019c
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f24945r
            if (r0 == 0) goto L_0x019c
            boolean r0 = r7.f24933f
            if (r0 != 0) goto L_0x0010
            goto L_0x019c
        L_0x0010:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "refreshDepartureLocationOnMapDraged() =="
            r0.append(r1)
            java.lang.String r1 = r8.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.m17753a((java.lang.String) r0)
            r0 = 0
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r7.f24951x
            r2 = 1
            if (r1 != 0) goto L_0x0036
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f24945r
            r0.latLng = r8
        L_0x0033:
            r0 = 1
            goto L_0x0161
        L_0x0036:
            boolean r1 = r7.m17768b((com.didi.common.map.model.LatLng) r8)
            r3 = 0
            if (r1 == 0) goto L_0x0059
            java.util.List<com.sdk.poibase.model.RpcPoi> r0 = r7.f24947t
            com.sdk.poibase.model.RpcPoi r0 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r8, r0)
            r7.f24946s = r0
            if (r0 == 0) goto L_0x0054
            r7.m17751a(r0, r3, r2, r2)
            com.sdk.poibase.model.RpcPoi r8 = r7.f24946s
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r7.m17729a((com.sdk.poibase.model.RpcPoi) r8)
            r7.m17764b((com.didi.map.global.component.departure.model.DepartureAddress) r8)
            return
        L_0x0054:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f24945r
            r0.latLng = r8
            goto L_0x0033
        L_0x0059:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r1 = r7.f24945r
            com.didi.common.map.model.LatLng r1 = r1.latLng
            boolean r1 = com.didi.common.map.util.LatLngUtils.isSameLatLng(r1, r8)
            if (r1 == 0) goto L_0x0067
            r7.m17787e((com.didi.common.map.model.LatLng) r8)
            return
        L_0x0067:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r1 = r7.f24945r
            r1.latLng = r8
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r7.f24951x
            com.sdk.poibase.model.poi.FenceInfo r1 = r1.startFenceInfo
            boolean r4 = com.didi.map.global.component.departure.util.FenceUtils.isFenceMustAbsorb(r1)
            if (r4 == 0) goto L_0x010c
            com.didi.common.map.Map r4 = r7.f24930c
            boolean r1 = com.didi.map.global.component.departure.util.FenceUtils.positionIsInFence(r4, r1, r8)
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7.f24926R
            if (r1 == 0) goto L_0x008c
            r7.m17787e((com.didi.common.map.model.LatLng) r8)
            com.didi.map.global.component.departure.IDepartureCompContract$IDepartureComponentCallback r8 = r7.f24932e
            if (r8 == 0) goto L_0x008b
            r8.onBroadOtherMapCallback(r2)
        L_0x008b:
            return
        L_0x008c:
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f24938k
            if (r1 == 0) goto L_0x00c2
            boolean r1 = r1.isTerminal()
            if (r1 == 0) goto L_0x00c2
            com.didi.map.global.component.departure.model.SpecialPois r0 = r7.m17813q()
            java.util.List r0 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointList(r0)
            com.didi.map.global.component.recmarker.model.RecPoint r0 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecPoint(r8, r0)
            if (r0 == 0) goto L_0x00be
            java.lang.String r1 = r0.addrName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00be
            com.didi.map.global.component.departure.model.SpecialPois r1 = r7.m17813q()
            java.lang.String r0 = r0.addrName
            com.didi.map.global.component.departure.model.SPoi r0 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r1, r0)
            r7.m17748a((com.didi.map.global.component.departure.model.SPoi) r0)
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f24938k
            r1.setSelectedTerminalArea(r0)
        L_0x00be:
            r7.m17787e((com.didi.common.map.model.LatLng) r8)
            return
        L_0x00c2:
            java.util.List<com.sdk.poibase.model.RpcPoi> r1 = r7.f24947t
            com.sdk.poibase.model.RpcPoi r1 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r8, r1)
            r7.f24946s = r1
            if (r1 == 0) goto L_0x0161
            com.didi.map.global.component.departure.view.DepartureCardViewController r8 = r7.f24938k
            if (r8 == 0) goto L_0x00f9
            boolean r8 = r8.isTerminalViewValid()
            if (r8 == 0) goto L_0x00f9
            com.didi.map.global.component.departure.view.DepartureCardViewController r8 = r7.f24938k
            com.sdk.poibase.model.RpcPoi r0 = r7.f24946s
            r8.setSelectedDeparture(r0)
            com.didi.map.global.component.recmarker.IRecMarkerController r8 = r7.f24936i
            if (r8 == 0) goto L_0x00e6
            com.sdk.poibase.model.RpcPoi r8 = r7.f24946s
            r7.m17751a(r8, r3, r2, r2)
        L_0x00e6:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r8 = r7.f24940m
            com.didi.map.global.component.departure.view.DepartureCardViewController r0 = r7.f24938k
            com.didi.map.global.component.departure.model.SPoi r0 = r0.getSelectedTerminalArea()
            r8.setSelectedTerminalSPoi(r0)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r8 = r7.f24940m
            com.sdk.poibase.model.RpcPoi r0 = r7.f24946s
            r8.reportOmegaOnTerminalRecPickupChange(r0, r2)
            goto L_0x0102
        L_0x00f9:
            com.didi.map.global.component.recmarker.IRecMarkerController r8 = r7.f24936i
            if (r8 == 0) goto L_0x0102
            com.sdk.poibase.model.RpcPoi r8 = r7.f24946s
            r7.m17751a(r8, r3, r2, r2)
        L_0x0102:
            com.sdk.poibase.model.RpcPoi r8 = r7.f24946s
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r7.m17729a((com.sdk.poibase.model.RpcPoi) r8)
            r7.m17764b((com.didi.map.global.component.departure.model.DepartureAddress) r8)
            return
        L_0x010c:
            com.didi.map.global.component.departure.departure.DeparturePresenter r1 = r7.f24942o
            if (r1 == 0) goto L_0x0116
            java.util.List<com.sdk.poibase.model.RpcPoi> r3 = r7.f24947t
            com.sdk.poibase.model.RpcPoi r3 = r1.sensing(r3)
        L_0x0116:
            r7.f24946s = r3
            if (r3 == 0) goto L_0x0033
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r3.base_info
            if (r1 == 0) goto L_0x0033
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r7.f24936i
            if (r1 == 0) goto L_0x0033
            java.lang.String r1 = "refreshDepartureLocationOnMapDraged is 5% poi"
            r7.m17753a((java.lang.String) r1)
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f24938k
            if (r1 == 0) goto L_0x0139
            boolean r1 = r1.isTerminalViewValid()
            if (r1 == 0) goto L_0x0139
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f24938k
            com.sdk.poibase.model.RpcPoi r3 = r7.f24946s
            r1.setSelectedDeparture(r3)
        L_0x0139:
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoi r3 = r7.f24946s
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r3.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoi r5 = r7.f24946s
            com.sdk.poibase.model.RpcPoiBaseInfo r5 = r5.base_info
            double r5 = r5.lng
            r1.<init>((double) r3, (double) r5)
            com.didi.map.global.component.recmarker.IRecMarkerController r3 = r7.f24936i
            com.didi.map.global.component.recmarker.view.IRecMarker r3 = r3.findMarker(r1)
            if (r3 == 0) goto L_0x0161
            com.sdk.poibase.model.RpcPoi r8 = r7.f24946s
            r7.m17751a(r8, r1, r2, r2)
            com.sdk.poibase.model.RpcPoi r8 = r7.f24946s
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r7.m17729a((com.sdk.poibase.model.RpcPoi) r8)
            r7.m17764b((com.didi.map.global.component.departure.model.DepartureAddress) r8)
            return
        L_0x0161:
            if (r0 == 0) goto L_0x0198
            boolean r8 = r7.m17831z()
            if (r8 == 0) goto L_0x0192
            com.didi.map.global.component.departure.circle.ZoneCircleController r8 = r7.f24941n
            com.didi.common.map.model.LatLng r8 = r8.getCenter()
            com.didi.common.map.model.LatLng r0 = r7.f24948u
            if (r0 == 0) goto L_0x018b
            com.didi.map.global.component.departure.circle.ZoneCircleController r0 = r7.f24941n
            com.didi.common.map.model.Circle r0 = r0.getCircle()
            if (r0 == 0) goto L_0x018b
            com.didi.map.global.component.departure.circle.ZoneCircleController r0 = r7.f24941n
            com.didi.common.map.model.Circle r0 = r0.getCircle()
            com.didi.common.map.model.LatLng r1 = r7.f24948u
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x018b
            com.didi.common.map.model.LatLng r8 = r7.f24948u
        L_0x018b:
            r7.m17782d((com.didi.common.map.model.LatLng) r8)
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f24945r
            r0.latLng = r8
        L_0x0192:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r8 = r7.f24945r
            r7.m17747a((com.didi.map.global.component.departure.model.DepartureLocationInfo) r8, (int) r2)
            goto L_0x019b
        L_0x0198:
            r7.m17787e((com.didi.common.map.model.LatLng) r8)
        L_0x019b:
            return
        L_0x019c:
            r7.m17787e((com.didi.common.map.model.LatLng) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.canoe.CanoeDepartureView.m17735a(com.didi.common.map.model.LatLng):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17747a(DepartureLocationInfo departureLocationInfo, int i) {
        m17753a("startPoiRequest...");
        if (this.f24929b != null) {
            this.f24910B = CallFrom.CANOE_DEPARTURE_FROMHOME == this.f24929b.getReqCallerId() && (departureLocationInfo.latLng == null || i == 0);
        }
        if (this.f24942o != null && departureLocationInfo != null) {
            this.f24945r = departureLocationInfo;
            CarpoolDepartureController carpoolDepartureController = this.f24939l;
            if (carpoolDepartureController != null) {
                carpoolDepartureController.drawCircle(departureLocationInfo.latLng);
            }
            this.f24953z = i;
            this.f24942o.startRequest(departureLocationInfo, i, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m17768b(LatLng latLng) {
        FenceController fenceController = this.f24935h;
        return fenceController != null && fenceController.isInFence(latLng) == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m17779c(LatLng latLng) {
        FenceController fenceController = this.f24935h;
        return fenceController != null && fenceController.isInFence(latLng) == 3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17752a(ReverseStationsInfo reverseStationsInfo) {
        if (this.f24933f) {
            DepartureCompParams departureCompParams = this.f24929b;
            if (departureCompParams == null || departureCompParams.getApiType() != ApiType.DEPARTURE_POI_INFO) {
                m17778c(reverseStationsInfo);
                return;
            }
            if (this.f24926R) {
                this.f24926R = false;
            }
            m17767b(reverseStationsInfo);
        }
    }

    /* renamed from: b */
    private void m17767b(ReverseStationsInfo reverseStationsInfo) {
        SPoi sPoi;
        DepartureCardViewController departureCardViewController;
        m17753a("handlePoiResult()  start");
        if (reverseStationsInfo == null) {
            m17809o();
            return;
        }
        DepartureOmegaUtils.OmegaParams.type = 1;
        this.f24951x = reverseStationsInfo;
        m17797i();
        m17800k();
        ArrayList<RpcPoi> recStartPoints = reverseStationsInfo.getRecStartPoints();
        this.f24947t = recStartPoints;
        if (CollectionUtil.isEmpty((Collection<?>) recStartPoints)) {
            this.f24947t = TerminalUtils.getSelectedSpecialRpcPoiList(this.f24951x);
        }
        this.f24946s = DepartureUtils.findRecommendAdsorbPoint(this.f24947t);
        if (this.f24920L) {
            LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f24930c);
            sPoi = TerminalUtils.getNearestSpoi(mapCenterPoint, this.f24951x);
            if (sPoi != null && !CollectionUtil.isEmpty((Collection<?>) sPoi.list)) {
                List<RpcPoi> list = sPoi.list;
                this.f24947t = list;
                this.f24946s = DepartureUtils.findTargetRecommend(mapCenterPoint, list);
            }
        } else {
            sPoi = null;
        }
        DepartureAddress a = m17729a(this.f24946s);
        this.f24949v = a;
        m17788e(a);
        if (this.f24920L && (departureCardViewController = this.f24938k) != null) {
            if (departureCardViewController != null) {
                departureCardViewController.performSelectedArea(sPoi, this.f24946s);
            }
            this.f24920L = false;
        }
        m17746a(this.f24949v);
        List<RecPoint> terminalRecPointListWithoutPointFirst = TerminalUtils.getTerminalRecPointListWithoutPointFirst(m17813q());
        if (!CollectionUtil.isEmpty((Collection<?>) terminalRecPointListWithoutPointFirst)) {
            m17754a(terminalRecPointListWithoutPointFirst, true);
        } else {
            m17754a(TerminalUtils.getRecPointList(this.f24947t), false);
        }
        DepartureCardViewController departureCardViewController2 = this.f24938k;
        if (departureCardViewController2 == null || !departureCardViewController2.isValidAndTerminal() || CollectionUtil.isEmpty((Collection<?>) terminalRecPointListWithoutPointFirst) || this.f24911C == 1) {
            this.f24940m.clearTerminalCache();
            if (this.f24936i == null) {
                m17753a("handlePoiResult,is normal poi, mRecMakerController is null,mLocationInfo=" + this.f24945r);
                LatLng u = m17821u();
                if (CallFrom.CANOE_DEPARTURE_FROMHOME != this.f24929b.getReqCallerId()) {
                    m17782d(u);
                }
                m17764b(this.f24949v);
                m17722A();
                return;
            }
            RpcPoi rpcPoi = this.f24946s;
            if (rpcPoi == null || rpcPoi.base_info == null) {
                m17753a("handleResult() 普通推荐点-未吸附");
            } else {
                LatLng latLng = new LatLng(this.f24946s.base_info.lat, this.f24946s.base_info.lng);
                m17753a("handleResult() 普通推荐点-吸附: " + latLng.toString());
                m17751a(this.f24946s, latLng, true, true);
                DepartureAddress departureAddress = this.f24949v;
                if (departureAddress != null && departureAddress.getZoneType() == 0) {
                    this.f24940m.setDefaultRecTerminalPickupPoi(this.f24946s);
                }
                DepartureCardViewController departureCardViewController3 = this.f24938k;
                if (departureCardViewController3 != null && departureCardViewController3.isTerminalViewValid()) {
                    this.f24940m.setSelectedTerminalSPoi(this.f24938k.getSelectedTerminalArea());
                }
            }
            if (this.f24911C == 1) {
                m17797i();
            }
            m17764b(this.f24949v);
            m17722A();
            return;
        }
        RecPoint findTargetRecPoint = DepartureUtils.findTargetRecPoint(DepartureUtils.getMapCenterPoint(this.f24930c), terminalRecPointListWithoutPointFirst);
        if (findTargetRecPoint == null || TextUtils.isEmpty(findTargetRecPoint.addrName)) {
            m17753a("handleResult() 场站内-未吸附");
            return;
        }
        m17753a("handleResult() 场站内-吸附,recPoint=" + findTargetRecPoint.location.toString());
        SPoi adsorbTerminalAreaByName = TerminalUtils.getAdsorbTerminalAreaByName(m17813q(), findTargetRecPoint.addrName);
        this.f24938k.setSelectedTerminalArea(adsorbTerminalAreaByName);
        this.f24940m.setSelectedTerminalSPoi(adsorbTerminalAreaByName);
        m17751a((RpcPoi) null, findTargetRecPoint.location, true, true);
        m17764b(this.f24949v);
        m17722A();
    }

    /* renamed from: c */
    private void m17778c(ReverseStationsInfo reverseStationsInfo) {
        m17753a("handleReverseGeoResult() start");
        DepartureOmegaUtils.OmegaParams.type = 0;
        if (reverseStationsInfo != null) {
            DepartureAddress a = m17729a((RpcPoi) null);
            this.f24949v = a;
            if (a != null) {
                m17782d(m17821u());
                this.f24951x = reverseStationsInfo;
                PinActionUtils.startAdsorbRecommendAnimation((IPinDrawer) null, 10, (DepartureMarkerView.AnimationFinishListener) null);
                m17764b(this.f24949v);
                return;
            }
        }
        m17753a("handleReverseGeoResult() is null, return.");
        m17809o();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m17751a(com.sdk.poibase.model.RpcPoi r12, com.didi.common.map.model.LatLng r13, final boolean r14, final boolean r15) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x000a
            if (r13 != 0) goto L_0x000a
            java.lang.String r12 = "animateToAdsorbPoi() is null, return."
            r11.m17753a((java.lang.String) r12)
            return
        L_0x000a:
            boolean r0 = r11.m17789e()
            if (r0 != 0) goto L_0x0016
            java.lang.String r12 = "animateToAdsorbPoi() recMarkerShowable is false, return."
            r11.m17753a((java.lang.String) r12)
            return
        L_0x0016:
            java.lang.String r0 = "animateToAdsorbPoi 吸附开始"
            r11.m17753a((java.lang.String) r0)
            com.sdk.poibase.model.RpcPoi r0 = r11.f24946s
            com.didi.map.global.component.departure.util.DepartureOmegaUtils.mapDragRecommend(r0)
            r0 = 0
            if (r12 == 0) goto L_0x0035
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r12.base_info
            if (r1 == 0) goto L_0x0035
            com.didi.common.map.model.LatLng r13 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r12.base_info
            double r0 = r0.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r12 = r12.base_info
            double r2 = r12.lng
            r13.<init>((double) r0, (double) r2)
            goto L_0x0037
        L_0x0035:
            if (r13 == 0) goto L_0x0039
        L_0x0037:
            r5 = r13
            goto L_0x003a
        L_0x0039:
            r5 = r0
        L_0x003a:
            if (r5 == 0) goto L_0x0064
            com.didi.map.global.component.departure.DepartureCompParams r12 = r11.f24929b
            if (r12 != 0) goto L_0x0041
            goto L_0x0064
        L_0x0041:
            com.didi.map.global.component.recmarker.IRecMarkerController r12 = r11.f24936i
            if (r12 == 0) goto L_0x004a
            com.didi.map.global.component.recmarker.RecMarkerController r12 = (com.didi.map.global.component.recmarker.RecMarkerController) r12
            r12.updateMarkerPinedState(r5)
        L_0x004a:
            java.util.concurrent.atomic.AtomicBoolean r12 = r11.f24909A
            r13 = 1
            r12.set(r13)
            com.didi.common.map.Map r4 = r11.f24930c
            r6 = 1
            r7 = 0
            com.didi.map.global.component.departure.DepartureCompParams r12 = r11.f24929b
            float r8 = r12.getZoom()
            com.didi.common.map.model.Padding r9 = r11.f24913E
            com.didi.map.global.component.departure.canoe.CanoeDepartureView$5 r10 = new com.didi.map.global.component.departure.canoe.CanoeDepartureView$5
            r10.<init>(r14, r15, r5)
            com.didi.map.global.component.departure.util.PinActionUtils.animateCamera(r4, r5, r6, r7, r8, r9, r10)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.canoe.CanoeDepartureView.m17751a(com.sdk.poibase.model.RpcPoi, com.didi.common.map.model.LatLng, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17782d(LatLng latLng) {
        if (latLng != null) {
            m17753a("animateToDeparture 动画开始");
            boolean z = (this.f24941n == null && this.f24939l == null) ? this.f24953z == 0 : false;
            this.f24909A.set(true);
            PinActionUtils.animateCamera(this.f24930c, latLng, true, z, this.f24929b.getZoom(), this.f24913E, new BestViewer.IBestViewListener() {
                public void onFinished() {
                    CanoeDepartureView.this.m17753a("动画完成");
                    CanoeDepartureView.this.f24909A.set(false);
                    int u = CanoeDepartureView.this.m17828y();
                    if (CanoeDepartureView.this.f24932e != null) {
                        CanoeDepartureView.this.f24932e.onDragging(u);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    private void m17787e(LatLng latLng) {
        String str;
        boolean z;
        AbsCanoeAddressView absCanoeAddressView;
        if (this.f24929b.isBubbleVisible() && this.f24934g != null) {
            DepartureCardViewController departureCardViewController = this.f24938k;
            boolean z2 = departureCardViewController != null && departureCardViewController.isTerminalViewValid() && !this.f24938k.isWelcomeViewValid() && !this.f24938k.isTerminal() && !this.f24938k.isWaitCheckPickupSpot() && this.f24911C != 1;
            AddressWalkGuide m = m17805m();
            if (m != null && z2) {
                if (this.f24925Q == null) {
                    DepartureWalkGuide departureWalkGuide = new DepartureWalkGuide(this.f24930c.getContext());
                    this.f24925Q = departureWalkGuide;
                    departureWalkGuide.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CanoeDepartureView.this.m17761b(view);
                        }
                    });
                }
                this.f24925Q.setData(m);
                IDeparturePinView iDeparturePinView = this.f24934g;
                DepartureWalkGuide departureWalkGuide2 = this.f24925Q;
                iDeparturePinView.showView(departureWalkGuide2, departureWalkGuide2.getWIDTH(), this.f24925Q.getHEIGHT(), this.f24925Q.getANGLE());
            } else if (m17768b(latLng) || m17779c(latLng)) {
                this.f24934g.toNoParking();
            } else {
                String n = m17807n();
                DepartureCardViewController departureCardViewController2 = this.f24938k;
                if (departureCardViewController2 == null || (!departureCardViewController2.isWelcomeViewValid() && !this.f24938k.isWaitCheckPickupSpot() && !this.f24938k.isTerminal())) {
                    int i = this.f24911C;
                    if (i == 3) {
                        DepartureAddress departureAddress = this.f24924P;
                        if (departureAddress != null) {
                            str = departureAddress.getDepartureDisplayName();
                            z = true;
                        } else {
                            str = this.f24930c.getContext().getString(R.string.canoe_input);
                            z = false;
                        }
                        if (z) {
                            if (this.f24921M == null) {
                                this.f24921M = new CanoeAddressView(this.f24930c.getContext());
                            }
                            absCanoeAddressView = this.f24921M;
                        } else {
                            if (this.f24922N == null) {
                                this.f24922N = new CanoeAddressFailView(this.f24930c.getContext());
                            }
                            absCanoeAddressView = this.f24922N;
                        }
                        absCanoeAddressView.setAddressName(str);
                        absCanoeAddressView.setClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                CanoeDepartureView.this.m17734a(view);
                            }
                        });
                        int[] widthHeight = absCanoeAddressView.getWidthHeight();
                        this.f24934g.showView(absCanoeAddressView, widthHeight[0], widthHeight[1], absCanoeAddressView.getAngle());
                    } else if (i == 4) {
                        if (this.f24923O == null) {
                            this.f24923O = new DestinationFlagView(this.f24930c.getContext());
                        }
                        int[] widthHeight2 = this.f24923O.getWidthHeight();
                        IDeparturePinView iDeparturePinView2 = this.f24934g;
                        DestinationFlagView destinationFlagView = this.f24923O;
                        iDeparturePinView2.showView(destinationFlagView, widthHeight2[0], widthHeight2[1], destinationFlagView.getAngle());
                    } else if (i == 5) {
                        if (TextUtils.isEmpty(n)) {
                            n = this.f24930c.getContext().getString(R.string.Canoe_Rider_Mainprocess_Get_in_YPSM);
                        }
                        this.f24934g.showText(n);
                    } else {
                        if (TextUtils.isEmpty(n)) {
                            n = this.f24930c.getContext().getString(R.string.GRider_Homepage0714_Get_on_XNNb);
                        }
                        this.f24934g.showText(n);
                    }
                } else {
                    this.f24934g.showText(this.f24930c.getContext().getString(R.string.GRider_Homepage0714_Get_in_tpiW));
                }
            }
        }
        ThreadManager.getHandler(0).postDelayed(new Runnable() {
            public void run() {
                DepartureOmegaUtils.trackPinMove(DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f24930c));
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m17761b(View view) {
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f24932e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onClickBubble();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17734a(View view) {
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f24932e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onClickBubble();
        }
    }

    /* renamed from: m */
    private AddressWalkGuide m17805m() {
        DepartureAddress departureAddress = this.f24924P;
        if (departureAddress == null || departureAddress.getExtendInfo() == null || this.f24924P.getExtendInfo().getWalkGuide() == null || !this.f24924P.getExtendInfo().getWalkGuide().isValid()) {
            return null;
        }
        return this.f24924P.getExtendInfo().getWalkGuide();
    }

    /* renamed from: n */
    private String m17807n() {
        DepartureAddress departureAddress = this.f24924P;
        if (departureAddress == null || departureAddress.getExtendInfo() == null) {
            return null;
        }
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(this.f24924P.getExtendInfo().getBubbleText());
        return richTextInfo.getContent();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17764b(DepartureAddress departureAddress) {
        this.f24924P = departureAddress;
        DepartureInterceptController departureInterceptController = this.f24916H;
        if (departureInterceptController != null) {
            ReverseStationsInfo reverseStationsInfo = this.f24951x;
            departureInterceptController.updateNewRequestLocation(departureAddress, reverseStationsInfo == null ? null : reverseStationsInfo.locLevel);
        }
        m17753a("onDepartureAddrSuccess callback");
        if (departureAddress != null) {
            m17777c(departureAddress);
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f24932e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onDepartureAddressChanged(departureAddress);
            }
            m17787e(departureAddress.getPosition());
        } else {
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback2 = this.f24932e;
            if (iDepartureComponentCallback2 != null) {
                iDepartureComponentCallback2.onFetchAddressFail(m17810p());
            }
            m17787e(m17810p());
        }
        m17736a(departureAddress == null ? m17810p() : departureAddress.getPosition(), false);
    }

    /* renamed from: o */
    private void m17809o() {
        m17787e(m17810p());
        DepartureInterceptController departureInterceptController = this.f24916H;
        if (departureInterceptController != null) {
            departureInterceptController.updateNewRequestLocation((DepartureAddress) null, (String) null);
        }
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f24932e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onFetchAddressFail(m17810p());
        }
        m17736a(m17810p(), true);
    }

    /* renamed from: a */
    private void m17736a(LatLng latLng, boolean z) {
        LatLng latLng2;
        String str;
        Map map = this.f24930c;
        if (map != null) {
            if (latLng == null) {
                latLng = DepartureUtils.getMapCenterPoint(map);
            }
            if (m17768b(latLng) || m17779c(latLng)) {
                FenceInfo fenceInfo = this.f24935h.getFenceInfo();
                DepartureAddress departureAddress = this.f24949v;
                String str2 = null;
                if (departureAddress == null || departureAddress.getAddress() == null) {
                    str = null;
                    latLng2 = null;
                } else {
                    str = this.f24949v.getAddress().poiId;
                    latLng2 = this.f24949v.getPosition();
                }
                if (fenceInfo != null) {
                    str2 = fenceInfo.fenceId;
                }
                if (str2 == null) {
                    str2 = this.f24935h.isInAroundFence(latLng);
                }
                if (!TextUtils.isEmpty(str2)) {
                    DepartureOmegaUtils.trackNoParkingError(latLng2, str, str2, z ? 1 : 0);
                }
            }
        }
    }

    /* renamed from: c */
    private void m17777c(DepartureAddress departureAddress) {
        m17784d(departureAddress);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17784d(DepartureAddress departureAddress) {
        DepartureOmegaManager departureOmegaManager = this.f24940m;
        if (departureOmegaManager != null) {
            departureOmegaManager.setPickupPoiDescription(DepartureUtils.getMainTitleFromDepartureAddr(departureAddress));
        }
    }

    /* renamed from: p */
    private LatLng m17810p() {
        DepartureLocationInfo departureLocationInfo = this.f24945r;
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
    public com.didi.map.global.component.departure.model.DepartureAddress m17729a(com.sdk.poibase.model.RpcPoi r8) {
        /*
            r7 = this;
            com.didi.map.global.component.departure.departure.DeparturePresenter r0 = r7.f24942o
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
            com.sdk.poibase.model.poi.ReverseStationsInfo r0 = r7.f24951x
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
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r7.f24951x
            if (r2 == 0) goto L_0x004d
            com.sdk.poibase.model.RpcPoi r1 = r2.getDepartureAddress()
        L_0x004d:
            com.didi.map.global.component.departure.departure.DeparturePresenter r2 = r7.f24942o
            com.didi.common.map.model.LatLng r3 = r7.m17810p()
            boolean r0 = r7.m17768b((com.didi.common.map.model.LatLng) r0)
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r2.getDepartureAddress(r8, r1, r3, r0)
            return r8
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.canoe.CanoeDepartureView.m17729a(com.sdk.poibase.model.RpcPoi):com.didi.map.global.component.departure.model.DepartureAddress");
    }

    /* renamed from: q */
    private SpecialPois m17813q() {
        DepartureAddress departureAddress = this.f24949v;
        if (departureAddress != null) {
            return departureAddress.getSpecialPois();
        }
        return null;
    }

    /* renamed from: e */
    private void m17788e(DepartureAddress departureAddress) {
        if (this.f24929b.isTerminalViewVisible()) {
            m17753a("handleTerminalView() isTerminalViewVisible is true");
            if (departureAddress != null && departureAddress.getZoneType() == 0) {
                m17816s();
            }
            DepartureCardViewController departureCardViewController = this.f24938k;
            if (departureCardViewController != null) {
                departureCardViewController.setData(departureAddress, DepartureUtils.getFenceInfo(this.f24951x), this.f24946s);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m17814r() {
        this.f24926R = true;
        m17800k();
    }

    /* renamed from: s */
    private void m17816s() {
        if (this.f24938k == null) {
            DepartureCardViewController departureCardViewController = new DepartureCardViewController(this.f24931d, this.f24929b);
            this.f24938k = departureCardViewController;
            departureCardViewController.setTerminalViewCallback(new ITerminalView.Callback() {
                public void onTerminalAreaSelected(SPoi sPoi, int i) {
                    CanoeDepartureView.this.m17748a(sPoi);
                    CanoeDepartureView.this.f24940m.setSelectedTerminalSPoi(sPoi);
                }

                public void onDepartureSelected(RpcPoi rpcPoi, int i) {
                    CanoeDepartureView.this.m17766b(rpcPoi);
                    CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                    canoeDepartureView.m17753a("onDepartureSelected eventCode=" + i);
                    if (i == 2) {
                        CanoeDepartureView.this.f24940m.reportOmegaOnTerminalRecPickupChange(CanoeDepartureView.this.f24946s, 3);
                    }
                }

                public void onClickChange(SpecialPois specialPois) {
                    CanoeDepartureView.this.m17749a(specialPois);
                }

                public void onClickNext(SPoi sPoi) {
                    CanoeDepartureView.this.m17765b(sPoi);
                }

                public void onClickConfirmPickup(RpcPoi rpcPoi) {
                    if (CanoeDepartureView.this.f24932e != null) {
                        CanoeDepartureView.this.m17784d(CanoeDepartureView.this.m17729a(rpcPoi));
                        CanoeDepartureView.this.f24932e.onConfirmPickup(CanoeDepartureView.this.m17729a(rpcPoi));
                    }
                    CanoeDepartureView.this.f24940m.reportOmegaOnTerminalConfirmButtonClick(rpcPoi);
                }

                public void onClickBroadOther() {
                    CanoeDepartureView.this.m17814r();
                    FenceInfo fenceInfo = CanoeDepartureView.this.f24949v.getFenceInfo();
                    if (!(fenceInfo == null || CanoeDepartureView.this.f24949v.getAddress() == null)) {
                        CanoeDepartureView.this.f24949v.getAddress().displayName = fenceInfo.fenceName;
                    }
                    if (CanoeDepartureView.this.f24932e != null) {
                        CanoeDepartureView.this.f24932e.onClickBroadOtherInStationCard(CanoeDepartureView.this.f24949v);
                    }
                    CanoeDepartureView.this.f24940m.reportOmegaStationAreaBroadFromOther();
                }
            });
            this.f24938k.setWelcomeViewCallback(new ITerminalWelcomeView.Callback() {
                public void onClickSetPickupSpot() {
                    if (CanoeDepartureView.this.f24932e != null) {
                        CanoeDepartureView.this.f24932e.onStartTerminalWindow(CanoeDepartureView.this.f24949v);
                    }
                    CanoeDepartureView.this.f24940m.reportOmegaOnWelcomeButtonClick();
                }

                public void onClickSelectOtherArea() {
                    if (CanoeDepartureView.this.f24932e != null) {
                        CanoeDepartureView.this.f24932e.onStartSugPage(CanoeDepartureView.this.f24949v);
                    }
                    CanoeDepartureView.this.f24940m.reportOmegaOnOtherAreaClick();
                }
            });
        }
    }

    /* renamed from: t */
    private void m17819t() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f24930c);
        if (mapCenterPoint != null) {
            this.f24945r.latLng = mapCenterPoint;
            m17747a(this.f24945r, 1);
        }
    }

    public DepartureAddress getDepartureAddress() {
        return this.f24949v;
    }

    public void startTerminalSelect() {
        DepartureCardViewController departureCardViewController = this.f24938k;
        if (departureCardViewController != null) {
            departureCardViewController.setPickupSpotChecked(true);
            m17819t();
        }
    }

    public boolean isShowTerminalViewOnSetPickupSpotAfter() {
        DepartureCardViewController departureCardViewController;
        if (this.f24929b.isTerminalViewVisible() && (departureCardViewController = this.f24938k) != null && departureCardViewController.isWaitCheckPickupSpot()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17748a(SPoi sPoi) {
        m17753a("terminalAreaSelected()");
        if (!(sPoi == null || sPoi.area == null || sPoi.area.centre_point == null)) {
            m17751a((RpcPoi) null, new LatLng(sPoi.area.centre_point.lat, sPoi.area.centre_point.lng), true, false);
        }
        this.f24927S = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17766b(RpcPoi rpcPoi) {
        m17753a("departureSelected()");
        if (rpcPoi != null && rpcPoi.base_info != null) {
            this.f24946s = rpcPoi;
            m17751a(rpcPoi, (LatLng) null, true, false);
            RpcPoi rpcPoi2 = this.f24927S;
            String str = (rpcPoi2 == null || rpcPoi2.base_info == null) ? "" : this.f24927S.base_info.poi_id;
            if (TextUtils.isEmpty(str) || !str.equals(rpcPoi.base_info.poi_id)) {
                this.f24927S = rpcPoi;
                if (this.f24932e != null) {
                    DepartureAddress a = m17729a(rpcPoi);
                    DepartureCardViewController departureCardViewController = this.f24938k;
                    if (departureCardViewController != null) {
                        departureCardViewController.refreshTerminalCardViewSubNotice(a);
                    }
                    m17784d(a);
                    this.f24924P = a;
                    if (a != null) {
                        m17777c(a);
                        this.f24932e.onDepartureAddressChanged(a);
                        m17787e(a.getPosition());
                        return;
                    }
                    this.f24932e.onFetchAddressFail(m17810p());
                    m17787e(m17810p());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17749a(SpecialPois specialPois) {
        m17753a("clickChangeToShowTerminalAreaList()");
        List<RecPoint> terminalRecPointList = TerminalUtils.getTerminalRecPointList(specialPois);
        DepartureCardViewController departureCardViewController = this.f24938k;
        if (departureCardViewController != null && departureCardViewController.hasTerminalView()) {
            m17754a(terminalRecPointList, true);
            SPoi selectedTerminalArea = this.f24938k.getSelectedTerminalArea();
            if (selectedTerminalArea == null) {
                selectedTerminalArea = TerminalUtils.getAdsorbTerminalArea(specialPois);
            }
            m17748a(selectedTerminalArea);
            m17787e((LatLng) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17765b(SPoi sPoi) {
        m17753a("clickNextToSelectTerminalArea()");
        if (sPoi != null && !CollectionUtil.isEmpty((Collection<?>) sPoi.list)) {
            this.f24947t = sPoi.list;
            m17754a(TerminalUtils.getRecPointList(sPoi.list), false);
            RpcPoi findRecommendAdsorbPoint = DepartureUtils.findRecommendAdsorbPoint(sPoi.list);
            m17766b(findRecommendAdsorbPoint);
            this.f24940m.setSelectedTerminalSPoi(sPoi);
            this.f24940m.setDefaultRecTerminalPickupPoi(findRecommendAdsorbPoint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public LatLng m17821u() {
        DepartureLocationInfo departureLocationInfo = this.f24945r;
        if (departureLocationInfo == null || departureLocationInfo.latLng == null || this.f24945r.latLng.latitude == 0.0d) {
            return DepartureUtils.getMapCenterPoint(this.f24930c);
        }
        return this.f24945r.latLng;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f24945r;
    }

    public View getDepartureCardView() {
        DepartureCardViewController departureCardViewController = this.f24938k;
        if (departureCardViewController != null) {
            return departureCardViewController.getDepartureCardView();
        }
        return null;
    }

    /* renamed from: v */
    private void m17823v() {
        DeparturePresenter departurePresenter = this.f24942o;
        if (departurePresenter != null) {
            departurePresenter.stopRequest();
        }
    }

    public void start() {
        m17760b();
        m17791f();
        m17795h();
        m17747a(this.f24945r, this.f24953z);
        this.f24909A.set(true);
        C939510 r8 = new BestViewer.IBestViewListener() {
            public void onFinished() {
                CanoeDepartureView.this.f24909A.set(false);
            }
        };
        ZoneCircleController zoneCircleController = this.f24941n;
        if (zoneCircleController == null || CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
            DepartureLocationInfo departureLocationInfo = this.f24945r;
            if (departureLocationInfo != null && LatLngUtils.locateCorrect(departureLocationInfo.latLng)) {
                CarpoolDepartureController carpoolDepartureController = this.f24939l;
                if (carpoolDepartureController != null) {
                    BestViewer.doBestView(this.f24930c, false, (LatLng) null, carpoolDepartureController.getBestViewPoints(this.f24945r.latLng), this.f24913E, (Padding) null, r8);
                    return;
                }
                PinActionUtils.animateCamera(this.f24930c, this.f24945r.latLng, false, true, this.f24929b.getZoom(), this.f24913E, r8);
                return;
            }
            return;
        }
        BestViewer.doBestView(this.f24930c, false, (LatLng) null, this.f24941n.getBestViewPoints(), this.f24913E, (Padding) null, r8);
    }

    public void updateDepartureLocation(final DepartureLocationInfo departureLocationInfo, final boolean z) {
        if (this.f24933f && m17772b(departureLocationInfo)) {
            m17753a("updateDepartureLocation=" + departureLocationInfo);
            DepartureOmegaUtils.OmegaParams.scrollType = 1;
            C939611 r7 = new BestViewer.IBestViewListener() {
                public void onFinished() {
                    CanoeDepartureView.this.m17753a("updateDepartureLocation onFinished");
                    CanoeDepartureView.this.f24909A.set(false);
                    if (CanoeDepartureView.this.m17831z()) {
                        LatLng center = CanoeDepartureView.this.f24941n.getCenter();
                        if (!(CanoeDepartureView.this.f24945r == null || CanoeDepartureView.this.f24945r.latLng == null || CanoeDepartureView.this.f24941n.getCircle() == null || !CanoeDepartureView.this.f24941n.getCircle().contains(CanoeDepartureView.this.f24945r.latLng))) {
                            center = CanoeDepartureView.this.f24945r.latLng;
                        }
                        CanoeDepartureView.this.m17782d(center);
                        departureLocationInfo.latLng = center;
                    } else {
                        departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f24930c);
                    }
                    int i = 1;
                    if (CanoeDepartureView.this.f24926R && CanoeDepartureView.this.f24951x != null) {
                        LatLng latLng = departureLocationInfo.latLng;
                        FenceInfo fenceInfo = CanoeDepartureView.this.f24951x.startFenceInfo;
                        if (FenceUtils.isFenceMustAbsorb(fenceInfo)) {
                            if (!FenceUtils.positionIsInFence(CanoeDepartureView.this.f24930c, fenceInfo, latLng)) {
                                boolean unused = CanoeDepartureView.this.f24926R = false;
                            } else {
                                return;
                            }
                        }
                    } else if (CanoeDepartureView.this.m17768b(departureLocationInfo.latLng)) {
                        RpcPoi unused2 = CanoeDepartureView.this.f24946s = DepartureUtils.findTargetRecommend(departureLocationInfo.latLng, CanoeDepartureView.this.f24947t);
                        if (CanoeDepartureView.this.f24946s != null) {
                            CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                            canoeDepartureView.m17751a(canoeDepartureView.f24946s, (LatLng) null, true, true);
                            CanoeDepartureView canoeDepartureView2 = CanoeDepartureView.this;
                            CanoeDepartureView.this.m17764b(canoeDepartureView2.m17729a(canoeDepartureView2.f24946s));
                            return;
                        }
                    }
                    CanoeDepartureView canoeDepartureView3 = CanoeDepartureView.this;
                    DepartureLocationInfo departureLocationInfo = departureLocationInfo;
                    if (z) {
                        i = canoeDepartureView3.f24953z;
                    }
                    canoeDepartureView3.m17747a(departureLocationInfo, i);
                }
            };
            if (!z || !this.f24909A.get()) {
                this.f24909A.set(true);
                ZoneCircleController zoneCircleController = this.f24941n;
                if (zoneCircleController != null && !CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
                    m17753a("mZoneCircleCtr bestview");
                    BestViewer.doBestView(this.f24930c, true, (LatLng) null, this.f24941n.getBestViewPoints(), this.f24913E, (Padding) null, r7);
                } else if (this.f24939l != null) {
                    m17753a("mCarpoolController bestview");
                    BestViewer.doBestView(this.f24930c, true, (LatLng) null, this.f24939l.getBestViewPoints(departureLocationInfo.latLng), this.f24913E, (Padding) null, r7);
                } else {
                    float zoom = this.f24929b.getZoom();
                    m17753a("正常 BestView");
                    PinActionUtils.animateCamera(this.f24930c, departureLocationInfo.latLng, true, true, zoom, this.f24913E, r7);
                }
                DeparturePresenter departurePresenter = this.f24942o;
                if (departurePresenter != null) {
                    departurePresenter.stopRequest();
                }
            }
        }
    }

    /* renamed from: w */
    private Padding m17824w() {
        int i = this.f24915G;
        return new Padding(i, i, i, i);
    }

    /* renamed from: a */
    private boolean m17756a(LatLng latLng, LatLng latLng2) {
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        if (computeDistanceBetween < 30.0d) {
            return false;
        }
        m17753a("checkDistance : " + computeDistanceBetween);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m17827x() {
        if (this.f24929b.isPinVisible() && this.f24929b.isRequireByDrag()) {
            if (this.f24932e != null && !this.f24944q) {
                m17753a("onStartDragging");
                this.f24932e.onStartDragging();
            }
            int y = m17828y();
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f24932e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onDragging(y);
            }
            m17733a(y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public int m17828y() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f24930c);
        FenceController fenceController = this.f24935h;
        int isInFence = fenceController != null ? fenceController.isInFence(mapCenterPoint) : 2;
        ZoneCircleController zoneCircleController = this.f24941n;
        if (zoneCircleController == null || zoneCircleController.allowDragToOuter()) {
            return isInFence;
        }
        if (this.f24941n.handleMapDrag(mapCenterPoint)) {
            return 1;
        }
        return 2;
    }

    /* renamed from: a */
    private void m17733a(int i) {
        DepartureCompParams departureCompParams = this.f24929b;
        if (departureCompParams != null && this.f24934g != null) {
            if (!departureCompParams.isBubbleVisible()) {
                this.f24934g.startDragging_Ex();
            } else if (i == 1 || i == 3) {
                this.f24934g.toNoParking();
            } else {
                this.f24934g.startDragging();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m17831z() {
        ZoneCircleController zoneCircleController = this.f24941n;
        return zoneCircleController != null && !zoneCircleController.allowDragToOuter() && this.f24941n.isOutside();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17753a(String str) {
        DLog.m7384d("DepartureView", str, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17750a(DIDILocation dIDILocation) {
        if (this.f24933f && dIDILocation != null && this.f24945r != null) {
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (!LatLngUtils.locateCorrect(latLng)) {
                DLog.m7384d("departure", "onReceiveLocationUpdate error " + latLng.toString(), new Object[0]);
                return;
            }
            GuideLine guideLine = this.f24937j;
            if (guideLine != null) {
                guideLine.updateStartPosition(latLng);
            }
            this.f24940m.setLocationAccuracy(dIDILocation.getAccuracy());
            if (this.f24953z == 0 && this.f24941n == null && this.f24939l == null && this.f24910B) {
                DIDILocation dIDILocation2 = this.f24952y;
                if (dIDILocation2 == null) {
                    DLog.m7384d("departure", "onReceiveLocationUpdate 首次定位成功 " + latLng.toString(), new Object[0]);
                } else if (!m17756a(new LatLng(dIDILocation2.getLatitude(), this.f24952y.getLongitude()), latLng)) {
                    m17753a("onReceiveLocationUpdate : return");
                    return;
                }
                this.f24945r.latLng = latLng;
                this.f24952y = dIDILocation;
                if (CallFrom.CANOE_DEPARTURE_FROMHOME == this.f24929b.getReqCallerId()) {
                    m17747a(this.f24945r, this.f24953z);
                } else {
                    updateDepartureLocation(this.f24945r, true);
                }
            }
            DepartureInterceptController departureInterceptController = this.f24916H;
            if (departureInterceptController != null) {
                departureInterceptController.upDateCurrentLocation(dIDILocation);
            }
        }
    }

    /* renamed from: A */
    private void m17722A() {
        this.f24940m.reportOmegaOnShowTerminalWelcome(this.f24938k, DepartureUtils.getFenceInfo(this.f24951x), this.f24953z == 0);
    }

    public void stop() {
        m17776c();
        m17793g();
        m17799j();
        m17823v();
        CarpoolDepartureController carpoolDepartureController = this.f24939l;
        if (carpoolDepartureController != null) {
            carpoolDepartureController.removeCircle(false);
        }
    }

    public void destroy() {
        stop();
        m17800k();
        m17797i();
        GuideLine guideLine = this.f24937j;
        if (guideLine != null) {
            guideLine.destroy();
            this.f24937j = null;
        }
        Map map = this.f24930c;
        if (map != null) {
            map.stopAnimation();
        }
        DeparturePresenter departurePresenter = this.f24942o;
        if (departurePresenter != null) {
            departurePresenter.destroy();
            this.f24942o = null;
        }
        this.f24926R = false;
        DepartureOmegaUtils.hasDragged = false;
        DepartureOmegaUtils.OmegaParams.scrollType = -1;
        Handler handler = this.f24912D;
        if (handler != null) {
            handler.removeCallbacks(this.f24914F);
            this.f24912D.removeCallbacksAndMessages((Object) null);
            this.f24912D = null;
        }
        this.f24938k = null;
    }

    public void addOrderInterceptListener(final DepartureInterceptController.IInterceptListener iInterceptListener) {
        DepartureInterceptController departureInterceptController = this.f24916H;
        if (departureInterceptController != null) {
            departureInterceptController.addInterceptListener(new DepartureInterceptController.IInterceptListener() {
                public void onIntercept(OrderInterceptMode orderInterceptMode, boolean z) {
                    String E = CanoeDepartureView.this.f24928a;
                    DLog.m7384d(E, "getInterceptStatus : onIntercept model=" + orderInterceptMode + ",newPoi=" + z, new Object[0]);
                    DepartureDataStore.getInstance().saveInterceptTime();
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onIntercept(orderInterceptMode, z);
                    }
                }

                public void onContinue() {
                    DLog.m7384d(CanoeDepartureView.this.f24928a, "getInterceptStatus : onContinue", new Object[0]);
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onContinue();
                    }
                }

                public void onStart() {
                    DLog.m7384d(CanoeDepartureView.this.f24928a, "getInterceptStatus : onStart", new Object[0]);
                    CanoeDepartureView.this.f24945r.latLng = CanoeDepartureView.this.m17821u();
                    CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                    canoeDepartureView.m17747a(canoeDepartureView.f24945r, CanoeDepartureView.this.f24953z);
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
        DepartureLocationInfo a = m17730a(departureLocationInfo);
        this.f24945r = a;
        FenceController fenceController = this.f24935h;
        if (fenceController != null && a != null && (map = this.f24930c) != null) {
            if (FenceUtils.positionIsInFence(map, fenceController.getFenceInfo(), this.f24945r.latLng)) {
                m17787e(this.f24945r.latLng);
            } else {
                m17747a(this.f24945r, this.f24953z);
            }
        }
    }
}
