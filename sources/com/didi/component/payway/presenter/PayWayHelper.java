package com.didi.component.payway.presenter;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.travel.psnger.model.response.EstimateItem;

public class PayWayHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayMethodSelectAdapter f15167a = new PayMethodAdapterImpl();

    /* renamed from: b */
    private final BaseEventPublisher.OnEventListener<Boolean> f15168b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (PayWayHelper.this.f15167a != null) {
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (estimateItem == null || estimateItem.payWayList == null || estimateItem.payWayList.size() == 0) {
                    PayWayHelper.this.f15167a.notifyRefreshFailed();
                } else {
                    DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                    payMethodListParam.list = DateConverUtils.converPayMethodInfoList(estimateItem.payWayList);
                    payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(estimateItem.payGroupList);
                    payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(estimateItem.payCfgInfo);
                    PayWayHelper.this.f15167a.notifyRefreshSuccess(payMethodListParam);
                }
            }
            PayWayHelper.this.m10854b();
        }
    };

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15169c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f15167a != null) {
                PayWayHelper.this.f15167a.notifyRefreshFailed();
            }
            PayWayHelper.this.m10854b();
        }
    };

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15170d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f15167a != null) {
                PayWayHelper.this.f15167a.notifyRefreshFailed();
            }
            PayWayHelper.this.m10854b();
        }
    };

    /* renamed from: e */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15171e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f15167a != null) {
                PayWayHelper.this.f15167a.notifyRefreshFinished();
            }
            PayWayHelper.this.m10854b();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam> f15172f = new BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam>() {
        public void onEvent(String str, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
            if (PayWayHelper.this.f15167a != null) {
                PayWayHelper.this.f15167a.notifyRefreshSuccess(payMethodListParam);
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, PayWayHelper.this.f15172f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, PayWayHelper.this.f15173g);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15173g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f15167a != null) {
                PayWayHelper.this.f15167a.notifyRefreshFailed();
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, PayWayHelper.this.f15172f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, PayWayHelper.this.f15173g);
        }
    };

    public PayMethodSelectAdapter getPayMethodAdapter() {
        return this.f15167a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10853a() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f15168b);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f15169c);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f15170d);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f15171e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10854b() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f15168b);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f15169c);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f15170d);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f15171e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10857c() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, this.f15172f);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, this.f15173g);
    }

    class PayMethodAdapterImpl extends PayMethodSelectAdapter {
        PayMethodAdapterImpl() {
        }

        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
            if (entrance == DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE) {
                PayWayHelper.this.m10857c();
            } else {
                PayWayHelper.this.m10853a();
            }
        }
    }
}
