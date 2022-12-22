package com.didi.soda.customer.foundation.tracker;

import android.content.Context;
import android.os.Bundle;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;

public final class FirebaseAnalyticsHelper {
    private FirebaseAnalyticsHelper() {
    }

    public static void initRemoteConfig() {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).initFirebaseRemote();
    }

    public static void trackSignup(Context context) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).trackFirebaseEvent(context, Const.AdsEventConst.EVENT_KEY_SIGN_UP, (Bundle) null);
    }

    public static void trackLogin(Context context) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).trackFirebaseEvent(context, Const.AdsEventConst.EVENT_KEY_LOG_IN, (Bundle) null);
    }

    public static void trackViewRestaurant(Context context) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).trackFirebaseEvent(context, Const.AdsEventConst.EVENT_KEY_VIEW_RESTAURANT, (Bundle) null);
    }

    public static void trackAddCart(Context context) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).trackFirebaseEvent(context, Const.AdsEventConst.EVENT_KEY_ADD_TO_CART, (Bundle) null);
    }

    public static void trackAddPayment(Context context) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).trackFirebaseEvent(context, Const.AdsEventConst.EVENT_KEY_ADD_PAYMENT, (Bundle) null);
    }

    public static void trackCreateOrder(Context context) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).trackFirebaseEvent(context, Const.AdsEventConst.EVENT_KEY_CREATE_ORDER, (Bundle) null);
    }
}
