package com.dmap.navigation.base.route;

import com.didi.map.base.RouteSectionWithName;
import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.location.IPassPoint;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface IRoute {
    int getDistance();

    INaviPoi getEnd();

    int getLightCnt();

    List<INaviPoi> getOriginalPassPoints();

    int getReqEventType();

    List<RouteSectionWithName> getRoadnames();

    BigInteger getRouteId();

    List<IPassPoint> getRoutePassPoints();

    List<LatLng> getRoutePoints();

    ArrayList<Integer> getRouteTrafficIndex();

    INaviPoi getStart();

    LatLng getTagForPosition(String str);

    String getTagForValue(String str);

    int getTime();

    List<IToastInfo> getToastInfos();

    byte[] getTrafficEvent();

    ArrayList<LatLng> getTrafficInsertPoint();
}
