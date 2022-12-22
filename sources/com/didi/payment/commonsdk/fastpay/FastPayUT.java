package com.didi.payment.commonsdk.fastpay;

import com.didi.payment.base.tracker.FinOmegaSDK;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/fastpay/FastPayUT;", "", "()V", "trackFastPay2CashierBtnClk", "", "productLine", "", "trackFastPayBtnClk", "trackFastPayBtnShow", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayUT.kt */
public final class FastPayUT {
    public static final FastPayUT INSTANCE = new FastPayUT();

    private FastPayUT() {
    }

    public final void trackFastPayBtnShow(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("product_line", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("fin_payment_fastpay_order_sw", linkedHashMap);
    }

    public final void trackFastPayBtnClk(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("product_line", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("fin_payment_fastpay_order_ck", linkedHashMap);
    }

    public final void trackFastPay2CashierBtnClk(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("product_line", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("fin_payment_fastpay_order_cashier_ck", linkedHashMap);
    }
}
