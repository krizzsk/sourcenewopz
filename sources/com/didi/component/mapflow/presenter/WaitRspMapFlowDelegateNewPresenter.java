package com.didi.component.mapflow.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.address.model.WayPoint;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.carsliding.IconHelper;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.order.waiting.p123v2.IWaitingForReplyControllerV2;
import com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplyParamV2;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.messagecenter.p152pb.OrderStat;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.model.response.CarMoveBean;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DrivingMapInfo;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.xengine.register.XERegister;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;
import com.didichuxing.foundation.p188io.JSON;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;

public class WaitRspMapFlowDelegateNewPresenter extends AbsAfterOrderMapFlowDelegatePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f14492a = "WaitRspMapFlowDelegateNewPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IWaitingForReplyControllerV2 f14493b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Driver f14494c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f14495d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f14496e = false;

    /* renamed from: f */
    private CarMoveBean f14497f;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14498g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(str, BaseEventKeys.Expectation.EVENT_EXPECTATION_DUSE_BROADCAST_FAIL)) {
                GLog.m7965d(WaitRspMapFlowDelegateNewPresenter.this.f14492a, "司机超时未接单");
                WaitRspMapFlowDelegateNewPresenter.this.m10293c();
            }
        }
    };

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<ExpectationManagementModel> f14499h = new BaseEventPublisher.OnEventListener<ExpectationManagementModel>() {
        public void onEvent(String str, ExpectationManagementModel expectationManagementModel) {
            GLog.m7965d(WaitRspMapFlowDelegateNewPresenter.this.f14492a, "push消息来了");
            if (expectationManagementModel != null) {
                try {
                    GLog.m7965d(WaitRspMapFlowDelegateNewPresenter.this.f14492a, JSON.stringify(expectationManagementModel));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (expectationManagementModel.duse_status != 3 && expectationManagementModel.duse_status != 5) {
                    return;
                }
                if (TextUtils.isEmpty(expectationManagementModel.did)) {
                    GLog.m7965d(WaitRspMapFlowDelegateNewPresenter.this.f14492a, "司机id为空");
                    return;
                }
                String c = WaitRspMapFlowDelegateNewPresenter.this.f14492a;
                GLog.m7965d(c, "司机ID" + expectationManagementModel.did);
                String c2 = WaitRspMapFlowDelegateNewPresenter.this.f14492a;
                GLog.m7965d(c2, "经纬度" + expectationManagementModel.lat + "---" + expectationManagementModel.lng);
                Driver driver = new Driver(expectationManagementModel.did);
                VectorCoordinateList vectorCoordinateList = new VectorCoordinateList();
                vectorCoordinateList.add(new VectorCoordinate(expectationManagementModel.lat, expectationManagementModel.lng, 0.0f, 0));
                driver.setVectorCoordinateList(vectorCoordinateList);
                if (expectationManagementModel.duse_status == 3) {
                    if (WaitRspMapFlowDelegateNewPresenter.this.f14494c != null) {
                        WaitRspMapFlowDelegateNewPresenter.this.m10293c();
                    }
                    driver.setBitmap(IconHelper.getInstance().getSmoothDriverIcon(WaitRspMapFlowDelegateNewPresenter.this.mContext, WaitRspMapFlowDelegateNewPresenter.this.f14495d, R.drawable.global_mapflow_default_car_icon));
                    WaitRspMapFlowDelegateNewPresenter.this.m10284a(driver);
                    Driver unused = WaitRspMapFlowDelegateNewPresenter.this.f14494c = driver;
                }
            }
        }
    };

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<DTSDKOrderStatus> f14500i = new BaseEventPublisher.OnEventListener<DTSDKOrderStatus>() {
        public void onEvent(String str, DTSDKOrderStatus dTSDKOrderStatus) {
            if (TextUtils.equals(str, BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS) && dTSDKOrderStatus != null && dTSDKOrderStatus.status == 4) {
                WaitRspMapFlowDelegateNewPresenter waitRspMapFlowDelegateNewPresenter = WaitRspMapFlowDelegateNewPresenter.this;
                waitRspMapFlowDelegateNewPresenter.m10291b(waitRspMapFlowDelegateNewPresenter.f14494c);
            }
        }
    };
    protected XEResponseCallback mXELogicCallbackMapInfo = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData.jsonObject != null) {
                DrivingMapInfo drivingMapInfo = new DrivingMapInfo();
                drivingMapInfo.parse(xEngineData.jsonObject.toString());
                String unused = WaitRspMapFlowDelegateNewPresenter.this.f14495d = drivingMapInfo.mapConfig.mapCarIcon;
            }
            if (!WaitRspMapFlowDelegateNewPresenter.this.f14496e) {
                WaitRspMapFlowDelegateNewPresenter.this.m10300f();
                boolean unused2 = WaitRspMapFlowDelegateNewPresenter.this.f14496e = true;
            }
        }
    };

    public WaitRspMapFlowDelegateNewPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public ISceneController getSceneController() {
        return this.f14493b;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerCallback(XERequestKey.REQUEST_KEY_MAP_INFO, this.mXELogicCallbackMapInfo);
        doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, true);
        m10298e();
        m10289b();
        m10285a(m10301g());
        m10300f();
    }

    /* renamed from: b */
    private void m10289b() {
        CarMoveBean carMoveBean = new CarMoveBean();
        this.f14497f = carMoveBean;
        carMoveBean.sdkmaptype = NationComponentDataUtil.getMapTypeString();
        if (CarOrderHelper.getOrder() != null) {
            this.f14497f.channel = CarOrderHelper.getOrder().productid;
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m10295d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10284a(Driver driver) {
        if (this.f14493b != null) {
            GLog.m7965d(this.f14492a, "startOrder:开始播单");
            this.f14493b.onOrderToOneDriver(driver);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10291b(Driver driver) {
        if (this.f14493b != null) {
            GLog.m7965d(this.f14492a, "onDriverReceivedOrder:司机接受订单");
            this.f14493b.onDriverReceivedOrder(driver);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10293c() {
        GLog.m7965d(this.f14492a, "onDriverRefuseOrder:司机拒绝订单");
        IWaitingForReplyControllerV2 iWaitingForReplyControllerV2 = this.f14493b;
        if (iWaitingForReplyControllerV2 != null) {
            iWaitingForReplyControllerV2.onDriverRefuseOrder((Driver) null);
        }
    }

    /* renamed from: d */
    private void m10295d() {
        unsubscribe(BaseEventKeys.Expectation.EVENT_EXPECTATION_DUSE_BROADCAST_FAIL, this.f14498g);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, this.f14499h);
        unsubscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f14500i);
        XERegister.unregisterCallback(XERequestKey.REQUEST_KEY_MAP_INFO, this.mXELogicCallbackMapInfo);
    }

    /* renamed from: e */
    private void m10298e() {
        subscribe(BaseEventKeys.Expectation.EVENT_EXPECTATION_DUSE_BROADCAST_FAIL, this.f14498g);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, this.f14499h);
        subscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f14500i);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10300f() {
        Address startAddress = FormStore.getInstance().getStartAddress();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && !TextUtil.isEmpty(order.carPoolOrderScene)) {
            FormStore.getInstance().setCarpoolOrderScene(NumberUtil.parseInt(order.carPoolOrderScene));
            FormStore.getInstance().setCurrentComboType(order.comboType);
        }
        if (order != null && order.startAddress != null) {
            startAddress = order.startAddress;
        } else if (startAddress == null) {
            OmegaSDK.trackError("WaitRspMapFlowDelegateNewPresenter", new Throwable("WaitRspMapFlowDelegateNewPresenter FormStore startAddress == null"));
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (order != null && order.endAddress != null) {
            endAddress = order.endAddress;
        } else if (endAddress == null) {
            OmegaSDK.trackError("WaitRspMapFlowDelegateNewPresenter", new Throwable("WaitRspMapFlowDelegateNewPresenter FormStore endAddress == null"));
        }
        if (startAddress != null && endAddress != null) {
            CarSlidingParam carSlidingParam = getCarSlidingParam(this.mCarBitmapDescriptor, OrderStat.OnTrip, this.f14497f);
            this.f14493b = transformToWaitingForNewReplySceneV2(new WaitingForReplyParamV2.Builder().context(this.mContext).mapChangeListener(this.mMapChangeListener).slidingParam(carSlidingParam).setMarkerParam(m10282a(startAddress, endAddress, FormStore.getInstance().getWayPointAddressList())).defaultCarBitmap(IconHelper.getInstance().getSmoothDriverIcon(this.mContext, this.f14495d, R.drawable.global_mapflow_default_car_icon).getBitmap()).build());
        }
    }

    /* renamed from: a */
    private List<CommonMarkerParam> m10282a(Address address, Address address2, List<WayPoint> list) {
        Address address3;
        MapElementId mapElementId;
        if (this.mContext == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.map_icon_pick_up);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.waypoint_map_icon_stop_point);
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(latLng, decodeResource, 0.5f, 0.5f, MapElementId.ID_MARKER_START);
        commonMarkerParam.setAddressName(address.getDisplayName());
        arrayList.add(commonMarkerParam);
        CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(new LatLng(address2.getLatitude(), address2.getLongitude()), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.map_icon_destination), 0.5f, 0.5f, MapElementId.ID_MARKER_END);
        commonMarkerParam2.setAddressName(address2.getDisplayName());
        arrayList.add(commonMarkerParam2);
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (int i = 0; i < list.size(); i++) {
                WayPoint wayPoint = list.get(i);
                if (!(wayPoint == null || (address3 = wayPoint.getAddress()) == null)) {
                    if (i == 0) {
                        mapElementId = MapElementId.ID_MARKER_WAYPOINT_1;
                    } else if (i != 1) {
                        mapElementId = MapElementId.ID_MARKER_WAYPOINT_3;
                    } else {
                        mapElementId = MapElementId.ID_MARKER_WAYPOINT_2;
                    }
                    CommonMarkerParam commonMarkerParam3 = new CommonMarkerParam(new LatLng(address3.latitude, address3.longitude), decodeResource2, 0.5f, 0.5f, mapElementId);
                    commonMarkerParam3.setAddressName(address3.getDisplayName());
                    arrayList.add(commonMarkerParam3);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    private String m10301g() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        return (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.carMapIconUrl)) ? "" : newEstimateItem.carConfig.carMapIconUrl;
    }

    /* renamed from: a */
    private void m10285a(String str) {
        this.f14495d = str;
        if (!TextUtils.isEmpty(str) && !IconHelper.getInstance().haveCache(this.f14495d)) {
            IconHelper.getInstance().requestMisIcon(this.mContext.getApplicationContext(), this.f14495d, true, new IconHelper.IconChangeListener() {
                public void iconChange() {
                    if (WaitRspMapFlowDelegateNewPresenter.this.f14493b != null) {
                        WaitRspMapFlowDelegateNewPresenter.this.f14493b.onCarBitmapNetWorkSuccess(IconHelper.getInstance().getSmoothDriverIcon(WaitRspMapFlowDelegateNewPresenter.this.mContext, WaitRspMapFlowDelegateNewPresenter.this.f14495d, R.drawable.global_mapflow_default_car_icon).getBitmap());
                    }
                }
            });
        }
    }
}
