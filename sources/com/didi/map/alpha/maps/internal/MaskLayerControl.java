package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;

public class MaskLayerControl {

    /* renamed from: a */
    private IMaskLayerDelegate f24540a;

    public MaskLayerControl(IMaskLayerDelegate iMaskLayerDelegate) {
        this.f24540a = iMaskLayerDelegate;
    }

    public void destroy() {
        this.f24540a = null;
    }

    public final MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate == null) {
            return null;
        }
        return iMaskLayerDelegate.addMaskLayer(maskLayerOptions, this);
    }

    public void setOptions(MaskLayerOptions maskLayerOptions) {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate != null) {
            iMaskLayerDelegate.setOptions(maskLayerOptions);
        }
    }

    public MaskLayerOptions getOptions() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate == null) {
            return null;
        }
        return iMaskLayerDelegate.getOptions();
    }

    public String getId() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate == null) {
            return null;
        }
        return iMaskLayerDelegate.getId();
    }

    public final void removeMaskLayer() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate != null) {
            iMaskLayerDelegate.removeMaskLayer();
        }
    }

    public final void removeMaskLayer(long j) {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate != null) {
            iMaskLayerDelegate.removeMaskLayer(j);
        }
    }

    public void setZIndex(int i) {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate != null) {
            iMaskLayerDelegate.setZIndex(i);
        }
    }

    public int getZIndex() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate == null) {
            return 0;
        }
        return iMaskLayerDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate != null) {
            iMaskLayerDelegate.setVisible(z);
        }
    }

    public boolean isVisible() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate == null) {
            return false;
        }
        return iMaskLayerDelegate.isVisible();
    }

    public boolean isClickable() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f24540a;
        if (iMaskLayerDelegate == null) {
            return false;
        }
        return iMaskLayerDelegate.isClickable();
    }
}
