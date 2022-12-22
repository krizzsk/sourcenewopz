package com.didiglobal.p205sa.biz.component.mapflow;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.AddressException;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.GlobalSugCallback;
import com.didi.address.model.IWayPointsPostCallback;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.NewAddressApiFactory;
import com.didi.addressnew.framework.IDidiAddressNewApiImpl;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.Padding;
import com.didi.component.core.IGroupView;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.global.IReverseGeoListener;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.scene.mainpage.IMapEventCallBack;
import com.didi.map.global.flow.scene.mainpage.MainPageSceneParam;
import com.didi.map.sdk.env.IBizDataGetter;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.idfa.IDFAManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.base.RouterType;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.mapflow.IconHelper;
import com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.model.AnimationModel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import com.didiglobal.p205sa.biz.estimate.EstimateParams;
import com.didiglobal.p205sa.biz.sender.GlobalSenderName;
import com.didiglobal.p205sa.biz.sender.IAddressData;
import com.didiglobal.p205sa.biz.util.AddressUtil;
import com.didiglobal.p205sa.biz.util.BaseEventKeys;
import com.didiglobal.p205sa.biz.util.CloseSideBarEvent;
import com.didiglobal.p205sa.biz.util.MapRedayEvent;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didiglobal.sa.biz.component.mapflow.MapFlowPresenter */
public class MapFlowPresenter extends ComponentPresenterImpl<MapFlowDelegateView> {

    /* renamed from: a */
    RideCardModel f51020a = null;

    /* renamed from: b */
    double f51021b;

    /* renamed from: c */
    double f51022c;

    /* renamed from: d */
    int f51023d = 1;

    /* renamed from: e */
    IMapEventCallBack f51024e = new IMapEventCallBack() {
        public void onMapStable() {
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            MapFlowPresenter.this.f51021b = cameraPosition.zoom;
        }

        public boolean onDoubleTap(float f, float f2) {
            MapFlowPresenter.this.addTrack(2);
            MapFlowPresenter.this.f51023d = 2;
            return false;
        }

        public boolean onDown(float f, float f2) {
            MapFlowPresenter mapFlowPresenter = MapFlowPresenter.this;
            mapFlowPresenter.f51022c = mapFlowPresenter.f51021b;
            return false;
        }

        public boolean onScroll(float f, float f2) {
            MapFlowPresenter.this.f51023d = 3;
            return false;
        }

        public boolean onUp(float f, float f2) {
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            if (MapFlowPresenter.this.f51021b > MapFlowPresenter.this.f51022c) {
                MapFlowPresenter.this.addTrack(6);
                hashMap.put("entry_3", "6");
            } else if (MapFlowPresenter.this.f51021b < MapFlowPresenter.this.f51022c) {
                MapFlowPresenter.this.addTrack(7);
                hashMap.put("entry_3", "6");
            } else {
                hashMap.put("entry_3", Integer.valueOf(MapFlowPresenter.this.f51023d));
            }
            hashMap.put(ParamKeys.PARAM_COMPLAIN_ENTRY, "sa");
            hashMap.put("entry_2", "map");
            bundle.putSerializable("sa_entry", hashMap);
            MapFlowPresenter.this.f51023d = 1;
            MapFlowPresenter mapFlowPresenter = MapFlowPresenter.this;
            mapFlowPresenter.m36558a("satype " + SaApolloUtil.INSTANCE.getSaType());
            if (SaApolloUtil.INSTANCE.getSaType() != SaApolloUtil.SaType.SA_A || (!PageTouchEventManger.mapInFirstPosition && PageTouchEventManger.showMap)) {
                SaBusinessManager ins = SaBusinessManager.Companion.getIns();
                ins.switchBusiness("ride", NationTypeUtil.getNationComponentData().getProductPreFix() + RouterType.RIDE_ENTRANCE, bundle);
            } else {
                MapFlowPresenter.this.doPublish(BaseEventKeys.SA_Panel.PANEL_EXPAND);
            }
            if (MapFlowPresenter.this.mCarMainPageController != null) {
                MapFlowPresenter.this.mCarMainPageController.leaveSaPage(0);
            }
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Logger f51025f = LoggerFactory.getLogger("dongxt-MapFlowPresenter");

    /* renamed from: g */
    private ComponentParams f51026g;
    protected GlobalSugCallback globalSugCallback = new GlobalSugCallback() {
        public int requestSugWindowFeature() {
            return 2;
        }

        public void setResult(AddressResult addressResult) {
            EstimateParams estimateParams = new EstimateParams();
            if (addressResult != null) {
                Address unused = MapFlowPresenter.this.f51027h = addressResult.start;
                Address unused2 = MapFlowPresenter.this.f51028i = addressResult.end;
            }
            estimateParams.setEndAddress(MapFlowPresenter.this.f51028i);
            estimateParams.setStartAddress(MapFlowPresenter.this.f51027h);
            Bundle bundle = new Bundle();
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            bundle.putString("page_source", "page_sug");
            bundle.putSerializable("estimateParams", estimateParams);
            SaBusinessManager ins = SaBusinessManager.Companion.getIns();
            ins.switchBusiness("ride", NationTypeUtil.getNationComponentData().getProductPreFix() + RouterType.RIDE_ESTIMATE, bundle);
        }

        public void onSugSessionClosed() {
            boolean unused = MapFlowPresenter.this.f51036q = false;
            MapFlowPresenter.this.m36562b();
        }

        public void onCloseButtonClick() {
            MapFlowPresenter.this.goBack();
        }

        public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, IWayPointsPostCallback iWayPointsPostCallback) {
            MapFlowPresenter.this.onSubmitWayPoint(fragmentActivity, list, list2, iWayPointsPostCallback);
            EstimateParams estimateParams = new EstimateParams();
            estimateParams.setEndAddress(MapFlowPresenter.this.f51028i);
            estimateParams.setStartAddress(MapFlowPresenter.this.f51027h);
            estimateParams.setmWayPointAddressList(MapFlowPresenter.this.f51032m);
            Bundle bundle = new Bundle();
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            bundle.putString("page_source", "page_sug");
            bundle.putSerializable("estimateParams", estimateParams);
            SaBusinessManager ins = SaBusinessManager.Companion.getIns();
            ins.switchBusiness("ride", NationTypeUtil.getNationComponentData().getProductPreFix() + RouterType.RIDE_ESTIMATE, bundle);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f51027h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f51028i;

    /* renamed from: j */
    private boolean f51029j = false;

    /* renamed from: k */
    private String f51030k;

    /* renamed from: l */
    private String f51031l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public List<WayPoint> f51032m = new ArrayList();
    protected ICarBitmapDescriptor mCarBitmapDescriptor = new ICarBitmapDescriptor() {
        public BitmapDescriptor getBitmapDescriptor() {
            if (MapFlowPresenter.this.mContext != null) {
                return IconHelper.getInstance().getSmoothDriverIcon(MapFlowPresenter.this.mContext.getApplicationContext(), MapFlowPresenter.this.f51035p, R.drawable.global_mapflow_default_car_icon);
            }
            return null;
        }

        public BitmapDescriptor getDefaultBitmapDescriptor() {
            if (MapFlowPresenter.this.mContext != null) {
                return IconHelper.getInstance().getSmoothDriverIcon(MapFlowPresenter.this.mContext.getApplicationContext(), MapFlowPresenter.this.f51035p, R.drawable.global_mapflow_default_car_icon);
            }
            return null;
        }
    };
    protected ICarMainPageController mCarMainPageController;
    protected Padding mCurrentPadding;
    protected BaseEventPublisher.OnEventListener mHomeBestViewPadding = new BaseEventPublisher.OnEventListener<Padding>() {
        public void onEvent(String str, Padding padding) {
            MapFlowPresenter.this.mCurrentPadding = padding;
            MapFlowPresenter.this.doBestView();
        }
    };
    protected BaseEventPublisher.OnEventListener<RideCardModel> mHomeUpdate = new BaseEventPublisher.OnEventListener<RideCardModel>() {
        public void onEvent(String str, RideCardModel rideCardModel) {
            MapFlowPresenter.this.f51020a = rideCardModel;
            MapFlowPresenter mapFlowPresenter = MapFlowPresenter.this;
            mapFlowPresenter.m36557a(mapFlowPresenter.f51020a);
        }
    };
    protected BaseEventPublisher.OnEventListener<Integer> mShowSugPageListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if ("event_show_new_sug_page".equals(str)) {
                MapFlowPresenter.this.showSugOrRouterPage(num.intValue(), FromType.HOME, MapFlowPresenter.this.globalSugCallback, true, true);
            }
        }
    };

    /* renamed from: n */
    private PanelAnimatorMgr.ScrolledListener f51033n = new PanelAnimatorMgr.ScrolledListener() {
        public void onScrollChanged(Padding padding) {
            if (MapFlowPresenter.this.mCarMainPageController != null) {
                MapFlowPresenter.this.mCurrentPadding = padding;
                MapFlowPresenter.this.doBestView();
            }
        }
    };

    /* renamed from: o */
    private PanelAnimatorMgr.AnimationListener f51034o = new PanelAnimatorMgr.AnimationListener() {
        public void onAnimationProcess(AnimationModel animationModel) {
            if (animationModel.isExpand() && animationModel.getFraction() == 1.0f) {
                Bundle bundle = new Bundle();
                HashMap hashMap = new HashMap();
                if (animationModel.getType() == 1) {
                    MapFlowPresenter.this.addTrack(1);
                    hashMap.put("entry_3", "1");
                } else {
                    MapFlowPresenter.this.addTrack(3);
                    hashMap.put("entry_3", "5");
                }
                hashMap.put(ParamKeys.PARAM_COMPLAIN_ENTRY, "sa");
                hashMap.put("entry_2", "map");
                bundle.putSerializable("sa_entry", hashMap);
                SaBusinessManager ins = SaBusinessManager.Companion.getIns();
                ins.switchBusiness("ride", NationTypeUtil.getNationComponentData().getProductPreFix() + RouterType.RIDE_ENTRANCE, bundle);
                if (MapFlowPresenter.this.mCarMainPageController != null) {
                    MapFlowPresenter.this.mCarMainPageController.leaveSaPage(100);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f51035p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f51036q = false;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36558a(String str) {
        this.f51025f.info(str, new Object[0]);
    }

    public MapFlowPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f51026g = componentParams;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m36558a("onadd");
        EventBus.getDefault().register(this);
        subscribe("event_map_reset_map", this.mHomeBestViewPadding);
        subscribe(BaseEventKeys.SAHome.EVENT_HOME_UPDATE, this.mHomeUpdate);
        subscribe("event_show_new_sug_page", this.mShowSugPageListener);
        PanelAnimatorMgr.addAnimationListener(this.f51034o);
        PanelAnimatorMgr.addScrolledListener(this.f51033n);
        setBizDataGetter();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RideCardModel m36553a() {
        return this.f51020a;
    }

    public void addTrack(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "1");
        hashMap.put("style", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_map_to_ridehome_ck", (Map<String, Object>) hashMap);
    }

    public void onRemove() {
        super.onRemove();
        m36558a("onRemove");
        PanelAnimatorMgr.removeListener(this.f51034o);
        PanelAnimatorMgr.removeScrolledListener(this.f51033n);
        EventBus.getDefault().unregister(this);
        unsubscribe("event_map_reset_map", this.mHomeBestViewPadding);
        unsubscribe(BaseEventKeys.SAHome.EVENT_HOME_UPDATE, this.mHomeUpdate);
        unsubscribe("event_show_new_sug_page", this.mShowSugPageListener);
    }

    public void onPageResume() {
        super.onPageResume();
        m36558a("onPageResume");
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
        m36558a("onPageHiddenChanged " + z);
        ICarMainPageController iCarMainPageController = this.mCarMainPageController;
        if (iCarMainPageController == null) {
            return;
        }
        if (!z) {
            this.f51032m.clear();
            if (SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getMapFlowView().getPresenter().getCurrentScene() instanceof ICarMainPageController) {
                MainPageSceneParam.Builder builder = new MainPageSceneParam.Builder();
                builder.isSuperAppScene(true);
                builder.iMapEventCallBack(this.f51024e);
                builder.slidingParam(getCarSlidingParam(this.mCarBitmapDescriptor));
                ICarMainPageController iCarMainPageController2 = (ICarMainPageController) SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getMapFlowView().getPresenter().getCurrentScene();
                this.mCarMainPageController = iCarMainPageController2;
                iCarMainPageController2.saUpdatePageSceneParam(builder.build());
                this.mCarMainPageController.saCarMainToSAPage(m36564c());
                return;
            }
            this.mCarMainPageController = null;
            m36562b();
        } else if (iCarMainPageController != null) {
            iCarMainPageController.leaveSaPage(0);
        }
    }

    public void onPagePause() {
        super.onPagePause();
        m36558a("onPagePause");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMapReday(MapRedayEvent mapRedayEvent) {
        m36558a("====mapreday====");
        m36562b();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(Bundle bundle) {
        this.f51029j = true;
        if (bundle != null) {
            this.f51030k = bundle.getString("driverInfoLat");
            this.f51031l = bundle.getString("driverInfoLat");
            EventBus.getDefault().post(new CloseSideBarEvent());
            showSugOrRouterPage(2, FromType.OPEN_RIDE, this.globalSugCallback, true, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36562b() {
        m36558a("entersa homescene ");
        if (this.mCarMainPageController != null || SuperAppBusinessManager.INSTANCE.getCommonBusinessContext() == null || SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getMapFlowView() == null) {
            m36558a("dup enter scene or mapflow is null");
        } else if (!SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getMapFlowView().isMapReady()) {
            m36558a("mapready is false");
        } else {
            MainPageSceneParam.Builder builder = new MainPageSceneParam.Builder();
            builder.isSuperAppScene(true);
            builder.iMapEventCallBack(this.f51024e);
            builder.slidingParam(getCarSlidingParam(this.mCarBitmapDescriptor));
            Address address = new Address();
            DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
            if (didiLocation != null) {
                address.setLatitude(didiLocation.getLatitude());
                address.setLongitude(didiLocation.getLongitude());
            }
            SugParams createSugPageAddressParam = AddressUtil.createSugPageAddressParam(this.mContext, 2, address);
            createSugPageAddressParam.fromType = FromType.HOME;
            builder.addressParam(createSugPageAddressParam.addressParam);
            builder.reverseGeo(new IReverseGeoListener() {
                public void onFail(IOException iOException) {
                }

                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    RpcPoi rpcPoi;
                    if (reverseGeoResult != null && !TextUtil.isEmpty(reverseGeoResult.countryCode)) {
                        if (!(reverseGeoResult.result == null || reverseGeoResult.result.size() <= 0 || (rpcPoi = reverseGeoResult.result.get(0)) == null || rpcPoi.base_info == null || (rpcPoi.base_info.lat == 0.0d && rpcPoi.base_info.lng == 0.0d))) {
                            Address unused = MapFlowPresenter.this.f51027h = new Address();
                            MapFlowPresenter.this.f51027h.setLatitude(rpcPoi.base_info.lat);
                            MapFlowPresenter.this.f51027h.setLongitude(rpcPoi.base_info.lng);
                            if (!TextUtils.isEmpty(rpcPoi.base_info.displayname)) {
                                MapFlowPresenter.this.f51027h.setDisplayName(rpcPoi.base_info.displayname);
                                MapFlowPresenter.this.f51025f.info(MapFlowPresenter.this.f51027h.displayName, new Object[0]);
                            }
                            IAddressData iAddressData = (IAddressData) MapFlowPresenter.this.getDataSender(ComponentType.COMPONENT_SA_XPANEL, GlobalSenderName.SEND_START_ADDRESS_DATA);
                            if (iAddressData != null) {
                                iAddressData.setData(MapFlowPresenter.this.f51027h);
                            }
                        }
                        EventBus.getDefault().post(reverseGeoResult);
                    }
                }
            });
            ICarMainPageController transformToMainScene = transformToMainScene(builder.build());
            this.mCarMainPageController = transformToMainScene;
            if (transformToMainScene != null) {
                m36558a("enter homescene " + m36564c());
                this.mCarMainPageController.doBestView(m36564c());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36557a(RideCardModel rideCardModel) {
        if (!(rideCardModel == null || rideCardModel.map == null)) {
            this.f51035p = rideCardModel.map.carIcon;
        }
        if (!TextUtils.isEmpty(this.f51035p) && !IconHelper.getInstance().haveCache(this.f51035p)) {
            IconHelper.getInstance().requestMisIcon(this.mContext.getApplicationContext(), this.f51035p, true, new IconHelper.IconChangeListener() {
                public void iconChange() {
                    if (MapFlowPresenter.this.mCarMainPageController != null) {
                        MapFlowPresenter.this.mCarMainPageController.updateCarIcon();
                    }
                }
            });
        }
    }

    public CarSlidingParam getCarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor) {
        return new CarSlidingParam(iCarBitmapDescriptor, 0, 1, IDFAManager.getIdfa(this.mContext, (IDFAManager.onIDFAChangeListener) null), NationTypeUtil.getNationComponentData().getOriginID(), MixFlagUtil.getMixFlag(this.mContext), m36554a(this.mContext));
    }

    public String getUid() {
        String uid = NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
        return !TextUtil.isEmpty(uid) ? uid : "0";
    }

    /* renamed from: a */
    private static String m36554a(Context context) {
        IA3Manager iA3Manager = (IA3Manager) ComponentLoadUtil.getComponent(IA3Manager.class);
        return iA3Manager != null ? iA3Manager.getToken(context) : "";
    }

    public ICarMainPageController transformToMainScene(MainPageSceneParam mainPageSceneParam) {
        m36558a("MapFlowDelegate switch2CarMainPageScene..");
        if (SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getMapFlowView() != null) {
            return SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getMapFlowView().getPresenter().switch2CarMainPageScene(mainPageSceneParam);
        }
        return null;
    }

    public void setBizDataGetter() {
        PaxEnvironment.getInstance().setBizDataGetter(new IBizDataGetter() {
            public String getToken() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
            }

            public String getUid() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
            }

            public String getPhoneNumber() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
            }

            public String getProductId() {
                try {
                    if (!SuperAppBusinessManager.INSTANCE.isSaRealShow()) {
                        return ((IProductId) ServiceLoader.load(IProductId.class).get()).getProductId();
                    }
                    RideCardModel h = MapFlowPresenter.this.m36553a();
                    if (h == null || h.map == null) {
                        return "30008";
                    }
                    return h.map.businessid;
                } catch (Exception e) {
                    MapFlowPresenter.this.m36558a("getproductid exception");
                    e.printStackTrace();
                    return "30008";
                }
            }

            public String getAppVersion() {
                return SystemUtil.getVersionName(DIDIApplicationDelegate.getAppContext());
            }

            public String getCountryCode() {
                return ConfProxy.getInstance().getCountryIsoCode();
            }

            public int getCityId() {
                return ConfProxy.getInstance().getCityId();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void doBestView() {
        if (SuperAppBusinessManager.INSTANCE.isSaRealShow()) {
            Padding c = m36564c();
            ICarMainPageController iCarMainPageController = this.mCarMainPageController;
            if (iCarMainPageController != null && c != null) {
                iCarMainPageController.doBestView(c);
                m36558a("MapFlowDelegate doBestView padding=" + c);
            }
        }
    }

    /* renamed from: c */
    private Padding m36564c() {
        if (this.mCurrentPadding == null) {
            this.mCurrentPadding = new Padding(0, 0, 0, 0);
        }
        return this.mCurrentPadding;
    }

    /* access modifiers changed from: protected */
    public void showSugOrRouterPage(int i, FromType fromType, GlobalSugCallback globalSugCallback2, Boolean bool, boolean z) {
        Address address = this.f51027h;
        if (address == null || this.f51029j) {
            address = getCurrentAddress();
            if (address == null) {
                address = new Address();
                address.latitude = 0.0d;
                address.longitude = 0.0d;
                address.displayName = this.mContext.getResources().getString(R.string.GRider_Sug_2020_placeholder_pickup);
            }
        } else {
            Logger logger = this.f51025f;
            logger.info(this.f51027h.displayName + "startAddress", new Object[0]);
        }
        if (!bool.booleanValue()) {
            address = null;
        }
        SugParams createSugPageAddressParam = AddressUtil.createSugPageAddressParam(this.mContext, i, address);
        RideCardModel a = m36553a();
        if (a == null || a.config == null || a.config.enableWaypoint != 1) {
            createSugPageAddressParam.enable_way_point = false;
        } else {
            createSugPageAddressParam.enable_way_point = true;
        }
        createSugPageAddressParam.fromType = fromType;
        createSugPageAddressParam.is_start_address_new_select = this.f51036q;
        createSugPageAddressParam.map_select_oper = SugParams.MapSelectOper.OTHER;
        createSugPageAddressParam.wayPointParam.setWayPointTypes(getEditableWayPointsType());
        createSugPageAddressParam.wayPointParam.setWayPoints(getWayPoints());
        createSugPageAddressParam.wayPointParam.setAddDefaultWayPoint(z);
        IDidiAddressNewApiImpl createDidiAddress = NewAddressApiFactory.createDidiAddress(this.mContext);
        try {
            if (this.f51026g != null) {
                createDidiAddress.startSugActivity(this.f51026g.getActivity(), createSugPageAddressParam, globalSugCallback2);
            }
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public Address getCurrentAddress() {
        Address address = new Address();
        if (this.f51029j) {
            try {
                address.setLatitude(Double.parseDouble(this.f51030k));
                address.setLongitude(Double.parseDouble(this.f51031l));
            } catch (Exception unused) {
                address.setLatitude(0.0d);
                address.setLongitude(0.0d);
            }
            return address;
        }
        if (NationTypeUtil.getNationComponentData().getDidiLocation() != null) {
            address.setLatitude(NationTypeUtil.getNationComponentData().getDidiLocation().getLongitude());
            address.setLongitude(NationTypeUtil.getNationComponentData().getDidiLocation().getLongitude());
        }
        address.setCityId(Integer.parseInt(NationTypeUtil.getNationComponentData().getCityId()));
        return address;
    }

    /* access modifiers changed from: protected */
    public List<Integer> getEditableWayPointsType() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> getWayPoints() {
        WayPoint wayPoint;
        WayPoint wayPoint2;
        List<WayPoint> list = this.f51032m;
        if (list == null || list.size() == 0) {
            wayPoint2 = null;
            wayPoint = null;
        } else {
            wayPoint2 = null;
            wayPoint = null;
            for (WayPoint next : this.f51032m) {
                if (next.getWayPointType() == 1) {
                    wayPoint2 = next;
                } else if (next.getWayPointType() == 3) {
                    wayPoint = next;
                }
            }
        }
        if (wayPoint2 == null) {
            this.f51032m.add(0, new WayPoint(1, (Address) null));
        }
        if (wayPoint == null) {
            List<WayPoint> list2 = this.f51032m;
            list2.add(list2.size(), new WayPoint(3, (Address) null));
        }
        return this.f51032m;
    }

    /* access modifiers changed from: protected */
    public boolean hasWayPointBy(List<WayPoint> list, int... iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            int i3 = iArr[i];
            Iterator<WayPoint> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getWayPointType() == i3) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                i2++;
            }
            i++;
        }
        if (iArr.length == i2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSubmitWayPoint(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, IWayPointsPostCallback iWayPointsPostCallback) {
        Logger logger = this.f51025f;
        logger.info("zl-route-editor", "[sug page] onSubmit WayPoints : " + list + " changed: " + list2);
        if (!hasWayPointBy(list, 3)) {
            if (hasWayPointBy(list, 2)) {
                List<WayPoint> filterWayPointBy = filterWayPointBy(list, 2);
                filterWayPointBy.get(filterWayPointBy.size() - 1).setWayPointType(3);
            }
        }
        this.f51032m.clear();
        if (hasWayPointBy(list, 1, 3)) {
            saveWayPoint(list);
        }
        iWayPointsPostCallback.onSuccess();
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> filterWayPointBy(List<WayPoint> list, int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (WayPoint next : list) {
            if (Arrays.binarySearch(iArr, next.getWayPointType()) >= 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void saveWayPoint(List<WayPoint> list) {
        if (list != null) {
            for (WayPoint next : list) {
                if (next.getWayPointType() == 1) {
                    this.f51027h = next.getAddress();
                } else if (next.getWayPointType() == 3) {
                    this.f51028i = next.getAddress();
                } else if (next.getWayPointType() == 2 && next != null) {
                    this.f51032m.add(next);
                }
            }
        }
    }
}
