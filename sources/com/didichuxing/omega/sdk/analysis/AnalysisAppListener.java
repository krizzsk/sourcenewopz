package com.didichuxing.omega.sdk.analysis;

import android.app.Application;
import com.didichuxing.omega.sdk.common.OmegaCallback;
import com.didichuxing.omega.sdk.common.backend.ActivityLifecycleRegister;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.Constants;
import java.util.Timer;
import java.util.TimerTask;

public class AnalysisAppListener {
    public static void whenAppStart(Application application) {
        ActivityLifecycleRegister.addActivityLifecycleListener(new AnalysisActivityListener());
        Event event = new Event(Constants.EVENT_OMG_APP_START);
        event.setSessionId();
        Tracker.trackEvent(event);
        doAsyncInit(application);
    }

    private static void doAsyncInit(Application application) {
        new Timer("OmegaSDK.asyncInit").schedule(new TimerTask() {
            public void run() {
                if (OmegaCallback.iAsyncInit != null) {
                    OmegaCallback.iAsyncInit.init();
                }
                if (RuntimeCheck.IsMainProcess()) {
                    EventStorageFixed.uploadLastEvent();
                }
            }
        }, 300);
    }
}
