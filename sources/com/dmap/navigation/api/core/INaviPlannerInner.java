package com.dmap.navigation.api.core;

import com.dmap.navigation.api.core.INaviPlanner;
import com.dmap.navigation.base.route.IRoute;
import java.util.List;

public interface INaviPlannerInner extends INaviPlanner {

    public interface Callback extends INaviPlanner.Callback {
        void onFinish(INaviRequest iNaviRequest, INaviResponse iNaviResponse);
    }

    public interface INaviRequest {
        String getTraceId();

        int getYawType();
    }

    public interface INaviResponse {
        int getErrorCode();

        int getIsMultiRoute();

        List<IRoute> getRoutesList();

        byte[] getTrafficEventData();

        boolean isMandatory();
    }
}
