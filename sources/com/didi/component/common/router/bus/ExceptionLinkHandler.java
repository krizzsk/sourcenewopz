package com.didi.component.common.router.bus;

import com.didi.component.business.constant.NEveREventKeys;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class ExceptionLinkHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        BaseEventPublisher.getPublisher().publish(NEveREventKeys.BusEvent.OPEN_LOCATION_SERVICE);
    }
}
