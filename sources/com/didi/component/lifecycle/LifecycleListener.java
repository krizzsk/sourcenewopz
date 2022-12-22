package com.didi.component.lifecycle;

public interface LifecycleListener {
    void onAdd();

    void onBackHome();

    void onLeaveHome();

    void onPageHide();

    void onPagePause();

    void onPageResume();

    void onPageShow();

    void onPageStart();

    void onPageStop();

    void onRemove();
}
