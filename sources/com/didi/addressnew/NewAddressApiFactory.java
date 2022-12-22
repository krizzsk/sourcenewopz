package com.didi.addressnew;

import android.content.Context;
import com.didi.addressnew.framework.IDidiAddressNewApiImpl;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.config.Preferences;
import com.didichuxing.omega.sdk.init.OmegaSDK;

public class NewAddressApiFactory {
    public static IDidiAddressNewApiImpl createDidiAddress(Context context) {
        if (context != null) {
            m2624a(context);
            return new IDidiAddressNewApiImpl();
        }
        throw new RuntimeException("context is null");
    }

    /* renamed from: a */
    private static void m2624a(Context context) {
        OmegaSDK.init(context);
        SystemUtil.init(context);
        Preferences.getInstance().init(context);
    }

    private NewAddressApiFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }
}
