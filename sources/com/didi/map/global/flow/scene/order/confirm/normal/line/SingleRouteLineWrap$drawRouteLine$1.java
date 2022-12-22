package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.utils.LineDataConverter;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/confirm/normal/line/SingleRouteLineWrap$drawRouteLine$1", "Lcom/didi/map/global/component/line/data/IRouteSearchResultCallback;", "onGetRouteResult", "", "response", "Lcom/didi/map/global/component/line/data/param/LineDataResponse;", "onGetRouteResultError", "errorMsg", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleRouteLineWrap.kt */
public final class SingleRouteLineWrap$drawRouteLine$1 implements IRouteSearchResultCallback {
    final /* synthetic */ CommonLineParam $param;
    final /* synthetic */ SingleRouteLineWrap this$0;

    public void onGetRouteResultError(String str) {
    }

    SingleRouteLineWrap$drawRouteLine$1(CommonLineParam commonLineParam, SingleRouteLineWrap singleRouteLineWrap) {
        this.$param = commonLineParam;
        this.this$0 = singleRouteLineWrap;
    }

    public void onGetRouteResult(LineDataResponse lineDataResponse) {
        if (lineDataResponse != null) {
            CommonLineParam commonLineParam = this.$param;
            SingleRouteLineWrap singleRouteLineWrap = this.this$0;
            if (!CollectionUtil.isEmpty((Collection<?>) lineDataResponse.getRoutePlanRes().routeGeos)) {
                LineParams lineParams = new LineParams(LineDataConverter.getLatLngListFromDiffGeoPoints(lineDataResponse.getRoutePlanRes().routeGeos.get(0)), commonLineParam.getLineColor() == 0 ? singleRouteLineWrap.f26716a.getResources().getColor(R.color.global_map_waiting_scene_line_color) : commonLineParam.getLineColor(), commonLineParam.getLineWidth() == 0 ? 6 : commonLineParam.getLineWidth());
                lineParams.setZIndex(singleRouteLineWrap.f26719d);
                LineExParam lineExParam = new LineExParam();
                lineExParam.setHasPulseAnim(false);
                lineExParam.setHasLineExtensionAnim(false);
                lineParams.setExParam(lineExParam);
                singleRouteLineWrap.f26720e = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, singleRouteLineWrap.f26717b, singleRouteLineWrap.f26716a, lineParams);
                ICompLineContract access$getMRouteLine$p = singleRouteLineWrap.f26720e;
                if (access$getMRouteLine$p != null) {
                    access$getMRouteLine$p.setListener(new SingleRouteLineWrap$drawRouteLine$1$onGetRouteResult$1$1(singleRouteLineWrap));
                }
                ICompLineContract access$getMRouteLine$p2 = singleRouteLineWrap.f26720e;
                if (access$getMRouteLine$p2 != null) {
                    access$getMRouteLine$p2.start();
                }
            }
        }
    }
}
