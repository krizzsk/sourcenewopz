package com.didi.component.common.router.ride;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xbanner.XBannerConstants;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class ReloadXBannerHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        if (GlobalApolloUtil.isHomeEngine()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, 0);
        } else {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_KEEP_PAGE_STATE);
        }
    }
}
