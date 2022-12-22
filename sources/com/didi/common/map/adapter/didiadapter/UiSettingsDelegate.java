package com.didi.common.map.adapter.didiadapter;

import com.didi.common.map.internal.IUiSettingsDelegate;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.UiSettings;

public class UiSettingsDelegate implements IUiSettingsDelegate {

    /* renamed from: a */
    private DidiMap f10727a;

    /* renamed from: b */
    private UiSettings f10728b;

    public void clear() throws MapNotExistApiException {
    }

    public void setLogoGravity(int i) {
    }

    public void setLogoGravityWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setLogoVisibility(int i) {
    }

    public void setScaleViewEnabled(boolean z) {
    }

    public void setTouchEnabled(boolean z) throws MapNotExistApiException {
    }

    public void setZoomEnabled(boolean z) throws MapNotExistApiException {
    }

    public void setZoomFromCenterByDoubleClickEnabled(boolean z) throws MapNotExistApiException {
    }

    public UiSettingsDelegate(DidiMap didiMap) {
        this.f10727a = didiMap;
        if (didiMap != null) {
            this.f10728b = didiMap.getUiSettings();
        }
    }

    public void setCompassEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setCompassEnabled(z);
        }
    }

    public void setCompassPadding(int i, int i2) throws MapNotExistApiException {
        DidiMap didiMap;
        if (this.f10728b != null && (didiMap = this.f10727a) != null) {
            didiMap.setCompassExtraPadding(i, i2);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setMyLocationButtonEnabled(z);
        }
    }

    public void setScaleGravity(int i) {
        DidiMap didiMap = this.f10727a;
        if (didiMap == null) {
            return;
        }
        if (i == 83) {
            didiMap.setScaleAnchor(0);
        } else if (i == 85) {
            didiMap.setScaleAnchor(1);
        } else if (i == 53) {
            didiMap.setScaleAnchor(2);
        } else if (i == 51) {
            didiMap.setScaleAnchor(3);
        } else if (i == 81) {
            didiMap.setScaleAnchor(4);
        } else if (i == 49) {
            didiMap.setScaleAnchor(5);
        } else if (i == 3) {
            didiMap.setScaleAnchor(0);
        } else if (i == 5) {
            didiMap.setScaleAnchor(1);
        } else if (i == 48) {
            didiMap.setScaleAnchor(3);
        } else if (i == 80) {
            didiMap.setScaleAnchor(0);
        } else if (i == 17) {
            didiMap.setScaleAnchor(4);
        } else {
            didiMap.setScaleAnchor(0);
        }
    }

    public void setScaleGravityWithMargin(int i, int i2, int i3, int i4, int i5) {
        DidiMap didiMap = this.f10727a;
        if (didiMap == null) {
            return;
        }
        if (i == 83) {
            didiMap.setScaleAnchorWithMargin(0, i2, i3, i4, i5);
        } else if (i == 85) {
            didiMap.setScaleAnchorWithMargin(1, i2, i3, i4, i5);
        } else if (i == 53) {
            didiMap.setScaleAnchorWithMargin(2, i2, i3, i4, i5);
        } else if (i == 51) {
            didiMap.setScaleAnchorWithMargin(3, i2, i3, i4, i5);
        } else if (i == 81) {
            didiMap.setScaleAnchorWithMargin(4, i2, i3, i4, i5);
        } else if (i == 49) {
            didiMap.setScaleAnchorWithMargin(5, i2, i3, i4, i5);
        } else if (i == 3) {
            didiMap.setScaleAnchorWithMargin(0, i2, i3, i4, i5);
        } else if (i == 5) {
            didiMap.setScaleAnchorWithMargin(1, i2, i3, i4, i5);
        } else if (i == 48) {
            didiMap.setScaleAnchorWithMargin(3, i2, i3, i4, i5);
        } else if (i == 80) {
            didiMap.setScaleAnchorWithMargin(0, i2, i3, i4, i5);
        } else if (i == 17) {
            didiMap.setScaleAnchorWithMargin(4, i2, i3, i4, i5);
        } else {
            didiMap.setScaleAnchorWithMargin(0, i2, i3, i4, i5);
        }
    }

    public boolean isZoomControlsEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isZoomControlsEnabled();
    }

    public void setZoomControlsEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setZoomControlsEnabled(z);
        }
    }

    public boolean isZoomEnabled() throws MapNotExistApiException {
        DidiMap didiMap = this.f10727a;
        if (didiMap == null) {
            return false;
        }
        if (didiMap.getUiSettings().isZoomControlsEnabled() || this.f10727a.getUiSettings().isZoomGesturesEnabled()) {
            return true;
        }
        return false;
    }

    public void setZoomFromCenterByGestureEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setZoomGesturesEnabled(z);
        }
    }

    public boolean isScrollEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isScrollGesturesEnabled();
    }

    public void setScrollEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setScrollGesturesEnabled(z);
        }
    }

    public boolean isTiltEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isTiltGesturesEnabled();
    }

    public void setTiltEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setTiltGesturesEnabled(z);
        }
    }

    public boolean isRotateGesturesEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isRotateGesturesEnabled();
    }

    public void setRotateGesturesEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setRotateGesturesEnabled(z);
        }
    }

    public void setAllGesturesEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f10728b;
        if (uiSettings != null) {
            uiSettings.setAllGesturesEnabled(z);
        }
    }
}
