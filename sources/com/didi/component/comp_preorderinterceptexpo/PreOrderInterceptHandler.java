package com.didi.component.comp_preorderinterceptexpo;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class PreOrderInterceptHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        String queryParameter = request.getUri().getQueryParameter("unique_id");
        if (!TextUtils.isEmpty(queryParameter)) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_EXPO, queryParameter);
        }
    }
}
