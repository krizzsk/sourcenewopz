package com.didi.flutter.hotpatch.flutterhotpatch;

import android.app.Application;

public interface HotPatchAdapter {
    boolean canLoadPatch(Application application);

    String getPatchPath(Application application);

    void onFlutterError();
}
