package com.didi.soda.customer.foundation.tracker;

import android.content.Context;
import com.appsflyer.AppsFlyerLib;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper;
import java.util.Map;

public final class AppsFlyerTrackHelper {
    private AppsFlyerTrackHelper() {
    }

    public static void trackSignup(Context context) {
        m29146a(context, isOpenOmegaTrack() ? Const.AdsOmegaEventConst.EVENT_KEY_SIGN_UP : Const.AdsEventConst.EVENT_KEY_SIGN_UP, (Map<String, Object>) null);
    }

    public static void trackLogin(Context context) {
        m29146a(context, isOpenOmegaTrack() ? Const.AdsOmegaEventConst.EVENT_KEY_LOG_IN : Const.AdsEventConst.EVENT_KEY_LOG_IN, (Map<String, Object>) null);
    }

    public static void trackViewRestaurant(Context context) {
        m29146a(context, Const.AdsEventConst.EVENT_KEY_VIEW_RESTAURANT, (Map<String, Object>) null);
    }

    public static void trackAddCart(Context context) {
        m29146a(context, isOpenOmegaTrack() ? Const.AdsOmegaEventConst.EVENT_KEY_ADD_TO_CART : Const.AdsEventConst.EVENT_KEY_ADD_TO_CART, (Map<String, Object>) null);
    }

    public static void trackAddPayment(Context context) {
        m29146a(context, isOpenOmegaTrack() ? Const.AdsOmegaEventConst.EVENT_KEY_ADD_PAYMENT : Const.AdsEventConst.EVENT_KEY_ADD_PAYMENT, (Map<String, Object>) null);
    }

    public static void trackCreateOrder(Context context) {
        m29146a(context, isOpenOmegaTrack() ? Const.AdsOmegaEventConst.EVENT_KEY_CREATE_ORDER : Const.AdsEventConst.EVENT_KEY_CREATE_ORDER, (Map<String, Object>) null);
    }

    /* renamed from: a */
    private static void m29146a(Context context, String str, Map<String, Object> map) {
        if (isOpenOmegaTrack()) {
            OmegaTracker.Builder.create(str).addEventParam("appsflyer_id", AppsFlyerLib.getInstance().getAppsFlyerUID(context)).addEventParam("advertising_id", AdvertisingIdHelper.getInstance().getGAID()).build().track();
        } else {
            AppsFlyerLib.getInstance().trackEvent(context, str, map);
        }
    }

    public static boolean isOpenOmegaTrack() {
        return CustomerApolloUtil.isOmegaTrack();
    }
}
