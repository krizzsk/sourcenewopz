package com.didi.component.routeguide;

import com.didi.component.core.IView;

public interface IRouteGuideView extends IView<AbsRouteGuidePresenter> {
    void updateData(RouteGuideData routeGuideData);
}
