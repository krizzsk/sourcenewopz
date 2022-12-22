package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayLayer;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.MapCanvas;

public abstract class GLTile extends GLOverlayView implements MapCanvas.TileCallback {

    public static class Option extends GLOverlayView.Option {
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    protected GLTile(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option, GLOverlayLayer.TILE, true);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        this.mDisplayId = this.mMapCanvas.addTile(this);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removeTile(i);
    }
}
