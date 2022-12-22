package com.didi.map.global.component.line.pax.dropoffline;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.utils.LineDataConverter;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.SingleRouteRes;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/map/global/component/line/pax/dropoffline/SingleWalkLineManager$requestLine$1", "Lcom/didi/map/global/component/line/data/IRouteSearchResultCallback;", "onGetRouteResult", "", "response", "Lcom/didi/map/global/component/line/data/param/LineDataResponse;", "onGetRouteResultError", "errorMsg", "", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleWalkLineManager.kt */
public final class SingleWalkLineManager$requestLine$1 implements IRouteSearchResultCallback {
    final /* synthetic */ SingleWalkLineManager this$0;

    SingleWalkLineManager$requestLine$1(SingleWalkLineManager singleWalkLineManager) {
        this.this$0 = singleWalkLineManager;
    }

    public void onGetRouteResult(LineDataResponse lineDataResponse) {
        MultiRoutePlanRes multiRoutePlanRes;
        WalkLineCallback access$getCallback$p;
        if (lineDataResponse != null && (multiRoutePlanRes = lineDataResponse.getMultiRoutePlanRes()) != null) {
            SingleWalkLineManager singleWalkLineManager = this.this$0;
            DLog.m7384d(singleWalkLineManager.f25859a, Intrinsics.stringPlus("onFinishToSearch res msg = : ", multiRoutePlanRes.msg), new Object[0]);
            if (!singleWalkLineManager.f25864f) {
                List<SingleRouteRes> list = multiRoutePlanRes.routeRes;
                if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                    for (SingleRouteRes next : list) {
                        if (next != null) {
                            List<LatLng> latLngListFromDiffGeoPoints = LineDataConverter.getLatLngListFromDiffGeoPoints(next.routeGeos);
                            if (next.travelMode == TravelMode.WALKING) {
                                Integer num = next.style;
                                Intrinsics.checkNotNullExpressionValue(num, "route.style");
                                singleWalkLineManager.m18394a(latLngListFromDiffGeoPoints, num.intValue());
                                Integer num2 = next.style;
                                boolean z = true;
                                if (num2 != null && num2.intValue() == 0) {
                                    WalkLineCallback access$getCallback$p2 = singleWalkLineManager.f25862d;
                                    if (access$getCallback$p2 != null) {
                                        access$getCallback$p2.onFinishToSearch(true, next);
                                    }
                                } else {
                                    if ((num2 == null || num2.intValue() != 1) && (num2 == null || num2.intValue() != 2)) {
                                        z = false;
                                    }
                                    if (z && (access$getCallback$p = singleWalkLineManager.f25862d) != null) {
                                        access$getCallback$p.onFinishToSearch(false, next);
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
                List linkedList = new LinkedList();
                LatLng startPos = singleWalkLineManager.f25863e.getStartPos();
                if (startPos != null) {
                    linkedList.add(startPos);
                }
                LatLng endPos = singleWalkLineManager.f25863e.getEndPos();
                if (endPos != null) {
                    linkedList.add(endPos);
                }
                singleWalkLineManager.m18394a(linkedList, 0);
                WalkLineCallback access$getCallback$p3 = singleWalkLineManager.f25862d;
                if (access$getCallback$p3 != null) {
                    access$getCallback$p3.onFinishToSearch(false, (SingleRouteRes) null);
                }
            }
        }
    }

    public void onGetRouteResultError(String str) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
