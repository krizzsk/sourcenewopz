package com.didi.component.confirmupdateaddress.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.address.model.WayPoint;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmAddressListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.confirmupdateaddress.util.ConfirmGuideUtil;
import com.didi.component.confirmupdateaddress.view.IConfirmUpdateAddress;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmUpdateAddressPresenter extends IPresenter<IConfirmUpdateAddress> implements IConfirmUpdateAddress.IPresenterCallback {

    /* renamed from: a */
    private final BusinessContext f12698a;

    /* renamed from: b */
    private long f12699b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<SugResult> f12700c = new BaseEventPublisher.OnEventListener<SugResult>() {
        public void onEvent(String str, SugResult sugResult) {
            if (sugResult != null) {
                Address address = sugResult.start;
                Address address2 = sugResult.end;
                if (address != null && !TextUtils.isEmpty(address.getDisplayName())) {
                    ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setPickUpText(address.getDisplayName());
                }
                if (address2 != null && !TextUtils.isEmpty(address2.getDisplayName())) {
                    ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setDestinationText(address2.getDisplayName());
                }
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Integer> f12701d = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (ConfirmUpdateAddressPresenter.this.mView != null) {
                ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setVisible(num.intValue());
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<Object> f12702e = new BaseEventPublisher.OnEventListener<Object>() {
        public void onEvent(String str, Object obj) {
            List<WayPoint> list;
            Address address;
            Address address2;
            if (obj != null && (list = (List) obj) != null && list.size() > 0) {
                for (WayPoint wayPoint : list) {
                    if (wayPoint.getWayPointType() == 1 && (address2 = wayPoint.getAddress()) != null && !TextUtils.isEmpty(address2.getDisplayName())) {
                        ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setPickUpText(address2.getDisplayName());
                    }
                    if (wayPoint.getWayPointType() == 3 && (address = wayPoint.getAddress()) != null && !TextUtils.isEmpty(address.getDisplayName())) {
                        ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setDestinationText(address.getDisplayName());
                    }
                }
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12703f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Address startAddress = FormStore.getInstance().getStartAddress();
            if (startAddress == null || TextUtils.isEmpty(startAddress.getDisplayName())) {
                ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setPickUpText(ResourcesHelper.getString(ConfirmUpdateAddressPresenter.this.mContext, R.string.map_flow_current_location));
            } else {
                ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setPickUpText(startAddress.getDisplayName());
            }
            Address endAddress = FormStore.getInstance().getEndAddress();
            if (endAddress != null) {
                ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setDestinationText(endAddress.getDisplayName());
            }
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<String> f12704g = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).setPickUpText(str2);
            }
        }
    };

    /* renamed from: h */
    private final ConfirmAddressListener f12705h = new ConfirmAddressListener() {
        public void updateAlpha(float f) {
            if (ConfirmUpdateAddressPresenter.this.mView != null) {
                ((IConfirmUpdateAddress) ConfirmUpdateAddressPresenter.this.mView).updateAlpha(f);
            }
        }
    };

    public ConfirmUpdateAddressPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f12698a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Map.EVENT_CONFIRM_PAGE_RESULT_CALLBACK, this.f12700c);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, this.f12701d);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED, this.f12702e);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f12703f);
        subscribe(BaseEventKeys.Map.EVENT_ESTIMATE_UPDATE_GUESS_DESTINATION_START, this.f12704g);
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().addConfirmAddressObserver(this.f12705h);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Map.EVENT_CONFIRM_PAGE_RESULT_CALLBACK, this.f12700c);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, this.f12701d);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED);
        unsubscribe(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED, this.f12702e);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f12703f);
        unsubscribe(BaseEventKeys.Map.EVENT_ESTIMATE_UPDATE_GUESS_DESTINATION_START, this.f12704g);
    }

    public void onChangeClick() {
        hideGuide();
        if (FormStore.getInstance().isFromOpenRide()) {
            doPublish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_CHANGE_ADDRESS_SHOW_SUG, 2);
        } else if (FormStore.getInstance().hasStopPoints()) {
            doPublish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_CHANGE_ADDRESS_SHOW_SUG, 6);
        } else {
            doPublish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_CHANGE_ADDRESS_SHOW_SUG, 1);
        }
        m8640b();
    }

    /* renamed from: b */
    private void m8640b() {
        HashMap hashMap = new HashMap();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            if (newEstimateItem.carConfig != null) {
                hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
            }
            hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
        }
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress != null) {
            hashMap.put("from_lat", Double.valueOf(startAddress.latitude));
            hashMap.put("from_lng", Double.valueOf(startAddress.longitude));
            hashMap.put("from_addr", !TextUtils.isEmpty(startAddress.address) ? startAddress.address : startAddress.displayName);
            hashMap.put("from_srctag", startAddress.srcTag);
            hashMap.put("from_poi_id", startAddress.poiId);
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (endAddress != null) {
            hashMap.put("to_lat", Double.valueOf(endAddress.latitude));
            hashMap.put("to_lng", Double.valueOf(endAddress.longitude));
            hashMap.put("to_addr", !TextUtils.isEmpty(endAddress.address) ? endAddress.address : endAddress.displayName);
            hashMap.put("to_srctag", endAddress.srcTag);
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId);
        }
        hashMap.put("type", "change");
        GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_change_ck", (Map<String, Object>) hashMap);
    }

    public void hideGuide() {
        if (this.mView != null) {
            ConfirmGuideUtil.INSTANCE.setShowEditGuideOnConfirm(this.mContext, true);
            ((IConfirmUpdateAddress) this.mView).hideGuide();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.f12699b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        m8642c();
    }

    /* renamed from: c */
    private void m8642c() {
        this.f12699b = System.currentTimeMillis() - this.f12699b;
        HashMap hashMap = new HashMap();
        hashMap.put("time", Long.valueOf(this.f12699b));
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "staytime");
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_time_sw", (Map<String, Object>) hashMap);
    }
}
