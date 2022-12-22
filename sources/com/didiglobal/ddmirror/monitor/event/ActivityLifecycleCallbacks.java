package com.didiglobal.ddmirror.monitor.event;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didiglobal.ddmirror.monitor.PrismMonitor;
import com.didiglobal.ddmirror.monitor.model.EventData;

public class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    PrismMonitor mPrismMonitor = PrismMonitor.getInstance();

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        EventData eventData = new EventData(6);
        eventData.eventId = "an_&_" + activity.getClass().getName();
        this.mPrismMonitor.post(eventData);
    }
}
