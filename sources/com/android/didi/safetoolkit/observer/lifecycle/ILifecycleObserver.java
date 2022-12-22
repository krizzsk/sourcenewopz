package com.android.didi.safetoolkit.observer.lifecycle;

import java.io.Serializable;

public interface ILifecycleObserver extends Serializable {
    void onCreate();

    void onDestroy();
}
