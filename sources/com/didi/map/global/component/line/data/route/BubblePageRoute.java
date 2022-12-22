package com.didi.map.global.component.line.data.route;

import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.BubblePageLineRequest;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.map.sdk.proto.driver_gl.VisitorInfo;
import com.didi.map.sdk.proto.driver_gl.enumOSType;
import com.didichuxing.routesearchsdk.RouteSearchApiFactory;
import com.didichuxing.routesearchsdk.bubblepage.BubblePageRouteSearchParam;
import com.didichuxing.routesearchsdk.bubblepage.IBubblePageRouteSearchCallback;

public class BubblePageRoute extends BaseLineRoute<BubblePageLineRequest> {
    public static final String TAG = "BubblePageRoute";

    public void start(BubblePageLineRequest bubblePageLineRequest, final IRouteSearchResultCallback iRouteSearchResultCallback) {
        if (checkCommonParamIsRight(bubblePageLineRequest, iRouteSearchResultCallback)) {
            if (bubblePageLineRequest.getStart() == null) {
                DLog.m7384d(TAG, "start is null", new Object[0]);
                return;
            }
            DoublePoint build = new DoublePoint.Builder().lat(Float.valueOf((float) bubblePageLineRequest.getStart().latitude)).lng(Float.valueOf((float) bubblePageLineRequest.getStart().longitude)).dlat(Double.valueOf(bubblePageLineRequest.getStart().latitude)).dlng(Double.valueOf(bubblePageLineRequest.getStart().longitude)).build();
            if (bubblePageLineRequest.getEnd() == null) {
                DLog.m7384d(TAG, "end is null", new Object[0]);
                return;
            }
            DoublePoint build2 = new DoublePoint.Builder().lat(Float.valueOf((float) bubblePageLineRequest.getEnd().latitude)).lng(Float.valueOf((float) bubblePageLineRequest.getEnd().longitude)).dlat(Double.valueOf(bubblePageLineRequest.getEnd().latitude)).dlng(Double.valueOf(bubblePageLineRequest.getEnd().longitude)).build();
            VisitorInfo visitorInfo = new VisitorInfo("", PaxEnvironment.getInstance().getToken(), PaxEnvironment.getInstance().getAppVersion(), PaxEnvironment.getInstance().getPhoneNumber(), enumOSType.Android, Long.valueOf(System.currentTimeMillis()));
            BubblePageRouteSearchParam.Builder builder = new BubblePageRouteSearchParam.Builder();
            builder.startPoint(build).startCityID(bubblePageLineRequest.getStartCityId()).endPoint(build2).bizGroup(bubblePageLineRequest.getBizGroup()).endCityID(bubblePageLineRequest.getEndCityId()).countryId(String.valueOf(PaxEnvironment.getInstance().getCountryCode())).productId(PaxEnvironment.getInstance().getProductId()).setOdPoints(convertToOdPoints(bubblePageLineRequest.getWayPoint()));
            builder.setVisitorInfo(visitorInfo);
            builder.epfOrderType(bubblePageLineRequest.getEpfOrderType() != null ? bubblePageLineRequest.getEpfOrderType() : EpfOrderType.NormalType);
            builder.lang(bubblePageLineRequest.getCurrentLang() != null ? bubblePageLineRequest.getCurrentLang() : "");
            if (PaxEnvironment.getInstance().getProductId() == null || PaxEnvironment.getInstance().getUid() == null) {
                builder.setBizType(0);
                builder.setPassengerID(0L);
            } else {
                builder.setBizType(Integer.valueOf(PaxEnvironment.getInstance().getProductId()));
                builder.setPassengerID(Long.valueOf(PaxEnvironment.getInstance().getUid()));
            }
            try {
                RouteSearchApiFactory.createBubblePageRouteSearch(getContext()).calculateRoute(builder.build(), new IBubblePageRouteSearchCallback() {
                    public void onBeginToSearch() {
                        DLog.m7384d(BubblePageRoute.TAG, "createBubblePageRouteSearch", new Object[0]);
                    }

                    public void onFinishToSearch(BubblePageRes bubblePageRes, String str) {
                        DLog.m7384d(BubblePageRoute.TAG, "onFinishToSearch", new Object[0]);
                        if (BubblePageRoute.this.isDestroy()) {
                            DLog.m7384d(BubblePageRoute.TAG, "mIsDestroy is true", new Object[0]);
                        } else if (iRouteSearchResultCallback != null) {
                            iRouteSearchResultCallback.onGetRouteResult(BubblePageRoute.this.packageResponse(bubblePageRes));
                        }
                    }
                });
            } catch (Exception e) {
                DLog.m7384d(TAG, e.toString(), new Object[0]);
            }
        }
    }
}
