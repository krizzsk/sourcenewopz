package com.didi.sdk.connectivity;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import didinet.ApolloAPI;
import didinet.NetEngine;

/* renamed from: com.didi.sdk.connectivity.a */
/* compiled from: ApolloProvider */
class C12165a implements ConfigProvider<Config> {

    /* renamed from: a */
    private static final String f35759a = "net-connectivity";

    /* renamed from: b */
    private Config f35760b;

    C12165a() {
    }

    /* renamed from: a */
    public Config provider() {
        Config config = this.f35760b;
        if (config != null) {
            return config;
        }
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        if (apolloAPI == null || !apolloAPI.getToggle(f35759a).allow()) {
            return null;
        }
        try {
            Config a = Config.m25293a(apolloAPI.getToggle(f35759a).getExperiment());
            this.f35760b = a;
            return a;
        } catch (Throwable th) {
            SystemUtils.log(3, "connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.ApolloProvider", 32);
            return null;
        }
    }
}
