package com.didi.payment.wallet.global.model;

import android.content.Context;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;

public class WalletApolloUtils {
    public static boolean useOldServer() {
        IToggle toggle = Apollo.getToggle("client_99pay_homepage_ab");
        if (toggle == null || !toggle.allow() || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("newWallet", 0)).intValue() != 1) {
            return true;
        }
        return false;
    }

    public static boolean useOldServerForMonitorOnly() {
        IToggle toggle = Apollo.getToggle("client_99pay_homepage_ab_test_copy");
        if (toggle == null || !toggle.allow() || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("newWallet", 0)).intValue() != 1) {
            return true;
        }
        return false;
    }

    public static void trackOldServerToggleForMonitorOnly(Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_monitor_city_id", PayBaseParamUtil.getHttpBaseParams(context).get("city_id"));
            PayTracker.trackEvent("ibt_homepage_old_for_monitor_bt", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void trackNewServerToggleForMonitorOnly(Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_monitor_city_id", PayBaseParamUtil.getHttpBaseParams(context).get("city_id"));
            PayTracker.trackEvent("ibt_homepage_new_for_monitor_bt", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
