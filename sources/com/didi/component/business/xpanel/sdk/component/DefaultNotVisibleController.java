package com.didi.component.business.xpanel.sdk.component;

import com.didi.component.core.ComponentParams;

public class DefaultNotVisibleController implements InflateController {
    public boolean isVisible(ComponentParams componentParams) {
        return false;
    }

    public boolean shouldInflate(ComponentParams componentParams) {
        return true;
    }
}
