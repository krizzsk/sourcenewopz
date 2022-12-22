package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/confirm/normal/line/MultiRouteLineWrap$planMultiLine$1", "Lcom/didi/map/global/component/line/data/IRouteSearchResultCallback;", "onGetRouteResult", "", "response", "Lcom/didi/map/global/component/line/data/param/LineDataResponse;", "onGetRouteResultError", "errMessage", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MultiRouteLineWrap.kt */
public final class MultiRouteLineWrap$planMultiLine$1 implements IRouteSearchResultCallback {
    final /* synthetic */ Ref.ObjectRef<CommonLineParam> $commonLineParam;
    final /* synthetic */ MultiRouteLineWrap this$0;

    MultiRouteLineWrap$planMultiLine$1(MultiRouteLineWrap multiRouteLineWrap, Ref.ObjectRef<CommonLineParam> objectRef) {
        this.this$0 = multiRouteLineWrap;
        this.$commonLineParam = objectRef;
    }

    public void onGetRouteResult(LineDataResponse lineDataResponse) {
        if (this.this$0.f26691d == null && !this.this$0.f26695h) {
            DLog.m7384d("BubblePage", "get route back from network.", new Object[0]);
            BubblePageRes bubblePageRes = null;
            this.this$0.m18885a(lineDataResponse == null ? null : lineDataResponse.getBubblePageRes(), ((CommonLineParam) this.$commonLineParam.element).getStartPoint(), ((CommonLineParam) this.$commonLineParam.element).getEndPoint(), ((CommonLineParam) this.$commonLineParam.element).getWayPoints());
            BubblePageCache instance = BubblePageCache.getInstance();
            LatLng startPoint = ((CommonLineParam) this.$commonLineParam.element).getStartPoint();
            LatLng endPoint = ((CommonLineParam) this.$commonLineParam.element).getEndPoint();
            List<LatLng> wayPoints = ((CommonLineParam) this.$commonLineParam.element).getWayPoints();
            if (lineDataResponse != null) {
                bubblePageRes = lineDataResponse.getBubblePageRes();
            }
            instance.addBubblePageToCache(startPoint, endPoint, wayPoints, bubblePageRes);
        }
    }

    public void onGetRouteResultError(String str) {
        if (!TextUtils.isEmpty(str)) {
            DLog.m7384d(MultiRouteLineWrap.TAG, Intrinsics.stringPlus("errMessage:", str), new Object[0]);
        }
    }
}
