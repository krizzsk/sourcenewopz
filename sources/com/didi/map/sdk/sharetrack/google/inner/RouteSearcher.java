package com.didi.map.sdk.sharetrack.google.inner;

import android.content.Context;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didi.map.sdk.sharetrack.google.inner.net.NormalRouteFetcherV2;
import com.didichuxing.routesearchsdk.CallFrom;

public class RouteSearcher {

    /* renamed from: a */
    private static final String f28810a = "RouteSearcher";

    /* renamed from: b */
    private Context f28811b;

    /* renamed from: c */
    private NormalRouteFetcherV2 f28812c;

    /* renamed from: d */
    private OrderInfo f28813d;

    /* renamed from: e */
    private CallFrom f28814e = CallFrom.UNKNOWN;

    public void stop() {
    }

    public RouteSearcher(Context context) {
        NetUtils.init(context);
        this.f28811b = context;
        this.f28812c = new NormalRouteFetcherV2(context);
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f28813d = orderInfo;
    }

    public void calculateRoute(RouteSearchOptions routeSearchOptions, ISearchRouteCallback iSearchRouteCallback) {
        NormalRouteFetcherV2 normalRouteFetcherV2;
        if (routeSearchOptions != null && (normalRouteFetcherV2 = this.f28812c) != null) {
            normalRouteFetcherV2.setOrderInfo(this.f28813d);
            this.f28812c.setCaller(this.f28814e);
            this.f28812c.calculateRoute(routeSearchOptions, iSearchRouteCallback);
        }
    }

    public void destroy() {
        stop();
        this.f28812c = null;
    }

    public void setCaller(CallFrom callFrom) {
        if (callFrom != null) {
            this.f28814e = callFrom;
        }
    }
}
