package com.didi.component.common.router.ride;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class SwitchPageHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String queryParameter = uri.getQueryParameter("node");
        if (!TextUtils.isEmpty(queryParameter)) {
            if ("eyeball".equals(queryParameter)) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_ESTIMATE);
            } else if (XPanelScene.SCENE_CONFIRM.equals(queryParameter)) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, uri.getQueryParameter("offer_price"));
            } else if ("home".equals(queryParameter)) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_HOME);
            }
        }
    }
}
