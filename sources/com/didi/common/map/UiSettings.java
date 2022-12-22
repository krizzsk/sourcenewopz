package com.didi.common.map;

import com.didi.common.map.internal.IUiSettingsDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.throwable.MapNotExistApiException;

public final class UiSettings {

    /* renamed from: a */
    private IUiSettingsDelegate f10702a;

    public UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.f10702a = iUiSettingsDelegate;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setMyLocationButtonEnabled(false);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setCompassEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setCompassEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setCompassPadding(int i, int i2) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setCompassPadding(i, i2);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setScaleViewEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setScaleViewEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setLogoGravity(int i) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setLogoGravity(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setLogoGravityWithMargin(int i, int i2, int i3, int i4, int i5) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setLogoGravityWithMargin(i, i2, i3, i4, i5);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setLogoVisibility(int i) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setLogoVisibility(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setScaleGravity(int i) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setScaleGravity(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setScaleGravityWithMargin(int i, int i2, int i3, int i4, int i5) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setScaleGravityWithMargin(i, i2, i3, i4, i5);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isZoomControlsEnabled() {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate == null) {
            return false;
        }
        try {
            return iUiSettingsDelegate.isZoomControlsEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
            return false;
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setZoomControlsEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isZoomEnabled() {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate == null) {
            return false;
        }
        try {
            return iUiSettingsDelegate.isZoomEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
            return true;
        }
    }

    public void setZoomEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setZoomEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setZoomFromCenterByDoubleClickEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setZoomFromCenterByDoubleClickEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setZoomFromCenterByGestureEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setZoomFromCenterByGestureEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setTouchEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setTouchEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isScrollEnabled() {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate == null) {
            return false;
        }
        try {
            return iUiSettingsDelegate.isScrollEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
            return true;
        }
    }

    public void setScrollEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setScrollEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isTiltEnabled() {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate == null) {
            return false;
        }
        try {
            return iUiSettingsDelegate.isTiltEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
            return true;
        }
    }

    public void setTiltEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setTiltEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isRotateGesturesEnabled() {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate == null) {
            return false;
        }
        try {
            return iUiSettingsDelegate.isRotateGesturesEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
            return true;
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setRotateGesturesEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.setAllGesturesEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void clear() {
        IUiSettingsDelegate iUiSettingsDelegate = this.f10702a;
        if (iUiSettingsDelegate != null) {
            try {
                iUiSettingsDelegate.clear();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }
}
