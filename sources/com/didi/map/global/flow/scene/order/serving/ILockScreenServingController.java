package com.didi.map.global.flow.scene.order.serving;

import android.view.View;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.List;

public interface ILockScreenServingController extends ISceneController {
    void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback);

    void destroyMarkerBubble(MapElementId mapElementId);

    LatLng getLastDriverPosition();

    EtaEda getLastEtaEda();

    double getLeftRouteDistance();

    void hideMarkerBubble(MapElementId mapElementId);

    void onPushMsgReceived(byte[] bArr);

    boolean refresh3DCarIcons(boolean z, List<String> list);

    void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor);

    void setCarpoolInfo(IFetchCarpoolInfo iFetchCarpoolInfo);

    void setCarpoolShowBubblesEnabled(boolean z);

    void setOdPoints(List<OdPoint> list, long j);

    void updateMarkerBubble(MapElementId mapElementId, View view);
}
