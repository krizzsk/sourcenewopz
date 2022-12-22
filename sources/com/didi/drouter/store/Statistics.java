package com.didi.drouter.store;

import androidx.collection.ArrayMap;
import com.didi.drouter.utils.RouterExecutor;
import com.didi.drouter.utils.SystemUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public class Statistics {
    /* renamed from: a */
    static void m14398a() {
        RouterExecutor.main(new Runnable() {
            public void run() {
                try {
                    OmegaSDKAdapter.trackEvent("drouter_app_name", (Map<String, Object>) new ArrayMap<String, Object>() {
                        {
                            put("name", SystemUtil.getAppName());
                            put("package", SystemUtil.getPackageName());
                        }
                    });
                } catch (Exception | NoClassDefFoundError unused) {
                }
            }
        }, 20000);
    }

    public static void track(String str) {
        try {
            OmegaSDK.trackCounter("drouter_data_all");
            OmegaSDK.trackCounter("drouter_data_" + str);
        } catch (NoClassDefFoundError unused) {
        }
    }
}
