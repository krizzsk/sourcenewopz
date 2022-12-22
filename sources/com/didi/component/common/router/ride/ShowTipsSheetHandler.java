package com.didi.component.common.router.ride;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class ShowTipsSheetHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Expectation.EVENT_EXPECTATION_SHOW_TIPS);
    }
}
