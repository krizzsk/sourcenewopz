package com.didi.sdk.fresco;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.facebook.drawee.backends.pipeline.Fresco;

public class FrescoInit {

    /* renamed from: a */
    private static Boolean f35944a;
    public static boolean initialized;

    public static boolean isAllowed() {
        Boolean bool = f35944a;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("psg_anr_fresco_init_when_use");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f35944a = valueOf;
        return valueOf.booleanValue();
    }

    public static void before() {
        SystemUtils.log(4, "FrescoInit", "before: ", (Throwable) null, "com.didi.sdk.fresco.FrescoInit", 27);
        if (initialized) {
            SystemUtils.log(4, "FrescoInit", "initialized: ", (Throwable) null, "com.didi.sdk.fresco.FrescoInit", 29);
        } else if (isAllowed()) {
            SystemUtils.log(4, "FrescoInit", "init: ", (Throwable) null, "com.didi.sdk.fresco.FrescoInit", 35);
            init();
        }
    }

    public static void init() {
        initialized = true;
        Fresco.initialize(DIDIApplication.getAppContext());
    }
}
