package com.didi.foundation.sdk.depsdowngrade;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class DependencyDowngradeToggle implements DowngradeToggle {

    /* renamed from: b */
    private static final DependencyDowngradeToggle f21168b = new DependencyDowngradeToggle();

    /* renamed from: a */
    DowngradeToggle f21169a;

    public static DependencyDowngradeToggle getInstance() {
        return f21168b;
    }

    private DependencyDowngradeToggle() {
        DowngradeToggle downgradeToggle = (DowngradeToggle) ServiceLoader.load(DowngradeToggle.class).get();
        this.f21169a = downgradeToggle;
        if (downgradeToggle == null) {
            this.f21169a = new C8354a();
        }
    }

    public boolean toggle() {
        return this.f21169a.toggle();
    }

    public boolean isDowngradeMap() {
        return toggle() && this.f21169a.isDowngradeMap();
    }

    public boolean isDowngradeNavigation() {
        return toggle() && this.f21169a.isDowngradeNavigation();
    }

    public boolean isDowngradeIM() {
        return toggle() && this.f21169a.isDowngradeIM();
    }

    public boolean isDowngradeShare() {
        return toggle() && this.f21169a.isDowngradeShare();
    }

    public boolean isDowngradeFaceBookLogin() {
        return toggle() && this.f21169a.isDowngradeFaceBookLogin();
    }

    public boolean isDowngradeGoogleLogin() {
        return toggle() && this.f21169a.isDowngradeGoogleLogin();
    }
}
