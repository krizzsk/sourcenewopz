package com.didi.hawaii.mapsdkv2.adapter;

import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLMaskLayerOptionAdapter;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMaskLayer;
import com.didi.map.alpha.maps.internal.IMaskLayerDelegate;
import com.didi.map.alpha.maps.internal.MaskLayerControl;
import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;
import java.util.Map;

public final class MaskLayerDelegate extends C9003b implements IMaskLayerDelegate {

    /* renamed from: b */
    private static final GLMaskLayerOptionAdapter f23726b = new GLMaskLayerOptionAdapter();

    /* renamed from: c */
    private MaskLayer f23727c;

    /* renamed from: d */
    private MaskLayerOptions f23728d;

    /* renamed from: e */
    private GLMaskLayer f23729e;

    public String getId() {
        return null;
    }

    public boolean isClickable() {
        return false;
    }

    public void removeMaskLayer(long j) {
    }

    public MaskLayerDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions, MaskLayerControl maskLayerControl) {
        this.f23728d = maskLayerOptions;
        this.f23729e = new GLMaskLayer(this.viewManager, f23726b.get(maskLayerOptions, this.viewManager));
        this.f23727c = new MaskLayer(maskLayerOptions, maskLayerControl);
        this.viewManager.addView((GLOverlayView) this.f23729e);
        return this.f23727c;
    }

    public void setOptions(MaskLayerOptions maskLayerOptions) {
        if (this.f23729e != null) {
            this.f23729e.updateOption(f23726b.get(maskLayerOptions, this.viewManager));
            this.f23728d = maskLayerOptions;
        }
    }

    public MaskLayerOptions getOptions() {
        if (this.f23727c != null) {
            return this.f23728d;
        }
        return null;
    }

    public void removeMaskLayer() {
        if (this.f23729e != null) {
            this.viewManager.removeView(this.f23729e);
            this.f23729e = null;
            this.f23727c = null;
        }
    }

    public void setZIndex(int i) {
        GLMaskLayer gLMaskLayer = this.f23729e;
        if (gLMaskLayer != null) {
            gLMaskLayer.setZIndex(i);
        }
    }

    public int getZIndex() {
        GLMaskLayer gLMaskLayer = this.f23729e;
        if (gLMaskLayer != null) {
            return gLMaskLayer.getZIndex();
        }
        return 0;
    }

    public void setVisible(boolean z) {
        GLMaskLayer gLMaskLayer = this.f23729e;
        if (gLMaskLayer != null) {
            gLMaskLayer.setVisible(z);
        }
    }

    public boolean isVisible() {
        GLMaskLayer gLMaskLayer = this.f23729e;
        return gLMaskLayer != null && gLMaskLayer.isVisible();
    }
}
