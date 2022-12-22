package com.android.didi.safetoolkit.presenter;

import android.content.Context;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;
import com.android.didi.safetoolkit.presenter.IBaseView;

public abstract class AbsViewPresenter<T extends IBaseView> implements ILifecycleObserver {
    protected T mView;

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public AbsViewPresenter(T t) {
        this.mView = t;
        t.addLifecycleObserver(this);
    }

    public boolean isViewAttached() {
        return this.mView != null;
    }

    public T getView() {
        return this.mView;
    }

    public Context getContext() {
        if (isViewAttached()) {
            return this.mView.getContext();
        }
        return null;
    }

    public final String getString(int i) {
        return getContext().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getContext().getString(i, objArr);
    }
}
