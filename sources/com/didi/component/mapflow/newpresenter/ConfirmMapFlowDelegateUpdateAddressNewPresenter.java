package com.didi.component.mapflow.newpresenter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.address.FromType;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.HashMap;

public class ConfirmMapFlowDelegateUpdateAddressNewPresenter extends ConfirmMapFlowDelegateNewPresenter {

    /* renamed from: b */
    ILocationCallback f14364b = new ILocationCallback() {
        public void onUpdateLocation(DepartureAddress departureAddress) {
            if (departureAddress != null) {
                Address address = departureAddress.getAddress();
                if (address == null) {
                    GLog.m7965d("修改上车点", "地图返回地址为空了");
                    return;
                }
                GLog.m7965d("修改上车点", "onUpdateLocation:" + address.toString());
                FormStore.getInstance().setDepartureAddress(address);
                ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS, departureAddress);
                ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_ONSERVICE_PIN_CHANGED_OUT_OF_AREA, address);
            }
        }

        public void onDragging(int i) {
            if (i == 1) {
                ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_NO_PARKING, false);
            } else {
                ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_NO_PARKING, true);
            }
        }

        public void onFail(LatLng latLng) {
            ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_NO_PARKING, false);
        }

        public void onDepartureLoading(LatLng latLng) {
            ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS_LOADING);
        }
    };

    /* renamed from: c */
    private final Logger f14365c = LoggerFactory.getLogger(getClass());

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14366d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Map.EVENT_ONSERVICE_SHOW_ADDRESS_AREA, str) && ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.mOnServiceController != null) {
                ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.mOnServiceController.doBestView(ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.getCurrentPadding());
                GLog.m7965d("修改上车点", "调用最佳view:" + ConfirmMapFlowDelegateUpdateAddressNewPresenter.this.getCurrentPadding().toString());
            }
        }
    };

    /* access modifiers changed from: protected */
    public void enterConfirmScene() {
    }

    /* access modifiers changed from: protected */
    public boolean needHandleShowPinListener() {
        return false;
    }

    public ConfirmMapFlowDelegateUpdateAddressNewPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Map.EVENT_ONSERVICE_SHOW_ADDRESS_AREA, this.f14366d);
        if (CarOrderHelper.getOrder() != null) {
            m10044a(CarOrderHelper.getOrder().startAddress, CarOrderHelper.getOrder().endAddress);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        m10046b();
        super.onRemove();
        unsubscribe(BaseEventKeys.Map.EVENT_ONSERVICE_SHOW_ADDRESS_AREA, this.f14366d);
    }

    /* renamed from: b */
    private void m10046b() {
        if (this.mOnServiceController != null) {
            GLog.m7965d("修改上车点", "leavePickUpSceneV2");
            this.mOnServiceController.stopModifyPickupLocation((LatLng) null);
        }
    }

    /* access modifiers changed from: protected */
    public ServingParam getServingParam(CarOrder carOrder, long j, int i) {
        ServingParam servingParam = super.getServingParam(carOrder, j, i, true);
        if (servingParam != null) {
            return new ServingParam(servingParam.getBuilder().isNewVersion(true));
        }
        return null;
    }

    /* renamed from: a */
    private void m10044a(Address address, Address address2) {
        CarOrder order;
        if (address != null && (order = CarOrderHelper.getOrder()) != null) {
            ServingParam servingParam = getServingParam(order, this.mWaitForArrivalNewSctxRequestInterval, 0);
            if (servingParam == null) {
                GLog.m7965d("修改上车点", "param == null");
                return;
            }
            HashMap<MapElementId, CommonMarkerParam> markerParams = servingParam.getMarkerParams();
            CommonMarkerParam markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_WAYPOINT);
            if (markerParam != null) {
                markerParam.setMarkerIconResId(R.drawable.waypoint_map_icon_stop_point);
                int interlinkOrderPerceptionGroupNo = GlobalApolloUtil.getInterlinkOrderPerceptionGroupNo();
                if (interlinkOrderPerceptionGroupNo == 1 || interlinkOrderPerceptionGroupNo == 2 || interlinkOrderPerceptionGroupNo == 3) {
                    markerParam.setAddressName(ResourcesHelper.getString(this.mContext, R.string.map_flow_finishing_last_trip_tips));
                    markerParam.setAddressNameColorResId(R.color.black);
                }
            }
            CommonMarkerParam markerParam2 = servingParam.getMarkerParam(MapElementId.ID_MARKER_ODPOINT);
            if (markerParam2 == null) {
                CommonMarkerParam.Builder builder = new CommonMarkerParam.Builder();
                builder.mo75597id(MapElementId.ID_MARKER_ODPOINT);
                builder.markerIconResId(R.drawable.waypoint_map_icon_stop_point);
                CommonMarkerParam commonMarkerParam = new CommonMarkerParam(builder);
                if (markerParams != null) {
                    markerParams.put(MapElementId.ID_MARKER_ODPOINT, commonMarkerParam);
                }
            } else {
                markerParam2.setMarkerIconResId(R.drawable.waypoint_map_icon_stop_point);
            }
            this.mOnServiceController = transformToWaitingForDrivingScene(servingParam);
            this.mOnServiceController.doBestView(getCurrentPadding());
            new LatLng(address.latitude, address.longitude);
            if (this.mOnServiceController != null) {
                this.mOnServiceController.startModifyPickupLocation(address, address2, 200.0f, this.f14364b);
            }
            this.mCurrentScene = 2;
            GLog.m7965d("修改上车点", "enterUpdatePickUpSceneV2");
        }
    }

    /* access modifiers changed from: protected */
    public Drawable getServingParamPickUpIcon() {
        return ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_pick_up);
    }

    /* access modifiers changed from: protected */
    public void leaveSugPage() {
        this.f14365c.info("ConfirmMapFlowDelegateUpdateAddressNewPresenter leaveSugPage..", new Object[0]);
        BaseEventPublisher.getPublisher().publish("event_hide_sug_page_container");
        this.mPopSugSceneController = null;
        AbsConfirmConfigState.isInSugPage = false;
        m10046b();
        Address departureAddress = FormStore.getInstance().getDepartureAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (departureAddress != null) {
            m10044a(departureAddress, endAddress);
            return;
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            m10044a(order.startAddress, order.endAddress);
        }
    }

    /* access modifiers changed from: protected */
    public void requestUpdatePickUpWithConfirm(Address address) {
        FormStore.getInstance().setDepartureAddress(address);
        DepartureAddress departureAddress = new DepartureAddress();
        departureAddress.setAddress(address);
        doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS, departureAddress);
        doPublish(BaseEventKeys.OnService.EVENT_ONSERVICE_PIN_CHANGED_OUT_OF_AREA, address);
        if (this.mPopSugSceneController != null) {
            this.mPopSugSceneController.closeSugSession();
        }
    }

    /* access modifiers changed from: protected */
    public void enterSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        m10046b();
        super.enterSugPageScene(i, address, fromType, iSugSceneCallback);
    }

    /* access modifiers changed from: protected */
    public void goBack() {
        CarOrder order;
        if (!(this.mOnServiceController == null || (order = CarOrderHelper.getOrder()) == null || order.startAddress == null)) {
            GLog.m7965d("修改上车点", "stopModifyPickupLocation");
            this.mOnServiceController.stopModifyPickupLocation(new LatLng(order.startAddress.latitude, order.startAddress.longitude));
        }
        super.goBack();
    }
}
