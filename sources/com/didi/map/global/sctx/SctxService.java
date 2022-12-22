package com.didi.map.global.sctx;

import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.List;

public interface SctxService {

    public interface SctxCallback {

        /* renamed from: com.didi.map.global.sctx.SctxService$SctxCallback$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onWayPointsStateUpdateForMiniBus(SctxCallback sctxCallback, List list) {
            }

            public static void $default$orderChanged(SctxCallback sctxCallback) {
            }
        }

        void goingOffCourse();

        void onAbnormalOrderStageCallback(int i);

        void onEtaEdaUpdate(EtaEdaInfo etaEdaInfo);

        void onMatched(LatLng latLng);

        void onRouteAnimationEnd();

        void onRouteAnimationStart();

        void onSctxStateUpdate(SctxStateInfo sctxStateInfo);

        void onStartDestinationUpdate(LatLng latLng, LatLng latLng2);

        void onSyncFail(Exception exc);

        void onSyncStart();

        void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes);

        void onWayPointsStateUpdate(boolean z, List<OdPoint> list);

        void onWayPointsStateUpdateForMiniBus(List<OdPoint> list);

        void orderChanged();

        void selectedPickupPoint(LatLng latLng);

        void showSecRouteInfoCallback(SecRouteInfoEx secRouteInfoEx, boolean z);
    }

    public static abstract class SctxCallbackAdapter implements SctxCallback {
        public void goingOffCourse() {
        }

        public void onAbnormalOrderStageCallback(int i) {
        }

        public void onEtaEdaUpdate(EtaEdaInfo etaEdaInfo) {
        }

        public void onMatched(LatLng latLng) {
        }

        public void onRouteAnimationEnd() {
        }

        public void onRouteAnimationStart() {
        }

        public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
        }

        public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
        }

        public void onSyncFail(Exception exc) {
        }

        public void onSyncStart() {
        }

        public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        }

        public void onWayPointsStateUpdate(boolean z, List<OdPoint> list) {
        }

        public /* synthetic */ void onWayPointsStateUpdateForMiniBus(List<OdPoint> list) {
            SctxCallback.CC.$default$onWayPointsStateUpdateForMiniBus(this, list);
        }

        public /* synthetic */ void orderChanged() {
            SctxCallback.CC.$default$orderChanged(this);
        }

        public void selectedPickupPoint(LatLng latLng) {
        }

        public void showSecRouteInfoCallback(SecRouteInfoEx secRouteInfoEx, boolean z) {
        }
    }

    public interface SctxMapElementTags {
        public static final String CAR_MARKER = "tag_car_marker";
        public static final String ROUTE_PLAN = "tag_route_plan";
    }

    public interface SctxOraNetAgent {
        byte[] doRequestInBackground(byte[] bArr);

        byte[] getRequestBody();
    }

    public interface SctxSearchGetter {
        String getPageReferrer();

        String getUserId();

        String getUserRole();
    }

    void cancelPickupPointRecommend();

    void chooseLine(int i);

    void enter();

    CarMarker getCarMarker();

    LatLng getDriverPoint();

    List<Line> getLines();

    double getRemainingRouteDistance();

    List<LatLng> getRemainingRoutePoints();

    long getRouteId();

    List<LatLng> getRoutePoints();

    void leave();

    void pause();

    void registerSctxCallback(SctxCallback sctxCallback);

    void resume();

    boolean set3DCarIcons(boolean z, List<String> list);

    void setCarIcon(BitmapDescriptor bitmapDescriptor);

    void setOraRequestInterval(long j);

    void setSctxOraNetAgent(SctxOraNetAgent sctxOraNetAgent);

    void setWayPoints(List<OdPoint> list, long j);

    void showRecommendPickupPoint(boolean z);

    void unRegisterSctxCallback(SctxCallback sctxCallback);

    void update(SctxTripParam sctxTripParam);

    void updateDestination(LatLng latLng);

    void updatePickupPoint(LatLng latLng);
}
