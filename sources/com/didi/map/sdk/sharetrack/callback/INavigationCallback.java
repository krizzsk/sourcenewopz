package com.didi.map.sdk.sharetrack.callback;

import android.location.Location;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.sharetrack.entity.DiDiRouteSegment;
import com.didi.map.sdk.sharetrack.entity.DiDiTimeAndDistance;
import java.util.List;

public interface INavigationCallback {
    void onApproaching(int i);

    void onArriveDestination();

    void onCameraModeChanged(CameraMode cameraMode);

    void onDriveAway();

    void onNaviVoice(String str, int i);

    void onNavigationCodeUpdate(int i);

    void onOffRoute();

    void onRemainingTimeOrDistanceChanged();

    void onResetView();

    void onRoadSnappedLocationChanged(GpsLocation gpsLocation);

    void onSctxSetRouteToLightNav_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location);

    void onSctxUploadAllData_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location, boolean z);

    void onStartNavSuccess();

    void onViaPointExpired(List<LatLng> list, long j);

    void startLightNavSctx_Google();
}
