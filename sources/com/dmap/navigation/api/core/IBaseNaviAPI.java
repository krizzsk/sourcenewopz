package com.dmap.navigation.api.core;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.route.IRoute;
import java.math.BigInteger;
import java.util.List;

public interface IBaseNaviAPI {
    INaviPlannerBuilder arrivedDestination();

    INaviPlannerBuilder elevatedRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2);

    INaviPlannerBuilder firstRoute(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, int i);

    INaviPlannerBuilder multiRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2, String str, int i3, int i4);

    INaviPlannerBuilder parallelRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2);

    INaviTrafficUpdater updateTraffic(IRoute iRoute, INaviLocation iNaviLocation, int i, List<BigInteger> list);

    INaviPlannerBuilder yawRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2, int i3);
}
