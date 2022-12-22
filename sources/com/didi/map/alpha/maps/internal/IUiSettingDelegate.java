package com.didi.map.alpha.maps.internal;

public interface IUiSettingDelegate {
    float getLogoMarginRate(int i);

    boolean isCompassEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleVisable();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setLogoAnchor(int i);

    void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5);

    void setLogoBottomMargin(int i);

    void setLogoLeftMargin(int i);

    void setLogoMarginRate(int i, float f);

    void setMyLocationButtonEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScaleAnchor(int i);

    void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5);

    void setScaleAndLogoMode(int i);

    void setScaleViewBottom(int i);

    void setScaleViewLeft(int i);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);

    void showScaleWithMaskLayer(boolean z);
}
