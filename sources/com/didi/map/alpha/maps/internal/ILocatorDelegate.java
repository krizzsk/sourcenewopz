package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.CompassDescriptor;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Locator;
import java.util.List;

public interface ILocatorDelegate {
    float getAngle();

    Rect getBound();

    Locator getLocator(LocatorControl locatorControl);

    int getNaviMode();

    RectF getPiexBound(float f);

    LatLng getPosition();

    Rect getScreenBound();

    boolean isCarVisible();

    boolean isCompassVisible();

    void navigateToPosition(boolean z, float f, float f2, float f3, float f4, float f5, List<LatLng> list, int i, int i2, LatLng latLng);

    void navigateToPosition(boolean z, LatLng latLng, float f);

    void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4);

    boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2);

    void setCarIcon(BitmapDescriptor bitmapDescriptor);

    void setCarVisible(boolean z);

    void setCarZIndex(float f);

    void setCompassIcon(CompassDescriptor compassDescriptor);

    void setCompassVisible(boolean z);

    void setCompassZIndex(float f);

    void setDestination(LatLng latLng);

    void setNaviMode(int i);

    void setPositionAndAngle(LatLng latLng, float f);

    void showGuideLine(boolean z);

    void stopNavigate();
}
