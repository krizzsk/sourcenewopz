package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;

public final class GLMaskLayerOptionAdapter implements GLViewOptionAdapter<GLMaskLayer.Option, MaskLayerOptions> {
    public GLMaskLayer.Option get(MaskLayerOptions maskLayerOptions, GLViewManager gLViewManager) {
        GLMaskLayer.Option option = new GLMaskLayer.Option();
        option.setColor(maskLayerOptions.getColor());
        option.setZIndex(Integer.valueOf(maskLayerOptions.getZIndex()));
        return option;
    }
}
