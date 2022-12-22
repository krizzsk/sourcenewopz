package com.didi.consume.base;

import com.didi.payment.base.tracker.FinOmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class CsOmegaUtils {
    public static void trackPhoneBillNumberDisplay(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_number_sw", map);
    }

    public static void trackPhoneBillConfirmBtnClicked(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", str);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_confirm_ck", hashMap);
    }

    public static void trackPhoneBillConfirmBtnClicked(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_confirm_ck", map);
    }

    public static void trackPhoneBillHistoryBtnClicked(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", str);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_ck", hashMap);
    }

    public static void trackPhoneBillOperatorDisplay(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_operator_sw", map);
    }

    public static void trackPhoneBillOperatorSelected(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_operator_ck", map);
    }

    public static void trackPhoneBillAmountDisplay(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_amount_sw", map);
    }

    public static void trackPhoneBillAmountSelected(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebill_amount_ck", map);
    }

    public static void clickKycUT(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sku_source_id", str);
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_kyc_notification_ck", hashMap);
    }

    public static void trackPhoneVoucherShow(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("fin_rechargeselect_sw", map);
    }

    public static void trackPhoneVoucherClick(Map<String, Object> map) {
        FinOmegaSDK.trackEvent("fin_phonerecharge_coupon_ck", map);
    }
}
