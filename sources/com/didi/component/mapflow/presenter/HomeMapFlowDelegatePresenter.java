package com.didi.component.mapflow.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.didi.common.map.MapView;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.carsliding.IconHelper;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.presenter.IMapFlowPresenter;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.global.FenceChangeListener;
import com.didi.map.global.flow.scene.global.IReverseGeoListener;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.scene.mainpage.MainPageSceneParam;
import com.didi.map.global.flow.utils.SceneUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.messagecenter.p152pb.OrderStat;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.model.response.CarMoveBean;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.domainprocessor.DomainDataContainer;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.sdk.poibase.util.BizUtil;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeMapFlowDelegatePresenter extends AbsHomeMapFlowDelegatePresenter implements MapView.TouchEventListener {

    /* renamed from: a */
    private final Logger f14426a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private boolean f14427b = true;

    /* renamed from: c */
    private FenceChangeListener f14428c = new FenceChangeListener() {
        public void onChange(FenceInfo fenceInfo) {
            String str = fenceInfo.welcomeText;
            String str2 = fenceInfo.recommendText;
            String str3 = fenceInfo.stationIcon;
            HashMap hashMap = new HashMap();
            hashMap.put("fence_id", fenceInfo.fenceId);
            hashMap.put("fence_type", Integer.valueOf(fenceInfo.fenceType));
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                GlobalOmegaUtils.trackEvent("ibt_gp_map_fence_view_sw", (Map<String, Object>) hashMap);
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14429d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Map.EVENT_REFRESH_MAPAPI_DATA.equalsIgnoreCase(str)) {
                boolean f = HomeMapFlowDelegatePresenter.this.m10167e();
                ELog.log("mapapi refresh finished with ret: " + f);
            }
        }
    };

    /* renamed from: e */
    private CarInfo f14430e = BusinessUtils.getDefaultConfCarInfo(this.mBusinessContext);

    /* renamed from: f */
    private CarMoveBean f14431f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f14432g;

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14433h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET.equals(str)) {
                HomeMapFlowDelegatePresenter.this.m10163c();
            }
        }
    };

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14434i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Map.EVENT_REFRESH_CAR_MOVING_ICON_BY_MIS.equals(str)) {
                HomeMapFlowDelegatePresenter.this.m10165d();
            }
        }
    };

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener<Boolean> f14435j = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue() && TextUtils.equals(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, str)) {
                HomeMapFlowDelegatePresenter.this.m10165d();
            }
        }
    };
    protected ICarBitmapDescriptor mCarBitmapDescriptor = new ICarBitmapDescriptor() {
        public BitmapDescriptor getBitmapDescriptor() {
            if (HomeMapFlowDelegatePresenter.this.mContext != null) {
                return IconHelper.getInstance().getSmoothDriverIcon(HomeMapFlowDelegatePresenter.this.mContext.getApplicationContext(), HomeMapFlowDelegatePresenter.this.f14432g, R.drawable.global_mapflow_default_car_icon);
            }
            return null;
        }

        public BitmapDescriptor getDefaultBitmapDescriptor() {
            if (HomeMapFlowDelegatePresenter.this.mContext != null) {
                return IconHelper.getInstance().getSmoothDriverIcon(HomeMapFlowDelegatePresenter.this.mContext.getApplicationContext(), HomeMapFlowDelegatePresenter.this.f14432g, R.drawable.global_mapflow_default_car_icon);
            }
            return null;
        }
    };
    protected ICarMainPageController mCarMainPageController;

    /* renamed from: a */
    private void m10158a(NearCarDriver nearCarDriver) {
        if ("home".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            HashMap hashMap = new HashMap();
            boolean z = !this.f14427b;
            int i = 0;
            this.f14427b = false;
            if (!(nearCarDriver == null || nearCarDriver.driverLocations == null)) {
                i = nearCarDriver.driverLocations.size();
            }
            hashMap.put("num", Integer.valueOf(i));
            hashMap.put("type", Integer.valueOf(z ? 1 : 0));
            GlobalOmegaUtils.trackEvent("gp_home_carNum_sw", (Map<String, Object>) hashMap);
        }
    }

    public HomeMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
        CarMoveBean carMoveBean = new CarMoveBean();
        this.f14431f = carMoveBean;
        carMoveBean.sdkmaptype = NationComponentDataUtil.getMapTypeString();
        this.f14431f.orderStage = OrderStat.HomePage;
        CarInfo carInfo = this.f14430e;
        if (carInfo != null) {
            this.f14431f.channel = carInfo.getBusinessNumId();
            this.f14431f.carLevelType = 0;
            Logger logger = this.f14426a;
            logger.info("HomeMapFlowDelegate CarMoveBean channel=" + this.f14431f.channel + " carLevel=" + this.f14430e.getCarLevel() + " carLevelType=" + this.f14431f.carLevelType, new Object[0]);
            m10159a(this.f14430e.getMapIcon());
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m10161b();
        subscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f14433h);
        subscribe(BaseEventKeys.Map.EVENT_REFRESH_CAR_MOVING_ICON_BY_MIS, this.f14434i);
        subscribe(BaseEventKeys.Map.EVENT_REFRESH_MAPAPI_DATA, this.f14429d);
        subscribe(BaseEventKeys.Home.EVENT_SHOW_ROUTER_PAGE, this.mShowNewSugPageListener);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f14435j);
        subscribe(BaseEventKeys.Home.EVENT_SHOW_SUG_PAGE_FROM_NEW_OPEN_RIDE, this.mShowNewSugPageListenerFromNewOpenRide);
        enterHomeScene();
        if (((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView() != null) {
            ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().addTouchEventListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f14433h);
        unsubscribe(BaseEventKeys.Map.EVENT_REFRESH_CAR_MOVING_ICON_BY_MIS, this.f14434i);
        unsubscribe(BaseEventKeys.Map.EVENT_REFRESH_MAPAPI_DATA, this.f14429d);
        unsubscribe(BaseEventKeys.Home.EVENT_SHOW_ROUTER_PAGE, this.mShowNewSugPageListener);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f14435j);
        unsubscribe(BaseEventKeys.Home.EVENT_SHOW_SUG_PAGE_FROM_NEW_OPEN_RIDE, this.mShowNewSugPageListenerFromNewOpenRide);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView() != null) {
            ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().removeTouchEventListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        enterHomeScene();
        subscribe("event_map_reset_map", this.mResetMapListener);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView() != null) {
            ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().addTouchEventListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe("event_map_reset_map", this.mResetMapListener);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView() != null) {
            ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().removeTouchEventListener(this);
        }
    }

    /* renamed from: b */
    private void m10161b() {
        DomainDataContainer domainDataContainer = (DomainDataContainer) SingletonHolder.getInstance(DomainDataContainer.class);
        if (TextUtil.isEmpty(domainDataContainer.getStringData("gconf_country_code"))) {
            domainDataContainer.putData("gconf_country_code", NationTypeUtil.getNationComponentData().getLocCountry());
            ELog.log("  set countryCode: " + NationTypeUtil.getNationComponentData().getLocCountry());
        }
    }

    public static Address convertToAddress(RpcPoi rpcPoi) {
        if (rpcPoi == null || rpcPoi.base_info == null) {
            return null;
        }
        Address address = new Address();
        address.poiId = rpcPoi.base_info.poi_id;
        address.uid = rpcPoi.base_info.poi_id;
        address.displayName = rpcPoi.base_info.displayname;
        address.address = rpcPoi.base_info.address;
        address.fullName = rpcPoi.base_info.addressAll;
        address.latitude = rpcPoi.base_info.lat;
        address.longitude = rpcPoi.base_info.lng;
        address.srcTag = rpcPoi.base_info.srctag;
        address.coordinate_type = rpcPoi.base_info.coordinate_type;
        address.cotype = BizUtil.convert2Cotype(rpcPoi.base_info.coordinate_type);
        address.weight = rpcPoi.base_info.weight;
        address.cityId = rpcPoi.base_info.city_id;
        address.cityName = rpcPoi.base_info.city_name;
        address.isRecommendTag = rpcPoi.base_info.is_recommend_absorb;
        address.searchId = rpcPoi.base_info.searchId;
        address.countryID = rpcPoi.base_info.countryId;
        address.countryCode = rpcPoi.base_info.countryCode;
        address.geofence = rpcPoi.geofence;
        address.hideAddress = rpcPoi.base_info.hide_address;
        if (rpcPoi.extend_info != null) {
            boolean z = true;
            if (rpcPoi.extend_info.enable_confirm_dropoff != 1) {
                z = false;
            }
            address.enableConfirmDropoff = z;
            address.xpanelDesc = rpcPoi.extend_info.xpanelDesc;
            address.subTitleDesc = rpcPoi.extend_info.subTitleDesc;
        }
        address.isDiscountPoi = rpcPoi.isDiscountPoi;
        return address;
    }

    /* access modifiers changed from: protected */
    public void enterHomeScene() {
        CarSlidingParam carSlidingParam = getCarSlidingParam(this.mCarBitmapDescriptor, OrderStat.HomePage, this.f14431f);
        MainPageSceneParam.Builder builder = new MainPageSceneParam.Builder();
        builder.context(this.mContext).mapChangeListener(this.mMapChangeListener).slidingParam(carSlidingParam).fenceChange(this.f14428c);
        Address address = new Address();
        DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
        if (lastKnownLocation != null) {
            address.setLatitude(lastKnownLocation.getLatitude());
            address.setLongitude(lastKnownLocation.getLongitude());
        }
        builder.addressParam(AddressUtil.createSugPageAddressParam(this.mContext, 1, address).addressParam);
        builder.reverseGeo(new IReverseGeoListener() {
            public void onFail(IOException iOException) {
            }

            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                RpcPoi rpcPoi;
                Address address;
                if (reverseGeoResult != null && !TextUtil.isEmpty(reverseGeoResult.countryCode)) {
                    if (!(reverseGeoResult.result == null || reverseGeoResult.result.size() <= 0 || (rpcPoi = reverseGeoResult.result.get(0)) == null || rpcPoi.base_info == null)) {
                        FormStore.getInstance().setDisplayName(rpcPoi.base_info.displayname);
                        if (!(rpcPoi.base_info.lat == 0.0d && rpcPoi.base_info.lng == 0.0d)) {
                            if (SceneUtils.checkHomeRgeoPax()) {
                                address = HomeMapFlowDelegatePresenter.convertToAddress(rpcPoi);
                                if (address == null) {
                                    address = new Address();
                                }
                            } else {
                                Address address2 = new Address();
                                address2.setLatitude(rpcPoi.base_info.lat);
                                address2.setLongitude(rpcPoi.base_info.lng);
                                if (!TextUtils.isEmpty(rpcPoi.base_info.displayname)) {
                                    address2.setDisplayName(rpcPoi.base_info.displayname);
                                }
                                address = address2;
                            }
                            FormStore.getInstance().setStartAddress(address);
                        }
                    }
                    DomainDataContainer domainDataContainer = (DomainDataContainer) SingletonHolder.getInstance(DomainDataContainer.class);
                    String stringData = domainDataContainer.getStringData("gconf_country_code");
                    if (DomainUtil.isSupportDomainSwitch(HomeMapFlowDelegatePresenter.this.mContext)) {
                        ELog.log("reversegeo response success country_code = " + reverseGeoResult.countryCode + " ");
                        domainDataContainer.putData("gconf_country_code", reverseGeoResult.countryCode);
                        if (!TextUtil.isEmpty(stringData) && !stringData.equalsIgnoreCase(reverseGeoResult.countryCode)) {
                            ELog.log("verify_compass catch country_code changed from old:" + stringData + " to new:" + reverseGeoResult.countryCode);
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.DomainSwitch.KEY_DOMAINSWITCH_COUNTRY_CODE_CHANGED, String.format("cid from %s to %s", new Object[]{stringData, reverseGeoResult.countryCode}));
                        }
                    }
                }
            }
        });
        this.mCarMainPageController = transformToMainScene(builder.build());
    }

    public ICarMainPageController transformToMainScene(MainPageSceneParam mainPageSceneParam) {
        this.f14426a.info("MapFlowDelegate switch2CarMainPageScene..", new Object[0]);
        IMapFlowPresenter presenter = ((IMapFlowDelegateView) this.mView).getMapFlowView() != null ? ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter() : null;
        if (presenter != null && (presenter.getCurrentScene() instanceof ICarMainPageController)) {
            ((ICarMainPageController) presenter.getCurrentScene()).saUpdatePageSceneParam(mainPageSceneParam);
            return (ICarMainPageController) presenter.getCurrentScene();
        } else if (presenter != null) {
            return presenter.switch2CarMainPageScene(mainPageSceneParam);
        } else {
            return null;
        }
    }

    public CarSlidingParam getCarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, OrderStat orderStat, CarMoveBean carMoveBean) {
        CarSlidingParam carSlidingParam = super.getCarSlidingParam(iCarBitmapDescriptor, orderStat, carMoveBean);
        carSlidingParam.setType(0);
        return carSlidingParam;
    }

    /* access modifiers changed from: protected */
    public ISceneController getSceneController() {
        return this.mCarMainPageController;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m10163c() {
        m10165d();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10165d() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
            CarInfo carInfo = new CarInfo();
            this.f14430e = carInfo;
            carInfo.setCarLevel(newEstimateItem.carConfig.carLevel);
            this.f14430e.setBusinessNumId(newEstimateItem.carConfig.carBussinessId);
            this.f14430e.setMapIcon(newEstimateItem.carConfig.carMapIconUrl);
            this.f14430e.setComboType(newEstimateItem.carConfig.carComboType);
        }
        if (this.f14430e == null) {
            this.f14430e = BusinessUtils.getDefaultConfCarInfo(this.mBusinessContext);
        }
        CarInfo carInfo2 = this.f14430e;
        if (carInfo2 != null) {
            this.f14431f.channel = carInfo2.getBusinessNumId();
            this.f14431f.carLevelType = 0;
            Logger logger = this.f14426a;
            logger.info("HomeMapFlowDelegate CarMoveBean channel=" + this.f14431f.channel + " carLevel=" + this.f14430e.getCarLevel() + " carLevelType=" + this.f14431f.carLevelType, new Object[0]);
            m10159a(this.f14430e.getMapIcon());
            return;
        }
        this.f14431f.channel = 0;
        this.f14431f.carLevelType = 0;
        this.f14426a.info("HomeMapFlowDelegate CarMoveBean current car info is null", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public int getMapBizId() {
        CarInfo carInfo = this.f14430e;
        if (carInfo == null || carInfo.getBusinessNumId() <= 0) {
            return super.getMapBizId();
        }
        return this.f14430e.getBusinessNumId();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            doPublish(BaseEventKeys.Map.EVENT_ON_TOUCH_THE_MAP);
        }
    }

    /* renamed from: a */
    private void m10159a(String str) {
        this.f14432g = str;
        if (!TextUtils.isEmpty(str) && !IconHelper.getInstance().haveCache(this.f14432g)) {
            IconHelper.getInstance().requestMisIcon(this.mContext.getApplicationContext(), this.f14432g, true, new IconHelper.IconChangeListener() {
                public void iconChange() {
                    if (HomeMapFlowDelegatePresenter.this.mCarMainPageController != null) {
                        HomeMapFlowDelegatePresenter.this.mCarMainPageController.updateCarIcon();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m10167e() {
        ICarMainPageController iCarMainPageController = this.mCarMainPageController;
        if (iCarMainPageController != null) {
            return iCarMainPageController.onDomainChanged();
        }
        return false;
    }
}
