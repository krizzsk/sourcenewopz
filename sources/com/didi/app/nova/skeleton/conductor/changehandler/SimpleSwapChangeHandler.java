package com.didi.app.nova.skeleton.conductor.changehandler;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class SimpleSwapChangeHandler extends ControllerChangeHandler implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private static final String f8376a = "SimpleSwapChangeHandler.removesFromViewOnPush";

    /* renamed from: b */
    private boolean f8377b;

    /* renamed from: c */
    private boolean f8378c;

    /* renamed from: d */
    private ViewGroup f8379d;

    /* renamed from: e */
    private ControllerChangeHandler.ControllerChangeCompletedListener f8380e;

    public boolean isReusable() {
        return true;
    }

    public void onViewDetachedFromWindow(View view) {
    }

    public SimpleSwapChangeHandler() {
        this(true);
    }

    public SimpleSwapChangeHandler(boolean z) {
        this.f8377b = z;
    }

    public void saveToBundle(Bundle bundle) {
        super.saveToBundle(bundle);
        bundle.putBoolean(f8376a, this.f8377b);
    }

    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        this.f8377b = bundle.getBoolean(f8376a);
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f8378c = true;
    }

    public void completeImmediately() {
        ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener = this.f8380e;
        if (controllerChangeCompletedListener != null) {
            controllerChangeCompletedListener.onChangeCompleted();
            this.f8380e = null;
            this.f8379d.removeOnAttachStateChangeListener(this);
            this.f8379d = null;
        }
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (!this.f8378c) {
            if (view != null && (!z || this.f8377b)) {
                viewGroup.removeView(view);
            }
            if (view2 != null && view2.getParent() == null) {
                viewGroup.addView(view2);
            }
        }
        if (viewGroup.getWindowToken() != null) {
            controllerChangeCompletedListener.onChangeCompleted();
            return;
        }
        this.f8380e = controllerChangeCompletedListener;
        this.f8379d = viewGroup;
        viewGroup.addOnAttachStateChangeListener(this);
    }

    public boolean removesFromViewOnPush() {
        return this.f8377b;
    }

    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener = this.f8380e;
        if (controllerChangeCompletedListener != null) {
            controllerChangeCompletedListener.onChangeCompleted();
            this.f8380e = null;
            this.f8379d = null;
        }
    }

    public ControllerChangeHandler copy() {
        return new SimpleSwapChangeHandler(removesFromViewOnPush());
    }
}
