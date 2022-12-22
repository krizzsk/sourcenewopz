package com.didi.map.sdk.sharetrack.external.view;

public interface ILimitSpeedView extends ISkin {
    void setCurrentSpeed(int i);

    void setLimitSpeed(int i);

    void setNearLimitSpeed(int i);

    void switchDayOrNightMode(boolean z);
}
