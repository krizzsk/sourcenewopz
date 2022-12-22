package com.android.didi.safetoolkit.observer.lifecycle;

import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;

public interface ILifecycleObservable<T extends ILifecycleObserver> {
    void addLifecycleObserver(T t);

    boolean removeLifecycleObserver(T t);
}
