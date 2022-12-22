package com.didi.component.common.router.ride;

import android.net.Uri;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class GlobalShareTripeHandler implements IRouterHandler {

    /* renamed from: a */
    private final String f11718a = GlobalShareTripeHandler.class.getSimpleName();

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (uri == null) {
            String str = this.f11718a;
            GLog.m7965d(str, "routeHandler uri = " + uri);
            return;
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_SUBSTITUTE_CALL_TRAVEL_SHARING);
    }
}
