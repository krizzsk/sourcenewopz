package com.didi.component.realtimeprice;

import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xpanel.sdk.component.InflateController;
import com.didi.component.core.ComponentParams;

public class RealTimePriceInflateController implements InflateController {
    public boolean shouldInflate(ComponentParams componentParams) {
        return CarOrderHelper.getOrder() != null && !CarOrderHelper.isUseNewCard();
    }

    public boolean isVisible(ComponentParams componentParams) {
        return CarOrderHelper.isOnService();
    }
}
