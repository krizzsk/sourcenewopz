package com.didichuxing.swarm.toolkit;

import android.net.Uri;

public interface ScreenshotService {

    public interface Callback {
        void onScreenshotTaken(Uri uri);
    }

    void takeScreenshot(int i, Callback callback);

    void takeScreenshot(Callback callback);
}
