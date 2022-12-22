package com.didi.hawaii.mapsdkv2.core;

public interface RenderProfile {
    int getSlowRenderInterval();

    void onFrame(long j, long j2, long j3);

    void onSlowRender(long j, long j2, long j3);
}
