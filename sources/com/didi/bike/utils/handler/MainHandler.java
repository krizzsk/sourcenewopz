package com.didi.bike.utils.handler;

import android.os.Handler;
import android.os.Looper;

public class MainHandler extends Handler {
    public MainHandler() {
        super(Looper.getMainLooper());
    }

    public void postOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
