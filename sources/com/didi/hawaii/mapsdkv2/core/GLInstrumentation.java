package com.didi.hawaii.mapsdkv2.core;

import java.util.concurrent.Future;

public interface GLInstrumentation {

    public interface GLInstrumentationFutureTask<V> {
        V call(MapEngine mapEngine, MapCanvas mapCanvas);
    }

    public interface GLInstrumentationTask {
        void run(MapEngine mapEngine, MapCanvas mapCanvas);
    }

    <T> Future<T> postToRenderThread(GLInstrumentationFutureTask<T> gLInstrumentationFutureTask);

    boolean postToRenderThread(GLInstrumentationTask gLInstrumentationTask);
}
