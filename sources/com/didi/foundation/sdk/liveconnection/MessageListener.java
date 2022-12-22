package com.didi.foundation.sdk.liveconnection;

public interface MessageListener {
    int getPushKey();

    void onReceive(Response response);
}
