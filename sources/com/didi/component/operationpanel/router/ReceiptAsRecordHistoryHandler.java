package com.didi.component.operationpanel.router;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class ReceiptAsRecordHistoryHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Trip.EVENT_GLOBAL_TRIP_SEND_RECEIPT);
    }
}
