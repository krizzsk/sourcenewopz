package com.didi.common.map.listener;

import com.didi.common.map.MapsSdkInitialize;

public interface OnMapsSdkInitializedCallback {
    void onMapsSdkInitialized(MapsSdkInitialize.Renderer renderer);
}
