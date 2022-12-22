package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView.Option;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;

public interface GLViewOptionAdapter<GLViewOption extends GLOverlayView.Option, ModelOption> {
    GLViewOption get(ModelOption modeloption, GLViewManager gLViewManager);
}
