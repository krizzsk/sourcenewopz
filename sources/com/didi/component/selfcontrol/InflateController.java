package com.didi.component.selfcontrol;

import com.didi.component.core.ComponentParams;

public interface InflateController {
    boolean isVisible(ComponentParams componentParams);

    boolean shouldInflate(ComponentParams componentParams);
}
