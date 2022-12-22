package com.didi.unifiedPay.component.manager;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.DriverServiceTranceEvent;
import com.didi.unifiedPay.util.OmegaUtils;
import com.didi.unifiedPay.util.UniPayParamUtil;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;

public class PayTranceEventManager {

    /* renamed from: a */
    private String f44367a;

    /* renamed from: b */
    private int f44368b;

    /* renamed from: c */
    private Context f44369c;

    public PayTranceEventManager(Context context, String str, int i) {
        this.f44369c = context;
        this.f44367a = str;
        this.f44368b = i;
    }

    public void doOmegaPayCardShow(String str, String str2, String str3) {
        m31506a("payCard_sw", str, str2, str3);
    }

    public void doOmegaPayCardClose(String str, String str2, String str3) {
        m31506a("payCard_close", str, str2, str3);
    }

    public void doOmegaPayCardPay(String str, String str2, String str3) {
        m31506a("payCard_pay", str, str2, str3);
    }

    public void doOmegaPayCardCouponShow(String str, String str2, String str3) {
        m31506a("payCard_coupon_sw", str, str2, str3);
    }

    public void doOmegaPayCardCouponClick() {
        m31506a("payCard_coupon_ck", (String) null, (String) null, (String) null);
    }

    public void doOmegaPayCardSwitchCoupon(String str, String str2, String str3) {
        m31506a("payCard_switchCoupon_ck", str, str2, str3);
    }

    public void doOmegaPayCardResultWait(String str, String str2, String str3) {
        m31506a("payCard_resultwait_sw", str, str2, str3);
    }

    public void doOmegaPayCardSuccess(String str, String str2, String str3) {
        m31506a("payCard_suc", str, str2, str3);
    }

    public void doOmegaPayCardFailure(String str, String str2, String str3, boolean z) {
        m31507a("payCard_ab_sw", str, str2, str3, z);
    }

    public void doOmegaPayCardFailureRetry(String str, String str2, String str3, boolean z) {
        m31507a("payCard_ab_retry", str, str2, str3, z);
    }

    public void doOmegaPayCardFailureCancel(String str, String str2, String str3, boolean z) {
        m31507a("payCard_ab_cancel", str, str2, str3, z);
    }

    public void doOmegaPayMethodChange(String str, String str2) {
        if (!TextUtil.isEmpty(str) && !str.equals(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("paym1", str);
            hashMap.put("paym2", str2);
            hashMap.put("uid", UniPayParamUtil.getUid(this.f44369c));
            OmegaUtils.trackEvent(DriverServiceTranceEvent.PAY_METHOD_CHANGE_ID, (String) null, (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private void m31506a(String str, String str2, String str3, String str4) {
        m31505a(this.f44367a, this.f44368b, str, str2, str3, str4, (String) null);
    }

    /* renamed from: a */
    private void m31507a(String str, String str2, String str3, String str4, boolean z) {
        m31505a(this.f44367a, this.f44368b, str, str2, str3, str4, z ? "noresult" : "fail");
    }

    /* renamed from: a */
    private void m31505a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("business_id", Integer.valueOf(i));
            hashMap.put(GlobalPayOmegaConstant.EventKey.PAYMETHOD_NAME, str3);
            hashMap.put("coupon", str4);
            hashMap.put("channel_id", str5);
            hashMap.put("pays", str6);
            OmegaUtils.trackEvent(str2, (String) null, (Map<String, Object>) hashMap);
        }
    }
}
