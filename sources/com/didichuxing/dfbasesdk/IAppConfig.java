package com.didichuxing.dfbasesdk;

import android.content.Context;

public interface IAppConfig {

    /* renamed from: com.didichuxing.dfbasesdk.IAppConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getDebugEnv(IAppConfig iAppConfig) {
            return "";
        }
    }

    Context getAppContext();

    String getDebugEnv();

    boolean isDebug();
}
