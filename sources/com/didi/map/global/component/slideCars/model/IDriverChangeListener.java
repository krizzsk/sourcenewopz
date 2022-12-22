package com.didi.map.global.component.slideCars.model;

import com.didi.map.global.component.slideCars.api.NearCarDriver;

public interface IDriverChangeListener {
    void onGetResultError(String str);

    void onGetResultSuccess(NearCarDriver nearCarDriver);
}
