package com.dmap.navigation.api.core;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.route.IRoute;

public interface INormalNaviAPI extends IBaseNaviAPI {
    INaviPlannerBuilder extremeSpeedRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2);

    INaviPlannerBuilder preferenceRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2);
}
