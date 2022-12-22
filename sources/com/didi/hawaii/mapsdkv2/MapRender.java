package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import com.didi.hawaii.mapsdkv2.view.RenderTask;

public interface MapRender {
    Context getContext();

    void queueEvent(Runnable runnable);

    void queueRenderEvent(RenderTask renderTask);

    void requestRender();
}
