package com.didi.component.confirmbroadingpoint.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.FireBaseEventUtils;
import com.didi.component.confirmbroadingpoint.AbsConfirmBroadingPointPresenter;
import com.didi.component.confirmbroadingpoint.IConfirmBroadingPointView;
import com.didi.component.confirmbroadingpoint.impl.view.StartDestConfirmCard;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.estimate.CarExtraLogModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.StartEndCardModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmGetOnPresenter extends AbsConfirmBroadingPointPresenter {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public StartDestConfirmCard f12646k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public StartEndCardModel f12647l;

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<View> f12648m = new BaseEventPublisher.OnEventListener<View>() {
        public void onEvent(String str, View view) {
            if (view != null) {
                ((IConfirmBroadingPointView) ConfirmGetOnPresenter.this.mView).setNormalVisible(0);
                ((IConfirmBroadingPointView) ConfirmGetOnPresenter.this.mView).setNormalCardView(view);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(((IConfirmBroadingPointView) ConfirmGetOnPresenter.this.mView).getView().getMeasuredHeight()));
            }
        }
    };

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener<StartEndCardModel> f12649n = new BaseEventPublisher.OnEventListener<StartEndCardModel>() {
        public void onEvent(String str, StartEndCardModel startEndCardModel) {
            StartDestConfirmCard unused = ConfirmGetOnPresenter.this.f12646k = new StartDestConfirmCard(ConfirmGetOnPresenter.this.mContext);
            StartEndCardModel unused2 = ConfirmGetOnPresenter.this.f12647l = startEndCardModel;
            ConfirmGetOnPresenter.this.f12646k.setConfirmBtnClickLis(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER);
                    ConfirmGetOnPresenter.this.trackSubmit();
                }
            });
            ConfirmGetOnPresenter.this.f12646k.bindData(startEndCardModel);
            ((IConfirmBroadingPointView) ConfirmGetOnPresenter.this.mView).setNormalVisible(0);
            ((IConfirmBroadingPointView) ConfirmGetOnPresenter.this.mView).setNormalCardView(ConfirmGetOnPresenter.this.f12646k);
        }
    };

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12650p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (ConfirmGetOnPresenter.this.f12646k != null) {
                ConfirmGetOnPresenter.this.f12646k.hideLoading();
            }
        }
    };

    /* renamed from: q */
    private long f12651q;

    public ConfirmGetOnPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onConfirmClicked() {
        super.onConfirmClicked();
        FormStore instance = FormStore.getInstance();
        if (instance.getDepartureAddress() != null) {
            instance.setStartAddress(instance.getDepartureAddress(), false);
        }
        trackSubmit();
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER);
    }

    /* access modifiers changed from: protected */
    public void trackSubmit() {
        int i;
        String str;
        FormStore instance = FormStore.getInstance();
        Address startAddress = instance.getStartAddress();
        Address endAddress = instance.getEndAddress();
        EstimateItem estimateItem = instance.getEstimateItem();
        String payWayMsg = instance.getPayWayMsg();
        int carLevel = instance.getCarLevel();
        long transportTime = instance.getTransportTime();
        HashMap hashMap = new HashMap();
        if (startAddress != null) {
            hashMap.put("from_addr", !TextUtils.isEmpty(startAddress.address) ? startAddress.address : startAddress.displayName);
            hashMap.put("from_lng", Double.valueOf(startAddress.longitude));
            hashMap.put("from_lat", Double.valueOf(startAddress.latitude));
            hashMap.put("from_poi_id", startAddress.poiId);
            hashMap.put("from_search_id", startAddress.searchId);
            hashMap.put("from_srctag", startAddress.getSrcTag());
        }
        if (endAddress != null) {
            hashMap.put("to_addr", !TextUtils.isEmpty(endAddress.address) ? endAddress.address : endAddress.displayName);
            hashMap.put("to_lng", Double.valueOf(endAddress.longitude));
            hashMap.put("to_lat", Double.valueOf(endAddress.latitude));
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId);
            hashMap.put("to_search_id", endAddress.searchId == null ? "" : endAddress.searchId);
            hashMap.put("to_srctag", endAddress.getSrcTag());
        }
        int i2 = 1;
        hashMap.put("is_reservation", Integer.valueOf(transportTime > 0 ? 1 : 0));
        hashMap.put(ParamKeys.PARAM_MODE, instance.Sid);
        hashMap.put("cartype", Integer.valueOf(carLevel));
        hashMap.put("payment", payWayMsg);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("dynamic", 0);
            hashMap.put("has_surgedprice", 1);
            hashMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
            hashMap.put("has_tips", 0);
        }
        float f = 0.0f;
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null || newEstimateItem.carConfig.extraData.getExtraLog() == null)) {
            CarExtraLogModel extraLog = newEstimateItem.carConfig.extraData.getExtraLog();
            if (!TextUtils.isEmpty(extraLog.originFee)) {
                try {
                    f = Float.parseFloat(extraLog.originFee);
                } catch (Exception unused) {
                }
            }
        }
        if (newEstimateItem != null) {
            hashMap.put("origin_fee", Float.valueOf(f));
            hashMap.put("bubble_id", newEstimateItem.estimateId);
            hashMap.put("price_estimated", Float.valueOf(newEstimateItem.feeNumber));
        }
        hashMap.put("business_id", BusinessDataUtil.getProductId());
        List<PayWayModel.PayWayItem> payWaySelectedItem = FormStore.getInstance().getPayWaySelectedItem();
        if (payWaySelectedItem == null || payWaySelectedItem.size() <= 0) {
            i = 0;
        } else {
            i = 0;
            for (PayWayModel.PayWayItem payWayItem : payWaySelectedItem) {
                i |= payWayItem.tag;
            }
        }
        hashMap.put("paytype", Integer.valueOf(i));
        hashMap.put("eta", Integer.valueOf(instance.getEta()));
        assembleEstimateData(hashMap, estimateItem);
        hashMap.put("editaddr", Integer.valueOf((FormStore.getInstance().hasChangeAddressType(1) || FormStore.getInstance().hasChangeAddressType(2)) ? 1 : 0));
        TaxiCompanyListModel.CompanyModel curCompany = instance.getCurCompany();
        if (curCompany != null) {
            if ("0".equals(curCompany.f44227id)) {
                str = "All";
            } else {
                str = "1".equals(curCompany.f44227id) ? "nopickupfeegroup" : curCompany.f44227id;
            }
            hashMap.put("CompanyChoice", str);
        }
        EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem2 == null || newEstimateItem2.carConfig == null || newEstimateItem2.carConfig.guideType == null)) {
            hashMap.put(ParamKeys.PARAM_GUIDE_TYPE, newEstimateItem2.carConfig.guideType.toString());
        }
        if (FormStore.getInstance().getTransportTime() == 0) {
            i2 = 0;
        }
        hashMap.put("order_type", Integer.valueOf(i2));
        StartEndCardModel startEndCardModel = this.f12647l;
        if (startEndCardModel != null && !CollectionUtils.isEmpty((Map) startEndCardModel.extraLogData)) {
            hashMap.putAll(this.f12647l.extraLogData);
        }
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_submit_ck", (Map<String, Object>) hashMap);
        FireBaseEventUtils.traceEvent("pas_orderconfirm_submit_ck", false);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFORM_GET_ON_SHOW_NORMAL, this.f12648m);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, this.f12649n);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFORM_HIDE_START_END_LOADING, this.f12650p);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.f12651q = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        this.f12651q = System.currentTimeMillis() - this.f12651q;
        HashMap hashMap = new HashMap();
        hashMap.put("time", Long.valueOf(this.f12651q));
        GlobalOmegaUtils.trackEvent("ibt_gp_pickupconfirm_time_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFORM_GET_ON_SHOW_NORMAL, this.f12648m);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, this.f12649n);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFORM_HIDE_START_END_LOADING, this.f12650p);
    }
}
