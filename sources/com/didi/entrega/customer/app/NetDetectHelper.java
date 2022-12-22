package com.didi.entrega.customer.app;

import android.app.Application;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.foundation.sdk.application.ability.NetDetectAbility;

public class NetDetectHelper {

    /* renamed from: a */
    private static final String f19794a = "2003";

    /* renamed from: b */
    private static boolean f19795b = false;

    /* renamed from: c */
    private static NetDetectAbility f19796c;

    public static void init(Application application) {
        boolean isNetDetectEnable = CustomerApolloUtil.isNetDetectEnable();
        f19795b = isNetDetectEnable;
        if (isNetDetectEnable) {
            NetDetectAbility Builder = new NetDetectAbility.Builder().setContext(application).setApolloToggle("sailing_net_detect_monitor_experiments").setDataType("2003").setTripCountry(LocationUtil.getPoiCountryCode()).Builder();
            f19796c = Builder;
            Builder.init();
            f19796c.startDetection(5000);
        }
    }

    public static void resume() {
        NetDetectAbility netDetectAbility;
        if (f19795b && (netDetectAbility = f19796c) != null) {
            netDetectAbility.resumeDetection();
        }
    }

    public static void stop() {
        NetDetectAbility netDetectAbility;
        if (f19795b && (netDetectAbility = f19796c) != null) {
            netDetectAbility.stopDetection();
        }
    }
}
