package com.didi.component.common.router;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class GlobalOpenSugHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG, "");
    }
}
