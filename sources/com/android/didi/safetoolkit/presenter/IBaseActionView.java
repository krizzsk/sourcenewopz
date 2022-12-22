package com.android.didi.safetoolkit.presenter;

import com.android.didi.safetoolkit.observer.action.IActionObservable;
import com.android.didi.safetoolkit.observer.action.IActionObserver;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;

public interface IBaseActionView<T extends ILifecycleObserver & IActionObserver> extends IActionObservable<T>, IBaseView<T> {
}
