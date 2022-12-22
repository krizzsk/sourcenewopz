package com.didi.app.nova.support.view.recyclerview.binder.mvp;

public interface RvLifecycleObserver {
    void onAttach();

    void onDestroy();

    void onDetach();
}
