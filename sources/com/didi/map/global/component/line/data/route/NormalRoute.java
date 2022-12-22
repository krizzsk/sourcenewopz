package com.didi.map.global.component.line.data.route;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.cache.LineCacheInstance;
import com.didi.map.global.component.line.data.param.RouteLineRequest;
import com.didi.map.global.model.URLHelper;
import com.didi.map.global.model.omega.AlarmOmegaUtil;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.OidPidPair;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.IRouteSearchCallback;
import com.didichuxing.routesearchsdk.RouteSearchApiFactory;
import com.didichuxing.routesearchsdk.RouteSearchParam;
import java.util.ArrayList;
import java.util.Collection;

public class NormalRoute extends BaseLineRoute<RouteLineRequest> {
    public static final String TAG = "NormalRoute";

    public void start(RouteLineRequest routeLineRequest, IRouteSearchResultCallback iRouteSearchResultCallback) {
        IRouteSearchResultCallback iRouteSearchResultCallback2 = iRouteSearchResultCallback;
        if (checkCommonParamIsRight(routeLineRequest, iRouteSearchResultCallback)) {
            LatLng start = routeLineRequest.getStart();
            final LatLng end = routeLineRequest.getEnd();
            if (start == null) {
                DLog.m7384d(TAG, "start is null", new Object[0]);
            } else if (end == null) {
                DLog.m7384d(TAG, "end is null", new Object[0]);
            } else {
                if (isCacheEnable()) {
                    RoutePlanRes routeInCache = LineCacheInstance.getCacheInstance().getRouteInCache(routeLineRequest);
                    if (routeInCache != null) {
                        if (iRouteSearchResultCallback2 != null) {
                            if (routeInCache != null) {
                                DLog.m7384d(TAG, "获取缓存路线数据--》" + routeInCache.msg, new Object[0]);
                            }
                            iRouteSearchResultCallback2.onGetRouteResult(packageResponse(routeInCache));
                            return;
                        }
                        return;
                    }
                } else {
                    RouteLineRequest routeLineRequest2 = routeLineRequest;
                }
                RouteSearchParam.BizType bizType = RouteSearchParam.BizType.GLOBAL;
                double d = start.latitude;
                double d2 = start.longitude;
                String str = TAG;
                LatLng latLng = start;
                RouteSearchParam.Builder builder = new RouteSearchParam.Builder(bizType, d, d2, end.latitude, end.longitude, PaxEnvironment.getInstance().getToken());
                builder.setProductId(String.valueOf(PaxEnvironment.getInstance().getProductId()));
                builder.setPhoneNum(PaxEnvironment.getInstance().getPhoneNumber());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new OidPidPair(TextUtils.isEmpty(routeLineRequest.getOrderId()) ? "" : routeLineRequest.getOrderId(), PaxEnvironment.getInstance().getUid()));
                builder.setOidPidPairsList(arrayList);
                builder.setBizGroup(routeLineRequest.getBizGroup());
                builder.setCountryId(PaxEnvironment.getInstance().getCountryCode());
                if (routeLineRequest.getTravelMode() == null) {
                    builder.setTravelMode(routeLineRequest.getTravelMode());
                } else {
                    builder.setTravelMode(TravelMode.DRIVING);
                }
                builder.setOdPoints(convertToOdPoints(routeLineRequest.getWayPoint()));
                final CallFrom callFrom = routeLineRequest.getCallFrom();
                builder.setCaller(callFrom);
                try {
                    final RouteLineRequest routeLineRequest3 = routeLineRequest;
                    final IRouteSearchResultCallback iRouteSearchResultCallback3 = iRouteSearchResultCallback;
                    final LatLng latLng2 = latLng;
                    RouteSearchApiFactory.createRouteSearch(getContext(), URLHelper.getUrlHost(getContext())).calculateRoute(builder.build(), new IRouteSearchCallback() {
                        public void onBeginToSearch() {
                            DLog.m7384d(NormalRoute.TAG, "createRouteSearch", new Object[0]);
                        }

                        public void onFinishToSearch(RoutePlanRes routePlanRes, String str) {
                            if (!NormalRoute.this.isDestroy()) {
                                DLog.m7384d(NormalRoute.TAG, "onFinishToSearch", new Object[0]);
                                if (routePlanRes != null) {
                                    DLog.m7384d(NormalRoute.TAG, "获取路线数据结果--》" + routePlanRes.msg, new Object[0]);
                                    if (!CollectionUtil.isEmpty((Collection<?>) routePlanRes.routeGeos)) {
                                        LineCacheInstance.getCacheInstance().addRouteToCache(new LineCacheInstance.NormalLineCache(routeLineRequest3, routePlanRes));
                                    }
                                }
                                if (iRouteSearchResultCallback3 != null) {
                                    iRouteSearchResultCallback3.onGetRouteResult(NormalRoute.this.packageResponse(routePlanRes));
                                }
                                if (routePlanRes != null) {
                                    try {
                                        String productId = PaxEnvironment.getInstance().getProductId();
                                        String callFrom = callFrom == null ? "" : callFrom.toString();
                                        String token = PaxEnvironment.getInstance().getToken();
                                        LatLng latLng = null;
                                        LatLng latLng2 = latLng2 == null ? null : new LatLng(latLng2.latitude, latLng2.longitude);
                                        if (end != null) {
                                            latLng = new LatLng(end.latitude, end.longitude);
                                        }
                                        AlarmOmegaUtil.routePlanAlarmOmega(productId, callFrom, token, latLng2, latLng, routePlanRes, routePlanRes.ret.intValue(), "");
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                    DLog.m7384d(str, e.toString(), new Object[0]);
                }
            }
        }
    }
}
