package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;

public interface MapContext {
    Context getAndroidContext();

    GLHttpClient getHttpClient();

    Resources getResources();
}
