package com.didi.map.sdk.sharetrack.google;

import android.content.Context;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Padding;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.nav.util.MapMargins;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didi.map.sdk.sharetrack.external.IRouteSearcher;
import com.didi.map.sdk.sharetrack.google.inner.RouteSearcher;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.List;

public class GGRouteSearcherImpl extends IRouteSearcher {
    private static final String TAG = "GGRouteSearcherImpl";
    private CallFrom mCaller = CallFrom.UNKNOWN;
    private Context mContext;
    /* access modifiers changed from: private */
    public boolean mLineVisible = true;
    /* access modifiers changed from: private */
    public Map mMap;
    private MapMargins mMapMargins;
    /* access modifiers changed from: private */
    public MultiLine mMultiPolyline;
    private RouteSearcher mRouteSearcher;
    /* access modifiers changed from: private */
    public boolean mWorking;

    public GGRouteSearcherImpl(Context context) {
        this.mContext = context;
        this.mRouteSearcher = new RouteSearcher(context);
    }

    public void setDiDiMap(Map map) {
        this.mMap = map;
    }

    public void start(final RouteSearchOptions routeSearchOptions) {
        RouteSearcher routeSearcher = this.mRouteSearcher;
        if (routeSearcher != null && routeSearchOptions != null) {
            this.mWorking = true;
            routeSearcher.setCaller(this.mCaller);
            this.mRouteSearcher.calculateRoute(routeSearchOptions, new ISearchRouteCallback() {
                public void onBeginToSearch() {
                    DLog.m20357d(GGRouteSearcherImpl.TAG, "calculateRoute,onBeginToSearch", new Object[0]);
                    RouteSearchOptions routeSearchOptions = routeSearchOptions;
                    if (routeSearchOptions != null && routeSearchOptions.callback != null) {
                        routeSearchOptions.callback.onBeginToSearch();
                    }
                }

                public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
                    if (GGRouteSearcherImpl.this.mWorking) {
                        if (arrayList == null || arrayList.size() <= 0) {
                            DLog.m20357d(GGRouteSearcherImpl.TAG, "calculateRoute,onFinishToSearch,fail", new Object[0]);
                            RouteSearchOptions routeSearchOptions = routeSearchOptions;
                            if (routeSearchOptions != null && routeSearchOptions.callback != null) {
                                routeSearchOptions.callback.onFinishToSearch((ArrayList<NaviRoute>) null, str);
                                return;
                            }
                            return;
                        }
                        NaviRoute naviRoute = arrayList.get(0);
                        if (!(GGRouteSearcherImpl.this.mMap == null || naviRoute == null || naviRoute.getRoutePoints() == null || naviRoute.getRoutePoints().size() <= 1)) {
                            LineOptions width = new LineOptions().color(routeSearchOptions.lineColor).width((double) routeSearchOptions.lineWidth);
                            width.clickable(false);
                            width.visible(GGRouteSearcherImpl.this.mLineVisible);
                            width.addAll(naviRoute.getRoutePoints());
                            MultiLine multiLine = new MultiLine(GGRouteSearcherImpl.this.mMap);
                            multiLine.setOptions(routeSearchOptions.currentLineOptions, routeSearchOptions.remainLineOptions);
                            multiLine.setPoints(naviRoute.getRoutePoints());
                            multiLine.setVisible(true);
                            multiLine.init(naviRoute.getDstRouteGeoIndex());
                            if (!(GGRouteSearcherImpl.this.mMap == null || GGRouteSearcherImpl.this.mMultiPolyline == null)) {
                                GGRouteSearcherImpl.this.mMultiPolyline.remove();
                                DLog.m20357d(GGRouteSearcherImpl.TAG, "calculateRoute,onFinishToSearch,remove old line", new Object[0]);
                            }
                            MultiLine unused = GGRouteSearcherImpl.this.mMultiPolyline = multiLine;
                        }
                        RouteSearchOptions routeSearchOptions2 = routeSearchOptions;
                        if (routeSearchOptions2 != null && routeSearchOptions2.callback != null) {
                            routeSearchOptions.callback.onFinishToSearch(arrayList, str);
                            DLog.m20357d(GGRouteSearcherImpl.TAG, "calculateRoute,onFinishToSearch,ok", new Object[0]);
                        }
                    }
                }
            });
            DLog.m20357d(TAG, "GGRouteSearcherImpl,start", new Object[0]);
        }
    }

    public void stop() {
        RouteSearcher routeSearcher = this.mRouteSearcher;
        if (routeSearcher != null) {
            routeSearcher.stop();
        }
        this.mWorking = false;
    }

    public void destroy() {
        MultiLine multiLine = this.mMultiPolyline;
        if (!(multiLine == null || this.mMap == null)) {
            multiLine.remove();
            this.mMultiPolyline = null;
        }
        RouteSearcher routeSearcher = this.mRouteSearcher;
        if (routeSearcher != null) {
            routeSearcher.destroy();
        }
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        RouteSearcher routeSearcher = this.mRouteSearcher;
        if (routeSearcher != null) {
            routeSearcher.setOrderInfo(orderInfo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setOrderInfo:");
        sb.append(orderInfo == null ? "null" : orderInfo.toString());
        DLog.m20357d(TAG, sb.toString(), new Object[0]);
    }

    public void setLineVisible(boolean z) {
        MultiLine multiLine = this.mMultiPolyline;
        if (multiLine != null) {
            multiLine.setVisible(z);
        }
        this.mLineVisible = z;
    }

    public void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, boolean z) {
        ArrayList arrayList = new ArrayList();
        MultiLine multiLine = this.mMultiPolyline;
        if (multiLine != null && this.mLineVisible) {
            if (multiLine.mFirstLine != null) {
                arrayList.add(this.mMultiPolyline.mFirstLine);
            }
            if (this.mMultiPolyline.mSecondLine != null) {
                arrayList.add(this.mMultiPolyline.mSecondLine);
            }
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        Padding padding = new Padding();
        MapMargins mapMargins = this.mMapMargins;
        if (mapMargins != null) {
            padding.bottom = mapMargins.bottom;
            padding.top = this.mMapMargins.top;
            padding.left = this.mMapMargins.left;
            padding.right = this.mMapMargins.right;
        }
        Map map = this.mMap;
        if (map != null) {
            BestViewer.doBestView(map, z, (List<IMapElement>) arrayList, padding, new Padding(i, i3, i2, i4), (BestViewer.IBestViewListener) null);
        }
    }

    public Line getLine() {
        MultiLine multiLine = this.mMultiPolyline;
        if (multiLine != null) {
            return multiLine.mFirstLine;
        }
        return null;
    }

    public void setCaller(CallFrom callFrom) {
        if (callFrom != null) {
            this.mCaller = callFrom;
        }
    }

    public void onNewMargin(MapMargins mapMargins) {
        this.mMapMargins = mapMargins;
    }
}
