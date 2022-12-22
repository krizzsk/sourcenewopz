package com.didi.sdk.service;

import android.os.Bundle;

public interface IForegroundServiceCallback {
    void onServiceDestroy(int i);

    void onServiceStartCommand(int i, Bundle bundle);
}
