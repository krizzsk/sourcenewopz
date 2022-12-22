package com.didi.component.payway.anycar.presenter;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;

public class AnyCarPayWayHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayMethodSelectAdapter f15113a = new PayMethodAdapterImpl();

    /* renamed from: b */
    private final BaseEventPublisher.OnEventListener<Boolean> f15114b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (AnyCarPayWayHelper.this.f15113a != null) {
                AnyCarPayModel anyCarPayModel = null;
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    anyCarPayModel = confirmListener.getAnycarPayModel();
                }
                if (anyCarPayModel == null || anyCarPayModel.payWayList == null || anyCarPayModel.payWayList.size() == 0) {
                    AnyCarPayWayHelper.this.f15113a.notifyRefreshFailed();
                } else {
                    DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                    payMethodListParam.list = DateConverUtils.converPayMethodInfoList(anyCarPayModel.payWayList);
                    payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(anyCarPayModel.carPayGroupInfo);
                    payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(anyCarPayModel.payCfgInfo);
                    AnyCarPayWayHelper.this.f15113a.notifyRefreshSuccess(payMethodListParam);
                }
            }
            AnyCarPayWayHelper.this.m10798b();
        }
    };

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15115c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f15113a != null) {
                AnyCarPayWayHelper.this.f15113a.notifyRefreshFailed();
            }
            AnyCarPayWayHelper.this.m10798b();
        }
    };

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15116d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f15113a != null) {
                AnyCarPayWayHelper.this.f15113a.notifyRefreshFailed();
            }
            AnyCarPayWayHelper.this.m10798b();
        }
    };

    /* renamed from: e */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15117e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f15113a != null) {
                AnyCarPayWayHelper.this.f15113a.notifyRefreshFinished();
            }
            AnyCarPayWayHelper.this.m10798b();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam> f15118f = new BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam>() {
        public void onEvent(String str, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
            if (AnyCarPayWayHelper.this.f15113a != null) {
                AnyCarPayWayHelper.this.f15113a.notifyRefreshSuccess(payMethodListParam);
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, AnyCarPayWayHelper.this.f15118f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, AnyCarPayWayHelper.this.f15119g);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15119g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f15113a != null) {
                AnyCarPayWayHelper.this.f15113a.notifyRefreshFailed();
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, AnyCarPayWayHelper.this.f15118f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, AnyCarPayWayHelper.this.f15119g);
        }
    };

    public PayMethodSelectAdapter getPayMethodAdapter() {
        return this.f15113a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10797a() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f15114b);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f15115c);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f15116d);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f15117e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10798b() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f15114b);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f15115c);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f15116d);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f15117e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10801c() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, this.f15118f);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, this.f15119g);
    }

    class PayMethodAdapterImpl extends PayMethodSelectAdapter {
        PayMethodAdapterImpl() {
        }

        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
            if (entrance == DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE) {
                AnyCarPayWayHelper.this.m10801c();
            } else {
                AnyCarPayWayHelper.this.m10797a();
            }
        }
    }
}
