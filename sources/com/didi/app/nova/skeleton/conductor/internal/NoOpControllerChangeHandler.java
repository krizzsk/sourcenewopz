package com.didi.app.nova.skeleton.conductor.internal;

import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class NoOpControllerChangeHandler extends ControllerChangeHandler {
    public boolean isReusable() {
        return true;
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        controllerChangeCompletedListener.onChangeCompleted();
    }

    public ControllerChangeHandler copy() {
        return new NoOpControllerChangeHandler();
    }
}
