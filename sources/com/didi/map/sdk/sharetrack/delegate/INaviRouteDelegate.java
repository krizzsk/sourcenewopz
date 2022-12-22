package com.didi.map.sdk.sharetrack.delegate;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.proto.driver_gl.PickupHint;
import com.didi.map.sdk.sharetrack.entity.WayPoint;
import java.util.List;

public interface INaviRouteDelegate {

    /* renamed from: com.didi.map.sdk.sharetrack.delegate.INaviRouteDelegate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$avoidTolls(INaviRouteDelegate iNaviRouteDelegate) {
            return false;
        }

        public static int $default$getNaviAddtionalLine(INaviRouteDelegate iNaviRouteDelegate) {
            return 0;
        }

        public static List $default$getRouteSegmentList(INaviRouteDelegate iNaviRouteDelegate) {
            return null;
        }

        public static boolean $default$routeShorter(INaviRouteDelegate iNaviRouteDelegate) {
            return false;
        }
    }

    boolean avoidTolls();

    String getDistanceInfo();

    int getDstRouteGeoIndex();

    LineOptions.MultiColorLineInfo[] getLineColorInfos();

    String getNavEndPlaceId();

    int getNaviAddtionalLine();

    int getParkingStatus();

    PickupHint getPickUpHint();

    List<String> getRoadNames();

    LatLng getRouteDestPoint();

    String getRouteId();

    List<LatLng> getRoutePoints();

    String getRouteRecommendMsg();

    List<List<LatLng>> getRouteSegmentList();

    LatLng getRouteStartPoint();

    List<Integer> getRouteTrafficIndex();

    int getSegmentDistance(int i);

    int getSegmentSize();

    int getTime();

    List<LatLng> getTrafficInsertPoint();

    List<WayPoint> getWayPoints();

    boolean hasFeeSegment();

    boolean isNearby();

    boolean isRouteTypePersonal();

    boolean routeShorter();
}
