package com.didichuxing.swarm.toolkit;

import android.app.Activity;
import android.view.ViewManager;

public interface ToolkitService {
    Activity getActivity();

    ViewManager getViewManager();

    void hide();

    void show();
}
