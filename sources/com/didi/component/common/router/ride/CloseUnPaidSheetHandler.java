package com.didi.component.common.router.ride;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.base.ComponentType;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.util.SidConverter;

public class CloseUnPaidSheetHandler implements IRouterHandler {
    public static final String CLOSED = "1";
    public static final String UN_CLOSED = "0";

    public void handle(Request request, Result result) {
        String queryParameter = request.getUri().getQueryParameter(SidConverter.SID_OPERATION);
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.SERVICE_CONTROL_NO_PAY);
        }
    }
}
