package com.didi.unifiedPay.component.presenter.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.didi.unifiedPay.UnifiedPaySystem;
import com.didi.unifiedPay.component.AbsUnifiedPaymentPresenter;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.manager.PayTranceEventManager;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.presenter.PayWindowManager;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.PayBizType;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.model.PayInfo;

public abstract class NonTripUnifiedPaymetPresenter extends AbsUnifiedPaymentPresenter {
    public static final String PAY_PARAM = "pay_param";

    /* renamed from: a */
    private String f44380a;

    /* access modifiers changed from: protected */
    public int getBid() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        return "0";
    }

    public NonTripUnifiedPaymetPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
    }

    public void onAdd(Bundle bundle) {
        ((IPayView) this.mView).setBizType(PayBizType.BIZ_NON_TRIP);
        PayParam payParam = (PayParam) bundle.getSerializable("pay_param");
        if (payParam != null) {
            payParam.bid = getBid();
            this.mUnifiedPaySystem = UnifiedPaySystem.createUnifiedPay(this.mContext, PayConstant.PayBillType.NoneTrip);
            this.mEventManager = new PayTranceEventManager(this.mContext, getOrderId(), getBid());
            this.mWindowManager = new PayWindowManager((IPayView) this.mView, this, this.mContext, getOrderId(), getBid());
            this.mUnifiedPaySystem.setPayParam(payParam);
            this.mUnifiedPaySystem.init(payParam.bid, getOrderId(), this.mFragmentManager);
            prepareData();
        }
    }

    /* access modifiers changed from: protected */
    public void setupView(PayInfo payInfo) {
        super.setupView(payInfo);
        ((IPayView) this.mView).setCancelableForThirdPay(false);
    }

    public String getWxAppid() {
        String str = this.f44380a;
        return str != null ? str : "";
    }
}
