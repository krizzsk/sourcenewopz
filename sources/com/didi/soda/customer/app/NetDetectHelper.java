package com.didi.soda.customer.app;

import android.app.Application;
import com.didi.foundation.sdk.application.ability.NetDetectAbility;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;

public class NetDetectHelper {

    /* renamed from: a */
    private static final String f40335a = "2003";

    /* renamed from: b */
    private static boolean f40336b = false;

    /* renamed from: c */
    private static NetDetectAbility f40337c;

    public static void init(Application application) {
        boolean isNetDetectEnable = CustomerApolloUtil.isNetDetectEnable();
        f40336b = isNetDetectEnable;
        if (isNetDetectEnable) {
            NetDetectAbility Builder = new NetDetectAbility.Builder().setContext(application).setApolloToggle("sailing_net_detect_monitor_experiments").setDataType("2003").setTripCountry(LocationUtil.getPoiCountryCode()).Builder();
            f40337c = Builder;
            Builder.init();
            f40337c.startDetection(5000);
        }
    }

    public static void resume() {
        NetDetectAbility netDetectAbility;
        if (f40336b && (netDetectAbility = f40337c) != null) {
            netDetectAbility.resumeDetection();
        }
    }

    public static void stop() {
        NetDetectAbility netDetectAbility;
        if (f40336b && (netDetectAbility = f40337c) != null) {
            netDetectAbility.stopDetection();
        }
    }
}
