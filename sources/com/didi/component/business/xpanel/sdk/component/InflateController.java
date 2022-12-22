package com.didi.component.business.xpanel.sdk.component;

import com.didi.component.core.ComponentParams;

public interface InflateController {
    boolean isVisible(ComponentParams componentParams);

    boolean shouldInflate(ComponentParams componentParams);
}
