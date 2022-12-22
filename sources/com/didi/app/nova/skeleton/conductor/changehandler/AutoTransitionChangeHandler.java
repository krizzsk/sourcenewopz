package com.didi.app.nova.skeleton.conductor.changehandler;

import android.transition.AutoTransition;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class AutoTransitionChangeHandler extends TransitionChangeHandler {
    /* access modifiers changed from: protected */
    public Transition getTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        return new AutoTransition();
    }

    public ControllerChangeHandler copy() {
        return new AutoTransitionChangeHandler();
    }
}
