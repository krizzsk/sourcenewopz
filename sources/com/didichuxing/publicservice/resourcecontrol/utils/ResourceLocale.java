package com.didichuxing.publicservice.resourcecontrol.utils;

import com.didi.sdk.apm.SystemUtils;

public class ResourceLocale {
    private static boolean isResourceLocaleIsGL = false;
    private static boolean isResourceLocaleIsPt = false;

    public static void setResourceLocaleIsPt(boolean z) {
        isResourceLocaleIsPt = z;
        SystemUtils.log(3, "ResourceLocale", "ResourceLocale:" + z, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale", 18);
    }

    public static void setResourceLocalIsGl(boolean z) {
        isResourceLocaleIsGL = z;
    }

    public static boolean isResourceLocaleIsPt() {
        SystemUtils.log(3, "ResourceLocale", "isResourceLocaleIsPt:" + isResourceLocaleIsPt, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale", 26);
        return isResourceLocaleIsPt;
    }

    public static boolean isResourceLocaleIsGl() {
        SystemUtils.log(3, "ResourceLocale", "isResourceLocaleIsPt:" + isResourceLocaleIsPt, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale", 31);
        return isResourceLocaleIsGL;
    }
}
