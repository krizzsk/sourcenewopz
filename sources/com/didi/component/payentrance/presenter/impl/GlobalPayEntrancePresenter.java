package com.didi.component.payentrance.presenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.payentrance.activity.confirmfare.ConfirmFareActivity;
import com.didi.component.payentrance.presenter.AbsUnifiedPayEntrancePresenter;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.component.payentrance.view.Mode;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class GlobalPayEntrancePresenter extends AbsUnifiedPayEntrancePresenter implements IPayEntranceView.OnBindCardClickListener {

    /* renamed from: a */
    private static final String f14957a = GlobalPayEntrancePresenter.class.getSimpleName();

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener f14958b = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TextUtils.equals(BaseEventKeys.Pay.CATEGORY, str) && TextUtils.equals(BaseEventKeys.Pay.EVENT_PAYENTANCE_REFRESH, str2)) {
                GlobalPayEntrancePresenter.this.refreshOrderBill();
            }
        }
    };

    /* renamed from: c */
    private boolean f14959c = false;

    public GlobalPayEntrancePresenter(ComponentParams componentParams) {
        super("", componentParams, ((FragmentActivity) componentParams.bizCtx.getContext()).getSupportFragmentManager(), componentParams.extras);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        bundle.putBoolean("KEY_RETURN_FROM_PAYVIEW", true);
        super.onAdd(bundle);
        m10754c();
        GlobalOmegaUtils.trackEvent("gp_endtrip_evaluate_sw");
    }

    /* access modifiers changed from: protected */
    public void handlePayInfo(BasicPayInfo basicPayInfo) {
        if (basicPayInfo != null && basicPayInfo.payStatus == 6) {
            doPublish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
        }
        this.mBasicPayInfo = basicPayInfo;
        if (this.mBasicPayInfo == null) {
            ((IPayEntranceViewContainer) this.mView).showError((CharSequence) null);
            return;
        }
        if (!handleBlockStep(this.mBasicPayInfo)) {
            handlePayState(basicPayInfo);
        }
        doPublish(BaseEventKeys.Service.EndService.EVENT_BASIC_PAY_INFO, basicPayInfo);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_XPANEL_SCROLL_TOP_EVENT);
            }
        }, 300);
    }

    /* access modifiers changed from: protected */
    public boolean handleBlockStep(BasicPayInfo basicPayInfo) {
        ((IPayEntranceViewContainer) this.mView).showBindCard(false);
        if (basicPayInfo.payStatus != 6 || basicPayInfo.riskInfo == null) {
            int i = basicPayInfo.blockType;
            if (i != 2) {
                if (i != 3) {
                    if (i != 5 || basicPayInfo.statusMsg == null) {
                        return false;
                    }
                    m10753b(basicPayInfo);
                } else if (basicPayInfo.confirmInfo == null) {
                    return false;
                } else {
                    if (!this.f14959c) {
                        this.f14959c = true;
                        Intent intent = new Intent(this.mContext, ConfirmFareActivity.class);
                        intent.putExtra(AbsUnifiedPayEntrancePresenter.EXTRA_PIN_ERR_KEY, basicPayInfo.confirmInfo);
                        if (basicPayInfo.billBasic != null) {
                            intent.putExtra(AbsUnifiedPayEntrancePresenter.EXTRA_PIN_CURRENCY_KEY, basicPayInfo.billBasic.currencySymbol);
                        }
                        startActivityForResult(intent, 101);
                    }
                }
            } else if (basicPayInfo.riskInfo == null) {
                return false;
            } else {
                m10750a(basicPayInfo);
            }
            return true;
        }
        m10750a(basicPayInfo);
        return true;
    }

    /* renamed from: a */
    private void m10750a(BasicPayInfo basicPayInfo) {
        if (basicPayInfo == null || basicPayInfo.billBasic == null) {
            GLog.m7968e(f14957a, "payInfo or payInfo.billBasic  ==null");
            return;
        }
        m10751a(false);
        BasicBill basicBill = basicPayInfo.billBasic;
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.RISKVIEW);
        ((IPayEntranceViewContainer) this.mView).setActionButtonEnable(false);
        doPublish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
        if (basicPayInfo.riskInfo != null && !TextUtil.isEmpty(basicPayInfo.riskInfo.riskMessage)) {
            ((IPayEntranceViewContainer) this.mView).setFeeDescribe(UnipayTextUtil.handleString(basicPayInfo.riskInfo.riskMessage));
        } else if (!TextUtil.isEmpty(basicBill.billText)) {
            ((IPayEntranceViewContainer) this.mView).setFeeDescribe(UnipayTextUtil.handleString(basicBill.billText));
        } else if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().couponInfo == null || TextUtils.isEmpty(CarOrderHelper.getOrder().couponInfo.couponText))) {
            ((IPayEntranceViewContainer) this.mView).setFeeDescribe(CarOrderHelper.getOrder().couponInfo.couponText);
        }
        m10749a(basicBill);
        setMessage(basicBill);
        addJumpable(basicBill);
        if (isFeeObjection()) {
            ((IPayEntranceViewContainer) this.mView).setActionText(this.mContext.getString(R.string.pe_car_pay_entrance_title));
        } else {
            ((IPayEntranceViewContainer) this.mView).setActionText(this.mContext.getString(R.string.pe_car_pay_entrance_title_4cancel));
        }
    }

    /* renamed from: a */
    private void m10751a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SchemeDispatcherImpl.HOST_PAY, Integer.valueOf(z ? 1 : 2));
        GlobalOmegaUtils.trackEvent("Brazil_endTrip_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m10753b(BasicPayInfo basicPayInfo) {
        if (basicPayInfo == null || basicPayInfo.billBasic == null) {
            GLog.m7968e(f14957a, "payInfo or payInfo.billBasic  ==null");
            return;
        }
        BasicBill basicBill = basicPayInfo.billBasic;
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.FinishPay);
        m10749a(basicBill);
        ((IPayEntranceViewContainer) this.mView).setMessage(basicPayInfo.statusMsg);
        ((IPayEntranceViewContainer) this.mView).setOnBindCardClickListener(this);
        ((IPayEntranceViewContainer) this.mView).showBindCard(true);
        addJumpable(basicBill);
    }

    /* renamed from: a */
    private void m10749a(BasicBill basicBill) {
        String str = "";
        if (!TextUtils.isEmpty(basicBill.leftDes)) {
            str = str + basicBill.leftDes + " ";
        }
        if (!TextUtil.isEmpty(basicBill.totalFeeText)) {
            str = str + basicBill.totalFeeText;
        }
        if (!TextUtil.isEmpty(basicBill.rightDes)) {
            str = str + basicBill.rightDes;
        }
        ((IPayEntranceViewContainer) this.mView).setPrice(str);
    }

    /* renamed from: c */
    private void m10754c() {
        subscribe(BaseEventKeys.Pay.CATEGORY, this.f14958b);
    }

    /* renamed from: d */
    private void m10756d() {
        unsubscribe(BaseEventKeys.Pay.CATEGORY, this.f14958b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        m10756d();
        super.onRemove();
    }

    public void onPayClick(Mode mode, double d, double d2) {
        if (!checkObjection()) {
            doPublish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, new ComponentWrap("payment"));
        }
        String str = f14957a;
        SystemUtils.log(3, str, "onPayBtnClick totalFee:" + d + " onePrice:" + d2, (Throwable) null, "com.didi.component.payentrance.presenter.impl.GlobalPayEntrancePresenter", 262);
        GlobalOmegaUtils.trackEvent("gp_endtrip_evaluate_ck");
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
        return order != null ? order.oid : "";
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), 103, addCardParam);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        super.onActivityResult(i, i2, intent);
        if (intent != null && (extras = intent.getExtras()) != null && 101 == i) {
            this.f14959c = false;
            if (i2 == -1) {
                int i3 = extras.getInt(AbsUnifiedPayEntrancePresenter.EXTRA_CONFIRM_RESULT_KEY);
                ((IPayEntranceViewContainer) this.mView).showLoading();
                if (i3 == 1) {
                    this.mUnifiedPaySystem.billConfirm(1, new ConfirmBillCallBack(1));
                } else {
                    this.mUnifiedPaySystem.billConfirm(2, new ConfirmBillCallBack(2));
                }
            }
        }
    }

    class ConfirmBillCallBack implements PayServiceCallback<Object> {
        private int actionType;

        public ConfirmBillCallBack(int i) {
            this.actionType = i;
        }

        public void onSuccess(Object obj) {
            ((IPayEntranceViewContainer) GlobalPayEntrancePresenter.this.mView).hideLoading();
            if (this.actionType == 1) {
                GlobalPayEntrancePresenter.this.goPayPage();
            } else {
                GlobalPayEntrancePresenter.this.refreshOrderBill();
            }
        }

        public void onFail(Error error) {
            ((IPayEntranceViewContainer) GlobalPayEntrancePresenter.this.mView).showError(error.msg);
        }
    }
}
