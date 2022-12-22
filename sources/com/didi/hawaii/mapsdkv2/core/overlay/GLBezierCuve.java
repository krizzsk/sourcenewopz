package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Color;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

@GLViewDebug.ExportClass(name = "Polygon")
public class GLBezierCuve extends GLPrimaryShape {
    @GLViewDebug.ExportField(name = "state")

    /* renamed from: a */
    private float f24050a;
    @GLViewDebug.ExportField(name = "start_point")

    /* renamed from: b */
    private GLView.LatLngSafe f24051b;
    @GLViewDebug.ExportField(name = "end_point")

    /* renamed from: c */
    private GLView.LatLngSafe f24052c;
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: d */
    private int f24053d = Color.argb(17, 0, 163, 255);
    @GLViewDebug.ExportField(name = "width")

    /* renamed from: e */
    private float f24054e;
    @GLViewDebug.ExportField(name = "curvature")

    /* renamed from: f */
    private float f24055f;

    /* renamed from: g */
    private double[] f24056g = new double[4];

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public GLBezierCuve(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24050a = option.state;
        this.f24054e = option.width;
        this.f24053d = option.mColor;
        this.f24055f = option.curvature;
        this.f24051b = new GLView.LatLngSafe(option.startPoint.longitude, option.startPoint.latitude);
        this.f24052c = new GLView.LatLngSafe(option.endPoint.longitude, option.endPoint.latitude);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        GLView.LatLngSafe latLngSafe = this.f24051b;
        if (latLngSafe != null && this.f24052c != null) {
            this.f24056g[0] = latLngSafe.getLongitude();
            this.f24056g[1] = this.f24051b.getLatitude();
            this.f24056g[2] = this.f24052c.getLongitude();
            this.f24056g[3] = this.f24052c.getLatitude();
            this.mDisplayId = this.mMapCanvas.drawBezierCurve(this.f24056g, m17103a(this.f24053d), this.f24054e, this.f24055f, this.f24050a);
        }
    }

    /* renamed from: a */
    private int[] m17103a(int i) {
        return new int[]{Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i)};
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removePolygon(i);
    }

    public void setState(final float f) {
        if (this.f24050a != f) {
            this.f24050a = f;
            set(new RenderTask() {
                public void run() {
                    GLBezierCuve.this.mMapCanvas.updateBezierCurve(GLBezierCuve.this.mDisplayId, f);
                }
            });
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public float curvature;
        /* access modifiers changed from: private */
        public LatLng endPoint;
        protected int mColor = Color.argb(17, 0, 163, 255);
        /* access modifiers changed from: private */
        public LatLng startPoint;
        /* access modifiers changed from: private */
        public float state = 0.0f;
        /* access modifiers changed from: private */
        public float width;

        public void setStartPoint(LatLng latLng) {
            this.startPoint = latLng;
        }

        public void setEndPoint(LatLng latLng) {
            this.endPoint = latLng;
        }

        public void setmColor(int i) {
            this.mColor = i;
        }

        public void setWidth(float f) {
            this.width = f;
        }

        public void setCurvature(float f) {
            this.curvature = f;
        }

        public void setState(float f) {
            this.state = f;
        }
    }
}
