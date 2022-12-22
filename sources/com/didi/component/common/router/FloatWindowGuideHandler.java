package com.didi.component.common.router;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.sdk.app.ActivityLifecycleManager;

public class FloatWindowGuideHandler implements IRouterHandler {
    public static int OVERLAY_WINDOW_REQUEST = 1;

    public void handle(Request request, Result result) {
        Context context;
        Activity activity;
        if (!TextUtils.isEmpty(request.getUri().getPath()) && (context = request.getContext()) != null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = ActivityLifecycleManager.getInstance().getCurrentActivity();
            }
            OrderFloatWindowManager.Instance().requestPermission(activity, OVERLAY_WINDOW_REQUEST);
            GlobalOmegaUtils.trackEvent("map_fw_authority_sw");
        }
    }
}
