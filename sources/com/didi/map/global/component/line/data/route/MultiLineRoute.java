package com.didi.map.global.component.line.data.route;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.MultiRouteLineRequest;
import com.didi.map.global.model.URLHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didichuxing.routesearchsdk.RouteSearchApiFactory;
import com.didichuxing.routesearchsdk.multi.IMultiRouteSearchCallback;
import com.didichuxing.routesearchsdk.multi.MultiRouteSearchParam;

public class MultiLineRoute extends BaseLineRoute<MultiRouteLineRequest> {
    public static final String TAG = "MultiLineRoute";

    public void start(MultiRouteLineRequest multiRouteLineRequest, IRouteSearchResultCallback iRouteSearchResultCallback) {
        if (checkCommonParamIsRight(multiRouteLineRequest, iRouteSearchResultCallback)) {
            long j = 0;
            try {
                if (PaxEnvironment.getInstance().getUid() != null) {
                    j = Long.parseLong(PaxEnvironment.getInstance().getUid());
                }
            } catch (Exception unused) {
            }
            long j2 = j;
            String productId = multiRouteLineRequest.getProductId();
            if (productId == null) {
                productId = PaxEnvironment.getInstance().getProductId();
            }
            String str = productId;
            if (!TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                final IRouteSearchResultCallback iRouteSearchResultCallback2 = iRouteSearchResultCallback;
                RouteSearchApiFactory.createMultiRouteSearch(getContext(), URLHelper.getUrlHost(getContext())).calculateRoute(new MultiRouteSearchParam(PaxEnvironment.getInstance().getToken(), "", PaxEnvironment.getInstance().getCountryCode(), str, j2, multiRouteLineRequest.getCallFrom(), multiRouteLineRequest.getOrderStage(), multiRouteLineRequest.getDidiVersion(), multiRouteLineRequest.getOrderId(), multiRouteLineRequest.getLineParams()), new IMultiRouteSearchCallback() {
                    public /* synthetic */ void onFinishToSearch(MultiRoutePlanRes multiRoutePlanRes, String str, int i) {
                        IMultiRouteSearchCallback.CC.$default$onFinishToSearch(this, multiRoutePlanRes, str, i);
                    }

                    public void onBeginToSearch() {
                        DLog.m7384d(MultiLineRoute.TAG, "createRouteSearch", new Object[0]);
                    }

                    public void onFinishToSearch(MultiRoutePlanRes multiRoutePlanRes, String str) {
                        if (!MultiLineRoute.this.isDestroy()) {
                            DLog.m7384d(MultiLineRoute.TAG, "onFinishToSearch", new Object[0]);
                            if (multiRoutePlanRes != null) {
                                DLog.m7384d(MultiLineRoute.TAG, "获取路线数据结果--》" + multiRoutePlanRes.msg, new Object[0]);
                            }
                            if (iRouteSearchResultCallback2 != null) {
                                iRouteSearchResultCallback2.onGetRouteResult(MultiLineRoute.this.packageResponse(multiRoutePlanRes));
                            }
                        }
                    }
                });
            }
        }
    }
}
