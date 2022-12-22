package com.didi.hawaii.mapsdkv2.core;

import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

public class GLAndroidView extends GLOverlayView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f23817a;

    /* renamed from: b */
    private final Handler f23818b;

    /* renamed from: c */
    private final LatLng f23819c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LatLng f23820d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f23821e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f23822f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final FrameLayout f23823g;

    public static class Option extends GLOverlayView.Option {
        public float anchorX = 0.5f;
        public float anchorY = 0.5f;
        public LatLng latLng;
        public View view;
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public GLAndroidView(GLViewManager gLViewManager, Option option, FrameLayout frameLayout) {
        super(gLViewManager, option, GLOverlayLayer.OVERLAY, false);
        this.f23818b = gLViewManager.getMainHandler();
        LatLng latLng = new LatLng(option.latLng);
        this.f23819c = latLng;
        this.f23820d = new LatLng(latLng);
        this.f23821e = option.anchorX;
        this.f23822f = option.anchorY;
        View view = option.view;
        this.f23817a = view;
        view.setVisibility(4);
        this.f23823g = frameLayout;
        if (frameLayout.indexOfChild(this.f23817a) != -1) {
            this.f23823g.removeView(this.f23817a);
        }
        attachToFrame(true);
    }

    public void setAnchor(float f, float f2) {
        this.f23821e = f;
        this.f23822f = f2;
    }

    public int[] getViewWH() {
        View view = this.f23817a;
        if (view == null) {
            return new int[]{0, 0};
        }
        return new int[]{view.getWidth(), this.f23817a.getHeight()};
    }

    public float getAnchorX() {
        return this.f23821e;
    }

    public float getAnchorY() {
        return this.f23822f;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        float[] screenLocation = this.mMapCanvas.toScreenLocation(this.f23820d);
        final float f = screenLocation[0];
        final float f2 = screenLocation[1];
        this.f23818b.post(new Runnable() {
            public void run() {
                int height = GLAndroidView.this.f23817a.getHeight();
                GLAndroidView.this.f23817a.setX(f - (((float) GLAndroidView.this.f23817a.getWidth()) * GLAndroidView.this.f23821e));
                GLAndroidView.this.f23817a.setY(f2 - (((float) height) * GLAndroidView.this.f23822f));
                GLAndroidView.this.f23817a.setVisibility(0);
                GLAndroidView.this.f23823g.addView(GLAndroidView.this.f23817a, new FrameLayout.LayoutParams(-2, -2));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        this.f23818b.post(new Runnable() {
            public void run() {
                GLAndroidView.this.f23823g.removeView(GLAndroidView.this.f23817a);
            }
        });
    }

    public void setCenter(LatLng latLng) {
        if (!this.f23819c.equals(latLng)) {
            final double d = latLng.latitude;
            final double d2 = latLng.longitude;
            this.f23819c.latitude = d;
            this.f23819c.longitude = d2;
            set(new RenderTask() {
                public void run() {
                    GLAndroidView.this.f23820d.longitude = d2;
                    GLAndroidView.this.f23820d.latitude = d;
                }
            });
        }
    }

    public LatLng getCenter() {
        return new LatLng(this.f23819c);
    }

    public void onFrameFinish(boolean z) {
        if (z) {
            float[] screenLocation = this.mMapCanvas.toScreenLocation(this.f23820d);
            final float f = screenLocation[0];
            final float f2 = screenLocation[1];
            this.f23818b.post(new Runnable() {
                public void run() {
                    int height = GLAndroidView.this.f23817a.getHeight();
                    GLAndroidView.this.f23817a.setX(f - (((float) GLAndroidView.this.f23817a.getWidth()) * GLAndroidView.this.f23821e));
                    GLAndroidView.this.f23817a.setY(f2 - (((float) height) * GLAndroidView.this.f23822f));
                }
            });
        }
    }

    public void setVisible(boolean z) {
        super.setVisible(z);
        this.f23817a.setVisibility(z ? 0 : 4);
        if (!z) {
            attachToFrame(false);
        } else {
            attachToFrame(true);
        }
    }

    public void setAlpha(float f) {
        super.setAlpha(f);
        this.f23817a.setAlpha(f);
    }
}
