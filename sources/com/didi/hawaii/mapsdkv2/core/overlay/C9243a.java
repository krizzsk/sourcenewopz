package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLPolyline;
import com.didi.map.outer.model.LatLng;

/* renamed from: com.didi.hawaii.mapsdkv2.core.overlay.a */
/* compiled from: GLBorderOne */
abstract class C9243a extends GLOverlayGroup {

    /* renamed from: a */
    private final GLPolyline f24141a;

    protected C9243a(GLViewManager gLViewManager, GLOverlayGroup.Option option, LatLng[] latLngArr, int i, float f, boolean z, boolean z2) {
        super(gLViewManager, option);
        LatLng[] latLngArr2 = new LatLng[(latLngArr.length + 1)];
        System.arraycopy(latLngArr, 0, latLngArr2, 0, latLngArr.length);
        latLngArr2[latLngArr.length] = latLngArr[0];
        GLPolyline.Option option2 = new GLPolyline.Option();
        option2.setForceLoad(z2);
        option2.setColor(i);
        option2.setWidth(f);
        option2.setPts(latLngArr2);
        option2.setBellowRoute(z);
        option.copyTo(option2);
        GLPolyline gLPolyline = new GLPolyline(gLViewManager, option2);
        this.f24141a = gLPolyline;
        addView(gLPolyline);
    }

    public void updatePoints(LatLng[] latLngArr) {
        LatLng[] latLngArr2 = new LatLng[(latLngArr.length + 1)];
        System.arraycopy(latLngArr, 0, latLngArr2, 0, latLngArr.length);
        latLngArr2[latLngArr.length] = latLngArr[0];
        this.f24141a.setPts(latLngArr2);
    }

    public void setBorderBellowRoute(boolean z) {
        this.f24141a.setBellowRoute(z);
    }

    public int getBorderColor() {
        return this.f24141a.getColor();
    }

    public void setBorderColor(int i) {
        this.f24141a.setColor(i);
    }

    public float getBorderWidth() {
        return this.f24141a.getWidth();
    }

    public void setBorderWidth(float f) {
        this.f24141a.setWidth(f);
    }
}
