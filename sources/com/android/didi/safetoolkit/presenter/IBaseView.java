package com.android.didi.safetoolkit.presenter;

import android.content.Context;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObservable;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;

public interface IBaseView<T extends ILifecycleObserver> extends ILifecycleObservable<T> {
    Context getContext();
}
