package com.android.didi.safetoolkit.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.android.didi.safetoolkit.UIStuff;
import com.android.didi.safetoolkit.observer.action.ActionObserverCompat;
import com.android.didi.safetoolkit.observer.action.IActionObservable;
import com.android.didi.safetoolkit.observer.action.IActionObserver;
import com.android.didi.safetoolkit.observer.lifecycle.IComponentLifecycleObserver;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObservable;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;
import com.android.didi.safetoolkit.observer.lifecycle.LifecycleObserverCompat;
import com.android.didi.safetoolkit.presenter.IBaseView;

public abstract class AbsPresenter<T extends IBaseView> implements UIStuff, IActionObservable, IActionObserver, IComponentLifecycleObserver, ILifecycleObservable {
    private ActionObserverCompat mActionObserverCompat = new ActionObserverCompat();
    private LifecycleObserverCompat mLifeObserverCompat = new LifecycleObserverCompat();
    protected T mView;

    public AbsPresenter(T t) {
        this.mView = t;
        this.mView.addLifecycleObserver(this);
    }

    public void addLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        this.mLifeObserverCompat.addLifecycleObserver(iLifecycleObserver);
    }

    public boolean removeLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        return this.mLifeObserverCompat.removeLifecycleObserver(iLifecycleObserver);
    }

    public void addActionObserver(IActionObserver iActionObserver) {
        this.mActionObserverCompat.addActionObserver(iActionObserver);
    }

    public boolean removeActionObserver(IActionObserver iActionObserver) {
        return this.mActionObserverCompat.removeActionObserver(iActionObserver);
    }

    public void onCreate() {
        addAttachViewActionObserver();
        this.mLifeObserverCompat.onCreate();
    }

    public void onStart() {
        this.mLifeObserverCompat.onStart();
    }

    public void onResume() {
        this.mLifeObserverCompat.onResume();
    }

    public void onHiddenChanged(boolean z) {
        if (z) {
            removeAttachViewActionObserver();
        } else {
            addAttachViewActionObserver();
        }
        this.mLifeObserverCompat.onHiddenChanged(z);
    }

    public void onPause() {
        this.mLifeObserverCompat.onPause();
    }

    public void onStop() {
        this.mLifeObserverCompat.onStop();
    }

    public void onDestroy() {
        removeAttachViewActionObserver();
        this.mLifeObserverCompat.onDestroy();
    }

    private void addAttachViewActionObserver() {
        T t = this.mView;
        if (t instanceof IActionObservable) {
            ((IActionObservable) t).addActionObserver(this);
        }
    }

    private void removeAttachViewActionObserver() {
        T t = this.mView;
        if (t instanceof IActionObservable) {
            ((IActionObservable) t).removeActionObserver(this);
        }
    }

    public final boolean isViewAttached() {
        return this.mView != null;
    }

    public final T getView() {
        return this.mView;
    }

    public Context getContext() {
        if (!isViewAttached()) {
            return null;
        }
        T t = this.mView;
        if (t instanceof Activity) {
            return (Context) t;
        }
        if (t instanceof Fragment) {
            return ((Fragment) t).getActivity();
        }
        return t.getContext();
    }

    public final String getString(int i) {
        if (getContext() == null) {
            return "";
        }
        return getContext().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        if (getContext() == null) {
            return "";
        }
        return getContext().getString(i, objArr);
    }

    public final void showPDialog() {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showPDialog();
        }
    }

    public final void showPDialog(String str) {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showPDialog(str);
        }
    }

    public final void showPDialog(String str, boolean z) {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showPDialog(str, z);
        }
    }

    public final void closePDialog() {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).closePDialog();
        }
    }

    public final boolean isWaitDialogShowing() {
        T t = this.mView;
        if (t instanceof UIStuff) {
            return ((UIStuff) t).isWaitDialogShowing();
        }
        return false;
    }

    public final void showToast(String str) {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showToast(str);
        }
    }

    public void showToast(int i) {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showToast(i);
        }
    }

    public void showToast(int i, int i2) {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showToast(i, i2);
        }
    }

    public final void showToast(String str, int i) {
        T t = this.mView;
        if (t instanceof UIStuff) {
            ((UIStuff) t).showToast(str, i);
        }
    }

    public void onBackPressed() {
        this.mActionObserverCompat.onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mActionObserverCompat.onActivityResult(i, i2, intent);
    }
}
