package com.didi.sdk.push.fcm;

public interface IOrderStatusParamsService {
    String getLocalOrderId();

    int getLocalStatus();

    int getLocalSubStatus();
}
