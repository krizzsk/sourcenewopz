package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCircle;
import com.didi.map.outer.model.LatLng;

@GLViewDebug.ExportClass(name = "Circle&Border")
public class GLBorderCircle extends GLOverlayGroup {
    @GLViewDebug.ExportField(name = "fill")

    /* renamed from: a */
    private final GLCircle f24057a;
    @GLViewDebug.ExportField(name = "border")

    /* renamed from: b */
    private final GLCircle f24058b;

    public GLBorderCircle(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        GLCircle.Option option2 = new GLCircle.Option();
        option2.setColor(option.color);
        option2.setType(1);
        option.copyTo(option2);
        option2.setRadius(option.radius);
        option2.setCenter(option.center);
        option2.setIsMask(option.isMask);
        this.f24057a = new GLCircle(gLViewManager, option2);
        if (option.isMask) {
            this.f24058b = null;
            addView(this.f24057a);
            return;
        }
        GLCircle.Option option3 = new GLCircle.Option();
        option3.setType(2);
        option3.setColor(option.borderColor);
        option.copyTo(option3);
        option3.setRadius(option.radius);
        option3.setCenter(option.center);
        option3.setWidth(option.borderWidth);
        option2.setIsMask(option.isMask);
        GLCircle gLCircle = new GLCircle(gLViewManager, option3);
        this.f24058b = gLCircle;
        addView(this.f24057a, gLCircle);
    }

    public void setFillColor(int i) {
        this.f24057a.setColor(i);
    }

    public int getFillColor() {
        return this.f24057a.getColor();
    }

    public void setCenter(LatLng latLng) {
        this.f24057a.setCenter(latLng);
        GLCircle gLCircle = this.f24058b;
        if (gLCircle != null) {
            gLCircle.setCenter(latLng);
        }
    }

    public LatLng getCenter() {
        return this.f24057a.getCenter();
    }

    public float getRadius() {
        return this.f24057a.getRadius();
    }

    public void setRadius(float f) {
        this.f24057a.setRadius(f);
        GLCircle gLCircle = this.f24058b;
        if (gLCircle != null) {
            gLCircle.setRadius(f);
        }
    }

    public int getBorderColor() {
        GLCircle gLCircle = this.f24058b;
        if (gLCircle != null) {
            return gLCircle.getColor();
        }
        return 0;
    }

    public void setBorderColor(int i) {
        GLCircle gLCircle = this.f24058b;
        if (gLCircle != null) {
            gLCircle.setColor(i);
        }
    }

    public float getBorderWidth() {
        GLCircle gLCircle = this.f24058b;
        if (gLCircle != null) {
            return gLCircle.getWidth();
        }
        return 0.0f;
    }

    public void setBorderWidth(float f) {
        GLCircle gLCircle = this.f24058b;
        if (gLCircle != null) {
            gLCircle.setWidth(f);
        }
    }

    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            Option option2 = (Option) option;
            setCenter(option2.center);
            setRadius(option2.radius);
            setFillColor(option2.color);
            setBorderColor(option2.borderColor);
            setBorderWidth(option2.borderWidth);
        }
    }

    public static class Option extends GLOverlayGroup.Option {
        /* access modifiers changed from: private */
        public int borderColor;
        /* access modifiers changed from: private */
        public float borderWidth;
        /* access modifiers changed from: private */
        public LatLng center = new LatLng(0.0d, 0.0d);
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isMask;
        /* access modifiers changed from: private */
        public float radius;

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

        public void setIsMask(boolean z) {
            this.isMask = z;
        }
    }
}
