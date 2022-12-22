package com.didi.component.payment.presenter.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.DDCreditParam;
import com.didi.unifiedPay.component.model.PayState;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PaySuccessMessage;
import com.didiglobal.ddmirror.reporter.MReporter;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.presenter.GlobalAbsPaymentPresenter;
import java.util.Map;

public class GlobalPaymentPresenter extends GlobalAbsPaymentPresenter {

    /* renamed from: a */
    private static final String f15102a = GlobalPaymentPresenter.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f15103b = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private UniPayManager f15104c = new UniPayManager();

    /* renamed from: d */
    private boolean f15105d = false;

    /* access modifiers changed from: protected */
    public void gotoCostObjectionActivity(PayInfo payInfo, int i) {
    }

    /* access modifiers changed from: protected */
    public void gotoDDCreditSignActivity(DDCreditParam dDCreditParam, int i) {
    }

    public GlobalPaymentPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f15104c.registerPushListener(this.mContext, f15102a);
        boolean z = false;
        if (bundle.getInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 0) == 2) {
            z = true;
        }
        this.f15105d = z;
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        if (this.mCurrentState != PayState.PaySuccess) {
            ((IGlobalPayView) this.mView).hideLoadingPop(true);
        }
        if (z) {
            int i2 = payInfo.payStatus;
            m10790a(i2);
            if (i2 == 6) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
            } else {
                super.requestPayInfoResult(z, payInfo, str, i);
            }
        } else {
            GLog.m7965d(f15102a, "getPayinfo接口获取失败，展示errorview");
            ((IGlobalPayView) this.mView).setTitle(true, this.mContext.getResources().getString(R.string.pay_fail), str);
            showRetryView();
        }
    }

    /* renamed from: a */
    private void m10790a(int i) {
        if (i != 3 && i != 5 && i != 7) {
            CarNotifyManager.autoPayFailNotification(this.mContext);
        }
    }

    public void onPaySuccessMessageCreated(PaySuccessMessage paySuccessMessage) {
        CarOrder order;
        super.onPaySuccessMessageCreated(paySuccessMessage);
        if (paySuccessMessage != null && paySuccessMessage.voucherValue > 0 && (order = CarOrderHelper.getOrder()) != null && order.payResult != null) {
            order.payResult.actual_deduction = String.valueOf(paySuccessMessage.voucherValue / 100);
        }
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        this.f15103b.info(" onPaySuccessed", new Object[0]);
        PayState payState = this.mCurrentState;
        super.onPaySuccessed(i, str);
        if (payState != PayState.PaySuccess && this.mCurrentState == PayState.PaySuccess) {
            m10789a();
        }
    }

    /* renamed from: a */
    private void m10789a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (GlobalPaymentPresenter.this.mView != null) {
                    ((IGlobalPayView) GlobalPaymentPresenter.this.mView).hideLoadingPop(false);
                }
                GlobalPaymentPresenter.this.f15103b.info("lmf >>>sendPaySuccessedEvent>>", new Object[0]);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_SUCCESS);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, "payment");
                if (!BusinessDataUtil.isCancelOrder(CarOrderHelper.getOrder())) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EndService.CATEGORY, BaseEventKeys.Service.EndService.EVENT_SHOW_EVALUATE);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYENTANCE_REFRESH);
                }
            }
        }, 1000);
    }

    /* access modifiers changed from: protected */
    public void onPrePayFailed(int i, String str) {
        GLog.m7965d(f15102a, "onPrePayFailed");
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        super.onPrePayFailed(i, str);
        MReporter.Companion.reportError("pay_error", 2, str, i, "", "prePay", (Map<String, Object>) null);
    }

    public void onPayFailed(PayError payError, String str) {
        String str2 = f15102a;
        GLog.m7965d(str2, "onPayFailed" + payError.errorCode);
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        int i = payError.errorCode;
        if (i == 3) {
            String str3 = f15102a;
            GLog.m7965d(str3, "onPayFailed isPayMentShow:" + this.f15105d);
            if (this.f15105d) {
                m10792b();
                this.f15105d = false;
            } else {
                super.onPayFailed(payError, str);
            }
        } else if (i != 500101) {
            super.onPayFailed(payError, str);
        } else {
            ((IGlobalPayView) this.mView).setTitle(true, this.mContext.getResources().getString(R.string.pay_fail), str);
        }
        MReporter.Companion.reportError("pay_error", 2, str, payError.errorCode, "", "pollingQueryPayStatus", (Map<String, Object>) null);
    }

    /* renamed from: b */
    private void m10792b() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, "payment");
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_WAIT);
    }

    public void onRemove() {
        super.onRemove();
        this.f15104c.unregisterPushListener();
        if (this.mView != null) {
            ((IGlobalPayView) this.mView).hideLoadingPop(false);
        }
    }

    public void onShowFeeDetailClick() {
        if (GlobalApolloUtil.isH5CovertToNative()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_DETAIL);
        } else {
            super.onShowFeeDetailClick();
        }
    }

    /* access modifiers changed from: protected */
    public void onViewFilled() {
        GLog.m7965d(f15102a, "onViewFilled");
    }

    public boolean onClose() {
        super.onClose();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, "payment");
        if (BusinessDataUtil.isCancelOrder(CarOrderHelper.getOrder())) {
            return false;
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EndService.CATEGORY, BaseEventKeys.Service.EndService.EVENT_SHOW_ORDER_DETAIL);
        return false;
    }

    /* access modifiers changed from: protected */
    public int getBid() {
        try {
            return Integer.parseInt(BusinessDataUtil.getProductId());
        } catch (Exception unused) {
            return 256;
        }
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        CarOrder order = CarOrderHelper.getOrder();
        StringBuilder sb = new StringBuilder();
        sb.append("oid:");
        sb.append(order == null ? "CarOrder is Null" : TextUtils.isEmpty(order.oid) ? "oid is Null" : order.oid);
        SystemUtils.log(6, "OidNullCheck", sb.toString(), new Exception(), "com.didi.component.payment.presenter.impl.GlobalPaymentPresenter", 244);
        return order != null ? order.oid : "";
    }
}
