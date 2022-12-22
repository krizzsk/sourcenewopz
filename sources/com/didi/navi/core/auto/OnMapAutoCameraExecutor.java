package com.didi.navi.core.auto;

import com.didi.map.outer.model.animation.Animation;

public interface OnMapAutoCameraExecutor {
    void checkParam(MapAutoCameraDescriptor mapAutoCameraDescriptor);

    void executeAction(MapAutoCameraDescriptor mapAutoCameraDescriptor, Animation.AnimationListener animationListener);

    MapAutoCameraDescriptor getContextParam();
}
