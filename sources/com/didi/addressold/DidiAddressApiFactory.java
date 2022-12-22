package com.didi.addressold;

import android.content.Context;
import com.didi.address.IDidiAddressApi;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.config.Preferences;
import com.didichuxing.omega.sdk.init.OmegaSDK;

public class DidiAddressApiFactory {
    public static IDidiAddressApi createDidiAddress(Context context) {
        if (context != null) {
            m4863a(context);
            return new C3420a();
        }
        throw new RuntimeException("context is null");
    }

    /* renamed from: a */
    private static void m4863a(Context context) {
        OmegaSDK.init(context);
        SystemUtil.init(context);
        Preferences.getInstance().init(context);
    }

    private DidiAddressApiFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }
}
