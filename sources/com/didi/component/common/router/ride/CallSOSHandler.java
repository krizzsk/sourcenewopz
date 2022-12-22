package com.didi.component.common.router.ride;

import android.app.Activity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.app.ActivityLifecycleManager;

public class CallSOSHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            SafeToolKit.getIns().startEmergencyAssistanceActivity(currentActivity);
        }
    }
}
