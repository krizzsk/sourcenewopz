package com.didi.carpool.onservice;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.android.didi.theme.DidiThemeManager;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.ImageUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter;
import com.didi.map.global.flow.scene.order.serving.IPassBTMStatusCallback;
import com.didi.map.global.flow.scene.order.serving.carpool.CarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.model.FlierFeature;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DrivingMapInfo;
import com.didi.travel.psnger.model.response.FlierPoolStationModel;
import com.didi.travel.psnger.model.response.MapBubbleMsg;
import com.didi.travel.psnger.utils.NumberUtil;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarPoolOnServiceMapFlowDelegatePresenter extends OnServiceMapFlowDelegatePresenter implements IFetchCarpoolInfo {

    /* renamed from: d */
    private static final String f10674d = "CarPoolOnServiceMapFlowDelegatePresenter";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<MapBubbleMsg> f10675e;

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<DrivingMapInfo> f10676f = new BaseEventPublisher.OnEventListener<DrivingMapInfo>() {
        public void onEvent(String str, DrivingMapInfo drivingMapInfo) {
            List unused = CarPoolOnServiceMapFlowDelegatePresenter.this.f10675e = drivingMapInfo.mapBubbleMsgList;
        }
    };

    public CarPoolOnServiceMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.CarPool.EVENT_NEW_CAR_POOL_PEOPLE_INFOS_UPDATE, this.f10676f);
        if (this.mOnServiceController != null) {
            this.mOnServiceController.setCarpoolInfo(this);
            this.mOnServiceController.setCarpoolShowBubblesEnabled(GlobalApolloUtil.isShowCarpoolTravelDetail());
        }
    }

    /* access modifiers changed from: protected */
    public void updateInfoWindow(final MapElementId mapElementId, final View view) {
        updateInfoWindowInMainThread(new Runnable() {
            public void run() {
                if (CarPoolOnServiceMapFlowDelegatePresenter.this.getSceneController() != null) {
                    CarPoolOnServiceMapFlowDelegatePresenter.this.getSceneController().updateMarkerBubble(mapElementId, view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void checkPassengerLate() {
        super.newCheckPassengerLate();
    }

    /* access modifiers changed from: protected */
    public void waitForArrival(CarOrder carOrder, boolean z) {
        super.waitForArrival(carOrder, z);
        if (carOrder != null && this.isCancleDown) {
            m7291a(carOrder);
        }
        if (carOrder == null) {
            return;
        }
        if (this.isShowMap || !this.isCancleDown) {
            m7292a(carOrder, this.isCancleDown);
        }
    }

    /* access modifiers changed from: protected */
    public void showNewWaitArrivalInfoWindow() {
        if (this.isShowMap) {
            super.showNewWaitArrivalInfoWindow();
        }
    }

    /* renamed from: a */
    private void m7291a(CarOrder carOrder) {
        long j;
        if (!BusinessDataUtil.onInterceptOrderStatus(carOrder, this.mCurSubStatus)) {
            if (this.isCancleDown) {
                j = (long) this.currentTime;
            } else {
                j = calculateLeftTime(carOrder.departureTime);
            }
            if (j <= 0) {
                SimpleRequestMapInfo();
                m7292a(carOrder, false);
            }
        }
    }

    /* renamed from: a */
    private void m7292a(CarOrder carOrder, boolean z) {
        CharSequence charSequence;
        String parseEtaMsg;
        if (carOrder != null) {
            boolean z2 = carOrder.substatus == 4007;
            if (((long) this.currentTime) <= 0 || z2 || z || !this.isCancleDown) {
                if (!(this.mEtaEda == null || this.mEtaEda.eta <= 0 || !this.isShowMap || this.drivingMapInfo.mapBubbleMsg == null || this.drivingMapInfo.mapBubbleMsg.size() == 0)) {
                    int i = 0;
                    while (i < this.drivingMapInfo.mapBubbleMsg.size()) {
                        if (this.drivingMapInfo.mapBubbleMsg.get(i).bubbleType != 3 || (parseEtaMsg = parseEtaMsg(this.drivingMapInfo.mapBubbleMsg.get(i).msg)) == null) {
                            i++;
                        } else {
                            Context context = this.mContext;
                            showInfoWindowTextOnCar(HighlightUtil.highlight(context, parseEtaMsg + Elvish.Companion.getInstance().formatCountdownTime(this.mEtaEda.eta * 60, true)), true);
                            return;
                        }
                    }
                }
                if (carOrder.substatus != 4001 && carOrder.substatus != 4002) {
                    charSequence = ResourcesHelper.getString(this.mContext, R.string.global_carpool_map_flow_driver_arrived);
                } else if (this.mEtaEda == null || this.mEtaEda.eta <= 0) {
                    charSequence = ResourcesHelper.getString(this.mContext, R.string.global_carpool_map_flow_driver_on_the_way);
                } else {
                    Context context2 = this.mContext;
                    Context context3 = this.mContext;
                    charSequence = HighlightUtil.highlight(context2, ResourcesHelper.getString(context3, R.string.global_carpool_map_flow_driver_will_arrive, "" + this.mEtaEda.eta));
                }
                showInfoWindowTextOnCar(charSequence, false);
            } else {
                m7291a(carOrder);
            }
            if (carOrder.substatus == 4004) {
                CarNotifyManager.buildPassengerLateNotify(this.mContext);
                doPublish(BaseEventKeys.OnService.EVENT_STATUS_PASSENGER_LATE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ServingParam getServingParam(CarOrder carOrder, long j, int i) {
        FlierPoolStationModel flierPoolStationModel;
        CarOrder carOrder2 = carOrder;
        String str = null;
        if (carOrder2 == null || carOrder2.startAddress == null || carOrder2.endAddress == null) {
            LoggerFactory.getLogger(getClass().getName()).error("OnServiceMapFlowDelegate getServingParam order is null", new Object[0]);
            return null;
        }
        long j2 = 0;
        if (carOrder2.carDriver != null) {
            j2 = NumberUtil.strToLong(carOrder2.carDriver.did);
        }
        long j3 = j2;
        OrderParams createOrderParams = createOrderParams(carOrder2.oid, j3, j, i, this.mFromPageId);
        createOrderParams.productID = String.valueOf(carOrder2.productid);
        createOrderParams.srcTag = carOrder2.startAddress.srcTag;
        createOrderParams.orderType = carOrder2.orderType;
        createOrderParams.isShowExtendedAnimation = true;
        createOrderParams.pickupExtendedAnimDurationInMs = 1000;
        createOrderParams.lastOrderId = carOrder2.lastOrderId;
        m7290a(createOrderParams, carOrder2);
        if (this.mBusinessContext.getCountryInfo() != null) {
            str = this.mBusinessContext.getCountryInfo().getCountryIsoCode();
        }
        ClientParams clientParams = new ClientParams(SystemUtil.getVersionName(this.mContext), str, SystemUtil.getIMEI());
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(new CommonMarkerParam.Builder().addressName(ResourcesHelper.getString(this.mContext, R.string.map_flow_finishing_last_trip_tips)).addressNameColorResId(R.color.black).markerIconResId(R.drawable.waypoint_map_icon_stop_point));
        LatLng latLng = new LatLng(carOrder2.startAddress.latitude, carOrder2.startAddress.longitude);
        FlierFeature flierFeature = carOrder2.flierFeature;
        if (!(flierFeature == null || (flierPoolStationModel = flierFeature.flierPoolStationModel) == null || (flierPoolStationModel.lat == 0.0d && flierPoolStationModel.lng == 0.0d))) {
            String str2 = flierPoolStationModel.address;
            latLng.latitude = flierPoolStationModel.lat;
            latLng.longitude = flierPoolStationModel.lng;
        }
        ClientParams clientParams2 = clientParams;
        LatLng latLng2 = new LatLng(carOrder2.endAddress.latitude, carOrder2.endAddress.longitude);
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("OnServiceMapFlowDelegate getServingParam oid=" + carOrder2.oid + " driverId=" + j3 + " countryId=" + str + " startLatLng=" + latLng + " endLatLng=" + latLng2, new Object[0]);
        CommonMarkerParam.Builder builder = new CommonMarkerParam.Builder();
        builder.mo75597id(MapElementId.ID_MARKER_ODPOINT);
        builder.markerIconResId(R.drawable.waypoint_map_icon_stop_point);
        CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(builder);
        DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.pin_pickup_icon);
        DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.pin_dropoff_icon);
        Drawable drawable = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_pick_up);
        Drawable drawable2 = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_destination);
        addExtraParams(createOrderParams);
        CommonMarkerParam commonMarkerParam3 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng).markerIcon(ImageUtil.Drawable2Bitmap(drawable)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_START).poiId(carOrder2.startAddress.uid).addressName(carOrder2.startAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        CommonMarkerParam commonMarkerParam4 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng2).markerIcon(ImageUtil.Drawable2Bitmap(drawable2)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_END).addressName(carOrder2.endAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        HashMap hashMap = new HashMap();
        hashMap.put(MapElementId.ID_MARKER_START, commonMarkerParam3);
        hashMap.put(MapElementId.ID_MARKER_END, commonMarkerParam4);
        hashMap.put(MapElementId.ID_MARKER_WAYPOINT, commonMarkerParam);
        hashMap.put(MapElementId.ID_MARKER_ODPOINT, commonMarkerParam2);
        ServingParam.Builder passBTMStatusCallback = new ServingParam.Builder().isNewVersion(true).markerParams(hashMap).carBitmapDescriptor(this.mCarBitmapDescriptor).orderParams(createOrderParams).showGuideEntrance(true).clientParams(clientParams2).etaEdaCallback(this.mEtaEdaCallback).guideEntranceCallback(this.mIGuideEntranceCallback).context(this.mContext).mapChangeListener(this.mMapChangeListener).passBTMStatusCallback(new IPassBTMStatusCallback() {
            public void showBTMEntry(boolean z) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ENTRANCE_SHOW, Boolean.valueOf(z));
                OrderComManager.getInstance().isShowBlueToothEntrance = z;
                CarPoolOnServiceMapFlowDelegatePresenter.this.traceBlueMeetShowEvent();
            }
        });
        passBTMStatusCallback.oraOrderStageCallback(this.mIOraOrderStageCallback).car3DIcons(this.mCache3DList);
        return new ServingParam(passBTMStatusCallback);
    }

    /* renamed from: a */
    private void m7290a(OrderParams orderParams, CarOrder carOrder) {
        if (carOrder != null) {
            orderParams.travelId = carOrder.travelid;
            orderParams.carpoolStartIcon = ((BitmapDrawable) ResourcesHelper.getDrawable(this.mContext, R.drawable.global_com_icon_green_stop)).getBitmap();
            orderParams.carpoolEndIcon = ((BitmapDrawable) ResourcesHelper.getDrawable(this.mContext, R.drawable.global_com_icon_orange_stop)).getBitmap();
        }
    }

    public List<CarpoolInfo> onFetch() {
        List<MapBubbleMsg> list = this.f10675e;
        if (list == null || list.size() <= 0) {
            GLog.m7965d(f10674d, "拼友地图气泡消息列表为空");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f10675e.size(); i++) {
            MapBubbleMsg mapBubbleMsg = this.f10675e.get(i);
            sb.append("MapBubbleMsg [" + i + "] =");
            sb.append(mapBubbleMsg.toString());
            sb.append("\n");
            arrayList.add(new CarpoolInfo(mapBubbleMsg.orderId, mapBubbleMsg.type, mapBubbleMsg.msg));
        }
        GLog.m7965d(f10674d, sb.toString());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.CarPool.EVENT_NEW_CAR_POOL_PEOPLE_INFOS_UPDATE, this.f10676f);
    }

    /* access modifiers changed from: protected */
    public void onPostTransformScene() {
        super.onPostTransformScene();
        if (this.mOnServiceController != null) {
            this.mOnServiceController.setCarpoolInfo(this);
            this.mOnServiceController.setCarpoolShowBubblesEnabled(GlobalApolloUtil.isShowCarpoolTravelDetail());
        }
    }

    /* access modifiers changed from: protected */
    public void destroyCountDownV2() {
        if (getSceneController() != null && !this.isShowMap) {
            getSceneController().destroyMarkerBubble(MapElementId.ID_MARKER_CAR);
            getSceneController().destroyMarkerBubble(MapElementId.ID_MARKER_START);
        }
    }
}
