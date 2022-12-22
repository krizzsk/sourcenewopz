package com.didi.entrega.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({DowngradeToggle.class})
public class CustomerDowngradeToggle implements DowngradeToggle {

    /* renamed from: a */
    private DowngradeStorage f19884a = new DowngradeStorage();

    public boolean toggle() {
        return this.f19884a.toggle();
    }

    public boolean isDowngradeMap() {
        return this.f19884a.isDowngradeMap();
    }

    public boolean isDowngradeNavigation() {
        return this.f19884a.isDowngradeNavigation();
    }

    public boolean isDowngradeIM() {
        return this.f19884a.isDowngradeIM();
    }

    public boolean isDowngradeShare() {
        return this.f19884a.isDowngradeShare();
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f19884a.isDowngradeFaceBookLogin();
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f19884a.isDowngradeGoogleLogin();
    }
}
