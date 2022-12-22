package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background.ApplicationStateMonitor;

public class UiBackgroundListener implements ComponentCallbacks2 {
    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20) {
            ApplicationStateMonitor.getInstance().uiHidden();
        }
    }
}
