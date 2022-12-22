package com.didi.common.map;

import android.content.Context;
import com.didi.common.map.MapsSdkInitialize;
import com.didi.common.map.listener.OnMapsSdkInitializedCallback;

public interface IMapsSdkInitializeDelegate {
    int initialize(Context context, MapsSdkInitialize.Renderer renderer, OnMapsSdkInitializedCallback onMapsSdkInitializedCallback);
}
