package com.didi.map.global.component.slideCars.api;

public interface ICarNavigatorCallback {
    void onFails(String str);

    void onSuccess(NearCarDriver nearCarDriver);
}
