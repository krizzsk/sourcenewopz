package com.didi.payment.creditcard.global.omega;

import android.content.Context;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import java.util.HashMap;

public class GlobalOmegaErrorCounter {

    /* renamed from: a */
    private static int f30398a;

    /* renamed from: b */
    private static int f30399b;

    /* renamed from: c */
    private static int f30400c;

    /* renamed from: d */
    private static int f30401d;

    /* renamed from: e */
    private static int f30402e;

    public static void addInvalidCardNoCount() {
        f30398a++;
    }

    public static void addInvalidDateCount() {
        f30399b++;
    }

    public static void addInvalidCvvCount() {
        f30400c++;
    }

    public static void addInvalidCidCount() {
        f30401d++;
    }

    public static void addInvalidBlackCardCount() {
        f30402e++;
    }

    public static void resetValue() {
        f30398a = 0;
        f30399b = 0;
        f30400c = 0;
        f30402e = 0;
    }

    public static void onSignErrorEvent(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", PayBaseParamUtil.getParam(context, "uid"));
        hashMap.put("city_id", PayBaseParamUtil.getParam(context, "trip_city_id"));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_CARD_NO, Integer.valueOf(f30398a));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_VALIDATION_DATE, Integer.valueOf(f30399b));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_CVV, Integer.valueOf(f30400c));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_CID, Integer.valueOf(f30401d));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_NOT_SUPPORTED, Integer.valueOf(f30402e));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_CREDITCARD_ERROR, hashMap);
    }
}
