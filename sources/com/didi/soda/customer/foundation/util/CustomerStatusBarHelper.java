package com.didi.soda.customer.foundation.util;

import android.app.Activity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.soda.customer.app.GlobalContext;

public final class CustomerStatusBarHelper {

    /* renamed from: a */
    private static CustomerStatusBarHelper f41227a = new CustomerStatusBarHelper();

    /* renamed from: b */
    private Boolean f41228b;

    private CustomerStatusBarHelper() {
    }

    public static CustomerStatusBarHelper getHelper() {
        return f41227a;
    }

    public void resetState() {
        this.f41228b = null;
    }

    public void setStatusBarBgLightning(Activity activity, boolean z) {
        Boolean bool = this.f41228b;
        if (bool == null || bool.booleanValue() != z) {
            this.f41228b = Boolean.valueOf(z);
            if (!GlobalContext.isEmbed()) {
                StatusBarLightingCompat.setStatusBarBgLightning(activity, !z, 0);
            }
        }
    }

    public void setStatusBarBgLightningForThirdParty(Activity activity, boolean z, int i) {
        if (!GlobalContext.isEmbed()) {
            StatusBarLightingCompat.setStatusBarBgLightning(activity, !z, i);
        }
    }

    public Boolean getCurrentStatus() {
        return this.f41228b;
    }
}
