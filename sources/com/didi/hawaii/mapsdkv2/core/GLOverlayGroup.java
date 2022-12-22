package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GLOverlayGroup extends GLPrimaryShape {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<GLOverlayView> f23921a = new ArrayList(12);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f23922b = false;

    public static class Option extends GLOverlayView.Option {
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public void setZIndex(int i) {
    }

    public GLOverlayGroup(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
    }

    public void addView(GLOverlayView... gLOverlayViewArr) {
        if (gLOverlayViewArr != null) {
            Collections.addAll(this.f23921a, gLOverlayViewArr);
            if (isAdded()) {
                for (GLOverlayView gLOverlayView : gLOverlayViewArr) {
                    if (!this.f23922b) {
                        gLOverlayView.setAlpha(getAlpha());
                        gLOverlayView.setZIndex(gLOverlayView.getZIndex() > getZIndex() ? gLOverlayView.getZIndex() : getZIndex());
                    }
                    gLOverlayView.setVisible(isVisible());
                }
                this.mViewManager.addView(gLOverlayViewArr);
            }
        }
    }

    public void setIgnoreGroupAttrs(boolean z) {
        this.f23922b = z;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        getMainHandler().post(new Runnable() {
            public void run() {
                int i;
                for (GLOverlayView gLOverlayView : GLOverlayGroup.this.f23921a) {
                    if (!GLOverlayGroup.this.f23922b) {
                        gLOverlayView.setAlpha(GLOverlayGroup.this.getAlpha());
                        if (gLOverlayView.getZIndex() > GLOverlayGroup.this.getZIndex()) {
                            i = gLOverlayView.getZIndex();
                        } else {
                            i = GLOverlayGroup.this.getZIndex();
                        }
                        gLOverlayView.setZIndex(i);
                    }
                    gLOverlayView.setVisible(GLOverlayGroup.this.isVisible());
                }
                GLOverlayGroup.this.mViewManager.addView((GLOverlayView[]) GLOverlayGroup.this.f23921a.toArray(new GLOverlayView[GLOverlayGroup.this.f23921a.size()]));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        getMainHandler().post(new Runnable() {
            public void run() {
                for (GLOverlayView removeView : GLOverlayGroup.this.f23921a) {
                    GLOverlayGroup.this.mViewManager.removeView(removeView);
                }
                GLOverlayGroup.this.f23921a.clear();
            }
        });
    }

    public void removeView(GLOverlayView gLOverlayView) {
        this.f23921a.remove(gLOverlayView);
        this.mViewManager.removeView(gLOverlayView);
    }

    public void clearView() {
        for (GLOverlayView removeView : this.f23921a) {
            this.mViewManager.removeView(removeView);
        }
        this.f23921a.clear();
    }

    public void setVisible(boolean z) {
        super.setVisible(z);
        beginSetTransaction();
        for (GLOverlayView visible : this.f23921a) {
            visible.setVisible(z);
        }
        commitSetTransaction();
    }

    public void setAlpha(float f) {
        super.setAlpha(f);
        beginSetTransaction();
        for (GLOverlayView alpha : this.f23921a) {
            alpha.setAlpha(f);
        }
        commitSetTransaction();
    }

    public GLOverlayView getChildAt(int i) {
        if (i < 0 || i >= this.f23921a.size()) {
            return null;
        }
        return this.f23921a.get(i);
    }

    public int getChildCount() {
        return this.f23921a.size();
    }

    public GLOverlayView findViewById(String str) {
        checkThread();
        for (GLOverlayView next : this.f23921a) {
            if (next.getId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void beginSetTransaction() {
        super.beginSetTransaction();
        for (GLOverlayView beginSetTransaction : this.f23921a) {
            beginSetTransaction.beginSetTransaction(this.mSetTransaction);
        }
    }

    /* access modifiers changed from: protected */
    public void commitSetTransaction() {
        super.commitSetTransaction();
        for (GLOverlayView commitSetTransaction : this.f23921a) {
            commitSetTransaction.commitSetTransaction();
        }
    }

    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        beginSetTransaction();
        for (GLOverlayView onUpdateOption : this.f23921a) {
            onUpdateOption.onUpdateOption(option);
        }
        commitSetTransaction();
    }
}
