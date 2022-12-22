package com.didi.app.nova.skeleton.conductor.changehandler;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;

public class TransitionChangeHandlerCompat extends ControllerChangeHandler {

    /* renamed from: a */
    private static final String f8383a = "TransitionChangeHandlerCompat.changeHandler.class";

    /* renamed from: b */
    private static final String f8384b = "TransitionChangeHandlerCompat.changeHandler.state";

    /* renamed from: c */
    private ControllerChangeHandler f8385c;

    public TransitionChangeHandlerCompat() {
    }

    public TransitionChangeHandlerCompat(TransitionChangeHandler transitionChangeHandler, ControllerChangeHandler controllerChangeHandler) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f8385c = transitionChangeHandler;
        } else {
            this.f8385c = controllerChangeHandler;
        }
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        this.f8385c.performChange(viewGroup, view, view2, z, controllerChangeCompletedListener);
    }

    public void saveToBundle(Bundle bundle) {
        super.saveToBundle(bundle);
        bundle.putString(f8383a, this.f8385c.getClass().getName());
        Bundle bundle2 = new Bundle();
        this.f8385c.saveToBundle(bundle2);
        bundle.putBundle(f8384b, bundle2);
    }

    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        ControllerChangeHandler controllerChangeHandler = (ControllerChangeHandler) ClassUtils.newInstance(bundle.getString(f8383a));
        this.f8385c = controllerChangeHandler;
        controllerChangeHandler.restoreFromBundle(bundle.getBundle(f8384b));
    }

    public boolean removesFromViewOnPush() {
        return this.f8385c.removesFromViewOnPush();
    }

    public ControllerChangeHandler copy() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new TransitionChangeHandlerCompat((TransitionChangeHandler) this.f8385c.copy(), (ControllerChangeHandler) null);
        }
        return new TransitionChangeHandlerCompat((TransitionChangeHandler) null, this.f8385c.copy());
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        this.f8385c.onAbortPush(controllerChangeHandler, controller);
    }

    public void completeImmediately() {
        this.f8385c.completeImmediately();
    }

    public void setForceRemoveViewOnPush(boolean z) {
        this.f8385c.setForceRemoveViewOnPush(z);
    }
}
