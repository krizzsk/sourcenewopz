package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.core.GLOverlayView;

public abstract class GLPrimaryShape extends GLOverlayView {
    public GLPrimaryShape(GLViewManager gLViewManager, GLOverlayView.Option option) {
        super(gLViewManager, option, GLOverlayLayer.OVERLAY, false);
    }
}
