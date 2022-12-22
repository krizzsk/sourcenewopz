package com.didi.foundation.sdk.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public interface ApplicationListener {
    void attachBaseContext(Context context);

    void onConfigurationChanged(Application application, Configuration configuration);

    void onCreate(Application application);

    void onLowMemory(Application application);

    void onTerminate(Application application);

    void onTrimMemory(Application application, int i);
}
