package com.dmap.navigation.api.core;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.location.INaviPoi;
import java.util.List;

public interface IOrderNaviAPI extends IBaseNaviAPI {
    INaviPlannerBuilder driverChangedDest(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2);

    INaviPlannerBuilder passengerChangedDest(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2);

    INaviPlannerBuilder syncPassengerRoute(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2);
}
