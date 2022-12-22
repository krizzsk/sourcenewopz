package com.didi.map.outer.map;

import com.didi.map.alpha.maps.internal.UiSettingControl;

public class UiSettings {
    public static final int SHOW_BOTH_LOGO_SCALE = 3;
    public static final int SHOW_LOGO_ONLY = 1;
    public static final int SHOW_LOGO_SCALE_EXCLUSIVE = 4;
    public static final int SHOW_NO_LOGO_SCALE = 5;
    public static final int SHOW_SCALE_ONLY = 2;

    /* renamed from: a */
    private UiSettingControl f27877a = null;

    @Deprecated
    public void setLogoVisible(boolean z) {
    }

    @Deprecated
    public void showScaleView(boolean z) {
    }

    protected UiSettings() {
    }

    public UiSettings(UiSettingControl uiSettingControl) {
        this.f27877a = uiSettingControl;
    }

    public void setZoomControlsEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setZoomControlsEnabled(z);
        }
    }

    public void setCompassEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setCompassEnabled(z);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setMyLocationButtonEnabled(z);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setScrollGesturesEnabled(z);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setZoomGesturesEnabled(z);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setTiltGesturesEnabled(z);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setRotateGesturesEnabled(z);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setAllGesturesEnabled(z);
        }
    }

    public boolean isZoomControlsEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isZoomControlsEnabled();
        }
        return false;
    }

    public boolean isCompassEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isCompassEnabled();
        }
        return false;
    }

    public boolean isMyLocationButtonEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isMyLocationButtonEnabled();
        }
        return false;
    }

    public boolean isScrollGesturesEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isScrollGesturesEnabled();
        }
        return false;
    }

    public boolean isZoomGesturesEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isZoomGesturesEnabled();
        }
        return false;
    }

    public boolean isTiltGesturesEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isTiltGesturesEnabled();
        }
        return false;
    }

    public boolean isRotateGesturesEnabled() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isRotateGesturesEnabled();
        }
        return false;
    }

    public void setScaleAndLogoMode(int i) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setScaleAndLogoMode(i);
        }
    }

    public void setScaleViewLeft(int i) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setScaleViewLeft(i);
        }
    }

    public void setScaleViewBottom(int i) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setScaleViewBottom(i);
        }
    }

    public boolean isScaleViewVisible() {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            return uiSettingControl.isScaleVisable();
        }
        return false;
    }

    public void setLogoLeft(int i) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setLogoLeftMargin(i);
        }
    }

    public void setLogoBottom(int i) {
        UiSettingControl uiSettingControl = this.f27877a;
        if (uiSettingControl != null) {
            uiSettingControl.setLogoBottomMargin(i);
        }
    }
}
