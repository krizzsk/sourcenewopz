package com.didi.foundation.sdk.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public abstract class AbstractLifecycleListener implements ApplicationListener {
    public void attachBaseContext(Context context) {
    }

    public void onConfigurationChanged(Application application, Configuration configuration) {
    }

    public void onCreate(Application application) {
    }

    public void onLowMemory(Application application) {
    }

    public void onTerminate(Application application) {
    }

    public void onTrimMemory(Application application, int i) {
    }
}
