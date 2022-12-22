package com.didi.entrega.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;

public final class CustomerDowngradeHelper {

    /* renamed from: a */
    private static DowngradeToggle f19883a = DependencyDowngradeToggle.getInstance();

    private CustomerDowngradeHelper() {
    }

    public static boolean isDowngradeMap() {
        return f19883a.isDowngradeMap();
    }

    public static boolean isDowngradeNavigation() {
        return f19883a.isDowngradeNavigation();
    }

    public static boolean isDowngradeIM() {
        return f19883a.isDowngradeIM();
    }

    public static boolean isDowngradeShare() {
        return f19883a.isDowngradeShare();
    }

    public static boolean isDowngradeFaceBookLogin() {
        return f19883a.isDowngradeFaceBookLogin();
    }

    public static boolean isDowngradeGoogleLogin() {
        return f19883a.isDowngradeGoogleLogin();
    }
}
