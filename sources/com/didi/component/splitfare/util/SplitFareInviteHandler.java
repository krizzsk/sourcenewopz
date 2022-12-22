package com.didi.component.splitfare.util;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.splitfare.model.NewSplitFareMsg;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class SplitFareInviteHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (!TextUtils.isEmpty(uri.getPath())) {
            NewSplitFareMsg newSplitFareMsg = new NewSplitFareMsg();
            newSplitFareMsg.from = 3;
            newSplitFareMsg.msg = uri.getQueryParameter("message");
            newSplitFareMsg.iconUrl = uri.getQueryParameter("icon");
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_ASK_SPLIT_FARE, newSplitFareMsg);
        }
    }
}
