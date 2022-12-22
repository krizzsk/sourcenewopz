package com.didi.app.nova.skeleton.conductor.changehandler;

import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public abstract class TransitionChangeHandler extends ControllerChangeHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f8381a;

    /* renamed from: b */
    private boolean f8382b;

    public interface OnTransitionPreparedListener {
        void onPrepared();
    }

    /* access modifiers changed from: protected */
    public abstract Transition getTransition(ViewGroup viewGroup, View view, View view2, boolean z);

    public boolean removesFromViewOnPush() {
        return true;
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f8381a = true;
    }

    public void completeImmediately() {
        super.completeImmediately();
        this.f8382b = true;
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, final ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (this.f8381a) {
            controllerChangeCompletedListener.onChangeCompleted();
        } else if (this.f8382b) {
            executePropertyChanges(viewGroup, view, view2, (Transition) null, z);
            controllerChangeCompletedListener.onChangeCompleted();
        } else {
            Transition transition = getTransition(viewGroup, view, view2, z);
            transition.addListener(new Transition.TransitionListener() {
                public void onTransitionPause(Transition transition) {
                }

                public void onTransitionResume(Transition transition) {
                }

                public void onTransitionStart(Transition transition) {
                }

                public void onTransitionEnd(Transition transition) {
                    controllerChangeCompletedListener.onChangeCompleted();
                }

                public void onTransitionCancel(Transition transition) {
                    controllerChangeCompletedListener.onChangeCompleted();
                }
            });
            final ViewGroup viewGroup2 = viewGroup;
            final Transition transition2 = transition;
            final View view3 = view;
            final View view4 = view2;
            final boolean z2 = z;
            prepareForTransition(viewGroup, view, view2, transition, z, new OnTransitionPreparedListener() {
                public void onPrepared() {
                    if (!TransitionChangeHandler.this.f8381a) {
                        TransitionManager.beginDelayedTransition(viewGroup2, transition2);
                        TransitionChangeHandler.this.executePropertyChanges(viewGroup2, view3, view4, transition2, z2);
                    }
                }
            });
        }
    }

    public void prepareForTransition(ViewGroup viewGroup, View view, View view2, Transition transition, boolean z, OnTransitionPreparedListener onTransitionPreparedListener) {
        onTransitionPreparedListener.onPrepared();
    }

    public void executePropertyChanges(ViewGroup viewGroup, View view, View view2, Transition transition, boolean z) {
        if (view != null && ((removesFromViewOnPush() || !z) && view.getParent() == viewGroup)) {
            viewGroup.removeView(view);
        }
        if (view2 != null && view2.getParent() == null) {
            viewGroup.addView(view2);
        }
    }
}
