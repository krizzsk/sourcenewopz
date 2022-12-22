package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.view.RenderTask;

@GLViewDebug.ExportClass(name = "Overlay")
public abstract class GLOverlayView extends GLView {
    protected static final int DISPLAY_ID_HAVE_REMOVED = -2;
    protected static final int DISPLAY_ID_NOT_ADDED = -1;
    /* access modifiers changed from: protected */
    @GLViewDebug.ExportField(name = "alpha")
    public float alpha;
    @GLViewDebug.ExportField(name = "bellowRoute")
    protected boolean bellowRoute = false;
    protected int mBubbleId = -1;
    /* access modifiers changed from: protected */
    public int mDisplayId = -1;
    protected final boolean mSingleInstance;
    /* access modifiers changed from: protected */
    @GLViewDebug.ExportField(name = "visible")
    public boolean visible;
    /* access modifiers changed from: protected */
    public int zIndex;

    /* access modifiers changed from: protected */
    public abstract void onSetAlpha(float f);

    /* access modifiers changed from: protected */
    public abstract void onSetVisible(boolean z);

    protected GLOverlayView(GLViewManager gLViewManager, Option option, GLOverlayLayer gLOverlayLayer, boolean z) {
        super(gLViewManager, gLOverlayLayer);
        this.visible = option.visible;
        this.alpha = option.alpha;
        this.zIndex = option.zIndex;
        this.mSingleInstance = z;
    }

    public void setLayer(GLOverlayLayer gLOverlayLayer) {
        this.mLayer = gLOverlayLayer;
        setTrueZIndex(calculateTrueZIndex(gLOverlayLayer, this.zIndex));
    }

    public void setLayerAndZIndex(GLOverlayLayer gLOverlayLayer, int i) {
        this.mLayer = gLOverlayLayer;
        this.zIndex = i;
        setTrueZIndex(calculateTrueZIndex(this.mLayer, this.zIndex));
    }

    /* access modifiers changed from: protected */
    public static int calculateTrueZIndex(GLOverlayLayer gLOverlayLayer, int i) {
        return GLOverlayLayer.getZIndexStart(gLOverlayLayer) + i;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(final boolean z) {
        if (this.visible != z) {
            this.visible = z;
            set(new RenderTask() {
                public void run() {
                    GLOverlayView.this.onSetVisible(z);
                }
            });
        }
    }

    public void setBellowRoute(final boolean z) {
        this.bellowRoute = z;
        set(new RenderTask() {
            public void run() {
                GLOverlayView.this.mMapCanvas.setBellowRoute(GLOverlayView.this.mDisplayId, z);
            }
        });
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(final float f) {
        if (this.alpha != f) {
            this.alpha = f;
            set(new RenderTask() {
                public void run() {
                    GLOverlayView.this.onSetAlpha(f);
                }
            });
        }
    }

    public int getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setTrueZIndex(final int i) {
        set(new RenderTask() {
            public void run() {
                GLOverlayView.this.mMapCanvas.setZIndex(GLOverlayView.this.mDisplayId, i);
            }
        });
    }

    public void setZIndex(int i) {
        if (this.zIndex != i) {
            this.zIndex = i;
            setTrueZIndex(calculateTrueZIndex(this.mLayer, i));
        }
    }

    public final boolean isSingleInstance() {
        return this.mSingleInstance;
    }

    /* access modifiers changed from: protected */
    public boolean onInterceptGestureEvent(Gesture gesture) {
        return !this.visible;
    }

    public void updateOption(Option option) {
        beginSetTransaction();
        onUpdateOption(option);
        commitSetTransaction();
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(Option option) {
        setAlpha(option.alpha);
        setVisible(option.visible);
        setZIndex(option.zIndex);
    }

    public static class Option implements GLView.Options {
        protected float alpha = 1.0f;
        protected boolean visible = true;
        protected int zIndex = 0;

        protected Option() {
        }

        public void setVisible(boolean z) {
            this.visible = z;
        }

        public void setAlpha(float f) {
            this.alpha = f;
        }

        public void setZIndex(Integer num) {
            this.zIndex = num.intValue();
        }

        public boolean isVisible() {
            return this.visible;
        }

        public float getAlpha() {
            return this.alpha;
        }

        public int getzIndex() {
            return this.zIndex;
        }

        public void copyTo(Option option) {
            option.setVisible(this.visible);
            option.setAlpha(this.alpha);
            option.setZIndex(Integer.valueOf(this.zIndex));
        }
    }
}
