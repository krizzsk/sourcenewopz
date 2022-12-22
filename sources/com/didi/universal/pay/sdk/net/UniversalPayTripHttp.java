package com.didi.universal.pay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.net.api.trip.ChangePayInfo;
import com.didi.universal.pay.sdk.net.api.trip.GetPayInfo;
import com.didi.universal.pay.sdk.net.api.trip.GetPayStatus;
import com.didi.universal.pay.sdk.net.api.trip.Prepay;
import com.didi.universal.pay.sdk.util.LogUtil;

public class UniversalPayTripHttp extends AbsUniversalPayHttp {
    public UniversalPayTripHttp(Context context, UniversalPayParams universalPayParams) {
        super(context, universalPayParams);
        LogUtil.m32410fi("UniversalPayTripHttp", "params-> " + universalPayParams.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo113153a() {
        GetPayInfo getPayInfo = new GetPayInfo();
        getPayInfo.page_type = 0;
        getPayInfo.out_token = this.mPayParams.outToken;
        return getPayInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo113154a(int i) {
        ChangePayInfo changePayInfo = new ChangePayInfo();
        changePayInfo.biz_pay_type = this.mEnterpriseType;
        changePayInfo.coupon_id = this.mCouponId;
        changePayInfo.user_select = this.mWantPayChannel;
        changePayInfo.change_type = i;
        changePayInfo.pay_channels = getPayChannels();
        changePayInfo.monthly_card_id = this.mMonthlyCardId;
        changePayInfo.has_deduction = this.hasDeduction;
        changePayInfo.out_token = this.mPayParams.outToken;
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
        prepay.app_scheme = "diditaxi://didipay/callback";
        if (!TextUtils.isEmpty(str2)) {
            prepay.session_id = str2;
        }
        if (this.arrSelectedPayChannels != null && this.arrSelectedPayChannels.size() > 0) {
            prepay.pay_channels = getPayChannels();
        }
        return prepay;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo113156b() {
        GetPayStatus getPayStatus = new GetPayStatus();
        getPayStatus.out_token = this.mPayParams.outToken;
        return getPayStatus;
    }
}
