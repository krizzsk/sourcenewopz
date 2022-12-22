package com.didi.component.matchtogo20.ontrip;

import com.didi.component.business.xpanel.sdk.component.InflateController;
import com.didi.component.core.ComponentParams;

public class MTGOnTripController implements InflateController {
    public boolean isVisible(ComponentParams componentParams) {
        return false;
    }

    public boolean shouldInflate(ComponentParams componentParams) {
        return false;
    }
}
