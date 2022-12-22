package com.didi.map.sdk.sharetrack.google.inner.net;

import android.content.Context;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.OidPidPair;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.CommonConverter;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didi.map.sdk.sharetrack.google.inner.model.RoutePlanWrapper;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.sdk.sharetrack.net.DUrl;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.IRouteSearchApi;
import com.didichuxing.routesearchsdk.IRouteSearchCallback;
import com.didichuxing.routesearchsdk.RouteSearchApiFactory;
import com.didichuxing.routesearchsdk.RouteSearchParam;
import java.util.ArrayList;
import java.util.List;

public class NormalRouteFetcherV2 {

    /* renamed from: a */
    private OrderInfo f28858a;

    /* renamed from: b */
    private Context f28859b;

    /* renamed from: c */
    private CallFrom f28860c = CallFrom.UNKNOWN;

    /* renamed from: d */
    private final String f28861d = "NormalRouteFetcherV2";

    /* renamed from: e */
    private IRouteSearchApi f28862e;

    public NormalRouteFetcherV2(Context context) {
        this.f28859b = context;
        this.f28862e = RouteSearchApiFactory.createRouteSearch(context, DUrl.getDomainURL(context));
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f28858a = orderInfo;
    }

    public void calculateRoute(RouteSearchOptions routeSearchOptions, ISearchRouteCallback iSearchRouteCallback) {
        RouteSearchOptions routeSearchOptions2 = routeSearchOptions;
        if (routeSearchOptions2 == null || routeSearchOptions2.destination == null || routeSearchOptions2.start == null) {
            DLog.m20357d("NormalRouteFetcherV2", "[calculateRoute] return", new Object[0]);
            return;
        }
        OidPidPair.Builder builder = new OidPidPair.Builder();
        OrderInfo orderInfo = this.f28858a;
        String str = "";
        OidPidPair.Builder orderId = builder.orderId(orderInfo == null ? str : orderInfo.getOrderId());
        OrderInfo orderInfo2 = this.f28858a;
        if (orderInfo2 != null) {
            str = String.valueOf(orderInfo2.getPassengerId());
        }
        OidPidPair build = orderId.passengerId(str).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        List<OdPoint> convertOrderPoints2OdPoints = CommonConverter.Companion.convertOrderPoints2OdPoints(routeSearchOptions2.orderPoints);
        RouteSearchParam.Builder builder2 = r5;
        RouteSearchParam.Builder builder3 = new RouteSearchParam.Builder(RouteSearchParam.BizType.GLOBAL, routeSearchOptions2.start.latitude, routeSearchOptions2.start.longitude, routeSearchOptions2.destination.latitude, routeSearchOptions2.destination.longitude, PlatInfo.getInstance().getDriverTicket());
        RouteSearchParam.Builder countryId = builder2.setCaller(this.f28860c).setPhoneNum(PlatInfo.getInstance().getDriverPhoneNumber()).setProductId(String.valueOf(PlatInfo.getInstance().getBizType())).setCountryId(PlatInfo.getInstance().getCountryCode());
        OrderInfo orderInfo3 = this.f28858a;
        RouteSearchParam build2 = countryId.setOrderStage(orderInfo3 == null ? 0 : orderInfo3.getOrderStage()).setOidPidPairsList(arrayList).setDriverId(PlatInfo.getInstance().getDriverId()).setOdPoints(convertOrderPoints2OdPoints).build();
        final ISearchRouteCallback iSearchRouteCallback2 = iSearchRouteCallback;
        this.f28862e.calculateRoute(build2, new IRouteSearchCallback() {
            public void onBeginToSearch() {
                DLog.m20357d("NormalRouteFetcherV2", "[calculateRoute] onBeginToSearch", new Object[0]);
                ISearchRouteCallback iSearchRouteCallback = iSearchRouteCallback2;
                if (iSearchRouteCallback != null) {
                    iSearchRouteCallback.onBeginToSearch();
                }
            }

            public void onFinishToSearch(RoutePlanRes routePlanRes, String str) {
                String str2;
                String str3;
                DLog.m20357d("NormalRouteFetcherV2", "[calculateRoute] onFinishToSearch", new Object[0]);
                if (iSearchRouteCallback2 != null) {
                    ArrayList arrayList = new ArrayList();
                    if (routePlanRes != null) {
                        arrayList.add(new NaviRoute(new RoutePlanWrapper(routePlanRes)));
                    }
                    Object[] objArr = new Object[2];
                    String str4 = "";
                    if (routePlanRes == null) {
                        str2 = str4;
                    } else {
                        str2 = str4 + routePlanRes.ret;
                    }
                    objArr[0] = str2;
                    if (routePlanRes == null) {
                        str3 = str4;
                    } else {
                        str3 = str4 + routePlanRes.msg;
                    }
                    objArr[1] = str3;
                    DLog.m20357d("NormalRouteFetcherV2", "NormalRouteFetcherV2 onFinishToSearch ,%s , %s", objArr);
                    ISearchRouteCallback iSearchRouteCallback = iSearchRouteCallback2;
                    if (routePlanRes != null) {
                        str4 = str4 + routePlanRes.ret;
                    }
                    iSearchRouteCallback.onFinishToSearch(arrayList, str4);
                }
            }
        });
    }

    public void setCaller(CallFrom callFrom) {
        this.f28860c = callFrom;
    }
}
