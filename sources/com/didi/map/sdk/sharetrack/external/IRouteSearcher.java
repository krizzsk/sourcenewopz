package com.didi.map.sdk.sharetrack.external;

import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Line;
import com.didi.map.sdk.nav.util.MapMargins;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public abstract class IRouteSearcher {
    public abstract void destroy();

    public abstract Line getLine();

    public void onNewMargin(MapMargins mapMargins) {
    }

    public abstract void setCaller(CallFrom callFrom);

    public abstract void setDiDiMap(Map map);

    public abstract void setLineVisible(boolean z);

    public abstract void setOrderInfo(OrderInfo orderInfo);

    public abstract void start(RouteSearchOptions routeSearchOptions);

    public abstract void stop();

    public abstract void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, boolean z);
}
