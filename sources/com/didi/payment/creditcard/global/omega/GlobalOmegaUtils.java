package com.didi.payment.creditcard.global.omega;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didichuxing.diface.logger.DiFaceLogger;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;

public class GlobalOmegaUtils {
    /* renamed from: a */
    private static int m21350a(int i) {
        if (i == 1) {
            return 3;
        }
        if (i != 8) {
            if (i != 4) {
                return i != 5 ? 1 : 2;
            }
            return 4;
        }
    }

    public static void track(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    public static void track(Context context, String str, Map map) {
        map.put("passenger_id", m21352b(context));
        map.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(str, map);
    }

    public static void trackAddCardPageSW(Context context, int i, String str, String str2, int i2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        hashMap.put("bind_type", Integer.valueOf(i));
        hashMap.put("resource_id", str2);
        hashMap.put("app_id", str3);
        hashMap.put("product_id", str4);
        hashMap.put("campaign_status", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("version", str);
        }
        if (DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH.equals(str2)) {
            hashMap.put("popup_type", "no_card_user");
            hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.POPUPBUTTON_NAME, GlobalOmegaConstant.AddCardPage.EventKey.POPUPBUTTON_NAME);
        }
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_SW, hashMap);
    }

    public static void trackAddCardPageReturnCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_RETURN_CK, hashMap);
    }

    public static void trackAddCardPageCardNumberCK(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("version", str);
        }
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_CARDNUMBER_CK, hashMap);
    }

    public static void trackAddCardPageCreditCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_CREDIT_CK, hashMap);
    }

    public static void trackAddCardPageDebitCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_DEBIT_CK, hashMap);
    }

    public static void trackAddCardPageExpirationCK(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("version", str);
        }
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_EXPIRATION_CK, hashMap);
    }

    public static void trackAddCardPageCvvCK(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("version", str);
        }
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_CVV_CK, hashMap);
    }

    public static void trackAddCardPageCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        hashMap.put("source", Integer.valueOf(m21350a(i)));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_CK, hashMap);
    }

    public static void trackOcrOperation(Context context, int i, Map<String, Object> map) {
        map.put("passenger_id", m21352b(context));
        map.put("city_id", m21353c(context));
        map.put("source", Integer.valueOf(m21350a(i)));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_OCR_OPERATION_CK, map);
    }

    public static void trackPassivityOcr(Context context, int i, Map<String, Object> map) {
        map.put("passenger_id", m21352b(context));
        map.put("city_id", m21353c(context));
        map.put("source", Integer.valueOf(m21350a(i)));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_OCR_PASSIVITY_CK, map);
    }

    public static void enterPassivityOcr(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        hashMap.put("source", Integer.valueOf(m21350a(i)));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_OCR_ENTER_PASSIVITY_CK, hashMap);
    }

    public static void trackAddCardPageAddCK(Context context, int i, int i2, String str, int i3, String str2, int i4, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        hashMap.put("status", Integer.valueOf(i2));
        hashMap.put("source", Integer.valueOf(m21350a(i)));
        hashMap.put("resource_id", str2);
        hashMap.put("app_id", str3);
        hashMap.put("product_id", str4);
        hashMap.put("campaign_status", Integer.valueOf(i4));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("version", str);
        }
        if (i3 != 0) {
            hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(i3));
        }
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_ADD_CK, hashMap);
    }

    public static void track3dsVerifyST(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", str);
        hashMap.put("type", str2);
        hashMap.put("pub_biz", "fintech");
        FinOmegaSDK.trackEvent(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_st, hashMap);
    }

    public static void track3dsVerifyResultEx(String str, String str2, String str3, String str4, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", str3);
        hashMap.put("auth", str4);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("errno", str);
        }
        hashMap.put("errno_json", str2);
        hashMap.put("pub_biz", "fintech");
        hashMap.put("is_cancel", Integer.valueOf(i));
        FinOmegaSDK.trackEvent(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_result_ex, hashMap);
    }

    public static void track3dsVerifyResultServerEx(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", str);
        hashMap.put("result", Integer.valueOf(i));
        hashMap.put("pub_biz", "fintech");
        FinOmegaSDK.trackEvent(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_result_server_st, hashMap);
    }

    public static void trackAddCardNetErrorPopupSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GP_ADDCARDERROR_POPUP_SW, hashMap);
    }

    public static void trackAddCardNetErrorBackBtnCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GP_ADDCARDERRORBACK_BTN_CK, hashMap);
    }

    public static void trackAddCardNetErrorWaitBtnCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GP_ADDCARDERRORWAIT_BTN_CK, hashMap);
    }

    public static void trackCardDetailPageSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.CardDetailPage.EventId.GLOBAL_PAS_CREDIT_SW, hashMap);
    }

    public static void trackCardDetailPageReturnCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.CardDetailPage.EventId.GLOBAL_PAS_CREDIT_RETURN_CK, hashMap);
    }

    public static void trackCardDetailPageRemoveCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.CardDetailPage.EventId.GLOBAL_PAS_CREDIT_REMOVE_CK, hashMap);
    }

    public static void trackCardDetailPageRemoveCancelCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.CardDetailPage.EventId.GLOBAL_PAS_CREDIT_REMOVE_CANCEL_CK, hashMap);
    }

    public static void trackCardDetailPageRemoveOKCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m21352b(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.CardDetailPage.EventId.GLOBAL_PAS_CREDIT_REMOVE_OK_CK, hashMap);
    }

    public static void trackOcrPageOcrCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", m21352b(context));
        hashMap.put("phone", m21351a(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.OcrPage.EventId.GLOBAL_PAS_CREDITCARD_OCR_CK, hashMap);
    }

    public static void trackOcrPageOcrMnlCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", m21352b(context));
        hashMap.put("phone", m21351a(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.OcrPage.EventId.GLOBAL_PAS_CREDITCARD_OCR_CK, hashMap);
    }

    public static void trackOcrPageOcrBackCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", m21352b(context));
        hashMap.put("phone", m21351a(context));
        hashMap.put("city_id", m21353c(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.OcrPage.EventId.GLOBAL_PAS_CREDITCARD_OCR_CK, hashMap);
    }

    public static void trackOcrPageOcrTimeCk(Context context, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", m21352b(context));
        hashMap.put("phone", m21351a(context));
        hashMap.put("city_id", m21353c(context));
        hashMap.put("duration", Long.valueOf(j));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.OcrPage.EventId.GLOBAL_PAS_CREDITCARD_OCR_CK, hashMap);
    }

    /* renamed from: a */
    private static String m21351a(Context context) {
        return PayBaseParamUtil.getStringParam(context, "phone");
    }

    /* renamed from: b */
    private static String m21352b(Context context) {
        return PayBaseParamUtil.getStringParam(context, "uid");
    }

    /* renamed from: c */
    private static String m21353c(Context context) {
        return PayBaseParamUtil.getStringParam(context, "city_id");
    }
}
