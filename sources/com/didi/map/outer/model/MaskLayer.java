package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.MaskLayerControl;

public final class MaskLayer {

    /* renamed from: a */
    private MaskLayerControl f27986a;

    public MaskLayer(MaskLayerOptions maskLayerOptions, MaskLayerControl maskLayerControl) {
        this.f27986a = maskLayerControl;
    }

    public void setOptions(MaskLayerOptions maskLayerOptions) {
        this.f27986a.setOptions(maskLayerOptions);
    }

    public MaskLayerOptions getOptions() {
        return this.f27986a.getOptions();
    }

    public String getId() {
        return this.f27986a.getId();
    }

    public void remove() {
        this.f27986a.removeMaskLayer();
    }

    public void remove(long j) {
        this.f27986a.removeMaskLayer(j);
    }

    public void setZIndex(int i) {
        this.f27986a.setZIndex(i);
    }

    public int getZIndex() {
        return this.f27986a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.f27986a.setVisible(z);
    }

    public boolean isVisible() {
        return this.f27986a.isVisible();
    }

    public boolean isClickable() {
        return this.f27986a.isClickable();
    }
}
