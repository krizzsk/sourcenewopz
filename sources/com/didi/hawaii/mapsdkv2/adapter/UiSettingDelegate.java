package com.didi.hawaii.mapsdkv2.adapter;

import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLUiSetting;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.widget.MapWidgets;
import com.didi.map.alpha.maps.internal.IUiSettingDelegate;

public class UiSettingDelegate implements IUiSettingDelegate {

    /* renamed from: a */
    private final GLUiSetting f23753a;

    /* renamed from: b */
    private final GLBaseMapView f23754b;

    /* renamed from: c */
    private final MapWidgets f23755c;

    public float getLogoMarginRate(int i) {
        return 0.0f;
    }

    public void setLogoAnchor(int i) {
    }

    public void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setLogoMarginRate(int i, float f) {
    }

    public void setScaleAnchor(int i) {
    }

    public void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void showScaleWithMaskLayer(boolean z) {
    }

    public UiSettingDelegate(GLViewManager gLViewManager, MapWidgets mapWidgets) {
        GLBaseMapView baseMap = gLViewManager.getBaseMap();
        this.f23754b = baseMap;
        this.f23753a = baseMap.getUiSetting();
        this.f23755c = mapWidgets;
    }

    public void setZoomControlsEnabled(boolean z) {
        this.f23753a.setZoomControlsEnabled(z);
        this.f23754b.setZoomControlVisible(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f23753a.setCompassEnabled(z);
        this.f23754b.setCompassVisible(z);
    }

    public void setMyLocationButtonEnabled(boolean z) {
        this.f23753a.setMyLocationButtonEnabled(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f23753a.setScrollGesturesEnabled(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f23753a.setZoomGesturesEnabled(z);
    }

    public void setTiltGesturesEnabled(boolean z) {
        this.f23753a.setTiltGesturesEnabled(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f23753a.setRotateGesturesEnabled(z);
    }

    public void setAllGesturesEnabled(boolean z) {
        this.f23753a.setAllGesturesEnabled(z);
    }

    public boolean isZoomControlsEnabled() {
        return this.f23753a.isZoomControlsEnabled();
    }

    public boolean isCompassEnabled() {
        return this.f23753a.isCompassEnabled();
    }

    public boolean isMyLocationButtonEnabled() {
        return this.f23753a.isMyLocationButtonEnabled();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f23753a.isScrollGesturesEnabled();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f23753a.isZoomGesturesEnabled();
    }

    public boolean isTiltGesturesEnabled() {
        return this.f23753a.isTiltGesturesEnabled();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f23753a.isRotateGesturesEnabled();
    }

    public void setScaleAndLogoMode(int i) {
        this.f23755c.setLogoScaleShowMode(i);
    }

    public void setScaleViewLeft(int i) {
        this.f23755c.setScaleViewLeft(i);
    }

    public void setScaleViewBottom(int i) {
        this.f23755c.setScaleViewBottom(i);
    }

    public boolean isScaleVisable() {
        return this.f23755c.isScaleViewVisible();
    }

    public void setLogoLeftMargin(int i) {
        this.f23755c.setLogoViewLeft(i);
    }

    public void setLogoBottomMargin(int i) {
        this.f23755c.setLogoViewBottom(i);
    }
}
