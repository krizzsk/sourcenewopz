package com.didi.component.mapflow.infowindow.widget;

import com.didi.component.mapflow.infowindow.callback.CountDownCallback;

public interface ICountDownInfoWindow {
    void init(int i, int i2, int i3, CountDownCallback countDownCallback);

    void start();

    void stop(boolean z);
}
