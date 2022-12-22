package com.didi.map.sdk.nav.car;

import com.didi.common.map.model.LatLng;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import java.util.List;

public interface AnimationPartInterface {

    /* renamed from: com.didi.map.sdk.nav.car.AnimationPartInterface$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$resetMapTilt(AnimationPartInterface animationPartInterface) {
        }
    }

    void destroy();

    double distanceLeft();

    void followMyLocation(boolean z);

    AnimateNode getCurrentAnimNode();

    void resetMapTilt();

    void setAnimationInterval(int i);

    void setCameraMode(CameraMode cameraMode);

    void setCameraMode(CameraMode cameraMode, boolean z);

    void setCarHeadMaxMapLevel(double d);

    void setCarHeadParams(int i, int i2);

    void setCarImageView(NavOverlay navOverlay);

    void setCarMarkerOrImageEnable(boolean z);

    void setIsBackground(boolean z);

    void setOnCarAnimationListener(onCarAnimationListener oncaranimationlistener);

    void setRoutePoints(List<LatLng> list);

    void start(AnimateNode animateNode);

    void start(AnimateNode animateNode, DMKEventPoint dMKEventPoint);

    void stop(onCarAnimationCancelListener oncaranimationcancellistener, boolean z);

    void zoomToNav();
}
