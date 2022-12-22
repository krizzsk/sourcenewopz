package com.didi.map.global.flow.scene.order.serving;

import android.view.View;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public interface IServingController extends ISceneController {

    /* renamed from: com.didi.map.global.flow.scene.order.serving.IServingController$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$animateCamera(IServingController iServingController, CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
        }

        public static void $default$cancelPickupPointRecommend(IServingController iServingController) {
        }

        public static void $default$destroyMarkerBubble(IServingController iServingController, MapElementId mapElementId) {
        }

        public static LatLng $default$getLastDriverPosition(IServingController iServingController) {
            return null;
        }

        public static EtaEda $default$getLastEtaEda(IServingController iServingController) {
            return null;
        }

        public static double $default$getLeftRouteDistance(IServingController iServingController) {
            return -1.0d;
        }

        public static void $default$hideMarkerBubble(IServingController iServingController, MapElementId mapElementId) {
        }

        public static void $default$modifyDestination(IServingController iServingController, LatLng latLng) {
        }

        public static void $default$onOrderStateChanged(IServingController iServingController, int i, ServingParam servingParam) {
        }

        public static void $default$onPushMsgReceived(IServingController iServingController, byte[] bArr) {
        }

        public static void $default$onStartChangedForSharer(IServingController iServingController, GuideStartInfo guideStartInfo) {
        }

        public static boolean $default$refresh3DCarIcons(IServingController iServingController, boolean z, List list) {
            return false;
        }

        public static void $default$refreshCarBitmapDescriptor(IServingController iServingController, BitmapDescriptor bitmapDescriptor) {
        }

        public static void $default$setCarpoolInfo(IServingController iServingController, IFetchCarpoolInfo iFetchCarpoolInfo) {
        }

        public static void $default$setCarpoolShowBubblesEnabled(IServingController iServingController, boolean z) {
        }

        public static void $default$setInfoWindowClickListener(IServingController iServingController, MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener) {
        }

        public static void $default$setOdPoints(IServingController iServingController, List list, long j) {
        }

        public static void $default$startModifyPickupLocation(IServingController iServingController, Address address, Address address2, float f, ILocationCallback iLocationCallback) {
        }

        public static void $default$stopModifyPickupLocation(IServingController iServingController, LatLng latLng) {
        }

        public static void $default$updateMarkerBubble(IServingController iServingController, MapElementId mapElementId, View view) {
        }

        public static void $default$updateMarkerBubble(IServingController iServingController, MapElementId mapElementId, View view, InfoWindow.Position position) {
        }

        public static void $default$updatePickupPoint(IServingController iServingController, LatLng latLng) {
        }
    }

    void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback);

    void cancelPickupPointRecommend();

    void destroyMarkerBubble(MapElementId mapElementId);

    LatLng getLastDriverPosition();

    EtaEda getLastEtaEda();

    double getLeftRouteDistance();

    void hideMarkerBubble(MapElementId mapElementId);

    void modifyDestination(LatLng latLng);

    void onOrderStateChanged(int i, ServingParam servingParam);

    void onPushMsgReceived(byte[] bArr);

    void onStartChangedForSharer(GuideStartInfo guideStartInfo);

    boolean refresh3DCarIcons(boolean z, List<String> list);

    void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor);

    void setCarpoolInfo(IFetchCarpoolInfo iFetchCarpoolInfo);

    void setCarpoolShowBubblesEnabled(boolean z);

    void setInfoWindowClickListener(MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener);

    void setOdPoints(List<OdPoint> list, long j);

    void startModifyPickupLocation(Address address, Address address2, float f, ILocationCallback iLocationCallback);

    void stopModifyPickupLocation(LatLng latLng);

    void updateMarkerBubble(MapElementId mapElementId, View view);

    void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position);

    void updatePickupPoint(LatLng latLng);
}
