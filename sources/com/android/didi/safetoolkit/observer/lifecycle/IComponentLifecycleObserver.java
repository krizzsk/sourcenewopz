package com.android.didi.safetoolkit.observer.lifecycle;

public interface IComponentLifecycleObserver extends ILifecycleObserver {
    void onHiddenChanged(boolean z);

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
