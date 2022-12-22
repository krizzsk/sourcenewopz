package com.didi.sdk.nation;

import com.didi.commoninterfacelib.ServiceProviderManager;

public class NationTypeUtil {

    /* renamed from: a */
    private static INationTypeComponent f36848a = ((INationTypeComponent) ServiceProviderManager.getInstance().getComponent(INationTypeComponent.class));

    public static NationComponentData getNationComponentData() {
        return f36848a.getNationComponentData();
    }

    public static void refreshPushConfig() {
        f36848a.refreshPushHost();
    }
}
