package com.didi.common.map.internal;

import com.didi.common.map.model.throwable.MapNotExistApiException;

public interface IUiSettingsDelegate {
    void clear() throws MapNotExistApiException;

    boolean isRotateGesturesEnabled() throws MapNotExistApiException;

    boolean isScrollEnabled() throws MapNotExistApiException;

    boolean isTiltEnabled() throws MapNotExistApiException;

    boolean isZoomControlsEnabled() throws MapNotExistApiException;

    boolean isZoomEnabled() throws MapNotExistApiException;

    void setAllGesturesEnabled(boolean z) throws MapNotExistApiException;

    void setCompassEnabled(boolean z) throws MapNotExistApiException;

    void setCompassPadding(int i, int i2) throws MapNotExistApiException;

    void setLogoGravity(int i) throws MapNotExistApiException;

    void setLogoGravityWithMargin(int i, int i2, int i3, int i4, int i5) throws MapNotExistApiException;

    void setLogoVisibility(int i);

    void setMyLocationButtonEnabled(boolean z) throws MapNotExistApiException;

    void setRotateGesturesEnabled(boolean z) throws MapNotExistApiException;

    void setScaleGravity(int i) throws MapNotExistApiException;

    void setScaleGravityWithMargin(int i, int i2, int i3, int i4, int i5) throws MapNotExistApiException;

    void setScaleViewEnabled(boolean z) throws MapNotExistApiException;

    void setScrollEnabled(boolean z) throws MapNotExistApiException;

    void setTiltEnabled(boolean z) throws MapNotExistApiException;

    void setTouchEnabled(boolean z) throws MapNotExistApiException;

    void setZoomControlsEnabled(boolean z) throws MapNotExistApiException;

    void setZoomEnabled(boolean z) throws MapNotExistApiException;

    void setZoomFromCenterByDoubleClickEnabled(boolean z) throws MapNotExistApiException;

    void setZoomFromCenterByGestureEnabled(boolean z) throws MapNotExistApiException;
}
