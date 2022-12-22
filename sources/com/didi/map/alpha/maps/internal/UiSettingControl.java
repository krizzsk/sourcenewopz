package com.didi.map.alpha.maps.internal;

public class UiSettingControl {

    /* renamed from: a */
    private IUiSettingDelegate f24563a = null;

    public UiSettingControl(IUiSettingDelegate iUiSettingDelegate) {
        this.f24563a = iUiSettingDelegate;
    }

    public void exit() {
        if (this.f24563a != null) {
            this.f24563a = null;
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setZoomControlsEnabled(z);
        }
    }

    public void setCompassEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setCompassEnabled(z);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setMyLocationButtonEnabled(z);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setScrollGesturesEnabled(z);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setZoomGesturesEnabled(z);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setTiltGesturesEnabled(z);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setRotateGesturesEnabled(z);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setAllGesturesEnabled(z);
        }
    }

    public boolean isZoomControlsEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isZoomControlsEnabled();
        }
        return false;
    }

    public boolean isCompassEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isCompassEnabled();
        }
        return false;
    }

    public boolean isMyLocationButtonEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isMyLocationButtonEnabled();
        }
        return false;
    }

    public boolean isScrollGesturesEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isScrollGesturesEnabled();
        }
        return false;
    }

    public boolean isZoomGesturesEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isZoomGesturesEnabled();
        }
        return false;
    }

    public boolean isTiltGesturesEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isTiltGesturesEnabled();
        }
        return false;
    }

    public boolean isRotateGesturesEnabled() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isRotateGesturesEnabled();
        }
        return false;
    }

    public void setScaleAndLogoMode(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setScaleAndLogoMode(i);
        }
    }

    public void setScaleViewLeft(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setScaleViewLeft(i);
        }
    }

    public void setScaleViewBottom(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setScaleViewBottom(i);
        }
    }

    public boolean isScaleVisable() {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.isScaleVisable();
        }
        return false;
    }

    public void showScaleWithMaskLayer(boolean z) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.showScaleWithMaskLayer(z);
        }
    }

    public void setLogoMarginRate(int i, float f) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setLogoMarginRate(i, f);
        }
    }

    public float getLogoMarginRate(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            return iUiSettingDelegate.getLogoMarginRate(i);
        }
        return 0.0f;
    }

    public void setLogoAnchor(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setLogoAnchor(i);
        }
    }

    public void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setLogoAnchorWithMargin(i, i2, i3, i4, i5);
        }
    }

    public void setScaleAnchor(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setScaleAnchor(i);
        }
    }

    public void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setScaleAnchorWithMargin(i, i2, i3, i4, i5);
        }
    }

    public void setLogoLeftMargin(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setLogoLeftMargin(i);
        }
    }

    public void setLogoBottomMargin(int i) {
        IUiSettingDelegate iUiSettingDelegate = this.f24563a;
        if (iUiSettingDelegate != null) {
            iUiSettingDelegate.setLogoBottomMargin(i);
        }
    }
}
