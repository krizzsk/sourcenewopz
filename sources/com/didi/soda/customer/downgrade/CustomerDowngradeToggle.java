package com.didi.soda.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({DowngradeToggle.class})
public class CustomerDowngradeToggle implements DowngradeToggle {

    /* renamed from: a */
    private DowngradeStorage f40881a = new DowngradeStorage();

    public boolean toggle() {
        return this.f40881a.toggle();
    }

    public boolean isDowngradeMap() {
        return this.f40881a.isDowngradeMap();
    }

    public boolean isDowngradeNavigation() {
        return this.f40881a.isDowngradeNavigation();
    }

    public boolean isDowngradeIM() {
        return this.f40881a.isDowngradeIM();
    }

    public boolean isDowngradeShare() {
        return this.f40881a.isDowngradeShare();
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f40881a.isDowngradeFaceBookLogin();
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f40881a.isDowngradeGoogleLogin();
    }
}
