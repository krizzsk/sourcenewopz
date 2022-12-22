package com.didi.sdk.app;

public interface INavigationListener {
    void onBackToHome();

    void onEntranceVisible(boolean z);

    void onLeaveHome();

    void preLeaveHome();
}
