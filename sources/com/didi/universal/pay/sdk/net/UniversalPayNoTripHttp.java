package com.didi.universal.pay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.net.api.nontrip.NonTripGetPayInfo;
import com.didi.universal.pay.sdk.net.api.trip.ChangePayInfo;
import com.didi.universal.pay.sdk.net.api.trip.GetPayStatus;
import com.didi.universal.pay.sdk.net.api.trip.Prepay;
import com.didi.universal.pay.sdk.util.LogUtil;

public class UniversalPayNoTripHttp extends AbsUniversalPayHttp {
    public UniversalPayNoTripHttp(Context context, UniversalPayParams universalPayParams) {
        super(context, universalPayParams);
        LogUtil.m32410fi("UniversalPayNoTripHttp", "params-> " + universalPayParams.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo113153a() {
        NonTripGetPayInfo nonTripGetPayInfo = new NonTripGetPayInfo();
        nonTripGetPayInfo.sign = this.mPayParams.sign;
        nonTripGetPayInfo.sign_type = this.mPayParams.signType;
        nonTripGetPayInfo.biz_content = this.mPayParams.bizContent;
        nonTripGetPayInfo.out_trade_id = this.mPayParams.outTradeId;
        return nonTripGetPayInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo113154a(int i) {
        ChangePayInfo changePayInfo = new ChangePayInfo();
        changePayInfo.biz_pay_type = this.mEnterpriseType;
        changePayInfo.coupon_id = this.mCouponId;
        changePayInfo.user_select = this.mWantPayChannel;
        changePayInfo.change_type = i;
        changePayInfo.monthly_card_id = this.mMonthlyCardId;
        changePayInfo.has_deduction = this.hasDeduction;
        changePayInfo.out_token = this.mPayParams.outToken;
        changePayInfo.out_trade_id = this.mPayParams.outTradeId;
        if (this.arrSelectedPayChannels == null || this.arrSelectedPayChannels.size() <= 0) {
            changePayInfo.pay_channel = this.mSelectedPayChannel;
        } else {
            changePayInfo.pay_channels = getPayChannels();
        }
        return changePayInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo113155a(String str, String str2) {
        Prepay prepay = new Prepay();
        prepay.biz_pay_type = this.mEnterpriseType;
        prepay.appid = str;
        prepay.coupon_id = this.mCouponId;
        prepay.monthly_card_id = this.mMonthlyCardId;
        prepay.has_deduction = this.hasDeduction;
        prepay.out_token = this.mPayParams.outToken;
        prepay.out_trade_id = this.mPayParams.outTradeId;
        prepay.app_scheme = "diditaxi://didipay/callback";
        if (!TextUtils.isEmpty(str2)) {
            prepay.session_id = str2;
        }
        if (this.arrSelectedPayChannels == null || this.arrSelectedPayChannels.size() <= 0) {
            prepay.pay_channel = this.mSelectedPayChannel;
        } else {
            prepay.pay_channels = getPayChannels();
        }
        return prepay;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo113156b() {
        GetPayStatus getPayStatus = new GetPayStatus();
        getPayStatus.out_trade_id = this.mPayParams.outTradeId;
        return getPayStatus;
    }
}
