package com.didi.map.global.flow.scene.simple;

import com.didi.map.global.component.departure.controller.OrderInterceptMode;

public interface IOrderInterceptCallbackNew {
    void onContinue();

    void onIntercept(OrderInterceptMode orderInterceptMode, boolean z, String str, String str2, String str3);

    void onStart();
}
