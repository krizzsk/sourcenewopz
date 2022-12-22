package com.didi.map.global.flow.scene.vamos.sctx.passenger;

import android.view.View;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.ISceneController;
import java.util.List;

public interface IVamosPssengerSctxSceneController extends ISceneController {
    void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback);

    void destroyCarMarkerInfoWindow();

    void destroyEndMarkerInfoWindow();

    void destroyStartMarkerInfoWindow();

    LatLng getDriverPoint();

    EtaEda getEtaEda();

    double getRemainingRouteDistance();

    void hideCarMarkerInfoWindow();

    void hideEndMarkerInfoWindow();

    void hideStartMarkerInfoWindow();

    boolean isUserLocationVisible();

    void onPushMsgReceived(byte[] bArr);

    boolean refresh3DCarIcons(boolean z, List<String> list);

    void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor);

    void refreshStartEndMarker(LatLng latLng, LatLng latLng2);

    void setCarMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setEndMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setStartMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void showCarMarkerInfoWindow(View view);

    void showEndMarkerInfoWindow(View view);

    void showStartMarkerInfoWindow(View view);

    void updateDestination(LatLng latLng);
}
