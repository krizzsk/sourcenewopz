package com.didi.common.map.internal;

import com.didi.common.map.model.throwable.MapNotExistApiException;

public interface IMapElementDelegate {
    Object getElement();

    String getId() throws MapNotExistApiException;

    IMapElementOptions getOptions();

    int getZIndex() throws MapNotExistApiException;

    boolean isClickable() throws MapNotExistApiException;

    boolean isVisible() throws MapNotExistApiException;

    void remove() throws MapNotExistApiException;

    void setClickable(boolean z);

    void setOptions(IMapElementOptions iMapElementOptions);

    void setVisible(boolean z) throws MapNotExistApiException;

    void setZIndex(int i) throws MapNotExistApiException;
}
