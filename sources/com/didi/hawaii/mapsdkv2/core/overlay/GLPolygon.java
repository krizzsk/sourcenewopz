package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import java.util.Arrays;

@GLViewDebug.ExportClass(name = "Polygon")
public class GLPolygon extends GLPrimaryShape {
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: a */
    public int f24112a;
    @GLViewDebug.ExportField(name = "points")

    /* renamed from: b */
    private final LatLng[] f24113b;
    @GLViewDebug.ExportField(name = "forceload")

    /* renamed from: c */
    private final boolean f24114c;

    public final boolean isLongClickable() {
        return false;
    }

    public GLPolygon(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24112a = option.color;
        this.f24113b = (LatLng[]) Arrays.copyOf(option.pts, option.pts.length);
        this.bellowRoute = option.bellowRoute;
        this.f24114c = option.isForceLoad;
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setPolygonVisible(this.mDisplayId, z);
    }

    public void updatePoints(final LatLng[] latLngArr) {
        set(new RenderTask() {
            public void run() {
                GLPolygon.this.mMapCanvas.updatePolygon(GLPolygon.this.mDisplayId, latLngArr, GLPolygon.this.f24112a, GLPolygon.calculateTrueZIndex(GLPolygon.this.mLayer, GLPolygon.this.zIndex), GLPolygon.this.alpha, GLPolygon.this.visible);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        this.mMapCanvas.setPolygonAlpha(this.mDisplayId, f);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mDisplayId = this.mMapCanvas.addPolygon(this.f24113b, this.f24112a, calculateTrueZIndex(this.mLayer, this.zIndex), this.alpha, this.visible, this.f24114c);
        this.mMapCanvas.setBellowRoute(this.mDisplayId, this.bellowRoute);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removePolygon(i);
    }

    public int getColor() {
        return this.f24112a;
    }

    public void setColor(final int i) {
        if (this.f24112a != i) {
            this.f24112a = i;
            set(new RenderTask() {
                public void run() {
                    GLPolygon.this.mMapCanvas.setPolygonColor(GLPolygon.this.mDisplayId, i);
                }
            });
        }
    }

    public LatLng[] getPts() {
        LatLng[] latLngArr = this.f24113b;
        return (LatLng[]) Arrays.copyOf(latLngArr, latLngArr.length);
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            Option option2 = (Option) option;
            setColor(option2.color);
            setBellowRoute(option2.bellowRoute);
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public boolean bellowRoute = false;
        private boolean clickable = false;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isForceLoad = false;
        /* access modifiers changed from: private */
        public LatLng[] pts = new LatLng[0];

        public void setForceLoad(boolean z) {
            this.isForceLoad = z;
        }

        public void setBellowRoute(boolean z) {
            this.bellowRoute = z;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public void setPts(LatLng[] latLngArr) {
            this.pts = latLngArr;
        }

        public void setClickable(boolean z) {
            this.clickable = z;
        }
    }
}
