package com.didichuxing.diface.core.MVP;

import com.didichuxing.diface.core.MVP.IView;

public abstract class BasePresenter<T extends IView> {
    protected T mViewRef;

    /* renamed from: a */
    private void m34015a() {
    }

    public void onCreate() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public BasePresenter(T t) {
        this.mViewRef = t;
    }

    /* access modifiers changed from: protected */
    public T getView() {
        return this.mViewRef;
    }

    public void onDestroy() {
        m34015a();
    }
}
