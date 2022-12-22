package com.didi.map.global.flow.scene.order.confirm.normal;

import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.CircleTip;
import com.didi.map.global.component.CircleTipParam;
import com.didi.map.global.component.ICircleTipComponent;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.view.LoadingInfoWindow;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.component.slideCars.ISlideCarsCompContract;
import com.didi.map.global.component.slideCars.SlideCarsCompParams;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ClientConfigParam;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.impl.MultiSlideCarsCompImpl;
import com.didi.map.global.component.slideCars.model.IDriverChangeListener;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.pre.MiniBusOrderBubbleSceneController;
import com.didi.map.global.flow.scene.order.confirm.BubbleContentParam;
import com.didi.map.global.flow.scene.order.confirm.MapElementStatus;
import com.didi.map.global.flow.scene.order.confirm.RoutePlanParam;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import com.didi.map.global.flow.scene.order.confirm.normal.line.BubbleLineParam;
import com.didi.map.global.flow.scene.order.confirm.normal.line.BubblePageCache;
import com.didi.map.global.flow.scene.order.confirm.normal.line.RouteLineManage;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.CacheKey;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@IScene.Scene(mo74615id = 1002)
public class NewOrderConfirmScene extends PageScene<OrderConfirmSceneParam> implements IOrderConfirmController {
    public static final String TAG = "OrderConfirmScene";

    /* renamed from: a */
    private ICircleTipComponent f26638a;

    /* renamed from: b */
    private LoadingInfoWindow f26639b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IDepartureCompContract f26640c;

    /* renamed from: d */
    private IMarkersCompContract f26641d;

    /* renamed from: e */
    private ISlideCarsCompContract f26642e;

    /* renamed from: f */
    private boolean f26643f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RouteLineManage f26644g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AtomicBoolean f26645h = new AtomicBoolean(false);

    /* renamed from: i */
    private String f26646i = "";

    /* renamed from: j */
    private MiniBusOrderBubbleSceneController f26647j;

    /* renamed from: k */
    private LineMode f26648k;

    /* renamed from: l */
    private LatLng f26649l;

    /* renamed from: m */
    private boolean f26650m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f26651n = true;

    /* renamed from: o */
    private boolean f26652o = false;

    /* renamed from: p */
    private final OnElementShowCallback f26653p = new OnElementShowCallback() {
        public void onBubbleShowSuccess() {
            if (NewOrderConfirmScene.this.f26645h != null && !NewOrderConfirmScene.this.f26645h.get()) {
                NewOrderConfirmScene newOrderConfirmScene = NewOrderConfirmScene.this;
                newOrderConfirmScene.doBestView(newOrderConfirmScene.mPadding);
            }
        }

        public void onLineShowSuccess() {
            if (!NewOrderConfirmScene.this.f26651n && NewOrderConfirmScene.this.f26644g != null) {
                NewOrderConfirmScene.this.f26644g.setLineVisible(false);
            }
            if (NewOrderConfirmScene.this.f26645h != null && !NewOrderConfirmScene.this.f26645h.get()) {
                NewOrderConfirmScene newOrderConfirmScene = NewOrderConfirmScene.this;
                newOrderConfirmScene.doBestView(newOrderConfirmScene.mPadding);
                if (NewOrderConfirmScene.this.getAppFluentOmega() != null) {
                    NewOrderConfirmScene.this.getAppFluentOmega().stopCalculateTime(NewOrderConfirmScene.this.getContext(), NewOrderConfirmScene.this.getMap(), 6, (HashMap<String, Object>) null);
                }
            }
        }

        public void onBubbleAvoidSuccess() {
            if (NewOrderConfirmScene.this.f26645h != null && !NewOrderConfirmScene.this.f26645h.get()) {
                NewOrderConfirmScene newOrderConfirmScene = NewOrderConfirmScene.this;
                newOrderConfirmScene.doBestView(newOrderConfirmScene.mPadding);
            }
        }
    };

    public NewOrderConfirmScene(OrderConfirmSceneParam orderConfirmSceneParam, MapViewHolder mapViewHolder) {
        super(orderConfirmSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().startCalculateTime(6, 1);
        }
        PaxEnvironment.getInstance().setCache(CacheKey.CLICK_POSITION, (Object) null);
        this.f26643f = MapFlowApolloUtils.isShowCarInBubblePage();
        if (this.mParam != null) {
            if (((OrderConfirmSceneParam) this.mParam).getStartAddress() != null) {
                this.f26649l = new LatLng(((OrderConfirmSceneParam) this.mParam).getStartAddress().getLatitude(), ((OrderConfirmSceneParam) this.mParam).getStartAddress().getLongitude());
            }
            m18857a(((OrderConfirmSceneParam) this.mParam).getMarkerParams());
            m18855a(((OrderConfirmSceneParam) this.mParam).getStartAddress(), ((OrderConfirmSceneParam) this.mParam).getEndAddress(), ((OrderConfirmSceneParam) this.mParam).isGuessDestination() ? CallFrom.BUBBLEPAGE_REC_START : CallFrom.GLOBAL_BUBBLEPAGE_STATION);
        }
    }

    public void doBestView(Padding padding) {
        Padding padding2;
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null && getContext() != null) {
            MiniBusOrderBubbleSceneController miniBusOrderBubbleSceneController = this.f26647j;
            if (miniBusOrderBubbleSceneController == null || !miniBusOrderBubbleSceneController.doBestView(padding)) {
                ArrayList arrayList = new ArrayList();
                int dp2px = DisplayUtils.dp2px(getContext(), 10.0f);
                ICircleTipComponent iCircleTipComponent = this.f26638a;
                if (iCircleTipComponent == null) {
                    hideResetView();
                    IMarkersCompContract iMarkersCompContract = this.f26641d;
                    if (iMarkersCompContract != null && !CollectionUtil.isEmpty((Collection<?>) iMarkersCompContract.getMarkers())) {
                        arrayList.addAll(this.f26641d.getMarkers());
                    }
                    padding2 = new Padding(dp2px, dp2px, dp2px, dp2px);
                } else {
                    if (!CollectionUtil.isEmpty((Collection<?>) iCircleTipComponent.getBestViewElements())) {
                        arrayList.addAll(this.f26638a.getBestViewElements());
                    }
                    IMarkersCompContract iMarkersCompContract2 = this.f26641d;
                    if (iMarkersCompContract2 != null) {
                        if (this.f26650m) {
                            arrayList.addAll(iMarkersCompContract2.getMarkers(MapElementId.ID_MARKER_START.name()));
                            arrayList.addAll(this.f26641d.getMarkers(MapElementId.ID_MARKER_END.name()));
                        } else {
                            arrayList.addAll(iMarkersCompContract2.getMarkers(MapElementId.ID_MARKER_START.name()));
                        }
                    }
                    padding2 = new Padding(dp2px, 0, dp2px, DisplayUtils.dp2px(getContext(), 4.0f));
                }
                Padding padding3 = padding2;
                RouteLineManage routeLineManage = this.f26644g;
                if (routeLineManage != null && !CollectionUtil.isEmpty((Collection<?>) routeLineManage.getBestViewElements())) {
                    arrayList.addAll(this.f26644g.getBestViewElements());
                }
                LoadingInfoWindow loadingInfoWindow = this.f26639b;
                if (!(loadingInfoWindow == null || this.f26641d == null)) {
                    loadingInfoWindow.setPadding(padding);
                    if (!(this.mParam == null || ((OrderConfirmSceneParam) this.mParam).getCollideRectCallback() == null || CollectionUtil.isEmpty((Collection<?>) ((OrderConfirmSceneParam) this.mParam).getCollideRectCallback().getCollideAvoidRect()))) {
                        this.f26639b.setCollideRectCallback(((OrderConfirmSceneParam) this.mParam).getCollideRectCallback());
                    }
                    Marker labelMarkerById = this.f26641d.getLabelMarkerById(MapElementId.ID_MARKER_START.name());
                    if (labelMarkerById != null) {
                        arrayList.remove(labelMarkerById);
                    }
                }
                BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, padding3, (BestViewer.IBestViewListener) null);
            }
        }
    }

    public void leave() {
        super.leave();
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().removeOmega(1, 6);
        }
        IMarkersCompContract iMarkersCompContract = this.f26641d;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f26641d = null;
        }
        RouteLineManage routeLineManage = this.f26644g;
        if (routeLineManage != null) {
            routeLineManage.destroy();
            this.f26644g = null;
        }
        IDepartureCompContract iDepartureCompContract = this.f26640c;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f26640c = null;
        }
        AtomicBoolean atomicBoolean = this.f26645h;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
            this.f26645h = null;
        }
        markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.DESTROY, (BubbleContentParam) null);
        m18852a(MapElementStatus.DESTROY, (MiniBusParamInterface) null);
        slidingCarHandler(MapElementStatus.DESTROY, (CarSlidingParam) null);
        m18851a(MapElementStatus.DESTROY, (View) null, (CircleParam) null);
    }

    public void onResume() {
        ISlideCarsCompContract iSlideCarsCompContract;
        if (this.isSceneValid && (iSlideCarsCompContract = this.f26642e) != null) {
            iSlideCarsCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        ISlideCarsCompContract iSlideCarsCompContract;
        if (this.isSceneValid && (iSlideCarsCompContract = this.f26642e) != null) {
            iSlideCarsCompContract.onMapVisible(false);
        }
    }

    /* renamed from: a */
    private void m18857a(List<CommonMarkerParam> list) {
        MarkerModel a;
        if (getMap() != null && getContext() != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            ArrayList arrayList = new ArrayList();
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                for (CommonMarkerParam next : list) {
                    if (!(next == null || (a = m18847a(next)) == null)) {
                        arrayList.add(a);
                    }
                }
            }
            this.f26641d = new MarkersComponent();
            this.f26641d.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26641d.create(getContext(), getMap());
        }
    }

    /* renamed from: a */
    private MarkerModel m18847a(CommonMarkerParam commonMarkerParam) {
        if (commonMarkerParam == null || commonMarkerParam.getId() == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        switch (C96694.$SwitchMap$com$didi$map$global$flow$scene$param$MapElementId[commonMarkerParam.getId().ordinal()]) {
            case 1:
                markerModel.setZOrder(102);
                break;
            case 2:
                markerModel.setZOrder(100);
                break;
            case 3:
                markerModel.setZOrder(90);
                break;
            case 4:
                markerModel.setZOrder(91);
                break;
            case 5:
                markerModel.setZOrder(92);
                break;
            case 6:
                markerModel.setZOrder(93);
                break;
        }
        markerModel.setId(commonMarkerParam.getId().name());
        markerModel.setPoint(commonMarkerParam.getPoint());
        markerModel.setAnchorU(commonMarkerParam.getAnchorU());
        markerModel.setAnchorV(commonMarkerParam.getAnchorV());
        markerModel.setMarkerIcon(commonMarkerParam.getMarkerIcon());
        return markerModel;
    }

    /* renamed from: a */
    private void m18856a(String str) {
        if (getContext() != null && getMap() != null && this.f26641d != null) {
            LoadingInfoWindow loadingInfoWindow = new LoadingInfoWindow(getContext(), this.f26641d, str, this.mMapView.getMapView());
            this.f26639b = loadingInfoWindow;
            loadingInfoWindow.setInfoWindowZIndex(110);
        }
    }

    /* renamed from: a */
    private void m18850a(CarSlidingParam carSlidingParam) {
        if (this.mParam != null && ((OrderConfirmSceneParam) this.mParam).getStartAddress() != null && getMap() != null && getContext() != null && LatLngUtils.locateCorrect(this.f26649l) && carSlidingParam != null) {
            this.f26642e = new MultiSlideCarsCompImpl();
            SlideCarsCompParams slideCarsCompParams = new SlideCarsCompParams();
            slideCarsCompParams.setCarSlidingRequestParam(m18860b(carSlidingParam));
            slideCarsCompParams.setBitmapGetter(carSlidingParam.getBitmap());
            slideCarsCompParams.setPullIntervalMs(10000);
            slideCarsCompParams.setShowSlidingCar(this.f26643f);
            this.f26642e.setConfigParam(slideCarsCompParams);
            this.f26642e.setListener(new IDriverChangeListener() {
                public void onGetResultSuccess(NearCarDriver nearCarDriver) {
                    if (nearCarDriver != null && NewOrderConfirmScene.this.getContext() != null && NewOrderConfirmScene.this.f26651n) {
                        if (nearCarDriver.eta > 0) {
                            BubbleContentParam bubbleContentParam = new BubbleContentParam();
                            try {
                                String string = NewOrderConfirmScene.this.getContext().getString(R.string.GRider_eta__dpqd);
                                bubbleContentParam.setContent(String.format(string, new Object[]{nearCarDriver.eta + " "}));
                                NewOrderConfirmScene.this.markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.SHOW, bubbleContentParam);
                            } catch (Exception unused) {
                                DLog.m7384d("FormatException", "eta format exception", new Object[0]);
                            }
                        } else {
                            NewOrderConfirmScene.this.markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
                        }
                        if (NewOrderConfirmScene.this.getAppFluentOmega() != null) {
                            NewOrderConfirmScene.this.getAppFluentOmega().stopCalculateTime(NewOrderConfirmScene.this.getContext(), NewOrderConfirmScene.this.getMap(), 1, (HashMap<String, Object>) null);
                        }
                        if (NewOrderConfirmScene.this.mParam != null && ((OrderConfirmSceneParam) NewOrderConfirmScene.this.mParam).getSlidingSuccessRunnable() != null) {
                            ((OrderConfirmSceneParam) NewOrderConfirmScene.this.mParam).getSlidingSuccessRunnable().run();
                        }
                    }
                }

                public void onGetResultError(String str) {
                    NewOrderConfirmScene.this.markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
                }
            });
            this.f26642e.create(getContext(), getMap());
            this.f26642e.start();
        }
    }

    /* renamed from: b */
    private CarNavigatorRequest m18860b(CarSlidingParam carSlidingParam) {
        String str;
        DIDILocation lastKnownLocation;
        if (!(LatLngUtils.locateCorrect(this.f26649l) || getContext() == null || (lastKnownLocation = LocationHelper.getLastKnownLocation(getContext())) == null)) {
            this.f26649l = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        }
        String str2 = null;
        if (carSlidingParam == null) {
            return null;
        }
        boolean z = true;
        boolean z2 = getMap() != null;
        if (getMap().getMapVendor() == null) {
            z = false;
        }
        if (z2 && z) {
            str2 = getMap().getMapVendor().toString();
        }
        if (this.f26652o) {
            str = "29999";
        } else {
            str = PaxEnvironment.getInstance().getProductId();
        }
        String str3 = str;
        if (str2 == null) {
            str2 = "gmap";
        }
        CarNavigatorRequest carNavigatorRequest = new CarNavigatorRequest(str3, str2, new ClientConfigParam(LocaleCodeHolder.getInstance().getCurrentLang(), "wgs84", carSlidingParam.getIdfa(), carSlidingParam.getOriginId(), carSlidingParam.getMixFlag(), carSlidingParam.getA3Token()), this.f26649l, carSlidingParam.getType(), carSlidingParam.getOrderState());
        carNavigatorRequest.setPid(carSlidingParam.getPid());
        carNavigatorRequest.setCarLevel(carSlidingParam.getCarLevel());
        carNavigatorRequest.setType(carSlidingParam.getType());
        carNavigatorRequest.setOrderState(carSlidingParam.getOrderState());
        if (carSlidingParam.getEndLatLng() != null) {
            carNavigatorRequest.setEndPosition(carSlidingParam.getEndLatLng());
        }
        if (carSlidingParam.getXtags() != null) {
            carNavigatorRequest.setXtags(carSlidingParam.getXtags());
        }
        if (carSlidingParam.getExtra() != null) {
            carNavigatorRequest.setExtra(carSlidingParam.getExtra());
        }
        if (carSlidingParam.getBubbleId() != null) {
            carNavigatorRequest.setBubbleId(carSlidingParam.getBubbleId());
        }
        if (carSlidingParam.getOrderTab() != 0) {
            carNavigatorRequest.setOrderTab(carSlidingParam.getOrderTab());
        }
        if (!CollectionUtil.isEmpty((Collection<?>) carSlidingParam.getAnyCarInfo())) {
            carNavigatorRequest.setAnyCarInfo(carSlidingParam.getAnyCarInfo());
        }
        if (carSlidingParam.getAnyCarPriority() != -1) {
            carNavigatorRequest.setIsAnyCarIntl(carSlidingParam.getIsAnyCarIntl());
        }
        if (carSlidingParam.getAnyCarPriority() != -1) {
            carNavigatorRequest.setAnyCarPriority(carSlidingParam.getAnyCarPriority());
        }
        return carNavigatorRequest;
    }

    /* renamed from: com.didi.map.global.flow.scene.order.confirm.normal.NewOrderConfirmScene$4 */
    static /* synthetic */ class C96694 {

        /* renamed from: $SwitchMap$com$didi$map$global$flow$scene$order$confirm$MapElementStatus */
        static final /* synthetic */ int[] f26654xc1baabd8;
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        static {
            /*
                com.didi.map.global.flow.scene.order.confirm.MapElementStatus[] r0 = com.didi.map.global.flow.scene.order.confirm.MapElementStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26654xc1baabd8 = r0
                r1 = 1
                com.didi.map.global.flow.scene.order.confirm.MapElementStatus r2 = com.didi.map.global.flow.scene.order.confirm.MapElementStatus.SHOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f26654xc1baabd8     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.scene.order.confirm.MapElementStatus r3 = com.didi.map.global.flow.scene.order.confirm.MapElementStatus.DESTROY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f26654xc1baabd8     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.flow.scene.order.confirm.MapElementStatus r4 = com.didi.map.global.flow.scene.order.confirm.MapElementStatus.HIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f26654xc1baabd8     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.flow.scene.order.confirm.MapElementStatus r5 = com.didi.map.global.flow.scene.order.confirm.MapElementStatus.UPDATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.didi.map.global.flow.scene.param.MapElementId[] r4 = com.didi.map.global.flow.scene.param.MapElementId.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId = r4
                com.didi.map.global.flow.scene.param.MapElementId r5 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x004e }
                com.didi.map.global.flow.scene.param.MapElementId r4 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_END     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_1     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x006d }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_2     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_3     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.confirm.normal.NewOrderConfirmScene.C96694.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m18851a(MapElementStatus mapElementStatus, View view, CircleParam circleParam) {
        ICircleTipComponent iCircleTipComponent;
        int i = C96694.f26654xc1baabd8[mapElementStatus.ordinal()];
        if (i != 1) {
            if (i == 2 && (iCircleTipComponent = this.f26638a) != null) {
                iCircleTipComponent.destroy();
                this.f26638a = null;
            }
        } else if (getMap() != null && getContext() != null && circleParam != null && LatLngUtils.locateCorrect(this.f26649l)) {
            CircleTipParam circleTipParam = new CircleTipParam();
            circleTipParam.mCenter = this.f26649l;
            circleTipParam.fillColor = circleParam.getFillColor();
            circleTipParam.strokeColor = circleParam.getStrokeColor();
            circleTipParam.strokeWidthInPixel = circleParam.getStrokeWidthInPixel();
            circleTipParam.radiusInMeters = circleParam.getRadiusInMeters();
            if (view != null) {
                circleTipParam.mViewTip = view;
            }
            circleTipParam.isUsingZIndex = true;
            circleTipParam.zIndex = 103;
            ICircleTipComponent iCircleTipComponent2 = this.f26638a;
            if (iCircleTipComponent2 != null) {
                iCircleTipComponent2.destroy();
            }
            CircleTip circleTip = new CircleTip();
            this.f26638a = circleTip;
            circleTip.setConfigParam(circleTipParam);
            this.f26638a.create(getContext(), getMap());
        }
    }

    /* renamed from: a */
    private void m18855a(Address address, Address address2, CallFrom callFrom) {
        if (getMap() != null && getContext() != null && address != null) {
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            this.f26640c = new DepartureComponent();
            DepartureLocationInfo departureLocationInfo = new DepartureLocationInfo(latLng, address, "wgs84");
            this.f26640c.setConfigParam(new DepartureCompParams.Builder().departureTime(0).isPinVisible(false).isRecPointVisible(false).isBubbleVisible(false).locationInfo(departureLocationInfo).requireByDrag(false).isFenceVisible(true).zoom(18.0f).callFrom(callFrom).setEndPoint(address2).apiType(ApiType.DEPARTURE_POI_INFO).fenceOptions(new DepartureFenceOptions()).build());
            this.f26640c.create(getContext(), getMap());
            this.f26640c.registerCallback(new IDepartureCompContract.IDepartureComponentCallback() {
                public /* synthetic */ void onBroadOtherMapCallback(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onBroadOtherMapCallback(this, i);
                }

                public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
                }

                public /* synthetic */ void onClickBubble() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBubble(this);
                }

                public /* synthetic */ void onConfirmPickup(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onConfirmPickup(this, departureAddress);
                }

                public /* synthetic */ void onDepartureLoading(LatLng latLng) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDepartureLoading(this, latLng);
                }

                public /* synthetic */ void onDragging(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
                }

                public /* synthetic */ void onFetchAddressFail(LatLng latLng) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onFetchAddressFail(this, latLng);
                }

                public /* synthetic */ void onStartDragging() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartDragging(this);
                }

                public /* synthetic */ void onStartSugPage(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartSugPage(this, departureAddress);
                }

                public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
                }

                public /* synthetic */ void onUp() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    NewOrderConfirmScene newOrderConfirmScene = NewOrderConfirmScene.this;
                    newOrderConfirmScene.doBestView(newOrderConfirmScene.mPadding);
                    if (NewOrderConfirmScene.this.mParam != null && ((OrderConfirmSceneParam) NewOrderConfirmScene.this.mParam).isGuessDestination() && ((OrderConfirmSceneParam) NewOrderConfirmScene.this.mParam).getPinCallback() != null && NewOrderConfirmScene.this.f26640c != null) {
                        ((OrderConfirmSceneParam) NewOrderConfirmScene.this.mParam).getPinCallback().onDepartureAddressChanged(departureAddress);
                    }
                }
            });
            this.f26640c.start();
            this.f26640c.setFenceVisible(false);
        }
    }

    public void markerBubbleHandler(MapElementId mapElementId, MapElementStatus mapElementStatus, BubbleContentParam bubbleContentParam) {
        LoadingInfoWindow loadingInfoWindow;
        int i = C96694.f26654xc1baabd8[mapElementStatus.ordinal()];
        if (i != 1) {
            if (i == 2) {
                LoadingInfoWindow loadingInfoWindow2 = this.f26639b;
                if (loadingInfoWindow2 != null) {
                    loadingInfoWindow2.releaseView();
                    this.f26639b = null;
                    return;
                }
                return;
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
            } else if (this.f26641d != null && (loadingInfoWindow = this.f26639b) != null) {
                loadingInfoWindow.hideInfoWindow();
                return;
            } else {
                return;
            }
        }
        if (this.f26641d != null) {
            LoadingInfoWindow loadingInfoWindow3 = this.f26639b;
            if (loadingInfoWindow3 == null) {
                m18856a(mapElementId.name());
            } else {
                loadingInfoWindow3.showInfoWindow();
            }
            if (bubbleContentParam != null && this.f26639b != null) {
                if (bubbleContentParam.isLoadingToggle()) {
                    LoadingInfoWindow loadingInfoWindow4 = this.f26639b;
                    if (loadingInfoWindow4 != null) {
                        loadingInfoWindow4.showLoadingView();
                    }
                } else if (this.f26639b != null) {
                    if (!TextUtils.isEmpty(bubbleContentParam.getContent())) {
                        this.f26639b.showText(bubbleContentParam.getContent());
                    }
                    if (!TextUtils.isEmpty(bubbleContentParam.getFullTextContent())) {
                        this.f26639b.showText(bubbleContentParam.getFullTextContent());
                    }
                }
            }
        }
    }

    public void slidingCarHandler(MapElementStatus mapElementStatus, CarSlidingParam carSlidingParam) {
        ISlideCarsCompContract iSlideCarsCompContract;
        int i = C96694.f26654xc1baabd8[mapElementStatus.ordinal()];
        if (i == 1) {
            ISlideCarsCompContract iSlideCarsCompContract2 = this.f26642e;
            if (iSlideCarsCompContract2 == null) {
                m18850a(carSlidingParam);
            } else {
                iSlideCarsCompContract2.reStart(m18860b(carSlidingParam));
            }
            ISlideCarsCompContract iSlideCarsCompContract3 = this.f26642e;
            if (iSlideCarsCompContract3 != null) {
                iSlideCarsCompContract3.setCarVisible(this.f26643f);
            }
        } else if (i == 2) {
            ISlideCarsCompContract iSlideCarsCompContract4 = this.f26642e;
            if (iSlideCarsCompContract4 != null) {
                iSlideCarsCompContract4.destroy();
                this.f26642e = null;
            }
        } else if (i == 3) {
            ISlideCarsCompContract iSlideCarsCompContract5 = this.f26642e;
            if (iSlideCarsCompContract5 != null) {
                iSlideCarsCompContract5.setCarVisible(false);
            }
        } else if (i == 4 && (iSlideCarsCompContract = this.f26642e) != null) {
            iSlideCarsCompContract.refreshCarIcon();
            this.f26642e.setCarVisible(this.f26643f);
        }
    }

    public void updateCarLevel(CarLevelParam carLevelParam) {
        if (carLevelParam != null && getMap() != null) {
            DLog.m7384d(TAG, "sceneType" + carLevelParam.getSceneType(), new Object[0]);
            int sceneType = carLevelParam.getSceneType();
            boolean z = true;
            if (sceneType == 0) {
                this.f26651n = true;
                this.f26652o = false;
                if (carLevelParam.getMiniBusParamInterface() != null) {
                    this.f26643f = false;
                    DLog.m7384d(TAG, "切换小巴", new Object[0]);
                    m18852a(MapElementStatus.SHOW, carLevelParam.getMiniBusParamInterface());
                } else {
                    this.f26643f = MapFlowApolloUtils.isShowCarInBubblePage();
                    DLog.m7384d(TAG, "切换其他车型", new Object[0]);
                    m18852a(MapElementStatus.DESTROY, (MiniBusParamInterface) null);
                }
                if (carLevelParam.getCarSlidingParam() != null) {
                    DLog.m7384d(TAG, "创建刷新运力", new Object[0]);
                    slidingCarHandler(MapElementStatus.SHOW, carLevelParam.getCarSlidingParam());
                    BubbleContentParam bubbleContentParam = new BubbleContentParam();
                    bubbleContentParam.setLoadingToggle(true);
                    markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.SHOW, bubbleContentParam);
                } else {
                    DLog.m7384d(TAG, "销毁运力", new Object[0]);
                    slidingCarHandler(MapElementStatus.DESTROY, (CarSlidingParam) null);
                    markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
                }
                m18851a(MapElementStatus.DESTROY, (View) null, (CircleParam) null);
                if (carLevelParam.getCircleParam() != null) {
                    m18851a(MapElementStatus.SHOW, carLevelParam.getViewTip(), carLevelParam.getCircleParam());
                    if (carLevelParam.getViewTip() != null) {
                        m18854a(MapElementId.ID_MARKER_END, false);
                        this.f26650m = false;
                        DLog.m7384d(TAG, "拼车非全揽", new Object[0]);
                    } else {
                        this.f26650m = true;
                        m18854a(MapElementId.ID_MARKER_END, true);
                        DLog.m7384d(TAG, "拼车全揽", new Object[0]);
                    }
                } else {
                    m18854a(MapElementId.ID_MARKER_END, true);
                }
                IDepartureCompContract iDepartureCompContract = this.f26640c;
                if (iDepartureCompContract != null) {
                    if (carLevelParam.getCircleParam() != null) {
                        z = false;
                    }
                    iDepartureCompContract.setFenceVisible(z);
                }
                if (carLevelParam.getRoutePlanParam() != null) {
                    m18853a(carLevelParam.getRoutePlanParam(), carLevelParam.getSceneType());
                    return;
                }
                DLog.m7384d(TAG, "路线销毁", new Object[0]);
                RouteLineManage routeLineManage = this.f26644g;
                if (routeLineManage != null) {
                    routeLineManage.destroy();
                }
            } else if (sceneType == 1) {
                DLog.m7384d(TAG, "anycar  updatacarLevel", new Object[0]);
                this.f26651n = true;
                this.f26652o = true;
                boolean isShowCarInBubblePage = MapFlowApolloUtils.isShowCarInBubblePage();
                this.f26643f = isShowCarInBubblePage;
                if (!isShowCarInBubblePage) {
                    DLog.m7384d(TAG, "不显示运力", new Object[0]);
                }
                if (carLevelParam.getCarSlidingParam() != null) {
                    DLog.m7384d(TAG, "slidingParam-->" + carLevelParam.getCarSlidingParam().toString(), new Object[0]);
                    slidingCarHandler(MapElementStatus.SHOW, carLevelParam.getCarSlidingParam());
                    BubbleContentParam bubbleContentParam2 = new BubbleContentParam();
                    bubbleContentParam2.setLoadingToggle(true);
                    markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.SHOW, bubbleContentParam2);
                } else {
                    slidingCarHandler(MapElementStatus.DESTROY, (CarSlidingParam) null);
                    markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
                }
                IDepartureCompContract iDepartureCompContract2 = this.f26640c;
                if (iDepartureCompContract2 != null) {
                    iDepartureCompContract2.setFenceVisible(carLevelParam.getCircleParam() == null);
                }
                if (carLevelParam.getRoutePlanParam() != null) {
                    DLog.m7384d(TAG, "lineParam->" + carLevelParam.getRoutePlanParam().toString(), new Object[0]);
                    m18853a(carLevelParam.getRoutePlanParam(), carLevelParam.getSceneType());
                    RouteLineManage routeLineManage2 = this.f26644g;
                    if (routeLineManage2 != null) {
                        routeLineManage2.setLineVisible(true);
                        return;
                    }
                    return;
                }
                DLog.m7384d(TAG, "路线销毁", new Object[0]);
                RouteLineManage routeLineManage3 = this.f26644g;
                if (routeLineManage3 != null) {
                    routeLineManage3.destroy();
                }
            } else if (sceneType == 2) {
                DLog.m7384d(TAG, "anycar no select car", new Object[0]);
                this.f26651n = false;
                RouteLineManage routeLineManage4 = this.f26644g;
                if (routeLineManage4 != null) {
                    routeLineManage4.setLineVisible(false);
                }
                slidingCarHandler(MapElementStatus.DESTROY, (CarSlidingParam) null);
                markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
            }
        }
    }

    /* renamed from: a */
    private void m18852a(MapElementStatus mapElementStatus, MiniBusParamInterface miniBusParamInterface) {
        if (miniBusParamInterface == null) {
            mapElementStatus = MapElementStatus.DESTROY;
        }
        int i = C96694.f26654xc1baabd8[mapElementStatus.ordinal()];
        if (i == 1) {
            MiniBusOrderBubbleSceneController miniBusOrderBubbleSceneController = this.f26647j;
            if (miniBusOrderBubbleSceneController != null) {
                miniBusOrderBubbleSceneController.onDestroy();
                this.f26647j = null;
            }
            this.f26647j = new MiniBusOrderBubbleSceneController(getContext(), getMap());
            m18858a(false);
            this.f26647j.onChangeMiniBusCar(miniBusParamInterface);
        } else if (i == 2) {
            MiniBusOrderBubbleSceneController miniBusOrderBubbleSceneController2 = this.f26647j;
            if (miniBusOrderBubbleSceneController2 != null) {
                miniBusOrderBubbleSceneController2.onDestroy();
                this.f26647j = null;
            }
            m18858a(true);
        }
    }

    /* renamed from: a */
    private void m18858a(boolean z) {
        if (this.mParam != null) {
            List<CommonMarkerParam> markerParams = ((OrderConfirmSceneParam) this.mParam).getMarkerParams();
            if (!CollectionUtil.isEmpty((Collection<?>) markerParams)) {
                for (CommonMarkerParam next : markerParams) {
                    if (!(next == null || this.f26641d == null || next.getId() == null)) {
                        this.f26641d.setMarkerVisible(next.getId().toString(), z);
                        this.f26641d.setLabelVisible(next.getId().toString(), z);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m18854a(MapElementId mapElementId, boolean z) {
        IMarkersCompContract iMarkersCompContract;
        if (this.mParam != null && (iMarkersCompContract = this.f26641d) != null) {
            iMarkersCompContract.setMarkerVisible(mapElementId.name(), z);
            this.f26641d.setLabelVisible(mapElementId.name(), z);
        }
    }

    public long getDefaultRouteId() {
        RouteLineManage routeLineManage = this.f26644g;
        long defaultRouteId = routeLineManage != null ? routeLineManage.getDefaultRouteId() : 0;
        DLog.m7384d("BubblePage", "getDefaultRouteId: " + defaultRouteId, new Object[0]);
        return defaultRouteId;
    }

    public long getSelectedRouteId() {
        RouteLineManage routeLineManage = this.f26644g;
        long selectedRouteId = routeLineManage != null ? routeLineManage.getSelectedRouteId() : 0;
        DLog.m7384d("BubblePage", "getSelectedRouteId: " + selectedRouteId, new Object[0]);
        return selectedRouteId;
    }

    /* renamed from: a */
    private void m18853a(RoutePlanParam routePlanParam, int i) {
        String str;
        int i2 = i;
        String productId = PaxEnvironment.getInstance().getProductId();
        boolean z = false;
        DLog.m7384d("BubblePage", "productId:" + productId, new Object[0]);
        if (TextUtils.isEmpty(productId) || routePlanParam == null || routePlanParam.getLineParam() == null) {
            DLog.m7384d(TAG, "数据错误，不显示路线", new Object[0]);
            RouteLineManage routeLineManage = this.f26644g;
            if (routeLineManage != null) {
                routeLineManage.setLineMode(true, m18848a((CommonLineParam) null, LineMode.MODE_NONE, "", i2));
                return;
            }
            return;
        }
        LineMode lineMode = routePlanParam.getLineMode();
        String bubbleId = routePlanParam.getBubbleId();
        CommonLineParam lineParam = routePlanParam.getLineParam();
        EpfOrderType orderType = routePlanParam.getOrderType();
        DLog.m7384d("BubblePage", "lineMode:" + lineMode + "last line mode:" + this.f26648k + ",bubbleId:" + bubbleId, new Object[0]);
        if (this.f26644g == null) {
            DLog.m7384d(TAG, "创建路线组件", new Object[0]);
            this.f26644g = new RouteLineManage(getContext(), getMap());
            BubblePageCache.getInstance().readApollo();
        }
        if (this.mParam != null) {
            this.f26644g.setLineSelectedListener(((OrderConfirmSceneParam) this.mParam).getLineSelectedListener());
        }
        this.f26644g.setOnElementShowCallback(this.f26653p);
        this.f26644g.setEpfOrderType(orderType);
        if (!this.f26646i.equals(productId) || !this.f26644g.hasLine() || this.f26648k != lineMode) {
            String str2 = bubbleId;
            this.f26648k = lineMode;
            this.f26646i = productId;
            if (!CollectionUtil.isEmpty((Collection<?>) lineParam.getWayPoints())) {
                DLog.m7384d(TAG, "有途经点--routePlan", new Object[0]);
                this.f26644g.setLineMode(true, m18848a(lineParam, LineMode.MODE_SINGLE_ROUTE, str2, i2));
                return;
            }
            DLog.m7384d(TAG, "无途经点--bubblePage", new Object[0]);
            List<String> multiLineSupportProductIds = MapFlowApolloUtils.getMultiLineSupportProductIds();
            if (CollectionUtil.isEmpty((Collection<?>) multiLineSupportProductIds)) {
                if (LineMode.MODE_MULTI_ROUTE == lineMode) {
                    lineMode = LineMode.MODE_SINGLE_ROUTE;
                }
                this.f26644g.setLineMode(true, m18848a(lineParam, lineMode, str2, i2));
                return;
            }
            this.f26644g.setMarkersCollide(m18849a());
            if (i2 == 1) {
                this.f26644g.setLineMode(true, m18848a(lineParam, lineMode, str2, i2));
            } else if (multiLineSupportProductIds.contains(productId)) {
                this.f26644g.setLineMode(false, m18848a(lineParam, lineMode, str2, i2));
            } else {
                this.f26644g.setLineMode(true, m18848a(lineParam, lineMode, str2, i2));
            }
        } else {
            RouteLineManage routeLineManage2 = this.f26644g;
            if (routeLineManage2 != null && routeLineManage2.hasMultiLine()) {
                long defaultRouteId = this.f26644g.getDefaultRouteId();
                long selectedRouteId = this.f26644g.getSelectedRouteId();
                long optionRouteId = this.f26644g.getOptionRouteId();
                if (selectedRouteId != 0) {
                    if (selectedRouteId == defaultRouteId) {
                        z = true;
                    }
                    if (z) {
                        str = this.f26644g.getDefaultBubbleContent();
                    } else {
                        str = this.f26644g.getOptionBubbleContent();
                    }
                    MapFlowOmegaUtil.onOptionLineClick(selectedRouteId, str, defaultRouteId, optionRouteId, bubbleId);
                    MapFlowOmegaUtil.onOptionLineShow(defaultRouteId, this.f26644g.getDefaultBubbleContent(), optionRouteId, this.f26644g.getOptionBubbleContent(), bubbleId);
                }
            }
        }
    }

    /* renamed from: a */
    private BubbleLineParam m18848a(CommonLineParam commonLineParam, LineMode lineMode, String str, int i) {
        Address address;
        Address address2;
        if (this.mParam != null) {
            Address startAddress = ((OrderConfirmSceneParam) this.mParam).getStartAddress();
            address = ((OrderConfirmSceneParam) this.mParam).getEndAddress();
            address2 = startAddress;
        } else {
            address2 = null;
            address = null;
        }
        return new BubbleLineParam(commonLineParam, address2, address, lineMode, str, i == 0 ? 0 : 2);
    }

    /* renamed from: a */
    private List<Marker> m18849a() {
        ArrayList arrayList = new ArrayList();
        IMarkersCompContract iMarkersCompContract = this.f26641d;
        if (iMarkersCompContract != null) {
            arrayList.addAll(iMarkersCompContract.getAllMarkers());
        }
        return arrayList;
    }
}
