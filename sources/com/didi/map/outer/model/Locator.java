package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.LocatorControl;
import java.util.List;

public final class Locator implements IMapElement {
    public static final int CAR_FOLLOW = 2;
    public static final int CAR_UP_FOLLOW = 1;
    public static final int NORMAL = 0;

    /* renamed from: a */
    private final LocatorControl f27939a;

    public Locator(LocatorControl locatorControl) {
        this.f27939a = locatorControl;
    }

    public Rect getBound() {
        return this.f27939a.getBound();
    }

    public RectF getPixel20Bound(float f) {
        return this.f27939a.getPiexBound(f);
    }

    public Rect getScrrenBound() {
        return this.f27939a.getScreenBound();
    }

    public boolean isCompassVisible() {
        return this.f27939a.isCompassVisible();
    }

    public void setCompassVisible(boolean z) {
        this.f27939a.setCompassVisible(z);
    }

    public boolean isCarVisible() {
        return this.f27939a.isCarVisible();
    }

    public void setCarVisible(boolean z) {
        this.f27939a.setCarVisible(z);
    }

    public LatLng getPosition() {
        return this.f27939a.getPosition();
    }

    public void setPositionAndAngle(LatLng latLng, float f) {
        this.f27939a.setPositionAndAngle(latLng, f);
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f27939a.setCarIcon(bitmapDescriptor);
    }

    public RectF getPiexBound(float f) {
        return this.f27939a.getPiexBound(f);
    }

    public void setCompassIcon(CompassDescriptor compassDescriptor) {
        this.f27939a.setCompassIcon(compassDescriptor);
    }

    public void setCarZIndex(float f) {
        this.f27939a.setCarZIndex(f);
    }

    public float getAngle() {
        return this.f27939a.getAngle();
    }

    public void setCompassZIndex(float f) {
        this.f27939a.setCompassZIndex(f);
    }

    public void setNaviMode(int i) {
        this.f27939a.setNaviMode(i);
    }

    public int getNaviMode() {
        return this.f27939a.getNaviMode();
    }

    public void showGuideLine(boolean z) {
        this.f27939a.showGuideLine(z);
    }

    public void setDestination(LatLng latLng) {
        this.f27939a.setDestination(latLng);
    }

    public boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2) {
        return this.f27939a.navigateToPosition(z, latLng, f, f2, i, i2, z2, j, j2);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f) {
        this.f27939a.navigateToPosition(z, latLng, f);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4) {
        this.f27939a.navigateToPosition(z, latLng, 360.0f - f, 360.0f - f2, f3, f4);
    }

    public void navigateToPosition(boolean z, float f, float f2, float f3, float f4, float f5, List<LatLng> list, int i, int i2, LatLng latLng) {
        this.f27939a.navigateToPosition(z, 360.0f - f, 360.0f - f2, f3, f4, f5, list, i, i2, latLng);
    }

    public void stopNavigate() {
        this.f27939a.stopNavigate();
    }
}
