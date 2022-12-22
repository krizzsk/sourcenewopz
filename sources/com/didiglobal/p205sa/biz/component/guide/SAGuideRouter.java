package com.didiglobal.p205sa.biz.component.guide;

import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

/* renamed from: com.didiglobal.sa.biz.component.guide.SAGuideRouter */
public class SAGuideRouter implements IRouterHandler {
    public static final String SA_GUIDER = "sa_guider";

    public void handle(Request request, Result result) {
        request.getUri();
        BaseEventPublisher.getPublisher().publish("sa_guider");
    }
}
