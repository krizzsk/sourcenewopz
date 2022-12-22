package com.didi.component.common.router.ride;

import android.net.Uri;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class BookingWaitBackHandler implements IRouterHandler {

    /* renamed from: a */
    private String f11717a = BookingWaitBackHandler.class.getSimpleName();

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String str = this.f11717a;
        GLog.m7965d(str, "bookwaitbackHandler uri = " + uri);
        if (uri != null) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_BOOK_BACKHOME);
        }
    }
}
