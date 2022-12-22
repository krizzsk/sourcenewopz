package com.didi.map.sdk.nav.car;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import java.util.List;

public interface IMyLocationDelegate {
    void animateCancel(onCarAnimationCancelListener oncaranimationcancellistener);

    void animateTo(AnimateNode animateNode);

    void animateTo(AnimateNode animateNode, DMKEventPoint dMKEventPoint);

    void destroy();

    double distanceLeft();

    void followMyLocation(boolean z);

    AnimationPartInterface getCarAnimator();

    NavOverlay getCarImage();

    CarMarker getCarMarker();

    AnimateNode getCurrentAnimNode();

    void onNewMargin(int i, int i2, int i3, int i4);

    boolean refresh3DCarIcons(boolean z, List<String> list);

    void set3DCarEnabled(boolean z);

    void set3DCarIcons(List<String> list);

    void setAnimationInterval(int i);

    void setCameraMode(CameraMode cameraMode);

    void setCarAnimationListener(onCarAnimationListener oncaranimationlistener);

    void setCarHeadMaxMapLevel(double d);

    void setCarMarkerOptions(String str, MarkerOptions markerOptions);

    void setCarMarkerOrImageEnable(boolean z);

    void setIsBackground(boolean z);

    void setIsPassenger(boolean z);

    void setNavRoutePoints(List<LatLng> list, boolean z);

    void zoomToNav();
}
