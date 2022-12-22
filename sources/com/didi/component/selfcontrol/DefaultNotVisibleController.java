package com.didi.component.selfcontrol;

import com.didi.component.core.ComponentParams;

public final class DefaultNotVisibleController implements InflateController {
    public boolean isVisible(ComponentParams componentParams) {
        return false;
    }

    public boolean shouldInflate(ComponentParams componentParams) {
        return true;
    }
}
