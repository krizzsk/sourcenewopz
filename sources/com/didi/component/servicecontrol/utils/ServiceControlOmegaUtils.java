package com.didi.component.servicecontrol.utils;

import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class ServiceControlOmegaUtils {
    public static void sendNoPayButtonClick(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        OmegaSDKAdapter.trackEvent("ibt_paydidnotpay_block_ck", (Map<String, Object>) hashMap);
    }

    public static void sendServiceControlCardCK(CashUnPayInterceptInfo cashUnPayInterceptInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", Long.valueOf(NationComponentDataUtil.getUid()));
        hashMap.put("noticepage_url", cashUnPayInterceptInfo.link);
        OmegaSDKAdapter.trackEvent("ibt_deduction_pax_xpanal_ck", (Map<String, Object>) hashMap);
    }

    public static void sendServiceControlCardSW(CashUnPayInterceptInfo cashUnPayInterceptInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", Long.valueOf(NationComponentDataUtil.getUid()));
        hashMap.put("noticepage_url", cashUnPayInterceptInfo.link);
        OmegaSDKAdapter.trackEvent("ibt_deduction_pax_xpanal_sw", (Map<String, Object>) hashMap);
    }
}
