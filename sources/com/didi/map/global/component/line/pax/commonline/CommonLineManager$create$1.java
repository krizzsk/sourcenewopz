package com.didi.map.global.component.line.pax.commonline;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.utils.LineDataConverter;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/map/global/component/line/pax/commonline/CommonLineManager$create$1", "Lcom/didi/map/global/component/line/data/IRouteSearchResultCallback;", "onGetRouteResult", "", "response", "Lcom/didi/map/global/component/line/data/param/LineDataResponse;", "onGetRouteResultError", "errorMsg", "", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonLineManager.kt */
public final class CommonLineManager$create$1 implements IRouteSearchResultCallback {
    final /* synthetic */ CommonLineManager this$0;

    public void onGetRouteResultError(String str) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
    }

    CommonLineManager$create$1(CommonLineManager commonLineManager) {
        this.this$0 = commonLineManager;
    }

    public void onGetRouteResult(LineDataResponse lineDataResponse) {
        ICompLineContract access$getMLine$p;
        ICompLineContract access$getMLine$p2;
        if (lineDataResponse != null) {
            CommonLineManager commonLineManager = this.this$0;
            if (!CollectionUtil.isEmpty((Collection<?>) lineDataResponse.getRoutePlanRes().routeGeos)) {
                List<LatLng> latLngListFromDiffGeoPoints = LineDataConverter.getLatLngListFromDiffGeoPoints(lineDataResponse.getRoutePlanRes().routeGeos.get(0));
                CommonLineParam access$getMLineParam$p = commonLineManager.f25843d;
                LineParams lineParams = null;
                LineParams lineParam = access$getMLineParam$p == null ? null : access$getMLineParam$p.getLineParam();
                if (lineParam != null) {
                    lineParam.setLinePoints(latLngListFromDiffGeoPoints);
                }
                CompLineFactory.LineType lineType = CompLineFactory.LineType.LINE_COMMON;
                Map access$getMMap$p = commonLineManager.f25842c;
                Context access$getMContext$p = commonLineManager.f25841b;
                CommonLineParam access$getMLineParam$p2 = commonLineManager.f25843d;
                if (access$getMLineParam$p2 != null) {
                    lineParams = access$getMLineParam$p2.getLineParam();
                }
                commonLineManager.f25846g = CompLineFactory.createLineComponent(lineType, access$getMMap$p, access$getMContext$p, lineParams);
                if (!(commonLineManager.f25844e == null || (access$getMLine$p2 = commonLineManager.f25846g) == null)) {
                    access$getMLine$p2.setListener(commonLineManager.f25844e);
                }
                if (!(commonLineManager.f25845f == null || (access$getMLine$p = commonLineManager.f25846g) == null)) {
                    access$getMLine$p.setLineClickListener(commonLineManager.f25845f);
                }
                ICompLineContract access$getMLine$p3 = commonLineManager.f25846g;
                if (access$getMLine$p3 != null) {
                    access$getMLine$p3.start();
                }
            }
        }
    }
}
