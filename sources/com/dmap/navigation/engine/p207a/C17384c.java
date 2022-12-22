package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.api.core.INaviPlannerBuilder;
import com.dmap.navigation.api.core.IOrderNaviAPI;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.jni.sub.NaviLocationListNative;
import com.dmap.navigation.jni.sub.NaviPoiListNative;
import com.dmap.navigation.jni.sub.NaviPoiNative;
import com.dmap.navigation.jni.swig.FirstRetryStrategy;
import com.dmap.navigation.jni.swig.NaviBusinessBridge;
import com.dmap.navigation.jni.swig.NaviOption;
import com.dmap.navigation.jni.swig.OrderInfo;
import com.dmap.navigation.jni.swig.OrderNaviAPI;
import com.dmap.navigation.jni.swig.ReqRouteInfo;
import com.dmap.navigation.jni.swig.RetryStrategy;
import com.dmap.navigation.jni.swig.UserInfo;
import java.math.BigInteger;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.c */
/* compiled from: OrderNaviAPIImpl */
public final class C17384c extends C17374a<OrderNaviAPI> implements IOrderNaviAPI {
    public C17384c(INaviContext iNaviContext) {
        super(iNaviContext, new OrderNaviAPI((UserInfo) iNaviContext.getUserInfo(), (OrderInfo) iNaviContext.getOrderInfo(), (NaviOption) iNaviContext.getNaviOption()));
    }

    public final INaviPlannerBuilder syncPassengerRoute(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_SYNC_PASSENGER_ROUTE());
        m37026a(iNaviPoi, iNaviPoi2, list, list2);
        return this;
    }

    public final INaviPlannerBuilder passengerChangedDest(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_PASSENGER_CHANGED_DESTINATION());
        m37026a(iNaviPoi, iNaviPoi2, list, list2);
        return this;
    }

    public final INaviPlannerBuilder driverChangedDest(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_DRIVER_CHANGED_DESTINATION());
        m37026a(iNaviPoi, iNaviPoi2, list, list2);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final RetryStrategy mo125493a(int i) {
        if (i == NaviBusinessBridge.getAPI_PASSENGER_CHANGED_DESTINATION() || i == NaviBusinessBridge.getAPI_SYNC_PASSENGER_ROUTE() || i == NaviBusinessBridge.getAPI_DRIVER_CHANGED_DESTINATION()) {
            return new FirstRetryStrategy();
        }
        return super.mo125493a(i);
    }

    /* renamed from: a */
    private void m37026a(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, List<INaviLocation> list2) {
        this.f51731a.setStart(new NaviPoiNative(iNaviPoi));
        this.f51731a.setEnd(new NaviPoiNative(iNaviPoi2));
        this.f51731a.setPassPoints(new NaviPoiListNative(list));
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(BigInteger.ZERO);
        reqRouteInfo.setPassfork(0);
        this.f51731a.setCurrentRoute(reqRouteInfo);
        if (list2 != null && list2.size() > 0) {
            this.f51731a.setHistoryPoints(new NaviLocationListNative(list2));
        }
    }
}
