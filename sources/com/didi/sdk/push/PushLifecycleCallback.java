package com.didi.sdk.push;

interface PushLifecycleCallback {
    void onAuthentication(int i, int i2);

    void onConnect(int i, int i2);

    void onDestroy();

    void onDisConnect(int i, int i2);

    void onStartLoop();

    void stopLoop();
}
