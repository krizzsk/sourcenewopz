package com.android.didi.safetoolkit.observer.action;

import com.android.didi.safetoolkit.observer.action.IActionObserver;

public interface IActionObservable<T extends IActionObserver> {
    void addActionObserver(T t);

    boolean removeActionObserver(T t);
}
