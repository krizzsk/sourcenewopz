package com.didi.soda.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;

public final class CustomerDowngradeHelper {

    /* renamed from: a */
    private static DowngradeToggle f40880a = DependencyDowngradeToggle.getInstance();

    private CustomerDowngradeHelper() {
    }

    public static boolean isDowngradeMap() {
        return f40880a.isDowngradeMap();
    }

    public static boolean isDowngradeNavigation() {
        return f40880a.isDowngradeNavigation();
    }

    public static boolean isDowngradeIM() {
        return f40880a.isDowngradeIM();
    }

    public static boolean isDowngradeShare() {
        return f40880a.isDowngradeShare();
    }

    public static boolean isDowngradeFaceBookLogin() {
        return f40880a.isDowngradeFaceBookLogin();
    }

    public static boolean isDowngradeGoogleLogin() {
        return f40880a.isDowngradeGoogleLogin();
    }
}
