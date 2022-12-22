package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;

public interface IMaskLayerDelegate {
    MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions, MaskLayerControl maskLayerControl);

    String getId();

    MaskLayerOptions getOptions();

    int getZIndex();

    boolean isClickable();

    boolean isVisible();

    void removeMaskLayer();

    void removeMaskLayer(long j);

    void setOptions(MaskLayerOptions maskLayerOptions);

    void setVisible(boolean z);

    void setZIndex(int i);
}
