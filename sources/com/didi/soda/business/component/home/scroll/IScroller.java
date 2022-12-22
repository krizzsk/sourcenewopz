package com.didi.soda.business.component.home.scroll;

import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

public interface IScroller {
    public static final int MAX_SMOOTH_SCROLL_DISTANCE = 30;
    public static final int SCROLL_OFFSET = DisplayUtils.dip2px(GlobalContext.getContext(), 10.0f);

    void scrollToPosition(int i, ScrollerFinishCallback scrollerFinishCallback);
}
