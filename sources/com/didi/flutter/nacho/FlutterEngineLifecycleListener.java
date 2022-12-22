package com.didi.flutter.nacho;

import android.content.Context;

public interface FlutterEngineLifecycleListener {
    void onPostStart(Context context, String str);

    void onPreStart(Context context, String str);
}
