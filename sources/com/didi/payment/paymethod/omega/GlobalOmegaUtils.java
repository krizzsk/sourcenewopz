package com.didi.payment.paymethod.omega;

import android.content.Context;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.paymethod.omega.GlobalOmegaConstant;
import java.util.HashMap;

public class GlobalOmegaUtils {
    public static void trackAddPayPaySuccess(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPayPage.EventId.GLOBAL_PAS_ADD_PAYPAY_SUCESS, hashMap);
    }

    public static void trackPayPayRemoveCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPayPage.EventId.GLOBAL_PAS_PAYPAY_REMOVE_CK, hashMap);
    }

    public static void trackPayPayRemoveOKCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPayPage.EventId.GLOBAL_PAS_PAYPAY_REMOVE_OK_CK, hashMap);
    }

    public static void trackPayPayRemoveCancelCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPayPage.EventId.GLOBAL_PAS_PAYPAY_REMOVE_CANCEL_CK, hashMap);
    }

    public static void trackAddPayPalSuccess(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPalPage.EventId.GP_ADD_PAYPALV2_SUCESS, hashMap);
    }

    public static void trackPayPalRemoveCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPalPage.EventId.GP_PAYPALV2_REMOVE_CK, hashMap);
    }

    public static void trackPayPalRemoveOKCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPalPage.EventId.GP_PAYPALV2_REMOVE_OK_CK, hashMap);
    }

    public static void trackPayPalRemoveCancelCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21751a(context));
        hashMap.put("city_id", m21752b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPalPage.EventId.GP_PAYPALV2_REMOVE_CANCEL_CK, hashMap);
    }

    /* renamed from: a */
    private static String m21751a(Context context) {
        return context == null ? "" : PayBaseParamUtil.getStringParam(context, "uid");
    }

    /* renamed from: b */
    private static String m21752b(Context context) {
        return context == null ? "" : PayBaseParamUtil.getStringParam(context, "trip_city_id");
    }
}
