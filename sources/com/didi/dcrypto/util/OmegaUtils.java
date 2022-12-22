package com.didi.dcrypto.util;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtils {
    public static void ibt_microinvest_mihomenotpurchased_buy_ck(boolean z, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_login", Boolean.valueOf(z));
        hashMap.put("kyc_status", str);
        hashMap.put("acc_status", str2);
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomenotpurchased_buy_ck", (Map<String, Object>) hashMap);
    }

    public static void ibt_microinvest_mihomepurchased_buy_ck(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_login", Boolean.valueOf(z));
        hashMap.put("selected_coin", str);
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomepurchased_buy_ck", (Map<String, Object>) hashMap);
    }

    public static void ibt_microinvest_mihomenotpurchased_page_sw() {
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomenotpurchased_page_sw", (Map<String, Object>) new HashMap());
    }

    public static void ibt_microinvest_mihomepurchased_page_sw() {
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomepurchased_page_sw", (Map<String, Object>) new HashMap());
    }

    public static void ibt_microinvest_mihomepurchased_trx_ck() {
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomepurchased_trx_ck", (Map<String, Object>) new HashMap());
    }

    public static void ibt_microinvest_agreementpopup_popup_sw() {
        OmegaSDKAdapter.trackEvent("ibt_microinvest_agreementpopup_popup_sw", (Map<String, Object>) new HashMap());
    }

    public static void ibt_microinvest_agreementpopup_cancel_ck() {
        OmegaSDKAdapter.trackEvent("ibt_microinvest_agreementpopup_cancel_ck", (Map<String, Object>) new HashMap());
    }

    public static void ibt_microinvest_agreementpopup_continue_ck() {
        OmegaSDKAdapter.trackEvent("ibt_microinvest_agreementpopup_continue_ck", (Map<String, Object>) new HashMap());
    }

    public static void ibt_microinvest_mihomepurchased_sell_ck(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_login", Boolean.valueOf(z));
        hashMap.put("selected_coin", str);
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomepurchased_sell_ck", (Map<String, Object>) hashMap);
    }

    public static void ibt_microinvest_mihomenotpurchased_page_browse_time_ex(boolean z, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("if_login", Boolean.valueOf(z));
        hashMap.put("browse_start_at", str);
        hashMap.put("browse_end_at", str2);
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomenotpurchased_page_browse_time_ex", (Map<String, Object>) hashMap);
    }

    public static void ibt_microinvest_mihomepurchased_page_browse_time_ex(boolean z, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("if_login", Boolean.valueOf(z));
        hashMap.put("browse_start_at", str);
        hashMap.put("browse_end_at", str2);
        OmegaSDKAdapter.trackEvent("ibt_microinvest_mihomepurchased_page_browse_time_ex", (Map<String, Object>) hashMap);
    }
}
