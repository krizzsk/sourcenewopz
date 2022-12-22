package com.didi.foundation.sdk.depsdowngrade;

public interface DowngradeToggle {
    boolean isDowngradeFaceBookLogin();

    boolean isDowngradeGoogleLogin();

    boolean isDowngradeIM();

    boolean isDowngradeMap();

    boolean isDowngradeNavigation();

    boolean isDowngradeShare();

    boolean toggle();
}
