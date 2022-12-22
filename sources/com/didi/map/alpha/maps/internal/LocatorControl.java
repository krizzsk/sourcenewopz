package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.CompassDescriptor;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Locator;
import java.util.List;

public final class LocatorControl {

    /* renamed from: a */
    private final ILocatorDelegate f24536a;

    public void stopNavigate() {
    }

    public LocatorControl(ILocatorDelegate iLocatorDelegate) {
        this.f24536a = iLocatorDelegate;
    }

    public void setCarVisible(boolean z) {
        this.f24536a.setCarVisible(z);
    }

    public boolean isCarVisible() {
        return this.f24536a.isCarVisible();
    }

    public boolean isCompassVisible() {
        return this.f24536a.isCompassVisible();
    }

    public void setCompassVisible(boolean z) {
        this.f24536a.setCompassVisible(z);
    }

    public void setPositionAndAngle(LatLng latLng, float f) {
        this.f24536a.setPositionAndAngle(latLng, f);
    }

    public LatLng getPosition() {
        return this.f24536a.getPosition();
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f24536a.setCarIcon(bitmapDescriptor);
    }

    public RectF getPiexBound(float f) {
        return this.f24536a.getPiexBound(f);
    }

    public void setCompassIcon(CompassDescriptor compassDescriptor) {
        this.f24536a.setCompassIcon(compassDescriptor);
    }

    public Locator getLocator() {
        return this.f24536a.getLocator(this);
    }

    public float getAngle() {
        return this.f24536a.getAngle();
    }

    public void setCarZIndex(float f) {
        this.f24536a.setCarZIndex(f);
    }

    public void setCompassZIndex(float f) {
        this.f24536a.setCompassZIndex(f);
    }

    public void setNaviMode(int i) {
        this.f24536a.setNaviMode(i);
    }

    public int getNaviMode() {
        return this.f24536a.getNaviMode();
    }

    public Rect getBound() {
        return this.f24536a.getBound();
    }

    public Rect getScreenBound() {
        return this.f24536a.getScreenBound();
    }

    public void showGuideLine(boolean z) {
        this.f24536a.showGuideLine(z);
    }

    public void setDestination(LatLng latLng) {
        this.f24536a.setDestination(latLng);
    }

    public boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2) {
        return this.f24536a.navigateToPosition(z, latLng, f, f2, i, i2, z2, j, j2);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f) {
        this.f24536a.navigateToPosition(z, latLng, f);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4) {
        this.f24536a.navigateToPosition(z, latLng, f, f2, f3, f4);
    }

    public void navigateToPosition(boolean z, float f, float f2, float f3, float f4, float f5, List<LatLng> list, int i, int i2, LatLng latLng) {
        this.f24536a.navigateToPosition(z, f, f2, f3, f4, f5, list, i, i2, latLng);
    }
}
