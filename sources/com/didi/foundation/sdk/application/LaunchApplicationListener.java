package com.didi.foundation.sdk.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.didichuxing.foundation.spi.ServiceLoader;

public class LaunchApplicationListener extends AbstractLifecycleListener {
    private Iterable<AppLifecycleListener> mAppListener = ServiceLoader.load(AppLifecycleListener.class);
    private Iterable<ApplicationListener> mApplicationListener = ServiceLoader.load(ApplicationListener.class);

    public void attachBaseContext(Context context) {
        try {
            for (ApplicationListener attachBaseContext : this.mApplicationListener) {
                attachBaseContext.attachBaseContext(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onConfigurationChanged(Application application, Configuration configuration) {
        try {
            for (ApplicationListener onConfigurationChanged : this.mApplicationListener) {
                onConfigurationChanged.onConfigurationChanged(application, configuration);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Application application) {
        try {
            for (AppLifecycleListener onCreate : this.mAppListener) {
                onCreate.onCreate(application);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispatcherOnCreate(application);
    }

    public void onLowMemory(Application application) {
        try {
            for (ApplicationListener onLowMemory : this.mApplicationListener) {
                onLowMemory.onLowMemory(application);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTerminate(Application application) {
        try {
            for (ApplicationListener onTerminate : this.mApplicationListener) {
                onTerminate.onTerminate(application);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTrimMemory(Application application, int i) {
        try {
            for (ApplicationListener onTrimMemory : this.mApplicationListener) {
                onTrimMemory.onTrimMemory(application, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dispatcherOnCreate(Application application) {
        try {
            for (ApplicationListener onCreate : this.mApplicationListener) {
                onCreate.onCreate(application);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
