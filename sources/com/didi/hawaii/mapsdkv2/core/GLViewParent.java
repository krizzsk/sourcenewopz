package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.view.RenderTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface GLViewParent {
    <T> Future<T> postToRenderThread(Callable<T> callable);

    boolean postToRenderThread(RenderTask renderTask);
}
