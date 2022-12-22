package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBorderCircle;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarker;
import com.didi.map.outer.model.LatLng;

public class GLMyLocation extends GLOverlayGroup {

    /* renamed from: a */
    private GLMarker f24109a;

    /* renamed from: b */
    private GLBorderCircle f24110b;

    /* renamed from: c */
    private Option f24111c;

    public void setAnchor(float f, float f2) {
    }

    public GLMyLocation(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24111c = option;
        m17151a();
        m17153c();
    }

    public GLView getCarMarker() {
        return this.f24109a;
    }

    public void setAngle(float f) {
        this.f24111c.setAngle(f);
        this.f24109a.setAngle(f);
    }

    public void setRadius(float f) {
        this.f24111c.setRadius(f);
        m17153c();
        GLBorderCircle gLBorderCircle = this.f24110b;
        if (gLBorderCircle != null) {
            gLBorderCircle.setRadius(f);
        }
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f24111c.setCenter(latLng);
            super.beginSetTransaction();
            GLMarker gLMarker = this.f24109a;
            if (gLMarker != null) {
                gLMarker.setPosition(latLng);
            }
            GLBorderCircle gLBorderCircle = this.f24110b;
            if (gLBorderCircle != null) {
                gLBorderCircle.setCenter(latLng);
            }
            super.commitSetTransaction();
        }
    }

    public void setTexture(Texture texture) {
        this.f24111c.setTexture(texture);
        GLMarker gLMarker = this.f24109a;
        if (gLMarker != null) {
            gLMarker.updateOption(m17152b());
        }
    }

    /* renamed from: a */
    private void m17151a() {
        if (this.f24109a == null) {
            GLMarker gLMarker = new GLMarker(this.mViewManager, m17152b());
            this.f24109a = gLMarker;
            super.addView(gLMarker);
        }
    }

    /* renamed from: b */
    private GLMarker.Option m17152b() {
        GLMarker.Option option = new GLMarker.Option();
        option.setPosition(this.f24111c.center.longitude, this.f24111c.center.latitude);
        option.setTexture(this.f24111c.texture);
        option.setAngle(this.f24111c.angle);
        option.setClockwise(true);
        option.setFlat(true);
        option.setZIndex(Integer.valueOf(this.f24111c.getzIndex() + 1));
        return option;
    }

    /* renamed from: c */
    private void m17153c() {
        if (this.f24111c.showRing && this.f24110b == null && 0.0f < this.f24111c.radius) {
            GLBorderCircle.Option option = new GLBorderCircle.Option();
            option.setColor(this.f24111c.color);
            option.setRadius(this.f24111c.radius);
            option.setCenter(this.f24111c.center);
            option.setBorderWidth(this.f24111c.borderWidth);
            option.setBorderColor(this.f24111c.borderColor);
            GLBorderCircle gLBorderCircle = new GLBorderCircle(this.mViewManager, option);
            this.f24110b = gLBorderCircle;
            super.addView(gLBorderCircle);
        }
    }

    public static class Option extends GLOverlayGroup.Option {
        /* access modifiers changed from: private */
        public float angle;
        /* access modifiers changed from: private */
        public int borderColor;
        /* access modifiers changed from: private */
        public float borderWidth;
        /* access modifiers changed from: private */
        public LatLng center = new LatLng(0.0d, 0.0d);
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public float radius;
        /* access modifiers changed from: private */
        public boolean showRing;
        /* access modifiers changed from: private */
        public Texture texture;

        public void setRadius(float f) {
            this.radius = f;
        }

        public void setCenter(LatLng latLng) {
            this.center.latitude = latLng.latitude;
            this.center.longitude = latLng.longitude;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public void setBorderWidth(float f) {
            this.borderWidth = f;
        }

        public void setBorderColor(int i) {
            this.borderColor = i;
        }

        public void setAngle(float f) {
            this.angle = f;
        }

        public void setTexture(Texture texture2) {
            this.texture = texture2;
        }

        public void setShowRing(boolean z) {
            this.showRing = z;
        }
    }
}
