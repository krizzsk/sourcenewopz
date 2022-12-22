package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

@GLViewDebug.ExportClass(name = "Circle")
public class GLCircle extends GLPrimaryShape {
    public static final int FILL = 1;
    public static final int RING = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f24061a;

    /* renamed from: b */
    private final boolean f24062b;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "width")

    /* renamed from: c */
    public float f24063c;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "center")

    /* renamed from: d */
    public final LatLng f24064d;
    @GLViewDebug.ExportField(name = "radius")

    /* renamed from: e */
    private float f24065e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f24066f;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: g */
    public int f24067g;

    /* renamed from: a */
    private float m17105a(float f) {
        return f * 10.0f;
    }

    public boolean isClickable() {
        return false;
    }

    public boolean isLongClickable() {
        return false;
    }

    public GLCircle(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24061a = option.type;
        this.f24067g = option.color;
        this.f24064d = new LatLng(option.center);
        this.f24063c = option.width;
        this.f24062b = option.isMask;
        this.f24065e = m17105a(option.radius);
        this.f24066f = m17105a(option.radius);
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setCircleVisible(this.mDisplayId, z);
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        this.mMapCanvas.setCircleColor(this.mDisplayId, MathsUtils.mixedColorWithAlpha(f, this.f24067g));
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mDisplayId = this.mMapCanvas.addCircle(this.f24064d, this.f24066f, MathsUtils.mixedColorWithAlpha(this.alpha, this.f24067g), calculateTrueZIndex(this.mLayer, this.zIndex), this.visible, this.f24061a == 2, this.f24063c, this.f24062b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removeCircle(i);
    }

    public int getColor() {
        return this.f24067g;
    }

    public void setColor(final int i) {
        if (this.f24067g != i) {
            this.f24067g = i;
            final float f = this.alpha;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleColor(GLCircle.this.mDisplayId, MathsUtils.mixedColorWithAlpha(f, i));
                }
            });
        }
    }

    public LatLng getCenter() {
        return this.f24064d;
    }

    public void setCenter(final LatLng latLng) {
        if (!this.f24064d.equals(latLng)) {
            this.f24064d.longitude = latLng.longitude;
            this.f24064d.latitude = latLng.latitude;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleCenter(GLCircle.this.mDisplayId, latLng);
                }
            });
        }
    }

    public float getRadius() {
        return this.f24065e;
    }

    public void setRadius(float f) {
        float a = m17105a(f);
        if (this.f24066f == 0.0f) {
            this.f24066f = a;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.updateCircle(GLCircle.this.mDisplayId, GLCircle.this.f24064d, GLCircle.this.f24066f, MathsUtils.mixedColorWithAlpha(GLCircle.this.alpha, GLCircle.this.f24067g), GLCircle.calculateTrueZIndex(GLCircle.this.mLayer, GLCircle.this.zIndex), GLCircle.this.visible, GLCircle.this.f24061a == 2, GLCircle.this.f24063c);
                }
            });
        }
        if (this.f24065e != a) {
            this.f24065e = a;
            final float f2 = a / this.f24066f;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleScale(GLCircle.this.mDisplayId, f2);
                }
            });
        }
    }

    public float getWidth() {
        return this.f24063c;
    }

    public void setWidth(final float f) {
        if (this.f24063c != f && this.f24061a == 2) {
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleRingWidth(GLCircle.this.mDisplayId, f);
                }
            });
        }
    }

    public boolean isMask() {
        return this.f24062b;
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            setColor(((Option) option).color);
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public final LatLng center = new LatLng(0.0d, 0.0d);
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isMask;
        /* access modifiers changed from: private */
        public float radius;
        /* access modifiers changed from: private */
        public int type = 1;
        /* access modifiers changed from: private */
        public float width;

        public void setCenter(LatLng latLng) {
            this.center.longitude = latLng.longitude;
            this.center.latitude = latLng.latitude;
        }

        public void setIsMask(boolean z) {
            this.isMask = z;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setRadius(float f) {
            this.radius = f;
        }

        public void setWidth(float f) {
            this.width = f;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public int getColor() {
            return this.color;
        }

        public float getWidth() {
            return this.width;
        }

        public boolean isMask() {
            return this.isMask;
        }
    }
}
