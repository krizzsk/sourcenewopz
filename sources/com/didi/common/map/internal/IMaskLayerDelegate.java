package com.didi.common.map.internal;

import com.didi.common.map.model.MaskLayerOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;

public interface IMaskLayerDelegate extends IMapElementDelegate {
    void remove(long j) throws MapNotExistApiException;

    void setMaskLayerOptions(MaskLayerOptions maskLayerOptions) throws MapNotExistApiException;
}
