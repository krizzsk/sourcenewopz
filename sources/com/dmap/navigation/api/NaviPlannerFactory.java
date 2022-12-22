package com.dmap.navigation.api;

import com.dmap.navigation.api.core.INaviPlanner;
import com.dmap.navigation.api.core.impl.NaviAPIFactory;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviPoi;
import java.util.List;

public final class NaviPlannerFactory {
    private NaviPlannerFactory() {
    }

    public static INaviPlanner createNormalNaviPlanner(INaviContext iNaviContext, INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, int i) {
        return NaviAPIFactory.createNormalNaviAPI(iNaviContext).firstRoute(iNaviPoi, iNaviPoi2, list, i).build();
    }

    public static INaviPlanner createOrderNaviPlanner(INaviContext iNaviContext, INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list) {
        return NaviAPIFactory.createOrderNaviAPI(iNaviContext).firstRoute(iNaviPoi, iNaviPoi2, list, 0).build();
    }
}
