package com.didichuxing.publicservice.resourcecontrol.utils;

import com.didichuxing.publicservice.resourcecontrol.pojo.SdkDevice;

public class RoamingManager {
    private static final String RESOURCE_NAME = "_pas_notice_webview_travel";

    public static String mapResourceName(String str) {
        SdkDevice device;
        if (ResourceLocale.isResourceLocaleIsPt() || ResourceLocale.isResourceLocaleIsGl() || (device = ResourceManager.getManager().getDevice()) == null || !device.isOversea) {
            return str;
        }
        return device.countryIsoCode + RESOURCE_NAME;
    }

    public static boolean isRoaming() {
        SdkDevice device = ResourceManager.getManager().getDevice();
        return device != null && device.isOpened && device.isOversea;
    }
}
