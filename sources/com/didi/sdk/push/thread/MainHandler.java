package com.didi.sdk.push.thread;

import android.os.Handler;
import android.os.Looper;

public class MainHandler extends Handler {
    public MainHandler() {
        super(Looper.getMainLooper());
    }
}
