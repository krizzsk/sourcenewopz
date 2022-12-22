package com.didi.map.global.flow.scene.global;

import com.didi.map.global.component.slideCars.api.NearCarDriver;

public interface ICarSlidingChangeListener {
    void onGetResultError(String str);

    void onGetResultSuccess(NearCarDriver nearCarDriver);
}
